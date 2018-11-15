package office.leave.pojo;
// default package



/**
 * AbstractLeavePage entity provides the base persistence definition of the LeavePage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLeavePage  implements java.io.Serializable {


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
     private Integer dai;
     private Integer chu;
     private Integer tuan;
     private String zhiwu;
     private Integer workage;
     private Integer type;
     private String qita;
     private String begindate;
     private String enddate;
     private Integer halfday;
     private Double days;
     private String xiaojia;
     private String queren;
     private String remark;
     private Integer view;
     private Integer viewpb;
     private Integer viewby;


    // Constructors

    /** default constructor */
    public AbstractLeavePage() {
    }

    
    /** full constructor */
    public AbstractLeavePage(String number, Integer process, String jindu, String date, Integer status, String preundertake, String undertake, String initiator, String applicant, Integer dai, Integer chu, Integer tuan, String zhiwu, Integer workage, Integer type, String qita, String begindate, String enddate, Integer halfday, Double days, String xiaojia, String queren, String remark, Integer view, Integer viewpb, Integer viewby) {
        this.number = number;
        this.process = process;
        this.jindu = jindu;
        this.date = date;
        this.status = status;
        this.preundertake = preundertake;
        this.undertake = undertake;
        this.initiator = initiator;
        this.applicant = applicant;
        this.dai = dai;
        this.chu = chu;
        this.tuan = tuan;
        this.zhiwu = zhiwu;
        this.workage = workage;
        this.type = type;
        this.qita = qita;
        this.begindate = begindate;
        this.enddate = enddate;
        this.halfday = halfday;
        this.days = days;
        this.xiaojia = xiaojia;
        this.queren = queren;
        this.remark = remark;
        this.view = view;
        this.viewpb = viewpb;
        this.viewby = viewby;
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

    public Integer getDai() {
        return this.dai;
    }
    
    public void setDai(Integer dai) {
        this.dai = dai;
    }

    public Integer getChu() {
        return this.chu;
    }
    
    public void setChu(Integer chu) {
        this.chu = chu;
    }

    public Integer getTuan() {
        return this.tuan;
    }
    
    public void setTuan(Integer tuan) {
        this.tuan = tuan;
    }

    public String getZhiwu() {
        return this.zhiwu;
    }
    
    public void setZhiwu(String zhiwu) {
        this.zhiwu = zhiwu;
    }

    public Integer getWorkage() {
        return this.workage;
    }
    
    public void setWorkage(Integer workage) {
        this.workage = workage;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public String getQita() {
        return this.qita;
    }
    
    public void setQita(String qita) {
        this.qita = qita;
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

    public String getXiaojia() {
        return this.xiaojia;
    }
    
    public void setXiaojia(String xiaojia) {
        this.xiaojia = xiaojia;
    }

    public String getQueren() {
        return this.queren;
    }
    
    public void setQueren(String queren) {
        this.queren = queren;
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

    public Integer getViewpb() {
        return this.viewpb;
    }
    
    public void setViewpb(Integer viewpb) {
        this.viewpb = viewpb;
    }

    public Integer getViewby() {
        return this.viewby;
    }
    
    public void setViewby(Integer viewby) {
        this.viewby = viewby;
    }
   








}