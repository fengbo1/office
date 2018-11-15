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

 function deletekq(o,m)
	{
		if(confirm("确定删除该考勤记录？"))
	      {
			var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					//$.alert(xmlhttp.responseText);
					//document.getElementById("kqjl"+o).innerHTML="已修改";
					if(m==1)
					{
						document.getElementById("qd"+o).innerHTML="";
					}
					if(m==2)
					{
						document.getElementById("qt"+o).innerHTML="";
					}
				}
			}
			if(m==1)
			{
				xmlhttp.open("POST", "<%=path%>/qrdelete.action?id="+o+"&qddel=1&qtdel=0&type=2", true);
			}
			if(m==2)
			{
				xmlhttp.open("POST", "<%=path%>/qrdelete.action?id="+o+"&qddel=0&qtdel=1&type=2", true);
			}
			xmlhttp.send();
	      }
	}
	//确认修改删除动作,传入id
	 function qrdelete(o,type)
	 {
		 var qddel = document.getElementById("delqd"+o).value;
		 var qtdel = document.getElementById("delqt"+o).value;
		 if(confirm("确定删除操作？"))
	      {
				 var xmlhttp;
					if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
						xmlhttp = new XMLHttpRequest();
					} else {// code for IE6, IE5
						xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
					}
					xmlhttp.onreadystatechange = function() {
						if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
							//$.alert(xmlhttp.responseText);
							document.getElementById("kqjl"+o).innerHTML="已修改";
							document.getElementById("aqd"+o).innerHTML="";
							document.getElementById("aqt"+o).innerHTML="";
						}
					}
					xmlhttp.open("POST", "<%=path%>/qrdelete.action?id="+o+"&qddel=" + qddel +"&qtdel="+ qtdel+"&type="+type, true);
					xmlhttp.send();
	      }
		}
	function processmonth(o)
	{
		 if(confirm("确认重新生成该员工考勤记录汇总表？"))
	      {
			 window.location = "<%=path%>/processkqjlmonth.action?para="+o+"&month=id";
	      }
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form action="<%=path%>/kqjlgrdaily.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="16" align="center" bordercolor="#FFFFFF"><b>${name}${month}月考勤记录明细表</b>
							</td>
						</tr>
						<tr >
						<td colspan="2" height="10px">
								<div align="center">
									<input type="button" value="返回" onclick="javascript:history.go(-1);">
						</div></td>	
						<td colspan="11" height="10px">
								<div align="center">
						</div></td>	
						<td colspan="2" height="10px">
								<div align="center">
									<input style="width:130px" type="button" onclick="processmonth('${id}')" value="重新生成汇总校验表"/>
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
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>是否出勤日</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上班时间</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>考勤开始时间</p>
							</div></td>					
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>下班时间</p>
								</div></td>				
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>签到时间</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>签退时间</p>
								</div></td>
							<td  width="80px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>迟到/早退情况</p>
								</div></td>		
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>是否请假</p>
								</div></td>	
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>是否公干</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>补考勤缺失情况</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>	
									
						</tr>
							<c:forEach items="${list}" var="kqjl" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.name}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:positiontoname(kqjl.position)}</div></td>		
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.date}</div></td>
								<td width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.week}</div></td>
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${kqjl.halfday==1}">下午半天</c:if>
										<c:if test="${kqjl.halfday==2}">上午半天</c:if>
										<c:if test="${kqjl.halfday==0&&fb:lengthofstring(kqjl.pbqdtime)>0&&fb:lengthofstring(kqjl.pbqttime)>0}">是</c:if>
										</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.pbqdtime}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:plusfiveminutes(kqjl.pbqdtime)}</div></td>					
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.pbqttime}</div></td>								
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center" id="qd${kqjl.id}">
										<c:if test="${kqjl.qdqs==2}"><p style="color:red"></c:if>
										<c:if test="${kqjl.qdqs==3}">(补)</c:if>
										${kqjl.qdtime}
										<c:if test="${empty kqjl.qdtime}">无指纹记录</c:if>
										</p>
										<!--考勤异议提出与删除功能，暂不用 --> 
											<a id="aqd${kqjl.id}"	href="#" onclick="deletekq(${kqjl.id},1)">
											<c:if test="${fb:lengthofstring(kqjl.qdtime)>0}">删除</c:if>
											</a>
										</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center" id="qt${kqjl.id}">
											<c:if test="${kqjl.qtqs==2}"><p style="color:red"></c:if>
											<c:if test="${kqjl.qtqs==3}">(补)</c:if>
											${kqjl.qttime}
											<c:if test="${empty kqjl.qttime}">无指纹记录</c:if>
											</p>
											<!--考勤异议提出与删除功能，暂不用  -->
											<a id="aqt${kqjl.id}"	href="#" onclick="deletekq(${kqjl.id},2)">
											<c:if test="${fb:lengthofstring(kqjl.qttime)>0}">删除</c:if></a>
											</div></td>
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<p style="color:red">
										${fb:qdqttypetostring(kqjl.qdqs,kqjl.qtqs)}
										</p>
										</div></td>				
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${kqjl.qj!=0}">${fb:typetostring(kqjl.qj)}</c:if></div></td>		
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${kqjl.gg!=0}">是</c:if></div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${kqjl.qdqs==3}">补签到</c:if>
										<c:if test="${kqjl.qtqs==3}">补签退</c:if></div></td>
								<!--考勤异议提出与删除功能，暂不用 -->	
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center" id="kqjl${kqjl.id}">
										<!--
										<a	href="#" onclick="qrdelete(${kqjl.id},2)">
										确认修改
										</a>
										-->
								</div></td>	
							</tr>
							</c:forEach>
		</table>
		</form>
  </body>
</html>
