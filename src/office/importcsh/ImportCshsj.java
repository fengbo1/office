package office.importcsh;

import java.io.File;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportCshsj {

	private static Logger logger = Logger.getLogger(ImportCshsj.class);
	private File file; 
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String type;
    private String fugai;
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
	
	public String execute() throws Exception
	{
		int nn=0;
		String realpath = "D:/import/office/";
		message = "导入成功";
		
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
    	UserInfoDAO uidao = new UserInfoDAO();
    	LeavePageDAO lpdao = new LeavePageDAO();
    	try {
    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
			
			Sheet sheet = book.getSheet(0);
			
			nn = sheet.getRows();
			if(type.equals("qjsp"))
			{
				if(fugai.equals("fugai"))
				{
					String sql = "truncate t_leave_page";
					String sql1 = "delete from t_leave_process where number like '%QJSQ%'";
					String sql2 = "truncate t_leave_monthsummary";
					String sql3 = "truncate t_leave_summary";
					session.createSQLQuery(sql).executeUpdate();
					session.createSQLQuery(sql1).executeUpdate();
					session.createSQLQuery(sql2).executeUpdate();
					session.createSQLQuery(sql3).executeUpdate();
				}
				for (int i = 1; i < nn; i++) {
					LeavePage lp = new LeavePage();
					String number = "";
					String date = sheet.getCell(0, i).getContents().trim().replace("-", "");
					String initiator = sheet.getCell(1, i).getContents().trim();
					String applicant = sheet.getCell(2, i).getContents().trim();
					UserInfo uiapp = uidao.findByName(applicant);
					UserInfo uiini = uidao.findByName(initiator);
					String position = uiapp.getPosition();
					String tuan = position.substring(4, 5);
					if(tuan.compareTo("0")<0||tuan.compareTo("9")>0)
					{
						tuan="0";
					}
					int dai = 0;
					String index = "";
					if(!initiator.equals(applicant))
					{
						dai = 1;
					}
					
					List<LeavePage> list = lpdao.findByDate(date);
					if (list.isEmpty()) {
						number = date + "QJSQ" + dai + "0" + "001";
					} else {
						LeavePage lastlp = list.get(list.size() - 1);
						String tempnumber = lastlp.getNumber();
						index = tempnumber.substring(tempnumber.length() - 3, tempnumber
								.length());// 20151005QJSQ00111
						index = "000" + String.valueOf(Integer.parseInt(index) + 1);
						index = index.substring(index.length() - 3, index.length());
						number = date + "QJSQ" + dai + "0" + index;
					}
					lp.setNumber(number);
					lp.setProcess(0);
					lp.setJindu("");
					lp.setDate(date);
					lp.setStatus(2);
					lp.setPreundertake("");
					lp.setUndertake("");
					lp.setInitiator(uiini.getNewnumber());
					lp.setApplicant(uiapp.getNewnumber());
					lp.setDai(dai);
					lp.setChu(Integer.valueOf(position.substring(2, 3)));
					lp.setTuan(Integer.valueOf(tuan));
					lp.setZhiwu(sheet.getCell(3, i).getContents().trim());
					//lp.set
				}
			}
			else if(type.equals("wcgg"))
			{
				for (int i = 1; i < nn; i++) {
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
					uidao.merge(ui);
				}
			}
			else if(type.equals("jbsp"))
			{
				for (int i = 1; i < nn; i++) {
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
					uidao.merge(ui);
				}
			}
			else if(type.equals("kqqs"))
			{
				for (int i = 1; i < nn; i++) {
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
					uidao.merge(ui);
				}
			}
    	}catch (Exception e) {
			trans.rollback();
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
