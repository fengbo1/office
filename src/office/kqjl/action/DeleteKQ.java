package office.kqjl.action;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 在考勤明细表中删除考勤记录
 * @author htzx
 *
 */
public class DeleteKQ {

	private int id;
	private int type;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
    		if(type==1)//签到
    		{
    			kd.setQdtime("");
    		}
    		if(type==2)//签退
    		{
    			kd.setQttime("");
    		}
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
