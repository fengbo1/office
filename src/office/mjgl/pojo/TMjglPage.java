package office.mjgl.pojo;


/**
 * TMjglPage entity. @author MyEclipse Persistence Tools
 */
public class TMjglPage extends AbstractTMjglPage implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TMjglPage() {
	}

	/** full constructor */
	public TMjglPage(String name, String chu, String currentauth,
			String tempauth, String temptime, Integer currenttime, String remark) {
		super(name, chu, currentauth, tempauth, temptime, currenttime, remark);
	}

}
