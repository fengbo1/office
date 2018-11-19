package office.kqjl.action;

import office.kqjl.pojo.KqjlMonth;
import office.userinfo.action.UserLogin;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class KqqsDis {

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception
	{
		message = "操作成功";
		UserLogin ul = new UserLogin();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		ul.ifKQQSDisabledForManager(session);
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
