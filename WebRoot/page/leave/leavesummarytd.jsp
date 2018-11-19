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
$('#keyword').attr('value',x[1].value);
$('#chutuan').attr('value',x[2].value);
});
 function expressout()
	{
		var year = document.getElementById("year").value;
		var name = document.getElementById("name").value;
		var chutuan = document.getElementById("chutuan").value;
		var keyword = document.getElementById("keyword").value;
		window.location = "<%=path%>/exportleavesummary.action?year="+year+"&name="+name+"&chutuan="+chutuan+"&keyword="+keyword;
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/viewsummary.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="20" align="center" bordercolor="#FFFFFF"><b><c:if test="${authoI=='I'||authoJ=='J'||zhi=='0'||zhi=='1'}">中心汇总</c:if><c:if test="${zhi=='2'||zhi=='4'}">团队汇总</c:if></b>
							</td>
						</tr>
						<tr class="qq">
							<td colspan="20" align="center">
							年度<select id="year" name="year"style="width: 70px" >
								<c:forEach items="${listyear}" var="l" varStatus="status">
								<option value="${l}">${l}</option>
								</c:forEach>
							</select>
							处室团队
									<select id="chutuan" name="chutuan" style="width: 120px">
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
							姓名<input style="width: 70px" type="text"  name="name" value="${name}"/>
							按关键字排序
								<select id="keyword" name="keyword" style="width: 130px" >
								<option value="yearleave">年假已休</option>
								<option value="workleave">加班调休假</option>
								<option value="bingleave">病假已休</option>
								<option value="shileave">事假已休</option>
								<option value="hunleave">婚假已休</option>
								<option value="chanleave">产假已休</option>
								<option value="tanpoleave">探亲（配偶）</option>
								<option value="tanfmleave">探亲（父母）</option>
								<option value="sangleave">丧假已休</option>
								<option value="shangleave">工伤假已休</option>
								<option value="gongleave">公假已休</option>
								<option value="qitaleave">产检已休</option>
								</select>
									<input type="hidden" name="newnumber" value="${newnumber}"/>
									<input type="hidden" name="zxtd" value="td"/>
									<input type="submit" value="查询"/>
									<input type="hidden" name="para" value="${year}"/>
									<input type="hidden" name="para" value="${keyword}"/>
									<input type="hidden" name="para" value="${chutuan}"/>
									<input type="button" value="导出" onclick="expressout()"/>			
								</div></td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="30px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="30px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>年度</p>
								</div></td>
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							<td  width="78px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室团队</p>
								</div></td>		
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>年假总天数</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>年假已请天数</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>加班调休剩余</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>加班调休已请</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>病假已请天数</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>事假已请天数</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>婚假已请天数</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>产假已请天数</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>探亲假（配偶）</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>探亲假（父母）</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>丧假已请天数</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>工伤假已请天数</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>公假已请天数</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>产检已请天数</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>陪考假已请天数</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>哺乳假已请天数</p>
								</div></td>												
						</tr>
							<c:forEach items="${list}" var="leave" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.year}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.name}</div></td>
								<td height="25" align="center" valign="middle"><div
										align="center">${fb:positiontoname(leave.position)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.yearall}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.yearleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.workrest}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.workleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.bingleave}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.shileave}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.hunleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.chanleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.tanpoleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.tanfmleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.sangleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.shangleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.gongleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.qitaleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.peikaoleave}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.buruleave}</div></td>						
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="20">
								<div align="center">
								<a	href="<%=path%>/viewsummary.action?newnumber=${newnumber}&zhuan=1&year=${year}&zxtd=td&chutuan=${chutuan}&name=${name}&keyword=${keyword}&currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/viewsummary.action?newnumber=${newnumber}&zhuan=1&year=${year}&zxtd=td&chutuan=${chutuan}&name=${name}&keyword=${keyword}&currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="submit" value="跳转"/>	
								</div><br/></td>
						</tr>
		</table>
		</form>
  </body>
</html>
