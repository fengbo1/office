package office.zcgl.pojo;

/**
 * AbstractStorehouseData entity provides the base persistence definition of the
 * StorehouseData entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStorehouseData implements java.io.Serializable {

	// Fields

	private Integer id;
	private String assetname;
	private String assettype;
	private String sn;
	private String assetnumber;
	private String rukutime;
	private String rukunum;
	private Integer iswupin;
	private String area;

	// Constructors

	/** default constructor */
	public AbstractStorehouseData() {
	}

	/** full constructor */
	public AbstractStorehouseData(String assetname, String assettype,
			String sn, String assetnumber, String rukutime, String rukunum,
			Integer iswupin, String area) {
		this.assetname = assetname;
		this.assettype = assettype;
		this.sn = sn;
		this.assetnumber = assetnumber;
		this.rukutime = rukutime;
		this.rukunum = rukunum;
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

	public String getAssetname() {
		return this.assetname;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	public String getAssettype() {
		return this.assettype;
	}

	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getAssetnumber() {
		return this.assetnumber;
	}

	public void setAssetnumber(String assetnumber) {
		this.assetnumber = assetnumber;
	}

	public String getRukutime() {
		return this.rukutime;
	}

	public void setRukutime(String rukutime) {
		this.rukutime = rukutime;
	}

	public String getRukunum() {
		return this.rukunum;
	}

	public void setRukunum(String rukunum) {
		this.rukunum = rukunum;
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