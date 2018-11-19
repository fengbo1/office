package office.pb2.action;

import office.pb2.dao.YgxxHzDAO;
import office.pb2.pojo.XxsqPage;
import office.pb2.pojo.YgxxHz;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ProcessYgxxHz {

	private static Logger logger = Logger.getLogger(ProcessYgxxHz.class);
	public String process(XxsqPage xp) throws Exception
	{
		YgxxHzDAO yhdao = new YgxxHzDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    
 	   if(xp.getNumber().equals("20161230YGXX01002"))
		{
			System.out.println("!!");
		}
 		try {
 			String enddate = xp.getEnddate();
 			String sql = "";
 			String bd = "";
 			String ed = "";
 			logger.debug("计算汇总表"+xp.getNumber()+"status:"+xp.getStatus());
 			System.out.println("计算汇总表"+xp.getNumber()+"status:"+xp.getStatus());
 			String[] peoples = xp.getPeople().split("、");
 			int year = Integer.parseInt(enddate.substring(0, 4));
 			int month = Integer.parseInt(enddate.substring(4, 6));
 			int quarter = 0;
 			if(month>=1&&month<=2)
 			{
 				quarter = 1;
 				bd = String.valueOf(year-1)+"1201";
 				ed = String.valueOf(year)+"0229";
 			}
 			else if(month>=3&&month<=5)
 			{
 				quarter = 2;
 				bd = String.valueOf(year)+"0301";
 				ed = String.valueOf(year)+"0531";
 			}
 			else if(month>=6&&month<=8)
 			{
 				quarter = 3;
 				bd = String.valueOf(year)+"0601";
 				ed = String.valueOf(year)+"0831";
 			}
 			else if(month>=9&&month<=11)
 			{
 				quarter = 4;
 				bd = String.valueOf(year)+"0901";
 				ed = String.valueOf(year)+"1131";
 			}
 			else if(month==12)
 			{
 				quarter = 1;
 				bd = String.valueOf(year)+"1201";
 				ed = String.valueOf(year+1)+"0229";
 				year += 1;
 			}
 			if(bd.length()==8&&ed.length()==8)
 			{
 				for(int i=0;i<peoples.length;i++)
 	 			{
 					
 	 				YgxxHz yh = yhdao.findAllByNameAndYearAndQuarter(peoples[i], year, quarter);
 	 				if(yh==null)
 	 				{
 	 					yh=new YgxxHz();
 	 					UserInfo ui = uidao.findByName(peoples[i]);
 	 					yh.setName(peoples[i]);
 	 					yh.setYear(year);
 	 					yh.setQuarter(quarter);
 	 					if(ui!=null)
 	 					{
 	 						yh.setChu(ui.getPosition().substring(2,3));
 	 					}
 	 				    
 	 				}
 	 				sql = "SELECT count(*) from t_xxsq_page where status in(4,7) and people like '%"+peoples[i]+"%' and begindate>='"+bd+"' and begindate<='"+ed+"'";
 	 				logger.debug(sql);
 	 				int times = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
 	 				yh.setTimes(times);
 	 				sql = "SELECT sum(day) from t_xxsq_page where status in(4,7) and people like '%"+peoples[i]+"%' and begindate>='"+bd+"' and begindate<='"+ed+"'";
 	 				logger.debug(sql);
 	 				if(session.createSQLQuery(sql).uniqueResult()!=null)
 	 				{
 	 					double days = Double.valueOf((session.createSQLQuery(sql).uniqueResult().toString()));
 	 					yh.setDays(days);
 	 				}
 	 				else
 	 				{
 	 					yh.setDays(0.0);
 	 				}
 	 				sql = "SELECT sum(hour) from t_xxsq_page where status in(4,7) and people like '%"+peoples[i]+"%' and begindate>='"+bd+"' and begindate<='"+ed+"'";
 	 				logger.debug(sql);
 	 				if(session.createSQLQuery(sql).uniqueResult()!=null)
 	 				{
 	 					double hour = Double.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
 	 					yh.setHours(hour);
 	 				}
 	 				else
 	 				{
 	 					yh.setHours(0.0);
 	 				}
 	 				yhdao.merge(yh);
 	 			}
 			}
 			
 		}catch (Exception e) {
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
	
	public String processwithoutsession(Session session,XxsqPage xp) throws Exception
	{
		YgxxHzDAO yhdao = new YgxxHzDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		String enddate = xp.getEnddate();
			String sql = "";
			String bd = "";
			String ed = "";
			String[] peoples = xp.getPeople().split("、");
			int year = Integer.parseInt(enddate.substring(0, 4));
			int month = Integer.parseInt(enddate.substring(4, 6));
			int quarter = 0;
			if(month>=1&&month<=2)
			{
				quarter = 1;
				bd = String.valueOf(year-1)+"1201";
				ed = String.valueOf(year)+"0229";
			}
			else if(month>=3&&month<=5)
			{
				quarter = 2;
				bd = String.valueOf(year)+"0301";
				ed = String.valueOf(year)+"0531";
			}
			else if(month>=6&&month<=8)
			{
				quarter = 3;
				bd = String.valueOf(year)+"0601";
				ed = String.valueOf(year)+"0831";
			}
			else if(month>=9&&month<=11)
			{
				quarter = 4;
				bd = String.valueOf(year)+"0901";
				ed = String.valueOf(year)+"1131";
			}
			else if(month==12)
			{
				quarter = 1;
				//year += 1;
				bd = String.valueOf(year)+"1201";
				ed = String.valueOf(year+1)+"0229";
			}
			if(bd.length()==8&&ed.length()==8)
			{
				for(int i=0;i<peoples.length;i++)
	 			{
	 				YgxxHz yh = yhdao.findAllByNameAndYearAndQuarter(peoples[i], year, quarter);
	 				if(yh==null)
	 				{
	 					yh=new YgxxHz();
	 					UserInfo ui = uidao.findByName(peoples[i]);
	 					yh.setName(peoples[i]);
	 					yh.setYear(year);
	 					yh.setQuarter(quarter);
	 					if(ui!=null)
 	 					{
 	 						yh.setChu(ui.getPosition().substring(2,3));
 	 					}
	 				}
	 				sql = "SELECT count(*) from t_xxsq_page where status in(4,7) and people like '%"+peoples[i]+"%' and begindate>='"+bd+"' and begindate<='"+ed+"'";
	 				int times = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
	 				yh.setTimes(times);
	 				sql = "SELECT sum(day) from t_xxsq_page where status in(4,7) and people like '%"+peoples[i]+"%' and begindate>='"+bd+"' and begindate<='"+ed+"'";
	 				if(session.createSQLQuery(sql).uniqueResult()!=null)
	 				{
	 					double days = Double.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
	 					yh.setDays(days);
	 				}
	 				else
	 				{
	 					yh.setDays(0.0);
	 				}
	 				sql = "SELECT sum(hour) from t_xxsq_page where status in(4,7) and people like '%"+peoples[i]+"%' and begindate>='"+bd+"' and begindate<='"+ed+"'";
	 				if(session.createSQLQuery(sql).uniqueResult()!=null)
	 				{
	 					double hour = Double.valueOf(session.createSQLQuery(sql).uniqueResult().toString());
	 					yh.setHours(hour);
	 				}
	 				else
	 				{
	 					yh.setHours(0.0);
	 				}
	 				yhdao.merge(yh);
	 			}
			}
		return "success";
	}
}
