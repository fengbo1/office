package office.userinfo.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.userinfo.pojo.UserInfo;
import office.util.Util;

public class UserList {

	private static final Log log = LogFactory.getLog(UserList.class);
	private String newnumber;
	private int zhuan;
	private String strtemp;
	private String name;
	private int chutuan;
	private List<UserInfo> list;
	
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
	public int getZhuan() {
		return zhuan;
	}
	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}
	public String getStrtemp() {
		return strtemp;
	}
	public void setStrtemp(String strtemp) {
		this.strtemp = strtemp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
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
		Query query;
		String hql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			hql = "from UserInfo as ui where ui.id>0";
			if(name!=null&&zhuan==1)
			{
				strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");;
			}
			else
			{
				strtemp = name;
			}
			if(strtemp!=null)
			{
				hql += " and ui.username like '%"+strtemp+"%'";
			}
			if(chutuan>9)
			{
				String zu = String.valueOf(chutuan-9);
				hql += " and ui.position like '__6_"+zu+"'";
			}
			else if(chutuan>6)
			{
				String zu = String.valueOf(chutuan-6);
				hql += " and ui.position like '__3_"+zu+"'";
			}
			else if(chutuan>0)
			{
				hql += " and ui.position like '__"+chutuan+"__'";
			}
			hql +="order by ui.paixu";
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
