package office.zcgl.action;

import java.util.List;

import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.zcgl.dao.AssertFenDAO;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssertFen;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetTemp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ViewZcApplyFenName {
	private String number;
	private String newnumber;
	private AssetApply ay;
	private List<AssetTemp> listap;
	//private int count=0;	
	private List<LeaveProcess> listlp;
	private String position;
	private UserInfo ui;
	private List<AssertFen> listaf;
	private int type;
	private int isshow;
	
	
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
	
	public List<AssertFen> getListaf() {
		return listaf;
	}

	public void setListaf(List<AssertFen> listaf) {
		this.listaf = listaf;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIsshow() {
		return isshow;
	}

	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}

	public AssetApply getAy() {
		return ay;
	}
	
	public void setAy(AssetApply ay) {
		this.ay = ay;
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
		AssetApplyDAO aydao = new AssetApplyDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		AssetTempDAO apdao = new AssetTempDAO();
		AssertFenDAO afdao = new AssertFenDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    isshow=0;
 	    ay= aydao.findAllByNumber(number);
 	    listap = apdao.findAllByNumber(number);
 	    listlp = lpdao.findAllByNumber(number); 	   
 	    ui = uidao.findByNewNumber(ay.getInitiator());
		position = ui.getPosition();
		if(type==1)
		{
			listaf = afdao.findAllByApplyNumber(number);
	        isshow = 1;		
		}
 	    //bu =wp.getNumber().substring(13, 14);
 	    //count=listap.size();
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
