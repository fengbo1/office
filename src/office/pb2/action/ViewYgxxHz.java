package office.pb2.action;

import java.util.List;

import office.leave.pojo.LeavePage;
import office.pb2.pojo.TbsqPage;
import office.pb2.pojo.YgxxHz;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewYgxxHz {

	private static final Log log = LogFactory.getLog(ViewYgxxHz.class);
	private String newnumber;
	private int year;
	private int quarter;
	private String name;
	private List<YgxxHz> list;
	private String type;
	private int zhuan;
	private int year1;
	private int year2;
	private int year3;
	private int chutuan;
	
	
	

	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}


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
	public static Log getLog() {
		return log;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<YgxxHz> getList() {
		return list;
	}
	public void setList(List<YgxxHz> list) {
		this.list = list;
	}
	public int getZhuan() {
		return zhuan;
	}
	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}
	public int getYear1() {
		return year1;
	}
	public void setYear1(int year1) {
		this.year1 = year1;
	}
	public int getYear2() {
		return year2;
	}
	public void setYear2(int year2) {
		this.year2 = year2;
	}
	public int getYear3() {
		return year3;
	}
	public void setYear3(int year3) {
		this.year3 = year3;
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		DateUtil du = new DateUtil();
		Query query;
		String hql = "";
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    UserInfo ui = uidao.findByNewNumber(newnumber);
 	    //String position = ui.getPosition();
		try {
			year1 = du.getThisYear();
			year2 = year1-1;
			year3 = year2-1;
			if(name!=null&&zhuan==1)
			{
				name = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				name = name;
			}
			if(type.equals("all"))
			{
				hql = "from YgxxHz as yh where 1=1";
				if(name!=null&&!name.equals(""))
				{
					hql += " and yh.name='"+name+"'";
				}
				if(chutuan>=1&&chutuan<=6)
				{
					hql += " and yh.chu='"+chutuan+"'";
				}
				else if(chutuan>=7&&chutuan<=9)
				{
					int temptuan = chutuan-6;
					hql += " and yh.chu='3' and yh.zu='"+temptuan+"'";
				}
				else if(chutuan>=10&&chutuan<=12)
				{
					int temptuan = chutuan-9;
					hql += " and yh.chu='6' and yh.zu='"+temptuan+"'";
				}
			}
			else
			{
				String strtemp = ui.getUsername();
				int length=strtemp.length();
				String temp=strtemp.substring(length-1, length);
				if(temp.equals("B"))
				{
					strtemp = strtemp.substring(0, length-1);
				}
				hql = "from TYgxxHz as yh where yh.name='"+strtemp+"'";
			}
			if(year!=0)
			{
				hql += " and yh.year="+year;
			}
			if(quarter!=0)
			{
				hql += " and yh.quarter="+quarter;
			}
			hql+=" order by yh.id desc";
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
