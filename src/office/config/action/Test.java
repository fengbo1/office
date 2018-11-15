package office.config.action;

import office.config.dao.ConfigDAO;
import office.config.pojo.Config;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class Test {

	public String execute() throws Exception
	{
		ConfigDAO cfdao = new ConfigDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
				Config cfg = new Config();
				cfg.setName("test");
				cfg.setValue(1);
				cfg.setStrvalue("2");
				cfdao.merge(cfg);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
	}
}
