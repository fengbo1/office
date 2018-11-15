package office.pb2.action;

import java.util.ArrayList;
import java.util.List;

import office.leave.pojo.LeavePage;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewYgxxAll {

	private static final Log log = LogFactory.getLog(LeavePage.class);
	private String newnumber;
	private List<XxsqPage> list;
	private String type;
	private String begindate;
	private String enddate;
	private String name;
	private int zhuan;
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
	public List<XxsqPage> getList() {
		return list;
	}
	public void setList(List<XxsqPage> list) {
		this.list = list;
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
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		Query query;
		String hql = "";
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    UserInfo ui = uidao.findByNewNumber(newnumber);
		try {
			if(name!=null&&zhuan==1)
			{
				name = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				name = name;
			}
			list = new ArrayList<XxsqPage>();
			if(type.equals("all"))
			{
				hql = "from XxsqPage as xp where 1=1";
				if(name!=null&&!name.equals(""))
				{
					hql += " and xp.people like '%"+name+"%'";
				}
				if(chutuan>=1&&chutuan<=6)
				{
					hql += " and xp.chu='"+chutuan+"'";
				}
				else if(chutuan>=7&&chutuan<=9)
				{
					int temptuan = chutuan-6;
					hql += " and xp.chu='3' and xp.zu='"+temptuan+"'";
				}
				else if(chutuan>=10&&chutuan<=12)
				{
					int temptuan = chutuan-9;
					hql += " and xp.chu='6' and xp.zu='"+temptuan+"'";
				}
			}
			else
			{
				String newnumber1=newnumber.substring(0,8);
				String strtemp = ui.getUsername();
				int length=strtemp.length();
				String temp=strtemp.substring(length-1, length);
				if(temp.equals("B"))
				{
					strtemp = strtemp.substring(0, length-1);
				}
				hql = "from XxsqPage as xp where substr(xp.initiator,1,8)='"+newnumber1+"' or xp.people like '%"+strtemp+"%'";
			}
			if(begindate!=null&&enddate!=null&&!begindate.equals("")&&!enddate.equals(""))
			{
				String bdtemp = begindate.replace("-", "");
				String edtemp = enddate.replace("-", "");
				hql += " and ((xp.begindate>='"+bdtemp+"' and xp.begindate<='"+edtemp+"') or (xp.enddate>='"+bdtemp+"' and xp.enddate<='"+edtemp+"') or (xp.begindate<='"+bdtemp+"' and xp.enddate>='"+edtemp+"'))";
			}
			hql += " order by locate('6',xp.status),xp.id desc";
			System.out.println(hql);
			query = session.createQuery(hql);
			List<XxsqPage> listxptemp = session.createQuery(hql).list();
			for(int i=0;i<listxptemp.size();i++)
			{
				XxsqPage xp = listxptemp.get(i);
				String[] peoples = xp.getPeople().split("、");
				for(int j=0;j<peoples.length;j++)
				{
					XxsqPage xptemp = new XxsqPage();
					xptemp.setNumber(xp.getNumber());
					xptemp.setDate(xp.getDate());
					xptemp.setStatus(xp.getStatus());
					xptemp.setPreundertake(xp.getPreundertake());
					xptemp.setUndertake(xp.getUndertake());
					xptemp.setInitiator(xp.getInitiator());
					xptemp.setApplicant(xp.getApplicant());
					xptemp.setPeople(peoples[j]);
					xptemp.setTel(xp.getTel());
					xptemp.setBegindate(xp.getBegindate());
					xptemp.setEnddate(xp.getEnddate());
					xptemp.setHalfday(xp.getHalfday());
					xptemp.setDay(xp.getDay());
					xptemp.setHour(xp.getHour());
					xptemp.setType(xp.getType());
					xptemp.setReason(xp.getReason());
					xptemp.setQita(xp.getQita());
					xptemp.setRemark(xp.getRemark());
					if(name!=null&&!name.equals(""))
					{
						if(name.equals(peoples[j]))
						{
							list.add(xptemp);
						}
					}
					else
					{
						list.add(xptemp);
					}
				}
			}
			totalRows = list.size();
			initPageProperties();
			currentPage = currentPage <= 1 ? 1 : currentPage;
			if(pageSize*currentPage<list.size())
			{
				list = list.subList(pageSize * (currentPage - 1), pageSize * (currentPage));
			}
			else
			{
				list = list.subList(pageSize * (currentPage - 1),(int)totalRows);
			}
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
