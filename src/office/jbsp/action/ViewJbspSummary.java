package office.jbsp.action;

import java.util.List;

import office.jbsp.pojo.JbspSummary;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.LeaveUtil;
import office.util.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewJbspSummary {

	private static final Log log = LogFactory.getLog(ViewJbspSummary.class);
	private List<JbspSummary> list;
	private String name;
	private String keyword;
	private int year;
	private int zhuan;
	private String newnumber;
	private int chutuan;
	private List<Integer> listyear; 
	private String zxtd;
	private int pageSize = Util.pagesize;
	private int totalPages = -1;
	private int currentPage = -1;
	private int previousPage = 1;
	private int nextPage = 1;
	private int firstPage = 1;
	private int lastPage = 1;
	private long totalRows = -1;
	public List<JbspSummary> getList() {
		return list;
	}
	public void setList(List<JbspSummary> list) {
		this.list = list;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getZhuan() {
		return zhuan;
	}
	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public List<Integer> getListyear() {
		return listyear;
	}
	public void setListyear(List<Integer> listyear) {
		this.listyear = listyear;
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
	public String getZxtd() {
		return zxtd;
	}
	public void setZxtd(String zxtd) {
		this.zxtd = zxtd;
	}
	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}
	public String execute() throws Exception
	{
		Query query;
		String result="success";
		String position = "";
		String zhi = "";
		String chu = "";
		String zu ="";
		String autho = "";
		UserInfoDAO uidao = new UserInfoDAO();
		String sql = "select distinct year from t_jbsp_summary";
		String hql = "from JbspSummary as js where js.year="+year;
	
		String hql2 = "from JbspSummary as js where js.name='"+LeaveUtil.NewNumberToName(newnumber)+"' order by js.year desc";
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(newnumber);
 			position = ui.getPosition();
 			autho = ui.getAuthority();
 			zhi = position.substring(0,1);
			chu = position.substring(2,3);
			zu=position.substring(4,5);
			if(zxtd!=null&&zxtd.equals("td"))
			{
				if(name!=null&&zhuan==1)
				{
					name = new String(name.getBytes("ISO8859-1"),"UTF-8");
				}
				if(name!=null&&name.length()>0)
				{
					hql += " and js.name like '%"+name+"%'";
				}
				if(chutuan>=1&&chutuan<=6)
				{
					hql += " and js.position like '__"+chutuan+"__'";
				}
				else if(chutuan>=7&&chutuan<=9)
				{
					String temptuan = String.valueOf(chutuan-6);
					hql +=  " and js.position like '__3_"+temptuan+"'";
				}
				else if(chutuan>=10&&chutuan<=12)
				{
					String temptuan = String.valueOf(chutuan-9);
					hql +=  " and js.position like '__6_"+temptuan+"'";
				}
				if(zhi.equals("2"))
				{
					hql += " and js.position like '__"+chu+"__'";
				}
				if(zhi.equals("4"))
				{
					hql += " and (js.name in (select username from UserInfo as ui where ui.position like '__"+chu+"_"+zu+"'))";
				}
				if(keyword!=null&&keyword.length()>0)
				{
					hql += " order by js."+keyword+" desc";
				}
				result="successtd";
			}
			else
			{
				hql = hql2;
			}
			System.out.println(hql);
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(hql).list().size();
			initPageProperties();
			list = query.list();
			listyear = session.createSQLQuery(sql).list();
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
