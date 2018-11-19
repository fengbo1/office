package office.zszm.action;
import java.util.List;

import office.yscj.pojo.TYscj;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class ShowYscjChoose {
	private static final Log log = LogFactory.getLog(TYscj.class);
	         // 新一代员工编号
	private List<TYscj> list;
	private String name;
    private String newnumbers;
    private String sex;
    private String identity;
    private String passport;
    private String chu;
    private String tel;
    private String zxdate;
    private String zhiwu;
	
	

	public String getNewnumbers() {
		return newnumbers;
	}

	public void setNewnumbers(String newnumbers) {
		this.newnumbers = newnumbers;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getChu() {
		return chu;
	}

	public void setChu(String chu) {
		this.chu = chu;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZxdate() {
		return zxdate;
	}

	public void setZxdate(String zxdate) {
		this.zxdate = zxdate;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public List<TYscj> getList() {
		return list;
	}

	public void setList(List<TYscj> list) {
		this.list = list;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		Query query;
		String hql = "";
		
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			ui = uidao.findByName(name);
			newnumbers=ui.getNewnumber();		
			hql = "from TYscj as ty where 1=1";
			String newnumber1=newnumbers.substring(0,8);
			hql += " and substr(ty.applicant,1,8)='"+newnumber1+"'";
	
			hql += " and ty.status in (8,9) order by ty.id desc";
			System.out.println(hql);
			query = session.createQuery(hql);
			
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
}
	
	