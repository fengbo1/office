package office.wcgg.action;

import java.util.ArrayList;
import java.util.List;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;
import office.wcgg.dao.WcggBaodaoDAO;
import office.wcgg.pojo.WcggBaodao;
import office.wcgg.pojo.WcggPage;
import office.wcgg.pojo.WcggPageBean;
import office.wcgg.pojo.WcggPageBeanShow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
/**
 * 外出公干明细列表
 * 如果是待报道和办结归档状态将条目拆分
 * @author htzx
 *
 */
public class ViewWcggAll {

	private static final Log log = LogFactory.getLog(WcggPage.class);
	private String newnumber;// 新一代员工编号
	private List<WcggPageBeanShow> list;
	private String title;
	private String autho;
	private String name;
	private String begindate;
	private String enddate;
	private String strtemp;
	private int chutuan;
	private int zhuan;
	private String zxtd;
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = Util.pagesize;
	/**
	* 总页数
	*/
	private int totalPages = -1;
	/**
	* 当前页
	*/
	private int currentPage = -1;
	/**
	* 上一页
	*/
	private int previousPage = 1;
	/**
	* 下一页
	*/
	private int nextPage = 1;
	/**
	* 第一页
	*/
	private int firstPage = 1;
	/**
	* 最后一页
	*/
	private int lastPage = 1;
	/**
	* 总记录条数
	*/
	private long totalRows = -1;
	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public List<WcggPageBeanShow> getList() {
		return list;
	}

	public void setList(List<WcggPageBeanShow> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutho() {
		return autho;
	}

	public void setAutho(String autho) {
		this.autho = autho;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getStrtemp() {
		return strtemp;
	}

	public void setStrtemp(String strtemp) {
		this.strtemp = strtemp;
	}

	public int getZhuan() {
		return zhuan;
	}

	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}

	public int getChutuan() {
		return chutuan;
	}

	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}

	public String getZxtd() {
		return zxtd;
	}

