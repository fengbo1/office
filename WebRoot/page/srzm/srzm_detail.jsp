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
			with(document.forms[0]) {
			action='srzmqueren.action';
			method="post";
			submit();
			}
		}
	</script>	
	
  </head>
  
  <body>
  ${daohang}
    <form >
    <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong> <font style="color:red;"><c:if test="${dai=='1'}">（代）</c:if></font>业务处理中心成都分中心收入证明申请表</strong><strong> </strong></p>
    	<table height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as" >
    				姓名
    			</td>
    			<td width="176" >
    				${fb:newnumbertoname(tz.applicant)}
    			</td>
    			<td width="101" class="as" >
    				性别
    			</td>
    			<td width="75" >
    				${tz.sex}
    			</td>
    			<td width="121" class="as">
    				 身份证号码
    			</td>
    			<td width="201">
    				<input type="hidden" id="identity" name="identity" value="${ui.identity}"/> 
    				${ui.identity}
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				所在部门
    			</td>
    			<td colspan="3">
    			<input type="hidden" id="chu" name="chu" value="${fb:positiontoname(position)}"/>
    				${fb:positiontoname(position)}
    			</td>
    			<td  class="as">
    				联系电话
    			</td>
    			<td width="201">
    				${tz.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				来总行工作时间
    				
    			</td>
    			<td colspan="2">
    				<input type="hidden" id="zxdate" name="zxdate" value="${ui.zxdate}"/> 
    				${ui.zxdate}
    			</td>
    		
    			<td class="as">
    				现任职务
    			</td>
    			 <td colspan="2"><!--  <input type="text" id="zhiwu" name="zhiwu" style="padding:0px;margin:0px;">-->
      	           ${tz.zhiwu}
	  	
	         </td>
    		</tr>
    		<tr>
    			<td class="as">
    				收入证明用途  
    			</td>
    			<td colspan="3">
    			${tz.yongtu}
    			</td>
    			<td class="as">
    				所需份数
    			</td>
    			<td>
    			${tz.neednumber}
    			</td>
    		</tr>
    		 <tr>
    			<td class="as">
    				收入证明接收单位
    			</td>
    			<td colspan="5">
    			${tz.todepartment}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请人   （签字）
    			</td>
    			<td colspan="5">
    				${ui.username} &nbsp;&nbsp;&nbsp;&nbsp; ${tz.date} 
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				综合与生产管理处意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='J'}"> 
     	 					审核人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审核时间：${lp.time}<br/>
      					</c:if>
      					<c:if test="${lp.authority=='G'}"> 
     	 					审核人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审核时间：${lp.time}<br/>
      					</c:if>
    					<c:if test="${lp.authority=='H'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">${tz.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
    				<input type="button" onclick="javascript:history.go(-1);" value="返   回" />
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<c:if test="${queren==1}">
						<input type="button" onclick="tijiao()" value="确   认" />    				
    				</c:if>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
