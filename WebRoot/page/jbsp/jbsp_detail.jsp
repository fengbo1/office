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
  </head>
  
  <body>
  ${daohang}
    <form action="#" method="post">
    <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><c:if test="${bu=='1'}"><font style="color:red;">（补）</font></c:if>业务处理中心加班审批备案表</strong><strong> </strong></p>
    	<table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="121" class="as">
    				姓名
    			</td>
    			<td width="176">
    				${fb:newnumbertoname(jp.applicant)}
    			</td>
    			<td width="72" class="as">
    				处室
    			</td>
    			<td width="175">
    				${fb:positiontoname(position)}
    			</td>
    			<td width="89" class="as">
    				联系方式
    			</td>
    			<td width="201">
    				${jp.tel}
    			</td>
    		</tr>
    		<tr>
    			<td  class="as">
    				加班人
    			</td>
    			<td colspan="5" id="p">
     	 					${jp.people}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				加班事由
    			</td>
    			<td colspan="5">
    				${jp.reason}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				加班时间
    			</td>
    			<td colspan="5">
    				${begindate}<c:if test="${jp.halfday=='0'||jp.halfday=='2'}">上午</c:if><c:if test="${jp.halfday=='1'||jp.halfday=='3'}">下午</c:if>&nbsp;至
      				${enddate}<c:if test="${jp.halfday=='2'||jp.halfday=='3'}">上午</c:if><c:if test="${jp.halfday=='0'||jp.halfday=='1'}">下午</c:if>&nbsp;，共
      				${jp.days}天
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
    				</c:forEach>&nbsp;
    				
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
    				</c:forEach>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">${jp.remark}&nbsp;
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
    				<input type="button" onclick="javascript:history.go(-1);" value="返回" />
    				<input type="hidden" name="number" value="${number}"/>
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
