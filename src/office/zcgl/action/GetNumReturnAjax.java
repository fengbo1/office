package office.zcgl.action;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.pojo.AssetInfoShowBean;
import ccb.hibernate.HibernateSessionFactory;
public class GetNumReturnAjax {
	private String assettype;
	private String assetname;
	private String newnumber;
	private String nowtime;
	private List<AssetTemp> listlznum;
	private List<AssetInfo> listnum;
    private int num=0;
 





	public String getNowtime() {
		return nowtime;
	}


	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}


	public List<AssetTemp> getListlznum() {
		return listlznum;
	}


	public void setListlznum(List<AssetTemp> listlznum) {
		this.listlznum = listlznum;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public String getAssettype() {
		return assettype;
	}


	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}


	public String getAssetname() {
		return assetname;
	}


	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}


	public List<AssetInfo> getListnum() {
		return listnum;
	}


	public void setListnum(List<AssetInfo> listnum) {
		this.listnum = listnum;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    Query query;
 	    Query querynum;
 	    int bora=0;
 	    assetname=new String(assetname.getBytes("ISO8859-1"),"UTF-8");
 	    assettype=new String(assettype.getBytes("ISO8859-1"),"UTF-8");
 	    if(assettype.equals("升腾DI945-2B(X2) 17寸普屏"))
	    {
	    	assettype="升腾DI945-2B(X2)+17寸普屏";
	    }
 	    UserInfo ui = new UserInfo();
	    UserInfoDAO uidao =new UserInfoDAO();
	    ui=uidao.findByNewNumber(newnumber);
	    String position = ui.getPosition();
	    String chu = position.substring(2,3);
	    int chuint = Integer.parseInt(chu);
		String hql = "";
		String hql1 = "";
 	    hql = "from AssetInfo as ai where ai.type='"+assettype+"' and ai.name='"+assetname+"'and ai.chu='"+chuint+"'and ai.status='"+2+"'order by ai.id";
		hql1 = "select b from AssetReturn a,AssetTemp b where a.number=b.number and a.chu='"+chuint+"'and a.status in(1,2,14) and b.type='"+assettype+"' and b.name='"+assetname+"'order by a.id";
 	    query = session.createQuery(hql);
 	    querynum = session.createQuery(hql1);
		listnum= query.list();
		listlznum= querynum.list();
		//Iterator itor = listlznum.iterator();
		num=listnum.size();
		int sum=0;
	
		for(int i=0;i<listlznum.size();i++)
		{
		    AssetTemp ap=listlznum.get(i);
			//String tempnum=listlznum.get(i);
			
			sum=sum+ap.getNum();
			//String a = tempnum;
			//num=num-Integer.parseInt(tempnum);
		}
		num=num-sum;
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
