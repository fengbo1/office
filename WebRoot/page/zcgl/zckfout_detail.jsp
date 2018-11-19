<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>My JSP 'authorityfailed.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
	<script type="text/javascript">
   
    function show(name,type,number)
	{
		var namec = encodeURI(name); 
		var typec = encodeURI(type);
		var numberc = number;
		window.location = "<%=path%>/showkfout.action?name="+namec+"&type="+typec+"&number="+number;
	}
	
    </script>

 

   <style type="text/css">
  .as {
	text-align: center;
      }
   b{
	color:red;
      }
  </style>
  </head>
  
  <body> 
 ${daohang} 
 <br>
 <br>
    <form >
    	<br>
    		<br>
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心资产报废记录表</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		<tr height="40">
    			<td width="200" class="as" >
    				申请报废资产管理员名称<b>*</b>
    			</td>
    			<td width="300" class="as" colspan="2">
    				
    				 ${ah.name} 
    				
    			</td>
    			<td width="200" class="as" >
    				复核资产管理员名称<b>*</b>
    			</td>
    			<td  class="as" colspan="3">
    			 
    				 ${ah.checkname}
    				
    			</td>
    		    </tr>
    	   <c:forEach items="${listtemp}" var="ap" varStatus="status">
    		              <tr height="40">
    			               <td  class="as" >
    				                                      资产名称<b>*</b>
    			               </td>
    			               <td  class="as" >
    				
    				             ${ap.assetname} 
    			
    			               </td>
    			              <td  class="as" >
    				                                  型号<b>*</b>
    			              </td>
    			              <td  class="as" >
    			  
    				             ${ap.assettype} 
    			
    			              </td>
    			              <td width="120" class="as">
    				                                        数量<b>*</b>
    			              </td>
    		                  <td  class="as" >
    				
    				                                  报废 ${ap.num}件 
    				
    			              </td>
    			              <td  class="as" >
    				
    			                   <input type="button" onclick="show('${ap.assetname}','${ap.assettype}','${ap.rukunum}')" value="查看详情" />    				
    				               
    			              </td>
    		                 </tr>
    		                 </c:forEach>
                <tr height="40">
    			<td class="as">
    				原因
    			</td>
    			<td colspan="6" class="as">
    				
                   ${ah.reason} 
    				&nbsp;&nbsp;
    			</td>
    		        </tr>
   
    		<tr height="40">
    			<td  class="as" >
    				复核资产管理员复核意见<b>*</b>
    			</td>
    			<td class="as" colspan="6" >
    			&nbsp;
    			<c:forEach items="${listlp}" var="lp" varStatus="status">
    					
     	 		复核人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;复核时间：${lp.time}<br/>
      			&nbsp;
    			</c:forEach>
    				
    			</td>
    		
    		    </tr>
    		<tr height="40">
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="6">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="number" value="${ah.number}"/>
    				<input type="button" onclick="javascript:history.go(-1);" value="返   回" / >
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				   				
    				
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
