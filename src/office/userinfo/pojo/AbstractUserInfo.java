package office.userinfo.pojo;
// default package



/**
 * AbstractUserInfo entity provides the base persistence definition of the UserInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserInfo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String newnumber;
     private String username;
     private String password;
     private String position;
     private String authority;
     private String identity;
     private String workdate;
     private String ccbdate;
     private String zxdate;
     private Integer workyears;
     private String passport;
     private String hkpassport;
     private String twpassport;
     private Double yearall;
     private String role890;
     private String role891;
     private Integer status890;
     private Integer status891;
     private Integer paixu;
     private String remark1;
     private String remark2;
     private String opnumber;


    // Constructors

    /** default constructor */
    public AbstractUserInfo() {
    }

    
    /** full constructor */
    public AbstractUserInfo(String newnumber, String username, String password, String position, String authority, String identity, String workdate, String ccbdate, String zxdate, Integer workyears, String passport, String hkpassport, String twpassport, Double yearall, String role890, String role891, Integer status890, Integer status891, Integer paixu, String remark1, String remark2, String opnumber) {
        this.newnumber = newnumber;
        this.username = username;
        this.password = password;
        this.position = position;
        this.authority = authority;
        this.identity = identity;
        this.workdate = workdate;
        this.ccbdate = ccbdate;
        this.zxdate = zxdate;
        this.workyears = workyears;
        this.passport = passport;
        this.hkpassport = hkpassport;
        this.twpassport = twpassport;
        this.yearall = yearall;
        this.role890 = role890;
        this.role891 = role891;
        this.status890 = status890;
        this.status891 = status891;
        this.paixu = paixu;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.opnumber = opnumber;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

    public String getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getIdentity() {
        return this.identity;
    }
    
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getWorkdate() {
        return this.workdate;
    }
    
    public void setWorkdate(String workdate) {
        this.workdate = workdate;
    }

    public String getCcbdate() {
        return this.ccbdate;
    }
    
    public void setCcbdate(String ccbdate) {
        this.ccbdate = ccbdate;
    }

    public String getZxdate() {
        return this.zxdate;
    }
    
    public void setZxdate(String zxdate) {
        this.zxdate = zxdate;
    }

    public Integer getWorkyears() {
        return this.workyears;
    }
    
    public void setWorkyears(Integer workyears) {
        this.workyears = workyears;
    }

    public String getPassport() {
        return this.passport;
    }
    
    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getHkpassport() {
        return this.hkpassport;
    }
    
    public void setHkpassport(String hkpassport) {
        this.hkpassport = hkpassport;
    }

    public String getTwpassport() {
        return this.twpassport;
    }
    
    public void setTwpassport(String twpassport) {
        this.twpassport = twpassport;
    }

    public Double getYearall() {
        return this.yearall;
    }
    
    public void setYearall(Double yearall) {
        this.yearall = yearall;
    }

    public String getRole890() {
        return this.role890;
    }
    
    public void setRole890(String role890) {
        this.role890 = role890;
    }

    public String getRole891() {
        return this.role891;
    }
    
    public void setRole891(String role891) {
        this.role891 = role891;
    }

    public Integer getStatus890() {
        return this.status890;
    }
    
    public void setStatus890(Integer status890) {
        this.status890 = status890;
    }

    public Integer getStatus891() {
        return this.status891;
    }
    
    public void setStatus891(Integer status891) {
        this.status891 = status891;
    }

    public Integer getPaixu() {
        return this.paixu;
    }
    
    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }
    
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getOpnumber() {
        return this.opnumber;
    }
    
    public void setOpnumber(String opnumber) {
        this.opnumber = opnumber;
    }
   








}