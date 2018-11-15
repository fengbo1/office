package office.uass.action;

import java.util.List;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class UschShowPage {
	private String newnumber;
	private List<UserInfo> list;
	private UserInfo ui;
	private String position;
	private String type;
	private String brdf;
	private String number;
	private String nowdate;
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBrdf() {
		return brdf;
	}
	public void setBrdf(String brdf) {
		this.brdf = brdf;
	}
	public String getNowdate() {
		return nowdate;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    try {
 	    	  DateUtil du = new DateUtil();
	 		  nowdate = du.getStdStringDate();
 	    	  number = "null";
 	    	  UserInfoDAO uidao = new UserInfoDAO();
 	 		  ui = uidao.findByNewNumber(newnumber);
 	 		  position = ui.getPosition();
 	 		  if(position.charAt(2)=='1')
 	 		  {
 	 			list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("2_1_C"));
 	 		  }
 	 		  else if((position.charAt(0)=='2'))
 	 		  {
 	 			list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("1_"+position.substring(2, 3)+"__"));
 	 		  }
 	 		  else
 	 		  {
 	 			list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("2_"+position.substring(2, 3)+"__"));
 	 		  }
 	 		  
 	 		  type="new";
 		   } catch (Exception e) {
			// TODO: handle exception
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
