package office.pb.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.pb.dao.PbTeshuDAO;
import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.dao.TPbPeopleDAO;
import office.pb.dao.YgpbPlanDAO;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.ScpbTeam;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

public class GetPbConfig {

	private List listsp;//生产排班
	private List listyp;//员工响应排班
	private List listst;//生产排班小组
	private List listpt;//特殊人员设置
	private List listpp;//单独人员排班
	private String unpaiban;
	
	public List getListpp() {
		return listpp;
	}
	public void setListpp(List listpp) {
		this.listpp = listpp;
	}
	public List getListsp() {
		return listsp;
	}
	public void setListsp(List listsp) {
		this.listsp = listsp;
	}
	public List getListyp() {
		return listyp;
	}
	public void setListyp(List listyp) {
		this.listyp = listyp;
	}
	public List getListst() {
		return listst;
	}
	public void setListst(List listst) {
		this.listst = listst;
	}
	public String getUnpaiban() {
		return unpaiban;
	}
	public void setUnpaiban(String unpaiban) {
		this.unpaiban = unpaiban;
	}
	public List getListpt() {
		return listpt;
	}
	public void setListpt(List listpt) {
		this.listpt = listpt;
	}
	public String execute() throws Exception
	{
		int num=0;
		String sql="";
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		
    		ScpbPlanDAO spdao = new ScpbPlanDAO();
    		YgpbPlanDAO ypdao = new YgpbPlanDAO();
    		ScpbTeamDAO stdao = new ScpbTeamDAO();
    		PbTeshuDAO ptdao = new PbTeshuDAO();
    		TPbPeopleDAO ppdao = new TPbPeopleDAO();
    		UserInfoDAO uidao = new UserInfoDAO();
    		sql = "select max(num) from t_scpb_plan";
    		if(session.createSQLQuery(sql).uniqueResult()!=null)
    			num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
    		listsp = spdao.findAllOrderByNo(num);
    		listyp = ypdao.findAllOrderByNo();
    		sql = "select max(num) from t_scpb_team";
    		if(session.createSQLQuery(sql).uniqueResult()!=null)
    			num = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
    		listst = stdao.findAllOrderByNo(num);
    		listpt = ptdao.findAll();
    		listpp = ppdao.findAll();
    		unpaiban = "";
    		List<String> liststr = new ArrayList<String>();
    		List<String> listpb = new ArrayList<String>();
    		List<String> listunpb = new ArrayList<String>();
    		List<UserInfo> listui = uidao.findAllByPosition1("sc");
    		for(int i=0;i<listui.size();i++)
    		{
    			UserInfo ui = listui.get(i);
    			if(!ui.getPosition().startsWith("2")&&!ui.getPosition().startsWith("1"))
    				liststr.add(ui.getUsername());
    		}
    		for(int i=0;i<listst.size();i++)
    		{
    			ScpbTeam st = (ScpbTeam) listst.get(i);
    			Collections.addAll(listpb, st.getLeader().split("、"));
				Collections.addAll(listpb, st.getMember().split("、"));
//    			String leaders = st.getLeader();
//    			for(int j=0;j<leaders.split("、").length;j++)
//    			{
//    				listpb.add(leaders.split("、")[j]);
//    			}
//    			//listpb.add(st.getLeader());
//    			String members = st.getMember();
//    			members.split("、");
//    			for(int j=0;j<members.split("、").length;j++)
//    			{
//    				listpb.add(members.split("、")[j]);
//    			}
    		}
    		liststr.removeAll(listpb);
    		for(int i=0;i<liststr.size();i++)
    		{
    			if(i!=0)
    				unpaiban+="、";
    			unpaiban+=liststr.get(i);
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
