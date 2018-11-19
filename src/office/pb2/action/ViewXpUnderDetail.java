package office.pb2.action;

import java.util.ArrayList;
import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.process.action.FindNextUnder;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.tempxx.dao.TPeopleworkDAO;
import office.tempxx.pojo.TPeoplework;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewXpUnderDetail {
	private String number;
	private String newnumber;
	private String username;
	private String undersign;
	private List<LeaveProcess> listlp;
	private XxsqPage xp;
	private int bu;
	private String begindate;
	private String enddate;
	private String nextunder;
	private int youshenpi;
	private List<UserInfo> listui;
	private int peoplenum;
	private int message;
	


	public int getPeoplenum() {
		return peoplenum;
	}


	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}


	public int getMessage() {
		return message;
	}


	public void setMessage(int message) {
		this.message = message;
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


	public XxsqPage getXp() {
		return xp;
	}


	public void setXp(XxsqPage xp) {
		this.xp = xp;
	}


	public int getBu() {
		return bu;
	}


	public void setBu(int bu) {
		this.bu = bu;
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
	
	public String getNextunder() {
		return nextunder;
	}


	public void setNextunder(String nextunder) {
		this.nextunder = nextunder;
	}

	public List<UserInfo> getListui() {
		return listui;
	}


	public void setListui(List<UserInfo> listui) {
		this.listui = listui;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUndersign() {
		return undersign;
	}


	public void setUndersign(String undersign) {
		this.undersign = undersign;
	}


	public int getYoushenpi() {
		return youshenpi;
	}


	public void setYoushenpi(int youshenpi) {
		this.youshenpi = youshenpi;
	}


	public String execute() throws Exception
	{ 
		
		XxsqPageDAO xpdao = new XxsqPageDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    listui = new ArrayList<UserInfo>();
 	    xp = xpdao.findAllByNumber(number);
 	    
 	    UserInfo uiviewer = uidao.findByNewNumber(newnumber);
 	    username = uiviewer.getUsername();
 	    listui = fnu.findNextUnder("YGXX", number);
 	    listlp = lpdao.findAllByNumber(number);
 	    Process p = pdao.findByItemAndApplicant("YGXX", xp.getProcess());
		
		int jindulength = xp.getJindu().length();
		String proc = p.getProcess();

		undersign = proc.substring(jindulength, jindulength + 1);

		if (listui.isEmpty()) {
			youshenpi = 0;
			nextunder="no";
		} else {
			youshenpi = 1;
			nextunder="yes";
		}
 	    bu = Integer.parseInt(number.substring(13, 14));//20160711KQQS00001
 	    begindate = xp.getBegindate().substring(0, 4)+"年"+xp.getBegindate().substring(4, 6)+"月"+xp.getBegindate().substring(6, 8)+"日";
		enddate = xp.getEnddate().substring(0, 4)+"年"+xp.getEnddate().substring(4, 6)+"月"+xp.getEnddate().substring(6, 8)+"日";
 	    istip(xp.getBegindate(),xp.getEnddate(),xp);
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
	public void istip (String begindate,String enddate,XxsqPage xp) 
	{
		message=0;
		String people = xp.getPeople();
		//name = java.net.URLDecoder.decode(name,"UTF-8");
		String names[] = people.split("、");
		MyCalendarDAO mcdao=new MyCalendarDAO();
		MyCalendar mc = new MyCalendar();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		TPeoplework tw = new TPeoplework();
		TPeopleworkDAO twdao = new TPeopleworkDAO();
	
 	   // ui = uidao.findByNewNumber(newnumber);
 	   // ui = uidao.findByOpnumber(opnumber);
 	    //String name = ui.getUsername();
 	    String begindate1=begindate.replace("-","");
	    String enddate1=enddate.replace("-","");
	    int flag = 0;
	    int bigday = 0;
	    int num = names.length;
	    List<MyCalendar> listmc;
 	    for(int i=0;i<names.length;i++)
 	    {
 	    	String name = names[i];
 	    	ui = uidao.findByName(name);
 	    	String opnumber = ui.getOpnumber();
 	 	    String position = ui.getPosition();
 	 	    String chu = position.substring(2, 3);
 	 	    String zhi = position.substring(0, 1);
 	 	    listmc=mcdao.findByBeginAndEnd(begindate1, enddate1, 1);
 	 	    
 	 	    for(int j=0;j<listmc.size();j++)
 	 	    {
 	 	    	
 	 	    	mc=listmc.get(j);
 	 	    	tw = twdao.findAllByOpNumber(opnumber, mc.getDate());
 	 	    	if((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&!(zhi.equals("2"))&&!(zhi.equals("1")))
 	 	    	{
 	 	    		if((tw==null)||(tw.getStatus().equals("上线")))
 	 	    	
 	 	  	 	    {
 	 	  	 	    	flag=flag+1;
 	 	  	 	    }
 	 	    	}
 	 	 	  
 	 	    }
 	 	    if(bigday<flag)
 	 	    {
 	 	        bigday=flag;	
 	 	    }
 	    }
 	    peoplenum = num;
 	    message = bigday;
 		
	}
}
