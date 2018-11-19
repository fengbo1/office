package office.uass.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.process.action.FindNextUnder;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.uass.dao.UassPtDAO;
import office.uass.dao.UassPtPeopleDAO;
import office.uass.pojo.UassPt;
import office.uass.pojo.UassPtPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

public class UsptViewDetail {

	private String number;
	private String newnumber;
	private UassPt up;
	private List<LeaveProcess> listlp;
	private List<UassPtPeople> listupp;
	private UserInfo ui;
	private String position;
	private int queren;
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
	public UassPt getUp() {
		return up;
	}
	public void setUp(UassPt up) {
		this.up = up;
	}
	public List<LeaveProcess> getListlp() {
		return listlp;
	}
	public void setListlp(List<LeaveProcess> listlp) {
		this.listlp = listlp;
	}
	public List<UassPtPeople> getListupp() {
		return listupp;
	}
	public void setListupp(List<UassPtPeople> listupp) {
		this.listupp = listupp;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getQueren() {
		return queren;
	}
	public void setQueren(int queren) {
		this.queren = queren;
	}
	public String execute() throws Exception {
		UassPtDAO updao = new UassPtDAO();
		UassPtPeopleDAO uppdao = new UassPtPeopleDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		up = updao.findAllByNumber(number);
		listlp = lpdao.findAllByNumber(number);
		listupp = uppdao.findAllByNumber(number);
		ui = uidao.findByNewNumber(up.getInitiator());
		position = ui.getPosition();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
