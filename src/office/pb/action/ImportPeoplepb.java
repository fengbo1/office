package office.pb.action;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import office.pb.dao.TPbPeopleDAO;
import office.pb.pojo.TPbPeople;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import office.mycalendar.pojo.MyCalendar;
import office.mycalendar.dao.MyCalendarDAO;
public class ImportPeoplepb {

	
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
		/*if(yearmonth.compareTo("201501")<0||yearmonth.compareTo("209912")>0)
		{
			message = "导入失败,文件名应以年+月开头";
		}*/
	
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	TPbPeopleDAO ppdao = new TPbPeopleDAO();
	    	MyCalendar Mc = new MyCalendar();
	    	MyCalendarDAO Mcdao = new MyCalendarDAO();
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				
				//String sql = "truncate t_pb_people";
				//session.createSQLQuery(sql).executeUpdate();
				for (int i = 1; i < nn; i++) {
					
					String names = sheet.getCell(1, i).getContents().trim();
					String [] name = names.split("、");
					for(int j= 0; j<name.length;j++)
					{		
					TPbPeople pp = new TPbPeople();
					
					int plan =Integer.parseInt(sheet.getCell(2, i).getContents().trim());
					String date = sheet.getCell(0, i).getContents().trim();
					//pp.setDate(date);
					Mc = Mcdao.findByDate(date);
					TPbPeople pptemp = ppdao.findByDateAndName(date, name[j]);
					if(pptemp==null)
					{
						pp.setDate(date);
						pp.setWeek(Mc.getWeek());
						pp.setName(name[j]);
						pp.setPlan(plan);
						if(plan == 0)
						{
							pp.setIsrest(1);
						}
						if(plan != 0)
						{
							pp.setIsrest(0);
						}	
						  ppdao.merge(pp);
					}
					else
					{
						pptemp.setDate(date);
						pptemp.setWeek(Mc.getWeek());
						pptemp.setName(name[j]);
						pptemp.setPlan(plan);
						if(plan == 0)
						{
							pptemp.setIsrest(1);
						}
						if(plan != 0)
						{
							pptemp.setIsrest(0);
						}	
						  ppdao.merge(pptemp);
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
