package office.zcgl.action;
import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.LeaveUtil;
import office.util.Util;
import office.zcgl.dao.AssetReturnDAO;
import office.zcgl.pojo.AssetReturn;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class ZcReturnQueRen {
	private String message;
	private String number;
	private String date;
	private String time;

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
 	    
 	    AssetReturnDAO aydao = new AssetReturnDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		date = du.getStringDate();
		UserInfoDAO uidao = new UserInfoDAO();
		time = du.getSimpleDateTime();
		AssetReturn ay = aydao.findAllByNumber(number);
		UserInfo ui = uidao.findByNewNumber(ay.getInitiator());
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(ay.getInitiator());
		lpro.setAuthority("");
		lpro.setRemark("资产管理员确认");
		changeassetinfo(ay,session);
		ay.setThisunder(null);
		ay.setPreunder(null);
		ay.setStatus(4);
		
		message = "确认成功";
		result = "success";
		oldao.merge(ol);
		lprodao.merge(lpro);
		aydao.merge(ay);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
	public void changeassetinfo(AssetReturn ay,Session session)
	{
		 AssetInfoDAO aidao=new AssetInfoDAO();
		 String assetid = ay.getAssetid();
	 	 Query query;
		 String hql = "";
		 String searchid = assetid.replace("、", "','");
		 hql = "from AssetInfo as ai where ai.id in ('"+searchid+"') order by ai.id";
		 query = session.createQuery(hql);
		 List<AssetInfo>listap= query.list();
		 for(int i=0;i<listap.size();i++)
		 {	
			AssetInfo ap = listap.get(i);
		    ap.setChu(7);
		    ap.setStatus(1);
		    ap.setPeople("");
		    ap.setReturntime("");
		    ap.setArea("");
			aidao.merge(ap);
		 }			
	}
		
}
