package office.yscj.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.yscj.pojo.TYscj;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for TYscj
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see office.yscj.pojo.TYscj
 * @author MyEclipse Persistence Tools
 */

public class TYscjDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TYscjDAO.class);
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
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String HUKOU = "hukou";
	public static final String EMAIL = "email";
	public static final String CONTACTPEOPLE = "contactpeople";
	public static final String CONTACTPEOPLETEL = "contactpeopletel";
	public static final String CATEGORY = "category";
	public static final String TOCOUNTRY = "tocountry";
	public static final String SUMDAY = "sumday";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String HALFDAY = "halfday";
	public static final String REASON = "reason";
	public static final String TRAVELAGENCY = "travelagency";
	public static final String INVITEPEOPLE = "invitepeople";
	public static final String RELATIONSHIP = "relationship";
	public static final String INVITEPEOPLETEL = "invitepeopletel";
	public static final String QITASHUOMING = "qitashuoming";
	public static final String REMARK = "remark";
	public static final String PASSPORTTYPE = "passporttype";
	public static final String NOTHOLIDAY = "notholiday";
	public static final String LEAVEPAGENUMBER = "leavepagenumber";
	public static final String LEAVEREMARK = "leaveremark";

	public void save(TYscj transientInstance) {
		log.debug("saving TYscj instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TYscj persistentInstance) {
		log.debug("deleting TYscj instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TYscj findById(java.lang.Integer id) {
		log.debug("getting TYscj instance with id: " + id);
		try {
			TYscj instance = (TYscj) getSession().get("office.yscj.pojo.TYscj",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TYscj instance) {
		log.debug("finding TYscj instance by example");
		try {
			List results = getSession()
					.createCriteria("office.yscj.pojo.TYscj").add(
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
		log.debug("finding TYscj instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TYscj as model where model."
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

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByHukou(Object hukou) {
		return findByProperty(HUKOU, hukou);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByContactpeople(Object contactpeople) {
		return findByProperty(CONTACTPEOPLE, contactpeople);
	}

	public List findByContactpeopletel(Object contactpeopletel) {
		return findByProperty(CONTACTPEOPLETEL, contactpeopletel);
	}

	public List findByCategory(Object category) {
		return findByProperty(CATEGORY, category);
	}

	public List findByTocountry(Object tocountry) {
		return findByProperty(TOCOUNTRY, tocountry);
	}

	public List findBySumday(Object sumday) {
		return findByProperty(SUMDAY, sumday);
	}

	public List findByBegindate(Object begindate) {
		return findByProperty(BEGINDATE, begindate);
	}

	public List findByEnddate(Object enddate) {
		return findByProperty(ENDDATE, enddate);
	}

	public List findByHalfday(Object halfday) {
		return findByProperty(HALFDAY, halfday);
	}

	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	public List findByTravelagency(Object travelagency) {
		return findByProperty(TRAVELAGENCY, travelagency);
	}

	public List findByInvitepeople(Object invitepeople) {
		return findByProperty(INVITEPEOPLE, invitepeople);
	}

	public List findByRelationship(Object relationship) {
		return findByProperty(RELATIONSHIP, relationship);
	}

	public List findByInvitepeopletel(Object invitepeopletel) {
		return findByProperty(INVITEPEOPLETEL, invitepeopletel);
	}

	public List findByQitashuoming(Object qitashuoming) {
		return findByProperty(QITASHUOMING, qitashuoming);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByPassporttype(Object passporttype) {
		return findByProperty(PASSPORTTYPE, passporttype);
	}

	public List findByNotholiday(Object notholiday) {
		return findByProperty(NOTHOLIDAY, notholiday);
	}

	public List findByLeavepagenumber(Object leavepagenumber) {
		return findByProperty(LEAVEPAGENUMBER, leavepagenumber);
	}

	public List findByLeaveremark(Object leaveremark) {
		return findByProperty(LEAVEREMARK, leaveremark);
	}

	public List findAll() {
		log.debug("finding all TYscj instances");
		try {
			String queryString = "from TYscj";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TYscj merge(TYscj detachedInstance) {
		log.debug("merging TYscj instance");
		try {
			TYscj result = (TYscj) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TYscj instance) {
		log.debug("attaching dirty TYscj instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TYscj instance) {
		log.debug("attaching clean TYscj instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	 public List findAllByDate(String date) {
	    	log.debug("finding all TYscj instances");
	    	try {
	    		String queryString = "from TYscj as ty where ty.date='"+date+"'";
	             Query queryObject = getSession().createQuery(queryString);
	    		 return queryObject.list();
	    	} catch (RuntimeException re) {
	    		log.error("find all failed", re);
	    		throw re;
	    	}
	    }
	  public TYscj findAllByNumber(String number) {
	    	log.debug("finding all TYscj instances");
	    	try {
	    		String queryString = "from TYscj as ty where ty.number='"+number+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TYscj> list = queryObject.list();
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