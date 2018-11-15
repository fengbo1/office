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
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
 <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script type="text/javascript">
 $(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
var x=document.getElementsByName("para");
//$('#chutuan').attr('value',x[0].value);
});
 
  function savebringtime()
     {
        alert("请确认，时间提交之后无法更改");
     	with(document.forms[0]) 
     	{
		  action='yscjtzbaocun.action?number=${tz.number}&newnumber=${newnumber}';
		  method="post";
		  submit();
					}
     	
     }
     
     function savereturntime()
     {
        alert("请确认，时间提交之后无法更改");
     	with(document.forms[0]) 
     	{
		  action='yscjtzbanjie.action?number=${tz.number}&newnumber=${newnumber}';
		  method="post";
		  submit();
					}
     	
     }
     
       function viewdetail()
     {
     
     	with(document.forms[0]) 
     	{
		  action='viewyscjdetail.action?number=${tz.number}';
		  method="post";
		  submit();
					}
     	
     }
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body> 
  ${daohang} 
  <form>
					<table height="80" align="center" cellpadding="0" cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>因私出国（境）证照领取台账</b>
							</td>
						</tr>
						
							
					<tr height="50px" class="表格表头背景1" id="hang">
						
							<td  width="125px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>拟去国家或地区</p>
								</div></td>
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>出国（境）事由</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>拟出国（境）总天数</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>拟出国（境）时间</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>拟回国（境）时间</p>
								</div></td>			
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>证件类型</p>
								</div></td>	
						
							<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>证件编号</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>领取护照时间</p>
								</div></td>		
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>出入境证件归还日期</p>
								</div></td>	
							 <td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>查看审批表</p>
								</div></td>											
						   </tr>
					
							<tr class="btbj" id="hang" style="height:20px">
								
								<td width="125px" height="25" align="center" valign="middle"  nowrap><div
										align="center">${tz.number}</div></td>
								<td width="60px" height="25" align="center" valign="middle"  nowrap><div
										align="center">${tz.name}</div></td>
								<td width="100px" height="25" align="center" valign="middle"  nowrap><div
										align="center">${tz.tocountry}</div></td>
								<td width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tz.reason}</div></td>
								<td width="70px" height="25" align="center" valign="middle"  nowrap><div
										align="center">${tz.sumday}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tz.begindate}</div></td>
								<td width="100px" height="25" align="center" valign="middle"  nowrap><div
										align="center">${tz.enddate}</div></td>
								<td width="70px" height="25" align="center" valign="middle"  nowrap><div
										align="center">${tz.passporttype}</div></td>		
								
								<td width="80px" height="25" align="center" valign="middle"  nowrap><div
										align="center">${tz.passportnumber}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tz.bringtime}</div>
							    </td>
						                                                                                                                 
								<td width="70px" height="25" align="center" valign="middle" nowrap>
								<input size=10 type="text" name="returntime" id="returntime" class="Wdate" onClick="WdatePicker()"/></td>
								
								<td width="70px" height="25" align="center" valign="middle"  nowrap><div
										align="center">
					               
										 <input size=10 type="button" onclick="viewdetail()" value="查看详情"/>	            
										</div></td>	
								</tr>
							   <tr>
							   <td width="125px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							   <td width="60px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							   <td width="100px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							   <td width="50px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							   <td width="70px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							   <td width="100px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							   <td width="100px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							   <td width="70px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							   <td width="80px" height="25" align="center" valign="middle" nowrap> 		
							   </td>
							  <td width="80px" height="25" align="center" valign="middle"  nowrap>
					            </td>
							   <td width="80px" height="25" align="center" valign="middle"  nowrap>
							    <input size=10 type="button" onclick="savereturntime()" value="提交"/>	 
							   </td>
							   </tr>
		</table>
		</form>
  </body>
</html>
