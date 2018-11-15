package office.mjgl.action;
import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.dao.TMjglDAO;
import office.mjgl.pojo.TMjgl;
import office.mjgl.pojo.TMjglPage;
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
public class MjglQueren {
	private String message;
	private String number;
	private String thisnewnumber;
	public String getThisnewnumber() {
		return thisnewnumber;
	}
	public void setThisnewnumber(String thisnewnumber) {
		this.thisnewnumber = thisnewnumber;
	}
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
 	    TMjglDAO tmdao = new TMjglDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		TMjgl tm = tmdao.findAllByNumber(number);
		UserInfo ui = uidao.findByNewNumber("66191663");
		ol.setItem("MJGL");
	    ol.setName(ui.getUsername());
		ol.setNewnumber("66191663");
		ol.setTime(du.getDateTime());
		ol.setRemark("门禁管理员确认");
			
		//lpro.setNumber(number);
		//lpro.setTime(time);
		//lpro.setViewer(ui.getUsername());
		//lpro.setViewernewnumber("66191663");
		//lpro.setAuthority("Q");
		//lpro.setRemark("门禁管理员确认");
		
		tm.setThisunder(tm.getInitiator());
		tm.setPreunder("66191663");
		
		tm.setStatus(13);
		message = "调整权限成功";
		result = "success";
		oldao.merge(ol);
		//lprodao.merge(lpro);
		tmdao.merge(tm);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
