package office.zcgl.pojo;

/**
 * StorehouseTempt entity. @author MyEclipse Persistence Tools
 */
public class StorehouseTempt extends AbstractStorehouseTempt implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public StorehouseTempt() {
	}

	/** full constructor */
	public StorehouseTempt(String assetname, String assettype, String sn,
			Integer num, String rukunum) {
		super(assetname, assettype, sn, num, rukunum);
	}

}
