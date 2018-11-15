package office.zcgl.action;
import java.util.List;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import office.process.pojo.Process;
import office.zcgl.dao.AssertFenDAO;
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssertFen;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.pojo.AssetApply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import ccb.hibernate.HibernateSessionFactory;
public class ZcApplyQueRen {
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
		message = "确认成功";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    AssetApplyDAO aydao = new AssetApplyDAO();
 	    LeaveProcessDAO lprodao = new LeaveProcessDAO();
 	    AssertFenDAO afdao = new AssertFenDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		date = du.getStringDate();
		UserInfoDAO uidao = new UserInfoDAO();
		time = du.getSimpleDateTime();
		AssetApply ay = aydao.findAllByNumber(number);
		List<AssertFen> listaf = afdao.findAllByApplyNumber(number);
		UserInfo ui = uidao.findByNewNumber(ay.getInitiator());
		int flag =1;
		//int flag = checksamechu(ay,listaf,uidao);
		if(flag==0)
		{
			result="failed";
			message="分配编号人员必须和处室资产管理员是同一处室，请重新分配!";
		}
		if(flag==1)
		{
			lpro.setNumber(number);
			lpro.setTime(time);
			lpro.setViewer(ui.getUsername());
			lpro.setViewernewnumber(ay.getInitiator());
			lpro.setAuthority("");
			lpro.setRemark("处室资产管理员分配编号到人");
			ol.setItem("ZCSL");
		    ol.setName(ui.getUsername());
		    ol.setNewnumber(ay.getInitiator());
		    ol.setTime(du.getDateTime());
			ol.setRemark("处室资产管理员分配编号到人");
			ay.setThisunder(null);
			ay.setPreunder(null);
			ay.setStatus(4);
			changeassetinfo(listaf,ay);
			oldao.merge(ol);
			lprodao.merge(lpro);
			aydao.merge(ay);
		}
		
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
			ai.setPeople(af.getUsername());
			ai.setArea(af.getArea());
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
	
	public int checksamechu(AssetApply ay ,List<AssertFen> listaf,UserInfoDAO uidao)
	{
		int flag=1;
		int chu = ay.getChu();
		String name="";
		AssertFen af;
		UserInfo ui;
		for(int i=0;i<listaf.size();i++)
		{
			af = listaf.get(i);
			name = af.getUsername();
			ui = uidao.findByName(name);
			int userchu = Integer.parseInt(ui.getPosition().substring(2, 3));
			if(chu!=userchu)
			{
				flag=0;
				break;
			}
			
		}
		return flag;
	}
	
}
