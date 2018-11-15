package office.yscj.pojo;

/**
 * TYscjtz entity. @author MyEclipse Persistence Tools
 */
public class TYscjtz extends AbstractTYscjtz implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TYscjtz() {
	}

	/** full constructor */
	public TYscjtz(String number, String newnumber, String reason,
			String bringtime, String returntime, Double sumday,
			String begindate, String enddate, String passporttype,
			String passportnumber, String tocountry, String date,
			Integer status, String name) {
		super(number, newnumber, reason, bringtime, returntime, sumday,
				begindate, enddate, passporttype, passportnumber, tocountry,
				date, status, name);
	}

}
