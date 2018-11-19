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

 $(document).ready(function(){ 
    
    var RadioGroup1="${RadioGroup1}";
    var RadioGroup2="${RadioGroup2}";
    var reason = "${reason}";
    var peoplenametiao = "${peoplenametiao}";
  
    if(RadioGroup1=="sw")
      {
         document.getElementById("RadioGroup1_0").checked=true;
      } 
    if(RadioGroup1=="xw")
      {
         document.getElementById("RadioGroup1_1").checked=true;
      } 
     if(RadioGroup2=="sw")
      {
         document.getElementById("RadioGroup2_0").checked=true;
      } 
     if(RadioGroup2=="xw")
      {
         document.getElementById("RadioGroup2_1").checked=true;
      } 
     if(reason=="1")
      {
         document.getElementById("reason1").checked=true;
      } 
       if(reason=="2")
      {
         document.getElementById("reason2").checked=true;
      } 
        if(reason=="3")
      {
         document.getElementById("reason3").checked=true;
      } 
        if(reason=="4")
      {
         document.getElementById("reason4").checked=true;
      } 
        if(reason=="5")
      {
         document.getElementById("reason5").checked=true;
      } 
        if(reason=="6")
      {
         document.getElementById("reason6").checked=true;
      } 
        if(reason=="7")
      {
         document.getElementById("reason7").checked=true;
      } 
        if(reason=="8")
      {
         document.getElementById("reason8").checked=true;
      } 
        if(reason=="9")
      {
         document.getElementById("reason9").checked=true;
      } 
        if(reason=="10")
      {
         document.getElementById("reason10").checked=true;
      } 
        if(reason=="11")
      {
         document.getElementById("reason11").checked=true;
      } 
        if(reason=="12")
      {
         document.getElementById("reason12").checked=true;
      } 
        if(reason=="20")
      {
         document.getElementById("reason20").checked=true;
      } 
     
      var names = peoplenametiao.split("、");
      for(var i=0;i<names.length;i++)
      {
      	$("<input type='text' name='people' style='width:50px' >").val(names[i]).appendTo("#p");
      	/*var input = document.createElement("input"); 
        input.type = "text" ;
        input.value = names[i] ;
        alert(names[i]);
        input.name = "people";
        input.style="width:50px";
      	$('#p').append(input);*/
      }
      
      istipno();
       
});
	
	
	function showpaiban()
   {		
	    var type = 1;
	    with(document.forms[0]) {
		action="viewygpw.action?isdai=1&type="+type;
		method="post";
		submit();
	  }
   }
	
	function a(){
		alert("如果有多个下线员工，员工必须为同一处室！");
		$('#p').append("<input type='text' name='people' style='width:50px'/>");
		}
 	  
	function b(){
		$("input[name='people']").eq($("input[name='people']").size()-1).remove();
		}

	function istip()
    {
    var begindate = document.getElementById("begindate").value;
	var enddate = document.getElementById("enddate").value;
	var result = begindate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
	if(result==null)
	{ 
	    return ;
    }
	var result2 = enddate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
	if(result2==null)
	{        
	    return;
	}	
	var begindates=begindate.replace(/-/g,"/");
	var begindates=new Date(begindates);
    var enddates=enddate.replace(/-/g,"/");
    var enddates=new Date(enddates);
    var rg10=document.getElementById("RadioGroup1_0");
	var rg11=document.getElementById("RadioGroup1_1");
	var rg20=document.getElementById("RadioGroup2_0");
	var rg21=document.getElementById("RadioGroup2_1");
	if(begindates>enddates){
		    alert("因公下线开始时间不能晚于结束时间！");
			return ;
	}
	if(!rg10.checked&&!rg11.checked)
	{
			return;
	}
	if(!rg20.checked&&!rg21.checked)
	{
			return;
    }
	
	var peoples = document.getElementsByName("people");
	var people=peoples[0].value;
	for(var i=1;Number(i)<Number(peoples.length);i++)
	{
		people=people+"、";
		people=people+peoples[i].value;
	}
	people = encodeURI(people); 
	var yesorno="";
	var type=0;
	var time=new Date().getTime();
	var arrs=new Array();
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			    yesorno=xmlhttp.responseText;
			    arrs=yesorno.split("|");
			   // alert(yesorno);
			    if(Number(arrs[1])==0)
			    {
			       document.getElementById("tip").innerHTML="计划内下线，不需经排班管理员环节";
			       document.getElementById("showbt").style.display="none";
			    }
				if(Number(arrs[1])==1)
				{
				   document.getElementById("tip").innerHTML="计划外下线";
				   document.getElementById("showbt").style.display="inline";
				}
				//alert(arr[0].length);
				//alert(arr[11]);
				if(Number(arrs[1])>1)
				{
				   document.getElementById("tip").innerHTML="计划外下线，一天以上请报主任同意。 ";
				   document.getElementById("showbt").style.display="inline";
				}
				if(Number(arrs[2]>=3))
				{
					 document.getElementById("tip1").innerHTML="超过3人请报武汉同意";
					 document.getElementById("showbt").style.display="inline";
				}
							
		}				
	} 
	
	xmlhttp.open("GET","showygtip.action?people="+people+"&begindate="+begindate+"&enddate="+enddate+"&nowtime="+time,true);

	xmlhttp.send();
  
}

