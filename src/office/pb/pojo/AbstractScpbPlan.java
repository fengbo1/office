package office.pb.pojo;
// default package



/**
 * AbstractScpbPlan entity provides the base persistence definition of the ScpbPlan entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScpbPlan  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer no;
     private Integer num;
     private String sbtime;
     private String xbtime;
     private String zytime;
     private String pxtime;
     private Integer type;


    // Constructors

    /** default constructor */
    public AbstractScpbPlan() {
    }

    
    /** full constructor */
    public AbstractScpbPlan(Integer no, Integer num, String sbtime, String xbtime, String zytime, String pxtime, Integer type) {
        this.no = no;
        this.num = num;
        this.sbtime = sbtime;
        this.xbtime = xbtime;
        this.zytime = zytime;
        this.pxtime = pxtime;
        this.type = type;
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

    public String getPxtime() {
        return this.pxtime;
    }
    
    public void setPxtime(String pxtime) {
        this.pxtime = pxtime;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
   








}