package ccb.util;
/**
 * 
 * @author mir
 * <br/>
 * 该类保存query查询的条件
 */
public class QueryCriteria {

	private String qc;
	private String qcBegin;
	private String qcEnd;
	public QueryCriteria(String qc, String qcBegin, String qcEnd) {
		super();
		this.qc = qc;
		this.qcBegin = qcBegin;
		this.qcEnd = qcEnd;
	}
	public QueryCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getQc() {
		return qc;
	}
	public void setQc(String qc) {
		this.qc = qc;
	}
	public String getQcBegin() {
		return qcBegin;
	}
	public void setQcBegin(String qcBegin) {
		this.qcBegin = qcBegin;
	}
	public String getQcEnd() {
		return qcEnd;
	}
	public void setQcEnd(String qcEnd) {
		this.qcEnd = qcEnd;
	}
	
	
	
	
}
