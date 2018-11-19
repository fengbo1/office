package office.pb2.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.pb2.pojo.TbsqMxBean;
import office.pb2.pojo.TbsqPage;
import office.pb2.pojo.YgxxHz;
import office.pb2.pojo.YgxxHzBean;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.Util;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExportTbsq {
	private static Logger logger = Logger.getLogger(ExportYgxx.class);
	private String begindate;
	private String enddate;
	private String name;
	private String Path;
	private String newnumber;

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
	public String execute() throws Exception{
		String filePath = "";
		String bd="";
		String ed="";
		String searchnn = "";
		List<TbsqPage> listtptemp;
		List<TbsqPage> list = new ArrayList<TbsqPage>();
		UserInfoDAO uidao = new UserInfoDAO();
		List<TbsqMxBean> tmblist = new ArrayList<TbsqMxBean>();
		ExportExcel<TbsqMxBean> ex = new ExportExcel<TbsqMxBean>();
		String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"生产调班编号","调班日期","申请人",
				"调班对象","发起日期","状态","调班原因","原计划"
				,"调班后计划","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from TbsqPage as tp where 1=1";
		if(strtemp!=null&&!strtemp.equals(""))
		{
			UserInfo squi = uidao.findByName(strtemp);
			hql += " and (tp.applicant='"+squi.getNewnumber()+"' or tp.tbname='"+strtemp+"')";
		}
		if(begindate!=null&&enddate!=null&&!begindate.equals("")&&!enddate.equals(""))
		{
			String bdtemp = begindate.replace("-", "");
			String edtemp = enddate.replace("-", "");
			hql += " and tp.tbdate>='"+bdtemp+"' and tp.tbdate<='"+edtemp+"'";
		}
		hql += " order by tp.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		listtptemp = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<listtptemp.size();i++)
		{
			TbsqPage tp = listtptemp.get(i);
			TbsqMxBean tmb = new TbsqMxBean();
			tmb.setNumber(tp.getNumber());
			tmb.setTbdate(tp.getTbdate());
			tmb.setName(LeaveUtil.NewNumberToName(tp.getInitiator())+"代"+LeaveUtil.NewNumberToName(tp.getApplicant()));
			tmb.setTbname(tp.getTbname());
			tmb.setDate(tp.getDate());
			tmb.setStatus(Util.statusToString(tp.getStatus()));
			tmb.setReason(tp.getReason());
			tmb.setPrejihua(tp.getPrejihua());
			tmb.setNowjihua(tp.getNowjihua());
			tmb.setRemark(tp.getRemark());
			tmblist.add(tmb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"TbsqPage"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "TbsqPage"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("集中生产人员因公下线汇总表",headers, tmblist, out);
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
