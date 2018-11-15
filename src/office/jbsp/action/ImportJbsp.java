package office.jbsp.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.dao.JbspPageDiDAO;
import office.jbsp.pojo.JbspPage;
import office.jbsp.pojo.JbspPageDi;
import office.kqjl.action.ImportKqjl;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.pb2.action.ProcessYgxxHz;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportJbsp {
	private static Logger logger = Logger.getLogger(ImportJbsp.class);
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
	
	
	public String execute() throws Exception{
		String realpath = "D:/import/office/";
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		JbspPageDAO jbdao = new JbspPageDAO();
		JbspPageDiDAO jbddao = new JbspPageDiDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		int nn=0;
		message = "导入失败";
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
			//第一遍检查提醒
			for (int i = 1; i < nn; i++) {
				String date = sheet.getCell(0, i).getContents().trim();
				String name = sheet.getCell(2, i).getContents().trim();
				List<JbspPage> listjb = jbdao.findAllByNameAndDate(name, date);
				if(!listjb.isEmpty())
				
				{
					message+="！姓名【";
					message+= name;
					message+="】日期【";
					message+= date;
					message+="】重复";
				}
			}
			if(message.equals("导入失败"))
			{
				message = "导入成功！";
				for (int i = 1; i < nn; i++) {
					String date = sheet.getCell(0, i).getContents().trim();
					String sxw = sheet.getCell(1, i).getContents().trim();
					String name = sheet.getCell(2, i).getContents().trim();
					String reason = sheet.getCell(3, i).getContents().trim();
					UserInfo ui = uidao.findByName(name);
					if(ui!=null)
					{
						String position = ui.getPosition();
						String chu = position.substring(2, 3);
						String zu = position.substring(4, 5);
						int halfday = 0;
						double days = 0;
						String index = "000"+fraw.readandwrite("JBSP");
						index = index.substring(index.length() - 3, index.length());
						String number = du.getStringDate() + "JBSP10" + index;
						if(sxw.contains("上午"))
						{
							halfday = 2;
							days = 0.5;
						}
						else if(sxw.contains("下午"))
						{
							halfday = 1;
							days = 0.5;
						}
						else
						{
							halfday = 0;
							days = 1;
						}
						JbspPage jp = new JbspPage();
						JbspPageDi jpd = jbddao.findAllByNumberName(number, name);
						jp.setNumber(number);
						jp.setDate(du.getStringDate());
						jp.setStatus(4);
						jp.setInitiator(ui.getNewnumber());
						jp.setApplicant(ui.getNewnumber());
						jp.setPeople(name);
						jp.setChu(chu);
						jp.setZu(zu);
						jp.setReason(reason);
						jp.setBegindate(date);
						jp.setEnddate(date);
						jp.setHalfday(halfday);
						jp.setDays(days);
						jp.setRemark("考勤管理员统一导入");
						jp.setJbdays(0.0);
						jp.setDidays(0.0);
						jbdao.merge(jp);
						
						jpd.setBegindate(date);
			    		jpd.setEnddate(date);
			    		jpd.setDays(days);
			    		jpd.setJbdays(days);
			    		jpd.setDidays(0.0);
			    		jbddao.merge(jpd);
					}
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
