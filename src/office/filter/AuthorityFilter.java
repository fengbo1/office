package office.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class AuthorityFilter implements Filter{

	private static Logger logger = Logger.getLogger(AuthorityFilter.class);
	private FilterConfig filterConfig;
    
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        ServletContext context = this.filterConfig.getServletContext();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String IP = (String) session.getAttribute("IP");
        String url = req.getRequestURI();
       
        if(url.startsWith("/office/page")&&url.endsWith("authorityfailed.jsp"))
        {
        	 res.sendRedirect("./../authorityfailed.jsp");
        }
        else if ((session.getAttribute("username") != null)||url.endsWith("login.action")||url.endsWith("modify.jsp")||url.endsWith("Modify.action")) {
            context.log("身份认证通过，进入下一步处理 ");
            logger.info(username+"IP:"+IP+"url:"+url);
            session.setAttribute("daohang", getDaohangByURL(url,"",""));
            chain.doFilter(request, response);
           
        } else {
            context.log("身份认证失败，直接返回");
            logger.info(username+"IP:"+IP+"url:"+url);
            res.sendRedirect("authorityfailed.jsp");
        }
    }

    public void destroy() {
        this.filterConfig = null;
    }
    
    public String getDaohangByURL(String url,String type,String dai)
    {
    	String result = "";
    	if(type==null)
    	{
    		type="";
    	}
    	if(dai==null)
    	{
    		dai = "";
    	}
    	if(url.contains("user.action"))
    	{
    		if(type.equals("find_all"))
    		{
    			result = "用户信息->查询所有";
    		}
    		else
    		{
    			result = "用户信息->修改密码";
    		}
    	}
    	else if(url.contains("leave.action"))
    	{
    		if(dai.equals("1"))
    		{
    			result = "请假申请->发起申请->代发起";
    		}
    		else
    		{
    			result = "请假申请->发起申请";
    		}
    		
    	}
    	else if(url.contains("viewapply.action"))
    	{
    		if(type.equals("lz"))
    		{
    			result = "请假申请->查看申请->流转中";
    		}
    		else if(type.equals("ybj"))
    		{
    			result = "请假申请->查看申请->已办结";
    		}
    		else
    		{
    			result = "请假申请->查看申请";
    		}
    		
    	}
    	else if(url.contains("viewundertake.action"))
    	{
    		result = "请假申请->本人承办->待办事宜";
    	}
    	else if(url.contains("viewycb.action"))
    	{
    		result = "请假申请->本人承办->已承办";
    	}
    	else if(url.contains("viewall.action"))
    	{
    		result = "请假申请->统计查询->明细查询";
    	}
    	else if(url.contains("viewsummary.action"))
    	{
    		result = "请假申请->统计查询->汇总查询";
    	}
    	else if(url.contains("importcalendar.action"))
    	{
    		result = "日历表->导入日历表";
    	}
    	else if(url.contains("showwcggpage.action"))
    	{
    		result = "外出公干->发起申请->本人发起";
    	}
    	else if(url.contains("viewwcgg.action"))
    	{
    		result = "外出公干->查看申请->流转中";
    	}
    	else if(url.contains("viewwcggybj.action"))
    	{
    		result = "外出公干->查看申请->已办结归档";
    	}
    	else if(url.contains("viewwcggunder.action"))
    	{
    		result = "外出公干->本人承办->待办事宜";
    	}
    	else if(url.contains("viewwcggall.action"))
    	{
    		result = "外出公干->统计查询->明细查询";
    	}
    	else if(url.contains("viewwcggycb.action"))
    	{
    		result = "外出公干->本人承办->已承办";
    	}
    	else if(url.contains("showjbsppage.action"))
    	{
    		result = "加班申请->发起申请->本人发起";
    	}
    	else if(url.contains("viewjbsp.action"))
    	{
    		result = "加班申请->查看申请->流转中";
    	}
    	else if(url.contains("viewjbspybj.action"))
    	{
    		result = "加班申请->查看申请->已办结归档";
    	}
    	else if(url.contains("viewjbspunder.action"))
    	{
    		result = "加班申请->本人承办->待办事宜";
    	}
    	else if(url.contains("viewjbspall.action"))
    	{
    		result = "加班申请->统计查询->明细查询";
    	}
    	else if(url.contains("viewjbspycb.action"))
    	{
    		result = "加班申请->本人承办->已承办";
    	}
    	else if(url.contains("viewjbspsummary.action"))
    	{
    		result = "加班申请->汇总查询";
    	}
    	else if(url.contains("showkqqspage.action"))
    	{
    		result = "考勤缺失->发起申请->本人发起";
    	}
    	else if(url.contains("viewkqqs.action"))
    	{
    		result = "考勤缺失->查看申请->流转中";
    	}
    	else if(url.contains("viewkqqsybj"))
    	{
    		result = "考勤缺失->查看申请->已办结归档";
    	}
    	else if(url.contains("viewkqqsall.action"))
    	{
    		result = "考勤缺失->统计查询->明细查询";
    	}
    	else if(url.contains("viewkqqsunder.action"))
    	{
    		result = "考勤缺失->本人承办->待办事宜";
    	}
    	else if(url.contains("viewkqqsycb.action"))
    	{
    		result = "考勤缺失->本人承办->已承办";
    	}
    	else if(url.contains("importkqjl.action"))
    	{
    		result = "考勤记录->导入记录";
    	}
    	else if(url.contains("kqjldaily.action"))
    	{
    		result = "考勤记录->记录查询->日报表";
    	}
    	else if(url.contains("kqjlmonth.action"))
    	{
    		result = "考勤记录->记录查询->月报表";
    	}
    	else if(url.contains("welcome.action"))
    	{
    		result = "待办事宜";
    	}
    	else if(url.contains("userlist.action"))
    	{
    		result = "用户信息->用户管理";
    	}
    	return result;
    }
    
}
