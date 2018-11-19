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
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.dao.AssetBorrowDAO;
import office.zcgl.pojo.AssetBorrow;
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
public class DeleteZcBorrowPage {
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
		AssetBorrowDAO aydao = new AssetBorrowDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		AssetTempDAO apdao = new AssetTempDAO();
		LeaveProcess lpro = new LeaveProcess();
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		AssetBorrow ay = aydao.findAllByNumber(number);
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		String time = du.getSimpleDateTime();
		message = "撤销成功";
		
		ol.setItem("ZCJY");
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
		
		ay.setStatus(6);//状态修改为已撤销
		ay.setPreunder("");
		ay.setThisunder("");
		List<AssetTemp> listap = apdao.findAllByNumber(number);
	 	//unchangeassetinfo(listap,number); 
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
	public void unchangeassetinfo(List<AssetTemp> listap,String number)
	{
		AssetInfoDAO aidao=new AssetInfoDAO();
		for(int i=0;i<listap.size();i++)
		{
			AssetBorrowDAO aydao=new AssetBorrowDAO();
			AssetTemp ap = listap.get(i);
			AssetBorrow ay = aydao.findAllByNumber(number);
			for(int j=0;j<ap.getNum();j++)
			{
				AssetInfo ai = aidao.findAllByNameAndTypeAndChuAndStatus(ap.getName(), ap.getType(),ay.getChu(),3).get(0);
				ai.setChu(7);
				ai.setStatus(1);
				aidao.merge(ai);
			}	
			
		}
		
	}
}
