package office.zcgl.pojo;

/**
 * AbstractAssetTemp entity provides the base persistence definition of the
 * AssetTemp entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAssetTemp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private String number;
	private Integer num;

	// Constructors

	/** default constructor */
	public AbstractAssetTemp() {
	}

	/** full constructor */
	public AbstractAssetTemp(String name, String type, String number,
			Integer num) {
		this.name = name;
		this.type = type;
		this.number = number;
		this.num = num;
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

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}