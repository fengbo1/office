package office.pb.pojo;
// default package



/**
 * PbMx entity. @author MyEclipse Persistence Tools
 */
public class PbMx extends AbstractPbMx implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public PbMx() {
    }

    
    /** full constructor */
    public PbMx(String month, String date, Integer week, String name, String position, Integer team, Integer plan, Integer teamnum, Integer plannum, Integer plantype, String pbqdtime, String pbqttime, String zytime, String pxtime, Integer wb, String sw, String xw, String tb) {
        super(month, date, week, name, position, team, plan, teamnum, plannum, plantype, pbqdtime, pbqttime, zytime, pxtime, wb, sw, xw, tb);        
    }
   
}
