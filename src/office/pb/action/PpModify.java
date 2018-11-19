package office.pb.action;

import office.pb.dao.TPbPeopleDAO;
import office.pb.pojo.TPbPeople;
import office.userinfo.dao.UserInfoDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.mycalendar.pojo.MyCalendar;
import office.mycalendar.dao.MyCalendarDAO;

public class PpModify {
	private int id;
	private int week;
	private String name;
	private String date;
	private int plan;
	private int isrest;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	public int getIsrest() {
		return isrest;
	}
	public void setIsrest(int isrest) {
		this.isrest = isrest;
	}
	public String execute() throws Exception
	{
		TPbPeopleDAO ppdao = new TPbPeopleDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		MyCalendar Mc = new MyCalendar();
    	MyCalendarDAO Mcdao = new MyCalendarDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		if(uidao.findByName(name)==null)
    		{
    			message = "失败！名字书写有误";
    			return "failed";
    		}
    		else
    		{
    			message = "修改成功";
    			TPbPeople pp = ppdao.findById(id);
    			Mc = Mcdao.findByDate(date);
				pp.setWeek(Mc.getWeek());
    			pp.setName(name);
    			pp.setDate(date.replace("-",""));
    			if(plan == 0)
				{
					pp.setIsrest(1);
				}
				if(plan == 1)
				{
					pp.setIsrest(0);
				}	
    		    pp.setPlan(plan);
    			ppdao.merge(pp);
    		}
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
}
