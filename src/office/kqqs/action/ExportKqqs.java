package office.kqqs.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.jbsp.pojo.JbspPage;
import office.jbsp.pojo.JbspPageBean;
import office.kqqs.pojo.KqqsPage;
import office.kqqs.pojo.KqqsPageBean;
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

public class ExportKqqs {

	private static Logger logger = Logger.getLogger(ExportKqqs.class);
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
		List<KqqsPage> list;
		UserInfoDAO uidao = new UserInfoDAO();
		List<KqqsPageBean> kpblist = new ArrayList<KqqsPageBean>();
		ExportExcel<KqqsPageBean> ex = new ExportExcel<KqqsPageBean>();
		String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"审批单编号","提交日期","状态",
				"姓名","处室","小组","联系电话","原因",
				"缺失日期","签到/签退","缺失时间","是否补考勤","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from KqqsPage as kp";
		if(strtemp!=null&&strtemp.length()>1)
			searchnn = uidao.nameToNewnumber(strtemp);
		hql +=" where kp.applicant like '%"+searchnn+"%'";
		if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
		{
			bd = begindate.replace("-", "");
			ed = enddate.replace("-", "");
			hql += " and kp.qsdate>='"+bd+"' and kp.qsdate<='"+ed+"'";
		}
		
		
		if(chutuan>=1&&chutuan<=6)
		{
			hql += " and kp.chu='"+chutuan+"'";
		}
		else if(chutuan>=7&&chutuan<=9)
		{
			int temptuan = chutuan-6;
			hql += " and kp.chu='3' and kp.zu='"+temptuan+"'";
		}
		else if(chutuan>=10&&chutuan<=12)
		{
			int temptuan = chutuan-9;
			hql += " and kp.chu='6' and kp.zu='"+temptuan+"'";
		}
		
		
		hql += " order by kp.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			KqqsPage kp = list.get(i);
			KqqsPageBean kpb = new KqqsPageBean();
			kpb.setNumber(kp.getNumber());
			kpb.setDate(kp.getDate());
			kpb.setStatus(Util.statusToString(kp.getStatus()));
			kpb.setApplicant(LeaveUtil.NewNumberToName(kp.getApplicant()));
			kpb.setChu(UserUtil.cToName(Integer.parseInt(kp.getChu())));
			kpb.setZu(kp.getZu());
			kpb.setTel(kp.getTel());
			kpb.setReason(kp.getReason());
			kpb.setQsdate(kp.getQsdate());
			kpb.setQdqt(Util.qdqtToString(kp.getQdqt()));
			kpb.setQstime(kp.getQstime());
			kpb.setBu(Util.yesOrNot(kp.getBu()));
			kpb.setRemark(kp.getRemark());
			kpblist.add(kpb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"KQQS"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "KQQS"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, kpblist, out);
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
