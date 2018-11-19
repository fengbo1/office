package office.userinfo.action;

import java.util.List;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class TiShi {

	private String keyword;
	private String para;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String execute() throws Exception
	{
		para = "";
		String name = new String(keyword.getBytes("GB2312"),"UTF-8");
		UserInfoDAO uidao = new UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		String queryString = "from UserInfo as ui where ui.username like '%"+name+"%' order by paixu";
	        Query queryObject = session.createQuery(queryString);
    		List<UserInfo> list = queryObject.list();
    		for(int i=0;i<list.size();i++)
    		{
    			if(i!=0)
    			{
    				para+="|";
    			}
    			else
    			{
    				para+=list.get(0).getUsername();
    			}
    		}
    		para+="冯|额";
    		System.out.println("--"+para+"--");
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
