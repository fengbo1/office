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
  
  function showpaiban()
   {		
	  with(document.forms[0]) {
		action="viewygunderpw.action?isdai=0";
		method="post";
		submit();
	  }
   }
   
  function radioc(){
    var radio=document.getElementsByName("radio");

	if (radio[0].checked==true){
		 
		document.getElementById("shenpiren").style.display="inline-block";
		//document.getElementById("xuanze").style.display="inline-block";
	}else{
		 
		document.getElementById("shenpiren").style.display="none"; 
		alert("请确认您选择的意见是【不同意】");
	} 
	}
   
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
					action='ygxxshenpi.action';
					method="post";
					submit();
				}
			}
		}
  } 
  </script>
  </head>
  
  <body>
  ${daohang}
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
    				<input type="radio" name="radio" value="agree" onclick="radioc()">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="radioc()">
        						不同意
     					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 备注：<input type="text" name="textfield" >
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">
    				${xp.remark}&nbsp; <span id = tip style="color:red" ><c:if test="${message==0}">计划内下线，不需经排班管理员环节 </c:if><c:if test="${message==1}">计划外下线 &nbsp;&nbsp;&nbsp; <input style="width:100px" type="button" onclick="showpaiban()" value="查看排班计划表"/></c:if><c:if test="${message>1}">计划外下线， 一天以上请报主任同意&nbsp;&nbsp;&nbsp;<input style="width:100px" type="button" onclick="showpaiban()" value="查看排班计划表"/> </c:if><c:if test="${peoplenum>=3}">超过3人请报武汉同意  &nbsp;&nbsp;&nbsp;</c:if></span>
    			</td>
    		</tr>
    	
    	
    		<tr>
    			<td class="as">
    				选择审批人
    			</td>
    			<td colspan="5">
    		<div id="shenpiren">
    			<c:if test="${nextunder!='no'}"> 
    				<select name="xuanze">
        				<option value="wu">请选择下一级审批人</option>
        					<c:forEach items="${listui}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        			</select>
        			</c:if>
    		  </div>
    			</td>
    		</tr>
    		
    		<c:if test="${nextunder=='no'}">
    			<input type="hidden" name="xuanze" value="you"/>
    		</c:if> 
    		 
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="number" value="${xp.number}"/>
    				<input type="hidden" name="thisunder" value="${undersign}"/>
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
