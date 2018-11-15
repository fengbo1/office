package office.yscj.pojo;

/**
 * AbstractTYscj entity provides the base persistence definition of the TYscj
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTYscj implements java.io.Serializable {

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
	private String applicant;
	private String chu;
	private String zu;
	private String tel;
	private String zhiwu;
	private String sex;
	private Integer age;
	private String hukou;
	private String email;
	private String contactpeople;
	private String contactpeopletel;
	private Integer category;
	private String tocountry;
	private Double sumday;
	private String begindate;
	private String enddate;
	private Integer halfday;
	private Integer reason;
	private String travelagency;
	private String invitepeople;
	private String relationship;
	private String invitepeopletel;
	private String qitashuoming;
	private String remark;
	private Integer passporttype;
	private Integer notholiday;
	private String leavepagenumber;
	private String leaveremark;

	// Constructors

	/** default constructor */
	public AbstractTYscj() {
	}

	/** full constructor */
	public AbstractTYscj(String number, Integer process, String jindu,
			String date, Integer status, String preunder, String thisunder,
			String initiator, String applicant, String chu, String zu,
			String tel, String zhiwu, String sex, Integer age, String hukou,
			String email, String contactpeople, String contactpeopletel,
			Integer category, String tocountry, Double sumday,
			String begindate, String enddate, Integer halfday, Integer reason,
			String travelagency, String invitepeople, String relationship,
			String invitepeopletel, String qitashuoming, String remark,
			Integer passporttype, Integer notholiday, String leavepagenumber,
			String leaveremark) {
		this.number = number;
		this.process = process;
		this.jindu = jindu;
		this.date = date;
		this.status = status;
		this.preunder = preunder;
		this.thisunder = thisunder;
		this.initiator = initiator;
		this.applicant = applicant;
		this.chu = chu;
		this.zu = zu;
		this.tel = tel;
		this.zhiwu = zhiwu;
		this.sex = sex;
		this.age = age;
		this.hukou = hukou;
		this.email = email;
		this.contactpeople = contactpeople;
		this.contactpeopletel = contactpeopletel;
		this.category = category;
		this.tocountry = tocountry;
		this.sumday = sumday;
		this.begindate = begindate;
		this.enddate = enddate;
		this.halfday = halfday;
		this.reason = reason;
		this.travelagency = travelagency;
		this.invitepeople = invitepeople;
		this.relationship = relationship;
		this.invitepeopletel = invitepeopletel;
		this.qitashuoming = qitashuoming;
		this.remark = remark;
		this.passporttype = passporttype;
		this.notholiday = notholiday;
		this.leavepagenumber = leavepagenumber;
		this.leaveremark = leaveremark;
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

	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
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

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZhiwu() {
		return this.zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHukou() {
		return this.hukou;
	}

	public void setHukou(String hukou) {
		this.hukou = hukou;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactpeople() {
		return this.contactpeople;
	}

	public void setContactpeople(String contactpeople) {
		this.contactpeople = contactpeople;
	}

	public String getContactpeopletel() {
		return this.contactpeopletel;
	}

	public void setContactpeopletel(String contactpeopletel) {
		this.contactpeopletel = contactpeopletel;
	}

	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getTocountry() {
		return this.tocountry;
	}

	public void setTocountry(String tocountry) {
		this.tocountry = tocountry;
	}

	public Double getSumday() {
		return this.sumday;
	}

	public void setSumday(Double sumday) {
		this.sumday = sumday;
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

	public Integer getHalfday() {
		return this.halfday;
	}

	public void setHalfday(Integer halfday) {
		this.halfday = halfday;
	}

	public Integer getReason() {
		return this.reason;
	}

	public void setReason(Integer reason) {
		this.reason = reason;
	}

	public String getTravelagency() {
		return this.travelagency;
	}

	public void setTravelagency(String travelagency) {
		this.travelagency = travelagency;
	}

	public String getInvitepeople() {
		return this.invitepeople;
	}

	public void setInvitepeople(String invitepeople) {
		this.invitepeople = invitepeople;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getInvitepeopletel() {
		return this.invitepeopletel;
	}

	public void setInvitepeopletel(String invitepeopletel) {
		this.invitepeopletel = invitepeopletel;
	}

	public String getQitashuoming() {
		return this.qitashuoming;
	}

	public void setQitashuoming(String qitashuoming) {
		this.qitashuoming = qitashuoming;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPassporttype() {
		return this.passporttype;
	}

	public void setPassporttype(Integer passporttype) {
		this.passporttype = passporttype;
	}

	public Integer getNotholiday() {
		return this.notholiday;
	}

	public void setNotholiday(Integer notholiday) {
		this.notholiday = notholiday;
	}

	public String getLeavepagenumber() {
		return this.leavepagenumber;
	}

	public void setLeavepagenumber(String leavepagenumber) {
		this.leavepagenumber = leavepagenumber;
	}

	public String getLeaveremark() {
		return this.leaveremark;
	}

	public void setLeaveremark(String leaveremark) {
		this.leaveremark = leaveremark;
	}

}