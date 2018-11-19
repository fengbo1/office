package office.pb.pojo;

/**
 * AbstractTPbPeople entity provides the base persistence definition of the
 * TPbPeople entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTPbPeople implements java.io.Serializable {

	// Fields

	private Integer id;
	private String date;
	private Integer week;
	private String name;
	private Integer plan;
	private Integer isrest;

	// Constructors

	/** default constructor */
	public AbstractTPbPeople() {
	}

	/** full constructor */
	public AbstractTPbPeople(String date, Integer week, String name,
			Integer plan, Integer isrest) {
		this.date = date;
		this.week = week;
		this.name = name;
		this.plan = plan;
		this.isrest = isrest;
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

	public Integer getWeek() {
		return this.week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPlan() {
		return this.plan;
	}

	public void setPlan(Integer plan) {
		this.plan = plan;
	}

	public Integer getIsrest() {
		return this.isrest;
	}

	public void setIsrest(Integer isrest) {
		this.isrest = isrest;
	}

}