package office.kqqs.action;

import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
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

public class KqqsQueren {

	private String message;
	private String number;
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
		
		UserInfo ui = uidao.findByNewNumber(kp.getApplicant());
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(kp.getApplicant());
		lpro.setAuthority("");
		lpro.setRemark("申请人确认");
		
		kp.setThisunder(null);
		kp.setPreunder(null);
		
		kp.setStatus(4);
		message = "确认成功";
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
