package office.zhuanti;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.jbsp.pojo.JbspPage;
import office.jbsp.pojo.JbspPageBean;
import office.leave.action.ExportLeaveAll;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.ExportExcel;
import office.util.UserUtil;
import office.util.Util;
import office.wcgg.pojo.WcggPage;
import office.wcgg.pojo.WcggPageBean;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExpWcgg {
	private String Path;
	private static Logger logger = Logger.getLogger(ExportLeaveAll.class);
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception{
		MyCalendarDAO mcdao = new MyCalendarDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		String filePath = "";
		List<WcggPage> list;
		List<WcggPageBean> wpblist = new ArrayList<WcggPageBean>();
		ExportExcel<WcggPageBean> ex = new ExportExcel<WcggPageBean>();
		String[] headers = {"审批单编号","提交日期","状态","",
				"申请人","公干人员","处室团队","联系电话","原因",
				"地点","起始日期","截止日期","","","公干天数","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from WcggPage as wp order by wp.id desc";
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			WcggPage wp = list.get(i);
			String[] wpname=wp.getPeople().split("、");
			for(int j=0;j<wpname.length;j++)
			{
				String tempname = wpname[j];
				UserInfo ui = uidao.findByName(tempname);
				List<MyCalendar> listmc = mcdao.findByBeginAndEnd(wp.getBegindate(),wp.getEnddate(),2);
				for(int k=0;k<listmc.size();k++)
				{
					MyCalendar mc = listmc.get(k);
					double halfday=1.0;
					if(mc.getDate().equals(wp.getBegindate())&&(wp.getHalfday()==1||wp.getHalfday()==3))//第一天
					{
						halfday=0.5;
					}
					if(mc.getDate().equals(wp.getEnddate())&&(wp.getHalfday()==2||wp.getHalfday()==3))//最后一天
					{
						halfday=0.5;
					}
					WcggPageBean wpb = new WcggPageBean();
					wpb.setNumber(wp.getNumber());
					wpb.setDate(wp.getDate());
					wpb.setStatus(Util.statusToString(wp.getStatus()));
					if(ui!=null)
					{
						wpb.setChutuan(UserUtil.positionToName(ui.getPosition()));
						wpb.setApplicant(ui.getNewnumber());
					}
					wpb.setPeople(tempname);
					wpb.setTel(wp.getTel());
					wpb.setReason(wp.getReason());
					wpb.setAddr(wp.getAddr());
					wpb.setBegindate(mc.getDate());
					wpb.setEnddate(mc.getDate());
					wpb.setDays(String.valueOf(halfday));
					wpb.setRemark(wp.getRemark());
					
					wpblist.add(wpb);
				}
			}
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"WCGG"+"-"+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "WCGG"+"-"+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("外出公干明细表",headers, wpblist, out);
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
