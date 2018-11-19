package office.mjgl.pojo;


/**
 * TMjgl entity. @author MyEclipse Persistence Tools
 */
public class TMjgl extends AbstractTMjgl implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TMjgl() {
	}

	/** full constructor */
	public TMjgl(String number, Integer process, String jindu, String date,
			Integer status, String preunder, String thisunder,
			String initiator, String people, String chu, String zu,
			Integer reason, String oldp, String newp, Integer oldtime,
			Integer newtime, Integer istemp, String startdate, String enddate,
			String tempauth, Integer temptime, String remark1, String remark2,
			String startdateamorpm, String enddateamorpam) {
		super(number, process, jindu, date, status, preunder, thisunder,
				initiator, people, chu, zu, reason, oldp, newp, oldtime,
				newtime, istemp, startdate, enddate, tempauth, temptime,
				remark1, remark2, startdateamorpm, enddateamorpam);
	}

}
