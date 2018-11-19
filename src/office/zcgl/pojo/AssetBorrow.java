package office.zcgl.pojo;

/**
 * AssetBorrow entity. @author MyEclipse Persistence Tools
 */
public class AssetBorrow extends AbstractAssetBorrow implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public AssetBorrow() {
	}

	/** full constructor */
	public AssetBorrow(String number, String name, Integer chu, Integer status,
			String date, String reason, String remark, Integer process,
			String jindu, String preunder, String thisunder, String initiator,
			String returntime, String tel, Integer isreturn,
			Integer isandborrow, String andborrowreturntime) {
		super(number, name, chu, status, date, reason, remark, process, jindu,
				preunder, thisunder, initiator, returntime, tel, isreturn,
				isandborrow, andborrowreturntime);
	}

}
