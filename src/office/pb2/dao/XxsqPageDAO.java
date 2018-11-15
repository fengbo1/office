package office.pb2.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.pb2.pojo.XxsqPage;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for XxsqPage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .XxsqPage
  * @author MyEclipse Persistence Tools 
 */

public class XxsqPageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(XxsqPageDAO.class);
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
	public static final String PEOPLE = "people";
	public static final String TEL = "tel";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String HALFDAY = "halfday";
	public static final String DAY = "day";
	public static final String HOUR = "hour";
	public static final String TYPE = "type";
	public static final String REASON = "reason";
	public static final String QITA = "qita";
	public static final String REMARK = "remark";
	public static final String VIEW = "view";
	public static final String CHU = "chu";



    
    public void save(XxsqPage transientInstance) {
        log.debug("saving XxsqPage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(XxsqPage persistentInstance) {
        log.debug("deleting XxsqPage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public XxsqPage findById( java.lang.Integer id) {
        log.debug("getting XxsqPage instance with id: " + id);
        try {
            XxsqPage instance = (XxsqPage) getSession()
                    .get("XxsqPage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(XxsqPage instance) {
        log.debug("finding XxsqPage instance by example");
        try {
            List results = getSession()
                    .createCriteria("XxsqPage")
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
      log.debug("finding XxsqPage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from XxsqPage as model where model." 
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
	
	public List findByPeople(Object people
	) {
		return findByProperty(PEOPLE, people
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findByBegindate(Object begindate
	) {
		return findByProperty(BEGINDATE, begindate
		);
	}
	
	public List findByEnddate(Object enddate
	) {
		return findByProperty(ENDDATE, enddate
		);
	}
	
	public List findByHalfday(Object halfday
	) {
		return findByProperty(HALFDAY, halfday
		);
	}
	
	public List findByDay(Object day
	) {
		return findByProperty(DAY, day
		);
	}
	
	public List findByHour(Object hour
	) {
		return findByProperty(HOUR, hour
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
		);
	}
	
	public List findByQita(Object qita
	) {
		return findByProperty(QITA, qita
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	
	public List findByView(Object view
	) {
		return findByProperty(VIEW, view
		);
	}
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	

	public List findAll() {
		log.debug("finding all XxsqPage instances");
		try {
			String queryString = "from XxsqPage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public XxsqPage merge(XxsqPage detachedInstance) {
        log.debug("merging XxsqPage instance");
        try {
            XxsqPage result = (XxsqPage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(XxsqPage instance) {
        log.debug("attaching dirty XxsqPage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(XxsqPage instance) {
        log.debug("attaching clean XxsqPage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public XxsqPage findAllByNumber(String number) {
    	log.debug("finding all XxsqPage instances");
    	try {
    		String queryString = "from XxsqPage as xp where xp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	return (XxsqPage) list.get(0); 
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public XxsqPage findAllByBegindateAndEnddate(String begindate,String enddate,String name) {
    	log.debug("finding all XxsqPage instances");
    	try {
    		String queryString = "from XxsqPage as xp where xp.begindate='"+begindate+"' and xp.enddate='"+enddate+"' and people='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return new XxsqPage();
             }
             else
             {
            	return (XxsqPage) list.get(0); 
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public boolean ifFindContain(String begindate,String enddate,String name,int halfday1)
    {
    	try {
    		String queryString = "from XxsqPage as xp where xp.status in(1,2,4,7) and xp.people like '%"+name+"%' and ((xp.begindate<='"+begindate+"' and xp.enddate>='"+begindate+"') or (xp.begindate<='"+enddate+"' and xp.enddate>='"+enddate+"') or (xp.begindate>='"+begindate+"' and xp.enddate<='"+enddate+"'))";
            System.out.println(queryString) ;
    		Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return false;
             }
             else
             {
            	 XxsqPage xp = (XxsqPage) list.get(0);
            	 if((halfday1==2||halfday1==3)&&(xp.getHalfday()==1||xp.getHalfday()==3)&&enddate.equals(xp.getBegindate()))
            	 {
            		 return false;
            	 }
            	 else if((halfday1==1||halfday1==3)&&(xp.getHalfday()==2||xp.getHalfday()==3)&&begindate.equals(xp.getEnddate()))
            	 {
            		 return false;
            	 }
            	 else
            	 {
            		 return true; 
            	 }
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}