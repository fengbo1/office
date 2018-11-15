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
 });

 function del(a,b)
 {
	 var message = "";
	 if(a=="scpb"||a=="ygpb")
	 {
		 message = "是否删除班次"+b;
	}
	 else if(a=="st")
	 {
		 message = "是否删除最后一个排班小组？";
		 }	
	 else if(a=="pt")
	 {
		 message = "是否删除特殊人员"+b;
		 }
     else if(a=="pp")
	 {
		 message = "是否删除单独排班人员"+b;
		 }
	if (window.confirm(message)) {
		with(document.forms[0]) {
			action='pbdel.action?type='+a+'&no='+b;
			method="post";
			submit();
		}
	}
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  <form action="<%=path%>/userlist.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>集中生产班次设置</b>
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
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
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
										
										</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${authoI=='I'||authoT=='T'}">
										<a href="<%=path%>/scpbtomodify.action?id=${sp.id}&no=${sp.no}">修改</a>&nbsp;<a href="#" onclick="del('scpb','${sp.no}')">删除</a>
										</c:if>
										</div></td>
							</tr>
						</c:forEach>
						<tr class="表格表头背景">
								<td colspan="7" height="25" align="left" valign="middle" nowrap><div
										align="center">
										<c:if test="${authoI=='I'||authoT=='T'}">
										<a href="<%=path%>/scpbtoadd.action">新增班次</a>
										</c:if>
										</div></td>
							</tr>
			</table>
		</form>
		<br/>
		<!-- 
  		 <form action="<%=path%>/userlist.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>员工响应班次设置</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上班时间</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>下班时间</p>
								</div></td>
							<td  width="330px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>作业时间</p>
								</div></td>
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
						</tr>
							<c:forEach items="${listyp}" var="yp" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">班次${yp.no}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${yp.sbtime}</div></td>		
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${yp.xbtime}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${yp.zytime}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center"><a href="<%=path%>/ygpbtomodify.action?no=${yp.no}">修改</a>&nbsp;<a href="#" onclick="del('ygpb','${yp.no}')">删除</a></div></td>
							</tr>
						</c:forEach>
						<tr class="表格表头背景">
								<td colspan="6" height="25" align="left" valign="middle" nowrap><div
										align="center">
										<a href="<%=path%>/ygpbtoadd.action">新增计划</a>
										</div></td>
							</tr>
				</table>
			</form>
		<br/>
		 -->
		<form action="<%=path%>/userlist.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>集中生产小组人员设置</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="70px" align="center" valign="middle"
								bordercolor=none><div align="center">
									<p>组别</p>
								</div></td>
							<td  width="120px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>组长</p>
								</div></td>
							<td  width="600px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>组员</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
						</tr>
							<c:forEach items="${listst}" var="st" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle"><div
										align="center">${st.no}组</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${st.leader}</div></td>		
								<td  width="600px" height="25" align="center" valign="middle"><div
										align="center">${st.member}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${authoI=='I'||authoT=='T'}">
										<a onclick="return confirm('修改小组信息后，排班明细需要重新计算！');" href="<%=path%>/sttomodify.action?no=${st.no}&id=${st.id}&unpaiban=${unpaiban}">修改</a>
										</c:if>
										</div></td>
							</tr>
						</c:forEach>
						<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle"><div
										align="center">未分排班小组</div></td>
								<td width="820px" colspan="3" height="25" align="center" valign="middle"><div
										align="center">${unpaiban}</div></td>		
							</tr>
						<tr class="表格表头背景">
								<td colspan="6" height="25" align="left" valign="middle" nowrap><div
										align="center">
										<c:if test="${authoI=='I'||authoT=='T'}">
										<a href="<%=path%>/sttoadd.action?unpaiban=${unpaiban}">新增小组</a>&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a align="right" href="#" onclick="del('st','${st.no}')">删除最后一个小组</a>
										</c:if>
										</div></td>
							</tr>
				</table>
			</form>
		<br/>
		<form action="<%=path%>/userlist.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>特殊人员设置</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="70px" align="center" valign="middle"
								bordercolor=none><div align="center">
									<p>人员</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>事项</p>
								</div></td>
							<td  width="300px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>有效期</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
						</tr>
							<c:forEach items="${listpt}" var="pt" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle"><div
										align="center">${pt.name}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${pt.item==1}">哺乳假</c:if></div></td>		
								<td height="25" align="center" valign="middle"><div
										align="center">${pt.yxbegin}-${pt.yxend}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${authoI=='I'||authoT=='T'}">
										<a href="<%=path%>/pttomodify.action?id=${pt.id}">修改</a>&nbsp;<a href="#" onclick="del('pt','${pt.id}')">删除</a>
										</c:if>
										</div></td>
							</tr>
						</c:forEach>
						<tr class="表格表头背景">
								<td colspan="6" height="25" align="left" valign="middle" nowrap><div
										align="center">
										<c:if test="${authoI=='I'||authoT=='T'}">
										<a href="<%=path%>/page/pb/ptadd.jsp">新增特殊人员</a>
										</c:if>
										</div></td>
							</tr>
				</table>
			</form>
		<br/>
		
		<form action="<%=path%>/userlist.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>单独人员排班设置</b>
							</td>
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="150px" align="center" valign="middle"
								bordercolor=none><div align="center">
									<p>人员</p>
								</div></td>
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>班次</p>
								</div></td>
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>是否调休</p>
								</div></td>
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
						</tr>
							<c:forEach items="${listpp}" var="pp" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle"><div
										align="center">${pp.name}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">${pp.date}</div></td>		
								<td height="25" align="center" valign="middle"><div
										align="center"><c:if test="${pp.plan!=0}">班次${pp.plan}</c:if><c:if test="${pp.plan==0}">无</c:if></div></td>
								<td height="25" align="center" valign="middle"><div
										align="center">${fb:newresttostring(pp.isrest)}</div></td>
								<td height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${authoI=='I'||authoT=='T'}">
										<a href="<%=path%>/pptomodify.action?id=${pp.id}">修改</a>&nbsp;<a href="#" onclick="del('pp','${pp.id}')">删除</a>
										</c:if>
										</div></td>
							</tr>
						</c:forEach>
						<tr class="表格表头背景">
								<td colspan="6" height="25" align="left" valign="middle" nowrap><div
										align="center">
										<c:if test="${authoI=='I'||authoT=='T'}">
										<!-- <a href="<%=path%>/pptoadd.action">新增单独排班人员</a> -->
										</c:if>
										</div></td>
							</tr>
				</table>
			</form>
			
			<br/>
  </body>
</html>
