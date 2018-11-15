package office.leave.pojo;
// default package



/**
 * LeaveProcess entity. @author MyEclipse Persistence Tools
 */
public class LeaveProcess extends AbstractLeaveProcess implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public LeaveProcess() {
    }

    
    /** full constructor */
    public LeaveProcess(String number, String time, String viewer, String viewernewnumber, String role, String authority, Integer opinion, String remark) {
        super(number, time, viewer, viewernewnumber, role, authority, opinion, remark);        
    }
   
}
