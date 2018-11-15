package office.uass.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostHnPeople;
import office.uass.pojo.UassPt;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UassCostHn entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UassCostHn
  * @author MyEclipse Persistence Tools 
 */

public class UassCostHnDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UassCostHnDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDERTAKE = "preundertake";
	public static final String UNDERTAKE = "undertake";
	public static final String INITIATOR = "initiator";
	public static final String APPLICANT = "applicant";
	public static final String POSITION = "position";
	public static final String TEL = "tel";
	public static final String SXTIME = "sxtime";
	public static final String REMARK = "remark";



    
    public void save(UassCostHn transientInstance) {
        log.debug("saving UassCostHn instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UassCostHn persistentInstance) {
        log.debug("deleting UassCostHn instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UassCostHn findById( java.lang.Integer id) {
        log.debug("getting UassCostHn instance with id: " + id);
        try {
            UassCostHn instance = (UassCostHn) getSession()
                    .get("UassCostHn", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UassCostHn instance) {
        log.debug("finding UassCostHn instance by example");
        try {
            List results = getSession()
                    .createCriteria("UassCostHn")
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
      log.debug("finding UassCostHn instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UassCostHn as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	
	public List findByProcess(Object process
	) {
		return findByProperty(PROCESS, process
		);
	}
	
	public List findByJindu(Object jindu
	) {
		return findByProperty(JINDU, jindu
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findByPreundertake(Object preundertake
	) {
		return findByProperty(PREUNDERTAKE, preundertake
		);
	}
	
	public List findByUndertake(Object undertake
	) {
		return findByProperty(UNDERTAKE, undertake
		);
	}
	
	public List findByInitiator(Object initiator
	) {
		return findByProperty(INITIATOR, initiator
		);
	}
	
	public List findByApplicant(Object applicant
	) {
		return findByProperty(APPLICANT, applicant
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findBySxtime(Object sxtime
	) {
		return findByProperty(SXTIME, sxtime
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all UassCostHn instances");
		try {
			String queryString = "from UassCostHn";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UassCostHn merge(UassCostHn detachedInstance) {
        log.debug("merging UassCostHn instance");
        try {
            UassCostHn result = (UassCostHn) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UassCostHn instance) {
        log.debug("attaching dirty UassCostHn instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UassCostHn instance) {
        log.debug("attaching clean UassCostHn instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /**
     * 
     * @param number
     * @return
     */
    public UassCostHn findAllByNumber(String number) {
		log.debug("finding all UassCostHn instances");
		try {
			String queryString = "from UassCostHn as uch where uch.number='"+number+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 List<UassCostHn> list = queryObject.list();
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
    
    public String submitUassCostHn(String number)
    {
    	try {
    		UserInfoDAO uidao = new UserInfoDAO();
    		UassCostHnPeopleDAO uchpdao = new UassCostHnPeopleDAO();
    		List<UassCostHnPeople> list = uchpdao.findAllByNumber(number);
    		for(int i=0;i<list.size();i++)
    		{
    			UassCostHnPeople uchp = list.get(i);
    			UserInfo ui = uidao.findByName(uchp.getName());
    			if(ui!=null)
    			{
    				if(uchp.getPool().contains("891"))
    				{
    					if(uchp.getType891()==1)//注销
    					{
    						//ui.setRole891("0000000000000000000000000000000000000000");
    						if(uchp.getContent891().contains("生效"))
    						{
    							ui.setStatus891(1);
    						}
    						else
    						{
    							ui.setStatus891(0);
    						}
    						
    					}
    					else if(uchp.getType891()==2)//修改
    					{
    						ui.setRole891(uchp.getItem891af());
    					}
    					else if(uchp.getType891()==3)	//新增
    					{
    						ui.setRole891(uchp.getItem891af());
    						ui.setStatus891(1);
    					}
    				}
    				if(uchp.getPool().contains("890"))
    				{
    					if(uchp.getType890()==1)//注销
    					{
    						//ui.setRole890("0000000000000000000000000000000000000000");
    						if(uchp.getContent890().contains("生效"))
    						{
    							ui.setStatus890(1);
    						}
    						else
    						{
    							ui.setStatus890(0);
    						}
    					}
    					else if(uchp.getType890()==2)//修改
    					{
    						ui.setRole890(uchp.getItem890af());
    					}
    					else if(uchp.getType890()==3)	//新增
    					{
    						ui.setRole890(uchp.getItem890af());
    						ui.setStatus890(1);
    					}
    				}
    				uidao.merge(ui);
    			}
    		}
    		
    	} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
    	
    	return "success";
    }
}