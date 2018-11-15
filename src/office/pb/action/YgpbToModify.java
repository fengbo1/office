package office.pb.action;

import java.util.ArrayList;
import java.util.List;

import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.YgpbPlanDAO;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.YgpbPlan;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class YgpbToModify {
	private int a;
	private int b;
	private int c;
	private int id;
	private int no;
	private String sb1;
	private String sb2;
	private String xb1;
	private String xb2;
	private String zy11;
	private String zy12;
	private String zy13;
	private String zy14;
	private String zy21;
	private String zy22;
	private String zy23;
	private String zy24;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSb1() {
		return sb1;
	}
	public void setSb1(String sb1) {
		this.sb1 = sb1;
	}
	public String getSb2() {
		return sb2;
	}
	public void setSb2(String sb2) {
		this.sb2 = sb2;
	}
	public String getXb1() {
		return xb1;
	}
	public void setXb1(String xb1) {
		this.xb1 = xb1;
	}
	public String getXb2() {
		return xb2;
	}
	public void setXb2(String xb2) {
		this.xb2 = xb2;
	}
	public String getZy11() {
		return zy11;
	}
	public void setZy11(String zy11) {
		this.zy11 = zy11;
	}
	public String getZy12() {
		return zy12;
	}
	public void setZy12(String zy12) {
		this.zy12 = zy12;
	}
	public String getZy13() {
		return zy13;
	}
	public void setZy13(String zy13) {
		this.zy13 = zy13;
	}
	public String getZy14() {
		return zy14;
	}
	public void setZy14(String zy14) {
		this.zy14 = zy14;
	}
	public String getZy21() {
		return zy21;
	}
	public void setZy21(String zy21) {
		this.zy21 = zy21;
	}
	public String getZy22() {
		return zy22;
	}
	public void setZy22(String zy22) {
		this.zy22 = zy22;
	}
	public String getZy23() {
		return zy23;
	}
	public void setZy23(String zy23) {
		this.zy23 = zy23;
	}
	public String getZy24() {
		return zy24;
	}
	public void setZy24(String zy24) {
		this.zy24 = zy24;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		YgpbPlanDAO ygdao = new YgpbPlanDAO();
    		YgpbPlan yg = ygdao.findAllByNo(no);
    		List<YgpbPlan> list = ygdao.findAll();
    		List<Integer> listintbig = new ArrayList<Integer>();
    		List<Integer> listintsmall = new ArrayList<Integer>();
    		int size = list.size()+3;
    		id = yg.getId();
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
    		sb1 = yg.getSbtime().split(":")[0];
    		sb2 = yg.getSbtime().split(":")[1];
    		xb1 = yg.getXbtime().split(":")[0];
    		xb2 = yg.getXbtime().split(":")[1];
    		String[] zy = yg.getZytime().split(" ");
    		if(zy.length>0)
    		{
    			String zy1 = zy[0];
    			zy11 = zy1.split("-")[0].split(":")[0];
    			zy12 = zy1.split("-")[0].split(":")[1];
    			zy13 = zy1.split("-")[1].split(":")[0];
    			zy14 = zy1.split("-")[1].split(":")[1];
    		}
    		if(zy.length>1)
    		{
    			String zy2 = zy[1];
    			zy21 = zy2.split("-")[0].split(":")[0];
    			zy22 = zy2.split("-")[0].split(":")[1];
    			zy23 = zy2.split("-")[1].split(":")[0];
    			zy24 = zy2.split("-")[1].split(":")[1];
    		}
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
