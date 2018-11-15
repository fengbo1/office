package office.jbsp.action;

import java.util.List;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggPage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewJbspDetail {
	private String number;
	private String newnumber;
	private JbspPage jp;
	private List<LeaveProcess> listlp;
	private String bu;
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
	public JbspPage getJp() {
		return jp;
	}
	public void setJp(JbspPage jp) {
		this.jp = jp;
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
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		JbspPageDAO jpdao = new JbspPageDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    jp = jpdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number);
 	    bu = jp.getNumber().substring(13, 14);
 	    UserInfo ui = uidao.findByNewNumber(jp.getApplicant());
		position = ui.getPosition();
		begindate=du.simpleToStanderd(jp.getBegindate());
	    enddate=du.simpleToStanderd(jp.getEnddate());
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
