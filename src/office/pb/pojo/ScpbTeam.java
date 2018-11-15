package office.pb.pojo;
// default package



/**
 * ScpbTeam entity. @author MyEclipse Persistence Tools
 */
public class ScpbTeam extends AbstractScpbTeam implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public ScpbTeam() {
    }

    
    /** full constructor */
    public ScpbTeam(Integer no, Integer num, String leader, String member) {
        super(no, num, leader, member);        
    }
   
}
