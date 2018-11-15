package office.tempxx.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.tempxx.pojo.TPeoplework;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPeoplework entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see office.tempxx.pojo.TPeoplework
 * @author MyEclipse Persistence Tools
 */

public class TPeopleworkDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TPeopleworkDAO.class);
	// property constants
	public static final String OPNUMBER = "opnumber";
	public static final String ZU = "zu";
	public static final String DATE = "date";
	public static final String ISZHUAN = "iszhuan";
	public static final String REMARK = "remark";
	public static final String NAME = "name";
	public static final String STATUS = "status";

	public void save(TPeoplework transientInstance) {
		log.debug("saving TPeoplework instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TPeoplework persistentInstance) {
		log.debug("deleting TPeoplework instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TPeoplework findById(java.lang.Integer id) {
		log.debug("getting TPeoplework instance with id: " + id);
		try {
			TPeoplework instance = (TPeoplework) getSession().get(
					"office.tempxx.pojo.TPeoplework", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPeoplework instance) {
		log.debug("finding TPeoplework instance by example");
		try {
			List results = getSession().createCriteria(
					"office.tempxx.pojo.TPeoplework").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TPeoplework instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TPeoplework as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOpnumber(Object opnumber) {
		return findByProperty(OPNUMBER, opnumber);
	}

	public List findByZu(Object zu) {
		return findByProperty(ZU, zu);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByIszhuan(Object iszhuan) {
		return findByProperty(ISZHUAN, iszhuan);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all TPeoplework instances");
		try {
			String queryString = "from TPeoplework";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPeoplework merge(TPeoplework detachedInstance) {
		log.debug("merging TPeoplework instance");
		try {
			TPeoplework result = (TPeoplework) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPeoplework instance) {
		log.debug("attaching dirty TPeoplework instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPeoplework instance) {
		log.debug("attaching clean TPeoplework instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
    public TPeoplework findAllByOpNumber(String number,String date) {
	    log.debug("finding all instances");
	     try {
	    		String queryString = "from TPeoplework as tw where tw.opnumber='"+number+"'and tw.date='"+date+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TPeoplework> list = queryObject.list();
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
    
    public int isvalid(String time,String name) {
	    log.debug("finding all instances");
	     try {
	    		String queryString = "from TPeoplework as tw where tw.date>='"+time+"01'and tw.date<='"+time+"31' and tw.name='"+name+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TPeoplework> list = queryObject.list();
	             if(list.isEmpty())
	             {
	            	 return 0;
	             }
	             else
	             {
	            	 return 1;
	             }
	    	} catch (RuntimeException re) {
	    		log.error("find all failed", re);
	    		throw re;
	    	}
	    }
   
}