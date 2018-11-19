package office.kqqs.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.kqqs.pojo.KqqsPage;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for KqqsPage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .KqqsPage
  * @author MyEclipse Persistence Tools 
 */

public class KqqsPageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(KqqsPageDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDER = "preunder";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String APPLICANT = "applicant";
	public static final String CHU = "chu";
	public static final String ZU = "zu";
	public static final String TEL = "tel";
	public static final String REASON = "reason";
	public static final String QSDATE = "qsdate";
	public static final String QDQT = "qdqt";
	public static final String QSTIME = "qstime";
	public static final String BU = "bu";
	public static final String CS = "cs";
	public static final String REMARK = "remark";



    
    public void save(KqqsPage transientInstance) {
        log.debug("saving KqqsPage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(KqqsPage persistentInstance) {
        log.debug("deleting KqqsPage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public KqqsPage findById( java.lang.Integer id) {
        log.debug("getting KqqsPage instance with id: " + id);
        try {
            KqqsPage instance = (KqqsPage) getSession()
                    .get("KqqsPage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(KqqsPage instance) {
        log.debug("finding KqqsPage instance by example");
        try {
            List results = getSession()
                    .createCriteria("KqqsPage")
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
      log.debug("finding KqqsPage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from KqqsPage as model where model." 
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
	
	public List findByPreunder(Object preunder
	) {
		return findByProperty(PREUNDER, preunder
		);
	}
	
	public List findByThisunder(Object thisunder
	) {
		return findByProperty(THISUNDER, thisunder
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
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	
	public List findByZu(Object zu
	) {
		return findByProperty(ZU, zu
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
		);
	}
	
	public List findByQsdate(Object qsdate
	) {
		return findByProperty(QSDATE, qsdate
		);
	}
	
	public List findByQdqt(Object qdqt
	) {
		return findByProperty(QDQT, qdqt
		);
	}
	
	public List findByQstime(Object qstime
	) {
		return findByProperty(QSTIME, qstime
		);
	}
	
	public List findByBu(Object bu
	) {
		return findByProperty(BU, bu
		);
	}
	
	public List findByCs(Object cs
	) {
		return findByProperty(CS, cs
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all KqqsPage instances");
		try {
			String queryString = "from KqqsPage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	public KqqsPage merge(KqqsPage detachedInstance) {
	    log.debug("merging KqqsPage instance");
	    try {
	        KqqsPage result = (KqqsPage) getSession()
	                .merge(detachedInstance);
	        log.debug("merge successful");
	        return result;
	    } catch (RuntimeException re) {
	        log.error("merge failed", re);
	        throw re;
	    }
	}

	public void attachDirty(KqqsPage instance) {
	    log.debug("attaching dirty KqqsPage instance");
	    try {
	        getSession().saveOrUpdate(instance);
	        log.debug("attach successful");
	    } catch (RuntimeException re) {
	        log.error("attach failed", re);
	        throw re;
	    }
	}

	public void attachClean(KqqsPage instance) {
	    log.debug("attaching clean KqqsPage instance");
	    try {
	        getSession().lock(instance, LockMode.NONE);
	        log.debug("attach successful");
	    } catch (RuntimeException re) {
	        log.error("attach failed", re);
	        throw re;
	    }
	}
	public List findAllByNameAndDate(String newnumber,String date) {
		log.debug("finding all KqqsPage instances");
		try {
			String queryString = "from KqqsPage as kp where kp.applicant='"+newnumber+"' and kp.status in (3,4,7) and kp.qsdate='"+date+"'";
	        //System.out.println(queryString);
			Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllByNameAndDateQD(String newnumber,String date) {
		log.debug("finding all KqqsPage instances");
		try {
			String queryString = "from KqqsPage as kp where kp.applicant='"+newnumber+"' and kp.status in (3,4,7) and kp.qdqt=1 and kp.qsdate='"+date+"'";
	        //System.out.println(queryString);
			Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllByNameAndDateQT(String newnumber,String date) {
		log.debug("finding all KqqsPage instances");
		try {
			String queryString = "from KqqsPage as kp where kp.applicant='"+newnumber+"' and kp.status in (3,4,7) and kp.qdqt=2 and kp.qsdate='"+date+"'";
	        //System.out.println(queryString);
			Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllByDate(String date) {
		log.debug("finding all KqqsPage instances");
		try {
			String queryString = "from KqqsPage as kp where kp.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 
	 * @param month
	 * @param status 2表示流转中
	 * @return
	 */
	public List findAllByDateAndStatus(String month,int status) {
		log.debug("finding all KqqsPage instances");
		try {
			String queryString = "";
			if(status==2)//流转中
			{
				queryString = "from KqqsPage as kp where kp.qsdate>='"+month+"01' and kp.qsdate<='"+month+"31' and kp.status in (1,2,3)";
			}
			
			 Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 查询缺失
	 * @param month 201501
	 * @return
	 */
	public List findAllByQsMonthAndNewnumber(String month,String newnumber) {
		log.debug("finding all KqqsPage instances");
		try {
			String queryString = "from KqqsPage as kp where kp.status in (1,2,4,7) and kp.qsdate>='"+month+"01' and kp.qsdate<='"+month+"31' and kp.applicant='"+newnumber+"' order by kp.number";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public KqqsPage findAllByNumber(String number) {
		log.debug("finding all KqqsPage instances");
		try {
			String queryString = "from KqqsPage as kp where kp.number='"+number+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         List<KqqsPage> list = queryObject.list();
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
}