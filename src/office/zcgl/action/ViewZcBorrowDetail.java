package office.zcgl.action;
import java.util.List;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import office.process.pojo.Process;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.dao.AssetBorrowDAO;
import office.zcgl.pojo.AssetBorrow;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import ccb.hibernate.HibernateSessionFactory;
public class ViewZcBorrowDetail {
	private String number;
	private String newnumber;
	private AssetBorrow ay;
	private List<AssetTemp> listap;
	//private int count=0;	
	private List<LeaveProcess> listlp;
	private String position;
	private UserInfo ui;
	private int queren;
   // private AssetTemp[]dataap;
    
	/*public AssetTemp[] getDataap() {
		return dataap;
	}
	public void setDataap(AssetTemp[] dataap) {
		this.dataap = dataap;
	}*/
	/*public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}*/
	

	public int getQueren() {
		return queren;
	}
	public AssetBorrow getAy() {
		return ay;
	}
	public void setAy(AssetBorrow ay) {
		this.ay = ay;
	}
	public void setQueren(int queren) {
		this.queren = queren;
	}
	public List<AssetTemp> getListap() {
		return listap;
	}
	public void setListap(List<AssetTemp> listap) {
		this.listap = listap;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	
	public List<LeaveProcess> getListlp() {
		return listlp;
	}
	public void setListlp(List<LeaveProcess> listlp) {
		this.listlp = listlp;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public String execute() throws Exception
	{
		AssetBorrowDAO aydao = new AssetBorrowDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		AssetTempDAO apdao = new AssetTempDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    ay= aydao.findAllByNumber(number);
 	    listap = apdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number);
 	    ui = uidao.findByNewNumber(ay.getInitiator());
		position = ui.getPosition();
 	    //bu =wp.getNumber().substring(13, 14);
 	    //count=listap.size();
 	    
 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
