package office.pb2.pojo;
// default package



/**
 * AbstractTbsqPage entity provides the base persistence definition of the TbsqPage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTbsqPage  implements java.io.Serializable {


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
     private String tbdate;
     private String tbname;
     private String reason;
     private String prejihua;
     private String nowjihua;
     private String remark;
     private Integer pretype;
     private Integer nowtype;


    // Constructors

    /** default constructor */
    public AbstractTbsqPage() {
    }

    
    /** full constructor */
    public AbstractTbsqPage(String number, Integer process, String jindu, String date, Integer status, String preundertake, String undertake, String initiator, String applicant, String tbdate, String tbname, String reason, String prejihua, String nowjihua, String remark, Integer pretype, Integer nowtype) {
        this.number = number;
        this.process = process;
        this.jindu = jindu;
        this.date = date;
        this.status = status;
        this.preundertake = preundertake;
        this.undertake = undertake;
        this.initiator = initiator;
        this.applicant = applicant;
        this.tbdate = tbdate;
        this.tbname = tbname;
        this.reason = reason;
        this.prejihua = prejihua;
        this.nowjihua = nowjihua;
        this.remark = remark;
        this.pretype = pretype;
        this.nowtype = nowtype;
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

    public String getTbdate() {
        return this.tbdate;
    }
    
    public void setTbdate(String tbdate) {
        this.tbdate = tbdate;
    }

    public String getTbname() {
        return this.tbname;
    }
    
    public void setTbname(String tbname) {
        this.tbname = tbname;
    }

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPrejihua() {
        return this.prejihua;
    }
    
    public void setPrejihua(String prejihua) {
        this.prejihua = prejihua;
    }

    public String getNowjihua() {
        return this.nowjihua;
    }
    
    public void setNowjihua(String nowjihua) {
        this.nowjihua = nowjihua;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPretype() {
        return this.pretype;
    }
    
    public void setPretype(Integer pretype) {
        this.pretype = pretype;
    }

    public Integer getNowtype() {
        return this.nowtype;
    }
    
    public void setNowtype(Integer nowtype) {
        this.nowtype = nowtype;
    }
   








}