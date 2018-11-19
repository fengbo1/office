package office.wcgg.action;

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

/**
 * 更新外出公干状态
 * @author htzx
 *
 */
public class UpdateWcggStatus {

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
 	    WcggPageDAO wpdao = new WcggPageDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		WcggPage wp = wpdao.findAllByNumber(number);
		String jindu = wp.getJindu();
		int jdlength = wp.getJindu().length();//F//FE
		int status = wp.getStatus();
		
		UserInfo ui = uidao.findByNewNumber(newnumber);
		
		ol.setItem("WCGG");
		ol.setName(ui.getUsername());
		ol.setNewnumber(wp.getPreunder());
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(wp.getPreunder());
		lpro.setAuthority(jindu.substring(jdlength-1, jdlength));
		lpro.setRole("收回");
		lpro.setRemark("收回承办，重新办理");
		ol.setOperate("收回承办，重新办理");
		
		wp.setThisunder(wp.getPreunder());
		wp.setPreunder(null);
		
		if(jdlength>=2)
			wp.setJindu(jindu.substring(0, jdlength-1));
		else
			wp.setJindu("");
		if(status==4)
		{
			wp.setStatus(1);
		}
		else if(status==3)
		{
			wp.setStatus(2);
			wpdao.unSubmitWcggPage(number);
		}
		else if(status==1)
		{
			wp.setStatus(0);
			wp.setThisunder(null);
		}
		message = "收回成功";
		result = "success";
		oldao.merge(ol);
		lprodao.merge(lpro);
		wpdao.merge(wp);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
