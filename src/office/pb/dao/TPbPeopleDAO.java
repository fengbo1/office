package office.pb.dao;

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.mycalendar.pojo.MyCalendar;
import office.pb.pojo.ScpbTable;
import office.pb.pojo.TPbPeople;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TPbPeople entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see office.pb.pojo.TPbPeople
 * @author MyEclipse Persistence Tools
 */

public class TPbPeopleDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TPbPeopleDAO.class);
	// property constants
	public static final String DATE = "date";
	public static final String WEEK = "week";
	public static final String NAME = "name";
	public static final String PLAN = "plan";
	public static final String ISREST = "isrest";

	public void save(TPbPeople transientInstance) {
		log.debug("saving TPbPeople instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TPbPeople persistentInstance) {
		log.debug("deleting TPbPeople instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TPbPeople findById(java.lang.Integer id) {
		log.debug("getting TPbPeople instance with id: " + id);
		try {
			TPbPeople instance = (TPbPeople) getSession().get(
					"office.pb.pojo.TPbPeople", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPbPeople instance) {
		log.debug("finding TPbPeople instance by example");
		try {
			List results = getSession().createCriteria(
					"office.pb.pojo.TPbPeople").add(Example.create(instance))
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
		log.debug("finding TPbPeople instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TPbPeople as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByWeek(Object week) {
		return findByProperty(WEEK, week);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPlan(Object plan) {
		return findByProperty(PLAN, plan);
	}

	public List findByIsrest(Object isrest) {
		return findByProperty(ISREST, isrest);
	}

	public List findAll() {
		log.debug("finding all TPbPeople instances");
		try {
			String queryString = "from TPbPeople";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<TPbPeople> findByBeginAndEnd(String begindate,String enddate) {
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "";
			
			 queryString = "from TPbPeople as tp where tp.date>='"+begindate+"' and tp.date<='"+enddate+"'";			
			 Query queryObject = getSession().createQuery(queryString);
			 List<TPbPeople> listpp = queryObject.list();
			 if(listpp.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return listpp;
             }
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
    public TPbPeople findFinal()
    {
    	try {
    		String queryString = "from TPbPeople as tb order by tb.id desc";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             } 
             else
             {
            	 return (TPbPeople) list.get(0);
             }
    		 
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

	public TPbPeople findByDateAndName(String date,String name) {
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "";
			
			 queryString = "from TPbPeople as tp where tp.date='"+date+"' and tp.name='"+name+"'";			
			 Query queryObject = getSession().createQuery(queryString);
			 List<TPbPeople> listtp = queryObject.list();
			 if(listtp.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return listtp.get(0);
             }
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	public void deleteByDate(String date,Session session) {
		log.debug("finding all MyCalendar instances");
		try {
			 String queryString = "";
			
			 queryString = "delete from t_pb_people where date='"+date+"'";			
			 session.createSQLQuery(queryString).executeUpdate();
			
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	public TPbPeople merge(TPbPeople detachedInstance) {
		log.debug("merging TPbPeople instance");
		try {
			TPbPeople result = (TPbPeople) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPbPeople instance) {
		log.debug("attaching dirty TPbPeople instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TPbPeople instance) {
		log.debug("attaching clean TPbPeople instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}