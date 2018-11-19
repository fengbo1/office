package office.kqjl.pojo;
// default package



/**
 * AbstractKqjlMonth entity provides the base persistence definition of the KqjlMonth entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKqjlMonth  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String month;
     private String name;
     private String newnumber;
     private String position;
     private Double workdays;
     private Double zhiwendays;
     private Integer chidao;
     private Integer zaotui;
     private Integer qdqs;
     private Integer qtqs;
     private Integer bukq;
     private Double qjdays;
     private Double ggdays;
     private Double jbdays;
     private Double yearleave;
     private Double workleave;
     private Double bingleavebu;
     private Double bingleavekou;
     private Double shileavebu;
     private Double shileavekou;
     private Double hunleave;
     private Double chanleave;
     private Double tanpoleave;
     private Double tanfmleave;
     private Double sangleave;
     private Double shangleave;
     private Double gongleave;
     private Double chanjianleave;
     private Double peikaoleave;
     private Double buruleave;
     private Integer yc;
     private Integer status;


    // Constructors

    /** default constructor */
    public AbstractKqjlMonth() {
    }

    
    /** full constructor */
    public AbstractKqjlMonth(String month, String name, String newnumber, String position, Double workdays, Double zhiwendays, Integer chidao, Integer zaotui, Integer qdqs, Integer qtqs, Integer bukq, Double qjdays, Double ggdays, Double jbdays, Double yearleave, Double workleave, Double bingleavebu, Double bingleavekou, Double shileavebu, Double shileavekou, Double hunleave, Double chanleave, Double tanpoleave, Double tanfmleave, Double sangleave, Double shangleave, Double gongleave, Double chanjianleave, Double peikaoleave, Double buruleave, Integer yc, Integer status) {
        this.month = month;
        this.name = name;
        this.newnumber = newnumber;
        this.position = position;
        this.workdays = workdays;
        this.zhiwendays = zhiwendays;
        this.chidao = chidao;
        this.zaotui = zaotui;
        this.qdqs = qdqs;
        this.qtqs = qtqs;
        this.bukq = bukq;
        this.qjdays = qjdays;
        this.ggdays = ggdays;
        this.jbdays = jbdays;
        this.yearleave = yearleave;
        this.workleave = workleave;
        this.bingleavebu = bingleavebu;
        this.bingleavekou = bingleavekou;
        this.shileavebu = shileavebu;
        this.shileavekou = shileavekou;
        this.hunleave = hunleave;
        this.chanleave = chanleave;
        this.tanpoleave = tanpoleave;
        this.tanfmleave = tanfmleave;
        this.sangleave = sangleave;
        this.shangleave = shangleave;
        this.gongleave = gongleave;
        this.chanjianleave = chanjianleave;
        this.peikaoleave = peikaoleave;
        this.buruleave = buruleave;
        this.yc = yc;
        this.status = status;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return this.month;
    }
    
    public void setMonth(String month) {
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

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public Double getWorkdays() {
        return this.workdays;
    }
    
    public void setWorkdays(Double workdays) {
        this.workdays = workdays;
    }

    public Double getZhiwendays() {
        return this.zhiwendays;
    }
    
    public void setZhiwendays(Double zhiwendays) {
        this.zhiwendays = zhiwendays;
    }

    public Integer getChidao() {
        return this.chidao;
    }
    
    public void setChidao(Integer chidao) {
        this.chidao = chidao;
    }

    public Integer getZaotui() {
        return this.zaotui;
    }
    
    public void setZaotui(Integer zaotui) {
        this.zaotui = zaotui;
    }

    public Integer getQdqs() {
        return this.qdqs;
    }
    
    public void setQdqs(Integer qdqs) {
        this.qdqs = qdqs;
    }

    public Integer getQtqs() {
        return this.qtqs;
    }
    
    public void setQtqs(Integer qtqs) {
        this.qtqs = qtqs;
    }

    public Integer getBukq() {
        return this.bukq;
    }
    
    public void setBukq(Integer bukq) {
        this.bukq = bukq;
    }

    public Double getQjdays() {
        return this.qjdays;
    }
    
    public void setQjdays(Double qjdays) {
        this.qjdays = qjdays;
    }

    public Double getGgdays() {
        return this.ggdays;
    }
    
    public void setGgdays(Double ggdays) {
        this.ggdays = ggdays;
    }

    public Double getJbdays() {
        return this.jbdays;
    }
    
    public void setJbdays(Double jbdays) {
        this.jbdays = jbdays;
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

    public Double getBingleavebu() {
        return this.bingleavebu;
    }
    
    public void setBingleavebu(Double bingleavebu) {
        this.bingleavebu = bingleavebu;
    }

    public Double getBingleavekou() {
        return this.bingleavekou;
    }
    
    public void setBingleavekou(Double bingleavekou) {
        this.bingleavekou = bingleavekou;
    }

    public Double getShileavebu() {
        return this.shileavebu;
    }
    
    public void setShileavebu(Double shileavebu) {
        this.shileavebu = shileavebu;
    }

    public Double getShileavekou() {
        return this.shileavekou;
    }
    
    public void setShileavekou(Double shileavekou) {
        this.shileavekou = shileavekou;
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

    public Double getChanjianleave() {
        return this.chanjianleave;
    }
    
    public void setChanjianleave(Double chanjianleave) {
        this.chanjianleave = chanjianleave;
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

    public Integer getYc() {
        return this.yc;
    }
    
    public void setYc(Integer yc) {
        this.yc = yc;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
   








}