function jisuan() {
		////////////////////////////////计算日期//////////////////
		var halfday1s=document.getElementsByName("RadioGroup1");
		var halfday2s=document.getElementsByName("RadioGroup2");
		var halfday1="false";
		var halfday2="false";
		var sum=0;
		if(halfday1s[1].checked==true){
			halfday1="true";
			}
		if(halfday2s[0].checked==true){
			halfday2="true";
			}

		
		var begindate= document.getElementById("begindate").value;
		var enddate= document.getElementById("enddate").value;
		if(begindate<=enddate)
		{
			 inoutdate(begindate,enddate,1,halfday1,halfday2);
			//document.getElementById("day").readOnly=true;
			//document.getElementById("hour").value=0;
		}
		//else
		//{
			//document.getElementById("day").value=0;
			//document.getElementById("hour").value=0;
			//document.getElementById("day").readOnly=false;
		//}
	    //return sum;
	}
	function inoutdate(begindate,enddate,type,halfday1,halfday2){
		////////提交计算前检查一下///////////////////////////
			var rg10=document.getElementById("RadioGroup1_0");
			var rg11=document.getElementById("RadioGroup1_1");
			var rg20=document.getElementById("RadioGroup2_0");
			var rg21=document.getElementById("RadioGroup2_1");
		    var result = begindate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
	        if(result==null)
	        { return ;
			 }
	        var result2 = enddate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
	        if(result2==null)
	        {        
	            return;
	        }
	        var begindates=begindate.replace(/-/g,"/");
			var begindates=new Date(begindates);
			var enddates=enddate.replace(/-/g,"/");
			var enddates=new Date(enddates);	
			if(begindates>enddates){
				alert("因公下线开始时间不能晚于结束时间！");
				return ;
			}
			if(!rg10.checked&&!rg11.checked)
				{
					return;
				}
			if(!rg20.checked&&!rg21.checked)
				{
					return;
				}	
		
		////////提交计算前检查一下///////////////////////////
		var sumdate; 
		var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}	
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					sumdate=xmlhttp.responseText;	
					//alert(sumdate);	
					//document.getElementById("day").value=sumdate.split(".")[0];
					document.getElementById("days").value=sumdate;
					//return sumdate;
								
				}				
			} 
			var url="sumdate.action?begindate="+begindate+"&enddate="+enddate+"&type="+type+"&halfday1="+halfday1+"&halfday2="+halfday2;
			xmlhttp.open("GET",url,false);
			xmlhttp.send();
		}	
		
		
