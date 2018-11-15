package office.log.pojo;
// default package



/**
 * OperateLog entity. @author MyEclipse Persistence Tools
 */
public class OperateLog extends AbstractOperateLog implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public OperateLog() {
    }

    
    /** full constructor */
    public OperateLog(String time, String name, String newnumber, String item, String operate, String remark) {
        super(time, name, newnumber, item, operate, remark);        
    }
   
}
