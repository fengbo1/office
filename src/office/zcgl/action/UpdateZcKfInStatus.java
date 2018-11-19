package office.zcgl.action;
import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.dao.StorehouseInDAO;
import office.zcgl.pojo.StorehouseIn;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class UpdateZcKfInStatus {
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
 	    StorehouseInDAO ahdao = new StorehouseInDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		String time = du.getSimpleDateTime();
		StorehouseIn ah = ahdao.findAllByNumber(number);
		
		ol.setItem("ZCRK");
		ol.setName(ah.getName());
		ol.setNewnumber(ah.getInitiator());
		ol.setTime(time);
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ah.getName());
		lpro.setViewernewnumber(ah.getInitiator());
		lpro.setAuthority("M");
		
		lpro.setRemark("收回，重新办理");
		ol.setOperate("收回，重新办理");
		
		//ah.setThisunder(ah.getInitiator());
	
	
		/*else if(status==3)
		{
			tz.setStatus(2);
			//tzdao.unSubmitWcggPage(number);
		}*/
	  
		ah.setStatus(0);
	    ah.setThisunder(null);
		
		message = "收回成功";
		result = "success";
		oldao.merge(ol);
	    lprodao.merge(lpro);
		ahdao.merge(ah);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
