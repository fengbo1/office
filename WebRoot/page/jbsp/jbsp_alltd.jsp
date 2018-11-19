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
$('#chutuan').attr('value',x[0].value);
});
 function expressout()
	{
		var begindate = document.getElementById("begindate").value;
		var enddate = document.getElementById("enddate").value;
		var applicant = document.getElementById("name").value;	
		window.location = "<%=path%>/exportjbsp.action?begindate="+begindate+"&enddate="+enddate+"&applicant="+applicant;
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/viewjbspall.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b><c:if test="${authoI=='I'||zhi=='0'||zhi=='1'}">中心明细</c:if><c:if test="${zhi=='2'||zhi=='4'}">团队明细</c:if></b>
							</td>
						</tr>
						<tr>
							<td colspan="26" height="10px">
								<div align="center">
								
									起始日期					
									<input size=10 type="text" name="begindate" id="begindate" class="Wdate" value="${begindate}" onClick="WdatePicker()" >
									截止日期
									<input size=10 type="text" name="enddate" id="enddate" class="Wdate" value="${enddate}" onClick="WdatePicker()" >
									<c:if test="${authoI=='I'||zhi=='1'||zhi=='0'}">
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
									</c:if>	
									姓名	
									<input type="text" name="name" value="${strtemp}"/>	
									
									<input type="hidden" name="zxtd" value="td"/>							
									<input type="submit" value="查询"/>
									<input type="hidden" name="para" value="${chutuan}"/>
									<c:if test="${authoI=='I'||zhi=='0'||zhi=='1'||zhi=='2'}">
									<input type="button" value="导出" onclick="expressout()"/>
									</c:if>		
									
							</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="130px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>	
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>加班人</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>联系电话</p>
								</div></td>
							<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>加班事由</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>开始日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>结束日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>调休天数</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>已抵用天数</p>
								</div></td>	
							<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>当前承办人</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>		
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
							<c:forEach items="${list}" var="jbsp" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="130px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.number}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.date}</div></td>
								<td width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(jbsp.applicant)}</div></td>
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.people}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.tel}</div></td>
								<td width="200px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.reason}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.begindate}</div></td>		
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.enddate}</div></td>		
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.jbdays}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${jbsp.didays}</div></td>
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(jbsp.thisunder)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newstatustostring(jbsp.status)}</div></td>
								 
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${(authoI=='I')&&(jbsp.status!=4)&&(jbsp.status!=6)}">
										<a onClick="return confirm('确定撤销?');"  href="<%=path%>/deletejbsppage.action?number=${jbsp.number}&newnumber=${newnumber}">撤销</a>
										&nbsp;&nbsp;
										</c:if>
										<a href="<%=path%>/viewjbspdetail.action?number=${jbsp.number}&newnumber=${newnumber}">查看详情</a>
										</div></td>	
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="14">
								<div align="center">
								<a	href="<%=path%>/viewjbspall.action?zhuan=1&begindate=${begindate}&enddate=${enddate}&zxtd=td&chutuan=${chutuan}&name=${strtemp}&newnumber=${newnumber}&currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/viewjbspall.action?zhuan=1&begindate=${begindate}&enddate=${enddate}&zxtd=td&chutuan=${chutuan}&name=${strtemp}&newnumber=${newnumber}&currentPage=${nextPage}"
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
