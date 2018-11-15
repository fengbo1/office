package office.pb2.action;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class TbsqShenpi {

	private String xuanze;
	private String number;
	private String textfield;
	private String radio;
	private String message;
	private String thisnewnumber;
	private String thisundername;
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
		PbMxDAO pmdao = new PbMxDAO();
		TbsqPageDAO tpdao = new TbsqPageDAO();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		UserInfoDAO uidao = new UserInfoDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			String time = du.getSimpleDateTime();
 			UserInfo ui = uidao.findByNewNumber(thisnewnumber);
 			UserInfo uixz = uidao.findByNewNumber(xuanze);//下一级审批人
 			TbsqPage tp = tpdao.findAllByNumber(number);
 			UserInfo uifq = uidao.findByNewNumber(tp.getApplicant());
 			PbMx pmfq = pmdao.findAllByNameAndDateNull(uifq.getUsername(),tp.getTbdate());
 			PbMx pmtb = pmdao.findAllByNameAndDateNull(tp.getTbname(),tp.getTbdate());
 			ol.setItem("TBSQ");
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
 			if(radio.equals("agree"))
 			{
 				lpro.setOpinion(1);
// 				if(tp.getStatus()==1)
// 				{
// 					tp.setUndertake(xuanze);
// 					tp.setStatus(2);
// 				}
 				if(ui.getAuthority().contains("T"))//审批完毕
 				{
 					String tempsb = "";
 					String tempxb = "";
 					String tempzy = "";
 					String temppx = "";
 					int tempwb=0;
 					tp.setUndertake(tp.getInitiator());
 					tp.setStatus(7);
 					tempsb = pmfq.getPbqdtime();
 					tempxb = pmfq.getPbqttime();
 					tempzy = pmfq.getZytime();
 					temppx = pmfq.getPxtime();
 					tempwb = pmfq.getWb();
 					pmfq.setPbqdtime(pmtb.getPbqdtime());
 					pmfq.setPbqttime(pmtb.getPbqttime());
 					pmfq.setZytime(pmtb.getZytime());
 					pmfq.setPxtime(pmtb.getPxtime());
 					pmfq.setTb(tp.getTbname());
 					pmfq.setWb(pmtb.getWb());
 					
 					pmtb.setPbqdtime(tempsb);
 					pmtb.setPbqttime(tempxb);
 					pmtb.setZytime(tempzy);
 					pmtb.setPxtime(temppx);
 					pmtb.setTb(uifq.getUsername());
 					pmtb.setWb(tempwb);
 					
 					pmdao.merge(pmtb);
 					pmdao.merge(pmfq);
 				}
 				else//还有下一级审批人
 				{
 					tp.setUndertake(xuanze);
 					tp.setStatus(2);
 				}
 				tp.setPreundertake(ui.getNewnumber());
 			}
 			else
 			{
 				lpro.setOpinion(2);
 				tp.setStatus(5);//修改为已退回状态
 				tp.setPreundertake(null);
 				tp.setUndertake(null);//下一处理人是自己
 			}
 			lprodao.merge(lpro);
	 		tpdao.merge(tp);
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