function istipno()
    {
    var begindate = document.getElementById("begindate").value;
	var enddate = document.getElementById("enddate").value;
	var result = begindate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
	if(result==null)
	{ 
	    return ;
    }
	var result2 = enddate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
	if(result2==null)
	{        
	    return;
	}	
	var begindates=begindate.replace(/-/g,"/");
	var begindates=new Date(begindates);
    var enddates=enddate.replace(/-/g,"/");
    var enddates=new Date(enddates);
    var rg10=document.getElementById("RadioGroup1_0");
	var rg11=document.getElementById("RadioGroup1_1");
	var rg20=document.getElementById("RadioGroup2_0");
	var rg21=document.getElementById("RadioGroup2_1");
	if(begindates>enddates){
		    alert("因公下线开始时间不能晚于结束时间！");
			return ;
	}
	if(!rg10.checked&&!rg11.checked)
	{
			return;
	}
	if(!rg20.checked&&!rg21.checked)
	{
			return;
    }
	
	var peoples = document.getElementsByName("people");
	var people=peoples[0].value;
	for(var i=1;Number(i)<Number(peoples.length);i++)
	{
		people=people+"、";
		people=people+peoples[i].value;
	}
	
	people = encodeURI(people); 
	var yesorno="";
	var type=0;
	var time=new Date().getTime();
	var arrs=new Array();
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			    yesorno=xmlhttp.responseText;
			    arrs=yesorno.split("|");
			   // alert(yesorno);
			    if(Number(arrs[1])==0)
			    {
			       document.getElementById("tip").innerHTML="计划内下线，不需经排班管理员环节";
			       document.getElementById("showbt").style.display="none";
			    }
				if(Number(arrs[1])==1)
				{
				   document.getElementById("tip").innerHTML="计划外下线";
				   document.getElementById("showbt").style.display="inline";
				}
				//alert(arr[0].length);
				//alert(arr[11]);
				if(Number(arrs[1])>1)
				{
				   document.getElementById("tip").innerHTML="计划外下线，一天以上请报主任同意。";
				   document.getElementById("showbt").style.display="inline";
				}
				if(Number(arrs[2]>=3))
				{
					 document.getElementById("tip1").innerHTML="超过3人请报武汉同意";
					 document.getElementById("showbt").style.display="inline";
				}
							
		}				
	} 
	
	xmlhttp.open("GET","showygtip.action?people="+people+"&begindate="+begindate+"&enddate="+enddate+"&nowtime="+time,false);

	xmlhttp.send();
  
}
	//计算休假日期使用 -->
	
	////////提交计算前检查一下///////////////////////////
	
	 function tijiao() {
		  	var begindate= document.getElementById("begindate").value;
			var begindate=begindate.replace(/-/g,"/");
			//var begindate=new Date(begindate);
			 var reason=document.getElementsByName("reason")[0].value;
			var enddate= document.getElementById("enddate").value;
			var enddate=enddate.replace(/-/g,"/");
			//var enddate=new Date(enddate);
		  var xuanze = document.getElementById("xuanze").value;
		  var rg10=document.getElementById("RadioGroup1_0");
		  var rg11=document.getElementById("RadioGroup1_1");
		  var rg20=document.getElementById("RadioGroup2_0");
		  var rg21=document.getElementById("RadioGroup2_1");
		  var rg30=document.getElementById("RadioGroup3_0");
		  var rg31=document.getElementById("RadioGroup3_1");
		  var reason1=document.getElementById("reason1");
		  var reason2=document.getElementById("reason2");
		  var reason3=document.getElementById("reason3");
		  var reason4=document.getElementById("reason4");
		  var reason5=document.getElementById("reason5");
		  var reason6=document.getElementById("reason6");
		  var reason7=document.getElementById("reason7");
		  var reason8=document.getElementById("reason8");
		  var reason9=document.getElementById("reason9");
		  var reason10=document.getElementById("reason10");
		  var reason11=document.getElementById("reason11");
		  var reason12=document.getElementById("reason12");
		  var reason20=document.getElementById("reason20");
		  var tel=document.getElementById("tel").value;
		  var name=document.getElementById("name").value;
		  var day=document.getElementById("day").value;
		  var hour=document.getElementById("hour").value;
		  //var times=document.getElementById("times").value;
		  var qita=document.getElementById("qita").value;
		 // var panduan= sumdate.selectedIndex;
		   jisuan();
		   var days=document.getElementById("days").value;
	       //alert(days);
		  if(day=="")
		  {
		  	 day=0;
		  }
		  if(hour=="")
		  {
		     hour=0;
		  }
		  var message ="请再次检查从"+begindate+"到"+enddate+"共"+day+"天"+hour+"小时是否正确，确认提交？";
			if(xuanze=='')
			{
				 alert("请选择下一级审批人，只有团队负责人有发起权限！");
				  return;
				}
			else if(tel=="")
		  {
			  alert("请填写联系电话");
			  document.getElementById("tel").focus();
			  return;
			}
		  else if(!rg10.checked&&!rg11.checked)
			{
				alert("请选择上午或下午");
				return;
			}
		  else if(!rg20.checked&&!rg21.checked)
			{
				alert("请选择上午或下午");
				return;
			}
		  else if((day==""&&hour=="")||(day=="0"&&hour=="0"))
			{
				alert("请填写天或小时");
				return;
			}
		  else if(!reason1.checked&&!reason2.checked&&!reason3.checked&&!reason4.checked&&!reason5.checked&&!reason6.checked&&!reason7.checked&&!reason8.checked&&!reason9.checked&&!reason10.checked&&!reason11.checked&&!reason12.checked&&!reason20.checked)
			{
				alert("请选择下线事由");
				return;
			}
		  else if(reason20.checked&&trim(qita)=="")
			{
				alert("选择其他请填写下线事由");
				return;
			}
		 else if(Number(days*6)<Number(Number(day*6)+Number(hour)))
			{
				alert("下线总时长超过下线时段最大时长");			
				return;
			}
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						action='subygxxpage.action';
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
    <form action="subjbsppage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心因公下线审批单</strong><strong> </strong></p>
        <table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td class="as">
    				发起人<b>*</b>
    			</td>
    			<td colspan="3" width="176">
    					<input type="hidden" id="name" name="name" value="${name}"/> 
    				${name}
    			</td>
    			<td width="89" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td width="201">
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" value="${tel}"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="center">
    				<input type="button" style="width:120px" id="button" value="增加一位下线员工" onclick="a()"/>
    			</td>
    			<td colspan="4" id="p">&nbsp;
    			</td>
    			<td><input type="button" style="width:120px" id="button" value="减少一位下线员工" onclick="b()"/></td>
    		</tr>
    		<tr>
    			<td class="as">
    				下线时间段<b>*</b>
    			</td>
    			 <td colspan="5" >
     				<div style="float:left;padding-top:8px;width:110px">从<input size="9" type="text" name="begindate" id="begindate" value="${begindate}" class="Wdate" onClick="WdatePicker();istip()" ></div>
    				 <div style="float:left">  
     					<input type="radio" name="RadioGroup1" value="sw" id="RadioGroup1_0" onClick="istip()">上午<br>
        				<input type="radio" name="RadioGroup1" value="xw" id="RadioGroup1_1" onClick="istip()">下午    
    				 </div>    
    				 <div style="float:left;padding-top:8px;width:120px"> 起至<input size="9" type="text" name="enddate" id="enddate" value="${enddate}" class="Wdate" onClick="WdatePicker();istip()" ></div>      
    				 <div style="float:left">      
     					<input type="radio" name="RadioGroup2" value="sw" id="RadioGroup2_0" onClick="istip()">上午<br>     
       				 <input type="radio" name="RadioGroup2" value="xw" id="RadioGroup2_1" onClick="istip()">下午 
     				</div><!-- onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" -->
     				<div style="float:left;padding-top:8px;">止，共<input size="2" style="IME-MODE: disable;" maxlength="5" type="text" name="day" value="${day}" id="day" >天
      			 	<input size="2" style="IME-MODE: disable;" maxlength="5" type="text" name="hour" id="hour" value="${hour}">小时 </div><b>跨季度请分两次填写</b>
        		</td>
    		</tr>
    		<tr>
    			<td class="as">
    				下线事由<b>*</b>
    			</td>
    			<td colspan="5">
    				<input type="radio" name="reason" value="1" id="reason1">优化创新&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="2" id="reason2">项目借调&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="3" id="reason3">外出公干&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="4" id="reason4">员工培训&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="5" id="reason5">中心检查<br/>
    				<input type="radio" name="reason" value="6" id="reason6">业务监控&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="7" id="reason7">临时抽调&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="8" id="reason8">轮岗实习&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="9" id="reason9">加班调休&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="10" id="reason10">党团工会<br/>
    				<input type="radio" name="reason" value="11" id="reason11">产量下线&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="12" id="reason12">组长下线&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" name="reason" value="20" id="reason20">其他
    				<input size="36" type="text" name="qita" id="qita" value="${qita}">
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
    				<input type="text" name="remark" style="width:400px"/ value="${remark}"><input id="showbt" style="width:100px;display:none" type="button" onclick="showpaiban()" value="查看排班计划表"/><br><span id = tip style="color:red"></span><span id = tip1 style="color:red"></span>
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="5">
    				<select name="thisunder" id="xuanze">
        				<c:forEach items="${list}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    		<tr style="color:red">
    			<td colspan="6">
    			<div align="center">下线时间段填写规则：
    				下线整天的，填写天数；不足整天的，填写小时数；小时数不累计折算天数；1天按6小时折算。
    				例：连续3天，每天下线3小时，则填写9小时，不能填写1.5天。
    			</div>
    		</td>
    		</tr>
    	</table>
    	 <input type="hidden" id="days" />
    </form>
    
  </body>
</html>
