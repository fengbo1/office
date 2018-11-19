package office.zcgl.action;


import java.util.List;
import office.zcgl.pojo.StorehouseData;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ShowKfIn {
   private String name;
   private String type;
   private String number;
   private List<StorehouseData> listsh;
     
      public List<StorehouseData> getListsh() {
	     return listsh;
       }
      
      public void setListsh(List<StorehouseData> listsh) {
	     this.listsh = listsh;
       }

	  public String getName() {
	      return name;
      }

      public void setName(String name) {
	      this.name = name;
        }

      public String getType() {
 	     return type;
       }

      public void setType(String type) {
	    this.type = type;
       }

      public String getNumber() {
	      return number;
       }

      public void setNumber(String number) {
	     this.number = number;
       }


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	name=new String(name.getBytes("ISO8859-1"),"UTF-8");
    	type=new String(type.getBytes("ISO8859-1"),"UTF-8");
    	try {
    	
			
			  String hql="from StorehouseData as sh where sh.rukunum = '"+number+"' and sh.assetname = '"+name+"' and sh.assettype = '"+type+"'";
			  listsh = session.createQuery(hql).list();
			 
			  
			}
			catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		    }
			finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		  }
		return "success";
	}

}
