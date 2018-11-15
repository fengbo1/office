package office.pb.action;

import java.util.List;

import office.pb.dao.ScpbPlanDAO;
import office.pb.pojo.ScpbPlan;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class PpToAdd {
	
	private List<ScpbPlan>listplan;
	
	public List<ScpbPlan> getListplan() {
		return listplan;
	}

	public void setListplan(List<ScpbPlan> listplan) {
		this.listplan = listplan;
	}

	public String execute() throws Exception
	{
		
		ScpbPlanDAO spdao = new ScpbPlanDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		
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
