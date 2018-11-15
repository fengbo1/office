package office.leave.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveProcessDAO;
import office.leave.dao.LeaveSummaryDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.leave.pojo.LeaveSummary;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.process.action.FindNextUnder;
import office.tempxx.dao.TPeopleworkDAO;
import office.tempxx.pojo.TPeoplework;
import office.userinfo.dao.UserInfoDAO;
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
 * 点击本人承办-审批之后的详情页面
 * @author htzx
 *
 */
public class ViewUndertakeDetail {
	private String number;//请假单编号
	private String name;//用户名
	private String thisnewnumber;//当前审批人工号
	private String newnumber;
	private LeavePage lp;
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
	private String status;//请假表当前状态
	private String type;//请假类型
	private String dai;
	private String bu;
	private int isshow;
	private UserInfo huizong;
	private String youjbtx;//有加班调休并且请病事假，置1
	private int youwushenpi;
	private int year;//提交申请时的nianfe
	//当前日期
	private String nowdate;
	//年假次数提示
	private String yearcs;
	//上年度休假情况
	private LeaveSummary lastyear;
	//本年度休假情况
	private LeaveSummary thisyear;
	private List<UserInfo> list;//下一阶段审批人
	private String thisunder;
	private List<LeaveProcess> lpro;
	
	public int getIsshow() {
		return isshow;
	}
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	public int getYouwushenpi() {
		return youwushenpi;
	}
	public void setYouwushenpi(int youwushenpi) {
		this.youwushenpi = youwushenpi;
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
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getThisnewnumber() {
		return thisnewnumber;
	}
	public void setThisnewnumber(String thisnewnumber) {
		this.thisnewnumber = thisnewnumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public UserInfo getHuizong() {
		return huizong;
	}
	public void setHuizong(UserInfo huizong) {
		this.huizong = huizong;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getYearcs() {
		return yearcs;
	}
	public void setYearcs(String yearcs) {
		this.yearcs = yearcs;
	}
	public String getYoujbtx() {
		return youjbtx;
	}
	public void setYoujbtx(String youjbtx) {
		this.youjbtx = youjbtx;
	}
	public String execute() throws Exception
	{
		Query query;
		Query queryui;
		DateUtil du = new DateUtil();
		double jbsprestdays = 0.0;
		String lpyear = "";//请假所属年度
		LeavePageDAO lpdao = new LeavePageDAO();
		LeaveSummaryDAO lsdao = new LeaveSummaryDAO();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		LeaveUtil lu = new LeaveUtil();
		FindNextUnder fnu = new FindNextUnder();
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
 				ui=new UserInfo();
 			}
 			else
 			{
 				ui=(UserInfo) queryui.list().get(0);
 			}
 			//判断是否有加班调休
 			int year = Integer.parseInt(lp.getBegindate().substring(0, 4));
 			double jbdays = lpdao.findSumByApplicant(lp.getApplicant(), 169, year,11);//当年流转中加班调休天数
	    	LeaveSummary lsthisyear = lsdao.findByYearAndNewnumber(year,lp.getApplicant());
	    	LeaveSummary lslastyear = lsdao.findByYearAndNewnumber(year-1,lp.getApplicant());
	    	if(lsthisyear!=null&&lslastyear!=null)
	    	{
	    		//jbsprestdays = lsthisyear.getWorkrest() + lslastyear.getWorkrest()+newjbrest-jbdays;
	    		jbsprestdays = lsthisyear.getWorkrest() + lslastyear.getWorkrest()-jbdays;
	    	}
	    	if((jbsprestdays>0)&&(lp.getType()==1||lp.getType()==3))
	    	{
	    		youjbtx = ui.getUsername()+"有未休完的加班调休，按中心规定，应休完加班调休后再请病事假！是否同意休假？";
	    	}
 			huizong = uidao.findAllByAuthority("H").get(0);
 			year = Integer.parseInt(lp.getDate().substring(0, 4));
 			thisnewnumber = lp.getUndertake();
 			name = ui.getUsername();
	    	sex = UserUtil.getSexFromIdentity(ui.getIdentity());
	    	birthdate = UserUtil.getBirthFromIdentity(ui.getIdentity());
	    	workdate = ui.getWorkdate();
	    	date = du.getStringDate();
	    	chu = UserUtil.positionToName(ui.getPosition());
	    	if(chu.equals("3"))//只有异常交易处有团队
	    	tuan=UserUtil.tToName(Integer.valueOf(ui.getPosition().substring(2,3)),Integer.valueOf(ui.getPosition().substring(4,5)));
	    	zxdate=ui.getZxdate();
	    	ccbdate = ui.getCcbdate();
	    	lastyear = lsdao.findByYearAndName(year-1, name);
	    	thisyear = lsdao.findByYearAndName(year, name);
	    	//isshow = showtip(begindate,enddate,ui);
//	    	if(lpyear.equals(String.valueOf(year)))//今年
//	    	{
//	    		thisyear = fixyearleave(thisyear,lp);
//	    	}
//	    	if(lpyear.equals(lastyear.getYear()))//去年
//	    	{
//	    		lastyear = fixyearleave(lastyear,lp);
//	    	}
	    	workyears=ui.getWorkyears().toString();
	    	yearrest=String.valueOf((thisyear.getYearall()-thisyear.getYearleave()));
	    	workrest=thisyear.getWorkrest().toString();
	    	begindate=du.simpleToStanderd(lp.getBegindate());
	    	enddate=du.simpleToStanderd(lp.getEnddate());
	    	isshow = showtip(lp.getBegindate(),lp.getEnddate(),ui);
	    	type = LeaveUtil.TypeSexToString(ui.getIdentity(),lp.getType());
	    	Date date = new Date();
			SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			nowdate = bartDateFormat.format(date);
 			status = String.valueOf(lp.getStatus());
 			dai = number.substring(12,13);
			bu = number.substring(13,14);
			list = fnu.findNextUnder("QJSQ", number);//下一级承办人列表
		 	if(list.isEmpty())
		 	{
		 		youwushenpi = 0;
		 	}
		 	else
		 	{
		 	    youwushenpi = 1;
		 	 }
//		 	if(uidao.findByNewNumber(thisnewnumber).getAuthority().contains("I"))
//			{
//				thisunder = "I";
//				youwushenpi = 0;
//			}
//			else
//			{
				thisunder = lu.getThisUndertake(number);//当前承办人的代号
			//}
		 	 lpro = lprodao.findAllByNumber(number);
		 	 //判断是否是年休，提示剩余次数
		 	if(lp.getType()==2)
		 	{
		 		String sql = "select count(*) from t_leave_page where begindate>='"+lpyear+"0101' and begindate<='"+lpyear+"1231' and id<='"+lp.getId()+"' and type=2 and status in (1,2,7,9) and applicant='"+lp.getApplicant()+"'";
		 		int cs = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
		 		if(cs>3)
		 		{
		 			yearcs = "根据中心考勤管理办法规定，年休假应3次内休完，此为第"+cs+"次请年休假，是否同意？";
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
	
	public LeaveSummary fixyearleave(LeaveSummary ls,LeavePage lp)
	{
		int type = lp.getType();
		if(type==1)
		{
			ls.setBingleave(ls.getBingleave()-lp.getDays());
		}
		else if(type==2)
		{
			ls.setYearleave(ls.getYearleave()-lp.getDays());
		}
		else if(type==3)
		{
			ls.setShileave(ls.getShileave()-lp.getDays());
		}
		else if(type==4)
		{
			ls.setHunleave(ls.getHunleave()-lp.getDays());
		}
		else if(type==5)
		{
			ls.setChanleave(ls.getChanleave()-lp.getDays());
		}
		
		else if(type==6)
		{
			ls.setTanpoleave(ls.getTanpoleave()-lp.getDays());
		}
		else if(type==7)
		{
			ls.setTanfmleave(ls.getTanfmleave()-lp.getDays());
		}
		else if(type==8)
		{
			ls.setSangleave(ls.getSangleave()-lp.getDays());
		}
		else if(type==9)
		{
			ls.setShangleave(ls.getShangleave()-lp.getDays());
		}
		else if(type==10)
		{
			ls.setGongleave(ls.getGongleave()-lp.getDays());
		}
		else if(type==11)
		{
			ls.setWorkleave(ls.getWorkleave()-lp.getDays());
		}
		else if(type==12)
		{
			ls.setQitaleave(ls.getQitaleave()-lp.getDays());
		}
		return ls;
	}
	public int showtip(String begindate,String enddate,UserInfo ui)
	{
		    int flag=0;
		    MyCalendarDAO mcdao=new MyCalendarDAO();
			MyCalendar mc = new MyCalendar();
			TPeoplework tw = new TPeoplework();
			TPeopleworkDAO twdao = new TPeopleworkDAO();
			List<MyCalendar> listmc;
		    String opnumber = ui.getOpnumber();
	 	    String position = ui.getPosition();
	 	    String chu = position.substring(2, 3);
	 	    String zhi = position.substring(0, 1);
	 	    String begindate1=begindate.replace("-","");
		    String enddate1=enddate.replace("-","");
	 	    listmc=mcdao.findByBeginAndEnd(begindate1, enddate1, 2);
	 	    for(int i=0;i<listmc.size();i++)
	 	    {
	 	    	
	 	    	mc=listmc.get(i);
	 	    	tw = twdao.findAllByOpNumber(opnumber, mc.getDate());
	 	    	if((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&!(zhi.equals("2"))&&!(zhi.equals("1")))
 	 	    	{
 	 	    		if((tw==null)||(tw.getStatus().equals("上线")))
 	 	    	
 	 	  	 	    {
 	 	  	 	    	flag=flag+1;
 	 	  	 	    }
 	 	    	}
	 	 	  
	 	    }
	 	    return flag;
	}
}
