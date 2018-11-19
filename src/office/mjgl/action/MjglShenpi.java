package office.mjgl.action;
import java.sql.Timestamp;

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

import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.dao.TMjglDAO;
import office.mjgl.pojo.TMjgl;
import office.mjgl.pojo.TMjglPage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class MjglShenpi {
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
		message = "审批成功";
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		TMjglDAO tmdao = new TMjglDAO();
		TMjglPage tp= new TMjglPage();
		TMjglPageDAO tpdao = new TMjglPageDAO();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();//审批意见写在leaveprocess中
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		String time = du.getSimpleDateTime();
		if(radio==null)
		{
			message = "失败！请选择审批意见";
			return "success";
		}
		if(xuanze!=null&&xuanze.contains("选择")&&radio.equals("agree"))
		{
			message = "失败！请选择下一级审批人";
			return "success";
		}
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(thisnewnumber);
 			TMjgl tm = tmdao.findAllByNumber(number);
 			String peoplesave=tm.getPeople();
 			Process p = pdao.findByItemAndApplicant("MJGL", tm.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = tm.getJindu();
 			String under = tm.getThisunder();//当前审批人
 			ol.setItem("MJGL");
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
 				
 			
 				if((proc.length()-jindu.length())==1)//门禁卡开通完毕
 				{
 					tm.setJindu(proc);
 					tm.setStatus(12);
 					tm.setThisunder("66191663");//下一个处理人门禁管理员
 					submitmjglpage(peoplesave,tm);
 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(tm.getInitiator())+"已更新");
 					oldao.merge(ol);
 				}
 				else
 				{
 					tm.setThisunder(xuanze);
 					tm.setJindu(tm.getJindu()+thisunder);
 					tm.setStatus(2);//流转中状态
 				}
 				  tm.setPreunder(thisnewnumber);
 				}
 				else
 				{
 				lpro.setOpinion(2);
 				tm.setStatus(5);//修改为已退回状态
 				tm.setPreunder(null);
 				tm.setThisunder(null);//下一处理人是自己
 				tm.setJindu(tm.getJindu().substring(0,1));
 				}
 		
 				lprodao.merge(lpro);
 	 			tmdao.merge(tm);
 			}
 			else
 			{
 				message = "失败！，您已经审批过该事项或您没有该事项审批权限！";
 			}
 			
 		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
 public void submitmjglpage(String peoplesave,TMjgl tmtemp)
	{   
	    TMjglPage tp1= new TMjglPage();
		TMjglPageDAO tpdao1 = new TMjglPageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo initiator = uidao.findByNewNumber(tmtemp.getInitiator()); 
 	    tp1=tpdao1.findAllByName(initiator.getUsername());
		
		if(tmtemp.getIstemp()==0)
		{
			tp1.setCurrentauth(tmtemp.getNewp());
			tp1.setCurrenttime(tmtemp.getNewtime());
			tp1.setRemark(tmtemp.getRemark1());
		}
		else
		{
			tp1.setTempauth(tmtemp.getTempauth());
			tp1.setTemptime(tmtemp.getRemark2());
			//tp1.setStartdate(tmtemp.getStartdate());
			//tp1.setEnddate(tmtemp.getEnddate());
			tp1.setRemark(tmtemp.getRemark1());
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
				tp.setCurrentauth(tmtemp.getNewp());
				tp.setCurrenttime(tmtemp.getNewtime());
				tp.setRemark(tmtemp.getRemark1());
			}
			else
			{
				tp.setTempauth(tmtemp.getTempauth());
				tp.setTemptime(tmtemp.getRemark2());
				tp.setRemark(tmtemp.getRemark1());
				//tp.setStartdateamorpm(tmtemp.getStartdateamorpm());
				//tp.setEnddateamorpm(tmtemp.getEnddateamorpam());
			}
			tpdao.merge(tp);
	    }
	    }
		
	}
}
