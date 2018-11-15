package office.mjgl.pojo;

public class TMjglPageBean {
	private String name;
	private String chu;
	private String currentauth;
	private Integer currenttime;
	private String tempauth;
	private String temptime;
	private String remark;

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
	public String getCurrentauth() {
		return currentauth;
	}
	public void setCurrentauth(String currentauth) {
		this.currentauth = currentauth;
	}
	public String getTempauth() {
		return tempauth;
	}
	public void setTempauth(String tempauth) {
		this.tempauth = tempauth;
	}

	public String getTemptime() {
		return temptime;
	}
	public void setTemptime(String temptime) {
		this.temptime = temptime;
	}
	public Integer getCurrenttime() {
		return currenttime;
	}
	public void setCurrenttime(Integer currenttime) {
		this.currenttime = currenttime;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
