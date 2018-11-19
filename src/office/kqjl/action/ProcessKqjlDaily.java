package office.kqjl.action;

import java.util.List;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlUpload;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
/**
 * 计算考勤记录明细表
 * @author htzx
 *
 */
public class ProcessKqjlDaily {

	private KqjlUpload ku;
	private String year;
	private String month;
	private String message;
	
	public KqjlUpload getKu() {
		return ku;
	}

	public void setKu(KqjlUpload ku) {
		this.ku = ku;
	}
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception
	{
		String sql = "";
		ImportKqjl ik = new ImportKqjl();
		//原 ik.countKqjlDaily();
		ik.countKqjlDailyNew(year+month);
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		//更新异常标志位
    		sql = "update t_kqjl_daily set yc=1 where qdtime>'00:00:00' and (qj>0 or gg>0) and halfday=1 and date>='"+year+month+"01' and date<='"+year+month+"31'";
    		session.createSQLQuery(sql).executeUpdate();
    		sql = "update t_kqjl_daily set yc=1 where qttime>'00:00:00' and (qj>0 or gg>0) and halfday=2 and date>='"+year+month+"01' and date<='"+year+month+"31'";
    		session.createSQLQuery(sql).executeUpdate();
    		message = "生成成功";
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String processKqjlById(int id)
	{
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		KqqsPageDAO kpdao = new KqqsPageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		KqjlDaily kd = kddao.findAllByID(id);
    		String name = kd.getName();
    		String date = kd.getDate();
    		UserInfo ui = uidao.findByName(name);
    		List<KqqsPage> listkp = kpdao.findAllByNameAndDate(ui.getNewnumber(),date);
    		//保存补考勤信息
			if(!listkp.isEmpty())
			{
				KqqsPage kp = listkp.get(0);
				if(kp.getQdqt()==1&&kd.getQdtime().equals(""))
				{
					kd.setQdtime(kp.getQstime()+":00");
					kd.setQdqs(3);//补考勤
					if(kd.getQttime().equals(""))
					{
						kd.setQtqs(1);
					}
				}
				else if(kp.getQdqt()==2&&kd.getQttime().equals(""))
				{
					kd.setQttime(kp.getQstime()+":00");
					kd.setQtqs(3);//补考勤
					if(kd.getQdtime().equals(""))
					{
						kd.setQdqs(1);
					}
				}
				else if(kp.getQdqt()==3&&kd.getQdtime().equals("")&&kd.getQttime().equals(""))
				{
					kd.setQdtime(kp.getQstime()+":00");
					kd.setQdqs(3);//补考勤
					kd.setQttime(kp.getQstime()+":00");
					kd.setQtqs(3);//补考勤
				}
				else
				{
//					kd.setQdqs(1);//考勤缺失
//					kd.setQtqs(1);//考勤缺失
				}
			}
			else
			{
				if(kd.getQttime().equals(""))
				{
					kd.setQtqs(1);
				}
				if(kd.getQdtime().equals(""))
				{
					kd.setQdqs(1);
				}
			}
			kddao.merge(kd);
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
	
	public String countKqjlDailyBySQL(String yearmonth)
	{
		MyCalendarDAO mcdao = new MyCalendarDAO();
		String bgdate = yearmonth+"01";
		String eddate = yearmonth+"31";
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		List<MyCalendar> listmc = mcdao.findByBeginAndEnd(bgdate,eddate,2);//所有天数
    		String sql = "delete from t_kqjl_daily where date>='"+bgdate+"' and date<='"+eddate+"'";
    		session.createSQLQuery(sql).executeUpdate();
    		for(int i=0;i<listmc.size();i++)
    		{
    			MyCalendar mc = listmc.get(i);
    			if(mc.getWorkday()==1)//工作日
    			{
    				sql = "insert into t_kqjl_daily(date,week,name,newnumber,position,pbqdtime,pbqttime,qdtime,qttime,qdqs,qtqs,qj,gg,jb,halfday,tb,pb,yc,yy) select '"+mc.getDate()+"',"+mc.getWeek()+",username,newnumber,position,'"+Util.plusFiveMinutes(Util.zcqd)+"','"+Util.zcqt+"','','',0,0,0,0,0,0,0,0,0,0 from user_info  as ui where ui.position not like '0____' and ui.username not like '%B%' and ui.username not like '%管理%' and ui.newnumber!='20186393' and ui.position!='10000' and ui.position not like '9____' and ui.position not like '__4__'";
    			}
    			else//非工作日
    			{
    				sql = "insert into t_kqjl_daily(date,week,name,newnumber,position,pbqdtime,pbqttime,qdtime,qttime,qdqs,qtqs,qj,gg,jb,halfday,tb,pb,yc,yy) select '"+mc.getDate()+"',"+mc.getWeek()+",username,newnumber,position,'','','','',0,0,0,0,0,0,0,0,0,0 from user_info  as ui where ui.position not like '0____' and ui.username not like '%B%' and ui.username not like '%管理%' and ui.newnumber!='20186393' and ui.position!='10000' and ui.position not like '9____' and ui.position not like '__4__'";
    			}
    			session.createSQLQuery(sql).executeUpdate();
    			sql = "update t_kqjl_daily a,t_kqjl_import b set a.qdtime=b.qdtime,a.qttime=b.qttime where a.date=b.date and a.name=b.name and a.date>='"+bgdate+"' and a.date<='"+eddate+"'";
    			session.createSQLQuery(sql).executeUpdate();
    			sql = "update t_kqjl_daily set qdqs = 1 where qdtime='' and date>='"+bgdate+"' and date<='"+eddate+"'";
    			session.createSQLQuery(sql).executeUpdate();//考勤缺失
    			sql = "update t_kqjl_daily set qtqs = 1 where qttime='' and date>='"+bgdate+"' and date<='"+eddate+"'";
    			session.createSQLQuery(sql).executeUpdate();
    			sql = "update t_kqjl_daily set qdqs = 2 where mid(pbqdtime,1,5)<mid(qdtime,1,5) and qdtime!='' and pbqdtime!=''";
    			session.createSQLQuery(sql).executeUpdate();//迟到早退
    			sql = "update t_kqjl_daily set qtqs = 2 where mid(pbqttime,1,5)>mid(qttime,1,5) and qttime!='' and pbqttime!=''";
    			session.createSQLQuery(sql).executeUpdate();
    			sql = "update t_kqjl_daily a,t_kqqs_page b set a.qdqs=3,a.qdtime=concat(b.qstime,':00') where a.date=b.qsdate and b.qdqt=1 and a.date>='"+bgdate+"' and a.date<='"+eddate+"'";
    			session.createSQLQuery(sql).executeUpdate();//补签到
    			sql = "update t_kqjl_daily a,t_kqqs_page b set a.qtqs=3,a.qttime=concat(b.qstime,':00') where a.date=b.qsdate and b.qdqt=2 and a.date>='"+bgdate+"' and a.date<='"+eddate+"'";
    			session.createSQLQuery(sql).executeUpdate();
    			sql = "update t_kqjl_daily a,t_mycalendar b set a.qdqs = 0 where a.date=b.date and (b.remark='1' or b.remark='3') and a.date>='"+bgdate+"' and a.date<='"+eddate+"'";
    			session.createSQLQuery(sql).executeUpdate();//不计考勤
    			sql = "update t_kqjl_daily a,t_mycalendar b set a.qtqs = 0 where a.date=b.date and (b.remark='2' or b.remark='3') and a.date>='"+bgdate+"' and a.date<='"+eddate+"'";
    			session.createSQLQuery(sql).executeUpdate();
    			
    		}
    		sql = "";
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
		
	}
}
