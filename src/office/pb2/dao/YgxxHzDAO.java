package office.pb2.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.pb2.pojo.YgxxHz;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for YgxxHz entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .YgxxHz
  * @author MyEclipse Persistence Tools 
 */

public class YgxxHzDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(YgxxHzDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String YEAR = "year";
	public static final String QUARTER = "quarter";
	public static final String TIMES = "times";
	public static final String DAYS = "days";
	public static final String HOURS = "hours";
	public static final String CHU = "chu";



    
    public void save(YgxxHz transientInstance) {
        log.debug("saving YgxxHz instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(YgxxHz persistentInstance) {
        log.debug("deleting YgxxHz instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public YgxxHz findById( java.lang.Integer id) {
        log.debug("getting YgxxHz instance with id: " + id);
        try {
            YgxxHz instance = (YgxxHz) getSession()
                    .get("YgxxHz", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(YgxxHz instance) {
        log.debug("finding YgxxHz instance by example");
        try {
            List results = getSession()
                    .createCriteria("YgxxHz")
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
      log.debug("finding YgxxHz instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from YgxxHz as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
		);
	}
	
	public List findByQuarter(Object quarter
	) {
		return findByProperty(QUARTER, quarter
		);
	}
	
	public List findByTimes(Object times
	) {
		return findByProperty(TIMES, times
		);
	}
	
	public List findByDays(Object days
	) {
		return findByProperty(DAYS, days
		);
	}
	
	public List findByHours(Object hours
	) {
		return findByProperty(HOURS, hours
		);
	}
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	

	public List findAll() {
		log.debug("finding all YgxxHz instances");
		try {
			String queryString = "from YgxxHz";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public YgxxHz merge(YgxxHz detachedInstance) {
        log.debug("merging YgxxHz instance");
        try {
            YgxxHz result = (YgxxHz) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(YgxxHz instance) {
        log.debug("attaching dirty YgxxHz instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(YgxxHz instance) {
        log.debug("attaching clean YgxxHz instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public YgxxHz findAllByNameAndYearAndQuarter(String name,int year,int quarter) {
    	log.debug("finding all YgxxHz instances");
    	try {
    		String queryString = "from YgxxHz as yh where yh.name='"+name+"' and yh.year="+year+" and yh.quarter="+quarter;
             Query queryObject = getSession().createQuery(queryString);
             List<YgxxHz> list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
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
}