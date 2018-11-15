package office.pb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.pb.pojo.PbRemark;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for PbRemark entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .PbRemark
  * @author MyEclipse Persistence Tools 
 */

public class PbRemarkDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PbRemarkDAO.class);
		//property constants
	public static final String MONTH = "month";
	public static final String TYPE = "type";
	public static final String REMARK = "remark";



    
    public void save(PbRemark transientInstance) {
        log.debug("saving PbRemark instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PbRemark persistentInstance) {
        log.debug("deleting PbRemark instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PbRemark findById( java.lang.Integer id) {
        log.debug("getting PbRemark instance with id: " + id);
        try {
            PbRemark instance = (PbRemark) getSession()
                    .get("PbRemark", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PbRemark instance) {
        log.debug("finding PbRemark instance by example");
        try {
            List results = getSession()
                    .createCriteria("PbRemark")
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
      log.debug("finding PbRemark instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PbRemark as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMonth(Object month
	) {
		return findByProperty(MONTH, month
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all PbRemark instances");
		try {
			String queryString = "from PbRemark";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PbRemark merge(PbRemark detachedInstance) {
        log.debug("merging PbRemark instance");
        try {
            PbRemark result = (PbRemark) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PbRemark instance) {
        log.debug("attaching dirty PbRemark instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PbRemark instance) {
        log.debug("attaching clean PbRemark instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}