package office.yscj.pojo;

/**
 * TYscj entity. @author MyEclipse Persistence Tools
 */
public class TYscj extends AbstractTYscj implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TYscj() {
	}

	/** full constructor */
	public TYscj(String number, Integer process, String jindu, String date,
			Integer status, String preunder, String thisunder,
			String initiator, String applicant, String chu, String zu,
			String tel, String zhiwu, String sex, Integer age, String hukou,
			String email, String contactpeople, String contactpeopletel,
			Integer category, String tocountry, Double sumday,
			String begindate, String enddate, Integer halfday, Integer reason,
			String travelagency, String invitepeople, String relationship,
			String invitepeopletel, String qitashuoming, String remark,
			Integer passporttype, Integer notholiday, String leavepagenumber,
			String leaveremark) {
		super(number, process, jindu, date, status, preunder, thisunder,
				initiator, applicant, chu, zu, tel, zhiwu, sex, age, hukou,
				email, contactpeople, contactpeopletel, category, tocountry,
				sumday, begindate, enddate, halfday, reason, travelagency,
				invitepeople, relationship, invitepeopletel, qitashuoming,
				remark, passporttype, notholiday, leavepagenumber, leaveremark);
	}

}
