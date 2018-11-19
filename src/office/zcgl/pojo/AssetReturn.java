package office.zcgl.pojo;

/**
 * AssetReturn entity. @author MyEclipse Persistence Tools
 */
public class AssetReturn extends AbstractAssetReturn implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public AssetReturn() {
	}

	/** full constructor */
	public AssetReturn(String number, String name, Integer chu, Integer status,
			String date, String reason, String remark, Integer process,
			String jindu, String preunder, String thisunder, String initiator,
			String tel, String assetid) {
		super(number, name, chu, status, date, reason, remark, process, jindu,
				preunder, thisunder, initiator, tel, assetid);
	}

}
