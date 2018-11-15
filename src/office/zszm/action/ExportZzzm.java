package office.zszm.action;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import office.zszm.pojo.TZzzm;
import office.zszm.pojo.TZzzmBean;
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
public class ExportZzzm {
	private static Logger logger = Logger.getLogger(ExportZzzm.class);
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
		List<TZzzm> list;
		UserInfoDAO uidao = new UserInfoDAO();
		List<TZzzmBean> tzblist = new ArrayList<TZzzmBean>();
		ExportExcel<TZzzmBean> ex = new ExportExcel<TZzzmBean>();
		String strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
		String[] headers = {"审批单编号","提交日期","发起人",
				"申请人","联系电话","用途","所需份数","接收单位",
				"状态","备注","是否开具单位无营业执照证明（汉语）","是否开具单位无营业执照证明（英语）"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from TZzzm as tz";
		if(strtemp!=null&&strtemp.length()>1)
			searchnn = uidao.nameToNewnumber(strtemp);
		hql +=" where tz.applicant like '%"+searchnn+"%'";
		if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
		{
			bd = begindate.replace("-", "");
			ed = enddate.replace("-", "");
			hql += " and tz.date>='"+bd+"' and tz.date<='"+ed+"'";
		}
		if(chutuan>=1&&chutuan<=6)
		{
			hql += " and tz.chu='"+chutuan+"'";
		}
		else if(chutuan>=7&&chutuan<=9)
		{
			int temptuan = chutuan-6;
			hql += " and tz.chu='3' and tz.zu='"+temptuan+"'";
		}
		else if(chutuan>=10&&chutuan<=12)
		{
			int temptuan = chutuan-9;
			hql += " and tz.chu='6' and tz.zu='"+temptuan+"'";
		}
		hql += " order by tz.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		String lich="";
		String lien="";
		for(int i=0;i<list.size();i++)
		{
			TZzzm tz = list.get(i);
			TZzzmBean tzb = new TZzzmBean();
			tzb.setNumber(tz.getNumber());
			tzb.setDate(tz.getDate());
			tzb.setInitiator(tz.getInitiator());
			tzb.setApplicant(LeaveUtil.NewNumberToName(tz.getApplicant()));
			tzb.setTel(tz.getTel());
			tzb.setYongtu(tz.getYongtu());
			tzb.setNeednumber(Util.statusToString(tz.getNeednumber()));
			tzb.setTodepartment(tz.getTodepartment());
			tzb.setStatus(Util.statusToString(tz.getStatus()));
			tzb.setRemark(tz.getRemark());
			if(tz.getLicencech()!=null&&tz.getLicencech()!="")
			{
			if(tz.getLicencech().equals("1"))
			{
				lich="有";
			}
			else if(tz.getLicencech().equals("0"))
			{
				lich="无";
			}
			}
			else
			{
				lich="空";
			}
			if(tz.getLicenceen()!=null&&tz.getLicenceen()!="")
			{
			if(tz.getLicenceen().equals("1"))
			{
				lien="有";
			}
			else if(tz.getLicenceen().equals("0"))
			{
				lien="无";
			}
			}
			else
			{
				lien="空";
			}
			tzb.setLicencech(lich);
			tzb.setLicenceen(lien);
			tzblist.add(tzb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"ZZZM"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "ZZZM"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, tzblist, out);
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
