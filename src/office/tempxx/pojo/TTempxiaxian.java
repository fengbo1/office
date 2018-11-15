package office.tempxx.pojo;

/**
 * TTempxiaxian entity. @author MyEclipse Persistence Tools
 */
public class TTempxiaxian extends AbstractTTempxiaxian implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TTempxiaxian() {
	}

	/** full constructor */
	public TTempxiaxian(String chu, String opzu, String name, String opnumber,
			String zu, String reason, String shuoming, String begindate,
			String enddate, String reportdate, String remark, String paiban,
			String xiaxiantime, String relatednumber, String isred) {
		super(chu, opzu, name, opnumber, zu, reason, shuoming, begindate,
				enddate, reportdate, remark, paiban, xiaxiantime,
				relatednumber, isred);
	}

}
