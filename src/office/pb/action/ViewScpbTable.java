package office.pb.action;

import java.util.ArrayList;
import java.util.List;

import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.bean.ScpbTableBean;
import office.pb.bean.ScpbTableHzBean;
import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.ScpbTableDAO;
import office.pb.dao.ScpbTableHzDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.ScpbTable;
import office.pb.pojo.ScpbTableHz;
import office.pb.pojo.ScpbTeam;
import office.util.PbUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ViewScpbTable {

	private List listsp;//生产排班
	private List<ScpbTeam> listst;
	//private List<ScpbTableBean> liststb;
	private List<ScpbTableHzBean> liststhb;
	private String month;
	private int size;
	public List<ScpbTeam> getListst() {
		return listst;
	}
	public void setListst(List<ScpbTeam> listst) {
		this.listst = listst;
	}
	public List<ScpbTableHzBean> getListsthb() {
		return liststhb;
	}
	public void setListsthb(List<ScpbTableHzBean> liststhb) {
		this.liststhb = liststhb;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List getListsp() {
		return listsp;
	}
	public void setListsp(List listsp) {
		this.listsp = listsp;
	}
	public String execute() throws Exception
	{
		String sql = "";
		int num=0;
		ScpbPlanDAO spdao = new ScpbPlanDAO();
		ScpbTableHzDAO sthdao = new ScpbTableHzDAO();
		MyCalendarDAO mcdao = new MyCalendarDAO();
		PbUtil pu = new PbUtil();
		//ScpbTeamDAO stdao = new ScpbTeamDAO();
//		ScpbTableDAO stabledao = new ScpbTableDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		listst = new ArrayList<ScpbTeam>();
    		liststhb = new ArrayList<ScpbTableHzBean>();
    		sql = "select max(num) from t_scpb_plan";
    		if(session.createSQLQuery(sql).uniqueResult()!=null)
    			num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
    		listsp = spdao.findAllOrderByNo(num);
    		if(!sthdao.findAll().isEmpty())
    		{
    			sql = "select max(date) from t_scpb_table_hz";
        		if(month==null)
        			month = session.createSQLQuery(sql).uniqueResult().toString().substring(0, 6);
        		size = sthdao.findMxTeamnoByMonth(month);
        		List<MyCalendar> listmc = mcdao.findByBeginAndEnd(month+"01", month+"31", 2);
        		for(int i=0;i<listmc.size();i++)
        		{
        			MyCalendar mc = listmc.get(i);
        			List<ScpbTableHz> liststh = sthdao.findAllByDate(mc.getDate());
        			ScpbTableHzBean sthb = pu.scpbTableHzToBean(liststh);
        			if(sthb!=null)
        			{
        				sthb.setDate(mc.getDate());
        				liststhb.add(sthb);
        			}
        		}
        		for(int i=0;i<size;i++)
        		{
        			listst.add(new ScpbTeam());
        		}
    		}
//    		listst = stdao.findAllBiggestTeam();
//    		size = listst.size();
//    		sql = "select max(month) from t_scpb_table";
//    		if(month==null)
//    			month = session.createSQLQuery(sql).uniqueResult().toString();
//    		liststable = stabledao.findAllByMonthOrderByBegin(month);
    	}catch (Exception e) {
			trans.rollback();//出错回滚
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
