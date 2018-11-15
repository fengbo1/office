package office.userinfo.action;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.config.dao.ConfigDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.config.pojo.Config;
import office.kqjl.dao.KqjlUploadDAO;
import office.kqjl.pojo.KqjlUpload;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.zcgl.pojo.AssetBorrow;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport implements ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	
	private Session h_session;
    private Transaction trans;
    private String hql;
    private Query query;
    private int errNum = 0;
    private int restNum;
    private int isneedalert=0;
    
    Timestamp d = new Timestamp(System.currentTimeMillis());
    
    
	public int getIsneedalert() {
		return isneedalert;
	}


	public void setIsneedalert(int isneedalert) {
		this.isneedalert = isneedalert;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}




	public Session getSession() {
		return h_session;
	}


	public void setSession(Session h_session) {
		this.h_session = h_session;
	}


	public Transaction getTrans() {
		return trans;
	}


	public void setTrans(Transaction trans) {
		this.trans = trans;
	}


	public String getHql() {
		return hql;
	}


	public void setHql(String hql) {
		this.hql = hql;
	}


	public Query getQuery() {
		return query;
	}


	public void setQuery(Query query) {
		this.query = query;
	}
     public void setServletResponse(HttpServletResponse response)
       {
       }

	public String execute() throws Exception
	{
	/*固定写法*/
		DateUtil du = new DateUtil();
		ConfigDAO cfgdao = new ConfigDAO();
		  int views = 0;//访问量统计
		  h_session=HibernateSessionFactory.getSession();
		  trans=h_session.beginTransaction();
		 // ifKQQSDisabled(h_session);//考勤缺失
		  Config config = cfgdao.findAllByName("times");
		  username=new String(username.getBytes("ISO8859-1"),"UTF-8");
		  hql="select user from UserInfo as user where user.username=:u";
		  query=h_session.createQuery(hql);
		  query.setString("u",username);//设置查询参数
		//  query.setString("p",password);//设置查询参数
		  System.out.println(username+":"+hql);
          List l=query.list();
     	  if((l==null)||(l.size()<=0))
     	  {
     		  this.addFieldError("用户","用户不存在!");
			  return "false";
     	  }
     	  else 
     	  {
     		  UserInfo u=(UserInfo)(l.get(0));
     		  id=u.getId();
     		  username = this.getUsername();
     		
     		  System.out.print("username:"+username);
     		 
     		  System.out.print("DBpwd:"+u.getPassword());
     		 if(ActionContext.getContext().getSession().get(username) == null)
 			 {
 				 errNum = 0;
 			 }
 			 else{
 				 errNum=(Integer)ActionContext.getContext().getSession().get(username);
 			 }
 			 System.out.print(ActionContext.getContext().getSession().get(username));
 			 if(errNum>=5)
 			 {
 				this.addFieldError("用户","该用户已经被锁定,请找管理员解锁");
				return "false";
 			 }
     		 /* if(!password.equals(u.getPassword()))
     		  {
     			 if(errNum==0)
        		  {
        			 errNum = errNum+1;
        			 ActionContext.getContext().getSession().put(username,errNum);  
        			 this.addFieldError("用户","你已经输入错误1次，还有4次");
       			  	 return "false";
        		  }
     			 else 
     			 {
     					restNum = 5-errNum;
     					this.addFieldError("用户","你已经输入错误"+errNum+"次，还有"+restNum+"次");
     					errNum = errNum+1;
     					ActionContext.getContext().getSession().put(username,errNum);  
     					return "false";
     			 }
     			
     		  }*/
     		  String authM=u.getAuthority().substring(12,13);
     		  String authN=u.getAuthority().substring(13,14);
     		  if(authN.equals("N"))
     		  {
     			  String chuzc=u.getPosition().substring(2,3);
     			  int chuzcint =Integer.parseInt(chuzc);
     			  String hql1="from AssetBorrow as ab where ab.status=17 and ab.isreturn=0 and ab.isandborrow=0 and ab.name='"+username+"'order by ab.returntime ";
     			  query=h_session.createQuery(hql1);
     			  List<AssetBorrow> listzcb=query.list();
     			  String date1="";
     			  if(listzcb.size()!=0)
     			  {	  
     			  AssetBorrow ab = listzcb.get(0);
     			  date1=ab.getReturntime();
     			  }
     			  // String hql2="select a.returntime from AssetAndborrow a ,AssetBorrow b where a.borrownumber=b.number and a.status=4 and b.name='"+username+"'and b.isreturn=0 and b.isandborrow=1 order by a.returntime ";
     			  // query=h_session.createQuery(hql2);
     			 // List<String> listtime=query.list();
     			  String date2="";
     			 /* if(listtime.size()!=0)
     			  {
     		      date2=listtime.get(0);
     			  }*/
     			  String nowdate = du.getStringDate();
     			  String bd = nowdate.replace("-","");
     			  String ed1 = date1.replace("-","");
     			  String ed2 = date2.replace("-","");
     			  if(!ed1.equals("")&&!ed2.equals(""))
     			  {
     				 int result = ed1.compareTo(ed2);
     				 if(result<0)
     				 {
     					int result1=bd.compareTo(ed2);
     					if(result1<0)
     					{	
     					double days = du.getDaysByBegindateAndEnddate(h_session,bd,ed2);
     					isneedalert=(int)days;
     					}
     					else
         				 {
         					 isneedalert=2000;  					 
         				 }
     				 }
     				 else
     				 {
     					int result2=bd.compareTo(ed1);
     					if(result2<0)
     					{	
     					double days = du.getDaysByBegindateAndEnddate(h_session,bd,ed1);
     					isneedalert=(int)days;
     					}
     					else
         				 {
         					isneedalert=2000;  					 
         				 }
     				  }
     			    }
     			    if(ed1.equals("")&&!ed2.equals(""))
     			    {
     			    	int result1=bd.compareTo(ed2);
     					if(result1<0)
     					{	
     					double days = du.getDaysByBegindateAndEnddate(h_session,bd,ed2);
     					isneedalert=(int)days;
     					}
     					else
         				 {
         					 isneedalert=2000;  					 
         				 }
     			    }
     			    if(!ed1.equals("")&&ed2.equals(""))
    			    {
     			    	int result2=bd.compareTo(ed1);
     					if(result2<0)
     					{	
     					double days = du.getDaysByBegindateAndEnddate(h_session,bd,ed1);
     					isneedalert=(int)days;
     					}
     					else
         				 {
         					isneedalert=2000;  					 
         				 }
    			    }
     			  }
     		  
     		  System.out.print("time1"+d);
        	  ActionContext.getContext().getSession().put("username",u.getUsername());
        	 // ActionContext.getContext().getSession().put("password",u.getPassword());
        	  ActionContext.getContext().getSession().put("zhi",u.getPosition().substring(0,1));//30303
        	  ActionContext.getContext().getSession().put("chu",u.getPosition().substring(2,3));//30303
        	  ActionContext.getContext().getSession().put("zu",u.getPosition().substring(4,5));//30303
        	  ActionContext.getContext().getSession().put("id",id);
        	  ActionContext.getContext().getSession().put("isneedalert",isneedalert);
        	  ActionContext.getContext().getSession().put("newnumber",u.getNewnumber());
        	  ActionContext.getContext().getSession().put("year",du.getThisYear());
        	  ActionContext.getContext().getSession().put("autho",u.getAuthority());
        	  ActionContext.getContext().getSession().put("authoA",u.getAuthority().substring(0,1));
        	  ActionContext.getContext().getSession().put("authoB",u.getAuthority().substring(1,2));
        	  ActionContext.getContext().getSession().put("authoC",u.getAuthority().substring(2,3));
        	  ActionContext.getContext().getSession().put("authoD",u.getAuthority().substring(3,4));
        	  ActionContext.getContext().getSession().put("authoE",u.getAuthority().substring(4,5));
        	  ActionContext.getContext().getSession().put("authoF",u.getAuthority().substring(5,6));
        	  ActionContext.getContext().getSession().put("authoG",u.getAuthority().substring(6,7));
        	  ActionContext.getContext().getSession().put("authoH",u.getAuthority().substring(7,8));
        	  ActionContext.getContext().getSession().put("authoI",u.getAuthority().substring(8,9));
        	  ActionContext.getContext().getSession().put("authoJ",u.getAuthority().substring(9,10));
        	  ActionContext.getContext().getSession().put("authoK",u.getAuthority().substring(10,11));
        	  ActionContext.getContext().getSession().put("authoL",u.getAuthority().substring(11,12));
        	  ActionContext.getContext().getSession().put("authoM",u.getAuthority().substring(12,13));
        	  ActionContext.getContext().getSession().put("authoN",u.getAuthority().substring(13,14));
        	  ActionContext.getContext().getSession().put("authoO",u.getAuthority().substring(14,15));
        	  ActionContext.getContext().getSession().put("authoP",u.getAuthority().substring(15,16));
        	  ActionContext.getContext().getSession().put("authoQ",u.getAuthority().substring(16,17));
        	  ActionContext.getContext().getSession().put("authoR",u.getAuthority().substring(17,18));
        	  ActionContext.getContext().getSession().put("authoS",u.getAuthority().substring(18,19));
        	  ActionContext.getContext().getSession().put("authoT",u.getAuthority().substring(19,20));
        	  
        	  config.setValue(config.getValue()+1);
        	  ActionContext.getContext().getSession().put("views",config.getValue());
        	  cfgdao.merge(config);
        	  //访问量统计
//        	  HttpSession session=null;
//        	  session.setAttribute("user", this.getUsername());
        	  trans.commit();
        	  h_session.flush();
        	  h_session.clear();
        	  h_session.close();
        	  return "success";
     	  }
     	 
	}
	public String ifKQQSDisabled(Session session)
	{
		DateUtil du = new DateUtil();
		KqqsPageDAO kpdao = new KqqsPageDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();
		KqjlUploadDAO kudao = new KqjlUploadDAO();
		String nowdate = du.getStringDate();
		String premonth = du.getLastMonth(nowdate.substring(0, 6));
		//int date = Integer.parseInt(nowdate.substring(6,8));//20160417
		int date = du.countThisMonthWorkdaysByDate(session, nowdate);
		KqjlUpload ku = kudao.findAllByMonth(premonth);
		if((date>3)&&(ku.getIfkqqsdisabled()==0))//如果大于3个工作日，补上月的考勤缺失无效
		{
			List<KqqsPage> list = kpdao.findAllByDateAndStatus(premonth, 2);
			for(int i=0;i<list.size();i++)
			{
				KqqsPage kp = list.get(i);
				kp.setStatus(5);//修改为已退回状态
 				kp.setPreunder(null);
 				kp.setThisunder(null);//下一处理人是自己
 				kp.setJindu(kp.getJindu().substring(0,1));
 				//在被退回时次数减1
 				List<KqqsPage> listkp = kpdao.findAllByQsMonthAndNewnumber(kp.getQsdate().substring(0, 6),kp.getApplicant());
 				if((!listkp.isEmpty()))
 				{
 					if(listkp.size()>0)
 					{
 						for(int j=0;i<listkp.size();i++)
 						{
 							KqqsPage kptemp  = listkp.get(i);
 							kptemp.setCs(i+1);
 						}
 						
 					}
 				}
 				kp.setCs(null);
 				lpro.setNumber(kp.getNumber());
 	 			lpro.setTime(du.getSimpleDateTime());
 	 			lpro.setViewer("自助办公工具");
 	 			lpro.setViewernewnumber("");
 	 			lpro.setAuthority("");
 	 			lpro.setRemark("超过次前3个工作日，工具自动退回未审批的考勤缺失申请");
 	 			lpro.setOpinion(2);
 				kpdao.merge(kp);
 				lpdao.merge(lpro);
			}
			String sql = "update t_kqjl_daily set qtqs=2 where qtqs=1 and date>='"+premonth+"01' and date<='"+premonth+"31'";
			session.createSQLQuery(sql).executeUpdate();
			sql = "update t_kqjl_daily set qdqs=2 where qdqs=1 and date>='"+premonth+"01' and date<='"+premonth+"31'";
			session.createSQLQuery(sql).executeUpdate();
			ku.setIfkqqsdisabled(1);
			kudao.merge(ku);
		}
		return "success";
	}
	/**
	 * 管理员专用
	 * 手工触发考勤缺失失效功能
	 * @param session
	 * @return
	 */
	public String ifKQQSDisabledForManager(Session session)
	{
		DateUtil du = new DateUtil();
//		KqqsPageDAO kpdao = new KqqsPageDAO();
//		LeaveProcessDAO lpdao = new LeaveProcessDAO();
//		LeaveProcess lpro = new LeaveProcess();
		KqjlUploadDAO kudao = new KqjlUploadDAO();
		String nowdate = du.getStringDate();
		String premonth = du.getLastMonth(nowdate.substring(0, 6));
//		premonth = "201607";
		//int date = Integer.parseInt(nowdate.substring(6,8));//20160417
//		int date = du.countThisMonthWorkdaysByDate(session, nowdate);
		KqjlUpload ku = kudao.findAllByMonth(premonth);
//		List<KqqsPage> list = kpdao.findAllByDateAndStatus(premonth, 2);
//		for(int i=0;i<list.size();i++)
//		{
//			KqqsPage kp = list.get(i);
//			kp.setStatus(5);//修改为已退回状态
//				kp.setPreunder(null);
//				kp.setThisunder(null);//下一处理人是自己
//				kp.setJindu(kp.getJindu().substring(0,1));
//				//在被退回时次数减1
//				List<KqqsPage> listkp = kpdao.findAllByQsMonthAndNewnumber(kp.getQsdate().substring(0, 6),kp.getApplicant());
//				if((!listkp.isEmpty()))
//				{
//					if(listkp.size()>0)
//					{
//						for(int j=0;i<listkp.size();i++)
//						{
//							KqqsPage kptemp  = listkp.get(i);
//							kptemp.setCs(i+1);
//						}
//						
//					}
//				}
//				kp.setCs(null);
//				lpro.setNumber(kp.getNumber());
//	 			lpro.setTime(du.getSimpleDateTime());
//	 			lpro.setViewer("自助办公工具");
//	 			lpro.setViewernewnumber("");
//	 			lpro.setAuthority("");
//	 			lpro.setRemark("超过次前3个工作日，工具自动退回未审批的考勤缺失申请");
//	 			lpro.setOpinion(2);
//				kpdao.merge(kp);
//				lpdao.merge(lpro);
//		}
		String sql = "update t_kqjl_daily set qtqs=2 where qtqs=1 and date>='"+premonth+"01' and date<='"+premonth+"31'";
		session.createSQLQuery(sql).executeUpdate();
		System.out.println(sql);
		sql = "update t_kqjl_daily set qdqs=2 where qdqs=1 and date>='"+premonth+"01' and date<='"+premonth+"31'";
		session.createSQLQuery(sql).executeUpdate();
		System.out.println(sql);
		ku.setIfkqqsdisabled(1);
		kudao.merge(ku);	
		return "success";
	}
	
}
