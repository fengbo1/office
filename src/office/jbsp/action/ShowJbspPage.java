package office.jbsp.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

public class ShowJbspPage {

	private String newnumber;
	private List<UserInfo> list;
	private UserInfo ui;
	private Integer chu;
	private String position;
	private String chuname;
	private String allname;
	private String nonext="you";
	
	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public List<UserInfo> getList() {
		return list;
	}

	public void setList(List<UserInfo> list) {
		this.list = list;
	}

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public Integer getChu() {
		return chu;
	}

	public void setChu(Integer chu) {
		this.chu = chu;
	}

	public String getNonext() {
		return nonext;
	}

	public void setNonext(String nonext) {
		this.nonext = nonext;
	}
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getChuname() {
		return chuname;
	}

	public void setChuname(String chuname) {
		this.chuname = chuname;
	}

	public String getAllname() {
		return allname;
	}

	public void setAllname(String allname) {
		this.allname = allname;
	}

	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    GetProcessByPosition gpbp = new GetProcessByPosition();
 	    ProcessDAO pdao = new ProcessDAO();
 	    int process = 0;
 	    ui = uidao.findByNewNumber(newnumber);
 	    position = ui.getPosition();
 	    String thisunder = "";
 	    process = gpbp.getJbspProcess(position);
 	    Process p = pdao.findByItemAndApplicant("JBSP", process);
 	    if(p!=null)
 	    {
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	list = uidao.findByAuthorityAndPosition(thisunder, position);
 	    }
 	    chu = Integer.parseInt(position.substring(2,3));
 	    List<UserInfo> listall = uidao.findAll();
	    List<UserInfo> listchu = uidao.findAllByPosition1("__"+chu+"__");
	    chuname="";
	    allname="";
	    for(int i=0;i<listall.size();i++)
	    {
	    	UserInfo ui = listall.get(i);
	    	allname+=ui.getUsername();
	    	allname+="、";
	    }
	    for(int i=0;i<listchu.size();i++)
	    {
	    	UserInfo ui = listchu.get(i);
	    	chuname+=ui.getUsername();
	    	chuname+="、";
	    }
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		if(list==null||list.isEmpty())
		{
			nonext = "wu";
		}
		return "success";
	}
}
