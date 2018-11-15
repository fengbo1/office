package office.wcgg.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.wcgg.pojo.WcggBaodao;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for WcggBaodao entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WcggBaodao
  * @author MyEclipse Persistence Tools 
 */

public class WcggBaodaoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WcggBaodaoDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String BEGINDATE = "begindate";
	public static final String BAODAODATE = "baodaodate";
	public static final String BGHALFDAY = "bghalfday";
	public static final String BDHALFDAY = "bdhalfday";
	public static final String SUMDAY = "sumday";
	public static final String STATUS = "status";



    
    public void save(WcggBaodao transientInstance) {
        log.debug("saving WcggBaodao instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WcggBaodao persistentInstance) {
        log.debug("deleting WcggBaodao instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WcggBaodao findById( java.lang.Integer id) {
        log.debug("getting WcggBaodao instance with id: " + id);
        try {
            WcggBaodao instance = (WcggBaodao) getSession()
                    .get("WcggBaodao", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WcggBaodao instance) {
        log.debug("finding WcggBaodao instance by example");
        try {
            List results = getSession()
                    .createCriteria("WcggBaodao")
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
      log.debug("finding WcggBaodao instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WcggBaodao as model where model." 
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
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByBegindate(Object begindate
	) {
		return findByProperty(BEGINDATE, begindate
		);
	}
	
	public List findByBaodaodate(Object baodaodate
	) {
		return findByProperty(BAODAODATE, baodaodate
		);
	}
	
	public List findByBghalfday(Object bghalfday
	) {
		return findByProperty(BGHALFDAY, bghalfday
		);
	}
	
	public List findByBdhalfday(Object bdhalfday
	) {
		return findByProperty(BDHALFDAY, bdhalfday
		);
	}
	
	public List findBySumday(Object sumday
	) {
		return findByProperty(SUMDAY, sumday
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	

	public List findAll() {
		log.debug("finding all WcggBaodao instances");
		try {
			String queryString = "from WcggBaodao";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WcggBaodao merge(WcggBaodao detachedInstance) {
        log.debug("merging WcggBaodao instance");
        try {
            WcggBaodao result = (WcggBaodao) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WcggBaodao instance) {
        log.debug("attaching dirty WcggBaodao instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WcggBaodao instance) {
        log.debug("attaching clean WcggBaodao instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public List findAllByNumber(String number) {
    	log.debug("finding all WcggBaodao instances");
    	try {
    		String queryString = "from WcggBaodao as wb where wb.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public List<WcggBaodao> findAllByNewnumberAndDate(String newnumber,String date) {
    	log.debug("finding all WcggBaodao instances");
    	try {
    		String queryString = "from WcggBaodao as wb where wb.newnumber='"+newnumber+"' and wb.begindate<='"+date+"' and wb.baodaodate>='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<WcggBaodao> list = queryObject.list();
           	 return list;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 根据表编号和工号查询
     * @param number
     * @return
     */
    public WcggBaodao findAllByNumberAndNewnumber(String number,String newnumber) {
    	log.debug("finding all WcggBaodao instances");
    	try {
    		String queryString = "from WcggBaodao as wb where wb.number='"+number+"' and wb.newnumber='"+newnumber+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<WcggBaodao> list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
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
    /**
     * 根据表编号和姓名查询
     * @param number
     * @return
     */
    public WcggBaodao findAllByNumberAndName(String number,String name) {
    	log.debug("finding all WcggBaodao instances");
    	try {
    		String queryString = "from WcggBaodao as wb where wb.number='"+number+"' and wb.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<WcggBaodao> list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
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
    /**
     * 根据表编号和状态查询
     * @param number
     * @return
     */
    public List findAllByStatusAndNumber(int status,String number) {
    	log.debug("finding all WcggBaodao instances");
    	try {
    		String queryString = "from WcggBaodao as wb where wb.status="+status+" and wb.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<WcggBaodao> list = queryObject.list();
            return queryObject.list();
            
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}