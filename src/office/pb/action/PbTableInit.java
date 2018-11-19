package office.pb.action;

import java.util.List;

import office.pb.dao.ScpbTableDAO;
import office.pb.pojo.ScpbTable;
import office.util.PbUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class PbTableInit {

	public String execute() throws Exception
	{
		ScpbTableDAO stdao = new ScpbTableDAO();
		PbUtil pu = new PbUtil();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		try {
			List<ScpbTable> list = stdao.findAll();
			for(int i=0;i<list.size();i++)
			{
				ScpbTable sta = list.get(i);
				
				
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
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
