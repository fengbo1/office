package office.zcgl.action;
import java.util.List;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.process.action.FindNextUnder;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.LeaveUtil;
import office.util.Util;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.dao.StorehouseInDAO;
import office.zcgl.dao.StorehouseOutDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.pojo.StorehouseIn;
import office.zcgl.pojo.StorehouseOut;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class ZcKfOutShenpi {
	private String thisunder;
	private String number;
	private String message;
	private String newnumber;
	private String thisundername;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
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

	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getThisundername() {
		return thisundername;
	}
	public void setThisundername(String thisundername) {
		this.thisundername = thisundername;
	}

	public String execute() throws Exception
	{
		String result = "success";
		message = "复核通过";
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		StorehouseOut ah = new StorehouseOut();
		StorehouseOutDAO ahdao = new StorehouseOutDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();//审批意见写在leaveprocess中
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		time = du.getSimpleDateTime();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(newnumber);
 			ah = ahdao.findAllByNumber(number);
 			thisundername = ui.getUsername();
 			ol.setItem("ZCCK");
 			ol.setName(thisundername);
 			ol.setNewnumber(newnumber);
 			ol.setTime(time);
 			ol.setRemark(number);
 			oldao.merge(ol);
 			lpro.setNumber(number);
 			lpro.setTime(time);
 			lpro.setViewer(thisundername);
 			lpro.setViewernewnumber(newnumber);
 			lpro.setAuthority("N");
 			lpro.setRemark("复核通过");
 			lprodao.merge(lpro);
 			ah.setStatus(4);
 			ah.setThisunder("");
 			ahdao.merge(ah);
 						
 		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
}
