package office.zcgl.action;

import java.util.List;

import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.StorehouseData;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowSearchDetail {
	 private String name;
	   private String type;
	   private String number;
	   private int chu;
	   private int status;
	   private List<AssetInfo> listsh;
	   private int isreturn;
	   private int flag;
	 
	
	
 
    public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getIsreturn() {
		return isreturn;
	}

	public void setIsreturn(int isreturn) {
		this.isreturn = isreturn;
	}

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<AssetInfo> getListsh() {
		return listsh;
	}

	public void setListsh(List<AssetInfo> listsh) {
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
	    	 if(type.equals("升腾DI945-2B(X2) 17寸普屏"))
			 {
			    	type="升腾DI945-2B(X2)+17寸普屏";
			 }
	    	 if(type.equals("柯尼卡美能达b363 621 机柜"))
			 {
			    	type="柯尼卡美能达b363+621+机柜";
			 }
	    	 if(type.equals("1 1 3"))
			 {
			    	type="1+1+3";
			 }
	    	try {
	    	
				
				  String hql="from AssetInfo as sh where sh.chu = "+chu+" and sh.name = '"+name+"' and sh.type = '"+type+"' and sh.status ="+status;
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
