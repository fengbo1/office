package office.kqqs.action;

import java.util.List;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewKqqsDetail {
	private String number;
	private String newnumber;
	private KqqsPage kp;
	private List<LeaveProcess> listlp;
	private String position;
	private String qsdate;
	private int queren;
	private String dai;
	
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
	public KqqsPage getKp() {
		return kp;
	}
	public void setKp(KqqsPage kp) {
		this.kp = kp;
	}
	public List<LeaveProcess> getListlp() {
		return listlp;
	}
	public void setListlp(List<LeaveProcess> listlp) {
		this.listlp = listlp;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getQsdate() {
		return qsdate;
	}
	public void setQsdate(String qsdate) {
		this.qsdate = qsdate;
	}
	
	public int getQueren() {
		return queren;
	}
	public void setQueren(int queren) {
		this.queren = queren;
	}
	public String getDai() {
		return dai;
	}
	public void setDai(String dai) {
		this.dai = dai;
	}
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		KqqsPageDAO kpdao = new KqqsPageDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    kp = kpdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number);
 	    dai = number.substring(12, 13);//20160711KQQS00001
 	    UserInfo ui = uidao.findByNewNumber(kp.getApplicant());
		position = ui.getPosition();
		qsdate=du.simpleToStanderd(kp.getQsdate());
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
