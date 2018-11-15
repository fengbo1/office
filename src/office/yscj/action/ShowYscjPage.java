package office.yscj.action;
import java.util.List;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.process.pojo.Process;
import office.util.UserUtil;
import office.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.yscj.pojo.TYscjTemp;
import office.yscj.dao.TYscjTempDAO;
import java.util.Calendar;
import ccb.hibernate.HibernateSessionFactory;
public class ShowYscjPage {
	private String newnumber;
	private List<UserInfo> list;
	private UserInfo ui;
	private Integer chu;
	private String position;
    private String time;
    private String sex;
    private int age;
    public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public List<UserInfo> getList() {
		return list;
	}


	public void setList(List<UserInfo> list) {
		this.list = list;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public Integer getChu() {
		return chu;
	}


	public void setChu(Integer chu) {
		this.chu = chu;
	}

	public UserInfo getUi() {
		return ui;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public void setUi(UserInfo ui) {
		this.ui = ui;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    DateUtil du = new DateUtil();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    GetProcessByPosition gpbp = new GetProcessByPosition();
 	    ProcessDAO pdao = new ProcessDAO();
 	    ui = uidao.findByNewNumber(newnumber); 
 	    int process = 0;
 	    age=countage();
 	    sex = UserUtil.getSexFromIdentity(ui.getIdentity());
 	    position = ui.getPosition();
 	    String thisunder = "";
 	    time = du.getDate();
 	    process = gpbp.getYscjProcess(position);
 	    Process p = pdao.findByItemAndApplicant("YSCJ", process);
 	    if(p!=null)
	    {
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	list = uidao.findByAuthorityAndPosition(thisunder, position);
	    }
 	    chu = Integer.parseInt(position.substring(2,3));
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
	public int countage()
	{
		Calendar a=Calendar.getInstance();
	 	int year = a.get(Calendar.YEAR); 
	 	int birthyear=Integer.parseInt(ui.getIdentity().substring(6,10));
	 	int birthmonth=Integer.parseInt(ui.getIdentity().substring(10,12));
	 	int birthday=Integer.parseInt(ui.getIdentity().substring(12,14));
	 	int month = a.get(Calendar.MONTH)+1; 
	 	int day = a.get(Calendar.DATE); 
		int age=year-birthyear;
		if((birthmonth-month)>0)
		{
			age=age-1;
		}
		if(((birthmonth-month)==0)&&((birthday-day)>0))
		{
			age=age-1;
		}
		return age;
		
	}
}
