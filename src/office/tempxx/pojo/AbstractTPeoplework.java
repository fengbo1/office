package office.tempxx.pojo;

/**
 * AbstractTPeoplework entity provides the base persistence definition of the
 * TPeoplework entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTPeoplework implements java.io.Serializable {

	// Fields

	private Integer id;
	private String opnumber;
	private String zu;
	private String date;
	private String iszhuan;
	private String remark;
	private String name;
	private String status;

	// Constructors

	/** default constructor */
	public AbstractTPeoplework() {
	}

	/** full constructor */
	public AbstractTPeoplework(String opnumber, String zu, String date,
			String iszhuan, String remark, String name, String status) {
		this.opnumber = opnumber;
		this.zu = zu;
		this.date = date;
		this.iszhuan = iszhuan;
		this.remark = remark;
		this.name = name;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpnumber() {
		return this.opnumber;
	}

	public void setOpnumber(String opnumber) {
		this.opnumber = opnumber;
	}

	public String getZu() {
		return this.zu;
	}

	public void setZu(String zu) {
		this.zu = zu;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIszhuan() {
		return this.iszhuan;
	}

	public void setIszhuan(String iszhuan) {
		this.iszhuan = iszhuan;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}