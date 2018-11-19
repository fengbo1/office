package office.kqjl.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.kqjl.pojo.KqjlImport;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for KqjlImport entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .KqjlImport
  * @author MyEclipse Persistence Tools 
 */

public class KqjlImportDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(KqjlImportDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String DATE = "date";
	public static final String QDTIME = "qdtime";
	public static final String QTTIME = "qttime";



    
    public void save(KqjlImport transientInstance) {
        log.debug("saving KqjlImport instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(KqjlImport persistentInstance) {
        log.debug("deleting KqjlImport instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public KqjlImport findById( java.lang.Integer id) {
        log.debug("getting KqjlImport instance with id: " + id);
        try {
            KqjlImport instance = (KqjlImport) getSession()
                    .get("KqjlImport", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(KqjlImport instance) {
        log.debug("finding KqjlImport instance by example");
        try {
            List results = getSession()
                    .createCriteria("KqjlImport")
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
      log.debug("finding KqjlImport instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from KqjlImport as model where model." 
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
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByQdtime(Object qdtime
	) {
		return findByProperty(QDTIME, qdtime
		);
	}
	
	public List findByQttime(Object qttime
	) {
		return findByProperty(QTTIME, qttime
		);
	}
	

	public List findAll() {
		log.debug("finding all KqjlImport instances");
		try {
			String queryString = "from KqjlImport";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public KqjlImport merge(KqjlImport detachedInstance) {
        log.debug("merging KqjlImport instance");
        try {
            KqjlImport result = (KqjlImport) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(KqjlImport instance) {
        log.debug("attaching dirty KqjlImport instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(KqjlImport instance) {
        log.debug("attaching clean KqjlImport instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllByDate(String date) {
		log.debug("finding all KqjlImport instances");
		try {
			String queryString = "from KqjlImport as ki where ki.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public KqjlImport findAllByDateAndName(String date,String name) {
		log.debug("finding all KqjlImport instances");
		try {
			String queryString = "from KqjlImport as ki where ki.date='"+date+"' and ki.name='"+name+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<KqjlImport> listki = queryObject.list();
	         if(listki.isEmpty())
	         {
	        	 return new KqjlImport(name,"", date,"","");
	         }
	         else
	         {
	        	 return listki.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}