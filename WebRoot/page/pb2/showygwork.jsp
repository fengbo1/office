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
});

function back()
{
  with(document.forms[0]) {
		action="backtoygxxpage.action"
		method="post";
		submit();
	  }
}

function showpaiban()
{		
	with(document.forms[0]) {
		action='viewygpw.action?isdai=1';
		method="post";
		submit();
	}
}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/viewygpw.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>作业人员统计表</b>
							</td>
						</tr>
						<!-- <tr>
							<td colspan="26" height="10px">
								<div align="center">
									起始日期					
									<input size=10 type="text" name="chabegindate" id="begindate" class="Wdate"  onClick="WdatePicker()" >
									截止日期
									<input size=10 type="text" name="chaenddate" id="enddate" class="Wdate"  onClick="WdatePicker()" >
									姓名	
									<input size=10 type="text" name="chaname" />	
									<input type="button" onclick="showpaiban()" value="查询"/>
							</div></td>	
						</tr> -->
							<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作员代码</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人员</p>
								</div></td>	
							<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>所在班组</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>
															
						</tr>
							<c:forEach items="${list}" var="pw" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pw.opnumber}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pw.name}</div></td>
								<td width="200px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pw.zu}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pw.date}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pw.status}</div></td>
								
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="14">
								<div align="center">
							
								
								<input type="hidden" name="newnumber" value="${newnumber}"/>
								<input type="hidden" name="peoplename" value="${peoplename}"/>
								<input type="hidden" name="peoplenametiao" value="${peoplenametiao}"/>
						        <input type="hidden" name="name" value="${name}"/>
						        <input type="hidden" name="day" value="${day}"/>
						        <input type="hidden" name="hour" value="${hour}"/>
						        <input type="hidden" name="reason" value="${reason}"/>
						        <input type="hidden" name="begindate" value="${begindate}"/>
						        <input type="hidden" name="enddate" value="${enddate}"/>
						        <input type="hidden" name="tel" value="${tel}"/>
						        <input type="hidden" name="qita" value="${qita}"/>
						        <input type="hidden" name="remark" value="${remark}"/>
						        <input type="hidden" name="isdai" value="${isdai}"/>
						        <input type="hidden" name="RadioGroup1" value="${RadioGroup1}"/>
						        <input type="hidden" name="RadioGroup2" value="${RadioGroup2}"/>
						        <c:if test="${isdai==0}">
								<input type="button" onclick="javascript:history.go(-1);" value="返   回" />
								 </c:if>
								 <c:if test="${isdai==1}">
								<input type="button" onclick="back();" value="返   回" />
								</c:if>
								</div>
								<br/>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
