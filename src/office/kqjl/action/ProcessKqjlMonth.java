package office.kqjl.action;

import java.util.List;

import office.kqjl.dao.KqjlMonthDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlMonth;
import office.util.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 生成考勤汇总表
 * @author htzx
 *
 */
public class ProcessKqjlMonth {

	private String message;
	private String para;
	private String month;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String execute() throws Exception
	{
		ImportKqjl ik = new ImportKqjl();
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		message = "生成成功";
		month = month.replace("-", "");
		String sql = "";
		
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		if(month.length()>6)
    		{
    			month = month.substring(0, 6);
    			ik.countkqjlMonth(session,month);
    		}
    		else if(month.equals("id"))
    		{
    			KqjlMonth km = kmdao.findAllById(Integer.parseInt(para));
    			ik.countkqjlMonthById(session, Integer.parseInt(para));
    			month = km.getMonth();
    		}
    		else
    		{
    			sql = "select * from t_kqjl_daily where date>='"+month+Util.beginday+"' and date<='"+month+Util.endday+"' and position like '"+para+"' and (yy=1 or yc=1)";
    			System.out.println(sql);
    			List list = session.createSQLQuery(sql).addEntity(KqjlDaily.class).list();
    			if(list.isEmpty())
    			{
    				ik.countkqjlMonthByTeam(session,para);
    			}
    			else
    			{
    				message = "失败，还有异常未处理，请处理完毕后重新提交";
    			}
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
		updateYc(month);
		return "success";
	}
	
	public String updateYc(String month)
	{
		
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		//更新异常标志位
    		String sql = "update t_kqjl_month set yc=1 where month='"+month+"' and workdays<>(zhiwendays+qjdays+ggdays+chidao/2+zaotui/2+bukq/2)";
    		System.out.println(sql);
    		session.createSQLQuery(sql).executeUpdate();
    		sql = "update t_kqjl_month set yc=0 where month='"+month+"' and workdays=(zhiwendays+qjdays+ggdays+chidao/2+zaotui/2+bukq/2)";
    		System.out.println(sql);
    		session.createSQLQuery(sql).executeUpdate();
    		
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
