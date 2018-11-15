package office.pb2.action;

import office.leave.dao.LeavePageDAO;
import office.pb.dao.PbMxDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.PbMx;
import office.pb.pojo.ScpbTeam;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class GetJihua {

	private String name;
	private String date;
	private String tbname;
	private String prejihua;
	private String nowjihua;
	private String bossname;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTbname() {
		return tbname;
	}
	public void setTbname(String tbname) {
		this.tbname = tbname;
	}
	public String getPrejihua() {
		return prejihua;
	}
	public void setPrejihua(String prejihua) {
		this.prejihua = prejihua;
	}
	public String getNowjihua() {
		return nowjihua;
	}
	public void setNowjihua(String nowjihua) {
		this.nowjihua = nowjihua;
	}
	public String getBossname() {
		return bossname;
	}
	public void setBossname(String bossname) {
		this.bossname = bossname;
	}
	public String execute() throws Exception
	{
		System.out.println("11111");
		LeavePageDAO lpd=new LeavePageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		//name = java.net.URLDecoder.decode(name,"UTF-8"); 
		//tbname = java.net.URLDecoder.decode(tbname,"UTF-8");
		//ScpbTeamDAO stdao = new ScpbTeamDAO();
		name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		tbname = new String(tbname.getBytes("ISO8859-1"),"UTF-8");
		date = date.replace("-","");
		String result = "success";
		PbMxDAO pmdao = new PbMxDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    try {
 	    	PbMx pm = pmdao.findAllByNameAndDateNull(name, date);
 	    	PbMx pmtb = pmdao.findAllByNameAndDateNull(tbname, date);
 	    	//ScpbTeam st = stdao.findAllByNoAndNum(pm.getTeam(),pm.getTeamnum());
 	    	//UserInfo ui = 
 	    	//ScpbTeam sttb = stdao.findAllByNoAndNum(pmtb.getTeam(),pmtb.getTeamnum());
 	    	if(pm==null||pmtb==null)//无记录
 	    	{
 	    		result = "failededed";
 	    	}
 	    	else
 	    	{
 	    		UserInfo ui = uidao.findByName(name);
 	    		UserInfo tbui = uidao.findByName(tbname);
 	    		UserInfo uipb = uidao.findAllByAuthority("T").get(0);
 	    		prejihua = "签到时间："+pm.getPbqdtime()+"，签退时间："+pm.getPbqttime()+"，作业时间："+pm.getZytime();
 	    		nowjihua = "签到时间："+pmtb.getPbqdtime()+"，签退时间："+pmtb.getPbqttime()+"，作业时间："+pmtb.getZytime();
 			    if(ui.getAuthority().contains("D"))
 			    {
 			    	if(ui.getPosition().substring(2, 3).equals(tbui.getPosition().substring(2, 3))&&ui.getPosition().substring(4, 5).equals(tbui.getPosition().substring(4, 5)))//同一处室
 			    	{
 			    		bossname="（排班管理员）"+uipb.getUsername()+":"+uipb.getNewnumber();
 			    	}
 			    	else
 			    	{
 			    		bossname=lpd.findzuzhang(tbname);
 			    	}
 			    }
 			    else
 			    {
 			    	bossname=lpd.findzuzhang(name);
 			    }
 	    		
 	    	}
 	   	} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
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
