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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
 <style type="text/css">
<!--
 .as {
	text-align: center;
      }
   b{
	color:red;
      }
-->
</style>
<script type="text/javascript">


function tijiao()
		{
			with(document.forms[0]) {
			action='zckfoutreturn.action';
			method="post";
			submit();
			}
		}
		
   function show(name,type,number)
	{
		var namec = encodeURI(name); 
		var typec = encodeURI(type);
		var numberc = number;
		window.location = "<%=path%>/showkfout.action?name="+namec+"&type="+typec+"&number="+number;
	}
 </script>
 <!-- <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css"> -->
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/zckfoutshenpi.action" method="post" name="fm1">
				<br>
					<br>	
					 <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心资产报废复核表</strong><strong> </strong></p>
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
    				
    				                                  报废${ap.num}件 
    				
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
   
							<tr >
							<td class="as" colspan="2">
								
							
								复核无误，请点击：
					
								<input type="hidden" name="type" value="${type}"/>
								<input type="hidden" name="newnumber" value="${newnumber}"/>
								<input type="hidden" name="number" value="${number}"/>
								<input type="submit" value="确   定"/>
								</td>
								<td  class="as" colspan="5">
								如有错误，请填写错误理由:
								<input type="text" style="width:200px"  id="remark" name="remark"/>    	
								并点击：<input type="button" onclick="tijiao()" value="退   回" />    
								
								
								
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
