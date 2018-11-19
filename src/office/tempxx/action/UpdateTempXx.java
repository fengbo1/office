package office.tempxx.action;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.ScpbTeam;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.tempxx.dao.TPeopleworkDAO;
import office.tempxx.dao.TTempxiaxianDAO;
import office.tempxx.dao.TUpdateTimeDAO;
import office.tempxx.pojo.TPeoplework;
import office.tempxx.pojo.TTempxiaxian;
import office.tempxx.pojo.TUpdateTime;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;
import office.util.DateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class UpdateTempXx {
	   private LeavePage lp;
	   private LeavePageDAO lpdao;
	   private XxsqPage xp;
	   private XxsqPageDAO xpdao;
	   private MyCalendar mc;
	   private MyCalendarDAO mcdao;
	   private TPeoplework tw;
	   private TPeopleworkDAO twdao;
	   private UserInfo ui;
	   private UserInfoDAO uidao;
	   private TUpdateTime tt;
	   private TUpdateTimeDAO ttdao;
	   private TTempxiaxian tx;
	   private TTempxiaxianDAO txdao;
	   private String tip;
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public TTempxiaxian getTx() {
		return tx;
	}
	public void setTx(TTempxiaxian tx) {
		this.tx = tx;
	}
	public TTempxiaxianDAO getTxdao() {
		return txdao;
	}
	public void setTxdao(TTempxiaxianDAO txdao) {
		this.txdao = txdao;
	}
	public TUpdateTime getTt() {
		return tt;
	}
	public void setTt(TUpdateTime tt) {
		this.tt = tt;
	}
	public TUpdateTimeDAO getTtdao() {
		return ttdao;
	}
	public void setTtdao(TUpdateTimeDAO ttdao) {
		this.ttdao = ttdao;
	}
	public LeavePage getLp() {
		return lp;
	}
	public void setLp(LeavePage lp) {
		this.lp = lp;
	}
	public LeavePageDAO getLpdao() {
		return lpdao;
	}
	public void setLpdao(LeavePageDAO lpdao) {
		this.lpdao = lpdao;
	}
	public XxsqPage getXp() {
		return xp;
	}
	public void setXp(XxsqPage xp) {
		this.xp = xp;
	}
	public XxsqPageDAO getXpdao() {
		return xpdao;
	}
	public void setXpdao(XxsqPageDAO xpdao) {
		this.xpdao = xpdao;
	}
	public MyCalendar getMc() {
		return mc;
	}
	public void setMc(MyCalendar mc) {
		this.mc = mc;
	}
	public MyCalendarDAO getMcdao() {
		return mcdao;
	}
	public void setMcdao(MyCalendarDAO mcdao) {
		this.mcdao = mcdao;
	}
	public TPeoplework getTw() {
		return tw;
	}
	public void setTw(TPeoplework tw) {
		this.tw = tw;
	}
	public TPeopleworkDAO getTwdao() {
		return twdao;
	}
	public void setTwdao(TPeopleworkDAO twdao) {
		this.twdao = twdao;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public UserInfoDAO getUidao() {
		return uidao;
	}
	public void setUidao(UserInfoDAO uidao) {
		this.uidao = uidao;
	}
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    ttdao = new TUpdateTimeDAO();
 	    uidao = new UserInfoDAO();
 	    lpdao = new LeavePageDAO();
 	    xpdao = new XxsqPageDAO();
 	    twdao = new TPeopleworkDAO();
 	    txdao = new TTempxiaxianDAO();
 	    tx = new TTempxiaxian();
		tt = ttdao.findAllByLastId();
	    List<MyCalendar> listmc;
	    List<MyCalendar> listmclp;
	    List<MyCalendar> listmcxp;
	    List<LeavePage>listlp;
	    List<XxsqPage>listxp;
	    Date now = new Date();
	    SimpleDateFormat dateform = new SimpleDateFormat("yyyyMMdd");
	    String begindate = tt.getDate();
	    String enddate = dateform.format(now);
	    MyCalendarDAO mcdao=new MyCalendarDAO();
		MyCalendar mc = new MyCalendar();
		TUpdateTime ttnew = new TUpdateTime();
		ttnew.setDate(enddate);
		ttnew.setStatus("0");
		listmc = mcdao.findByBeginAndEnd(begindate, enddate, 1);
	   //计算更新时间段内请假表和因公下线表计划外
		for(int i=0;i<listmc.size();i++)
	 	    { 	    	
	 	    	mc=listmc.get(i);
	 	    	String date = mc.getDate();
	 	    	listlp=lpdao.findAllByDate(date);
	 	    	for(int j=0;j<listlp.size();j++)
	 	    	{
	 	    		lp=listlp.get(j);
	 	    		double days = lp.getDays();
	 	    		if(days>=1)
	 	    		{
	 	    			String begindatelp=lp.getBegindate();
		 	    		String enddatelp=lp.getEnddate();
		 	    		String newnumberlp=lp.getApplicant();
		 	    		ui = uidao.findByNewNumber(newnumberlp);
		 	    		String position = ui.getPosition();
		 	    		String chu = position.substring(2, 3);
		 	 	 	    String zhi = position.substring(0, 1);
		 	 	 	    String zu = position.substring(4, 5);
		 	 	 	    String opnumber = ui.getOpnumber();
		 	 	 	    String numberlp = lp.getNumber();
		 	 	 	    String name = ui.getUsername();
		 	 	 	    List<String> listdate = new ArrayList<String>();
		 	    		listmclp = mcdao.findByBeginAndEnd(begindatelp, enddatelp, 1);
		 	    		int flag = 0;
		 	    		for(int k=0;k<listmclp.size();k++)
		 	 	 	    {
		 	 	 	    	
		 	 	 	    	mc=listmclp.get(k);
		 	 	 	    	tw = twdao.findAllByOpNumber(opnumber, mc.getDate());
		 	 	 	    	if((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&!(zhi.equals("2"))&&!(zhi.equals("1")))
		 	 	 	    	{
		 	 	 	    		if((tw==null)||(tw.getStatus().equals("上线")))
		 	 	 	    	
		 	 	 	  	 	    {
		 	 	 	  	 	    	flag=flag+1;
		 	 	 	  	 	    }
		 	 	 	    		else
		 	 	 	    		{
		 	 	 	    			listdate.add(mc.getDate());
		 	 	 	    		}
		 	 	 	    	}
		 	 	 	    }
		 	    		if(flag!=0)
		 	    		{
		 	    			TTempxiaxian txtt = new TTempxiaxian();
		 	    			txtt = txdao.findAllByNumber(numberlp);
		 	    			if(txtt==null)
		 	    			{
		 	    			String begintime=""; 
		 	    			String endtime="";
		 	    			if(listdate.size()>0)
		 	    			{	
		 	    			   begintime=listdate.get(0);
		 	    			   for(int b=0;b<listdate.size();b++)
			 	    			{
			 	    				endtime=listdate.get(b);
			 	    			}
		 	    			}
		 	    					 	    	
		 	    			tx.setBegindate(begindatelp);
		 	    			tx.setChu(chuToName(chu));
		 	    			tx.setEnddate(enddatelp);
		 	    			tx.setName(ui.getUsername());
		 	    			tx.setOpnumber(opnumber);
		 	    			tx.setOpzu(changenametozu(name));
		 	    			//tx.setOpzu( );
		 	    			tx.setReason("请休假");
		 	    			tx.setRelatednumber(lp.getNumber());
		 	    			tx.setReportdate(enddate);
		 	    			tx.setShuoming("("+typetoname(lp.getType())+")");
		 	    			tx.setZu(changenametozu(name));
		 	    			tx.setRemark("");
		 	    			ttnew.setStatus("1");
		 	    			if(enddate.compareTo(begindatelp)>=0)
		 	    			{
		 	    				tx.setRemark("补报");
		 	    			}
		 	    			if((begintime!="")&&(endtime!=""))
		 	    			{
		 	    				tx.setRemark(begintime+"到"+endtime+"已报下线计划");
		 	    			}
		 	    			if((enddate.compareTo(begindatelp)>=0)&&(begintime!="")&&(endtime!=""))
		 	    			{
		 	    				tx.setRemark("补报，"+begintime+"到"+endtime+"已报下线计划");
		 	    			}
		 	    			txdao.merge(tx);
		 	    			}
		 	    		}
	 	    		}	
	 	    
	 	    	}
	 	    	listxp=xpdao.findByDate(date);
	 	    	for(int k=0;k<listxp.size();k++)
	 	    	{
	 	    		xp=listxp.get(k);
	 	    		if((xp.getReason()!=9)&&(xp.getDay()>=1))
	 	    		{		
	 	    		String begindatexp=xp.getBegindate();
	 	    		String enddatexp=xp.getEnddate();
	 	    		String people = xp.getPeople();
	 	    		String []names = people.split("、");
	 	    		String numberxp = xp.getNumber();
	 	    	   // List<String> listdate = new ArrayList<String>();
	 	    		for(int m=0;m<names.length;m++)
	 	    		{
	 	    			String name = names[m];
	 	    			ui = uidao.findByName(name);
		 	    		String position = ui.getPosition();
		 	    		String chu = position.substring(2, 3);
		 	 	 	    String zhi = position.substring(0, 1);
		 	 	 	    String zu = position.substring(4, 5);
		 	 	 	    String opnumber = ui.getOpnumber();
		 	 	 	    List<String> listdate = new ArrayList<String>();
		 	    		listmcxp = mcdao.findByBeginAndEnd(begindatexp, enddatexp, 1);
		 	    		int flag = 0;
		 	    		for(int n=0;n<listmcxp.size();n++)
		 	 	 	    {
		 	 	 	    	
		 	 	 	    	mc=listmcxp.get(n);
		 	 	 	    	tw = twdao.findAllByOpNumber(opnumber, mc.getDate());
		 	 	 	    	if((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&!(zhi.equals("2"))&&!(zhi.equals("1")))
		 	 	 	    	{
		 	 	 	    		if((tw==null)||(tw.getStatus().equals("上线")))
		 	 	 	    	
		 	 	 	  	 	    {
		 	 	 	  	 	    	flag=flag+1;
		 	 	 	  	 	    }
		 	 	 	    		else
		 	 	 	    		{
		 	 	 	    			listdate.add(mc.getDate());
		 	 	 	    		}
		 	 	 	    	}
		 	 	 	    }
		 	    		if(flag!=0)
		 	    		{
		 	    			List<TTempxiaxian> listtxtt1 = new ArrayList<TTempxiaxian>();
		 	    			listtxtt1 = txdao.findAlllistByNumber(numberxp);
		 	    			int flag1=0;//判断是否已有此条记录
		 	    			if(listtxtt1!=null)
		 	    			{
		 	    				for(int d=0;d<listtxtt1.size();d++)
			 	    			{
			 	    				TTempxiaxian txtt1 = listtxtt1.get(d);
			 	    				if(name.equals( txtt1.getName()))
			 	    				{
			 	    					flag1=1;
			 	    				}
			 	    				
			 	    			}
		 	    			}	
		 	    			
		 	    			if(listtxtt1==null||flag1==0)
		 	    			{
		 	    				
		 	    				String begintime=""; 
			 	    			String endtime="";
			 	    			if(listdate.size()>0)
			 	    			{	
			 	    			   begintime=listdate.get(0);
			 	    			   for(int b=0;b<listdate.size();b++)
				 	    			{
				 	    				endtime=listdate.get(b);
				 	    			}
			 	    			}
		 	    				tx.setBegindate(begindatexp);
			 	    			tx.setChu(chuToName(chu));
			 	    			tx.setEnddate(enddatexp);
			 	    			tx.setName(ui.getUsername());
			 	    			tx.setOpnumber(opnumber);
			 	    			//tx.setOpzu( );
			 	    			tx.setOpzu(changenametozu(name));
			 	    			tx.setReason("因公下线");
			 	    			tx.setRelatednumber(xp.getNumber());
			 	    			tx.setReportdate(enddate);
			 	    			tx.setShuoming("("+ygxxReasonToString(xp.getReason())+")"+xp.getQita());
			 	    			tx.setZu(changenametozu(name));
			 	    			tx.setRemark("");
			 	    			ttnew.setStatus("1");
			 	    			if(enddate.compareTo(begindatexp)>=0)
			 	    			{
			 	    				tx.setRemark("补报");
			 	    			}
			 	    			if((begintime!="")&&(endtime!=""))
			 	    			{
			 	    				tx.setRemark(begintime+"到"+endtime+"已报下线计划");
			 	    			}
			 	    			if((enddate.compareTo(begindatexp)>=0)&&(begintime!="")&&(endtime!=""))
			 	    			{
			 	    				tx.setRemark("补报，"+begintime+"到"+endtime+"已报下线计划");
			 	    			}
			 	    			txdao.merge(tx);
		 	    			}	 	    			
		 	    		}
	 	    		  }
	 	    		}
	 	    	}
	 	    	
	 	    //计算审批明细表中是否存在撤销的数据
	 	       	              
	 	       String year = date.substring(0, 4);
	 	       String month = date.substring(4, 6);
	 	       String day = date.substring(6, 8);
	 	       LeaveProcess lpro = new LeaveProcess();
	 	       LeaveProcessDAO lprodao = new LeaveProcessDAO();
	 	       List<LeaveProcess> listlpro = lprodao.findByDelete(year, month, day);
	 	       for(int l=0;l<listlpro.size();l++)
	 	       {
	 	    	   lpro = listlpro.get(l);
	 	    	   if((lpro.getNumber().contains("YGXX"))&&(lpro.getRemark().contains("已执行撤销员工")))
	 	    	   {
	 	    		   String temp1[]=lpro.getRemark().split("【");
	 	    		   String temp2[]=temp1[1].split("】");
	 	    		   String name = temp2[0];
	 	    		   XxsqPage xpdelete = xpdao.findAllByNumber(lpro.getNumber());
	 	    		    ui = uidao.findByName(name);
		 	    		String position = ui.getPosition();
		 	    		String chu = position.substring(2, 3);
		 	 	 	    String zhi = position.substring(0, 1);
		 	 	 	    String zu = position.substring(4, 5);
		 	 	 	    String opnumber = ui.getOpnumber();
		 	 	 	    TTempxiaxian txtt = new TTempxiaxian();
	 	    			txtt = txdao.findDeleteByNumberandName(lpro.getNumber(),name);
	 	    			TTempxiaxian txcun = new TTempxiaxian();
	 	    			txcun = txdao.findAllByNumberandName(lpro.getNumber(),name);
		 	 	  	   if((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&!(zhi.equals("2"))&&!(zhi.equals("1")))
		 	 	  	   {
		 	 	  		if((txtt==null)&&(txcun!=null))
		 	 	  		{
		 	 	  		tx.setBegindate(xpdelete.getBegindate());
	 	    			tx.setChu(chuToName(chu));
	 	    			tx.setEnddate(xpdelete.getEnddate());
	 	    			tx.setName(ui.getUsername());
	 	    			tx.setOpnumber(opnumber);
	 	    			//tx.setOpzu( );
	 	    			tx.setOpzu(changenametozu(name));
	 	    			tx.setReason(ygxxReasonToString(xpdelete.getReason()));
	 	    			tx.setRelatednumber(xpdelete.getNumber());
	 	    			tx.setReportdate(enddate);
	 	    			tx.setShuoming(xpdelete.getRemark());
	 	    			tx.setZu(changenametozu(name));
	 	    			tx.setRemark("已撤销");
	 	    			ttnew.setStatus("1");
	 	    			txdao.merge(tx);
		 	 	  		}
		 	 	  		
		 	 	  	   }
		 	 	 	    
	 	    	   }
	 	    	   
	 	    	   if((lpro.getNumber().contains("YGXX"))&&(lpro.getRemark().contains("撤销审批表")))
	 	    	   {
	 	    		   XxsqPage xpdelete = xpdao.findAllByNumber(lpro.getNumber());
	 	    		   String names[] = xpdelete.getPeople().split("、");
	 	    		   for(int p=0;p<names.length;p++)
	 	    		   {
	 	    			   String name = names[p];
	 	    			    ui = uidao.findByName(name);
			 	    		String position = ui.getPosition();
			 	    		String chu = position.substring(2, 3);
			 	 	 	    String zhi = position.substring(0, 1);
			 	 	 	    String zu = position.substring(4, 5);
			 	 	 	    String opnumber = ui.getOpnumber();
			 	 	 	    TTempxiaxian txtt = new TTempxiaxian();
		 	    			txtt = txdao.findDeleteByNumberandName(lpro.getNumber(),name);
		 	    			TTempxiaxian txcun = new TTempxiaxian();
		 	    			txcun = txdao.findAllByNumberandName(lpro.getNumber(),name);
			 	 	 	 if((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&!(zhi.equals("2"))&&!(zhi.equals("1")))
			 	 	 	 {
			 	 	 		if((txtt==null)&&(txcun!=null))
			 	 	 		{
			 	 	 			tx.setBegindate(xpdelete.getBegindate());
			 	    			tx.setChu(chuToName(chu));
			 	    			tx.setEnddate(xpdelete.getEnddate());
			 	    			tx.setName(ui.getUsername());
			 	    			tx.setOpnumber(opnumber);
			 	    			//tx.setOpzu( );
			 	    			tx.setOpzu(changenametozu(name));
			 	    			tx.setReason(ygxxReasonToString(xpdelete.getReason()));
			 	    			tx.setRelatednumber(xpdelete.getNumber());
			 	    			tx.setReportdate(enddate);
			 	    			tx.setShuoming(xpdelete.getRemark());
			 	    			tx.setZu(changenametozu(name));
			 	    			tx.setRemark("已撤销");
			 	    			ttnew.setStatus("1");
			 	    			txdao.merge(tx);
			 	 	 		}
			 	 	 		
			 	 	 	 }
			 	 	 	    
	 	    		   }
	 	    	   }
	 	    	   if((lpro.getNumber().contains("QJSQ"))&&(lpro.getRemark().contains("已撤销")))
	 	    	   {
	 	    		   LeavePage lpdelete = lpdao.findByNumber(lpro.getNumber());
	 	    		   String newnumber = lpdelete.getApplicant();
	 	    		   ui = uidao.findByNewNumber(newnumber);
	 	    		   String name = ui.getUsername();
	 	    		   String position = ui.getPosition();
		 	    		String chu = position.substring(2, 3);
		 	 	 	    String zhi = position.substring(0, 1);
		 	 	 	    String zu = position.substring(4, 5);
		 	 	 	    String opnumber = ui.getOpnumber();
		 	 	 	    TTempxiaxian txtt = new TTempxiaxian();
	 	    			txtt = txdao.findDeleteByNumber(lpro.getNumber());
	 	    			TTempxiaxian txcun = new TTempxiaxian();
	 	    			txcun = txdao.findAllByNumber(lpro.getNumber());
		 	 	 	 if((chu.equals("2")||chu.equals("6")||chu.equals("3"))&&!(zhi.equals("2"))&&!(zhi.equals("1")))
		 	 	 	 {
		 	 	 		    if((txtt==null)&&(txcun!=null))
		 	 	 		    {
		 	 	 		    	tx.setBegindate(lpdelete.getBegindate());
			 	    			tx.setChu(chuToName(chu));
			 	    			tx.setEnddate(lpdelete.getEnddate());
			 	    			tx.setName(ui.getUsername());
			 	    			tx.setOpnumber(opnumber);
			 	    			//tx.setOpzu( );
			 	    			tx.setOpzu(changenametozu(name));
			 	    			tx.setReason("请休假");
			 	    			tx.setRelatednumber(lpdelete.getNumber());
			 	    			tx.setReportdate(enddate);
			 	    			tx.setShuoming(lpdelete.getRemark());
			 	    			tx.setZu(changenametozu(name));
			 	    			tx.setRemark("已撤销");
			 	    			ttnew.setStatus("1");
			 	    			txdao.merge(tx);
		 	 	 		    }
		 	 	 		    
		 	 	 	 }
		 	 	 	   
	 	    	   }
	 	       }
	 	    }
		ttdao.merge(ttnew);
		TUpdateTime ttstatus = new TUpdateTime();
		ttstatus = ttdao.findAllByLastId();
		tip = ttstatus.getStatus();
	    trans.commit();
		session.flush();
		session.clear();
		session.close();
	    return "success";
	}
	
	public String changenametozu(String name)
	{
		int num ;
		String zu="无" ;
		UserInfoDAO uizudao = new UserInfoDAO();
		UserInfo uizu = uizudao.findByName(name);
		String position = ui.getPosition();
		String chu = position.substring(2, 3);
		if(chu.equals("2"))
		{
			zu="稽核团队";
			
		}
		else
		{
			ScpbTeam st = new ScpbTeam();
			ScpbTeamDAO stdao = new ScpbTeamDAO();
			st = stdao.findMaxNum();
			num = st.getNum();
			List<ScpbTeam> list = stdao.findAllItemMaxNum(num);
			for(int i =0;i<list.size();i++)
			{
				ScpbTeam stt = list.get(i);
				if(stt.getLeader().equals(name))
				{
					zu = numtoname(stt.getNo());
					break;
				}
				else
				{
					String []names = stt.getMember().split("、");
					for(int j=0;j<names.length;j++)
					{
						if(names[j].equals(name))
						{
							zu = numtoname(stt.getNo());
							break;
						}
						
					}
				}
			}
		}
		return zu;
		
	}
	public String numtoname(int num)
	{
		String zuname="";
		if(num==1)
		{
			zuname="排班一组";
		}
		if(num==2)
		{
			zuname="排班二组";
		}
		if(num==3)
		{
			zuname="排班三组";
		}
		if(num==4)
		{
			zuname="排班四组";
		}
		if(num==5)
		{
			zuname="排班五组";
		}
		if(num==6)
		{
			zuname="排班六组";
		}
		if(num==7)
		{
			zuname="外汇专班三组";
		}
		if(num==8)
		{
			zuname="外汇专班四组";
		}
		if(num==9)
		{
			zuname="外汇专班五组";
		}
		return zuname;
	}
	
	public String typetoname(int num)
	{
		String name="";
		if(num==1)
		{
			name="病假";
		}
		if(num==2)
		{
			name="年休假";
		}
		if(num==3)
		{
			name="事假";
		}
		if(num==4)
		{
			name="婚假";
		}
		if(num==5)
		{
			name="产假（或陪护假）";
		}
		if(num==6)
		{
			name="探亲假（配偶）";
		}
		if(num==7)
		{
			name="探亲假（父母）";
		}
		if(num==8)
		{
			name="丧假";
		}
		if(num==9)
		{
			name="工伤假";
		}
		if(num==10)
		{
			name="公假";
		}
		if(num==11)
		{
			name="加班调休";
		}
		if(num==12)
		{
			name="产检";
		}
		if(num==13)
		{
			name="陪考假";
		}
		if(num==14)
		{
			name="哺乳假";
		}
		return name;
	}
	public static String chuToName(String chu)
	{
		if(chu.equals("1"))
		{
			return "综合与生产管理处";
		}
		else if(chu.equals("2"))
		{
			return "合规与监督二处";
		}
		else if(chu.equals("3"))
		{
			return "通用业务二处";
		}
		else if(chu.equals("4"))
		{
			return "员工响应团队";
		}
		else if(chu.equals("5"))
		{
			return "研发支持二处";
		}
		else if(chu.equals("6"))
		{
			return "专业处理二处";
		}
		else
		{
			return "";
		}
	}
	
	public static String ygxxReasonToString(Integer type)
	{
		String result = "";
		if(type==1)
		{
			result = "优化创新";
		}
		else if(type==2)
		{
			result = "项目借调";
		}
		else if(type==3)
		{
			result = "外出公干";
		}
		else if(type==4)
		{
			result = "员工培训";
		}
		else if(type==5)
		{
			result = "中心检查";
		}
		else if(type==6)
		{
			result = "业务监控";
		}
		else if(type==7)
		{
			result = "临时抽调";
		}
		else if(type==8)
		{
			result = "轮岗实习";
		}
		else if(type==9)
		{
			result = "加班调休";
		}
		else if(type==10)
		{
			result = "党团工会";
		}
		else if(type==11)
		{
			result = "产量下线";
		}
		else if(type==12)
		{
			result = "组长下线";
		}
		else if(type==20)
		{
			result = "其他";
		}
		return result;
	}
}
