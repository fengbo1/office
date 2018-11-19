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
<script language="javascript" type="text/javascript" src="<%=path%>/js/DatePicker.js"></script>
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
$('#all').attr('value',x[0].value);
 });
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form action="<%=path%>/kqjlzw.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td 
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="6" align="center" bordercolor="#FFFFFF"><b>考勤指纹记录</b>
							</td>
						</tr>
						<c:if test="${zhi!=3}">
						<tr>
							<td colspan="6" align="center">
							<select id="all" name="all" style="width: 100px">
								<option value="0">个人</option>
								<option value="1">全部</option>
							</select>
							<input type="hidden" name="para" value="${all}"/>
							<input type="hidden" name="newnumber" value="${newnumber}"/>
							<input type="submit" value="查询"/>
							</td>
						</tr>
						</c:if>
						<p style="color:red">签退指纹记录在第二个工作日上午10点后生成</p>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="80px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>
							<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>签到时间</p>
								</div></td>
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>签退时间</p>
								</div></td>
							<c:if test="${all==0}"> 	
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>补考勤</p>
								</div></td>
						 	</c:if> 		
						</tr>
							<c:forEach items="${list}" var="zw" varStatus="status">
							<tr class="btbj" id="hang">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zw.date}</div></td>
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zw.name}</div></td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zw.qdtime}</div></td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zw.qttime}</div></td>
								<c:if test="${all==0}">
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">
								<c:if test="${zw.qdtime==''}">		
								<a	href="<%=path%>/showkqqspagebukqjl.action?newnumber=${newnumber}&date=${zw.date}&qdqt=qd">补签到</a>
								</c:if>
								<c:if test="${zw.qttime==''&&today!=zw.date}">
								<a	href="<%=path%>/showkqqspagebukqjl.action?newnumber=${newnumber}&date=${zw.date}&qdqt=qt">补签退</a>
								</c:if>
								</div></td>
								</c:if>		
							</tr>
							</c:forEach>
		</table>
		</form>
  </body>
</html>
