package office.pb.pojo;
// default package



/**
 * AbstractPbRemark entity provides the base persistence definition of the PbRemark entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPbRemark  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String month;
     private Integer type;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractPbRemark() {
    }

    
    /** full constructor */
    public AbstractPbRemark(String month, Integer type, String remark) {
        this.month = month;
        this.type = type;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return this.month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}