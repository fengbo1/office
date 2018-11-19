package office.pb.action;

import java.util.List;

import office.pb.dao.PbMxDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class PbMx {

	private String name;
	private String type;//day,month
	private String date;
	private String newnumber;
	private List<PbMx> listpm;
	private int zhuan;
	private int bc;//班次
	private int chu;
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 14;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<PbMx> getListpm() {
		return listpm;
	}
	public void setListpm(List<PbMx> listpm) {
		this.listpm = listpm;
	}
	public int getZhuan() {
		return zhuan;
	}
	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}
	public int getBc() {
		return bc;
	}
	public void setBc(int bc) {
		this.bc = bc;
	}
	public int getChu() {
		return chu;
	}
	public void setChu(int chu) {
		this.chu = chu;
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
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String execute() throws Exception
	{
		PbMxDAO pmdao = new PbMxDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Query query;
		String hql = "";
		String sql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			if(name!=null&&zhuan==1)
			{
				name = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				name = name;
			}
			UserInfo ui = uidao.findByNewNumber(newnumber);
			String position = ui.getPosition();
			sql = "select max(month) from t_pb_mx";
			String month = session.createSQLQuery(sql).uniqueResult().toString();
			sql = "select max(date) from t_pb_mx";
			if(date==null)
			{
				date = session.createSQLQuery(sql).uniqueResult().toString();
			}
			else
			{
				date=date.replace("-", "");
			}
			hql = "from PbMx as px where 1=1";
			char cc = ui.getPosition().charAt(2);
			if(cc=='4')
			{
				hql += " and px.plantype="+2;
			}
			if(cc=='3'||cc=='2')
			{
				hql += " and px.plantype="+1;
			}
			if(bc!=0)
			{
				hql += " and px.wb="+bc;
			}
			if(position.startsWith("303"))//普通员工默认看自己
			{
				hql += " and px.name='"+ui.getUsername()+"'";
			}
			if(type==null)//无
			{
				if(position.startsWith("303"))
				{
					type="month";
					hql += " and px.date like '"+date.substring(0, 6)+"__'";
				}
				else
				{
					type="day";
					hql += " and px.date='"+date+"'";
					if(position.startsWith("4"))//组长默认看本组
					{
						hql += " and px.position like '__3_"+position.substring(4, 5)+"'";
					}
				}
				
			}
			else//有选type的权限
			{
				if(name!=null&&!name.equals(""))
				{
					hql += " and px.name='"+name+"'";
				}
				if(type.equals("month"))//查询当月
				{
					hql += " and px.date like '"+date.substring(0, 6)+"__'";
				}
				else if(type.equals("day"))//查询当日
				{
					hql += " and px.date='"+date+"'";
				}
				if(chu>0&&chu<5)
				{
					
					hql += " and px.position like '__"+chu+"__'";
				}
				if(chu==0)
				{
					if(position.startsWith("4"))//组长默认看本组
					{
						hql += " and px.position like '__3_"+position.substring(4, 5)+"'";
					}
				}
				if(chu>4)
				{
					int c = chu-4;
					hql += " and px.team="+c;
				}
			}
			hql += " order by px.date,px.team,px.position";
			System.out.println(hql);
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(hql).list().size();
			initPageProperties();
			listpm = query.list();
			date = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8);
		}catch (Exception e) {
			trans.rollback();//出错回滚
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
			System.out.println("没有初始化totalRows参数！");
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
