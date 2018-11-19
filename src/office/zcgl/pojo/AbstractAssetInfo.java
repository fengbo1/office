package office.zcgl.pojo;

/**
 * AbstractAssetInfo entity provides the base persistence definition of the
 * AssetInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAssetInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private Integer chu;
	private Integer status;
	private String date;
	private String remark;
	private String sn;
	private String people;
	private String number;
	private String returntime;
	private Integer iswupin;
	private String area;

	// Constructors

	/** default constructor */
	public AbstractAssetInfo() {
	}

	/** full constructor */
	public AbstractAssetInfo(String name, String type, Integer chu,
			Integer status, String date, String remark, String sn,
			String people, String number, String returntime, Integer iswupin,
			String area) {
		this.name = name;
		this.type = type;
		this.chu = chu;
		this.status = status;
		this.date = date;
		this.remark = remark;
		this.sn = sn;
		this.people = people;
		this.number = number;
		this.returntime = returntime;
		this.iswupin = iswupin;
		this.area = area;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPeople() {
		return this.people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getReturntime() {
		return this.returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}

	public Integer getIswupin() {
		return this.iswupin;
	}

	public void setIswupin(Integer iswupin) {
		this.iswupin = iswupin;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}