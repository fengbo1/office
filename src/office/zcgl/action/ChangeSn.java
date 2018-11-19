package office.zcgl.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;

public class ChangeSn {
	private String number;
	private String name;
	private String type;
	private int status;
	private int chu;
	//private int count=0;	
    private AssetInfo assetinfo;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getChu() {
		return chu;
	}
	public void setChu(int chu) {
		this.chu = chu;
	}
	public AssetInfo getAssetinfo() {
		return assetinfo;
	}
	public void setAssetinfo(AssetInfo assetinfo) {
		this.assetinfo = assetinfo;
	}
    
	public String execute() throws Exception
	{
		AssetInfoDAO aidao = new AssetInfoDAO();
		name=new String(name.getBytes("ISO8859-1"),"UTF-8");
    	type=new String(type.getBytes("ISO8859-1"),"UTF-8");
    	if(type.equals("升腾DI945-2B(X2) 17寸普屏"))
		 {
		    	type="升腾DI945-2B(X2)+17寸普屏";
		 }
		//UserInfoDAO uidao = new UserInfoDAO();
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    assetinfo = aidao.findAllByNumber(number);
 	   
 	 
 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
