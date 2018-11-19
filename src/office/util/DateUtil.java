package office.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MonthSummary;
/**
 * 时间操作相关的小工具
 * @author htzx
 *
 */
public class DateUtil {
	
	private String sumdates;

	Calendar a=Calendar.getInstance();
	
	int year = a.get(Calendar.YEAR); 
	int month = a.get(Calendar.MONTH)+1; 
	int date = a.get(Calendar.DATE); 
	int hour = a.get(Calendar.HOUR_OF_DAY); 
	int minute = a.get(Calendar.MINUTE); 
	int second = a.get(Calendar.SECOND); 
	public int getThisYear()
	{
		return year;
	}
	public int getMonth()
	{
		return month;
	}
	public String getThisSeason()
	{
		if(3<=month&&5>=month)
		{
			return "2";
		}
		else if(6<=month&&8>=month)
		{
			return "3";
		}
		else if(9<=month&&11>=month)
		{
			return "4";
		}
		else
		{
			return "1";
		}
	}
	public String getLastYear()
	{
		return String.valueOf(year-1);
	}
	public String getLastSeason()
	{
		int m = month+1;
		if(3<=m&&5>=m)
		{
			return "1";
		}
		else if(6<=m&&8>=m)
		{
			return "2";
		}
		else if(9<=m&&11>=m)
		{
			return "3";
		}
		else
		{
			return "4";
		}
	}
	public String getDateTime()
	{
		return year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分"+second+"秒";
	}
	
