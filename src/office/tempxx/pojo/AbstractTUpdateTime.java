package office.tempxx.pojo;

/**
 * AbstractTUpdateTime entity provides the base persistence definition of the
 * TUpdateTime entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTUpdateTime implements java.io.Serializable {

	// Fields

	private Integer id;
	private String date;
	private String status;

	// Constructors

	/** default constructor */
	public AbstractTUpdateTime() {
	}

	/** full constructor */
	public AbstractTUpdateTime(String date, String status) {
		this.date = date;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}