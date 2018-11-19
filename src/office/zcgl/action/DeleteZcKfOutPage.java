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
import office.util.Util;
import office.process.pojo.Process;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.dao.StorehouseDataDAO;
import office.zcgl.dao.StorehouseInDAO;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.StorehouseData;
import office.zcgl.pojo.StorehouseIn;
import office.zcgl.pojo.StorehouseOut;
import office.zcgl.dao.StorehouseOutDAO;
public class DeleteZcKfOutPage {
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
		StorehouseOutDAO ahdao = new StorehouseOutDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		StorehouseOut ah = ahdao.findAllByNumber(number);
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		String time = du.getSimpleDateTime();
		message = "撤销成功";
		
		ol.setItem("ZCCK");
		ol.setName(ui.getUsername());
		ol.setNewnumber(newnumber);
		ol.setTime(time);
		ol.setOperate("撤销");
		ol.setRemark(number);
		
		lpro.setAuthority("M");
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(newnumber);
		lpro.setRemark("已撤销");
		
		lprodao.merge(lpro);
		oldao.merge(ol);
		
		/*if(tz.getStatus()==3||tz.getStatus()==4)//如果状态已审批完毕，需反向执行提交操作
		{
			//message = tzdao.unSubmitWcggPage(number);
		}*/
		
//		String sqlwp = "delete from t_wcgg_page where number='"+number+"'";
//		String sqllpro = "delete from t_leave_process where number='"+number+"'";
//		String sqlbd = "delete from t_wcgg_baodao where number='"+number+"'";
//		session.createSQLQuery(sqlwp).executeUpdate();
//		session.createSQLQuery(sqllpro).executeUpdate();
//		session.createSQLQuery(sqlbd).executeUpdate();
		
		ah.setStatus(6);//状态修改为已撤销
		ah.setThisunder("");
		//unchangeassetinfo(ah);
		ahdao.merge(ah);
		StorehouseDataDAO ahddao = new StorehouseDataDAO();
	 	List<StorehouseData> listahd = ahddao.findAllByRukunum(ah.getChukunum());
	    unchangeassetinfo(listahd);			
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
	public void unchangeassetinfo(List<StorehouseData> listahd)
	{
		AssetInfoDAO aidao=new AssetInfoDAO();
	    for(int i=0;i<listahd.size();i++)
		{
		    AssetInfo ai = aidao.findAllByNumber(listahd.get(i).getAssetnumber());
			ai.setStatus(1);
			ai.setArea("库房");
			aidao.merge(ai);
		}
	}
}
