package office.mjgl.action;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.leave.dao.LeavePageDAO;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.UserUtil;
import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.pojo.TMjglPage;
public class MjglAjax {
	private String people;
	private String currentauth;
	private int currenttime;
	private String bossname;
	public String getBossname() {
		return bossname;
	}
	public void setBossname(String bossname) {
		this.bossname = bossname;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getCurrentauth() {
		return currentauth;
	}
	public void setCurrentauth(String currentauth) {
		this.currentauth = currentauth;
	}
	public int getCurrenttime() {
		return currenttime;
	}
	public void setCurrenttime(int currenttime) {
		this.currenttime = currenttime;
	}
	public String execute() throws Exception
	{
		TMjglPageDAO tmdao=new TMjglPageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		String result = "success";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    people=new String(people.getBytes("ISO8859-1"),"UTF-8");
		TMjglPage tm = tmdao.findAllByName(people);
		if(tm!=null)
	    {
			currentauth=tm.getCurrentauth();
			currenttime=tm.getCurrenttime();
	    }
	
	    int process = 0;
	    UserInfo ui = uidao.findByName(people);
	 	String position = ui.getPosition();
	 	String auth=ui.getAuthority();
	 	String thisunder = "";
	    GetProcessByPosition gpbp = new GetProcessByPosition();
	 	ProcessDAO pdao = new ProcessDAO();
		process = gpbp.getMjglProcess(position,auth);
	 	Process p = pdao.findByItemAndApplicant("MJGL", process);
	 	if(p!=null)
		{
	 	    thisunder = p.getProcess().substring(1, 2);//EDCA
	 	    bossname = uidao.findBoss(thisunder, position);
		 }
		if(tm==null)
		{
			result = "failed";
		}
		
		trans.commit();
        session.flush();
        session.clear();
        session.close();
		return result;
	}
	
}
