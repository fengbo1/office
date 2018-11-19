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
$('#chu').attr('value',x[0].value);
$('#key').attr('value',x[1].value);
$('#sequence').attr('value',x[2].value);
});

 //处理异常
 function chuliyc(o)
{
	 window.location = "<%=path%>/chuliyc.action?id="+o+"&type="+1;
}
 function express(authoI)
	{
		var month = document.getElementById("month").value;
		var newnumber = document.getElementById("newnumber").value;
		//var name = document.getElementById("name").value;
		var chu;
		var key;
		var sequence;
		if(document.getElementById("chu")==null)
		{
			chu = "0";
		}
		else
		{
			chu = document.getElementById("chu").value;
		}
		//var chu = document.getElementById("chu").value;
		if(authoI=='I')
		{
			window.location = "<%=path%>/exportkqjlmonthhz.action?month="+month+"&newnumber="+newnumber;
		}
		else if(document.getElementById("key")==null)
		{
			window.location = "<%=path%>/exportkqjlmonth.action?month="+month+"&newnumber="+newnumber+"&chu="+chu;
		}
		else
		{
			key = document.getElementById("key").value;
			sequence = document.getElementById("sequence").value;
			window.location = "<%=path%>/exportkqjlmonth.action?month="+month+"&newnumber="+newnumber+"&chu="+chu+"&key="+key+"&sequence="+sequence;
		}
			
		
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form action="<%=path%>/kqjlmonth.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="17" align="center" bordercolor="#FFFFFF"><b>${month}月报表</b>
							</td>
						</tr>
						<tr>
							<td colspan="17" height="10px">
							<div align="center">
									月份						
									<input size=10 type="text" name="month" id="month" readonly="readonly" value="${month}" onclick="setmonth(this,'yyyyMM','2010-01','2099-12',1)" >
									<c:if test="${zhi<3||authoI=='I'||authoJ=='J'}">
									<c:if test="${zhi<2||authoI=='I'||authoJ=='J'||authoB=='B'}">
									处室								
							<select id="chu" name="chu" style="width: 120px" >
								<option value="0">全部</option>
								<c:if test="${zhi<2||authoI=='I'||authoJ=='J'}">
								<option value="1">综合与生产管理处</option>
								<option value="2">合规与监督二处</option>
								<option value="3">通用业务二处</option>
								<option value="4">员工响应团队</option>
								<option value="5">研发支持二处</option>
								<option value="6">专业处理二处</option>
								</c:if>
								<option value="7">业务处理1组</option>
								<option value="8">业务处理2组</option>
								<option value="9">业务处理3组</option>
								<option value="10">专业处理1组</option>
								<option value="11">专业处理2组</option>
								<option value="12">专业处理3组</option>
							</select>
							</c:if>								
							按关键字排序								
						    <select id="key" name="key"	style="width: 140px">
								<option value="chitui">本月迟到+早退次数</option>
								<option value="chidao">本月迟到天数</option>
								<option value="zaotui">本月早退天数</option>
								<option value="workdays">本月工作天数</option>
								<option value="zhiwendays">指纹记录正常出勤天数</option>
								<option value="bukq">补交考勤次数</option>
								<option value="qjdays">本月请假天数</option>
								<option value="ggdays">本月公干天数</option>
							</select>
							<select id="sequence" name="sequence"
								style="width: 50px">
								<option value="1">倒序</option>
								<option value="0">正序</option>
							</select>	
									姓名	
								<input type="text" id="name" name="name" value="${strtemp}"/>
							</c:if>	
									<input type="submit" value="查询"/>
									<c:if test="${zhi!=3||authoI=='I'||authoJ=='J'}">
									<input type="button" onclick="express('${authoI}')" value="导出"/>	
									</c:if>
									<input type="hidden" name="para" value="${chu}"/>
									<input type="hidden" name="para" value="${key}"/>
									<input type="hidden" name="para" value="${sequence}"/>
									<input type="hidden" name="para" value="${strtemp}"/>
						</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>月份</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							<td  width="90px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室（团队）</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>应工作天数</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>指纹记录正常出勤天数</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>请假天数（不含周末）</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>公干天数（不含周末）</p>
								</div></td>		
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>迟到天数</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>早退天数</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>未通过审批签到缺失次数</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>未通过审批签退缺失次数</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>已通过审批考勤缺失次数</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>详情</p>
								</div></td>			
						</tr>
							<c:forEach items="${list}" var="kqjl" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.month}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.name}</div></td>
								<td width="90px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:positiontoname(kqjl.position)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.workdays}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.zhiwendays}</div></td>	
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.qjdays}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.ggdays}</div></td>			
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.chidao}</div></td>		
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.zaotui}</div></td>		
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.qdqs}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.qtqs}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.bukq}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">
											<a href="#" onclick="chuliyc(${kqjl.id})">查看</a>
										</div></td>		
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="17">
								<div align="center">
								<a	href="<%=path%>/kqjlmonth.action?zhuan=1&newnumber=${newnumber}&currentPage=${previousPage}&month=${month}&chu=${chu}&key=${key}&name=${strtemp}&sequence=${sequence}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/kqjlmonth.action?zhuan=1&newnumber=${newnumber}&currentPage=${nextPage}&month=${month}&chu=${chu}&key=${key}&name=${strtemp}&sequence=${sequence}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
								<input type="submit" value="跳转"/>	
								</div>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
