package office.jbsp.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.jbsp.pojo.JbspPage;
import office.jbsp.pojo.JbspPageBean;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;

public class ExportJbsp {
	
	private String begindate;
	private String enddate;
	private String applicant;
	private String Path;
	private static Logger logger = Logger.getLogger(ExportJbsp.class);
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
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
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
		List<JbspPage> list;
		List<JbspPageBean> jpblist = new ArrayList<JbspPageBean>();
		ExportExcel<JbspPageBean> ex = new ExportExcel<JbspPageBean>();
		String strtemp = new String(applicant.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"审批单编号","提交日期","状态",
				"申请人","加班人员","处室","团队","联系电话","原因",
				"起始日期","截止日期","加班天数","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from JbspPage as jp";
		hql +=" where jp.people like '%"+strtemp+"%'";
		if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
		{
			bd = begindate.replace("-", "");
			ed = enddate.replace("-", "");
			//hql += " and jp.begindate>='"+bd+"' and jp.begindate<='"+ed+"'";
			hql += " and ((jp.begindate>='"+bd+"' and jp.begindate<='"+ed+"') or (jp.enddate>='"+bd+"' and jp.enddate<='"+ed+"') or (jp.begindate<='"+bd+"' and jp.enddate>='"+ed+"'))";
		}
		hql += " order by jp.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			JbspPage jp = list.get(i);
			JbspPageBean jpb = new JbspPageBean();
			jpb.setNumber(jp.getNumber());
			jpb.setDate(jp.getDate());
			jpb.setStatus(Util.statusToString(jp.getStatus()));
			jpb.setApplicant(LeaveUtil.NewNumberToName(jp.getApplicant()));
			jpb.setPeople(jp.getPeople());
			jpb.setChu(UserUtil.cToName(Integer.parseInt(jp.getChu())));
			jpb.setZu(jp.getZu());
			jpb.setTel(jp.getTel());
			jpb.setReason(jp.getReason());
			jpb.setBegindate(jp.getBegindate());
			jpb.setEnddate(jp.getEnddate());
			jpb.setDays(String.valueOf(jp.getDays()));
			jpb.setRemark(jp.getRemark());
			
			jpblist.add(jpb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"JBSP"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "JBSP"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("加班审批明细表",headers, jpblist, out);
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
