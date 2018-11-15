package office.util;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

/**
 * 与用户信息相关的工具函数
 * @author htzx
 *
 */
public class UserUtil {

	/**
	 * 根据身份证号返回性别
	 * @param identity
	 * @return
	 */
	public static String getSexFromIdentity(String identity)
	{
		int sex = 0;
		if(identity==null||identity.length()<3)
		{
			return "未知";
		}
		else
		{
			sex = Integer.parseInt(identity.substring(identity.length()-2,identity.length()-1));//倒数第二位
			if(sex%2==1)
			{
				return "男";
			}
			else
			{
				return "女";
			}
		}
	}
	public static String getBirthFromIdentity(String identity)
	{
		String Birth = "";
		if(identity==null||identity.length()<3)
		{
			return "未知";
		}
		else
		{
			Birth = identity.substring(6,identity.length()-8)+"-"+identity.substring(10,identity.length()-6)+"-"+identity.substring(12,identity.length()-4);//5101811988
			return Birth;
		}
	}
	/**
	 * 处室转化为描述
	 * @param s
	 * @return
	 */
	public static String cToName(Integer c)
	{
		if(c==null)
		{
			return "-";
		}
		if(c==0)
		{
			return "主任办公室";
		}
		else if(c==1)
		{
			return "综合与生产管理处";
		}
		else if(c==2)
		{
			return "合规与监督二处";
		}
		else if(c==3)
		{
			return "通用业务二处";
		}
		else if(c==4)
		{
			return "员工响应团队";
		}
		else if(c==5)
		{
			return "研发支持二处";
		}
		else if(c==6)
		{
			return "专业处理二处";
		}
		else if(c==7)
		{
			return "库房";
		}
		else if(c==11)
		{
			return "成都维度";
		}
		else if(c==12)
		{
			return "成都银雁";
		}
		else if(c==13)
		{
			return "威科姆";
		}
		else if(c==14)
		{
			return "银河万佳";
		}
		else if(c==15)
		{
			return "民兴物业";
		}
		
		else
		{
			return "其他";
		}
	}
	/**
	 * position转化为描述
	 * @param s
	 * @return
	 */
	public static String positionToName(String position)
	{
		if(position==null||position.equals(""))
		{
			return "";
		}
		else
		{
			String c = position.substring(2, 3);
			String t = position.substring(4, 5);
			String z = position.substring(0, 1);
			
			if(c.equals("1"))
			{
				return "综合与生产管理处";
			}
			else if(c.equals("2"))
			{
				if(z.equals("3")||z.equals("4"))
				{
					if(t.equals("1"))
					{
						return "集中稽核组";
					}
					else if(t.equals("2"))
					{
						return "反洗钱组";
					}
					else if(t.equals("3"))
					{
						return "柜面授权";
					}
					else
					{
						return "合规"+t+"组";
					}
				}
				else
				{
					return "合规与监督二处";
				}
			}
			else if(c.equals("3"))
			{
				if(z.equals("3")||z.equals("4"))
				{
					return "业务处理"+t+"组";
				}
				else
				{
					return "通用业务二处";
				}
			}
			else if(c.equals("4"))
			{
				return "员工响应团队";
			}
			else if(c.equals("5"))
			{
				return "研发支持二处";
			}
			else if(c.equals("6"))
			{
				if(z.equals("3")||z.equals("4"))
				{
					return "专业处理"+t+"组";
				}
				else
				{
					return "专业处理二处";
				}
			}
			else
			{
				return "其他";
			}
		}
	}
	/**
	 * 处室名称
	 */
	public static String chuToName(String chu)
	{
		if(chu.equals("1"))
		{
			return "综合与生产管理处";
		}
		else if(chu.equals("2"))
		{
			return "合规与监督二处";
		}
		else if(chu.equals("3"))
		{
			return "通用业务二处";
		}
		else if(chu.equals("4"))
		{
			return "员工响应团队";
		}
		else if(chu.equals("5"))
		{
			return "研发支持二处";
		}
		else if(chu.equals("6"))
		{
			return "专业处理二处";
		}
		else if(chu.equals("11"))
		{
			return "维度";
		}
		else if(chu.equals("12"))
		{
			return "银雁";
		}
		else if(chu.equals("13"))
		{
			return "威科姆";
		}
		else if(chu.equals("14"))
		{
			return "银河万佳";
		}
		else if(chu.equals("15"))
		{
			return "民兴物业";
		}
		else
		{
			return "";
		}
	}
	/**
	 * 下一级负责人名称
	 * @param s
	 * @return
	 */
	public static String positionTofzr(String position)
	{
		if(position==null||position.equals(""))
		{
			return "";
		}
		else
		{
			char c = position.charAt(2);
			char t = position.charAt(4);
			char z = position.charAt(0);
			
			if(z=='1')//处长
			{
				if(c=='1')
				{
					return "分中心主任";
				}
				else
				{
					return "综合与生产管理处";
				}
			}
			else if(c=='3'&&z=='3')
			{
				return "业务处理"+t+"组";
			}
			else if(c=='6'&&z=='3')
			{
				return "专业处理"+t+"组";
			}
			else if(c=='2'&&z=='3')
			{
				if(t=='1')
				{
					return "集中稽核组";
				}
				else if(t=='2')
				{
					return "反洗钱组";
				}
				else if(t=='3')
				{
					return "柜面授权";
				}
				else
				{
					return "";
				}
				
			}
//			else if(c=='3'&&z=='4')
//			{
//				return "业务处理"+t+"组";
//			}
//			else if(c=='6'&z=='4')
//			{
//				return "专业处理"+t+"组";
//			}
			else
			{
				if(c=='1')
				{
					return "综合与生产管理处";
				}
				else if(c=='2')
				{
					return "合规与监督二处";
				}
				else if(c=='3')
				{
					return "通用业务二处";
				}
				else if(c=='4')
				{
					return "员工响应团队";
				}
				else if(c=='5')
				{
					return "研发支持二处";
				}
				else if(c=='6')
				{
					return "专业处理二处";
				}
				else
				{
					return "";
				}
			}
		}
	}
	/**
	 * 处室转化为数字
	 * @param s
	 * @return
	 */
	public static Integer cToInteger(String c)
	{
		if(c==null)
		{
			return -1;
		}
		if(c.contains("综合")||c.contains("生产"))
		{
			return 1;
		}
		else if(c.contains("合规"))
		{
			return 2;
		}
		else if(c.contains("通用"))
		{
			return 3;
		}
		else if(c.contains("响应"))
		{
			return 4;
		}
		else if(c.contains("渠道")||c.contains("研发"))
		{
			return 5;
		}
		else if(c.contains("专业"))
		{
			return 6;
		}
		else
		{
			return -1;
		}
	}
	/**
	 * 团队转化为描述
	 * @param s
	 * @return
	 */
	public static String tToName(Integer c,Integer t)
	{	
		
		if(c==3)
		{		
			if(t==0)
			{
				return "";
			}
			else
			{
				return "业务处理"+t+"组";
			}
					
		}
		else if(c==6)
		{
			if(t==0)
			{
				return "";
			}
			else
			{
				return "专业处理"+t+"组";
			}
		}
		else if(c==2)
		{
			if(t==1)
			{
				return "集中稽核组";
			}
			else if(t==2)
			{
				return "反洗钱组";
			}
			else if(t==3)
			{
				return "柜面授权";
			}
			else 
			{
				return "";
			}
			
		}
		else{
			return "";
		}
	}
	/**
	 * 分组中提取数字
	 * @param zx
	 * @return
	 */
	public static Integer teamToTnteger(String team)
	{
		String str2 = "";
		if (team == null) {
			return -1;
		} else {
			team = team.trim();
			if (!"".equals(team)) {
				for (int i = 0; i < team.length(); i++) {
					if (team.charAt(i) >= 48 && team.charAt(i) <= 57) {
						str2 += team.charAt(i);
					}
				}
				if(!"".equals(str2))
				return Integer.parseInt(str2);
			}
			return -1;
		}
			
	}
	
