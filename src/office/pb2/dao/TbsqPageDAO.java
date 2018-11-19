package office.pb2.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.pb2.pojo.TbsqPage;
import office.userinfo.pojo.UserInfo;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for TbsqPage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .TbsqPage
  * @author MyEclipse Persistence Tools 
 */

public class TbsqPageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TbsqPageDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDERTAKE = "preundertake";
	public static final String UNDERTAKE = "undertake";
	public static final String INITIATOR = "initiator";
	public static final String APPLICANT = "applicant";
	public static final String TBDATE = "tbdate";
	public static final String TBNAME = "tbname";
	public static final String REASON = "reason";
	public static final String PREJIHUA = "prejihua";
	public static final String NOWJIHUA = "nowjihua";
	public static final String REMARK = "remark";
	public static final String PRETYPE = "pretype";
	public static final String NOWTYPE = "nowtype";



    
    public void save(TbsqPage transientInstance) {
        log.debug("saving TbsqPage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TbsqPage persistentInstance) {
        log.debug("deleting TbsqPage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TbsqPage findById( java.lang.Integer id) {
        log.debug("getting TbsqPage instance with id: " + id);
        try {
            TbsqPage instance = (TbsqPage) getSession()
                    .get("TbsqPage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TbsqPage instance) {
        log.debug("finding TbsqPage instance by example");
        try {
            List results = getSession()
                    .createCriteria("TbsqPage")
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
      log.debug("finding TbsqPage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TbsqPage as model where model." 
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
	
	public List findByProcess(Object process
	) {
		return findByProperty(PROCESS, process
		);
	}
	
	public List findByJindu(Object jindu
	) {
		return findByProperty(JINDU, jindu
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findByPreundertake(Object preundertake
	) {
		return findByProperty(PREUNDERTAKE, preundertake
		);
	}
	
	public List findByUndertake(Object undertake
	) {
		return findByProperty(UNDERTAKE, undertake
		);
	}
	
	public List findByInitiator(Object initiator
	) {
		return findByProperty(INITIATOR, initiator
		);
	}
	
	public List findByApplicant(Object applicant
	) {
		return findByProperty(APPLICANT, applicant
		);
	}
	
	public List findByTbdate(Object tbdate
	) {
		return findByProperty(TBDATE, tbdate
		);
	}
	
	public List findByTbname(Object tbname
	) {
		return findByProperty(TBNAME, tbname
		);
	}
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
		);
	}
	
	public List findByPrejihua(Object prejihua
	) {
		return findByProperty(PREJIHUA, prejihua
		);
	}
	
	public List findByNowjihua(Object nowjihua
	) {
		return findByProperty(NOWJIHUA, nowjihua
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	
	public List findByPretype(Object pretype
	) {
		return findByProperty(PRETYPE, pretype
		);
	}
	
	public List findByNowtype(Object nowtype
	) {
		return findByProperty(NOWTYPE, nowtype
		);
	}
	

	public List findAll() {
		log.debug("finding all TbsqPage instances");
		try {
			String queryString = "from TbsqPage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TbsqPage merge(TbsqPage detachedInstance) {
        log.debug("merging TbsqPage instance");
        try {
            TbsqPage result = (TbsqPage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TbsqPage instance) {
        log.debug("attaching dirty TbsqPage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TbsqPage instance) {
        log.debug("attaching clean TbsqPage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public TbsqPage findAllByNumber(String number) {
    	log.debug("finding all TbsqPage instances");
    	try {
    		String queryString = "from TbsqPage as tp where tp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (TbsqPage) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public TbsqPage findAllByNameAndDate(UserInfo ui,String date) {
    	log.debug("finding all TbsqPage instances");
    	try {
    		String queryString = "from TbsqPage as tp where (tp.applicant='"+ui.getNewnumber()+"' or tp.tbname='"+ui.getUsername()+"') and tp.tbdate='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (TbsqPage) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public TbsqPage findAllByApplicantNameAndDateAndStatus(UserInfo ui,String date,String status) {
    	log.debug("finding all TbsqPage instances");
    	try {
    		String queryString = "from TbsqPage as tp where tp.applicant='"+ui.getNewnumber()+"' and tp.status in ("+status+") and tp.tbdate='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (TbsqPage) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public TbsqPage findAllByTbNameAndDateAndStatus(UserInfo ui,String date,String status) {
    	log.debug("finding all TbsqPage instances");
    	try {
    		String queryString = "from TbsqPage as tp where tp.tbname='"+ui.getUsername()+"' and tp.status in ("+status+") and tp.tbdate='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return null;
    		 }
    		 else
    		 {
    			 return (TbsqPage) list.get(0);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}