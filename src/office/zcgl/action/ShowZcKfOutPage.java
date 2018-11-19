package office.zcgl.action;
import java.util.List;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.process.pojo.Process;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.StorehouseOut;
import ccb.hibernate.HibernateSessionFactory;
public class ShowZcKfOutPage {
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
