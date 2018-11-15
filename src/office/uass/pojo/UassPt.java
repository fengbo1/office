package office.uass.pojo;
// default package



/**
 * UassPt entity. @author MyEclipse Persistence Tools
 */
public class UassPt extends AbstractUassPt implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UassPt() {
    }

    
    /** full constructor */
    public UassPt(String number, Integer process, String jindu, String date, Integer status, String preundertake, String undertake, String initiator, String applicant, String position, String tel, String sxtime, String filename, String remark) {
        super(number, process, jindu, date, status, preundertake, undertake, initiator, applicant, position, tel, sxtime, filename, remark);        
    }
   
}
