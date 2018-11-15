package office.welcome;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import office.jbsp.pojo.JbspPage;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.pb2.pojo.XxsqPage;
import office.uass.dao.UassCostHnPeopleDAO;
import office.uass.dao.UassPtPeopleDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostWb;
import office.uass.pojo.UassJihe;
import office.uass.pojo.UassPt;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.zszm.dao.TZzzmDAO;
import office.srzm.dao.TSrzmDAO;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggPage;
import office.zszm.pojo.TZzzm;
import office.srzm.pojo.TSrzm;
import office.yscj.pojo.TYscj;
import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.dao.TMjglDAO;
import office.mjgl.pojo.TMjgl;
import office.mjgl.pojo.TMjglPage;
import office.zcgl.pojo.*;
import office.zcgl.dao.*;
/**
 * 欢迎页面查看待办事宜
 * 
 * @author htzx
 * 
 */
public class WelcomePage {

	private String newnumber;
	private String number;
	private List<LeavePage> listlp;
	private List<LeavePage> listlpgl;
	private List<WcggPage> listwp;
	private List<WcggPage> listwpkq;
	private List<JbspPage> listjp;
	private List<KqqsPage> listkp;
	private List<XxsqPage> listxp;
	private List<XxsqPage> listxpkq;
	private List<TbsqPage> listtp;
	private List<TbsqPage> listtpkq;
	private List<WelcomeBean> listwb1;//考勤管理
	private List<WelcomeBean> listwb2;//事项审批
	private List<WelcomeBean> listwb3;//资产管理
	private List<WelcomeBean> listwb4;//员工渠道
    private List<TZzzm> listtz;
    private List<TSrzm> listts;
    private List<TYscj>listty;
    private List<TMjgl>listtm;
    private List<AssetApply>listay;
    private List<AssetBorrow>listab;
    private List<AssetReturn>listar;

    private List<StorehouseIn>listsin;
    private List<StorehouseOut>listsout;
    private List<UassPt> listuspt;
    private List<UassCostHn> listusch;
    private List<UassCostWb> listuscw;
    private List<UassJihe> listusjh;
    
    private TZzzm tzclean;
    private TSrzm tsclean;
    private TMjgl tmclean;
    
    
    
	public List<WelcomeBean> getListwb1() {
		return listwb1;
	}

	public void setListwb1(List<WelcomeBean> listwb1) {
		this.listwb1 = listwb1;
	}

	public List<WelcomeBean> getListwb2() {
		return listwb2;
	}

	public void setListwb2(List<WelcomeBean> listwb2) {
		this.listwb2 = listwb2;
	}

	public List<WelcomeBean> getListwb3() {
		return listwb3;
	}

	public void setListwb3(List<WelcomeBean> listwb3) {
		this.listwb3 = listwb3;
	}

	public List<AssetApply> getListay() {
		return listay;
	}

	public void setListay(List<AssetApply> listay) {
		this.listay = listay;
	}

	public List<AssetBorrow> getListab() {
		return listab;
	}

	public void setListab(List<AssetBorrow> listab) {
		this.listab = listab;
	}

	public List<AssetReturn> getListar() {
		return listar;
	}

	public void setListar(List<AssetReturn> listar) {
		this.listar = listar;
	}



	public List<StorehouseIn> getListsin() {
		return listsin;
	}

	public void setListsin(List<StorehouseIn> listsin) {
		this.listsin = listsin;
	}

	public List<StorehouseOut> getListsout() {
		return listsout;
	}

	public void setListsout(List<StorehouseOut> listsout) {
		this.listsout = listsout;
	}

	public TZzzm getTzclean() {
		return tzclean;
	}

	public void setTzclean(TZzzm tzclean) {
		this.tzclean = tzclean;
	}

	public List<TSrzm> getListts() {
		return listts;
	}

	public void setListts(List<TSrzm> listts) {
		this.listts = listts;
	}

	public List<TYscj> getListty() {
		return listty;
	}

	public void setListty(List<TYscj> listty) {
		this.listty = listty;
	}

	public List<TZzzm> getListtz() {
		return listtz;
	}

