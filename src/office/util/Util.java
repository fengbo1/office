package office.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import office.config.pojo.Config;
import office.jbsp.dao.JbspPageDAO;
import office.jbsp.dao.JbspSummaryDAO;
import office.jbsp.pojo.JbspPage;
import office.jbsp.pojo.JbspSummary;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlMonth;
import office.kqjl.pojo.KqjlUpload;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeaveMonthSummaryDAO;
import office.leave.dao.LeavePageDAO;
import office.leave.dao.LeaveSummaryDAO;
import office.leave.pojo.LeaveMonthSummary;
import office.leave.pojo.LeavePage;
import office.leave.pojo.LeaveProcess;
import office.leave.pojo.LeaveSummary;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MonthSummary;
import office.pb.dao.PbMxDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.PbMx;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.ScpbTable;
import office.pb.pojo.ScpbTeam;
import office.pb.pojo.YgpbPlan;
import office.pb2.pojo.TbsqPage;
import office.pb2.pojo.XxsqPage;
import office.uass.pojo.UassCostHnPeople;
import office.uass.pojo.UassCostWb;
import office.uass.pojo.UassPt;
import office.uass.pojo.UassPtPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.wcgg.dao.WcggBaodaoDAO;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.dao.WcggSummaryDAO;
import office.wcgg.pojo.WcggBaodao;
import office.wcgg.pojo.WcggPage;
import office.wcgg.pojo.WcggSummary;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 * 乱七八糟小工具
 * @author htzx
 *
 */
public class Util {


	//public static final String basepath = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/office/" ;//服务器
	public static final String basepath ="C:/Program Files/apache-tomcat-7.0.59/webapps/office/";

	//public static final String basepath ="D:/Program Files/Apache Software Foundation/apache-tomcat-7.0.59/webapps/office/";

	public static final String downloadpath = basepath+"derive/" ;//下载
	public static final String mubanpath = basepath+"templet/" ;//下载
	public static final String jihepath = basepath+"file/jihefile/" ;//稽核文件
	public static final String ptpath = basepath+"file/ptfile/" ;//平台用户文件
	public static final String ctpath = basepath+"file/costfile/" ;//cost文件

	public static final int pagesize=10;
	public static final String zcqd = "08:30:00";
	public static final String zcqt = "17:00:00";
	public static final String xwbqd = "09:30";
	public static final String dwbqd = "11:00";
	public static final String beginday = "01";
	public static final String endday = "31";
	public static final List<Integer> leavedays = Arrays.asList(4,5,6,7,8,9,13,14);//婚产探丧工，陪考假，哺乳假
	public static final List<Integer> leaveworkdays = Arrays.asList(1,2,3,10,11,12);//年病，事，公，加，产检

	//尺子=123456789A123456789B123456789C123456789D123456789E123456789F123456789G
	
