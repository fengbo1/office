package office.yscj.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.yscj.pojo.TYscjTemp;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TYscjTemp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see office.yscj.pojo.TYscjTemp
 * @author MyEclipse Persistence Tools
 */

public class TYscjTempDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TYscjTempDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DATE = "date";
	public static final String CHU = "chu";
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
	public static final String TEL = "tel";

	public void save(TYscjTemp transientInstance) {
		log.debug("saving TYscjTemp instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TYscjTemp persistentInstance) {
		log.debug("deleting TYscjTemp instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TYscjTemp findById(java.lang.Integer id) {
		log.debug("getting TYscjTemp instance with id: " + id);
		try {
			TYscjTemp instance = (TYscjTemp) getSession().get(
					"office.yscj.pojo.TYscjTemp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TYscjTemp instance) {
		log.debug("finding TYscjTemp instance by example");
		try {
			List results = getSession().createCriteria(
					"office.yscj.pojo.TYscjTemp").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TYscjTemp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TYscjTemp as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByChu(Object chu) {
		return findByProperty(CHU, chu);
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

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findAll() {
		log.debug("finding all TYscjTemp instances");
		try {
			String queryString = "from TYscjTemp";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TYscjTemp merge(TYscjTemp detachedInstance) {
		log.debug("merging TYscjTemp instance");
		try {
			TYscjTemp result = (TYscjTemp) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TYscjTemp instance) {
		log.debug("attaching dirty TYscjTemp instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TYscjTemp instance) {
		log.debug("attaching clean TYscjTemp instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}