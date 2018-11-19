package office.jbsp.action;

import java.sql.Timestamp;
import java.util.List;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UpdateJbspStatus {
	private String message;
	private String number;
	private String newnumber;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String execute() throws Exception
	{
		String result = "success";
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    JbspPageDAO jpdao = new JbspPageDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		JbspPage jp = jpdao.findAllByNumber(number);
		String jindu = jp.getJindu();
		int jdlength = jp.getJindu().length();
		int status = jp.getStatus();
		
		UserInfo ui = uidao.findByNewNumber(newnumber);
		
		ol.setItem("JBSP");
		ol.setName(ui.getUsername());
		ol.setNewnumber(jp.getPreunder());
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(jp.getPreunder());
		lpro.setAuthority(jindu.substring(jdlength-1, jdlength));
		lpro.setRole("收回");
		lpro.setRemark("收回承办，重新办理");
		ol.setOperate("收回承办，重新办理");
		
		jp.setThisunder(jp.getPreunder());
		jp.setPreunder(null);
		
		if(jdlength>=2)
			jp.setJindu(jindu.substring(0, jdlength-1));
		else
			jp.setJindu("");
		if(status==4)
		{
			jpdao.unsubmitJbspPage(number,session);
			jp.setStatus(1);
		}
		else if(status==1)
		{
			jp.setStatus(0);
			jp.setThisunder(null);
		}
		message = "收回成功";
		result = "success";
		oldao.merge(ol);
		lprodao.merge(lpro);
		jpdao.merge(jp);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
	
//	public String checkifguoqi()
//	{
//		JbspPageDAO jpdao = new JbspPageDAO();
//		LeaveProcessDAO lpdao = new LeaveProcessDAO();
//		List<JbspPage> list = jpdao.findAll();
//		for(int i=0;i<list.size();i++)
//		{
//			JbspPage jp= list.get(i);
//			List<LeaveProcess> listlp = lpdao.findAllByNumber(jp.getNumber());
//			if(!listlp.isEmpty())
//			{
//				
//			}
//			
//		}
//		
//		return "";
//	}
}
