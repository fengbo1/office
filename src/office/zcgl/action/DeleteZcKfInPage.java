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
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.dao.StorehouseDataDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.pojo.StorehouseData;
import office.zcgl.pojo.StorehouseOut;
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
public class DeleteZcKfInPage {
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
		StorehouseInDAO ahdao = new StorehouseInDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		StorehouseIn ah = ahdao.findAllByNumber(number);
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		String time = du.getSimpleDateTime();
		message = "撤销成功";
		
		ol.setItem("ZCRK");
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
		ahdao.merge(ah);
		
	    unchangeassetinfo(ah,session);
	
	
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
	public void unchangeassetinfo(StorehouseIn ah ,Session session )
	{
		
		StorehouseDataDAO ashdao = new StorehouseDataDAO();
		List<StorehouseData> listash = ashdao.findByRukunum(ah.getRukunum());
	    for(int i=0;i<listash.size();i++)
		{
	    	String sql = "delete from asset_info where number = '"+listash.get(i).getAssetnumber()+"'";
	    	session.createSQLQuery(sql).executeUpdate();
		}
	}
}
