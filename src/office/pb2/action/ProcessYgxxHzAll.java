package office.pb2.action;

import java.util.List;

import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ProcessYgxxHzAll {

	public String execute() throws Exception
	{
		XxsqPageDAO xpdao = new XxsqPageDAO();
		ProcessYgxxHz pyh = new ProcessYgxxHz();
		List<XxsqPage> list = xpdao.findAll();
		for(int i=0;i<list.size();i++)
		{
			pyh.process(list.get(i));
		}
		return "success";
	}
}
