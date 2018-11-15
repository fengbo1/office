package office.kqjl.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.kqjl.pojo.ScpbUpload;
import office.kqjl.pojo.YgpbUpload;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ScpbUpload entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ScpbUpload
  * @author MyEclipse Persistence Tools 
 */

public class ScpbUploadDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScpbUploadDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String DATE = "date";
	public static final String PBQDTIME = "pbqdtime";
	public static final String PBQTTIME = "pbqttime";
	public static final String TB = "tb";



    
    public void save(ScpbUpload transientInstance) {
        log.debug("saving ScpbUpload instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ScpbUpload persistentInstance) {
        log.debug("deleting ScpbUpload instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ScpbUpload findById( java.lang.Integer id) {
        log.debug("getting ScpbUpload instance with id: " + id);
        try {
            ScpbUpload instance = (ScpbUpload) getSession()
                    .get("ScpbUpload", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ScpbUpload instance) {
        log.debug("finding ScpbUpload instance by example");
        try {
            List results = getSession()
                    .createCriteria("ScpbUpload")
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
      log.debug("finding ScpbUpload instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ScpbUpload as model where model." 
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
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByPbqdtime(Object pbqdtime
	) {
		return findByProperty(PBQDTIME, pbqdtime
		);
	}
	
	public List findByPbqttime(Object pbqttime
	) {
		return findByProperty(PBQTTIME, pbqttime
		);
	}
	
	public List findByTb(Object tb
	) {
		return findByProperty(TB, tb
		);
	}
	

	public List findAll() {
		log.debug("finding all ScpbUpload instances");
		try {
			String queryString = "from ScpbUpload";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ScpbUpload merge(ScpbUpload detachedInstance) {
        log.debug("merging ScpbUpload instance");
        try {
            ScpbUpload result = (ScpbUpload) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ScpbUpload instance) {
        log.debug("attaching dirty ScpbUpload instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ScpbUpload instance) {
        log.debug("attaching clean ScpbUpload instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public ScpbUpload findAllByDateName(String date,String name) {
		log.debug("finding all YgpbUpload instances");
		try {
			String queryString = "from ScpbUpload as su where su.date='"+date+"' and su.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 ScpbUpload su = new ScpbUpload();
				 su.setName(name);
				 su.setDate(date);
				 return su;
			 }
			 else
			 {
				 return null;
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public ScpbUpload findAllByDateNameNull(String date,String name) {
		log.debug("finding all YgpbUpload instances");
		try {
			String queryString = "from ScpbUpload as su where su.date='"+date+"' and su.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(!list.isEmpty())
			 {
				 ScpbUpload su = (ScpbUpload) list.get(0);
				 //su.setName(name);
				// su.setDate(date);
				 return su;
			 }
			 else
			 {
				 return null;
			 }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public List<ScpbUpload> findAllByName(String name,String yearmonth) {
		log.debug("finding all YgpbUpload instances");
		try {
			String queryString = "from ScpbUpload as su where su.name='"+name+"' and su.date>='"+yearmonth+"01' and su.date<='"+yearmonth+"31'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}