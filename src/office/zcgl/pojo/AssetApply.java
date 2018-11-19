package office.zcgl.pojo;


/**
 * AssetApply entity. @author MyEclipse Persistence Tools
 */
public class AssetApply extends AbstractAssetApply implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public AssetApply() {
	}

	/** full constructor */
	public AssetApply(String number, String name, Integer chu, Integer status,
			String date, String reason, String remark, Integer process,
			String jindu, String preunder, String thisunder, String initiator,
			String tel) {
		super(number, name, chu, status, date, reason, remark, process, jindu,
				preunder, thisunder, initiator, tel);
	}

}