	public static String authoToName(String autho)
	{
		String result = "";
		if(autho==null)
		{
			result = "";
		}
		if(autho.contains("A"))
		{
			result = "分中心负责人";
		}
		if(autho.contains("B"))
		{
			if(!result.equals(""))
			{
				result += "、处室负责人";
			}
			else
				{
				result = "处室负责人";
				}
		}
		if(autho.contains("C"))
		{
			if(!result.equals(""))
			{
				result += "、团队负责人";
			}
			else
			{
				result = "团队负责人";
			}
			
			
		}
		if(autho.contains("D"))
		{
			if(!result.equals(""))
			{
				result += "、小组长";
			}
			else
			{
				result = "小组长";
			}
			
		}
		if(autho.contains("F"))
		{
			if(!result.equals(""))
			{
				result += "、印章管理员";
			}
			else
			{
				result = "印章管理员";
			}
			
		}
		if(autho.contains("I"))
		{
			if(!result.equals(""))
			{
				result += "、考勤管理员";
			}
			else
			{
				result = "考勤管理员";
			}
			
		}
	   if(autho.contains("J"))
		{
			if(!result.equals(""))
			{
				result += "、薪酬管理员";
			}
			else
			{
				result = "薪酬管理员";
			}
		
		}
	   if(autho.contains("K"))
		{
			if(!result.equals(""))
			{
				result += "、因私出境管理员";
			}
			else
			{
				result = "因私出境管理员";
			}
			
			
		}
		if(autho.contains("M"))
		{
			if(!result.equals(""))
			{
				result += "、中心资产管理员";
			}
			else
			{
				result = "中心资产管理员";
			}
			
		}
		if(autho.contains("N"))
		{
			if(!result.equals(""))
			{
				result += "、资产管理员";
			}
			else
			{
				result = "资产管理员";
			}
			
		}
		if(autho.contains("O"))
		{
			if(!result.equals(""))
			{
				result += "、参数维护审批人";
			}
			else
			{
				result = "参数维护审批人";
			}
			
		}
		if(autho.contains("P"))
		{
			if(!result.equals(""))
			{
				result += "、资产审核员";
			}
			else
			{
				result = "资产审核员";
			}
			
		}
		if(autho.contains("Q"))
		{
			if(!result.equals(""))
			{
				result += "、门禁管理员";
			}
			else
			{
				result = "门禁管理员";
			}
			
		}
		if(autho.contains("R"))
		{
			if(!result.equals(""))
			{
				result += "、外包管理员";
			}
			else
			{
				result = "外包管理员";
			}
			
		}
		if(autho.contains("S"))
		{
			if(!result.equals(""))
			{
				result += "、监控管理员";
			}
			else
			{
				result = "监控管理员";
			}
			
		}
		if(autho.contains("T"))
		{
			if(!result.equals(""))
			{
				result += "、生产排班管理员";
			}
			else
			{
				result = "生产排班管理员";
			}
		}
		return result;
	}
	
