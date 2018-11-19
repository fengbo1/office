package office.zcgl.action;

import java.util.ArrayList;
import java.util.List;
import office.zcgl.pojo.AssetInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class SearchReturn {
	private String assettype;
	private String assetname;
	private String people;
    private int chu;
    private List<AssetInfo> listaf;
    
    
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
 	    Query query;
 	    //System.out.println("111111");
		String hql = "";
		
		if(people==null||people.equals(""))
		{
			  if(assetname.equals("wu"))
			    {
			    	hql = "select * from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' order by ai.id";
			    }
			  else if ((!assetname.equals("wu"))&&(assettype.equals("wu")))
			    {
			    	hql = "select * from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.name='"+assetname+"' order by ai.id";
			    }
			  else if ((!assetname.equals("wu"))&&(!assettype.equals("wu")))
			  {
				  hql = "select * from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.name='"+assetname+"' and ai.type='"+assettype+"' order by ai.id";
			  }
			
		}
		else
		{
			
			String searchname = people.replace("、", "','");
		    
			if(assetname.equals("wu"))
			    {
			       
			    	 hql = "select * from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.people in ('"+searchname+"') order by ai.id";
				  
			    }
			  else if ((!assetname.equals("wu"))&&(assettype.equals("wu")))
			    {
			    	 hql = "select * from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.name='"+assetname+"' and ai.people in ('"+searchname+"') order by ai.id";
			    }
			  else if ((!assetname.equals("wu"))&&(!assettype.equals("wu")))
			  {
				     hql = "select * from AssetInfo as ai where ai.status in (2,3) and ai.chu='"+chu+"' and ai.name='"+assetname+"' and ai.type='"+assettype+"' and ai.people in ('"+searchname+"') order by ai.id";
			  }
		}
			  
		query = session.createQuery(hql);
		listaf= query.list();
		
			
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
