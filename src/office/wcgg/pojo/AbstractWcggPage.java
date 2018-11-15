package office.wcgg.pojo;
// default package



/**
 * AbstractWcggPage entity provides the base persistence definition of the WcggPage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWcggPage  implements java.io.Serializable {


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
     private String people;
     private String chu;
     private String zu;
     private String tel;
     private String reason;
     private String addr;
     private String begindate;
     private String enddate;
     private Integer halfday;
     private Double days;
     private Integer view;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractWcggPage() {
    }

    
    /** full constructor */
    public AbstractWcggPage(String number, Integer process, String jindu, String date, Integer status, String preunder, String thisunder, String initiator, String applicant, String people, String chu, String zu, String tel, String reason, String addr, String begindate, String enddate, Integer halfday, Double days, Integer view, String remark) {
        this.number = number;
        this.process = process;
        this.jindu = jindu;
        this.date = date;
        this.status = status;
        this.preunder = preunder;
        this.thisunder = thisunder;
        this.initiator = initiator;
        this.applicant = applicant;
        this.people = people;
        this.chu = chu;
        this.zu = zu;
        this.tel = tel;
        this.reason = reason;
        this.addr = addr;
        this.begindate = begindate;
        this.enddate = enddate;
        this.halfday = halfday;
        this.days = days;
        this.view = view;
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

    public String getPeople() {
        return this.people;
    }
    
    public void setPeople(String people) {
        this.people = people;
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

    public String getAddr() {
        return this.addr;
    }
    
    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getBegindate() {
        return this.begindate;
    }
    
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getHalfday() {
        return this.halfday;
    }
    
    public void setHalfday(Integer halfday) {
        this.halfday = halfday;
    }

    public Double getDays() {
        return this.days;
    }
    
    public void setDays(Double days) {
        this.days = days;
    }

    public Integer getView() {
        return this.view;
    }
    
    public void setView(Integer view) {
        this.view = view;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}