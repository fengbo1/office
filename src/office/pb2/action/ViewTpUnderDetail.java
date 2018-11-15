package office.pb2.action;

import java.util.ArrayList;
import java.util.List;

import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewTpUnderDetail {

	private String number;
	private String newnumber;
	private String username;
	private List<LeaveProcess> listlp;
	private TbsqPage tp;
	private int dai;
	private String tbdate;
	private String nextunder;
	private List<UserInfo> listui;
	
	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}


	public List<LeaveProcess> getListlp() {
		return listlp;
	}


	public void setListlp(List<LeaveProcess> listlp) {
		this.listlp = listlp;
	}

	public int getDai() {
		return dai;
	}


	public void setDai(int dai) {
		this.dai = dai;
	}


	public String getNextunder() {
		return nextunder;
	}


	public void setNextunder(String nextunder) {
		this.nextunder = nextunder;
	}

	public List<UserInfo> getListui() {
		return listui;
	}


	public void setListui(List<UserInfo> listui) {
		this.listui = listui;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TbsqPage getTp() {
		return tp;
	}


	public void setTp(TbsqPage tp) {
		this.tp = tp;
	}


	public String getTbdate() {
		return tbdate;
	}


	public void setTbdate(String tbdate) {
		this.tbdate = tbdate;
	}


	public String execute() throws Exception
	{ 
		LeavePageDAO lpd=new LeavePageDAO();
		TbsqPageDAO tpdao = new TbsqPageDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    listui = new ArrayList<UserInfo>();
 	    tp = tpdao.findAllByNumber(number);
 	    UserInfo uiapl = uidao.findByNewNumber(tp.getApplicant());
 	    UserInfo uitbn = uidao.findByName(tp.getTbname());
 	    UserInfo uiviewer = uidao.findByNewNumber(newnumber);
 	    username = uiviewer.getUsername();
	    //if(uiapl.getPosition())
 	   if(uiviewer.getAuthority().contains("T"))//调班管理员审批
 	   {
   		nextunder = "no";
 	   }
 	   else if(tp.getStatus()==1)//第一个组长审批
	    {
 		   	UserInfo uifq = uidao.findByNewNumber(tp.getApplicant());//发起人名字
	    	UserInfo ui = uidao.findByName(tp.getTbname());//调班人名字
	    	if(uiapl.getPosition().substring(4, 5).equals(uitbn.getPosition().substring(4, 5)))//同一个组
	    	{
	    		listui = uidao.findByAuthorityAndPosition("T", "");
	    	}
	    	else
	    	{
	    		if(uifq.getAuthority().contains("D"))
	    		{
	    			listui = uidao.findByAuthorityAndPosition("T", "");
	    		}
	    		else
	    		{
	    			listui = uidao.findByAuthorityAndPosition("D", ui.getPosition());
	    		}
	    	}
	    }
	    else//第二个人审批
	    {
	    	listui = uidao.findByAuthorityAndPosition("T", "");
	    }
 	    listlp = lpdao.findAllByNumber(number);
 	    dai = Integer.parseInt(number.substring(12, 13));//20160711KQQS00001
		tbdate = tp.getTbdate().substring(0, 4)+"年"+tp.getTbdate().substring(4, 6)+"月"+tp.getTbdate().substring(6, 8)+"日";
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
