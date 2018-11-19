package office.jbsp.pojo;
// default package



/**
 * AbstractJbspPageDi entity provides the base persistence definition of the JbspPageDi entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJbspPageDi  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private String name;
     private String begindate;
     private String enddate;
     private Double days;
     private Double jbdays;
     private Double didays;


    // Constructors

    /** default constructor */
    public AbstractJbspPageDi() {
    }

    
    /** full constructor */
    public AbstractJbspPageDi(String number, String name, String begindate, String enddate, Double days, Double jbdays, Double didays) {
        this.number = number;
        this.name = name;
        this.begindate = begindate;
        this.enddate = enddate;
        this.days = days;
        this.jbdays = jbdays;
        this.didays = didays;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getBegindate() {
        return this.begindate;
    }
    
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Double getDays() {
        return this.days;
    }
    
    public void setDays(Double days) {
        this.days = days;
    }

    public Double getJbdays() {
        return this.jbdays;
    }
    
    public void setJbdays(Double jbdays) {
        this.jbdays = jbdays;
    }

    public Double getDidays() {
        return this.didays;
    }
    
    public void setDidays(Double didays) {
        this.didays = didays;
    }
   








}