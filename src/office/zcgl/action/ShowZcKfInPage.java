package office.zcgl.action;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowZcKfInPage {
	private String newnumber;
    private int isshow;
    private UserInfo ui;
    
	
	public UserInfo getUi() {
		return ui;
	}


	public void setUi(UserInfo ui) {
		this.ui = ui;
	}


	public int getIsshow() {
		return isshow;
	}


	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    ui = uidao.findByNewNumber(newnumber);
		isshow=0;
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}

}
