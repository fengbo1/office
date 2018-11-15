package office.kqqs.action;

import java.util.ArrayList;
import java.util.List;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowKqqsPage {

	private String newnumber;
	private List<UserInfo> list;
	private List<Integer> l;
	private UserInfo ui;
	private Integer chu;
	private String position;
	private String nonext="you";
	private String type;//是否代发起
	

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


	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public List<Integer> getL() {
		return l;
	}


	public void setL(List<Integer> l) {
		this.l = l;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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
 	    process = gpbp.getKqqsProcess(position);
 	    //process = 3;//20160414修改，考勤缺失全到惠总
 	    Process p = pdao.findByItemAndApplicant("KQQS", process);
 	    if(p!=null)
	    {
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	list = uidao.findByAuthorityAndPosition(thisunder, position);
	    }
 	    chu = Integer.parseInt(position.substring(2,3));
 	    l=new ArrayList<Integer>();
 	    for(int i=0;i<100;i++)
 	    {
 	    	l.add(i);
 	    }
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		if(list==null||list.isEmpty())
		{
			nonext = "wu";
		}
		if(type==null||type.equals(""))
		{
			return "success";
		}
		else
		{
			return "df";
		}
		
	}
}
