package office.zcgl.pojo;

/**
 * AbstractAssetApply entity provides the base persistence definition of the
 * AssetApply entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAssetApply implements java.io.Serializable {

	// Fields

	private Integer id;
	private String number;
	private String name;
	private Integer chu;
	private Integer status;
	private String date;
	private String reason;
	private String remark;
	private Integer process;
	private String jindu;
	private String preunder;
	private String thisunder;
	private String initiator;
	private String tel;

	// Constructors

	/** default constructor */
	public AbstractAssetApply() {
	}

	/** full constructor */
	public AbstractAssetApply(String number, String name, Integer chu,
			Integer status, String date, String reason, String remark,
			Integer process, String jindu, String preunder, String thisunder,
			String initiator, String tel) {
		this.number = number;
		this.name = name;
		this.chu = chu;
		this.status = status;
		this.date = date;
		this.reason = reason;
		this.remark = remark;
		this.process = process;
		this.jindu = jindu;
		this.preunder = preunder;
		this.thisunder = thisunder;
		this.initiator = initiator;
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

	public Integer getChu() {
		return this.chu;
	}

	public void setChu(Integer chu) {
		this.chu = chu;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getProcess() {
		return this.process;
	}

	public void setProcess(Integer process) {
		this.process = process;
	}

	public String getJindu() {
		return this.jindu;
	}

	public void setJindu(String jindu) {
		this.jindu = jindu;
	}

	public String getPreunder() {
		return this.preunder;
	}

	public void setPreunder(String preunder) {
		this.preunder = preunder;
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

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}