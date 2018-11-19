package office.zcgl.action;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;

public class ImportChangeInfo {
	private static Logger logger = Logger.getLogger(ImportAssetInfo.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private int chu;
    
	public static Logger getLogger() {
		return logger;
	}
	public static void setLogger(Logger logger) {
		ImportChangeInfo.logger = logger;
	}
	public int getChu() {
		return chu;
	}
	public void setChu(int chu) {
		this.chu = chu;
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
		//UserInfoDAO uidao = new UserInfoDAO();
		String yearmonth = fileFileName.substring(0, 6);
		int nn=0;
		int flag=0;
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
		if(yearmonth.compareTo("20150101")<0||yearmonth.compareTo("20991231")>0)
		{
			message = "导入失败,文件名应以年+月+日开头";
		}
	
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	AssetInfoDAO kidao = new AssetInfoDAO();
	    	AssetInfo ki = new AssetInfo();
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				
				//String sql = "truncate asset_info";
				//session.createSQLQuery(sql).executeUpdate();
				for (int i = 1; i < nn; i++) {
					
					  //  AssetInfo ki = new AssetInfo();
				        ki=kidao.findAllByNumberAndChu(sheet.getCell(0, i).getContents().trim(),chu);
				        if(sheet.getCell(0, i).getContents().trim()!=null&&!sheet.getCell(0, i).getContents().trim().equals(""))
				        {
				        	if(ki==null)
				        	{
				        		flag=1;
					        	message="要修改的资产不存在或不属于本处室";
					        	break;
				        	}
				        	
				        
					    if((sheet.getCell(1, i).getContents().trim()!=null)&&(!(sheet.getCell(1, i).getContents().trim().equals(""))))
					    {
					    	 ki.setPeople(sheet.getCell(1, i).getContents().trim());
					    }
					    if((sheet.getCell(2, i).getContents().trim()!=null)&&(!(sheet.getCell(2, i).getContents().trim().equals(""))))
					    {
					    	 ki.setArea(sheet.getCell(2, i).getContents().trim());
					    }
					  
						kidao.merge(ki);
					
				        }
	    	        }
				}
				catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			    }
				finally{
					
					if(flag==1)
					{
					    trans.rollback();
					}
					else
					{
						trans.commit();
					}
					 session.flush();
			         session.clear();
			         session.close();
				
			  }
			//countKqjlDaily();//计算考勤记录日表
			//countKqjlDailyForYgxy();//计算考勤记录日表(员工响应)
			//countkqjlMonth();//计算考勤记录月表
		
		return "success";
   }
}
