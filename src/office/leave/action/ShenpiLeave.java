package office.leave.action;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.LeaveUtil;

/**
 * 审批请假表
 * @author htzx
 *
 */
public class ShenpiLeave {

	private String thisunder;//当前审批人代号
	private String xuanze;//下一级审批人
	private String number;//请假单编号
	private String textfield;//审批意见
	private String radio;//审批决定
	private String jihua;
	private String message;
	private String thisnewnumber;
	private String newnumber;//当前审批人新一代编号
	private String bingzm;
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
	public String getThisnewnumber() {
		return thisnewnumber;
	}
	public void setThisnewnumber(String thisnewnumber) {
		this.thisnewnumber = thisnewnumber;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getJihua() {
		return jihua;
	}
	public void setJihua(String jihua) {
		this.jihua = jihua;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getBingzm() {
		return bingzm;
	}
	public void setBingzm(String bingzm) {
		this.bingzm = bingzm;
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
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		LeaveProcess lpro = new LeaveProcess();
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		DateUtil du = new DateUtil();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		String time = du.getSimpleDateTime();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(thisnewnumber);
 			UserInfo huizong = uidao.findAllByAuthority("H").get(0);//寻找惠总
 			LeavePage lp = lpdao.findByNumber(number);
 			int appli = lp.getProcess();//请假类别编号
 			Process p = pdao.findByItemAndApplicant("QJSQ", appli);
 			String proc = p.getProcess();//完整请假流程
 			String jindu = lp.getJindu();
 			String under = lp.getUndertake();
 			UserInfo un = uidao.findByNewNumber(under);
 			String[] arrayxz = xuanze.split(",");
// 			for(int i=0;i<arrayxz.length;i++)
// 			{
// 				
// 			}
 			ol.setItem("QJSQ");
 			//
 			ol.setName(thisundername);
 			ol.setNewnumber(thisnewnumber);
 			ol.setTime(du.getDateTime());
 			ol.setRemark(number);
 			
 			lpro.setNumber(number);
 			lpro.setTime(time);
 			//lpro.setViewer(ui.getUsername());
 			lpro.setViewer(thisundername);
 			lpro.setViewernewnumber(thisnewnumber);
 			lpro.setAuthority(thisunder);
 			lpro.setRemark(textfield);
 			if(bingzm!=null&&bingzm.equals("yes"))//如果提供了医院证明
			{
 				lpro.setRole("已见病休证明、病历原件及复印件。");
			}
 			if(bingzm!=null&&bingzm.equals("no"))//如果提供了医院证明
			{
 				lpro.setRole("未见病休证明、病历原件及复印件。");
			}
// 			
// 			if(radio.equals("agree")&&(xuanze.contains("wu"))&&(jihua==null||!jihua.equals("nei")))
// 			{
// 				message = "失败！请选择下一级审批人";
// 			}
// 			else if(lp.getStatus()==9&&lp.getType()==1&&bingzm==null)
// 			{
// 				message = "失败！请选择请假人是否出示医院纸质证明";
// 			}
 			if((newnumber.substring(0,8)).equals(under)&&thisundername.contains(un.getUsername()))
 			{
 				if(radio.equals("agree"))//审批人决定//1 通过 2 不通过
 				{
 					lpro.setOpinion(1);
 					if(lp.getStatus()==9&&lp.getType()==1)
 					{
 						lpro.setRemark(textfield);
 					}
// 	 				if(jihua!=null&&jihua.equals("nei"))//如果是计划内休假，跳过生产管理处
// 	 				{
// 	 					lp.setStatus(1);
// 	 					lp.setUndertake(huizong.getNewnumber());//当前承办人改为惠总
// 	 					lp.setJindu(lp.getJindu()+thisunder+"T");
// 	 				}
 	 				if((proc.length()-jindu.length())==1)//BOSS审批完毕，进入待销假状态
 	 				{
 	 					lp.setJindu(proc);
 	 					lp.setStatus(7);
 	 					lp.setUndertake(lp.getApplicant());//下一个处理人是申请人自己
 	 					lpdao.submitLeavePage(session,number);//审批完毕，更新汇总表状态
 	 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(lp.getApplicant())+LeaveUtil.TypeToString(lp.getType())+lp.getDays()+"已更新");
 	 					oldao.merge(ol);
 	 				}
 	 				else
 	 				{
 	 					if(xuanze.split(",")[0].contains("wu"))
 	 					{
 	 						lp.setUndertake(xuanze.split(",")[1]);
 	 					}
 	 					else
 	 					{
 	 						lp.setUndertake(xuanze.split(",")[0]);
 	 					}
 	 					//lp.setUndertake(xuanze.split(",")[0]);
 	 					lp.setJindu(lp.getJindu()+thisunder);
 	 					lp.setStatus(1);//流转中状态
 	 				}
 	 				lp.setPreundertake(thisnewnumber);
 				}
 				else
 				{
 					lpro.setOpinion(2);
 	 				lp.setStatus(4);//修改为已退回状态
 	 				lp.setPreundertake(null);
 	 				lp.setUndertake(null);//下一处理人是自己
 	 				lp.setJindu(lp.getJindu().substring(0,1));
 				}
 				lprodao.merge(lpro);
 	 			lpdao.merge(lp);
 			}
 			else
 			{
 				message = "失败！您已经审批过该事项或您没有该事项审批权限";
 			}
 		}catch (Exception e) {
			// TODO: handle exception
 			trans.rollback();
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
