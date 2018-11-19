package office.leave.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.LeaveUtil;
import office.util.UserUtil;

public class ModifyLeave {

	private String newnumber;
	private String number;
	private String workdate;
	private String chu;
	private String tuan;
	private String zhiwu;
	private int workyears;
	private String type;
	private String begindate;
	private String enddate;
	private double days;
	private int halfday;
	
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getWorkdate() {
		return workdate;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String getTuan() {
		return tuan;
	}
	public void setTuan(String tuan) {
		this.tuan = tuan;
	}
	public String getZhiwu() {
		return zhiwu;
	}
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	public int getWorkyears() {
		return workyears;
	}
	public void setWorkyears(int workyears) {
		this.workyears = workyears;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public double getDays() {
		return days;
	}
	public void setDays(double days) {
		this.days = days;
	}
	public int getHalfday() {
		return halfday;
	}
	public void setHalfday(int halfday) {
		this.halfday = halfday;
	}
	public String execute() throws Exception
	{
		LeavePageDAO lpdao = new LeavePageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		LeavePage lp = lpdao.findByNumber(number);
		UserInfo ui = uidao.findByNewNumber(lp.getApplicant());
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			if(lp.getStatus()==2||lp.getStatus()==7||lp.getStatus()==8)//如果状态是已办结
			{
				lpdao.undoLeavePage(session,number);
			}
			lp.setWorkage(workyears);
			lp.setChu(UserUtil.cToInteger(chu));
			lp.setTuan(UserUtil.teamToTnteger(tuan));
			lp.setZhiwu(zhiwu);
			lp.setDays(days);
			lp.setType(LeaveUtil.TypeToInteger(type));
			lp.setBegindate(begindate.replace("-", ""));
			lp.setEnddate(enddate.replace("-", ""));
			lp.setHalfday(halfday);
			ui.setWorkyears(workyears);
			ui.setWorkdate(workdate);
			lpdao.merge(lp);
			uidao.merge(ui);
			if(lp.getStatus()==2||lp.getStatus()==7||lp.getStatus()==8)
			{
				lpdao.submitLeavePage(session,number);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "";
	}
	
}
