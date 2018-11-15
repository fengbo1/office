package office.mycalendar.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.mycalendar.pojo.MyCalendar;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for MyCalendar entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .MyCalendar
  * @author MyEclipse Persistence Tools 
 */

public class MyCalendarDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MyCalendarDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String WEEK = "week";
	public static final String WORKDAY = "workday";
	public static final String REMARK = "remark";



    
    public void save(MyCalendar transientInstance) {
        log.debug("saving MyCalendar instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MyCalendar persistentInstance) {
        log.debug("deleting MyCalendar instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MyCalendar findById( java.lang.Integer id) {
        log.debug("getting MyCalendar instance with id: " + id);
        try {
            MyCalendar instance = (MyCalendar) getSession()
                    .get("MyCalendar", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(MyCalendar instance) {
        log.debug("finding MyCalendar instance by example");
        try {
            List results = getSession()
                    .createCriteria("MyCalendar")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding MyCalendar instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MyCalendar as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByWeek(Object week
	) {
		return findByProperty(WEEK, week
		);
	}
	
	public List findByWorkday(Object workday
	) {
		return findByProperty(WORKDAY, workday
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "from MyCalendar";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MyCalendar merge(MyCalendar detachedInstance) {
        log.debug("merging MyCalendar instance");
        try {
            MyCalendar result = (MyCalendar) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MyCalendar instance) {
        log.debug("attaching dirty MyCalendar instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MyCalendar instance) {
        log.debug("attaching clean MyCalendar instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
	 * 根据日期查询当月最后一天
	 * @param date
	 * @return
	 */
	public String findEndDateByDate(String date)
	{
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "from MyCalendar as mc where mc.date like '"+date.substring(0,6)+"__' order by mc.date desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<MyCalendar> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	 return list.get(0).getDate();
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 传入8位日期
     * 返回是否是工作日
     * @param date
     * @return true 工作日 false 非工作日
     */
    public boolean ifWorkDay(String date) {
		log.debug("finding all MyCalendar instances");
		try {
			 String queryString = "from MyCalendar as mc where mc.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         MyCalendar calendar = (MyCalendar) queryObject.list().get(0);
	         if(calendar.getWorkday()==1)
	         {
	        	 return true;
	         }
	         else
	         {
	        	 return false;
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public MyCalendar findByDate(String date) {
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "from MyCalendar as mc where mc.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return (MyCalendar) queryObject.list().get(0);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 根据起始截止日期工作日查询所有
     * @param begindate
     * @param enddate
     * @param workday 1工作日，0非工作日 2全部
     * @return
     */
    public List<MyCalendar> findByBeginAndEnd(String begindate,String enddate,int workday) {
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "";
			if(workday==2)
			{
				queryString = "from MyCalendar as mc where mc.date>='"+begindate+"' and mc.date<='"+enddate+"'";
			}
			else
			{
				queryString = "from MyCalendar as mc where mc.date>='"+begindate+"' and mc.date<='"+enddate+"' and mc.workday="+workday;
			}
			 Query queryObject = getSession().createQuery(queryString);
			 return  queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 根据起始截止日期halfday查询加班可抵用天数（国家法定节假日1比2）
     * @param begindate
     * @param enddate
     * @param workday 1工作日，0非工作日 2全部
     * @param halfday 0无，1第一天下午，2最后一天上午，3=1+2
     * @return
     */
    public double findJbdaysByBeginAndEnd(String begindate,String enddate,int halfday) {
		log.debug("finding all MyCalendar instances");
		try {
			double jbdays = 0;
			String queryString = "";
			queryString = "from MyCalendar as mc where mc.date>='"+begindate+"' and mc.date<='"+enddate+"'";
			Query queryObject = getSession().createQuery(queryString);
			List<MyCalendar> list = queryObject.list();
			
			if(begindate.equals(enddate))//只有一天
			{
				MyCalendar mc = list.get(0);
				double tempday = 0;
				if(halfday==1||halfday==2)
				{
					tempday = 0.5;
				}
				else
				{
					tempday = 1;
				}
				if(mc.getRemark().equals("1"))
				{
					tempday = tempday*2;
				}
				jbdays+=tempday;
			}
			else//一天以上
			{
				for(int i=0;i<list.size();i++)
				{
					MyCalendar mc = list.get(i);
					if(mc.getDate().equals(begindate))//第一天
					{
						double tempday = 0;
						if(halfday==1||halfday==3)
						{
							tempday=0.5;
						}
						else
						{
							tempday=1;
						}
						if(mc.getRemark().equals("1"))
						{
							tempday = tempday*2;
						}
						jbdays+=tempday;
					}
					else if(mc.getDate().equals(enddate))//最后一天
					{
						double tempday = 0;
						if(halfday==2||halfday==3)
						{
							tempday=0.5;
						}
						else
						{
							tempday=1;
						}
						if(mc.getRemark().equals("1"))
						{
							tempday = tempday*2;
						}
						jbdays+=tempday;
					}
					else//中间天数
					{
						double tempday = 1;
						if(mc.getRemark().equals("1"))
						{
							tempday = tempday*2;
						}
						jbdays+=tempday;
					}
				}
			}
			System.out.println(begindate+"---"+enddate+":"+jbdays);
			return jbdays;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}