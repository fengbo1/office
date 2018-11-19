package office.uass.pojo;
// default package



/**
 * AbstractUassPtPeople entity provides the base persistence definition of the UassPtPeople entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUassPtPeople  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private String name;
     private String item;
     private String content;


    // Constructors

    /** default constructor */
    public AbstractUassPtPeople() {
    }

    
    /** full constructor */
    public AbstractUassPtPeople(String number, String name, String item, String content) {
        this.number = number;
        this.name = name;
        this.item = item;
        this.content = content;
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

    public String getItem() {
        return this.item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   








}