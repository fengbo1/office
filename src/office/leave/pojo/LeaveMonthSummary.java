package office.leave.pojo;
// default package



/**
 * LeaveMonthSummary entity. @author MyEclipse Persistence Tools
 */
public class LeaveMonthSummary extends AbstractLeaveMonthSummary implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public LeaveMonthSummary() {
    }

    
    /** full constructor */
    public LeaveMonthSummary(Integer year, Integer month, String name, String newnumber, Double yearleave, Double workleave, Double bingleave, Double shileave, Double hunleave, Double chanleave, Double tanpoleave, Double tanfmleave, Double sangleave, Double shangleave, Double gongleave, Double qitaleave, Double peikaoleave, Double buruleave, Double sumleave, Double sumwork, String remark) {
        super(year, month, name, newnumber, yearleave, workleave, bingleave, shileave, hunleave, chanleave, tanpoleave, tanfmleave, sangleave, shangleave, gongleave, qitaleave, peikaoleave, buruleave, sumleave, sumwork, remark);        
    }
   
}
