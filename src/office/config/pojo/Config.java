package office.config.pojo;
// default package



/**
 * Config entity. @author MyEclipse Persistence Tools
 */
public class Config extends AbstractConfig implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Config() {
    }

    
    /** full constructor */
    public Config(String name, Integer value, String strvalue) {
        super(name, value, strvalue);        
    }
   
}
