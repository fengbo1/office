package office.wcgg.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.process.action.FindNextUnder;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.wcgg.dao.WcggBaodaoDAO;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggBaodao;
import office.wcgg.pojo.WcggPage;

public class ViewWcggDetail {

	private String number;
	private String newnumber;
	private WcggPage wp;
	private List<WcggBaodao> listwb;
	private List<LeaveProcess> listlp;
	private String bu;
	private String dai;
	private String position;
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
	public WcggPage getWp() {
		return wp;
	}
	public void setWp(WcggPage wp) {
		this.wp = wp;
	}
	public List<WcggBaodao> getListwb() {
		return listwb;
	}
	public void setListwb(List<WcggBaodao> listwb) {
		this.listwb = listwb;
	}
	public List<LeaveProcess> getListlp() {
		return listlp;
	}
	public void setListlp(List<LeaveProcess> listlp) {
		this.listlp = listlp;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	public String getDai() {
		return dai;
	}
	public void setDai(String dai) {
		this.dai = dai;
	}
	public String execute() throws Exception
	{
		WcggPageDAO wpdao = new WcggPageDAO();
		DateUtil du = new DateUtil();
		WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    wp = wpdao.findAllByNumber(number);
 	    listwb = wbdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number);
 	    UserInfo ui = uidao.findByNewNumber(wp.getApplicant());
		position = ui.getPosition();
 	    bu =wp.getNumber().substring(13, 14);
 	    dai=wp.getNumber().substring(12, 13);
 	    begindate=du.simpleToStanderd(wp.getBegindate());
 	    enddate=du.simpleToStanderd(wp.getEnddate());
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
	
}
