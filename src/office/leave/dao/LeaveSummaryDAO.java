package office.leave.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.leave.pojo.LeaveSummary;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for LeaveSummary entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .LeaveSummary
  * @author MyEclipse Persistence Tools 
 */

public class LeaveSummaryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(LeaveSummaryDAO.class);
		//property constants
	public static final String YEAR = "year";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String POSITION = "position";
	public static final String YEARALL = "yearall";
	public static final String YEARLEAVE = "yearleave";
	public static final String WORKREST = "workrest";
	public static final String WORKLEAVE = "workleave";
	public static final String BINGLEAVE = "bingleave";
	public static final String SHILEAVE = "shileave";
	public static final String HUNLEAVE = "hunleave";
	public static final String CHANLEAVE = "chanleave";
	public static final String TANPOLEAVE = "tanpoleave";
	public static final String TANFMLEAVE = "tanfmleave";
	public static final String SANGLEAVE = "sangleave";
	public static final String SHANGLEAVE = "shangleave";
	public static final String GONGLEAVE = "gongleave";
	public static final String QITALEAVE = "qitaleave";
	public static final String PEIKAOLEAVE = "peikaoleave";
	public static final String BURULEAVE = "buruleave";
	public static final String REMARK = "remark";



    
    public void save(LeaveSummary transientInstance) {
        log.debug("saving LeaveSummary instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LeaveSummary persistentInstance) {
        log.debug("deleting LeaveSummary instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LeaveSummary findById( java.lang.Integer id) {
        log.debug("getting LeaveSummary instance with id: " + id);
        try {
            LeaveSummary instance = (LeaveSummary) getSession()
                    .get("LeaveSummary", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(LeaveSummary instance) {
        log.debug("finding LeaveSummary instance by example");
        try {
            List results = getSession()
                    .createCriteria("LeaveSummary")
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
      log.debug("finding LeaveSummary instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LeaveSummary as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByYear(Object year
	) {
		return findByProperty(YEAR, year
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
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByYearall(Object yearall
	) {
		return findByProperty(YEARALL, yearall
		);
	}
	
	public List findByYearleave(Object yearleave
	) {
		return findByProperty(YEARLEAVE, yearleave
		);
	}
	
	public List findByWorkrest(Object workrest
	) {
		return findByProperty(WORKREST, workrest
		);
	}
	
	public List findByWorkleave(Object workleave
	) {
		return findByProperty(WORKLEAVE, workleave
		);
	}
	
	public List findByBingleave(Object bingleave
	) {
		return findByProperty(BINGLEAVE, bingleave
		);
	}
	
	public List findByShileave(Object shileave
	) {
		return findByProperty(SHILEAVE, shileave
		);
	}
	
	public List findByHunleave(Object hunleave
	) {
		return findByProperty(HUNLEAVE, hunleave
		);
	}
	
	public List findByChanleave(Object chanleave
	) {
		return findByProperty(CHANLEAVE, chanleave
		);
	}
	
	public List findByTanpoleave(Object tanpoleave
	) {
		return findByProperty(TANPOLEAVE, tanpoleave
		);
	}
	
	public List findByTanfmleave(Object tanfmleave
	) {
		return findByProperty(TANFMLEAVE, tanfmleave
		);
	}
	
	public List findBySangleave(Object sangleave
	) {
		return findByProperty(SANGLEAVE, sangleave
		);
	}
	
	public List findByShangleave(Object shangleave
	) {
		return findByProperty(SHANGLEAVE, shangleave
		);
	}
	
	public List findByGongleave(Object gongleave
	) {
		return findByProperty(GONGLEAVE, gongleave
		);
	}
	
	public List findByQitaleave(Object qitaleave
	) {
		return findByProperty(QITALEAVE, qitaleave
		);
	}
	
	public List findByPeikaoleave(Object peikaoleave
	) {
		return findByProperty(PEIKAOLEAVE, peikaoleave
		);
	}
	
	public List findByBuruleave(Object buruleave
	) {
		return findByProperty(BURULEAVE, buruleave
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all LeaveSummary instances");
		try {
			String queryString = "from LeaveSummary";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LeaveSummary merge(LeaveSummary detachedInstance) {
        log.debug("merging LeaveSummary instance");
        try {
            LeaveSummary result = (LeaveSummary) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LeaveSummary instance) {
        log.debug("attaching dirty LeaveSummary instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LeaveSummary instance) {
        log.debug("attaching clean LeaveSummary instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public LeaveSummary findByYearAndName(int year,String name) {
    	log.debug("finding all LeaveSummary instances");
    	try {
    		String queryString = "from LeaveSummary where year=:y and name=:n";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setInteger("y", year);
             queryObject.setString("n", name);
             if(queryObject.list().size()>0)
             {
            	 return (LeaveSummary) queryObject.list().get(0);
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
    public LeaveSummary findByYearAndNewnumber(int year,String newnumber) {
    	log.debug("finding all LeaveSummary instances");
    	try {
    		String queryString = "from LeaveSummary where year=:y and newnumber=:n";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setInteger("y", year);
             queryObject.setString("n", newnumber);
             if(queryObject.list().size()>0)
             {
            	 return (LeaveSummary) queryObject.list().get(0);
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
}