package office.leave.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.dao.LeaveSummaryDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.leave.pojo.LeaveSummary;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
/**
 * 本人申请-流转中-查看详情
 * @author htzx
 *
 */
public class LeaveDetail {

	private String number;//请假单编号
	private String name;//用户名
	private LeavePage lp;
	private List<LeaveProcess> lpro;
	private UserInfo ui;
	private String sex;
	private String birthdate;
	private String workdate;
	private String date;
	private String chu;
	private String tuan;
	private String zxdate;
	private String ccbdate;
	private String workyears;
	private String yearrest;
	private String workrest;
	private String begindate;
	private String enddate;
	private String type;//请假类型
	private String status;
	private String dai;
	private String bu;
	private int xiaojia;
	//年假次数提示
	private String yearcs;//
	//当前日期
	private String nowdate;
	//上年度休假情况
	private LeaveSummary lastyear;
	//本年度休假情况
	private LeaveSummary thisyear;
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
	
	public LeavePage getLp() {
		return lp;
	}
	public void setLp(LeavePage lp) {
		this.lp = lp;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getWorkdate() {
		return workdate;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getZxdate() {
		return zxdate;
	}
	public void setZxdate(String zxdate) {
		this.zxdate = zxdate;
	}
	public String getCcbdate() {
		return ccbdate;
	}
	public void setCcbdate(String ccbdate) {
		this.ccbdate = ccbdate;
	}
	public String getWorkyears() {
		return workyears;
	}
	public void setWorkyears(String workyears) {
		this.workyears = workyears;
	}
	public String getYearrest() {
		return yearrest;
	}
	public void setYearrest(String yearrest) {
		this.yearrest = yearrest;
	}
	public String getWorkrest() {
		return workrest;
	}
	public void setWorkrest(String workrest) {
		this.workrest = workrest;
	}
	public String getNowdate() {
		return nowdate;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	public LeaveSummary getLastyear() {
		return lastyear;
	}
	public void setLastyear(LeaveSummary lastyear) {
		this.lastyear = lastyear;
	}
	public LeaveSummary getThisyear() {
		return thisyear;
	}
	public void setThisyear(LeaveSummary thisyear) {
		this.thisyear = thisyear;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getXiaojia() {
		return xiaojia;
	}
	public void setXiaojia(int xiaojia) {
		this.xiaojia = xiaojia;
	}
	public List<LeaveProcess> getLpro() {
		return lpro;
	}
	public void setLpro(List<LeaveProcess> lpro) {
		this.lpro = lpro;
	}
	public String getDai() {
		return dai;
	}
	public void setDai(String dai) {
		this.dai = dai;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String getYearcs() {
		return yearcs;
	}
	public void setYearcs(String yearcs) {
		this.yearcs = yearcs;
	}
	public String execute() throws Exception
	{
		Query query;
		Query queryui;
		String lpyear = "";//请假所属年度
		LeaveSummaryDAO lsdao = new LeaveSummaryDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		DateUtil du = new DateUtil();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	   try {
 			String hql="from LeavePage as lp where lp.number=:n";
 			query = session.createQuery(hql);
 			query.setString("n", number);
 			lp = (LeavePage) query.list().get(0);
 			lpyear = lp.getBegindate().substring(0, 4);
 			String hqlui="from UserInfo as ui where ui.newnumber='"+lp.getApplicant()+"'";
 			queryui = session.createQuery(hqlui);
 			if(queryui.list().isEmpty())
 			{
 				ui=new UserInfo();;
 			}
 			else
 			{
 				ui=(UserInfo) queryui.list().get(0);
 			}
 			int year = Integer.parseInt(lp.getDate().substring(0, 4));
 			name = ui.getUsername();
	    	sex = UserUtil.getSexFromIdentity(ui.getIdentity());
	    	birthdate = UserUtil.getBirthFromIdentity(ui.getIdentity());
	    	workdate = ui.getWorkdate();
	    	date = du.getStringDate();
	    	chu = UserUtil.positionToName(ui.getPosition());
	    	if(chu.equals("3")||chu.equals("6"))//异常交易处才有团队
	    	tuan=UserUtil.tToName(Integer.valueOf(ui.getPosition().substring(2,3)),Integer.valueOf(ui.getPosition().substring(4,5)));
	    	zxdate=ui.getZxdate();
	    	ccbdate = ui.getCcbdate();
	    	lastyear = lsdao.findByYearAndName(year-1, name);
	    	thisyear = lsdao.findByYearAndName(year, name);
	    	workyears=ui.getWorkyears().toString();
	    	yearrest=String.valueOf((thisyear.getYearall()-thisyear.getYearleave()));
	    	workrest=thisyear.getWorkrest().toString();
	    	begindate=du.simpleToStanderd(lp.getBegindate());
	    	enddate=du.simpleToStanderd(lp.getEnddate());
	    	type = LeaveUtil.TypeSexToString(ui.getIdentity(),lp.getType());
			status = String.valueOf(lp.getStatus());
			lpro = lprodao.findAllByNumber(number);
			dai = number.substring(12,13);
			bu = number.substring(13,14);
			System.out.println("xiaojia:"+xiaojia);
			if(lp.getType()==2)
		 	{
		 		String sql = "select count(*) from t_leave_page where begindate>='"+lpyear+"0101' and begindate<='"+lpyear+"1231' and id<='"+lp.getId()+"' and type=2 and status in (1,2,7,9) and applicant='"+lp.getApplicant()+"'";
		 		int cs = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
		 		if(cs>3)
		 		{
		 			yearcs = "根据中心考勤管理办法规定，年休假应3次内休完，此为第"+session.createSQLQuery(sql).uniqueResult().toString()+"次请年休假，是否同意？";
		 	
		 		}
		 	}	
 	  } catch (Exception e) {
			// TODO: handle exception
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
