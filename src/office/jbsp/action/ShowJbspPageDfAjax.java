package office.jbsp.action;

import java.util.List;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.UserUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowJbspPageDfAjax {

	private String newnumber;
	private String name;
	private String chutuan;
	private String bossname;
	private String chuname;
	private String allname;

	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChutuan() {
		return chutuan;
	}
	public void setChutuan(String chutuan) {
		this.chutuan = chutuan;
	}
	public String getBossname() {
		return bossname;
	}
	public void setBossname(String bossname) {
		this.bossname = bossname;
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
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    name=new String(name.getBytes("ISO8859-1"),"UTF-8");
		UserInfo ui = uidao.findByName(name);
		UserInfo uifq = uidao.findByNewNumber(newnumber);
		if(ui==null)
		{
			result = "failededed";
		}
		else if(ifcandai(uifq.getAuthority(),uifq.getPosition(),ui.getPosition()))
		{
			String newnumbersq = ui.getNewnumber();
			
			chutuan = UserUtil.positionToName(ui.getPosition());
			
		 	GetProcessByPosition gpbp = new GetProcessByPosition();
		 	ProcessDAO pdao = new ProcessDAO();
		 	int process = 0;
		 	String position = ui.getPosition();
		 	String thisunder = "";
		 	process = gpbp.getJbspProcess(position);
		 	Process p = pdao.findByItemAndApplicant("JBSP", process);
		 	if(p!=null)
			{
		 	    thisunder = p.getProcess().substring(1, 2);//EDCA
		 	    bossname = uidao.findBoss(thisunder, position);
			 }
		 	
		 	List<UserInfo> listall = uidao.findAll();
		    List<UserInfo> listchu = uidao.findAllByPosition1("__"+position.substring(2, 3)+"__");
		    chuname="";
		    allname="";
		    for(int i=0;i<listall.size();i++)
		    {
		    	UserInfo u = listall.get(i);
		    	allname+=u.getUsername();
		    	allname+="、";
		    }
		    for(int i=0;i<listchu.size();i++)
		    {
		    	UserInfo u = listchu.get(i);
		    	chuname+=u.getUsername();
		    	chuname+="、";
		    }
		}
		else
		{
			result = "failed";
		}
		trans.commit();
        session.flush();
        session.clear();
        session.close();
		return result;
	}
	/**
	 * a是否能代b发起 返回true能。返回false不能
	 * @param positionfq
	 * @param positionsq
	 * @return
	 */
	public boolean ifcandai(String autho,String positionfq,String positionsq)
	{
		String zhifq = positionfq.substring(0, 1);
		String chufq = positionfq.substring(2, 3);
		String zhisq = positionsq.substring(0, 1);
		String chusq = positionsq.substring(2, 3);
		
		if(zhifq.equals("0")||zhifq.equals("1")||autho.contains("I"))//主任处长代所有人
		{
			return true;
		}
		else if(zhifq.equals("2")&&(chufq.equals(chusq)))//团队负责人代本处室
		{
			return true;
		}
		else if((zhifq.equals("3")||zhifq.equals("4"))&&(chufq.equals(chusq)))//普通员工代本处室&&!zhisq.equals("2")&&!zhisq.equals("1")
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
