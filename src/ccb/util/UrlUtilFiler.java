package ccb.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * url处理filter
 * 
 * @author 苏玮
 * 
 *         2010-12-16
 * 
 */
public class UrlUtilFiler implements Filter {

	/**
	 * 放进session中，用于存放最近访问过的ListAction的url地址
	 * 该url地址是不包括当前页值的详细请求地址
	 */
	private static final String LATEST_LIST_URL="latest_list_url";
	
	private static final String NAMESPACE_URL="namespace_url";
	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;

		/**
		 * 获得url请求
		 */
		String url = request.getRequestURI();
		
		String namespaceUrl=null;
		
		
		
		/**
		 * 获得请求参数
		 */
		Map<?,?> parameterMap=arg0.getParameterMap();
		
		/**
		 * 获得ListAction的请求参数
		 */
		if(url.endsWith("List.action")){
			
			
			StringBuffer urlBuffer=new StringBuffer(url);
			int i=0;
			int size=parameterMap.size();
			for(Map.Entry<?, ?> entry:parameterMap.entrySet()){
				
				if(i==0){
					urlBuffer.append("?");
				}
				if(!"currentPage".equals(entry.getKey().toString())){
					String[] values=(String[])entry.getValue();
					
					for(int j=0;j<values.length;j++){
						urlBuffer.append(entry.getKey()+"="+values[j]);
						if(j<(values.length-1)){
							urlBuffer.append("&");
						}
					}
				}
				if(i<(size-1)){
					urlBuffer.append("&");
				}
				i++;
			}
			request.getSession().setAttribute(LATEST_LIST_URL, urlBuffer.toString());
			
			
		}
		
		/**
		 * 获得InfoAction及ListAction的命名空间
		 */
		if(url.endsWith("List.action")||url.endsWith("Info.action")){
			if(url.endsWith("List.action")){
				namespaceUrl=url.split("List.action")[0];
			}
			if(url.endsWith("Info.action")){
				namespaceUrl=url.split("Info.action")[0];
			}
			System.out.println("namespaceUrl="+namespaceUrl);
			request.getSession().setAttribute(NAMESPACE_URL, namespaceUrl);
		}
		
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
