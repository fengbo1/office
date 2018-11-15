package office.kqjl.action;

import office.kqjl.dao.KqjlUploadDAO;
import office.kqjl.pojo.KqjlUpload;
import office.util.DateUtil;

public class ShowKqjlImport {

	private KqjlUpload ku;
	private int year1;
	private int year2;
	private int month;
	
	public KqjlUpload getKu() {
		return ku;
	}
	public void setKu(KqjlUpload ku) {
		this.ku = ku;
	}
	public int getYear1() {
		return year1;
	}
	public void setYear1(int year1) {
		this.year1 = year1;
	}
	public int getYear2() {
		return year2;
	}
	public void setYear2(int year2) {
		this.year2 = year2;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		KqjlUploadDAO kudao = new KqjlUploadDAO();
		ku = kudao.findAllBeforeImport();
		year1 = du.getThisYear();
		year2 = year1-1;
		month = du.getMonth()-1;
		return "success";
	}
}
