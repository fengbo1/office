package office.tempxx.action;

import java.util.List;

import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.tempxx.dao.TPeopleworkDAO;
import office.tempxx.pojo.TPeoplework;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowYgTip {
	private String begindate;
	private String enddate;
	private String nowtime;
	private String message;
	private String people;
	private String peoplenum;
    
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(String peoplenum) {
		this.peoplenum = peoplenum;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getNowtime() {
		return nowtime;
	}
	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	private List<MyCalendar> listmc;
	public List<MyCalendar> getListmc() {
		return listmc;
	}
	public void setListmc(List<MyCalendar> listmc) {
		this.listmc = listmc;
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
	public String execute() throws Exception
	{
		message="0";
		people=new String(people.getBytes("ISO8859-1"),"UTF-8");
		//name = java.net.URLDecoder.decode(name,"UTF-8");
		String names[] = people.split("、");
		MyCalendarDAO mcdao=new MyCalendarDAO();
		MyCalendar mc = new MyCalendar();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		TPeoplework tw = new TPeoplework();
		TPeopleworkDAO twdao = new TPeopleworkDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();

 	   // ui = uidao.findByNewNumber(newnumber);
 	   // ui = uidao.findByOpnumber(opnumber);
 	    //String name = ui.getUsername();
 	    String begindate1=begindate.replace("-","");
	    String enddate1=enddate.replace("-","");
	    int flag = 0;
	    int bigday = 0;
	    int num = 0;
 	    for(int i=0;i<names.length;i++)
 	    {
 	    	String name = names[i];
 	    	ui = uidao.findByName(name);
 	    	String opnumber = ui.getOpnumber();
 	 	    String position = ui.getPosition();
 	 	    String chu = position.substring(2, 3);
 	 	    String zhi = position.substring(0, 1);
 	 	    listmc=mcdao.findByBeginAndEnd(begindate1, enddate1, 1);
 	 	    flag=0;
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
 	 	    if(flag>0)
 	 	    {
 	 	    	num++;
 	 	    }
 	 	    if(bigday<flag)
 	 	    {
 	 	        bigday=flag;	
 	 	    }
 	    }
 	    peoplenum = Integer.toString(num);
 	    message = Integer.toString(bigday);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
