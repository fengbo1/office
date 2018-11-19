package office.zcgl.action;
import java.util.List;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.zcgl.dao.StorehouseDataDAO;
import office.zcgl.dao.StorehouseOutDAO;
import office.zcgl.pojo.StorehouseData;
import office.zcgl.pojo.StorehouseOut;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class SubZcKfOutPage {

	
	private String username;
	private String thisunder;
	private String tel;
	private String reason;
	private String newnumber;
	private String message;
	private String rukunum;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRukunum() {
		return rukunum;
	}

	public void setRukunum(String rukunum) {
		this.rukunum = rukunum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	public String getThisunder() {
		return thisunder;
	}

	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}


	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String execute() throws Exception
	{
		StorehouseOut ah = new StorehouseOut();
	    StorehouseOutDAO ahdao = new StorehouseOutDAO();

		UserInfoDAO uidao = new UserInfoDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		//GetProcessByPosition gpbp = new GetProcessByPosition();
		DateUtil du = new DateUtil();
	
//		int zhi = 0;
		
	//	int process = 0;
	
		String dateout = du.getStringDate();
		String index = "000";
		String number = "";
		String result = "success";
		String position = "";
        String checkname = "";
		String thisunder = "";
		
		thisunder="88906063";
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    UserInfo ui= uidao.findByNewNumber(newnumber);//发起人
 	    UserInfo uithis= uidao.findByNewNumber(thisunder);
 	    checkname = uithis.getUsername();
 	    position = ui.getPosition();
 	    String name = ui.getUsername();
 	   
 	    //zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		
 	   
		//获得审批表编号
//		if (list.isEmpty()) {
//			number = date + "WCGG" + dai + bu + "001";
//		} else {
			//index = "000" + String.valueOf(list.size()+1);
			index = "000"+fraw.readandwrite("ZCCK");
			index = index.substring(index.length() - 3, index.length());
			number = dateout + "ZCCK" + index;
//		}
		//是否表中有重复项
		if(ahdao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
         
		//获得公干流程编号
	
		//检查时间有效性
	
		ah.setDate(dateout);
        ah.setInitiator(newnumber);
        ah.setName(name);
        ah.setNumber(number);
        ah.setCheckname(checkname);
        ah.setReason(reason);
        ah.setThisunder(thisunder);
        ah.setStatus(1);	
        ah.setTel(tel);
        ah.setChukunum(rukunum);
 	    ahdao.merge(ah);
 	    StorehouseDataDAO ahddao = new StorehouseDataDAO();
 	    List<StorehouseData> listahd = ahddao.findAllByRukunum(rukunum);
 	   // changeassetinfo(ay);
 	    if(listahd!=null)
 	    {
 	    	changeassetinfo(listahd);
 	    }
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return result;
	}
	public void changeassetinfo(List<StorehouseData> listahd)
	{
		AssetInfoDAO aidao=new AssetInfoDAO();
		DateUtil du = new DateUtil();
		String datechuku = du.getStringDate();
	    for(int i=0;i<listahd.size();i++)
		{
		    AssetInfo ai = aidao.findAllByNumberAndChu(listahd.get(i).getAssetnumber());
			ai.setStatus(4);
			ai.setArea("报废");
			ai.setDate(datechuku);
			aidao.merge(ai);
		}
	}
}
