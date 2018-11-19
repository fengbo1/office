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
									<p>报废时间</p>
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
																
						   </tr>
							<c:forEach items="${listsh}" var="zckfout" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
							
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zckfout.rukutime}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zckfout.assetname}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zckfout.assettype}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zckfout.sn}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zckfout.assetnumber}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:wupintostring(zckfout.iswupin)}</div></td>
		                        <td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zckfout.area}</div></td>
							</tr>
							</c:forEach>
						
		</table>
		                     <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                      <input type="button" value="返回上一页" onclick="javascript:history.go(-1);" />
		</form>
  </body>
</html>
