package office.kqjl.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.kqjl.pojo.KqjlMonth;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for KqjlMonth entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .KqjlMonth
  * @author MyEclipse Persistence Tools 
 */

public class KqjlMonthDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(KqjlMonthDAO.class);
		//property constants
	public static final String MONTH = "month";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String POSITION = "position";
	public static final String WORKDAYS = "workdays";
	public static final String ZHIWENDAYS = "zhiwendays";
	public static final String CHIDAO = "chidao";
	public static final String ZAOTUI = "zaotui";
	public static final String QDQS = "qdqs";
	public static final String QTQS = "qtqs";
	public static final String BUKQ = "bukq";
	public static final String QJDAYS = "qjdays";
	public static final String GGDAYS = "ggdays";
	public static final String JBDAYS = "jbdays";
	public static final String YEARLEAVE = "yearleave";
	public static final String WORKLEAVE = "workleave";
	public static final String BINGLEAVEBU = "bingleavebu";
	public static final String BINGLEAVEKOU = "bingleavekou";
	public static final String SHILEAVEBU = "shileavebu";
	public static final String SHILEAVEKOU = "shileavekou";
	public static final String HUNLEAVE = "hunleave";
	public static final String CHANLEAVE = "chanleave";
	public static final String TANPOLEAVE = "tanpoleave";
	public static final String TANFMLEAVE = "tanfmleave";
	public static final String SANGLEAVE = "sangleave";
	public static final String SHANGLEAVE = "shangleave";
	public static final String GONGLEAVE = "gongleave";
	public static final String CHANJIANLEAVE = "chanjianleave";
	public static final String PEIKAOLEAVE = "peikaoleave";
	public static final String BURULEAVE = "buruleave";
	public static final String YC = "yc";
	public static final String STATUS = "status";



    
    public void save(KqjlMonth transientInstance) {
        log.debug("saving KqjlMonth instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(KqjlMonth persistentInstance) {
        log.debug("deleting KqjlMonth instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public KqjlMonth findById( java.lang.Integer id) {
        log.debug("getting KqjlMonth instance with id: " + id);
        try {
            KqjlMonth instance = (KqjlMonth) getSession()
                    .get("KqjlMonth", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(KqjlMonth instance) {
        log.debug("finding KqjlMonth instance by example");
        try {
            List results = getSession()
                    .createCriteria("KqjlMonth")
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
      log.debug("finding KqjlMonth instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from KqjlMonth as model where model." 
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
	
	public List findByWorkdays(Object workdays
	) {
		return findByProperty(WORKDAYS, workdays
		);
	}
	
	public List findByZhiwendays(Object zhiwendays
	) {
		return findByProperty(ZHIWENDAYS, zhiwendays
		);
	}
	
	public List findByChidao(Object chidao
	) {
		return findByProperty(CHIDAO, chidao
		);
	}
	
	public List findByZaotui(Object zaotui
	) {
		return findByProperty(ZAOTUI, zaotui
		);
	}
	
	public List findByQdqs(Object qdqs
	) {
		return findByProperty(QDQS, qdqs
		);
	}
	
	public List findByQtqs(Object qtqs
	) {
		return findByProperty(QTQS, qtqs
		);
	}
	
	public List findByBukq(Object bukq
	) {
		return findByProperty(BUKQ, bukq
		);
	}
	
	public List findByQjdays(Object qjdays
	) {
		return findByProperty(QJDAYS, qjdays
		);
	}
	
	public List findByGgdays(Object ggdays
	) {
		return findByProperty(GGDAYS, ggdays
		);
	}
	
	public List findByJbdays(Object jbdays
	) {
		return findByProperty(JBDAYS, jbdays
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
	
	public List findByBingleavebu(Object bingleavebu
	) {
		return findByProperty(BINGLEAVEBU, bingleavebu
		);
	}
	
	public List findByBingleavekou(Object bingleavekou
	) {
		return findByProperty(BINGLEAVEKOU, bingleavekou
		);
	}
	
	public List findByShileavebu(Object shileavebu
	) {
		return findByProperty(SHILEAVEBU, shileavebu
		);
	}
	
	public List findByShileavekou(Object shileavekou
	) {
		return findByProperty(SHILEAVEKOU, shileavekou
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
	
	public List findByChanjianleave(Object chanjianleave
	) {
		return findByProperty(CHANJIANLEAVE, chanjianleave
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
	
	public List findByYc(Object yc
	) {
		return findByProperty(YC, yc
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	

	public List findAll() {
		log.debug("finding all KqjlMonth instances");
		try {
			String queryString = "from KqjlMonth";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public KqjlMonth merge(KqjlMonth detachedInstance) {
        log.debug("merging KqjlMonth instance");
        try {
            KqjlMonth result = (KqjlMonth) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(KqjlMonth instance) {
        log.debug("attaching dirty KqjlMonth instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(KqjlMonth instance) {
        log.debug("attaching clean KqjlMonth instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public List findAllByMonth(String month) {
    	log.debug("finding all KqjlMonth instances");
    	try {
    		String queryString = "from KqjlMonth as km where km.month='"+month+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public KqjlMonth findAllByMonthAndName(String name,String month) {
    	log.debug("finding all KqjlMonth instances");
    	try {
    		String queryString = "from KqjlMonth as km where km.name='"+name+"' and km.month='"+month+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<KqjlMonth> list = queryObject.list();
             if(list.isEmpty())
             {
            	 KqjlMonth km = new KqjlMonth();
            	 km.setMonth(month);
            	 km.setName(name);
            	 return km;
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
     * 如果无，不新增
     * @param name
     * @param month
     * @return
     */
    public KqjlMonth findAllByMonthAndNameNull(String name,String month) {
    	log.debug("finding all KqjlMonth instances");
    	try {
    		String queryString = "from KqjlMonth as km where km.name='"+name+"' and km.month='"+month+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<KqjlMonth> list = queryObject.list();
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
    public KqjlMonth findAllById(int id) {
    	log.debug("finding all KqjlMonth instances");
    	try {
    		String queryString = "from KqjlMonth as km where km.id="+id;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	return (KqjlMonth) list.get(0); 
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}