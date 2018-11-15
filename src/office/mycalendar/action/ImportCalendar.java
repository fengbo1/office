package office.mycalendar.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.ActionContext;
import ccb.hibernate.HibernateSessionFactory;

/**
 * 导入日历表
 * @author htzx
 *  日期             星期             工作日               是否国家法定节假日
 *  ————————————————————————————————————
 * | date | week  |  workday |  remark  |      
 * |20110101  1       0（否）            1      |
 * |                                    |
 * |                                    |
 *  ————————————————————————————————————
 *
 */
public class ImportCalendar {
	private static Logger logger = Logger.getLogger(ImportCalendar.class);
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
	/**
	 * 标准文件名2015rlb.xls
	 * 文件上传和读取内容
	 * @return "success"执行成功
	 * @throws Exception
	 */
	public String execute() throws Exception
	{
		int nn=0;
		String realpath = "D:/import/office/";
		message = "导入成功";
		MyCalendarDAO mcdao = new MyCalendarDAO();
		String year = fileFileName.substring(0,4);
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
		if(year.compareTo("2015")<0||year.compareTo("2099")>0)
		{
			message = "导入失败,文件名应以年开头";
			return "failed";
		}
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
			if(nn<365||nn>367)
			{
				message = "失败，请导入完整的日历表";
			}
			else
			{
				String begindate = year+"0101";
				String enddate = year+"1231";
				String sql = "delete from t_mycalendar where date>='"+begindate+"' and date<='"+enddate+"'";
				session.createSQLQuery(sql).executeUpdate();
				
				for (int i = 1; i < nn; i++) {
					MyCalendar mc = new MyCalendar();
					mc.setDate(sheet.getCell(0, i).getContents().trim());
					mc.setWeek(Integer.parseInt(sheet.getCell(1, i).getContents().trim()));
					mc.setWorkday(Integer.parseInt(sheet.getCell(2, i).getContents().trim()));
					mc.setRemark(sheet.getCell(3, i).getContents().trim());
					mcdao.merge(mc);
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
