package office.wcgg.action;

import java.util.List;

import office.process.action.GetProcessByPosition;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.wcgg.dao.WcggBaodaoDAO;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggBaodao;
import office.wcgg.pojo.WcggPage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 提交外出公干审批表
 * @author htzx
 *
 */
public class SubWcggPage {

	private String newnumber;
	private String message;
	private String name;
	private String tel;
	private String reason;
	private String addr;
	private String begindate;
	private String enddate;
	private String remark;
	private String thisunder;
	private String[] people;
	private int dai;
	private double sumdate;
	private String RadioGroup1;
	private String RadioGroup2;
	private String username;
	
	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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

	public double getSumdate() {
		return sumdate;
	}

	public void setSumdate(double sumdate) {
		this.sumdate = sumdate;
	}

	public String getThisunder() {
		return thisunder;
	}

	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String[] getPeople() {
		return people;
	}

	public void setPeople(String[] people) {
		this.people = people;
	}

	public int getDai() {
		return dai;
	}

	public void setDai(int dai) {
		this.dai = dai;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() throws Exception
	{
		WcggPage wp = new WcggPage();
		UserInfoDAO uidao = new UserInfoDAO();
		WcggPageDAO wpdao = new WcggPageDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
		GetProcessByPosition gpbp = new GetProcessByPosition();
		DateUtil du = new DateUtil();
		int bu = 0;// 是否补申请0:否，1：是
//		int zhi = 0;
		int chu = 0;
		int process = 0;
		int halfday = 0;
		String date = du.getStringDate();
		String index = "000";
		String peoplesave = name;
		String number = "";
		String result = "success";
		String position = "";
		message = "失败，姓名";
		
		if(people==null)
		{
			people = new String[0];
		}
		//检查姓名是否重复
		
		for(int i=0;i<people.length;i++)
		{
			if(people[i].equals(name))
			{
				message = "失败，同行人与申请人名字重复，请修改";
				return "failed";
			}
		}
		if(!Util.ifHasSame(people))
		{
			message = "失败，同行人中存在重复名字，请修改";
			return "failed";
		}
		if(sumdate<=0)
		{
			message = "失败，外出公干天数必须大于0天";
			return "failed";
		}
		if (date.compareTo(begindate.replace("-","")) > 0)// 是否补请
		{
			bu = 1;
		}
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    List<WcggPage> list = wpdao.findAllByDate(date);
 	    UserInfo ui = uidao.findByName(name);//外出公干领头人
 	    UserInfo uiinitiator = uidao.findByNewNumber(newnumber);//发起人
 	    if(!uiinitiator.getUsername().equals(name))
 	    {
 	    	dai=1;
 	    }
 	    else
 	    {
 	    	dai=0;
 	    }
 	    position = ui.getPosition();
 	    //zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
 	   
		//获得审批表编号
//		if (list.isEmpty()) {
//			number = date + "WCGG" + dai + bu + "001";
//		} else {
			//index = "000" + String.valueOf(list.size()+1);
			index = "000"+fraw.readandwrite("WCGG");
			index = index.substring(index.length() - 3, index.length());
			number = date + "WCGG" + dai + bu + index;
//		}
		//是否表中有重复项
		if(wpdao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
		//只有考勤管理员有补交外出公干的权限
		if(!uiinitiator.getAuthority().contains("I"))
		{
			if(begindate.replace("-","").compareTo(date)<0)
			{
				message = "提交失败，补交外出公干审批单请联系考勤管理员";
				result = "failed";
				trans.rollback();
				return result;
			}
		}
		//获得公干流程编号
		process = gpbp.getWcggProcess(position,sumdate);
		if(process==0)
		{
			result = "nowcgg";
			message = "您不需要填此表";
		}
		//检查时间有效性
		if(begindate.length()<8||enddate.length()<8)
		{
			message = "提交失败，请选择正确的时间";
			result = "failed";
			trans.rollback();
			return result;
		}
		//
		if(people!=null)
		{
			for(int i=0;i<people.length;i++)//保存公干人信息，以备销假之用
		    {
				peoplesave += "、";
				peoplesave += people[i];
		    }
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
		if(dai==1)
		{
			username = username.replace("刘一帆","考勤管理员").replace("冯波","考勤管理员");
			remark = remark+"("+username+"代为申请)";
		}
 	    wp.setNumber(number);
 	    wp.setProcess(process);
 	    wp.setJindu("E");
 	    wp.setDate(date);
 	    wp.setStatus(1);
 	    wp.setPreunder("");
 	    wp.setThisunder(thisunder);
 	    wp.setInitiator(newnumber);
 	    wp.setApplicant(ui.getNewnumber());
 	    wp.setPeople(peoplesave);
 	    wp.setChu(String.valueOf(chu));
 	    wp.setZu(position.substring(4, 5));
 	    wp.setTel(tel);
 	    wp.setReason(reason);
 	    wp.setAddr(addr);
 	    wp.setBegindate(begindate.replace("-",""));
 	    wp.setEnddate(enddate.replace("-",""));
 	    wp.setHalfday(halfday);//0无，1第一天下午，2最后一天上午，3=1+2
 	    wp.setDays(sumdate);
 	    wp.setRemark(remark);
 	    wp.setView(1);//未看
 	    if(result.equals("success"))//成功，写入申请表信息
 	    {
 	    	WcggBaodao wbtemp = new WcggBaodao();
 	    	wbtemp.setName(name);
 	    	wbtemp.setNewnumber(uidao.nameToNewnumber(name));
 	    	wbtemp.setNumber(number);
 	    	wbtemp.setBegindate(begindate.replace("-",""));
 	    	wbtemp.setBaodaodate("");
 			if(RadioGroup1.equals("xw"))
 			{
 				wbtemp.setBghalfday(2);
 			}
 			else
 			{
 				wbtemp.setBghalfday(1);
 			}
 	    	wbtemp.setStatus(0);
 			wbdao.merge(wbtemp);
 	    	
 	    	for(int i=0;i<people.length;i++)//保存公干人信息，以备销假之用
 	    	{
 	    		WcggBaodao wb = new WcggBaodao();
 	    		String tempnewnumber = uidao.nameToNewnumber(people[i]);
 	    		if(tempnewnumber.equals("notfound"))//如果没有发现姓名
 	    		{
 	    			message+="【"+people[i]+"】、";
 	    			result = "failed";
 	    			
 	    		}
 	    		else
 	    		{
 	    			wb.setName(people[i]);
 	    			wb.setNewnumber(tempnewnumber);
 	    			wb.setNumber(number);
 	    			wb.setBegindate(begindate.replace("-",""));
 	    			wb.setBaodaodate("");
 	    			if(RadioGroup1.equals("xw"))
 	    			{
 	    				wb.setBghalfday(2);
 	    			}
 	    			else
 	    			{
 	    				wb.setBghalfday(1);
 	    			}
 	    			wb.setStatus(0);
 	    			wbdao.merge(wb);
 	    		}
 	    	}
 	    	message+="有误，工具无法匹配";
 	    	if(result.equals("failed"))
 	    	{
 	    		trans.rollback();
 	    		return result;
 	    	}
 	    	if(!ifSameChu(peoplesave))
 	    	{
 	    		message = "外出公干人员应该为同一处室，请返回重新选择";
 	    		trans.rollback();
 	    		return "failed";
 	    	}
 	    	if(result.equals("success"))
 	    	{
 	    		wpdao.merge(wp);
 	    	}
 	    	else
 	    	{
 	    		trans.rollback();
	    		return result;
 	    	}
 	    	
 	    }
 	    
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return result;
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
