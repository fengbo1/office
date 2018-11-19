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

	
	 $(document).ready(function(){ 
		 if(${authoJ!='J'}&&${authoL!='L'})
		 {
			 document.getElementById("it1").disabled="disabled";
			 document.getElementById("it4").disabled="disabled";
			 document.getElementById("it5").disabled="disabled";
		}
		 

		 var xgcheck=document.getElementById("xgcheck").value;
		 if(xgcheck.length>4&&document.getElementById("it1")!=null)
		 {
			 if(xgcheck.substr(0,1)=="1")
			 {
				 document.getElementById("it1").checked=true;	
			 }
			 if(xgcheck.substr(1,1)=="1")
			 {
				 document.getElementById("it2").checked=true;	
			 }
			 if(xgcheck.substr(2,1)=="1")
			 {
				 document.getElementById("it3").checked=true;	
			 }
			 if(xgcheck.substr(3,1)=="1")
			 {
				 document.getElementById("it4").checked=true;	
			 }
			 if(xgcheck.substr(4,1)=="1")
			 {
				 document.getElementById("it5").checked=true;	
			 }	

			}
		  
		 });
	

	 function tijiao() {
		  var xuanze = document.getElementById("xuanze").value;
		  var tel=document.getElementById("tel").value;
		  var name=document.getElementById("name").value;
		  var sxtime=document.getElementById("sxtime").value;
		  var nowdate=document.getElementById("nowdate").value;
		  var message = "请确认是否已上传必要的附件？";
		  if(sxtime<=nowdate)
			{
				alert("生效日期应晚于今日！");
				  return;
			}
		  if('${type}'=='new')
		  {
			  alert("请至少保存一位维护对象");
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
		  else if(sxtime=="")
			{
				alert("请选择生效时间");return;
			}
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						action='subusptpage.action';
						method="post";
						submit();
					}
				}
			}
	  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
		} 

	function baocun()
	{
		var check = "";
		var it1=document.getElementById("it1");
		var it2=document.getElementById("it2");
		var it3=document.getElementById("it3");
		var it4=document.getElementById("it4");
		var it5=document.getElementById("it5");

		var addp=document.getElementById("addp");

		if(addp!=null&&addp.value=='')
		{
			alert("请填写姓名");
			return;
		}

		if(it1==null)
		{
			return;
		}
		if(it1.checked)
		{
			check+="1";
		}
		else
		{
			check+="0";
		}
		if(it2.checked)
		{
			check+="1";
		}
		else
		{
			check+="0";
		}
		if(it3.checked)
		{
			check+="1";
		}
		else
		{
			check+="0";
		}
		if(it4.checked)
		{
			check+="1";
		}
		else
		{
			check+="0";
		}
		if(it5.checked)
		{
			check+="1";
		}
		else
		{
			check+="0";
		}
		if(check=="00000")
		{
			alert("请选择事项");
			return;
		}
		var message = "确认保存？";
		if (window.confirm(message)) {
			with(document.forms[0]) {
				action='baocunuspt.action?check='+check+'&type=baocun';
				method="post";
				submit();
			}
		}
		}


	function xinzeng()
	{
		var message = "确认新增？";
		if (window.confirm(message)) {
			with(document.forms[0]) {
				action='baocunuspt.action?type=xinzeng&uppid=0';
				method="post";
				submit();
			}
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
  <b>${message }</b>
    <form name="filename" action="subusptpage.action" method="post" enctype="multipart/form-data">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>平台用户维护申请表</strong></p>
        <table width="860" height="550" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as">
    					发起人<b>*</b>
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
    				维护对象<b>*</b>
    			</td>
    			<td colspan="3" id="p">
    				<c:if test="${type=='new'&&brdf=='br'}">
    					${ui.username}
    				</c:if>
    				<c:if test="${type=='xinzeng'||type=='baocun'||type=='xg'}">
    				<c:forEach items="${listupp}" var="upp" varStatus="status">
    					${upp.name}&nbsp;&nbsp;事项：${fb:uassptitemtostring(upp.item)}；维护内容：${upp.content}&nbsp;&nbsp;
    					<a href="<%=path%>/usptxiugai.action?type=xg&number=${number}&newnumber=${newnumber}&uppid=${upp.id}">修改</a> 
    					&nbsp;
    					<a href="<%=path%>/usptxiugai.action?type=sc&number=${number}&newnumber=${newnumber}&uppid=${upp.id}">删除</a> 
    					<br/>
    				</c:forEach>
    				</c:if>
    				<c:if test="${type!='baocun'&&(type!='new'||brdf=='df')}">
    					填写姓名<input type="text" id="addp" name="addp" value="${uppxg.name}"/>
    				</c:if>
    			</td>
    		</tr>
    		<c:if test="${type!='baocun'}">
    		<tr>
    			<td class="as">
    				申请事项<b>*</b>
    			</td>
    			<td colspan="3" id="p">
    				<input type="checkbox" id="it1" name="it1"/>用户新增&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it2" name="it2"/>用户基本信息变更&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it3" name="it3"/>用户岗位信息变更<br/>
    				<input type="checkbox" id="it4" name="it4"/>机构基本信息变更&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it5" name="it5"/>机构权限或其他信息变更
    			</td>
    		</tr>
    		</c:if>
    		<tr>
    			<td class="as">
    				具体事项内容<b>*</b>
    			</td>
    			<td colspan="3" id="p">&nbsp;
    				<c:if test="${type!='baocun'}">
    				<textarea style="width:650px;height:70px" name="content">${uppxg.content}</textarea>
    				</c:if>
    				
    				<p align="right">建议生效日期：<input type="text" id="sxtime" name="sxtime" value="${sxtime}" class="Wdate"  onClick="WdatePicker()" onchange="alert('建议生效日期原则上应不早于申请日期的次日')"/></p>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3" class="as">
    				<input style="width:70px" type="button" onclick="baocun()" value="保 存"/>&nbsp;&nbsp;&nbsp;&nbsp;
    				<input style="width:70px" type="button" onclick="xinzeng()" value="新 增"/>
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
    			<td class="as">
    				上传附件：
    			</td>
    			<td colspan="3" id="p">&nbsp;
    				<input type="file" name="file" />
    				
    			</td>
    		</tr>
    		<tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="number" value="${number}"/>
    				<input type="hidden" name="brdf" value="${brdf}"/>
    				<input type="hidden" id="xgcheck" value="${uppxg.item}"/>
    				<input type="hidden" id="nowdate" name="nowdate" value="${nowdate}"/>
    				<input type="hidden" name="obj" value="${obj}"/>
    				<input type="hidden" id="uppid" name="uppid" value="${uppid}"/>
    				<input type="hidden" name="dai" value="0"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>


