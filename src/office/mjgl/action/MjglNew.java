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
public class MjglNew {
	private String people;
	private int isnew;
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
	
	public int getIsnew() {
		return isnew;
	}
	public void setIsnew(int isnew) {
		this.isnew = isnew;
	}
	public String execute() throws Exception
	{
		TMjglPageDAO tmdao=new TMjglPageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		String result = "success";
		isnew=1;
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    people=new String(people.getBytes("ISO8859-1"),"UTF-8");
		TMjglPage tm = tmdao.findAllByName(people);
		if(tm!=null)
	    {
			isnew=0;
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
		
		trans.commit();
        session.flush();
        session.clear();
        session.close();
		return result;
	}
	
}
