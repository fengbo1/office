package office.log.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.log.pojo.OperateLog;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for OperateLog entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .OperateLog
  * @author MyEclipse Persistence Tools 
 */

public class OperateLogDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OperateLogDAO.class);
		//property constants
	public static final String TIME = "time";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String ITEM = "item";
	public static final String OPERATE = "operate";
	public static final String REMARK = "remark";



    
    public void save(OperateLog transientInstance) {
        log.debug("saving OperateLog instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(OperateLog persistentInstance) {
        log.debug("deleting OperateLog instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OperateLog findById( java.lang.Integer id) {
        log.debug("getting OperateLog instance with id: " + id);
        try {
            OperateLog instance = (OperateLog) getSession()
                    .get("OperateLog", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(OperateLog instance) {
        log.debug("finding OperateLog instance by example");
        try {
            List results = getSession()
                    .createCriteria("OperateLog")
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
      log.debug("finding OperateLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from OperateLog as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
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
	
	public List findByItem(Object item
	) {
		return findByProperty(ITEM, item
		);
	}
	
	public List findByOperate(Object operate
	) {
		return findByProperty(OPERATE, operate
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all OperateLog instances");
		try {
			String queryString = "from OperateLog";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public OperateLog merge(OperateLog detachedInstance) {
        log.debug("merging OperateLog instance");
        try {
            OperateLog result = (OperateLog) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(OperateLog instance) {
        log.debug("attaching dirty OperateLog instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OperateLog instance) {
        log.debug("attaching clean OperateLog instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}