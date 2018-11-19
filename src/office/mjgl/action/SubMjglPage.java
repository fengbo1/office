package office.mjgl.action;
import java.util.List;
import office.process.action.GetProcessByPosition;
import office.mjgl.dao.TMjglDAO;
import office.mjgl.pojo.TMjgl;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.pojo.TMjglPage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class SubMjglPage {
	
	private String newnumber;
	private String number;
	private Integer process;
    private String message;
    private String remark;
	private String thisunder;
	private String[] people;
	private String RadioGroup1;
    private String newt;
	private String RadioGroup2;
	private String chu;
	private String zu;
	private String changetime;
	public String getChangetime() {
		return changetime;
	}

	public void setChangetime(String changetime) {
		this.changetime = changetime;
	}

	private String  newp1;
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRadioGroup1() {
		return RadioGroup1;
	}

	public void setRadioGroup1(String radioGroup1) {
		RadioGroup1 = radioGroup1;
	}

	public String getNewt() {
		return newt;
	}

	public void setNewt(String newt) {
		this.newt = newt;
	}

	public String getRadioGroup2() {
		return RadioGroup2;
	}

	public void setRadioGroup2(String radioGroup2) {
		RadioGroup2 = radioGroup2;
	}


	public String getNewp1() {
		return newp1;
	}

	public void setNewp1(String newp1) {
		this.newp1 = newp1;
	}

	public String getNewp2() {
		return newp2;
	}

	public void setNewp2(String newp2) {
		this.newp2 = newp2;
	}

	public String getNewp3() {
		return newp3;
	}

	public void setNewp3(String newp3) {
		this.newp3 = newp3;
	}

	public String getNewp4() {
		return newp4;
	}

	public void setNewp4(String newp4) {
		this.newp4 = newp4;
	}

	public String getNewp5() {
		return newp5;
	}

	public void setNewp5(String newp5) {
		this.newp5 = newp5;
	}

	public String getNewp6() {
		return newp6;
	}

	public void setNewp6(String newp6) {
		this.newp6 = newp6;
	}

	public String getNewp7() {
		return newp7;
	}

	public void setNewp7(String newp7) {
		this.newp7 = newp7;
	}

	public String getNewp8() {
		return newp8;
	}

	public void setNewp8(String newp8) {
		this.newp8 = newp8;
	}

	public String getNewp9() {
		return newp9;
	}

	public void setNewp9(String newp9) {
		this.newp9 = newp9;
	}

	public String getNewp10() {
		return newp10;
	}

	public void setNewp10(String newp10) {
		this.newp10 = newp10;
	}

	public String getNewp11() {
		return newp11;
	}

	public void setNewp11(String newp11) {
		this.newp11 = newp11;
	}

	public String getNewp12() {
		return newp12;
	}

	public void setNewp12(String newp12) {
		this.newp12 = newp12;
	}

	public String getNewp13() {
		return newp13;
	}

	public void setNewp13(String newp13) {
		this.newp13 = newp13;
	}

	public String getNewp14() {
		return newp14;
	}

	public void setNewp14(String newp14) {
		this.newp14 = newp14;
	}

	public String getNewp15() {
		return newp15;
	}

	public void setNewp15(String newp15) {
		this.newp15 = newp15;
	}

	public String getNewp16() {
		return newp16;
	}

	public void setNewp16(String newp16) {
		this.newp16 = newp16;
	}

	private String  newp2;
	private String  newp3;
	private String  newp4;
	private String  newp5;
	private String  newp6;
	private String  newp7;
	private String  newp8;
	private String  newp9;
	private String  newp10;
	private String  newp11;
	private String  newp12;
	private String  newp13;
	private String  newp14;
	private String  newp15;
	private String  newp16;
	
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

	public Integer getProcess() {
		return process;
	}

	public void setProcess(Integer process) {
		this.process = process;
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

	public String getChu() {
		return chu;
	}

	public void setChu(String chu) {
		this.chu = chu;
	}

	public String getZu() {
		return zu;
	}

	public void setZu(String zu) {
		this.zu = zu;
	}

	
	public String newp_01(String newp)
		{	
		if(newp==null)
		{
		  return "0";
				
		 }
		else
			{
			return "1";
			}
		}

	public String execute() throws Exception
	{
		TMjgl tm = new TMjgl();
		TMjglPage tp= new TMjglPage();
		TMjglPageDAO tpdao = new TMjglPageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		TMjglDAO tmdao = new TMjglDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
	    GetProcessByPosition gpbp = new GetProcessByPosition();
		DateUtil du = new DateUtil();
		String date = du.getStringDate();
		String peoplesave="";
//		int zhi = 0;
		int chu = 0;
		int process = 0;
		if(people!=null)
		{	
		 peoplesave =people[0];
		for(int i=1;i<people.length;i++)
	    {
			peoplesave += "、";
			peoplesave += people[i];
			
	    }
		}
		String index = "000";
		String number = "";
		String result = "success";
		String position = "";
		message = "失败，姓名";

		//检查姓名是否重复
	
		if((people!=null)&&(!Util.ifHasSame(people)))
		{
			message = "失败，同行人中存在重复名字，请修改";
			return "failed";
		}

		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    //List<TZzzm> list = tzdao.findAllByDate(date);
 	  
 	   // UserInfo initiatorproc = uidao.findByName(name);//发起人
 	    UserInfo initiator = uidao.findByNewNumber(newnumber); 
 	    String name = initiator.getUsername();
 	    String peopleaddinit =peoplesave;
 	    peopleaddinit += "、";
 	    peopleaddinit += name;
 	    tp=tpdao.findAllByName(initiator.getUsername());
 	    position = initiator.getPosition();
 	    //String positionproc = initiatorproc.getPosition();
 	    String auth=initiator.getAuthority();
 	    //zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
 	   
		//获得审批表编号
//		if (list.isEmpty()) {
//			number = date + "WCGG" + dai + bu + "001";
//		} else {
			//index = "000" + String.valueOf(list.size()+1);
			index = "000"+fraw.readandwrite("MJGL");
			index = index.substring(index.length() - 3, index.length());
			number = date + "MJGL" + index;
//		}
		//是否表中有重复项
		if(tmdao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
	
		//获得门禁申请编号
		process = gpbp.getMjglProcess(position,auth);
		if(process==0)
		{
			result = "nomjgl";
			message = "您不需要填此表";
		}
		
		/*if((RadioGroup2=="2")&&(begindate.length()<8||enddate.length()<8))
		{
			message = "提交失败，请选择正确的时间";
			result = "failed";
			trans.rollback();
			return result;
		}*/
		//
	
		newp1=newp_01(newp1);
		newp2=newp_01(newp2);
		newp3=newp_01(newp3);
		newp4=newp_01(newp4);
		newp5=newp_01(newp5);
		newp6=newp_01(newp6);
		newp7=newp_01(newp7);
		newp8=newp_01(newp8);
		newp9=newp_01(newp9);
		newp10=newp_01(newp10);
		newp11=newp_01(newp11);
		newp12=newp_01(newp12);
		newp13=newp_01(newp13);
		newp14=newp_01(newp14);
		newp15=newp_01(newp15);
		newp16=newp_01(newp16);	
		String newp=newp1+newp2+newp3+newp4
	    +newp5+newp6+newp7+newp8
	    +newp9+newp10+newp11+newp12
	    +newp13+newp14+newp15+newp16;
		
		if(RadioGroup1.equals("1")&&RadioGroup2.equals("0"))
		{
			tm.setNewp(newp);
			tm.setNewtime(Integer.parseInt(newt));
			tm.setOldp("2222222222222222");
			//tm.setOldtime(tp.getCurrenttime());
			tm.setChu(String.valueOf(chu));
			tm.setDate(date);
			tm.setJindu("E");
			//tm.setEnddate("wu");
			tm.setRemark2(changetime);
			//tm.setEnddateamorpam("wu");
			tm.setInitiator(newnumber);
			tm.setIstemp(Integer.parseInt(RadioGroup2));
			tm.setNumber(number);
			tm.setPeople(peoplesave);
			tm.setPreunder("");
			tm.setProcess(process);
			tm.setReason(Integer.parseInt(RadioGroup1));
			//tm.setStartdate("wu");
			//tm.setStartdateamorpm("wu");
			tm.setStatus(1);
			tm.setThisunder(thisunder);
			tm.setZu(position.substring(4, 5));
			tm.setRemark1(remark);
			tm.setTempauth("2222222222222222");
			tm.setTemptime(-1);
			
		}
		else if (RadioGroup1.equals("1")&&RadioGroup2.equals("1"))
		{
			tm.setTempauth(newp);
			tm.setTemptime(Integer.parseInt(newt));
			tm.setOldp("2222222222222222");
			//tm.setOldtime(tp.getCurrenttime());
			tm.setChu(String.valueOf(chu));
			tm.setDate(date);
			tm.setJindu("E");
			tm.setRemark2(changetime);
		
			//tm.setEnddateamorpam(RadioGroup4);
			tm.setInitiator(newnumber);
			tm.setIstemp(Integer.parseInt(RadioGroup2));
			//tm.setNewp(tp.getCurrentauth());
			//tm.setNewtime(tp.getCurrenttime());
			tm.setNumber(number);
			tm.setPeople(peoplesave);
			tm.setPreunder("");
			tm.setProcess(process);
			tm.setReason(Integer.parseInt(RadioGroup1));
			
			//tm.setStartdateamorpm(RadioGroup3);
			tm.setStatus(1);
			tm.setThisunder(thisunder);
			tm.setZu(position.substring(4, 5));
			tm.setRemark1(remark);
		}
		else if(RadioGroup2.equals("0"))
		{
			tm.setNewp(newp);
			tm.setNewtime(Integer.parseInt(newt));
			tm.setOldp(tp.getCurrentauth());
			tm.setOldtime(tp.getCurrenttime());
			tm.setChu(String.valueOf(chu));
			tm.setDate(date);
			tm.setJindu("E");
			//tm.setEnddate("wu");
			tm.setRemark2(changetime);
			//tm.setEnddateamorpam("wu");
			tm.setInitiator(newnumber);
			tm.setIstemp(Integer.parseInt(RadioGroup2));
			tm.setNumber(number);
			tm.setPeople(peoplesave);
			tm.setPreunder("");
			tm.setProcess(process);
			tm.setReason(Integer.parseInt(RadioGroup1));
			//tm.setStartdate("wu");
			//tm.setStartdateamorpm("wu");
			tm.setStatus(1);
			tm.setThisunder(thisunder);
			tm.setZu(position.substring(4, 5));
			tm.setRemark1(remark);
			tm.setTempauth("2222222222222222");
			tm.setTemptime(-1);
			
		}
		else if (RadioGroup2.equals("1"))
		{
			tm.setTempauth(newp);
			tm.setTemptime(Integer.parseInt(newt));
			tm.setOldp(tp.getCurrentauth());
			tm.setOldtime(tp.getCurrenttime());
			tm.setChu(String.valueOf(chu));
			tm.setDate(date);
			tm.setJindu("E");
			tm.setRemark2(changetime);
		
			//tm.setEnddateamorpam(RadioGroup4);
			tm.setInitiator(newnumber);
			tm.setIstemp(Integer.parseInt(RadioGroup2));
			tm.setNewp(tp.getCurrentauth());
			tm.setNewtime(tp.getCurrenttime());
			tm.setNumber(number);
			tm.setPeople(peoplesave);
			tm.setPreunder("");
			tm.setProcess(process);
			tm.setReason(Integer.parseInt(RadioGroup1));
			
			//tm.setStartdateamorpm(RadioGroup3);
			tm.setStatus(1);
			tm.setThisunder(thisunder);
			tm.setZu(position.substring(4, 5));
			tm.setRemark1(remark);
		}
 	   /* tz.setNumber(number);
 	    tz.setProcess(process);
 	    tz.setJindu("E");
 	    tz.setDate(date);
 	    tz.setStatus(1);
 	    tz.setPreunder("");
 	    tz.setThisunder(thisunder);
 	    tz.setInitiator(newnumber);
 	    tz.setApplicant(ui.getNewnumber());
 	    tz.setChu(String.valueOf(chu));
 	    tz.setZu(position.substring(4, 5));
 	    tz.setTel(tel);
 	    tz.setZhiwu(zhiwu);
 	    tz.setYongtu(yongtu);
 	    tz.setSex(sex);
 	    tz.setNeednumber(neednumber);
 	    tz.setTodepartment(todepartment);//0无，1第一天下午，2最后一天上午，3=1+2
 	    tz.setRemark(remark);*/
 	   
 	   if(!peoplesave.equals(""))
 		   
 	   {   
 		   if(!ifSameChu(peopleaddinit))
 	   
	    	{
	    		message = "一同申请人员应该为同一处室，请返回重新选择";
	    		trans.rollback();
	    		return "failed";
	    	}
 	   }  
		
 	   if(result.equals("success"))
 	    	{
 	    		tmdao.merge(tm);
 	    	}
 	    	else
 	    	{
 	    		trans.rollback();
	    		return result;
 	    	}
 
 	    	trans.commit();
 			session.flush();
 			session.clear();
 			session.close();
 			
 			return result;
 	    	
 	    }
 	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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


