package office.zcgl.action;

import java.util.List;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.zcgl.dao.AssertFenDAO;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssertFen;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ZcApplyFenQueRen {
	private String message;
	private String number;
	private String date;
	private String time;
	private String newnumber;
	
	
	
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
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
		message = "分配编号完毕";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction(); 	    
 	    AssetApplyDAO aydao = new AssetApplyDAO();
 	    AssertFenDAO afdao = new AssertFenDAO();
 	    AssetInfoDAO aidao = new AssetInfoDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		date = du.getStringDate();
		UserInfoDAO uidao = new UserInfoDAO();
		time = du.getSimpleDateTime();
		AssetApply ay = aydao.findAllByNumber(number);
		UserInfo ui = uidao.findByNewNumber(newnumber);
		List<AssertFen>listaf = afdao.findByApplynumber(number);
		int flag=1;
		for(int i=0;i<listaf.size();i++)
		{
			AssertFen af = listaf.get(i);
			AssetInfo ai = aidao.findAllByNumber(af.getNumber());
			if(ai==null)
			{
				result="failed";
				message="所分配编号不存在，请重新分配！";
				flag=0;
				break;
			}
			if(ai.getStatus()!=1)
			{
				result="failed";
				message="存在不在库编号被分配，请重新分配！";
				flag=0;
				break;
			}
			
		}
		if(flag==1)
		{
			lpro.setNumber(number);
			lpro.setTime(time);
			lpro.setViewer(ui.getUsername());
			lpro.setViewernewnumber(newnumber);
			lpro.setAuthority("M");
			lpro.setRemark("中心资产管理员分配编号");
			ol.setItem("ZCSL");
		    ol.setName(ui.getUsername());
		    ol.setNewnumber(newnumber);
		    ol.setTime(du.getDateTime());
			ol.setRemark("中心资产管理员分配编号");
			ay.setThisunder(ay.getInitiator());
			ay.setPreunder("66191663");
			ay.setStatus(15);
			changeassetinfo(listaf,ay);
			oldao.merge(ol);
			lprodao.merge(lpro);
			aydao.merge(ay);
		}
		
		
		//result = "success";
		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
     }
	
	public void changeassetinfo(List<AssertFen> listaf,AssetApply ay)
	{
		AssetInfoDAO aidao=new AssetInfoDAO();
		for(int i=0;i<listaf.size();i++)
		{
			
			AssertFen af = listaf.get(i);
		    AssetInfo ai = aidao.findAllByNumber(af.getNumber());
			ai.setChu(ay.getChu());
			ai.setStatus(2);
			//ai.setPeople(af.getUsername());
			//ai.setArea(af.getArea());
			ai.setReturntime("0");
			aidao.merge(ai);				
		}
		
	}
	
	public void unchangeassetinfo(List<AssertFen> listaf,AssetApply ay)
	{
		AssetInfoDAO aidao=new AssetInfoDAO();
		for(int i=0;i<listaf.size();i++)
		{
		
			AssertFen af = listaf.get(i);
			AssetInfo ai = aidao.findAllByNumber(af.getNumber());
			ai.setChu(7);
			ai.setStatus(1);
			ai.setPeople("");
			aidao.merge(ai);
				
		}	
	}
}
