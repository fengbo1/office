package office.leave.action;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import office.jbsp.dao.JbspPageDiDAO;
import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveSummaryDAO;
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

public class BackToLeavePage {
	
	private String name;
	private String newnumber;
	private String begindate;
	private String yearrest="0";
	private String workrest="0";
	private String nowdate;
	private String enddate;
	private String zhiwu;
	private String type;
	private String RadioGroup1;
	private String RadioGroup2;
	private String workyears="0";
    private String remark;
    
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWorkyears() {
		return workyears;
	}

	public void setWorkyears(String workyears) {
		this.workyears = workyears;
	}


	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
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
	
	public String execute() throws Exception
	{
	        
		String names[]=name.split(",");
		String begindates[]=begindate.split(",");
		String enddates[]=enddate.split(",");
		name=names[1];
		name = name.trim();
		begindate = begindates[1];
		begindate = begindate.trim();
		enddate = enddates[1];
		enddate = enddate.trim();
		Date date = new Date();
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		nowdate = bartDateFormat.format(date);
		 
		return "success";
	}


}
