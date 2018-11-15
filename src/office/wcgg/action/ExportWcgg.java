package office.wcgg.action;

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

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;
import office.wcgg.pojo.WcggPage;
import office.wcgg.pojo.WcggPageBean;

public class ExportWcgg {
	
	private String begindate;
	private String enddate;
	private String applicant;
	private String Path;
	private int chutuan;
	private static Logger logger = Logger.getLogger(ExportWcgg.class);
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
		List<WcggPage> list;
		UserInfoDAO uidao = new UserInfoDAO();
		List<WcggPageBean> wpblist = new ArrayList<WcggPageBean>();
		ExportExcel<WcggPageBean> ex = new ExportExcel<WcggPageBean>();
		String strtemp = new String(applicant.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"审批单编号","提交日期","状态","",
				"申请人","公干人员","处室团队","联系电话","原因",
				"地点","起始日期","截止日期","","","公干天数","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from WcggPage as wp";
		hql +=" where wp.people like '%"+strtemp+"%'";
		if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
		{
			bd = begindate.replace("-", "");
			ed = enddate.replace("-", "");
			hql += " and ((wp.begindate>='"+bd+"' and wp.begindate<='"+ed+"') or (wp.enddate>='"+bd+"' and wp.enddate<='"+ed+"') or (wp.begindate<='"+bd+"' and wp.enddate>='"+ed+"'))";
		}
		
		if(chutuan>=1&&chutuan<=6)
		{
			hql += " and wp.chu='"+chutuan+"'";
		}
		else if(chutuan>=7&&chutuan<=9)
		{
			int temptuan = chutuan-6;
			hql += " and wp.chu='3' and wp.zu='"+temptuan+"'";
		}
		else if(chutuan>=10&&chutuan<=12)
		{
			int temptuan = chutuan-9;
			hql += " and wp.chu='6' and wp.zu='"+temptuan+"'";
		}
		
		hql += " order by wp.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			WcggPage wp = list.get(i);
			WcggPageBean wpb = new WcggPageBean();
			UserInfo ui = uidao.findByNewNumber(wp.getApplicant());
			wpb.setNumber(wp.getNumber());
			wpb.setDate(wp.getDate());
			wpb.setStatus(Util.statusToString(wp.getStatus()));
			System.out.println(wp.getApplicant());
			wpb.setApplicant(LeaveUtil.NewNumberToName(wp.getApplicant()));
			wpb.setPeople(wp.getPeople());
			if(ui!=null)
			wpb.setChutuan(UserUtil.positionToName(ui.getPosition()));
			wpb.setTel(wp.getTel());
			wpb.setReason(wp.getReason());
			wpb.setAddr(wp.getAddr());
			wpb.setBegindate(wp.getBegindate());
			wpb.setEnddate(wp.getEnddate());
			wpb.setDays(String.valueOf(wp.getDays()));
			wpb.setRemark(wp.getRemark());
			
			wpblist.add(wpb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"WCGG"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "WCGG"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, wpblist, out);
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
