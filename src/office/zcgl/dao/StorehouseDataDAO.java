package office.zcgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.zcgl.pojo.StorehouseData;
import office.zcgl.pojo.StorehouseTempt;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * StorehouseData entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see office.zcgl.pojo.StorehouseData
 * @author MyEclipse Persistence Tools
 */

public class StorehouseDataDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StorehouseDataDAO.class);
	// property constants
	public static final String ASSETNAME = "assetname";
	public static final String ASSETTYPE = "assettype";
	public static final String SN = "sn";
	public static final String ASSETNUMBER = "assetnumber";
	public static final String RUKUTIME = "rukutime";
	public static final String RUKUNUM = "rukunum";
	public static final String ISWUPIN = "iswupin";
	public static final String AREA = "area";

	public void save(StorehouseData transientInstance) {
		log.debug("saving StorehouseData instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StorehouseData persistentInstance) {
		log.debug("deleting StorehouseData instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StorehouseData findById(java.lang.Integer id) {
		log.debug("getting StorehouseData instance with id: " + id);
		try {
			StorehouseData instance = (StorehouseData) getSession().get(
					"office.zcgl.pojo.StorehouseData", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StorehouseData instance) {
		log.debug("finding StorehouseData instance by example");
		try {
			List results = getSession().createCriteria(
					"office.zcgl.pojo.StorehouseData").add(
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
		log.debug("finding StorehouseData instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StorehouseData as model where model."
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

	public List findByAssetnumber(Object assetnumber) {
		return findByProperty(ASSETNUMBER, assetnumber);
	}

	public List findByRukutime(Object rukutime) {
		return findByProperty(RUKUTIME, rukutime);
	}

	public List findByRukunum(Object rukunum) {
		return findByProperty(RUKUNUM, rukunum);
	}

	public List findByIswupin(Object iswupin) {
		return findByProperty(ISWUPIN, iswupin);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findAll() {
		log.debug("finding all StorehouseData instances");
		try {
			String queryString = "from StorehouseData";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StorehouseData merge(StorehouseData detachedInstance) {
		log.debug("merging StorehouseData instance");
		try {
			StorehouseData result = (StorehouseData) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StorehouseData instance) {
		log.debug("attaching dirty StorehouseData instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StorehouseData instance) {
		log.debug("attaching clean StorehouseData instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	 public List<StorehouseData> findAllByRukunum(String rukunum) {
	    	log.debug("finding all StorehouseData instances");
	    	try {
	    		String queryString = "from StorehouseData as ap where ap.rukunum='"+rukunum+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<StorehouseData> list = queryObject.list();
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