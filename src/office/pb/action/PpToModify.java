package office.pb.action;

import java.util.List;

import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.TPbPeopleDAO;
import office.pb.pojo.TPbPeople;
import office.pb.pojo.ScpbPlan;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class PpToModify {

	private int id;
	private int week;
	private String name;
	private String date;
	private int plan;
	private int isrest;
	private List<ScpbPlan>listplan;
	
	public List<ScpbPlan> getListplan() {
		return listplan;
	}
	public void setListplan(List<ScpbPlan> listplan) {
		this.listplan = listplan;
	}
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
	
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	public int getIsrest() {
		return isrest;
	}
	public void setIsrest(int isrest) {
		this.isrest = isrest;
	}
	public String execute() throws Exception
	{
		TPbPeopleDAO ppdao = new TPbPeopleDAO();
		ScpbPlanDAO spdao = new ScpbPlanDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		TPbPeople pp = ppdao.findById(id);
    		name = pp.getName();
    		date = pp.getDate();
    		plan = pp.getPlan();
    		week = pp.getWeek();
    		isrest = pp.getIsrest();
    		listplan = spdao.findAllMaxNum();
    		
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
