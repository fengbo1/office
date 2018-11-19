package office.leave.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.jbsp.dao.JbspPageDiDAO;
import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveSummaryDAO;
import office.leave.pojo.LeaveSummary;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.UserUtil;
import office.util.Util;
/**
 * 请假页面展示
 * 从数据库中读取请假审批表中的返显要素，并在页面显示
 * @author htzx
 *
 */
public class ShowLeavePage_dai {

	private int	dai;
	private String begindate;
	private String newnumber;
	private String name;
	private String sex;
	private String birthdate;
	private String workdate;
	private String date;
	private String chu;
	private String tuan;
	private String zxdate;
	private String ccbdate;
	private String workyears="0";
	private String yearrest="0";
	private String workrest="0";
	private String bossname;
	private String message;
	private int yearcishu;
	private double jbsprestdays;
	private double chanrestdays;
	private double tanfmrestdays;
	private double tanporestdays;
	//当前日期
	private String nowdate;
	//上年度休假情况
	private LeaveSummary lastyear;
	//本年度休假情况
	private LeaveSummary thisyear;
	
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public int getDai() {
		return dai;
	}
	public void setDai(int dai) {
		this.dai = dai;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setTuan(String tuan) {
		this.tuan = tuan;
	}
	public String getTuan() {
		return tuan;
	}
	public void setZxdate(String zxdate) {
		this.zxdate = zxdate;
	}
	public String getZxdate() {
		return zxdate;
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
	
	public void setYearrest(String yearrest) {
		this.yearrest = yearrest;
	}
	public String getYearrest() {
		return yearrest;
	}
	public String getWorkrest() {
		return workrest;
	}
	public void setWorkrest(String workrest) {
		this.workrest = workrest;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	public String getNowdate() {
		return nowdate;
	}

	public void setBossname(String bossname) {
		this.bossname = bossname;
	}
	public String getBossname() {
		return bossname;
	}
	public double getJbsprestdays() {
		return jbsprestdays;
	}
	public void setJbsprestdays(double jbsprestdays) {
		this.jbsprestdays = jbsprestdays;
	}
	
	public double getChanrestdays() {
		return chanrestdays;
	}
	public void setChanrestdays(double chanrestdays) {
		this.chanrestdays = chanrestdays;
	}
	public double getTanfmrestdays() {
		return tanfmrestdays;
	}
	public void setTanfmrestdays(double tanfmrestdays) {
		this.tanfmrestdays = tanfmrestdays;
	}
	public double getTanporestdays() {
		return tanporestdays;
	}
	public void setTanporestdays(double tanporestdays) {
		this.tanporestdays = tanporestdays;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getYearcishu() {
		return yearcishu;
	}
	public void setYearcishu(int yearcishu) {
		this.yearcishu = yearcishu;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String execute() throws Exception{
		
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		JbspPageDiDAO jpddao = new JbspPageDiDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		LeaveSummaryDAO lsdao = new LeaveSummaryDAO();
		DateUtil du = new DateUtil();
		System.out.println("newnumber+"+newnumber);
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		name = java.net.URLDecoder.decode(name,"UTF-8"); 
		UserInfo ui = uidao.findByName(name);
		UserInfo uifq = uidao.findByNewNumber(newnumber);
		if(begindate==null||begindate.length()<8)
		{
			begindate = du.getStringDate();
		}
		else
		{
			begindate = begindate.replace("-","");
		}
		int year = Integer.parseInt(begindate.substring(0, 4));
		if(ui==null)
		{
			result = "failededed";
		}
		else if(ifcandai(uifq.getAuthority(),uifq.getPosition(),ui.getPosition()))
		{
			String newnumbersq = ui.getNewnumber();
		    if(ui!=null)
		    {
		    	yearcishu = lpdao.findYearShengyuCishu(newnumbersq,year);
		    	double yeardays = lpdao.findSumByApplicant(newnumbersq, 169, year,2);//当年流转中年假天数
		    	double jbdays = lpdao.findSumByApplicant(newnumbersq, 169, year,11);//当年流转中加班调休天数
		    	LeaveSummary lsthisyear = lsdao.findByYearAndNewnumber(year,newnumbersq);
		    	LeaveSummary lslastyear = lsdao.findByYearAndNewnumber(year-1,newnumbersq);
		    	double newjbrest = jpddao.findDaysByBegindateEnddateName(begindate, name);
		    	//jbsprestdays = lsthisyear.getWorkrest() + lslastyear.getWorkrest()+newjbrest-jbdays;;
		    	if(lsthisyear!=null&&lslastyear!=null)
		    	{
		    		//jbsprestdays = lsthisyear.getWorkrest() + lslastyear.getWorkrest()-jbdays;;
		    		jbsprestdays = lsthisyear.getWorkrest() + lslastyear.getWorkrest()+newjbrest-jbdays;;
		    	}
		    	//newnumber = ui.getNewnumber();
		    	sex = UserUtil.getSexFromIdentity(ui.getIdentity());
		    	if(sex.equals("男"))
		    	{
		    		chanrestdays = 20-lpdao.findSumByApplicant(newnumber, 169, year,5);//当年流转中产假天数
		    	}
		    	else
		    	{
		    		chanrestdays = 158-lpdao.findSumByApplicant(newnumber, 169, year,5);//当年流转中产假天数
		    	}
		    	if(lpdao.findByNumberAndYear(newnumber,String.valueOf(year),6).isEmpty())
		    	{
		    		tanporestdays = 30;
		    	}
		    	else
		    	{
		    		tanporestdays = 0;
		    	}
		    	if(lpdao.findByNumberAndYear(newnumber,String.valueOf(year),7).isEmpty())
		    	{
		    		tanfmrestdays = 45;
		    	}
		    	else
		    	{
		    		tanfmrestdays = 0;
		    	}
		    	birthdate = UserUtil.getBirthFromIdentity(ui.getIdentity());
		    	if(ui.getWorkdate()!=null)
		    	workdate = ui.getWorkdate();
		    	date = du.getStringDate();
		    	chu = UserUtil.positionToName(ui.getPosition());
		    	if(ui.getPosition().substring(2,3).equals("3"))//如果是异常交易处才识别团队
		    	//tuan=UserUtil.tToName(Integer.valueOf(ui.getPosition().substring(2,3)),Integer.valueOf(ui.getPosition().substring(4,5)));
		    	zxdate=ui.getZxdate();
		    	if(ui.getCcbdate()!=null)
		    	ccbdate = ui.getCcbdate();
		    	lastyear = lsdao.findByYearAndName(year-1, name);
		    	thisyear = lsdao.findByYearAndName(year, name);
		    	if(ui.getWorkyears()!=null)
		    	workyears=ui.getWorkyears().toString();

		    	if(thisyear!=null)
		    	{
		    		yearrest=String.valueOf((thisyear.getYearall()-thisyear.getYearleave())-yeardays);
			    	workrest=thisyear.getWorkrest().toString();
		    	}

		    	Date date = new Date();
				SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				nowdate = bartDateFormat.format(date);
		    	
		    }
		    LeavePageDAO lpd=new LeavePageDAO();
		    bossname=lpd.findboss(name);
		}
		else
		{
			result = "failed";
		}
	    if(dai==1)
	    {
	    	result = "dai";
	    }
		trans.commit();
        session.flush();
        session.clear();
        session.close();
		
		return result;
	}
	/**
	 * a是否能代b发起 返回true能。返回false不能
	 * @param positionfq
	 * @param positionsq
	 * @return
	 */
	public boolean ifcandai(String autho,String positionfq,String positionsq)
	{
		String zhifq = positionfq.substring(0, 1);
		String chufq = positionfq.substring(2, 3);
		String zhisq = positionsq.substring(0, 1);
		String chusq = positionsq.substring(2, 3);
		
		if(zhifq.equals("0")||zhifq.equals("1")||autho.contains("I"))//主任处长代所有人
		{
			return true;
		}
		else if(zhifq.equals("2")&&(chufq.equals(chusq)))//团队负责人代本处室
		{
			return true;
		}
		else if((zhifq.equals("3")||zhifq.equals("4"))&&(chufq.equals(chusq)))//普通员工代本处室&&!zhisq.equals("2")&&!zhisq.equals("1")
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	
}