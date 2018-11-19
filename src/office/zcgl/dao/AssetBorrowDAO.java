package office.zcgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import office.zcgl.pojo.AssetBorrow;

/**
 * A data access object (DAO) providing persistence and search support for
 * AssetBorrow entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see office.zcgl.pojo.AssetBorrow
 * @author MyEclipse Persistence Tools
 */

public class AssetBorrowDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AssetBorrowDAO.class);
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
	public static final String RETURNTIME = "returntime";
	public static final String TEL = "tel";
	public static final String ISRETURN = "isreturn";
	public static final String ISANDBORROW = "isandborrow";
	public static final String ANDBORROWRETURNTIME = "andborrowreturntime";

	public void save(AssetBorrow transientInstance) {
		log.debug("saving AssetBorrow instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AssetBorrow persistentInstance) {
		log.debug("deleting AssetBorrow instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssetBorrow findById(java.lang.Integer id) {
		log.debug("getting AssetBorrow instance with id: " + id);
		try {
			AssetBorrow instance = (AssetBorrow) getSession().get(
					"office.zcgl.pojo.AssetBorrow", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AssetBorrow instance) {
		log.debug("finding AssetBorrow instance by example");
		try {
			List results = getSession().createCriteria(
					"office.zcgl.pojo.AssetBorrow").add(
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
		log.debug("finding AssetBorrow instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AssetBorrow as model where model."
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

	public List findByReturntime(Object returntime) {
		return findByProperty(RETURNTIME, returntime);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByIsreturn(Object isreturn) {
		return findByProperty(ISRETURN, isreturn);
	}

	public List findByIsandborrow(Object isandborrow) {
		return findByProperty(ISANDBORROW, isandborrow);
	}

	public List findByAndborrowreturntime(Object andborrowreturntime) {
		return findByProperty(ANDBORROWRETURNTIME, andborrowreturntime);
	}

	public List findAll() {
		log.debug("finding all AssetBorrow instances");
		try {
			String queryString = "from AssetBorrow";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AssetBorrow merge(AssetBorrow detachedInstance) {
		log.debug("merging AssetBorrow instance");
		try {
			AssetBorrow result = (AssetBorrow) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AssetBorrow instance) {
		log.debug("attaching dirty AssetBorrow instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssetBorrow instance) {
		log.debug("attaching clean AssetBorrow instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public AssetBorrow findAllByNumber(String number) {
    	log.debug("finding all AssetBorrwo instances");
    	try {
    		String queryString = "from AssetBorrow as ay where ay.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<AssetBorrow> list = queryObject.list();
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