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
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssetTemp;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.pojo.AssetApply;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.pojo.AssetInfo;
import ccb.hibernate.HibernateSessionFactory;

public class SubZcApplyPage {

	private String username;
	private String tel;
	private int chu;
	private String remark;
	private String reason;
	private String thisunder;
	private String[] assetname;
	private String[] assettype;
	private String[] sum;
	private String newnumber;
	private String message;
	private int num;
	
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String[] getAssetname() {
		return assetname;
	}

	public void setAssetname(String[] assetname) {
		this.assetname = assetname;
	}

	public String[] getAssettype() {
		return assettype;
	}

	public void setAssettype(String[] assettype) {
		this.assettype = assettype;
	}

  
	public String[] getSum() {
		return sum;
	}

	public void setSum(String[] sum) {
		this.sum = sum;
	}

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String execute() throws Exception
	{
		AssetApply ay = new AssetApply();
		AssetTemp ap = new AssetTemp();
		AssetApplyDAO aydao = new AssetApplyDAO();
		AssetTempDAO apdao = new AssetTempDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		GetProcessByPosition gpbp = new GetProcessByPosition();
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
			index = "000"+fraw.readandwrite("ZCSL");
			index = index.substring(index.length() - 3, index.length());
			number = date + "ZCSL" + index;
//		}
		//是否表中有重复项
		if(aydao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
		int flag=0;
		for(int i=0;i<num;i++)
		{
			String tempname=assetname[i];
			for(int j=i+1;j<num;j++)
			{
				if(tempname.equals(assetname[j]))
				{
					if(assettype[i].equals(assettype[j]))
					{
						flag=1;
					}
						
				}
			}
		}
		if(flag==1)
		{
			result = "failed";
			message = "提交失败，不得重复选择同一名称、类型资产！";
			trans.rollback();
			return result;
		}
		Query query;
		List<AssetInfo>listnum;
		int flag1=0;
		int num1=0;
		for(int i=0;i<num;i++)
		{
			String hql = "";
	 	    hql = "from AssetInfo as ai where ai.type='"+assettype[i]+"' and  ai.name='"+assetname[i]+"' and ai.status='"+1+"'order by ai.id";
			query = session.createQuery(hql);
			listnum= query.list();
			num1=listnum.size();
			if(Integer.parseInt(sum[i])>num1)
			{
				flag1=1;
			}
		}
		if(flag1==1)
		{
			result = "failed";
			message = "提交失败，库存不足！";
			trans.rollback();
			return result;
		}
		//获得公干流程编号
		process = gpbp.getZcslProcess(position);
		if(process==0)
		{
			result = "nozcsl";
			message = "您不需要填此表";
		}
		//检查时间有效性
		
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
        
        if((assetname==null)||(assettype==null)||(sum==null))
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
        if((assetname!=null)&&(assettype!=null)&&(sum!=null))
        {
        	for(int i=0;i<num;i++)
        	{
        		ap.setName(assetname[i]);
        		ap.setNum(Integer.parseInt(sum[i]));
        		//ap.setNum(sum[i]);
        		ap.setNumber(number);
        		ap.setType(assettype[i]);
        		apdao.merge(ap);
        	}
        }       
 	    aydao.merge(ay);
 	    List<AssetTemp> listap = apdao.findAllByNumber(number);
 	    //changeassetinfo(listap,number);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return result;
	}
		

}
