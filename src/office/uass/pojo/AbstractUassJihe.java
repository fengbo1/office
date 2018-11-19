package office.uass.pojo;
// default package



/**
 * AbstractUassJihe entity provides the base persistence definition of the UassJihe entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUassJihe  implements java.io.Serializable {


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
     private String content;
     private String sxtime;
     private String filename1;
     private String filename2;
     private String filename3;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractUassJihe() {
    }

    
    /** full constructor */
    public AbstractUassJihe(String number, Integer process, String jindu, String date, Integer status, String preundertake, String undertake, String initiator, String applicant, String position, String tel, String content, String sxtime, String filename1, String filename2, String filename3, String remark) {
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
        this.content = content;
        this.sxtime = sxtime;
        this.filename1 = filename1;
        this.filename2 = filename2;
        this.filename3 = filename3;
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

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getSxtime() {
        return this.sxtime;
    }
    
    public void setSxtime(String sxtime) {
        this.sxtime = sxtime;
    }

    public String getFilename1() {
        return this.filename1;
    }
    
    public void setFilename1(String filename1) {
        this.filename1 = filename1;
    }

    public String getFilename2() {
        return this.filename2;
    }
    
    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public String getFilename3() {
        return this.filename3;
    }
    
    public void setFilename3(String filename3) {
        this.filename3 = filename3;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}