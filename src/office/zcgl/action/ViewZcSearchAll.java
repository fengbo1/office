package office.zcgl.action;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.process.pojo.Process;
import office.zcgl.pojo.AssetInfoShowBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class ViewZcSearchAll {
	private static final Log log = LogFactory.getLog(AssetApply.class);
	private String newnumber;
	private UserInfo ui;
	private Integer chu;
	private String position;
	private List<String> listinfo;
	private List<AssetInfo>list;
	private List<AssetInfoShowBean> listshow;
	private String assetname;
	private String assettype;
	private int zhuan;
	private String name;
	private String type;
	private int iswupin;
	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 10;

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


	public int getIswupin() {
		return iswupin;
	}


	public void setIswupin(int iswupin) {
		this.iswupin = iswupin;
	}


	public List<AssetInfoShowBean> getListshow() {
		return listshow;
	}


	public void setListshow(List<AssetInfoShowBean> listshow) {
		this.listshow = listshow;
	}


	public int getZhuan() {
		return zhuan;
	}


	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
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


	public List<AssetInfo> getList() {
		return list;
	}


	public void setList(List<AssetInfo> list) {
		this.list = list;
	}


	public String getAssetname() {
		return assetname;
	}


	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}


	public String getAssettype() {
		return assettype;
	}


	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}


	public List<String> getListinfo() {
		return listinfo;
	}


	public void setListinfo(List<String> listinfo) {
		this.listinfo = listinfo;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public Integer getChu() {
		return chu;
	}


	public void setChu(Integer chu) {
		this.chu = chu;
	}

	public UserInfo getUi() {
		return ui;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public void setUi(UserInfo ui) {
		this.ui = ui;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    Query query;
 	    Query querylist;
		String hql = "";
 	    String hqllist="";
 	    if(assetname!=null&&!assetname.equals("wu")&&zhuan==1&&!assetname.equals(""))
		{
			name = new String(assetname.getBytes("ISO8859-1"),"UTF-8");
		}
 	    else
 	    {
 	    	name=assetname;
 	    }
 	    if(assettype!=null&&!assettype.equals("wu")&&zhuan==1&&!assettype.equals(""))
		{
			type = new String(assettype.getBytes("ISO8859-1"),"UTF-8");
		}
 	    else
 	    {
 	    	type=assettype;
 	    }
 	    //hqllist="from AssetInfo as ai where ai.chu='"+chu+"'";
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    ui = uidao.findByNewNumber(newnumber);
 	    position = ui.getPosition();
 	    chu = Integer.parseInt(position.substring(2,3));
 	    int zhi = Integer.parseInt(position.substring(0,1));
 	    hqllist="select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from AssetInfo as ai group by ai.name, ai.type,ai.chu,ai.status having ai.chu='"+chu+"'";
 	    if(iswupin==1)
	    {
	    	hqllist = "select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from AssetInfo as ai where ai.iswupin=0 group by ai.name, ai.type,ai.chu,ai.status having ai.chu='"+chu+"'";
	    }
	    if(iswupin==2)
	    {
	    	hqllist = "select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from AssetInfo as ai where ai.iswupin=1 group by ai.name, ai.type,ai.chu,ai.status having ai.chu='"+chu+"'";
	    }
	    
 	    if(assetname!=null&&!assetname.equals("wu")&&!assetname.equals(""))
 	    {
 	    	hqllist+= " and ai.name='"+name+"'";
 	    }
 	    if(assettype!=null&&!assettype.equals("wu")&&!assettype.equals(""))
 	    {
 	    	hqllist+= " and ai.type='"+type+"'";
 	    }
 	    /*if(assetname!=null&&assettype!=null&&!assetname.equals("")&&!assettype.equals(""))
 	    { 	
 	    if(!assetname.equals("wu")&&!assettype.equals("wu")&&!assetname.equals("0")&&!assettype.equals("0"))
 	    {
 	    	hqllist += " and ai.name='"+name+"' and ai.type='"+type+"'";
 	    }
 	    if(!assetname.equals("wu")&&!assettype.equals("wu")&&!assetname.equals("0")&&assettype.equals("0"))
	    {
	    	hqllist += " and ai.name='"+name+"'";
	    }
 	    }*/
	    
	    
 	    hqllist += " order by ai.name,ai.type,ai.chu,ai.status";
 	    hql = "select distinct(ai.name) from AssetInfo as ai where ai.chu='"+chu+"'order by ai.id";
		query = session.createQuery(hql);
		listinfo= query.list();
		querylist = session.createQuery(hqllist);
		querylist.setFirstResult(pageSize * (currentPage - 1));
		querylist.setMaxResults(pageSize);
		totalRows = session.createQuery(hqllist).list().size();
		initPageProperties();
		list = querylist.list();
		Iterator itor = list.iterator();
		listshow =new ArrayList<AssetInfoShowBean>();
		while(itor.hasNext())
		{	
			Object[] object = (Object[])itor.next();
			AssetInfoShowBean as = new AssetInfoShowBean();
			as.setName(object[0].toString());
			as.setType(object[1].toString());
			as.setChu((Integer)object[2]);
			as.setStatus((Integer)object[3]);
			as.setNum(object[4].toString());	
			listshow.add(as);		
		}
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
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
