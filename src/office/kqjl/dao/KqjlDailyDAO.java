package office.kqjl.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.kqjl.pojo.KqjlDaily;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for KqjlDaily entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .KqjlDaily
  * @author MyEclipse Persistence Tools 
 */

public class KqjlDailyDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(KqjlDailyDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String WEEK = "week";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String POSITION = "position";
	public static final String PBQDTIME = "pbqdtime";
	public static final String PBQTTIME = "pbqttime";
	public static final String QDTIME = "qdtime";
	public static final String QTTIME = "qttime";
	public static final String QDQS = "qdqs";
	public static final String QTQS = "qtqs";
	public static final String QJ = "qj";
	public static final String GG = "gg";
	public static final String JB = "jb";
	public static final String HALFDAY = "halfday";
	public static final String TB = "tb";
	public static final String PB = "pb";
	public static final String YC = "yc";
	public static final String YY = "yy";



    
    public void save(KqjlDaily transientInstance) {
        log.debug("saving KqjlDaily instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(KqjlDaily persistentInstance) {
        log.debug("deleting KqjlDaily instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public KqjlDaily findById( java.lang.Integer id) {
        log.debug("getting KqjlDaily instance with id: " + id);
        try {
            KqjlDaily instance = (KqjlDaily) getSession()
                    .get("KqjlDaily", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(KqjlDaily instance) {
        log.debug("finding KqjlDaily instance by example");
        try {
            List results = getSession()
                    .createCriteria("KqjlDaily")
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
      log.debug("finding KqjlDaily instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from KqjlDaily as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByWeek(Object week
	) {
		return findByProperty(WEEK, week
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByPbqdtime(Object pbqdtime
	) {
		return findByProperty(PBQDTIME, pbqdtime
		);
	}
	
	public List findByPbqttime(Object pbqttime
	) {
		return findByProperty(PBQTTIME, pbqttime
		);
	}
	
	public List findByQdtime(Object qdtime
	) {
		return findByProperty(QDTIME, qdtime
		);
	}
	
	public List findByQttime(Object qttime
	) {
		return findByProperty(QTTIME, qttime
		);
	}
	
	public List findByQdqs(Object qdqs
	) {
		return findByProperty(QDQS, qdqs
		);
	}
	
	public List findByQtqs(Object qtqs
	) {
		return findByProperty(QTQS, qtqs
		);
	}
	
	public List findByQj(Object qj
	) {
		return findByProperty(QJ, qj
		);
	}
	
	public List findByGg(Object gg
	) {
		return findByProperty(GG, gg
		);
	}
	
	public List findByJb(Object jb
	) {
		return findByProperty(JB, jb
		);
	}
	
	public List findByHalfday(Object halfday
	) {
		return findByProperty(HALFDAY, halfday
		);
	}
	
	public List findByTb(Object tb
	) {
		return findByProperty(TB, tb
		);
	}
	
	public List findByPb(Object pb
	) {
		return findByProperty(PB, pb
		);
	}
	
	public List findByYc(Object yc
	) {
		return findByProperty(YC, yc
		);
	}
	
	public List findByYy(Object yy
	) {
		return findByProperty(YY, yy
		);
	}
	

	public List findAll() {
		log.debug("finding all KqjlDaily instances");
		try {
			String queryString = "from KqjlDaily";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public KqjlDaily merge(KqjlDaily detachedInstance) {
        log.debug("merging KqjlDaily instance");
        try {
            KqjlDaily result = (KqjlDaily) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(KqjlDaily instance) {
        log.debug("attaching dirty KqjlDaily instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(KqjlDaily instance) {
        log.debug("attaching clean KqjlDaily instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    /**
     * 根据日期和姓名查询,是否有记录，1有0无
     * @param date
     * @param name
     * @return
     */
    public int findByDateAndNameAll(String date,String name) {
    	log.debug("finding all KqjlDaily instances");
    	try {
    		String queryString = "from KqjlDaily as kd where kd.date='"+date+"' and kd.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<KqjlDaily> list = queryObject.list();
             if(list.isEmpty())
             {//初始化考勤记录，默认正常考勤时间
            	 return 0;
             }
             else
             {
            	 return 1;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 根据日期和姓名查询
     * @param date
     * @param name
     * @return
     */
    public KqjlDaily findByDateAndName(String date,String name) {
    	log.debug("finding all KqjlDaily instances");
    	try {
    		String queryString = "from KqjlDaily as kd where kd.date='"+date+"' and kd.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<KqjlDaily> list = queryObject.list();
             if(list.isEmpty())
             {//初始化考勤记录，默认正常考勤时间
            	 return new KqjlDaily(date, 0, name, "","",Util.zcqd,Util.zcqt,"","",0,0,0,0,0,0,0,0,0,0);
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
    /**
     * 根据日期和姓名查询(排班月专用)
     * @param date
     * @param name
     * @return
     */
    public KqjlDaily findByDateAndNameForPb(String date,String name) {
    	log.debug("finding all KqjlDaily instances");
    	try {
    		UserInfoDAO uidao = new UserInfoDAO();
    		String queryString = "from KqjlDaily as kd where kd.date='"+date+"' and kd.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<KqjlDaily> list = queryObject.list();
             if(list.isEmpty())
             {//初始化考勤记录，默认正常考勤时间
            	 UserInfo ui = uidao.findByName(name);
            	 KqjlDaily kd = new KqjlDaily(date, 0, name, "","","","","","",0,0,0,0,0,0,0,0,0,0);
            	 if(ui!=null)
            	 {
            		 kd.setNewnumber(ui.getNewnumber());
                	 kd.setPosition(ui.getPosition());
            	 }
            	 return kd;
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
    /**
     * 根据日期和姓名查询
     * @param date
     * @param name
     * @return
     */
    public KqjlDaily findByDateAndNameNull(String date,String name) {
    	log.debug("finding all KqjlDaily instances");
    	try {
    		String queryString = "from KqjlDaily as kd where kd.date='"+date+"' and kd.name='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<KqjlDaily> list = queryObject.list();
             if(list.isEmpty())
             {//初始化考勤记录，默认正常考勤时间
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
    /**
     * 查询当月所有记录
     * @param month
     * @param name
     * @return
     */
    public List findAllByMonthAndName(String month,String name) {
    	log.debug("finding all KqjlImport instances");
    	try {
    		String queryString = "from KqjlDaily as kd where kd.date>='"+month+"01' and kd.date<='"+month+"31' and kd.name='"+name+"' order by kd.date";
             Query queryObject = getSession().createQuery(queryString);
             return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 查询当月所有记录
     * @param month
     * @param name
     * @return
     */
    public List findAllWorkDayByMonthAndName(String month,String name) {
    	log.debug("finding all KqjlImport instances");
    	try {
    		String queryString = "from KqjlDaily as kd where kd.date>='"+month+"01' and kd.date<='"+month+"31' and kd.pbqdtime>'00:00:00' and kd.pbqttime>'00:00:00' and kd.name='"+name+"' order by kd.date";
             Query queryObject = getSession().createQuery(queryString);
             return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 查询当月所有记录
     * @param month
     * @param name
     * @return
     */
    public List findAllByMonth(String month) {
    	log.debug("finding all KqjlImport instances");
    	try {
    		String queryString = "from KqjlDaily as kd where kd.date>='"+month+"01' and kd.date<='"+month+"31' order by kd.date";
             Query queryObject = getSession().createQuery(queryString);
             return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public KqjlDaily findAllByID(int id) {
    	log.debug("finding all KqjlImport instances");
    	try {
    		String queryString = "from KqjlDaily as kd where kd.id="+id;
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(!list.isEmpty())
             {
            	 KqjlDaily kd = (KqjlDaily) list.get(0);
            	 return kd;
             }
             else
             {
            	 return null;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 查询当月所有记录
     * @param month
     * @param name
     * @param pb
     * @return
     */
    public List findAllByPb(String month,String name) {
    	log.debug("finding all KqjlImport instances");
    	try {
    		String queryString = "from KqjlDaily as kd where kd.date>='"+month+"01' and kd.date<='"+month+"31' and kd.name='"+name+"' and kd.pb=1";
             Query queryObject = getSession().createQuery(queryString);
             return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 查询当月所有记录
     * @param month
     * @param name
     * @param pb
     * @return
     */
    public double findDaysByQjType(String month,String name,int type) {
    	log.debug("finding all KqjlImport instances");
    	double result = 0.0;
    	try {
//    		String tempsql = "select count(*) from t_kqjl_daily where date>='"+month+"01' and date<='"+month+"31' and name='"+name+"' and halfday=0 and qj="+type;
//    		int wz = Integer.parseInt(getSession().createSQLQuery(tempsql).uniqueResult().toString());
    		String tempsql = "select count(*) from t_kqjl_daily where date>='"+month+"01' and date<='"+month+"31' and name='"+name+"' and qdqs=4 and qj="+type;
    		int sw = Integer.parseInt(getSession().createSQLQuery(tempsql).uniqueResult().toString());
    		tempsql = "select count(*) from t_kqjl_daily where date>='"+month+"01' and date<='"+month+"31' and name='"+name+"' and qtqs=4 and qj="+type;
    		int xw = Integer.parseInt(getSession().createSQLQuery(tempsql).uniqueResult().toString());
    		result =(double)sw/2+(double)xw/2;
    		return result;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
 
}