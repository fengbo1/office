package office.zcgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import office.zcgl.pojo.AssetTemp;
/**
 * A data access object (DAO) providing persistence and search support for
 * AssetTemp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see office.zcgl.pojo.AssetTemp
 * @author MyEclipse Persistence Tools
 */

public class AssetTempDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AssetTempDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String NUMBER = "number";
	public static final String NUM = "num";

	public void save(AssetTemp transientInstance) {
		log.debug("saving AssetTemp instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AssetTemp persistentInstance) {
		log.debug("deleting AssetTemp instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssetTemp findById(java.lang.Integer id) {
		log.debug("getting AssetTemp instance with id: " + id);
		try {
			AssetTemp instance = (AssetTemp) getSession().get(
					"office.zcgl.pojo.AssetTemp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AssetTemp instance) {
		log.debug("finding AssetTemp instance by example");
		try {
			List results = getSession().createCriteria(
					"office.zcgl.pojo.AssetTemp").add(Example.create(instance))
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
		log.debug("finding AssetTemp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AssetTemp as model where model."
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

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List findAll() {
		log.debug("finding all AssetTemp instances");
		try {
			String queryString = "from AssetTemp";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AssetTemp merge(AssetTemp detachedInstance) {
		log.debug("merging AssetTemp instance");
		try {
			AssetTemp result = (AssetTemp) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AssetTemp instance) {
		log.debug("attaching dirty AssetTemp instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssetTemp instance) {
		log.debug("attaching clean AssetTemp instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	 public List<AssetTemp> findAllByNumber(String number) {
	    	log.debug("finding all AssetTemp instances");
	    	try {
	    		String queryString = "from AssetTemp as ap where ap.number='"+number+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<AssetTemp> list = queryObject.list();
	             if(list.isEmpty())
	             {
	            	 return null;
	             }
	             else
	             {
	            	 return list;
	             }
	    	} catch (RuntimeException re) {
	    		log.error("find all failed", re);
	    		throw re;
	    	}
	    }
	    
		public List<AssetTemp> findAllByNameAndTypeAndChuAndStatus(String name,String type,int chu,int status) {
	    	log.debug("finding all AssetTemp instances");
	    	try {
	    		String queryString = "from AssetTemp as ap where ap.name='"+name+"'and ap.type='"+type+"'and ap.chu='"+chu+"'and ap.status='"+status+"' order by ap.returntime";
	             Query queryObject = getSession().createQuery(queryString);
	             List<AssetTemp> list = queryObject.list();
	             if(list.isEmpty())
	             {
	            	 return null;
	             }
	             else
	             {
	            	 return list;
	             }
	    	} catch (RuntimeException re) {
	    		log.error("find all failed", re);
	    		throw re;
	    	}
	    }
}