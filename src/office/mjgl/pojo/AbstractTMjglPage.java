package office.mjgl.pojo;

/**
 * AbstractTMjglPage entity provides the base persistence definition of the
 * TMjglPage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTMjglPage implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String chu;
	private String currentauth;
	private String tempauth;
	private String temptime;
	private Integer currenttime;
	private String remark;

	// Constructors

	/** default constructor */
	public AbstractTMjglPage() {
	}

	/** full constructor */
	public AbstractTMjglPage(String name, String chu, String currentauth,
			String tempauth, String temptime, Integer currenttime, String remark) {
		this.name = name;
		this.chu = chu;
		this.currentauth = currentauth;
		this.tempauth = tempauth;
		this.temptime = temptime;
		this.currenttime = currenttime;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChu() {
		return this.chu;
	}

	public void setChu(String chu) {
		this.chu = chu;
	}

	public String getCurrentauth() {
		return this.currentauth;
	}

	public void setCurrentauth(String currentauth) {
		this.currentauth = currentauth;
	}

	public String getTempauth() {
		return this.tempauth;
	}

	public void setTempauth(String tempauth) {
		this.tempauth = tempauth;
	}

	public String getTemptime() {
		return this.temptime;
	}

	public void setTemptime(String temptime) {
		this.temptime = temptime;
	}

	public Integer getCurrenttime() {
		return this.currenttime;
	}

	public void setCurrenttime(Integer currenttime) {
		this.currenttime = currenttime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}