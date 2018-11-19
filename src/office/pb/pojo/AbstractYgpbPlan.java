package office.pb.pojo;
// default package



/**
 * AbstractYgpbPlan entity provides the base persistence definition of the YgpbPlan entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYgpbPlan  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer no;
     private String sbtime;
     private String xbtime;
     private String zytime;


    // Constructors

    /** default constructor */
    public AbstractYgpbPlan() {
    }

    
    /** full constructor */
    public AbstractYgpbPlan(Integer no, String sbtime, String xbtime, String zytime) {
        this.no = no;
        this.sbtime = sbtime;
        this.xbtime = xbtime;
        this.zytime = zytime;
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

    public String getSbtime() {
        return this.sbtime;
    }
    
    public void setSbtime(String sbtime) {
        this.sbtime = sbtime;
    }

    public String getXbtime() {
        return this.xbtime;
    }
    
    public void setXbtime(String xbtime) {
        this.xbtime = xbtime;
    }

    public String getZytime() {
        return this.zytime;
    }
    
    public void setZytime(String zytime) {
        this.zytime = zytime;
    }
   








}