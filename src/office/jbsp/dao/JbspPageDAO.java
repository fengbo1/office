package office.jbsp.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.jbsp.pojo.JbspPage;
import office.jbsp.pojo.JbspPageDi;
import office.jbsp.pojo.JbspSummary;
import office.leave.dao.LeaveSummaryDAO;
import office.leave.pojo.LeaveSummary;
import office.mycalendar.dao.MyCalendarDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for JbspPage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .JbspPage
  * @author MyEclipse Persistence Tools 
 */

public class JbspPageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(JbspPageDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDER = "preunder";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String APPLICANT = "applicant";
	public static final String PEOPLE = "people";
	public static final String CHU = "chu";
	public static final String ZU = "zu";
	public static final String TEL = "tel";
	public static final String REASON = "reason";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String HALFDAY = "halfday";
	public static final String DAYS = "days";
	public static final String JBDAYS = "jbdays";
	public static final String DIDAYS = "didays";
	public static final String REMARK = "remark";



    
    public void save(JbspPage transientInstance) {
        log.debug("saving JbspPage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(JbspPage persistentInstance) {
        log.debug("deleting JbspPage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public JbspPage findById( java.lang.Integer id) {
        log.debug("getting JbspPage instance with id: " + id);
        try {
            JbspPage instance = (JbspPage) getSession()
                    .get("JbspPage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(JbspPage instance) {
        log.debug("finding JbspPage instance by example");
        try {
            List results = getSession()
                    .createCriteria("JbspPage")
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
      log.debug("finding JbspPage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JbspPage as model where model." 
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
	
	public List findByPreunder(Object preunder
	) {
		return findByProperty(PREUNDER, preunder
		);
	}
	
	public List findByThisunder(Object thisunder
	) {
		return findByProperty(THISUNDER, thisunder
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
	
	public List findByPeople(Object people
	) {
		return findByProperty(PEOPLE, people
		);
	}
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	
	public List findByZu(Object zu
	) {
		return findByProperty(ZU, zu
		);
	}
	
	public List findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
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
	
	public List findByHalfday(Object halfday
	) {
		return findByProperty(HALFDAY, halfday
		);
	}
	
	public List findByDays(Object days
	) {
		return findByProperty(DAYS, days
		);
	}
	
	public List findByJbdays(Object jbdays
	) {
		return findByProperty(JBDAYS, jbdays
		);
	}
	
	public List findByDidays(Object didays
	) {
		return findByProperty(DIDAYS, didays
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all JbspPage instances");
		try {
			String queryString = "from JbspPage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public JbspPage merge(JbspPage detachedInstance) {
        log.debug("merging JbspPage instance");
        try {
            JbspPage result = (JbspPage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(JbspPage instance) {
        log.debug("attaching dirty JbspPage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(JbspPage instance) {
        log.debug("attaching clean JbspPage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public List findAllByDate(String date) {
    	log.debug("finding all JbspPage instances");
    	try {
    		String queryString = "from JbspPage as jp where jp.date='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllByNameAndDate(String name,String date) {
    	log.debug("finding all JbspPage instances");
    	try {
    		String queryString = "from JbspPage as jp where jp.people like '%"+name+"%' and jp.status=4 and jp.begindate<='"+date+"' and jp.enddate>='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public JbspPage findAllByNumber(String number) {
    	log.debug("finding all WcggPage instances");
    	try {
    		String queryString = "from JbspPage as jp where jp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<JbspPage> list = queryObject.list();
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
    /**
     * 提交审批表，更新汇总表
     * @param nummber
     * @return
     */
    public String submitJbspPage(String number)
    {
    	JbspPageDAO jpdao = new JbspPageDAO();
    	UserInfoDAO uidao = new UserInfoDAO();
    	JbspPageDiDAO jpddao = new JbspPageDiDAO();
    	//JbspSummaryDAO jsdao = new JbspSummaryDAO();
    	MyCalendarDAO mcdao = new MyCalendarDAO();
    	//LeaveSummaryDAO lsdao = new LeaveSummaryDAO();
    	JbspPage jp = jpdao.findAllByNumber(number);
//    	String year = jp.getBegindate().substring(0, 4);
    	String[] people = jp.getPeople().split("、");
//    	double jbdays = mcdao.findJbdaysByBeginAndEnd(jp.getBegindate(),jp.getEnddate(),jp.getHalfday());
    	for(int i=0;i<people.length;i++)
    	{
//    		UserInfo tempui = uidao.findByName(people[i]);
    		JbspPageDi jpd = jpddao.findAllByNumberName(number, people[i]);
 //   		String tempnewnumber = tempui.getNewnumber();
//    		JbspSummary js = jsdao.findAllByYearAndNewNumber(year,tempnewnumber);
//    		LeaveSummary ls = lsdao.findByYearAndNewnumber(Integer.parseInt(year), tempnewnumber);
//    		if(js==null)
//    		{
//    			js = new JbspSummary(Integer.parseInt(year),tempui.getUsername(), tempui.getNewnumber(),tempui.getPosition(), 0, 0.0, 0.0, "");
//    		}
//    		if(ls==null)
//    		{
//    			ls = new LeaveSummary(Integer.parseInt(year), tempui.getUsername(), tempui.getNewnumber(),tempui.getPosition(),5.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.0,0.0,0.0, 0.0, 0.0, 0.0, 0.0, "");
//    		}
//    		js.setTimes(js.getTimes()+1);
//    		//js.setDays(js.getDays()+jp.getDays());  1:1
//    		js.setDays(js.getDays()+jbdays);   //1:2
//    		//ls.setWorkrest(ls.getWorkrest()+jp.getDays());  1:1
//    		ls.setWorkrest(ls.getWorkrest()+jbdays); //1:2
    		//jsdao.merge(js);20170120修改加班调休计算方法，不需要改动js和ls表
    		//lsdao.merge(ls);
    		jpd.setBegindate(jp.getBegindate());
    		jpd.setEnddate(jp.getEnddate());
    		jpd.setDays(jp.getDays());
    		jpd.setJbdays(jp.getDays());
    		jpd.setDidays(0.0);
    		jpddao.merge(jpd);
    	}
    	String message = "success";
    	return message;
    }
    /**
     * 提交审批表，更新汇总表(反向操作)
     * @param nummber
     * @return
     */
    public String unsubmitJbspPage(String number,Session session)
    {
    	JbspPageDAO jpdao = new JbspPageDAO();
    	UserInfoDAO uidao = new UserInfoDAO();
    	MyCalendarDAO mcdao = new MyCalendarDAO();
    	JbspSummaryDAO jsdao = new JbspSummaryDAO();
    	LeaveSummaryDAO lsdao = new LeaveSummaryDAO();
    	JbspPage jp = jpdao.findAllByNumber(number);
    	String year = jp.getBegindate().substring(0, 4);
    	String[] people = jp.getPeople().split("、");
    	double jbdays = mcdao.findJbdaysByBeginAndEnd(jp.getBegindate(),jp.getEnddate(),jp.getHalfday());
    	String sql = "delete from t_jbsp_page_di where number='"+number+"'";
    	session.createSQLQuery(sql).executeUpdate();
    	for(int i=0;i<people.length;i++)
    	{
    		UserInfo tempui = uidao.findByName(people[i]);
    		String tempnewnumber = tempui.getNewnumber();
    		JbspSummary js = jsdao.findAllByYearAndNewNumber(year,tempnewnumber);
    		LeaveSummary ls = lsdao.findByYearAndNewnumber(Integer.parseInt(year), tempnewnumber);
    		js.setTimes(js.getTimes()-1);
    		//js.setDays(js.getDays()-jp.getDays()); 1:1
    		js.setDays(js.getDays()-jbdays);   //1:2
    		//ls.setWorkrest(ls.getWorkrest()-jp.getDays());  1:1
    		ls.setWorkrest(ls.getWorkrest()-jbdays);  //1:2
    		jsdao.merge(js);
    		lsdao.merge(ls);
    	}
    	String message = "success";
    	return message;
    }
}