package office.pb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import javax.jms.Session;

import office.pb.pojo.ScpbTableHz;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ScpbTableHz entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ScpbTableHz
  * @author MyEclipse Persistence Tools 
 */

public class ScpbTableHzDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScpbTableHzDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String TEAMNO = "teamno";
	public static final String PLANNO = "planno";



    
    public void save(ScpbTableHz transientInstance) {
        log.debug("saving ScpbTableHz instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ScpbTableHz persistentInstance) {
        log.debug("deleting ScpbTableHz instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ScpbTableHz findById( java.lang.Integer id) {
        log.debug("getting ScpbTableHz instance with id: " + id);
        try {
            ScpbTableHz instance = (ScpbTableHz) getSession()
                    .get("ScpbTableHz", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ScpbTableHz instance) {
        log.debug("finding ScpbTableHz instance by example");
        try {
            List results = getSession()
                    .createCriteria("ScpbTableHz")
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
      log.debug("finding ScpbTableHz instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ScpbTableHz as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByTeamno(Object teamno
	) {
		return findByProperty(TEAMNO, teamno
		);
	}
	
	public List findByPlanno(Object planno
	) {
		return findByProperty(PLANNO, planno
		);
	}
	

	public List findAll() {
		log.debug("finding all ScpbTableHz instances");
		try {
			String queryString = "from ScpbTableHz";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ScpbTableHz merge(ScpbTableHz detachedInstance) {
        log.debug("merging ScpbTableHz instance");
        try {
            ScpbTableHz result = (ScpbTableHz) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ScpbTableHz instance) {
        log.debug("attaching dirty ScpbTableHz instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ScpbTableHz instance) {
        log.debug("attaching clean ScpbTableHz instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public ScpbTableHz findAllByDateAndTeamno(String date,int teamno) {
		log.debug("finding all ScpbTableHz instances");
		try {
			String queryString = "from ScpbTableHz as sth where sth.date='"+date+"' and sth.teamno="+teamno;
	         Query queryObject = getSession().createQuery(queryString);
	         List list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	return  (ScpbTableHz) list.get(0);
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public List findAllByMonth(String month) {
		log.debug("finding all ScpbTableHz instances");
		try {
			String queryString = "from ScpbTableHz as sth where sth.date>='"+month+"01' and sth.date<='"+month+"31' order by sth.date desc";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public int findMxTeamnoByMonth(String month) {
		log.debug("finding all ScpbTableHz instances");
		try {
			String queryString = "select max(teamno) from t_scpb_table_hz where date>='"+month+"01' and date<='"+month+"31'";
	         int maxno = 0;
	         if(getSession().createSQLQuery(queryString).uniqueResult()!=null)
	         {
	        	 maxno = Integer.parseInt(getSession().createSQLQuery(queryString).uniqueResult().toString());
	         }
			 return maxno;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public List findAllByDate(String date) {
		log.debug("finding all ScpbTableHz instances");
		try {
			String queryString = "from ScpbTableHz as sth where sth.date='"+date+"' order by sth.date";
			System.out.println(queryString);
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}