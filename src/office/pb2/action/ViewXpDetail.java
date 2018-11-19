package office.pb2.action;

import java.util.List;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewXpDetail {

	private String number;
	private String newnumber;
	private List<LeaveProcess> listlp;
	private XxsqPage xp;
	private int bu;
	private String begindate;
	private String enddate;
	
	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public List<LeaveProcess> getListlp() {
		return listlp;
	}


	public void setListlp(List<LeaveProcess> listlp) {
		this.listlp = listlp;
	}


	public XxsqPage getXp() {
		return xp;
	}


	public void setXp(XxsqPage xp) {
		this.xp = xp;
	}


	public int getBu() {
		return bu;
	}


	public void setBu(int bu) {
		this.bu = bu;
	}


	public String getBegindate() {
		return begindate;
	}


	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public String execute() throws Exception
	{ 
		
		XxsqPageDAO xpdao = new XxsqPageDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    xp = xpdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number);
 	    bu = Integer.parseInt(number.substring(13, 14));//20160711KQQS00001
 	    begindate = xp.getBegindate().substring(0, 4)+"年"+xp.getBegindate().substring(4, 6)+"月"+xp.getBegindate().substring(6, 8)+"日";
		enddate = xp.getEnddate().substring(0, 4)+"年"+xp.getEnddate().substring(4, 6)+"月"+xp.getEnddate().substring(6, 8)+"日";
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
