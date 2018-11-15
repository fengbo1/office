package office.log.pojo;
// default package



/**
 * AbstractOperateLog entity provides the base persistence definition of the OperateLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOperateLog  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String time;
     private String name;
     private String newnumber;
     private String item;
     private String operate;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractOperateLog() {
    }

    
    /** full constructor */
    public AbstractOperateLog(String time, String name, String newnumber, String item, String operate, String remark) {
        this.time = time;
        this.name = name;
        this.newnumber = newnumber;
        this.item = item;
        this.operate = operate;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
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

    public String getItem() {
        return this.item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }

    public String getOperate() {
        return this.operate;
    }
    
    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}