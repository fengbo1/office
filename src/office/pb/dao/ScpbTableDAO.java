package office.pb.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.pb.pojo.ScpbTable;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ScpbTable entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ScpbTable
  * @author MyEclipse Persistence Tools 
 */

public class ScpbTableDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ScpbTableDAO.class);
		//property constants
	public static final String MONTH = "month";
	public static final String TEAMNUM = "teamnum";
	public static final String PLANNUM = "plannum";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String TEAM1 = "team1";
	public static final String TEAM2 = "team2";
	public static final String TEAM3 = "team3";
	public static final String TEAM4 = "team4";
	public static final String TEAM5 = "team5";
	public static final String TEAM6 = "team6";
	public static final String TEAM7 = "team7";
	public static final String TEAM8 = "team8";
	public static final String TEAM9 = "team9";
	public static final String TEAM10 = "team10";
	public static final String TEAM11 = "team11";
	public static final String TEAM12 = "team12";
	public static final String TEAM13 = "team13";
	public static final String TEAM14 = "team14";
	public static final String TEAM15 = "team15";
	public static final String TEAM16 = "team16";
	public static final String TEAM17 = "team17";
	public static final String TEAM18 = "team18";
	public static final String TEAM19 = "team19";
	public static final String TEAM20 = "team20";
	public static final String TEAM21 = "team21";
	public static final String TEAM22 = "team22";
	public static final String TEAM23 = "team23";
	public static final String TEAM24 = "team24";
	public static final String TEAM25 = "team25";
	public static final String TEAM26 = "team26";
	public static final String TEAM27 = "team27";
	public static final String TEAM28 = "team28";
	public static final String TEAM29 = "team29";
	public static final String TEAM30 = "team30";
	public static final String DWB = "dwb";



    
    public void save(ScpbTable transientInstance) {
        log.debug("saving ScpbTable instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ScpbTable persistentInstance) {
        log.debug("deleting ScpbTable instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ScpbTable findById( java.lang.Integer id) {
        log.debug("getting ScpbTable instance with id: " + id);
        try {
            ScpbTable instance = (ScpbTable) getSession()
                    .get("ScpbTable", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ScpbTable instance) {
        log.debug("finding ScpbTable instance by example");
        try {
            List results = getSession()
                    .createCriteria("ScpbTable")
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
      log.debug("finding ScpbTable instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ScpbTable as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMonth(Object month
	) {
		return findByProperty(MONTH, month
		);
	}
	
	public List findByTeamnum(Object teamnum
	) {
		return findByProperty(TEAMNUM, teamnum
		);
	}
	
	public List findByPlannum(Object plannum
	) {
		return findByProperty(PLANNUM, plannum
		);
	}
	
	public List findByBegindate(Object begindate
	) {
		return findByProperty(BEGINDATE, begindate
		);
	}
	
	public List findByEnddate(Object enddate
	) {
		return findByProperty(ENDDATE, enddate
		);
	}
	
	public List findByTeam1(Object team1
	) {
		return findByProperty(TEAM1, team1
		);
	}
	
	public List findByTeam2(Object team2
	) {
		return findByProperty(TEAM2, team2
		);
	}
	
	public List findByTeam3(Object team3
	) {
		return findByProperty(TEAM3, team3
		);
	}
	
	public List findByTeam4(Object team4
	) {
		return findByProperty(TEAM4, team4
		);
	}
	
	public List findByTeam5(Object team5
	) {
		return findByProperty(TEAM5, team5
		);
	}
	
	public List findByTeam6(Object team6
	) {
		return findByProperty(TEAM6, team6
		);
	}
	
	public List findByTeam7(Object team7
	) {
		return findByProperty(TEAM7, team7
		);
	}
	
	public List findByTeam8(Object team8
	) {
		return findByProperty(TEAM8, team8
		);
	}
	
	public List findByTeam9(Object team9
	) {
		return findByProperty(TEAM9, team9
		);
	}
	
	public List findByTeam10(Object team10
	) {
		return findByProperty(TEAM10, team10
		);
	}
	
	public List findByTeam11(Object team11
	) {
		return findByProperty(TEAM11, team11
		);
	}
	
	public List findByTeam12(Object team12
	) {
		return findByProperty(TEAM12, team12
		);
	}
	
	public List findByTeam13(Object team13
	) {
		return findByProperty(TEAM13, team13
		);
	}
	
	public List findByTeam14(Object team14
	) {
		return findByProperty(TEAM14, team14
		);
	}
	
	public List findByTeam15(Object team15
	) {
		return findByProperty(TEAM15, team15
		);
	}
	
	public List findByTeam16(Object team16
	) {
		return findByProperty(TEAM16, team16
		);
	}
	
	public List findByTeam17(Object team17
	) {
		return findByProperty(TEAM17, team17
		);
	}
	
	public List findByTeam18(Object team18
	) {
		return findByProperty(TEAM18, team18
		);
	}
	
	public List findByTeam19(Object team19
	) {
		return findByProperty(TEAM19, team19
		);
	}
	
	public List findByTeam20(Object team20
	) {
		return findByProperty(TEAM20, team20
		);
	}
	
	public List findByTeam21(Object team21
	) {
		return findByProperty(TEAM21, team21
		);
	}
	
	public List findByTeam22(Object team22
	) {
		return findByProperty(TEAM22, team22
		);
	}
	
	public List findByTeam23(Object team23
	) {
		return findByProperty(TEAM23, team23
		);
	}
	
	public List findByTeam24(Object team24
	) {
		return findByProperty(TEAM24, team24
		);
	}
	
	public List findByTeam25(Object team25
	) {
		return findByProperty(TEAM25, team25
		);
	}
	
	public List findByTeam26(Object team26
	) {
		return findByProperty(TEAM26, team26
		);
	}
	
	public List findByTeam27(Object team27
	) {
		return findByProperty(TEAM27, team27
		);
	}
	
	public List findByTeam28(Object team28
	) {
		return findByProperty(TEAM28, team28
		);
	}
	
	public List findByTeam29(Object team29
	) {
		return findByProperty(TEAM29, team29
		);
	}
	
	public List findByTeam30(Object team30
	) {
		return findByProperty(TEAM30, team30
		);
	}
	
	public List findByDwb(Object dwb
	) {
		return findByProperty(DWB, dwb
		);
	}
	

	public List findAll() {
		log.debug("finding all ScpbTable instances");
		try {
			String queryString = "from ScpbTable";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ScpbTable merge(ScpbTable detachedInstance) {
        log.debug("merging ScpbTable instance");
        try {
            ScpbTable result = (ScpbTable) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ScpbTable instance) {
        log.debug("attaching dirty ScpbTable instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ScpbTable instance) {
        log.debug("attaching clean ScpbTable instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /**
     * 查询是否包含，
     * @param begindate
     * @param enddate
     * @param team
     * @return
     */
    public boolean findAllIfContain(String begindate,String enddate,int team) {
    	log.debug("finding all ScpbTable instances");
    	try {
    		String queryString = "from ScpbTable as st where st.team"+team+"="+team+
    				" and ((st.begindate<='"+begindate+"' and st.enddate>='"+begindate+"') " +
    				"or (st.begindate<='"+enddate+"' and st.enddate>='"+enddate+"') " +
    				"or (st.begindate>='"+begindate+"' and st.enddate<='"+enddate+"'))";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return false;
    		 }
    		 else
    		 {
    			 return true;
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public ScpbTable findAllByBeginEnd(String begin,String end) {
    	log.debug("finding all ScpbTable instances");
    	try {
    		String queryString = "from ScpbTable as st where st.begindate='"+begin+"' and st.enddate='"+end+"'";
            Query queryObject = getSession().createQuery(queryString);
            List<ScpbTable> list = queryObject.list();
            if(list.isEmpty())
            {
            	return new ScpbTable("",0,0,"","",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"");
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

    public List findAllByMonthOrderByBegin(String month) {
    	log.debug("finding all ScpbTable instances");
    	try {
    		String queryString = "from ScpbTable as st where st.month='"+month+"' order by st.begindate";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public ScpbTable findFinal()
    {
    	try {
    		String queryString = "from ScpbTable as st order by st.id desc";
             Query queryObject = getSession().createQuery(queryString);
             List list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             } 
             else
             {
            	 return (ScpbTable) list.get(0);
             }
    		 
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public ScpbTable findAllById(int id) {
    	log.debug("finding all ScpbTable instances");
    	try {
    		String queryString = "from ScpbTable as st where st.id="+id;
             Query queryObject = getSession().createQuery(queryString);
             List<ScpbTable> list = queryObject.list();
    		 return list.get(0);
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}