package office.yscj.dao;
import office.yscj.pojo.TYscj;
import office.yscj.pojo.TYscjtz;
import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TYscjtz entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see office.yscj.pojo.TYscjtz
 * @author MyEclipse Persistence Tools
 */

public class TYscjtzDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TYscjtzDAO.class);
	// property constants
	public static final String NUMBER = "number";
	public static final String NEWNUMBER = "newnumber";
	public static final String REASON = "reason";
	public static final String BRINGTIME = "bringtime";
	public static final String RETURNTIME = "returntime";
	public static final String SUMDAY = "sumday";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String PASSPORTTYPE = "passporttype";
	public static final String PASSPORTNUMBER = "passportnumber";
	public static final String TOCOUNTRY = "tocountry";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String NAME = "name";

	public void save(TYscjtz transientInstance) {
		log.debug("saving TYscjtz instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TYscjtz persistentInstance) {
		log.debug("deleting TYscjtz instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TYscjtz findById(java.lang.Integer id) {
		log.debug("getting TYscjtz instance with id: " + id);
		try {
			TYscjtz instance = (TYscjtz) getSession().get(
					"office.yscj.pojo.TYscjtz", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TYscjtz instance) {
		log.debug("finding TYscjtz instance by example");
		try {
			List results = getSession().createCriteria(
					"office.yscj.pojo.TYscjtz").add(Example.create(instance))
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
		log.debug("finding TYscjtz instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TYscjtz as model where model."
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

	public List findByNewnumber(Object newnumber) {
		return findByProperty(NEWNUMBER, newnumber);
	}

	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	public List findByBringtime(Object bringtime) {
		return findByProperty(BRINGTIME, bringtime);
	}

	public List findByReturntime(Object returntime) {
		return findByProperty(RETURNTIME, returntime);
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

	public List findByPassporttype(Object passporttype) {
		return findByProperty(PASSPORTTYPE, passporttype);
	}

	public List findByPassportnumber(Object passportnumber) {
		return findByProperty(PASSPORTNUMBER, passportnumber);
	}

	public List findByTocountry(Object tocountry) {
		return findByProperty(TOCOUNTRY, tocountry);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all TYscjtz instances");
		try {
			String queryString = "from TYscjtz";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TYscjtz merge(TYscjtz detachedInstance) {
		log.debug("merging TYscjtz instance");
		try {
			TYscjtz result = (TYscjtz) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TYscjtz instance) {
		log.debug("attaching dirty TYscjtz instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TYscjtz instance) {
		log.debug("attaching clean TYscjtz instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	 public TYscjtz findAllByNumber(String number) {
	    	log.debug("finding all TYscjtz instances");
	    	try {
	    		String queryString = "from TYscjtz as tz where tz.number='"+number+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TYscjtz> list = queryObject.list();
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