	public void setListtz(List<TZzzm> listtz) {
		this.listtz = listtz;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public List<LeavePage> getListlp() {
		return listlp;
	}

	public void setListlp(List<LeavePage> listlp) {
		this.listlp = listlp;
	}

	public List<LeavePage> getListlpgl() {
		return listlpgl;
	}

	public void setListlpgl(List<LeavePage> listlpgl) {
		this.listlpgl = listlpgl;
	}

	public List<WcggPage> getListwp() {
		return listwp;
	}

	public void setListwp(List<WcggPage> listwp) {
		this.listwp = listwp;
	}

	public List<JbspPage> getListjp() {
		return listjp;
	}

	public void setListjp(List<JbspPage> listjp) {
		this.listjp = listjp;
	}

	public List<KqqsPage> getListkp() {
		return listkp;
	}

	public void setListkp(List<KqqsPage> listkp) {
		this.listkp = listkp;
	}

	public List<WcggPage> getListwpkq() {
		return listwpkq;
	}

	public void setListwpkq(List<WcggPage> listwpkq) {
		this.listwpkq = listwpkq;
	}
	public List<XxsqPage> getListxp() {
		return listxp;
	}

	public void setListxp(List<XxsqPage> listxp) {
		this.listxp = listxp;
	}

	public List<TbsqPage> getListtp() {
		return listtp;
	}

	public void setListtp(List<TbsqPage> listtp) {
		this.listtp = listtp;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<XxsqPage> getListxpkq() {
		return listxpkq;
	}

	public void setListxpkq(List<XxsqPage> listxpkq) {
		this.listxpkq = listxpkq;
	}

	public List<TbsqPage> getListtpkq() {
		return listtpkq;
	}

	public void setListtpkq(List<TbsqPage> listtpkq) {
		this.listtpkq = listtpkq;
	}

	public List<WelcomeBean> getListwb4() {
		return listwb4;
	}

	public void setListwb4(List<WelcomeBean> listwb4) {
		this.listwb4 = listwb4;
	}

	public List<UassPt> getListuspt() {
		return listuspt;
	}

	public void setListuspt(List<UassPt> listuspt) {
		this.listuspt = listuspt;
	}

	public List<UassCostHn> getListusch() {
		return listusch;
	}

	public void setListusch(List<UassCostHn> listusch) {
		this.listusch = listusch;
	}

	public List<UassCostWb> getListuscw() {
		return listuscw;
	}

	public void setListuscw(List<UassCostWb> listuscw) {
		this.listuscw = listuscw;
	}

	public List<UassJihe> getListusjh() {
		return listusjh;
	}

	public void setListusjh(List<UassJihe> listusjh) {
		this.listusjh = listusjh;
	}

	public String execute() throws Exception {
		String hql = "";
		String hql1 = "";
		String hql2 = "";
		UassPtPeopleDAO uppdao = new UassPtPeopleDAO();
		UassCostHnPeopleDAO uchpdao = new UassCostHnPeopleDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		WcggPageDAO wpdao = new WcggPageDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		XxsqPageDAO xpdao = new XxsqPageDAO();
		MyCompartor mc = new MyCompartor();
		listwb1 = new ArrayList<WelcomeBean>();
		listwb2 = new ArrayList<WelcomeBean>();
		listwb3 = new ArrayList<WelcomeBean>();
		listwb4 = new ArrayList<WelcomeBean>();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		UserInfo uithis = uidao.findByNewNumber(newnumber);
		String uassautho = uithis.getAuthority();
		if(number!=null)
		{
			if(number.contains("WCGG"))
			{
				WcggPage wptemp = wpdao.findAllByNumber(number);
				if(uithis.getAuthority().contains("I"))
				{
					wptemp.setView(wptemp.getView()+2);
				}
				else
				{
					wptemp.setView(wptemp.getView()+1);
				}
				//wptemp.setView(3);
				wpdao.merge(wptemp);
			}
			else if(number.contains("QJSQ"))
			{
				LeavePage lptemp = lpdao.findByNumber(number);
				if(uithis.getAuthority().contains("I"))
				{
					lptemp.setView(lptemp.getView()+2);
				}
				else if(uithis.getAuthority().contains("J"))
				{
					lptemp.setView(lptemp.getView()+1);
				}
				else if(uithis.getAuthority().contains("T"))
				{
					lptemp.setViewpb(2);
				}
				//wptemp.setView(3);
				lpdao.merge(lptemp);
			}
			else if(number.contains("ZZZM"))
			{
				TZzzmDAO tzdao=new TZzzmDAO();
				tzclean=tzdao.findAllByNumber(number);
				tzclean.setStatus(11);
				tzdao.merge(tzclean);
			}
			else if(number.contains("SRZM"))
			{
				TSrzmDAO tsdao=new TSrzmDAO();
				tsclean=tsdao.findAllByNumber(number);
				tsclean.setStatus(11);
				tsdao.merge(tsclean);
			}
			/*else if(number.contains("MJGL"))
			{
				TMjglDAO tmdao=new TMjglDAO();
				tmclean=tmdao.findAllByNumber(number);
				tmclean.setStatus(11);
				tmdao.merge(tmclean);
			}*/
			else if(number.contains("YGXX"))
			{
				XxsqPage xptemp = xpdao.findAllByNumber(number);
				xptemp.setView(xptemp.getView()+1);
				//wptemp.setView(3);
				xpdao.merge(xptemp);
			}
		}
		
		String name = LeaveUtil.NewNumberToNameNoSession(newnumber);
		int length=name.length();
		String temp=name.substring(length-1, length);
		if(temp.equals("B"))
		{
			name = name.substring(0, length-1);
		}
		try {
			String newnumber1=newnumber.substring(0,8);
			hql = "from LeavePage as lp where substr(lp.undertake,1,8)='"+newnumber1+"' or (substr(lp.initiator,1,8)='"+newnumber1+"' and lp.status in (0,4)) order by lp.id desc";
			listlp = session.createQuery(hql).list();
			hql = "from WcggPage as wp where substr(wp.thisunder,1,8)='"+newnumber1+"' or (substr(wp.initiator,1,8)='"+newnumber1+"' and wp.status in (0,5)) or (wp.people like '%"+name+"%' and wp.status=3) order by wp.id desc";
			listwp = session.createQuery(hql).list();
			hql = "from JbspPage as jp where substr(jp.thisunder,1,8)='"+newnumber1+"' or (substr(jp.initiator,1,8)='"+newnumber1+"' and jp.status in (0,5)) order by jp.id desc";
			listjp = session.createQuery(hql).list();
			hql = "from KqqsPage as kp where substr(kp.thisunder,1,8)='"+newnumber1+"' or (substr(kp.initiator,1,8)='"+newnumber1+"' and kp.status in (0,5)) order by kp.id desc";
			listkp = session.createQuery(hql).list();
			hql = "from XxsqPage as xp where substr(xp.undertake,1,8)='"+newnumber1+"' or (substr(xp.initiator,1,8)='"+newnumber1+"' and xp.status in (0,5)) order by xp.id desc";
			listxp = session.createQuery(hql).list();
			hql = "from TbsqPage as tp where substr(tp.undertake,1,8)='"+newnumber1+"' or (substr(tp.initiator,1,8)='"+newnumber1+"' and tp.status in (0,5)) order by tp.id desc";
			listtp = session.createQuery(hql).list();
			hql = "from TbsqPage as tp where (substr(tp.applicant,1,8)='"+newnumber1+"' or tp.tbname='"+name+"') and tp.status in (0,5,7) order by tp.id desc";
			listtpkq = session.createQuery(hql).list();
			hql = "from TZzzm as tz where substr(tz.thisunder,1,8)='"+newnumber1+"' or (substr(tz.initiator,1,8)='"+newnumber1+"' and tz.status in (0,5)) or (tz.status=4 and '"+newnumber1+"'='91362239') order by tz.id desc";
			listtz = session.createQuery(hql).list();
			hql = "from TSrzm as tz where substr(tz.thisunder,1,8)='"+newnumber1+"' or (substr(tz.initiator,1,8)='"+newnumber1+"' and tz.status in (0,5)) or (tz.status=4 and '"+newnumber1+"'='91362239')  order by tz.id desc";
			listts = session.createQuery(hql).list();
			hql = "from TYscj as ty where (substr(ty.thisunder,1,8)='"+newnumber1+"' and ty.status !='"+4+"') or (substr(ty.initiator,1,8)='"+newnumber1+"' and ty.status in (0,5))order by ty.id desc";
			listty = session.createQuery(hql).list();
			hql = "from TMjgl as tm where (substr(tm.thisunder,1,8)='"+newnumber1+"' and tm.status !='"+4+"') or (substr(tm.initiator,1,8)='"+newnumber1+"' and tm.status in (0,5))order by tm.id desc";
			listtm = session.createQuery(hql).list();
			hql= "from AssetApply as ay where substr(ay.thisunder,1,8)='"+newnumber1+"' or (substr(ay.initiator,1,8)='"+newnumber1+"' and ay.status in (0,5)) order by ay.id desc";
		    listay= session.createQuery(hql).list();
			hql= "select * from asset_borrow as ay where substr(ay.thisunder,1,8)='"+newnumber1+"' or (substr(ay.initiator,1,8)='"+newnumber1+"' and ay.status in (0,5)) order by ay.id desc";
		    //hql= "from AssetBorrow as ay where ay.thisunder='"+newnumber+"' or (ay.initiator='"+newnumber+"' and ay.status in (0,5)) order by ay.id desc";
		    listab = session.createSQLQuery(hql).addEntity(AssetBorrow.class).list();
			hql= "from AssetReturn as ay where substr(ay.thisunder,1,8)='"+newnumber1+"' or (substr(ay.initiator,1,8)='"+newnumber1+"' and ay.status in (0,5)) order by ay.id desc";
			listar = session.createQuery(hql).list();
			hql= "from StorehouseIn as ah where substr(ah.thisunder,1,8)='"+newnumber1+"' or (substr(ah.initiator,1,8)='"+newnumber1+"' and ah.status in (0,5)) order by ah.id desc";
			listsin = session.createQuery(hql).list();
			hql= "from StorehouseOut as ah where substr(ah.thisunder,1,8)='"+newnumber1+"' or (substr(ah.initiator,1,8)='"+newnumber1+"' and ah.status in (0,5)) order by ah.id desc";
			listsout = session.createQuery(hql).list();
			
			hql= "from UassPt as up where substr(up.undertake,1,8)='"+newnumber1+"' or (substr(up.initiator,1,8)='"+newnumber1+"' and up.status in (0,5))";
			if(uassautho.contains("o"))
			{
				hql+=" or up.status=16";
			}
			hql+=" order by up.id desc";
			listuspt = session.createQuery(hql).list();
			hql= "from UassCostHn as up where substr(up.undertake,1,8)='"+newnumber1+"' or (substr(up.initiator,1,8)='"+newnumber1+"' and up.status in (0,5))";
			if(uassautho.contains("o"))
			{
				hql+=" or up.status=16";
			}
			hql+=" order by up.id desc";
			listusch = session.createQuery(hql).list();
			hql= "from UassCostWb as up where substr(up.undertake,1,8)='"+newnumber1+"' or (substr(up.initiator,1,8)='"+newnumber1+"' and up.status in (0,5))";
			if(uassautho.contains("o"))
			{
				hql+=" or up.status=16";
			}
			hql+=" order by up.id desc";
			listuscw = session.createQuery(hql).list();
			hql= "from UassJihe as up where substr(up.undertake,1,8)='"+newnumber1+"' or (substr(up.initiator,1,8)='"+newnumber1+"' and up.status in (0,5))";
			if(uassautho.contains("o"))
			{
				hql+=" or up.status=16";
			}
			hql+=" order by up.id desc";
			//System.out.println(hql);
			listusjh = session.createQuery(hql).list();
			if(uithis.getAuthority().contains("I"))
			{
				hql = "from WcggPage as wp where wp.view in (1,2) and wp.status<>6 and wp.people not like '%"+name+"%'";
				listwpkq = session.createQuery(hql).list();
				for(int i=0;i<listwpkq.size();i++)
				{
					WcggPage wp = listwpkq.get(i);
					UserInfo ui = uidao.findByNewNumber(wp.getApplicant());
					WelcomeBean wb = new WelcomeBean();
					wb.setDate(wp.getDate());
					wb.setInitiator(wp.getInitiator());
					wb.setName(wp.getPeople());
					if(ui!=null)
					wb.setChu(UserUtil.positionToName(ui.getPosition()));
					wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(wp.getPreunder()));
					wb.setNumber(wp.getNumber());
					wb.setType1("外出公干");
					wb.setType2("（管理员查阅）");
					wb.setStatus(wp.getStatus());
					listwb1.add(wb);
				}
			}
			if(uithis.getAuthority().contains("T"))
			{
				hql = "from XxsqPage as xp where xp.view=1 and xp.status<>6";
				listxpkq = session.createQuery(hql).list();
				for(int i=0;i<listxpkq.size();i++)
				{
					XxsqPage xp = listxpkq.get(i);
					UserInfo ui = uidao.findByNewNumber(xp.getApplicant());
					WelcomeBean wb = new WelcomeBean();
					wb.setDate(xp.getDate());
					wb.setInitiator(xp.getInitiator());
					wb.setName(xp.getPeople());
					if(ui!=null)
					wb.setChu(UserUtil.positionToName(ui.getPosition()));
					wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(xp.getPreundertake()));
					wb.setNumber(xp.getNumber());
					wb.setType1("因公下线");
					wb.setType2("（排班管理员查阅）");
					wb.setStatus(xp.getStatus());
					listwb2.add(wb);
				}
				hql = "from LeavePage as lp where lp.viewpb=1 and lp.status in (1,2,7,9) and lp.chu in (3,6)";
				List<LeavePage> listlppb = session.createQuery(hql).list();
				for(int i=0;i<listlppb.size();i++)
				{
					LeavePage lp = listlppb.get(i);
					UserInfo ui = uidao.findByNewNumber(lp.getApplicant());
					WelcomeBean wb = new WelcomeBean();
					wb.setDate(lp.getDate());
					wb.setInitiator(lp.getInitiator());
					wb.setName(LeaveUtil.NewNumberToNameNoSession(lp.getApplicant()));
					if(ui!=null)
					wb.setChu(UserUtil.positionToName(ui.getPosition()));
					wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(lp.getPreundertake()));
					wb.setNumber(lp.getNumber());
					wb.setType1("请假申请");
					wb.setType2("（排班管理员查阅）");
					wb.setStatus(lp.getStatus());
					listwb1.add(wb);
				}
			}
			if(uithis.getAuthority().contains("J"))
			{
				hql = "from WcggPage as wp where wp.view in (1,3) and wp.status<>6 and wp.people not like '%"+name+"%'";
				listwpkq = session.createQuery(hql).list();
				for(int i=0;i<listwpkq.size();i++)
				{
					WcggPage wp = listwpkq.get(i);
					UserInfo ui = uidao.findByNewNumber(wp.getApplicant());
					WelcomeBean wb = new WelcomeBean();
					wb.setDate(wp.getDate());
					wb.setInitiator(wp.getInitiator());
					wb.setName(wp.getPeople());
					if(ui!=null)
					wb.setChu(UserUtil.positionToName(ui.getPosition()));
					wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(wp.getPreunder()));
					wb.setNumber(wp.getNumber());
					wb.setType1("外出公干");
					wb.setType2("（管理员查阅）");
					wb.setStatus(wp.getStatus());
					listwb1.add(wb);
				}
				hql = "from LeavePage as lp where lp.view in (1,3) and lp.status in (1,2,7,9)";
				listlpgl = session.createQuery(hql).list();
				for(int i=0;i<listlpgl.size();i++)
				{
					LeavePage lp = listlpgl.get(i);
					UserInfo ui = uidao.findByNewNumber(lp.getApplicant());
					WelcomeBean wb = new WelcomeBean();
					wb.setDate(lp.getDate());
					wb.setInitiator(lp.getInitiator());
					wb.setName(LeaveUtil.NewNumberToNameNoSession(lp.getApplicant()));
					if(ui!=null)
					wb.setChu(UserUtil.positionToName(ui.getPosition()));
					wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(lp.getPreundertake()));
					wb.setNumber(lp.getNumber());
					wb.setType1("请假申请");
					wb.setType2("（管理员查阅）");
					wb.setStatus(lp.getStatus());
					listwb1.add(wb);
				}
			}
			for(int i=0;i<listlp.size();i++)
			{
				LeavePage lp = listlp.get(i);
				UserInfo ui = uidao.findByNewNumber(lp.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(lp.getDate());
				wb.setInitiator(lp.getInitiator());
				wb.setName(LeaveUtil.NewNumberToNameNoSession(lp.getApplicant()));
				if(ui!=null)
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(lp.getPreundertake()));
				wb.setNumber(lp.getNumber());
				wb.setType1("请假申请");
				wb.setType2("-"+LeaveUtil.TypeToString(lp.getType()));
				wb.setStatus(lp.getStatus());
				listwb1.add(wb);
			}
			for(int i=0;i<listwp.size();i++)
			{
				WcggPage wp = listwp.get(i);
				UserInfo ui = uidao.findByNewNumber(wp.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(wp.getDate());
				wb.setInitiator(wp.getInitiator());
				wb.setName(wp.getPeople());
				if(ui!=null)
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(wp.getPreunder()));
				wb.setNumber(wp.getNumber());
				wb.setType1("外出公干");
				wb.setType2("");
				wb.setStatus(wp.getStatus());
				listwb1.add(wb);
			}
			for(int i=0;i<listjp.size();i++)
			{
				JbspPage jp = listjp.get(i);
				UserInfo ui = uidao.findByNewNumber(jp.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(jp.getDate());
				wb.setInitiator(jp.getInitiator());
				wb.setName(jp.getPeople());
				if(ui!=null)
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(jp.getPreunder()));
				wb.setNumber(jp.getNumber());
				wb.setType1("加班申请");
				wb.setType2("");
				wb.setStatus(jp.getStatus());
				listwb1.add(wb);
			}
			for(int i=0;i<listkp.size();i++)
			{
				KqqsPage kp = listkp.get(i);
				UserInfo ui = uidao.findByNewNumber(kp.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(kp.getDate());
				wb.setInitiator(kp.getInitiator());
				wb.setName(LeaveUtil.NewNumberToNameNoSession(kp.getApplicant()));
				if(ui!=null)
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(kp.getPreunder()));
				wb.setNumber(kp.getNumber());
				wb.setType1("考勤缺失");
				wb.setType2("");
				wb.setStatus(kp.getStatus());
				listwb1.add(wb);
			}
			for(int i=0;i<listxp.size();i++)
			{
				XxsqPage xp = listxp.get(i);
				UserInfo ui = uidao.findByNewNumber(xp.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(xp.getDate());
				wb.setInitiator(xp.getInitiator());
				wb.setName(xp.getPeople());
				if(ui!=null)
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(xp.getPreundertake()));
				wb.setNumber(xp.getNumber());
				wb.setType1("因公下线");
				wb.setType2("");
				wb.setStatus(xp.getStatus());
				listwb2.add(wb);
			}
			for(int i=0;i<listtp.size();i++)
			{
				TbsqPage tp = listtp.get(i);
				UserInfo ui = uidao.findByNewNumber(tp.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(tp.getDate());
				wb.setInitiator(tp.getInitiator());
				wb.setName(LeaveUtil.NewNumberToNameNoSession(tp.getApplicant())+"、"+tp.getTbname());
				if(ui!=null)
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(tp.getPreundertake()));
				wb.setNumber(tp.getNumber());
				wb.setType1("调班申请");
				wb.setType2("");
				wb.setStatus(tp.getStatus());
				listwb2.add(wb);
			}
			for(int i=0;i<listtpkq.size();i++)
			{
				TbsqPage tp = listtpkq.get(i);
				UserInfo ui = uidao.findByNewNumber(tp.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(tp.getDate());
				wb.setInitiator(tp.getInitiator());
				wb.setName(LeaveUtil.NewNumberToNameNoSession(tp.getApplicant())+"、"+tp.getTbname());
				if(ui!=null)
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(tp.getPreundertake()));
				wb.setNumber(tp.getNumber());
				wb.setType1("调班申请");
				wb.setType2("（调班人查阅）");
				wb.setStatus(tp.getStatus());
				listwb2.add(wb);
			}
			for(int i=0;i<listtz.size();i++)
			{
				TZzzm tz = listtz.get(i);
				UserInfo ui = uidao.findByNewNumber(tz.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(tz.getDate());
				wb.setInitiator(tz.getInitiator());
				
				if(ui!=null)
				wb.setName(ui.getUsername());
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(tz.getPreunder()));
				wb.setNumber(tz.getNumber());
				wb.setType1("在职证明");
				wb.setType2("");
				wb.setStatus(tz.getStatus());
				listwb2.add(wb);
			}
			for(int i=0;i<listts.size();i++)
			{
				TSrzm tz = listts.get(i);
				UserInfo ui = uidao.findByNewNumber(tz.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(tz.getDate());
				wb.setInitiator(tz.getInitiator());
				
				if(ui!=null)
				wb.setName(ui.getUsername());
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(tz.getPreunder()));
				wb.setNumber(tz.getNumber());
				wb.setType1("收入证明");
				wb.setType2("");
				wb.setStatus(tz.getStatus());
				listwb2.add(wb);
			}
			for(int i=0;i<listty.size();i++)
			{
				TYscj ty = listty.get(i);
				UserInfo ui = uidao.findByNewNumber(ty.getApplicant());
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(ty.getDate());
				wb.setInitiator(ty.getInitiator());
				
				if(ui!=null)
				wb.setName(ui.getUsername());
				wb.setChu(UserUtil.positionToName(ui.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(ty.getPreunder()));
				wb.setNumber(ty.getNumber());
				wb.setType1("因私出入境");
				wb.setType2("");
				wb.setStatus(ty.getStatus());
				listwb2.add(wb);
			}
			for(int i=0;i<listtm.size();i++)
			{
				TMjgl tm = listtm.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(tm.getDate());
				wb.setInitiator(tm.getInitiator());
				
				wb.setName(tm.getPeople());
				wb.setChu(UserUtil.chuToName(tm.getChu()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(tm.getPreunder()));
				wb.setNumber(tm.getNumber());
				wb.setType1("门禁管理");
				wb.setType2("");
				wb.setStatus(tm.getStatus());
				listwb2.add(wb);
			}
			
			for(int i=0;i<listay.size();i++)
			{
				AssetApply ay = listay.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(ay.getDate());
				wb.setInitiator(ay.getInitiator());
				
				wb.setName(ay.getName());
				wb.setChu(UserUtil.cToName(ay.getChu()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(ay.getPreunder()));
				wb.setNumber(ay.getNumber());
				wb.setType1("资产申领");
				wb.setType2("");
				wb.setStatus(ay.getStatus());
				listwb3.add(wb);
			}
			
			for(int i=0;i<listab.size();i++)
			{
				AssetBorrow ab = listab.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(ab.getDate());
				wb.setInitiator(ab.getInitiator());
				
				wb.setName(ab.getName());
				wb.setChu(UserUtil.cToName(ab.getChu()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(ab.getPreunder()));
				wb.setNumber(ab.getNumber());
				wb.setType1("资产借用");
				wb.setType2("");
				wb.setStatus(ab.getStatus());
				listwb3.add(wb);
			}
			
			for(int i=0;i<listar.size();i++)
			{
				AssetReturn ar = listar.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(ar.getDate());
				wb.setInitiator(ar.getInitiator());
				
				wb.setName(ar.getName());
				wb.setChu(UserUtil.cToName(ar.getChu()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(ar.getPreunder()));
				wb.setNumber(ar.getNumber());
				wb.setType1("资产归还");
				wb.setType2("");
				wb.setStatus(ar.getStatus());
				listwb3.add(wb);
			}
			
			for(int i=0;i<listsin.size();i++)
			{
				StorehouseIn shin = listsin.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(shin.getDate());
				wb.setInitiator(shin.getInitiator());
				
				wb.setName(shin.getName());
				wb.setChu(UserUtil.cToName(1));
				wb.setPreunder("");
				wb.setNumber(shin.getNumber());
				wb.setType1("入库管理");
				wb.setType2("");
				wb.setStatus(shin.getStatus());
				listwb3.add(wb);
			}
			
			for(int i=0;i<listsout.size();i++)
			{
				StorehouseOut shout = listsout.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(shout.getDate());
				wb.setInitiator(shout.getInitiator());
				
				wb.setName(shout.getName());
				wb.setChu(UserUtil.cToName(1));
				wb.setPreunder("");
				wb.setNumber(shout.getNumber());
				wb.setType1("报废管理");
				wb.setType2("");
				wb.setStatus(shout.getStatus());
				listwb3.add(wb);
			}
			for(int i=0;i<listuspt.size();i++)
			{
				UassPt up = listuspt.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(up.getDate());
				wb.setInitiator(up.getInitiator());
				
				wb.setName(uppdao.findPeopleNameAllByNumber(up.getNumber()));
				wb.setChu(UserUtil.positionToName(up.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(up.getPreundertake()));
				wb.setNumber(up.getNumber());
				wb.setType1("平台用户");
				wb.setType2(up.getSxtime());
				wb.setStatus(up.getStatus());
				listwb4.add(wb);
			}
			for(int i=0;i<listusch.size();i++)
			{
				UassCostHn uch = listusch.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(uch.getDate());
				wb.setInitiator(uch.getInitiator());
				
				wb.setName(uchpdao.findPeopleNameAllByNumber(uch.getNumber()));
				wb.setChu(UserUtil.positionToName(uch.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(uch.getPreundertake()));
				wb.setNumber(uch.getNumber());
				wb.setType1("COS_T行方用户");
				wb.setType2(uch.getSxtime());
				wb.setStatus(uch.getStatus());
				listwb4.add(wb);
			}
			for(int i=0;i<listuscw.size();i++)
			{
				UassCostWb uc = listuscw.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(uc.getDate());
				wb.setInitiator(uc.getInitiator());
				
				wb.setName("-");
				wb.setChu(UserUtil.positionToName(uc.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(uc.getPreundertake()));
				wb.setNumber(uc.getNumber());
				wb.setType1("COS_T外包用户");
				wb.setType2(uc.getSxtime());
				wb.setStatus(uc.getStatus());
				listwb4.add(wb);
			}
			for(int i=0;i<listusjh.size();i++)
			{
				UassJihe uc = listusjh.get(i);
				WelcomeBean wb = new WelcomeBean();
				wb.setDate(uc.getDate());
				wb.setInitiator(uc.getInitiator());
				
				wb.setName("-");
				wb.setChu(UserUtil.positionToName(uc.getPosition()));
				wb.setPreunder(LeaveUtil.NewNumberToNameNoSession(uc.getPreundertake()));
				wb.setNumber(uc.getNumber());
				wb.setType1("稽核用户");
				wb.setType2(uc.getSxtime());
				wb.setStatus(uc.getStatus());
				listwb4.add(wb);
			}
			Collections.sort(listwb1,mc);
			Collections.sort(listwb2,mc);
			Collections.sort(listwb3,mc);
			//Collections.reverse(listwb);
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			e.printStackTrace();
		} finally {
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
	}

	public List<TMjgl> getListtm() {
		return listtm;
	}

	public void setListtm(List<TMjgl> listtm) {
		this.listtm = listtm;
	}

	public TSrzm getTsclean() {
		return tsclean;
	}

	public void setTsclean(TSrzm tsclean) {
		this.tsclean = tsclean;
	}

	public TMjgl getTmclean() {
		return tmclean;
	}

	public void setTmclean(TMjgl tmclean) {
		this.tmclean = tmclean;
	}
}
