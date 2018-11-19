package office.jbsp.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.jbsp.pojo.JbspPageDi;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for JbspPageDi entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .JbspPageDi
  * @author MyEclipse Persistence Tools 
 */

public class JbspPageDiDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JbspPageDiDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String DAYS = "days";
	public static final String JBDAYS = "jbdays";
	public static final String DIDAYS = "didays";



    
    public void save(JbspPageDi transientInstance) {
        log.debug("saving JbspPageDi instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(JbspPageDi persistentInstance) {
        log.debug("deleting JbspPageDi instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public JbspPageDi findById( java.lang.Integer id) {
        log.debug("getting JbspPageDi instance with id: " + id);
        try {
            JbspPageDi instance = (JbspPageDi) getSession()
                    .get("JbspPageDi", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(JbspPageDi instance) {
        log.debug("finding JbspPageDi instance by example");
        try {
            List results = getSession()
                    .createCriteria("JbspPageDi")
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
      log.debug("finding JbspPageDi instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JbspPageDi as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByBegindate(Object begindate
	) {
		return findByProperty(BEGINDATE, begindate
		);
	}
	
	public List findByEnddate(Object enddate
	) {
		return findByProperty(ENDDATE, enddate
		);
	}
	
	public List findByDays(Object days
	) {
		return findByProperty(DAYS, days
		);
	}
	
	public List findByJbdays(Object jbdays
	) {
		return findByProperty(JBDAYS, jbdays
		);
	}
	
	public List findByDidays(Object didays
	) {
		return findByProperty(DIDAYS, didays
		);
	}
	

	public List findAll() {
		log.debug("finding all JbspPageDi instances");
		try {
			String queryString = "from JbspPageDi";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public JbspPageDi merge(JbspPageDi detachedInstance) {
        log.debug("merging JbspPageDi instance");
        try {
            JbspPageDi result = (JbspPageDi) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(JbspPageDi instance) {
        log.debug("attaching dirty JbspPageDi instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(JbspPageDi instance) {
        log.debug("attaching clean JbspPageDi instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
	public JbspPageDi findAllByNumber(String number) {
		log.debug("finding all JbspPageDi instances");
		try {
			String queryString = "from JbspPageDi as jpd where jpd.number='"+number+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 return null;
			 }
			 else
			 {
				 return (JbspPageDi) list.get(0);
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public JbspPageDi findAllByNumberName(String number,String name) {
		log.debug("finding all JbspPageDi instances");
		try {
			String queryString = "from JbspPageDi as jpd where jpd.number='"+number+"' and jpd.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<JbspPageDi> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 JbspPageDi jpd = new JbspPageDi();
	        	 jpd.setName(name);
	        	 jpd.setNumber(number);
	        	 return jpd;
	         }
	         else
	         {
	        	 return list.get(0);
	         }
			 
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 返回date之后的加班调休申请
     * @param date
     * @param Name
     * @return
     */
    public List findAllByBegindateEnddateName(String date,String name) {
		log.debug("finding all JbspPageDi instances");
		try {
			String queryString = "from JbspPageDi as jpd where jpd.enddate>='"+date+"' and jpd.name='"+name+"' and jpd.jbdays>jpd.didays order by jpd.begindate";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 返回date之内的加班调休申请天数
     * @param date
     * @param Name
     * @return
     */
    public double findDaysByBegindateEnddateName(String date,String name) {
		log.debug("finding all JbspPageDi instances");
		try {
			double result=0.0;
			String serdate = getLastSixMonthDate(date);
			String queryString = "select sum(jpd.jbdays-jpd.didays) from t_jbsp_page_di as jpd where jpd.enddate>='"+serdate+"' and jpd.name='"+name+"' and jpd.jbdays>jpd.didays";
	         Object obj = getSession().createSQLQuery(queryString).uniqueResult();
	         if(obj!=null)
	         {
	        	 result = Double.parseDouble(obj.toString());
	         }
			 return result;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 请加班调休后，抵扣加班抵扣表中的天数
     * @param name 抵扣人姓名
     * @param begindate 请假起始日期
     * @param days 天数
     * @return
     */
    public String diKouJbdays(String name,String begindate,double days)
    {
    	String serdate = "";
    	double tempdays = days;
    	serdate = getLastSixMonthDate(begindate);
    	List<JbspPageDi> listjpd = findAllByBegindateEnddateName(serdate,name);
    	for(int i=0;i<listjpd.size();i++)
    	{
    		JbspPageDi jpd = listjpd.get(i);
    		double restdays = jpd.getJbdays()-jpd.getDidays();
    		if(tempdays<=restdays)//如果够抵用
    		{
    			jpd.setDidays(jpd.getDidays()+tempdays);
    			tempdays=0;
    		}
    		else
    		{
    			jpd.setDidays(jpd.getJbdays());
    			tempdays-=restdays;
    		}
    		merge(jpd);
    	}
    	return "success";
    }
    /**
     * 还原加班调休抵扣天数()
     * @param name 抵扣人姓名
     * @param days 天数
     * @return restdays;处理完还原抵扣表后，如果还有剩余未抵扣天数，返回天数
     */
    public double huanYuanJbDays(String name,double days)
    {
    	double tempdays = days;
    	String sql = "from JbspPageDi as jpd where jpd.didays>0 and name='"+name+"' order by jpd.begindate desc";
    	List<JbspPageDi> listjpd = getSession().createQuery(sql).list();
    	for(int i=0;i<listjpd.size();i++)
    	{
    		JbspPageDi jpd = listjpd.get(i);
    		if(jpd.getDidays()>=tempdays)//如果本次调休抵用够还原
    		{
    			jpd.setDidays(jpd.getDidays()-tempdays);
    			tempdays=0;
    		}
    		else//如果本次调休抵用不够还原
    		{
    			tempdays-=jpd.getDidays();
    			jpd.setDidays(0.0);
    		}
    		merge(jpd);
    	}
    	return tempdays;
    }
    /**
     * 输入日期半年前的日期
     * @param date
     * @return
     */
    public String getLastSixMonthDate(String date)
    {
    	String serdate="20999999";
    	int year = Integer.parseInt(date.substring(0, 4));
    	int month = Integer.parseInt(date.substring(4, 6));
    	if(month>6)//7-12
    	{
    		month-=6;
    		serdate = date.substring(0, 4)+"0"+String.valueOf(month)+date.substring(6,8);
    	}
    	else//1-6
    	{
    		year-=1;
    		month+=6;
    		if(month<10)
    		{
    			serdate = String.valueOf(year)+"0"+String.valueOf(month)+date.substring(6,8);
    		}
    		else
    		{
    			serdate = String.valueOf(year)+String.valueOf(month)+date.substring(6,8);
    		}
    	}
    	return serdate;
    }
}