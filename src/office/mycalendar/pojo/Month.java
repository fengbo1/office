package office.mycalendar.pojo;
// default package



/**
 * Month entity. @author MyEclipse Persistence Tools
 */
public class Month extends AbstractMonth implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Month() {
    }

    
    /** full constructor */
    public Month(Integer year, Integer month, Integer sczhi, Integer workdays) {
        super(year, month, sczhi, workdays);        
    }
   
}
