package office.leave.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import office.leave.dao.LeaveSummaryDAO;

/**
 * 生成leavesummary初始化数据
 * @author htzx
 *
 */
public class ProduceSummary {

	private int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String execute() throws Exception
	{
		String sql = "delete from t_leave_summary where year="+year;
		String sql2 = "insert into t_leave_summary(year,name,newnumber,yearall,yearleave,workrest,workleave,bingleave,shileave,hunleave,chanleave,tanpoleave,tanfmleave,sangleave,shangleave,gongleave,qitaleave,remark) select "+year+",username,newnumber,yearall,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,'' from user_info";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		
		
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
}
