package office.pb.action;

import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ToChangePbMx {

	private int id;
	private String message;
	private office.pb.pojo.PbMx pm;
	private String newnumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public office.pb.pojo.PbMx getPm() {
		return pm;
	}
	public void setPm(office.pb.pojo.PbMx pm) {
		this.pm = pm;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		String result = "success";
		PbMxDAO pmdao = new PbMxDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		UserInfo ui = uidao.findByNewNumber(newnumber);
    		String zu = ui.getPosition().substring(4, 5);
    		pm = pmdao.findAllById(id);
    		String pbzu = pm.getPosition().substring(4, 5);
//    		if(!zu.equals(pbzu)&&!ui.getAuthority().equals("I"))
//    		{
//    			message = "失败！只能修改自己小组";
//    			result = "failed";
//    		}
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return result;
	}
}
