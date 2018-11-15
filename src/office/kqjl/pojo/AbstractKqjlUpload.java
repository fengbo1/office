package office.kqjl.pojo;
// default package



/**
 * AbstractKqjlUpload entity provides the base persistence definition of the KqjlUpload entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKqjlUpload  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String month;
     private Integer scpb;
     private Integer xypb;
     private Integer zwjl;
     private Integer scpby;
     private Integer kqjl1;
     private Integer kqjl2;
     private Integer kqjl3;
     private Integer kqjl4;
     private Integer ifkqqsdisabled;


    // Constructors

    /** default constructor */
    public AbstractKqjlUpload() {
    }

    
    /** full constructor */
    public AbstractKqjlUpload(String month, Integer scpb, Integer xypb, Integer zwjl, Integer scpby, Integer kqjl1, Integer kqjl2, Integer kqjl3, Integer kqjl4, Integer ifkqqsdisabled) {
        this.month = month;
        this.scpb = scpb;
        this.xypb = xypb;
        this.zwjl = zwjl;
        this.scpby = scpby;
        this.kqjl1 = kqjl1;
        this.kqjl2 = kqjl2;
        this.kqjl3 = kqjl3;
        this.kqjl4 = kqjl4;
        this.ifkqqsdisabled = ifkqqsdisabled;
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

    public Integer getScpb() {
        return this.scpb;
    }
    
    public void setScpb(Integer scpb) {
        this.scpb = scpb;
    }

    public Integer getXypb() {
        return this.xypb;
    }
    
    public void setXypb(Integer xypb) {
        this.xypb = xypb;
    }

    public Integer getZwjl() {
        return this.zwjl;
    }
    
    public void setZwjl(Integer zwjl) {
        this.zwjl = zwjl;
    }

    public Integer getScpby() {
        return this.scpby;
    }
    
    public void setScpby(Integer scpby) {
        this.scpby = scpby;
    }

    public Integer getKqjl1() {
        return this.kqjl1;
    }
    
    public void setKqjl1(Integer kqjl1) {
        this.kqjl1 = kqjl1;
    }

    public Integer getKqjl2() {
        return this.kqjl2;
    }
    
    public void setKqjl2(Integer kqjl2) {
        this.kqjl2 = kqjl2;
    }

    public Integer getKqjl3() {
        return this.kqjl3;
    }
    
    public void setKqjl3(Integer kqjl3) {
        this.kqjl3 = kqjl3;
    }

    public Integer getKqjl4() {
        return this.kqjl4;
    }
    
    public void setKqjl4(Integer kqjl4) {
        this.kqjl4 = kqjl4;
    }

    public Integer getIfkqqsdisabled() {
        return this.ifkqqsdisabled;
    }
    
    public void setIfkqqsdisabled(Integer ifkqqsdisabled) {
        this.ifkqqsdisabled = ifkqqsdisabled;
    }
   








}