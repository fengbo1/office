package office.pb.pojo;
// default package



/**
 * AbstractScpbTeam entity provides the base persistence definition of the ScpbTeam entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScpbTeam  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer no;
     private Integer num;
     private String leader;
     private String member;


    // Constructors

    /** default constructor */
    public AbstractScpbTeam() {
    }

    
    /** full constructor */
    public AbstractScpbTeam(Integer no, Integer num, String leader, String member) {
        this.no = no;
        this.num = num;
        this.leader = leader;
        this.member = member;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return this.no;
    }
    
    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public String getLeader() {
        return this.leader;
    }
    
    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getMember() {
        return this.member;
    }
    
    public void setMember(String member) {
        this.member = member;
    }
   








}