package office.kqqs.action;

import java.util.List;

import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.mycalendar.dao.MyCalendarDAO;
import office.process.action.GetProcessByPosition;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class SubKqqsPage {
	private String newnumber;
	private String message;
	private String name;
	private String tel;
	private String reason;
	private String qsdate;
	private int shi;
	private int fen;
	private String remark;
	private String thisunder;
	private String qdqt;

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

	public String getQsdate() {
		return qsdate;
	}

	public void setQsdate(String qsdate) {
		this.qsdate = qsdate;
	}
	public int getShi() {
		return shi;
	}

	public void setShi(int shi) {
		this.shi = shi;
	}

	public int getFen() {
		return fen;
	}

	public void setFen(int fen) {
		this.fen = fen;
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

	public String getQdqt() {
		return qdqt;
	}

	public void setQdqt(String qdqt) {
		this.qdqt = qdqt;
	}

	public String execute() throws Exception {
		KqqsPage kp = new KqqsPage();
		UserInfoDAO uidao = new UserInfoDAO();
		KqqsPageDAO kpdao = new KqqsPageDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		GetProcessByPosition gpbp = new GetProcessByPosition();
		DateUtil du = new DateUtil();
		int bu = 0;// 是否补申请0:否，1：是
		int qdqtint=0;
		// int zhi = 0;
		String chu = "";
		String zu = "";
		int process = 0;

		String date = du.getStringDate();
		String index = "000";
		String dai = "0";
		String number = "";
		String result = "success";
		String position = "";
		String shifen = "";
		if(qsdate==null||qsdate.length()==0)
		{
			message = "提交失败,考勤缺失日期未填写";
			return "failed";
		}
		if(thisunder.contains("选择"))
		{
			message = "提交失败,请选择下一级审批人";
			return "failed";
		}
		qsdate = qsdate.replace("-","");
		int qsmonth = Integer.valueOf(qsdate.substring(4, 6));
		int thismonth = Integer.valueOf(date.substring(4, 6));
		int thisday = Integer.valueOf(date.substring(6, 8));
		int thisyearmonth = Integer.valueOf(date.substring(0, 6));
		int qsyearmonth = Integer.valueOf(qsdate.substring(0, 6));
		//是否补单
		if((thismonth-qsmonth)==1||(thismonth-qsmonth)==-11)
		{
			bu=1;
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		List<KqqsPage> list = kpdao.findAllByDate(date);
		int workdays = du.countThisMonthWorkdaysByDate(session, date);
		UserInfo ui = uidao.findByName(name);
		position = ui.getPosition();
		// zhi = Integer.parseInt(position.substring(0, 1));//
		// 职务0主任1处长2团队负责人3小组长4普通员工
		chu = position.substring(2, 3);// 第三位表示处室
		zu = position.substring(4, 5);// 第三位表示处室
		if(!ui.getNewnumber().equals(newnumber))
		{
			dai = "1";
		}
		// 获得审批表编号
//		if (list.isEmpty()) {
//			number = date + "KQQS" + dai + bu + "001";
//		} else {
			//KqqsPage lastlp = list.get(list.size() - 1);
			//String tempnumber = lastlp.getNumber();
			//index = tempnumber.substring(tempnumber.length() - 3, tempnumber.length());// 20151005QJSQ0111
			//index = "000" + String.valueOf(Integer.parseInt(index) + 1);//20160201修改
			index = "000"+fraw.readandwrite("KQQS");
			//index = "000" + String.valueOf(list.size()+1);
			index = index.substring(index.length() - 3, index.length());
			number = date + "KQQS" + dai + bu + index;
//		}
		//是否表中有重复项
		if(kpdao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
		// 获得公干流程编号
		process = gpbp.getKqqsProcess(position);
		//process = 3;//考勤缺失全部到惠总20160414修改
		if (process == 0) {
			result = "nokqqs";
			message = "提交失败，您不需要填此表";
			trans.rollback();
			return result;
		}
		//检查是否有指纹记录
		KqjlDaily kd = kddao.findByDateAndName(qsdate, name);
		if(qdqt.equals("qd")&&!kd.getQdtime().equals(""))
		{
			message = "提交失败，您打了指纹，无需补考勤";
			result = "failed";
			trans.rollback();
			return result;
		}
		if(qdqt.equals("qt")&&!kd.getQttime().equals(""))
		{
			message = "提交失败，您打了指纹，无需补考勤";
			result = "failed";
			trans.rollback();
			return result;
		}
		//检查时间有效性
		if(qsdate.length()<8)
		{
			message = "提交失败，请选择正确的时间";
			result = "failed";
			trans.rollback();
			return result;
		}
		//检查时间有效性
		if(qsdate.compareTo(date)>0)
		{
			message = "提交失败，请选择正确的时间";
			result = "failed";
			trans.rollback();
			return result;
		}
		if(workdays>10)
		{
			if(qsmonth<thismonth)
			{
				message = "提交失败，考勤缺失有效期为次月前5个工作日";
				result = "failed";
				trans.rollback();
				return result;
			}
		}
		//签到签退
		if(qdqt==null)
		{
			qdqtint = 0;
		}
		else if(qdqt.equals("qd"))
		{
			qdqtint = 1;
		}
		else if(qdqt.equals("qt"))
		{
			qdqtint = 2;
		}
		else
		{
			qdqtint = 0;
		}
		//时分
		if(shi<10)
		{
			shifen = "0"+String.valueOf(shi);
		}
		else
		{
			shifen = String.valueOf(shi);
		}
		shifen+=":";
		if(fen<10)
		{
			shifen += "0";
			shifen += String.valueOf(fen);
		}
		else
		{
			shifen += String.valueOf(fen);
		}
		
		//
		//当月月只能补一次
		List<KqqsPage> listkp = kpdao.findAllByQsMonthAndNewnumber(qsdate.substring(0, 6),ui.getNewnumber());//发起人可收回、流转中、审批完毕
		if((!listkp.isEmpty()))
		{
			kp.setCs(listkp.size()+1);
//			message = "提交失败，当月考勤缺失只能补一次";
//			result = "failed";
//			trans.rollback();
//			return result;
		}
		else
		{
			kp.setCs(1);
		}
		kp.setNumber(number);
		kp.setProcess(process);
		kp.setJindu("E");
		kp.setDate(date);
		kp.setStatus(1);
		kp.setPreunder("");
		kp.setThisunder(thisunder);
		kp.setInitiator(newnumber);
		kp.setApplicant(ui.getNewnumber());
		kp.setChu(chu);
		kp.setZu(zu);
		kp.setTel(tel);
		kp.setQdqt(qdqtint);
		kp.setReason(reason);
		kp.setRemark(remark);
		kp.setQsdate(qsdate);
		kp.setQstime(shifen);
		kp.setBu(bu);

		kpdao.merge(kp);
		trans.commit();
		session.flush();
		session.clear();
		session.close();

		return result;
	}
}
