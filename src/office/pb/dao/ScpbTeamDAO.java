package office.pb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.pb.pojo.ScpbPlan;
import office.pb.pojo.ScpbTeam;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ScpbTeam entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ScpbTeam
  * @author MyEclipse Persistence Tools 
 */

public class ScpbTeamDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScpbTeamDAO.class);
		//property constants
	public static final String NO = "no";
	public static final String NUM = "num";
	public static final String LEADER = "leader";
	public static final String MEMBER = "member";



    
    public void save(ScpbTeam transientInstance) {
        log.debug("saving ScpbTeam instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ScpbTeam persistentInstance) {
        log.debug("deleting ScpbTeam instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ScpbTeam findById( java.lang.Integer id) {
        log.debug("getting ScpbTeam instance with id: " + id);
        try {
            ScpbTeam instance = (ScpbTeam) getSession()
                    .get("ScpbTeam", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ScpbTeam instance) {
        log.debug("finding ScpbTeam instance by example");
        try {
            List results = getSession()
                    .createCriteria("ScpbTeam")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ScpbTeam instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ScpbTeam as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNo(Object no
	) {
		return findByProperty(NO, no
		);
	}
	
	public List findByNum(Object num
	) {
		return findByProperty(NUM, num
		);
	}
	
	public List findByLeader(Object leader
	) {
		return findByProperty(LEADER, leader
		);
	}
	
	public List findByMember(Object member
	) {
		return findByProperty(MEMBER, member
		);
	}

	public List findAll() {
		log.debug("finding all ScpbTeam instances");
		try {
			String queryString = "from ScpbTeam";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ScpbTeam merge(ScpbTeam detachedInstance) {
        log.debug("merging ScpbTeam instance");
        try {
            ScpbTeam result = (ScpbTeam) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ScpbTeam instance) {
        log.debug("attaching dirty ScpbTeam instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ScpbTeam instance) {
        log.debug("attaching clean ScpbTeam instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public List findAllMaxNum() {
		log.debug("finding all ScpbTeam instances");
		try {
			String sql = "select max(num) from t_scpb_team";
			String maxnum = getSession().createSQLQuery(sql).uniqueResult().toString();
			String queryString = "from ScpbTeam as st where st.num="+maxnum;
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public List findAllBiggestTeam() {
		log.debug("finding all ScpbTeam instances");
		try {
			String sql = "select max(no) from t_scpb_team";
			String maxno = getSession().createSQLQuery(sql).uniqueResult().toString();
			String queryString = "from ScpbTeam as st where st.no="+maxno;
	        Query queryObject = getSession().createQuery(queryString);
	        ScpbTeam st = (ScpbTeam) queryObject.list().get(0);
	        queryString = "from ScpbTeam as st where st.num="+st.getNum();
	        queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    public List findAllOrderByNo(int num) {
    	log.debug("finding all ScpbTeam instances");
    	try {
    		String queryString = "from ScpbTeam as st where st.num="+num+" order by st.no";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllWithOutNo(int no,int num) {
    	log.debug("finding all ScpbTeam instances");
    	try {
    		String queryString = "from ScpbTeam as st where st.num="+num+" and st.no!="+no;
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllWithOutNoAndOld(int no,int oldno,int num) {
    	log.debug("finding all ScpbTeam instances");
    	try {
    		String queryString = "from ScpbTeam as st where st.num="+num+" and st.no!="+oldno+" and st.no!="+no;
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public ScpbTeam findAllMaxNumByNo(int no) {
    	log.debug("finding all ScpbTeam instances");
    	try {
    		String queryString = "from ScpbTeam as st where st.no="+no+" order by st.num desc";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbTeam) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    
    public List<ScpbTeam> findAllItemMaxNum(int num) {
    	log.debug("finding all ScpbTeam instances");
    	try {
    		String queryString = "from ScpbTeam as st where st.num="+num+" order by st.no";
             Query queryObject = getSession().createQuery(queryString);
             List<ScpbTeam> list = queryObject.list();
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
    
    public ScpbTeam findMaxNum() {
    	log.debug("finding all ScpbTeam instances");
    	try {
    		String queryString = "from ScpbTeam as st order by st.num desc";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbTeam) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public ScpbTeam findAllByNoAndNum(int no,int num){
    	log.debug("finding all ScpbTeam instances");
    	try {
    		String queryString = "from ScpbTeam as st where st.no="+no+" and st.num="+num;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbTeam) list.get(0);
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public ScpbTeam findAllByID(int id) {
    	log.debug("finding all ScpbTeam instances");
    	try {
    		String queryString = "from ScpbTeam as st where st.id="+id;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return (ScpbTeam) list.get(0);
             }
    		
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}