package office.mjgl.action;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.process.action.FindNextUnder;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.pojo.TMjglPage;
public class ViewMjglPage {
	
	private String newnumber;
	private TMjglPage tm;
    private String currenttime;
    private String temptime;
    int chu;
	public String getCurrenttime() {
		return currenttime;
	}

	public void setCurrenttime(String currenttime) {
		this.currenttime = currenttime;
	}

	public String getTemptime() {
		return temptime;
	}

	public void setTemptime(String temptime) {
		this.temptime = temptime;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public TMjglPage getTm() {
		return tm;
	}

	public void setTm(TMjglPage tm) {
		this.tm = tm;
	}

	public String execute() throws Exception
	{
		TMjglPageDAO tmdao = new TMjglPageDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    UserInfo ui = uidao.findByNewNumber(newnumber);
 	    String name = ui.getUsername();
 	    tm=tmdao.findAllByName(name);
 	    if(tm!=null)
 	    {
 	    	chu=Integer.parseInt(tm.getChu());
 	 	    if((tm.getCurrenttime()!=null)&&(tm.getCurrenttime()==1))
 	 	    {
 	 	    	currenttime="7*24";
 	 	    }
 	 	    if((tm.getCurrenttime()!=null)&&(tm.getCurrenttime()==2))
 	 	    {
 	 	    	currenttime="5*16(6:00-22:00)";
 	 	    }
 	 	    if((tm.getCurrenttime()!=null)&&(tm.getCurrenttime()==3))
 		    {
 		    	currenttime="7*16(6:00-22:00)";
 		    }
 	 	    if((tm.getCurrenttime()!=null)&&(tm.getCurrenttime()==4))
 		    {
 		    	currenttime="5*13(7:00-20:00)";
 		    }
 	    }
 	       
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}
}
