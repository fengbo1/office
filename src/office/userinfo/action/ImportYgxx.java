package office.userinfo.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import office.uass.dao.UassCodeDAO;
import office.uass.pojo.UassCode;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportYgxx {

	private static Logger logger = Logger.getLogger(ImportYgxx.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 标准文件名ygxx.xls
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
			if(type.equals("fugai"))//如果选择的是覆盖，先删除原表
			{
				String sql = "truncate user_info";
				session.createSQLQuery(sql).executeUpdate();
				
				for (int i = 1; i < nn; i++) {
					UserInfo ui = new UserInfo();
					StringBuilder role890=new StringBuilder("00000000");
					StringBuilder role891=new StringBuilder("000000000000000000000000000000000000000000000");
					String workyears = sheet.getCell(9, i).getContents().trim();
					
					ui.setUsername(sheet.getCell(0, i).getContents().trim());
					ui.setNewnumber(sheet.getCell(1, i).getContents().trim());
					ui.setPassword(sheet.getCell(2, i).getContents().trim());
					ui.setPosition(sheet.getCell(3, i).getContents().trim());
					ui.setAuthority(sheet.getCell(4, i).getContents().trim());
					ui.setIdentity(sheet.getCell(5, i).getContents().trim());
					ui.setWorkdate(sheet.getCell(6, i).getContents().trim());
					ui.setCcbdate(sheet.getCell(7, i).getContents().trim());
					ui.setZxdate(sheet.getCell(8, i).getContents().trim());
					if(workyears==null||workyears.equals(""))
					{
						ui.setWorkyears(0);
					}
					else
					{
						ui.setWorkyears(Integer.parseInt(sheet.getCell(9, i).getContents().trim()));
					}
					ui.setPassport(sheet.getCell(10, i).getContents().trim());
					ui.setHkpassport(sheet.getCell(11, i).getContents().trim());
					ui.setTwpassport(sheet.getCell(12, i).getContents().trim());
					ui.setStatus890(Integer.parseInt(sheet.getCell(13, i).getContents().trim()));
					ui.setStatus891(Integer.parseInt(sheet.getCell(14, i).getContents().trim()));
					String r890=sheet.getCell(15, i).getContents().trim();
					String r891=sheet.getCell(16, i).getContents().trim();
					String[] ar890=r890.split(",");
					String[] ar891=r891.split(",");
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
			else//如果选择的是更新新增，
			{
				for (int i = 1; i < nn; i++) {
					StringBuilder role890=new StringBuilder("00000000");
					StringBuilder role891=new StringBuilder("000000000000000000000000000000000000000000000");
					UserInfo ui = uidao.findByName(sheet.getCell(0, i).getContents().trim());
					if(ui==null)
					{
						ui=new UserInfo();
					}
					String workyears = sheet.getCell(9, i).getContents().trim();
					ui.setUsername(sheet.getCell(0, i).getContents().trim());
					ui.setNewnumber(sheet.getCell(1, i).getContents().trim());
					ui.setPassword(sheet.getCell(2, i).getContents().trim());
					ui.setPosition(sheet.getCell(3, i).getContents().trim());
					ui.setAuthority(sheet.getCell(4, i).getContents().trim());
					ui.setIdentity(sheet.getCell(5, i).getContents().trim());
					ui.setWorkdate(sheet.getCell(6, i).getContents().trim());
					ui.setCcbdate(sheet.getCell(7, i).getContents().trim());
					ui.setZxdate(sheet.getCell(8, i).getContents().trim());
					if(workyears==null||workyears.equals(""))
					{
						ui.setWorkyears(0);
					}
					else
					{
						ui.setWorkyears(Integer.parseInt(sheet.getCell(9, i).getContents().trim()));
					}
					ui.setPassport(sheet.getCell(10, i).getContents().trim());
					ui.setHkpassport(sheet.getCell(11, i).getContents().trim());
					ui.setTwpassport(sheet.getCell(12, i).getContents().trim());
					ui.setStatus890(Integer.parseInt(sheet.getCell(13, i).getContents().trim()));
					ui.setStatus891(Integer.parseInt(sheet.getCell(14, i).getContents().trim()));
					String r890=sheet.getCell(15, i).getContents().trim();
					String r891=sheet.getCell(16, i).getContents().trim();
					String[] ar890=r890.split(",");
					String[] ar891=r891.split(",");
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
