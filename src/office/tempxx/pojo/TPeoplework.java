package office.tempxx.pojo;

/**
 * TPeoplework entity. @author MyEclipse Persistence Tools
 */
public class TPeoplework extends AbstractTPeoplework implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TPeoplework() {
	}

	/** full constructor */
	public TPeoplework(String opnumber, String zu, String date, String iszhuan,
			String remark, String name, String status) {
		super(opnumber, zu, date, iszhuan, remark, name, status);
	}

}
