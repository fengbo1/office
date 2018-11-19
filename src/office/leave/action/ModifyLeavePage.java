package office.leave.action;

import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

public class ModifyLeavePage {

	private String number;
	private String newnumber;
	private LeavePage lp;
	private UserInfo ui;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public LeavePage getLp() {
		return lp;
	}
	public void setLp(LeavePage lp) {
		this.lp = lp;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String execute() throws Exception
	{
		LeavePageDAO lpdao = new LeavePageDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		lp = lpdao.findByNumber(number);
		ui = uidao.findByNewNumber(lp.getApplicant());
		
		
		return "success";
	}
}
