package office.pb.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class PbMxDel {
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
		message="删除成功";
		String sql = "delete from t_pb_mx where id="+id;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			session.createSQLQuery(sql).executeUpdate();
			
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
