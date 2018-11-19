package office.kqjl.action;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 提出异议
 * @author htzx
 *
 */
public class TichuYY {

	private int id;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		KqjlDaily kd = kddao.findAllByID(id);
    		kd.setYy(1);
    		kddao.merge(kd);
    		message = "提交成功";
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
