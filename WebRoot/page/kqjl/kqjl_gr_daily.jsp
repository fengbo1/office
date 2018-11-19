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
$('#yc').attr('value',x[0].value);
 });

 function tichuyy(o)
 {
	  if(confirm("确定提交？"))
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
						document.getElementById("kqjl"+o).innerHTML="异议已提交";
					}
				}
				xmlhttp.open("POST", "<%=path%>/tichuyy.action?id=" + o, true);
				xmlhttp.send();
			 //<%=path%>/tichuyy.action?id=${kqjl.id}
      }
	}
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
		var m = document.getElementById("month").value;
		 if(confirm("确认生成考勤记录汇总表？"))
	      {
			 window.location = "<%=path%>/processkqjlmonth.action?para="+o+"&month="+m;
	      }
	}
	function express()
	{
		var month = document.getElementById("month").value;
 		var name = document.getElementById("name").value;
 		var newnumber = document.getElementById("newnumber").value;
 		var yc = document.getElementById("yc").value;
		window.location = "<%=path%>/exportkqjlgrdaily.action?month="+month+"&name="+name+"&yc="+yc+"&newnumber="+newnumber;
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
								colspan="17" align="center" bordercolor="#FFFFFF"><b>${month}月考勤记录明细表</b>
							</td>
						</tr>
						<tr >
							<td align="center" colspan="17" height="10px" style="color:red">
								提示：补上月考勤缺失请在本月前3个工作日内完成。对其他考勤记录有异议，请联系考勤管理员。
							</td>
						</tr>
						<tr >
							<td colspan="2" height="10px">
								
							</td>
							<td colspan="13" height="10px">
								<div align="center">
									月份					
									<input size=10 type="text" name="month" id="month" readonly="readonly" value="${month}" onclick="setmonth(this,'yyyyMM','2010-01','2099-12',1)" >
								<c:if test="${authoB=='B'||authoD=='D'||authoC=='C'||authoA=='A'||authoI=='I'}">
								<select id="yc" name="yc" style="width: 100px">
									<option value="0">全部</option>
									<option value="1">异常</option>
								</select>	
									姓名	
								<input type="text" id="name" name="name" value="${strtemp}"/>								
								</c:if>
									<input type="submit" value="查询"/>
									<c:if test="${zhi<3||authoI=='I'||authoJ=='J'}">
									<input type="button" onclick="express()" value="导出"/>
									</c:if>
									<input type="hidden" name="para" value="${yc}"/>
						</div></td>
						<td colspan="2" height="10px">
								<div align="center">
								<!-- 
								<c:if test="${(autho=='C'||autho=='BH'||autho=='D'||autho=='OTC')&&ifschzb==1}">
									<input type="button" onclick="processmonth('${para}')" value="生成汇总表"/>
								</c:if>
								 -->
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
									<p>早签到</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>晚签退</p>
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
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>是否异常</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>	
									
						</tr>
							<c:forEach items="${list}" var="kqjl" varStatus="status">
							<tr class="btbj" id="hang" <c:if test="${kqjl.qdqs==1||kqjl.qtqs==1}">style="color:red"</c:if>>
								
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
											<c:if test="${kqjl.halfday==0}">是</c:if>
										</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.pbqdtime}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:plusfiveminutes(kqjl.pbqdtime)}</div></td>				
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${kqjl.pbqttime}</div></td>								
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center" id="qd${kqjl.id}">
										<c:if test="${kqjl.qdqs==2||kqjl.qdqs==1}"><p style="color:red"></c:if>
										<c:if test="${kqjl.qdqs==3}">(补)</c:if>
										${kqjl.qdtime}
										<c:if test="${empty kqjl.qdtime}">无指纹记录</c:if>
										</p>
										<!--考勤异议提出与删除功能，暂不用 --> 
										<c:if test="${kqjl.yy==1&&(zhi=='4'||zhi=='2'||zhi=='1')}">
											<a id="aqd${kqjl.id}"	href="#" onclick="deletekq(${kqjl.id},1)">
											<c:if test="${fb:lengthofstring(kqjl.qdtime)>0}">删除</c:if></a>
										</c:if>
										</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center" id="qt${kqjl.id}">
											<c:if test="${kqjl.qtqs==2||kqjl.qtqs==1}"><p style="color:red"></c:if>
											<c:if test="${kqjl.qtqs==3}">(补)</c:if>
											${kqjl.qttime}
											<c:if test="${empty kqjl.qttime}">无指纹记录</c:if>
											</p>
											<!--考勤异议提出与删除功能，暂不用  -->
											<c:if test="${kqjl.yy==1&&(zhi=='4'||zhi=='2'||zhi=='1')}">
											<a id="aqt${kqjl.id}"	href="#" onclick="deletekq(${kqjl.id},2)">
											<c:if test="${fb:lengthofstring(kqjl.qttime)>0}">删除</c:if></a>
											</c:if>
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
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${kqjl.yc!=0}">是</c:if></div></td>			
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center" id="kqjl${kqjl.id}">
										<c:if test="${kqjl.qdqs==1&&username==kqjl.name}">
										<a	href="<%=path%>/showkqqspagebukqjl.action?newnumber=${newnumber}&date=${kqjl.date}&qdqt=qd">补签到</a>
										</c:if>
										<c:if test="${kqjl.qtqs==1&&username==kqjl.name}">&nbsp;&nbsp;&nbsp;
										<a	href="<%=path%>/showkqqspagebukqjl.action?newnumber=${newnumber}&date=${kqjl.date}&qdqt=qt">补签退</a>
										</c:if>
										<!--
										<a	href="#" onclick="qrdelete(${kqjl.id},2)">
										<c:if test="${fb:lengthofstring(kqjl.qdtime)>0||fb:lengthofstring(kqjl.qttime)>0}">
										确认修改
										</c:if>
										</a>
										-->
								</div></td>	
										
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="17">
								<div align="center">
								<a	href="<%=path%>/kqjlgrdaily.action?zhuan=1&currentPage=${previousPage}&newnumber=${newnumber}&yc=${yc}&month=${month}&name=${strtemp}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/kqjlgrdaily.action?zhuan=1&currentPage=${nextPage}&newnumber=${newnumber}&yc=${yc}&month=${month}&name=${strtemp}"
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
