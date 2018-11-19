package office.pb2.action;

import java.util.ArrayList;
import java.util.List;

import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.tempxx.dao.TPeopleworkDAO;
import office.tempxx.pojo.TPeoplework;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class BackToYgxxPage {
	private String name;
	private String newnumber;
	private String tel;
	private String[] people;
	private String RadioGroup1;
	private String RadioGroup2;
	private double day;
	private double hour;//天，小时
	private String begindate;
	private String enddate;
	private int reason;
	private String qita;
	private String remark;
	private String peoplename;
	private String peoplenametiao;
	private List<UserInfo> list;
	
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	public String getPeoplenametiao() {
		return peoplenametiao;
	}
	public void setPeoplenametiao(String peoplenametiao) {
		this.peoplenametiao = peoplenametiao;
	}
	public String getPeoplename() {
		return peoplename;
	}
	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String[] getPeople() {
		return people;
	}
	public void setPeople(String[] people) {
		this.people = people;
	}
	public String getRadioGroup1() {
		return RadioGroup1;
	}
	public void setRadioGroup1(String radioGroup1) {
		RadioGroup1 = radioGroup1;
	}
	public String getRadioGroup2() {
		return RadioGroup2;
	}
	public void setRadioGroup2(String radioGroup2) {
		RadioGroup2 = radioGroup2;
	}
	public double getDay() {
		return day;
	}
	public void setDay(double day) {
		this.day = day;
	}
	public double getHour() {
		return hour;
	}
	public void setHour(double hour) {
		this.hour = hour;
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
	public int getReason() {
		return reason;
	}
	public void setReason(int reason) {
		this.reason = reason;
	}
	public String getQita() {
		return qita;
	}
	public void setQita(String qita) {
		this.qita = qita;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			list = new ArrayList<UserInfo>();
			UserInfo ui = uidao.findByNewNumber(newnumber);
			//name = ui.getUsername();
			String position = ui.getPosition();
			char chu = position.charAt(2);
			char zhi = position.charAt(0);
			if(zhi=='2'||zhi=='1')
			{
				List<UserInfo> templist = uidao.findAllByAuthority("T");//排班管理员
				for(int i=0;i<templist.size();i++)
				{
					UserInfo tempui = templist.get(i);
					String tempstr = "排班管理员（"+tempui.getUsername()+"）";
					UserInfo temp = new UserInfo();
					temp.setNewnumber(tempui.getNewnumber());
					temp.setUsername(tempstr);
					list.add(temp);
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
		return "success";
	}
}
