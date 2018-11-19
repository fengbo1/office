package office.jbsp.action;

import java.util.List;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.process.action.GetProcessByPosition;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class SubJbspPage {
	private String newnumber;
	private String message;
	private String name;
	private String tel;
	private String reason;
	private String begindate;
	private String enddate;
	private String remark;
	private String thisunder;
	private String[] people;
	private int dai;
	private double sumdate;
	private String RadioGroup1;
	private String RadioGroup2;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getThisunder() {
		return thisunder;
	}

	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
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

	public double getSumdate() {
		return sumdate;
	}

	public void setSumdate(double sumdate) {
		this.sumdate = sumdate;
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

	public String execute() throws Exception {
		JbspPage jp = new JbspPage();
		UserInfoDAO uidao = new UserInfoDAO();
		JbspPageDAO jpdao = new JbspPageDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		GetProcessByPosition gpbp = new GetProcessByPosition();
		DateUtil du = new DateUtil();
		int bu = 0;
		
		String chu = "";
		String zu = "";
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

		if (date.compareTo(begindate.replace("-", "")) > 0)
		{
			bu = 1;
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();

		List<JbspPage> list = jpdao.findAllByDate(date);
		UserInfo ui = uidao.findByName(name);
		if(ui==null)
		{
			message += "【"+name+"】有误";
			trans.rollback();
			return "failed";
		}
		position = ui.getPosition();
		
		chu = position.substring(2, 3);
		zu = position.substring(4, 5);

//		if (list.isEmpty()) {
//			number = date + "JBSP" + dai + bu + "001";
//		} else {
			//JbspPage lastlp = list.get(list.size() - 1);
			//String tempnumber = lastlp.getNumber();
			index = "000"+fraw.readandwrite("JBSP");
			//index = "000" + String.valueOf(list.size()+1);
			index = index.substring(index.length() - 3, index.length());
			number = date + "JBSP" + dai + bu + index;
//		}
	
		if(jpdao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
		
		process = gpbp.getJbspProcess(position);
		if (process == 0) {
			result = "nojbsp";
			message = "提交失败，您不需要填此表";
			trans.rollback();
			return result;
		}
	
		if(begindate.length()<8||enddate.length()<8)
		{
			message = "提交失败，请选择正确的时间";
			result = "failed";
			trans.rollback();
			return result;
		}
		if(sumdate<=0)
		{
			message = "失败，加班天数必须大于0天";
			trans.rollback();
			return "failed";
		}
		//
		if(people!=null)
		{
			for (int i = 0; i < people.length; i++)
			{
				peoplesave += "、";
				peoplesave += people[i];
			}
		}
		
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
		jp.setNumber(number);
		jp.setProcess(process);
		jp.setJindu("E");
		jp.setDate(date);
		jp.setStatus(1);
		jp.setPreunder("");
		jp.setThisunder(thisunder);
		jp.setInitiator(newnumber);
		jp.setApplicant(ui.getNewnumber());
		jp.setPeople(peoplesave);
		jp.setChu(chu);
		jp.setZu(zu);
		jp.setTel(tel);
		jp.setReason(reason);
		jp.setBegindate(begindate.replace("-", ""));
		jp.setEnddate(enddate.replace("-", ""));
		jp.setHalfday(halfday);
		jp.setDays(sumdate);
		jp.setRemark(remark);

		if (result.equals("success"))
		{
			for (int i = 0; i < people.length; i++)
			{
				String tempnewnumber = uidao.nameToNewnumber(people[i]);
				if (tempnewnumber.equals("notfound"))
				{
					message += "【" + people[i] + "】、";
					result = "failed";
				}
			}
			message += "有误，工具无法匹配";
			if(result.equals("failed"))
			{
				trans.rollback();
				return result;
			}
			if(!ifSameChu(peoplesave))
 	    	{
 	    		message = "加班人员应该为同一处室，请返回重新选择";
 	    		trans.rollback();
 	    		return "failed";
 	    	}
			if (result.equals("success")) {
				jpdao.merge(jp);
			} else {
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
