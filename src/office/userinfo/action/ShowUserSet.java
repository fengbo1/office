package office.userinfo.action;

import office.config.dao.ConfigDAO;

public class ShowUserSet {

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String execute() throws Exception
	{
		ConfigDAO cfgdao = new ConfigDAO();
		name = cfgdao.findAllByName("buru").getStrvalue();
		return "success";
	}
}
