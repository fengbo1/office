package office.config.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.config.pojo.Config;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Config entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Config
  * @author MyEclipse Persistence Tools 
 */

public class ConfigDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ConfigDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String VALUE = "value";
	public static final String STRVALUE = "strvalue";



    
    public void save(Config transientInstance) {
        log.debug("saving Config instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Config persistentInstance) {
        log.debug("deleting Config instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Config findById( java.lang.Integer id) {
        log.debug("getting Config instance with id: " + id);
        try {
            Config instance = (Config) getSession()
                    .get("Config", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Config instance) {
        log.debug("finding Config instance by example");
        try {
            List results = getSession()
                    .createCriteria("Config")
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
      log.debug("finding Config instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Config as model where model." 
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
	
	public List findByValue(Object value
	) {
		return findByProperty(VALUE, value
		);
	}
	
	public List findByStrvalue(Object strvalue
	) {
		return findByProperty(STRVALUE, strvalue
		);
	}
	

	public List findAll() {
		log.debug("finding all Config instances");
		try {
			String queryString = "from Config";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Config merge(Config detachedInstance) {
        log.debug("merging Config instance");
        try {
            Config result = (Config) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Config instance) {
        log.debug("attaching dirty Config instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Config instance) {
        log.debug("attaching clean Config instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public Config findAllByName(String name) {
    	log.debug("finding all Config instances");
    	try {
    		String queryString = "from Config as cfg where cfg.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<Config> list = queryObject.list();
             if(list.isEmpty())
             {
            	 return new Config(name,0,"");
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