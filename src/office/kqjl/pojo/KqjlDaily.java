package office.kqjl.pojo;

// default package



/**
 * KqjlDaily entity. @author MyEclipse Persistence Tools
 */
public class KqjlDaily extends AbstractKqjlDaily implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public KqjlDaily() {
    }

    
    /** full constructor */
    public KqjlDaily(String date, Integer week, String name, String newnumber, String position, String pbqdtime, String pbqttime, String qdtime, String qttime, Integer qdqs, Integer qtqs, Integer qj, Integer gg, Integer jb, Integer halfday, Integer tb, Integer pb, Integer yc, Integer yy) {
        super(date, week, name, newnumber, position, pbqdtime, pbqttime, qdtime, qttime, qdqs, qtqs, qj, gg, jb, halfday, tb, pb, yc, yy);        
    }
   
}
