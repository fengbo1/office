package office.pb.dao;


import ccb.dao.BaseHibernateDAO;
import java.util.List;
import office.pb.pojo.YgpbPlan;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for YgpbPlan entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .YgpbPlan
  * @author MyEclipse Persistence Tools 
 */

public class YgpbPlanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(YgpbPlanDAO.class);
		//property constants
	public static final String NO = "no";
	public static final String SBTIME = "sbtime";
	public static final String XBTIME = "xbtime";
	public static final String ZYTIME = "zytime";



    
    public void save(YgpbPlan transientInstance) {
        log.debug("saving YgpbPlan instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(YgpbPlan persistentInstance) {
        log.debug("deleting YgpbPlan instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public YgpbPlan findById( java.lang.Integer id) {
        log.debug("getting YgpbPlan instance with id: " + id);
        try {
            YgpbPlan instance = (YgpbPlan) getSession()
                    .get("YgpbPlan", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(YgpbPlan instance) {
        log.debug("finding YgpbPlan instance by example");
        try {
            List results = getSession()
                    .createCriteria("YgpbPlan")
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
      log.debug("finding YgpbPlan instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from YgpbPlan as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNo(Object no
	) {
		return findByProperty(NO, no
		);
	}
	
	public List findBySbtime(Object sbtime
	) {
		return findByProperty(SBTIME, sbtime
		);
	}
	
	public List findByXbtime(Object xbtime
	) {
		return findByProperty(XBTIME, xbtime
		);
	}
	
	public List findByZytime(Object zytime
	) {
		return findByProperty(ZYTIME, zytime
		);
	}
	

	public List findAll() {
		log.debug("finding all YgpbPlan instances");
		try {
			String queryString = "from YgpbPlan";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public YgpbPlan merge(YgpbPlan detachedInstance) {
        log.debug("merging YgpbPlan instance");
        try {
            YgpbPlan result = (YgpbPlan) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(YgpbPlan instance) {
        log.debug("attaching dirty YgpbPlan instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(YgpbPlan instance) {
        log.debug("attaching clean YgpbPlan instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public YgpbPlan findAllByNo(int no) {
    	log.debug("finding all YgpbPlan instances");
    	try {
    		String queryString = "from YgpbPlan as yp where yp.no="+no;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (YgpbPlan) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public YgpbPlan findAllByID(int id) {
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from YgpbPlan as yp where yp.id="+id;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (YgpbPlan) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllOrderByNo() {
    	log.debug("finding all YgpbPlan instances");
    	try {
    		String queryString = "from YgpbPlan as yp order by yp.no";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}