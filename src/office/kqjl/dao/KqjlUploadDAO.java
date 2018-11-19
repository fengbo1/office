package office.kqjl.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.kqjl.pojo.KqjlUpload;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for KqjlUpload entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .KqjlUpload
  * @author MyEclipse Persistence Tools 
 */

public class KqjlUploadDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(KqjlUploadDAO.class);
		//property constants
	public static final String MONTH = "month";
	public static final String SCPB = "scpb";
	public static final String XYPB = "xypb";
	public static final String ZWJL = "zwjl";
	public static final String SCPBY = "scpby";
	public static final String KQJL1 = "kqjl1";
	public static final String KQJL2 = "kqjl2";
	public static final String KQJL3 = "kqjl3";
	public static final String KQJL4 = "kqjl4";
	public static final String IFKQQSDISABLED = "ifkqqsdisabled";



    
    public void save(KqjlUpload transientInstance) {
        log.debug("saving KqjlUpload instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(KqjlUpload persistentInstance) {
        log.debug("deleting KqjlUpload instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public KqjlUpload findById( java.lang.Integer id) {
        log.debug("getting KqjlUpload instance with id: " + id);
        try {
            KqjlUpload instance = (KqjlUpload) getSession()
                    .get("KqjlUpload", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(KqjlUpload instance) {
        log.debug("finding KqjlUpload instance by example");
        try {
            List results = getSession()
                    .createCriteria("KqjlUpload")
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
      log.debug("finding KqjlUpload instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from KqjlUpload as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMonth(Object month
	) {
		return findByProperty(MONTH, month
		);
	}
	
	public List findByScpb(Object scpb
	) {
		return findByProperty(SCPB, scpb
		);
	}
	
	public List findByXypb(Object xypb
	) {
		return findByProperty(XYPB, xypb
		);
	}
	
	public List findByZwjl(Object zwjl
	) {
		return findByProperty(ZWJL, zwjl
		);
	}
	
	public List findByScpby(Object scpby
	) {
		return findByProperty(SCPBY, scpby
		);
	}
	
	public List findByKqjl1(Object kqjl1
	) {
		return findByProperty(KQJL1, kqjl1
		);
	}
	
	public List findByKqjl2(Object kqjl2
	) {
		return findByProperty(KQJL2, kqjl2
		);
	}
	
	public List findByKqjl3(Object kqjl3
	) {
		return findByProperty(KQJL3, kqjl3
		);
	}
	
	public List findByKqjl4(Object kqjl4
	) {
		return findByProperty(KQJL4, kqjl4
		);
	}
	
	public List findByIfkqqsdisabled(Object ifkqqsdisabled
	) {
		return findByProperty(IFKQQSDISABLED, ifkqqsdisabled
		);
	}
	

	public List findAll() {
		log.debug("finding all KqjlUpload instances");
		try {
			String queryString = "from KqjlUpload";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public KqjlUpload merge(KqjlUpload detachedInstance) {
        log.debug("merging KqjlUpload instance");
        try {
            KqjlUpload result = (KqjlUpload) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(KqjlUpload instance) {
        log.debug("attaching dirty KqjlUpload instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(KqjlUpload instance) {
        log.debug("attaching clean KqjlUpload instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public KqjlUpload findAllBeforeImport() {
    	log.debug("finding all KqjlUpload instances");
    	try {
    		String queryString = "from KqjlUpload as ku where ku.scpb=1 or ku.xypb=1 or ku.zwjl=1 order by ku.month desc";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 KqjlUpload ku = new KqjlUpload();
            	 ku.setMonth("空表");
            	 return ku;
             }
             else
             {
            	 return (KqjlUpload) list.get(0);
             }
    		  
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public KqjlUpload findAllByMonth(String month) {
    	log.debug("finding all KqjlUpload instances");
    	try {
    		String queryString = "from KqjlUpload as ku where ku.month='"+month+"'";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 KqjlUpload ku = new KqjlUpload(month, 0, 0, 0, 0, 0, 0, 0, 0,0);
            	 return ku;
             }
             else
             {
            	 return (KqjlUpload) list.get(0);
             }
    		  
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}