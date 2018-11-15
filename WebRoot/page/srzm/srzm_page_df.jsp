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
	
	
	function tijiao() {
	 
		  
		  var zhiwu=document.getElementById("zhiwu").value; 
		  var xuanze = document.getElementById("xuanze").value;
		  var yongtu=document.getElementsByName("yongtu")[0].value;
		  var todepartment=document.getElementsByName("todepartment")[0].value;
		  var message = "确认提交？";
		  var tel=document.getElementById("tel").value;
		  var sex=document.getElementById("sex").value;
		  var neednumber=document.getElementById("neednumber").value;
		  var message = "确认提交？";

		  if(sex=="")
		  {
			  alert("请填写性别");
			  document.getElementById("name").focus();return;
			}
		  else if(trim(neednumber)=="")
		  {
			  alert("请填写所需份数");
			  document.getElementById("neednumber").focus();return;
			}
		  else if(tel=="")
		  {
			  alert("请填写联系电话");
			  document.getElementById("tel").focus();return;
			}
		  else if(trim(yongtu)=="")
		  {
			  alert("请输入在职证明用途");
			}
		  else if(trim(todepartment)=="")
		  {
			  alert("请输入在职证明接收单位");
			}
	
		  else if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
		  else if(zhiwu=="")
			{
				alert("请选择职务");return;
			}
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						
						action='subsrzmpage.action';
						method="post";
						submit();
					}
				}
			}
	  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
		} 
	function onlyNum() {
    if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39))
    if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
    event.returnValue=false;
} 
</script>

<script type="text/javascript">
function change1(){

var yesorno="";
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
			
				var arr=yesorno.split("|");
				if(arr[0].length==4)
				{
					alert("您输入姓名有误！");
				}
				if(arr[0].length==5)
				{
					alert("不能跨处室代申请！");
				}
					document.getElementById("chutuan").innerHTML=arr[0];
					bossname(arr[1]);
					document.getElementById("identity").innerHTML=arr[2];
					
					document.getElementById("username").innerHTML=arr[3]+arr[4];
			
					document.getElementById("zxdate").innerHTML=arr[5];
					document.getElementById("sex").value=arr[6];
					
					
		}				
	} 
	xmlhttp.open("GET","showsrzmpagedfajax.action?name="+name+"&newnumber="+newnumber,true);
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
    <form action="subsrzmpage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心成都分中心收入证明申请表</strong><strong> </strong></p>
        <table width="945" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as" >
    				姓名<b>*</b>
    			</td>
    			<td width="176" >
    				<input type="text" id="name" name="name" onblur="change1()"/> 
    			</td>
    			<td width="101" class="as" >
    				性别<b>*</b>
    			</td>
    			<td width="75" >
    			 <input type="text" id="sex" name="sex" readonly="readonly"/> 
    			</td>
    			<td width="121" class="as">
    				身份证号码<b>*</b>
    			</td>
    			<td width="201">
    				<div align="center" id="identity">&nbsp;</div>
    			</td>
    		</tr>
    		
    		<tr>
    			<td width="150" class="as">
    				所在部门<b>*</b>
    			</td>
    			<td colspan="3">
    			<div align="center" id="chutuan">&nbsp;</div>
    			</td>
    			<td width="121" class="as">
    				联系电话<b>*</b>
    			</td>
    			<td width="201">
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" />
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				来总行工作时间<b>*</b>
    				
    			</td>
    			<td colspan="2">
    				<div align="center" id="zxdate">&nbsp;</div>
    			</td>
    		
    			<td class="as">
    				现任职务<b>*</b>
    			</td>
    			 <td colspan="2"><!--  <input type="text" id="zhiwu" name="zhiwu" style="padding:0px;margin:0px;">-->
      	          <select id="zhiwu" name="zhiwu" style="padding:0px;margin:0px;">
      		        <option value="">请选择职务</option>
      		        <option value="高级经理">高级经理</option>
      		        <option value="高级副经理">高级副经理</option>
      		        <option value="业务经理">业务经理</option>
      		        <option value="业务副经理">业务副经理</option>
      		        <option value="一级业务员">一级业务员</option>
      		        <option value="二级业务员">二级业务员</option>
      		        <option value="三级业务员">三级业务员</option>
      		        <option value="四级业务员">四级业务员</option>
      		        <option value="五级业务员">五级业务员</option>
      		        <option value="六级业务员">六级业务员</option>
      	         </select>
	  	
	         </td>
    		</tr>
    		<tr>
    			<td class="as">
    				收入证明用途  <b>*</b>
    			</td>
    			<td colspan="3">
    			<input type="text" name="yongtu" style="width:400px"/>
    			</td>
    			<td class="as">
    				所需份数<b>*</b>
    			</td>
    			<td>
    			<input onkeydown="onlyNum();" style="ime-mode:Disabled" type="text" name="neednumber">
    			<!--  <input type="text" name="neednumber" /> -->
    			</td>
    		</tr>
    		 <tr>
    			<td class="as">
    				收入证明接收单位<b>*</b>
    			</td>
    			<td colspan="5">
    			<input type="text" name="todepartment" style="width:700px"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请人   （签字）
    			</td>
    			<td colspan="5">
    				<div  id="username">&nbsp;</div>
    				
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				综合与生产管理处意见
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
    				<input type="text" name="remark" style="width:700px"/>
    			</td>
    		</tr>
    		<tr>
    		
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="5">
    				<select name="thisunder" id="xuanze">
    				<option value="wu">请选择下一级审批人</option>
        			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="username" value="${username}"/>
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
