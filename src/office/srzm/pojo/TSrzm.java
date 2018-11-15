package office.srzm.pojo;


/**
 * TSrzm entity. @author MyEclipse Persistence Tools
 */
public class TSrzm extends AbstractTSrzm implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TSrzm() {
	}

	/** full constructor */
	public TSrzm(String number, Integer process, String jindu, String date,
			Integer status, String preunder, String thisunder,
			String initiator, String applicant, String chu, String zu,
			String tel, String zhiwu, String yongtu, Integer neednumber,
			String todepartment, String remark, String sex) {
		super(number, process, jindu, date, status, preunder, thisunder,
				initiator, applicant, chu, zu, tel, zhiwu, yongtu, neednumber,
				todepartment, remark, sex);
	}

}
