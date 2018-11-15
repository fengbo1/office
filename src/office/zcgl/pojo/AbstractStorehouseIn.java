package office.zcgl.pojo;

/**
 * AbstractStorehouseIn entity provides the base persistence definition of the
 * StorehouseIn entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStorehouseIn implements java.io.Serializable {

	// Fields

	private Integer id;
	private String number;
	private String name;
	private String checkname;
	private Integer status;
	private String thisunder;
	private String initiator;
	private String date;
	private String remark;
	private String rukunum;
	private String tel;

	// Constructors

	/** default constructor */
	public AbstractStorehouseIn() {
	}

	/** full constructor */
	public AbstractStorehouseIn(String number, String name, String checkname,
			Integer status, String thisunder, String initiator, String date,
			String remark, String rukunum, String tel) {
		this.number = number;
		this.name = name;
		this.checkname = checkname;
		this.status = status;
		this.thisunder = thisunder;
		this.initiator = initiator;
		this.date = date;
		this.remark = remark;
		this.rukunum = rukunum;
		this.tel = tel;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCheckname() {
		return this.checkname;
	}

	public void setCheckname(String checkname) {
		this.checkname = checkname;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getThisunder() {
		return this.thisunder;
	}

	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}

	public String getInitiator() {
		return this.initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRukunum() {
		return this.rukunum;
	}

	public void setRukunum(String rukunum) {
		this.rukunum = rukunum;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}