package office.zcgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.zcgl.pojo.StorehouseOut;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * StorehouseOut entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see office.zcgl.pojo.StorehouseOut
 * @author MyEclipse Persistence Tools
 */

public class StorehouseOutDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StorehouseOutDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String CHECKNAME = "checkname";
	public static final String STATUS = "status";
	public static final String DATE = "date";
	public static final String REASON = "reason";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String CHUKUNUM = "chukunum";
	public static final String TEL = "tel";

	public void save(StorehouseOut transientInstance) {
		log.debug("saving StorehouseOut instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StorehouseOut persistentInstance) {
		log.debug("deleting StorehouseOut instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StorehouseOut findById(java.lang.Integer id) {
		log.debug("getting StorehouseOut instance with id: " + id);
		try {
			StorehouseOut instance = (StorehouseOut) getSession().get(
					"office.zcgl.pojo.StorehouseOut", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StorehouseOut instance) {
		log.debug("finding StorehouseOut instance by example");
		try {
			List results = getSession().createCriteria(
					"office.zcgl.pojo.StorehouseOut").add(
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
		log.debug("finding StorehouseOut instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StorehouseOut as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCheckname(Object checkname) {
		return findByProperty(CHECKNAME, checkname);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	public List findByThisunder(Object thisunder) {
		return findByProperty(THISUNDER, thisunder);
	}

	public List findByInitiator(Object initiator) {
		return findByProperty(INITIATOR, initiator);
	}

	public List findByChukunum(Object chukunum) {
		return findByProperty(CHUKUNUM, chukunum);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findAll() {
		log.debug("finding all StorehouseOut instances");
		try {
			String queryString = "from StorehouseOut";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StorehouseOut merge(StorehouseOut detachedInstance) {
		log.debug("merging StorehouseOut instance");
		try {
			StorehouseOut result = (StorehouseOut) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StorehouseOut instance) {
		log.debug("attaching dirty StorehouseOut instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StorehouseOut instance) {
		log.debug("attaching clean StorehouseOut instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public StorehouseOut findAllByNumber(String number) {
    	log.debug("finding all Storehouseout instances");
    	try {
    		 String queryString = "from StorehouseOut as ah where ah.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<StorehouseOut> list = queryObject.list();
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