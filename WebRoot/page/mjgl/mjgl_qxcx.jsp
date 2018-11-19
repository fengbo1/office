<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
 function expressout()
	{
		window.location = "<%=path%>/exportmjglpage.action";
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form >
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>个人权限</b>
							</td>
						</tr>
						
					<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="60px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室</p>
								</div></td>
							<td  width="250px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>长期权限</p>
								</div></td>	
							<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>长期权限时段</p>
								</div></td>
							<td  width="250px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>临时权限</p>
								</div></td>
							<td  width="200px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>临时权限日期和时段</p>
								</div></td>
								
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>	
						
														
						</tr>
							
							<tr class="btbj" id="hang" style="height:50px">
								
								<td  width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tm.name}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:chutostring(chu)}</div></td>
								<td width="250px" height="25" align="center" valign="middle" nowrap><div
										align="left">
									<s:if test='tm.currentauth.substring(0,1)=="1"'>五楼大门</s:if>
									<s:if test='tm.currentauth.substring(1,2)=="1"'>五楼东区</s:if>
									<s:if test='tm.currentauth.substring(2,3)=="1"'>五楼西区</s:if>
									
									<s:if test='tm.currentauth.substring(3,4)=="1"'><span style="color: ForestGreen">六楼大门</span></s:if>
									<s:if test='tm.currentauth.substring(4,5)=="1"'><span style="color: ForestGreen">六楼西区</span></s:if>
									<s:if test='tm.currentauth.substring(5,6)=="1"'><span style="color: ForestGreen">六楼中区</span></s:if>
									<s:if test='tm.currentauth.substring(6,7)=="1"'><span style="color: ForestGreen">六楼综合</span></s:if>
									
									<s:if test='tm.currentauth.substring(7,8)=="1"'><span style="color: Sienna">七楼大门</span></s:if>
									<s:if test='tm.currentauth.substring(8,9)=="1"'><span style="color: Sienna">七楼东区</span></s:if>
									<s:if test='tm.currentauth.substring(9,10)=="1"'><span style="color: Sienna">七楼西区</span></s:if>
									<s:if test='tm.currentauth.substring(10,11)=="1"'><span style="color: red">八楼大门</span></s:if>
									<s:if test='tm.currentauth.substring(11,12)=="1"'><span style="color: red">八楼东区</span></s:if>
									<s:if test='tm.currentauth.substring(12,13)=="1"'><span style="color: red">八楼西区</span></s:if>
									<s:if test='tm.currentauth.substring(13,14)=="1"'><span style="color: Indigo">九楼大门</span></s:if>
									<s:if test='tm.currentauth.substring(14,15)=="1"'><span style="color: Indigo">九楼东区</span></s:if>
									<s:if test='tm.currentauth.substring(15,16)=="1"'><span style="color: Indigo">九楼西区</span></s:if>
										
								</div></td>
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">
									<c:if test="${tm.currenttime==1}">5×14（7:00-21:00）</c:if>
									<c:if test="${tm.currenttime==2}">5×13（7:00-20:00）</c:if>
									<c:if test="${tm.currenttime==3}">7×24</c:if>
								</div></td>
								<td width="250px" height="25" align="center" valign="middle" nowrap><div
										align="left">
										<s:if test='tm.tempauth.substring(0,1)=="1"'>五楼大门</s:if>
									<s:if test='tm.tempauth.substring(1,2)=="1"'>五楼东区</s:if>
									<s:if test='tm.tempauth.substring(2,3)=="1"'>五楼西区</s:if>
									
									<s:if test='tm.tempauth.substring(3,4)=="1"'><span style="color: ForestGreen">六楼大门</span></s:if>
									<s:if test='tm.tempauth.substring(4,5)=="1"'><span style="color: ForestGreen">六楼西区</span></s:if>
									<s:if test='tm.tempauth.substring(5,6)=="1"'><span style="color: ForestGreen">六楼中区</span></s:if>
									<s:if test='tm.tempauth.substring(6,7)=="1"'><span style="color: ForestGreen">六楼综合</span></s:if>
									
									<s:if test='tm.tempauth.substring(7,8)=="1"'><span style="color: Sienna">七楼大门</span></s:if>
									<s:if test='tm.tempauth.substring(8,9)=="1"'><span style="color: Sienna">七楼东区</span></s:if>
									<s:if test='tm.tempauth.substring(9,10)=="1"'><span style="color: Sienna">七楼西区</span></s:if>
									<s:if test='tm.tempauth.substring(10,11)=="1"'><span style="color: red">八楼大门</span></s:if>
									<s:if test='tm.tempauth.substring(11,12)=="1"'><span style="color: red">八楼东区</span></s:if>
									<s:if test='tm.tempauth.substring(12,13)=="1"'><span style="color: red">八楼西区</span></s:if>
									<s:if test='tm.tempauth.substring(13,14)=="1"'><span style="color: Indigo">九楼大门</span></s:if>
									<s:if test='tm.tempauth.substring(14,15)=="1"'><span style="color: Indigo">九楼东区</span></s:if>
									<s:if test='tm.tempauth.substring(15,16)=="1"'><span style="color: Indigo">九楼西区</span></s:if>
										</div></td>
								<td width="200px" height="25" align="center" valign="middle" nowrap><div
										align="center">
									     ${tm.temptime}
										</div></td>
								
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${tm.remark}</div></td>		
								
							<tr>
							<td colspan="26" height="10px" align=right>
														
									
									<c:if test="${authoQ=='Q'}">
										<input type="button" value="门禁权限表导出" onclick="expressout()"/>
									</c:if>
						    </td>	
						   </tr>
							<tr class="表格表头背景">
							<td colspan="14">
												
								<input type="hidden" name="newnumber" value="${newnumber}"/>	
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
