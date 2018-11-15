package office.pb.pojo;
// default package



/**
 * PbLog entity. @author MyEclipse Persistence Tools
 */
public class PbLog extends AbstractPbLog implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public PbLog() {
    }

    
    /** full constructor */
    public PbLog(String name, String date, String time, Integer num, String remark1, String remark2) {
        super(name, date, time, num, remark1, remark2);        
    }
   
}
