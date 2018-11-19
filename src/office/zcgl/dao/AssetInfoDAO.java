package office.zcgl.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.zcgl.pojo.AssetInfo;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AssetInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see office.zcgl.pojo.AssetInfo
 * @author MyEclipse Persistence Tools
 */

public class AssetInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AssetInfoDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String CHU = "chu";
	public static final String STATUS = "status";
	public static final String DATE = "date";
	public static final String REMARK = "remark";
	public static final String SN = "sn";
	public static final String PEOPLE = "people";
	public static final String NUMBER = "number";
	public static final String RETURNTIME = "returntime";
	public static final String ISWUPIN = "iswupin";
	public static final String AREA = "area";

	public void save(AssetInfo transientInstance) {
		log.debug("saving AssetInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AssetInfo persistentInstance) {
		log.debug("deleting AssetInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssetInfo findById(java.lang.Integer id) {
		log.debug("getting AssetInfo instance with id: " + id);
		try {
			AssetInfo instance = (AssetInfo) getSession().get(
					"office.zcgl.pojo.AssetInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AssetInfo instance) {
		log.debug("finding AssetInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"office.zcgl.pojo.AssetInfo").add(Example.create(instance))
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
		log.debug("finding AssetInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AssetInfo as model where model."
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

	public List findByChu(Object chu) {
		return findByProperty(CHU, chu);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findBySn(Object sn) {
		return findByProperty(SN, sn);
	}

	public List findByPeople(Object people) {
		return findByProperty(PEOPLE, people);
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findByReturntime(Object returntime) {
		return findByProperty(RETURNTIME, returntime);
	}

	public List findByIswupin(Object iswupin) {
		return findByProperty(ISWUPIN, iswupin);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findAll() {
		log.debug("finding all AssetInfo instances");
		try {
			String queryString = "from AssetInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AssetInfo merge(AssetInfo detachedInstance) {
		log.debug("merging AssetInfo instance");
		try {
			AssetInfo result = (AssetInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AssetInfo instance) {
		log.debug("attaching dirty AssetInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssetInfo instance) {
		log.debug("attaching clean AssetInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public AssetInfo findAllByNameAndTypeAndChu(String name,String type,int chu) {
    	log.debug("finding all AssetInfo instances");
    	try {
    		String queryString = "from AssetInfo as ai where ai.name='"+name+"'and ai.type='"+type+"'and ai.chu='"+chu+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<AssetInfo> list = queryObject.list();
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
	
	public List<AssetInfo> findAllByNameAndTypeAndChuAndStatus(String name,String type,int chu,int status) {
    	log.debug("finding all AssetInfo instances");
    	try {
    		String queryString = "from AssetInfo as ai where ai.name='"+name+"'and ai.type='"+type+"'and ai.chu='"+chu+"'and ai.status='"+status+"' order by ai.id";
             Query queryObject = getSession().createQuery(queryString);
             List<AssetInfo> list = queryObject.list();
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
	
	public AssetInfo findAllById(int id) {
    	log.debug("finding all AssetInfo instances");
    	try {
    		String queryString = "from AssetInfo as ai where ai.id='"+id+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<AssetInfo> list = queryObject.list();
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
	
	public AssetInfo findAllByNumber(String number) {
    	log.debug("finding all AssetInfo instances");
    	try {
    		String queryString = "from AssetInfo as ai where ai.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<AssetInfo> list = queryObject.list();
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
	
	
	public AssetInfo findAllByNumberAndChu(String number) {
    	log.debug("finding all AssetInfo instances");
    	try {
    		String queryString = "from AssetInfo as ai where ai.number='"+number+"' and ai.chu=7";
             Query queryObject = getSession().createQuery(queryString);
             List<AssetInfo> list = queryObject.list();
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
	
	
	public AssetInfo findAllByNumberAndChu(String number,int chu) {
    	log.debug("finding all AssetInfo instances");
    	try {
    		String queryString = "from AssetInfo as ai where ai.number='"+number+"' and ai.chu="+chu;
             Query queryObject = getSession().createQuery(queryString);
             List<AssetInfo> list = queryObject.list();
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
	
	public AssetInfo findAllByNumberAndAutho(String number,String authoR,String authoS) {
    	log.debug("finding all AssetInfo instances");
    	try {
    		String queryString="";
    		if(authoR.equals("R"))
    		{
    			queryString = "from AssetInfo as ai where ai.number='"+number+"' and ai.chu in (11,12)";
    		}
    		else if(authoS.equals("S"))
    		{
    			queryString = "from AssetInfo as ai where ai.number='"+number+"' and ai.chu in (13,14,15)";
    		}
    		
             Query queryObject = getSession().createQuery(queryString);
             List<AssetInfo> list = queryObject.list();
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