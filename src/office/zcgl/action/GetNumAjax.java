package office.zcgl.action;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.AssetTemp;
import ccb.hibernate.HibernateSessionFactory;
public class GetNumAjax {
	private String assettype;
	private String assetname;
	private List<AssetInfo> listnum;
	private List<AssetTemp> listlznum1;
	private List<AssetTemp> listlznum2;
    private int num=0;
 
    private String nowtime;

   
	public List<AssetTemp> getListlznum1() {
		return listlznum1;
	}


	public void setListlznum1(List<AssetTemp> listlznum1) {
		this.listlznum1 = listlznum1;
	}


	public List<AssetTemp> getListlznum2() {
		return listlznum2;
	}


	public void setListlznum2(List<AssetTemp> listlznum2) {
		this.listlznum2 = listlznum2;
	}


	public String getNowtime() {
		return nowtime;
	}


	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
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
 	    Query query1;
 	    Query query2;
 	    assetname=new String(assetname.getBytes("ISO8859-1"),"UTF-8");
 	    assettype=new String(assettype.getBytes("ISO8859-1"),"UTF-8");
 	    if(assettype.equals("升腾DI945-2B(X2) 17寸普屏"))
	    {
	    	assettype="升腾DI945-2B(X2)+17寸普屏";
	    }
		String hql = "";
		String hql1 = "";
		String hql2 = "";
 	    hql = "from AssetInfo as ai where ai.type='"+assettype+"' and  ai.name='"+assetname+"' and ai.status='"+1+"'order by ai.id";
 		hql1 = "select b from AssetApply a,AssetTemp b where a.number=b.number and a.status in(1,2,5,14) and b.type='"+assettype+"' and b.name='"+assetname+"'order by a.id";
 		hql2 = "select b from AssetBorrow a,AssetTemp b where a.number=b.number and a.status in(1,2,5,14) and b.type='"+assettype+"' and b.name='"+assetname+"'order by a.id";
 		query = session.createQuery(hql);
 		query1 = session.createQuery(hql1);
 		query2 = session.createQuery(hql2);
		listnum= query.list();
		listlznum1= query1.list();
		listlznum2= query2.list();
		
		num=listnum.size();
		int sum1=0;
		int sum2=0;
		
		for(int i=0;i<listlznum1.size();i++)
		{
		    AssetTemp ap=listlznum1.get(i);
			//String tempnum=listlznum.get(i);
			
			sum1=sum1+ap.getNum();
			//String a = tempnum;
			//num=num-Integer.parseInt(tempnum);
		}
		for(int i=0;i<listlznum2.size();i++)
		{
		    AssetTemp ap=listlznum2.get(i);
			//String tempnum=listlznum.get(i);
			
			sum2=sum2+ap.getNum();
			//String a = tempnum;
			//num=num-Integer.parseInt(tempnum);
		}
		num=num-(sum1+sum2);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
