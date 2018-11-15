package office.pb2.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import office.kqqs.action.ExportKqqs;
import office.kqqs.pojo.KqqsPage;
import office.kqqs.pojo.KqqsPageBean;
import office.pb2.pojo.XxsqPage;
import office.pb2.pojo.YgxxMxBean;
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

public class ExportYgxx {

	private static Logger logger = Logger.getLogger(ExportYgxx.class);
	private String begindate;
	private String enddate;
	private String name;
	private String Path;
	private String newnumber;
	private int chutuan;
	
	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
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
	public String execute() throws Exception{
		String filePath = "";
		String bd="";
		String ed="";
		String searchnn = "";
		List<XxsqPage> listxptemp;
		List<XxsqPage> list = new ArrayList<XxsqPage>();
		UserInfoDAO uidao = new UserInfoDAO();
		List<YgxxMxBean> ymblist = new ArrayList<YgxxMxBean>();
		ExportExcel<YgxxMxBean> ex = new ExportExcel<YgxxMxBean>();
		String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"审批单编号","下线人员","发起日期",
				"状态","发起人","联系电话","起始时间","结束时间",
				"下线天数","下线小时数","原因","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from XxsqPage as xp where 1=1";
		if(strtemp!=null&&!strtemp.equals(""))
		{
			hql += " and xp.people like '%"+strtemp+"%'";
		}
		if(chutuan!=0)
		{
			if(chutuan>=1&&chutuan<=6)
			{
				hql += " and xp.chu='"+chutuan+"'";
			}
			else if(chutuan>=7&&chutuan<=9)
			{
				int temptuan = chutuan-6;
				hql += " and xp.chu='3' and xp.zu='"+temptuan+"'";
			}
			else if(chutuan>=10&&chutuan<=12)
			{
				int temptuan = chutuan-9;
				hql += " and xp.chu='6' and xp.zu='"+temptuan+"'";
			}
		}
		if(begindate!=null&&enddate!=null&&!begindate.equals("")&&!enddate.equals(""))
		{
			String bdtemp = begindate.replace("-", "");
			String edtemp = enddate.replace("-", "");
			hql += " and ((xp.begindate>='"+bdtemp+"' and xp.begindate<='"+edtemp+"') or (xp.enddate>='"+bdtemp+"' and xp.enddate<='"+edtemp+"') or (xp.begindate<='"+bdtemp+"' and xp.enddate>='"+edtemp+"'))";
		}
		hql += " order by locate('6',xp.status),xp.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		listxptemp = query.list();
		for(int i=0;i<listxptemp.size();i++)
		{
			XxsqPage xp = listxptemp.get(i);
			String[] peoples = xp.getPeople().split("、");
			for(int j=0;j<peoples.length;j++)
			{
				XxsqPage xptemp = new XxsqPage();
				xptemp.setNumber(xp.getNumber());
				xptemp.setDate(xp.getDate());
				xptemp.setStatus(xp.getStatus());
				xptemp.setPreundertake(xp.getPreundertake());
				xptemp.setUndertake(xp.getUndertake());
				xptemp.setInitiator(xp.getInitiator());
				xptemp.setApplicant(xp.getApplicant());
				xptemp.setPeople(peoples[j]);
				xptemp.setTel(xp.getTel());
				xptemp.setBegindate(xp.getBegindate());
				xptemp.setEnddate(xp.getEnddate());
				xptemp.setHalfday(xp.getHalfday());
				xptemp.setDay(xp.getDay());
				xptemp.setHour(xp.getHour());
				xptemp.setType(xp.getType());
				xptemp.setReason(xp.getReason());
				xptemp.setQita(xp.getQita());
				xptemp.setRemark(xp.getRemark());
				if(strtemp!=null&&!strtemp.equals(""))
				{
					if(strtemp.equals(peoples[j]))
					{
						list.add(xptemp);
					}
				}
				else
				{
					list.add(xptemp);
				}
			}
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			XxsqPage xp = list.get(i);
			YgxxMxBean ymb = new YgxxMxBean();
			ymb.setNumber(xp.getNumber());
			ymb.setPeople(xp.getPeople());
			ymb.setDate(xp.getDate());
			ymb.setStatus(Util.statusToString(xp.getStatus()));
			ymb.setApplicant(LeaveUtil.NewNumberToName(xp.getApplicant()));
			ymb.setTel(xp.getTel());
			ymb.setBegindate(xp.getBegindate());
			ymb.setEnddate(xp.getEnddate());
			ymb.setDay(String.valueOf(xp.getDay()));
			ymb.setHour(String.valueOf(xp.getHour()));
			ymb.setReason(Util.ygxxReasonToString(xp.getReason())+xp.getQita());
			ymb.setRemark(xp.getRemark());
			ymblist.add(ymb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"YGXX"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "YGXX"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("集中生产人员因公下线明细表",headers, ymblist, out);
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
