package office.pb.action;

import office.pb.dao.PbTeshuDAO;
import office.pb.pojo.PbTeshu;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class PtToModify {

	private int id;
	private int item;
	private String name;
	private String begindate;
	private String enddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String execute() throws Exception
	{
		PbTeshuDAO ptdao = new PbTeshuDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		PbTeshu pt = ptdao.findAllByID(id);
    		name = pt.getName();
    		begindate = pt.getYxbegin();
    		enddate = pt.getYxend();
    		if(begindate.length()>7)
    		{
    			begindate = begindate.substring(0, 4)+"-"+begindate.substring(4, 6)+"-"+begindate.substring(6, 8);
    		}
    		if(enddate.length()>7)
    		{
    			enddate = enddate.substring(0, 4)+"-"+enddate.substring(4, 6)+"-"+enddate.substring(6, 8);
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
		return "success";
	}
}
