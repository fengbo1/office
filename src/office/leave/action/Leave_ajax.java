package office.leave.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import office.leave.dao.LeavePageDAO;

public class Leave_ajax {
	
	//private String name;
	private String sumdate;
	private String username;

	
	//public String getName() {
	//	return name;
	//}


	//public void setName(String name) {
	//	this.name = name;
	//}


	public String getSumdate() {
		return sumdate;
	}


	public void setSumdate(String sumdate) {
		this.sumdate = sumdate;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String execute()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String name=request.getParameter("name");
		LeavePageDAO lpd=new LeavePageDAO();
		String position=lpd.findboss(name);
		
		String zhi=position.substring(0,1);
		String chu=position.substring(1,2);
		String tuan=position.substring(2,3);
		
		sumdate=position;
		
		
		return "success";		
	}
}