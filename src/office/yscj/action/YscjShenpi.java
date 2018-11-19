package office.yscj.action;
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
import office.yscj.dao.TYscjtzDAO;
import office.yscj.pojo.TYscjtz;
import office.yscj.dao.TYscjDAO;
import office.yscj.pojo.TYscj;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class YscjShenpi {
	private String thisunder;
	private String xuanze;
	private String number;
	private String textfield;
	private String radio;
	private String message;
	private String thisnewnumber;
	private String thisundername;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
		TYscjDAO tydao = new TYscjDAO();
		DateUtil du = new DateUtil();
		TYscjtzDAO tzdao = new TYscjtzDAO();
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
 			TYscj ty = tydao.findAllByNumber(number);
 			Process p = pdao.findByItemAndApplicant("YSCJ", ty.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = ty.getJindu();
 			String under = ty.getThisunder();//当前审批人
 			ol.setItem("YSCJ");
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
 				if((proc.length()-jindu.length())==1)//BOSS审批完毕，进入待领取护照状态
 				{
 					ty.setJindu(proc);
 					ty.setStatus(8);
 					ty.setThisunder("89207003");//下一个处理人是因私出境管理员
 					//wpdao.submitWcggPage(number);//更新汇总表
 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(ty.getApplicant())+"已更新");
 					oldao.merge(ol);
 					TYscjtz tz = new TYscjtz();
 					UserInfo uitz = uidao.findByNewNumber(ty.getApplicant());
 		 	    	tz.setNumber(ty.getNumber());
 		 	    	tz.setDate(ty.getDate());
 		 	    	tz.setName(username);
 		 	    	tz.setTocountry(ty.getTocountry());
 		 	    	tz.setSumday(ty.getSumday());
 		 	    	tz.setBegindate(ty.getBegindate());
 		 	    	tz.setEnddate(ty.getEnddate());
 		 	    	tz.setStatus(10);
 		 	     	if(ty.getPassporttype()==1)
 			    	{
 			    		tz.setPassporttype("护照");
 			    	
 			    	}	
 			    	else if (ty.getPassporttype()==2)
 			    	{
 			    		tz.setPassporttype("港澳通行证");
 			    	}
 			    	else if(ty.getPassporttype()==3)
 			    	{
 			    		tz.setPassporttype("台湾通行证");
 			    	}
 		 	     	if(ty.getPassporttype()==1)
 			    	{
 		 	     		tz.setPassportnumber(uitz.getPassport());
 			    	
 			    	}	
 			    	else if (ty.getPassporttype()==2)
 			    	{
 			    		tz.setPassportnumber(uitz.getHkpassport());
 			    	}
 			    	else if(ty.getPassporttype()==3)
 			    	{
 			    		tz.setPassportnumber(uitz.getTwpassport());
 			    	}
 			    	
 		 	    	if(ty.getReason()==1)
 		 	    	{
 		 	    		tz.setReason("旅游");
 		 	    	
 		 	    	}	
 		 	    	else if (ty.getReason()==2)
 		 	    	{
 		 	    		tz.setReason("探亲");
 		 	    	}
 		 	    	else if(ty.getReason()==3)
 		 	    	{
 		 	    		tz.setReason("访友");
 		 	    	}
 		 	    	else if (ty.getReason()==4)
 		 	    	{
 		 	    		tz.setReason("其他");
 		 	    	}
 		 	    
 		 			tzdao.merge(tz);
 				}
 				else
 				{
 					ty.setThisunder(xuanze);
 					ty.setJindu(ty.getJindu()+thisunder);
 					ty.setStatus(2);//流转中状态
 				}
 				ty.setPreunder(thisnewnumber);
 				}
 				else
 				{
 				lpro.setOpinion(2);
 				ty.setStatus(5);//修改为已退回状态
 				ty.setPreunder(null);
 				ty.setThisunder(null);//下一处理人是自己
 				ty.setJindu(ty.getJindu().substring(0,1));
 				}
 			
 				lprodao.merge(lpro);
 				
 	 			tydao.merge(ty);
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
}
