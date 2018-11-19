package office.mjgl.action;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.pojo.TMjglPage;
import office.mjgl.dao.TMjglDAO;
import office.mjgl.pojo.TMjgl;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.process.action.FindNextUnder;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

public class ViewMjglDetail {
	private String number;
	private String newnumber;
	private TMjgl tm;
	private List<LeaveProcess> listlp;
	private int queren;
	private int selfqueren;
	public int getSelfqueren() {
		return selfqueren;
	}
	public void setSelfqueren(int selfqueren) {
		this.selfqueren = selfqueren;
	}
	public int getQueren() {
		return queren;
	}
	public void setQueren(int queren) {
		this.queren = queren;
	}
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

	public TMjgl getTm() {
		return tm;
	}
	public void setTm(TMjgl tm) {
		this.tm = tm;
	}
	public String execute() throws Exception
	{
		TMjglDAO tmdao = new TMjglDAO();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    tm = tmdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
}
