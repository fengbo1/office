package office.yscj.pojo;

/**
 * AbstractTYscjtz entity provides the base persistence definition of the
 * TYscjtz entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTYscjtz implements java.io.Serializable {

	// Fields

	private Integer id;
	private String number;
	private String newnumber;
	private String reason;
	private String bringtime;
	private String returntime;
	private Double sumday;
	private String begindate;
	private String enddate;
	private String passporttype;
	private String passportnumber;
	private String tocountry;
	private String date;
	private Integer status;
	private String name;

	// Constructors

	/** default constructor */
	public AbstractTYscjtz() {
	}

	/** full constructor */
	public AbstractTYscjtz(String number, String newnumber, String reason,
			String bringtime, String returntime, Double sumday,
			String begindate, String enddate, String passporttype,
			String passportnumber, String tocountry, String date,
			Integer status, String name) {
		this.number = number;
		this.newnumber = newnumber;
		this.reason = reason;
		this.bringtime = bringtime;
		this.returntime = returntime;
		this.sumday = sumday;
		this.begindate = begindate;
		this.enddate = enddate;
		this.passporttype = passporttype;
		this.passportnumber = passportnumber;
		this.tocountry = tocountry;
		this.date = date;
		this.status = status;
		this.name = name;
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

	public String getNewnumber() {
		return this.newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getBringtime() {
		return this.bringtime;
	}

	public void setBringtime(String bringtime) {
		this.bringtime = bringtime;
	}

	public String getReturntime() {
		return this.returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
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

	public String getPassporttype() {
		return this.passporttype;
	}

	public void setPassporttype(String passporttype) {
		this.passporttype = passporttype;
	}

	public String getPassportnumber() {
		return this.passportnumber;
	}

	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}

	public String getTocountry() {
		return this.tocountry;
	}

	public void setTocountry(String tocountry) {
		this.tocountry = tocountry;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}