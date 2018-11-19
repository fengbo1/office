package office.pb.action;

import office.pb.dao.PbLogDAO;
import office.pb.dao.ScpbPlanDAO;
import office.pb.pojo.PbLog;
import office.pb.pojo.ScpbPlan;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ScpbModify {

	private String message;
	private String name;
	private int no;
	private int yuanno;//修改前的no
	private int id;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getYuanno() {
		return yuanno;
	}
	public void setYuanno(int yuanno) {
		this.yuanno = yuanno;
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
	public String execute() throws Exception
	{
		if(ifshivalue(sb1)&&ifshivalue(xb1)&&iffenvalue(sb2)&&iffenvalue(xb2))
		{
			message = "修改成功";
			String sql = "";
			int num = 0;
			ScpbPlanDAO spdao = new ScpbPlanDAO();
			PbLogDAO pldao = new PbLogDAO();
			DateUtil du = new DateUtil();
			PbLog pl = new PbLog();
			String sbtime = std(sb1)+":"+std(sb2);
			String xbtime = std(xb1)+":"+std(xb2);
			String zytime = "";
			String pxtime = "";
			if(ifnotempty(zy11)&&ifnotempty(zy12)&&ifnotempty(zy13)&&ifnotempty(zy14))
			{
				zytime+= std(zy11)+":"+std(zy12)+"-"+std(zy13)+":"+std(zy14);
			}
			if(ifnotempty(zy21)&&ifnotempty(zy22)&&ifnotempty(zy23)&&ifnotempty(zy24))
			{
				zytime+= " "+std(zy21)+":"+std(zy22)+"-"+std(zy23)+":"+std(zy24);
			}
			if(ifnotempty(zy31)&&ifnotempty(zy32)&&ifnotempty(zy33)&&ifnotempty(zy34))
			{
				zytime+= " "+std(zy31)+":"+std(zy32)+"-"+std(zy33)+":"+std(zy34);
			}
			if(ifnotempty(zy41)&&ifnotempty(zy42)&&ifnotempty(zy43)&&ifnotempty(zy44))
			{
				zytime+= " "+std(zy41)+":"+std(zy42)+"-"+std(zy43)+":"+std(zy44);
			}
			if(ifnotempty(px11)&&ifnotempty(px12)&&ifnotempty(px13)&&ifnotempty(px14))
			{
				pxtime+= std(px11)+":"+std(px12)+"-"+std(px13)+":"+std(px14);
			}
			if(ifnotempty(px21)&&ifnotempty(px22)&&ifnotempty(px23)&&ifnotempty(px24))
			{
				pxtime+= " "+std(px21)+":"+std(px22)+"-"+std(px23)+":"+std(px24);
			}
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	try {
	    		sql = "select max(num) from t_scpb_plan";
	    		if(session.createSQLQuery(sql).uniqueResult()!=null)
	    			num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
	    		sql = "insert into t_scpb_plan(no,num,sbtime,xbtime,zytime,pxtime,type) select no,num+1,sbtime,xbtime,zytime,pxtime,type from t_scpb_plan where num="+num;
	    		session.createSQLQuery(sql).executeUpdate();
	    		ScpbPlan sp = spdao.findAllByNoAndNum(yuanno, num+1);
	    		sp.setNo(no);
	    		sp.setSbtime(sbtime);
	    		sp.setXbtime(xbtime);
	    		sp.setZytime(zytime);
	    		sp.setPxtime(pxtime);
	    		sp.setType(type);
	    		spdao.merge(sp);
	    		
	    		pl.setName(name);
	    		pl.setDate(du.getStringDate());
	    		pl.setTime(du.getTime());
	    		pl.setNum(num+1);
	    		pl.setRemark1("集中生产班次修改");
	    		pldao.merge(pl);
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
		else
		{
			message="失败！上班/下班时间格式有误!";
			return "failed";
		}
		
		
	}
	
	public boolean ifshivalue(String input)
	{
		if(!ifnotempty(input))
		{return false;}
		int shi = Integer.valueOf(input);
		if(shi<24)
			return true;
		else
			return false;
	}
	public boolean iffenvalue(String input)
	{
		if(!ifnotempty(input))
		{return false;}
		int fen = Integer.valueOf(input);
		if(fen<60)
			return true;
		else
			return false;
	}
	public boolean ifnotempty(String input)
	{
		if(input==null||input.equals(""))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public String std(String input)
	{
		if(input==null)
		{
			input = "00";
		}
		else if(input.length()==0)
		{
			input = "00";
		}
		else if(input.length()==1)
		{
			input = "0"+input;
		}
		return input;
	}
}

