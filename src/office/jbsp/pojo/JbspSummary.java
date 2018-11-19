package office.jbsp.pojo;
// default package



/**
 * JbspSummary entity. @author MyEclipse Persistence Tools
 */
public class JbspSummary extends AbstractJbspSummary implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public JbspSummary() {
    }

    
    /** full constructor */
    public JbspSummary(Integer year, String name, String newnumber, String position, Integer times, Double days, Double didays, String remark) {
        super(year, name, newnumber, position, times, days, didays, remark);        
    }
   
}
