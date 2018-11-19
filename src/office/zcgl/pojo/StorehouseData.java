package office.zcgl.pojo;

/**
 * StorehouseData entity. @author MyEclipse Persistence Tools
 */
public class StorehouseData extends AbstractStorehouseData implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public StorehouseData() {
	}

	/** full constructor */
	public StorehouseData(String assetname, String assettype, String sn,
			String assetnumber, String rukutime, String rukunum,
			Integer iswupin, String area) {
		super(assetname, assettype, sn, assetnumber, rukutime, rukunum,
				iswupin, area);
	}

}
