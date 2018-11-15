package office.leave.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.leave.pojo.LeaveMonthSummary;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for LeaveMonthSummary entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .LeaveMonthSummary
  * @author MyEclipse Persistence Tools 
 */

public class LeaveMonthSummaryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(LeaveMonthSummaryDAO.class);
		//property constants
	public static final String YEAR = "year";
	public static final String MONTH = "month";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String YEARLEAVE = "yearleave";
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
	public static final String SUMLEAVE = "sumleave";
	public static final String SUMWORK = "sumwork";
	public static final String REMARK = "remark";



    
    public void save(LeaveMonthSummary transientInstance) {
        log.debug("saving LeaveMonthSummary instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LeaveMonthSummary persistentInstance) {
        log.debug("deleting LeaveMonthSummary instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LeaveMonthSummary findById( java.lang.Integer id) {
        log.debug("getting LeaveMonthSummary instance with id: " + id);
        try {
            LeaveMonthSummary instance = (LeaveMonthSummary) getSession()
                    .get("LeaveMonthSummary", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(LeaveMonthSummary instance) {
        log.debug("finding LeaveMonthSummary instance by example");
        try {
            List results = getSession()
                    .createCriteria("LeaveMonthSummary")
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
      log.debug("finding LeaveMonthSummary instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LeaveMonthSummary as model where model." 
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
	
	public List findByMonth(Object month
	) {
		return findByProperty(MONTH, month
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
	
	public List findByYearleave(Object yearleave
	) {
		return findByProperty(YEARLEAVE, yearleave
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
	
	public List findBySumleave(Object sumleave
	) {
		return findByProperty(SUMLEAVE, sumleave
		);
	}
	
	public List findBySumwork(Object sumwork
	) {
		return findByProperty(SUMWORK, sumwork
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all LeaveMonthSummary instances");
		try {
			String queryString = "from LeaveMonthSummary";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LeaveMonthSummary merge(LeaveMonthSummary detachedInstance) {
        log.debug("merging LeaveMonthSummary instance");
        try {
            LeaveMonthSummary result = (LeaveMonthSummary) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LeaveMonthSummary instance) {
        log.debug("attaching dirty LeaveMonthSummary instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LeaveMonthSummary instance) {
        log.debug("attaching clean LeaveMonthSummary instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
     * 根据新一代编号，年份，月份查询
     * @param newnumber
     * @param year
     * @param month
     * @return
     */
    public LeaveMonthSummary findAllNewnumberAndYearAndMonth(String newnumber,int year,int month) {
    	log.debug("finding all LeaveMonthSummary instances");
    	try {
    		String queryString = "from LeaveMonthSummary as lms where lms.newnumber='"+newnumber+"' and lms.year="+year+" and lms.month="+month;
            Query queryObject = getSession().createQuery(queryString);
            List<LeaveMonthSummary> list = queryObject.list();
           UserInfoDAO uidao = new UserInfoDAO();
           UserInfo ui = uidao.findByNewNumber(newnumber);
           LeaveMonthSummary lms = new LeaveMonthSummary(year, month, ui.getUsername(), newnumber, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0,0.0,0.0, 0.0, 0.0,0.0,0.0, "");
             if(list.isEmpty())
             {
            	 return lms;
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