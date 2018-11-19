package office.zhuanti;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.leave.action.ExportLeaveAll;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeavePageBean;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
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

public class ExpLeave {

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
		String filePath = "";
		String bd="";
		String ed="";
		List<LeavePage> list;
		List<LeavePageBean> lpblist = new ArrayList<LeavePageBean>();
		ExportExcel<LeavePageBean> ex = new ExportExcel<LeavePageBean>();
		String[] headers = {"审批单编号","提交日期","状态","发起人",
				"请假人","是否代申请","处室","团队","职务","工作年限",
				"请假类型","起始日期","截止日期","请假天数","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from LeavePage as lp";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			
			LeavePage lp = list.get(i);
			List<MyCalendar> listmc = mcdao.findByBeginAndEnd(lp.getBegindate(),lp.getEnddate(), 1);
			for(int j=0;j<listmc.size();j++)
			{
				MyCalendar mc = listmc.get(j);
				double halfday=1.0;
				if(mc.getDate().equals(lp.getBegindate())&&(lp.getHalfday()==1||lp.getHalfday()==3))//第一天
				{
					halfday=0.5;
				}
				if(mc.getDate().equals(lp.getEnddate())&&(lp.getHalfday()==2||lp.getHalfday()==3))//最后一天
				{
					halfday=0.5;
				}
				LeavePageBean lpb = new LeavePageBean();
				lpb.setNumber(lp.getNumber());
				lpb.setDate(lp.getDate());
				lpb.setStatus(LeaveUtil.statusToString(lp.getStatus()));
				lpb.setInitiator(LeaveUtil.NewNumberToName(lp.getInitiator()));
				lpb.setApplicant(LeaveUtil.NewNumberToName(lp.getApplicant()));
				lpb.setDai(Util.yesOrNot(lp.getDai()));
				lpb.setChu(UserUtil.cToName(lp.getChu()));
				lpb.setTuan(UserUtil.tToName(lp.getChu(), lp.getTuan()));
				lpb.setZhiwu(lp.getZhiwu());
				lpb.setWorkage(String.valueOf(lp.getWorkage()));
				lpb.setType(LeaveUtil.TypeToString(lp.getType()));
				lpb.setBegindate(mc.getDate());
				lpb.setEnddate(mc.getDate());
				lpb.setDays(String.valueOf(halfday));
				
				lpblist.add(lpb);
			}
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"QJSQ"+bd+"-"+ed+".xls";
			 	logger.error("导出路径"+filePath);
				Path = "QJSQ"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, lpblist, out);
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
