package office.yscj.action;
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
import office.yscj.dao.TYscjDAO;
import office.yscj.pojo.TYscj;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class UpdateYscjStatus {
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
 	    TYscjDAO tydao = new TYscjDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		TYscj ty = tydao.findAllByNumber(number);
		String jindu = ty.getJindu();
		int jdlength = ty.getJindu().length();//F//FE
		int status = ty.getStatus();
		
		UserInfo ui = uidao.findByNewNumber(newnumber);
		
		ol.setItem("YSCJ");
		ol.setName(ui.getUsername());
		ol.setNewnumber(ty.getPreunder());
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(ty.getPreunder());
		lpro.setAuthority(jindu.substring(jdlength-1, jdlength));
		lpro.setRole("收回");
		lpro.setRemark("收回承办，重新办理");
		ol.setOperate("收回承办，重新办理");
		
		ty.setThisunder(ty.getPreunder());
		ty.setPreunder(null);
		
		if(jdlength>=2)
			ty.setJindu(jindu.substring(0, jdlength-1));
		else
			ty.setJindu("");
		if(status==4)
		{
			ty.setStatus(1);
		}
		else if(status==3)//审批完毕
		{
			ty.setStatus(2);
			//tydao.unSubmitWcggPage(number);
		}
		else if(status==1)
		{
			ty.setStatus(0);
			ty.setThisunder(null);
		}
		message = "收回成功";
		result = "success";
		oldao.merge(ol);
	    lprodao.merge(lpro);
		tydao.merge(ty);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
