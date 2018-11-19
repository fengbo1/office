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
$('#chutuan').attr('value',x[0].value);
 });
 //导出
 function expressout()
	{
		window.location = "<%=path%>/exportuserinfo.action";
	}
//删除用户
 function del(id)
{
	var aa= window.confirm("请确认是否删除该用户");
	if (aa) {
		window.location = "<%=path%>/userdel.action?id="+id;
	}
}
function modify(id)
{
	//window.location = "<%=path%>/userlist.action";
	window.location = "<%=path%>/usertoupdate.action?id="+id;
}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
   <form action="<%=path%>/userlist.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>用户管理</b>
							</td>
						</tr>
						<tr>
							<td colspan="12" height="10px">
								<div align="center">
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
									姓名	
								<input type="text" name="name" value="${strtemp}"/>								
							
									<input type="submit" value="查询"/>
									<input type="button" value="全量导出" onclick="expressout()"/>
									<input type="hidden" name="para" value="${chutuan}"/>
						</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>用户名</p>
								</div></td>
							<td  width="120px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室团队</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>权限</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>参加工作时间</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>来行时间</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>来中心时间</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>工作年限</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>护照号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>港澳通行证号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>台湾通行证号</p>
								</div></td>
							<c:if test="${authoI=='I'}">																												
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>	
							</c:if>											
						</tr>
							<c:forEach items="${list}" var="ui" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.username}</div></td>		
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:positiontoname(ui.position)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:authotoname(ui.authority)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.workdate}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.ccbdate}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.zxdate}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.workyears}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.passport}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.hkpassport}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.twpassport}</div></td>
								<c:if test="${authoI=='I'}">
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<input type="button" value="删除" onclick="del('${ui.id}')"/>
										<input type="button" value="修改" onclick="modify('${ui.id}')"/>
										<!-- <a href="<%=path%>/user.action?type=to_update&id=<s:property value="id"/>">修改</a> -->
											</div>
								</td>
								</c:if>
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<c:if test="${authoI=='I'}">
							<td colspan="11">
							</c:if>
							<c:if test="${authoI!='I'}">
							<td colspan="10">
							</c:if>
								<div align="center">
								<a	href="<%=path%>/userlist.action?zhuan=1&name=${strtemp}&chutuan=${chutuan}&currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/userlist.action?zhuan=1&name=${strtemp}&chutuan=${chutuan}&currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
								<td colspan="1">
									<c:if test="${authoI=='I'}">
									<input type="button" value="增加员工" onclick="location='<%=path%>/page/userinfo/add.jsp'"/>
									</c:if>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
