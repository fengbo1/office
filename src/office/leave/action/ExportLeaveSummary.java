package office.leave.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import office.leave.pojo.LeaveSummary;
import office.leave.pojo.LeaveSummaryBean;
import office.userinfo.dao.UserInfoDAO;
import office.util.ExportExcel;
import office.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ExportLeaveSummary {

	private String Path;
	private int year;
	private String name;
	private int chutuan;
	private String keyword;
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String execute() throws Exception{
		String filePath = "";
		UserInfoDAO uidao = new UserInfoDAO();
		List<LeaveSummary> list;
		String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		List<LeaveSummaryBean> lsblist = new ArrayList<LeaveSummaryBean>();
		ExportExcel<LeaveSummaryBean> ex = new ExportExcel<LeaveSummaryBean>();
		String[] headers = {"年度","姓名","员工编号","年假总天数",
				"年假已请天数","加班调休可休天数","加班调休已请天数",
				"病假已请天数","事假已请天数","婚假已请天数",
				"产假已请天数","探亲假（配偶）已请天数",
				"探亲假（父母）已请天数","丧假已请天数",
				"工伤假假已请天数","公假已请天数","产检已请天数","陪考假已请天数","哺乳假已请天数"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from LeaveSummary as ls";
		hql += " where ls.year="+year;
		if(chutuan>=1&&chutuan<=6)
		{
			hql += " and ls.position like '__"+chutuan+"__'";
		}
		if(chutuan>6&&chutuan<10)//789
		{
			String temptuan = String.valueOf(chutuan-6);
			hql +=  " and ls.position like '__3_"+temptuan+"'";
		}
		if(chutuan>9&&chutuan<13)//101112
		{
			String temptuan = String.valueOf(chutuan-9);
			hql +=  " and ls.position like '__6_"+temptuan+"'";
		}
		if(strtemp!=null&&strtemp.length()>1)
		{
			hql += " and ls.name='"+strtemp+"'";
		}
		if(keyword!=null&&keyword.length()>0)
		{
			hql += " order by ls."+keyword+" desc";
		}
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			
			LeaveSummary ls = list.get(i);
			LeaveSummaryBean lsb = new LeaveSummaryBean();
			lsb.setYear(ls.getYear());
			lsb.setName(ls.getName());
			lsb.setNewnumber(ls.getNewnumber());
			lsb.setYearall(ls.getYearall());
			lsb.setYearleave(ls.getYearleave());
			lsb.setWorkrest(ls.getWorkrest());
			lsb.setWorkleave(ls.getWorkleave());
			lsb.setBingleave(ls.getBingleave());
			lsb.setShileave(ls.getShileave());
			lsb.setHunleave(ls.getHunleave());
			lsb.setChanleave(ls.getChanleave());
			lsb.setTanpoleave(ls.getTanpoleave());
			lsb.setTanfmleave(ls.getTanfmleave());
			lsb.setSangleave(ls.getSangleave());
			lsb.setShangleave(ls.getShangleave());
			lsb.setGongleave(ls.getGongleave());
			lsb.setQitaleave(ls.getQitaleave());
			lsb.setPeikaoleave(ls.getPeikaoleave());
			lsb.setBuruleave(ls.getBuruleave());
			lsblist.add(lsb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"QJSQsummary.xls";
				Path = "QJSQsummary.xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("请假申请汇总表",headers, lsblist, out);
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
