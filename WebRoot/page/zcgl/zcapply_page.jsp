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
	 var num=1;
	 
	 function add()
	 {
	    
	 
	 	if(num==1)
	 	{
	 	      document.getElementById('hang1').style.display="block"; 
	 	      num=num+1;
	 	}
	 	else if(num==2)
	 	{
	 	      document.getElementById('hang2').style.display="block"; 
	 	      num=num+1;
	 	}
	 	else if(num==3)
	 	{
	 	      document.getElementById('hang3').style.display="block"; 
	 	      num=num+1;
	 	}
	 	else if(num==4)
	 	{
	 	      document.getElementById('hang4').style.display="block"; 
	 	      num=num+1;
	 	}
	 	else if(num==5)
	 	{
	 	      document.getElementById('hang5').style.display="block"; 
	 	      num=num+1;
	 	}
	 	
	 }
     
     function remove()
     {
        if(num==2)
	 	{
	 	      document.getElementById('hang1').style.display="none"; 
	 	      num=num-1;
	 	}
	 	else if(num==3)
	 	{
	 	      document.getElementById('hang2').style.display="none"; 
	 	      num=num-1;
	 	}
	 	else if(num==4)
	 	{
	 	      document.getElementById('hang3').style.display="none"; 
	 	      num=num-1;
	 	}
	 	else if(num==5)
	 	{
	 	      document.getElementById('hang4').style.display="none"; 
	 	      num=num-1;
	 	}
	 	else if(num==6)
	 	{
	 	      document.getElementById('hang5').style.display="none"; 
	 	      num=num-1;
	 	}
	 	
     }
     
    function gettype1(){
    
    var types="";
    var	assetname=document.getElementById('assetname1').value;
    assetname = encodeURI(assetname); 
    var xmlhttp;
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
				
				//document.getElementById("chutuan").innerHTML=arr[0];
			    typename1(types);
		}				
	} 
	xmlhttp.open("GET","getzichanleixing.action?assetname="+assetname+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function gettype2(){
    
    var types="";
    var	assetname=document.getElementById('assetname2').value;
    assetname = encodeURI(assetname); 
    var xmlhttp;
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
				
				//document.getElementById("chutuan").innerHTML=arr[0];
			    typename2(types);
		}				
	} 
	xmlhttp.open("GET","getzichanleixing.action?assetname="+assetname+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function gettype3(){
    
    var types="";
    var	assetname=document.getElementById('assetname3').value;
    assetname = encodeURI(assetname); 
    var xmlhttp;
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
				
				//document.getElementById("chutuan").innerHTML=arr[0];
			    typename3(types);
		}				
	} 
	xmlhttp.open("GET","getzichanleixing.action?assetname="+assetname+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function gettype4(){
    
    var types="";
    var	assetname=document.getElementById('assetname4').value;
    assetname = encodeURI(assetname); 
    var xmlhttp;
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
				
				//document.getElementById("chutuan").innerHTML=arr[0];
			    typename4(types);
		}				
	} 
	xmlhttp.open("GET","getzichanleixing.action?assetname="+assetname+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function gettype5(){
    
    var types="";
    var	assetname=document.getElementById('assetname5').value;
    assetname = encodeURI(assetname); 
    var xmlhttp;
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
				
				//document.getElementById("chutuan").innerHTML=arr[0];
			    typename5(types);
		}				
	} 
	xmlhttp.open("GET","getzichanleixing.action?assetname="+assetname+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function gettype6(){
    
    var types="";
    var	assetname=document.getElementById('assetname6').value;
    assetname = encodeURI(assetname); 
    var xmlhttp;
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
				
				//document.getElementById("chutuan").innerHTML=arr[0];
			    typename6(types);
		}				
	} 
	xmlhttp.open("GET","getzichanleixing.action?assetname="+assetname+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
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

function typename2(types){

var arry= new Array();
arry=types.split("|"); //字符分割 
var obj=document.getElementById('assettype2'); 
obj.options.length=0;
obj.options.add(new Option("-请选择资产型号-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 

function typename3(types){

var arry= new Array();
arry=types.split("|"); //字符分割 
var obj=document.getElementById('assettype3'); 
obj.options.length=0;
obj.options.add(new Option("-请选择资产型号-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 

function typename4(types){

var arry= new Array();
arry=types.split("|"); //字符分割 
var obj=document.getElementById('assettype4'); 
obj.options.length=0;
obj.options.add(new Option("-请选择资产型号-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 

function typename5(types){

var arry= new Array();
arry=types.split("|"); //字符分割 
var obj=document.getElementById('assettype5'); 
obj.options.length=0;
obj.options.add(new Option("-请选择资产型号-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 

function typename6(types){

var arry= new Array();
arry=types.split("|"); //字符分割 
var obj=document.getElementById('assettype6'); 
obj.options.length=0;
obj.options.add(new Option("-请选择资产型号-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 

 function getnum1(){

    var num="";
    var assetname=document.getElementById('assetname1').value;
   var assettype=document.getElementById('assettype1').value;
 
    assetname = encodeURI(assetname); 
    assettype = encodeURI(assettype);
    var xmlhttp;
     var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			num=xmlhttp.responseText;
			//alert(yesorno);
				document.getElementById("num1").innerHTML=num;
					
		}				
	} 
	xmlhttp.open("GET","getzichanshuliangajax.action?assetname="+assetname+"&assettype="+assettype+"&nowtime="+time,true);
	xmlhttp.send();
}

 function getnum2(){

    var num="";
    var assetname=document.getElementById('assetname2').value;
    var assettype=document.getElementById('assettype2').value;
    assetname = encodeURI(assetname); 
    assettype = encodeURI(assettype);
    var xmlhttp;
     var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			num=xmlhttp.responseText;
			//alert(yesorno);
				document.getElementById("num2").innerHTML=num;
					
		}				
	} 
	xmlhttp.open("GET","getzichanshuliangajax.action?assetname="+assetname+"&assettype="+assettype+"&nowtime="+time,true);
	xmlhttp.send();
}

 function getnum3(){

    var num="";
    var assetname=document.getElementById('assetname3').value;
    var assettype=document.getElementById('assettype3').value;
    assetname = encodeURI(assetname); 
    assettype = encodeURI(assettype);
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			num=xmlhttp.responseText;
			//alert(yesorno);
				document.getElementById("num3").innerHTML=num;
					
		}				
	} 
	xmlhttp.open("GET","getzichanshuliangajax.action?assetname="+assetname+"&assettype="+assettype+"&nowtime="+time,true);
	xmlhttp.send();
}

 function getnum4(){

    var num="";
    var assetname=document.getElementById('assetname4').value;
    var assettype=document.getElementById('assettype4').value;
    assetname = encodeURI(assetname); 
    assettype = encodeURI(assettype);
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			num=xmlhttp.responseText;
			//alert(yesorno);
				document.getElementById("num4").innerHTML=num;
					
		}				
	} 
	xmlhttp.open("GET","getzichanshuliangajax.action?assetname="+assetname+"&assettype="+assettype+"&nowtime="+time,true);
	xmlhttp.send();
}

 function getnum5(){

    var num="";
    var assetname=document.getElementById('assetname5').value;
    var assettype=document.getElementById('assettype5').value;
    assetname = encodeURI(assetname); 
    assettype = encodeURI(assettype);
    var xmlhttp;
     var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			num=xmlhttp.responseText;
			//alert(yesorno);
				document.getElementById("num5").innerHTML=num;
					
		}				
	} 
	xmlhttp.open("GET","getzichanshuliangajax.action?assetname="+assetname+"&assettype="+assettype+"&nowtime="+time,true);
	xmlhttp.send();
}

 function getnum6(){

    var num="";
    var assetname=document.getElementById('assetname6').value;
    var assettype=document.getElementById('assettype6').value;
    assetname = encodeURI(assetname); 
    assettype = encodeURI(assettype);
    var xmlhttp;
     var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			num=xmlhttp.responseText;
			//alert(yesorno);
				document.getElementById("num6").innerHTML=num;
					
		}				
	} 
	xmlhttp.open("GET","getzichanshuliangajax.action?assetname="+assetname+"&assettype="+assettype+"&nowtime="+time,true);
	xmlhttp.send();
}

	 function tijiao() {
	 
		  
		  var assetname1=document.getElementById("assetname1").value; 
		  var assettype1 = document.getElementById("assettype1").value;
		  var sum1 = document.getElementById("sum1").value;
		  var num1=document.getElementById("num1").innerHTML;
		  var assetname2=document.getElementById("assetname2").value; 
		  var assettype2 = document.getElementById("assettype2").value;
		  var sum2 = document.getElementById("sum2").value;
		  var num2=document.getElementById("num2").innerHTML;
		  var assetname3=document.getElementById("assetname3").value; 
		  var assettype3 = document.getElementById("assettype3").value;
		  var sum3 = document.getElementById("sum3").value;
		  var num3=document.getElementById("num3").innerHTML;
		  var assetname4=document.getElementById("assetname4").value; 
		  var assettype4 = document.getElementById("assettype4").value;
		  var sum4 = document.getElementById("sum4").value;
		  var num4=document.getElementById("num4").innerHTML;
		  var assetname5=document.getElementById("assetname5").value; 
		  var assettype5 = document.getElementById("assettype5").value;
		  var sum5 = document.getElementById("sum5").value;
		  var num5=document.getElementById("num5").innerHTML;
		  var assetname6=document.getElementById("assetname6").value; 
		  var assettype6 = document.getElementById("assettype6").value;
		  var sum6 = document.getElementById("sum6").value;
		  var num6=document.getElementById("num6").innerHTML;
		  var message = "确认提交？";
		  var tel=document.getElementById("tel").value;
		  var xuanze=document.getElementById("xuanze").value;
		  var reason=document.getElementById("reason").value;
		
          if(num==1)
          {
          	if(assetname1=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype1=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum1=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	if((sum1!="")&&(Number(sum1)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum1)>Number(num1))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          }
         else if(num==2)
          {
          	if(assetname1=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype1=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum1=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
            if((sum1!="")&&(Number(sum1)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
            if(Number(sum1)>Number(num1))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	   
          	if(assetname2=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype2=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum2=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
            if((sum2!="")&&(Number(sum2)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
            if(Number(sum2)>Number(num2))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          }
        else  if(num==3)
          {
          	if(assetname1=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype1=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum1=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	if((sum1!="")&&(Number(sum1)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
            if(Number(sum1)>Number(num1))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	   
          	if(assetname2=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype2=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum2=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
            if((sum2!="")&&(Number(sum2)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum2)>Number(num2))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	 
          	 if(assetname3=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype3=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum3=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
           if((sum3!="")&&(Number(sum3)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
            if(Number(sum3)>Number(num3))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          }
          
        else if(num==4)
          {
          	if(assetname1=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype1=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum1=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	   
           if((sum1!="")&&(Number(sum1)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum1)>Number(num1))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	   
          	if(assetname2=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype2=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum2=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
           if((sum2!="")&&(Number(sum2)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
         	if(Number(sum2)>Number(num2))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	 
          	if(assetname3=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype3=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum3=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
           if((sum3!="")&&(Number(sum3)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
            if(Number(sum3)>Number(num3))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	if(assetname4=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype4=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum4=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	if((sum4!="")&&(Number(sum4)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum4)>Number(num4))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          }
          
         else if(num==5)
          {
          	if(assetname1=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype1=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum1=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	if((sum1!="")&&(Number(sum1)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum1)>Number(num1))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	if(assetname2=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype2=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum2=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	if((sum2!="")&&(Number(sum2)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
            if(Number(sum2)>Number(num2))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	if(assetname3=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype3=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum3=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	if((sum3!="")&&(Number(sum3)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
            if(Number(sum3)>Number(num3))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }   
          	if(assetname4=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype4=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum4=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	if((sum4!="")&&(Number(sum4)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum4)>Number(num4))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   } 
            if(assetname5=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype5=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum5=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
           if((sum5!="")&&(Number(sum5)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum5)>Number(num5))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          }
          
        else if(num==6)
          {
          	if(assetname1=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype1=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum1=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
           if((sum1!="")&&(Number(sum1)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum1)>Number(num1))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }   
          	if(assetname2=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype2=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum2=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
           if((sum2!="")&&(Number(sum2)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum2)>Number(num2))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	if(assetname3=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype3=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum3=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
            if((sum3!="")&&(Number(sum3)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
            if(Number(sum3)>Number(num3))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }   
          	if(assetname4=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype4=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum4=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
             if((sum4!="")&&(Number(sum4)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum4)>Number(num4))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }  
            if(assetname5=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype5=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum5=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
            if((sum5!="")&&(Number(sum5)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum5)>Number(num5))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          	if(assetname6=="wu")
          	   {
          	   	 alert("请填写申领资产名称");
          	   	 return;
          	   }
          	if(assettype6=="wu")
          	   {
          	   	 alert("请填写申领资产型号");
          	   	 return;
          	   }
            if(sum6=="")
          	   {
          	   	 alert("请填写申领资产数量");
          	   	 return;
          	   }
          	if((sum6!="")&&(Number(sum6)<=0))
          	{
          	
          	   alert("请填写大于0的数量");
          	   return;
          	}
          	if(Number(sum6)>Number(num6))
          	  {
          	   	 alert("申领资产数量不得大于库存数量");
          	   	 return;
          	   }
          }
	
		  if(tel=="")
		  {
			  alert("请填写联系电话");
			  document.getElementById("tel").focus();return;
			}
		  if(trim(reason)=="")
		  {
			  alert("请输入资产申领原因");
			  return;
		   }
		
	     if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
		 
		 
			
		  if (window.confirm(message)) {
		       with(document.forms[0]) {
						
						action='subzcapplypage.action?num='+num;
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
    <form action="subzcapplypage.action" method="post">
    		<br>
    			<br>
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心资产申领表</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr height="50">
    			<td width="150" class="as" >
    				资产管理员<b>*</b>
    			</td>
    			<td width="150" class="as" >
    				<input style="width:50px" id="username" type="hidden" name="username" value="${ui.username}"  />
    				${ui.username}
    			</td>
    			<td width="100" class="as"  >
    				申领处室<b>*</b>
    			</td>
    			<td class="as" >
    			<c:if test="${authoR!='R'&&authoS!='S'}"> 
     	 			<input type="hidden" id="chu" name="chu" value="${chu}"/> 
    				${fb:chutostring(chu)}		
      			</c:if>
      			<c:if test="${authoR=='R'}"> 
    					<select id="zhiwu" name="chu" style="padding:0px;margin:0px;">
      		            <option value="">请选择外包公司</option>
      		               <option value="11">成都维度</option>
      		               <option value="12">成都银雁</option>
                    	</select>
    			</c:if>
    			<c:if test="${authoS=='S'}"> 
    					<select id="zhiwu1" name="chu" style="padding:0px;margin:0px;">
      		            <option value="">请选择外包公司</option>
      		               <option value="13">威科姆</option>
      		               <option value="14">银河万佳</option>
      		               <option value="15">民兴物业</option>
      		              
                    	</select>
    			</c:if>
    			</td>
    			
    			<td width="120" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" />
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td  class="as" >
    				资产名称<b>*</b>
    			</td>
    			<td width="145" class="as" >
    				<div style="display: block;"> <select id="assetname1"
			               name="assetname"  style="width: 135px" onchange="gettype1()">
			            <option value="wu">-请选择资产名称-</option>
			            <c:forEach items="${listinfo}" var="info" varStatus="status">
        						<option value="${info}">${info}</option>
        				</c:forEach>
		              </select></div>
    			</td>
    			<td width="100" class="as" >
    				型号<b>*</b>
    			</td>
    			<td width="100" class="as" >
    			  <div style="display: block;"> <select id="assettype1"
			        name="assettype"  style="width: 135px" onchange="getnum1()">
			       <option value="wu">-请选择资产型号-</option>
		          </select></div>
    			</td>
    			<td width="120" class="as">
    				数量<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				库存<span id=num1></span>件,申领<input type="text" id="sum1" name="sum" style="width:50" />件
    			</td>
    		</tr>
    		
    		<tr style="display:none" height="40" id="hang1">
    			<td  class="as"  >
    				资产名称<b>*</b>
    			</td>
    			<td width="145" class="as" >
    				<div style="display: block;"> <select id="assetname2"
			               name="assetname"  style="width: 135px" onchange="gettype2()">
			             <option value="wu">-请选择资产名称-</option>
			            <c:forEach items="${listinfo}" var="info" varStatus="status">
        						<option value="${info}">${info}</option>
        				</c:forEach>
		              </select></div>
    			</td>
    			<td width="100" class="as" >
    				型号<b>*</b>
    			</td>
    			<td width="100" class="as" >
    			  <div style="display: block;"> <select id="assettype2"
			        name="assettype"  style="width: 135px" onchange="getnum2()">
			       <option value="wu">-请选择资产型号-</option>
		          </select></div>
    			</td>
    			<td width="120" class="as">
    				数量<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				库存<span id=num2></span>台,申领<input type="text" id="sum2" name="sum" style="width:50" />台 
    			</td>
    		</tr>
    		
    		<tr style="display:none" height="40" id="hang2">
    			<td  class="as"  >
    				资产名称<b>*</b>
    			</td>
    			<td width="145" class="as" >
    				<div style="display: block;"> <select id="assetname3"
			               name="assetname"  style="width: 135px" onchange="gettype3()">
			            <option value="wu">-请选择资产名称-</option>
			            <c:forEach items="${listinfo}" var="info" varStatus="status">
        						<option value="${info}">${info}</option>
        				</c:forEach>
		              </select></div>
    			</td>
    			<td width="100" class="as" >
    				型号<b>*</b>
    			</td>
    			<td width="100" class="as" >
    			  <div style="display: block;"> <select id="assettype3"
			        name="assettype"  style="width: 135px" onchange="getnum3()">
			       <option value="wu">-请选择资产型号-</option>
		          </select></div>
    			</td>
    			<td width="120" class="as">
    				数量<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				库存<span id=num3></span>台,申领<input type="text" id="sum3" name="sum" style="width:50" />台 
    			</td>
    		</tr>
    		
    		<tr style="display:none" height="40" id="hang3">
    			<td  class="as"  >
    				资产名称<b>*</b>
    			</td>
    			<td width="145" class="as" >
    				<div style="display: block;"> <select id="assetname4"
			               name="assetname"  style="width: 135px" onchange="gettype4()">
			           <option value="wu">-请选择资产名称-</option>
			            <c:forEach items="${listinfo}" var="info" varStatus="status">
        						<option value="${info}">${info}</option>
        				</c:forEach>
		              </select></div>
    			</td>
    			<td width="100" class="as" >
    				型号<b>*</b>
    			</td>
    			<td width="100" class="as" >
    			  <div style="display: block;"> <select id="assettype4"
			        name="assettype"  style="width: 135px" onchange="getnum4()">
			       <option value="wu">-请选择资产型号-</option>
		          </select></div>
    			</td>
    			<td width="120" class="as">
    				数量<b>*</b>
    			</td>
    			<td width="200" class="as">
    				库存<span id=num4></span>台,申领<input type="text" id="sum4" name="sum" style="width:50" />台 
    			</td>
    		</tr>
    		
    		<tr style="display:none" height="40" id="hang4">
    			<td  class="as"  >
    				资产名称<b>*</b>
    			</td>
    			<td width="145" class="as" >
    				<div style="display: block;"> <select id="assetname5"
			               name="assetname"  style="width: 135px" onchange="gettype5()">
			            <option value="wu">-请选择资产名称-</option>
			            <c:forEach items="${listinfo}" var="info" varStatus="status">
        						<option value="${info}">${info}</option>
        				</c:forEach>
		              </select></div>
    			</td>
    			<td width="100" class="as" >
    				型号<b>*</b>
    			</td>
    			<td width="100" class="as" >
    			  <div style="display: block;"> <select id="assettype5"
			        name="assettype"  style="width: 135px" onchange="getnum5()">
			       <option value="wu">-请选择资产型号-</option>
		          </select></div>
    			</td>
    			<td width="120" class="as">
    				数量<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				库存<span id=num5></span>台,申领<input type="text" id="sum5" name="sum" style="width:50" />台 
    			</td>
    		</tr>
    		
    		<tr style="display:none" height="40" id="hang5">
    			<td  class="as"  >
    				资产名称<b>*</b>
    			</td>
    			<td width="145" class="as" >
    				<div style="display: block;"> <select id="assetname6"
			               name="assetname"  style="width: 135px" onchange="gettype6()">
			            <option value="wu">-请选择资产名称-</option>
			            <c:forEach items="${listinfo}" var="info" varStatus="status">
        						<option value="${info}">${info}</option>
        				</c:forEach>
		              </select></div>
    			</td>
    			<td width="100" class="as" >
    				型号<b>*</b>
    			</td>
    			<td width="100" class="as" >
    			  <div style="display: block;"> <select id="assettype6"
			        name="assettype"  style="width: 135px" onchange="getnum6()">
			       <option value="wu">-请选择资产型号-</option>
		          </select></div>
    			</td>
    			<td width="120" class="as">
    				数量<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				库存<span id=num6></span>台,申领<input type="text" id="sum6" name="sum" style="width:50" />台 
    			</td>
    		</tr>
    		
    	
    		<tr height="40">
    			<td  class="as">
    				申领其他资产
    			</td>
    			<td colspan="5" >
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<input type="button" id="button" value="添加" onclick="add()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<input type="button" id="button" value="减少" onclick="remove()"/>
    			</td>
    			
    		</tr>
    		<tr height="40">
    			<td  class="as">
    				申领原因<b>*</b>
    			</td>
    			<td colspan="5" >
    			<input type="text" id="reason" name="reason" style="width:650"/>
    			</td>
    			
    		</tr>
    		
    		<tr height="40">
    			<td class="as">
    				处室意见
    			</td>
    			<td colspan="5">
    				&nbsp;
    			</td>
    		</tr>
    		<tr height="40">
    			<td class="as">
    				综合与生产管理处意见
    			</td>
    			<td colspan="5">
    				&nbsp;
    			</td>
    		</tr>
    		<tr height="40">
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">
    				<input type="text" name="remark" style="width:650px"/>
    			</td>
    		</tr>
    		<tr height="40">
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="5">
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
    			<td colspan="5">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
