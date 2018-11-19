package office.leave.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.leave.pojo.LeaveSummary;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.LeaveUtil;
import office.util.Util;

public class ViewSummary {

	private static final Log log = LogFactory.getLog(LeaveSummary.class);
	private List<LeaveSummary> list;
	private String name;//姓名
	private String keyword;
	private int year;
	private int zhuan;
	private String newnumber;
	private int chutuan;
	private List<Integer> listyear; 
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

	public List<LeaveSummary> getList() {
		return list;
	}

	public void setList(List<LeaveSummary> list) {
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

	public List<Integer> getListyear() {
		return listyear;
	}

	public void setListyear(List<Integer> listyear) {
		this.listyear = listyear;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
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
		Query query;
		String position = "";
		String zhi = "";
		String chu = "";
		String zu = "";
		String autho = "";
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(newnumber);
 			position = ui.getPosition();
 			autho = ui.getAuthority();
 			zhi = position.substring(0,1);
			chu = position.substring(2,3);
			zu = position.substring(4,5);
			String sql = "select distinct year from t_leave_summary order by id desc";
			String hql = "select * from t_leave_summary a,user_info b where a.name=b.username and a.year="+year;
			//普通员工只能看自己的
			String strtemp = LeaveUtil.NewNumberToNameNoSession(newnumber);
			int length=strtemp.length();
			String temp=strtemp.substring(length-1, length);
			if(temp.equals("B"))
			{
				strtemp = strtemp.substring(0, length-1);
			}
			String hql2 = "select * from t_leave_summary where name='"+strtemp+"' order by year desc";
			if(zxtd==null||!zxtd.equals("td"))//普通员工
			{
				hql = hql2;
			}
			else
			{
				if(name!=null&&zhuan==1)
				{
					name = new String(name.getBytes("ISO8859-1"),"UTF-8");
				}
				if(name!=null&&name.length()>0)
				{
					hql += " and a.name like '%"+name+"%'";
				}
				if(chutuan>=1&&chutuan<=6)
				{
					hql += " and b.position like '__"+chutuan+"__'";
				}
				if(chutuan>6&&chutuan<10)//789
				{
					String temptuan = String.valueOf(chutuan-6);
					hql +=  " and b.position like '__3_"+temptuan+"'";
				}
				if(chutuan>9&&chutuan<13)//101112
				{
					String temptuan = String.valueOf(chutuan-9);
					hql +=  " and b.position like '__6_"+temptuan+"'";
				}
				if(zhi.equals("4"))//小组长
				{
					hql += " and a.name in (select username from user_info where position like '__"+chu+"_"+zu+"')";
				}
				if(zhi.equals("2"))
				{
					if(chu.equals("4"))
					{
						hql += " and a.name in (select username from user_info where position like '__"+chu+"_"+zu+"')";
					}
					else
					{
						hql += " and a.name in (select username from user_info where position like '__"+chu+"__')";
					}
				}
				if(keyword!=null&&keyword.length()>0)
				{
					hql += " order by a."+keyword+" desc";
				}
				result = "successtd";
			}
			System.out.println(hql);
			query = session.createSQLQuery(hql).addEntity(LeaveSummary.class);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createSQLQuery(hql).list().size();
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
