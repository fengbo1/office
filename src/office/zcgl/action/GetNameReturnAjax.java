package office.zcgl.action;

import java.util.List;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class GetNameReturnAjax {
	private int chu;
	private String newnumber;
	private List<String> listname;
	private String namelist="";
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

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}

	public List<String> getListname() {
		return listname;
	}

	public void setListname(List<String> listname) {
		this.listname = listname;
	}

	public String getNamelist() {
		return namelist;
	}

	public void setNamelist(String namelist) {
		this.namelist = namelist;
	}

	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    Query query;
 	    //System.out.println("111111");
 	  
 	    UserInfo ui = new UserInfo();
 	    UserInfoDAO uidao =new UserInfoDAO();
 	    ui=uidao.findByNewNumber(newnumber);
 	  
		String hql = "";
 	    hql = "select distinct(ai.name) from AssetInfo as ai where ai.chu='"+chu+"'and ai.status in (2,3) order by ai.id";
		query = session.createQuery(hql);
		listname= query.list();
		for(int i=0;i<listname.size();i++)
		{
			String name = listname.get(listname.size()-i-1);
			namelist = name+"|"+namelist;
		}
		 if(namelist.length()>0)
		 {
			 namelist=namelist.substring(0,namelist.length()-1);
		 }     
			
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
