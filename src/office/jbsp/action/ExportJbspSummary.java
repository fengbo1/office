package office.jbsp.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import office.jbsp.pojo.JbspPage;
import office.jbsp.pojo.JbspPageBean;
import office.jbsp.pojo.JbspSummary;
import office.jbsp.pojo.JbspSummaryBean;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ExportJbspSummary {

	private String year;
	private String name;
	private String keyword;
	private String Path;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	
	public String execute() throws Exception{
		String filePath = "";
		List<JbspSummary> list;
		List<JbspSummaryBean> jsblist = new ArrayList<JbspSummaryBean>();
		ExportExcel<JbspSummaryBean> ex = new ExportExcel<JbspSummaryBean>();
		//String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"年份","姓名","处室",
				"加班次数","加班天数","已抵用天数"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from JbspSummary as js where js.year="+year;
		if(name!=null&&name.length()>0)
		{
			hql += " and js.name like '%"+name+"%'";
		}
		if(keyword!=null&&keyword.length()>0)
		{
			hql += " order by js."+keyword+" desc";
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
			JbspSummary js = list.get(i);
			JbspSummaryBean jsb = new JbspSummaryBean();
			jsb.setYear(String.valueOf(js.getYear()));
			jsb.setName(js.getName());
			jsb.setChu(UserUtil.positionToName(js.getPosition()));
			jsb.setTimes(String.valueOf(js.getTimes()));
			jsb.setDays(String.valueOf(js.getDays()));
			jsb.setDidays(String.valueOf(js.getDidays()));
			
			jsblist.add(jsb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"JBSPsummary"+".xls";
				Path = "JBSPsummary"+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("加班审批汇总表",headers, jsblist, out);
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