	public static String dateToStandard(String date)
	{
		return date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
	}
	/**
	 * 如果是空
	 * @param s
	 * @return
	 */
	public static boolean ifEmpty(String s){
		if(s==null||s.equalsIgnoreCase("null")||s.isEmpty()||s.equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static String statusToString(Integer status)
	{
		String result = "";
		if(status==0)
		{
			result = "等待撤销";
		}
		else if(status==1)
		{
			result = "流转中";
		}
		else if(status==2)
		{
			result = "流转中";
		}
		else if(status==3)
		{
			result = "等待报到";
		}
		else if(status==4)
		{
			result = "已办结";
		}
		else if(status==5)
		{
			result = "已退回";
		}
		else if(status==6)
		{
			result = "已撤销";
		}
		else if(status==7)
		{
			result = "待确认";
		}
		else if(status==8)
		{
			result = "待领取护照";
		}
		else if(status==9)
		{
			result = "待归还护照";
		}
		else if(status==10)
		{
			result="已审批通过";
		}
		else if(status==11)
		{
			result = "已办结";
		}
		else if(status==12)
		{
			result="已审批通过，待调整门禁权限";
		}
		else if(status==13)
		{
			result="门禁权限调整成功，待申请人确认";
		}
		else if(status==14)
		{
			result="已审批通过，待中心资产管理员分配资产编号";
		}
		else if(status==15)
		{
			result="资产编号已分配，请处室管理员分配资产到个人，并领取资产核对编号！";
		}
		else if(status==16)
		{
			result="待UASS管理员处理";
		}
		else if(status==17)
		{
			result="待归还借用资产";
		}
		else if(status==18)
		{
			result="已审批通过，联系中心资产管理员归还资产";
		}
		return result;
	}
	public static String baodaoStatusToString(Integer status)
	{
		String result = "";
		if(status==1)
		{
			result = "等待报到";
		}
		else if(status==2)
		{
			result = "已报到";
		}
		else
		{
			result = "流转中";
		}
		return result;
	}
	
	public static String applyorborrowToString(Integer status)
	{
		String result = "";
		if(status==3)
		{
			result = "借用归还";
		}
		else if(status==2)
		{
			result = "领用归还";
		}
		return result;
	}
	public static String wupinToString(Integer iswupin)
	{
		String result = "";
		if(iswupin==1)
		{
			result = "资产";
		}
		else if(iswupin==0)
		{
			result = "物品";
		}
		return result;
	}
	
	public static String restToString(Integer status)
	{
		String result = "";
		if(status==0)
		{
			result = "否";
		}
		else if(status==1)
		{
			result = "是";
		}
		return result;
	}
	
	public static String isandborrowToString(Integer status)
	{
		String result = "";
		if(status==1)
		{
			result = "有续借";
		}
		else if(status==0)
		{
			result = "无续借";
		}
		return result;
	}
	
	public static String qdqtToString(Integer qdqt)
	{
		String result = "";
		if(qdqt==1)
		{
			result = "签到";
		}
		else if(qdqt==2)
		{
			result = "签退";
		}
		else
		{
			result = "无勾选";
		}
		return result;
	}
	public static String yesOrNot(Integer input)
	{
		String result = "";
		if(input==1)
		{
			result = "是";
		}
		else
		{
			result = "否";
		}
		return result;
	}
	public static String intToSxw(Integer input)
	{
		String result = "";
		if(input==2)
		{
			result = "下午";
		}
		else if(input==1)
		{
			result = "上午";
		}
		else if(input==0)
		{
			result = "全天";
		}
		else
		{
			result = "";
		}
		return result;
	}
	/**
	 * 如果字符串数组中存在相同字符串
	 * @param input
	 * @return
	 */
	public static boolean ifHasSame(String[] input)
	{
		boolean flag=true;
		for(int i=0;i<input.length;i++)
		{
			for(int j=i+1;j<input.length;j++)
			{
				if(input[i].equals(input[j]))
				{
					flag = false;
				}
			}
		}
		return flag;
	}
	/**
	 * 20150103-->2015年01月03日
	 * @param simple
	 * @return
	 */
	public static String simpleToStanderd(String simple)
	{
		return simple.substring(0,4)+"年"+simple.substring(4,6)+"月"+simple.substring(6,8)+"日";
	}
//	public static String underToString(String under)
//	{
//		String result = "";
//		if(under.equals("A"))
//		{
//			result = "主任";
//		}
//		else if(under.equals("B"))
//		{
//			result = "主任";
//		}
//	}
	/**
	 * 根据position得到组别
	 * @param position
	 * @return
	 */
	public static String positionToTeam(String position)
	{
		String result = "";
		if(position!=null&&position.length()>=5)
		{
			result=position.charAt(4)+"组";
		}
		return result;
	}
	
	public static int lenthOfString(String input)
	{
		return input.length();
	}
	/**
	 * 考勤缺失类型转换为文字描述
	 * @param type
	 * @return
	 */
	public static String qdqsTypeToString(Integer type)
	{
		String result = "";
		if(type==0)
		{
			result="";
		}
		else if(type==1)
		{
			result="缺失";
		}
		else if(type==2)
		{
			result="迟到";
		}
		else if(type==3)
		{
			result="补签到";
		}
		else if(type==4)
		{
			result="请假";
		}
		else if(type==5)
		{
			result="公干";
		}
		return result; 
	}
	/**
	 * 考勤缺失类型转换为文字描述
	 * @param type
	 * @return
	 */
	public static String qtqsTypeToString(Integer type)
	{
		String result = "";
		if(type==0)
		{
			result="";
		}
		else if(type==1)
		{
			result="缺失";
		}
		else if(type==2)
		{
			result="早退";
		}
		else if(type==3)
		{
			result="补签退";
		}
		else if(type==4)
		{
			result="请假";
		}
		else if(type==5)
		{
			result="公干";
		}
		return result; 
	}
	
	/**
	 * 考勤缺失类型转换为文字描述
	 * @param type
	 * @return
	 */
	public static String qdqtTypeToString(Integer type1,Integer type2)
	{
		String result = "";
		if(type1==1)
		{
			result="";
		}
		else if(type1==2)
		{
			result="迟到";
		}
		else if(type1==3)
		{
			result="补签到";
		}
		else
		{
			result="";
		}
		if(type1>1&&type1<4&&type2>1&&type2<4)
		{
			result+="/";
		}
		if(type2==1)
		{
			result+="";
		}
		else if(type2==2)
		{
			result+="早退";
		}
		else if(type2==3)
		{
			result+="补签退";
		}
		else
		{
			result+="";
		}
		return result; 
	}
	/**
	 * 增加5分钟
	 * 输入00:00:00
	 * 输出00:05:00
	 * @param time
	 * @return
	 */
	public static String plusFiveMinutes(String time)
	{
		String result = "";
		if(time.split(":").length>1)
		{
			int shi = Integer.valueOf(time.split(":")[0]);
			int fen = Integer.valueOf(time.split(":")[1]);
			String miao = "";
			if(time.split(":").length>2)
			{
				miao = time.split(":")[2];
			}
			else
			{
				miao = "00";
			}
			fen+=5;
			if(fen>=60)
			{
				fen -=60;
				shi +=1;
			}
			String strshi = String.valueOf(shi);
			String strfen = String.valueOf(fen);
			if(shi<10)
			{
				strshi = "0"+strshi;
			}
			if(fen<10)
			{
				strfen = "0"+strfen;
			}
			result = strshi+":"+strfen+":"+miao;
		}
		return result;
	}
	/**
	 * 减少5分钟
	 * 输入00:05:00
	 * 输出00:00:00
	 * @param time
	 * @return
	 */
	public static String jianFiveMinutes(String time)
	{
		String result = "";
		if(time.split(":").length>1)
		{
			int shi = Integer.valueOf(time.split(":")[0]);
			int fen = Integer.valueOf(time.split(":")[1]);
			String miao = "";
			if(time.split(":").length>2)
			{
				miao = time.split(":")[2];
			}
			else
			{
				miao = "00";
			}
			if(fen>=5)
			{
				fen -=5;
			}
			else{
				fen+=55;
				if(shi>0)
				shi-=1;
			}
			String strshi = String.valueOf(shi);
			String strfen = String.valueOf(fen);
			if(shi<10)
			{
				strshi = "0"+strshi;
			}
			if(fen<10)
			{
				strfen = "0"+strfen;
			}
			result = strshi+":"+strfen+":"+miao;
		}
		return result;
	}
	public static String ygxxReasonToString(Integer type)
	{
		String result = "";
		if(type==1)
		{
			result = "优化创新";
		}
		else if(type==2)
		{
			result = "项目借调";
		}
		else if(type==3)
		{
			result = "外出公干";
		}
		else if(type==4)
		{
			result = "员工培训";
		}
		else if(type==5)
		{
			result = "中心检查";
		}
		else if(type==6)
		{
			result = "业务监控";
		}
		else if(type==7)
		{
			result = "临时抽调";
		}
		else if(type==8)
		{
			result = "轮岗实习";
		}
		else if(type==9)
		{
			result = "加班调休";
		}
		else if(type==10)
		{
			result = "党团工会";
		}
		else if(type==11)
		{
			result = "产量下线";
		}
		else if(type==12)
		{
			result = "组长下线";
		}
		else if(type==20)
		{
			result = "其他";
		}
		return result;
	}
	
	
}



////
