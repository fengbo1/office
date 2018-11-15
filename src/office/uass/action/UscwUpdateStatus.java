package office.uass.action;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostWbDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostWb;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UscwUpdateStatus {
	private String message;
	private String number;
	private String newnumber;
	private String type;//cx撤销shfq收回发起shcb收回承办th退回
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String execute() throws Exception
	{
		String result = "success";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    UassCostWbDAO ucdao = new UassCostWbDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		UassCostWb uc = ucdao.findAllByNumber(number);
		String jindu = uc.getJindu();
		int jdlength = uc.getJindu().length();//F//FE
		
		UserInfo ui = uidao.findByNewNumber(newnumber);
		
		ol.setItem("USCW");
		ol.setName(ui.getUsername());
		ol.setNewnumber(newnumber);
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(newnumber);
		if(type.equals("shcb"))
		{
			lpro.setAuthority(jindu.substring(jdlength-1, jdlength));
			lpro.setRemark("收回承办，重新办理");
			ol.setOperate("收回承办，重新办理");
			uc.setUndertake(uc.getPreundertake());
			uc.setPreundertake(null);
			if(jdlength>=2)
				uc.setJindu(jindu.substring(0, jdlength-1));
			else
				uc.setJindu("");
		}
		else if(type.equals("shfq"))
		{
			uc.setStatus(6);
			uc.setUndertake(null);
		}
		else if(type.equals("cx"))
		{
			uc.setStatus(6);
			uc.setUndertake(null);
		}
		else if(type.equals("th"))
		{
			uc.setStatus(5);
			uc.setUndertake(null);
		}
		else if(type.equals("qr"))//确认
		{
			uc.setStatus(4);
			uc.setUndertake(null);
		}
		lpro.setRole("收回");
		message = "收回成功";
		result = "success";
		oldao.merge(ol);
		lprodao.merge(lpro);
		ucdao.merge(uc);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
