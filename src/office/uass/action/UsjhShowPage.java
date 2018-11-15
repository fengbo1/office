package office.uass.action;

import java.util.List;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UsjhShowPage {
	private String newnumber;
	private List<UserInfo> list;
	private UserInfo ui;
	private String position;
	private String obj;
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
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
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
 	    	  UserInfoDAO uidao = new UserInfoDAO();
 	 		  ui = uidao.findByNewNumber(newnumber);
 	 		  String autho = ui.getAuthority();
 	 		  position = ui.getPosition();
 	 		  if(obj.contains("wb"))//外包管理员
 	 		  {
 	 			 list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("2_1_C"));
 	 		  }
 	 		  else
 	 		  {
 	 			 list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("1_"+position.substring(2, 3)+"__"));
 	 		  }
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
