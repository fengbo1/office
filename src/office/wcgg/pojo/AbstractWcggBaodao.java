package office.wcgg.pojo;
// default package



/**
 * AbstractWcggBaodao entity provides the base persistence definition of the WcggBaodao entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWcggBaodao  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private String name;
     private String newnumber;
     private String begindate;
     private String baodaodate;
     private Integer bghalfday;
     private Integer bdhalfday;
     private Double sumday;
     private Integer status;


    // Constructors

    /** default constructor */
    public AbstractWcggBaodao() {
    }

    
    /** full constructor */
    public AbstractWcggBaodao(String number, String name, String newnumber, String begindate, String baodaodate, Integer bghalfday, Integer bdhalfday, Double sumday, Integer status) {
        this.number = number;
        this.name = name;
        this.newnumber = newnumber;
        this.begindate = begindate;
        this.baodaodate = baodaodate;
        this.bghalfday = bghalfday;
        this.bdhalfday = bdhalfday;
        this.sumday = sumday;
        this.status = status;
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

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getBegindate() {
        return this.begindate;
    }
    
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getBaodaodate() {
        return this.baodaodate;
    }
    
    public void setBaodaodate(String baodaodate) {
        this.baodaodate = baodaodate;
    }

    public Integer getBghalfday() {
        return this.bghalfday;
    }
    
    public void setBghalfday(Integer bghalfday) {
        this.bghalfday = bghalfday;
    }

    public Integer getBdhalfday() {
        return this.bdhalfday;
    }
    
    public void setBdhalfday(Integer bdhalfday) {
        this.bdhalfday = bdhalfday;
    }

    public Double getSumday() {
        return this.sumday;
    }
    
    public void setSumday(Double sumday) {
        this.sumday = sumday;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
   








}