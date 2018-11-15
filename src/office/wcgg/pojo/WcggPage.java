package office.wcgg.pojo;
// default package



/**
 * WcggPage entity. @author MyEclipse Persistence Tools
 */
public class WcggPage extends AbstractWcggPage implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WcggPage() {
    }

    
    /** full constructor */
    public WcggPage(String number, Integer process, String jindu, String date, Integer status, String preunder, String thisunder, String initiator, String applicant, String people, String chu, String zu, String tel, String reason, String addr, String begindate, String enddate, Integer halfday, Double days, Integer view, String remark) {
        super(number, process, jindu, date, status, preunder, thisunder, initiator, applicant, people, chu, zu, tel, reason, addr, begindate, enddate, halfday, days, view, remark);        
    }
   
}
