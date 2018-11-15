package office.wcgg.action;

import java.util.List;

import office.util.DateUtil;
import office.wcgg.dao.WcggBaodaoDAO;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggBaodao;
import office.wcgg.pojo.WcggPage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class WcggBaodaoAction {

	public String number;
	private String newnumber;
	private int RadioGroup1;
	private String baodaodate;
	private String message;
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
	public int getRadioGroup1() {
		return RadioGroup1;
	}
	public void setRadioGroup1(int radioGroup1) {
		RadioGroup1 = radioGroup1;
	}
	public String getBaodaodate() {
		return baodaodate;
	}
	public void setBaodaodate(String baodaodate) {
		this.baodaodate = baodaodate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		String result = "success";
		double sumday=0.0;
		message="报到成功";
		WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
		DateUtil du = new DateUtil();
		WcggPageDAO wpdao = new WcggPageDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    if(baodaodate==null||baodaodate.equals(""))
 	    {
 	    	message="失败！请选择报道日期";
 	    	result = "failed";
 	    }
 	    else
 	    {
 	    	WcggPage wp = wpdao.findAllByNumber(number);
 	    	int wphalf = wp.getHalfday();
 	    	WcggBaodao wb = wbdao.findAllByNumberAndNewnumber(number, newnumber);
 	 	    List<WcggBaodao> list = wbdao.findAllByStatusAndNumber(1, number);
 	 	    sumday = du.countSumdayForWCGG(session, wb.getBegindate(),baodaodate.replace("-",""), wb.getBghalfday(), RadioGroup1);
 	 	    wb.setStatus(2);
 	 	    wb.setBaodaodate(baodaodate.replace("-",""));
 	 	    wb.setBdhalfday(RadioGroup1);
 	 	    wb.setSumday(sumday);
 	 	    wbdao.merge(wb);
 	 	    if(list.size()==1)
 		    {
 		    	
 		    	wp.setStatus(4);
 		    	wp.setThisunder(null);
 		    	
 		    }
 	 	  wpdao.merge(wp);//报道完毕，更新审批表状态
 	    }
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		
		return result;
	}
}
