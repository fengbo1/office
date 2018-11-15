package office.uass.pojo;
// default package



/**
 * UassCostHn entity. @author MyEclipse Persistence Tools
 */
public class UassCostHn extends AbstractUassCostHn implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UassCostHn() {
    }

    
    /** full constructor */
    public UassCostHn(String number, Integer process, String jindu, String date, Integer status, String preundertake, String undertake, String initiator, String applicant, String position, String tel, String sxtime, String remark) {
        super(number, process, jindu, date, status, preundertake, undertake, initiator, applicant, position, tel, sxtime, remark);        
    }
   
}
