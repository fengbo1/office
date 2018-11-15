package office.zcgl.pojo;

/**
 * AbstractAssertFen entity provides the base persistence definition of the
 * AssertFen entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAssertFen implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private String number;
	private String username;
	private String applynumber;
	private String area;
	private String returntime;

	// Constructors

	/** default constructor */
	public AbstractAssertFen() {
	}

	/** full constructor */
	public AbstractAssertFen(String name, String type, String number,
			String username, String applynumber, String area, String returntime) {
		this.name = name;
		this.type = type;
		this.number = number;
		this.username = username;
		this.applynumber = applynumber;
		this.area = area;
		this.returntime = returntime;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApplynumber() {
		return this.applynumber;
	}

	public void setApplynumber(String applynumber) {
		this.applynumber = applynumber;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getReturntime() {
		return this.returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}

}