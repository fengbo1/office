package office.uass.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.uass.pojo.UassCode;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UassCode entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UassCode
  * @author MyEclipse Persistence Tools 
 */

public class UassCodeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UassCodeDAO.class);
		//property constants
	public static final String POOL = "pool";
	public static final String PAIXU = "paixu";
	public static final String CODE = "code";
	public static final String DETAIL = "detail";



    
    public void save(UassCode transientInstance) {
        log.debug("saving UassCode instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UassCode persistentInstance) {
        log.debug("deleting UassCode instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UassCode findById( java.lang.Integer id) {
        log.debug("getting UassCode instance with id: " + id);
        try {
            UassCode instance = (UassCode) getSession()
                    .get("UassCode", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UassCode instance) {
        log.debug("finding UassCode instance by example");
        try {
            List results = getSession()
                    .createCriteria("UassCode")
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
      log.debug("finding UassCode instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UassCode as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPool(Object pool
	) {
		return findByProperty(POOL, pool
		);
	}
	
	public List findByPaixu(Object paixu
	) {
		return findByProperty(PAIXU, paixu
		);
	}
	
	public List findByCode(Object code
	) {
		return findByProperty(CODE, code
		);
	}
	
	public List findByDetail(Object detail
	) {
		return findByProperty(DETAIL, detail
		);
	}
	

	public List findAll() {
		log.debug("finding all UassCode instances");
		try {
			String queryString = "from UassCode";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UassCode merge(UassCode detachedInstance) {
        log.debug("merging UassCode instance");
        try {
            UassCode result = (UassCode) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UassCode instance) {
        log.debug("attaching dirty UassCode instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UassCode instance) {
        log.debug("attaching clean UassCode instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
	public UassCode findCodeByPaixuAndPool(int paixu,String pool) {
		log.debug("finding all UassCode instances");
		try {
			String queryString = "from UassCode as uc where uc.paixu='"+paixu+"' and uc.pool='"+pool+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	return (UassCode) list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public UassCode findByPoolAndDetail(String pool,String detail) {
		log.debug("finding all UassCode instances");
		try {
			String queryString = "from UassCode as uc where uc.pool='"+pool+"' and uc.detail='"+detail+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	return (UassCode) list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}