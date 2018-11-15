package office.userinfo.action;

import java.util.ArrayList;
import java.util.List;

import office.userinfo.pojo.UserInfo;
import office.util.UserUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UserToUpdate {

	private String id;
	private UserInfo ui;
	private String chu;
	private String zhi;
	private String tuan;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String getZhi() {
		return zhi;
	}
	public void setZhi(String zhi) {
		this.zhi = zhi;
	}
	public String getTuan() {
		return tuan;
	}
	public void setTuan(String tuan) {
		this.tuan = tuan;
	}
	public String execute() throws Exception
	{
		String position = "";
		List<UserInfo> list = new ArrayList<UserInfo>();
		String hql = "from UserInfo as ui where ui.id="+id;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		list = session.createQuery(hql).list();
		if(!list.isEmpty())
		{
			ui = list.get(0);
			position = ui.getPosition();
			chu = position.substring(2, 3);
			tuan = position.substring(4, 5);
			zhi = position.substring(0, 1);
//			ui.setRemark1(UserUtil.cToName(Integer.parseInt(chu)));
//			if(chu.equals("3"))
//			{
//				ui.setRemark2(UserUtil.tToName(3, Integer.parseInt(zu)));
//			}
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
		
	}
}
