package office.leave.action;

import java.util.List;

import office.config.dao.ConfigDAO;
import office.config.pojo.Config;
import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveSummaryDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveSummary;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.LeaveUtil;
import office.util.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 提交请假申请
 * 
 * @author htzx
 * 
 */
public class SubLeavePage {
	private String name;// 申请人姓名
	private String xuanze;//选择的审批人
	private String number;// 申请书编号
	private String newnumber;//登陆人/发起人新一代编号
	private String date;// 发起申请的时间
	private int dai;// 是否代申请0：本人，1：代申请
	private int chu;// 处室
	private int tuan;// 团队
	private String zhiwu;// 职务
	private int workyears;// 连续工龄
	private int type;// 请假类型
	private String begindate;// 休假开始时间
	private String enddate;// 休假结束时间
	private double sumdate;// 休假天数
	private String remark;// 备注
	private String message;
	private String qita;
	private String RadioGroup1;
	private String RadioGroup2;
	private String bzm;
	private String username;

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDai() {
		return dai;
	}

	public void setDai(int dai) {
		this.dai = dai;
	}

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
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

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}

	public int getTuan() {
		return tuan;
	}

	public void setTuan(int tuan) {
		this.tuan = tuan;
	}

	public int getWorkyears() {
		return workyears;
	}

	public void setWorkyears(int workyears) {
		this.workyears = workyears;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getSumdate() {
		return sumdate;
	}

	public void setSumdate(double sumdate) {
		this.sumdate = sumdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getXuanze() {
		return xuanze;
	}

	public void setXuanze(String xuanze) {
		this.xuanze = xuanze;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
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

	public String getQita() {
		return qita;
	}

	public void setQita(String qita) {
		this.qita = qita;
	}

	public String getBzm() {
		return bzm;
	}

	public void setBzm(String bzm) {
		this.bzm = bzm;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() throws Exception {

		LeavePageDAO lpdao = new LeavePageDAO();
		LeavePage lp = new LeavePage();
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		UserInfo uishenqing = new UserInfo();//申请人信息
		//UserInfo uifaqi =new UserInfo();//发起人信息
		int process = 0;
		int halfday = 0;
		String position = "";
		String jindu = "";//审批进度
		String result = "success";
		char zu;//小组
		date = du.getStringDate();
		String index = "000";
		int bu = 0;// 是否补申请0:否，1：是
		begindate = begindate.replace("-", "");
		enddate = enddate.replace("-", "");
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		//trans.registerSynchronization(arg0)
		List<LeavePage> list = lpdao.findAllByDate(date);
		uishenqing = uidao.findByName(name);
		UserInfo uikqmaster = uidao.findAllByAuthority("I").get(0);//考勤管理员
		UserInfo uiinitiator = uidao.findByNewNumber(newnumber);//发起人
		//uifaqi = uidao.findByNewNumber(newnumber);
		position = uishenqing.getPosition();
		int zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		zu = position.charAt(4);
		if((zu>'0')&&(zu<'9'))
		{
			tuan = Integer.parseInt(position.substring(4, 5));//团队
		}
		if (date.compareTo(begindate) > 0)// 是否补请
		{
			bu = 1;
		}
			index = "000"+fraw.readandwrite("QJSQ");
			index = index.substring(index.length() - 3, index.length());
			number = date + "QJSQ" + dai + bu + index;
		lp.setNumber(number);
		lp.setDate(date);
		lp.setStatus(9);// 审批状态1，流转中,9,发起人可收回
		lp.setPreundertake("");
		xuanze=xuanze.replaceAll("\r\n", "");
		lp.setUndertake(xuanze.split(",")[0]);
		lp.setInitiator(newnumber);
		lp.setApplicant(uishenqing.getNewnumber());
		// 判断属于哪个流程
		if (zhi == 0)// 主任
		{
			message = "主任不需要请假";
			result = "failed";
		} else if ((zhi == 1)&&(chu==1)) {// 惠总
			//process = 5;
			process = 18;
			result = "success";		
		}else if(zhi==1)// 其他处室负责人
			{
			//process = 4;
			process = 17;
			result = "success";
			}else {
				if((type==1||type==2||type==3||type==11||type==12)&&(sumdate<=1.0))//一天以内
				{
					if((chu==2||chu==3||chu==6)&&zhi==3)//生产人员普通员工
					{
						process = 13;
					}
					else if((chu==2||chu==3||chu==6)&&zhi==4)//生产人员组长员工
					{
						process = 14;
					}
					else
					{
						process = 16;
					}
				}
				else//一天以上和所有其他假
				{
					if((chu==2||chu==3||chu==6)&&zhi==3)//生产人员普通员工
					{
						process = 11;
					}
					else if((chu==2||chu==3||chu==6)&&zhi==4)//生产人员组长员工
					{
						process = 12;
					}
					else
					{
						if(chu==1)
						{
							process = 17;
						}
						else
						{
							process = 15;
						}
					}
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
		//判断当前提交的请假表与流转中的请假事项之和是否超过限制
		message = ifLargeThan(session,type,sumdate,begindate,enddate,uishenqing.getNewnumber(),halfday);
		if(!message.equals("success"))
		{
			result = "failed";
		}
		//是否表中有重复项
		if(lpdao.findByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
		//只有考勤管理员有补交请假单的权限
		if(!uiinitiator.getAuthority().contains("I"))
		{
			if(begindate.compareTo(date)<0)
			{
				message = "提交失败，休假日期早于申请日期请联系考勤管理员告知原因，由考勤管理员代为发起";
				result = "failed";
			}
		}
		if(sumdate<=0)
		{
			message = "提交失败，请假总天数应该大于0";
			result = "failed";
		}
		if(begindate.compareTo(enddate)>0)
		{
			message = "提交失败，起始日期应该小于截止日期";
			result = "failed";
		}
		if(type!=6&&type!=7&&type!=9&&xuanze.contains("aaa"))
		{
			message = "提交失败，请选择下一审批人";
			result = "failed";
		}
		if(dai==1)
		{
			username = username.replace("刘一帆","考勤管理员").replace("冯波","考勤管理员");
			remark = remark+"("+username+"代为申请)";
		}
		lp.setDai(dai);
		lp.setChu(chu);
		lp.setTuan(tuan);
		lp.setZhiwu(zhiwu);
		lp.setWorkage(workyears);
		lp.setType(type);
		lp.setBegindate(begindate);
		lp.setEnddate(enddate);
		lp.setHalfday(halfday);//保存半天情况0无，1第一天下午，2最后一天上午，3=1+2
		lp.setDays(sumdate);
		lp.setRemark(remark);
		lp.setQita(qita);
		lp.setView(1);
		lp.setViewpb(1);
		lp.setProcess(process);
		bzm="yes";
		if(result.equals("success"))//如果成功才保存
		{
			jindu = pdao.findByItemAndApplicant("QJSQ",process).getProcess().substring(0,1);
			lp.setJindu(jindu);
			message = "提交成功";
			lpdao.merge(lp);
			//lpdao.submitLeavePage(number);//更新汇总表状态
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();

		return result;
	}
	/**
	 * 
	 * @param temptype
	 * @param tempsd 总天数
	 * @param tempbd
	 * @param temped
	 * @param tempname
	 * @param temphd  半天标志
	 * @return
	 */
	public String ifLargeThan(Session session,int temptype,double tempsd,String tempbd,String temped,String tempnw,int temphd)
	{
		String result = "success";
		LeavePageDAO lpdao = new LeavePageDAO();
		DateUtil du = new DateUtil();
		LeaveSummaryDAO lsdao = new LeaveSummaryDAO();
		int beginyear = Integer.valueOf(tempbd.substring(0, 4));
		int endyear = Integer.valueOf(temped.substring(0, 4));
		double by = lpdao.findSumByApplicant(tempnw, 169, beginyear,temptype);
		double ey = lpdao.findSumByApplicant(tempnw, 169, endyear,temptype);
		LeaveSummary lastlsby = lsdao.findByYearAndName(beginyear-1, LeaveUtil.NewNumberToNameNoSession(tempnw));
		LeaveSummary lastlsey = lsdao.findByYearAndName(endyear-1, LeaveUtil.NewNumberToNameNoSession(tempnw));
		LeaveSummary lsby = lsdao.findByYearAndName(beginyear, LeaveUtil.NewNumberToNameNoSession(tempnw));
		LeaveSummary lsey = lsdao.findByYearAndName(endyear, LeaveUtil.NewNumberToNameNoSession(tempnw));
		if(beginyear==endyear)//同年
		{
			result = ifyearlarge(lastlsby,lsby,by+tempsd,temptype);
		}
		if((endyear-beginyear)==1)//隔一年
		{
			double bydays = 0.0;
			double eydays = 0.0;
			if(Util.leavedays.contains(temptype))//婚、产、探、病、丧
			{
				bydays = du.getDaysByBegindateAndEnddate(session, tempbd, beginyear+"1231");
				eydays = du.getDaysByBegindateAndEnddate(session, endyear+"0101", temped);
			}
			else
			{
				bydays = du.getWorkDaysByBegindateAndEnddate(session, tempbd, beginyear+"1231");
				eydays = du.getWorkDaysByBegindateAndEnddate(session, endyear+"0101", temped);
			}
			if(temphd==1||temphd==3)
			{
				bydays -= 0.5;
			}
			if(temphd==2||temphd==3)
			{
				eydays -= 0.5;
			}
			result = ifyearlarge(null,lsby,by+bydays,temptype);
			result = ifyearlarge(lsby,lsey,ey+eydays,temptype);
		}
		
		return result;
	}
	/**
	 * 判断加上流转中的天数是否超过限制
	 * @param lastls
	 * @param ls
	 * @param days 请假天数
	 * @param type 请假类型
	 * @return 是否能休
	 */
	public String ifyearlarge(LeaveSummary lastls,LeaveSummary ls,double days,int type)
	{
		String result = "success";
		double lsday = 0.0;
		if(type==2)
		{
			lsday=ls.getYearleave();
			if((lsday+days)>ls.getYearall())
			{
				return "您有流转中的年休假，总天数超过限制";
			}
		}
		if(type==4)
		{
			lsday=ls.getHunleave();
			if((lsday+days)>12)
			{
				return "您有流转中的婚假，总天数超过限制";
			}
		}
//		if(type==11)
//		{
//			lsday=ls.getWorkleave();
//			double duibidays = 0.0;
//			if(lastls!=null)
//			{
//				duibidays = lastls.getWorkrest()+ls.getWorkrest();
//			}
//			else
//			{
//				duibidays = ls.getWorkrest();
//			}
//			if(days>duibidays)
//			{
//				return "您有流转中的加班调休，总天数超过限制";
//			}
//		}
		return result;
	}
}