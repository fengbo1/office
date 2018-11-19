package office.yscj.action;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.ActionContext;
import ccb.hibernate.HibernateSessionFactory;
import office.leave.dao.LeavePageDAO;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.util.DateUtil;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.UserUtil;
import office.mycalendar.pojo.MyCalendar;
import office.mycalendar.dao.MyCalendarDAO;
public class YscjIsWorkday {
	private String zhiwu;
	private List<MyCalendar> listmc;
	private String sex;
	private int age;
	private String identity;
	private String zxdate;
	private String hukou;
	private String email;
	private String contactpeople;
	private String contactpeopletel;
	private boolean category1;
	private boolean category2;
	private int afterworkday;
	private int beforeworkday;
	private int notholiday;
	public int getNotholiday() {
		return notholiday;
	}
	public void setNotholiday(int notholiday) {
		this.notholiday = notholiday;
	}
	public int getAfterworkday() {
		return afterworkday;
	}
	public void setAfterworkday(int afterworkday) {
		this.afterworkday = afterworkday;
	}
	public int getBeforeworkday() {
		return beforeworkday;
	}
	public void setBeforeworkday(int beforeworkday) {
		this.beforeworkday = beforeworkday;
	}
	public void setCategory1(boolean category1) {
		this.category1 = category1;
	}
	public void setCategory2(boolean category2) {
		this.category2 = category2;
	}
	
	private int rg1;
	//private int rg11;
	//private int rg20;
	private int rg2;
	private double sumday;
	private int isworkday;
	public int getIsworkday() {
		return isworkday;
	}
	public void setIsworkday(int isworkday) {
		this.isworkday = isworkday;
	}
	private MyCalendar cal;
	public MyCalendar getCal() {
		return cal;
	}
	public void setCal(MyCalendar cal) {
		this.cal = cal;
	}
	public double getSumday() {
		return sumday;
	}
	public void setSumday(double sumday) {
		this.sumday = sumday;
	}
	
	
	public int getRg1() {
		return rg1;
	}
	public void setRg1(int rg1) {
		this.rg1 = rg1;
	}
	public int getRg2() {
		return rg2;
	}
	public void setRg2(int rg2) {
		this.rg2 = rg2;
	}
	private String tocountry;
	public List<MyCalendar> getListmc() {
		return listmc;
	}
	public void setListmc(List<MyCalendar> listmc) {
		this.listmc = listmc;
	}
	private String name;
	private String tel;
	private String chu;
	private String begindate;
	private String enddate;
	public String getZhiwu() {
		return zhiwu;
	}
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getZxdate() {
		return zxdate;
	}
	public void setZxdate(String zxdate) {
		this.zxdate = zxdate;
	}
	public String getHukou() {
		return hukou;
	}
	public void setHukou(String hukou) {
		this.hukou = hukou;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactpeople() {
		return contactpeople;
	}
	public void setContactpeople(String contactpeople) {
		this.contactpeople = contactpeople;
	}
	public String getContactpeopletel() {
		return contactpeopletel;
	}
	public void setContactpeopletel(String contactpeopletel) {
		this.contactpeopletel = contactpeopletel;
	}
	
	public String getTocountry() {
		return tocountry;
	}
	public void setTocountry(String tocountry) {
		this.tocountry = tocountry;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
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
	    //System.out.println("~~~~~~");
		MyCalendarDAO mcdao=new MyCalendarDAO();
		DateUtil du = new DateUtil();
		Session session = HibernateSessionFactory.getSession();
  	    Transaction trans=session.beginTransaction();
 	    String begindate1=begindate.replace("-","");
 	    String enddate1=enddate.replace("-","");
 	    String begindate2;
 	    String enddate2;
 	    if(afterworkday==1)
 	    {
 	    	begindate2=du.getNextDay(begindate1);
 	    }
 	    else
 	    {
 	   	    begindate2=begindate1;
 	    }
 	   if(beforeworkday==0)
	    {
	    	enddate2=du.getBeforeDay(enddate1);
	    }
	    else
	    {
	   	    enddate2=enddate1;
	    }
	    listmc=mcdao.findByBeginAndEnd(begindate2, enddate2, 1);
	    sumday=getDaysByBegindateAndEnddate(session,begindate,enddate);
	    if((listmc!=null)&&(!listmc.isEmpty()))
	    {
	    	isworkday=1;
	    }
	    else
	    {
	    	isworkday=0;
	    }
	    zhiwu= new String(zhiwu.getBytes("ISO8859-1"),"UTF-8");
 	    hukou= new String(hukou.getBytes("ISO8859-1"),"UTF-8");
 	    contactpeople= new String(contactpeople.getBytes("ISO8859-1"),"UTF-8");
 	    tocountry= new String(tocountry.getBytes("ISO8859-1"),"UTF-8");
 	    name= new String(name.getBytes("ISO8859-1"),"UTF-8");
 	    ActionContext.getContext().getSession().put("isworkday",isworkday);
	    ActionContext.getContext().getSession().put("name",name);
	    ActionContext.getContext().getSession().put("sex",sex);
	    ActionContext.getContext().getSession().put("age",age);
	    ActionContext.getContext().getSession().put("identity",identity);
	    ActionContext.getContext().getSession().put("zxdate",zxdate);
	    ActionContext.getContext().getSession().put("hukou",hukou);
	    ActionContext.getContext().getSession().put("email",email);
	    ActionContext.getContext().getSession().put("contactpeople",contactpeople);
	    ActionContext.getContext().getSession().put("contactpeopletel",contactpeopletel);
	    ActionContext.getContext().getSession().put("category1",category1);
	    ActionContext.getContext().getSession().put("category2",category2);
	    ActionContext.getContext().getSession().put("tocountry",tocountry);
	    ActionContext.getContext().getSession().put("zhiwu",zhiwu);
	  
	    //ActionContext.getContext().getSession().put("rg1",rg1);
	    //ActionContext.getContext().getSession().put("rg11",rg11);
	    //ActionContext.getContext().getSession().put("rg2",rg2);
	    //ActionContext.getContext().getSession().put("rg21",rg21);
	    ActionContext.getContext().getSession().put("sumday",sumday);
	    ActionContext.getContext().getSession().put("tel",tel);
	    ActionContext.getContext().getSession().put("begindate",begindate);
	    ActionContext.getContext().getSession().put("enddate",enddate);
	    trans.commit();
		session.flush();
		session.clear();
		session.close();
	    return "success";
	}
	public boolean isCategory1() {
		return category1;
	}
	public boolean isCategory2() {
		return category2;
	}
	public double getDaysByBegindateAndEnddate(Session session,String begindate,String enddate)
	{
		double days = 0;
		String bd = begindate.replace("-","");
		String ed = enddate.replace("-","");
		if((bd.length()==8)&&(ed.length()==8))
		{
			String sql = "select count(*) from t_mycalendar where date>="+bd+" and date <="+ed;
			days = Double.valueOf(String.valueOf(session.createSQLQuery(sql).uniqueResult()));
		}
//		String tempdate = begindate;
//		while((!tempdate.equals(enddate))&&(!enddate.equals(""))&&(days<1000))
//		{
//			tempdate = getNextDay(tempdate);
//			days+=1;
//		}
		return days;
	}

}
