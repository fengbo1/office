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
import com.opensymphony.xwork2.ActionContext;
import ccb.hibernate.HibernateSessionFactory;
public class ImportAssetInfo {
	private static Logger logger = Logger.getLogger(ImportAssetInfo.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
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
		if(yearmonth.compareTo("201501")<0||yearmonth.compareTo("209912")>0)
		{
			message = "导入失败,文件名应以年+月开头";
		}
	
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	AssetInfoDAO kidao = new AssetInfoDAO();
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				
				String sql = "truncate asset_info";
				session.createSQLQuery(sql).executeUpdate();
				for (int i = 1; i < nn; i++) {
					
					AssetInfo ki = new AssetInfo();
				
						ki.setName(sheet.getCell(0, i).getContents().trim());
						ki.setType(sheet.getCell(1, i).getContents().trim());						
						ki.setChu(Integer.parseInt(sheet.getCell(2, i).getContents().trim()));
					    ki.setStatus(Integer.parseInt(sheet.getCell(3, i).getContents().trim()));
					    ki.setSn(sheet.getCell(4, i).getContents().trim());
					    ki.setNumber(sheet.getCell(5, i).getContents().trim());
					    ki.setPeople(sheet.getCell(6, i).getContents().trim());
					    ki.setArea(sheet.getCell(7, i).getContents().trim());
					    ki.setIswupin(Integer.parseInt(sheet.getCell(8, i).getContents().trim()));
					    ki.setDate(sheet.getCell(9, i).getContents().trim() );
					    ki.setRemark(sheet.getCell(10, i).getContents().trim());						
						kidao.merge(ki);
					
					
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
			//countKqjlDaily();//计算考勤记录日表
			//countKqjlDailyForYgxy();//计算考勤记录日表(员工响应)
			//countkqjlMonth();//计算考勤记录月表
		
		return "success";
   }
}
