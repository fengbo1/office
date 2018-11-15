package office.jbsp.action;

import java.sql.Timestamp;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.mycalendar.dao.MyCalendarDAO;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.LeaveUtil;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggPage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class JbspShenpi {

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
		JbspPageDAO jpdao = new JbspPageDAO();
		DateUtil du = new DateUtil();
		MyCalendarDAO mcdao = new MyCalendarDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		OperateLogDAO oldao = new OperateLogDAO();
		OperateLog ol = new OperateLog();
		String time = du.getSimpleDateTime();
		if(radio==null)
		{
			message = "请选择审批意见";
			return "success";
		}
		if(xuanze!=null&&xuanze.contains("选择")&&radio.equals("agree"))
		{
			message = "请选择下一级审批人";
			return "success";
		}
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(thisnewnumber);
 			JbspPage jp = jpdao.findAllByNumber(number);
 			Process p = pdao.findByItemAndApplicant("JBSP", jp.getProcess());
 			String proc = p.getProcess();
 			String jindu = jp.getJindu();
 			String under = jp.getThisunder();
 			ol.setItem("JBSP");
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
 				if(radio.equals("agree"))
 				{
 				lpro.setOpinion(1);
 				if((proc.length()-jindu.length())==1)
 				{
 					jp.setJbdays(mcdao.findJbdaysByBeginAndEnd(jp.getBegindate(),jp.getEnddate(),jp.getHalfday()));
 					jp.setDidays(0.0);
 					jp.setJindu(proc);
 					jp.setStatus(4);
 					jp.setThisunder("");
 					jpdao.submitJbspPage(number);
 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(jp.getApplicant())+jp.getDays()+"已更新");
 					oldao.merge(ol);
 				}
 				else
 				{
 					jp.setThisunder(xuanze);
 					jp.setJindu(jp.getJindu()+thisunder);
 					jp.setStatus(2);
 				}
 				jp.setPreunder(thisnewnumber);
 				}
 				else
 				{
 				lpro.setOpinion(2);
 				jp.setStatus(5);
 				jp.setPreunder(null);
 				jp.setThisunder(null);
 				jp.setJindu(jp.getJindu().substring(0,1));
 				}
 			
 				lprodao.merge(lpro);
 	 			jpdao.merge(jp);
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
		
		return result;
	}
}
