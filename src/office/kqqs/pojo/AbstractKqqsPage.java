package office.kqqs.pojo;
// default package



/**
 * AbstractKqqsPage entity provides the base persistence definition of the KqqsPage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKqqsPage  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private Integer process;
     private String jindu;
     private String date;
     private Integer status;
     private String preunder;
     private String thisunder;
     private String initiator;
     private String applicant;
     private String chu;
     private String zu;
     private String tel;
     private String reason;
     private String qsdate;
     private Integer qdqt;
     private String qstime;
     private Integer bu;
     private Integer cs;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractKqqsPage() {
    }

    
    /** full constructor */
    public AbstractKqqsPage(String number, Integer process, String jindu, String date, Integer status, String preunder, String thisunder, String initiator, String applicant, String chu, String zu, String tel, String reason, String qsdate, Integer qdqt, String qstime, Integer bu, Integer cs, String remark) {
        this.number = number;
        this.process = process;
        this.jindu = jindu;
        this.date = date;
        this.status = status;
        this.preunder = preunder;
        this.thisunder = thisunder;
        this.initiator = initiator;
        this.applicant = applicant;
        this.chu = chu;
        this.zu = zu;
        this.tel = tel;
        this.reason = reason;
        this.qsdate = qsdate;
        this.qdqt = qdqt;
        this.qstime = qstime;
        this.bu = bu;
        this.cs = cs;
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

    public String getPreunder() {
        return this.preunder;
    }
    
    public void setPreunder(String preunder) {
        this.preunder = preunder;
    }

    public String getThisunder() {
        return this.thisunder;
    }
    
    public void setThisunder(String thisunder) {
        this.thisunder = thisunder;
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

    public String getChu() {
        return this.chu;
    }
    
    public void setChu(String chu) {
        this.chu = chu;
    }

    public String getZu() {
        return this.zu;
    }
    
    public void setZu(String zu) {
        this.zu = zu;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getQsdate() {
        return this.qsdate;
    }
    
    public void setQsdate(String qsdate) {
        this.qsdate = qsdate;
    }

    public Integer getQdqt() {
        return this.qdqt;
    }
    
    public void setQdqt(Integer qdqt) {
        this.qdqt = qdqt;
    }

    public String getQstime() {
        return this.qstime;
    }
    
    public void setQstime(String qstime) {
        this.qstime = qstime;
    }

    public Integer getBu() {
        return this.bu;
    }
    
    public void setBu(Integer bu) {
        this.bu = bu;
    }

    public Integer getCs() {
        return this.cs;
    }
    
    public void setCs(Integer cs) {
        this.cs = cs;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}