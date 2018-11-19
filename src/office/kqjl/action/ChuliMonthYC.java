package office.kqjl.action;

import java.util.List;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.KqjlMonthDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlMonth;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ChuliMonthYC {

	private int id;
	private String message;
	private String name;
	private String month;
	private int type;
	private List<KqjlDaily> list;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public List<KqjlDaily> getList() {
		return list;
	}
	public void setList(List<KqjlDaily> list) {
		this.list = list;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String execute() throws Exception
	{
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		KqjlMonth km = kmdao.findAllById(id);
    		if(km!=null)
    		{
    			month = km.getMonth();
    			name = km.getName();
    			list = kddao.findAllByMonthAndName(month, name);
    		}
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		if(type==1)
		{
			return "month";
		}
		else
		{
			return "success";
		}
	}
}
