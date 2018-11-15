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
    <base href="<%=basePath%>">
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>My JSP 'authorityfailed.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
  <style type="text/css">
  .as {
	text-align: center;
}
  </style>
  	<style type="text/css">
	table{
     border-collapse:collapse;
}
table td{
     empty-cells:show;
}
	</style>
	<script type="text/javascript">
		function tijiao()
		{
			var baodaodate= document.getElementById("baodaodate").value;
			var rg10=document.getElementById("RadioGroup1_0");
			var rg11=document.getElementById("RadioGroup1_1");
			if(baodaodate=="")
			{
				alert("请选择报到日期");
			}
			else if(!rg10.checked&&!rg11.checked)
			{
				alert("请选择上午或下午");
			}
			else
			{
				with(document.forms[0]) {
				action='wcggbaodao.action';
				method="post";
				submit();
				}
			}
		}
	
	</script>
  </head>
  
  <body>
  ${daohang}
    <form action="wcggbaodao.action" method="post">
    <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong> <font style="color:red;"><c:if test="${dai=='1'}">（代）</c:if><c:if test="${bu=='1'}">（补）</c:if></font>业务处理中心外出公干备案表</strong><strong> </strong></p>
    	<table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="121" class="as">
    				姓名
    			</td>
    			<td width="176">
    				${fb:newnumbertoname(wp.applicant)}
    			</td>
    			<td width="72" >
    				处室
    			</td>
    			<td width="175">
    				${fb:positiontoname(position)}
    			</td>
    			<td width="89" class="as">
    				联系方式
    			</td>
    			<td width="201">
    				${wp.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				同行人
    			</td>
    			<td colspan="5" id="p">
    				<c:forEach items="${listwb}" var="wb" varStatus="status">
     	 					${wb.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				</c:forEach>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				公干事由
    			</td>
    			<td colspan="5">
    				${wp.reason}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				公干地点
    			</td>
    			<td colspan="5">
    				${wp.addr}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				往返时间
    			</td>
    			<td colspan="5">
    				${begindate}<c:if test="${wp.halfday=='0'||wp.halfday=='2'}">上午</c:if><c:if test="${wp.halfday=='1'||wp.halfday=='3'}">下午</c:if>&nbsp;，预计至
      				${enddate}<c:if test="${wp.halfday=='2'||wp.halfday=='3'}">上午</c:if><c:if test="${wp.halfday=='0'||wp.halfday=='1'}">下午</c:if>&nbsp;，共
      				${wp.days}天
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				所在处室意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'}">
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				中心审批意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='A'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				回中心报到时间
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listwb}" var="wb" varStatus="status">
    				<c:if test="${wb.status==2}"> 
     	 					<div style="float:left;width:120px">姓名：${wb.name}</div>
     	 					<div style="float:left;width:260px">报到时间：${fb:simpletostanderd(wb.baodaodate)}&nbsp;&nbsp;${fb:sxwtostring(wb.bdhalfday)}</div>
     	 					 <c:if test="${autho=='I'}">
     	 					 <div style="float:left;width:100px"><a	href="<%=path%>/page/wcgg/wcgg_baodao_xg.jsp">修改报到时间</a></div>
     	 					 </c:if>
     	 					<br/>
    				</c:if>
    				</c:forEach>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">${wp.remark}
    				 <c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.role=='撤销'}"> 
     	 					${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.role=='收回'}"> 
     	 					${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				
    				<input type="hidden" name="number" value="${number}"/>
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<c:forEach items="${listwb}" var="wb" varStatus="status">
    				<c:if test="${(wb.newnumber==newnumber)&&(wb.status==1)}">
    				<div style="float:left;padding-top:8px;">
    					选择回中心报到时间：
    					<input width="400"  type="text" name="baodaodate" id="baodaodate" class="Wdate" onClick="WdatePicker()" >
    					<p style="color:red">（注意！报到时间请选择实际回中心到岗上班时间）</p>
    				
    				</div>
    				 <div style="float:left">  
     					<input type="radio" name="RadioGroup1" value="1" id="RadioGroup1_0">上午<br>
        				<input type="radio" name="RadioGroup1" value="2" id="RadioGroup1_1">下午
    				 </div>
    				 <div style="float:left;padding-top:8px;width:130px"> 
    				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
    				<input type="button" onclick="tijiao()" value="确认报到" />
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				</div>
    				</c:if>
    				</c:forEach>
    				<div style="float:left;padding-top:8px;">
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    				</div>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
