package office.pb.pojo;
// default package



/**
 * AbstractPbLog entity provides the base persistence definition of the PbLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPbLog  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String date;
     private String time;
     private Integer num;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractPbLog() {
    }

    
    /** full constructor */
    public AbstractPbLog(String name, String date, String time, Integer num, String remark1, String remark2) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.num = num;
        this.remark1 = remark1;
        this.remark2 = remark2;
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

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }
    
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
   








}