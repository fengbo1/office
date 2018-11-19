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
  	<script type="text/javascript">
		function tijiao()
		{
			with(document.forms[0]) {
			action='kqqsqueren.action';
			method="post";
			submit();
			}
		}
	</script>
  </head>
  
  <body>
  ${daohang}
    <form action="#" method="post">
    <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><c:if test="${kp.bu==1}"><font style="color:red;">（补）</font></c:if><c:if test="${dai=='1'}"><font style="color:red;">（代）</font></c:if>业务处理中心考勤缺失备案表</strong></p>
    	<table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as">
    				姓名
    			</td>
    			<td width="176">
    				${fb:newnumbertoname(kp.applicant)}
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
    				${kp.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				记录缺失日期
    			</td>
    			<td colspan="5">
    				${qsdate}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${fb:qdqttostring(kp.qdqt)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<c:if test="${not empty kp.cs}">本月第${kp.cs}次补考勤缺失</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				记录缺失原因
    			</td>
    			<td colspan="5">
    				${kp.reason}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				<c:if test="${kp.qdqt==1}">实际到岗时间</c:if>
    				<c:if test="${kp.qdqt==2}">实际离岗时间</c:if>
    			</td>
    			<td colspan="5">
    				${kp.qstime}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				审批意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    				审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
    				</c:forEach>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">${kp.remark}&nbsp;
    				
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="button" onclick="javascript:history.go(-1);" value="返   回" />
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<c:if test="${queren==1}">
						<input type="button" onclick="tijiao()" value="确   认" />    				
    				</c:if>
    				<input type="hidden" id="number" name="number" value="${number}"/>
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
