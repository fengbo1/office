package office.jbsp.action;

import java.util.List;

import office.jbsp.pojo.JbspPage;
import office.jbsp.pojo.JbspPageDi;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;
import office.wcgg.pojo.WcggPage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewJpdAll {
	private static final Log log = LogFactory.getLog(WcggPage.class);
	private String newnumber;// 新一代员工编号
	private List<JbspPageDi> list;
	private String title;
	private String autho;
	private String name;
	private String date;
	private String strtemp;
	private String begindate;
	private String enddate;
	private int zhuan;
	private int chutuan;
	private String grzx;
	
	private int pageSize = Util.pagesize;


	private int totalPages = -1;


	private int currentPage = -1;

	
	private int previousPage = 1;

	
	private int nextPage = 1;

	private int firstPage = 1;
	
	private int lastPage = 1;

	private long totalRows = -1;
	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public List<JbspPageDi> getList() {
		return list;
	}

	public void setList(List<JbspPageDi> list) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getChutuan() {
		return chutuan;
	}

	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}

	public String getGrzx() {
		return grzx;
	}

	public void setGrzx(String grzx) {
		this.grzx = grzx;
	}

	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		Query query;
		String hql = "";
		String position = "";
		String zhi = "";
		String bd="";
		String ed="";
		String tempdate = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			ui = uidao.findByNewNumber(newnumber);
			position = ui.getPosition();
			autho = ui.getAuthority();
			zhi = position.substring(0,1);
			hql = "from JbspPageDi as jpd where 1=1";
			if(name!=null&&zhuan==1)
			{
				strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				strtemp = name;
			}
			if(strtemp==null)
			{
				strtemp="";
			}
			if(grzx.equals("gr"))
			{
				strtemp = ui.getUsername();
			}
			
			if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				bd = begindate.replace("-", "");
				ed = enddate.replace("-", "");
				//hql += " and jpd.begindate>='"+bd+"' and jpd.begindate<='"+ed+"'";
				hql += " and ((jpd.begindate>='"+bd+"' and jpd.begindate<='"+ed+"') or (jpd.enddate>='"+bd+"' and jpd.enddate<='"+ed+"') or (jpd.begindate<='"+bd+"' and jpd.enddate>='"+ed+"'))";
			}
			//strtemp = ui.getUsername();
			hql +=" and jpd.name like '%"+strtemp+"%'";
			hql += " order by jpd.id desc";
			System.out.println(hql);
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(hql).list().size();
			initPageProperties();
			list = query.list();
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
