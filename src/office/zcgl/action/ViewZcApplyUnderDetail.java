package office.zcgl.action;
import java.util.List;

import office.process.action.FindNextUnder;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import office.process.pojo.Process;
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.pojo.AssetApply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import ccb.hibernate.HibernateSessionFactory;
public class ViewZcApplyUnderDetail {
	private String number;
	private String undersign;
	private AssetApply ay;
	private List<AssetTemp> listap;
	private List<LeaveProcess> listlp;
	private List<UserInfo> listui;
	private int youshenpi;
	private String position;
	private UserInfo ui;
	private String time;
	
	public AssetApply getAy() {
		return ay;
	}
	public void setAy(AssetApply ay) {
		this.ay = ay;
	}
	public List<AssetTemp> getListap() {
		return listap;
	}
	public void setListap(List<AssetTemp> listap) {
		this.listap = listap;
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
		AssetApplyDAO aydao = new AssetApplyDAO();
		AssetTempDAO apdao = new AssetTempDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    ay= aydao.findAllByNumber(number);
	    listap = apdao.findAllByNumber(number);
 	    
 	    listlp = lpdao.findAllByNumber(number);
 	  	listui = fnu.findNextUnder("ZCSL", number);
 	  	ui = uidao.findByNewNumber(ay.getInitiator());
		position = ui.getPosition();
 	  	Process p = pdao.findByItemAndApplicant("ZCSL",ay.getProcess());
 	  	time = du.getDate();
 	  	int jindulength = ay.getJindu().length();
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
