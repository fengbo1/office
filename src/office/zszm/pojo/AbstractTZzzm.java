package office.zszm.pojo;

/**
 * AbstractTZzzm entity provides the base persistence definition of the TZzzm
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTZzzm implements java.io.Serializable {

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
	private String yongtu;
	private Integer neednumber;
	private String todepartment;
	private String remark;
	private String sex;
	private String licencech;
	private String licenceen;
	private Integer isdeparture;
	private String yscjnumber;

	// Constructors

	/** default constructor */
	public AbstractTZzzm() {
	}

	/** full constructor */
	public AbstractTZzzm(String number, Integer process, String jindu,
			String date, Integer status, String preunder, String thisunder,
			String initiator, String applicant, String chu, String zu,
			String tel, String zhiwu, String yongtu, Integer neednumber,
			String todepartment, String remark, String sex, String licencech,
			String licenceen, Integer isdeparture, String yscjnumber) {
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
		this.yongtu = yongtu;
		this.neednumber = neednumber;
		this.todepartment = todepartment;
		this.remark = remark;
		this.sex = sex;
		this.licencech = licencech;
		this.licenceen = licenceen;
		this.isdeparture = isdeparture;
		this.yscjnumber = yscjnumber;
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

	public String getYongtu() {
		return this.yongtu;
	}

	public void setYongtu(String yongtu) {
		this.yongtu = yongtu;
	}

	public Integer getNeednumber() {
		return this.neednumber;
	}

	public void setNeednumber(Integer neednumber) {
		this.neednumber = neednumber;
	}

	public String getTodepartment() {
		return this.todepartment;
	}

	public void setTodepartment(String todepartment) {
		this.todepartment = todepartment;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLicencech() {
		return this.licencech;
	}

	public void setLicencech(String licencech) {
		this.licencech = licencech;
	}

	public String getLicenceen() {
		return this.licenceen;
	}

	public void setLicenceen(String licenceen) {
		this.licenceen = licenceen;
	}

	public Integer getIsdeparture() {
		return this.isdeparture;
	}

	public void setIsdeparture(Integer isdeparture) {
		this.isdeparture = isdeparture;
	}

	public String getYscjnumber() {
		return this.yscjnumber;
	}

	public void setYscjnumber(String yscjnumber) {
		this.yscjnumber = yscjnumber;
	}

}