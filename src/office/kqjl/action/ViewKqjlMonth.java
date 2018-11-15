package office.kqjl.action;

import java.util.List;

import office.kqjl.dao.KqjlUploadDAO;
import office.kqjl.pojo.KqjlMonth;
import office.kqjl.pojo.KqjlUpload;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewKqjlMonth {
	private static final Log log = LogFactory.getLog(ViewKqjlMonth.class);
	private String newnumber;
	private List<KqjlMonth> list;
	private String month;
	private int chu;
	private String key;
	private int sequence;
	private String name;
	private String strtemp;
	private int zhuan;
	private KqjlUpload ku;
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 15;

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
	public List<KqjlMonth> getList() {
		return list;
	}
	public void setList(List<KqjlMonth> list) {
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getChu() {
		return chu;
	}
	public void setChu(int chu) {
		this.chu = chu;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public KqjlUpload getKu() {
		return ku;
	}
	public void setKu(KqjlUpload ku) {
		this.ku = ku;
	}
	public String execute() throws Exception
	{
		KqjlUploadDAO kudao = new KqjlUploadDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Query query;
		String hql = "";
		String sql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UserInfo ui = uidao.findByNewNumber(newnumber);
			int viewerchu = Integer.parseInt(ui.getPosition().substring(2, 3));
			int zhi = Integer.parseInt(ui.getPosition().substring(0, 1));
			String poslike="";
			sql = "select max(month) from t_kqjl_month";
			if(chu>9)
			{
				poslike = "__6_"+String.valueOf((chu-9));
			}
			else if(chu>6)
			{
				poslike = "__3_"+String.valueOf((chu-6));
			}
			else
			{
				poslike = "__"+String.valueOf((chu))+"__";
			}
			if(month==null||month.equals(""))
			{
				month = session.createSQLQuery(sql).uniqueResult().toString();
			}
			ku = kudao.findAllByMonth(month);
			if(ku.getKqjl1()==1&&ku.getKqjl2()==1&&ku.getKqjl3()==1&&ku.getKqjl4()==1)
			{
				hql = "from KqjlMonth as km where km.month='"+month+"'";
				if((zhi!=3)||ui.getAuthority().contains("I")||ui.getAuthority().contains("J"))//有权限人员
				{
					if(zhi==4)//组长
					{
						hql +=" and km.position like '__"+viewerchu+"_"+ui.getPosition().substring(4, 5)+"'";
					}
					else if(zhi==2||zhi==1)//处长
					{
						hql +=" and km.position like '__"+viewerchu+"__'";
					}
					if(chu!=0)
					{
						hql +=" and km.position like '"+poslike+"'";
					}	
					if(name!=null&&zhuan==1)
					{
						strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
					}
					else
					{
						strtemp = name;
					}
					System.out.println("keyword:"+strtemp);
					if(strtemp!=null)
					{
						hql +=" and km.name like '%"+strtemp+"%'";
					}
					if(key!=null&&!key.equals(""))
					{
						if(key.equals("chitui"))
						{
							hql = hql+" order by km.chidao+km.zaotui";
						}
						else
						{
							hql = hql+" order by km."+key;
						}
					}
					else
					{
						hql = hql+" order by km.id";
					}
					if(sequence==1)
					{
						hql = hql+" desc";
					}
				}
				else//普通员工
				{
					hql = "from KqjlMonth as km where km.month='"+month+"' and km.newnumber='"+newnumber+"'";
				}
				System.out.println(hql);
				query = session.createQuery(hql);
				query.setFirstResult(pageSize * (currentPage - 1));
				query.setMaxResults(pageSize);
				totalRows = session.createQuery(hql).list().size();
				initPageProperties();
				list = query.list();
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
