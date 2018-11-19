package office.pb2.action;

import java.util.ArrayList;
import java.util.List;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.UserUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ShowYgxxPage {

	private String newnumber;
	private String name;
	private UserInfo uisp;
	private List<UserInfo> list;
	private String chuname;
	private String allname;
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserInfo getUisp() {
		return uisp;
	}
	public void setUisp(UserInfo uisp) {
		this.uisp = uisp;
	}
	
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	public String getChuname() {
		return chuname;
	}
	public void setChuname(String chuname) {
		this.chuname = chuname;
	}
	public String getAllname() {
		return allname;
	}
	public void setAllname(String allname) {
		this.allname = allname;
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans=session.beginTransaction();
		try {
			list = new ArrayList<UserInfo>();
			UserInfo ui = uidao.findByNewNumber(newnumber);
			name = ui.getUsername();
			String position = ui.getPosition();
			char chu = position.charAt(2);
			char zhi = position.charAt(0);
			if(zhi=='2'||zhi=='1')
			{
				List<UserInfo> templist = uidao.findAllByAuthority("T");//排班管理员
				for(int i=0;i<templist.size();i++)
				{
					UserInfo tempui = templist.get(i);
					String tempstr = "排班管理员（"+tempui.getUsername()+"）";
					UserInfo temp = new UserInfo();
					temp.setNewnumber(tempui.getNewnumber());
					temp.setUsername(tempstr);
					list.add(temp);
				}
			}
			List<UserInfo> listall = uidao.findAll();
		    List<UserInfo> listchu = uidao.findAllByPosition1("__"+chu+"__");
		    chuname="";
		    allname="";
		    for(int i=0;i<listall.size();i++)
		    {
		    	UserInfo u = listall.get(i);
		    	allname+=u.getUsername();
		    	allname+="、";
		    }
		    for(int i=0;i<listchu.size();i++)
		    {
		    	UserInfo u = listchu.get(i);
		    	chuname+=u.getUsername();
		    	chuname+="、";
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
