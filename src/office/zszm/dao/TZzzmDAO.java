package office.zszm.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.zszm.pojo.TZzzm;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for TZzzm
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see office.zszm.pojo.TZzzm
 * @author MyEclipse Persistence Tools
 */

public class TZzzmDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TZzzmDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDER = "preunder";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String APPLICANT = "applicant";
	public static final String CHU = "chu";
	public static final String ZU = "zu";
	public static final String TEL = "tel";
	public static final String ZHIWU = "zhiwu";
	public static final String YONGTU = "yongtu";
	public static final String NEEDNUMBER = "neednumber";
	public static final String TODEPARTMENT = "todepartment";
	public static final String REMARK = "remark";
	public static final String SEX = "sex";
	public static final String LICENCECH = "licencech";
	public static final String LICENCEEN = "licenceen";
	public static final String ISDEPARTURE = "isdeparture";
	public static final String YSCJNUMBER = "yscjnumber";

	public void save(TZzzm transientInstance) {
		log.debug("saving TZzzm instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TZzzm persistentInstance) {
		log.debug("deleting TZzzm instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TZzzm findById(java.lang.Integer id) {
		log.debug("getting TZzzm instance with id: " + id);
		try {
			TZzzm instance = (TZzzm) getSession().get("office.zszm.pojo.TZzzm",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TZzzm instance) {
		log.debug("finding TZzzm instance by example");
		try {
			List results = getSession()
					.createCriteria("office.zszm.pojo.TZzzm").add(
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
		log.debug("finding TZzzm instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TZzzm as model where model."
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

	public List findByApplicant(Object applicant) {
		return findByProperty(APPLICANT, applicant);
	}

	public List findByChu(Object chu) {
		return findByProperty(CHU, chu);
	}

	public List findByZu(Object zu) {
		return findByProperty(ZU, zu);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByZhiwu(Object zhiwu) {
		return findByProperty(ZHIWU, zhiwu);
	}

	public List findByYongtu(Object yongtu) {
		return findByProperty(YONGTU, yongtu);
	}

	public List findByNeednumber(Object neednumber) {
		return findByProperty(NEEDNUMBER, neednumber);
	}

	public List findByTodepartment(Object todepartment) {
		return findByProperty(TODEPARTMENT, todepartment);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByLicencech(Object licencech) {
		return findByProperty(LICENCECH, licencech);
	}

	public List findByLicenceen(Object licenceen) {
		return findByProperty(LICENCEEN, licenceen);
	}

	public List findByIsdeparture(Object isdeparture) {
		return findByProperty(ISDEPARTURE, isdeparture);
	}

	public List findByYscjnumber(Object yscjnumber) {
		return findByProperty(YSCJNUMBER, yscjnumber);
	}

	public List findAll() {
		log.debug("finding all TZzzm instances");
		try {
			String queryString = "from TZzzm";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TZzzm merge(TZzzm detachedInstance) {
		log.debug("merging TZzzm instance");
		try {
			TZzzm result = (TZzzm) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TZzzm instance) {
		log.debug("attaching dirty TZzzm instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TZzzm instance) {
		log.debug("attaching clean TZzzm instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findAllByDate(String date) {
    	log.debug("finding all TZzzm instances");
    	try {
    		String queryString = "from TZzzm as tz where tz.date='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
	
	public TZzzm findAllByNumber(String number) {
	    	log.debug("finding all TZzzm instances");
	    	try {
	    		String queryString = "from TZzzm as tz where tz.number='"+number+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TZzzm> list = queryObject.list();
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