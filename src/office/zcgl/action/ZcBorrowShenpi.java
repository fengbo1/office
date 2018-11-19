package office.zcgl.action;
import java.util.List;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.LeaveUtil;
import office.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import office.process.pojo.Process;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.dao.AssetBorrowDAO;
import office.zcgl.pojo.AssetBorrow;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import ccb.hibernate.HibernateSessionFactory;
public class ZcBorrowShenpi {

	private String thisunder;
	private String xuanze;
	private String number;
	private String textfield;
	private String radio;
	private String message;
	private String thisnewnumber;
	private String thisundername;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
		AssetBorrowDAO aydao = new AssetBorrowDAO();
		AssetTempDAO apdao = new AssetTempDAO();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();//审批意见写在leaveprocess中
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		time = du.getSimpleDateTime();
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
 			AssetBorrow ay = aydao.findAllByNumber(number);
 			List<AssetTemp> listap = apdao.findAllByNumber(number);
 			Process p = pdao.findByItemAndApplicant("ZCJY", ay.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = ay.getJindu();
 			String under = ay.getThisunder();//当前审批人
 			ol.setItem("ZCJY");
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
 					ay.setJindu(proc);
 					ay.setStatus(14);
 					ay.setThisunder("66191663");//
 					//changeassetinfo();
 					//wpdao.submitWcggPage(number);//更新汇总表
 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(ay.getInitiator())+"已更新");
 					oldao.merge(ol);
 				}
 				else
 				{
 					ay.setThisunder(xuanze);
 					ay.setJindu(ay.getJindu()+thisunder);
 					ay.setStatus(2);//流转中状态
 				}
 				ay.setPreunder(thisnewnumber);
 				}
 				else
 				{
 				lpro.setOpinion(2);
 				ay.setStatus(5);//修改为已退回状态
 				ay.setPreunder(null);
 				ay.setThisunder(null);//下一处理人是自己
 				ay.setJindu(ay.getJindu().substring(0,1));
 				}
 			
 				lprodao.merge(lpro);
 				 
 	 			aydao.merge(ay);
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
