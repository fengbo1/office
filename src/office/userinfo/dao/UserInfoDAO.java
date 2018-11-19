package office.userinfo.dao;
// default package

import ccb.dao.BaseHibernateDAO;

import java.util.ArrayList;
import java.util.List;

import office.pb.dao.PbMxDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.ScpbTeam;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UserInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserInfo
  * @author MyEclipse Persistence Tools 
 */

public class UserInfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserInfoDAO.class);
		//property constants
	public static final String NEWNUMBER = "newnumber";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String POSITION = "position";
	public static final String AUTHORITY = "authority";
	public static final String IDENTITY = "identity";
	public static final String WORKDATE = "workdate";
	public static final String CCBDATE = "ccbdate";
	public static final String ZXDATE = "zxdate";
	public static final String WORKYEARS = "workyears";
	public static final String PASSPORT = "passport";
	public static final String HKPASSPORT = "hkpassport";
	public static final String TWPASSPORT = "twpassport";
	public static final String YEARALL = "yearall";
	public static final String ROLE890 = "role890";
	public static final String ROLE891 = "role891";
	public static final String STATUS890 = "status890";
	public static final String STATUS891 = "status891";
	public static final String PAIXU = "paixu";
	public static final String REMARK1 = "remark1";
	public static final String REMARK2 = "remark2";
	public static final String OPNUMBER = "opnumber";



    
    public void save(UserInfo transientInstance) {
        log.debug("saving UserInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserInfo persistentInstance) {
        log.debug("deleting UserInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserInfo findById( java.lang.Integer id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
            UserInfo instance = (UserInfo) getSession()
                    .get("UserInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserInfo instance) {
        log.debug("finding UserInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("UserInfo")
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
      log.debug("finding UserInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByPosition(Object position
	) {
		return findByProperty(POSITION, position
		);
	}
	
	public List findByAuthority(Object authority
	) {
		return findByProperty(AUTHORITY, authority
		);
	}
	
	public List findByIdentity(Object identity
	) {
		return findByProperty(IDENTITY, identity
		);
	}
	
	public List findByWorkdate(Object workdate
	) {
		return findByProperty(WORKDATE, workdate
		);
	}
	
	public List findByCcbdate(Object ccbdate
	) {
		return findByProperty(CCBDATE, ccbdate
		);
	}
	
	public List findByZxdate(Object zxdate
	) {
		return findByProperty(ZXDATE, zxdate
		);
	}
	
	public List findByWorkyears(Object workyears
	) {
		return findByProperty(WORKYEARS, workyears
		);
	}
	
	public List findByPassport(Object passport
	) {
		return findByProperty(PASSPORT, passport
		);
	}
	
	public List findByHkpassport(Object hkpassport
	) {
		return findByProperty(HKPASSPORT, hkpassport
		);
	}
	
	public List findByTwpassport(Object twpassport
	) {
		return findByProperty(TWPASSPORT, twpassport
		);
	}
	
	public List findByYearall(Object yearall
	) {
		return findByProperty(YEARALL, yearall
		);
	}
	
	public List findByRole890(Object role890
	) {
		return findByProperty(ROLE890, role890
		);
	}
	
	public List findByRole891(Object role891
	) {
		return findByProperty(ROLE891, role891
		);
	}
	
	public List findByStatus890(Object status890
	) {
		return findByProperty(STATUS890, status890
		);
	}
	
	public List findByStatus891(Object status891
	) {
		return findByProperty(STATUS891, status891
		);
	}
	
	public List findByPaixu(Object paixu
	) {
		return findByProperty(PAIXU, paixu
		);
	}
	
	public List findByRemark1(Object remark1
	) {
		return findByProperty(REMARK1, remark1
		);
	}
	
	public List findByRemark2(Object remark2
	) {
		return findByProperty(REMARK2, remark2
		);
	}
	
	public List findByOpnumber(Object opnumber
	) {
		return findByProperty(OPNUMBER, opnumber
		);
	}
	


	
    public UserInfo merge(UserInfo detachedInstance) {
        log.debug("merging UserInfo instance");
        try {
            UserInfo result = (UserInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserInfo instance) {
        log.debug("attaching dirty UserInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserInfo instance) {
        log.debug("attaching clean UserInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
	public UserInfo findAllById( int id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
        	String queryString = "from UserInfo as ui where ui.id="+id;
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
	/**
	 * 查询需要打卡的普通员工（不含员工响应）
	 * @return
	 */
	public List findAllForKqjl() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where (ui.position like '2____' or ui.position like '3____' or ui.position like '4____') and (ui.position like '__1__' or ui.position like '__2__' or ui.position like '__3__')";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 查询需要打卡的所有员工（员工响应）
	 * @return
	 */
	public List findAllForYgxy() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.position like '2_4__' or ui.position like '3_4__' or ui.position like '4_4__'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 查询需要打卡的所有员工（项目组）
	 * @return
	 */
	public List findAllForXMZ() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.position like '__5__' and ui.username not like '%B%'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 查询所有排班人员
	 * @return
	 */
	public List<UserInfo> findAllForPb(String month) {
		log.debug("finding all UserInfo instances");
		try {
			String names = "";
			PbMxDAO pmdao = new PbMxDAO();
			UserInfoDAO uidao = new UserInfoDAO();
			ScpbTeamDAO stdao = new ScpbTeamDAO();
			List<ScpbTeam> listst = stdao.findAllMaxNum();
			List<UserInfo> listui = new ArrayList<UserInfo>();
			String sql = "select * from user_info as ui where ui.username in (select name from t_pb_mx where date>='"+month+"01' and date<='"+month+"31')";
			listui = getSession().createSQLQuery(sql).addEntity(UserInfo.class).list();
//			for(int i=0;i<listst.size();i++)
//			{
//				ScpbTeam st = listst.get(i);
//				names+=st.getLeader();
//				names+="、";
//				names+=st.getMember();
//				names+="、";
//			}
//			String[] namesuzu = names.split("、");
//			for(int j=0;j<namesuzu.length;j++)
//			{
//				UserInfo ui = uidao.findByName(namesuzu[j]);
//				if(ui!=null)
//				{
//					listui.add(ui);
//				}
//			}
			return listui;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 *  and ui.position not like '__5__'
	 * 查询需要打卡的所有员工
	 * @return
	 */
	public List findAllDaKaYuanGong() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.position not like '0____' and ui.username not like '%B%' and ui.username not like '%管理%' and ui.newnumber!='20186393' and ui.position!='10000' and ui.position not like '9____' and ui.position not like '__4__'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 查询指定的人
	 * @return
	 */
	public List findAllByNames() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.username in ('王豆豆','陈道婷','谢炯') and ui.position not like '0____' and ui.position not like '1____' and ui.position not like '9____' and ui.position not like '__5__'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 查询需要打卡的所有员工
	 * @return
	 */
	public List findAllDaKaYuanGongByTeam(String team) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.position like'"+team+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 根据权限查询，返回list
	 * @param authority
	 * @return
	 */
	public List<UserInfo> findAllByAuthority(String authority) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.authority like '%"+authority+"%' and length(ui.newnumber)=8 order by paixu";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 涉及分组情况
	 * 根据权限,分组查询，，返回list
	 * @param authority
	 * @return
	 */
	public List<UserInfo> findZuZhangByAuthorityAndZu(String authority,String chu,String zu) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.authority like '%"+authority+"%' and ui.position like '__"+chu+"_"+zu+"' order by paixu";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 涉及分组情况
	 * 根据权限,分组查询，，返回list
	 * @param authority
	 * @return
	 */
	public List<UserInfo> findTuanByAuthorityAndChu(String authority,String chu) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.authority like '%"+authority+"%' and ui.position like '__"+chu+"__' and length(ui.newnumber)=8 order by paixu";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * 根据position查询匹配的审批人
	 * @return
	 */
	public List<UserInfo> findAllByPosition1(String position) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString="";
			if(position.equals("sc"))
			{
				queryString = "from UserInfo as ui where mid(ui.position,3,1) in ('3','6','2') and ui.username not like '%B' order by paixu";
			}
			else
			{
				queryString = "from UserInfo as ui where ui.position like '"+position+"' and ui.username not like '%B' order by paixu";
			}
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
    
    public List findAllByNameList(String name) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    public int findChuByName(String name) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 List list = queryObject.list();
    		 if(list.isEmpty())
    		 {
    			 return -1;
    		 }
    		 else
    		 {
    			 UserInfo ui = (UserInfo) list.get(0);
    			 String chu = ui.getPosition().substring(2, 3);
    			 return Integer.parseInt(chu);
    		 }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
  
    /**
     * 根据position查询匹配的审批人(计划外)
     * @return
     */
    public List<UserInfo> findAllByPositionOut(String position,String authority) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.position like '"+position+"' or ui.authority like '%"+authority+"%' order by paixu";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    //根据申请人查询记录
    public UserInfo findByName(String username) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username=:u order by paixu";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",username);
             List<UserInfo> list = queryObject.list();
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
    //根据申请人新一代工号查询记录
    public UserInfo findByNewNumber(String newnumber) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.newnumber=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",newnumber);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    
    public UserInfo findByOpnumber(String opnumber) {
    	log.debug("finding all UserInfo instances");
    	try {
    		 String queryString = "from UserInfo as ui where ui.opnumber=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",opnumber);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    //根据名字查新一代编号
    public String nameToNewnumber(String name) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",name);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return "notfound";
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui.getNewnumber();
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    //根据名字查新一代编号
    public String nameToNewnumbernull(String name) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",name);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return "";
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui.getNewnumber();
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

    /**
     * 根据权限和职务查询审批人
     * @param authority
     * @param position
     * @return
     */
    public List<UserInfo> findByAuthorityAndPosition(String authority,String position)
    {
    	
    		List<UserInfo> listtemp = new ArrayList<UserInfo>();
    		List<UserInfo> list = new ArrayList<UserInfo>();
    		if(authority.equals("C")||authority.equals("B"))
        	{
    			listtemp=findTuanByAuthorityAndChu(authority,position.substring(2,3));
        	}
        	else if(authority.equals("D"))
        	{
        		listtemp=findZuZhangByAuthorityAndZu(authority,position.substring(2, 3),position.substring(4,5));
        	}
        	else
        	{
        		listtemp=findAllByAuthority(authority);
        	}
    		
    		list = UserlistToSelectlist(listtemp);
    		return list;
    }

    /**
     * 查询出来的userlist 转成下拉选择框中的list
     * @param listtemp
     * @return
     */
    public List<UserInfo> UserlistToSelectlist(List<UserInfo> listtemp)
    {
    	List<UserInfo> list = new ArrayList<UserInfo>();
    	if(!listtemp.isEmpty())
    	{
    		for(int i=0;i<listtemp.size();i++)
    		{
    			UserInfo uitemp = listtemp.get(i);
    			UserInfo uithis = new UserInfo();
    			String temppos = uitemp.getPosition();
    			String tempautho=uitemp.getAuthority().substring(16,17);
    			String tempstr = "";
    			String tempchu = temppos.substring(2,3);
    			String tempzhi = temppos.substring(0,1);
    			String tempzu = temppos.substring(4,5);
    			if(tempzhi.equals("0"))
    			{
    				tempstr = "中心负责人（"+uitemp.getUsername()+"）";
    			}
    			else if((tempchu.equals("1"))&&(!tempautho.equals("Q")))
    			{
    				tempstr = "综合与生产管理处（"+uitemp.getUsername()+"）";
    			}
    			else if(tempchu.equals("2"))
    			{
    				tempstr = "合规与监督二处（"+uitemp.getUsername()+"）";
    			}
    			else if(tempautho.equals("Q"))
    			{
    				tempstr = "门禁管理员（"+uitemp.getUsername()+"）";
    			}
    			else if(tempchu.equals("3"))
    			{
    				if(tempzhi.equals("2")||tempzhi.equals("1"))
    				{
    					tempstr = "通用业务二处（"+uitemp.getUsername()+"）";
    				}
    				else
    				{
    					tempstr = "业务处理"+tempzu+"组（"+uitemp.getUsername()+"）";
    				}
    			}
    			else if(tempchu.equals("4"))
    			{
    				tempstr = "员工响应团队（"+uitemp.getUsername()+"）";
    			}
    			else if(tempchu.equals("5"))
    			{
    				tempstr = "研发支持二处（"+uitemp.getUsername()+"）";
    			}
    			else if(tempchu.equals("6"))
    			{
    				if(tempzhi.equals("2")||tempzhi.equals("1"))
    				{
    					tempstr = "专业处理二处（"+uitemp.getUsername()+"）";
    				}
    				else
    				{
    					tempstr = "专业处理"+tempzu+"组（"+uitemp.getUsername()+"）";
    				}
    			}
    			uithis.setUsername(tempstr);
    			uithis.setNewnumber(uitemp.getNewnumber());
    			list.add(uithis);
    		}
    	}
    	return list;
    }


    public String findBoss(String authority,String position)
    {
    	String bossname = "";
    	List<UserInfo> list = findByAuthorityAndPosition(authority,position);
    	for(int i=0;i<list.size();i++)
    	{
    		UserInfo ui = list.get(list.size()-i-1);
    		bossname = ui.getUsername()+":"+ui.getNewnumber()+";"+bossname;
    	}
    	 if(bossname.length()>0)
    	        bossname=bossname.substring(0,bossname.length()-1);
    	return bossname;
    }
}