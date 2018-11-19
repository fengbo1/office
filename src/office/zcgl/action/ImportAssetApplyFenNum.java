package office.zcgl.action;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import office.zcgl.dao.AssertFenDAO;
import office.zcgl.pojo.AssertFen;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class ImportAssetApplyFenNum {
	private static Logger logger = Logger.getLogger(ImportAssetApplyFenNum.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String number;
    private String result;
    
    
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	
public String execute() throws Exception {
		
		String realpath = "D:/import/office/";
		message = "导入成功";
		result = "success";
		//UserInfoDAO uidao = new UserInfoDAO();
		
		int nn=0;
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
	    	int flag=0;
	    	AssertFenDAO afdao = new AssertFenDAO();
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				String sql = "delete from assert_fen where applynumber= '"+number+"'";
				session.createSQLQuery(sql).executeUpdate();
				for (int i = 1; i < nn; i++) {
					
					AssertFen af = new AssertFen();
					//AssertFen aftemp = afdao.findAllByNumber( );
					af.setName(sheet.getCell(0, i).getContents().trim());
				    af.setType(sheet.getCell(1, i).getContents().trim());
				    if(sheet.getCell(2, i).getContents().trim()==null||sheet.getCell(2, i).getContents().trim().equals(""))
				    {
				    	flag=1;
				    }
					af.setNumber(sheet.getCell(2, i).getContents().trim());
					af.setApplynumber(number);
					afdao.merge(af);
	    	        }
				if(flag==1)
				{
					ActionContext.getContext().put("message", "未分配资产（物品）编号！！");
					result="failed";
				}
				}
				catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			    }
				finally{
				 trans.commit();
		         session.flush();
		         session.clear();
		         session.close();
			  }
			
		
		return result;
   }
}
