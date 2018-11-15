package office.pb.action;

import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.dao.YgpbPlanDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 排班功能通用删除功能
 * @author htzx
 *
 */
public class PbDel {

	private String type;
	private String message;
	private int no;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String execute() throws Exception
	{
		String sql = "";
		int num=0;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			if(type.equals("scpb"))
			{
				sql = "select max(num) from t_scpb_plan";
	    		if(session.createSQLQuery(sql).uniqueResult()!=null)
	    			num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
	    		sql = "insert into t_scpb_plan(no,num,sbtime,xbtime,zytime,pxtime,type) select no,num+1,sbtime,xbtime,zytime,pxtime,type from t_scpb_plan where num="+num;
	    		session.createSQLQuery(sql).executeUpdate();
	    		int lastnum = num+1;
				sql = "delete from t_scpb_plan where no="+no+" and num="+lastnum;
			}
			if(type.equals("ygpb"))
			{
				sql = "delete from t_ygpb_plan where no="+no;
			}
			if(type.equals("st"))
			{
				int maxno = 0;
				int maxnum= 0;
				ScpbTeamDAO stdao = new ScpbTeamDAO();
				sql = "select max(num) from t_scpb_team";
	    		if(session.createSQLQuery(sql).uniqueResult()!=null)
	    			num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
	    		sql = "insert into t_scpb_team(no,num,leader,member) select no,num+1,leader,member from t_scpb_team where num="+num;
	    		session.createSQLQuery(sql).executeUpdate();
	    		int lastnum = num+1;
	    		sql = "select max(no) from t_scpb_team where num="+lastnum;
	    		maxno = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
				sql = "delete from t_scpb_team where num="+lastnum+" and no="+maxno;
			}
			if(type.equals("pt"))
			{
				sql = "delete from t_pb_teshu where id="+no;
			}
			if(type.equals("pp"))
			{
				sql = "delete from t_pb_people where id="+no;
			}
			session.createSQLQuery(sql).executeUpdate();
			message = "删除成功";
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
