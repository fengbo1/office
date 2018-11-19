package office.zcgl.pojo;

/**
 * AbstractAssetBorrow entity provides the base persistence definition of the
 * AssetBorrow entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAssetBorrow implements java.io.Serializable {

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
	private String returntime;
	private String tel;
	private Integer isreturn;
	private Integer isandborrow;
	private String andborrowreturntime;

	// Constructors

	/** default constructor */
	public AbstractAssetBorrow() {
	}

	/** full constructor */
	public AbstractAssetBorrow(String number, String name, Integer chu,
			Integer status, String date, String reason, String remark,
			Integer process, String jindu, String preunder, String thisunder,
			String initiator, String returntime, String tel, Integer isreturn,
			Integer isandborrow, String andborrowreturntime) {
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
		this.returntime = returntime;
		this.tel = tel;
		this.isreturn = isreturn;
		this.isandborrow = isandborrow;
		this.andborrowreturntime = andborrowreturntime;
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

	public String getReturntime() {
		return this.returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getIsreturn() {
		return this.isreturn;
	}

	public void setIsreturn(Integer isreturn) {
		this.isreturn = isreturn;
	}

	public Integer getIsandborrow() {
		return this.isandborrow;
	}

	public void setIsandborrow(Integer isandborrow) {
		this.isandborrow = isandborrow;
	}

	public String getAndborrowreturntime() {
		return this.andborrowreturntime;
	}

	public void setAndborrowreturntime(String andborrowreturntime) {
		this.andborrowreturntime = andborrowreturntime;
	}

}