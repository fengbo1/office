package office.zcgl.action;
import java.util.List;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.process.action.FindNextUnder;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.LeaveUtil;
import office.util.Util;

import office.zcgl.dao.StorehouseDataDAO;
import office.zcgl.dao.StorehouseInDAO;
import office.zcgl.dao.StorehouseOutDAO;
import office.zcgl.pojo.StorehouseData;
import office.zcgl.pojo.StorehouseIn;
import office.zcgl.pojo.StorehouseOut;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class ZcKfOutReturn {
	private String thisunder;
	private String number;
	private String message;
	private String newnumber;
	private String thisundername;
	private String time;
	private String remark;
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getThisundername() {
		return thisundername;
	}
	public void setThisundername(String thisundername) {
		this.thisundername = thisundername;
	}

	public String execute() throws Exception
	{
		String result = "success";
		message = "复核不通过";
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		StorehouseOut ah = new StorehouseOut();
		StorehouseOutDAO ahdao = new StorehouseOutDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		DateUtil du = new DateUtil();
		LeaveProcessDAO lprodao = new LeaveProcessDAO();
		LeaveProcess lpro = new LeaveProcess();//审批意见写在leaveprocess中
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		time = du.getSimpleDateTime();
		remark="复核不通过"+remark;
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(newnumber);
 			ah = ahdao.findAllByNumber(number);
 			
 			thisundername = ui.getUsername();
 			
 			ol.setItem("ZCCK");
 			ol.setName(thisundername);
 			ol.setNewnumber(newnumber);
 			ol.setTime(time);
 			ol.setRemark(number);
 			oldao.merge(ol);
 			lpro.setNumber(number);
 			lpro.setTime(time);
 			lpro.setViewer(thisundername);
 			lpro.setViewernewnumber(newnumber);
 			lpro.setAuthority("N");
 			lpro.setRemark(remark);
 			lprodao.merge(lpro);
 			ah.setStatus(5);
 			/*if(newnumber.equals("88906063"))
 			{
 				thisunder="66191663";
 			}
 			if(newnumber.equals("66191663"))
 			{
 				thisunder="88906063";
 			}*/
 			ah.setThisunder("");
 			ahdao.merge(ah);
 			//StorehouseDataDAO ahddao = new StorehouseDataDAO();
 	 	    //List<StorehouseData> listahd = ahddao.findAllByRukunum(ah.getChukunum());
 			//unchangeassetinfo(listahd);			
 		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	public void unchangeassetinfo(List<StorehouseData> listahd)
	{
		AssetInfoDAO aidao=new AssetInfoDAO();
	    for(int i=0;i<listahd.size();i++)
		{
		    AssetInfo ai = aidao.findAllByNumber(listahd.get(i).getAssetnumber());
			ai.setStatus(1);
			ai.setArea("库房");
			aidao.merge(ai);
		}
	}
}
