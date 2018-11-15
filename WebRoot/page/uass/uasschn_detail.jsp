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
  
  <script type="text/javascript">
  	function expressword()
	{
  		var message = "确认导出？";
		if (window.confirm(message)) {
			with(document.forms[0]) {
				action='uschdaochu.action';
				method="post";
				submit();
			}
		}
  	}
  
  	function expressexcel()
	{
  		var message = "确认导出？";
		if (window.confirm(message)) {
			with(document.forms[0]) {
				action='uschexport.action';
				method="post";
				submit();
			}
		}
  	}
  	function tijiao()
	{
		with(document.forms[0]) {
		action='uassqueren.action';
		method="post";
		submit();
		}
	}
  </script>
  
  <body>
    <form action="usptshenpi.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>行方COS_T系统用户维护申请表</strong></p>
        <table width="860" height="550" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as">
    				发起人
    			</td>
    			<td width="250">
    				${fb:newnumbertoname(up.initiator)}
    			</td>
    			<td width="150" class="as">
    				用户编号
    			</td>
    			<td width="250">
    				${ui.newnumber}
    			</td>
    		</tr>
    		<tr>	
    			<td class="as">
    				所在处室
    			</td>
    			<td>
    				${fb:positiontoname(position)}
    			</td>
    			<td class="as">
    				移动电话
    			</td>
    			<td>
    				${up.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				具体事项内容
    			</td>
    			<td colspan="3" >
    				<c:forEach items="${listupp}" var="upp" varStatus="status">
    					${upp.name}${fb:nametonewnumber(upp.name)}:${upp.content891};${upp.content890};${upp.remark1}<br/>
    				</c:forEach>
    				<p align="right">建议生效日期：${up.sxtime}</p>&nbsp;
    				<c:if test="${up.remark!=null}">
    				<p align="left">UASS管理员备注：${up.remark}</p>
    				</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请部门意见
    			</td>
    			<td colspan="3" id="p">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='C'}"> 
    						审核人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    					<c:if test="${lp.authority=='B'}"> 
    						审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    				</c:forEach>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				会签部门意见
    			</td>
    			<td colspan="3" id="p">&nbsp;
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='X'}"> 
    					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    				</c:forEach>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				中心部门意见
    			</td>
    			<td colspan="3" id="p">&nbsp;
    			<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='A'}"> 
    					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    				</c:forEach>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3">
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    				<input type="hidden" name="number" value="${number}"/>
 					<input type="button" onclick="expressword();" value="导出word" />
 					<input type="button" onclick="expressexcel();" value="导出excel" />
 					
 					<c:if test="${queren==1}">
						<input type="button" onclick="tijiao()" value="处    理" /> 
    				</c:if>
    				<c:if test="${authoO=='o'}">
    					<input type="text" name="remark" id="remark" value="${up.remark}" /> 
						<input type="button" onclick="tijiao()" value="处理并提交意见" /> 
    				</c:if>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
