package office.leave.pojo;
// default package



/**
 * AbstractLeaveProcess entity provides the base persistence definition of the LeaveProcess entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLeaveProcess  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private String time;
     private String viewer;
     private String viewernewnumber;
     private String role;
     private String authority;
     private Integer opinion;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractLeaveProcess() {
    }

    
    /** full constructor */
    public AbstractLeaveProcess(String number, String time, String viewer, String viewernewnumber, String role, String authority, Integer opinion, String remark) {
        this.number = number;
        this.time = time;
        this.viewer = viewer;
        this.viewernewnumber = viewernewnumber;
        this.role = role;
        this.authority = authority;
        this.opinion = opinion;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getViewer() {
        return this.viewer;
    }
    
    public void setViewer(String viewer) {
        this.viewer = viewer;
    }

    public String getViewernewnumber() {
        return this.viewernewnumber;
    }
    
    public void setViewernewnumber(String viewernewnumber) {
        this.viewernewnumber = viewernewnumber;
    }

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getOpinion() {
        return this.opinion;
    }
    
    public void setOpinion(Integer opinion) {
        this.opinion = opinion;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}