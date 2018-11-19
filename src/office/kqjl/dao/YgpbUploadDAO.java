package office.kqjl.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.kqjl.pojo.YgpbUpload;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for YgpbUpload entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .YgpbUpload
  * @author MyEclipse Persistence Tools 
 */

public class YgpbUploadDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(YgpbUploadDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String DATE = "date";
	public static final String PBQDTIME = "pbqdtime";
	public static final String PBQTTIME = "pbqttime";
	public static final String TB = "tb";



    
    public void save(YgpbUpload transientInstance) {
        log.debug("saving YgpbUpload instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(YgpbUpload persistentInstance) {
        log.debug("deleting YgpbUpload instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public YgpbUpload findById( java.lang.Integer id) {
        log.debug("getting YgpbUpload instance with id: " + id);
        try {
            YgpbUpload instance = (YgpbUpload) getSession()
                    .get("YgpbUpload", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(YgpbUpload instance) {
        log.debug("finding YgpbUpload instance by example");
        try {
            List results = getSession()
                    .createCriteria("YgpbUpload")
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
      log.debug("finding YgpbUpload instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from YgpbUpload as model where model." 
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
		log.debug("finding all YgpbUpload instances");
		try {
			String queryString = "from YgpbUpload";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public YgpbUpload merge(YgpbUpload detachedInstance) {
        log.debug("merging YgpbUpload instance");
        try {
            YgpbUpload result = (YgpbUpload) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(YgpbUpload instance) {
        log.debug("attaching dirty YgpbUpload instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(YgpbUpload instance) {
        log.debug("attaching clean YgpbUpload instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public YgpbUpload findAllByDateName(String date,String name) {
		log.debug("finding all YgpbUpload instances");
		try {
			String queryString = "from YgpbUpload as yu where yu.date='"+date+"' and yu.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(list.isEmpty())
			 {
				 YgpbUpload yu = new YgpbUpload();
				 yu.setName(name);
				 yu.setDate(date);
				 return yu;
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
    public YgpbUpload findAllByDateNameNull(String date,String name) {
		log.debug("finding all YgpbUpload instances");
		try {
			String queryString = "from YgpbUpload as yu where yu.date='"+date+"' and yu.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 if(!list.isEmpty())
			 {
				 YgpbUpload yu = (YgpbUpload) list.get(0);
				 //yu.setName(name);
				 //yu.setDate(date);
				 return yu;
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
    public List<YgpbUpload> findAllByName(String name,String yearmonth) {
		log.debug("finding all YgpbUpload instances");
		try {
			String queryString = "from YgpbUpload as yu where yu.name='"+name+"' and yu.date>='"+yearmonth+"01' and yu.date<='"+yearmonth+"31'";
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			 return list;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}