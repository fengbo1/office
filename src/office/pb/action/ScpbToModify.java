package office.pb.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.pb.dao.ScpbPlanDAO;
import office.pb.pojo.ScpbPlan;

public class ScpbToModify {

	private int a;
	private int b;
	private int c;
	private int id;
	private int no;
	private int type;
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
	private String zy31;
	private String zy32;
	private String zy33;
	private String zy34;
	private String zy41;
	private String zy42;
	private String zy43;
	private String zy44;
	private String px11;
	private String px12;
	private String px13;
	private String px14;
	private String px21;
	private String px22;
	private String px23;
	private String px24;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public String getZy31() {
		return zy31;
	}
	public void setZy31(String zy31) {
		this.zy31 = zy31;
	}
	public String getZy32() {
		return zy32;
	}
	public void setZy32(String zy32) {
		this.zy32 = zy32;
	}
	public String getZy33() {
		return zy33;
	}
	public void setZy33(String zy33) {
		this.zy33 = zy33;
	}
	public String getZy34() {
		return zy34;
	}
	public void setZy34(String zy34) {
		this.zy34 = zy34;
	}
	public String getZy41() {
		return zy41;
	}
	public void setZy41(String zy41) {
		this.zy41 = zy41;
	}
	public String getZy42() {
		return zy42;
	}
	public void setZy42(String zy42) {
		this.zy42 = zy42;
	}
	public String getZy43() {
		return zy43;
	}
	public void setZy43(String zy43) {
		this.zy43 = zy43;
	}
	public String getZy44() {
		return zy44;
	}
	public void setZy44(String zy44) {
		this.zy44 = zy44;
	}
	public String getPx11() {
		return px11;
	}
	public void setPx11(String px11) {
		this.px11 = px11;
	}
	public String getPx12() {
		return px12;
	}
	public void setPx12(String px12) {
		this.px12 = px12;
	}
	public String getPx13() {
		return px13;
	}
	public void setPx13(String px13) {
		this.px13 = px13;
	}
	public String getPx14() {
		return px14;
	}
	public void setPx14(String px14) {
		this.px14 = px14;
	}
	public String getPx21() {
		return px21;
	}
	public void setPx21(String px21) {
		this.px21 = px21;
	}
	public String getPx22() {
		return px22;
	}
	public void setPx22(String px22) {
		this.px22 = px22;
	}
	public String getPx23() {
		return px23;
	}
	public void setPx23(String px23) {
		this.px23 = px23;
	}
	public String getPx24() {
		return px24;
	}
	public void setPx24(String px24) {
		this.px24 = px24;
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
    		ScpbPlanDAO spdao = new ScpbPlanDAO();
    		ScpbPlan sp = spdao.findAllByID(id);
    		String sql = "select max(num) from t_scpb_plan";
    		int maxnum = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
    		List<ScpbPlan> list = spdao.findAllOrderByNo(maxnum);
    		List<Integer> listintbig = new ArrayList<Integer>();
    		List<Integer> listintsmall = new ArrayList<Integer>();
    		int size = list.size()+3;
    		id = sp.getId();
    		if(sp.getType()!=null)
    			type = sp.getType();
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
    		sb1 = sp.getSbtime().split(":")[0];
    		sb2 = sp.getSbtime().split(":")[1];
    		xb1 = sp.getXbtime().split(":")[0];
    		xb2 = sp.getXbtime().split(":")[1];
    		String[] zy = sp.getZytime().split(" ");
    		if(zy.length>0&&!zy[0].equals(""))
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
    		if(zy.length>2)
    		{
    			String zy3 = zy[2];
    			zy31 = zy3.split("-")[0].split(":")[0];
    			zy32 = zy3.split("-")[0].split(":")[1];
    			zy33 = zy3.split("-")[1].split(":")[0];
    			zy34 = zy3.split("-")[1].split(":")[1];
    		}
    		if(zy.length>3)
    		{
    			String zy4 = zy[3];
    			zy41 = zy4.split("-")[0].split(":")[0];
    			zy42 = zy4.split("-")[0].split(":")[1];
    			zy43 = zy4.split("-")[1].split(":")[0];
    			zy44 = zy4.split("-")[1].split(":")[1];
    		}
    		String[] px = sp.getPxtime().split(" ");
    		if(px.length>0&&!px[0].equals(""))
    		{
    			String px1 = px[0];
    			px11 = px1.split("-")[0].split(":")[0];
    			px12 = px1.split("-")[0].split(":")[1];
    			px13 = px1.split("-")[1].split(":")[0];
    			px14 = px1.split("-")[1].split(":")[1];
    		}
    		if(px.length>1)
    		{
    			String px2 = px[1];
    			px21 = px2.split("-")[0].split(":")[0];
    			px22 = px2.split("-")[0].split(":")[1];
    			px23 = px2.split("-")[1].split(":")[0];
    			px24 = px2.split("-")[1].split(":")[1];
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
