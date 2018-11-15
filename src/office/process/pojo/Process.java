package office.process.pojo;
// default package



/**
 * Process entity. @author MyEclipse Persistence Tools
 */
public class Process extends AbstractProcess implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Process() {
    }

    
    /** full constructor */
    public Process(String item, Integer applicant, String process, String remark) {
        super(item, applicant, process, remark);        
    }
   
}
