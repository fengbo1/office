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
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class ShowZcBorrowPage {
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
 	    Query query;
		String hql = "";
 	    hql = "select distinct(ai.name) from AssetInfo as ai where ai.status='"+1+"'order by ai.id";
		query = session.createQuery(hql);
		listinfo= query.list();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    GetProcessByPosition gpbp = new GetProcessByPosition();
 	    ProcessDAO pdao = new ProcessDAO();
 	    int process = 0;
 	    ui = uidao.findByNewNumber(newnumber);
 	    position = ui.getPosition();
 	    String thisunder = "";
 	    process = gpbp.getZcjyProcess(position);
 	    Process p = pdao.findByItemAndApplicant("ZCJY", process);
 	    if(p!=null)
	    {
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	list = uidao.findByAuthorityAndPosition(thisunder, position);
	    }
 	    chu = Integer.parseInt(position.substring(2,3));
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}


}
