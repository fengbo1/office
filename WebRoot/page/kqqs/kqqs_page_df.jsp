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

	//ajax读取处室
	function change1(){

		var chu="";
		var name=document.getElementById('name').value;
		var newnumber=document.getElementById('newnumber').value;
		name = encodeURI(name); 
		var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}	
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					yesorno=xmlhttp.responseText;
					//alert(yesorno);
						var arr=yesorno.split("|");
						if(arr[0].length==3)
						{
							alert("您输入姓名有误！");
						}
						document.getElementById("chu").innerHTML=arr[0];
						bossname(arr[1]);	
				}				
			} 
			xmlhttp.open("GET","kqqs_self_dai.action?name="+name+"&newnumber="+newnumber,true);
			xmlhttp.send();
		}
	
	//确定审批下一人
	function bossname(bossnames){

	var arry= new Array();
	arry=bossnames.split(";"); //字符分割 
	var obj=document.getElementById('xuanze'); 
	obj.options.length=0;
	for (var i=0;i<arry.length;i++){	
		var brry= new Array();
		brry=arry[i].split(":");
		obj.options.add(new Option(brry[0],brry[1])); //这个兼容IE与firefox 
	}
	} 
	
	 function tijiao() {
		  var xuanze = document.getElementById("xuanze").value;
		  var message = "确认提交？";
		  var tel=document.getElementById("tel").value;
		  var reason=document.getElementsByName("reason")[0].value;
		//  var name=document.getElementById("name").value;
		//  var chu=document.getElementById("chu").value;
		  var qd=document.getElementById("qd");
		  var qt=document.getElementById("qt");
		  var message = "确认提交？";

		if(trim(tel)=="")
		  {
			  alert("请填写联系电话");
			  document.getElementById("tel").focus();
			}
		  else if(!qd.checked&&!qt.checked)
		  {
			  alert("请选择签到或者签退");
			}
		  else if(trim(reason)=="")
		  {
			  alert("请输入记录缺失原因");
			}
		  else if(xuanze=="wu")
			{
				alert("请选择下一级审批人");
			}
			else
			{
				alert("考勤缺失申请有效期至次月前5个工作日，如果次月前5个工作日领导仍未审批视为审批不通过，按迟到或早退记录");
				if (window.confirm(message)) {
					with(document.forms[0]) {
						action='subkqqspage.action';
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
  ${daohang}
    <form action="subkqqspage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心考勤缺失备案表</strong><strong> </strong></p>
       <p align="center" style="color:red">考勤缺失申请有效期至次月前5个工作日，如果次月前5个工作日领导仍未审批视为审批不通过，按迟到或早退记录</p>
        <table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as">
    				姓名<b>*</b>
    			</td>
    			<td width="176">
    				<input style="width:90px" type="text" id="name" name="name" onblur="change1()"/>  
    			</td>
    			<td width="72" class="as">
    				处室<b>*</b>
    			</td>
    			<td width="175">
    				<div id="chu">
    					&nbsp
    				</div>
    			</td>
    			<td width="89" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td width="201">
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" />
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				记录缺失日期<b>*</b>
    			</td>
    			<td colspan="5">
    				<input size="9" type="text" name="qsdate" class="Wdate" onClick="WdatePicker()">&nbsp;&nbsp;
    				签到<input type="radio" name="qdqt" id="qd" value="qd"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				签退<input type="radio" name="qdqt" id="qt" value="qt"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				记录缺失原因<b>*</b>
    			</td>
    			<td colspan="5">
    				<input type="text" name="reason" style="width:400px"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				实际到岗/离岗时间<b>*</b>
    			</td>
    			<td colspan="5">
    				<select name="shi" style="width:40px">
    					<c:forEach items="${l}" varStatus="status" begin="0" end="23">
        						<option value="${status.index}">${status.index}</option>
        				</c:forEach>
    				</select>时
    				<select name="fen" style="width:40px">
    					<c:forEach items="${l}" varStatus="status" begin="0" end="59">
        						<option value="${status.index}">${status.index}</option>
        				</c:forEach>
    				</select>分
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				审批意见
    			</td>
    			<td colspan="5">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">
    				<input type="text" name="remark" style="width:400px"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="5">
    				<select id="xuanze" name="thisunder">
        				<option value="wu">请选择下一级审批人</option>
        			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<c:if test="${nonext=='you'}">
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    				</c:if>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
