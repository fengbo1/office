package office.tempxx.action;

import java.util.List;

import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.tempxx.pojo.TPeoplework;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewPwUnderAll {
	private static final Log log = LogFactory.getLog(TPeoplework.class);
	private List<TPeoplework> list;
	private String title;
	private String name;
	private String begindate;
	private String enddate;
	private String strtemp;
	private int zhuan;
	private String number;
	private String isdai;
	
	
	
	public String getIsdai() {
		return isdai;
	}

	public void setIsdai(String isdai) {
		this.isdai = isdai;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<TPeoplework> getList() {
		return list;
	}

	public void setList(List<TPeoplework> list) {
		this.list = list;
	}

	public int getZhuan() {
		return zhuan;
	}

	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getStrtemp() {
		return strtemp;
	}

	public void setStrtemp(String strtemp) {
		this.strtemp = strtemp;
	}


	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		LeavePage lp = new LeavePage();
		LeavePageDAO lpdao = new LeavePageDAO();
		Query query;
		String hql = "";
		String position = "";
		String bd = "";
		String ed = "";
		String un = "";
		//title = "统计查询-明细查询";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			lp = lpdao.findByNumber(number);
			ui = uidao.findByNewNumber(lp.getApplicant());
			position = ui.getPosition();
			name = ui.getUsername();
			begindate = lp.getBegindate();
			enddate = lp.getEnddate();
			hql = "from TPeoplework as tw where 1=1";
			if(name!=null&&zhuan==1)
			{
				strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				strtemp = name;
			}
			if((strtemp!=null)&&(!strtemp.equals("")))
			{	
				hql +=" and tw.name = '"+strtemp+"'";
			}
			if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				bd = begindate.replace("-","");
				ed = enddate.replace("-", "");
				hql += " and tw.date>='"+bd+"' and tw.date<='"+ed+"'";
			}
		
			
			hql += " order by tw.id";
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
