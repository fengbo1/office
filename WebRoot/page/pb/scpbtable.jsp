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
 });

 function del(id)
 {
	 var a = id;
	 alert(a);
	 if (window.confirm("是否删除该条排班记录")) {
			with(document.forms[0]) {
				action='pbtabledel.action?id='+a+'&type=1';
				method="post";
				submit();
			}
		}
 }	 
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
		<form action="<%=path%>/scpbtable.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="19" align="center" bordercolor="#FFFFFF"><b>集中业务${month}月排班表</b>
							</td>
						</tr>
						<tr  >
							<td colspan="19" height="10px">
								<div align="center">
								月份
									<input size=10 type="text" name="month" id="month" readonly="readonly" value="${month}" onclick="setmonth(this,'yyyyMM','2010-01','2099-12',1)" >					
									<input type="submit" value="查询"/>
						</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="80px" align="center" valign="middle"
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>
							<c:forEach items="${listst}" var="st" varStatus="status">	
							<td  width="65px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>排班${status.index+1}组</p>
								</div></td>
							</c:forEach>	
						</tr>
							<c:forEach items="${liststhb}" var="stb" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle"><div
										align="center">${stb.date}</div></td>
								<c:if test="${size>0}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team1)}</div></td>
								</c:if>
								<c:if test="${size>1}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team2)}</div></td>
								</c:if>
								<c:if test="${size>2}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team3)}</div></td>
								</c:if>
								<c:if test="${size>3}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team4)}</div></td>
								</c:if>
								<c:if test="${size>4}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team5)}</div></td>
								</c:if>
								<c:if test="${size>5}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team6)}</div></td>
								</c:if>
								<c:if test="${size>6}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team7)}</div></td>
								</c:if>
								<c:if test="${size>7}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team8)}</div></td>
								</c:if>
								<c:if test="${size>8}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team9)}</div></td>
								</c:if>
								<c:if test="${size>9}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team10)}</div></td>
								</c:if>
								<c:if test="${size>10}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team11)}</div></td>
								</c:if>
								<c:if test="${size>11}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team12)}</div></td>
								</c:if>
								<c:if test="${size>12}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team13)}</div></td>
								</c:if>
								<c:if test="${size>13}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team14)}</div></td>
								</c:if>
								<c:if test="${size>14}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team15)}</div></td>
								</c:if>
								<c:if test="${size>15}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team16)}</div></td>
								</c:if>
								<c:if test="${size>16}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team17)}</div></td>
								</c:if>
								<c:if test="${size>17}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team18)}</div></td>
								</c:if>
								<c:if test="${size>18}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team19)}</div></td>
								</c:if>
								<c:if test="${size>19}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team20)}</div></td>
								</c:if>
								<c:if test="${size>20}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team21)}</div></td>
								</c:if>
								<c:if test="${size>21}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team22)}</div></td>
								</c:if>
								<c:if test="${size>22}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team23)}</div></td>
								</c:if>
								<c:if test="${size>23}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team24)}</div></td>
								</c:if>
								<c:if test="${size>24}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team25)}</div></td>
								</c:if>
								<c:if test="${size>25}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team26)}</div></td>
								</c:if>
								<c:if test="${size>26}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team27)}</div></td>
								</c:if>
								<c:if test="${size>27}">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:bancitostring(stb.team28)}</div></td>
								</c:if>
							</tr>
						</c:forEach>
				</table>
			</form>
			
			<form action="<%=path%>/userlist.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>集中生产班次</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="130px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上班时间<br/>（考勤开始时间）</p>
								</div></td>
							<td  width="130px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>下班时间<br/>（考勤结束时间）</p>
								</div></td>
							<td  width="330px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>作业时间</p>
								</div></td>
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>培训/自我总结时间</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>备注</p>
								</div></td>	
						</tr>
							<c:forEach items="${listsp}" var="sp" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">班次${sp.no}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${sp.sbtime}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${sp.type==2}">日终</c:if><c:if test="${sp.type!=2}">${sp.xbtime}</c:if></div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${sp.zytime}<c:if test="${sp.type==2}">日终</c:if></div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${sp.pxtime}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${sp.type==6}">正常班1</c:if>
										<c:if test="${sp.type==7}">正常班2</c:if>
										<c:if test="${sp.type==8}">正常班3</c:if>
										<c:if test="${sp.type==3}">早班</c:if>
										<c:if test="${sp.type==1}">小晚班</c:if>
										<c:if test="${sp.type==2}">大晚班</c:if>
										<c:if test="${sp.type==4}">监控</c:if>
										<c:if test="${sp.type==5}">试点</c:if>
										<c:if test="${sp.type==9}">试点1</c:if>
										<c:if test="${sp.type==10}">试点2</c:if>
										<c:if test="${sp.type==11}">试点3</c:if>
										<c:if test="${sp.type==12}">试点4</c:if>
										<c:if test="${sp.type==13}">试点5</c:if>
										</div></td>		
							</tr>
						</c:forEach>
			</table>
		</form>
		<br/>
  </body>
</html>
