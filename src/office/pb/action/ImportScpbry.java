package office.pb.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import office.jbsp.pojo.JbspPage;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.ScpbUploadDAO;
import office.kqjl.dao.YgpbUploadDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.ScpbUpload;
import office.kqjl.pojo.YgpbUpload;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.bean.ScpbTableBean;
import office.pb.dao.PbMxDAO;
import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.ScpbTableDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.PbMx;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.ScpbTable;
import office.pb.pojo.ScpbTeam;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.PbUtil;
import office.util.Util;
import office.wcgg.pojo.WcggPage;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportScpbry {

	private static Logger logger = Logger.getLogger(ImportScpbry.class);
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
	ScpbTeamDAO stdao = new ScpbTeamDAO();
	UserInfoDAO uidao = new UserInfoDAO();
	int nn=0;
	message = "success";
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
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < nn; i++) {
			int teamno = Integer.parseInt(sheet.getCell(0, i).getContents().trim());
			String leader = sheet.getCell(1, i).getContents().trim();
			String member = sheet.getCell(2, i).getContents().trim();
			String[] leaders = leader.split("、");
			String[] members = member.split("、");
//			if(uidao.findByName(leader)==null)
//			{
//				message += "失败！找不到员工"+leader+",请确认姓名是否正确！";
//				return "failed";
//			}else if(list.indexOf(leader)!=-1)
//			{
//				message += "失败！姓名"+leader+"重复，请确认后重新导入！";
//				return "failed";
//			}
//			else
//			{
//				list.add(leader);
//			}
			for(int j=0;j<leaders.length;j++)
			{
				if(uidao.findByName(leaders[j])==null)
				{
					message += "失败！找不到员工"+leaders[j]+",请确认姓名是否正确！";
					return "failed";
				}
				else if(list.indexOf(leaders[j])!=-1)
				{
					message += "失败！姓名"+leaders[j]+"重复，请确认后重新导入！";
					return "failed";
				}
				else
				{
					list.add(leaders[j]);
				}
			}
			for(int j=0;j<members.length;j++)
			{
				if(uidao.findByName(members[j])==null)
				{
					message += "失败！找不到员工"+members[j]+",请确认姓名是否正确！";
					return "failed";
				}
				else if(list.indexOf(members[j])!=-1)
				{
					message += "失败！姓名"+members[j]+"重复，请确认后重新导入！";
					return "failed";
				}
				else
				{
					list.add(members[j]);
				}
			}
		}
		if(message.equals("success"))
		{
			message = "导入成功！";
			String sql = "select max(num) from t_scpb_team";
			int newnum = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString())+1;
			for (int i = 1; i < nn; i++) {
				ScpbTeam st = new ScpbTeam();
				int teamno = Integer.parseInt(sheet.getCell(0, i).getContents().trim());
				String leader = sheet.getCell(1, i).getContents().trim();
				String member = sheet.getCell(2, i).getContents().trim();
				st.setNo(teamno);
				st.setNum(newnum);
				st.setLeader(leader);
				st.setMember(member);
				stdao.merge(st);
			}
		}
		System.out.println(message);
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
