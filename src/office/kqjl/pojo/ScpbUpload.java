package office.kqjl.pojo;
// default package



/**
 * ScpbUpload entity. @author MyEclipse Persistence Tools
 */
public class ScpbUpload extends AbstractScpbUpload implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public ScpbUpload() {
    }

    
    /** full constructor */
    public ScpbUpload(String name, String date, String pbqdtime, String pbqttime, Integer tb) {
        super(name, date, pbqdtime, pbqttime, tb);        
    }
   
}
