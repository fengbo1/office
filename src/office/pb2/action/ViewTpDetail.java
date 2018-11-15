package office.pb2.action;

import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.userinfo.dao.UserInfoDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewTpDetail {

	private String number;
	private String newnumber;
	private List<LeaveProcess> listlp;
	private TbsqPage tp;
	private String tbdate;
	private int dai;
	
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
		
		TbsqPageDAO tpdao = new TbsqPageDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    tp = tpdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number);
 	    dai = Integer.parseInt(number.substring(12, 13));//20160711KQQS00001
 	    String d = tp.getTbdate();
 	    tbdate = d.substring(0, 4)+"年"+d.substring(4, 6)+"月"+d.substring(6, 8)+"日";
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
