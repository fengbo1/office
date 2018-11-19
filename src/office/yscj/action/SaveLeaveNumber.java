package office.yscj.action;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.Util;
import office.yscj.dao.TYscjTempDAO;
import office.yscj.pojo.TYscjTemp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class SaveLeaveNumber {
	private String []leavechoose;
    private String newnumberapply;
    private String leavepagenumber="";

	



	public String getLeavepagenumber() {
		return leavepagenumber;
	}

	public void setLeavepagenumber(String leavepagenumber) {
		this.leavepagenumber = leavepagenumber;
	}

	public String getNewnumberapply() {
		return newnumberapply;
	}

	public void setNewnumberapply(String newnumberapply) {
		this.newnumberapply = newnumberapply;
	}


	public String[] getLeavechoose() {
		return leavechoose;
	}

	public void setLeavechoose(String[] leavechoose) {
		this.leavechoose = leavechoose;
	}

	public String execute() throws Exception
	{
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    if(leavechoose!=null&&leavechoose.length!=0)
		{	
		  leavepagenumber = leavechoose[0];
		 for(int i=1;i<leavechoose.length;i++)
	    {
			leavepagenumber += "、";
			leavepagenumber += leavechoose[i];
			
	    }
		}
 	    ActionContext.getContext().getSession().put("leavepagenumber",leavepagenumber);
		String result = "success";
 	  
 	    	
 	    	trans.commit();
 			session.flush();
 			session.clear();
 			session.close();
 			
 			return result;
 	    	
 	    }
	   
}
