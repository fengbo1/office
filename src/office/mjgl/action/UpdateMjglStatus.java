package office.mjgl.action;
import java.sql.Timestamp;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.dao.TMjglDAO;
import office.mjgl.pojo.TMjgl;
import office.mjgl.pojo.TMjglPage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class UpdateMjglStatus {
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
 	    TMjglDAO tmdao = new TMjglDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		TMjgl tm = tmdao.findAllByNumber(number);
		String jindu = tm.getJindu();
		int jdlength = tm.getJindu().length();//F//FE
		int status = tm.getStatus();
		
		UserInfo ui = uidao.findByNewNumber(newnumber);
		
		ol.setItem("MJGL");
		ol.setName(ui.getUsername());
		ol.setNewnumber(tm.getPreunder());
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(tm.getPreunder());
		lpro.setAuthority(jindu.substring(jdlength-1, jdlength));
		lpro.setRole("收回");
		lpro.setRemark("收回承办，重新办理");
		ol.setOperate("收回承办，重新办理");
		
		tm.setThisunder(tm.getPreunder());
		tm.setPreunder(null);
		
		if(jdlength>=2)
			tm.setJindu(jindu.substring(0, jdlength-1));
		else
			tm.setJindu("");
		if(status==10)
		{
			tm.setStatus(1);
		}
		/*else if(status==3)
		{
			tz.setStatus(2);
			//tzdao.unSubmitWcggPage(number);
		}*/
		else if(status==1)
		{
			tm.setStatus(0);
			tm.setThisunder(null);
		}
		message = "收回成功";
		result = "success";
		oldao.merge(ol);
		lprodao.merge(lpro);
		tmdao.merge(tm);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
