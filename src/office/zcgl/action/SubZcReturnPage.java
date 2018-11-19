package office.zcgl.action;
import java.util.List;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.process.pojo.Process;
import office.zcgl.dao.AssertFenDAO;
import office.zcgl.dao.AssetReturnDAO;
import office.zcgl.pojo.AssertFen;
import office.zcgl.pojo.AssetReturn;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;
public class SubZcReturnPage {
	private String username;
	private String tel;
	private int chu;
	private String remark;
	private String reason;
	private String thisunder;
	private String [] assetid;
	private String newnumber;
	private String message;
	
	
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getThisunder() {
		return thisunder;
	}

	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}

	


	public String[] getAssetid() {
		return assetid;
	}

	public void setAssetid(String[] assetid) {
		this.assetid = assetid;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String execute() throws Exception
	{
		AssetReturn ay = new AssetReturn();		
		AssetReturnDAO aydao = new AssetReturnDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		GetProcessByPosition gpbp = new GetProcessByPosition();
		AssetInfo ai = new AssetInfo();
		AssetInfoDAO aidao = new AssetInfoDAO();
		AssertFen af = new AssertFen();
		AssertFenDAO afdao = new AssertFenDAO();
		DateUtil du = new DateUtil();
//		int zhi = 0;		
		int process = 0;
	
		String date = du.getStringDate();
		String index = "000";
		String number = "";
		String result = "success";
		String position = "";
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction(); 	    
 	    UserInfo ui= uidao.findByNewNumber(newnumber);//发起人 	   
 	    position = ui.getPosition();
 	    //zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		
 	   
		//获得审批表编号
//		if (list.isEmpty()) {
//			number = date + "WCGG" + dai + bu + "001";
//		} else {
			//index = "000" + String.valueOf(list.size()+1);
			index = "000"+fraw.readandwrite("ZCGH");
			index = index.substring(index.length() - 3, index.length());
			number = date + "ZCGH" + index;
//		}
		//是否表中有重复项
		if(aydao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
         	
		if((assetid==null)||(assetid.length==0))
		{
			result = "failed";
			message = "提交失败，未选择归还资产";
			trans.rollback();
			return result;
		}
		//获得公干流程编号
		process = gpbp.getZcghProcess(position);
		if(process==0)
		{
			result = "nozcgh";
			message = "您不需要填此表";
		}
		//检查时间有效性
		for(int i=0;i<assetid.length;i++)
		{
			int id = Integer.parseInt(assetid[i]);
			ai = aidao.findAllById(id);
			af.setApplynumber(number);
			af.setArea(ai.getArea());
			af.setName(ai.getName());
			af.setNumber(ai.getNumber());
			af.setType(ai.getType());
			af.setUsername(ai.getPeople());
			af.setReturntime(ai.getReturntime());
			afdao.merge(af);
		}
		ay.setChu(chu);
		ay.setDate(date);
		ay.setInitiator(newnumber);
        ay.setJindu("E");
        ay.setName(username);
        ay.setNumber(number);
        ay.setPreunder("");
        ay.setProcess(process);
        ay.setReason(reason);
        ay.setRemark(remark);
        ay.setStatus(1);
        ay.setTel(tel);
        ay.setThisunder(thisunder); 
        String ids=assetid[0];
		for(int i=1;i<assetid.length;i++)
		{
			ids=ids+"、"+assetid[i];
		}
		ay.setAssetid(ids);
		
 	    aydao.merge(ay);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();		
		return result;
	}
}
