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
b{
	color:red;
}
  </style>
  <script type="text/javascript">
  		function chexiao()
  		{
  			var message = "确认撤销？";
			if (window.confirm(message)) {
				with(document.forms[0]) {
					action='updatexpstatus.action';
					method="post";
					submit();
				}
			}


  	  		}
  
  
  </script>
  </head>
  
  <body>
    <form action="subjbsppage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心因公下线审批单</strong><strong> </strong></p>
        <table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
         <p align="right" style="padding:0px;margin:0px"><strong> 编号：${xp.number}</strong></p>
    		<tr>
    			<td width="121" class="as">
    				发起人<b>*</b>
    			</td>
    			<td colspan="3" width="176">
    				${fb:newnumbertoname(xp.initiator)}
    			</td>
    			<td width="89" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td width="201">
    				${xp.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				下线员工
    			</td>
    			<td colspan="5" id="p">
    				${xp.people}&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				下线时间段<b>*</b>
    			</td>
    			 <td colspan="5" >
     				${begindate}
     				<c:if test="${xp.halfday==0||xp.halfday==2}">上午</c:if><c:if test="${xp.halfday==1||xp.halfday==3}">下午</c:if>
     				起，至
     				${enddate}
     				<c:if test="${xp.halfday==0||xp.halfday==1}">下午</c:if><c:if test="${xp.halfday==2||xp.halfday==3}">上午</c:if>
     				止，共${xp.day}天${xp.hour}小时
        		</td>
    		</tr>
    		<tr>
    			<td class="as">
    				下线事由<b>*</b>
    			</td>
    			<td colspan="5">
    				${fb:ygxxreasontostring(xp.reason)}<c:if test="${xp.reason==20}">（${xp.qita}）</c:if>
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
    			<td colspan="5">
    				${xp.remark}&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="button" onclick="javascript:history.go(-1);" value="返回" />
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<c:if test="${(authoI=='I')&&(xp.status!=6)}">
    					撤销一个人
    					<input type="text" name="delname"/>
    					<input type="button" onclick="chexiao()" value="撤销" />
    				</c:if>
    				<input type="hidden" name="number" value="${xp.number}"/>
    				<input type="hidden" name="type" value="8"/>
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
