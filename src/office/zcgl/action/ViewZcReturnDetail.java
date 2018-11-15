package office.zcgl.action;
import java.util.List;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.process.pojo.Process;
import office.zcgl.dao.AssertFenDAO;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssertFen;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.dao.AssetReturnDAO;
import office.zcgl.pojo.AssetReturn;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class ViewZcReturnDetail {
	private String number;
	private String newnumber;
	private AssetReturn ay;
	private List<AssertFen> listap;
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
	public AssetReturn getAy() {
		return ay;
	}
	public void setAy(AssetReturn ay) {
		this.ay = ay;
	}
	public void setQueren(int queren) {
		this.queren = queren;
	}

	public List<AssertFen> getListap() {
		return listap;
	}
	public void setListap(List<AssertFen> listap) {
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
		AssetReturnDAO aydao = new AssetReturnDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		AssertFenDAO apdao = new AssertFenDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    ay= aydao.findAllByNumber(number);
 	    String assetid = ay.getAssetid(); 
 	    listap= apdao.findByApplynumber(number);	  
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
