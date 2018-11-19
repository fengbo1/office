package office.srzm.action;
import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.process.action.FindNextUnder;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import office.srzm.dao.TSrzmDAO;

import office.srzm.pojo.TSrzm;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
public class ViewSrzmUnderDetail {
	private String number;
	private String undersign;
	private TSrzm tz;
	
	private List<LeaveProcess> listlp;
	private List<UserInfo> listui;
	private int youshenpi;
	private String position;
	private UserInfo ui;
	private String time;
	private String dai;

	
	public TSrzm getTz() {
		return tz;
	}
	public void setTz(TSrzm tz) {
		this.tz = tz;
	}
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
		DateUtil du = new DateUtil();
		TSrzmDAO tzdao = new TSrzmDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    tz = tzdao.findAllByNumber(number);
 	
	    dai=tz.getNumber().substring(12, 13);
 	    
 	    listlp = lpdao.findAllByNumber(number);
 	  	listui = fnu.findNextUnder("SRZM", number);
 	  	ui = uidao.findByNewNumber(tz.getApplicant());
		position = ui.getPosition();
 	  	Process p = pdao.findByItemAndApplicant("SRZM",tz.getProcess());
 	  	time = du.getDate();
 	  	int jindulength = tz.getJindu().length();
 	  	String proc = p.getProcess();
 	  	
 	  	undersign = proc.substring(jindulength, jindulength+1);
 	  	
 	  	if(listui.isEmpty())
 	  	{
 	  		youshenpi = 0;
 	  	}
 	  	else
 	  	{
 	  		youshenpi = 1;
 	  	}
 	 
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
