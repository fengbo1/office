package office.wcgg.pojo;
// default package



/**
 * WcggBaodao entity. @author MyEclipse Persistence Tools
 */
public class WcggBaodao extends AbstractWcggBaodao implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WcggBaodao() {
    }

    
    /** full constructor */
    public WcggBaodao(String number, String name, String newnumber, String begindate, String baodaodate, Integer bghalfday, Integer bdhalfday, Double sumday, Integer status) {
        super(number, name, newnumber, begindate, baodaodate, bghalfday, bdhalfday, sumday, status);        
    }
   
}
