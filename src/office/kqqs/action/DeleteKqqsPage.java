package office.kqqs.action;

import java.sql.Timestamp;
import java.util.List;

import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class DeleteKqqsPage {

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
		KqqsPageDAO kpdao = new KqqsPageDAO();
		OperateLog ol = new OperateLog();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		//Timestamp time = new Timestamp(System.currentTimeMillis());
		String time = du.getSimpleDateTime();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		KqqsPage kp = kpdao.findAllByNumber(number);
		message = "撤销成功";
		
		ol.setItem("JBSP");
		ol.setName(ui.getUsername());
		ol.setNewnumber(newnumber);
		ol.setTime(du.getDateTime());
		ol.setOperate("撤销审批表");
		ol.setRemark(number);
		
		lpro.setAuthority(ui.getAuthority());
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(ui.getNewnumber());
		lpro.setRemark("已撤销");
		
		lprodao.merge(lpro);
		oldao.merge(ol);
		
//		String sqlkp = "delete from t_kqqs_page where number='"+number+"'";
//		String sqllpro = "delete from t_leave_process where number='"+number+"'";
//		session.createSQLQuery(sqlkp).executeUpdate();
//		session.createSQLQuery(sqllpro).executeUpdate();
		kp.setPreunder("");
		kp.setThisunder("");
//		List<KqqsPage> listkp = kpdao.findAllByQsMonthAndNewnumber(kp.getQsdate().substring(0, 6),ui.getNewnumber());
//		if((!listkp.isEmpty()))
//		{
//			if(listkp.size()>0)
//			{
//				for(int i=0;i<listkp.size();i++)
//				{
//					KqqsPage kptemp  = listkp.get(i);
//					kptemp.setCs(kptemp.getCs()-1);
//				}
//				
//			}
//		}
//		kp.setCs(null);
		kp.setStatus(6);//状态修改为已撤销
		
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
