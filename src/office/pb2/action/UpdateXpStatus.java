package office.pb2.action;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UpdateXpStatus {

	private String message;
	private String number;
	private String newnumber;
	private String delname;
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
	public String getDelname() {
		return delname;
	}
	public void setDelname(String delname) {
		this.delname = delname;
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
		XxsqPageDAO xpdao = new XxsqPageDAO();
		PbMxDAO pmdao = new PbMxDAO();
		ProcessYgxxHz pyh = new ProcessYgxxHz();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		UserInfoDAO uidao = new UserInfoDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		String result = "success";
		String hql = "";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    String time = du.getSimpleDateTime();
 	    XxsqPage xp = xpdao.findAllByNumber(number);
 	    int status = xp.getStatus();
 	    OperateLog ol = new OperateLog();
 	    
 	    UserInfo ui = uidao.findByNewNumber(newnumber);
 	    ol.setItem("YGXX");
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
 			xp.setUndertake("");
 			if(status==1)
 			{
 				xp.setStatus(0);
 			}
 			else
 			{
 				xp.setStatus(2);
 				xp.setUndertake(xp.getPreundertake());
 			}
 			xp.setPreundertake("");
 	    }
 	    else if(type==6)//撤销
 	    {
 			int halfday = xp.getHalfday();
 			String[] people = xp.getPeople().split("、");
 			for(int i=0;i<people.length;i++)
 			{
 				String p = people[i];
 				if(xp.getStatus()==4)
 				{
 					if(halfday==1||halfday==3)//第一天下午
 	 				{
 	 					hql = "update t_pb_mx set xw='' where date='"+xp.getBegindate()+"' and name='"+p+"'";
 	 					session.createSQLQuery(hql).executeUpdate();
 	 					System.out.println(hql);
 	 				}
 	 				if(halfday==2||halfday==3)//最后一天上午
 	 				{
 	 					hql = "update t_pb_mx set sw='' where date='"+xp.getEnddate()+"' and name='"+p+"'";
 	 					session.createSQLQuery(hql).executeUpdate();
 	 					System.out.println(hql);
 	 				}
 	 				if(halfday==0)
 	 				{
 	 					hql = "update t_pb_mx set sw='' and xw='' where date>='"+xp.getBegindate()+"' and date<='"+xp.getEnddate()+"' and name='"+p+"'";
 	 	 				session.createSQLQuery(hql).executeUpdate();
 	 	 				System.out.println(hql);
 	 				}
 	 				else
 	 				{
 	 					hql = "update t_pb_mx set sw='' and xw='' where date>'"+xp.getBegindate()+"' and date<'"+xp.getEnddate()+"' and name='"+p+"'";
 	 	 				session.createSQLQuery(hql).executeUpdate();
 	 	 				System.out.println(hql);
 	 				}
 	 				
 				}
 			}
 			message = "成功撤销！";
 	    	lpro.setRemark("撤销审批表");
 			ol.setOperate("已撤销");
 			xp.setStatus(6);
 			xp.setPreundertake("");
 			xp.setUndertake("");
 	    }
 	   else if(type==8)//撤销一个人
	    {
 		   	lpro.setRemark("已执行撤销员工【"+delname+"】操作");
			ol.setOperate("已执行撤销员工【"+delname+"】操作");
			String people=xp.getPeople();
			xp.setPeople(people.replace(delname+"、","").replace("、"+delname,"").replace(delname,""));
	    }
 	    lprodao.merge(lpro);
		oldao.merge(ol);
		xpdao.merge(xp);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		pyh.process(xp);
		return result;
		
		
	}
}
