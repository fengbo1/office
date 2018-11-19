package office.pb.action;

import office.pb.dao.PbTeshuDAO;
import office.pb.pojo.PbTeshu;
import office.userinfo.dao.UserInfoDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class PtModify {

	private int id;
	private String message;
	private String name;
	private String item;
	private String begindate;
	private String enddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		PbTeshuDAO ptdao = new PbTeshuDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		if(uidao.findByName(name)==null)
    		{
    			message = "失败！名字书写有误";
    			return "failed";
    		}
    		else
    		{
    			message = "修改成功";
    			PbTeshu pt = ptdao.findAllByID(id);
    			if(item.equals("buru"))
    				pt.setItem(1);
    			pt.setName(name);
    			pt.setYxbegin(begindate.replace("-",""));
    			pt.setYxend(enddate.replace("-",""));
    			ptdao.merge(pt);
    		}
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
}