	public String getSimpleDateTime()
	{
		return year+"-"+std(month)+"-"+std(date)+" "+std(hour)+":"+std(minute)+":"+std(second);
	}
	public String getTime()
	{
		return std(hour)+":"+std(minute)+":"+std(second);
	}
	public String std(int input)
	{
		if(input<10)
		{
			return "0"+input;
		}
		else
		{
			return String.valueOf(input);
		}
		
	}
	public String getDate()
	{
		return year+"年"+month+"月"+date+"日";
	}
	public int getIntegerDate()
	{
		return year*10000+month*100+date;
	}
	public String getStringDate()
	{
		return String.valueOf(getIntegerDate());
	}
	public String getStdStringDate()
	{
		String sd = getStringDate();
		if(sd.length()>7)
		{
			return sd.substring(0, 4)+"-"+sd.substring(4, 6)+"-"+sd.substring(6, 8);
		}
		else
		{
			return "";
		}
	}
	public String getThisMonth()
	{
		return String.valueOf(year*100+month);
	}
	public String getNextMonth(String thismonth)
	{
		int year = Integer.parseInt(thismonth.substring(0,4));
		int month = Integer.parseInt(thismonth.substring(4,6));
		if(month==12)
		{
			month=1;
			year+=1;
		}
		else
		{
			month+=1;
		}
		return String.valueOf(year*100+month);
	}
	public String getLastMonth(String thismonth)
	{
		int year = Integer.parseInt(thismonth.substring(0,4));
		int month = Integer.parseInt(thismonth.substring(4,6));
		if(month==1)
		{
			month=12;
			year-=1;
		}
		else
		{
			month-=1;
		}
		return String.valueOf(year*100+month);
	}
	/**
	 * 获得半年前的日期
	 * @return
	 */
	public String getLastHalfYearDay()
	{
		if(month<7)
		{
			year-=1;
			month+=6;
		}
		else
		{
			month-=6;
		}
		return String.valueOf(year*10000+month*100+date);
	}
	/**
	 * 20150103-->2015年01月03日
	 * @param simple
	 * @return
	 */
	public String simpleToStanderd(String simple)
	{
		return simple.substring(0,4)+"年"+simple.substring(4,6)+"月"+simple.substring(6,8)+"日";
	}
	/**
	 * 返回下一日日期
	 * 传入日期格式2015-11-11或20151111
	 * 返回20151112
	 * @param date
	 * @return
	 */
	public String getNextDay(String date)
	{
		date = date.replace("-", "");
		int year = Integer.parseInt(date.substring(0,4));
		int month = Integer.parseInt(date.substring(4,6));
		int day = Integer.parseInt(date.substring(6,8));
		String nextdate = "";
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);//月份从0开始
		cal.add(Calendar.DATE, 1);
		Date newdate = cal.getTime();
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		nextdate = format.format(newdate);
		return nextdate;
	}
	
	public String getBeforeDay(String date)
	{
		date = date.replace("-", "");
		int year = Integer.parseInt(date.substring(0,4));
		int month = Integer.parseInt(date.substring(4,6));
		int day = Integer.parseInt(date.substring(6,8));
		String beforedate = "";
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);//月份从0开始
		cal.add(Calendar.DATE, -1);
		Date newdate = cal.getTime();
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		beforedate = format.format(newdate);
		return beforedate;
	}
	
	/**
	 * 根据起始日期截止日期,是否有半天返回（年度，月份，天数）的list
	 * @param begindate
	 * @param enddate
	 * @param halfday 0无，1第一天下午，2最后一天上午，3=1+2
	 * @return
	 */
	public List<MonthSummary> getWorkListByBegindateAndEnddate(Session session,String begindate,String enddate,int halfday)
	{
		MyCalendarDAO mc = new MyCalendarDAO();
		int beginyear = Integer.parseInt(begindate.substring(0, 4));
		int endyear = Integer.parseInt(enddate.substring(0, 4));
		int beginmonth = Integer.parseInt(begindate.substring(4, 6));
		int endmonth = Integer.parseInt(enddate.substring(4, 6));
		String thismonth = begindate.substring(0, 6);
		List<MonthSummary> list = new ArrayList<MonthSummary>();
	
		if((beginyear==endyear)&&(beginmonth==endmonth))//同月的情况
		{
			double days = getWorkDaysByBegindateAndEnddate(session,begindate,enddate);
			if(halfday==1||halfday==3)
			{
				if((days>0)&&(mc.ifWorkDay(begindate)))
				days-=0.5;
			}
			if(halfday==2||halfday==3)
			{
				if((days>0)&&(mc.ifWorkDay(enddate)))
				days-=0.5;
			}
			MonthSummary ms = new MonthSummary(beginyear,beginmonth,days);
			list.add(ms);
		}
		else//跨月的情况
		{
			int index = 0;
			if(beginyear<endyear)//跨年了,1月-12月;=2个月
			{
				index = endmonth+12-beginmonth+1;
			}
			else//7月-6月;=2个月
			{
				index = endmonth-beginmonth+1;
			}
			if(index==2)//跨度为两个月的算法
			{
				double begindays = getWorkDaysByBegindateAndEnddate(session,begindate,mc.findEndDateByDate(begindate));
				if(halfday==1||halfday==3)
				{
					if((begindays>0)&&(mc.ifWorkDay(begindate)))
					begindays-=0.5;
				}
				MonthSummary beginms = new MonthSummary(beginyear,beginmonth,begindays);
				list.add(beginms);
				double enddays = getWorkDaysByBegindateAndEnddate(session,enddate.substring(0, 6)+"01",enddate);
				if(halfday==2||halfday==3)
				{
					if((enddays>0)&&(mc.ifWorkDay(enddate)))
					enddays-=0.5;
				}
				MonthSummary endms = new MonthSummary(endyear,endmonth,enddays);
				list.add(endms);
			}
			else if(index>2)//跨度大于两个月的情况
			{
				double begindays = getWorkDaysByBegindateAndEnddate(session,begindate,mc.findEndDateByDate(begindate));
				if(halfday==1||halfday==3)
				{
					if((begindays>0)&&(mc.ifWorkDay(begindate)))
					begindays-=0.5;
				}
				MonthSummary beginms = new MonthSummary(beginyear,beginmonth,begindays);
				list.add(beginms);
				for(int i=0;i<(index-2);i++)
				{
					thismonth = getNextMonth(thismonth);//下一个月
					String thisdate = thismonth+"01";
					int year  = Integer.parseInt(thismonth.substring(0, 4));
					int month = Integer.parseInt(thismonth.substring(4, 6));
					double days = getWorkDaysByBegindateAndEnddate(session,thisdate,mc.findEndDateByDate(thisdate));
					MonthSummary ms = new MonthSummary(year,month,days);
					list.add(ms);
				}
				double enddays = getWorkDaysByBegindateAndEnddate(session,enddate.substring(0, 6)+"01",enddate);
				if(halfday==2||halfday==3)
				{
					if((enddays>0)&&(mc.ifWorkDay(enddate)))
					enddays-=0.5;
				}
				MonthSummary endms = new MonthSummary(endyear,endmonth,enddays);
				list.add(endms);
			}
		}
		return list;
	}
	/**
	 * 根据起始日期截止日期,是否有半天返回（年度，月份，天数）的list
	 * @param begindate
	 * @param enddate
	 * @param halfday 0无，1第一天下午，2最后一天上午，3=1+2
	 * @return
	 */
	public List<MonthSummary> getListByBegindateAndEnddate(Session session,String begindate,String enddate,int halfday)
	{
		MyCalendarDAO mc = new MyCalendarDAO();
		int beginyear = Integer.parseInt(begindate.substring(0, 4));
		int endyear = Integer.parseInt(enddate.substring(0, 4));
		int beginmonth = Integer.parseInt(begindate.substring(4, 6));
		int endmonth = Integer.parseInt(enddate.substring(4, 6));
		String thismonth = begindate.substring(0, 6);
		List<MonthSummary> list = new ArrayList<MonthSummary>();
	
		if((beginyear==endyear)&&(beginmonth==endmonth))//同月的情况
		{
			double days = getDaysByBegindateAndEnddate(session,begindate,enddate);
			if(halfday==1||halfday==2)
			{
				if(days>0)
				days-=0.5;
			}
			else if(halfday==3)
			{
				days-=1;
			}
			MonthSummary ms = new MonthSummary(beginyear,beginmonth,days);
			list.add(ms);
		}
		else//跨月的情况
		{
			int index = 0;
			if(beginyear<endyear)//跨年了,1月-12月;=2个月
			{
				index = endmonth+12-beginmonth+1;
			}
			else//7月-6月;=2个月
			{
				index = endmonth-beginmonth+1;
			}
			if(index==2)//跨度为两个月的算法
			{
				double begindays = getDaysByBegindateAndEnddate(session,begindate,mc.findEndDateByDate(begindate));
				if(halfday==1||halfday==3)
				{
					if(begindays>0)
					begindays-=0.5;
				}
				MonthSummary beginms = new MonthSummary(beginyear,beginmonth,begindays);
				list.add(beginms);
				double enddays = getDaysByBegindateAndEnddate(session,enddate.substring(0, 6)+"01",enddate);
				if(halfday==2||halfday==3)
				{
					if(enddays>0)
					enddays-=0.5;
				}
				MonthSummary endms = new MonthSummary(endyear,endmonth,enddays);
				list.add(endms);
			}
			else if(index>2)//跨度大于两个月的情况
			{
				double begindays = getDaysByBegindateAndEnddate(session,begindate,mc.findEndDateByDate(begindate));
				if(halfday==1||halfday==3)
				{
					if(begindays>0)
					begindays-=0.5;
				}
				MonthSummary beginms = new MonthSummary(beginyear,beginmonth,begindays);
				list.add(beginms);
				for(int i=0;i<(index-2);i++)
				{
					thismonth = getNextMonth(thismonth);//下一个月
					String thisdate = thismonth+"01";
					int year  = Integer.parseInt(thismonth.substring(0, 4));
					int month = Integer.parseInt(thismonth.substring(4, 6));
					double days = getDaysByBegindateAndEnddate(session,thisdate,mc.findEndDateByDate(thisdate));
					MonthSummary ms = new MonthSummary(year,month,days);
					list.add(ms);
				}
				double enddays = getDaysByBegindateAndEnddate(session,enddate.substring(0, 6)+"01",enddate);
				if(halfday==2||halfday==3)
				{
					if(enddays>0)
					enddays-=0.5;
				}
				MonthSummary endms = new MonthSummary(endyear,endmonth,enddays);
				list.add(endms);
			}
		}
		return list;
	}
	/**
	 * 根据起始日期截止日期返回期间总[工作日]天数
	 * @param begindate
	 * @param enddate
	 * @param halfday
	 * @return
	 */
	public double getWorkDaysByBegindateAndEnddate(Session session,String begindate,String enddate)
	{
		MyCalendarDAO mcdao = new MyCalendarDAO();
		double days = 0;
		String bd = begindate.replace("-","");
		String ed = enddate.replace("-","");
		if((bd.length()==8)&&(ed.length()==8))
		{
		String sql = "select sum(workday) from t_mycalendar where date>="+bd+" and date <="+ed;
		days = Double.valueOf(String.valueOf(session.createSQLQuery(sql).uniqueResult()));
		}
//		if((!begindate.equals(""))&&mcdao.ifWorkDay(begindate))
//		{
//			days = 1;
//		}
//		String tempdate = begindate;
//		while((!tempdate.equals(enddate))&&(!enddate.equals(""))&&(days<1000))
//		{
//			tempdate = getNextDay(tempdate);
//			if(mcdao.ifWorkDay(tempdate))
//			{
//				days+=1;
//			}
//		}
		return days;
	}
	/**
	 * 根据起始日期截止日期返回期间总天数
	 * @param begindate
	 * @param enddate
	 * @param halfday
	 * @return
	 */
	public double getDaysByBegindateAndEnddate(Session session,String begindate,String enddate)
	{
		double days = 0;
		String bd = begindate.replace("-","");
		String ed = enddate.replace("-","");
		if((bd.length()==8)&&(ed.length()==8))
		{
			String sql = "select count(*) from t_mycalendar where date>="+bd+" and date <="+ed;
			days = Double.valueOf(String.valueOf(session.createSQLQuery(sql).uniqueResult()));
		}
//		String tempdate = begindate;
//		while((!tempdate.equals(enddate))&&(!enddate.equals(""))&&(days<1000))
//		{
//			tempdate = getNextDay(tempdate);
//			days+=1;
//		}
		return days;
	}
	/**
	 * 根据起始日期截止日期返回期间请假的天数  
	 * 
	 */
	public String countsumday()
	{
		MyCalendarDAO mcdao = new MyCalendarDAO();
 		String begindate=ServletActionContext.getRequest().getParameter("begindate"); 	
		String enddate=ServletActionContext.getRequest().getParameter("enddate");	
		String type=ServletActionContext.getRequest().getParameter("type");
		String halfday1=ServletActionContext.getRequest().getParameter("halfday1");
		String halfday2=ServletActionContext.getRequest().getParameter("halfday2");
		begindate=begindate.replace("-", "");
		enddate=enddate.replace("-", "");
		//事，加，年，伤，公，其他
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		System.out.println("type:"+type);
		int inttype = Integer.parseInt(type);
		//只算工作日
		if(Util.leaveworkdays.contains(inttype)){
			double sumdate=getWorkDaysByBegindateAndEnddate(session,begindate,enddate);
			if(sumdate>0&&halfday1.equals("true")&&mcdao.ifWorkDay(begindate)){
				sumdate=sumdate-0.5;
			}
			if(sumdate>0&&halfday2.equals("true")&&mcdao.ifWorkDay(enddate)){
				sumdate=sumdate-0.5;
			}
			sumdates=String.valueOf(sumdate);			
		}
		//算非工作日
		if(Util.leavedays.contains(inttype)){
			double sumdate=getDaysByBegindateAndEnddate(session,begindate,enddate);
			if(halfday1.equals("true")&&sumdate>0){
				sumdate=sumdate-0.5;
			}
			if(halfday2.equals("true")&&sumdate>0){
				sumdate=sumdate-0.5;
			}
			sumdates=String.valueOf(sumdate);			
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		//double sumdate=getWorkDaysByBegindateAndEnddate(begindate,enddate);
		//sumdates=String.valueOf(sumdate);		
		return "success";
		
	}
	public void setSumdates(String sumdates) {
		this.sumdates = sumdates;
	}
	public String getSumdates() {
		return sumdates;
	}
	/**
	 * 根据传入参数计算天数(仅限外出公干使用)
	 * @param begindate
	 * @param enddate
	 * @param bghalfday
	 * @param bdhalfday
	 * @return
	 */
	public double countSumdayForWCGG(Session session,String begindate,String baodaodate,int bghalfday,int bdhalfday)
	{
		MyCalendarDAO mcdao = new MyCalendarDAO();
		begindate=begindate.replace("-", "");
		baodaodate=baodaodate.replace("-", "");
		//只算工作日
		double sumdate=getWorkDaysByBegindateAndEnddate(session,begindate,baodaodate);
		if(sumdate>0&&(bghalfday==2)&&mcdao.ifWorkDay(begindate)){
			sumdate=sumdate-0.5;
		}
		if(sumdate>0&&(bdhalfday==2)&&mcdao.ifWorkDay(baodaodate)){
			sumdate=sumdate-0.5;
		}
		if(sumdate>0&&(bdhalfday==1)&&mcdao.ifWorkDay(baodaodate)){
			sumdate=sumdate-1;
		}
		return sumdate;
		
	}
	/**
	 * 计算当天是本月第几个工作日
	 * @param date
	 * @return
	 */
	public int countThisMonthWorkdaysByDate(Session session,String date)
	{
		String begindate = date.substring(0, 6)+"01";
		int days = 0;
		days = (int)getWorkDaysByBegindateAndEnddate(session,begindate,date);
		System.out.println("日期"+date+"是第"+days+"个工作日");
		return days;
	}
	
	
}
