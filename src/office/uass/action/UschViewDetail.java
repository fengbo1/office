package office.uass.action;

import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostHnPeopleDAO;
import office.uass.dao.UassPtDAO;
import office.uass.dao.UassPtPeopleDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostHnPeople;
import office.uass.pojo.UassPt;
import office.uass.pojo.UassPtPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UschViewDetail {
	private String number;
	private String newnumber;
	private UassCostHn up;
	private List<LeaveProcess> listlp;
	private List<UassCostHnPeople> listupp;
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

	public UassCostHn getUp() {
		return up;
	}

	public void setUp(UassCostHn up) {
		this.up = up;
	}

	public List<LeaveProcess> getListlp() {
		return listlp;
	}

	public void setListlp(List<LeaveProcess> listlp) {
		this.listlp = listlp;
	}

	public List<UassCostHnPeople> getListupp() {
		return listupp;
	}

	public void setListupp(List<UassCostHnPeople> listupp) {
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
		UassCostHnDAO updao = new UassCostHnDAO();
		UassCostHnPeopleDAO uppdao = new UassCostHnPeopleDAO();
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
