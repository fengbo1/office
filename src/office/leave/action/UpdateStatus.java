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

public class UpdateStatus {

	private int type;
	private String message;
	private String number;
	private String newnumber;
	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
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

	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public String execute() throws Exception
	{
		String result = "successcx";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		LeavePageDAO lpdao = new LeavePageDAO();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		String time = du.getSimpleDateTime();
		LeavePage lp = lpdao.findByNumber(number);
		String jindu = lp.getJindu();
		int jdlength = lp.getJindu().length();//F//FE
		int status = lp.getStatus();
		ui = uidao.findByNewNumber(newnumber);

		UserInfo uithis = uidao.findByNewNumber(lp.getUndertake());
		
		String auth = "";
		String auththis = "";
		auth = ui.getAuthority();
		if(uithis!=null)//避免空指针异常
		auththis = uithis.getAuthority();
		
		ol.setItem("QJSQ");
		ol.setName(ui.getUsername());
		ol.setNewnumber(lp.getPreundertake());
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(lp.getPreundertake());
		lpro.setAuthority(jindu.substring(jdlength-1, jdlength));

		
		if(type==3)
		{
			lpro.setRemark("撤销成功");
			ol.setOperate("撤销成功");
			lp.setStatus(type);
			message = "撤销成功";
			lp.setUndertake(null);
			result = "successcx";
		}
		else if(type==4)
		{
			lpro.setRemark("退回成功");
			ol.setOperate("退回成功");
			lp.setStatus(type);
			message = "退回成功";
		}
		else if(type==5)
		{
			lpro.setRemark("收回承办，重新办理。");
			ol.setOperate("收回承办，重新办理。");
			lp.setUndertake(lp.getPreundertake());//承办人改为上一人
			lp.setPreundertake(null);//不能重复收回
			if(auth.contains("G")&&auththis.contains("H"))//如果上一审批人是关辉，当前审批人是惠总，退两步
			{
				lp.setJindu(jindu.substring(0, jdlength-2));//EDCT
				lpro.setAuthority("C");
			}
			else if(jdlength>=2)
			{
				lp.setJindu(jindu.substring(0, jdlength-1));
				if(jdlength==2)//
				{
					lp.setStatus(9);
				}
			}
				
			else
				lp.setJindu("");	
			if(status==7)
			{
				lp.setStatus(1);
				lpdao.undoLeavePage(session, number);
			}
			else if(status==6)
			{
				lp.setStatus(1);
			}
			else if(status==9)
			{
				lp.setStatus(0);
				lp.setUndertake(null);
			}
			message = "收回成功";
			result = "successycb";
			oldao.merge(ol);
		}
	
	    lprodao.merge(lpro);
		
		lpdao.merge(lp);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
