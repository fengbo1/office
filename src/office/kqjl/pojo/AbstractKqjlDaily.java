package office.kqjl.pojo;
// default package



/**
 * AbstractKqjlDaily entity provides the base persistence definition of the KqjlDaily entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKqjlDaily  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private Integer week;
     private String name;
     private String newnumber;
     private String position;
     private String pbqdtime;
     private String pbqttime;
     private String qdtime;
     private String qttime;
     private Integer qdqs;
     private Integer qtqs;
     private Integer qj;
     private Integer gg;
     private Integer jb;
     private Integer halfday;
     private Integer tb;
     private Integer pb;
     private Integer yc;
     private Integer yy;


    // Constructors

    /** default constructor */
    public AbstractKqjlDaily() {
    }

    
    /** full constructor */
    public AbstractKqjlDaily(String date, Integer week, String name, String newnumber, String position, String pbqdtime, String pbqttime, String qdtime, String qttime, Integer qdqs, Integer qtqs, Integer qj, Integer gg, Integer jb, Integer halfday, Integer tb, Integer pb, Integer yc, Integer yy) {
        this.date = date;
        this.week = week;
        this.name = name;
        this.newnumber = newnumber;
        this.position = position;
        this.pbqdtime = pbqdtime;
        this.pbqttime = pbqttime;
        this.qdtime = qdtime;
        this.qttime = qttime;
        this.qdqs = qdqs;
        this.qtqs = qtqs;
        this.qj = qj;
        this.gg = gg;
        this.jb = jb;
        this.halfday = halfday;
        this.tb = tb;
        this.pb = pb;
        this.yc = yc;
        this.yy = yy;
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

    public Integer getWeek() {
        return this.week;
    }
    
    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
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

    public String getQdtime() {
        return this.qdtime;
    }
    
    public void setQdtime(String qdtime) {
        this.qdtime = qdtime;
    }

    public String getQttime() {
        return this.qttime;
    }
    
    public void setQttime(String qttime) {
        this.qttime = qttime;
    }

    public Integer getQdqs() {
        return this.qdqs;
    }
    
    public void setQdqs(Integer qdqs) {
        this.qdqs = qdqs;
    }

    public Integer getQtqs() {
        return this.qtqs;
    }
    
    public void setQtqs(Integer qtqs) {
        this.qtqs = qtqs;
    }

    public Integer getQj() {
        return this.qj;
    }
    
    public void setQj(Integer qj) {
        this.qj = qj;
    }

    public Integer getGg() {
        return this.gg;
    }
    
    public void setGg(Integer gg) {
        this.gg = gg;
    }

    public Integer getJb() {
        return this.jb;
    }
    
    public void setJb(Integer jb) {
        this.jb = jb;
    }

    public Integer getHalfday() {
        return this.halfday;
    }
    
    public void setHalfday(Integer halfday) {
        this.halfday = halfday;
    }

    public Integer getTb() {
        return this.tb;
    }
    
    public void setTb(Integer tb) {
        this.tb = tb;
    }

    public Integer getPb() {
        return this.pb;
    }
    
    public void setPb(Integer pb) {
        this.pb = pb;
    }

    public Integer getYc() {
        return this.yc;
    }
    
    public void setYc(Integer yc) {
        this.yc = yc;
    }

    public Integer getYy() {
        return this.yy;
    }
    
    public void setYy(Integer yy) {
        this.yy = yy;
    }
   








}