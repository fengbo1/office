package office.kqjl.action;

import java.util.List;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.KqjlUploadDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlMonth;
import office.kqjl.pojo.KqjlUpload;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 从汇总表到月报表
 * 更改标志位
 * @author htzx
 *
 */
public class UpdateKqjlMonth {

	private String newnumber;
	private String message;
	private String month;
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String execute() throws Exception
	{
		message = "生成成功";
		String sql = "";
		KqjlUploadDAO kudao = new KqjlUploadDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		UserInfo ui = uidao.findByNewNumber(newnumber);
    		KqjlUpload ku = kudao.findAllByMonth(month);
    		String chu = ui.getPosition().substring(2, 3);
    		String autho = ui.getAuthority();
//    		if(chu.equals("1")||autho.contains("I"))
//    		{
//    			sql = "select * from t_kqjl_month where month='"+month+"' and position like '__1__' and yc=1";
//    			List list = session.createSQLQuery(sql).addEntity(KqjlMonth.class).list();
//    			if(list.isEmpty())
//    			{
//    				ku.setKqjl1(1);
//    			}
//    			else
//    			{
//    				message+="提交失败，综合管理处有异常未处理。";
//    			}
//    		}
//    		if(chu.equals("2")||autho.contains("I"))
//    		{
//    			sql = "select * from t_kqjl_month where month='"+month+"' and position like '__2__' and yc=1";
//    			List list = session.createSQLQuery(sql).addEntity(KqjlMonth.class).list();
//    			if(list.isEmpty())
//    			{
//    				ku.setKqjl2(1);
//    			}
//    			else
//    			{
//    				message+="提交失败，生产管理处有异常未处理。";
//    			}
//    		}
//    		if(chu.equals("3")||autho.contains("I"))
//    		{
//    			sql = "select * from t_kqjl_month where month='"+month+"' and position like '__3__' and yc=1";
//    			List list = session.createSQLQuery(sql).addEntity(KqjlMonth.class).list();
//    			if(list.isEmpty())
//    			{
//    				ku.setKqjl3(1);
//    			}
//    			else
//    			{
//    				message+="提交失败，集中业务处理人员有异常未处理。";
//    			}
//    		}
//    		if(chu.equals("4")||autho.contains("I"))
//    		{
//    			sql = "select * from t_kqjl_month where month='"+month+"' and position like '__4__' and yc=1";
//    			List list = session.createSQLQuery(sql).addEntity(KqjlMonth.class).list();
//    			if(list.isEmpty())
//    			{
//    				ku.setKqjl4(1);
//    			}
//    			else
//    			{
//    				message+="提交失败，员工响应团队有异常未处理。";
//    			}
//    		}
    		ku.setKqjl1(1);
    		ku.setKqjl2(1);
    		ku.setKqjl3(1);
    		ku.setKqjl4(1);
    		kudao.merge(ku);
    		
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
