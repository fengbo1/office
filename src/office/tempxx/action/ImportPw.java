package office.tempxx.action;
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import office.tempxx.dao.TPeopleworkDAO;
import office.tempxx.pojo.TPeoplework;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import office.mycalendar.pojo.MyCalendar;
import office.mycalendar.dao.MyCalendarDAO;
public class ImportPw {
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
		int cc=0;
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
	    	TPeopleworkDAO pwdao = new TPeopleworkDAO();
	    	TPeoplework pw = new TPeoplework();
	    	TPeoplework lw = new TPeoplework();
	    	MyCalendar Mc = new MyCalendar();
	    	MyCalendarDAO Mcdao = new MyCalendarDAO();
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				cc = sheet.getColumns();
				//String sql = "truncate t_pb_people";
				String opnumber = "";
				String name = "";
				String zu = "";
				String date = "";
				String status = "";
				//session.createSQLQuery(sql).executeUpdate();
				for (int i = 2; i < nn; i++) {
					
				    for(int j = 3; j < cc;j++)
				    {
				    	opnumber = sheet.getCell(0, i).getContents().trim();
				    	name = sheet.getCell(1, i).getContents().trim();
				    	zu = sheet.getCell(2, i).getContents().trim();
				    	status = sheet.getCell(j, i).getContents().trim();
				    	date = sheet.getCell(j, 1).getContents().trim();
				    	lw = pwdao.findAllByOpNumber(opnumber, date);
				    	if(lw==null)
				    	{
				    		pw.setOpnumber(opnumber);
				    	    pw.setName(name);
				    	    pw.setZu(zu);
				    	    pw.setDate(date);
				    	    pw.setStatus(status);
				    	    pwdao.merge(pw);
				    	}
				    	else
				    	{
				    		lw.setOpnumber(opnumber);
				    	    lw.setName(name);
				    	    lw.setZu(zu);
				    	    lw.setDate(date);
				    	    lw.setStatus(status);
				    	    pwdao.merge(lw);
				    	}
	    	        }
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
