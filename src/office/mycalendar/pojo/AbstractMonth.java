package office.mycalendar.pojo;
// default package



/**
 * AbstractMonth entity provides the base persistence definition of the Month entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMonth  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer year;
     private Integer month;
     private Integer sczhi;
     private Integer workdays;


    // Constructors

    /** default constructor */
    public AbstractMonth() {
    }

    
    /** full constructor */
    public AbstractMonth(Integer year, Integer month, Integer sczhi, Integer workdays) {
        this.year = year;
        this.month = month;
        this.sczhi = sczhi;
        this.workdays = workdays;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return this.month;
    }
    
    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getSczhi() {
        return this.sczhi;
    }
    
    public void setSczhi(Integer sczhi) {
        this.sczhi = sczhi;
    }

    public Integer getWorkdays() {
        return this.workdays;
    }
    
    public void setWorkdays(Integer workdays) {
        this.workdays = workdays;
    }
   








}