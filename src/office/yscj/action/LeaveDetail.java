package office.yscj.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveProcessDAO;
import office.leave.dao.LeaveSummaryDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.leave.pojo.LeaveSummary;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;
import office.yscj.dao.TYscjDAO;
import office.yscj.pojo.TYscj;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
/**
 * 本人申请-流转中-查看详情
 * @author htzx
 *
 */
public class LeaveDetail {

	private String number;//请假单编号
	private List<LeavePage> list;
	
	public List<LeavePage> getList() {
		return list;
	}
	public void setList(List<LeavePage> list) {
		this.list = list;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String execute() throws Exception
	{
		LeavePageDAO lpdao = new LeavePageDAO();
		LeavePage lp = new LeavePage ();
		TYscjDAO tydao = new TYscjDAO();
		TYscj ty = new TYscj();
		list = new LinkedList();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    ty = tydao.findAllByNumber(number);
 	    try {
 	       String [] temp = ty.getLeavepagenumber().split("、");
 		   for(int i=0;i<temp.length;i++)
 		   {
 			   lp = lpdao.findByNumber(temp[i]);
 			   list.add(lp);
 		   }
 			
 	   } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
 	    
 	    
		return "success";
	}
}
