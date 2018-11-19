package office.srzm.action;
import java.util.List;

import office.srzm.pojo.TSrzm;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
public class ViewSrzmAll {
	private static final Log log = LogFactory.getLog(TSrzm.class);
	private String newnumber;// 新一代员工编号
	private List<TSrzm> list;
	private String title;
	private String authoI;
	private String authoJ;
	private String authoG;
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
	private int pageSize = 8;

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

	
	public String getAuthoG() {
		return authoG;
	}

	public void setAuthoG(String authoG) {
		this.authoG = authoG;
	}

	public List<TSrzm> getList() {
		return list;
	}

	public void setList(List<TSrzm> list) {
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



	public String getAuthoI() {
		return authoI;
	}

	public void setAuthoI(String authoI) {
		this.authoI = authoI;
	}

	public String getAuthoJ() {
		return authoJ;
	}

	public void setAuthoJ(String authoJ) {
		this.authoJ = authoJ;
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
		Query query;
		String hql = "";
		String position = "";
		String zhi = "";
		String chu = "";
		String zu = "";
		String bd = "";
		String ed = "";
		String un = "";
		title = "统计查询-明细查询";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			ui = uidao.findByNewNumber(newnumber);
			position = ui.getPosition();
			
			zhi = position.substring(0,1);
			chu = position.substring(2,3);
			zu = position.substring(4,5);
			hql = "from TSrzm as tz";
			if(name!=null&&zhuan==1)
			{
				strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				strtemp = name;
			}
			un = uidao.nameToNewnumbernull(strtemp);
			hql +=" where tz.applicant like '%"+un+"%'";
			if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				bd = begindate.replace("-","");
				ed = enddate.replace("-", "");
				hql += " and tz.date>='"+bd+"' and tz.date<='"+ed+"'";
			}
			if(zxtd!=null&&zxtd.equals("td"))
			{
				if(chutuan>=1&&chutuan<=6)
				{
					hql += " and tz.chu='"+chutuan+"'";
				}
				else if(chutuan>=7&&chutuan<=9)
				{
					int temptuan = chutuan-6;
					hql += " and tz.chu='3' and tz.zu='"+temptuan+"'";
				}
				else if(chutuan>=10&&chutuan<=12)
				{
					int temptuan = chutuan-9;
					hql+=" and tz.chu='6' and tz.zu='"+temptuan+"'";
					
				}
				if(zhi.equals("0")||zhi.equals("1")||authoI.equals("I")||authoJ.equals("J")||authoG.equals("G"))//主任看全部
				{
					hql += "";
				}
				else if(zhi.equals("2"))//团队负责人
				{
					hql += " and tz.chu='"+chu+"'";
				}
				
				else if(zhi.equals("4"))//组长
				{
					hql += " and tz.chu='"+chu+"' and tz.zu='"+zu+"'";
				}
				result = "successtd";
			}
			else//普通员工
			{
				String newnumber1=newnumber.substring(0,8);
				hql += " and substr(tz.initiator,1,8)='"+newnumber1+"'";
			}
			hql += " order by tz.id desc";
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
