package office.zcgl.action;
import java.util.List;


import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.zcgl.dao.StorehouseInDAO;
import office.zcgl.pojo.StorehouseIn;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
public class SubZcKfInPage {

	private String username;
	private String thisunder;
	private String tel;
	private String remark;
	private String newnumber;
	private String message;
	private String rukunum;

	

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRukunum() {
		return rukunum;
	}

	public void setRukunum(String rukunum) {
		this.rukunum = rukunum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		StorehouseIn ah = new StorehouseIn();
		StorehouseInDAO ahdao = new StorehouseInDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		//GetProcessByPosition gpbp = new GetProcessByPosition();
		DateUtil du = new DateUtil();
	
//		int zhi = 0;
		
	//	int process = 0;
	
		String datein = du.getStringDate();
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
			index = "000"+fraw.readandwrite("ZCRK");
			index = index.substring(index.length() - 3, index.length());
			number = datein + "ZCRK" + index;
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
		ah.setDate(datein);
        ah.setInitiator(newnumber);
        ah.setName(name);
        ah.setNumber(number);
        ah.setCheckname(checkname);
        ah.setRemark(remark);
        ah.setThisunder(thisunder);
        ah.setStatus(1);	
        ah.setTel(tel);
        ah.setRukunum(rukunum);
 	    ahdao.merge(ah);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return result;
	}
}
