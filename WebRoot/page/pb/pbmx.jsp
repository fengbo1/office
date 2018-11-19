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
$('#chu').attr('value',x[0].value);
$('#type').attr('value',x[1].value);
$('#bc').attr('value',x[2].value);
 });

 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form action="<%=path%>/pbmx.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="13" align="center" bordercolor="#FFFFFF"><b>排班明细表</b>
							</td>
						</tr>
						<tr  >
							<td colspan="13" height="10px">
								<div align="center">
									日期						
								<input size=10 type="text" name="date" id="date" class="Wdate" value="${date}" onClick="WdatePicker()" >
								
									排班小组						
							<select id="chu" name="chu" style="width: 100px" >
								<option value="0">全部</option>
								<!-- 
								<option value="1">综合管理处</option>
								<option value="2">生产管理处</option>
								<option value="3">异常交易处</option>
								<option value="4">员工响应团队</option>
								 -->
								<option value="5">1组</option>
								<option value="6">2组</option>
								<option value="7">3组</option>
								<option value="8">4组</option>
								<option value="9">5组</option>
								<option value="10">6组</option>
								<option value="11">7组</option>
								<option value="12">8组</option>
								<option value="13">9组</option>
								<option value="14">10组</option>
								<option value="15">11组</option>
								<option value="16">12组</option>
								<option value="17">13组</option>
							</select>
							班次
							<select id="bc" name="bc" style="width: 100px">
								<option value="6">正常班1</option>
								<option value="7">正常班2</option>
								<option value="8">正常班3</option>
								<option value="3">早班</option>
								<option value="1">小晚班</option>
								<option value="2">大晚班</option>
							</select>								
									姓名	
							<input style="width:100px" type="text" id="name" name="name" value="${name}"/>								
							查询
							<select id="type" name="type" style="width: 100px">
								<option value="day">当日</option>
								<option value="month">当月</option>
							</select>
									<input type="submit" value="查询"/>
									<input type="hidden" name="para" value="${chu}"/>
									<input type="hidden" name="para" value="${type}"/>
									<input type="hidden" name="para" value="${bc}"/>
						</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室（团队）</p>
								</div></td>
							<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>排班小组</p>
								</div></td>	
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>签到时间</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>签退时间</p>
								</div></td>		
							<td  width="180px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>排班作业时间</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>班次</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>特殊事项</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>调班情况</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>	
									
						</tr>
							<c:forEach items="${listpm}" var="pm" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${pm.name}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:positiontoname(pm.position)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${pm.team}</div></td>						
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${pm.date}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${pm.week}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${pm.pbqdtime}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${pm.pbqttime}</div></td>								
								<td width="180px" height="25" align="center" valign="middle" nowrap><div
										align="center">${pm.zytime}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:wbtypetostring(pm.wb)}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:pbtypetostring(pm.sw,pm.xw)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${pm.tb}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
									<c:if test="${authoT=='T'||authoI=='I'}">
										<a	href="<%=path%>/tochangepbmx.action?id=${pm.id}&newnumber=${newnumber}">修改</a>
										<a onClick="return confirm('确定删除?');" href="<%=path%>/pbmxdel.action?id=${pm.id}">删除</a>
									</c:if>
								</div></td>	
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="13">
								<div align="center">
								<a	href="<%=path%>/pbmx.action?zhuan=1&newnumber=${newnumber}&currentPage=${previousPage}&date=${date}&chu=${chu}&name=${name}&bc=${bc}&type=${type}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/pbmx.action?zhuan=1&newnumber=${newnumber}&currentPage=${nextPage}&date=${date}&chu=${chu}&name=${name}&bc=${bc}&type=${type}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="hidden" name="newnumber" value="${newnumber}"/>
								<input type="submit" value="跳转"/>	
								</div>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
