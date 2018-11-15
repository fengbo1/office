package office.yscj.action;
import java.util.List;
import org.hibernate.Query;
import java.io.IOException;
import office.process.action.GetProcessByPosition;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.yscj.dao.TYscjDAO;
import office.yscj.dao.TYscjTempDAO;
import office.yscj.dao.TYscjtzDAO;
import office.yscj.pojo.TYscj;
import office.yscj.pojo.TYscjTemp;
import office.yscj.pojo.TYscjtz;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class SubYscjPage {
	private String newnumber;
	private String message;
	private String zhiwu;
	private String sex;
	private int age;
	private String hukou;
	private String email;
	private String contactpeople;
	private String contactpeopletel;
	private int category;
	private String tocountry;
	private String travelagency;
	private String invitepeople1;
	private String invitepeople2;
	private String qitashuoming;
	private String remark;
	private String invitepeopletel1;
	private String invitepeopletel2;
	private String relationship1;
	private String relationship2;
	private int passporttype;
	private String name;
	private String tel;
	private int reason;
	private int notholiday;
	private String begindate;
	private String enddate;
	private String thisunder;
	private int dai;
	private String chengnuo;
	private String signature;
	private String hidechengnuo;
	private String leaveremark;
	
	
	public String getLeaveremark() {
		return leaveremark;
	}


	public void setLeaveremark(String leaveremark) {
		this.leaveremark = leaveremark;
	}


	public String getChengnuo() {
		return chengnuo;
	}


	public void setChengnuo(String chengnuo) {
		this.chengnuo = chengnuo;
	}


	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}


	public String getHidechengnuo() {
		return hidechengnuo;
	}


	public void setHidechengnuo(String hidechengnuo) {
		this.hidechengnuo = hidechengnuo;
	}
	private double sumday;
	private int afterworkdaysession;
	private int beforeworkdaysession;
	private int notholidaysession;
	private String username;
   // private String time;
	

	public int getNotholidaysession() {
		return notholidaysession;
	}


	public void setNotholidaysession(int notholidaysession) {
		this.notholidaysession = notholidaysession;
	}


	


	public int getAfterworkdaysession() {
		return afterworkdaysession;
	}


	public void setAfterworkdaysession(int afterworkdaysession) {
		this.afterworkdaysession = afterworkdaysession;
	}


	public int getBeforeworkdaysession() {
		return beforeworkdaysession;
	}


	public void setBeforeworkdaysession(int beforeworkdaysession) {
		this.beforeworkdaysession = beforeworkdaysession;
	}
	private String leavepagenumber;
	public String getLeavepagenumber() {
		return leavepagenumber;
	}


	public void setLeavepagenumber(String leavepagenumber) {
		this.leavepagenumber = leavepagenumber;
	}


	public String getInvitepeople1() {
		return invitepeople1;
	}


	public void setInvitepeople1(String invitepeople1) {
		this.invitepeople1 = invitepeople1;
	}

	public String getInvitepeople2() {
		return invitepeople2;
	}

	public void setInvitepeople2(String invitepeople2) {
		this.invitepeople2 = invitepeople2;
	}

	public String getInvitepeopletel1() {
		return invitepeopletel1;
	}

	public void setInvitepeopletel1(String invitepeopletel1) {
		this.invitepeopletel1 = invitepeopletel1;
	}

	public String getInvitepeopletel2() {
		return invitepeopletel2;
	}

	public void setInvitepeopletel2(String invitepeopletel2) {
		this.invitepeopletel2 = invitepeopletel2;
	}

	public String getRelationship1() {
		return relationship1;
	}

	public void setRelationship1(String relationship1) {
		this.relationship1 = relationship1;
	}

	public String getRelationship2() {
		return relationship2;
	}

	public void setRelationship2(String relationship2) {
		this.relationship2 = relationship2;
	}
	
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

	public double getSumday() {
		return sumday;
	}

	public void setSumday(double sumday) {
		this.sumday = sumday;
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

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHukou() {
		return hukou;
	}

	public void setHukou(String hukou) {
		this.hukou = hukou;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactpeople() {
		return contactpeople;
	}

	public void setContactpeople(String contactpeople) {
		this.contactpeople = contactpeople;
	}

	public String getContactpeopletel() {
		return contactpeopletel;
	}

	public void setContactpeopletel(String contactpeopletel) {
		this.contactpeopletel = contactpeopletel;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTocountry() {
		return tocountry;
	}

	public void setTocountry(String tocountry) {
		this.tocountry = tocountry;
	}

	public String getTravelagency() {
		return travelagency;
	}

	public void setTravelagency(String travelagency) {
		this.travelagency = travelagency;
	}


	public String getQitashuoming() {
		return qitashuoming;
	}

	public void setQitashuoming(String qitashuoming) {
		this.qitashuoming = qitashuoming;
	}


	public int getPassporttype() {
		return passporttype;
	}

	public void setPassporttype(int passporttype) {
		this.passporttype = passporttype;
	}

	public int getReason() {
		return reason;
	}

	public void setReason(int reason) {
		this.reason = reason;
	}

	public int getNotholiday() {
		return notholiday;
	}

	public void setNotholiday(int notholiday) {
		this.notholiday = notholiday;
	}

	public int getDai() {
		return dai;
	}

	public void setDai(int dai) {
		this.dai = dai;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() throws Exception
	{
		TYscj ty = new TYscj();
		//TYscjTemp tp= new TYscjTemp();
		UserInfoDAO uidao = new UserInfoDAO();
		TYscjDAO tydao = new TYscjDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		//TYscjTempDAO tpdao = new TYscjTempDAO();
		TYscjtzDAO tzdao = new TYscjtzDAO();
		GetProcessByPosition gpbp = new GetProcessByPosition();
		DateUtil du = new DateUtil();
		
//		int zhi = 0;
		int chu = 0;
		int process = 0;
		int halfday = 0;
		String date = du.getStringDate();
		String index = "000";
		String number = "";
		String result = "success";
		String position = "";
		message = "失败，姓名";
	
		
		/*if(sumday<=0)
		{
			message = "失败，因私出境天数必须大于0天";
			return "failed";
		}*/
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	   /* String hqltp = "";
	    hqltp = "from TYscjTemp";
	    Query querytp = session.createQuery(hqltp);
	    List<TYscjTemp>listtp = querytp.list();
	    if(!listtp.isEmpty())
	    	tp=listtp.get(0);
	    	*/
	    
 	   
 	    UserInfo ui = uidao.findByName(name);//因私出境申请人
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
			index = "000"+fraw.readandwrite("YSCJ");
			index = index.substring(index.length() - 3, index.length());
			number = date + "YSCJ" + dai + index;
//		}
		//是否表中有重复项
		if(tydao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
	
		//获得公干流程编号
		process = gpbp.getYscjProcess(position);
		if(process==0)
		{
			result = "noyscj";
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
	
		
		if(afterworkdaysession==1)
		{
			halfday = 1;
		}
		if(beforeworkdaysession==1)
		{
			halfday = 2;
		}
		if((afterworkdaysession==1)&&(beforeworkdaysession==1))
		{
			halfday = 3;
		}
		if(dai==1)
		{
			//username = username.replace("刘一帆","考勤管理员");
			//remark = remark+"("+username+"代为申请)";
		}
		
	    if((chengnuo.equals(hidechengnuo))&&(!signature.equals("")))
	    {
	    	ty.setRemark("承诺书已签字");
	    }	
		
	    ty.setNotholiday(notholidaysession);
		ty.setHalfday(halfday);
 	    ty.setNumber(number);
 	    ty.setProcess(process);
 	    ty.setJindu("E");
 	    ty.setDate(date);
 	    ty.setStatus(1);
 	    ty.setPreunder("");
 	    ty.setThisunder(thisunder);
 	    ty.setInitiator(newnumber);
 	    ty.setApplicant(ui.getNewnumber());
 	    ty.setChu(String.valueOf(chu));
 	    ty.setZu(position.substring(4, 5));
 	    ty.setTel(tel);
 	    ty.setLeaveremark(leaveremark);
 	    ty.setReason(reason);
 	    ty.setBegindate(begindate.replace("-",""));
 	    ty.setEnddate(enddate.replace("-",""));
 	    ty.setHalfday(halfday);//0无，1第一天下午，2最后一天上午，3=1+2
 	    ty.setSumday(sumday);
 	    //ty.setRemark(remark);
 	    ty.setHukou(hukou);
 	    ty.setCategory(category);
 	    ty.setContactpeople(contactpeople);
 	    ty.setTocountry(tocountry);
 	    ty.setContactpeopletel(contactpeopletel);
 	    ty.setEmail(email);
 	    ty.setQitashuoming(qitashuoming);
 	    if(notholidaysession==1)
 	    {
 	    	ty.setLeavepagenumber(leavepagenumber);
 	    }
 	   if(notholidaysession==0)
	    {
	    	ty.setLeavepagenumber("");
	    }
 	    
 	   // ty.setRemark(time);
 	    if(reason==2)
 	    {
 	    	ty.setInvitepeople(invitepeople1);
 	    }
 	    else if(reason==3)
 	    {
 	    	ty.setInvitepeople(invitepeople2);
 	    }
 	   if(reason==2)
	    {
 		  ty.setInvitepeopletel(invitepeopletel1);
	    }
	    else if(reason==3)
	    {
	      ty.setInvitepeopletel(invitepeopletel2);
	    }
 	  if(reason==2)
	    {
 		    ty.setRelationship(relationship1);
	    }
	    else if(reason==3)
	    {
	    	ty.setRelationship(relationship2);
	    }
 	  
 	    ty.setAge(age);
 	    ty.setZhiwu(zhiwu);
 	    ty.setSex(sex);
 	    ty.setTravelagency(travelagency);
 	    ty.setPassporttype(passporttype);
 	    //ty.setNotholiday(notholiday);
 	    tydao.merge(ty);
 	   /* if(result.equals("success"))//成功，写入申请表信息
 	    {
 	    	TYscjtz tz = new TYscjtz();
 	    	tz.setNumber(number);
 	    	tz.setDate(date);
 	    	tz.setName(name);
 	    	tz.setTocountry(tocountry);
 	    	tz.setSumday(sumday);
 	    	tz.setBegindate(begindate);
 	    	tz.setEnddate(enddate);
 	     	if(passporttype==1)
	    	{
	    		tz.setPassporttype("护照");
	    	
	    	}	
	    	else if (passporttype==2)
	    	{
	    		tz.setPassporttype("港澳通行证");
	    	}
	    	else if(passporttype==3)
	    	{
	    		tz.setPassporttype("台湾通行证");
	    	}
 	     	if(passporttype==1)
	    	{
 	     		tz.setPassportnumber(ui.getPassport());
	    	
	    	}	
	    	else if (passporttype==2)
	    	{
	    		tz.setPassportnumber(ui.getHkpassport());
	    	}
	    	else if(passporttype==3)
	    	{
	    		tz.setPassportnumber(ui.getTwpassport());
	    	}
	    	else 
	    	{
	    		tz.setPassportnumber("无");
	    	}
 	    	if(reason==1)
 	    	{
 	    		tz.setReason("旅游");
 	    	
 	    	}	
 	    	else if (reason==2)
 	    	{
 	    		tz.setReason("探亲");
 	    	}
 	    	else if(reason==3)
 	    	{
 	    		tz.setReason("访友");
 	    	}
 	    	else if (reason==4)
 	    	{
 	    		tz.setReason("其他");
 	    	}
 	    
 			tzdao.merge(tz);
 	    	
 	    	
 	    }*/
 	  /*try{
// 	   for ( int i = 0 ; i < listtp.size() - 1 ; i ++ ) {  
//		   tpdao.delete(listtp.get(i));
//		   } 
// 	  }
 		 String sql = "truncate t_yscj_temp";
 	 	  session.createSQLQuery(sql).executeUpdate();
 	  }
 	 catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
 	 }*/
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
