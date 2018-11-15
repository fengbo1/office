package office.jbsp.action;

import java.util.List;

import office.jbsp.pojo.JbspPage;
import office.leave.pojo.LeavePage;
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

public class ViewJbspUnder {
	private static final Log log = LogFactory.getLog(LeavePage.class);
	private String newnumber;
	private List<JbspPage> list;


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


	public List<JbspPage> getList() {
		return list;
	}


	public void setList(List<JbspPage> list) {
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


	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		Query query;
		String hql = "";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		try {
			UserInfo ui = uidao.findByNewNumber(newnumber);
			String newnumber1=newnumber.substring(0,8);
			hql = "from JbspPage as jb where substr(jb.thisunder,1,8)='"+newnumber1+"' or (substr(jb.initiator,1,8)='"+newnumber1+"' and jb.status in (0,5)) order by jb.id desc";
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
		return "success";
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
