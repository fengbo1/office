package office.kqjl.action;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.kqjl.pojo.KqjlDaily;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.Util;

public class ViewKqjlDaily {
	private static final Log log = LogFactory.getLog(ViewKqjlDaily.class);
	private String newnumber;
	private String date;
	private int chu;
	private int tj;
	private String key;
	private int zhuan;
	private String strtemp;
	private List<KqjlDaily> list;
	private int ifschzb;//是否可以生成汇总表标志位
	private String para;//传入的position参数
	private int md;//查询当月、查询当日切换
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
	
	public int getZhuan() {
		return zhuan;
	}
	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getChu() {
		return chu;
	}
	public void setChu(int chu) {
		this.chu = chu;
	}
	public int getTj() {
		return tj;
	}
	public void setTj(int tj) {
		this.tj = tj;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
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
	public String getStrtemp() {
		return strtemp;
	}
	public void setStrtemp(String strtemp) {
		this.strtemp = strtemp;
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
	public int getMd() {
		return md;
	}
	public void setMd(int md) {
		this.md = md;
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		DateUtil du = new DateUtil();
		String today = du.getStringDate();
		Query query;
		String hql = "";
		String sql = "";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UserInfo ui = uidao.findByNewNumber(newnumber);
			para = ui.getPosition();
			if(para.startsWith("4"))
			{
				para = "__"+para.substring(2, 3)+"_"+para.substring(4, 5);
			}
			else
			{
				para = "__"+para.substring(2, 3)+"__";
			}
			sql = "select max(date) from t_kqjl_daily where week<6";
			if(date==null||date.equals(""))
			{
				date = session.createSQLQuery(sql).uniqueResult().toString();
			}
			else
			{
				date = date.replace("-","");
			}
			hql = "from KqjlDaily as kd";
			if(md==0)
			{
				hql+= " where kd.date='"+date+"'";
			}
			else
			{
				hql+= " where kd.date>='"+date.substring(0, 6)+"01' and kd.date<='"+date.substring(0, 6)+"31'";
			}
			hql+=" and kd.pbqdtime>'00:00:00' and kd.pbqttime>'00:00:00'";
			date = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8);
			if(chu!=0)
				hql+=" and kd.position like '__"+chu+"__'";
			if(key!=null&&zhuan==1)
			{
				strtemp = new String(key.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				strtemp = key;
			}
			System.out.println("keyword:"+strtemp);
			if(strtemp!=null)
			{
				hql +=" and kd.name like '%"+strtemp+"%'";
			}
			if(tj==1)//只看迟到早退
			{
				hql +=" and (kd.qdqs=2 or kd.qtqs=2)";
			}
			if(tj==2)//只看考勤缺失
			{
				hql +=" and (kd.qdqs=1 or kd.qtqs=1)";
			}
			if(tj==3)//只看外出公干
			{
				hql +=" and kd.gg=1";
			}
			if(tj==4)//只看请假
			{
				hql +=" and kd.qj>0";
			}
			if(tj==9)//只看异常记录
			{
				hql +=" and kd.yc=1";
			}
			//locate('1',kd.qdqs) desc,locate('1',kd.qtqs) desc,locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc,
			hql +=" order by locate('2',kd.qdqs) desc,locate('2',kd.qtqs) desc, kd.name, kd.position,kd.date";
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
