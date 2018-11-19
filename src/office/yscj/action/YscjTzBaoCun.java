package office.yscj.action;
import java.util.List;

import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.Util;
import office.yscj.dao.TYscjDAO;
import office.yscj.dao.TYscjtzDAO;
import office.yscj.pojo.TYscj;
import office.yscj.pojo.TYscjtz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class YscjTzBaoCun {
	private String number;
	private String bringtime;
	private String returntime;
    private String newnumber;
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBringtime() {
		return bringtime;
	}

	public void setBringtime(String bringtime) {
		this.bringtime = bringtime;
	}

	public String getReturntime() {
		return returntime;
	}

	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}

	public String execute() throws Exception
	{
		TYscjtz tz= new TYscjtz();
		TYscjtzDAO tzdao = new TYscjtzDAO();
		TYscj ty=new TYscj();
		TYscjDAO tydao = new TYscjDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    DateUtil du = new DateUtil();
 	    OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByNewNumber(newnumber);
		ol.setItem("YSCJ");
		ol.setName(ui.getUsername());
		ol.setNewnumber(newnumber);
		ol.setTime(du.getDateTime());
		ol.setOperate("保存领取出国证照时间");
		ol.setRemark(number);
	    tz=tzdao.findAllByNumber(number);
	    ty=tydao.findAllByNumber(number);
	    tz.setBringtime(bringtime);
	    ty.setStatus(9);
 	    String result = "success";
 	    	if(tz==null||ty==null)
 	    	{
 	    		trans.rollback();
 	    		result="failed";
	    		return result ;
 	    	}
 	    	else
 	    	{
 	    		tzdao.merge(tz);
 	    		tydao.merge(ty);
 	    		oldao.merge(ol);
 	    	}
 	    	trans.commit();
 			session.flush();
 			session.clear();
 			session.close();
 			
 			return result;
 	    	
 	    }

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
}
