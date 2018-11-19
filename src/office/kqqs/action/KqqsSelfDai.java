package office.kqqs.action;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.UserUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class KqqsSelfDai {

	private String name;
	private String newnumber;
	private String chu;
	private String bossname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String getBossname() {
		return bossname;
	}
	public void setBossname(String bossname) {
		this.bossname = bossname;
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		name=new String(name.getBytes("ISO8859-1"),"UTF-8");
		String result = "success";
		String thisunder = "";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    GetProcessByPosition gpbp = new GetProcessByPosition();
	 	ProcessDAO pdao = new ProcessDAO();
	 	int process = 0;
 	    UserInfo ui = uidao.findByName(name);
 	    if(ui==null)
 	    {
 	    	chu = "无";
 	    }
 	    else
 	    {
 	    	chu = UserUtil.positionToName(ui.getPosition());
 	    	process = gpbp.getKqqsProcess(ui.getPosition());
 	    	Process p = pdao.findByItemAndApplicant("WCGG", process);
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	bossname = uidao.findBoss(thisunder, ui.getPosition());
 	    }
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
}
