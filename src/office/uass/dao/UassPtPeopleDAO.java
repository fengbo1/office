package office.uass.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.uass.pojo.UassPtPeople;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UassPtPeople entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UassPtPeople
  * @author MyEclipse Persistence Tools 
 */

public class UassPtPeopleDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UassPtPeopleDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String ITEM = "item";
	public static final String CONTENT = "content";



    
    public void save(UassPtPeople transientInstance) {
        log.debug("saving UassPtPeople instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UassPtPeople persistentInstance) {
        log.debug("deleting UassPtPeople instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UassPtPeople findById( java.lang.Integer id) {
        log.debug("getting UassPtPeople instance with id: " + id);
        try {
            UassPtPeople instance = (UassPtPeople) getSession()
                    .get("UassPtPeople", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UassPtPeople instance) {
        log.debug("finding UassPtPeople instance by example");
        try {
            List results = getSession()
                    .createCriteria("UassPtPeople")
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
      log.debug("finding UassPtPeople instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UassPtPeople as model where model." 
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
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	

	public List findAll() {
		log.debug("finding all UassPtPeople instances");
		try {
			String queryString = "from UassPtPeople";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UassPtPeople merge(UassPtPeople detachedInstance) {
        log.debug("merging UassPtPeople instance");
        try {
            UassPtPeople result = (UassPtPeople) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UassPtPeople instance) {
        log.debug("attaching dirty UassPtPeople instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UassPtPeople instance) {
        log.debug("attaching clean UassPtPeople instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public List findAllByNumber(String number) {
    	log.debug("finding all UassPtPeople instances");
    	try {
    		String queryString = "from UassPtPeople as upp where upp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public UassPtPeople findAllById(int id) {
    	log.debug("finding all UassPtPeople instances");
    	try {
    		String queryString = "from UassPtPeople as upp where upp.id='"+id+"'";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	return (UassPtPeople) list.get(0); 
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public UassPtPeople findAllByNameNumber(String name,String number) {
    	log.debug("finding all UassPtPeople instances");
    	try {
    		String queryString = "from UassPtPeople as upp where upp.number='"+number+"' and upp.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (UassPtPeople) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public String findPeopleNameAllByNumber(String number) {
    	log.debug("finding all UassPtPeople instances");
    	try {
    		String result = "";
    		String queryString = "from UassPtPeople as upp where upp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<UassPtPeople> list = queryObject.list();
             for(int i=0;i<list.size();i++)
             {
            	 UassPtPeople upp = list.get(i);
            	 result+=upp.getName();
            	 if(i<(list.size()-1))
            	 {
            		 result+="、";
            	 }
             }
             return result;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}