package office.zcgl.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.zcgl.pojo.StorehouseData;
import office.zcgl.pojo.StorehouseTempBean;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowImportZcKfOutPage {
	private String newnumber;
    private int isshow;
    private UserInfo ui;
    private String rukunum;
    private List<StorehouseTempBean> listtemp;
    
    
	public String getRukunum() {
		return rukunum;
	}


	public void setRukunum(String rukunum) {
		this.rukunum = rukunum;
	}


	public List<StorehouseTempBean> getListtemp() {
		return listtemp;
	}


	public void setListtemp(List<StorehouseTempBean> listtemp) {
		this.listtemp = listtemp;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public int getIsshow() {
		return isshow;
	}


	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}


	public UserInfo getUi() {
		return ui;
	}


	public void setUi(UserInfo ui) {
		this.ui = ui;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    Query query;
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    List<StorehouseData> list;
 	    ui = uidao.findByNewNumber(newnumber);
		isshow=1;
		String sql="insert into storehouse_tempt (assetname,assettype,sn,num,rukunum) select assetname,assettype,sn,count(assetname),rukunum from storehouse_data where rukunum = '"+rukunum+"' group by assetname,assettype";
		session.createSQLQuery(sql).executeUpdate();
		String hql = "select assetname,assettype,rukunum,count(assetname) from StorehouseData where rukunum = '"+rukunum+"' group by assetname,assettype";
		query = session.createQuery(hql);
		list= query.list();
		Iterator itor = list.iterator();
		listtemp = new ArrayList<StorehouseTempBean>();
		
		while(itor.hasNext())
		{	
			Object[] object = (Object[])itor.next();
			StorehouseTempBean as = new StorehouseTempBean();
			as.setAssetname(object[0].toString());
			as.setAssettype(object[1].toString());
			as.setNum(Integer.parseInt(String.valueOf(object[3])));
			as.setRukunum(object[2].toString());
			listtemp.add(as);		
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
