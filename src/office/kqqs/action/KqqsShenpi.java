package office.kqqs.action;

import java.sql.Timestamp;
import java.util.List;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.kqjl.action.ImportKqjl;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.KqjlMonthDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlMonth;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.LeaveUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class KqqsShenpi {
	private String thisunder;
	private String xuanze;
	private String number;
	private String textfield;
	private String radio;
	private String message;
	private String thisnewnumber;
	private String thisundername;
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getXuanze() {
		return xuanze;
	}
	public void setXuanze(String xuanze) {
		this.xuanze = xuanze;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTextfield() {
		return textfield;
	}
	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getThisnewnumber() {
		return thisnewnumber;
	}
	public void setThisnewnumber(String thisnewnumber) {
		this.thisnewnumber = thisnewnumber;
	}
	public String getThisundername() {
		return thisundername;
	}
	public void setThisundername(String thisundername) {
		this.thisundername = thisundername;
	}
	public String execute() throws Exception
	{
		String result = "success";
		int x = 0;
		message = "审批成功";
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		KqqsPageDAO kpdao = new KqqsPageDAO();
		ImportKqjl ik = new ImportKqjl();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();//审批意见写在leaveprocess中
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		String time = du.getSimpleDateTime();
		if(xuanze.contains("选择")&&radio.equals("agree"))
		{
			message = "失败，请选择下一级审批人!";
			return "failed";
		}
		UserInfo ui = uidao.findByNewNumber(thisnewnumber);
		KqqsPage kp = kpdao.findAllByNumber(number);
		UserInfo uishenqing = uidao.findByNewNumber(kp.getApplicant());
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			
 			
 			Process p = pdao.findByItemAndApplicant("KQQS", kp.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = kp.getJindu();
 			String under = kp.getThisunder();
 			ol.setItem("KQQS");
 			ol.setName(thisundername);
 			ol.setNewnumber(thisnewnumber);
 			ol.setTime(du.getDateTime());
 			ol.setRemark(number);
 			
 			lpro.setNumber(number);
 			lpro.setTime(time);
 			lpro.setViewer(thisundername);
 			lpro.setViewernewnumber(thisnewnumber);
 			lpro.setAuthority(thisunder);
 			lpro.setRemark(textfield);
 			if((thisnewnumber.substring(0,8)).equals(under))
 			{
 				if(radio.equals("agree"))//审批人决定//1 通过 2 不通过
 				{
 					lpro.setOpinion(1);
 	 				if((proc.length()-jindu.length())==1)//BOSS审批完毕，进入审批完毕
 	 				{
 	 					kp.setJindu(proc);
 	 					kp.setStatus(7);
 	 					kp.setThisunder(kp.getApplicant());//下一个处理人是申请人自己
 	 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(kp.getApplicant())+kp.getQsdate()+kp.getQstime()+"已更新");
 	 					oldao.merge(ol);
 	 					updateMonthByKqqs(session,kp);
 	 					x=1;
 	 				}
 	 				else
 	 				{
 	 					kp.setThisunder(xuanze);
 	 					kp.setJindu(kp.getJindu()+thisunder);
 	 					kp.setStatus(2);//流转中状态
 	 				}
 	 				kp.setPreunder(thisnewnumber);
 				}
 				else
 				{
 					lpro.setOpinion(2);
 	 				kp.setStatus(5);//修改为已退回状态
 	 				kp.setPreunder(null);
 	 				kp.setThisunder(null);//下一处理人是自己
 	 				kp.setJindu(kp.getJindu().substring(0,1));
 	 				//在被退回时次数减1
 	 				List<KqqsPage> listkp = kpdao.findAllByQsMonthAndNewnumber(kp.getQsdate().substring(0, 6),kp.getApplicant());
 	 				if((!listkp.isEmpty()))
 	 				{
 	 					if(listkp.size()>0)
 	 					{
 	 						for(int i=0;i<listkp.size();i++)
 	 						{
 	 							KqqsPage kptemp  = listkp.get(i);
 	 							kptemp.setCs(i+1);
 	 						}
 	 						
 	 					}
 	 				}
 	 				kp.setCs(null);
 				}
 				lprodao.merge(lpro);
 	 			kpdao.merge(kp);
 			}
 			else
 			{
 				message = "失败！，您已经审批过该事项或您没有该事项审批权限！";
 			}
 			
 		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		if(x==1)
		{
			//修正t_kqjl_month
			Session session1 = HibernateSessionFactory.getSession();
	 	    Transaction trans1=session1.beginTransaction();
			ik.countkqjlMonthByNameNull(session1, uishenqing.getUsername(), kp.getQsdate().substring(0, 6));
			trans1.commit();
			session1.flush();
			session1.clear();
			session1.close();
			
			Session session2 = HibernateSessionFactory.getSession();
	 	    Transaction trans2=session2.beginTransaction();
			String sql = "update t_kqjl_month set yc=1 where month='"+kp.getQsdate().substring(0, 6)+"' and workdays<>(zhiwendays+qjdays+ggdays+chidao/2+zaotui/2+bukq/2)";
    		System.out.println(sql);
    		session2.createSQLQuery(sql).executeUpdate();
    		sql = "update t_kqjl_month set yc=0 where month='"+kp.getQsdate().substring(0, 6)+"' and workdays=(zhiwendays+qjdays+ggdays+chidao/2+zaotui/2+bukq/2)";
    		System.out.println(sql);
    		session2.createSQLQuery(sql).executeUpdate();
    		trans2.commit();
			session2.flush();
			session2.clear();
			session2.close();
		}
		return result;
	}
	
	public String updateMonthByKqqs(Session session,KqqsPage kp)
	{
		ImportKqjl ik = new ImportKqjl();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(kp.getApplicant());
		KqjlDaily kd = kddao.findByDateAndNameNull(kp.getQsdate(),ui.getUsername());
		if(kd!=null)
		{
			String yearmonth = kp.getQsdate().substring(0, 6);
			//修正t_kqjl_daily
			if(kp.getQdqt()==1||kp.getQdqt()==3)//上午缺失
			{
				kd.setQdqs(3);
				kd.setQdtime(kp.getQstime()+":00");
			}
			if(kp.getQdqt()==2||kp.getQdqt()==3)//下午缺失
			{
				kd.setQtqs(3);
				kd.setQttime(kp.getQstime()+":00");
			}
			kddao.merge(kd);
		}
		return message;
	}
}
