package office.pb.pojo;

/**
 * TPbPeople entity. @author MyEclipse Persistence Tools
 */
public class TPbPeople extends AbstractTPbPeople implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TPbPeople() {
	}

	/** full constructor */
	public TPbPeople(String date, Integer week, String name, Integer plan,
			Integer isrest) {
		super(date, week, name, plan, isrest);
	}

}
