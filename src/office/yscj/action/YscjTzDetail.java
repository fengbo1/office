package office.yscj.action;
import java.util.List;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.Util;
import office.yscj.dao.TYscjtzDAO;
import office.yscj.pojo.TYscjtz;
import office.yscj.dao.TYscjDAO;
import office.yscj.pojo.TYscj;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class YscjTzDetail {
	private String number;
	private String newnumber;
    private TYscjtz tz;
    private TYscj ty;
	public TYscj getTy() {
		return ty;
	}

	public void setTy(TYscj ty) {
		this.ty = ty;
	}

	public TYscjtz getTz() {
		return tz;
	}

	public void setTz(TYscjtz tz) {
		this.tz = tz;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String execute() throws Exception
	{
		TYscjtzDAO tzdao=new TYscjtzDAO();
		tz=tzdao.findAllByNumber(number);
		TYscjDAO tydao=new TYscjDAO();
		ty=tydao.findAllByNumber(number);
		String result="success";
		if((tz.getBringtime()!=null)&&(tz.getBringtime()!=""))
		{
			 result="successed";
		}
	    return result;
 	    	
 	  }
}
