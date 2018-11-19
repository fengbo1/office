package office.zcgl.action;
import java.util.List;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.process.pojo.Process;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
public class ShowZcReturnPage {
	private String newnumber;
	private List<UserInfo> list;
	private UserInfo ui;
	private Integer chu;
	private String position;
	private List<String> listinfo;
	
	
	public List<String> getListinfo() {
		return listinfo;
	}


	public void setListinfo(List<String> listinfo) {
		this.listinfo = listinfo;
	}


	public List<UserInfo> getList() {
		return list;
	}


	public void setList(List<UserInfo> list) {
		this.list = list;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public Integer getChu() {
		return chu;
	}


	public void setChu(Integer chu) {
		this.chu = chu;
	}

	public UserInfo getUi() {
		return ui;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public void setUi(UserInfo ui) {
		this.ui = ui;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    ui = uidao.findByNewNumber(newnumber);
	    position = ui.getPosition();
	    chu = Integer.parseInt(position.substring(2,3));
 	    Query query;
		String hql = "";
 	    hql = "select distinct(ai.name) from AssetInfo as ai where ai.chu='"+chu+"'and ai.status in (2,3) order by ai.id";
		query = session.createQuery(hql);
		listinfo= query.list();
 	 
 	    GetProcessByPosition gpbp = new GetProcessByPosition();
 	    ProcessDAO pdao = new ProcessDAO();
 	    int process = 0;
 	   
 	    String thisunder = "";
 	    process = gpbp.getZcghProcess(position);
 	    Process p = pdao.findByItemAndApplicant("ZCGH", process);
 	    if(p!=null)
	    {
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	list = uidao.findByAuthorityAndPosition(thisunder, position);
	    }
 	    
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
