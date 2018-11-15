package office.zcgl.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import office.zcgl.pojo.AssetInfoShowBean;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.process.pojo.Process;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class ViewZcSearchAllZx {
	private static final Log log = LogFactory.getLog(AssetApply.class);
	private String newnumber;
	private UserInfo ui;
	private Integer chu;
	private String position;
	private String assetchu;
	private int zhuan;
	private List<AssetInfo>list;
	private List<AssetInfoShowBean> listshow;
	private String assetname;
	private String assettype;
	private List<String> listinfo;
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


	public List<String> getListinfo() {
		return listinfo;
	}


	public void setListinfo(List<String> listinfo) {
		this.listinfo = listinfo;
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


	public String getAssetchu() {
		return assetchu;
	}


	public void setAssetchu(String assetchu) {
		this.assetchu = assetchu;
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
 	    Query queryinfo;
		String hql = "";
		String hql1 = "";
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    ui = uidao.findByNewNumber(newnumber);
 	    position = ui.getPosition();
 	    if((assetchu!=null)&&(!assetchu.equals("wu"))&&(!assetchu.equals("")))
 	    {	
 	       chu = Integer.parseInt(assetchu);
 	    }
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
 	    int zhi = Integer.parseInt(position.substring(0,1));
 	    
 	    hql = "select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from AssetInfo as ai group by ai.name, ai.type,ai.chu,ai.status ";
 	    if(iswupin==1)
 	    {
 	    	hql = "select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from AssetInfo as ai where ai.iswupin=0 group by ai.name, ai.type,ai.chu,ai.status ";
 	    }
 	    if(iswupin==2)
	    {
	    	hql = "select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from AssetInfo as ai where ai.iswupin=1 group by ai.name, ai.type,ai.chu,ai.status ";
	    }
 	    
 	    if((assetname!=null&&!assetname.equals("wu")&&!assetname.equals(""))||(assettype!=null&&!assettype.equals("wu")&&!assettype.equals(""))||(assetchu!=null&&!assetchu.equals("wu")&&!assetchu.equals("")))
 	    {
 	    	hql+= "having 1=1"; 
 	    }
 	    if(assetname!=null&&!assetname.equals("wu")&&!assetname.equals(""))
 	    {
 	    	hql+= " and ai.name='"+name+"'";
 	    }
 	    if(assettype!=null&&!assettype.equals("wu")&&!assettype.equals(""))
 	    {
 	    	hql+= " and ai.type='"+type+"'";
 	    }
 	    if(assetchu!=null&&!assetchu.equals("wu")&&!assetchu.equals(""))
 	    {
 	    	hql+= " and ai.chu='"+chu+"'";
 	    }
 	   /* if(assetchu!=null&&assetname!=null&&assettype!=null&&!assetchu.equals("")&&!assetname.equals("")&&!assettype.equals(""))
 	    {
 	    if(!assetchu.equals("0")&&!assetname.equals("wu")&&!assettype.equals("wu")&&!assetname.equals("0")&&!assettype.equals("0"))
	    {
	    	hql+= "having ai.chu='"+chu+"' and ai.name='"+name+"' and ai.type='"+type+"'";
	    }
 	    else if(!assetchu.equals("0")&&!assetname.equals("wu")&&!assettype.equals("wu")&&!assetname.equals("0")&&assettype.equals("0"))
	    {
	    	hql+= " having ai.chu='"+chu+"' and ai.name='"+name+"'";
	    }
 	    else if(!assetchu.equals("0")&&!assetname.equals("wu")&&!assettype.equals("wu")&&assetname.equals("0")&&assettype.equals("0"))
	    {
	    	hql+= "having ai.chu='"+chu+"'";
	    }
 	    else if(assetchu.equals("0")&&!assetname.equals("wu")&&!assettype.equals("wu")&&!assetname.equals("0")&&!assettype.equals("0"))
	    {
 	    	hql+= "having ai.name='"+name+"' and ai.type='"+type+"'";
	    }
 	    else if(assetchu.equals("0")&&!assetname.equals("wu")&&!assettype.equals("wu")&&!assetname.equals("0")&&assettype.equals("0"))
	    {
	    	hql+= "having ai.name='"+name+"'";
	    }
 	    }*/
 	    
 	  
 	    hql+= " order by ai.name,ai.type,ai.chu,ai.status";
		query = session.createQuery(hql);
		query.setFirstResult(pageSize * (currentPage - 1));
		query.setMaxResults(pageSize);
		totalRows = session.createQuery(hql).list().size();
		initPageProperties();
		list=query.list();
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
		

//		for(int i=0;i<listtemp.size();ai++)
//		{
//			AssetInfoShow as=new AssetInfoShow();
//			as=(AssetInfoShow)listtemp.get(i);
//			list.add(as);	
//		}

		
		hql1 = "select distinct(ai.name) from AssetInfo as ai order by ai.id";
		queryinfo = session.createQuery(hql1);
	    listinfo= queryinfo.list();
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
