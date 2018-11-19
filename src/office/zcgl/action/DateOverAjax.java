package office.zcgl.action;

import org.hibernate.Session;
import org.hibernate.Transaction;
import office.util.DateUtil;
import ccb.hibernate.HibernateSessionFactory;

public class DateOverAjax { 
  private String returntime;
  private double days;
  
public double getDays() {
	return days;
}

public void setDays(double days) {
	this.days = days;
}

public String getReturntime() {
	return returntime;
}

public void setReturntime(String returntime) {
	this.returntime = returntime;
}

public String execute() throws Exception
{
	 DateUtil du = new DateUtil();
	 String nowdate = du.getStringDate();
	 String bd = nowdate.replace("-","");
	 String ed = returntime.replace("-","");
		
	 Session session = HibernateSessionFactory.getSession();
	 Transaction trans=session.beginTransaction();
	 days = du.getDaysByBegindateAndEnddate(session,bd,ed);
	 trans.commit();
	 session.flush();
	 session.clear();
	 session.close();
	
	return "success";
}
}
