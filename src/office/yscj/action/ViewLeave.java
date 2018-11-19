package office.yscj.action;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import office.yscj.pojo.TYscjTemp;
import office.yscj.dao.TYscjTempDAO;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;
public class ViewLeave {
	private static final Log log = LogFactory.getLog(LeavePage.class);
	private String newnumber;// 新一代员工编号
	private List<LeavePage> list;
	private String title;
	private String autho;
	private String begindate;
	private String enddate;
	private String applicant;
	private String zhiwu;
	private String sex;
	private String name;
	private int age;
	private String hukou;
	private String tel;
	private String email;
	private String contactpeople;
	private String contactpeopletel;
	private int notholiday;
    private int type;
	private int status;
	private String strtemp;
	private int chutuan;
	private int zhuan;
	private String zxtd;
	private String applicantname;
	private String applicantnewnumber;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApplicantname() {
		return applicantname;
	}

	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}

	public String getApplicantnewnumber() {
		return applicantnewnumber;
	}

	public void setApplicantnewnumber(String applicantnewnumber) {
		this.applicantnewnumber = applicantnewnumber;
	}

	public int getNotholiday() {
		return notholiday;
	}

	public void setNotholiday(int notholiday) {
		this.notholiday = notholiday;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHukou() {
		return hukou;
	}

	public void setHukou(String hukou) {
		this.hukou = hukou;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactpeople() {
		return contactpeople;
	}

	public void setContactpeople(String contactpeople) {
		this.contactpeople = contactpeople;
	}

	public String getContactpeopletel() {
		return contactpeopletel;
	}

	public void setContactpeopletel(String contactpeopletel) {
		this.contactpeopletel = contactpeopletel;
	}

	
	
	public int getZhuan() {
		return zhuan;
	}

	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public List<LeavePage> getList() {
		return list;
	}

	public void setList(List<LeavePage> list) {
		this.list = list;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutho() {
		return autho;
	}

	public void setAutho(String autho) {
		this.autho = autho;
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

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStrtemp() {
		return strtemp;
	}

	public void setStrtemp(String strtemp) {
		this.strtemp = strtemp;
	}
	public int getChutuan() {
		return chutuan;
	}

	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}

	public String getZxtd() {
		return zxtd;
	}

	public void setZxtd(String zxtd) {
		this.zxtd = zxtd;
	}

	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		UserInfo uiname = new UserInfo();
		Query query;
		String hql = "";
		String bd="";
		String ed="";
		strtemp = "";
		title = "明细查询";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		if(name==null)
		{
			applicantnewnumber="无";
		}
		else
		{
			
			uiname = uidao.findByName(name);
		    applicantnewnumber = uiname.getNewnumber();
		}
		
		try {
			ui = uidao.findByNewNumber(newnumber);			
			hql = "from LeavePage as lp where lp.status = 7";
			/*if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				bd = begindate.replace("-", "");
				ed = enddate.replace("-", "");
				hql += " and ((lp.begindate>='"+bd+"' and lp.begindate<='"+ed+"') or (lp.enddate>='"+bd+"' and lp.enddate<='"+ed+"') or (lp.begindate<='"+bd+"' and lp.enddate>='"+ed+"'))";
			}
			if(type!=0)
			{
				hql +=" and lp.type="+type;
			}
			if(status==1)
			{
				hql +=" and lp.status=2";
			}
			else if(status==2)
			{
				hql +=" and lp.status in (1,6,7,8,9)";
			}
			else if(status==3)
			{
				hql +=" and lp.status=3";
			}
			*/
			
			hql += " and lp.applicant='"+applicantnewnumber+"' order by locate('3',lp.status), lp.id desc";
			title = "个人请假明细";
			
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
