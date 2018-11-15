package office.zcgl.pojo;

/**
 * StorehouseIn entity. @author MyEclipse Persistence Tools
 */
public class StorehouseIn extends AbstractStorehouseIn implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public StorehouseIn() {
	}

	/** full constructor */
	public StorehouseIn(String number, String name, String checkname,
			Integer status, String thisunder, String initiator, String date,
			String remark, String rukunum, String tel) {
		super(number, name, checkname, status, thisunder, initiator, date,
				remark, rukunum, tel);
	}

}
