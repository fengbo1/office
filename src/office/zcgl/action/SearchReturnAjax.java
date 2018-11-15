package office.zcgl.action;

import java.util.List;
import net.sf.json.JSONArray;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.AssetReturn;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class SearchReturnAjax {
	private String assettype;
	private String assetname;
	private String people;
    private int chu;
    private List<AssetInfo> listaf;
    private JSONArray Array;
    private String newnumber;
    private String ss;
    
    
    


	public String getSs() {
		return ss;
	}


	public void setSs(String ss) {
		this.ss = ss;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public JSONArray getArray() {
		return Array;
	}


	public void setArray(JSONArray array) {
		Array = array;
	}


	public List<AssetInfo> getListaf() {
		return listaf;
	}


	public void setListaf(List<AssetInfo> listaf) {
		this.listaf = listaf;
	}


	public int getChu() {
		return chu;
	}


	public void setChu(int chu) {
		this.chu = chu;
	}


	public String getAssettype() {
		return assettype;
	}


	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}


	public String getPeople() {
		return people;
	}


	public void setPeople(String people) {
		this.people = people;
	}


	public String getAssetname() {
		return assetname;
	}


	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    UserInfo ui = uidao.findByNewNumber(newnumber);
 	   // chu = Integer.parseInt(ui.getPosition().substring(2, 3));
 	   
 	    Query query;
 	    Query query1;
 	    //System.out.println("111111");
		String hql = "";
		 assetname=new String(assetname.getBytes("ISO8859-1"),"UTF-8");
	 	 assettype=new String(assettype.getBytes("ISO8859-1"),"UTF-8");
	 	 if(assettype.equals("升腾DI945-2B(X2) 17寸普屏"))
		 {
		    	assettype="升腾DI945-2B(X2)+17寸普屏";
		 }
	 	
	 
	 	if(people==null||people.equals(""))
			 {
				  if(assetname.equals("wu"))
				    {
				    	hql = "from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' order by ai.id";
				    }
				  else if ((!assetname.equals("wu"))&&(assettype.equals("wu")))
				    {
				    	hql = "from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.name='"+assetname+"' order by ai.id";
				    }
				  else if ((!assetname.equals("wu"))&&(!assettype.equals("wu")))
				  {
					  hql = "from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.name='"+assetname+"' and ai.type='"+assettype+"' order by ai.id";
				  }
				
			}
			else
			{
				people=new String(people.getBytes("ISO8859-1"),"UTF-8");
				String searchname = people.replace("、", "','");
			    
				if(assetname.equals("wu"))
				    {
				       
				    	 hql = "from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.people in ('"+searchname+"') order by ai.id";
					  
				    }
				  else if ((!assetname.equals("wu"))&&(assettype.equals("wu")))
				    {
				    	 hql = "from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.name='"+assetname+"' and ai.people in ('"+searchname+"') order by ai.id";
				    }
				  else if ((!assetname.equals("wu"))&&(!assettype.equals("wu")))
				  {
					     hql = "from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.name='"+assetname+"' and ai.type='"+assettype+"' and ai.people in ('"+searchname+"') order by ai.id";
				  }
			}
	 	
	 	
	 	String hql1 = "from AssetReturn as ar where ar.status in(1,2,5,18) ";
	 	query1 = session.createQuery(hql1);
		List<AssetReturn>listar= query1.list();
		query = session.createQuery(hql);
		listaf= query.list();
		for(int i=0;i<listar.size();i++)
		{
			String ids[]=listar.get(i).getAssetid().split("、");
			for(int j=0;j<ids.length;j++)
			{
			   for(int k=0;k<listaf.size();k++)
			   {
				   int returnid = Integer.parseInt(ids[j]);
				   if(returnid == listaf.get(k).getId())
				   {
					   listaf.remove(k);
				   }
			   }
			}
		}
		Array = JSONArray.fromObject(listaf);
	    ss = Array.toString();
		System.out.println(ss);
		trans.commit();	
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
