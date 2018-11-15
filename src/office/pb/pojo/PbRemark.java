package office.pb.pojo;
// default package



/**
 * PbRemark entity. @author MyEclipse Persistence Tools
 */
public class PbRemark extends AbstractPbRemark implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public PbRemark() {
    }

    
    /** full constructor */
    public PbRemark(String month, Integer type, String remark) {
        super(month, type, remark);        
    }
   
}
