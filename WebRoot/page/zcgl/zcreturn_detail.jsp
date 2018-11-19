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
	<script type="text/javascript">
	function tijiao()
		{
			with(document.forms[0]) {
			action='zcreturnqueren.action';
			method="post";
			submit();
			}
		}
		
   </script>

 

  <style type="text/css">
  .as {
	text-align: center;
}
b{
	color:red;
}
  </style>
  </head>
  
  <body> 
 ${daohang} 
    <form>
    		<br>
    			<br> 
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心资产归还表</strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr height="50">
    			<td width="150" class="as"  >
    				归还处室<b>*</b>
    			</td>
    			<td width="145" class="as" >
    				<input type="hidden" id="chu" name="chu" value="${chu}"/> 
    				${fb:positiontoname(position)}
    			</td>
    			<td width="100" class="as" >
    				资产管理员<b>*</b>
    			</td>
    			<td width="100" class="as" >
    				<input style="width:50px" id="username" type="hidden" name="username" value="${ui.username}"  />
    				${ui.username}
    			</td>
    			<td width="120" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				${ay.tel}
    			</td>
    		</tr>
    	
    		<tr height="40">
    			<td  class="as" >
    				资产名称<b>*</b>
    			</td>
    			<td  colspan="5"  >
    				<c:forEach items="${listap}" var="af" varStatus="status">
    				          资产名称：${af.name}&nbsp;&nbsp;资产型号：${af.type}&nbsp;&nbsp;资产编号：${af.number}&nbsp;&nbsp;使用人：${af.username}&nbsp;&nbsp;使用区域：${af.area} <c:if test="${af.returntime!='0'}">&nbsp;&nbsp;归还时间：${af.returntime} </c:if>   <br/>
    				</c:forEach>
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td  class="as">
    				归还原因<b>*</b>
    			</td>
    			<td colspan="5" class="as">
    			    ${ay.reason}
    			</td>
    			
    		</tr>
    		
    		<tr height="40">
    			<td class="as">
    				处室意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'}">
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
      					<c:if test="${lp.authority=='H'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5" class="as">
    				${ay.remark}
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="number" value="${ay.number}"/>
    				<c:if test="${queren==1}">
    				<input type="button" onclick="tijiao();" value="确   认" />
    				</c:if>
    				<input type="button" onclick="javascript:history.go(-1);" value="返   回" />
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
