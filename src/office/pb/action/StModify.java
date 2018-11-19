package office.pb.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import office.pb.dao.PbLogDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.PbLog;
import office.pb.pojo.ScpbTeam;
import office.userinfo.dao.UserInfoDAO;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class StModify {
	private String message;
	private int id;
	private int no;
	private int yuanno;//原来的班次名
	private String name;
	private String[] leader;
	private String[] member;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String execute() throws Exception
	{
		message="";
		String sql = "";
		int num = 0;
		ScpbTeamDAO stdao = new ScpbTeamDAO();
		DateUtil du = new DateUtil();
		PbLogDAO pldao = new PbLogDAO();
		PbLog pl = new PbLog();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	String peoples = "";
    	String leaders = "";
    	String members = "";
    	sql = "select max(num) from t_scpb_team";
		if(session.createSQLQuery(sql).uniqueResult()!=null)
			num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
    	List listst = stdao.findAllWithOutNoAndOld(no,yuanno,num);
    	List<String> listpb = new ArrayList<String>();
    	for(int i=0;i<listst.size();i++)
		{
			ScpbTeam st = (ScpbTeam) listst.get(i);
			Collections.addAll(listpb, st.getLeader().split("、"));
			Collections.addAll(listpb, st.getMember().split("、"));
//			listpb.add(st.getLeader());
//			String temp = st.getMember();
//			temp.split("、");
//			for(int j=0;j<temp.split("、").length;j++)
//			{
//				listpb.add(temp.split("、")[j]);
//			}
		}
    	for(int i=0;i<leader.length;i++)
    	{
    		if(leader[i]!=null&&!leader[i].equals(""))
    		{
    			if(peoples.length()>0&&!peoples.endsWith("、"))
        		{
        			peoples+="、";
        		}
    			if(leaders.length()>0&&!leaders.endsWith("、"))
        		{
    				leaders+="、";
        		}
    			peoples+=leader[i];
        		leaders+=leader[i];
    		}
    	}
    	for(int i=0;i<member.length;i++)
    	{
    		if(member[i]!=null&&!member[i].equals(""))
    		{
    			if(peoples.length()>0&&!peoples.endsWith("、"))
        		{
        			peoples+="、";
        		}
    			if(members.length()>0&&!members.endsWith("、"))
        		{
    				members+="、";
        		}
        		peoples+=member[i];
        		members+=member[i];
    		}
    	}
    	System.out.println(peoples);
    	System.out.println(leaders);
    	System.out.println(members);
    	try {
    		UserInfoDAO uidao = new UserInfoDAO();
    		for(int i=0;i<members.split("、").length;i++)
    		{
    			String tempname = members.split("、")[i];
    			if(uidao.findChuByName(tempname)==-1)
        		{
        			message = "姓名"+tempname+"姓名书写有误";
        			return "failed";
        		}
        		else if(uidao.findChuByName(tempname)==1||uidao.findChuByName(tempname)==4||uidao.findChuByName(tempname)==5)
        		{
        			message = "姓名"+tempname+"不属于您的排班范围";
        			return "failed";
        		}
        		else if(listpb.indexOf(tempname)!=-1)
        		{
    				message ="!失败!姓名【"+tempname+"】已存在";
    				return "failed";
    			}
        		else
        		{
        			listpb.add(tempname);
        		}
    		}
//    		if(uidao.findChuByName(leader)==-1)
//    		{
//    			message = "失败！组长姓名书写有误";
//    			return "failed";
//    		}
//    		else if(uidao.findChuByName(leader)<2||uidao.findChuByName(leader)>3)
//    		{
//    			message = "失败！组长不属于您的排班范围";
//    			return "failed";
//    		}
//    		else
//    		{
//    			if(listpb.indexOf(leader)!=-1)
//    			{
//    				message +="失败！姓名【"+leader+"】已存在";
//    				return "failed";
//    			}
//    			else
//    				listpb.add(leader);
//    			for(int i=0;i<member.length;i++)
//    			{
//    				String name = member[i];
//    				if(name!=null&&!name.equals(""))
//    				{
//    					if(uidao.findChuByName(name)==-1)
//        	    		{
//        	    			message = "失败！姓名【"+name+"】书写有误";
//        	    			return "failed";
//        	    		}
//        	    		else if(uidao.findChuByName(name)<2||uidao.findChuByName(name)>3)
//        	    		{
//        	    			message = "失败！姓名【"+name+"】不属于您的排班范围";
//        	    			return "failed";
//        	    		}
//        	    		else
//        	    		{
//        	    			if(members.length()>0)
//        	    			{
//        	    				members+="、";
//        	    			}
//        	    			members+=name;
//        	    		}
//    					if(listpb.indexOf(name)!=-1)
//    					{
//    						message +="失败！姓名【"+name+"】已存在";
//    						return "failed";
//    					}
//    						
//    	    			else
//    	    				listpb.add(leader);
//    				}
//    			}
    			if(message.length()==0)
    			{
    	    		sql = "insert into t_scpb_team(no,num,leader,member) select no,num+1,leader,member from t_scpb_team where num="+num;
    	    		session.createSQLQuery(sql).executeUpdate();
    				ScpbTeam st = stdao.findAllByNoAndNum(yuanno, num+1);
    				st.setNo(no);
    				st.setLeader(leaders);
    				st.setMember(members);
    				message = "修改成功！";
    				stdao.merge(st);
    				
    				pl.setName(name);
    	    		pl.setDate(du.getStringDate());
    	    		pl.setTime(du.getTime());
    	    		pl.setNum(num+1);
    	    		pl.setRemark1("集中生产小组修改");
    	    		pldao.merge(pl);
    			}
 //   		}
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
