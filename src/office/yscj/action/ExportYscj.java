package office.yscj.action;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.yscj.pojo.TYscj;
import office.yscj.pojo.TYscjBean;
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
public class ExportYscj {
	private static Logger logger = Logger.getLogger(ExportYscj.class);
	private String begindate;
	private String enddate;
	private String name;
	private String Path;
	private int chutuan;
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
	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}
	public String execute() throws Exception{
		String filePath = "";
		String bd="";
		String ed="";
		String searchnn = "";
		List<TYscj> list;
		UserInfoDAO uidao = new UserInfoDAO();
		List<TYscjBean> tyblist = new ArrayList<TYscjBean>();
		ExportExcel<TYscjBean> ex = new ExportExcel<TYscjBean>();
		String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"审批单编号","提交日期","发起人",
				"申请人","联系电话","拟去国家","拟出国时间","拟回国时间",
				"状态","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from TYscj as ty where 1=1 ";
		if(strtemp!=null&&strtemp.length()>1)
		{    searchnn = uidao.nameToNewnumber(strtemp);
		     hql +=" and ty.applicant like '%"+searchnn+"%'";
		}
		 //hql +=" where ty.applicant like '%"+searchnn+"%'";
		if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
		{
			bd = begindate.replace("-", "");
			ed = enddate.replace("-", "");
			hql += " and ty.date>='"+bd+"' and ty.date<='"+ed+"'";
		}
		if(chutuan>=1&&chutuan<=6)
		{
			hql += " and ty.chu='"+chutuan+"'";
		}
		else if(chutuan>=7&&chutuan<=9)
		{
			int temptuan = chutuan-6;
			hql += " and ty.chu='3' and ty.zu='"+temptuan+"'";
		}
		else if(chutuan>=10&&chutuan<=12)
		{
			int temptuan = chutuan-9;
			hql += " and ty.chu='6' and ty.zu='"+temptuan+"'";
		}
		/*if(chutuan>=1&&chutuan<=5)
		{
			hql += " and ty.chu='"+chutuan+"'";
		}
		if(chutuan>5)
		{
			int temptuan = chutuan-5;
			hql += " and ty.chu='3' and ty.zu='"+temptuan+"'";
		}*/
		hql += " order by ty.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			TYscj ty = list.get(i);
			TYscjBean tyb = new TYscjBean();
			tyb.setNumber(ty.getNumber());
			tyb.setDate(ty.getDate());
			tyb.setInitiator(ty.getInitiator());
			tyb.setApplicant(LeaveUtil.NewNumberToName(ty.getApplicant()));
			tyb.setTel(ty.getTel());
			tyb.setTocountry(ty.getTocountry());
			tyb.setBegindate(ty.getBegindate());
			tyb.setEnddate(ty.getEnddate());
			tyb.setStatus(Util.statusToString(ty.getStatus()));
			tyb.setRemark(ty.getRemark());
			tyblist.add(tyb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"YSCJ"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "YSCJ"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, tyblist, out);
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
