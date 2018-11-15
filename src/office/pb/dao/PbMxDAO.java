package office.pb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.pb.pojo.PbMx;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for PbMx entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .PbMx
  * @author MyEclipse Persistence Tools 
 */

public class PbMxDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PbMxDAO.class);
		//property constants
	public static final String MONTH = "month";
	public static final String DATE = "date";
	public static final String WEEK = "week";
	public static final String NAME = "name";
	public static final String POSITION = "position";
	public static final String TEAM = "team";
	public static final String PLAN = "plan";
	public static final String TEAMNUM = "teamnum";
	public static final String PLANNUM = "plannum";
	public static final String PLANTYPE = "plantype";
	public static final String PBQDTIME = "pbqdtime";
	public static final String PBQTTIME = "pbqttime";
	public static final String ZYTIME = "zytime";
	public static final String PXTIME = "pxtime";
	public static final String WB = "wb";
	public static final String SW = "sw";
	public static final String XW = "xw";
	public static final String TB = "tb";



    
    public void save(PbMx transientInstance) {
        log.debug("saving PbMx instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PbMx persistentInstance) {
        log.debug("deleting PbMx instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PbMx findById( java.lang.Integer id) {
        log.debug("getting PbMx instance with id: " + id);
        try {
            PbMx instance = (PbMx) getSession()
                    .get("PbMx", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PbMx instance) {
        log.debug("finding PbMx instance by example");
        try {
            List results = getSession()
                    .createCriteria("PbMx")
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
      log.debug("finding PbMx instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PbMx as model where model." 
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
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByWeek(Object week
	) {
		return findByProperty(WEEK, week
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByTeam(Object team
	) {
		return findByProperty(TEAM, team
		);
	}
	
	public List findByPlan(Object plan
	) {
		return findByProperty(PLAN, plan
		);
	}
	
	public List findByTeamnum(Object teamnum
	) {
		return findByProperty(TEAMNUM, teamnum
		);
	}
	
	public List findByPlannum(Object plannum
	) {
		return findByProperty(PLANNUM, plannum
		);
	}
	
	public List findByPlantype(Object plantype
	) {
		return findByProperty(PLANTYPE, plantype
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
	
	public List findByZytime(Object zytime
	) {
		return findByProperty(ZYTIME, zytime
		);
	}
	
	public List findByPxtime(Object pxtime
	) {
		return findByProperty(PXTIME, pxtime
		);
	}
	
	public List findByWb(Object wb
	) {
		return findByProperty(WB, wb
		);
	}
	
	public List findBySw(Object sw
	) {
		return findByProperty(SW, sw
		);
	}
	
	public List findByXw(Object xw
	) {
		return findByProperty(XW, xw
		);
	}
	
	public List findByTb(Object tb
	) {
		return findByProperty(TB, tb
		);
	}
	

	public List findAll() {
		log.debug("finding all PbMx instances");
		try {
			String queryString = "from PbMx";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PbMx merge(PbMx detachedInstance) {
        log.debug("merging PbMx instance");
        try {
            PbMx result = (PbMx) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PbMx instance) {
        log.debug("attaching dirty PbMx instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PbMx instance) {
        log.debug("attaching clean PbMx instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public PbMx findAllByNameAndDate(String name,String date) {
    	log.debug("finding all PbMx instances");
    	try {
    		String queryString = "from PbMx as pm where pm.name='"+name+"' and pm.date='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 PbMx px = new PbMx();
            	 px.setDate(date);
            	 px.setName(name);
            	 return px;
             }
             else
             {
            	return (PbMx)list.get(0);
             }
    		
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 如果空返回空
     * @param name
     * @param date
     * @return
     */
    public PbMx findAllByNameAndDateNull(String name,String date) {
    	log.debug("finding all PbMx instances");
    	try {
    		String queryString = "from PbMx as pm where pm.name='"+name+"' and pm.date='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	return (PbMx)list.get(0);
             }
    		
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public PbMx findAllById(int id) {
		log.debug("finding all PbMx instances");
		try {
			String queryString = "from PbMx as pm where pm.id="+id;
	        Query queryObject = getSession().createQuery(queryString);
			List list = queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (PbMx) list.get(0);
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}