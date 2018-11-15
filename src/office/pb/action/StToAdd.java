package office.pb.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.pb.dao.ScpbTeamDAO;
import office.pb.dao.YgpbPlanDAO;
import office.pb.pojo.ScpbTeam;
import office.pb.pojo.YgpbPlan;

public class StToAdd {

	private int a;
	private int b;
	private int c;
	private String unpaiban;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public String getUnpaiban() {
		return unpaiban;
	}
	public void setUnpaiban(String unpaiban) {
		this.unpaiban = unpaiban;
	}
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		unpaiban = new String(unpaiban.getBytes("ISO8859-1"),"UTF-8");
    		ScpbTeamDAO stdao = new ScpbTeamDAO();
    		String sql = "select max(num) from t_scpb_team";
    		int maxnum = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
    		List<ScpbTeam> list = stdao.findAllOrderByNo(maxnum);//根据num查询，以no排序
    		List<Integer> listintbig = new ArrayList<Integer>();
    		List<Integer> listintsmall = new ArrayList<Integer>();
    		int size = list.size()+3;
    		for(int i=0;i<size;i++)
    		{
    			listintbig.add(i+1);
    		}
    		for(int i=0;i<list.size();i++)
    		{
    			listintsmall.add(list.get(i).getNo());
    		}
    		listintbig.removeAll(listintsmall);
    		a = listintbig.get(0);
    		b = listintbig.get(1);
    		c = listintbig.get(2);
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
