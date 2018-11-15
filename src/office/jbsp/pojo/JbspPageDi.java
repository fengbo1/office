package office.jbsp.pojo;
// default package



/**
 * JbspPageDi entity. @author MyEclipse Persistence Tools
 */
public class JbspPageDi extends AbstractJbspPageDi implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public JbspPageDi() {
    }

    
    /** full constructor */
    public JbspPageDi(String number, String name, String begindate, String enddate, Double days, Double jbdays, Double didays) {
        super(number, name, begindate, enddate, days, jbdays, didays);        
    }
   
}
