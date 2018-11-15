package office.uass.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import office.uass.dao.UassCodeDAO;
import office.uass.pojo.UassCode;
import office.userinfo.action.ImportYgxx;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportRole {

	private static Logger logger = Logger.getLogger(ImportRole.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
	public static Logger getLogger() {
		return logger;
	}
	public static void setLogger(Logger logger) {
		ImportRole.logger = logger;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 标准文件名uass.xls
	 * 文件上传和读取内容
	 * @return "success"执行成功
	 * @throws Exception
	 */
	public String execute() throws Exception
	{	
		int nn=0;
		UassCodeDAO ucdao = new UassCodeDAO();
		String realpath = "D:/import/office/";
		message = "导入成功";
		UserInfoDAO uidao = new UserInfoDAO();
		if (file != null) {
		       File savefile = new File(new File(realpath), fileFileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file, savefile);
		     }
		    else
		    {
		    	ActionContext.getContext().put("message", "传入文件有误");
		    }
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
			for (int i = 1; i < nn; i++) {
				String name=sheet.getCell(0, i).getContents().trim();
				UserInfo ui = uidao.findByName(name);
				if(ui!=null)
				{
					StringBuilder role890=new StringBuilder("00000000");
					StringBuilder role891=new StringBuilder("000000000000000000000000000000000000000000000");
					String status890=sheet.getCell(2, i).getContents().trim(); 
					String status891=sheet.getCell(3, i).getContents().trim(); 
					String r890=sheet.getCell(4, i).getContents().trim(); 
					String r891=sheet.getCell(5, i).getContents().trim();
					String[] ar890=r890.split(",");
					String[] ar891=r891.split(",");
					
					if(status890.equals("生效")||status890.equals("1"))
					{
						ui.setStatus890(1);
					}
					else
					{
						ui.setStatus890(0);
					}
					if(status891.equals("生效")||status891.equals("1"))
					{
						ui.setStatus891(1);
					}
					else
					{
						ui.setStatus891(0);
					}
					for(int j=0;j<ar890.length;j++)
					{
						UassCode uc = ucdao.findByPoolAndDetail("890",ar890[j]);
						if(uc!=null)
						{
							int index = uc.getPaixu();
							role890.replace(index,index+1,"1");
						}
					}
					for(int j=0;j<ar891.length;j++)
					{
						UassCode uc = ucdao.findByPoolAndDetail("891",ar891[j]);
						if(uc!=null)
						{
							int index = uc.getPaixu();
							role891.replace(index,index+1,"1");
						}
					}
					ui.setRole890(role890.toString());
					ui.setRole891(role891.toString());
					
					uidao.merge(ui);
				}
			}
    		
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
}
