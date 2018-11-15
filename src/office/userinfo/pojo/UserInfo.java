package office.userinfo.pojo;
// default package



/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
public class UserInfo extends AbstractUserInfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UserInfo() {
    }

    
    /** full constructor */
    public UserInfo(String newnumber, String username, String password, String position, String authority, String identity, String workdate, String ccbdate, String zxdate, Integer workyears, String passport, String hkpassport, String twpassport, Double yearall, String role890, String role891, Integer status890, Integer status891, Integer paixu, String remark1, String remark2, String opnumber) {
        super(newnumber, username, password, position, authority, identity, workdate, ccbdate, zxdate, workyears, passport, hkpassport, twpassport, yearall, role890, role891, status890, status891, paixu, remark1, remark2, opnumber);        
    }
   
}
