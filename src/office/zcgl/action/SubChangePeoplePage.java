package office.zcgl.action;

import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class SubChangePeoplePage {
private String number;
	
	//private int count=0;	
    private String people;
	private String name;
	private String type;
	private int status;
	private int chu;
	
	
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	//private UserInfo ui;
	public String execute() throws Exception
	{
		AssetInfoDAO aidao = new AssetInfoDAO();
		
		//UserInfoDAO uidao = new UserInfoDAO();
	
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	 
 	    AssetInfo assetinfo = aidao.findAllByNumber(number);
 	    assetinfo.setPeople(people);
 	    aidao.merge(assetinfo);
 	 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
