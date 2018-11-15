package office.kqqs.action;

import java.util.List;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.process.action.FindNextUnder;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewKqqsUnderDetail {
	private String number;
	private String undersign;
	private KqqsPage kp;
	private List<LeaveProcess> listlp;
	private List<UserInfo> listui;
	private int youshenpi;
	private String position;
	private String qsdate;

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
	public String getQsdate() {
		return qsdate;
	}

	public void setQsdate(String qsdate) {
		this.qsdate = qsdate;
	}

	public String execute() throws Exception {
		DateUtil du = new DateUtil();
		KqqsPageDAO kpdao = new KqqsPageDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		kp = kpdao.findAllByNumber(number);
		listlp = lpdao.findAllByNumber(number);
		listui = fnu.findNextUnder("KQQS", number);
		UserInfo ui = uidao.findByNewNumber(kp.getApplicant());
		position = ui.getPosition();
		Process p = pdao.findByItemAndApplicant("KQQS", kp.getProcess());

		int jindulength = kp.getJindu().length();
		String proc = p.getProcess();

		undersign = proc.substring(jindulength, jindulength + 1);

		if (listui.isEmpty()) {
			youshenpi = 0;
		} else {
			youshenpi = 1;
		}
		qsdate=du.simpleToStanderd(kp.getQsdate());
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
