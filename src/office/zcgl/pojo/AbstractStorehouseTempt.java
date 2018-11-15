package office.zcgl.pojo;

/**
 * AbstractStorehouseTempt entity provides the base persistence definition of
 * the StorehouseTempt entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStorehouseTempt implements java.io.Serializable {

	// Fields

	private Integer id;
	private String assetname;
	private String assettype;
	private String sn;
	private Integer num;
	private String rukunum;

	// Constructors

	/** default constructor */
	public AbstractStorehouseTempt() {
	}

	/** full constructor */
	public AbstractStorehouseTempt(String assetname, String assettype,
			String sn, Integer num, String rukunum) {
		this.assetname = assetname;
		this.assettype = assettype;
		this.sn = sn;
		this.num = num;
		this.rukunum = rukunum;
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

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getRukunum() {
		return this.rukunum;
	}

	public void setRukunum(String rukunum) {
		this.rukunum = rukunum;
	}

}