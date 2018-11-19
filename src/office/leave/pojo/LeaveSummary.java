package office.leave.pojo;
// default package



/**
 * LeaveSummary entity. @author MyEclipse Persistence Tools
 */
public class LeaveSummary extends AbstractLeaveSummary implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public LeaveSummary() {
    }

    
    /** full constructor */
    public LeaveSummary(Integer year, String name, String newnumber, String position, Double yearall, Double yearleave, Double workrest, Double workleave, Double bingleave, Double shileave, Double hunleave, Double chanleave, Double tanpoleave, Double tanfmleave, Double sangleave, Double shangleave, Double gongleave, Double qitaleave, Double peikaoleave, Double buruleave, String remark) {
        super(year, name, newnumber, position, yearall, yearleave, workrest, workleave, bingleave, shileave, hunleave, chanleave, tanpoleave, tanfmleave, sangleave, shangleave, gongleave, qitaleave, peikaoleave, buruleave, remark);        
    }
   
}
