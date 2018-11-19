package office.pb2.action;

import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.process.action.GetProcessByPosition;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class SubYgxxPage {

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
	private String thisunder;
	private String qita;
	private String remark;
	private String message;
	
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

	public void setDay(int day) {
		this.day = day;
	}



	public void setHour(int hour) {
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getThisunder() {
		return thisunder;
	}

	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}

	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		XxsqPageDAO xpdao = new XxsqPageDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		ProcessYgxxHz pyh = new ProcessYgxxHz();
		GetProcessByPosition gpbp = new GetProcessByPosition();
		int halfday = 0;
		int bu=0;
		int dayhour = 0;
		String date = du.getStringDate();
		String index = "000";
		String number = "";
		String peoplesave = "";
		String hql = "";
		String posxx = "";//下线员工position
		begindate = begindate.replace("-", "");
		enddate = enddate.replace("-", "");
		message = "提交成功";
		thisunder=thisunder.replaceAll("(\r\n|\r|\n|\n\r)", "");   
		if(people==null)
		{
			message = "失败！下线员工不能为空";
			return "failed";
		}
		if (date.compareTo(begindate) > 0)// 是否补请
		{
			bu = 1;
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		XxsqPage xp = new XxsqPage();
		try {
			
			UserInfo ui = uidao.findByName(name);
			index = "000"+fraw.readandwrite("YGXX");
			index = index.substring(index.length() - 3, index.length());
			number = date + "YGXX" + "0" + bu + index;
			
			
			if(begindate.length()<8||enddate.length()<8)
			{
				message = "失败！请选择正确的时间";
				//trans.rollback();
				return "failed";
			}
			if(!ifsamequarter(begindate,enddate))
			{
				message = "失败！起始日期和截止日期跨季度，请拆成两条提交";
				//trans.rollback();
				return "failed";
			}
			//计算halfday
			if(RadioGroup1.equals("xw"))
			{
				halfday = 1;
			}
			if(RadioGroup2.equals("sw"))
			{
				halfday = 2;
			}
			if(RadioGroup1.equals("xw")&&RadioGroup2.equals("sw"))
			{
				halfday = 3;
			}
			if(people!=null)
			{
				for (int i = 0; i < people.length; i++)// 保存下线人信息
				{
					UserInfo uitemp = uidao.findByName(people[i]);
					if(uitemp==null)
					{
						message = "失败！您输入的姓名【"+people[i]+"】不存在！";
						return "failed";
					}
					if(xpdao.ifFindContain(begindate, enddate, people[i],halfday))
					{
						message = "失败！发现姓名【"+people[i]+"】，下线日期"+begindate+"-"+enddate+"重复";
						return "failed";
					}
					if(i!=0)
						peoplesave += "、";
					    peoplesave += people[i];
				}
			}
			if(!ifSameChu(peoplesave))
 	    	{
 	    		message = "多个因公下线人员应该为同一处室，请返回重新选择";
 	    		//trans.rollback();
 	    		return "failed";
 	    	}
			UserInfo uitemp = uidao.findByName(peoplesave.split("、")[0]);
			//获得因公下线流程编号
			double days = (double)day+(double)hour/6;
			int process = gpbp.getYGXXProcess(ui.getPosition(),uitemp.getPosition(),days);
			
			xp.setNumber(number);
			xp.setProcess(process);
			xp.setJindu("E");
			xp.setDate(du.getStringDate());
			xp.setStatus(1);
			xp.setPreundertake("");
			xp.setUndertake(thisunder);
			xp.setInitiator(ui.getNewnumber());
			xp.setApplicant(ui.getNewnumber());
			xp.setPeople(peoplesave);
			xp.setTel(tel);
			xp.setBegindate(begindate);
			xp.setEnddate(enddate);
			xp.setHalfday(halfday);
			xp.setDay(day);
			xp.setHour(hour);
			xp.setType(0);
			xp.setReason(reason);
			xp.setQita(qita);
			xp.setRemark(remark);
			xp.setChu(ui.getPosition().substring(2,3));
			xp.setView(1);
			xpdao.merge(xp);
			
		}catch (Exception e) {
		trans.rollback();//出错回滚
		e.printStackTrace();
		}finally{
		 trans.commit();
         session.flush();
         session.clear();
         session.close();
	}
		pyh.process(xp);
		return "success";
	}
	/**
	 * 判断是否是同一个季度
	 * 12-2,3-5,6-8,9-11
	 * @param begindate
	 * @param enddate
	 * @return
	 */
	public boolean ifsamequarter(String begindate,String enddate)
	{
		int by = Integer.parseInt(begindate.substring(0, 4));
		int ey = Integer.parseInt(enddate.substring(0, 4));
		int bq = Integer.parseInt(begindate.substring(4, 6));
		int eq = Integer.parseInt(enddate.substring(4, 6));
		if(by==ey)//同一年
		{
			if(bq>=1&&bq<=2&&eq>=1&&eq<=2)//1季度
			{
				return true;
			}
			else if(bq>=3&&bq<=5&&eq>=3&&eq<=5)//2季度
			{
				return true;
			}
			else if(bq>=6&&bq<=8&&eq>=6&&eq<=8)//3季度
			{
				return true;
			}
			else if(bq>=9&&bq<=11&&eq>=9&&eq<=11)//4季度
			{
				return true;
			}
			else if(bq==12&&eq==12)//1季度
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if((ey-by)==1)
		{
			if(eq>=1&&eq<=2&&bq==12)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	/**
	 * 判断两个人是否是同一个处室
	 * @param name1
	 * @param name2
	 * @return 是true,否false
	 */
	public boolean ifSameChu(String name1,String name2)
	{
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui1 = uidao.findByName(name1);
		UserInfo ui2 = uidao.findByName(name2);
		String chu1 = ui1.getPosition().substring(2, 3);
		String chu2 = ui2.getPosition().substring(2, 3);
		if(chu1.equals(chu2))
		{
			return true;	
		}
		else
		{
			return false;
		}
	}
	public boolean ifSameChu(String names)
	{
		String[] name = names.split("、");
		for(int i=0;i<name.length;i++)
		{
			for(int j=i;j<name.length;j++)
			{
				if(!ifSameChu(name[i],name[j]))
				{
					return false;
				}
			}
		}
		return true;
	}
}
