package office.pb.pojo;
// default package



/**
 * AbstractPbMx entity provides the base persistence definition of the PbMx entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPbMx  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String month;
     private String date;
     private Integer week;
     private String name;
     private String position;
     private Integer team;
     private Integer plan;
     private Integer teamnum;
     private Integer plannum;
     private Integer plantype;
     private String pbqdtime;
     private String pbqttime;
     private String zytime;
     private String pxtime;
     private Integer wb;
     private String sw;
     private String xw;
     private String tb;


    // Constructors

    /** default constructor */
    public AbstractPbMx() {
    }

    
    /** full constructor */
    public AbstractPbMx(String month, String date, Integer week, String name, String position, Integer team, Integer plan, Integer teamnum, Integer plannum, Integer plantype, String pbqdtime, String pbqttime, String zytime, String pxtime, Integer wb, String sw, String xw, String tb) {
        this.month = month;
        this.date = date;
        this.week = week;
        this.name = name;
        this.position = position;
        this.team = team;
        this.plan = plan;
        this.teamnum = teamnum;
        this.plannum = plannum;
        this.plantype = plantype;
        this.pbqdtime = pbqdtime;
        this.pbqttime = pbqttime;
        this.zytime = zytime;
        this.pxtime = pxtime;
        this.wb = wb;
        this.sw = sw;
        this.xw = xw;
        this.tb = tb;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return this.month;
    }
    
    public void setMonth(String month) {
        this.month = month;
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

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getTeam() {
        return this.team;
    }
    
    public void setTeam(Integer team) {
        this.team = team;
    }

    public Integer getPlan() {
        return this.plan;
    }
    
    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public Integer getTeamnum() {
        return this.teamnum;
    }
    
    public void setTeamnum(Integer teamnum) {
        this.teamnum = teamnum;
    }

    public Integer getPlannum() {
        return this.plannum;
    }
    
    public void setPlannum(Integer plannum) {
        this.plannum = plannum;
    }

    public Integer getPlantype() {
        return this.plantype;
    }
    
    public void setPlantype(Integer plantype) {
        this.plantype = plantype;
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

    public Integer getWb() {
        return this.wb;
    }
    
    public void setWb(Integer wb) {
        this.wb = wb;
    }

    public String getSw() {
        return this.sw;
    }
    
    public void setSw(String sw) {
        this.sw = sw;
    }

    public String getXw() {
        return this.xw;
    }
    
    public void setXw(String xw) {
        this.xw = xw;
    }

    public String getTb() {
        return this.tb;
    }
    
    public void setTb(String tb) {
        this.tb = tb;
    }
   








}