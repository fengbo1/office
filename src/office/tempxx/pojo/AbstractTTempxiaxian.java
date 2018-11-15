package office.tempxx.pojo;

/**
 * AbstractTTempxiaxian entity provides the base persistence definition of the
 * TTempxiaxian entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTTempxiaxian implements java.io.Serializable {

	// Fields

	private Integer id;
	private String chu;
	private String opzu;
	private String name;
	private String opnumber;
	private String zu;
	private String reason;
	private String shuoming;
	private String begindate;
	private String enddate;
	private String reportdate;
	private String remark;
	private String paiban;
	private String xiaxiantime;
	private String relatednumber;
	private String isred;

	// Constructors

	/** default constructor */
	public AbstractTTempxiaxian() {
	}

	/** full constructor */
	public AbstractTTempxiaxian(String chu, String opzu, String name,
			String opnumber, String zu, String reason, String shuoming,
			String begindate, String enddate, String reportdate, String remark,
			String paiban, String xiaxiantime, String relatednumber,
			String isred) {
		this.chu = chu;
		this.opzu = opzu;
		this.name = name;
		this.opnumber = opnumber;
		this.zu = zu;
		this.reason = reason;
		this.shuoming = shuoming;
		this.begindate = begindate;
		this.enddate = enddate;
		this.reportdate = reportdate;
		this.remark = remark;
		this.paiban = paiban;
		this.xiaxiantime = xiaxiantime;
		this.relatednumber = relatednumber;
		this.isred = isred;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChu() {
		return this.chu;
	}

	public void setChu(String chu) {
		this.chu = chu;
	}

	public String getOpzu() {
		return this.opzu;
	}

	public void setOpzu(String opzu) {
		this.opzu = opzu;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getShuoming() {
		return this.shuoming;
	}

	public void setShuoming(String shuoming) {
		this.shuoming = shuoming;
	}

	public String getBegindate() {
		return this.begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getReportdate() {
		return this.reportdate;
	}

	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPaiban() {
		return this.paiban;
	}

	public void setPaiban(String paiban) {
		this.paiban = paiban;
	}

	public String getXiaxiantime() {
		return this.xiaxiantime;
	}

	public void setXiaxiantime(String xiaxiantime) {
		this.xiaxiantime = xiaxiantime;
	}

	public String getRelatednumber() {
		return this.relatednumber;
	}

	public void setRelatednumber(String relatednumber) {
		this.relatednumber = relatednumber;
	}

	public String getIsred() {
		return this.isred;
	}

	public void setIsred(String isred) {
		this.isred = isred;
	}

}