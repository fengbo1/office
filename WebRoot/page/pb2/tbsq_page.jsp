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
	function getjihua(){
	
		var jihua = "";
		var tbdate=document.getElementById('tbdate').value;
		var name=document.getElementById('name').value;
		var tbname=document.getElementById('tbname').value;
		name = encodeURI(name); 
		tbname = encodeURI(tbname); 
		var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}	
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					jihua=xmlhttp.responseText;
					var arr=jihua.split("|");
						if(arr[0].length==10)
						{
							//alert("您输入姓名有误！");
						}
						document.getElementById("pre").innerHTML=arr[0];
						document.getElementById("now").innerHTML=arr[1];
						bossname(arr[2]);
				}				
			} 
		
			xmlhttp.open("GET","getjihua.action?name="+name+"&tbname="+tbname+"&date="+tbdate,true);
		
			xmlhttp.send();
		}
	
	 function tijiao() {
		  var xuanze = document.getElementById("xuanze").value;
		  var message = "确认提交？";
		  var reason=document.getElementsByName("reason")[0].value;
		  var tbname=document.getElementById("tbname").value;
		  var tbdate=document.getElementById("tbdate").value;
		  
		  if(trim(tbdate)=="")
			{
				alert("请选择调班日期");
			}
		  else if(trim(tbname)=="")
			{
				alert("请填写调班对象");
			}
		  else if(trim(reason)=="")
		  {
			  alert("请输入调班原因");
			}
		  else if(xuanze=="")
		  {
			  alert("请确认调班人和调班日期，数据库中查询不到排班明细！");
			} 
		  else if(xuanze=="wu")
			{
				alert("请选择下一级审批人");
			}
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						alert("提交后，请及时联系排班管理员，最终是否成功以排班管理员录入的武汉中心审批意见为准！");
						action='subtbsqpage.action';
						method="post";
						submit();
					}
				}
			}
	  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
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
    <form action="subjbsppage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心业务处理人员调班审批单</strong><strong> </strong></p>
        <table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="121" class="as">
    				发起人<b>*</b>
    			</td>
    			<td width="150">
    				<c:if test="${df==0}">
    					<input type="hidden" id="name" name="name" value="${name}"/> 
    					${name}
    				</c:if>
    				<c:if test="${df==1}">
    					<input type="text" id="name" name="name" style="width:100px" onblur="getjihua()"/> 
    				</c:if>
    			</td>
    			<td width="121" class="as">
    				调班日期<b>*</b>
    			</td>
    			<td width="150">
    					<input size="9" type="text" name="tbdate" id="tbdate" class="Wdate" onClick="WdatePicker()"  onblur="getjihua()"/>
    			</td>
    			<td width="89" class="as">
    				调班对象<b>*</b>
    			</td>
    			<td width="150">
    				<input type="test" id="tbname" name="tbname" style="width:100px" onblur="getjihua()"/> 
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				调班事由<b>*</b>
    			</td>
    			<td colspan="5" id="p">
    				<input type="text" name="reason" style="width:400px"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				原排班计划
    			</td>
    			<td colspan="5" id="pre">&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				调整后计划
    			</td>
    			<td colspan="5" id="now">&nbsp;
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
    				<input type="hidden" name="df" value="${df}"/>
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="autho" value="${autho}"/>
    				<input type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    		<tr style="color:red">
    			<td colspan="6">
    				<div align="center">
    					提交后，请及时联系排班管理员，最终是否成功以排班管理员录入的武汉中心审批意见为准！
    				</div>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
