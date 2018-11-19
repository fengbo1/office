package office.pb2.action;

import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class YgxxShenpi {
	private String xuanze;
	private String number;
	private String textfield;
	private String radio;
	private String thisunder;
	private String message;
	private String thisnewnumber;
	private String thisundername;
	private static Logger logger = Logger.getLogger(YgxxShenpi.class);
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
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String execute() throws Exception
	{
		String result = "success";
		message = "审批成功";
		PbMxDAO pmdao = new PbMxDAO();
		XxsqPageDAO xpdao = new XxsqPageDAO();
		DateUtil du = new DateUtil();
		MyCalendarDAO mcdao = new MyCalendarDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessYgxxHz pyh = new ProcessYgxxHz();
		ProcessDAO pdao = new ProcessDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		XxsqPage xp = xpdao.findAllByNumber(number);
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			if(xuanze.contains("wu")&&radio.equals("agree"))
 			{
 				message = "失败，请选择下一级审批人!";
 				return "failed";
 			}
 			String time = du.getSimpleDateTime();
 			UserInfo ui = uidao.findByNewNumber(thisnewnumber);
 			
 			Process p = pdao.findByItemAndApplicant("YGXX", xp.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = xp.getJindu();
 			String under = xp.getUndertake();
 			
 			ol.setItem("KQQS");
 			ol.setName(thisundername);
 			ol.setNewnumber(thisnewnumber);
 			ol.setTime(du.getDateTime());
 			ol.setRemark(number);
 			
 			lpro.setNumber(number);
 			lpro.setTime(time);
 			lpro.setViewer(thisundername);
 			lpro.setViewernewnumber(thisnewnumber);
 			lpro.setAuthority(ui.getAuthority());
 			lpro.setRemark(textfield);
 			if((thisnewnumber.substring(0,8)).equals(under))
 			{
 				if(radio.equals("agree"))
 	 			{
 					String[] peoples = xp.getPeople().split("、");
 	 				lpro.setOpinion(1);
 	 				if((proc.length()-jindu.length())==1)//BOSS审批完毕，进入审批完毕
 	 				{
 	 					for(int i=0;i<peoples.length;i++)
 						{
 							List<MyCalendar> listmc = mcdao.findByBeginAndEnd(xp.getBegindate(),xp.getEnddate(), 2);
 							for(int j=0;j<listmc.size();j++)
 							{
 								MyCalendar mc = listmc.get(j);
 								PbMx pm = pmdao.findAllByNameAndDateNull(peoples[i], mc.getDate());
 		 						if(pm!=null)
 		 						{
 		 							if(xp.getHalfday()==0)//全天
 		 							{
 		 								//if(pm.getSw()==null&&)
 		 								pm.setSw("xx"+xp.getReason());
 		 								pm.setXw("xx"+xp.getReason());
 		 							}
 		 							else if(xp.getHalfday()==1)//第一天是下午
 		 							{
 		 								if(xp.getBegindate().equals(mc.getDate()))//第一天
 		 								{
 		 									pm.setXw("xx"+xp.getReason());
 		 								}
 		 								else
 		 								{
 		 									pm.setSw("xx"+xp.getReason());
 		 	 								pm.setXw("xx"+xp.getReason());
 		 								}
 		 							}
 		 							else if(xp.getHalfday()==2)//最后一天上午
 		 							{
 		 								if(xp.getEnddate().equals(mc.getDate()))//最后一天
 		 								{
 		 									pm.setSw("xx"+xp.getReason());
 		 								}
 		 								else
 		 								{
 		 									pm.setSw("xx"+xp.getReason());
 		 	 								pm.setXw("xx"+xp.getReason());
 		 								}
 		 							}
 		 							else if(xp.getHalfday()==3)//1+2
 		 							{
 		 								if(xp.getBegindate().equals(mc.getDate()))//第一天
 		 								{
 		 									pm.setXw("xx"+xp.getReason());
 		 								}
 		 								else if(xp.getEnddate().equals(mc.getDate()))//最后一天
 		 								{
 		 									pm.setSw("xx"+xp.getReason());
 		 								}
 		 								else
 		 								{
 		 									pm.setSw("xx"+xp.getReason());
 		 	 								pm.setXw("xx"+xp.getReason());
 		 								}
 		 							}
 		 							pmdao.merge(pm);
 		 						}
 							}
 						}
 	 					ol.setOperate("审批完毕,");
 	 					oldao.merge(ol);
 	 					xp.setPreundertake(thisnewnumber);
 	 					xp.setUndertake("");
 						xp.setStatus(4);
 						xp.setJindu(proc);
 						logger.debug(thisundername+"审批完毕"+xp.getNumber());
 	 				}
 	 				else
 	 				{
 	 					xp.setUndertake(xuanze);
 	 					xp.setJindu(xp.getJindu()+thisunder);
 	 					xp.setStatus(2);//流转中状态
 	 				}
 	 				
 						String date = xp.getDate();
 						
 	 				xp.setPreundertake(ui.getNewnumber());
 	 			}
 	 			else
 	 			{
 	 				lpro.setOpinion(2);
 	 				xp.setStatus(5);//修改为已退回状态
 	 				xp.setPreundertake(null);
 	 				xp.setUndertake(null);//下一处理人是自己
 	 			}
 	 			lprodao.merge(lpro);
 		 		xpdao.merge(xp);
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
		pyh.process(xp);
		return result;
	}
}
