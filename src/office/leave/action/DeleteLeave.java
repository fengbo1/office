package office.leave.action;

import java.sql.Timestamp;

import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 删除审批表的操作
 * @author htzx
 *
 */
public class DeleteLeave {

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
 	    DateUtil du = new DateUtil();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		LeavePageDAO lpdao = new LeavePageDAO();
		LeavePage lp = lpdao.findByNumber(number);
		UserInfoDAO uidao = new UserInfoDAO();
		String time = du.getSimpleDateTime();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		message = "撤销成功";
		
		ol.setItem("QJSQ");
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
		
		
		if(lp.getStatus()==7||lp.getStatus()==2)//如果状态已审批完毕，需反向执行提交操作
		{
			lpdao.undoLeavePage(session,number);
		}
		
		//String sqllp = "delete from t_leave_page where number='"+number+"'";
		//String sqllpro = "delete from t_leave_process where number='"+number+"'";
		//session.createSQLQuery(sqllp).executeUpdate();
		//session.createSQLQuery(sqllpro).executeUpdate();
		lp.setUndertake(null);//当前承办人改为空
		lp.setPreundertake("");
		lp.setStatus(3);//状态改为已撤销
		
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
