package office.userinfo.action;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UserDel {

	private String id;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String execute() throws Exception
	{
		
		String sql = "delete from user_info where id="+id;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.createSQLQuery(sql).executeUpdate();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
