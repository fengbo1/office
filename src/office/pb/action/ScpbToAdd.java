package office.pb.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.pb.dao.ScpbPlanDAO;
import office.pb.pojo.ScpbPlan;

public class ScpbToAdd {

	private int a;
	private int b;
	private int c;
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

	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		ScpbPlanDAO spdao = new ScpbPlanDAO();
    		String sql = "select max(num) from t_scpb_plan";
    		int maxnum = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
    		List<ScpbPlan> list = spdao.findAllOrderByNo(maxnum);
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
