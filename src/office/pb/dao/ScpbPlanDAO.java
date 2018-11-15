package office.pb.dao;


import ccb.dao.BaseHibernateDAO;
import java.util.List;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.YgpbPlan;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ScpbPlan entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ScpbPlan
  * @author MyEclipse Persistence Tools 
 */

public class ScpbPlanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScpbPlanDAO.class);
		//property constants
	public static final String NO = "no";
	public static final String NUM = "num";
	public static final String SBTIME = "sbtime";
	public static final String XBTIME = "xbtime";
	public static final String ZYTIME = "zytime";
	public static final String PXTIME = "pxtime";
	public static final String TYPE = "type";



    
    public void save(ScpbPlan transientInstance) {
        log.debug("saving ScpbPlan instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ScpbPlan persistentInstance) {
        log.debug("deleting ScpbPlan instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ScpbPlan findById( java.lang.Integer id) {
        log.debug("getting ScpbPlan instance with id: " + id);
        try {
            ScpbPlan instance = (ScpbPlan) getSession()
                    .get("ScpbPlan", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ScpbPlan instance) {
        log.debug("finding ScpbPlan instance by example");
        try {
            List results = getSession()
                    .createCriteria("ScpbPlan")
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
      log.debug("finding ScpbPlan instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ScpbPlan as model where model." 
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
	
	public List findByNum(Object num
	) {
		return findByProperty(NUM, num
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
	
	public List findByPxtime(Object pxtime
	) {
		return findByProperty(PXTIME, pxtime
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	

	public List findAll() {
		log.debug("finding all ScpbPlan instances");
		try {
			String queryString = "from ScpbPlan";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ScpbPlan merge(ScpbPlan detachedInstance) {
        log.debug("merging ScpbPlan instance");
        try {
            ScpbPlan result = (ScpbPlan) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ScpbPlan instance) {
        log.debug("attaching dirty ScpbPlan instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ScpbPlan instance) {
        log.debug("attaching clean ScpbPlan instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public ScpbPlan findAllMaxNumByNo(int no) {
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from ScpbPlan as sp where sp.no="+no+" order by sp.num desc";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbPlan) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public List<ScpbPlan> findAllMaxNum() {
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from ScpbPlan as sp where sp.num=(select Max(sp.num) from ScpbPlan as sp) order by sp.no";
             Query queryObject = getSession().createQuery(queryString);
             List<ScpbPlan> list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return list;
    	     }
    	   }
             catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    } 
    
    public ScpbPlan findAllByID(int id) {
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from ScpbPlan as sp where sp.id="+id;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbPlan) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public ScpbPlan findAllByNoAndNum(int no,int num){
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from ScpbPlan as sp where sp.no="+no+" and sp.num="+num;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbPlan) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public ScpbPlan findAllByNoAndNum(String no,int num){
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from ScpbPlan as sp where sp.no="+no+" and sp.num="+num;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbPlan) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public ScpbPlan findAllByTypeAndNum(int type,int num){
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from ScpbPlan as sp where sp.type="+type+" and sp.num="+num;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbPlan) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public ScpbPlan findAllByTypeAndNum(String type,int num){
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from ScpbPlan as sp where sp.type="+type+" and sp.num="+num;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbPlan) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllOrderByNo(int num) {
    	log.debug("finding all ScpbPlan instances");
    	try {
    		String queryString = "from ScpbPlan as sp where sp.num="+num+" order by sp.no";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}