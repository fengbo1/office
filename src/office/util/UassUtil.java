package office.util;

import office.uass.dao.UassCodeDAO;
import office.uass.pojo.UassCode;

public class UassUtil {

	/**
	 * 维护类型
	 * @param type
	 * @return
	 */
	public String typeToString(int type)
	{
		String result="";
		if(type==1)
		{
			result = "注销";
		}
		else if(type==2)
		{
			result = "修改";
		}
		else if(type==3)
		{
			result = "新增";
		}
		return result;
	}
	
	/**
	 * 角色代码转描述
	 * @param code
	 * @param pool
	 * @return
	 */
	public String codeToString(String code,String pool)
	{
		UassCodeDAO ucdao = new UassCodeDAO();
		String result = "";
		if(code!=null)
		{
			for(int i=0;i<code.length();i++)
			{
				char c = code.charAt(i);
				if(c=='1')
				{
					UassCode uc = ucdao.findCodeByPaixuAndPool(i, pool);
					if(uc!=null)
					{
						result += uc.getCode();
						result += ",";
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 角色代码转描述中文
	 * @param code
	 * @param pool
	 * @return
	 */
	public String codeToStringDetail(String code,String pool)
	{
		UassCodeDAO ucdao = new UassCodeDAO();
		String result = "";
		if(code!=null)
		{
			for(int i=0;i<code.length();i++)
			{
				char c = code.charAt(i);
				if(c=='1')
				{
					UassCode uc = ucdao.findCodeByPaixuAndPool(i, pool);
					if(uc!=null)
					{
						result += uc.getDetail();
						result += ",";
					}
				}
			}
		}
		return result;
	}
	
	public static String uassPtItemToString (String item)
	{
		String result = "";
		if(item.isEmpty())
		{
			
		}
		else if(item.length()<5)
		{
			
		}
		else
		{
			char tempc = item.charAt(0);
			if(tempc=='1')
			{
				result+="用户新增、";
			}
			tempc = item.charAt(1);
			if(tempc=='1')
			{
				result+="用户基本信息变更、";
			}
			tempc = item.charAt(2);
			if(tempc=='1')
			{
				result+="用户岗位信息变更、";
			}
			tempc = item.charAt(3);
			if(tempc=='1')
			{
				result+="机构基本信息变更、";
			}
			tempc = item.charAt(4);
			if(tempc=='1')
			{
				result+="机构权限或其他信息变更";
			}
			if(result.endsWith("、"))
			{
				result = result.substring(0, result.length()-1);
			}
		}
		return result;
	}
	public static String yesOrNot(Integer input)
	{
		String result = "";
		if(input==1)
		{
			result = "生效";
		}
		else
		{
			result = "注销";
		}
		return result;
	}
}
