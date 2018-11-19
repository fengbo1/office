package office.pb2.action;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UpdateTpStatus {

	private String message;
	private String number;
	private String newnumber;
	private int type;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		TbsqPageDAO tpdao = new TbsqPageDAO();
		PbMxDAO pmdao = new PbMxDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		UserInfoDAO uidao = new UserInfoDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		String result = "success";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    String time = du.getSimpleDateTime();
 	    TbsqPage tp = tpdao.findAllByNumber(number);
 	    int status = tp.getStatus();
 	    OperateLog ol = new OperateLog();
 	    
 	    UserInfo uifq = uidao.findByNewNumber(tp.getApplicant());
 	    UserInfo ui = uidao.findByNewNumber(newnumber);
 	    
 	    PbMx pmfq = pmdao.findAllByNameAndDateNull(uifq.getUsername(),tp.getTbdate());
 	    PbMx pmtb = pmdao.findAllByNameAndDateNull(tp.getTbname(),tp.getTbdate());
 	    
 	    ol.setItem("TBSQ");
		ol.setName(ui.getUsername());
		ol.setNewnumber(ui.getNewnumber());
		ol.setTime(du.getDateTime());
		ol.setRemark(number);
			
		lpro.setNumber(number);
		lpro.setTime(time);
		lpro.setViewer(ui.getUsername());
		lpro.setViewernewnumber(ui.getNewnumber());
		lpro.setAuthority(ui.getAuthority());
 	    
 	    if(type==0)//收回
 	    {
 	    	message = "成功收回！";
 	    	lpro.setRemark("收回承办，重新办理");
 			ol.setOperate("收回承办，重新办理");
 			tp.setUndertake("");
 			if(status==1)
 			{
 				tp.setStatus(0);
 			}
 			else
 			{
 				String sql = "select count(distinct(viewer)) from t_leave_process where number='"+number+"'";
 				int num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
 				if(num==1)
 				{
 					tp.setStatus(1);
 				}
 				else
 				{
 					tp.setStatus(2);
 				}
 				tp.setUndertake(tp.getPreundertake());
 			}
 			tp.setPreundertake("");
 	    }
 	    else if(type==6)//撤销
 	    {
 	    	if(tp.getStatus()==4)
 	    	{
 	    		String tempsb = "";
 	    		String tempxb = "";
				String tempzy = "";
				String temppx = "";
				tp.setUndertake("");
				tempsb = pmfq.getPbqdtime();
				tempxb = pmfq.getPbqttime();
				tempzy = pmfq.getZytime();
				temppx = pmfq.getPxtime();
				pmfq.setPbqdtime(pmtb.getPbqdtime());
				pmfq.setPbqttime(pmtb.getPbqttime());
				pmfq.setZytime(pmtb.getZytime());
				pmfq.setPxtime(pmtb.getPxtime());
				pmfq.setTb("");
				
				pmtb.setPbqdtime(tempsb);
				pmtb.setPbqttime(tempxb);
				pmtb.setZytime(tempzy);
				pmtb.setPxtime(temppx);
				pmtb.setTb("");
				
				pmdao.merge(pmtb);
				pmdao.merge(pmfq);	
 	    	}
 	    	message = "成功撤销！";
 	    	lpro.setRemark("撤销审批表");
 			ol.setOperate("已撤销");
 			tp.setStatus(6);
 			tp.setPreundertake("");
 			tp.setUndertake("");
 	    }
 	    else if(type==7)//确认
 	    {
 	    	message = "成功确认！";
 	    	lpro.setRemark("发起人确认");
 	    	tp.setStatus(4);//修改为成功
			tp.setPreundertake(null);
			tp.setUndertake(null);//下一处理人是自己
 	    }
 	    lprodao.merge(lpro);
		oldao.merge(ol);
		tpdao.merge(tp);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
