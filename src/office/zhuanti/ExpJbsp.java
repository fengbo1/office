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
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExpJbsp {
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
		List<JbspPage> list;
		List<JbspPageBean> jpblist = new ArrayList<JbspPageBean>();
		ExportExcel<JbspPageBean> ex = new ExportExcel<JbspPageBean>();
		String[] headers = {"审批单编号","提交日期","状态",
				"申请人","加班人员","处室","团队","联系电话","原因",
				"起始日期","截止日期","加班天数","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from JbspPage as jp order by jp.id desc";
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			JbspPage jp = list.get(i);
			String[] jbname=jp.getPeople().split("、");
			for(int j=0;j<jbname.length;j++)
			{
				String tempname = jbname[j];
				UserInfo ui = uidao.findByName(tempname);
				List<MyCalendar> listmc = mcdao.findByBeginAndEnd(jp.getBegindate(),jp.getEnddate(),2);
				for(int k=0;k<listmc.size();k++)
				{
					MyCalendar mc = listmc.get(k);
					double halfday=1.0;
					if(mc.getDate().equals(jp.getBegindate())&&(jp.getHalfday()==1||jp.getHalfday()==3))//第一天
					{
						halfday=0.5;
					}
					if(mc.getDate().equals(jp.getEnddate())&&(jp.getHalfday()==2||jp.getHalfday()==3))//最后一天
					{
						halfday=0.5;
					}
					JbspPageBean jpb = new JbspPageBean();
					jpb.setNumber(jp.getNumber());
					jpb.setDate(jp.getDate());
					jpb.setStatus(Util.statusToString(jp.getStatus()));
					if(ui!=null)
					{
						jpb.setApplicant(ui.getNewnumber());
						jpb.setChu(UserUtil.positionToName(ui.getPosition()));
					}
					jpb.setPeople(tempname);
					jpb.setZu("");
					jpb.setTel(jp.getTel());
					jpb.setReason(jp.getReason());
					jpb.setBegindate(mc.getDate());
					jpb.setEnddate(mc.getDate());
					jpb.setDays(String.valueOf(halfday));
					jpb.setRemark(jp.getRemark());
					
					jpblist.add(jpb);
				}
			}
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"JBSP"+"-"+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "JBSP"+"-"+".xls";
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