	public void setZxtd(String zxtd) {
		this.zxtd = zxtd;
	}

	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		WcggBaodaoDAO wbddao = new WcggBaodaoDAO();
		List<WcggPage> listwcgg = new ArrayList<WcggPage>();
		list = new ArrayList<WcggPageBeanShow>();
		Query query;
		String hql = "";
		String position = "";
		String zhi = "";
		String chu = "";
		String zu = "";
		String bd = "";
		String ed = "";
		title = "明细查询";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			ui = uidao.findByNewNumber(newnumber);
			position = ui.getPosition();
			autho = ui.getAuthority();
			zhi = position.substring(0,1);
			chu = position.substring(2,3);
			zu = position.substring(4,5);
			hql = "from WcggPage as wp where 1=1";
			if(name!=null&&zhuan==1)
			{
				strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				strtemp = name;
			}
			if(strtemp==null)
				strtemp="";
//			if(!zhi.equals("0")&&!zhi.equals("1")&&!zhi.equals("2")&&!autho.equals("I")&&!autho.equals("J"))
//			{
//				strtemp = ui.getUsername();
//			}
			if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				bd = begindate.replace("-", "");
				ed = enddate.replace("-", "");
				//hql += " and wp.begindate>='"+bd+"' and wp.begindate<='"+ed+"'";
				hql += " and ((wp.begindate>='"+bd+"' and wp.begindate<='"+ed+"') or (wp.enddate>='"+bd+"' and wp.enddate<='"+ed+"') or (wp.begindate<='"+bd+"' and wp.enddate>='"+ed+"'))";
			}
			if(zxtd!=null&&zxtd.equals("td"))
			{
				if(chutuan>=1&&chutuan<=6)
				{
					hql += " and wp.chu='"+chutuan+"'";
				}
				else if(chutuan>=7&&chutuan<=9)
				{
					int temptuan = chutuan-6;
					hql += " and wp.chu='3' and wp.zu='"+temptuan+"'";
				}
				else if(chutuan>=10&&chutuan<=12)
				{
					int temptuan = chutuan-9;
					hql += " and wp.chu='6' and wp.zu='"+temptuan+"'";
				}
				if(zhi.equals("0")||zhi.equals("1")||autho.contains("I")||autho.contains("T"))//主任看全部
				{
					hql += "";
				}
//				else//普通员工
//				{
//					hql += " and wp.number in (select number from WcggBaodao as wb where wb.newnumber='"+newnumber+"')";
//				}
				if(zhi.equals("2"))//团队负责人
				{
					hql += " and (wp.chu='"+chu+"')";
				}
				
				if(zhi.equals("4"))//组长
				{
					hql += " and (wp.chu='"+chu+"' and wp.zu='"+zu+"')";
				}
				if(!strtemp.equals(""))
				{
					hql +=" and wp.people like '%"+strtemp+"%'";
				}
				result = "successtd";
			}
			else
			{
				strtemp = ui.getUsername();
				int length=strtemp.length();
				String temp=strtemp.substring(length-1, length);
				if(temp.equals("B"))
				{
					strtemp = strtemp.substring(0, length-1);
				}
				hql +=" and wp.people like '%"+strtemp+"%'";
			}
			hql += " order by locate('6',wp.status), wp.id desc";
			System.out.println(hql);
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows =session.createQuery(hql).list().size();
			initPageProperties();
			listwcgg = query.list();
			for(int i=0;i<listwcgg.size();i++)
			{
				WcggPage wp = listwcgg.get(i);
//				if(wp.getStatus()==3||wp.getStatus()==4)//拆分
//				{
//					List<WcggBaodao> listbd = wbddao.findAllByNumber(wp.getNumber());
//					for(int j=0;j<listbd.size();j++)
//					{
//						WcggPageBeanShow wpb = new WcggPageBeanShow();
//						WcggBaodao wbd = listbd.get(j);
//						UserInfo tempui = uidao.findByName(wbd.getName());
//						wpb.setNumber(wbd.getNumber());//编号
//						wpb.setDate(wp.getDate());//申请日期
//						if(wbd.getStatus()==2)
//						{
//							wpb.setStatus(4);
//						}
//						else
//						{
//							wpb.setStatus(3);
//						}
//						wpb.setInitiator(LeaveUtil.NewNumberToNameNoSession(wp.getInitiator()));
//						wpb.setApplicant(wbd.getName());
//						wpb.setPeople(wbd.getName());
//						if(tempui!=null)
//						wpb.setChutuan(UserUtil.positionToName(tempui.getPosition()));
//						wpb.setTel(wp.getTel());
//						wpb.setReason(wp.getReason());
//						wpb.setAddr(wp.getAddr());
//						wpb.setBegindate(wbd.getBegindate());//出发时间
//						wpb.setEnddate(wp.getEnddate());//预计结束时间
//						wpb.setBaodaodate(wbd.getBaodaodate());//实际报到时间
//						wpb.setThisunder("无");
//						//if(wbd.getSumday()!=null)//20170329改
//						//wpb.setDays(wbd.getSumday());//实际公干总天数
//						wpb.setDays(wp.getDays());
//						list.add(wpb);
//					}
//				}
//				else//不拆分
//				{
					WcggPageBeanShow wpb = new WcggPageBeanShow();
					UserInfo tempui = uidao.findByNewNumber(wp.getApplicant());
					wpb.setNumber(wp.getNumber());//编号
					wpb.setDate(wp.getDate());//申请日期
					wpb.setStatus(wp.getStatus());
					wpb.setInitiator(LeaveUtil.NewNumberToNameNoSession(wp.getInitiator()));
					wpb.setApplicant(LeaveUtil.NewNumberToNameNoSession(wp.getApplicant()));
					wpb.setPeople(wp.getPeople());
					System.out.println(wp.getNumber());
					if(tempui!=null)
					wpb.setChutuan(UserUtil.positionToName(tempui.getPosition()));
					wpb.setTel(wp.getTel());
					wpb.setReason(wp.getReason());
					wpb.setAddr(wp.getAddr());
					wpb.setBegindate(wp.getBegindate());//出发时间
					wpb.setEnddate(wp.getEnddate());//预计结束时间
					wpb.setBaodaodate("");//实际报到时间
					wpb.setThisunder(LeaveUtil.NewNumberToNameNoSession(wp.getThisunder()));
					wpb.setDays(wp.getDays());//预计公干总天数
					list.add(wpb);
//				}
			}
//			if(pageSize*currentPage<list.size())
//			{
//				list = list.subList(pageSize * (currentPage - 1), pageSize * (currentPage));
//			}
//			else
//			{
//				list = list.subList(pageSize * (currentPage - 1),(int)totalRows);
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	/**
	 * 初始化页面属性<br>
	 * 必须在已获得totalRows值之后再调用该函数<br>
	 * 调用方式为：<br>
	 * 
	 * 给totalRows赋值<br>
	 * 调用initPageProperties(form)方法<br>
	 * 给list赋值<br>
	 * 调用initAttribute(request)方法<br>
	 * 
	 * 该方法在调用查询语句之前调用<br>
	 * pageSize为系统默认的分页的大小，如要更改pageSize，应在掉用setPageSize方法后再调用该方法<br>
	 * 
	 * 
	 */
	protected void initPageProperties() {

		if (totalRows == -1) {
			log.error("没有初始化totalRows参数！");
		}

		firstPage = 1;
		
		currentPage = currentPage <= 1 ? 1 : currentPage;

		totalPages = (totalRows % pageSize == 0) ? ((int) (totalRows / pageSize))
				: ((int) (totalRows / pageSize + 1));

		currentPage = currentPage >= totalPages ? totalPages : currentPage;

		previousPage = currentPage > 1 ? currentPage - 1 : 1;

		nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

		lastPage = totalPages;
	}
}
