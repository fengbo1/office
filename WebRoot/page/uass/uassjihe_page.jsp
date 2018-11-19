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
	<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	 function tijiao() {
		  var xuanze = document.getElementById("xuanze").value;
		  var tel=document.getElementById("tel").value;
		  var name=document.getElementById("name").value;
		  var content=document.getElementById("content").value;
		  var file1 = document.getElementById("file1").value;
		  var file2 = document.getElementById("file2").value;
		  var file3 = document.getElementById("file3").value;
		  var sxtime=document.getElementById("sxtime").value;
		  var nowdate=document.getElementById("nowdate").value;
		  var message = "确认提交？";
		  if(sxtime<=nowdate)
			{
				alert("生效日期应晚于今日！");
				  return;
			}
		  if(file1==""&&file2==""&&file3=="")
		  {
				alert("请上传相关附件！");
				return;
			}
		  if(content=="")
		  {
			  alert("请填写申请事项");
			  return;
			}
			
		  if(tel=="")
		  {
			  alert("请填写联系电话");
			  document.getElementById("tel").focus();return;
			}
		  else if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						action='usjhsubpage.action';
						method="post";
						submit();
					}
				}
			}
	  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
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
    <form name="filename" action="usjhsubpage.action" method="post" enctype="multipart/form-data">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>稽核用户维护申请表</strong></p>
        <table width="860" height="550" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as">
    					申请人<b>*</b>
    			</td>
    			<td width="250">
    				<input type="hidden" id="name" name="name" value="${ui.username}"/> 
    				${ui.username}
    			</td>
    			<td width="150" class="as">
    				用户编号<b>*</b>
    			</td>
    			<td width="250">
    				${ui.newnumber}
    			</td>
    		</tr>
    		<tr>	
    			<td class="as">
    				所在处室<b>*</b>
    			</td>
    			<td>
    				<input type="hidden" id="chu" name="chu" value="${fb:positiontoname(position)}"/>
    				${fb:positiontoname(position)}
    			</td>
    			<td class="as">
    				移动电话<b>*</b>
    			</td>
    			<td width="201">
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" value="${tel}"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请事项<b>*</b>
    			</td>
    			<td colspan="3" id="p">
    				<textarea name="content" style="width:600px;height:80px"></textarea>
    				<p align="right">建议生效日期：<input type="text" id="sxtime" name="sxtime" class="Wdate"  onClick="WdatePicker()" onchange="alert('建议生效日期原则上应不早于申请日期的次日')"/></p>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				上传附件<b>*</b>
    			</td>
    			<td colspan="3" id="p">
    				文件一：<input type="file" id="file1" name="file1" /><br/>
    			 	文件二：<input type="file" id="file2" name="file2" /><br/>
    				文件三：<input type="file" id="file3" name="file3" /> 
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请部门意见
    			</td>
    			<td colspan="3" id="p">&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				会签部门意见
    			</td>
    			<td colspan="3" id="p">&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				中心部门意见
    			</td>
    			<td colspan="3" id="p">&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="3">
    				<select name="thisunder" id="xuanze">
        				<option value="wu">请选择下一级审批人</option>
        				<c:if test="${zhi!='0'&&zhi!='1'}">
        					<c:forEach items="${list}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        				</c:if>	
        			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3">
    				<input type="hidden" id="nowdate" name="nowdate" value="${nowdate}"/>
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="number" value="${number}"/>
    				<input type="hidden" name="obj" value="${obj}"/>
    				<input type="hidden" name="dai" value="0"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
