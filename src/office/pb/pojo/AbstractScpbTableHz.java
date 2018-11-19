package office.pb.pojo;
// default package



/**
 * AbstractScpbTableHz entity provides the base persistence definition of the ScpbTableHz entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScpbTableHz  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private Integer teamno;
     private Integer planno;


    // Constructors

    /** default constructor */
    public AbstractScpbTableHz() {
    }

    
    /** full constructor */
    public AbstractScpbTableHz(String date, Integer teamno, Integer planno) {
        this.date = date;
        this.teamno = teamno;
        this.planno = planno;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTeamno() {
        return this.teamno;
    }
    
    public void setTeamno(Integer teamno) {
        this.teamno = teamno;
    }

    public Integer getPlanno() {
        return this.planno;
    }
    
    public void setPlanno(Integer planno) {
        this.planno = planno;
    }
   








}