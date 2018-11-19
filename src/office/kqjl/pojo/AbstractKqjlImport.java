package office.kqjl.pojo;
// default package



/**
 * AbstractKqjlImport entity provides the base persistence definition of the KqjlImport entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKqjlImport  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String newnumber;
     private String date;
     private String qdtime;
     private String qttime;


    // Constructors

    /** default constructor */
    public AbstractKqjlImport() {
    }

    
    /** full constructor */
    public AbstractKqjlImport(String name, String newnumber, String date, String qdtime, String qttime) {
        this.name = name;
        this.newnumber = newnumber;
        this.date = date;
        this.qdtime = qdtime;
        this.qttime = qttime;
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

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getQdtime() {
        return this.qdtime;
    }
    
    public void setQdtime(String qdtime) {
        this.qdtime = qdtime;
    }

    public String getQttime() {
        return this.qttime;
    }
    
    public void setQttime(String qttime) {
        this.qttime = qttime;
    }
   








}