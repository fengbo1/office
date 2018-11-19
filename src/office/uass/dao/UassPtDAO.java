package office.uass.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.uass.pojo.UassPt;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UassPt entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UassPt
  * @author MyEclipse Persistence Tools 
 */

public class UassPtDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UassPtDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDERTAKE = "preundertake";
	public static final String UNDERTAKE = "undertake";
	public static final String INITIATOR = "initiator";
	public static final String APPLICANT = "applicant";
	public static final String POSITION = "position";
	public static final String TEL = "tel";
	public static final String SXTIME = "sxtime";
	public static final String FILENAME = "filename";
	public static final String REMARK = "remark";



    
    public void save(UassPt transientInstance) {
        log.debug("saving UassPt instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UassPt persistentInstance) {
        log.debug("deleting UassPt instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UassPt findById( java.lang.Integer id) {
        log.debug("getting UassPt instance with id: " + id);
        try {
            UassPt instance = (UassPt) getSession()
                    .get("UassPt", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UassPt instance) {
        log.debug("finding UassPt instance by example");
        try {
            List results = getSession()
                    .createCriteria("UassPt")
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
      log.debug("finding UassPt instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UassPt as model where model." 
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
	
	public List findByProcess(Object process
	) {
		return findByProperty(PROCESS, process
		);
	}
	
	public List findByJindu(Object jindu
	) {
		return findByProperty(JINDU, jindu
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findByPreundertake(Object preundertake
	) {
		return findByProperty(PREUNDERTAKE, preundertake
		);
	}
	
	public List findByUndertake(Object undertake
	) {
		return findByProperty(UNDERTAKE, undertake
		);
	}
	
	public List findByInitiator(Object initiator
	) {
		return findByProperty(INITIATOR, initiator
		);
	}
	
	public List findByApplicant(Object applicant
	) {
		return findByProperty(APPLICANT, applicant
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findBySxtime(Object sxtime
	) {
		return findByProperty(SXTIME, sxtime
		);
	}
	
	public List findByFilename(Object filename
	) {
		return findByProperty(FILENAME, filename
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all UassPt instances");
		try {
			String queryString = "from UassPt";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UassPt merge(UassPt detachedInstance) {
        log.debug("merging UassPt instance");
        try {
            UassPt result = (UassPt) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UassPt instance) {
        log.debug("attaching dirty UassPt instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UassPt instance) {
        log.debug("attaching clean UassPt instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /**
     * 
     * @param number
     * @return
     */
    public UassPt findAllByNumber(String number) {
    	log.debug("finding all UassPt instances");
    	try {
    		String queryString = "from UassPt as up where up.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List<UassPt> list = queryObject.list();
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