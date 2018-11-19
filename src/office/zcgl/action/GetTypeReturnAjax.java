package office.zcgl.action;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
public class GetTypeReturnAjax {
	private String assetname;
	private String newnumber;
	private List<String> listtype;
	private String typename="";
	private String nowtime;
	
	
	
	public String getNowtime() {
		return nowtime;
	}

	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getAssetname() {
		return assetname;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
 
	public List<String> getListtype() {
		return listtype;
	}


	public void setListtype(List<String> listtype) {
		this.listtype = listtype;
	}

	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    Query query;
 	    //System.out.println("111111");
 	    assetname=new String(assetname.getBytes("ISO8859-1"),"UTF-8");
 	    UserInfo ui = new UserInfo();
 	    UserInfoDAO uidao =new UserInfoDAO();
 	    ui=uidao.findByNewNumber(newnumber);
 	    String position = ui.getPosition();
 	    String chu = position.substring(2,3);
 	    int chuint = Integer.parseInt(chu);
		String hql = "";
 	    hql = "select distinct(ai.type) from AssetInfo as ai where ai.name='"+assetname+"'and ai.chu='"+chuint+"'and ai.status in (2,3) order by ai.id";
		query = session.createQuery(hql);
		listtype= query.list();
		for(int i=0;i<listtype.size();i++)
		{
			String name = listtype.get(listtype.size()-i-1);
			typename = name+"|"+typename;
		}
		 if(typename.length()>0)
		 {
			 typename=typename.substring(0,typename.length()-1);
		 }     
			
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
