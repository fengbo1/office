package office.uass.action;

import java.util.List;

import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
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

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UsptUnderDetail {

	private String number;
	private String undersign;
	private UassPt up;
	private List<LeaveProcess> listlp;
	private List<UserInfo> listui;
	private List<UassPtPeople> listupp;
	private int youshenpi;
	private UserInfo ui;
	private String position;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUndersign() {
		return undersign;
	}

	public void setUndersign(String undersign) {
		this.undersign = undersign;
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

	public List<UserInfo> getListui() {
		return listui;
	}

	public void setListui(List<UserInfo> listui) {
		this.listui = listui;
	}

	public int getYoushenpi() {
		return youshenpi;
	}

	public void setYoushenpi(int youshenpi) {
		this.youshenpi = youshenpi;
	}
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public String execute() throws Exception {
		DateUtil du = new DateUtil();
		UassPtDAO updao = new UassPtDAO();
		UassPtPeopleDAO uppdao = new UassPtPeopleDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		up = updao.findAllByNumber(number);
		listlp = lpdao.findAllByNumber(number);
		listupp = uppdao.findAllByNumber(number);
		listui = fnu.findNextUnder("USPT", number);
		ui = uidao.findByNewNumber(up.getInitiator());
		position = ui.getPosition();
		Process p = pdao.findByItemAndApplicant("USPT", up.getProcess());

		int jindulength = up.getJindu().length();
		String proc = p.getProcess();

		undersign = proc.substring(jindulength, jindulength + 1);

		if (listui.isEmpty()) {
			youshenpi = 0;
		} else {
			youshenpi = 1;
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
