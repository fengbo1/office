package office.pb2.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;

public class SubTbsqPage {
	private String message;
	private String name;//发起人
	private String newnumber;//填表人
	private String tbname;//调班对象
	private String tbdate;//调班日期
	private String reason;//
	private String remark;
	private String thisunder;
	private String autho;
	private int df;
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
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getTbname() {
		return tbname;
	}
	public void setTbname(String tbname) {
		this.tbname = tbname;
	}
	public String getTbdate() {
		return tbdate;
	}
	public void setTbdate(String tbdate) {
		this.tbdate = tbdate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public int getDf() {
		return df;
	}
	public void setDf(int df) {
		this.df = df;
	}
	public String getAutho() {
		return autho;
	}
	public void setAutho(String autho) {
		this.autho = autho;
	}
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		TbsqPageDAO tpdao = new TbsqPageDAO();
		PbMxDAO pmdao = new PbMxDAO();
		String date = du.getStringDate();
		String index = "000";
		String number = "";
		int bu=0;
		message = "提交成功";
		tbdate = tbdate.replace("-","");
		thisunder=thisunder.replaceAll("(\r\n|\r|\n|\n\r)", "");   
		if (date.compareTo(tbdate)>=0&&!autho.contains("I")&&!autho.contains("T"))// 是否补请
		{
			message="失败！调班申请需要提前发起！";
			return "failed";
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			TbsqPage tp = new TbsqPage();
			UserInfo ui = uidao.findByName(name);
			UserInfo uidx=uidao.findByName(tbname);
			
			PbMx pmpre = pmdao.findAllByNameAndDateNull(name, tbdate);
			PbMx pmnow = pmdao.findAllByNameAndDateNull(tbname, tbdate);
			index = "000"+fraw.readandwrite("TBSQ");
			index = index.substring(index.length() - 3, index.length());
			number = date + "TBSQ" + df + bu + index;
			tp.setApplicant(ui.getNewnumber());
			tp.setDate(date);
			tp.setInitiator(newnumber);
			tp.setJindu("");
			tp.setPrejihua("签到时间："+pmpre.getPbqdtime()+"，签退时间："+pmpre.getPbqttime()+"，作业时间："+pmpre.getZytime());
			tp.setNumber(number);
			tp.setNowjihua("签到时间："+pmnow.getPbqdtime()+"，签退时间："+pmnow.getPbqttime()+"，作业时间："+pmnow.getZytime());
			tp.setPreundertake("");
			tp.setProcess(0);
			tp.setReason(reason);
			tp.setRemark(remark);
			tp.setStatus(1);
			tp.setTbdate(tbdate);
			tp.setTbname(tbname);
			tp.setUndertake(thisunder);
			tp.setPretype(pmpre.getWb());
			tp.setNowtype(pmnow.getWb());
			tpdao.merge(tp);
			
		}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
			}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
			return "success";
		}
}
