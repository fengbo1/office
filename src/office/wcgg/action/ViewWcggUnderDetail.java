package office.wcgg.action;

import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.process.action.FindNextUnder;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.wcgg.dao.WcggBaodaoDAO;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggBaodao;
import office.wcgg.pojo.WcggPage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewWcggUnderDetail {
	private String number;
	private String undersign;
	private WcggPage wp;
	private List<WcggBaodao> listwb;
	private List<LeaveProcess> listlp;
	private List<UserInfo> listui;
	private int youshenpi;
	private String position;
	private String begindate;
	private String enddate;
	private String dai;
	private String bu;
	
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
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		WcggPageDAO wpdao = new WcggPageDAO();
		WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    wp = wpdao.findAllByNumber(number);
 	    bu =wp.getNumber().substring(13, 14);
	    dai=wp.getNumber().substring(12, 13);
 	    listwb = wbdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number);
 	  	listui = fnu.findNextUnder("WCGG", number);
 	  	UserInfo ui = uidao.findByNewNumber(wp.getApplicant());
		position = ui.getPosition();
 	  	Process p = pdao.findByItemAndApplicant("WCGG",wp.getProcess());
 	    
 	  	int jindulength = wp.getJindu().length();
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
 	  	begindate=du.simpleToStanderd(wp.getBegindate());
	    enddate=du.simpleToStanderd(wp.getEnddate());
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
