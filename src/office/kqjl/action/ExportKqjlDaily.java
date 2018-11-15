package office.kqjl.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.kqjl.bean.KqjlDailyBean;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;
import office.userinfo.pojo.UserInfoBean;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;

public class ExportKqjlDaily {

	private String date;
	private int chu;
	private int tj;
	private String key;
	private int md;//查询当月、查询当日切换
	private String Path;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getChu() {
		return chu;
	}
	public void setChu(int chu) {
		this.chu = chu;
	}
	public int getTj() {
		return tj;
	}
	public void setTj(int tj) {
		this.tj = tj;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getMd() {
		return md;
	}
	public void setMd(int md) {
		this.md = md;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception{
		String filePath = "";
		String hql = "";
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
		date = date.replace("-","");
		hql = "from KqjlDaily as kd";
		if(md==0)
		{
			hql+= " where kd.date='"+date+"'";
		}
		else
		{
			hql+= " where kd.date>='"+date.substring(0, 6)+"01' and kd.date<='"+date.substring(0, 6)+"31'";
		}
		hql+=" and kd.pbqdtime>'00:00:00' and kd.pbqttime>'00:00:00'";
		if(chu!=0)
			hql+=" and kd.position like '__"+chu+"__'";
		if(key!=null)
		{
			hql +=" and kd.name like '%"+key+"%'";
		}
		if(tj==1)//只看迟到早退
		{
			hql +=" and (kd.qdqs=2 or kd.qtqs=2)";
		}
		if(tj==2)//只看考勤缺失
		{
			hql +=" and (kd.qdqs=1 or kd.qtqs=1)";
		}
		if(tj==3)//只看外出公干
		{
			hql +=" and kd.gg=1";
		}
		if(tj==4)//只看请假
		{
			hql +=" and kd.qj>0";
		}
		if(tj==9)//只看异常记录
		{
			hql +=" and kd.yc=1";
		}
		hql +=" order by locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.position,kd.date";
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
			 	filePath=Util.downloadpath+date+"kqjldaily.xls";
				Path = date+"kqjldaily.xls";
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
