package office.zcgl.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetBorrow;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.AssetInfoShowBean;
import office.zcgl.pojo.AssetInfoShowNewBean;
import office.zcgl.pojo.ChuAndNum;
import office.zcgl.pojo.SearchInfoBean;
import office.zcgl.pojo.TypeAndNum;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewZcSearchAllNewZx {
	private static final Log log = LogFactory.getLog(AssetApply.class);
	private String newnumber;
	private UserInfo ui;
	private Integer chu;
	private String position;
	private String assetchu;
	private int zhuan;
	private List<AssetInfo>list;
	private List<AssetInfo>list1;
	private List<AssetInfo>list2;
	private List<AssetInfo>list3;
	private List<AssetInfoShowNewBean> listshow;
	private List<AssetInfoShowBean> listsingleshow;
	private String assetname;
	private String assettype;
	private List<String> listinfo;
	private String name;
	private String type;
	private int iswupin;
	private JSONArray Array;
	private String ss;
	
	
	public JSONArray getArray() {
		return Array;
	}



	public void setArray(JSONArray array) {
		Array = array;
	}



	public String getSs() {
		return ss;
	}



	public void setSs(String ss) {
		this.ss = ss;
	}



	public List<AssetInfo> getList3() {
		return list3;
	}



	public void setList3(List<AssetInfo> list3) {
		this.list3 = list3;
	}



	public List<AssetInfoShowBean> getListsingleshow() {
		return listsingleshow;
	}



	public void setListsingleshow(List<AssetInfoShowBean> listsingleshow) {
		this.listsingleshow = listsingleshow;
	}



	public String getNewnumber() {
		return newnumber;
	}



	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}



	public UserInfo getUi() {
		return ui;
	}



	public void setUi(UserInfo ui) {
		this.ui = ui;
	}



	public Integer getChu() {
		return chu;
	}



	public void setChu(Integer chu) {
		this.chu = chu;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getAssetchu() {
		return assetchu;
	}



	public void setAssetchu(String assetchu) {
		this.assetchu = assetchu;
	}



	public int getZhuan() {
		return zhuan;
	}



	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}



	public List<AssetInfo> getList() {
		return list;
	}



	public void setList(List<AssetInfo> list) {
		this.list = list;
	}



	public List<AssetInfo> getList1() {
		return list1;
	}



	public void setList1(List<AssetInfo> list1) {
		this.list1 = list1;
	}



	public List<AssetInfo> getList2() {
		return list2;
	}



	public void setList2(List<AssetInfo> list2) {
		this.list2 = list2;
	}



	public List<AssetInfoShowNewBean> getListshow() {
		return listshow;
	}



	public void setListshow(List<AssetInfoShowNewBean> listshow) {
		this.listshow = listshow;
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
 	    
 	    hql = "select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from asset_info as ai group by ai.name, ai.type,ai.chu,ai.status ";
 	  //  String hql2 = "select ai.name,count(distinct(ai.type)) from AssetInfo as ai group by ai.name";
 	  //  String sql2 = "select ai.name,count(distinct(ai.type)) from asset_info as ai group by ai.name";
 	  //  String hql3 = "select ai.name,ai.type,count(ai.type) from AssetInfo as ai group by ai.name,ai.type ";
 	    if(iswupin==1)
 	    {
 	    	hql = "select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from asset_info as ai where ai.iswupin=1 group by ai.name, ai.type,ai.chu,ai.status ";
 	    	//hql2 = "select ai.name,count(distinct(ai.type)) from AssetInfo as ai where ai.iswupin=0 group by ai.name";
 	    	//sql2 = "select ai.name,count(distinct(ai.type)) from asset_info as ai where ai.iswupin=0 group by ai.name";
 	 	   // hql3 = "select ai.name,ai.type,count(ai.type) from AssetInfo as ai where ai.iswupin=0 group by ai.name,ai.type "; 	    
 	    }
 	    
 	    if(iswupin==2)
	    {
	    	hql = "select ai.name,ai.type,ai.chu,ai.status,count(ai.name) from asset_info as ai where ai.iswupin=0 group by ai.name, ai.type,ai.chu,ai.status ";
	    	//hql2 = "select ai.name,count(distinct(ai.type)) from AssetInfo as ai where ai.iswupin=1 group by ai.name";
	    	//sql2 = "select ai.name,count(distinct(ai.type)) from asset_info as ai where ai.iswupin=1 group by ai.name";
 	 	   // hql3 = "select ai.name,ai.type,count(ai.type) from AssetInfo as ai where ai.iswupin=1 group by ai.name,ai.type "; 	
	    }
 	    
 	    if((assetname!=null&&!assetname.equals("wu")&&!assetname.equals(""))||(assettype!=null&&!assettype.equals("wu")&&!assettype.equals(""))||(assetchu!=null&&!assetchu.equals("wu")&&!assetchu.equals("")))
 	    {
 	    	hql+= "having 1=1"; 
 	    	//hql2+= "having 1=1"; 
 	    	//sql2+= "having 1=1"; 
 	    	//hql3+= "having 1=1"; 
 	    }
 	    if(assetname!=null&&!assetname.equals("wu")&&!assetname.equals(""))
 	    {
 	    	hql+= " and ai.name='"+name+"'";
 	    	//hql2+= " and ai.name='"+name+"'";
 	    	//sql2+= " and ai.name='"+name+"'";
 	    	//hql3+= " and ai.name='"+name+"'";
 	    }
 	    if(assettype!=null&&!assettype.equals("wu")&&!assettype.equals(""))
 	    {
 	    	hql+= " and ai.type='"+type+"'";
 	    	//hql2+= " and ai.type='"+type+"'";
 	    	//sql2+= " and ai.type='"+type+"'";
 	    	//hql3+= " and ai.type='"+type+"'";
 	    }
 	    if(assetchu!=null&&!assetchu.equals("wu")&&!assetchu.equals(""))
 	    {
 	    	hql+= " and ai.chu='"+chu+"'";
 	    	//hql2+= " and ai.chu='"+chu+"'";
 	    	//sql2+= " and ai.chu='"+chu+"'";
 	    	//hql3+= " and ai.chu='"+chu+"'";
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
 	   String sql2 = "select ab.name,count(ab.name) from ("+hql+" ) as ab group by ab.name order by ab.name,ab.type,ab.chu,ab.status";
 	    //sql2+= " order by ai.name,ai.type,ai.chu,ai.status";
 	   String sql3 = "select ab.name, ab.type,count(ab.type) from ("+hql+" ) as ab group by ab.type order by ab.name,ab.type,ab.chu,ab.status";
 	   String sql4 = "select ab.name,ab.chu,count(ab.chu) from ("+hql+" ) as ab group by ab.name,ab.type,ab.chu order by ab.name,ab.type,ab.chu,ab.status";
		query = session.createSQLQuery(hql);
		list=query.list();
		query = session.createSQLQuery(sql2);
		list1=query.list();
		//query = session.createSQLQuery(sql2);
		//list1=query.list();
		query = session.createSQLQuery(sql3);
		list2=query.list();
		query = session.createSQLQuery(sql4);
		list3=query.list();
		//Iterator itor = list.iterator();
		Iterator itor1 = list1.iterator();
		//Iterator itor2 = list2.iterator();
		//Iterator itor3 = list3.iterator();
		
		listsingleshow =new ArrayList<AssetInfoShowBean>();
		Iterator itorsingle = list.iterator();
		while(itorsingle.hasNext())
		{	
			Object[] objectsingle = (Object[])itorsingle.next();
			AssetInfoShowBean as = new AssetInfoShowBean();
			as.setName(objectsingle[0].toString());
			as.setType(objectsingle[1].toString());
			as.setChu((Integer)objectsingle[2]);
			as.setStatus((Integer)objectsingle[3]);
			as.setNum(objectsingle[4].toString());	
			listsingleshow.add(as);		
		}
		listshow =new ArrayList<AssetInfoShowNewBean>();
		while(itor1.hasNext())
		{	
			Object[] object = (Object[])itor1.next();
			List<TypeAndNum> listtype = new ArrayList<TypeAndNum>();
			List<ChuAndNum> listchu = new ArrayList<ChuAndNum>();
			List<Integer> liststatus = new ArrayList<Integer>();
			List<Integer> listnum = new ArrayList<Integer>();
			List<SearchInfoBean>listinfo = new ArrayList<SearchInfoBean>();
			AssetInfoShowNewBean as = new AssetInfoShowNewBean();
			as.setName(object[0].toString());
			as.setNamenum(Integer.parseInt(object[1].toString()));
			Iterator itor = list.iterator();
			Iterator itor2 = list2.iterator();
			Iterator itor3 = list3.iterator();
			while(itor2.hasNext())
			{
				Object[] object1 = (Object[])itor2.next();
				if(object1[0].toString().equals(object[0].toString()))
				{
				    TypeAndNum tn = new TypeAndNum();
				    tn.setType(object1[1].toString());
				    tn.setTypenum(Integer.parseInt(object1[2].toString()));
				    listtype.add(tn);
					//listtype.add(object1[1].toString());
					//listtypenum.add(Integer.parseInt(object1[2].toString()));
			
				    
				}
			}
			
			while(itor3.hasNext())
			{
				Object[] object2 = (Object[])itor3.next();
				if(object2[0].toString().equals(object[0].toString()))
				{
					ChuAndNum cn = new ChuAndNum();				
				    cn.setChu(Integer.parseInt(object2[1].toString()));
				    cn.setChunum(Integer.parseInt(object2[2].toString()));
				    listchu.add(cn);
					//listtype.add(object1[1].toString());
					//listtypenum.add(Integer.parseInt(object1[2].toString()));
			
				    
				}
			}
			
			while(itor.hasNext())
			{
				Object[] object3 = (Object[])itor.next();
				if(object3[0].toString().equals(object[0].toString()))
				{
				   
					SearchInfoBean sb = new SearchInfoBean();
					sb.setName(object3[0].toString() );
					sb.setType(object3[1].toString() );
					sb.setChu(Integer.parseInt(object3[2].toString()) );
					sb.setStatus(Integer.parseInt(object3[3].toString()) );
					listinfo.add(sb);
				    liststatus.add(Integer.parseInt(object3[3].toString()));
				    listnum.add(Integer.parseInt(object3[4].toString()) );
					//listtype.add(object1[1].toString());
					//listtypenum.add(Integer.parseInt(object1[2].toString()));
			
				    
				}
			}
			as.setType(listtype);
	        as.setStatus(liststatus);
	        as.setNum(listnum);
	        as.setChu(listchu);
	        as.setSearchinfo(listinfo);
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
	    Array = JSONArray.fromObject(listshow);
	    ss = Array.toString();
	    System.out.println(ss);
	    
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
