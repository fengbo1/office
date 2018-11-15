package office.uass.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.uass.pojo.UassCostHnPeople;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UassCostHnPeople entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UassCostHnPeople
  * @author MyEclipse Persistence Tools 
 */

public class UassCostHnPeopleDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UassCostHnPeopleDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String POOL = "pool";
	public static final String TYPE891 = "type891";
	public static final String ITEM891BF = "item891bf";
	public static final String ITEM891AF = "item891af";
	public static final String CONTENT891 = "content891";
	public static final String TYPE890 = "type890";
	public static final String ITEM890BF = "item890bf";
	public static final String ITEM890AF = "item890af";
	public static final String CONTENT890 = "content890";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";



    
    public void save(UassCostHnPeople transientInstance) {
        log.debug("saving UassCostHnPeople instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UassCostHnPeople persistentInstance) {
        log.debug("deleting UassCostHnPeople instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UassCostHnPeople findById( java.lang.Integer id) {
        log.debug("getting UassCostHnPeople instance with id: " + id);
        try {
            UassCostHnPeople instance = (UassCostHnPeople) getSession()
                    .get("UassCostHnPeople", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UassCostHnPeople instance) {
        log.debug("finding UassCostHnPeople instance by example");
        try {
            List results = getSession()
                    .createCriteria("UassCostHnPeople")
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
      log.debug("finding UassCostHnPeople instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UassCostHnPeople as model where model." 
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
	
	public List findByPool(Object pool
	) {
		return findByProperty(POOL, pool
		);
	}
	
	public List findByType891(Object type891
	) {
		return findByProperty(TYPE891, type891
		);
	}
	
	public List findByItem891bf(Object item891bf
	) {
		return findByProperty(ITEM891BF, item891bf
		);
	}
	
	public List findByItem891af(Object item891af
	) {
		return findByProperty(ITEM891AF, item891af
		);
	}
	
	public List findByContent891(Object content891
	) {
		return findByProperty(CONTENT891, content891
		);
	}
	
	public List findByType890(Object type890
	) {
		return findByProperty(TYPE890, type890
		);
	}
	
	public List findByItem890bf(Object item890bf
	) {
		return findByProperty(ITEM890BF, item890bf
		);
	}
	
	public List findByItem890af(Object item890af
	) {
		return findByProperty(ITEM890AF, item890af
		);
	}
	
	public List findByContent890(Object content890
	) {
		return findByProperty(CONTENT890, content890
		);
	}
	
	public List findByRemark1(Object remark1
	) {
		return findByProperty(REMARK1, remark1
		);
	}
	
	public List findByRemark2(Object remark2
	) {
		return findByProperty(REMARK2, remark2
		);
	}
	

	public List findAll() {
		log.debug("finding all UassCostHnPeople instances");
		try {
			String queryString = "from UassCostHnPeople";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UassCostHnPeople merge(UassCostHnPeople detachedInstance) {
        log.debug("merging UassCostHnPeople instance");
        try {
            UassCostHnPeople result = (UassCostHnPeople) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UassCostHnPeople instance) {
        log.debug("attaching dirty UassCostHnPeople instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UassCostHnPeople instance) {
        log.debug("attaching clean UassCostHnPeople instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public List findAllByNumber(String number) {
    	log.debug("finding all UassCostHnPeople instances");
    	try {
    		String queryString = "from UassCostHnPeople as uchp where uchp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public UassCostHnPeople findAllById(int id) {
    	log.debug("finding all UassCostHnPeople instances");
    	try {
    		String queryString = "from UassCostHnPeople as uchp where uchp.id='"+id+"'";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	return (UassCostHnPeople) list.get(0); 
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public UassCostHnPeople findAllByNameNumber(String name,String number) {
    	log.debug("finding all UassCostHnPeople instances");
    	try {
    		String queryString = "from UassCostHnPeople as uchp where uchp.number='"+number+"' and uchp.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (UassCostHnPeople) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public String findPeopleNameAllByNumber(String number) {
    	log.debug("finding all UassCostHnPeople instances");
    	try {
    		String result = "";
    		String queryString = "from UassCostHnPeople as uchp where uchp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<UassCostHnPeople> list = queryObject.list();
             for(int i=0;i<list.size();i++)
             {
            	 UassCostHnPeople uchp = list.get(i);
            	 result+=uchp.getName();
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