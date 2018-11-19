package office.wcgg.pojo;
// default package



/**
 * WcggSummary entity. @author MyEclipse Persistence Tools
 */
public class WcggSummary extends AbstractWcggSummary implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WcggSummary() {
    }

    
    /** full constructor */
    public WcggSummary(String name, String year, String newnumber, String chu, String zu, Integer times, Double days, String remark) {
        super(name, year, newnumber, chu, zu, times, days, remark);        
    }
   
}
