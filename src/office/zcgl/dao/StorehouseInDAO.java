package office.zcgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.zcgl.pojo.StorehouseIn;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * StorehouseIn entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see office.zcgl.pojo.StorehouseIn
 * @author MyEclipse Persistence Tools
 */

public class StorehouseInDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StorehouseInDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String CHECKNAME = "checkname";
	public static final String STATUS = "status";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String DATE = "date";
	public static final String REMARK = "remark";
	public static final String RUKUNUM = "rukunum";
	public static final String TEL = "tel";

	public void save(StorehouseIn transientInstance) {
		log.debug("saving StorehouseIn instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StorehouseIn persistentInstance) {
		log.debug("deleting StorehouseIn instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StorehouseIn findById(java.lang.Integer id) {
		log.debug("getting StorehouseIn instance with id: " + id);
		try {
			StorehouseIn instance = (StorehouseIn) getSession().get(
					"office.zcgl.pojo.StorehouseIn", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StorehouseIn instance) {
		log.debug("finding StorehouseIn instance by example");
		try {
			List results = getSession().createCriteria(
					"office.zcgl.pojo.StorehouseIn").add(
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
		log.debug("finding StorehouseIn instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from StorehouseIn as model where model."
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

	public List findByThisunder(Object thisunder) {
		return findByProperty(THISUNDER, thisunder);
	}

	public List findByInitiator(Object initiator) {
		return findByProperty(INITIATOR, initiator);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByRukunum(Object rukunum) {
		return findByProperty(RUKUNUM, rukunum);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findAll() {
		log.debug("finding all StorehouseIn instances");
		try {
			String queryString = "from StorehouseIn";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StorehouseIn merge(StorehouseIn detachedInstance) {
		log.debug("merging StorehouseIn instance");
		try {
			StorehouseIn result = (StorehouseIn) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StorehouseIn instance) {
		log.debug("attaching dirty StorehouseIn instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StorehouseIn instance) {
		log.debug("attaching clean StorehouseIn instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public StorehouseIn findAllByNumber(String number) {
    	log.debug("finding all Storehousein instances");
    	try {
    		 String queryString = "from StorehouseIn as ah where ah.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<StorehouseIn> list = queryObject.list();
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