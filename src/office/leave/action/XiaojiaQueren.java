package office.leave.action;

import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class XiaojiaQueren {

	private String type;
	private String number;
	private String message;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		message = "销假成功";
		LeavePageDAO lpdao = new LeavePageDAO();
		DateUtil du = new DateUtil();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		LeavePage lp = lpdao.findByNumber(number);
		if(type.equals("xiaojia"))
		{
			lp.setStatus(2);
			lp.setUndertake(null);
			lp.setPreundertake(null);
			lp.setXiaojia(du.getSimpleDateTime());
		}
		if(type.equals("daixiaojia"))
		{
			lp.setStatus(2);
			lp.setUndertake(null);
			lp.setPreundertake(null);
			lp.setXiaojia(du.getSimpleDateTime()+" （考勤管理员代销假）");
		}	
		lpdao.merge(lp);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
