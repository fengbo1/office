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

public class DeleteMjglPage {
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
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		TMjglDAO tmdao = new TMjglDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		TMjgl tm = tmdao.findAllByNumber(number);
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		String time = du.getSimpleDateTime();
		message = "撤销成功";
		String peoplesave=tm.getPeople();
		ol.setItem("MJGL");
		ol.setName(ui.getUsername());
		ol.setNewnumber(newnumber);
		ol.setTime(du.getDateTime());
		ol.setOperate("撤销申请表");
		ol.setRemark(number);
		
		lpro.setAuthority(ui.getAuthority());
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(ui.getNewnumber());
		lpro.setRemark("已撤销");
		lpro.setRole("撤销");
		lprodao.merge(lpro);
		oldao.merge(ol);
		
		if(tm.getStatus()==12)//如果状态已审批完毕，需反向执行提交操作
		{
			unsubmitmjglpage(peoplesave,tm);
		}
		
//		String sqlwp = "delete from t_wcgg_page where number='"+number+"'";
//		String sqllpro = "delete from t_leave_process where number='"+number+"'";
//		String sqlbd = "delete from t_wcgg_baodao where number='"+number+"'";
//		session.createSQLQuery(sqlwp).executeUpdate();
//		session.createSQLQuery(sqllpro).executeUpdate();
//		session.createSQLQuery(sqlbd).executeUpdate();
		
		tm.setStatus(6);//状态修改为已撤销
		tm.setPreunder("");
		tm.setThisunder("");
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	public void unsubmitmjglpage(String peoplesave,TMjgl tmtemp)
	{   
		TMjglPage tp1= new TMjglPage();
		TMjglPageDAO tpdao1 = new TMjglPageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo initiator = uidao.findByNewNumber(tmtemp.getInitiator()); 
 	    tp1=tpdao1.findAllByName(initiator.getUsername());
		
		if(tmtemp.getIstemp()==0)
		{
			tp1.setCurrentauth(tmtemp.getOldp());
			tp1.setCurrenttime(tmtemp.getOldtime());
			tp1.setRemark("");
		}
		else
		{
			tp1.setTempauth(null);
			tp1.setTemptime(null);
			//tp1.setStartdate(tmtemp.getStartdate());
			//tp1.setEnddate(tmtemp.getEnddate());
			tp1.setRemark("");
			//tp.setStartdateamorpm(tmtemp.getStartdateamorpm());
			//tp.setEnddateamorpm(tmtemp.getEnddateamorpam());
		}
		tpdao1.merge(tp1);
		if(!peoplesave.equals(""))
		{		
		String []people=peoplesave.split("、");
		for(int i=0;i<people.length;i++)
	    {
			TMjglPage tp= new TMjglPage();
			TMjglPageDAO tpdao = new TMjglPageDAO();
			tp=tpdao.findAllByName(people[i]);
			if(tmtemp.getIstemp()==0)
			{
				tp.setCurrentauth(tmtemp.getOldp());
				tp.setCurrenttime(tmtemp.getOldtime());
			}
			else
			{
				tp.setTempauth(null);
				tp.setTemptime(null);
			}
			tpdao.merge(tp);
	    }
		}
	}
}
