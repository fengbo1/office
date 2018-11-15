package office.mjgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.mjgl.pojo.TMjgl;
import office.wcgg.pojo.WcggPage;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for TMjgl
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see office.mjgl.pojo.TMjgl
 * @author MyEclipse Persistence Tools
 */

public class TMjglDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TMjglDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDER = "preunder";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String PEOPLE = "people";
	public static final String CHU = "chu";
	public static final String ZU = "zu";
	public static final String REASON = "reason";
	public static final String OLDP = "oldp";
	public static final String NEWP = "newp";
	public static final String OLDTIME = "oldtime";
	public static final String NEWTIME = "newtime";
	public static final String ISTEMP = "istemp";
	public static final String STARTDATE = "startdate";
	public static final String ENDDATE = "enddate";
	public static final String TEMPAUTH = "tempauth";
	public static final String TEMPTIME = "temptime";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String STARTDATEAMORPM = "startdateamorpm";
	public static final String ENDDATEAMORPAM = "enddateamorpam";

	public void save(TMjgl transientInstance) {
		log.debug("saving TMjgl instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TMjgl persistentInstance) {
		log.debug("deleting TMjgl instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TMjgl findById(java.lang.Integer id) {
		log.debug("getting TMjgl instance with id: " + id);
		try {
			TMjgl instance = (TMjgl) getSession().get("office.mjgl.TMjgl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TMjgl instance) {
		log.debug("finding TMjgl instance by example");
		try {
			List results = getSession().createCriteria("office.mjgl.TMjgl")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TMjgl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TMjgl as model where model."
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

	public List findByProcess(Object process) {
		return findByProperty(PROCESS, process);
	}

	public List findByJindu(Object jindu) {
		return findByProperty(JINDU, jindu);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
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

	public List findByPeople(Object people) {
		return findByProperty(PEOPLE, people);
	}

	public List findByChu(Object chu) {
		return findByProperty(CHU, chu);
	}

	public List findByZu(Object zu) {
		return findByProperty(ZU, zu);
	}

	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	public List findByOldp(Object oldp) {
		return findByProperty(OLDP, oldp);
	}

	public List findByNewp(Object newp) {
		return findByProperty(NEWP, newp);
	}

	public List findByOldtime(Object oldtime) {
		return findByProperty(OLDTIME, oldtime);
	}

	public List findByNewtime(Object newtime) {
		return findByProperty(NEWTIME, newtime);
	}

	public List findByIstemp(Object istemp) {
		return findByProperty(ISTEMP, istemp);
	}

	public List findByStartdate(Object startdate) {
		return findByProperty(STARTDATE, startdate);
	}

	public List findByEnddate(Object enddate) {
		return findByProperty(ENDDATE, enddate);
	}

	public List findByTempauth(Object tempauth) {
		return findByProperty(TEMPAUTH, tempauth);
	}

	public List findByTemptime(Object temptime) {
		return findByProperty(TEMPTIME, temptime);
	}

	public List findByRemark1(Object remark1) {
		return findByProperty(REMARK1, remark1);
	}

	public List findByRemark2(Object remark2) {
		return findByProperty(REMARK2, remark2);
	}

	public List findByStartdateamorpm(Object startdateamorpm) {
		return findByProperty(STARTDATEAMORPM, startdateamorpm);
	}

	public List findByEnddateamorpam(Object enddateamorpam) {
		return findByProperty(ENDDATEAMORPAM, enddateamorpam);
	}

	public List findAll() {
		log.debug("finding all TMjgl instances");
		try {
			String queryString = "from TMjgl";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TMjgl merge(TMjgl detachedInstance) {
		log.debug("merging TMjgl instance");
		try {
			TMjgl result = (TMjgl) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TMjgl instance) {
		log.debug("attaching dirty TMjgl instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TMjgl instance) {
		log.debug("attaching clean TMjgl instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	 public TMjgl findAllByNumber(String number) {
	    	log.debug("finding all TMjgl instances");
	    	try {
	    		 String queryString = "from TMjgl as tm where tm.number='"+number+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TMjgl> list = queryObject.list();
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