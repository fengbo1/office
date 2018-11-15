package office.pb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.pb.pojo.PbTeshu;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for PbTeshu entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .PbTeshu
  * @author MyEclipse Persistence Tools 
 */

public class PbTeshuDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PbTeshuDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String ITEM = "item";
	public static final String YXBEGIN = "yxbegin";
	public static final String YXEND = "yxend";



    
    public void save(PbTeshu transientInstance) {
        log.debug("saving PbTeshu instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PbTeshu persistentInstance) {
        log.debug("deleting PbTeshu instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PbTeshu findById( java.lang.Integer id) {
        log.debug("getting PbTeshu instance with id: " + id);
        try {
            PbTeshu instance = (PbTeshu) getSession()
                    .get("PbTeshu", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PbTeshu instance) {
        log.debug("finding PbTeshu instance by example");
        try {
            List results = getSession()
                    .createCriteria("PbTeshu")
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
      log.debug("finding PbTeshu instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PbTeshu as model where model." 
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
	
	public List findByItem(Object item
	) {
		return findByProperty(ITEM, item
		);
	}
	
	public List findByYxbegin(Object yxbegin
	) {
		return findByProperty(YXBEGIN, yxbegin
		);
	}
	
	public List findByYxend(Object yxend
	) {
		return findByProperty(YXEND, yxend
		);
	}
	

	public List findAll() {
		log.debug("finding all PbTeshu instances");
		try {
			String queryString = "from PbTeshu";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PbTeshu merge(PbTeshu detachedInstance) {
        log.debug("merging PbTeshu instance");
        try {
            PbTeshu result = (PbTeshu) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PbTeshu instance) {
        log.debug("attaching dirty PbTeshu instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PbTeshu instance) {
        log.debug("attaching clean PbTeshu instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public PbTeshu findAllByID(int id) {
		log.debug("finding all PbTeshu instances");
		try {
			String queryString = "from PbTeshu as pt where pt.id="+id;
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	 return (PbTeshu) list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public PbTeshu findAllBy(String name,String date,int item) {
		log.debug("finding all PbTeshu instances");
		try {
			String queryString = "from PbTeshu as pt where pt.name='"+name+"' and pt.yxend>='"+date+"' and pt.yxbegin<='"+date+"' and item="+item;
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	 return (PbTeshu) list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}