package office.tempxx.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.tempxx.pojo.TTempxiaxian;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TTempxiaxian entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see office.tempxx.pojo.TTempxiaxian
 * @author MyEclipse Persistence Tools
 */

public class TTempxiaxianDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TTempxiaxianDAO.class);
	// property constants
	public static final String CHU = "chu";
	public static final String OPZU = "opzu";
	public static final String NAME = "name";
	public static final String OPNUMBER = "opnumber";
	public static final String ZU = "zu";
	public static final String REASON = "reason";
	public static final String SHUOMING = "shuoming";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String REPORTDATE = "reportdate";
	public static final String REMARK = "remark";
	public static final String PAIBAN = "paiban";
	public static final String XIAXIANTIME = "xiaxiantime";
	public static final String RELATEDNUMBER = "relatednumber";
	public static final String ISRED = "isred";

	public void save(TTempxiaxian transientInstance) {
		log.debug("saving TTempxiaxian instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TTempxiaxian persistentInstance) {
		log.debug("deleting TTempxiaxian instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TTempxiaxian findById(java.lang.Integer id) {
		log.debug("getting TTempxiaxian instance with id: " + id);
		try {
			TTempxiaxian instance = (TTempxiaxian) getSession().get(
					"office.tempxx.pojo.TTempxiaxian", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TTempxiaxian instance) {
		log.debug("finding TTempxiaxian instance by example");
		try {
			List results = getSession().createCriteria(
					"office.tempxx.pojo.TTempxiaxian").add(
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
		log.debug("finding TTempxiaxian instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TTempxiaxian as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByChu(Object chu) {
		return findByProperty(CHU, chu);
	}

	public List findByOpzu(Object opzu) {
		return findByProperty(OPZU, opzu);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByOpnumber(Object opnumber) {
		return findByProperty(OPNUMBER, opnumber);
	}

	public List findByZu(Object zu) {
		return findByProperty(ZU, zu);
	}

	public List findByReason(Object reason) {
		return findByProperty(REASON, reason);
	}

	public List findByShuoming(Object shuoming) {
		return findByProperty(SHUOMING, shuoming);
	}

	public List findByBegindate(Object begindate) {
		return findByProperty(BEGINDATE, begindate);
	}

	public List findByEnddate(Object enddate) {
		return findByProperty(ENDDATE, enddate);
	}

	public List findByReportdate(Object reportdate) {
		return findByProperty(REPORTDATE, reportdate);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByPaiban(Object paiban) {
		return findByProperty(PAIBAN, paiban);
	}

	public List findByXiaxiantime(Object xiaxiantime) {
		return findByProperty(XIAXIANTIME, xiaxiantime);
	}

	public List findByRelatednumber(Object relatednumber) {
		return findByProperty(RELATEDNUMBER, relatednumber);
	}

	public List findByIsred(Object isred) {
		return findByProperty(ISRED, isred);
	}

	public List findAll() {
		log.debug("finding all TTempxiaxian instances");
		try {
			String queryString = "from TTempxiaxian";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TTempxiaxian merge(TTempxiaxian detachedInstance) {
		log.debug("merging TTempxiaxian instance");
		try {
			TTempxiaxian result = (TTempxiaxian) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TTempxiaxian instance) {
		log.debug("attaching dirty TTempxiaxian instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TTempxiaxian instance) {
		log.debug("attaching clean TTempxiaxian instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	 public TTempxiaxian findAllByNumber(String number) {
	    	log.debug("finding all TTempxiaxian instances");
	    	try {
	    		String queryString = "from TTempxiaxian as tt where tt.relatednumber='"+number+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TTempxiaxian> list = queryObject.list();
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
	 
	 public TTempxiaxian findAllByNumberandName(String number,String name) {
	    	log.debug("finding all TTempxiaxian instances");
	    	try {
	    		String queryString = "from TTempxiaxian as tt where tt.relatednumber='"+number+"' and tt.name='"+name+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TTempxiaxian> list = queryObject.list();
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

	 
	 public List<TTempxiaxian> findAlllistByNumber(String number) {
	    	log.debug("finding all TTempxiaxian instances");
	    	try {
	    		String queryString = "from TTempxiaxian as tt where tt.relatednumber='"+number+"'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TTempxiaxian> list = queryObject.list();
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
	 
	 public TTempxiaxian findDeleteByNumberandName(String number,String name) {
	    	log.debug("finding all TTempxiaxian instances");
	    	try {
	    		String queryString = "from TTempxiaxian as tt where tt.relatednumber='"+number+"' and tt.name='"+name+"' and tt.remark='已撤销'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TTempxiaxian> list = queryObject.list();
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
	 
	 
	 public TTempxiaxian findDeleteByNumber(String number) {
	    	log.debug("finding all TTempxiaxian instances");
	    	try {
	    		String queryString = "from TTempxiaxian as tt where tt.relatednumber='"+number+"' and tt.remark='已撤销'";
	             Query queryObject = getSession().createQuery(queryString);
	             List<TTempxiaxian> list = queryObject.list();
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