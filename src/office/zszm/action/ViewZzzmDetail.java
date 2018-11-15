package office.zszm.action;
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

import office.zszm.dao.TZzzmDAO;
import office.zszm.pojo.TZzzm;

public class ViewZzzmDetail {
	private String number;
	private String newnumber;
	private TZzzm tz;
	private int queren;
	
	private List<LeaveProcess> listlp;
	private String bu;
	private String dai;
	private String position;
	private String begindate;
	private String enddate;
	private UserInfo ui;
	private String time;
	public int getQueren() {
		return queren;
	}
	public void setQueren(int queren) {
		this.queren = queren;
	}
	public TZzzm getTz() {
		return tz;
	}
	public void setTz(TZzzm tz) {
		this.tz = tz;
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
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String execute() throws Exception
	{
		TZzzmDAO tzdao = new TZzzmDAO();
		DateUtil du = new DateUtil();
        
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    tz= tzdao.findAllByNumber(number);
 	    time = du.getDate();
 	    listlp = lpdao.findAllByNumber(number);
 	    ui = uidao.findByNewNumber(tz.getApplicant());
		position = ui.getPosition();
 	    //bu =wp.getNumber().substring(13, 14);
 	    dai=tz.getNumber().substring(12, 13);
 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
}
