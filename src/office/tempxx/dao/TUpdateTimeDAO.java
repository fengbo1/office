package office.tempxx.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.tempxx.pojo.TPeoplework;
import office.tempxx.pojo.TUpdateTime;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TUpdateTime entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see office.tempxx.pojo.TUpdateTime
 * @author MyEclipse Persistence Tools
 */

public class TUpdateTimeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TUpdateTimeDAO.class);
	// property constants
	public static final String DATE = "date";
	public static final String STATUS = "status";

	public void save(TUpdateTime transientInstance) {
		log.debug("saving TUpdateTime instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TUpdateTime persistentInstance) {
		log.debug("deleting TUpdateTime instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TUpdateTime findById(java.lang.Integer id) {
		log.debug("getting TUpdateTime instance with id: " + id);
		try {
			TUpdateTime instance = (TUpdateTime) getSession().get(
					"office.tempxx.pojo.TUpdateTime", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TUpdateTime instance) {
		log.debug("finding TUpdateTime instance by example");
		try {
			List results = getSession().createCriteria(
					"office.tempxx.pojo.TUpdateTime").add(
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
		log.debug("finding TUpdateTime instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TUpdateTime as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all TUpdateTime instances");
		try {
			String queryString = "from TUpdateTime";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TUpdateTime merge(TUpdateTime detachedInstance) {
		log.debug("merging TUpdateTime instance");
		try {
			TUpdateTime result = (TUpdateTime) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TUpdateTime instance) {
		log.debug("attaching dirty TUpdateTime instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TUpdateTime instance) {
		log.debug("attaching clean TUpdateTime instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	 public TUpdateTime findAllByLastId() {
		    log.debug("finding all TUpdateTime instances");
		     try {
		    		 String queryString = "from TUpdateTime as tt order by tt.id desc";
		             Query queryObject = getSession().createQuery(queryString);
		             List<TUpdateTime> list = queryObject.list();
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