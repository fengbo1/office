package office.kqjl.pojo;
// default package



/**
 * AbstractYgpbUpload entity provides the base persistence definition of the YgpbUpload entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYgpbUpload  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String date;
     private String pbqdtime;
     private String pbqttime;
     private Integer tb;


    // Constructors

    /** default constructor */
    public AbstractYgpbUpload() {
    }

    
    /** full constructor */
    public AbstractYgpbUpload(String name, String date, String pbqdtime, String pbqttime, Integer tb) {
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