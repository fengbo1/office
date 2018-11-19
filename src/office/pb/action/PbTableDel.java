package office.pb.action;

import java.util.List;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.pb.bean.ScpbTableBean;
import office.pb.dao.ScpbTableDAO;
import office.pb.pojo.ScpbTable;
import office.util.PbUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

/**
 * 删除pbtable 表记录，同时删除对应的mx数据
 * @author htzx
 *
 */
public class PbTableDel {

	private int id;
	private String name;
	private String type;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String execute() throws Exception
	{
		ScpbTableDAO stadao = new ScpbTableDAO();
		OperateLogDAO oldao = new OperateLogDAO();
		String sql = "";
		PbUtil pu = new PbUtil();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			System.out.println(id);
			ScpbTable st = stadao.findAllById(id);
			List<ScpbTableBean> liststb = pu.scpbTableToBean(st);
			if(type.equals("1"))
			{
				sql = "delete from t_scpb_table where id="+id;
				System.out.println(sql);
				session.createSQLQuery(sql).executeUpdate();
			}
			else
			{
				
			}
			sql = "delete from t_pb_mx where date>='"+st.getBegindate()+"' and date<='"+st.getEnddate()+"' and plantype="+type;
			System.out.println(sql);
			session.createSQLQuery(sql).executeUpdate();
			message = "删除成功！";
			OperateLog ol = new OperateLog();
			ol.setName(name);
			ol.setOperate("删除pbtable和pbmx");
			ol.setRemark("日期"+st.getBegindate()+"至"+st.getEnddate());
			oldao.merge(ol);
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
