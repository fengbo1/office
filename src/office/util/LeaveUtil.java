package office.util;

import java.util.ArrayList;
import java.util.List;

import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveSummaryDAO;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveSummary;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 请假审批相关的小工具
 * @author htzx
 *
 */
public class LeaveUtil {

	/**
	 * 1病假2年休假3事假4婚假5产假6探亲假（配偶）7探亲假（父母）8丧假9工伤假10公假11加班调休
	 * @param type
	 * @return
	 */
	public static String TypeToString(Integer type)
	{
		String result = "";
		if(type==1)
		{
			result = "病假";
		}
		else if(type==2)
		{
			result = "年休假";
		}
		else if(type==3)
		{
			result = "事假";
		}
		else if(type==4)
		{
			result = "婚假";
		}
		else if(type==5)
		{
			result = "产假（陪护假）";
		}
		
		else if(type==6)
		{
			result = "探亲假（配偶）";
		}
		else if(type==7)
		{
			result = "探亲假（父母）";
		}
		else if(type==8)
		{
			result = "丧假";
		}
		else if(type==9)
		{
			result = "工伤假";
		}
		else if(type==10)
		{
			result = "公假";
		}
		else if(type==11)
		{
			result = "加班调休";
		}
		else if(type==12)
		{
			result = "产检";
		}
		else if(type==13)
		{
			result = "陪考假";
		}
		else if(type==14)
		{
			result = "哺乳假";
		}
		return result;
	}
	
	/**
	 * 1病假2年休假3事假4婚假5产假6探亲假（配偶）7探亲假（父母）8丧假9工伤假10公假11加班调休
	 * @param type,identity身份证
	 * @return
	 */
	public static String TypeSexToString(String identity,Integer type)
	{
		String result = "";
		if(type==1)
		{
			result = "病假";
		}
		else if(type==2)
		{
			result = "年休假";
		}
		else if(type==3)
		{
			result = "事假";
		}
		else if(type==4)
		{
			result = "婚假";
		}
		else if(type==5)
		{
			String sex = UserUtil.getSexFromIdentity(identity);
			if(sex.equals("男"))
			{
				result = "陪护假";
			}
			else if(sex.equals("女"))
			{
				result = "产假";
			}
		}
		
		else if(type==6)
		{
			result = "探亲假（配偶）";
		}
		else if(type==7)
		{
			result = "探亲假（父母）";
		}
		else if(type==8)
		{
			result = "丧假";
		}
		else if(type==9)
		{
			result = "工伤假";
		}
		else if(type==10)
		{
			result = "公假";
		}
		else if(type==11)
		{
			result = "加班调休";
		}
		else if(type==12)
		{
			result = "产检";
		}
		else if(type==13)
		{
			result = "陪考假";
		}
		else if(type==14)
		{
			result = "哺乳假";
		}
		return result;
	}
	
	public static Integer TypeToInteger(String type)
	{
		Integer result = 0;
		if(type.contains("病"))
		{
			result = 1;
		}
		else if(type.contains("年"))
		{
			result = 2;
		}
		else if(type.contains("事"))
		{
			result = 3;
		}
		else if(type.contains("婚"))
		{
			result = 4;
		}
		else if(type.contains("产")||type.contains("护"))
		{
			result = 5;
		}
		else if(type.contains("偶"))
		{
			result = 6;
		}
		else if(type.contains("母"))
		{
			result = 7;
		}
		else if(type.contains("丧"))
		{
			result = 8;
		}
		else if(type.contains("伤"))
		{
			result = 9;
		}
		else if(type.contains("公"))
		{
			result = 10;
		}
		else if(type.contains("班"))
		{
			result = 11;
		}
		else if(type.contains("其")||type.contains("产检"))
		{
			result = 12;
		}
		else if(type.contains("考"))
		{
			result = 13;
		}
		else if(type.contains("哺"))
		{
			result = 14;
		}
		return result;
	}
	
