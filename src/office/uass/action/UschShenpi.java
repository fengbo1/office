package office.uass.action;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostHnPeopleDAO;
import office.uass.dao.UassPtDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassPt;
import office.util.DateUtil;
import office.util.LeaveUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UschShenpi {
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
		UassCostHnDAO updao = new UassCostHnDAO();
		UassCostHnPeopleDAO uchpdao = new UassCostHnPeopleDAO();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();//审批意见写在leaveprocess中
		ProcessDAO pdao = new ProcessDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		String time = du.getSimpleDateTime();
		if(xuanze.contains("选择")&&radio.equals("agree"))
		{
			message = "失败，请选择下一级审批人!";
			return "failed";
		}
		UassCostHn up = updao.findAllByNumber(number);
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			Process p = pdao.findByItemAndApplicant("USCH", up.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = up.getJindu();
 			String under = up.getUndertake();
 			ol.setItem("USCH");
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
 	 					up.setJindu(proc);
 	 					up.setStatus(16);
 	 					up.setUndertake("");//下一个处理人是无
 	 					//updao.submitUassCostHn(number);
 	 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(up.getApplicant()));
 	 					oldao.merge(ol);
 	 				}
 	 				else
 	 				{
 	 					up.setUndertake(xuanze);
 	 					up.setJindu(up.getJindu()+thisunder);
 	 					up.setStatus(2);//流转中状态
 	 				}
 	 				up.setPreundertake(thisnewnumber);
 				}
 				else
 				{
 					lpro.setOpinion(2);
 	 				up.setStatus(5);//修改为已退回状态
 	 				up.setPreundertake(null);
 	 				up.setUndertake(null);//下一处理人是自己
 	 				up.setJindu(up.getJindu().substring(0,1));
 	 				//在被退回时次数减1
 				}
 				lprodao.merge(lpro);
 	 			updao.merge(up);
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
