package office.pb.pojo;
// default package



/**
 * ScpbPlan entity. @author MyEclipse Persistence Tools
 */
public class ScpbPlan extends AbstractScpbPlan implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public ScpbPlan() {
    }

    
    /** full constructor */
    public ScpbPlan(Integer no, Integer num, String sbtime, String xbtime, String zytime, String pxtime, Integer type) {
        super(no, num, sbtime, xbtime, zytime, pxtime, type);        
    }
   
}
