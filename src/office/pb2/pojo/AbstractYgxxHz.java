package office.pb2.pojo;
// default package



/**
 * AbstractYgxxHz entity provides the base persistence definition of the YgxxHz entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractYgxxHz  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer year;
     private Integer quarter;
     private Integer times;
     private Double days;
     private Double hours;
     private String chu;


    // Constructors

    /** default constructor */
    public AbstractYgxxHz() {
    }

    
    /** full constructor */
    public AbstractYgxxHz(String name, Integer year, Integer quarter, Integer times, Double days, Double hours, String chu) {
        this.name = name;
        this.year = year;
        this.quarter = quarter;
        this.times = times;
        this.days = days;
        this.hours = hours;
        this.chu = chu;
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

    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuarter() {
        return this.quarter;
    }
    
    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
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

    public Double getHours() {
        return this.hours;
    }
    
    public void setHours(Double hours) {
        this.hours = hours;
    }

    public String getChu() {
        return this.chu;
    }
    
    public void setChu(String chu) {
        this.chu = chu;
    }
   








}