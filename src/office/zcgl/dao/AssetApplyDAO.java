package office.zcgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.wcgg.pojo.WcggPage;
import office.zcgl.pojo.AssetApply;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AssetApply entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see office.zcgl.pojo.AssetApply
 * @author MyEclipse Persistence Tools
 */

public class AssetApplyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AssetApplyDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String CHU = "chu";
	public static final String STATUS = "status";
	public static final String DATE = "date";
	public static final String REASON = "reason";
	public static final String REMARK = "remark";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String PREUNDER = "preunder";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String TEL = "tel";

	public void save(AssetApply transientInstance) {
		log.debug("saving AssetApply instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AssetApply persistentInstance) {
		log.debug("deleting AssetApply instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssetApply findById(java.lang.Integer id) {
		log.debug("getting AssetApply instance with id: " + id);
		try {
			AssetApply instance = (AssetApply) getSession().get(
					"office.zcgl.AssetApply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AssetApply instance) {
		log.debug("finding AssetApply instance by example");
		try {
			List results = getSession()
					.createCriteria("office.zcgl.AssetApply").add(
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
		log.debug("finding AssetApply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AssetApply as model where model."
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

	public List findByChu(Object chu) {
		return findByProperty(CHU, chu);
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

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByProcess(Object process) {
		return findByProperty(PROCESS, process);
	}

	public List findByJindu(Object jindu) {
		return findByProperty(JINDU, jindu);
	}

	public List findByPreunder(Object preunder) {
		return findByProperty(PREUNDER, preunder);
	}

	public List findByThisunder(Object thisunder) {
		return findByProperty(THISUNDER, thisunder);
	}

	public List findByInitiator(Object initiator) {
		return findByProperty(INITIATOR, initiator);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findAll() {
		log.debug("finding all AssetApply instances");
		try {
			String queryString = "from AssetApply";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AssetApply merge(AssetApply detachedInstance) {
		log.debug("merging AssetApply instance");
		try {
			AssetApply result = (AssetApply) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AssetApply instance) {
		log.debug("attaching dirty AssetApply instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssetApply instance) {
		log.debug("attaching clean AssetApply instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public AssetApply findAllByNumber(String number) {
    	log.debug("finding all AssetApply instances");
    	try {
    		String queryString = "from AssetApply as ay where ay.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<AssetApply> list = queryObject.list();
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