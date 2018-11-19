package office.pb2.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.pb2.pojo.XxsqPage;
import office.pb2.pojo.YgxxHz;
import office.pb2.pojo.YgxxHzBean;
import office.pb2.pojo.YgxxMxBean;
import office.userinfo.dao.UserInfoDAO;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.Util;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExportYgxxHz {

	private static Logger logger = Logger.getLogger(ExportYgxx.class);
	private int year;
	private int quarter;
	private int chutuan;
	private String name;
	private String Path;
	private String newnumber;

	
	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
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
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public String execute() throws Exception{
		String filePath = "";
		String bd="";
		String ed="";
		String searchnn = "";
		List<YgxxHz> listyhtemp;
		List<YgxxHz> list = new ArrayList<YgxxHz>();
		UserInfoDAO uidao = new UserInfoDAO();
		List<YgxxHzBean> yhblist = new ArrayList<YgxxHzBean>();
		ExportExcel<YgxxHzBean> ex = new ExportExcel<YgxxHzBean>();
		String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"下线员工","年度","季度",
				"下线次数","下线总天数","总小时数","所属处室"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from YgxxHz as yh where 1=1";
		if(strtemp!=null&&!strtemp.equals(""))
		{
			hql += " and yh.name='"+strtemp+"'";
		}
		if(chutuan!=0)
		{
			if(chutuan>=1&&chutuan<=6)
			{
				hql += " and yh.chu='"+chutuan+"'";
			}
			else if(chutuan>=7&&chutuan<=9)
			{
				int temptuan = chutuan-6;
				hql += " and yh.chu='3' and yh.zu='"+temptuan+"'";
			}
			else if(chutuan>=10&&chutuan<=12)
			{
				int temptuan = chutuan-9;
				hql += " and yh.chu='6' and yh.zu='"+temptuan+"'";
			}
		}
		if(year!=0)
		{
			hql += " and yh.year="+year;
		}
		if(quarter!=0)
		{
			hql += " and yh.quarter="+quarter;
		}
		hql += " order by yh.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		listyhtemp = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<listyhtemp.size();i++)
		{
			YgxxHz yh = listyhtemp.get(i);
			YgxxHzBean yhb = new YgxxHzBean();
			String chuname="";
			if(yh.getChu().equals("1"))
			{
				chuname="综合与生产管理处";
			}
			else if(yh.getChu().equals("2"))
			{
				chuname="合规与监督二处";
			}
			else if(yh.getChu().equals("3"))
			{
				chuname="通用业务二处";
			}
			else if(yh.getChu().equals("4"))
			{
				chuname="员工响应团队";
			}
			else if(yh.getChu().equals("5"))
			{
				chuname="研发支持二处";
			}
			else if(yh.getChu().equals("6"))
			{
				chuname="专业处理二处";
			}
			
			yhb.setName(yh.getName());
			yhb.setYear(String.valueOf(yh.getYear()));
			yhb.setQuarter(String.valueOf(yh.getQuarter()));
			yhb.setTimes(String.valueOf(yh.getTimes()));
			yhb.setDays(String.valueOf(yh.getDays()));
			yhb.setHours(String.valueOf(yh.getHours()));
			yhb.setChu(chuname);
			yhblist.add(yhb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"YGXXHZ"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "YGXXHZ"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("集中生产人员因公下线汇总表",headers, yhblist, out);
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
