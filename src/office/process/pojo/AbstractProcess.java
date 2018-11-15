package office.process.pojo;
// default package



/**
 * AbstractProcess entity provides the base persistence definition of the Process entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractProcess  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String item;
     private Integer applicant;
     private String process;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractProcess() {
    }

    
    /** full constructor */
    public AbstractProcess(String item, Integer applicant, String process, String remark) {
        this.item = item;
        this.applicant = applicant;
        this.process = process;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return this.item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }

    public Integer getApplicant() {
        return this.applicant;
    }
    
    public void setApplicant(Integer applicant) {
        this.applicant = applicant;
    }

    public String getProcess() {
        return this.process;
    }
    
    public void setProcess(String process) {
        this.process = process;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}