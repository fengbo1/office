package office.mjgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.mjgl.pojo.TMjglPage;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TMjglPage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see office.mjgl.pojo.TMjglPage
 * @author MyEclipse Persistence Tools
 */

public class TMjglPageDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TMjglPageDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String CHU = "chu";
	public static final String CURRENTAUTH = "currentauth";
	public static final String TEMPAUTH = "tempauth";
	public static final String TEMPTIME = "temptime";
	public static final String CURRENTTIME = "currenttime";
	public static final String REMARK = "remark";

	public void save(TMjglPage transientInstance) {
		log.debug("saving TMjglPage instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TMjglPage persistentInstance) {
		log.debug("deleting TMjglPage instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TMjglPage findById(java.lang.Integer id) {
		log.debug("getting TMjglPage instance with id: " + id);
		try {
			TMjglPage instance = (TMjglPage) getSession().get(
					"office.mjgl.TMjglPage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TMjglPage instance) {
		log.debug("finding TMjglPage instance by example");
		try {
			List results = getSession().createCriteria("office.mjgl.TMjglPage")
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
		log.debug("finding TMjglPage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TMjglPage as model where model."
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

	public List findByChu(Object chu) {
		return findByProperty(CHU, chu);
	}

	public List findByCurrentauth(Object currentauth) {
		return findByProperty(CURRENTAUTH, currentauth);
	}

	public List findByTempauth(Object tempauth) {
		return findByProperty(TEMPAUTH, tempauth);
	}

	public List findByTemptime(Object temptime) {
		return findByProperty(TEMPTIME, temptime);
	}

	public List findByCurrenttime(Object currenttime) {
		return findByProperty(CURRENTTIME, currenttime);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TMjglPage instances");
		try {
			String queryString = "from TMjglPage";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TMjglPage merge(TMjglPage detachedInstance) {
		log.debug("merging TMjglPage instance");
		try {
			TMjglPage result = (TMjglPage) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TMjglPage instance) {
		log.debug("attaching dirty TMjglPage instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TMjglPage instance) {
		log.debug("attaching clean TMjglPage instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public TMjglPage findAllByName(String name) {
    	log.debug("finding all TMjglPage instances");
    	try {
    		 String queryString = "from TMjglPage as tm where tm.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<TMjglPage> list = queryObject.list();
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