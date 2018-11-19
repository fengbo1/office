package office.leave.dao;
// default package

import ccb.dao.BaseHibernateDAO;

import java.util.ArrayList;
import java.util.List;

import office.jbsp.dao.JbspPageDiDAO;
import office.jbsp.dao.JbspSummaryDAO;
import office.jbsp.pojo.JbspSummary;
import office.leave.pojo.LeaveMonthSummary;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveSummary;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MonthSummary;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.UserUtil;
import office.util.Util;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for LeavePage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .LeavePage
  * @author MyEclipse Persistence Tools 
 */

public class LeavePageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(LeavePageDAO.class);
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
	public static final String DAI = "dai";
	public static final String CHU = "chu";
	public static final String TUAN = "tuan";
	public static final String ZHIWU = "zhiwu";
	public static final String WORKAGE = "workage";
	public static final String TYPE = "type";
	public static final String QITA = "qita";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String HALFDAY = "halfday";
	public static final String DAYS = "days";
	public static final String XIAOJIA = "xiaojia";
	public static final String QUEREN = "queren";
	public static final String REMARK = "remark";
	public static final String VIEW = "view";
	public static final String VIEWPB = "viewpb";
	public static final String VIEWBY = "viewby";



    
    public void save(LeavePage transientInstance) {
        log.debug("saving LeavePage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LeavePage persistentInstance) {
        log.debug("deleting LeavePage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LeavePage findById( java.lang.Integer id) {
        log.debug("getting LeavePage instance with id: " + id);
        try {
            LeavePage instance = (LeavePage) getSession()
                    .get("LeavePage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(LeavePage instance) {
        log.debug("finding LeavePage instance by example");
        try {
            List results = getSession()
                    .createCriteria("LeavePage")
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
      log.debug("finding LeavePage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LeavePage as model where model." 
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
	
	public List findByDai(Object dai
	) {
		return findByProperty(DAI, dai
		);
	}
	
	public List findByChu(Object chu
	) {
		return findByProperty(CHU, chu
		);
	}
	
	public List findByTuan(Object tuan
	) {
		return findByProperty(TUAN, tuan
		);
	}
	
	public List findByZhiwu(Object zhiwu
	) {
		return findByProperty(ZHIWU, zhiwu
		);
	}
	
	public List findByWorkage(Object workage
	) {
		return findByProperty(WORKAGE, workage
		);
	}
	
	public List findByType(Object type
	) {
		return findByProperty(TYPE, type
		);
	}
	
	public List findByQita(Object qita
	) {
		return findByProperty(QITA, qita
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
	
	public List findByXiaojia(Object xiaojia
	) {
		return findByProperty(XIAOJIA, xiaojia
		);
	}
	
	public List findByQueren(Object queren
	) {
		return findByProperty(QUEREN, queren
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	
	public List findByView(Object view
	) {
		return findByProperty(VIEW, view
		);
	}
	
	public List findByViewpb(Object viewpb
	) {
		return findByProperty(VIEWPB, viewpb
		);
	}
	
	public List findByViewby(Object viewby
	) {
		return findByProperty(VIEWBY, viewby
		);
	}
	

	public List findAll() {
		log.debug("finding all LeavePage instances");
		try {
			String queryString = "from LeavePage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LeavePage merge(LeavePage detachedInstance) {
        log.debug("merging LeavePage instance");
        try {
            LeavePage result = (LeavePage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LeavePage instance) {
        log.debug("attaching dirty LeavePage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LeavePage instance) {
        log.debug("attaching clean LeavePage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllByDate(String date) {
    	log.debug("finding all LeavePage instances");
    	try {
    		String queryString = "from LeavePage as lp where lp.date="+date;
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List findAllByDateAndType(String applicant,String date,int type) {
    	log.debug("finding all LeavePage instances");
    	try {
    		String queryString = "from LeavePage as lp where lp.applicant='"+applicant+"' and lp.type="+type+" and lp.begindate<='"+date+"' and lp.enddate>='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
   
    /**
     * 查询事假不扣钱总天数
     * @param applicant
     * @param month
     * @return
     */

    public double findShiBUKOUByDateAndType(String applicant,String month) {
    	log.debug("finding all LeavePage instances");
    	try {
    		String queryString = "select sum(lp.days) from t_leave_page as lp where lp.applicant='"+applicant+"' and lp.status in (1,2,6,7,9) and lp.type=3 and lp.begindate>='"+month+"01' and lp.enddate<='"+month+"31' and lp.days=0.5";
            if(getSession().createSQLQuery(queryString).uniqueResult()==null)
            {
            	return 0;
            }
            else
            {
            	double days = Double.parseDouble(getSession().createSQLQuery(queryString).uniqueResult().toString());
       		 	return days;
            }
    		
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public LeavePage findByNumber(String number) {
    	log.debug("finding all LeavePage instances");
    	try {
    		String queryString = "from LeavePage as lp where lp.number='"+number+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<LeavePage> list = queryObject.list();
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
    public List<LeavePage> findByNumberAndYear(String applicant,String year,int type) {
    	log.debug("finding all LeavePage instances");
    	try {
    		String queryString = "from LeavePage as lp where lp.applicant='"+applicant+"' and lp.status in (1,2,7) and lp.type="+type+" and lp.begindate>='"+year+"0101' and lp.enddate<='"+year+"1231'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 
     * @param newnumber
     * @param date
     * @param status 数字逗号相隔
     * @return
     */
    public List findByNewNumberAndDate(String newnumber,String date,String status) {
    	log.debug("finding all LeavePage instances");
    	try {
    		String queryString = "from LeavePage as lp where lp.applicant='"+newnumber+"' and lp.status in ("+status+") and lp.begindate<='"+date+"' and lp.enddate>='"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     *  根据新一代工号请假类型天数等信息更新汇总表
     * @param begindate,请假起始日期
     * @param type
     * @param days
     * @param year
     * @param newnumber
     * @return
     */
    public String updateLeave(String begindate,int type,double days,int year,int month,String newnumber)
    {
    	LeaveSummaryDAO lsdao = new LeaveSummaryDAO();
    	JbspPageDiDAO jpddao = new JbspPageDiDAO();
    	UserInfoDAO uidao = new UserInfoDAO();
    	String name = uidao.findByNewNumber(newnumber).getUsername();
    	LeaveMonthSummaryDAO lmsdao = new LeaveMonthSummaryDAO();
    	LeaveSummary ls = lsdao.findByYearAndNewnumber(year, newnumber);
    	LeaveMonthSummary lms = lmsdao.findAllNewnumberAndYearAndMonth(newnumber, year, month);
    	//去年请假情况，加班调休用
    	LeaveSummary lspre = lsdao.findByYearAndNewnumber(year-1, newnumber);
    	//LeaveMonthSummary lmspre = lmsdao.findAllNewnumberAndYearAndMonth(newnumber, year-1, month);
    	if(type==1)//病假
    	{
    		ls.setBingleave(ls.getBingleave()+days);
    		lms.setBingleave(lms.getBingleave()+days);
    	}
    	else if(type==2)//年休假
    	{
    		ls.setYearleave(ls.getYearleave()+days);
    		lms.setYearleave(lms.getYearleave()+days);
    	}
    	else if(type==3)//事假
    	{
    		ls.setShileave(ls.getShileave()+days);
    		lms.setShileave(lms.getShileave()+days);
    	}
    	else if(type==4)//婚假
    	{
    		ls.setHunleave(ls.getHunleave()+days);
    		lms.setHunleave(lms.getHunleave()+days);
    	}
    	else if(type==5)//产假
    	{
    		ls.setChanleave(ls.getChanleave()+days);
    		lms.setChanleave(lms.getChanleave()+days);
    	}
    	else if(type==6)//探亲假配偶
    	{
    		ls.setTanpoleave(ls.getTanpoleave()+days);
    		lms.setTanpoleave(lms.getTanpoleave()+days);
    	}
    	else if(type==7)//探请假父母
    	{
    		ls.setTanfmleave(ls.getTanfmleave()+days);
    		lms.setTanfmleave(lms.getTanfmleave()+days);
    	}
    	else if(type==8)//丧假
    	{
    		ls.setSangleave(ls.getSangleave()+days);
    		lms.setSangleave(lms.getSangleave()+days);
    	}
    	else if(type==9)//工伤假
    	{
    		ls.setShangleave(ls.getShangleave()+days);
    		lms.setShangleave(lms.getShangleave()+days);
    	}
    	else if(type==10)//公假
    	{
    		ls.setGongleave(ls.getGongleave()+days);
    		lms.setGongleave(lms.getGongleave()+days);
    	}
    	else if(type==11)//加班调休
    	{
    		//JbspSummary
    		JbspSummaryDAO jsdao = new JbspSummaryDAO();
    		double lastrestdays=0.0;
        	JbspSummary js = jsdao.findAllByYearAndNewNumber(String.valueOf(year),newnumber);
        	JbspSummary jspre = jsdao.findAllByYearAndNewNumber(String.valueOf(year-1),newnumber);
        	if(jspre==null)
        	{
        		lastrestdays=0.0;
        	}
        	else
        	{
        		lastrestdays = jspre.getDays()-jspre.getDidays();
        	}
    		if((lastrestdays)>=days)//如果去年的加班剩余调休天数还足够，则用去年的天数抵用
    		{
    			jspre.setDidays(jspre.getDidays()+days);
    		}
    		else//如果去年加班剩余调休天数不够抵用，分两部分抵用
    		{
    			double lastyeardays = lastrestdays;
    			double thisyeardays = days - lastyeardays;//
    			if(jspre!=null)
    			{
    				jspre.setDidays(jspre.getDays());
    			}
    			if(js==null)
    			{
    				jpddao.diKouJbdays(name, begindate, thisyeardays);
    			}
    			else if((js.getDidays()+thisyeardays)>js.getDays())//如果今年的已经被抵用完,在新生成的加班明细表中抵扣
    			{
    				double newdays = js.getDidays()+thisyeardays-js.getDays();//新加班调休
    				js.setDidays(js.getDays());
    				jpddao.diKouJbdays(name, begindate, newdays);
    			}
    			else//如果今年的未抵用完
    			{
    				js.setDidays(js.getDidays()+thisyeardays);
    			}
    			
    		}
    		//leavesummary
    		if(lspre.getWorkrest()>=days)//leavesummary去年够减
    		{
    			lspre.setWorkrest(lspre.getWorkrest()-days);
    		}
    		else//去年不够减
    		{
    			if(ls.getWorkrest()>=(days-lspre.getWorkrest()))
    			{
    				ls.setWorkrest(ls.getWorkrest()-(days-lspre.getWorkrest()));
    			}
    			else
    			{
    				ls.setWorkrest(0.0);
    			}
    			lspre.setWorkrest(0.0);
    		}
    		ls.setWorkleave(ls.getWorkleave()+days);
    		lms.setWorkleave(lms.getWorkleave()+days);
    		if(js!=null)
    		{
    			jsdao.merge(js);
    		}
    		if(jspre!=null)
    		{
    			jsdao.merge(jspre);
    		}
    	}
    	else if(type==12)//产检
    	{
    		ls.setQitaleave(ls.getQitaleave()+days);
    		lms.setQitaleave(lms.getQitaleave()+days);
    	}
    	else if(type==13)//陪考假
    	{
    		ls.setPeikaoleave(ls.getPeikaoleave()+days);
    		lms.setPeikaoleave(lms.getPeikaoleave()+days);
    	}
    	else if(type==14)//哺乳假
    	{
    		ls.setBuruleave(ls.getBuruleave()+days);
    		lms.setBuruleave(lms.getBuruleave()+days);
    	}
    	lsdao.merge(ls);
    	if(lspre!=null)
    	{
    		lsdao.merge(lspre);
    	}
    	
    	lmsdao.merge(lms);
    	String result="success";
    	
    	return result;
    }
    /**
     *  根据新一代工号请假类型天数等信息反向操作汇总表
     * @param type
     * @param days
     * @param year
     * @param newnumber
     * @return
     */
    public String unupdateLeave(int type,double days,int year,int month,String newnumber)
    {
    	LeaveSummaryDAO lsdao = new LeaveSummaryDAO();
    	LeaveMonthSummaryDAO lmsdao = new LeaveMonthSummaryDAO();
    	UserInfoDAO uidao = new UserInfoDAO();
    	JbspPageDiDAO jpddao = new JbspPageDiDAO();
    	String name = uidao.findByNewNumber(newnumber).getUsername();
    	LeaveSummary ls = lsdao.findByYearAndNewnumber(year, newnumber);
    	LeaveMonthSummary lms = lmsdao.findAllNewnumberAndYearAndMonth(newnumber, year, month);
    	if(type==1)//病假
    	{
    		ls.setBingleave(ls.getBingleave()-days);
    		lms.setBingleave(lms.getBingleave()-days);
    	}
    	else if(type==2)//年休假
    	{
    		ls.setYearleave(ls.getYearleave()-days);
    		lms.setYearleave(lms.getYearleave()-days);
    	}
    	else if(type==3)//事假
    	{
    		ls.setShileave(ls.getShileave()-days);
    		lms.setShileave(lms.getShileave()-days);
    	}
    	else if(type==4)//婚假
    	{
    		ls.setHunleave(ls.getHunleave()-days);
    		lms.setHunleave(lms.getHunleave()-days);
    	}
    	else if(type==5)//产假
    	{
    		ls.setChanleave(ls.getChanleave()-days);
    		lms.setChanleave(lms.getChanleave()-days);
    	}
    	else if(type==6)//探亲假配偶
    	{
    		ls.setTanpoleave(ls.getTanpoleave()-days);
    		lms.setTanpoleave(lms.getTanpoleave()-days);
    	}
    	else if(type==7)//探请假父母
    	{
    		ls.setTanfmleave(ls.getTanfmleave()-days);
    		lms.setTanfmleave(lms.getTanfmleave()-days);
    	}
    	else if(type==8)//丧假
    	{
    		ls.setSangleave(ls.getSangleave()-days);
    		lms.setSangleave(lms.getSangleave()-days);
    	}
    	else if(type==9)//工伤假
    	{
    		ls.setShangleave(ls.getShangleave()-days);
    		lms.setShangleave(lms.getShangleave()-days);
    	}
    	else if(type==10)//公假
    	{
    		ls.setGongleave(ls.getGongleave()-days);
    		lms.setGongleave(lms.getGongleave()-days);
    	}
    	else if(type==11)//加班调休
    	{
    		//leavesummary
    		//ls.setWorkrest(ls.getWorkrest()+days);
    		LeaveSummary lspre = lsdao.findByYearAndNewnumber(year-1, newnumber);
    		ls.setWorkleave(ls.getWorkleave()-days);
    		lms.setWorkleave(lms.getWorkleave()-days);
    		//JBSPsummary
    		JbspSummaryDAO jsdao = new JbspSummaryDAO();
        	JbspSummary js = jsdao.findAllByYearAndNewNumber(String.valueOf(year),newnumber);
        	JbspSummary jspre = jsdao.findAllByYearAndNewNumber(String.valueOf(year-1),newnumber);
        	double restdidays = jpddao.huanYuanJbDays(name,days);//先返还jb抵用表里的天数
        	if(js!=null)//如果当年加班调休不为空
        	{
        		if(js.getDidays()>=restdidays)//够减
        		{
        			js.setDidays(js.getDidays()-restdidays);
        			ls.setWorkrest(ls.getWorkrest()+restdidays);
        		}
        		else//不够减
        		{
        			lspre.setWorkrest(lspre.getWorkrest()+(restdidays-js.getDidays()));
        			ls.setWorkrest(ls.getWorkrest()+js.getDidays());
        			jspre.setDidays(jspre.getDidays()-(restdidays-js.getDidays()));
        			js.setDidays(0.0);
        		}
        	}else
        	{
        		if(jspre!=null)
        		{
        			jspre.setDidays(jspre.getDidays()-restdidays);
        			lspre.setWorkrest(lspre.getWorkrest()+restdidays);
        		}
        	}
        	if(js!=null)
        	{
        		jsdao.merge(js);
        	}
        	if(jspre!=null)
        	{
        		jsdao.merge(jspre);
        	}
        	lsdao.merge(lspre);
    	}
    	else if(type==12)//其他请假
    	{
    		ls.setQitaleave(ls.getQitaleave()-days);
    		lms.setQitaleave(lms.getQitaleave()-days);
    	}
    	else if(type==13)//陪考假
    	{
    		ls.setPeikaoleave(ls.getPeikaoleave()-days);
    		lms.setPeikaoleave(lms.getPeikaoleave()-days);
    	}
    	else if(type==14)//哺乳假
    	{
    		ls.setBuruleave(ls.getBuruleave()-days);
    		lms.setBuruleave(lms.getBuruleave()-days);
    	}
    	lsdao.merge(ls);
    	lmsdao.merge(lms);
    	String result="success";
    	
    	return result;
    }
    /**
     * 提交审批表,更新汇总表
     */
    public String submitLeavePage(Session session,String number)
    {
    	try {
    		LeavePageDAO lpdao = new LeavePageDAO();
    		DateUtil du = new DateUtil();
    		LeavePage lp = lpdao.findByNumber(number);
    		int type = lp.getType();
    		String message = "";
    		String begindate = lp.getBegindate();
    		String enddate = lp.getEnddate();
    		List<MonthSummary> list = new ArrayList<MonthSummary>();
    		if(Util.leavedays.contains(type))//婚、产、探、病、丧计算周末
    		{
    			list = du.getListByBegindateAndEnddate(session,begindate, enddate, lp.getHalfday());
    		}
    		else//只计算工作日
    		{
    			list = du.getWorkListByBegindateAndEnddate(session,begindate, enddate, lp.getHalfday());
    		}
    		for(int i=0;i<list.size();i++)
    		{
    			MonthSummary ms = list.get(i);
    			message = lpdao.updateLeave(begindate,lp.getType(),ms.getDays(),ms.getYear(),ms.getMonth(), lp.getApplicant());
    		}
//    		double predays = 0;
//    		int beginyear = Integer.parseInt(begindate.substring(0, 4));
//    		int endyear = Integer.parseInt(enddate.substring(0, 4));
//    		
//    		if(beginyear==endyear)//起止年份同一年
//    		{
//    			message = lpdao.updateLeave(lp.getType(),lp.getDays(), beginyear, lp.getApplicant());
//    		}
//    		else if(beginyear<endyear)//跨年的情况
//    		{
//    			String tempdate = begindate;
//    			for(int i=beginyear;i<endyear;)
//    			{
//    				if(mcdao.ifWorkDay(tempdate))
//    				{
//    					predays+=1;
//    				}
//    				tempdate = du.getNextDay(tempdate);
//    				i=Integer.parseInt(tempdate.substring(0,4));
//    			}
//    			message += lpdao.updateLeave(lp.getType(),predays, beginyear, lp.getApplicant());
//    			message += lpdao.updateLeave(lp.getType(),lp.getDays()-predays, endyear, lp.getApplicant());
//    		}
    		
    	return message;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 反向操作，恢复已减掉的请假天数
     * @param number
     * @return
     */
    public String undoLeavePage(Session session,String number)
    {
    	try {
    		LeavePageDAO lpdao = new LeavePageDAO();
    		LeavePage lp = lpdao.findByNumber(number);
    		int type = lp.getType();
    		DateUtil du = new DateUtil();
    		MyCalendarDAO mcdao = new MyCalendarDAO();
    		String message = "";
    		String begindate = lp.getBegindate();
    		String enddate = lp.getEnddate();
    		List<MonthSummary> list = new ArrayList<MonthSummary>();
    		if(Util.leavedays.contains(type))//
    		{
    			list = du.getListByBegindateAndEnddate(session,begindate, enddate, lp.getHalfday());
    		}
    		else//只计算工作日
    		{
    			list = du.getWorkListByBegindateAndEnddate(session,begindate, enddate, lp.getHalfday());
    		}
    		for(int i=0;i<list.size();i++)
    		{
    			MonthSummary ms = list.get(i);
    			message = lpdao.unupdateLeave(lp.getType(),ms.getDays(),ms.getYear(),ms.getMonth(), lp.getApplicant());
    			
    		}
//    		int beginyear = Integer.parseInt(begindate.substring(0, 4));
//    		int endyear = Integer.parseInt(enddate.substring(0, 4));
//    		double predays = 0;
//    		if(beginyear==endyear)//起止年份同一年
//    		{
//    			message = lpdao.unupdateLeave(lp.getType(),lp.getDays(), beginyear, lp.getApplicant());
//    		}
//    		else if(beginyear<endyear)//跨年的情况
//    		{
//    			String tempdate = begindate;
//    			for(int i=beginyear;i<endyear;)
//    			{
//    				if(mcdao.ifWorkDay(tempdate))
//    				{
//    					predays+=1;
//    				}
//    				tempdate = du.getNextDay(tempdate);
//    				i=Integer.parseInt(tempdate.substring(0,4));
//    			}
//    			message += lpdao.unupdateLeave(lp.getType(),predays, beginyear, lp.getApplicant());
//    			message += lpdao.unupdateLeave(lp.getType(),lp.getDays()-predays, endyear, lp.getApplicant());
//    		}
    		return message;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 根据申请人和状态查询
     * @param applicant
     * @param status
     * @return
     */
    public List findByApplicant(String applicant,int status) {
    	log.debug("finding all LeavePage instances");
    	try {
    		String queryString = "";
    		if(status==169)//状态1/6/9，表示审批中的状态
    		{
    			queryString = "from LeavePage as lp where lp.applicant='"+applicant+"' and lp.status in (1,6,9)";
    		}
    		else
    		{
    			queryString = "from LeavePage as lp where lp.applicant='"+applicant+"' and lp.status="+status;
    		}
    			
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 年度内年假剩余次数
     * @param year
     * @return
     */
    public int findYearShengyuCishu(String newnumber,int year)
    {
    	try {
    		int yearcs = 0;
        	String queryString = "from LeavePage where applicant='"+newnumber+"' and status in (1,2,6,7,9) and type=2 and ((begindate>='"+year+"0101' and begindate<='"+year+"1231') or (enddate>='"+year+"0101' and enddate<='"+year+"1231'))";
        	List<LeavePage> list = getSession().createQuery(queryString).list();
        	yearcs=list.size();
        	return 3-yearcs;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    /**
     * 根据申请人和状态,年份查询
     * @param applicant
     * @param status
     * @return
     */
    public double findSumByApplicant(String applicant,int status,int year,int type) {
    	log.debug("finding all LeavePage instances");
    	DateUtil du = new DateUtil();
    	double result = 0.0;
    	try {
    		String queryString = "";
    		if(status==169)//状态1/6/9，表示审批中的状态
    		{
    			queryString = "select * from t_leave_page where applicant='"+applicant+"' and type="+type+" and status in (1,6,9) and ((begindate>='"+year+"0101' and begindate<='"+year+"1231') or (enddate>='"+year+"0101' and enddate<='"+year+"1231'))";
    		}
    		else
    		{
    			queryString = "select * from t_leave_page where applicant='"+applicant+"' and type="+type+" and status="+status+"and ((begindate>='"+year+"0101' and begindate<='"+year+"1231') or (enddate>='"+year+"0101' and enddate<='"+year+"1231'))";
    		}
    		//String days = String.valueOf(getSession().createSQLQuery(queryString).uniqueResult());
    		List<LeavePage> list = getSession().createSQLQuery(queryString).addEntity(LeavePage.class).list();
    		if(!list.isEmpty())
    		{
    			for(int i=0;i<list.size();i++)
    			{
    				LeavePage lp = list.get(i);
    				double tempdays = 0.0;
    				int by = Integer.valueOf(lp.getBegindate().substring(0, 4));
    				int ey = Integer.valueOf(lp.getEnddate().substring(0, 4));
    				//三种情况
    				if(by==ey)
    				{
    					result+=lp.getDays();
    				}
    				else if(by==year)
    				{
    					
    					if(Util.leavedays.contains(type))
    					{
    						tempdays = du.getDaysByBegindateAndEnddate(getSession(), lp.getBegindate(), lp.getBegindate().substring(0, 4)+"1231");
    					}
    					else if(Util.leaveworkdays.contains(type))
    					{
    						tempdays = du.getWorkDaysByBegindateAndEnddate(getSession(),lp.getBegindate(), lp.getBegindate().substring(0, 4)+"1231");
    					}
    				}
    				else if(ey==year)
    				{
    					if(Util.leavedays.contains(type))
    					{
    						tempdays = du.getDaysByBegindateAndEnddate(getSession(),lp.getEnddate().substring(0, 4)+"0101",lp.getEnddate());
    					}
    					else if(Util.leaveworkdays.contains(type))
    					{
    						tempdays = du.getWorkDaysByBegindateAndEnddate(getSession(),lp.getEnddate().substring(0, 4)+"0101",lp.getEnddate());
    					}
    				}
    				result += tempdays;
    			}
    		}
    		return result;
    		
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public String findboss(String name){
    	String bossname="";
    	String chu="A";
    	String tuan="A";
    	String zhi="A";
    	String hql2 = "";
    	 String array1 = "";
    	UserUtil uu = new UserUtil();
    	UserInfoDAO uidao = new UserInfoDAO();
    	List <UserInfo> mylist=new ArrayList<UserInfo>();
    	
    	
        try {
            List<UserInfo> listui = uidao.findAllByNameList(name);
            if(!listui.isEmpty())
            {
            	String position = listui.get(0).getPosition();
            	 //获得处室、团队、职务
                chu = position.substring(2, 3);
                tuan = position.substring(4, 5);
                zhi = position.substring(0, 1);
                if(zhi.equals("1"))//处长
                {
                	if(chu.equals("1"))//综合
                	{
                		hql2 = "from UserInfo where authority like '%A%'";// 条件查询HQL语句
                	}
                	else//其他
                	{
                		hql2 = "from UserInfo where position like '1_1__'";// 条件查询HQL语句
                	}
                }
                else if((chu.equals("2")||chu.equals("3")||chu.equals("6"))&&zhi.equals("3"))//业务处理人员
                {
                	hql2 = "from UserInfo where position like '__"+chu+"_"+tuan+"' and authority like '%D%'";// 条件查询HQL语句
                }
                else if((chu.equals("2")||chu.equals("3")||chu.equals("6"))&&zhi.equals("4"))//业务处理人员组长
                {
                	hql2 = "from UserInfo where position like '__"+chu+"__' and authority like '%B%'";// 条件查询HQL语句
                }
                else//其余人到处长
                {
                	hql2 = "from UserInfo where position like '1_"+chu+"__'";// 条件查询HQL语句
                }
                hql2 += " and username not like '%B%'";
                hql2 += " order by paixu desc";
                Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
                mylist = q2.list(); 
                 
                if(mylist.size()>=1){
               	 for(int i=0;i<mylist.size();i++){
               		 UserInfo ui = mylist.get(i);
                   	 array1 = UserUtil.positionTofzr(position);
                   	 array1+="（";
                   	 array1+=ui.getUsername();
                   	 array1+="）";
               		 bossname=array1+":"+ui.getNewnumber()+";"+bossname;                	
               	 }                	 
                }
            }
           
            //如果为异常交易处员工
//            if(chu.equals("3")&&zhi.equals("3")){
//            	 String hql2 = "from UserInfo where position like '4_3_"+tuan+"' order by paixu desc";// 条件查询HQL语句
//                 Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
//                 mylist = q2.list(); 
//                 
//                 if(mylist.size()>=1){
//                	 for(int i=0;i<mylist.size();i++){
//                		 UserInfo ui = mylist.get(i);
//                		 String array1 = "";
//                		 array1+=uu.tToName(3,Integer.valueOf(tuan));
//                		 array1+="（";
//                		 array1+=ui.getUsername();
//                		 array1+="）";
//                		 bossname=array1+":"+ui.getNewnumber()+";"+bossname;                	
//                	 }                	 
//                 }            	
//            }
//            //如果为生产管理处普通员工
//            if(chu.equals("2")&&zhi.equals("3")){
//           	 String hql2 = "from UserInfo where position like '2_2__' order by paixu desc";// 条件查询HQL语句
//                Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
//                mylist = q2.list(); 
//                
//                if(mylist.size()>=1){
//               	 for(int i=0;i<mylist.size();i++){
//               		UserInfo ui = mylist.get(i);
//               		String array1 = "生产管理处";
//               		array1+="（";
//               		array1+=ui.getUsername();
//               		array1+="）";
//               		bossname=array1+":"+ui.getNewnumber()+";"+bossname;                	
//               	 }                	 
//                }            	
//           }
//            //如果为异常交易处组长
//            if(chu.equals("3")&&zhi.equals("4")){
//            	 String hql2 = "from UserInfo where position like '2_3__' order by paixu desc";// 条件查询HQL语句
//                 Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
//                 mylist = q2.list(); 
//                  
//                 if(mylist.size()>=1){
//                	 for(int i=0;i<mylist.size();i++){
//                		 UserInfo ui = mylist.get(i);
//                    	 String array1 = "异常交易处";
//                    	 array1+="（";
//                    	 array1+=ui.getUsername();
//                    	 array1+="）";
//                		 bossname=array1+":"+ui.getNewnumber()+";"+bossname;                	
//                	 }                	 
//                 }          	
//            }
//            //如果为员工响应团队员工
//            if(zhi.equals("3")&&chu.equals("4")){
//           	 String hql2 = "from UserInfo where position like '2_4_A' order by paixu desc";// 条件查询HQL语句
//                Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
//                mylist = q2.list(); 
//               
//                if(mylist.size()>=1){
//               	 for(int i=0;i<mylist.size();i++){
//               		UserInfo ui = mylist.get(i);
//               		String array1 = "员工响应团队";
//               		array1+="（";
//               		array1+=ui.getUsername();
//               		array1+="）";
//               		bossname=array1+":"+ui.getNewnumber()+";"+bossname;         	
//               	 }                	 
//                }      	
//           }
//            //如果为员工响应团队员工
//            if(zhi.equals("3")&&chu.equals("5")){
//           	 String hql2 = "from UserInfo where position like '2_5_B' order by paixu desc";// 条件查询HQL语句
//                Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
//                mylist = q2.list(); 
//               
//                if(mylist.size()>=1){
//               	 for(int i=0;i<mylist.size();i++){
//               		UserInfo ui = mylist.get(i);
//               		String array1 = "员工渠道处";
//               		array1+="（";
//               		array1+=ui.getUsername();
//               		array1+="）";
//               		bossname=array1+":"+ui.getNewnumber()+";"+bossname;         	
//               	 }                	 
//                }      	
//           }
//            //如果为生产管理处、综合管理处、团队负责人、处室负责人
//            if((chu.equals("1")&&!zhi.equals("1"))||(zhi.equals("1")&&!chu.equals("1"))||zhi.equals("2")){
//              	 String hql2 = "from UserInfo where position like '1_1__' order by paixu desc";// 条件查询HQL语句
//                   Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
//                   mylist = q2.list(); 
//                
//                   if(mylist.size()>=1){
//                  	 for(int i=0;i<mylist.size();i++){
//                  		UserInfo ui = mylist.get(i);
//                   		String array1 = "综合管理处";
//                   		array1+="（";
//                   		array1+=ui.getUsername();
//                   		array1+="）";
//                   		bossname=array1+":"+ui.getNewnumber()+";"+bossname;                     	
//                  	 }                	 
//                   }     	
//              }
//            
//            //如果为综合处负责人
//            if(chu.equals("1")&&zhi.equals("1")){
//             	 String hql2 = "from UserInfo where authority like '%A%' order by paixu desc";// 条件查询HQL语句
//                  Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
//                  mylist = q2.list(); 
//               
//                  if(mylist.size()>=1){
//                 	 for(int i=0;i<mylist.size();i++){
//                 		UserInfo ui = mylist.get(i);
//                   		String array1 = "中心负责人";
//                   		array1+="（";
//                   		array1+=ui.getUsername();
//                   		array1+="）";
//                   		bossname=array1+":"+ui.getNewnumber()+";"+bossname;             	
//                 	 }                	 
//                  }         	
//             }
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("在leavepagedao.java中查询团队处室职务时失败");
        }
        if(bossname.length()>0)
        bossname=bossname.substring(0,bossname.length()-1);
        System.out.println(bossname);
    	return bossname;   	
    }

    /**
     * 输入名字查询组长
     * 仅供普通员工
     * @param name
     * @return
     */
    public String findzuzhang(String name){
    	String bossname="";
    	String position = "AAAAA";
    	String chu="A";
    	String tuan="A";
    	String zhi="A";
    	String autho = "";
    	UserUtil uu = new UserUtil();
    	List <UserInfo> mylist=new ArrayList<UserInfo>();
    	
    	
        try {
        	
            String hql = "from UserInfo where username='"+name+"'";// 条件查询HQL语句
            Query q = getSession().createQuery(hql);// 执行查询操作
            
            mylist = q.list(); 
            //获得处室、团队、职务
            if(mylist.size()==1){
            	position = mylist.get(0).getPosition();
            	 chu=position.substring(2,3);
            	 tuan=position.substring(4,5);
            	 zhi=position.substring(0,1);
            	 autho=mylist.get(0).getAuthority();
            }
            //如果为异常交易处员工
            if(chu.equals("3")||chu.equals("6")){
            	 String hql2 = "from UserInfo where position like '__"+chu+"_"+tuan+"' and authority like '%D%' order by paixu desc";// 条件查询HQL语句
                 Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
                 mylist = q2.list(); 
                 
                 if(mylist.size()>=1){
                	 for(int i=0;i<mylist.size();i++){
                		 UserInfo ui = mylist.get(i);
                		 String array1 = "";
                		 array1+=uu.tToName(Integer.parseInt(chu),Integer.valueOf(tuan));
                		 array1+="（";
                		 array1+=ui.getUsername();
                		 array1+="）";
                		 bossname=array1+":"+ui.getNewnumber()+";"+bossname;                	
                	 }                	 
                 }            	
            }
            //如果为合规与监督二处普通员工
            else if(chu.equals("2")&&zhi.equals("3")){
           	 String hql2 = "from UserInfo where position like '1_2__' order by paixu desc";// 条件查询HQL语句
                Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
                mylist = q2.list(); 
                
                if(mylist.size()>=1){
               	 for(int i=0;i<mylist.size();i++){
               		UserInfo ui = mylist.get(i);
               		String array1 = "合规与监督二处";
               		array1+="（";
               		array1+=ui.getUsername();
               		array1+="）";
               		bossname=array1+":"+ui.getNewnumber()+";"+bossname;                	
               	 }                	 
                }            	
           }
            //如果为员工响应团队员工
            else  if(zhi.equals("3")&&chu.equals("4")){
           	 String hql2 = "from UserInfo where position like '2_4_A' order by paixu desc";// 条件查询HQL语句
                Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
                mylist = q2.list(); 
               
                if(mylist.size()>=1){
               	 for(int i=0;i<mylist.size();i++){
               		UserInfo ui = mylist.get(i);
               		String array1 = "员工响应团队";
               		array1+="（";
               		array1+=ui.getUsername();
               		array1+="）";
               		bossname=array1+":"+ui.getNewnumber()+";"+bossname;         	
               	 }                	 
                }      	
           }
            //如果为员工响应团队员工
            else  if(zhi.equals("3")&&chu.equals("5")){
           	 String hql2 = "from UserInfo where position like '2_5_B' order by paixu desc";// 条件查询HQL语句
                Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
                mylist = q2.list(); 
               
                if(mylist.size()>=1){
               	 for(int i=0;i<mylist.size();i++){
               		UserInfo ui = mylist.get(i);
               		String array1 = "研发支持二处";
               		array1+="（";
               		array1+=ui.getUsername();
               		array1+="）";
               		bossname=array1+":"+ui.getNewnumber()+";"+bossname;         	
               	 }                	 
                }      	
           }
            //如果为生产管理处、综合管理处、团队负责人、处室负责人
            else if((chu.equals("1")&&!zhi.equals("1"))||(zhi.equals("1")&&!chu.equals("1"))||zhi.equals("2")){
              	 String hql2 = "from UserInfo where position like '1_1__' order by paixu desc";// 条件查询HQL语句
                   Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
                   mylist = q2.list(); 
                
                   if(mylist.size()>=1){
                  	 for(int i=0;i<mylist.size();i++){
                  		UserInfo ui = mylist.get(i);
                   		String array1 = "综合与生产管理处";
                   		array1+="（";
                   		array1+=ui.getUsername();
                   		array1+="）";
                   		bossname=array1+":"+ui.getNewnumber()+";"+bossname;                     	
                  	 }                	 
                   }     	
              }
            
            //如果为综合处负责人
            else if(chu.equals("1")&&zhi.equals("1")){
             	 String hql2 = "from UserInfo where authority like '%A%' order by paixu desc";// 条件查询HQL语句
                  Query q2 = getSession().createQuery(hql2);// 执行查询操作                 
                  mylist = q2.list(); 
               
                  if(mylist.size()>=1){
                 	 for(int i=0;i<mylist.size();i++){
                 		UserInfo ui = mylist.get(i);
                   		String array1 = "中心负责人";
                   		array1+="（";
                   		array1+=ui.getUsername();
                   		array1+="）";
                   		bossname=array1+":"+ui.getNewnumber()+";"+bossname;             	
                 	 }                	 
                  }         	
             }
        } catch (HibernateException e) {
            e.printStackTrace();
            System.out.println("在leavepagedao.java中查询团队处室职务时失败");
        }
        if(bossname.length()>0)
        bossname=bossname.substring(0,bossname.length()-1);
        //bossname=bossname.replaceAll("(\r\n|\r|\n|\n\r)", "");
        System.out.println(bossname);
    	return bossname;   	
    }
}