	public static String statusToString(Integer status)
	{
		String result = "";
		
		if(status==0)
		{
			result = "已收回,请撤销后重新发起";
		}
		else if(status==1)
		{
			result = "流转中";
		}
		else if(status==2)
		{
			result = "已办结";
		}
		else if(status==3)
		{
			result = "已撤销";
		}
		else if(status==4)
		{
			result = "审批不同意，已退回";
		}
		else if(status==5)
		{
			result = "已收回";
		}
		else if(status==6)
		{
			result = "流转中";
		}
		else if(status==7)
		{
			result = "等待申请人销假中";
		}
		else if(status==8)
		{
			result = "等待管理员确认中";
		}
		else if(status==9)//可撤销状态
		{
			result = "流转中";
		}
		else
		{
			result = "未知";
		}
		
		return result;
	}
	public static String assetstatusToString(Integer status)
	{
		String result = "";
		
		if(status==1)
		{
			result = "在库";
		}
		else if(status==2)
		{
			result = "领用";
		}
		else if(status==3)
		{
			result = "借用";
		}		
		else if(status==4)
		{
			result = "报废";
		}
		else
		{
			result = "未知";
		}
		
		return result;
	}
	public static String NewNumberToName(String newnumber)
	{
		String result = "";
		if(newnumber==null)
		{
			result="无";
		}
		else
		{
			Session session = HibernateSessionFactory.getSession();
	 	    Transaction trans=session.beginTransaction();
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui = uidao.findByNewNumber(newnumber);
			if(ui==null)
			{
				result = "无";
			}
			else
			{
				result = ui.getUsername();
			}
	 		trans.commit();
	 		session.flush();
	 		session.clear();
	 		session.close();
		}
		return result;
	}
	public static String NewNumberToNameNoSession(String newnumber)
	{
		String result = "";
		if(newnumber==null)
		{
			result="无";
		}
		else
		{
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui = uidao.findByNewNumber(newnumber);
			if(ui==null)
			{
				result = "无";
			}
			else
			{
				result = ui.getUsername();
			}
		}
		return result;
	}
	public static String NameToNewNumber(String name)
	{
		String result = "";
		if(name==null)
		{
			result="无";
		}
		else
		{
			Session session = HibernateSessionFactory.getSession();
	 	    Transaction trans=session.beginTransaction();
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui = uidao.findByName(name);
			if(ui==null)
			{
				result = "无";
			}
			else
			{
				result = ui.getNewnumber();
			}
	 		trans.commit();
	 		session.flush();
	 		session.clear();
	 		session.close();
		}
		return result;
	}
	public static String NameToNewNumberNoSession(String name)
	{
		String result = "";
		if(name==null)
		{
			result="无";
		}
		else
		{
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui = uidao.findByName(name);
			if(ui==null)
			{
				result = "无";
			}
			else
			{
				result = ui.getNewnumber();
			}
		}
		return result;
	}
	/**
	 * 获得当前承办人代号
	 * @param number 请假单编号
	 * @return
	 */
	public String getThisUndertake(String number)
	{
		LeavePageDAO lpdao = new LeavePageDAO();
		ProcessDAO pdao = new ProcessDAO();
		LeavePage lp = lpdao.findByNumber(number);
		Process p = pdao.findByItemAndApplicant("QJSQ",lp.getProcess());
		String jindu = lp.getJindu();
		String proc = p.getProcess();
		return proc.substring(jindu.length(),jindu.length()+1);
	}
	/**
	 * 获得下一级承办人代号
	 * @param number 请假单编号
	 * @return
	 */
	public String getNextUndertake(String number)
	{
		LeavePageDAO lpdao = new LeavePageDAO();
		ProcessDAO pdao = new ProcessDAO();
		LeavePage lp = lpdao.findByNumber(number);
		Process p = pdao.findByItemAndApplicant("QJSQ",lp.getProcess());
		String jindu = lp.getJindu();
		String proc = p.getProcess();
		return proc.substring(jindu.length()+1,jindu.length()+2);
	}
	
	public static String opinionToString(Integer opinion)
	{
		String result = "";
		if(opinion==1)
		{
			result = "同意";
		}
		else if(opinion==2)
		{
			result = "不同意";
		}
		
		return result;
	}
	
	public static String pbTypeToString(String input1,String input2)
	{
		String result="";
		if(input1!=null&&!input1.equals("")&&input1.length()>2)
		{
			int shuzi = Integer.parseInt(input1.substring(2, input1.length()));
			String type = input1.substring(0, 2);
			if(type.equals("gg"))
			{
				result += "上午:外出公干  ";
			}
			else if(type.equals("qj"))
			{
				result += "上午:"+TypeToString(shuzi)+"  ";
			}
			else if(type.equals("xx"))
			{
				result += "上午:因公下线  ";
			}
		}
		if(input2!=null&&!input2.equals("")&&input2.length()>2)
		{
			int shuzi = Integer.parseInt(input2.substring(2, input2.length()));
			String type = input2.substring(0, 2);
			if(type.equals("gg"))
			{
				result += "下午:外出公干";
			}
			else if(type.equals("qj"))
			{
				result += "下午:"+TypeToString(shuzi);
			}
			else if(type.equals("xx"))
			{
				result += "下午:"+"因公下线";
			}
		}
		if(input1!=null&&input1.equals("wu")&&input2!=null&&input2.equals("wu"))
		{
			result="本天调休无排班";
		}
		return result;
	}
}

///////////////////


