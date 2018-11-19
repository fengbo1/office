package office.jbsp.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.jbsp.pojo.JbspSummary;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for JbspSummary entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .JbspSummary
  * @author MyEclipse Persistence Tools 
 */

public class JbspSummaryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JbspSummaryDAO.class);
		//property constants
	public static final String YEAR = "year";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String POSITION = "position";
	public static final String TIMES = "times";
	public static final String DAYS = "days";
	public static final String DIDAYS = "didays";
	public static final String REMARK = "remark";



    
    public void save(JbspSummary transientInstance) {
        log.debug("saving JbspSummary instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(JbspSummary persistentInstance) {
        log.debug("deleting JbspSummary instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public JbspSummary findById( java.lang.Integer id) {
        log.debug("getting JbspSummary instance with id: " + id);
        try {
            JbspSummary instance = (JbspSummary) getSession()
                    .get("JbspSummary", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(JbspSummary instance) {
        log.debug("finding JbspSummary instance by example");
        try {
            List results = getSession()
                    .createCriteria("JbspSummary")
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
      log.debug("finding JbspSummary instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JbspSummary as model where model." 
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
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
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
	
	public List findByDidays(Object didays
	) {
		return findByProperty(DIDAYS, didays
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all JbspSummary instances");
		try {
			String queryString = "from JbspSummary";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public JbspSummary merge(JbspSummary detachedInstance) {
        log.debug("merging JbspSummary instance");
        try {
            JbspSummary result = (JbspSummary) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(JbspSummary instance) {
        log.debug("attaching dirty JbspSummary instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(JbspSummary instance) {
        log.debug("attaching clean JbspSummary instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public JbspSummary findAllByYearAndNewNumber(String year,String newnumber) {
    	log.debug("finding all JbspSummary instances");
    	try {
    		String queryString = "from JbspSummary as js where js.year='"+year+"' and js.newnumber='"+newnumber+"' order by js.id desc";
             Query queryObject = getSession().createQuery(queryString);
             List<JbspSummary> list = queryObject.list();
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