package office.welcome;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.util.DateUtil;

public class InitAction extends HttpServlet {  
  
	/**
	 * tomcat启动时执行一次该代码
	 */
    public void init() throws ServletException {  
        DateUtil du = new DateUtil(); 
       
        TbsqPageDAO tpdao = new  TbsqPageDAO();
        LeaveProcessDAO lprodao = new LeaveProcessDAO();
    	
    	Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    String date = du.getStringDate();
 	    String hql = "from TbsqPage as tp where tp.status in (1,2,3) and tp.date<='"+date+"'";
 	    List<TbsqPage> listtp = session.createQuery(hql).list();
 	    for(int i=0;i<listtp.size();i++)
 	    {
 	    	TbsqPage tp = listtp.get(i);
 	    	LeaveProcess lpro = new LeaveProcess();
 	    	tp.setStatus(5);//修改为已退回状态
			tp.setPreundertake(null);
			tp.setUndertake(null);
			lpro.setNumber(tp.getNumber());
			lpro.setTime(du.getSimpleDateTime());
			lpro.setViewer("自助办公工具");
			lpro.setRemark("超时退回");
			lpro.setOpinion(2);
			lprodao.merge(lpro);
			tpdao.merge(tp);
 	    }
 	    System.out.println("~~~~~~init~~~~~~");
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
     }  
}
