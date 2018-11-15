package office.kqjl.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.kqjl.bean.KqjlDailyBean;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExportKqjlGrDaily {

	private String month;
	private String name;
	private String Path;
	private String newnumber;
	private int yc;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
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
	public int getYc() {
		return yc;
	}
	public void setYc(int yc) {
		this.yc = yc;
	}
	public String execute() throws Exception{
		String filePath = "";
		String autho = "";
		String position = "";
		UserInfoDAO uidao = new UserInfoDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		List<KqjlDaily> list;
		List<KqjlDailyBean> kdblist = new ArrayList<KqjlDailyBean>();
		ExportExcel<KqjlDailyBean> ex = new ExportExcel<KqjlDailyBean>();
		String[] headers = {"日期","星期","姓名","处室团队",
				"上班时间","下班时间","签到时间","签退时间","迟到早退情况","请假",
				"公干","加班","请假/公干半天"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		autho = ui.getAuthority();
		position = ui.getPosition();
		month = month.replace("-","");
		UserInfo uish = uidao.findByName(name);//查询传入的姓名
		String hql = "from KqjlDaily as kd where kd.date>='"+month+"01' and kd.date<='"+month+"31' and kd.pbqdtime>'00:00:00' and kd.pbqttime>'00:00:00'";
		if(yc==1)
		{
			hql+=" and (kd.yc=1 or kd.qdqs=1 or kd.qtqs=1)";
		}
		if(autho.contains("C")||autho.contains("B"))//团队负责人
		{
			if(uish!=null&&(position.charAt(2)==uish.getPosition().charAt(2)))//查询的是团队内员工
			{
				hql += " and kd.name='"+name+"' order by locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
			}
			else
			{
				hql += " and kd.position like '__"+position.substring(2, 3)+"__' order by kd.yy desc ,locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
			}
		}
		else if(autho.contains("D"))//组长
		{
			if(uish!=null&&(position.charAt(4)==uish.getPosition().charAt(4)))//查询的是组内员工
			{
				hql += " and kd.name='"+name+"' order by  locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
			}
			else
			{
				hql += " and kd.position like '__"+position.substring(2, 3)+"_"+position.substring(4, 5)+"' order by kd.yy desc , locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
			}
		}
		else//普通员工
		{
			hql += " and kd.name='"+ui.getUsername()+"' order by locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
		}
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		for(int i=0;i<list.size();i++)
		{
			KqjlDaily kd = list.get(i);
			KqjlDailyBean kdb = new KqjlDailyBean();
			kdb.setDate(kd.getDate());
			kdb.setWeek(String.valueOf(kd.getWeek()));
			kdb.setName(kd.getName());
			kdb.setChu(UserUtil.positionToName(kd.getPosition()));
			kdb.setPbqdtime(kd.getPbqdtime());
			kdb.setPbqttime(kd.getPbqttime());
			kdb.setQdtime(kd.getQdtime());
			kdb.setQttime(kd.getQttime());
			kdb.setQdqt(Util.qdqtTypeToString(kd.getQdqs(),kd.getQtqs()));
			kdb.setQj(LeaveUtil.TypeToString(kd.getQj()));
			kdb.setGg(Util.yesOrNot(kd.getGg()));
			kdb.setJb(Util.yesOrNot(kd.getJb()));
			kdb.setHalfday(String.valueOf(kd.getHalfday()));
			kdblist.add(kdb);
		}
		
		//导出
		 try {
			 	filePath=Util.downloadpath+month+"kqjldaily.xls";
				Path = month+"kqjldaily.xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("考勤记录明细表",headers, kdblist, out);
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
