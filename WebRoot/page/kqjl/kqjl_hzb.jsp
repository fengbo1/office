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
});

 function processmonth(o)
{
	 var month = document.getElementById("month").value;		
	 if(confirm("确认生成考勤月报表？"))
     {
		 window.location = "<%=path%>/updatekqjlmonth.action?newnumber="+o+"&month="+month;
     }
}
 //处理异常
 function chuliyc(o)
{
	 window.location = "<%=path%>/chuliyc.action?id="+o;
}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form action="<%=path%>/kqjlhzb.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="17" align="center" bordercolor="#FFFFFF"><b>${month}月考勤记录汇总校验表</b>
							</td>
						</tr>
						<tr>
						<td colspan="3" height="10px">
							
						</td>
							<td colspan="8" height="10px">
							<div align="center">
									月份						
									<input size=10 type="text" name="month" id="month" readonly="readonly" value="${month}" onclick="setmonth(this,'yyyyMM','2010-01','2099-12',1)" >
									处室
									<select id="chu" name="chu" style="width: 100px" >
										<option value="0">全部</option>
										<option value="1">综合管理处</option>
										<option value="2">生产管理处</option>
										<option value="3">异常交易处</option>
										<option value="4">员工响应团队</option>
									</select>
									姓名	
								<input type="text" name="name" value="${strtemp}"/>
									<input type="hidden" name="newnumber" value="${newnumber}"/>
									<input type="hidden" name="para" value="${chu}"/>
									<input type="hidden" name="para" value="${strtemp}"/>
									<input type="submit" value="查询"/>
						</div></td>
						<td colspan="3" style="color:red">
							<c:if test="${chu==1&&ku.kqjl1!=1}">
								<input type="button" onclick="processmonth('${newnumber}')" value="生成月报表"/>	
							</c:if>
							<c:if test="${chu==1&&ku.kqjl1==1}">
								本处月报已提交
							</c:if>
							<c:if test="${chu==2&&ku.kqjl2!=1}">
								<input type="button" onclick="processmonth('${newnumber}')" value="生成月报表"/>	
							</c:if>
							<c:if test="${chu==2&&ku.kqjl2==1}">
								月报已提交
							</c:if>
							<c:if test="${chu==3&&ku.kqjl3!=1}">
								<input type="button" onclick="processmonth('${newnumber}')" value="生成月报表"/>	
							</c:if>
							<c:if test="${chu==3&&ku.kqjl3==1}">
								月报已提交
							</c:if>
							<c:if test="${chu==4&&ku.kqjl4!=1}">
								<input type="button" onclick="processmonth('${newnumber}')" value="生成月报表"/>	
							</c:if>
							<c:if test="${chu==4&&ku.kqjl4==1}">
								月报已提交
							</c:if>
							<c:if test="${authoI=='I'}">
								<input type="button" onclick="processmonth('${newnumber}')" value="生成中心月报表"/>	
							</c:if>
						</td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="50px" align="center" valign="middle" nowrap
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
									<p>异常处理</p>
								</div></td>		
						</tr>
							<c:forEach items="${list}" var="kqjl" varStatus="status">
							<tr class="btbj" id="hang" <c:if test="${kqjl.yc==1}">style="color:red"</c:if>>
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="50px" height="25" align="center" valign="middle" nowrap><div
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
										<c:if test="${kqjl.yc==1}">
											<a href="#" onclick="chuliyc(${kqjl.id})">处理</a>
										</c:if>
										</div></td>		
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="17">
								<div align="center">
								<a	href="<%=path%>/kqjlhzb.action?month=${month}&newnumber=${newnumber}&currentPage=${previousPage}&name=${strtemp}&zhuan=1&chu=${chu}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/kqjlhzb.action?month=${month}&newnumber=${newnumber}&currentPage=${nextPage}&name=${strtemp}&zhuan=1&chu=${chu}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="submit" value="跳转"/>	
								</div>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
