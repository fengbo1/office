package office.mycalendar.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.mycalendar.pojo.Month;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Month entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Month
  * @author MyEclipse Persistence Tools 
 */

public class MonthDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MonthDAO.class);
		//property constants
	public static final String YEAR = "year";
	public static final String MONTH = "month";
	public static final String SCZHI = "sczhi";
	public static final String WORKDAYS = "workdays";



    
    public void save(Month transientInstance) {
        log.debug("saving Month instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Month persistentInstance) {
        log.debug("deleting Month instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Month findById( java.lang.Integer id) {
        log.debug("getting Month instance with id: " + id);
        try {
            Month instance = (Month) getSession()
                    .get("Month", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Month instance) {
        log.debug("finding Month instance by example");
        try {
            List results = getSession()
                    .createCriteria("Month")
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
      log.debug("finding Month instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Month as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
		);
	}
	
	public List findByMonth(Object month
	) {
		return findByProperty(MONTH, month
		);
	}
	
	public List findBySczhi(Object sczhi
	) {
		return findByProperty(SCZHI, sczhi
		);
	}
	
	public List findByWorkdays(Object workdays
	) {
		return findByProperty(WORKDAYS, workdays
		);
	}
	

	public List findAll() {
		log.debug("finding all Month instances");
		try {
			String queryString = "from Month";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Month merge(Month detachedInstance) {
        log.debug("merging Month instance");
        try {
            Month result = (Month) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Month instance) {
        log.debug("attaching dirty Month instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Month instance) {
        log.debug("attaching clean Month instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}