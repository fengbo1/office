package office.kqjl.action;

import java.util.ArrayList;
import java.util.List;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.KqjlImportDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlImport;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.dao.PbMxDAO;
import office.pb.dao.PbTeshuDAO;
import office.pb.pojo.PbMx;
import office.pb.pojo.PbTeshu;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.Util;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggPage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewKqjlZw {
	private static final Log log = LogFactory.getLog(ViewKqjlZw.class);
	private String newnumber;
	private int all;
	private String today;
	private List<KqjlImport> list;
	
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public List<KqjlImport> getList() {
		return list;
	}
	public void setList(List<KqjlImport> list) {
		this.list = list;
	}
	public int getAll() {
		return all;
	}
	public void setAll(int all) {
		this.all = all;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		WcggPageDAO wpdao = new WcggPageDAO();
		DateUtil du = new DateUtil();
		Query query;
		today = du.getStringDate();
		String thisFirstDay =du.getThisMonth()+"01";
		String hql = "";
		list = new ArrayList<KqjlImport>();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UserInfo ui = uidao.findByNewNumber(newnumber);
			if(ui!=null)
			{
				if(all==0)
				{
					hql = "from KqjlImport where name='"+ui.getUsername()+"' and date>='"+thisFirstDay+"' order by date desc";
				}
				else
				{
					String key="";
					String position = ui.getPosition();
					char zhi = position.charAt(0);
					if(zhi=='0')
					{
						key="_____";
					}
					else if(zhi=='1')
					{
						key="__"+position.substring(2, 3)+"__";
					}
					else if(zhi=='2')
					{
						key="__"+position.substring(2, 3)+"__";
					}
					else if(zhi=='4')
					{
						key="__"+position.substring(2, 3)+"_"+position.substring(4, 5);
					}
					hql = "from KqjlImport where name in (select username from UserInfo where position like '"+key+"') and date>='"+thisFirstDay+"' order by date desc";
				}
			}
			System.out.println(hql);
			query = session.createQuery(hql);
			List<KqjlImport> listtemp = query.list();
			if(all==0)//查询自己的时候
			{
				for(int i=0;i<listtemp.size();i++)
				{
					KqjlImport kitmp = listtemp.get(i);
					KqjlImport ki = new KqjlImport();
					ki.setDate(kitmp.getDate());
					ki.setName(kitmp.getName());
					ki.setQdtime(kitmp.getQdtime());
					ki.setQttime(kitmp.getQttime());
					UserInfo uitmp = uidao.findByName(ki.getName());
					List<LeavePage> listlp = lpdao.findByNewNumberAndDate(uitmp.getNewnumber(),ki.getDate(),"2,6,7,8");
					List<WcggPage> listwp = wpdao.findAllByNameAndDate(uitmp.getUsername(), ki.getDate());
					
					//保存请假类型
					if(!listlp.isEmpty())
					{
						LeavePage lp = listlp.get(0);
						//哺乳假算正常出勤
						if(lp.getType()!=14)
						{
							if(lp.getBegindate().equals(ki.getDate())&&(lp.getHalfday()==1||lp.getHalfday()==3))
							{
								if(listlp.size()>1)//当天有多于1条的请假记录
								{
									LeavePage lptemp = listlp.get(1);
									if(lptemp.getEnddate().equals(ki.getDate())&&(lptemp.getHalfday()==2||lptemp.getHalfday()==3))//第二条是上午半天
									{//全天
										ki.setQdtime("【请假】");
										ki.setQttime("【请假】");
									}
									else
									{
										ki.setQttime("【请假】");
									}
								}else
								{
									ki.setQttime("【请假】");
								}
							}
							else if(lp.getEnddate().equals(ki.getDate())&&(lp.getHalfday()==2||lp.getHalfday()==3))
							{
								if(listlp.size()>1)//当天有多于1条的请假记录
								{
									LeavePage lptemp = listlp.get(1);
									if(lptemp.getBegindate().equals(ki.getDate())&&(lptemp.getHalfday()==1||lptemp.getHalfday()==3))//第二条是下午半天
									{//全天
										ki.setQdtime("【请假】");
										ki.setQttime("【请假】");
									}
									else
									{
										ki.setQdtime("【请假】");
									}
								}else
								{
									ki.setQdtime("【请假】");
								}
							}
							else
							{
								ki.setQdtime("【请假】");
								ki.setQttime("【请假】");
							}
						}
					}
					
					//保存外出公干信息
					if(!listwp.isEmpty())
					{
						WcggPage wp = listwp.get(0);
						if(wp.getBegindate().equals(ki.getDate())&&(wp.getHalfday()==1||wp.getHalfday()==3))//第一天下午半天
						{
							if(listwp.size()>1)
							{
								WcggPage wptemp = listwp.get(1);
								if(wptemp.getEnddate().equals(ki.getDate())&&(wptemp.getHalfday()==2||wptemp.getHalfday()==3))
								{
									ki.setQdtime("【公干】");
									ki.setQttime("【公干】");
								}
								else
								{
									ki.setQttime("【公干】");
								}
							}
							else
							{
								ki.setQttime("【公干】");
							}
						}
						else if(wp.getEnddate().equals(ki.getDate())&&(wp.getHalfday()==2||wp.getHalfday()==3))
						{
							if(listwp.size()>1)
							{
								WcggPage wptemp = listwp.get(1);
								if(wptemp.getBegindate().equals(ki.getDate())&&(wptemp.getHalfday()==1||wptemp.getHalfday()==3))
								{
									ki.setQdtime("【公干】");
									ki.setQttime("【公干】");
								}
								else
								{
									ki.setQdtime("【公干】");
								}
							}	
							else
							{
								ki.setQdtime("【公干】");
							}
						}
						else
						{
							ki.setQdtime("【公干】");
							ki.setQttime("【公干】");
						}
					}
					
					list.add(ki);
				}
			}
			else
			{
				list = listtemp;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
