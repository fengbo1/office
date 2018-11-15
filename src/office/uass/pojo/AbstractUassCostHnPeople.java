package office.uass.pojo;
// default package



/**
 * AbstractUassCostHnPeople entity provides the base persistence definition of the UassCostHnPeople entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUassCostHnPeople  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private String name;
     private String pool;
     private Integer type891;
     private String item891bf;
     private String item891af;
     private String content891;
     private Integer type890;
     private String item890bf;
     private String item890af;
     private String content890;
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public AbstractUassCostHnPeople() {
    }

    
    /** full constructor */
    public AbstractUassCostHnPeople(String number, String name, String pool, Integer type891, String item891bf, String item891af, String content891, Integer type890, String item890bf, String item890af, String content890, String remark1, String remark2) {
        this.number = number;
        this.name = name;
        this.pool = pool;
        this.type891 = type891;
        this.item891bf = item891bf;
        this.item891af = item891af;
        this.content891 = content891;
        this.type890 = type890;
        this.item890bf = item890bf;
        this.item890af = item890af;
        this.content890 = content890;
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

    public String getPool() {
        return this.pool;
    }
    
    public void setPool(String pool) {
        this.pool = pool;
    }

    public Integer getType891() {
        return this.type891;
    }
    
    public void setType891(Integer type891) {
        this.type891 = type891;
    }

    public String getItem891bf() {
        return this.item891bf;
    }
    
    public void setItem891bf(String item891bf) {
        this.item891bf = item891bf;
    }

    public String getItem891af() {
        return this.item891af;
    }
    
    public void setItem891af(String item891af) {
        this.item891af = item891af;
    }

    public String getContent891() {
        return this.content891;
    }
    
    public void setContent891(String content891) {
        this.content891 = content891;
    }

    public Integer getType890() {
        return this.type890;
    }
    
    public void setType890(Integer type890) {
        this.type890 = type890;
    }

    public String getItem890bf() {
        return this.item890bf;
    }
    
    public void setItem890bf(String item890bf) {
        this.item890bf = item890bf;
    }

    public String getItem890af() {
        return this.item890af;
    }
    
    public void setItem890af(String item890af) {
        this.item890af = item890af;
    }

    public String getContent890() {
        return this.content890;
    }
    
    public void setContent890(String content890) {
        this.content890 = content890;
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