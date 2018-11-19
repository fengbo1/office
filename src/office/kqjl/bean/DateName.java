package office.kqjl.bean;

public class DateName {

	private String date;
	private String name;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DateName(String date, String name) {
		super();
		this.date = date;
		this.name = name;
	}
	public DateName() {
		super();
		// TODO Auto-generated constructor stub
	}
}
