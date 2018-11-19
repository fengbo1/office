package office.pb2.pojo;
// default package



/**
 * AbstractXxsqPage entity provides the base persistence definition of the XxsqPage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractXxsqPage  implements java.io.Serializable {


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
     private String people;
     private String tel;
     private String begindate;
     private String enddate;
     private Integer halfday;
     private Double day;
     private Double hour;
     private Integer type;
     private Integer reason;
     private String qita;
     private String remark;
     private Integer view;
     private String chu;


    // Constructors

    /** default constructor */
    public AbstractXxsqPage() {
    }

    
    /** full constructor */
    public AbstractXxsqPage(String number, Integer process, String jindu, String date, Integer status, String preundertake, String undertake, String initiator, String applicant, String people, String tel, String begindate, String enddate, Integer halfday, Double day, Double hour, Integer type, Integer reason, String qita, String remark, Integer view, String chu) {
        this.number = number;
        this.process = process;
        this.jindu = jindu;
        this.date = date;
        this.status = status;
        this.preundertake = preundertake;
        this.undertake = undertake;
        this.initiator = initiator;
        this.applicant = applicant;
        this.people = people;
        this.tel = tel;
        this.begindate = begindate;
        this.enddate = enddate;
        this.halfday = halfday;
        this.day = day;
        this.hour = hour;
        this.type = type;
        this.reason = reason;
        this.qita = qita;
        this.remark = remark;
        this.view = view;
        this.chu = chu;
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

    public String getPeople() {
        return this.people;
    }
    
    public void setPeople(String people) {
        this.people = people;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
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

    public Double getDay() {
        return this.day;
    }
    
    public void setDay(Double day) {
        this.day = day;
    }

    public Double getHour() {
        return this.hour;
    }
    
    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getReason() {
        return this.reason;
    }
    
    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public String getQita() {
        return this.qita;
    }
    
    public void setQita(String qita) {
        this.qita = qita;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getView() {
        return this.view;
    }
    
    public void setView(Integer view) {
        this.view = view;
    }

    public String getChu() {
        return this.chu;
    }
    
    public void setChu(String chu) {
        this.chu = chu;
    }
   








}