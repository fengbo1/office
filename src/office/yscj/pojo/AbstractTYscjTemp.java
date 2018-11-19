package office.yscj.pojo;

/**
 * AbstractTYscjTemp entity provides the base persistence definition of the
 * TYscjTemp entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTYscjTemp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String date;
	private String chu;
	private String zhiwu;
	private String sex;
	private Integer age;
	private String hukou;
	private String email;
	private String contactpeople;
	private String contactpeopletel;
	private Integer category;
	private String tocountry;
	private Integer sumday;
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
	private String tel;

	// Constructors

	/** default constructor */
	public AbstractTYscjTemp() {
	}

	/** full constructor */
	public AbstractTYscjTemp(String name, String date, String chu,
			String zhiwu, String sex, Integer age, String hukou, String email,
			String contactpeople, String contactpeopletel, Integer category,
			String tocountry, Integer sumday, String begindate, String enddate,
			Integer halfday, Integer reason, String travelagency,
			String invitepeople, String relationship, String invitepeopletel,
			String qitashuoming, String remark, Integer passporttype,
			Integer notholiday, String leavepagenumber, String tel) {
		this.name = name;
		this.date = date;
		this.chu = chu;
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
		this.tel = tel;
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

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getChu() {
		return this.chu;
	}

	public void setChu(String chu) {
		this.chu = chu;
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

	public Integer getSumday() {
		return this.sumday;
	}

	public void setSumday(Integer sumday) {
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

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}