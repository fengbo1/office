package office.jbsp.action;

public class ShowJbspPageDf {
	private String newnumber;

	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String execute() throws Exception
	{
		return "success";
	}
}
