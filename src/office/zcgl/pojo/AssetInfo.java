package office.zcgl.pojo;

/**
 * AssetInfo entity. @author MyEclipse Persistence Tools
 */
public class AssetInfo extends AbstractAssetInfo implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public AssetInfo() {
	}

	/** full constructor */
	public AssetInfo(String name, String type, Integer chu, Integer status,
			String date, String remark, String sn, String people,
			String number, String returntime, Integer iswupin, String area) {
		super(name, type, chu, status, date, remark, sn, people, number,
				returntime, iswupin, area);
	}

}
