package office.kqqs.action;

import java.sql.Timestamp;

import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggPage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UpdateKqqsStatus {
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
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    KqqsPageDAO kpdao = new KqqsPageDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		KqqsPage kp = kpdao.findAllByNumber(number);
		String jindu = kp.getJindu();
		int jdlength = kp.getJindu().length();//F//FE
		int status = kp.getStatus();
		
		UserInfo ui = uidao.findByNewNumber(newnumber);
		
		ol.setItem("KQQS");
		ol.setName(ui.getUsername());
		ol.setNewnumber(kp.getPreunder());
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(kp.getPreunder());
		lpro.setAuthority(jindu.substring(jdlength-1, jdlength));
		
		lpro.setRemark("收回承办，重新办理");
		ol.setOperate("收回承办，重新办理");
		
		kp.setThisunder(kp.getPreunder());
		kp.setPreunder(null);
		
		if(jdlength>=2)
			kp.setJindu(jindu.substring(0, jdlength-1));
		else
			kp.setJindu("");
		if(status==3)
		{
			kp.setStatus(1);
		}
		else if(status==1)
		{
			kp.setStatus(0);
			kp.setCs(null);
			kp.setThisunder(null);
		}
		message = "收回成功";
		result = "success";
		oldao.merge(ol);
	    lprodao.merge(lpro);
		kpdao.merge(kp);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
