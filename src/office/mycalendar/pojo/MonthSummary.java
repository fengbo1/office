package office.mycalendar.pojo;

public class MonthSummary {

	private int year;
	private int month;
	private double days;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getDays() {
		return days;
	}
	public void setDays(double days) {
		this.days = days;
	}
	public MonthSummary(int year, int month, double days) {
		super();
		this.year = year;
		this.month = month;
		this.days = days;
	}
	public MonthSummary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
