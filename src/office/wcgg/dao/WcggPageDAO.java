package office.wcgg.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import office.mycalendar.dao.MyCalendarDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.wcgg.pojo.WcggBaodao;
import office.wcgg.pojo.WcggPage;
import office.wcgg.pojo.WcggSummary;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for WcggPage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WcggPage
  * @author MyEclipse Persistence Tools 
 */

public class WcggPageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WcggPageDAO.class);
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
	public static final String ADDR = "addr";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String HALFDAY = "halfday";
	public static final String DAYS = "days";
	public static final String VIEW = "view";
	public static final String REMARK = "remark";



    
    public void save(WcggPage transientInstance) {
        log.debug("saving WcggPage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WcggPage persistentInstance) {
        log.debug("deleting WcggPage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WcggPage findById( java.lang.Integer id) {
        log.debug("getting WcggPage instance with id: " + id);
        try {
            WcggPage instance = (WcggPage) getSession()
                    .get("WcggPage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WcggPage instance) {
        log.debug("finding WcggPage instance by example");
        try {
            List results = getSession()
                    .createCriteria("WcggPage")
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
      log.debug("finding WcggPage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WcggPage as model where model." 
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
	
	public List findByAddr(Object addr
	) {
		return findByProperty(ADDR, addr
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
	
	public List findByView(Object view
	) {
		return findByProperty(VIEW, view
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all WcggPage instances");
		try {
			String queryString = "from WcggPage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WcggPage merge(WcggPage detachedInstance) {
        log.debug("merging WcggPage instance");
        try {
            WcggPage result = (WcggPage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WcggPage instance) {
        log.debug("attaching dirty WcggPage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WcggPage instance) {
        log.debug("attaching clean WcggPage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public List findAllByDate(String date) {
    	log.debug("finding all WcggPage instances");
    	try {
    		String queryString = "from WcggPage as wp where wp.date='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 根据日期和姓名查询
     * 已办结
     * @param name
     * @param date
     * @return
     */
    public List findAllByNameAndDate(String name,String date) {
    	log.debug("finding all WcggPage instances");
    	try {
    		String queryString = "from WcggPage as wp where wp.people like '%"+name+"%' and wp.status in (1,2,3,4) and wp.begindate<='"+date+"' and wp.enddate>='"+date+"'";
            Query queryObject = getSession().createQuery(queryString);
    		return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 根据出发日期≤查询日期≤报道日期,查询有无wcgg的WcggPage
     * @param name
     * @param date
     * @return
     */
    public WcggPage findAllByNameAndDateFromBegindateAndBaodaodate(String name,String date) {
    	log.debug("finding all WcggPage instances");
    	try {
    		WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
    		String queryString = "from WcggPage as wp where wp.people like '%"+name+"%' and wp.status in (3,4) and wp.begindate<='"+date+"' order by wp.begindate desc";
            Query queryObject = getSession().createQuery(queryString);
    		List<WcggPage> list = queryObject.list();
    		WcggPage wcgg = new WcggPage();
    		if(!list.isEmpty())
    		{
    			wcgg = list.get(0);
    			WcggBaodao wcggbd = wbdao.findAllByNumberAndName(wcgg.getNumber(),name);
    			if(wcggbd!=null)//查询外出公干报到
    			{
    				String baodaodate = wcggbd.getBaodaodate().replace("-", "");
    				if(baodaodate.equals(""))//未报到
    				{
    					return wcgg;
    				}
    				else if(baodaodate.compareTo(date)>=0)//已报到并且报到时间晚于查询时间
    				{
    					return wcgg;
    				}
    				else//已报到并且报到时间早于查询时间,返回空
    				{
    					return null;
    				}
    			}
    			else
    			{
    				return null;
    			}
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
    public WcggPage findAllByNumber(String number) {
    	log.debug("finding all WcggPage instances");
    	try {
    		String queryString = "from WcggPage as wp where wp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<WcggPage> list = queryObject.list();
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
    public String submitWcggPage(String number)
    {
    	WcggPageDAO wpdao = new WcggPageDAO();
    	UserInfoDAO uidao = new UserInfoDAO();
    	MyCalendarDAO mcdao = new MyCalendarDAO();
    	WcggSummaryDAO wsdao = new WcggSummaryDAO();
    	DateUtil du = new DateUtil();
    	WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
    	WcggPage wp = wpdao.findAllByNumber(number);
    	List<WcggBaodao> listwb = wbdao.findAllByNumber(number);
    	String message = "";
    	String begindate = wp.getBegindate();
    	String enddate = wp.getEnddate();
    	double predays = 0;
    	int beginyear = Integer.parseInt(begindate.substring(0, 4));
    	int endyear = Integer.parseInt(enddate.substring(0, 4));
    	if(beginyear==endyear)//起止年份同一年
    	{
    		for(int i=0;i<listwb.size();i++)//根据报道情况表更新公干汇总表
    		{
    			WcggBaodao wb = listwb.get(i);
    			UserInfo ui = uidao.findByNewNumber(wb.getNewnumber());
    			WcggSummary ws = wsdao.findAllByNewNumberAndYear(wb.getNewnumber(), begindate.substring(0, 4));
    			if(ws==null)
    			{
    				ws = new WcggSummary(wb.getName(), begindate.substring(0, 4), wb.getNewnumber(),ui.getPosition().substring(2,3), ui.getPosition().substring(4,5),1, wp.getDays(), "");
    			}
    			else
    			{
    				ws.setDays(ws.getDays()+wp.getDays());
    				ws.setTimes(ws.getTimes()+1);
    			}
    			wb.setStatus(1);
    			wsdao.merge(ws);
    			wbdao.merge(wb);
    		}
    	}
    	else if(beginyear<endyear)//跨年的情况
    	{
    		String tempdate = begindate;
    		for(int i=beginyear;i<endyear;)
    		{
    			if(mcdao.ifWorkDay(tempdate))
    			{
    				predays+=1;
    			}
    			tempdate = du.getNextDay(tempdate);
    			i=Integer.parseInt(tempdate.substring(0,4));
    		}
    		for(int i=0;i<listwb.size();i++)//根据报道情况表更新公干汇总表
    		{
    			WcggBaodao wb = listwb.get(i);
    			UserInfo ui = uidao.findByNewNumber(wb.getNewnumber());
    			WcggSummary prews = wsdao.findAllByNewNumberAndYear(wb.getNewnumber(), begindate.substring(0, 4));
    			WcggSummary aftws = wsdao.findAllByNewNumberAndYear(wb.getNewnumber(), enddate.substring(0, 4));
    			if(prews==null)
    			{
    				prews = new WcggSummary(wb.getName(), begindate.substring(0, 4), wb.getNewnumber(),ui.getPosition().substring(2,3), ui.getPosition().substring(4,5),1, predays, "");
    			}
    			else
    			{
    				prews.setDays(prews.getDays()+predays);
    				prews.setTimes(prews.getTimes()+1);
    			}
    			if(aftws==null)
    			{
    				aftws = new WcggSummary(wb.getName(), enddate.substring(0, 4), wb.getNewnumber(),ui.getPosition().substring(2,3), ui.getPosition().substring(4,5),1, wp.getDays()-predays, "");
    			}
    			else
    			{
    				aftws.setDays(aftws.getDays()+wp.getDays()-predays);
    				aftws.setTimes(aftws.getTimes());
    			}
    			wb.setStatus(1);
    			wsdao.merge(prews);
    			wsdao.merge(aftws);
    			wbdao.merge(wb);
    		}
    	}
    	
    	return message;
    }
    /**
     * 提交审批表，更新汇总表(反向操作)
     * @param nummber
     * @return
     */
    public String unSubmitWcggPage(String number)
    {
    	WcggPageDAO wpdao = new WcggPageDAO();
    	//UserInfoDAO uidao = new UserInfoDAO();
    	MyCalendarDAO mcdao = new MyCalendarDAO();
    	WcggSummaryDAO wsdao = new WcggSummaryDAO();
    	DateUtil du = new DateUtil();
    	WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
    	WcggPage wp = wpdao.findAllByNumber(number);
    	List<WcggBaodao> listwb = wbdao.findAllByNumber(number);
    	String message = "撤销成功";
    	String begindate = wp.getBegindate();
    	String enddate = wp.getEnddate();
    	double predays = 0;
    	int beginyear = Integer.parseInt(begindate.substring(0, 4));
    	int endyear = Integer.parseInt(enddate.substring(0, 4));
    	if(beginyear==endyear)//起止年份同一年
    	{
    		for(int i=0;i<listwb.size();i++)//根据报道情况表更新公干汇总表
    		{
    			WcggBaodao wb = listwb.get(i);
    			//UserInfo ui = uidao.findByNewNumber(wb.getNewnumber());
    			WcggSummary ws = wsdao.findAllByNewNumberAndYear(wb.getNewnumber(), begindate.substring(0, 4));
    			if(ws==null)
    			{
    				//ws = new WcggSummary(wb.getName(), begindate.substring(0, 4), wb.getNewnumber(),ui.getPosition().substring(2,3), ui.getPosition().substring(4,5),1, wp.getDays(), "");
    			}
    			else
    			{
    				ws.setDays(ws.getDays()-wp.getDays());
    				ws.setTimes(ws.getTimes()-1);
    			}
    			wb.setStatus(0);
    			wsdao.merge(ws);
    			wbdao.merge(wb);
    		}
    	}
    	else if(beginyear<endyear)//跨年的情况
    	{
    		String tempdate = begindate;
    		for(int i=beginyear;i<endyear;)
    		{
    			if(mcdao.ifWorkDay(tempdate))
    			{
    				predays+=1;
    			}
    			tempdate = du.getNextDay(tempdate);
    			i=Integer.parseInt(tempdate.substring(0,4));
    		}
    		for(int i=0;i<listwb.size();i++)//根据报道情况表更新公干汇总表
    		{
    			WcggBaodao wb = listwb.get(i);
    			//UserInfo ui = uidao.findByNewNumber(wb.getNewnumber());
    			WcggSummary prews = wsdao.findAllByNewNumberAndYear(wb.getNewnumber(), begindate.substring(0, 4));
    			WcggSummary aftws = wsdao.findAllByNewNumberAndYear(wb.getNewnumber(), enddate.substring(0, 4));
    			if(prews==null)
    			{
    				//prews = new WcggSummary(wb.getName(), begindate.substring(0, 4), wb.getNewnumber(),ui.getPosition().substring(2,3), ui.getPosition().substring(4,5),1, predays, "");
    			}
    			else
    			{
    				prews.setDays(prews.getDays()-predays);
    				prews.setTimes(prews.getTimes()-1);
    			}
    			if(aftws==null)
    			{
    				//aftws = new WcggSummary(wb.getName(), enddate.substring(0, 4), wb.getNewnumber(),ui.getPosition().substring(2,3), ui.getPosition().substring(4,5),1, wp.getDays()-predays, "");
    			}
    			else
    			{
    				aftws.setDays(aftws.getDays()-wp.getDays()+predays);
    				aftws.setTimes(aftws.getTimes());
    			}
    			wb.setStatus(0);
    			wsdao.merge(prews);
    			wsdao.merge(aftws);
    			wbdao.merge(wb);
    		}
    	}
    	
    	return message;
    }
}