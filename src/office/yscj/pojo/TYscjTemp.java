package office.yscj.pojo;

/**
 * TYscjTemp entity. @author MyEclipse Persistence Tools
 */
public class TYscjTemp extends AbstractTYscjTemp implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TYscjTemp() {
	}

	/** full constructor */
	public TYscjTemp(String name, String date, String chu, String zhiwu,
			String sex, Integer age, String hukou, String email,
			String contactpeople, String contactpeopletel, Integer category,
			String tocountry, Integer sumday, String begindate, String enddate,
			Integer halfday, Integer reason, String travelagency,
			String invitepeople, String relationship, String invitepeopletel,
			String qitashuoming, String remark, Integer passporttype,
			Integer notholiday, String leavepagenumber, String tel) {
		super(name, date, chu, zhiwu, sex, age, hukou, email, contactpeople,
				contactpeopletel, category, tocountry, sumday, begindate,
				enddate, halfday, reason, travelagency, invitepeople,
				relationship, invitepeopletel, qitashuoming, remark,
				passporttype, notholiday, leavepagenumber, tel);
	}

}
