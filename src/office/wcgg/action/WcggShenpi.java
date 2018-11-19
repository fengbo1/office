package office.wcgg.action;

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
import office.wcgg.dao.WcggBaodaoDAO;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.dao.WcggSummaryDAO;
import office.wcgg.pojo.WcggPage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class WcggShenpi {

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
		WcggPageDAO wpdao = new WcggPageDAO();
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
 			WcggPage wp = wpdao.findAllByNumber(number);
 			Process p = pdao.findByItemAndApplicant("WCGG", wp.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = wp.getJindu();
 			String under = wp.getThisunder();//当前审批人
 			ol.setItem("WCGG");
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
 				if((proc.length()-jindu.length())==1)//BOSS审批完毕，进入待报道状态
 				{
 					wp.setJindu(proc);
 					wp.setStatus(3);
 					wp.setThisunder(wp.getApplicant());//下一个处理人是申请人自己
 					wpdao.submitWcggPage(number);//更新汇总表
 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(wp.getApplicant())+wp.getDays()+"已更新");
 					oldao.merge(ol);
 				}
 				else
 				{
 					wp.setThisunder(xuanze);
 					wp.setJindu(wp.getJindu()+thisunder);
 					wp.setStatus(2);//流转中状态
 				}
 				wp.setPreunder(thisnewnumber);
 				}
 				else
 				{
 				lpro.setOpinion(2);
 				wp.setStatus(5);//修改为已退回状态
 				wp.setPreunder(null);
 				wp.setThisunder(null);//下一处理人是自己
 				wp.setJindu(wp.getJindu().substring(0,1));
 				}
 			
 				lprodao.merge(lpro);
 	 			wpdao.merge(wp);
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
