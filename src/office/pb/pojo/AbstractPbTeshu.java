package office.pb.pojo;
// default package



/**
 * AbstractPbTeshu entity provides the base persistence definition of the PbTeshu entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPbTeshu  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer item;
     private String yxbegin;
     private String yxend;


    // Constructors

    /** default constructor */
    public AbstractPbTeshu() {
    }

    
    /** full constructor */
    public AbstractPbTeshu(String name, Integer item, String yxbegin, String yxend) {
        this.name = name;
        this.item = item;
        this.yxbegin = yxbegin;
        this.yxend = yxend;
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

    public Integer getItem() {
        return this.item;
    }
    
    public void setItem(Integer item) {
        this.item = item;
    }

    public String getYxbegin() {
        return this.yxbegin;
    }
    
    public void setYxbegin(String yxbegin) {
        this.yxbegin = yxbegin;
    }

    public String getYxend() {
        return this.yxend;
    }
    
    public void setYxend(String yxend) {
        this.yxend = yxend;
    }
   








}