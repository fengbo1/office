package office.zcgl.pojo;

/**
 * StorehouseOut entity. @author MyEclipse Persistence Tools
 */
public class StorehouseOut extends AbstractStorehouseOut implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public StorehouseOut() {
	}

	/** full constructor */
	public StorehouseOut(String number, String name, String checkname,
			Integer status, String date, String reason, String thisunder,
			String initiator, String chukunum, String tel) {
		super(number, name, checkname, status, date, reason, thisunder,
				initiator, chukunum, tel);
	}

}
