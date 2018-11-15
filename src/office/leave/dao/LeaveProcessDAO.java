package office.leave.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.leave.pojo.LeaveProcess;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for LeaveProcess entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .LeaveProcess
  * @author MyEclipse Persistence Tools 
 */

public class LeaveProcessDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(LeaveProcessDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String TIME = "time";
	public static final String VIEWER = "viewer";
	public static final String VIEWERNEWNUMBER = "viewernewnumber";
	public static final String ROLE = "role";
	public static final String AUTHORITY = "authority";
	public static final String OPINION = "opinion";
	public static final String REMARK = "remark";



    
    public void save(LeaveProcess transientInstance) {
        log.debug("saving LeaveProcess instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LeaveProcess persistentInstance) {
        log.debug("deleting LeaveProcess instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LeaveProcess findById( java.lang.Integer id) {
        log.debug("getting LeaveProcess instance with id: " + id);
        try {
            LeaveProcess instance = (LeaveProcess) getSession()
                    .get("LeaveProcess", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(LeaveProcess instance) {
        log.debug("finding LeaveProcess instance by example");
        try {
            List results = getSession()
                    .createCriteria("LeaveProcess")
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
      log.debug("finding LeaveProcess instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LeaveProcess as model where model." 
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
	
	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
		);
	}
	
	public List findByViewer(Object viewer
	) {
		return findByProperty(VIEWER, viewer
		);
	}
	
	public List findByViewernewnumber(Object viewernewnumber
	) {
		return findByProperty(VIEWERNEWNUMBER, viewernewnumber
		);
	}
	
	public List findByRole(Object role
	) {
		return findByProperty(ROLE, role
		);
	}
	
	public List findByAuthority(Object authority
	) {
		return findByProperty(AUTHORITY, authority
		);
	}
	
	public List findByOpinion(Object opinion
	) {
		return findByProperty(OPINION, opinion
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all LeaveProcess instances");
		try {
			String queryString = "from LeaveProcess";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LeaveProcess merge(LeaveProcess detachedInstance) {
        log.debug("merging LeaveProcess instance");
        try {
            LeaveProcess result = (LeaveProcess) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LeaveProcess instance) {
        log.debug("attaching dirty LeaveProcess instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LeaveProcess instance) {
        log.debug("attaching clean LeaveProcess instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
     * 根据请假审批表编号查询审批人意见
     * @param number
     * @return
     */
    public List<LeaveProcess> findAllByNumber(String number) {
    	log.debug("finding all LeaveProcess instances");
    	try {
    		String queryString = "from LeaveProcess as lp where lp.number='"+number+"' order by lp.id";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List<LeaveProcess> findByNewNumber(String newnumber) {
    	log.debug("finding all LeaveProcess instances");
    	try {
    		String queryString = "from LeaveProcess as lp where lp.newnumber='"+newnumber+"' order by lp.id";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public List<LeaveProcess> findByDelete(String year,String month,String day) {
    	log.debug("finding all LeaveProcess instances");
    	try {
    		 String queryString = "from LeaveProcess as lp where lp.time like '"+year+"_"+month+"_"+day+"%' and (lp.number like '%QJSQ%' or lp.number like '%YGXX%') and lp.remark like '%撤销%' order by lp.id";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}