package office.uass.pojo;
// default package



/**
 * AbstractUassCode entity provides the base persistence definition of the UassCode entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUassCode  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String pool;
     private Integer paixu;
     private String code;
     private String detail;


    // Constructors

    /** default constructor */
    public AbstractUassCode() {
    }

    
    /** full constructor */
    public AbstractUassCode(String pool, Integer paixu, String code, String detail) {
        this.pool = pool;
        this.paixu = paixu;
        this.code = code;
        this.detail = detail;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPool() {
        return this.pool;
    }
    
    public void setPool(String pool) {
        this.pool = pool;
    }

    public Integer getPaixu() {
        return this.paixu;
    }
    
    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
   








}