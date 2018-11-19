package office.zcgl.action;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class GetNameSearchAjax {
	private String assetchu;
	private List<String> listname;
	private String assetname="";
	private String nowtime;
	
	
	public String getNowtime() {
		return nowtime;
	}


	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}


	public String getAssetchu() {
		return assetchu;
	}


	public void setAssetchu(String assetchu) {
		this.assetchu = assetchu;
	}


	public List<String> getListname() {
		return listname;
	}


	public void setListname(List<String> listname) {
		this.listname = listname;
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
		if(assetchu.equals("0"))
		{
			 hql = "select distinct(ai.name) from AssetInfo as ai order by ai.id";
		}
		else
		{
			 hql = "select distinct(ai.name) from AssetInfo as ai where ai.chu='"+assetchu+"' order by ai.id";
		}
 	  
		query = session.createQuery(hql);
		listname= query.list();
		for(int i=0;i<listname.size();i++)
		{
			String name = listname.get(listname.size()-i-1);
			assetname = name+"|"+assetname;
		}
		 if(assetname.length()>0)
		 {
			assetname = assetname.substring(0,assetname.length()-1);
		 }     
			
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
