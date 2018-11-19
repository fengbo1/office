package office.uass.action;

import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostHnPeopleDAO;
import office.uass.pojo.UassCostHn;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class UschSubPage {
	private String newnumber;
	private String message;
	private String number;
	private String name;
	private String tel;
	private String sxtime;
	private String remark;
	private String thisunder;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSxtime() {
		return sxtime;
	}
	public void setSxtime(String sxtime) {
		this.sxtime = sxtime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String execute() throws Exception {
		DateUtil du = new DateUtil();
		UassCostHnDAO uchdao = new UassCostHnDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UassCostHn uch = uchdao.findAllByNumber(number);
			if(uch==null)
			{
				message = "失败！";
			}
			else
			{
				uch.setDate(du.getStringDate());
				uch.setJindu("E");
				uch.setStatus(1);
				uch.setUndertake(thisunder);
				uch.setPreundertake("");
				uch.setSxtime(sxtime);
				uchdao.merge(uch);
				message = "提交成功！";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
	}
}
