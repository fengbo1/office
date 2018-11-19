package office.yscj.action;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.yscj.pojo.TYscjtz;
import office.yscj.pojo.TYscjtzBean;
import office.userinfo.dao.UserInfoDAO;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class ExportYscjTz {
	private static Logger logger = Logger.getLogger(ExportYscj.class);
	private String begindate;
	private String enddate;
	private String name;
	private String Path;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	
	public String execute() throws Exception{
		String filePath = "";
		String bd="";
		String ed="";
		String searchnn = "";
		List<TYscjtz> list;
		UserInfoDAO uidao = new UserInfoDAO();
		List<TYscjtzBean> tzblist = new ArrayList<TYscjtzBean>();
		ExportExcel<TYscjtzBean> ex = new ExportExcel<TYscjtzBean>();
		String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"编号","姓名","拟去国家和地区",
				"出国（境）事由","拟出国（境）总天数","拟出国（境）时间","拟回国（境）时间","证件类型",
				"证件编号","护照领取时间","出入境证件归还时间"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from TYscjtz as tz";
		if(strtemp!=null&&strtemp.length()>1)
		{
			//searchnn = uidao.nameToNewnumber(strtemp);
		    hql +=" where tz.name like '%"+strtemp+"%'";
		}
		if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
		{
			bd = begindate.replace("-", "");
			ed = enddate.replace("-", "");
			hql += " and tz.date>='"+bd+"' and tz.date<='"+ed+"'";
		}
	
		hql += " order by tz.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			TYscjtz tz = list.get(i);
			TYscjtzBean tzb = new TYscjtzBean();
			tzb.setNumber(tz.getNumber());
			tzb.setName(tz.getName());
			tzb.setTocountry(tz.getTocountry());
			tzb.setReason(tz.getReason());
			tzb.setSumday(tz.getSumday());
			tzb.setBegindate(tz.getBegindate());
			tzb.setEnddate(tz.getEnddate());
			tzb.setPassporttype(tz.getPassporttype());
			tzb.setPassportnumber(tz.getPassportnumber());
			tzb.setBringtime(tz.getBringtime());
			tzb.setReturntime(tz.getReturntime());
			tzblist.add(tzb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"YSCJTZ"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "YSCJTZ"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, tzblist, out);
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
