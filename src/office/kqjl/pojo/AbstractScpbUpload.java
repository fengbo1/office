package office.kqjl.pojo;
// default package



/**
 * AbstractScpbUpload entity provides the base persistence definition of the ScpbUpload entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScpbUpload  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String date;
     private String pbqdtime;
     private String pbqttime;
     private Integer tb;


    // Constructors

    /** default constructor */
    public AbstractScpbUpload() {
    }

    
    /** full constructor */
    public AbstractScpbUpload(String name, String date, String pbqdtime, String pbqttime, Integer tb) {
        this.name = name;
        this.date = date;
        this.pbqdtime = pbqdtime;
        this.pbqttime = pbqttime;
        this.tb = tb;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getPbqdtime() {
        return this.pbqdtime;
    }
    
    public void setPbqdtime(String pbqdtime) {
        this.pbqdtime = pbqdtime;
    }

    public String getPbqttime() {
        return this.pbqttime;
    }
    
    public void setPbqttime(String pbqttime) {
        this.pbqttime = pbqttime;
    }

    public Integer getTb() {
        return this.tb;
    }
    
    public void setTb(Integer tb) {
        this.tb = tb;
    }
   








}