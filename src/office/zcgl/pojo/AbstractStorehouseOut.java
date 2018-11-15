package office.zcgl.pojo;

/**
 * AbstractStorehouseOut entity provides the base persistence definition of the
 * StorehouseOut entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStorehouseOut implements java.io.Serializable {

	// Fields

	private Integer id;
	private String number;
	private String name;
	private String checkname;
	private Integer status;
	private String date;
	private String reason;
	private String thisunder;
	private String initiator;
	private String chukunum;
	private String tel;

	// Constructors

	/** default constructor */
	public AbstractStorehouseOut() {
	}

	/** full constructor */
	public AbstractStorehouseOut(String number, String name, String checkname,
			Integer status, String date, String reason, String thisunder,
			String initiator, String chukunum, String tel) {
		this.number = number;
		this.name = name;
		this.checkname = checkname;
		this.status = status;
		this.date = date;
		this.reason = reason;
		this.thisunder = thisunder;
		this.initiator = initiator;
		this.chukunum = chukunum;
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

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getChukunum() {
		return this.chukunum;
	}

	public void setChukunum(String chukunum) {
		this.chukunum = chukunum;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}