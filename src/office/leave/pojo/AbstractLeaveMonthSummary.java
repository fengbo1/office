package office.leave.pojo;
// default package



/**
 * AbstractLeaveMonthSummary entity provides the base persistence definition of the LeaveMonthSummary entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLeaveMonthSummary  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer year;
     private Integer month;
     private String name;
     private String newnumber;
     private Double yearleave;
     private Double workleave;
     private Double bingleave;
     private Double shileave;
     private Double hunleave;
     private Double chanleave;
     private Double tanpoleave;
     private Double tanfmleave;
     private Double sangleave;
     private Double shangleave;
     private Double gongleave;
     private Double qitaleave;
     private Double peikaoleave;
     private Double buruleave;
     private Double sumleave;
     private Double sumwork;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractLeaveMonthSummary() {
    }

    
    /** full constructor */
    public AbstractLeaveMonthSummary(Integer year, Integer month, String name, String newnumber, Double yearleave, Double workleave, Double bingleave, Double shileave, Double hunleave, Double chanleave, Double tanpoleave, Double tanfmleave, Double sangleave, Double shangleave, Double gongleave, Double qitaleave, Double peikaoleave, Double buruleave, Double sumleave, Double sumwork, String remark) {
        this.year = year;
        this.month = month;
        this.name = name;
        this.newnumber = newnumber;
        this.yearleave = yearleave;
        this.workleave = workleave;
        this.bingleave = bingleave;
        this.shileave = shileave;
        this.hunleave = hunleave;
        this.chanleave = chanleave;
        this.tanpoleave = tanpoleave;
        this.tanfmleave = tanfmleave;
        this.sangleave = sangleave;
        this.shangleave = shangleave;
        this.gongleave = gongleave;
        this.qitaleave = qitaleave;
        this.peikaoleave = peikaoleave;
        this.buruleave = buruleave;
        this.sumleave = sumleave;
        this.sumwork = sumwork;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return this.month;
    }
    
    public void setMonth(Integer month) {
        this.month = month;
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

    public Double getYearleave() {
        return this.yearleave;
    }
    
    public void setYearleave(Double yearleave) {
        this.yearleave = yearleave;
    }

    public Double getWorkleave() {
        return this.workleave;
    }
    
    public void setWorkleave(Double workleave) {
        this.workleave = workleave;
    }

    public Double getBingleave() {
        return this.bingleave;
    }
    
    public void setBingleave(Double bingleave) {
        this.bingleave = bingleave;
    }

    public Double getShileave() {
        return this.shileave;
    }
    
    public void setShileave(Double shileave) {
        this.shileave = shileave;
    }

    public Double getHunleave() {
        return this.hunleave;
    }
    
    public void setHunleave(Double hunleave) {
        this.hunleave = hunleave;
    }

    public Double getChanleave() {
        return this.chanleave;
    }
    
    public void setChanleave(Double chanleave) {
        this.chanleave = chanleave;
    }

    public Double getTanpoleave() {
        return this.tanpoleave;
    }
    
    public void setTanpoleave(Double tanpoleave) {
        this.tanpoleave = tanpoleave;
    }

    public Double getTanfmleave() {
        return this.tanfmleave;
    }
    
    public void setTanfmleave(Double tanfmleave) {
        this.tanfmleave = tanfmleave;
    }

    public Double getSangleave() {
        return this.sangleave;
    }
    
    public void setSangleave(Double sangleave) {
        this.sangleave = sangleave;
    }

    public Double getShangleave() {
        return this.shangleave;
    }
    
    public void setShangleave(Double shangleave) {
        this.shangleave = shangleave;
    }

    public Double getGongleave() {
        return this.gongleave;
    }
    
    public void setGongleave(Double gongleave) {
        this.gongleave = gongleave;
    }

    public Double getQitaleave() {
        return this.qitaleave;
    }
    
    public void setQitaleave(Double qitaleave) {
        this.qitaleave = qitaleave;
    }

    public Double getPeikaoleave() {
        return this.peikaoleave;
    }
    
    public void setPeikaoleave(Double peikaoleave) {
        this.peikaoleave = peikaoleave;
    }

    public Double getBuruleave() {
        return this.buruleave;
    }
    
    public void setBuruleave(Double buruleave) {
        this.buruleave = buruleave;
    }

    public Double getSumleave() {
        return this.sumleave;
    }
    
    public void setSumleave(Double sumleave) {
        this.sumleave = sumleave;
    }

    public Double getSumwork() {
        return this.sumwork;
    }
    
    public void setSumwork(Double sumwork) {
        this.sumwork = sumwork;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}