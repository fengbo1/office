package office.config.pojo;
// default package



/**
 * AbstractConfig entity provides the base persistence definition of the Config entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractConfig  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer value;
     private String strvalue;


    // Constructors

    /** default constructor */
    public AbstractConfig() {
    }

    
    /** full constructor */
    public AbstractConfig(String name, Integer value, String strvalue) {
        this.name = name;
        this.value = value;
        this.strvalue = strvalue;
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

    public Integer getValue() {
        return this.value;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }

    public String getStrvalue() {
        return this.strvalue;
    }
    
    public void setStrvalue(String strvalue) {
        this.strvalue = strvalue;
    }
   








}