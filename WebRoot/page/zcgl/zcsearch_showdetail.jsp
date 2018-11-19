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
});


 function changearea(assetnumber)
 {
   
		var number = assetnumber;
		var name = document.getElementById("name").value; 
		var type = document.getElementById("type").value; 
		var namec = encodeURI(name); 
		var typec = encodeURI(type);
		var chu = document.getElementById("chu").value; 
		var status = document.getElementById("status").value; 
		window.location = "<%=path%>/changearea.action?number="+number+"&name="+namec+"&type="+typec+"&chu="+chu+"&status="+status;
 }
 
 
  function changepeople(assetnumber)
 {
   
		var number = assetnumber;
		var name = document.getElementById("name").value; 
		var type = document.getElementById("type").value; 
		var namec = encodeURI(name); 
		var typec = encodeURI(type);
		var chu = document.getElementById("chu").value; 
		var status = document.getElementById("status").value; 
		window.location = "<%=path%>/changepeople.action?number="+number+"&name="+namec+"&type="+typec+"&chu="+chu+"&status="+status;
 }
 
 
  function changesn(assetnumber)
 {
   
		var number = assetnumber;
		var name = document.getElementById("name").value; 
		var type = document.getElementById("type").value; 
		var namec = encodeURI(name); 
		var typec = encodeURI(type);
		var chu = document.getElementById("chu").value; 
		var status = document.getElementById("status").value; 
		window.location = "<%=path%>/changesn.action?number="+number+"&name="+namec+"&type="+typec+"&chu="+chu+"&status="+status;
 }
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
           <form>
				<br>
					<br>	
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
					
	                    <tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>明细查询</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>入库时间</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>资产名称</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>资产类型</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>SN编号</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>资产编号</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>是否资产</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>存放位置</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>使用人</p>
								</div></td>
																
						   </tr>
							<c:forEach items="${listsh}" var="zcsearch" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
							
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.date}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.name}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.type}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.sn} &nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${authoM=='M'}">  <input type="button" value="修改" onclick="changesn('${zcsearch.number}');" /></c:if> </div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.number}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:wupintostring(zcsearch.iswupin)}</div></td>
		                        <td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.area}&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${(authoN=='N'||authoS=='S'||authoR=='R')&&(flag!=1)}"> <input type="button" value="修改" onclick="changearea('${zcsearch.number}');" /></c:if> </div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.people}&nbsp;&nbsp;&nbsp;&nbsp; <c:if test="${(authoN=='N'||authoS=='S'||authoR=='R')&&(flag!=1)}"> <input type="button" value="修改" onclick="changepeople('${zcsearch.number}');" /></c:if></div></td>
							</tr>
							</c:forEach>
						
		</table>
		                     <br/>
		                       <c:if test="${isreturn!=1}">
		                      <input type="button" value="返回上一页" onclick="javascript:history.go(-1);" />
		                       </c:if>
		                      <input type="hidden" id="name" name="name" value="${name}"/>
		                      <input type="hidden" id="type" name="type" value="${type}"/>
		                      <input type="hidden" id="chu" name="chu" value="${chu}"/>
		                      <input type="hidden" id="status" name="status" value="${status}"/>
		</form>
  </body>
</html>
