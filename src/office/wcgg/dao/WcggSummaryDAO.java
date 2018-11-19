package office.wcgg.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.wcgg.pojo.WcggSummary;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for WcggSummary entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WcggSummary
  * @author MyEclipse Persistence Tools 
 */

public class WcggSummaryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WcggSummaryDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String YEAR = "year";
	public static final String NEWNUMBER = "newnumber";
	public static final String CHU = "chu";
	public static final String ZU = "zu";
	public static final String TIMES = "times";
	public static final String DAYS = "days";
	public static final String REMARK = "remark";



    
    public void save(WcggSummary transientInstance) {
        log.debug("saving WcggSummary instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WcggSummary persistentInstance) {
        log.debug("deleting WcggSummary instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WcggSummary findById( java.lang.Integer id) {
        log.debug("getting WcggSummary instance with id: " + id);
        try {
            WcggSummary instance = (WcggSummary) getSession()
                    .get("WcggSummary", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WcggSummary instance) {
        log.debug("finding WcggSummary instance by example");
        try {
            List results = getSession()
                    .createCriteria("WcggSummary")
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
      log.debug("finding WcggSummary instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WcggSummary as model where model." 
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
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	
	public List findByZu(Object zu
	) {
		return findByProperty(ZU, zu
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
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all WcggSummary instances");
		try {
			String queryString = "from WcggSummary";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public WcggSummary findAllByNewNumberAndYear(String NewNumber,String year) {
		log.debug("finding all WcggSummary instances");
		try {
			String queryString = "from WcggSummary as ws where ws.newnumber='"+NewNumber+"' and ws.year='"+year+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<WcggSummary> list = queryObject.list();
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
	
    public WcggSummary merge(WcggSummary detachedInstance) {
        log.debug("merging WcggSummary instance");
        try {
            WcggSummary result = (WcggSummary) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WcggSummary instance) {
        log.debug("attaching dirty WcggSummary instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WcggSummary instance) {
        log.debug("attaching clean WcggSummary instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}