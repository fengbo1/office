package office.tempxx.action;
import office.leave.pojo.LeavePage;
import office.leave.dao.LeavePageDAO;
import office.pb2.pojo.XxsqPage;
import office.pb2.dao.XxsqPageDAO;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.UserUtil;
import ccb.hibernate.HibernateSessionFactory;
import java.util.List;
import office.mycalendar.pojo.MyCalendar;
import office.mycalendar.dao.MyCalendarDAO;
import com.opensymphony.xwork2.ActionContext;
import office.tempxx.pojo.TPeoplework;
import office.tempxx.dao.TPeopleworkDAO;
public class ShowTip {
	private String opnumber;
	private String begindate;
	private String enddate;
	private String nowtime;
	private String newnumber;
	private String message;
	private String name;
	int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
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
	public String getOpnumber() {
		return opnumber;
	}
	public void setOpnumber(String opnumber) {
		this.opnumber = opnumber;
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
		if(type==1)
		{
			name=new String(name.getBytes("ISO8859-1"),"UTF-8");
			
		}	
		//name = java.net.URLDecoder.decode(name,"UTF-8"); 
		MyCalendarDAO mcdao=new MyCalendarDAO();
		MyCalendar mc = new MyCalendar();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		TPeoplework tw = new TPeoplework();
		TPeopleworkDAO twdao = new TPeopleworkDAO();
		LeavePage lp = new LeavePage();
		LeavePageDAO lpdao = new LeavePageDAO();
		XxsqPage xp = new XxsqPage();
		XxsqPageDAO xpdao = new XxsqPageDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    if(type==1)
 	    {
 	    	ui = uidao.findByName(name);
 	    }
 	    else
 	    {
 	    	ui = uidao.findByNewNumber(newnumber);
 	    }
 	    
 	   // ui = uidao.findByNewNumber(newnumber);
 	   // ui = uidao.findByOpnumber(opnumber);
 	    //String name = ui.getUsername();
 	    opnumber = ui.getOpnumber();
 	    String position = ui.getPosition();
 	    String chu = position.substring(2, 3);
 	    String zhi = position.substring(0, 1);
 	    String begindate1=begindate.replace("-","");
	    String enddate1=enddate.replace("-","");
 	    listmc=mcdao.findByBeginAndEnd(begindate1, enddate1, 1);
 	    int flag = 0;
 	    for(int i=0;i<listmc.size();i++)
 	    {
 	    	
 	    	mc=listmc.get(i);
 	    	tw = twdao.findAllByOpNumber(opnumber, mc.getDate());
 	    	if((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&!(zhi.equals("2"))&&!(zhi.equals("1")))
 	    	{
 	    		if((tw==null)||(tw.getStatus().equals("上线")))
 	  	 	    {
 	  	 	    	flag=flag+1;
 	  	 	    }
 	  	 	  
 	    	}	
 	 	   
 	    }
 	    if(((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&(zhi.equals("2")||zhi.equals("1")))||(chu.equals("1")||chu.equals("5")))
 	    {
 	    	flag=-1;
 	    }
 	    message = Integer.toString(flag);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
	
}
