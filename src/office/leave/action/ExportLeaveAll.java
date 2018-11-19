package office.leave.action;

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
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeavePageBean;
import office.userinfo.dao.UserInfoDAO;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;

/**
 * 导出请假明细表
 * @author htzx
 *
 */
public class ExportLeaveAll {

	private String begindate;
	private String enddate;
	private String applicant;
	private int chutuan;
	private int type;
	private int status;
	private String Path;
	private static Logger logger = Logger.getLogger(ExportLeaveAll.class);
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		String searchnn = "";
		String bd="";
		String ed="";
		UserInfoDAO uidao = new UserInfoDAO();
		List<LeavePage> list;
		List<LeavePageBean> lpblist = new ArrayList<LeavePageBean>();
		ExportExcel<LeavePageBean> ex = new ExportExcel<LeavePageBean>();
		String strtemp = new String(applicant.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"审批单编号","提交日期","状态","发起人",
				"请假人","是否代申请","处室","团队","职务","工作年限",
				"请假类型","起始日期","截止日期","请假天数","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from LeavePage as lp";
		if(strtemp!=null&&strtemp.length()>1)
			searchnn = uidao.nameToNewnumber(strtemp);
		hql +=" where lp.applicant like '%"+searchnn+"%'";
		if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
		{
			bd = begindate.replace("-", "");
			ed = enddate.replace("-", "");
			hql += " and ((lp.begindate>='"+bd+"' and lp.begindate<='"+ed+"') or (lp.enddate>='"+bd+"' and lp.enddate<='"+ed+"') or (lp.begindate<='"+bd+"' and lp.enddate>='"+ed+"'))";
		}
		if(type!=0)
		{
			hql +=" and lp.type="+type;
		}
		
		if(chutuan>=1&&chutuan<=6)
		{
			hql += " and lp.chu='"+chutuan+"'";
		}
		else if(chutuan>=7&&chutuan<=9)
		{
			int temptuan = chutuan-6;
			hql += " and lp.chu='3' and lp.zu='"+temptuan+"'";
		}
		else if(chutuan>=10&&chutuan<=12)
		{
			int temptuan = chutuan-9;
			hql += " and lp.chu='6' and lp.zu='"+temptuan+"'";
		}
	
		if(status==1)
		{
			hql +=" and lp.status=2";
		}
		if(status==2)
		{
			hql +=" and lp.status in (1,6,7,8,9)";
		}
		hql += " order by lp.id desc";
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
			lpb.setBegindate(lp.getBegindate());
			lpb.setEnddate(lp.getEnddate());
			lpb.setDays(String.valueOf(lp.getDays()));
			
			lpblist.add(lpb);
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
