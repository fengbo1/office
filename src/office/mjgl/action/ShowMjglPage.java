package office.mjgl.action;
import java.util.List;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.UserUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class ShowMjglPage {
	private String newnumber;
	private Integer chu;
	private UserInfo ui;
	private List<UserInfo> list;
	private String position;
	public Integer getChu() {
		return chu;
	}
	public void setChu(Integer chu) {
		this.chu = chu;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    GetProcessByPosition gpbp = new GetProcessByPosition();
 	    ProcessDAO pdao = new ProcessDAO();
 	    int process = 0;
 	    ui = uidao.findByNewNumber(newnumber);
 	    position = ui.getPosition();
 	    String thisunder = "";
 	    process = gpbp.getMjglProcess(position,ui.getAuthority());
 	    Process p = pdao.findByItemAndApplicant("MJGL", process);
 	    if(p!=null)
	    {
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	list = uidao.findByAuthorityAndPosition(thisunder, position);
	    }
 	    chu = Integer.parseInt(position.substring(2,3));
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
		
	}
}
