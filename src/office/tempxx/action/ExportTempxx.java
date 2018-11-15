package office.tempxx.action;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.tempxx.dao.TPeopleworkDAO;
import office.tempxx.pojo.TPeoplework;
import office.tempxx.pojo.TTempxiaxian;
import office.tempxx.pojo.TempXxBean;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.ExportDuoExcel;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;
import office.wcgg.pojo.WcggPage;
import office.wcgg.pojo.WcggPageBean;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ExportTempxx {
   private LeavePage lp;
   private LeavePageDAO lpdao;
   private XxsqPage xp;
   private XxsqPageDAO xpdao;
   private MyCalendar mc;
   private MyCalendarDAO mcdao;
   private TPeoplework tw;
   private TPeopleworkDAO twdao;
   private UserInfo ui;
   private UserInfoDAO uidao;
   private String Path;
   private String year;
   
public String getYear() {
	return year;
}

public void setYear(String year) {
	this.year = year;
}

public String getPath() {
	return Path;
}

public void setPath(String path) {
	Path = path;
}

public LeavePage getLp() {
	return lp;
}

public void setLp(LeavePage lp) {
	this.lp = lp;
}

public LeavePageDAO getLpdao() {
	return lpdao;
}

public void setLpdao(LeavePageDAO lpdao) {
	this.lpdao = lpdao;
}

public XxsqPage getXp() {
	return xp;
}

public void setXp(XxsqPage xp) {
	this.xp = xp;
}

public XxsqPageDAO getXpdao() {
	return xpdao;
}

public void setXpdao(XxsqPageDAO xpdao) {
	this.xpdao = xpdao;
}

public MyCalendar getMc() {
	return mc;
}

public void setMc(MyCalendar mc) {
	this.mc = mc;
}

public MyCalendarDAO getMcdao() {
	return mcdao;
}

public void setMcdao(MyCalendarDAO mcdao) {
	this.mcdao = mcdao;
}

public TPeoplework getTw() {
	return tw;
}

public void setTw(TPeoplework tw) {
	this.tw = tw;
}

public TPeopleworkDAO getTwdao() {
	return twdao;
}

public void setTwdao(TPeopleworkDAO twdao) {
	this.twdao = twdao;
}

public UserInfo getUi() {
	return ui;
}

public void setUi(UserInfo ui) {
	this.ui = ui;
}

public UserInfoDAO getUidao() {
	return uidao;
}

public void setUidao(UserInfoDAO uidao) {
	this.uidao = uidao;
}

public String execute() throws Exception
	{
	DateUtil du = new DateUtil();
	String filePath = "";
	String bd="";
	String ed="";
	year = String.valueOf(du.getThisYear());
	List<TTempxiaxian> list1;
	List<TTempxiaxian> list2;
	List<TTempxiaxian> list3;
	List<TTempxiaxian> list4;
	List<TTempxiaxian> list5;
	List<TTempxiaxian> list6;
	List<TTempxiaxian> list7;
	List<TTempxiaxian> list8;
	List<TTempxiaxian> list9;
	List<TTempxiaxian> list10;
	List<TTempxiaxian> list11;
	List<TTempxiaxian> list12;
	UserInfoDAO uidao = new UserInfoDAO();
	List<TempXxBean> wpblist1 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist2 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist3 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist4 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist5 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist6 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist7 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist8 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist9 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist10 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist11 = new ArrayList<TempXxBean>();
	List<TempXxBean> wpblist12 = new ArrayList<TempXxBean>();
	ExportDuoExcel<TempXxBean> ex = new ExportDuoExcel<TempXxBean>();
	//String strtemp = new String(applicant.getBytes("ISO8859-1"),"UTF-8");
	String[] headers = {"机构/处室","生产班组","操作员名称","工号",
			"所在班组","下线原因","说明","起始日期","截止日期",
			"下线时间段","原排班班型","上报日期","备注"};
	Query query1;
	Query query2;
	Query query3;
	Query query4;
	Query query5;
	Query query6;
	Query query7;
	Query query8;
	Query query9;
	Query query10;
	Query query11;
	Query query12;
	Session session = HibernateSessionFactory.getSession();
	Transaction trans = session.beginTransaction();
	String hql1 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0101' and tt.reportdate<='"+year+"0131' order by tt.reportdate";
	String hql2 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0201' and tt.reportdate<='"+year+"0229' order by tt.reportdate";
	String hql3 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0301' and tt.reportdate<='"+year+"0331' order by tt.reportdate";
	String hql4 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0401' and tt.reportdate<='"+year+"0430' order by tt.reportdate";
	String hql5 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0501' and tt.reportdate<='"+year+"0531' order by tt.reportdate";
	String hql6 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0601' and tt.reportdate<='"+year+"0630' order by tt.reportdate";
	String hql7 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0701' and tt.reportdate<='"+year+"0731' order by tt.reportdate";
	String hql8 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0801' and tt.reportdate<='"+year+"0831' order by tt.reportdate";
	String hql9 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"0901' and tt.reportdate<='"+year+"0930' order by tt.reportdate";
	String hql10 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"1001' and tt.reportdate<='"+year+"1031' order by tt.reportdate";
	String hql11 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"1101' and tt.reportdate<='"+year+"1130' order by tt.reportdate";
	String hql12 = "from TTempxiaxian as tt where tt.reportdate>='"+year+"1201' and tt.reportdate<='"+year+"1231' order by tt.reportdate";

	System.out.println(hql1);
	System.out.println(hql2);
	System.out.println(hql3);
	System.out.println(hql4);
	System.out.println(hql5);
	System.out.println(hql6);
	System.out.println(hql7);
	System.out.println(hql8);
	System.out.println(hql9);
	System.out.println(hql10);
	System.out.println(hql11);
	System.out.println(hql12);
	query1 = session.createQuery(hql1);
	query2 = session.createQuery(hql2);
	query3 = session.createQuery(hql3);
	query4 = session.createQuery(hql4);
	query5 = session.createQuery(hql5);
	query6 = session.createQuery(hql6);
	query7 = session.createQuery(hql7);
	query8 = session.createQuery(hql8);
	query9 = session.createQuery(hql9);
	query10 = session.createQuery(hql10);
	query11 = session.createQuery(hql11);
	query12 = session.createQuery(hql12);
	list1 = query1.list();
	list2 = query2.list();
	list3 = query3.list();
	list4 = query4.list();
	list5 = query5.list();
	list6 = query6.list();
	list7 = query7.list();
	list8 = query8.list();
	list9 = query9.list();
	list10 = query10.list();
	list11 = query11.list();
	list12 = query12.list();	
	trans.commit();
	session.flush();
	session.clear();
	session.close();
	for(int i=0;i<list1.size();i++)
	{
		TTempxiaxian ttxx = list1.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist1.add(wpb);
	}


	for(int i=0;i<list2.size();i++)
	{
		TTempxiaxian ttxx = list2.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist2.add(wpb);
	}
	for(int i=0;i<list3.size();i++)
	{
		TTempxiaxian ttxx = list3.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist3.add(wpb);
	}
	for(int i=0;i<list4.size();i++)
	{
		TTempxiaxian ttxx = list4.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist4.add(wpb);
	}
	for(int i=0;i<list5.size();i++)
	{
		TTempxiaxian ttxx = list5.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist5.add(wpb);
	}
	for(int i=0;i<list6.size();i++)
	{
		TTempxiaxian ttxx = list6.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist6.add(wpb);
	}
	for(int i=0;i<list7.size();i++)
	{
		TTempxiaxian ttxx = list7.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist7.add(wpb);
	}
	for(int i=0;i<list8.size();i++)
	{
		TTempxiaxian ttxx = list8.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist8.add(wpb);
	}
	for(int i=0;i<list9.size();i++)
	{
		TTempxiaxian ttxx = list9.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist9.add(wpb);
	}
	for(int i=0;i<list10.size();i++)
	{
		TTempxiaxian ttxx = list10.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist10.add(wpb);
	}

	for(int i=0;i<list11.size();i++)
	{
		TTempxiaxian ttxx = list11.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist11.add(wpb);
	}
	for(int i=0;i<list12.size();i++)
	{
		TTempxiaxian ttxx = list12.get(i);
		TempXxBean wpb = new TempXxBean();
		wpb.setBegindate(ttxx.getBegindate());
		wpb.setChu(ttxx.getChu());
		wpb.setEnddate(ttxx.getEnddate());
		wpb.setName(ttxx.getName());
		wpb.setOpnumber(ttxx.getOpnumber());
		wpb.setOpzu(ttxx.getOpzu());
		wpb.setReason(ttxx.getReason());
		wpb.setRemark(ttxx.getRemark());
		wpb.setReportdate(ttxx.getReportdate());
		wpb.setShuoming(ttxx.getShuoming());
		wpb.setZu(ttxx.getZu());
		wpblist12.add(wpb);
	}
	//导出
	 try {
		 	filePath=Util.downloadpath+"LSXX"+".xls";
		 	//logger.info("导出路径"+filePath);
			Path = "LSXX"+".xls";
			OutputStream out = new FileOutputStream(filePath);
			ex.exportExcel("计划外临时下线统计表",headers, wpblist1,wpblist2,wpblist3,wpblist4,wpblist5,wpblist6,wpblist7,wpblist8,wpblist9,wpblist10,wpblist11,wpblist12, out);
			out.close();
			System.out.println("excel导出成功！");
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	return "success";
	}
}
