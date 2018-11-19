package office.mycalendar.pojo;
// default package



/**
 * MyCalendar entity. @author MyEclipse Persistence Tools
 */
public class MyCalendar extends AbstractMyCalendar implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MyCalendar() {
    }

    
    /** full constructor */
    public MyCalendar(String date, Integer week, Integer workday, String remark) {
        super(date, week, workday, remark);        
    }
   
}
