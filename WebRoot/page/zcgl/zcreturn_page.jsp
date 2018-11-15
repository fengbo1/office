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
	      var xuanze=document.getElementById("xuanze").value;
		  var reason=document.getElementById("reason").value;
		 
		  if(trim(reason)=="")
		   {
			  alert("请输入资产归还原因");
			  return;
		   }
		    if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
	      var message = "确认提交？";
		  if (window.confirm(message)) {
		       with(document.forms[0]) {
						
						action='subzcreturnpage.action';
						method="post";
						submit();
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


  function getname(){
    
    var types="";
    var	chu=document.getElementById('chu').value;
    var	newnumber=document.getElementById('newnumber').value;
   
    var xmlhttp;
     //alert(1);
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			names=xmlhttp.responseText;
			//alert(yesorno);
			//alert(1);	
				//document.getElementById("chutuan").innerHTML=arr[0];
			 showname1(names);
		}				
	} 
	//alert(2);
	xmlhttp.open("GET","getzichanmingchengreturn.action?chu="+chu+"&nowtime="+time+"&newnumber="+newnumber+"&chu"+chu,true);
	//xmlhttp.open("GET","login.action",true);
	//alert(3);
	xmlhttp.send();
}		

function showname1(names){

var arry= new Array();
arry=names.split("|"); //字符分割 
var obj=document.getElementById('assetname1'); 
obj.options.length=0;
obj.options.add(new Option("-请选择资产名称-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 


  function gettype(){
    
    var types="";
    var	assetname=document.getElementById('assetname1').value;
    var	newnumber=document.getElementById('newnumber').value;
    assetname = encodeURI(assetname); 
    var xmlhttp;
     //alert(1);
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			types=xmlhttp.responseText;
			//alert(yesorno);
			//alert(1);	
				//document.getElementById("chutuan").innerHTML=arr[0];
			 typename1(types);
		}				
	} 
	//alert(2);
	xmlhttp.open("GET","getzichanleixingreturn.action?assetname="+assetname+"&nowtime="+time+"&newnumber="+newnumber,true);
	//xmlhttp.open("GET","login.action",true);
	//alert(3);
	xmlhttp.send();
}		

function typename1(types){

var arry= new Array();
arry=types.split("|"); //字符分割 
var obj=document.getElementById('assettype1'); 
obj.options.length=0;
obj.options.add(new Option("-请选择资产型号-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 


  function search()
  {
  	  with(document.forms[0]) {
			action='searchreturn.action';
			method="post";
			submit();
			}
  }
  
  function getsearch()
  {
  	var items="";
    var	assetname=document.getElementById('assetname1').value;
    var	assettype=document.getElementById('assettype1').value;
    var	people=document.getElementById('people').value;
    var newnumber = document.getElementById('newnumber').value; 
    var chu = document.getElementById('chu').value;
    if(chu==0)
		  {
		    alert("请选择归还处室");return;
		  }
    //var authoR = document.getElementById('newnumber').value;
    assetname = encodeURI(assetname); 
    assettype = encodeURI(assettype); 
    people = encodeURI(people); 
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			items=xmlhttp.responseText;
			
			var contents = items.split("|");
			var showcontent = contents[1];
			//var shows = JSON.parse(showcontent);
			

			
			var shows = eval("(" + showcontent + ")");
			//var shows = $.parseJSON(showcontent);
			//alert(shows.length);
			$("#showitem").empty();
			for(var i =0;Number(i)<Number(shows.length);i++)
			{
				if(shows[i].returntime!='0')
				{
					$("#showitem").append("资产名称："+shows[i].name+"&nbsp&nbsp资产型号："+shows[i].type+"&nbsp&nbsp资产编号："+shows[i].number+"&nbsp&nbsp使用人："+shows[i].people+"&nbsp&nbsp使用区域："+shows[i].area+"&nbsp&nbsp归还时间："+shows[i].returntime+"<input id='"+shows[i].id+"' type='checkbox' name='assetid'  value='"+shows[i].id+"' /><br/>");
				}
				else
				{
					$("#showitem").append("资产名称："+shows[i].name+"&nbsp&nbsp资产型号："+shows[i].type+"&nbsp&nbsp资产编号："+shows[i].number+"&nbsp&nbsp使用人："+shows[i].people+"&nbsp&nbsp使用区域："+shows[i].area+"<input id='"+shows[i].id+"' type='checkbox' name='assetid'  value='"+shows[i].id+"' /><br/>");
				}
				
			}	
				//document.getElementById("chutuan").innerHTML=arr[0];
			   //document.getElementById("showitem").innerHTML=content;
		}				
	} 
	xmlhttp.open("GET","searchreturnajax.action?assetname="+assetname+"&nowtime="+time+"&assettype="+assettype+"&people="+people+"&newnumber="+newnumber+"&chu="+chu,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
  }
  
  function getclear()
  {
  	$("#showitem").empty();
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
    <form action="subzcreturnpage.action" method="post">
    	<br>
    		<br>	
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心资产归还表</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr height="50">
    			<td width="100" class="as" >
    				资产管理员<b>*</b>
    			</td>
    			<td  class="as" >
    				<input style="width:50px" id="username" type="hidden" name="username" value="${ui.username}"  />
    				${ui.username}
    			</td>
    			
    			<td width="100" class="as"  >
    				归还处室<b>*</b>
    			</td>
    			<td width="150" class="as" >
    			<c:if test="${authoR!='R'&&authoS!='S'}"> 
     	 			<input type="hidden" id="chu" name="chu" value="${chu}"/> 
    				${fb:chutostring(chu)}		
      			</c:if>
      			<c:if test="${authoR=='R'}"> 
    					<select id="zhiwu" name="chu"  onchange="getname();" style="padding:0px;margin:0px;">
      		            <option value="">请选择外包公司</option>
      		               <option value="11">成都维度</option>
      		               <option value="12">成都银雁</option>
                    	</select>
    			</c:if>
    			<c:if test="${authoS=='S'}"> 
    					<select id="zhiwu1" name="chu"  onchange="getname();" style="padding:0px;margin:0px;">
      		            <option value="">请选择外包公司</option>
      		               <option value="13">威科姆</option>
      		               <option value="14">银河万佳</option>
      		               <option value="15">民兴物业</option>
      		              
                    	</select>
    			</c:if>
    			</td>
    			
    			<td width="100" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td class="as" colspan="2">
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" />
    			</td>
    		</tr>
    		
    		
    		<tr height="40">
    			<td  class="as" >
    				资产名称<b>*</b>
    			</td>
    			<td  class="as" >
    				<div style="display: block;"> <select id="assetname1"
			               name="assetname"  style="width: 135px" onchange="gettype();">
			           
			            <option value="wu">-请选择资产名称-</option>
			           <c:if test="${authoR!='R'&&authoS!='S'}"> 
			            <c:forEach items="${listinfo}" var="info" varStatus="status">
        						<option value="${info}">${info}</option>
        				</c:forEach>
			          </c:if>
		              </select></div>
    			</td>
    		  <td  class="as" >
    				型号<b>*</b>
    			</td>
    			<td class="as" >
    			  <div style="display: block;"> <select id="assettype1"
			        name="assettype"  style="width: 135px" >
			       <option value="wu">-请选择资产型号-</option>
		          </select></div>
    			</td>
    			<td  class="as">
    				使用人
    			</td>
    			<td class="as" >
    				
    			<input type="text" id="people" name="people" /><br>
    			<!-- <input type="button" onclick="getsearch()" value="查  询"/><br/> -->
    			 <!-- <input type="button" onclick="getclear()" value="清    除"/> -->
    			
    			（可输入多人姓名，用、隔开）
    				
    			</td>
    			<td  class="as">
    				<input type="button" onclick="getsearch()" value="查  询"/><br/>
    			</td>
    			
    		</tr>
    	
    		<tr height="40">
    			<td class="as">
    				可归还资产<b>*</b>
    			</td>
    			<td colspan="6" >
    			   <b>请选择要归还的资产：</b> <br/>
    			   <span id="showitem"> </span>
    				<!--  <c:forEach items="${listaf}" var="af" varStatus="status">
    				       资产名称：${af.name}资产型号：${af.type}资产编号：${af.number}使用人：${af.username}使用区域：${af.area}
    				     <c:if test="${af.returntime!='0'}">归还时间：${af.returntime} </c:if>   <input id="${af.id}" type="checkbox" name="assetid"  value="${af.id}" /><br/>
    				  </c:forEach> --> 
    				 
    			</td>
    		</tr>
    		<tr height="40">
    			<td  class="as">
    				归还原因<b>*</b>
    			</td>
    			<td colspan="6" >
    			<input type="text" id="reason" name="reason" style="width:650"/>
    			</td>
    			
    		</tr>
    		
    		<tr height="40">
    			<td class="as">
    				处室意见
    			</td>
    			<td colspan="6">
    				&nbsp;
    			</td>
    		</tr>
    	
    		<tr height="40">
    			<td class="as">
    				备注
    			</td>
    			<td colspan="6">
    				<input type="text" name="remark" style="width:650px"/>
    			</td>
    		</tr>
    		<tr height="40">
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="6">
    				<select name="thisunder" id="xuanze">
        				<option value="wu">请选择下一级审批人</option>
        					<c:forEach items="${list}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        			</select>
    			</td>
    		</tr>
    		<tr height="40">
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="6">
    				<input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" id="authoR" name="authoR" value="${authoR}"/>
    				<input type="hidden" id="authoS" name="authoS" value="${authoS}"/>
    				<!-- <input type="hidden" name="borrownumber" value="${number}"/> -->
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    	<br/><br/><br/><br/><br/>
    </form>
  </body>
</html>
