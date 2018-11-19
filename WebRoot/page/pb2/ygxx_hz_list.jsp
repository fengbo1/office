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
$('#year').attr('value',x[0].value);
$('#quarter').attr('value',x[1].value);
});

 		function expressout()
	{
		var year = document.getElementById("year").value;
		var quarter = document.getElementById("quarter").value;
		var name = document.getElementById("name").value;	
		var newnumber = document.getElementById("newnumber").value;	
		var chutuan = document.getElementById("chutuan").value;	
		window.location = "<%=path%>/exportygxxhz.action?year="+year+"&quarter="+quarter+"&name="+name+"&newnumber="+newnumber+"&chutuan="+chutuan;
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/viewygxxhz.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>因公下线汇总表</b>
							</td>
						</tr>
						<tr  >
							<td colspan="13" height="10px">
								<div align="center">
									年度						
								<select id="year" name="year" style="width: 100px" >
									<option value="${year1}">${year1}</option>
									<option value="${year2}">${year2}</option>
									<option value="${year3}">${year3}</option>
								</select>
									季度						
								<select id="quarter" name="quarter" style="width: 100px" >
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>
								<c:if test="${type=='all'}">
								处室团队
									<select id="chutuan" name="chutuan" style="width: 100px">
										<option value="0">全部</option>
										<option value="1">综合与生产管理处</option>
										<option value="2">合规与监督二处</option>
										<option value="3">通用业务二处</option>
										<option value="4">员工响应团队</option>
										<option value="5">研发支持二处</option>
										<option value="6">专业处理二处</option>
										<option value="7">业务处理1组</option>
										<option value="8">业务处理2组</option>
										<option value="9">业务处理3组</option>
										<option value="10">专业处理1组</option>
										<option value="11">专业处理2组</option>
										<option value="12">专业处理3组</option>
									</select>
									</c:if>		
									<c:if test="${type=='all'}">
									姓名	
								<input style="width:100px" type="text" id="name" name="name" value="${name}"/>
								</c:if>								
									<input type="submit" value="查询"/>
									<c:if test="${type=='all'}">
									<input type="button" value="导出" onclick="expressout()"/>
									</c:if>
									<input type="hidden" name="para" value="${year}"/>
									<input type="hidden" name="para" value="${quarter}"/>
									
						</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>年度</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>季度</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>次数</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>天数</p>
								</div></td>	
							<td  width="90px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>小时数</p>
								</div></td>	
						</tr>
							<c:forEach items="${list}" var="yh" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yh.name}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:chustostring(yh.chu)}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yh.year}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yh.quarter}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yh.times}
										</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yh.days}</div></td>
								<td width="90px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yh.hours}</div></td>
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="14">
								<div align="center">
								<a	href="<%=path%>/viewygxxhz.action?zhuan=1&name=${name}&year=${year}&chutuan=${chutuan}&quarter=${quarter}&type=${type}&newnumber=${newnumber}&currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/viewygxxhz.action?zhuan=1&name=${name}&year=${year}&chutuan=${chutuan}&quarter=${quarter}&type=${type}&newnumber=${newnumber}&currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="hidden" name="type" value="${type}"/>
								<input type="hidden" name="newnumber" value="${newnumber}"/>
								<input type="submit" value="跳转"/>	
								</div>
								<br/>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
