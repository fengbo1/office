package office.mjgl.pojo;

/**
 * AbstractTMjgl entity provides the base persistence definition of the TMjgl
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTMjgl implements java.io.Serializable {

	// Fields

	private Integer id;
	private String number;
	private Integer process;
	private String jindu;
	private String date;
	private Integer status;
	private String preunder;
	private String thisunder;
	private String initiator;
	private String people;
	private String chu;
	private String zu;
	private Integer reason;
	private String oldp;
	private String newp;
	private Integer oldtime;
	private Integer newtime;
	private Integer istemp;
	private String startdate;
	private String enddate;
	private String tempauth;
	private Integer temptime;
	private String remark1;
	private String remark2;
	private String startdateamorpm;
	private String enddateamorpam;

	// Constructors

	/** default constructor */
	public AbstractTMjgl() {
	}

	/** full constructor */
	public AbstractTMjgl(String number, Integer process, String jindu,
			String date, Integer status, String preunder, String thisunder,
			String initiator, String people, String chu, String zu,
			Integer reason, String oldp, String newp, Integer oldtime,
			Integer newtime, Integer istemp, String startdate, String enddate,
			String tempauth, Integer temptime, String remark1, String remark2,
			String startdateamorpm, String enddateamorpam) {
		this.number = number;
		this.process = process;
		this.jindu = jindu;
		this.date = date;
		this.status = status;
		this.preunder = preunder;
		this.thisunder = thisunder;
		this.initiator = initiator;
		this.people = people;
		this.chu = chu;
		this.zu = zu;
		this.reason = reason;
		this.oldp = oldp;
		this.newp = newp;
		this.oldtime = oldtime;
		this.newtime = newtime;
		this.istemp = istemp;
		this.startdate = startdate;
		this.enddate = enddate;
		this.tempauth = tempauth;
		this.temptime = temptime;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.startdateamorpm = startdateamorpm;
		this.enddateamorpam = enddateamorpam;
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

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getPeople() {
		return this.people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getChu() {
		return this.chu;
	}

	public void setChu(String chu) {
		this.chu = chu;
	}

	public String getZu() {
		return this.zu;
	}

	public void setZu(String zu) {
		this.zu = zu;
	}

	public Integer getReason() {
		return this.reason;
	}

	public void setReason(Integer reason) {
		this.reason = reason;
	}

	public String getOldp() {
		return this.oldp;
	}

	public void setOldp(String oldp) {
		this.oldp = oldp;
	}

	public String getNewp() {
		return this.newp;
	}

	public void setNewp(String newp) {
		this.newp = newp;
	}

	public Integer getOldtime() {
		return this.oldtime;
	}

	public void setOldtime(Integer oldtime) {
		this.oldtime = oldtime;
	}

	public Integer getNewtime() {
		return this.newtime;
	}

	public void setNewtime(Integer newtime) {
		this.newtime = newtime;
	}

	public Integer getIstemp() {
		return this.istemp;
	}

	public void setIstemp(Integer istemp) {
		this.istemp = istemp;
	}

	public String getStartdate() {
		return this.startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTempauth() {
		return this.tempauth;
	}

	public void setTempauth(String tempauth) {
		this.tempauth = tempauth;
	}

	public Integer getTemptime() {
		return this.temptime;
	}

	public void setTemptime(Integer temptime) {
		this.temptime = temptime;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getStartdateamorpm() {
		return this.startdateamorpm;
	}

	public void setStartdateamorpm(String startdateamorpm) {
		this.startdateamorpm = startdateamorpm;
	}

	public String getEnddateamorpam() {
		return this.enddateamorpam;
	}

	public void setEnddateamorpam(String enddateamorpam) {
		this.enddateamorpam = enddateamorpam;
	}

}