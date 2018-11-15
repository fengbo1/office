package office.pb.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.ScpbTeam;

public class StToModify {

	private int a;
	private int b;
	private int c;
	private int no;
	private int id;
	private String[] leader;
	private String unpaiban;
	private String[] member;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getLeader() {
		return leader;
	}
	public void setLeader(String[] leader) {
		this.leader = leader;
	}
	public String[] getMember() {
		return member;
	}
	public void setMember(String[] member) {
		this.member = member;
	}
	public String getUnpaiban() {
		return unpaiban;
	}
	public void setUnpaiban(String unpaiban) {
		this.unpaiban = unpaiban;
	}
	public String execute() throws Exception
	{
		unpaiban = new String(unpaiban.getBytes("ISO8859-1"),"UTF-8");
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		ScpbTeamDAO stdao = new ScpbTeamDAO();
    		String sql = "select max(num) from t_scpb_team";
    		int maxnum = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
    		List<ScpbTeam> list = stdao.findAllOrderByNo(maxnum);
    		ScpbTeam st = stdao.findAllByID(id);
    		List<Integer> listintbig = new ArrayList<Integer>();
    		List<Integer> listintsmall = new ArrayList<Integer>();
    		int size = list.size()+3;
    		for(int i=0;i<size;i++)
    		{
    			listintbig.add(i+1);
    		}
    		for(int i=0;i<list.size();i++)
    		{
    			listintsmall.add(list.get(i).getNo());
    		}
    		listintbig.removeAll(listintsmall);
    		a = listintbig.get(0);
    		b = listintbig.get(1);
    		c = listintbig.get(2);
    		id = st.getId();
    		leader=st.getLeader().split("、");
    		member = st.getMember().split("、");
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
