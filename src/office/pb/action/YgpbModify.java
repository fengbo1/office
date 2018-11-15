package office.pb.action;

import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.YgpbPlanDAO;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.YgpbPlan;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class YgpbModify {
	private String message;
	private int no;
	private int id;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public String execute() throws Exception
	{
		if(ifshivalue(sb1)&&ifshivalue(xb1)&&iffenvalue(sb2)&&iffenvalue(xb2))
		{
			message = "修改成功";
			YgpbPlanDAO ygdao = new YgpbPlanDAO();
			YgpbPlan yg = ygdao.findAllByID(id);
			String sbtime = std(sb1)+":"+std(sb2);
			String xbtime = std(xb1)+":"+std(xb2);
			String zytime = std(zy11)+":"+std(zy12)+"-"+std(zy13)+":"+std(zy14);
			if(ifnotempty(zy21)&&ifnotempty(zy22)&&ifnotempty(zy23)&&ifnotempty(zy24))
			{
				zytime+= " "+std(zy21)+":"+std(zy22)+"-"+std(zy23)+":"+std(zy24);
			}
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	try {
	    		yg.setNo(no);
	    		yg.setSbtime(sbtime);
	    		yg.setXbtime(xbtime);
	    		yg.setZytime(zytime);
	    		ygdao.merge(yg);
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
			message="修改失败，上班/下班时间格式有误!";
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

