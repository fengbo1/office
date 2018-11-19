package office.wcgg.pojo;
// default package



/**
 * AbstractWcggSummary entity provides the base persistence definition of the WcggSummary entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWcggSummary  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String year;
     private String newnumber;
     private String chu;
     private String zu;
     private Integer times;
     private Double days;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractWcggSummary() {
    }

    
    /** full constructor */
    public AbstractWcggSummary(String name, String year, String newnumber, String chu, String zu, Integer times, Double days, String remark) {
        this.name = name;
        this.year = year;
        this.newnumber = newnumber;
        this.chu = chu;
        this.zu = zu;
        this.times = times;
        this.days = days;
        this.remark = remark;
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

    public String getYear() {
        return this.year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getChu() {
        return this.chu;
    }
    
    public void setChu(String chu) {
        this.chu = chu;
    }

    public String getZu() {
        return this.zu;
    }
    
    public void setZu(String zu) {
        this.zu = zu;
    }

    public Integer getTimes() {
        return this.times;
    }
    
    public void setTimes(Integer times) {
        this.times = times;
    }

    public Double getDays() {
        return this.days;
    }
    
    public void setDays(Double days) {
        this.days = days;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}