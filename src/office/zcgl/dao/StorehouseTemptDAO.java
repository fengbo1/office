package office.zcgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;


import office.zcgl.pojo.StorehouseTempt;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * StorehouseTempt entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see office.zcgl.pojo.StorehouseTempt
 * @author MyEclipse Persistence Tools
 */

public class StorehouseTemptDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StorehouseTemptDAO.class);
	// property constants
	public static final String ASSETNAME = "assetname";
	public static final String ASSETTYPE = "assettype";
	public static final String SN = "sn";
	public static final String NUM = "num";
	public static final String RUKUNUM = "rukunum";

	public void save(StorehouseTempt transientInstance) {
		log.debug("saving StorehouseTempt instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StorehouseTempt persistentInstance) {
		log.debug("deleting StorehouseTempt instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StorehouseTempt findById(java.lang.Integer id) {
		log.debug("getting StorehouseTempt instance with id: " + id);
		try {
			StorehouseTempt instance = (StorehouseTempt) getSession().get(
					"office.zcgl.pojo.StorehouseTempt", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StorehouseTempt instance) {
		log.debug("finding StorehouseTempt instance by example");
		try {
			List results = getSession().createCriteria(
					"office.zcgl.pojo.StorehouseTempt").add(
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
		log.debug("finding StorehouseTempt instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StorehouseTempt as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAssetname(Object assetname) {
		return findByProperty(ASSETNAME, assetname);
	}

	public List findByAssettype(Object assettype) {
		return findByProperty(ASSETTYPE, assettype);
	}

	public List findBySn(Object sn) {
		return findByProperty(SN, sn);
	}

	public List findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List findByRukunum(Object rukunum) {
		return findByProperty(RUKUNUM, rukunum);
	}

	public List findAll() {
		log.debug("finding all StorehouseTempt instances");
		try {
			String queryString = "from StorehouseTempt";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StorehouseTempt merge(StorehouseTempt detachedInstance) {
		log.debug("merging StorehouseTempt instance");
		try {
			StorehouseTempt result = (StorehouseTempt) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StorehouseTempt instance) {
		log.debug("attaching dirty StorehouseTempt instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StorehouseTempt instance) {
		log.debug("attaching clean StorehouseTempt instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	 public List<StorehouseTempt> findAllByRukunum(String rukunum) {
	    	log.debug("finding all StorehouseTempt instances");
	    	try {
	    		String queryString = "from StorehouseTempt as ap where ap.rukunum='"+rukunum+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<StorehouseTempt> list = queryObject.list();
	             if(list.isEmpty())
	             {
	            	 return null;
	             }
	             else
	             {
	            	 return list;
	             }
	    	} catch (RuntimeException re) {
	    		log.error("find all failed", re);
	    		throw re;
	    	}
	    }
}