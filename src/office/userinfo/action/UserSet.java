package office.userinfo.action;

import office.config.dao.ConfigDAO;
import office.config.pojo.Config;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 用户信息设置
 * @author htzx
 *
 */
public class UserSet {

	private String message;
	private String type;
	private String zhi;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getZhi() {
		return zhi;
	}
	public void setZhi(String zhi) {
		this.zhi = zhi;
	}
	public String execute() throws Exception
	{
		message = "成功";
		ConfigDAO cfdao = new ConfigDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			if(type!=null)
			{
				if(type.equals("buru"))
				{
					Config cfg = cfdao.findAllByName("buru");
					cfg.setStrvalue(zhi);
					cfdao.merge(cfg);
				}
			}
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
