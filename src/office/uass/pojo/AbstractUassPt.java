package office.uass.pojo;
// default package



/**
 * AbstractUassPt entity provides the base persistence definition of the UassPt entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUassPt  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private Integer process;
     private String jindu;
     private String date;
     private Integer status;
     private String preundertake;
     private String undertake;
     private String initiator;
     private String applicant;
     private String position;
     private String tel;
     private String sxtime;
     private String filename;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractUassPt() {
    }

    
    /** full constructor */
    public AbstractUassPt(String number, Integer process, String jindu, String date, Integer status, String preundertake, String undertake, String initiator, String applicant, String position, String tel, String sxtime, String filename, String remark) {
        this.number = number;
        this.process = process;
        this.jindu = jindu;
        this.date = date;
        this.status = status;
        this.preundertake = preundertake;
        this.undertake = undertake;
        this.initiator = initiator;
        this.applicant = applicant;
        this.position = position;
        this.tel = tel;
        this.sxtime = sxtime;
        this.filename = filename;
        this.remark = remark;
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

    public Integer getProcess() {
        return this.process;
    }
    
    public void setProcess(Integer process) {
        this.process = process;
    }

    public String getJindu() {
        return this.jindu;
    }
    
    public void setJindu(String jindu) {
        this.jindu = jindu;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPreundertake() {
        return this.preundertake;
    }
    
    public void setPreundertake(String preundertake) {
        this.preundertake = preundertake;
    }

    public String getUndertake() {
        return this.undertake;
    }
    
    public void setUndertake(String undertake) {
        this.undertake = undertake;
    }

    public String getInitiator() {
        return this.initiator;
    }
    
    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getApplicant() {
        return this.applicant;
    }
    
    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSxtime() {
        return this.sxtime;
    }
    
    public void setSxtime(String sxtime) {
        this.sxtime = sxtime;
    }

    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}