package office.leave.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.Util;

public class ViewAll {

	private static final Log log = LogFactory.getLog(LeavePage.class);
	private String newnumber;// 新一代员工编号
	private List<LeavePage> list;
	private String title;
	private String autho;
	private String begindate;
	private String enddate;
	private String applicant;
	private int type;
	private int status;
	private String strtemp;
	private int chutuan;
	private int zhuan;
	private String zxtd;
	private String nowdate;
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

	public List<LeavePage> getList() {
		return list;
	}

	public void setList(List<LeavePage> list) {
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

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStrtemp() {
		return strtemp;
	}

	public void setStrtemp(String strtemp) {
		this.strtemp = strtemp;
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

	public String getNowdate() {
		return nowdate;
	}

	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}

	public String execute() throws Exception
	{
		String result = "success";
		DateUtil du = new DateUtil();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		Query query;
		String hql = "";
		String position = "";
		String zhi = "";
		String chu = "";
		String zu = "";
		String searchnn = "";
		String bd="";
		String ed="";
		strtemp = "";
		title = "明细查询";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			nowdate = du.getStringDate();
			ui = uidao.findByNewNumber(newnumber);
			position = ui.getPosition();
			autho = ui.getAuthority();
			zhi = position.substring(0,1);
			chu = position.substring(2,3);
			zu = position.substring(4,5);
			hql = "from LeavePage as lp where 1=1";
			if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				bd = begindate.replace("-", "");
				ed = enddate.replace("-", "");
				hql += " and ((lp.begindate>='"+bd+"' and lp.begindate<='"+ed+"') or (lp.enddate>='"+bd+"' and lp.enddate<='"+ed+"') or (lp.begindate<='"+bd+"' and lp.enddate>='"+ed+"'))";
			}
			if(type!=0)
			{
				hql +=" and lp.type="+type;
			}
			if(status==1)
			{
				hql +=" and lp.status=2";
			}
			else if(status==2)
			{
				hql +=" and lp.status in (1,6,7,8,9)";
			}
			else if(status==3)
			{
				hql +=" and lp.status=3";
			}
			if(applicant!=null&&zhuan==1)
			{
				strtemp = new String(applicant.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				strtemp = applicant;
			}
			if(strtemp!=null&&strtemp.length()>0)
			{
				//searchnn = uidao.nameToNewnumber(strtemp);
				//hql +=" and lp.applicant='"+searchnn+"'";
				String sql = "select newnumber from user_info where username like'%"+strtemp+"%'";
				String strtemp = "";
				List<String> listtemp = session.createSQLQuery(sql).list();
				for(int i=0;i<listtemp.size();i++)
				{
					if(i!=0)
					{
						strtemp+=",";
					}
					strtemp+="'";
					strtemp+=listtemp.get(i);
					strtemp+="'";
				}
				hql +=" and lp.applicant in ("+strtemp+")";
			}
				if(zxtd!=null&&zxtd.equals("td"))
				{
				if(chutuan>=1&&chutuan<=6)
				{
					hql += " and lp.chu="+chutuan;
				}
				if(chutuan>6&&chutuan<12)//7891011
				{
					int temptuan = chutuan-6;
					hql +=  " and lp.chu=3 and lp.tuan="+temptuan;
				}
				if(chutuan>11&&chutuan<15)//121314
				{
					int temptuan = chutuan-11;
					hql +=  " and lp.chu=6 and lp.tuan="+temptuan;
				}
				if(zhi.equals("0")||zhi.equals("1"))//主任看全部
				{
					hql += "";
				}
				else if(zhi.equals("2"))//团队负责人
				{
					hql += " and lp.chu="+chu;
				}
			
				else if(zhi.equals("4"))//组长
				{
					hql += " and lp.chu="+chu+" and lp.tuan="+zu;
				}
				else//普通员工
				{
					if(autho.contains("I")||autho.contains("J")||autho.contains("T"))//综合管理处可以看全部
					{
						hql += "";
					}
					else//普通人员只能看自己
					{
						String newnumber1=newnumber.substring(0,8);
						hql += " and substr(lp.applicant,1,8)='"+newnumber1+"'";
					}
				}
				hql += " order by locate('3',lp.status), lp.id desc";
				result = "successtd";
				title = "团队明细";
			}
			else
			{
				String newnumber1=newnumber.substring(0,8);
				hql += " and substr(lp.applicant,1,8)='"+newnumber1+"' order by locate('3',lp.status), lp.id desc";
				title = "个人明细";
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