	public static String roleChangeToString(String before,String after,String pool)
	{
		String result="";
		if(!before.isEmpty()&&!after.isEmpty())
		{
			if(pool.equals("891"))
			{
				int length = before.length()>after.length()?after.length(): before.length();
				for(int i=0;i<length;i++)
				{
					char bf = before.charAt(i);
					char af = after.charAt(i);
					if(bf!=af)
					{
						String op = "";
						if(bf=='0'&&af=='1')
						{
							op="增加";
						}
						else if(bf=='1'&&af=='0')
						{
							op="取消";
						}
						if(i==0)
						{
							result+=op;
							result+="891基本信息查询";
							result+="、";
						}
						else if(i==1)
						{
							result+=op;
							result+="891影像拆分";
							result+="、";
						}
						else if(i==2)
						{
							result+=op;
							result+="891版面识别";
							result+="、";
						}
						else if(i==3)
						{
							result+=op;
							result+="891录入修改";
							result+="、";
						}
						else if(i==4)
						{
							result+=op;
							result+="891录入修改主管";
							result+="、";
						}
						
						else if(i==5)
						{
							result+=op;
							result+="891检核修改";
							result+="、";
						}
						else if(i==6)
						{
							result+=op;
							result+="891检核修改主管";
							result+="、";
						}
						else if(i==7)
						{
							result+=op;
							result+="891初审录入";
							result+="、";
						}
						else if(i==8)
						{
							result+=op;
							result+="891专业复审";
							result+="、";
						}
						else if(i==9)
						{
							result+=op;
							result+="891对公账户资料处理";
							result+="、";
						}
						else if(i==10)
						{
							result+=op;
							result+="891人工分析CCBS失败角色";
							result+="、";
						}
						else if(i==11)
						{
							result+=op;
							result+="商户资料审核";
							result+="、";
						}
						else if(i==12)
						{
							result+=op;
							result+="商户发布失败处理";
							result+="、";
						}
						else if(i==16)
						{
							result+=op;
							result+="891对私汇出初审";
							result+="、";
						}
						else if(i==17)
						{
							result+=op;
							result+="891对私汇出复审";
							result+="、";
						}
						else if(i==18)
						{
							result+=op;
							result+="891外汇票据初审";
							result+="、";
						}
						else if(i==19)
						{
							result+=op;
							result+="891外汇票据复审";
							result+="、";
						}
						else if(i==20)
						{
							result+=op;
							result+="891外汇检核修改授权";
							result+="、";
						}
						else if(i==21)
						{
							result+=op;
							result+="891外汇检核修改";
							result+="、";
						}
						else if(i==22)
						{
							result+=op;
							result+="891外汇失败原因分析";
							result+="、";
						}
						else if(i==23)
						{
							result+=op;
							result+="891外汇录入修改授权";
							result+="、";
						}
						else if(i==24)
						{
							result+=op;
							result+="891外汇录入修改";
							result+="、";
						}
						else if(i==25)
						{
							result+=op;
							result+="891外汇专项查询角色";
							result+="、";
						}
						else if(i==26)
						{
							result+=op;
							result+="外汇汇入对私初审";
							result+="、";
						}
						else if(i==27)
						{
							result+=op;
							result+="外汇汇入对私复审";
							result+="、";
						}
						else if(i==28)
						{
							result+=op;
							result+="对公汇出初审";
							result+="、";
						}
						else if(i==29)
						{
							result+=op;
							result+="对公汇出复审";
							result+="、";
						}
						else if(i==30)
						{
							result+=op;
							result+="外汇汇入对公初审";
							result+="、";
						}
						else if(i==31)
						{
							result+=op;
							result+="外汇汇入对公复审";
							result+="、";
						}
						///
						else if(i==32)
						{
							result+=op;
							result+="891报表查询角色";
							result+="、";
						}
						else if(i==33)
						{
							result+=op;
							result+="891生产排班角色";
							result+="、";
						}
						else if(i==34)
						{
							result+=op;
							result+="891生产排班管理角色";
							result+="、";
						}
						else if(i==35)
						{
							result+=op;
							result+="891日始日终角色";
							result+="、";
						}
						else if(i==36)
						{
							result+=op;
							result+="891统计分析角色";
							result+="、";
						}
						else if(i==37)
						{
							result+=op;
							result+="891总行业务监控角色";
							result+="、";
						}
						else if(i==38)
						{
							result+=op;
							result+="891总行集中处理中心监控角色";
							result+="、";
						}
						else if(i==40)
						{
							result+=op;
							result+="海外要素录入修改";
							result+="、";
						}
						else if(i==41)
						{
							result+=op;
							result+="海外录入修改复核";
							result+="、";
						}
						else if(i==42)
						{
							result+=op;
							result+="海外票据审核";
						}
					}
				}
			}
			else if(pool.equals("890"))
			{
				int length = before.length()>after.length()?after.length(): before.length();
				for(int i=0;i<length;i++)
				{
					char bf = before.charAt(i);
					char af = after.charAt(i);
					if(bf!=af)
					{
						String op = "";
						if(bf=='0'&&af=='1')
						{
							op="增加";
						}
						else if(bf=='1'&&af=='0')
						{
							op="取消";
						}
						if(i==0)
						{
							result+=op;
							result+="890报表查询角色";
							result+="、";
						}
						else if(i==1)
						{
							result+=op;
							result+="890统计分析角色";
							result+="、";
						}
						else if(i==2)
						{
							result+=op;
							result+="890总行业务监控角色";
							result+="、";
						}
						else if(i==3)
						{
							result+=op;
							result+="890日始日终角色";
							result+="、";
						}
						else if(i==4)
						{
							result+=op;
							result+="890基本信息查询角色";
						}
					}
				}
			}
		}
		
		return result;
	}
	public static String roleNewToString(String role,String pool)
	{
		String result="";
		if(!role.isEmpty())
		{
			if(pool.equals("891"))
			{
				for(int i=0;i<role.length();i++)
				{
					if(role.charAt(i)=='1')
					{
						if(i==0)
						{
							result+="891基本信息查询";
							result+="、";
						}
						else if(i==1)
						{
							result+="891影像拆分";
							result+="、";
						}
						else if(i==2)
						{
							result+="891版面识别";
							result+="、";
						}
						else if(i==3)
						{
							result+="891录入修改";
							result+="、";
						}
						else if(i==4)
						{
							result+="891录入修改主管";
							result+="、";
						}
						
						else if(i==5)
						{
							
							result+="891检核修改";
							result+="、";
						}
						else if(i==6)
						{
							
							result+="891检核修改主管";
							result+="、";
						}
						else if(i==7)
						{
							
							result+="891初审录入";
							result+="、";
						}
						else if(i==8)
						{
							
							result+="891专业复审";
							result+="、";
						}
						else if(i==9)
						{
							
							result+="891对公账户资料处理";
							result+="、";
						}
						else if(i==10)
						{
							result+="891人工分析CCBS失败角色";
							result+="、";
						}
						else if(i==11)
						{
							result+="商户资料审核";
							result+="、";
						}
						else if(i==12)
						{
							result+="商户发布失败处理";
							result+="、";
						}
						else if(i==16)
						{
							
							result+="891对私汇出初审";
							result+="、";
						}
						else if(i==17)
						{
							
							result+="891对私汇出复审";
							result+="、";
						}
						else if(i==18)
						{
							
							result+="891外汇票据初审";
							result+="、";
						}
						else if(i==19)
						{
							
							result+="891外汇票据复审";
							result+="、";
						}
						else if(i==20)
						{
							
							result+="891外汇检核修改授权";
							result+="、";
						}
						else if(i==21)
						{
							
							result+="891外汇检核修改";
							result+="、";
						}
						else if(i==22)
						{
							
							result+="891外汇失败原因分析";
							result+="、";
						}
						else if(i==23)
						{
							
							result+="891外汇录入修改授权";
							result+="、";
						}
						else if(i==24)
						{
							
							result+="891外汇录入修改";
							result+="、";
						}
						else if(i==25)
						{
							
							result+="891外汇专项查询角色";
							result+="、";
						}
						else if(i==26)
						{
							result+="外汇汇入对私初审";
							result+="、";
						}
						else if(i==27)
						{
							result+="外汇汇入对私复审";
							result+="、";
						}
						else if(i==28)
						{
							result+="对公汇出初审";
							result+="、";
						}
						else if(i==29)
						{
							result+="对公汇出复审";
							result+="、";
						}
						else if(i==30)
						{
							result+="外汇汇入对公初审";
							result+="、";
						}
						else if(i==31)
						{
							result+="外汇汇入对公复审";
							result+="、";
						}///
						else if(i==32)
						{
							
							result+="891报表查询角色";
							result+="、";
						}
						else if(i==33)
						{
							
							result+="891生产排班角色";
							result+="、";
						}
						else if(i==34)
						{
							
							result+="891生产排班管理角色";
							result+="、";
						}
						else if(i==35)
						{
							
							result+="891日始日终角色";
							result+="、";
						}
						else if(i==36)
						{
							
							result+="891统计分析角色";
							result+="、";
						}
						else if(i==37)
						{
							
							result+="891总行业务监控角色";
							result+="、";
						}
						else if(i==38)
						{
							
							result+="891总行集中处理中心监控角色";
							result+="、";
						}
						else if(i==40)
						{
							result+="海外要素录入修改";
							result+="、";
						}
						else if(i==41)
						{
							result+="海外录入修改复核";
							result+="、";
						}
						else if(i==42)
						{
							result+="海外票据审核";
						}
					}
				}
			}
			else if(pool.equals("890"))
			{
				for(int i=0;i<role.length();i++)
				{
					if(role.charAt(i)=='1')
					{
						if(i==0)
						{
							
							result+="890报表查询角色";
							result+="、";
						}
						else if(i==1)
						{
							
							result+="890统计分析角色";
							result+="、";
						}
						else if(i==2)
						{
							
							result+="890总行业务监控角色";
							result+="、";
						}
						else if(i==3)
						{
							
							result+="890日始日终角色";
							result+="、";
						}
						else if(i==4)
						{
							
							result+="890基本信息查询角色";
						}
					}
				}
			}
		}
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
}
