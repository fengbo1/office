package office.kqjl.action;

import java.util.List;

import office.kqjl.pojo.KqjlDaily;
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

public class ViewKqjlGrDaily {
	private static final Log log = LogFactory.getLog(ViewKqjlGrDaily.class);
	private String newnumber;
	private String month;
	private List<KqjlDaily> list;
	private String name;
	private int zhuan;
	private String strtemp;
	private String autho;
	private String para;
	private int ifschzb;//是否可以生成汇总表标志位
	private int yc;
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 16;

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
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public List<KqjlDaily> getList() {
		return list;
	}
	public void setList(List<KqjlDaily> list) {
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAutho() {
		return autho;
	}
	public void setAutho(String autho) {
		this.autho = autho;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public int getIfschzb() {
		return ifschzb;
	}
	public void setIfschzb(int ifschzb) {
		this.ifschzb = ifschzb;
	}
	public int getYc() {
		return yc;
	}
	public void setYc(int yc) {
		this.yc = yc;
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		DateUtil du = new DateUtil();
		String today = du.getStringDate();
		Query query;
		String sql = "";
		String position = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			int workday = du.countThisMonthWorkdaysByDate(session, today);
			if(workday>3)
			{
				ifschzb = 1;
			}
			else
			{
				ifschzb = 0;
			}
			UserInfo ui = uidao.findByNewNumber(newnumber);
			autho = ui.getAuthority();
			position = ui.getPosition();
			para = position;
			if(para.startsWith("4"))
			{
				para = "__"+para.substring(2, 3)+"_"+para.substring(4, 5);
			}
			else
			{
				para = "__"+para.substring(2, 3)+"__";
			}
			sql = "select max(date) from t_kqjl_daily";
			if(month==null||month.equals(""))
			{
				month = session.createSQLQuery(sql).uniqueResult().toString().substring(0, 6);
			}
			else
			{
				month = month.replace("-","");
			}
			if(name!=null)
			{
				if(zhuan==1)
				{
					strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
					name = strtemp;
				}
				else
				{
					strtemp = name;
				}
			}
			UserInfo uish = uidao.findByName(name);//查询传入的姓名
			String hql = "from KqjlDaily as kd where kd.date>='"+month+"01' and kd.date<='"+month+"31' and kd.pbqdtime>'00:00:00' and kd.pbqttime>'00:00:00'";
			if(yc==1)
			{
				hql+=" and (kd.yc=1 or kd.qdqs=1 or kd.qtqs=1)";
			}
			
			if(autho.contains("C")||autho.contains("B"))//团队负责人
			{
				if(uish!=null&&(position.charAt(2)==uish.getPosition().charAt(2)))//查询的是团队内员工
				{
					hql += " and kd.name='"+strtemp+"' order by locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
				}
				else
				{
					hql+=" and kd.position like '__"+position.substring(2, 3)+"__' order by kd.yy desc ,locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
				}
			}
			else if(autho.contains("D"))//组长
			{
				if(uish!=null&&(position.charAt(4)==uish.getPosition().charAt(4)))//查询的是组内员工
				{
					hql+=" and kd.name='"+strtemp+"' order by  locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
				}
				else
				{
					hql+=" and kd.position like '__"+position.substring(2, 3)+"_"+position.substring(4, 5)+"' order by kd.yy desc , locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
				}
			}
			else//普通员工
			{
				hql+=" and kd.name='"+ui.getUsername()+"' order by locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,kd.name, kd.date";
			}
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
