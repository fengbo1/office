package office.welcome;

public class WelcomeBean {

	private String initiator;//发起人姓名
	private String name;//申请人姓名
	private String chu;//处室
	private String preunder;//上一级审批人
	private String date;//申请提交日期
	private String type1;//待办事宜类型
	private String type2;//待办事宜小类别
	private String number;//编号
	private int status;
	
	
	public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String getPreunder() {
		return preunder;
	}
	public void setPreunder(String preunder) {
		this.preunder = preunder;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getNumber() {
		return number;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
