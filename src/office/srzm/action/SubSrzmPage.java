package office.srzm.action;
import java.util.List;

import office.process.action.GetProcessByPosition;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;
import office.srzm.dao.TSrzmDAO;

import office.srzm.pojo.TSrzm;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
public class SubSrzmPage {
	/**
	 * 提交外出公干审批表
	 * @author htzx
	 *
	 */


		private String newnumber;
		private String message;
		private String tel;
		private String yongtu;
		private String zhiwu;
		private int neednumber;
		private String todepartment;
		private String remark;
		private String thisunder;
		private String name;
		private String sex;
		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		private int dai;
	
		private String username;
		
		public String getNewnumber() {
			return newnumber;
		}

		public void setNewnumber(String newnumber) {
			this.newnumber = newnumber;
		}
		
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

	

		public String getThisunder() {
			return thisunder;
		}

		public void setThisunder(String thisunder) {
			this.thisunder = thisunder;
		}
		
		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

	

		public int getDai() {
			return dai;
		}

		public void setDai(int dai) {
			this.dai = dai;
		}



		public String getYongtu() {
			return yongtu;
		}

		public void setYongtu(String yongtu) {
			this.yongtu = yongtu;
		}

		public String getZhiwu() {
			return zhiwu;
		}

		public void setZhiwu(String zhiwu) {
			this.zhiwu = zhiwu;
		}

		public int getNeednumber() {
			return neednumber;
		}

		public void setNeednumber(int neednumber) {
			this.neednumber = neednumber;
		}

		public String getTodepartment() {
			return todepartment;
		}

		public void setTodepartment(String todepartment) {
			this.todepartment = todepartment;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String execute() throws Exception
		{
			TSrzm tz = new TSrzm();
			UserInfoDAO uidao = new UserInfoDAO();
			TSrzmDAO tzdao = new TSrzmDAO();
			FileReadAndWrite fraw = new FileReadAndWrite();
		    GetProcessByPosition gpbp = new GetProcessByPosition();
			DateUtil du = new DateUtil();
		
//			int zhi = 0;
			int chu = 0;
			int process = 0;
		
			String date = du.getStringDate();
			String index = "000";
		
			String number = "";
			String result = "success";
			String position = "";
			message = "失败，姓名";
			
	
			Session session = HibernateSessionFactory.getSession();
	 	    Transaction trans=session.beginTransaction();
	 	    
	 	    //List<TZzzm> list = tzdao.findAllByDate(date);
	 	    UserInfo ui = uidao.findByName(name);
	 	    UserInfo uiinitiator = uidao.findByNewNumber(newnumber);//发起人
	 	    if(!uiinitiator.getUsername().equals(name))
	 	    {
	 	    	dai=1;
	 	    }
	 	    else
	 	    {
	 	    	dai=0;
	 	    }
	 	    position = ui.getPosition();
	 	    //zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
			chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
	 	   
			//获得审批表编号
//			if (list.isEmpty()) {
//				number = date + "WCGG" + dai + bu + "001";
//			} else {
				//index = "000" + String.valueOf(list.size()+1);
				index = "000"+fraw.readandwrite("SRZM");
				index = index.substring(index.length() - 3, index.length());
				number = date + "SRZM" + dai + index;
//			}
			//是否表中有重复项
			if(tzdao.findAllByNumber(number)!=null)
			{
				result = "failed";
				message = "提交失败，原因异常";
				trans.rollback();
				return result;
			}
		
			//获得公干流程编号
			process = gpbp.getSrzmProcess(position);
			if(process==0)
			{
				result = "nosrzm";
				message = "您不需要填此表";
			}
			
			if(dai==1)
			{
				username = username.replace("刘一帆","考勤管理员");
				remark = remark+"("+username+"代为申请)";
			}
	 	    tz.setNumber(number);
	 	    tz.setProcess(process);
	 	    tz.setJindu("E");
	 	    tz.setDate(date);
	 	    tz.setStatus(1);
	 	    tz.setPreunder("");
	 	    tz.setThisunder(thisunder);
	 	    tz.setInitiator(newnumber);
	 	    tz.setApplicant(ui.getNewnumber());
	 	    tz.setChu(String.valueOf(chu));
	 	    tz.setZu(position.substring(4, 5));
	 	    tz.setTel(tel);
	 	    tz.setZhiwu(zhiwu);
	 	    tz.setYongtu(yongtu);
	 	    tz.setSex(sex);
	 	    tz.setNeednumber(neednumber);
	 	    tz.setTodepartment(todepartment);//0无，1第一天下午，2最后一天上午，3=1+2
	 	    tz.setRemark(remark);
	 	   
	 	    
	 	    
	 	    	if(result.equals("success"))
	 	    	{
	 	    		tzdao.merge(tz);
	 	    	}
	 	    	else
	 	    	{
	 	    		trans.rollback();
		    		return result;
	 	    	}
	 	    	 trans.commit();
	 			session.flush();
	 			session.clear();
	 			session.close();
	 			
	 			return result;
	 	    	
	 	    }
	 	   
		

		/**
		 * 判断两个人是否是同一个处室
		 * @param name1
		 * @param name2
		 * @return 是true,否false
		 */
		public boolean ifSameChu(String name1,String name2)
		{
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui1 = uidao.findByName(name1);
			UserInfo ui2 = uidao.findByName(name2);
			String chu1 = ui1.getPosition().substring(2, 3);
			String chu2 = ui2.getPosition().substring(2, 3);
			if(chu1.equals(chu2))
			{
				return true;	
			}
			else
			{
				return false;
			}
		}
		public boolean ifSameChu(String names)
		{
			String[] name = names.split("、");
			for(int i=0;i<name.length;i++)
			{
				for(int j=i;j<name.length;j++)
				{
					if(!ifSameChu(name[i],name[j]))
					{
						return false;
					}
				}
			}
			return true;
		}
}
