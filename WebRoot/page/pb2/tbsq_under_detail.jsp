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
  function tijiao() {
	  var radio=document.getElementsByName("radio");
	  var xuanze = document.getElementById("xuanze").value;
	  var message = "确认提交？";
	  if(radio[0].checked!=true&&radio[1].checked!=true)
		{
			alert("请选择审批意见");
		}
	  else if(xuanze=="wu"&&radio[0].checked==true)
		{
			alert("请选择下一级审批人");
		}
		else
		{
			if (window.confirm(message)) {
				with(document.forms[0]) {
					action='tbsqshenpi.action';
					method="post";
					submit();
				}
			}
		}
  } 
  </script>
  </head>
  
  <body>
    <form action="subjbsppage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="color:red;"><c:if test="${dai==1}">（代）</c:if></font>业务处理中心业务处理人员调班审批单</strong><strong> </strong></p>
        <table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="121" class="as">
    				发起人<b>*</b>
    			</td>
    			<td width="150">
    			<c:if test="${tp.initiator!=tp.applicant}">${fb:newnumbertoname(tp.initiator)}代</c:if>
    				${fb:newnumbertoname(tp.applicant)}
    			</td>
    			<td width="121" class="as">
    				调班日期<b>*</b>
    			</td>
    			<td width="150">
    					${tbdate}
    			</td>
    			<td width="89" class="as">
    				调班对象<b>*</b>
    			</td>
    			<td width="150">
    				${tp.tbname}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				调班事由<b>*</b>
    			</td>
    			<td colspan="5" id="p">
    				${tp.reason}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				原排班计划
    			</td>
    			<td colspan="5" id="pre">
					${tp.prejihua}&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				调整后计划
    			</td>
    			<td colspan="5" id="now">
    				${tp.nowjihua}&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				审批意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.viewer!='谭显福'}">审核人：</c:if>
     	 			${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
    				</c:forEach>&nbsp;
    				<input type="radio" name="radio" value="agree">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree">
        						不同意
     					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 备注：<input type="text" name="textfield" >
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
    		<c:if test="${nextunder!='no'}"> 
    		<tr>
    			<td class="as">
    				选择审批人
    			</td>
    			<td colspan="5">
    				<select name="xuanze">
        				<option value="wu">请选择下一级审批人</option>
        					<c:forEach items="${listui}" var="user" varStatus="status">
        					<c:if test="${newnumber!=user.newnumber}">
        						<option value="${user.newnumber}"> ${user.username}
        					</c:if>	
        						</option>
        					</c:forEach>
        			</select>
    			</td>
    		</tr>
    		</c:if>
    		<c:if test="${nextunder=='no'}">
    			<input type="hidden" name="xuanze" value="you"/>
    		</c:if> 
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="number" value="${tp.number}"/>
    				<input type="hidden" name="thisnewnumber" value="${newnumber}"/>
    				<input type="hidden" name="thisundername" value="${username}"/>
    				<input  type="button" onclick="tijiao()"  value="提  交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返回" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
