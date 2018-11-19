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
	
	
	
	function change1(){
	
	var people = document.getElementById("name").value;
	people = encodeURI(people); 
	var result;
	var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}	
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				result=xmlhttp.responseText;
				var arr=result.split("|");
				var currentauth=arr[1];
				var currenttime=arr[2];
			   // bossname(arr[3]);
			    document.getElementById("RadioGroup2_0").checked=false;
			    document.getElementById("RadioGroup2_1").disabled=false;
				//document.getElementById("RadioGroup3_0").disabled=false;
				//document.getElementById("RadioGroup3_1").disabled=false;
				//document.getElementById("RadioGroup4_0").disabled=false;
				//document.getElementById("RadioGroup4_1").disabled=false;
				//document.getElementById("begindate").disabled=false;
				//document.getElementById("enddate").disabled=false;
				// $("#datetime").show();
				 //$("#RadioGroup3_0").show();
				 //$("#RadioGroup3_1").show();
				 //$("#RadioGroup4_0").show();
				// $("#RadioGroup4_1").show();
				// $("#begindate").show();
				// $("#enddate").show();
				$("#word1").show();
				 //$("#word2").show();
				 //$("#word3").show();
				// $("#word4").show();
				 //$("#word5").show();
				 //$("#word6").show();
				$("#changetime").show();
				if(currentauth.substr(0,1)=="1"){
				document.getElementById("id1").checked=true;	
				document.getElementById("id1").disabled=false;	
			    }
			    if(currentauth.substr(0,1)=="0"){
				document.getElementById("id1").disabled=false;			
			    }
			    if(currentauth.substr(1,1)=="1"){
				document.getElementById("id2").checked=true; 
				document.getElementById("id2").disabled=false;				
			    }
			    if(currentauth.substr(1,1)=="0"){
				document.getElementById("id2").disabled=false;				
			    }
			    if(currentauth.substr(2,1)=="1"){
				document.getElementById("id3").checked=true; 
				document.getElementById("id3").disabled=false;					
			    }
			    if(currentauth.substr(2,1)=="0"){
				document.getElementById("id3").disabled=false;				
			    }
			    if(currentauth.substr(3,1)=="1"){
				document.getElementById("id4").checked=true; 
				document.getElementById("id4").disabled=false;				
			    }
			    if(currentauth.substr(3,1)=="0"){
				document.getElementById("id4").disabled=false;				
			    }
			    if(currentauth.substr(4,1)=="1"){
				document.getElementById("id5").checked=true;
				document.getElementById("id5").disabled=false;		 			
			    }
			    if(currentauth.substr(4,1)=="0"){
				document.getElementById("id5").disabled=false;				
			    }
			    if(currentauth.substr(5,1)=="1"){
				document.getElementById("id6").checked=true; 
				document.getElementById("id6").disabled=false;				
			    }
			    if(currentauth.substr(5,1)=="0"){
				document.getElementById("id6").disabled=false;				
			    }		
			    if(currentauth.substr(6,1)=="1"){
				document.getElementById("id7").checked=true; 
				document.getElementById("id7").disabled=false;				
			    }
			    if(currentauth.substr(6,1)=="0"){
				document.getElementById("id7").disabled=false;				
			    }		
			    if(currentauth.substr(7,1)=="1"){
				document.getElementById("id8").checked=true; 
				document.getElementById("id8").disabled=false;				
			    }
			    if(currentauth.substr(7,1)=="0"){
				document.getElementById("id8").disabled=false;				
			    }		
			    if(currentauth.substr(8,1)=="1"){
				document.getElementById("id9").checked=true; 
				document.getElementById("id9").disabled=false;				
			    }
			    if(currentauth.substr(8,1)=="0"){
				document.getElementById("id9").disabled=false;				
			    }		
			    if(currentauth.substr(9,1)=="1"){
				document.getElementById("id10").checked=true; 	
				document.getElementById("id10").disabled=false;			
			    }
			    if(currentauth.substr(9,1)=="0"){
				document.getElementById("id10").disabled=false;				
			    }		
			    if(currentauth.substr(10,1)=="1"){
				document.getElementById("id11").checked=true; 
				document.getElementById("id11").disabled=false;					
			    }
			    if(currentauth.substr(10,1)=="0"){
				document.getElementById("id11").disabled=false;				
			    }		
			    if(currentauth.substr(11,1)=="1"){
				document.getElementById("id12").checked=true; 	
				document.getElementById("id12").disabled=false;				
			    }
			    if(currentauth.substr(11,1)=="0"){
				document.getElementById("id12").disabled=false;				
			    }		
			    if(currentauth.substr(12,1)=="1"){
				document.getElementById("id13").checked=true; 
				document.getElementById("id13").disabled=false;					
			    }
			    if(currentauth.substr(12,1)=="0"){
				document.getElementById("id13").disabled=false;				
			    }		
			    if(currentauth.substr(13,1)=="1"){
				document.getElementById("id14").checked=true; 	
				document.getElementById("id14").disabled=false;				
			    }
			    if(currentauth.substr(13,1)=="0"){
				document.getElementById("id14").disabled=false;				
			    }	
			    if(currentauth.substr(14,1)=="1"){
				document.getElementById("id15").checked=true; 
				document.getElementById("id15").disabled=false;			
			    }
			    if(currentauth.substr(14,1)=="0"){
				document.getElementById("id15").disabled=false;				
			    }		
			    if(currentauth.substr(15,1)=="1"){
				document.getElementById("id16").checked=true; 
				document.getElementById("id16").disabled=false;					
			    }
			    if(currentauth.substr(15,1)=="0"){
				document.getElementById("id16").disabled=false;				
			    }
			if(currenttime==""){
				document.getElementById("idt0").selected="selected"; 			
			}
			if(currenttime!=""){
				document.getElementById("idt0").disabled="disabled";			
			}
			if(currenttime==1){
				document.getElementById("idt1").selected="selected"; 			
			}
			if(currenttime!=1){
				document.getElementById("idt1").disabled=false;			
			}
			if(currenttime==2){
				document.getElementById("idt2").selected="selected"; 			
			}
			if(currenttime!=2){
				document.getElementById("idt2").disabled=false;			
			}
			if(currenttime==3){
				document.getElementById("idt3").selected="selected"; 			
			}
			if(currenttime!=3){
				document.getElementById("idt3").disabled=false;			
			}
			if(currenttime==4){
				document.getElementById("idt4").selected="selected"; 			
			}
			if(currenttime!=4){
				document.getElementById("idt4").disabled=false;			
			}			
			    																	
			}				
		} 
		var url="mjglajax.action?people="+people;
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
	}
	
	function change2(){
	
  
	var people = document.getElementById("name").value;
	people = encodeURI(people); 
	var result;
	var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}	
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				result=xmlhttp.responseText;
				var arr=result.split("|");
				var currentauth=arr[1];
				var currenttime=arr[2];
				//bossname(arr[3]);
				document.getElementById("RadioGroup2_0").checked=true;
				document.getElementById("RadioGroup2_1").disabled="disabled";
				//document.getElementById("RadioGroup3_0").disabled="disabled";
				//document.getElementById("RadioGroup3_1").disabled="disabled";
				//document.getElementById("RadioGroup4_0").disabled="disabled";
				//document.getElementById("RadioGroup4_1").disabled="disabled";
				//document.getElementById("begindate").disabled="disabled";
				//document.getElementById("enddate").disabled="disabled";
				 //$("#RadioGroup3_0").hide();
				// $("#RadioGroup3_1").hide();
				 //$("#RadioGroup4_0").hide();
				 //$("#RadioGroup4_1").hide();
				// $("#begindate").hide();
				// $("#enddate").hide();
				$("#word1").hide();
				// $("#word2").hide();
				// $("#word3").hide();
				 //$("#word4").hide();
				// $("#word5").hide();
				// $("#word6").hide();
				$("#changetime").hide();
				if(currentauth.substr(0,1)=="1"){
				document.getElementById("id1").checked=true; 
				document.getElementById("id1").disabled="disabled";			
			    //$("#id1").click(function(){return false;}); 	
			    }
			    if(currentauth.substr(0,1)=="0"){
				document.getElementById("id1").disabled="disabled";			
			    }
			    if(currentauth.substr(1,1)=="1"){
				document.getElementById("id2").checked=true; 
				document.getElementById("id2").disabled="disabled";				
				 //$("#id2").click(function(){return false;}); 			
			    }
			    if(currentauth.substr(1,1)=="0"){
				document.getElementById("id2").disabled="disabled";				
			    }
			    if(currentauth.substr(2,1)=="1"){
				document.getElementById("id3").checked=true; 
			    document.getElementById("id3").disabled="disabled";			
				 //$("#id3").click(function(){return false;}); 			
			    }
			    if(currentauth.substr(2,1)=="0"){
				document.getElementById("id3").disabled="disabled";				
			    }
			    if(currentauth.substr(3,1)=="1"){
				document.getElementById("id4").checked=true; 
				document.getElementById("id4").disabled="disabled";	
				 //$("#id4").click(function(){return false;});  				
			    }
			    if(currentauth.substr(3,1)=="0"){
				document.getElementById("id4").disabled="disabled";				
			    }
			    if(currentauth.substr(4,1)=="1"){
				document.getElementById("id5").checked=true; 
				document.getElementById("id5").disabled="disabled";		
				 //$("#id5").click(function(){return false;}); 				
			    }
			    if(currentauth.substr(4,1)=="0"){
				document.getElementById("id5").disabled="disabled";				
			    }
			    if(currentauth.substr(5,1)=="1"){
				document.getElementById("id6").checked=true; 
			    document.getElementById("id6").disabled="disabled";	
				 // $("#id6").click(function(){return false;}); ; 				
			    }
			    if(currentauth.substr(5,1)=="0"){
				document.getElementById("id6").disabled="disabled";				
			    }		
			    if(currentauth.substr(6,1)=="1"){
				document.getElementById("id7").checked=true; 
				document.getElementById("id7").disabled="disabled";	
				 //$("#id7").click(function(){return false;}); 			
			    }
			    if(currentauth.substr(6,1)=="0"){
				document.getElementById("id7").disabled="disabled";				
			    }		
			    if(currentauth.substr(7,1)=="1"){
				document.getElementById("id8").checked=true; 
				document.getElementById("id8").disabled="disabled";	
				 //$("#id8").click(function(){return false;}); 			
			    }
			    if(currentauth.substr(7,1)=="0"){
				document.getElementById("id8").disabled="disabled";				
			    }		
			    if(currentauth.substr(8,1)=="1"){
				document.getElementById("id9").checked=true; 
				document.getElementById("id9").disabled="disabled";	
				 //$("#id9").click(function(){return false;}); 			
			    }
			    if(currentauth.substr(8,1)=="0"){
				document.getElementById("id9").disabled="disabled";				
			    }		
			    if(currentauth.substr(9,1)=="1"){
				document.getElementById("id10").checked=true; 
				document.getElementById("id10").disabled="disabled";		
				 //$("#id10").click(function(){return false;});  			
			    }
			    if(currentauth.substr(9,1)=="0"){
				document.getElementById("id10").disabled="disabled";				
			    }		
			    if(currentauth.substr(10,1)=="1"){
				document.getElementById("id11").checked=true;
				document.getElementById("id11").disabled="disabled";
				// $("#id11").click(function(){return false;});  			
			    }
			    if(currentauth.substr(10,1)=="0"){
				document.getElementById("id11").disabled="disabled";				
			    }		
			    if(currentauth.substr(11,1)=="1"){
				document.getElementById("id12").checked=true; 
				document.getElementById("id12").disabled="disabled";
				// $("#id12").click(function(){return false;}); 				
			    }
			    if(currentauth.substr(11,1)=="0"){
				document.getElementById("id12").disabled="disabled";				
			    }		
			    if(currentauth.substr(12,1)=="1"){
				document.getElementById("id13").checked=true; 
				document.getElementById("id13").disabled="disabled";	
				 //$("#id13").click(function(){return false;}); 		
			    }
			    if(currentauth.substr(12,1)=="0"){
				document.getElementById("id13").disabled="disabled";				
			    }		
			    if(currentauth.substr(13,1)=="1"){
				document.getElementById("id14").checked=true;
				document.getElementById("id14").disabled="disabled"; 
				 //$("#id14").click(function(){return false;}); 				
			    }
			    if(currentauth.substr(13,1)=="0"){
				document.getElementById("id14").disabled="disabled";				
			    }	
			    if(currentauth.substr(14,1)=="1"){
				document.getElementById("id15").checked=true; 	
				document.getElementById("id15").disabled="disabled";	
				// $("#id15").click(function(){return false;}); 		
			    }
			    if(currentauth.substr(14,1)=="0"){
				document.getElementById("id15").disabled="disabled";				
			    }		
			    if(currentauth.substr(15,1)=="1"){
				document.getElementById("id16").checked=true; 
				document.getElementById("id16").disabled="disabled";	
				 //$("#id16").click(function(){return false;}); 		
			    }
			    if(currentauth.substr(15,1)=="0"){
				document.getElementById("id16").disabled="disabled";				
			    }
			if(currenttime==""){
				document.getElementById("idt0").selected="selected"; 			
			}
			if(currenttime!=""){
				document.getElementById("idt0").disabled="disabled";			
			}
			if(currenttime==1){
				document.getElementById("idt1").selected="selected"; 			
			}
			if(currenttime!=1){
				document.getElementById("idt1").disabled="disabled";			
			}
			if(currenttime==2){
				document.getElementById("idt2").selected="selected"; 			
			}
			if(currenttime!=2){
				document.getElementById("idt2").disabled="disabled";			
			}
			if(currenttime==3){
				document.getElementById("idt3").selected="selected"; 			
			}
			if(currenttime!=3){
				document.getElementById("idt3").disabled="disabled";			
			}
			if(currenttime==4){
				document.getElementById("idt4").selected="selected"; 			
			}
			if(currenttime!=4){
				document.getElementById("idt4").disabled="disabled";			
			}	
											
			}				
		} 
		var url="mjglajax.action?people="+people;
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
	}
    

    function change3(){
	

	var people = document.getElementById("name").value;
	people = encodeURI(people); 
	var result;
	var xmlhttp;

		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}	
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		
				result=xmlhttp.responseText;
				var arr=result.split("|");
				var isnew=arr[2];
				document.getElementById("RadioGroup2_0").checked=false;
			    document.getElementById("RadioGroup2_1").disabled=false;
				//document.getElementById("RadioGroup3_0").disabled=false;
				//document.getElementById("RadioGroup3_1").disabled=false;
				//document.getElementById("RadioGroup4_0").disabled=false;
				//document.getElementById("RadioGroup4_1").disabled=false;
				//document.getElementById("begindate").disabled=false;
				//document.getElementById("enddate").disabled=false;
				if(isnew=="0")
				{
					alert("申请人已有卡，不能点击领取新卡");
				}
				
			  		
			}
					
		} 
		var url="mjglnew.action?people="+people;
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
	
	}
	 function tijiao() {
		//var begindate= document.getElementById("begindate").value;
		//var enddate= document.getElementById("enddate").value;
		//var begindates=begindate.replace(/-/g,"/");
		//var begindates=new Date(begindates);
		//var enddates=enddate.replace(/-/g,"/");
		//var enddates=new Date(enddates);	 
		  
		  //var people=document.getElementsByName("people")[0].value; 
		  var xuanze = document.getElementById("xuanze").value;
		//  var rg10=document.getElementById("RadioGroup3_0");
		//  var rg11=document.getElementById("RadioGroup3_1");
		//  var rg20=document.getElementById("RadioGroup4_0");
		//  var rg21=document.getElementById("RadioGroup4_1");
		  var rg30=document.getElementById("RadioGroup2_0");
		  var rg31=document.getElementById("RadioGroup2_1");
		  var rg10=document.getElementById("RadioGroup1_0");
		  var rg11=document.getElementById("RadioGroup1_1");
		  var rg13=document.getElementById("RadioGroup1_3");
		  var rg14=document.getElementById("RadioGroup1_4");
		  var rg15=document.getElementById("RadioGroup1_5");
		  var message = "确认提交？";
		  var changetime=document.getElementById("changetime").value;
          var time=document.getElementById("newt").value;
          if(time=="")
          {
             alert("请选择长期权限时段");
             document.getElementById("newt").focus();
             return;
          }
		 /* if(people=="")
		  {
			  alert("请填写申请人");
			  document.getElementById("name").focus();return;
			}
		
		  if((rg31.checked)&&(!rg10.checked&&!rg11.checked))
			{
				alert("请选择上午或下午");
				return;
			}
		  else if((rg31.checked)&&(!rg20.checked&&!rg21.checked))
			{
				alert("请选择上午或下午");
				return;
			}*/
		   if(!rg10.checked&&!rg11.checked&&!rg13.checked&&!rg14.checked&&!rg15.checked)
			{
				alert("请选择申请事由！");
				return;
			}
		  if(!rg30.checked&&!rg31.checked)
			{
				alert("请选择长期或临时");
				return;
			}
		  else if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
		  else if(changetime="")
			{
			  alert("临时权限具体时间和日期");
			  document.getElementById("changetime").focus();return;
			}
		
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						
						action='submjglpage.action';
						method="post";
						submit();
					}
				}
			}
	  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
		}
	function hide()
	{
	   $("#word1").hide();
	   $("#changetime").hide();
	   document.getElementById("newt").focus();
        // return;
     }
	
	function show()
	{
	   $("#word1").show();
	   $("#changetime").show();
	}
	function a(){
		 alert("仅添加本处室人员！");
		 $('#p').append("<input type='text' name='people' style='width:50px'/>");
		}
	function b(){
		$("input[name='people']").eq($("input[name='people']").size()-1).remove();
		}
	/*function bossname(bossnames){

       var arry= new Array();
       arry=bossnames.split(";"); //字符分割 
       var obj=document.getElementById('xuanze'); 
       obj.options.length=0;
       for (var i=0;i<arry.length;i++){	
	   var brry= new Array();
	   brry=arry[i].split(":");
	   obj.options.add(new Option(brry[0],brry[1])); //这个兼容IE与firefox 
         }
     } */  
</script>
  <style type="text/css">
  .as {
	text-align: center;
    }
   b{
	color:red;
    }
   #ii
   {
     vertical-align:bottom;
   }
  </style>
  </head>
  
  <body> 
 ${daohang} 
    <form action="subwcggpage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心门禁卡申请表</strong><strong> </strong></p>
        <table width="900" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    		    <td width="200" class="as">
    				发起人姓名<b>*</b>
    			</td>
    			<td colspan="3">
    				<input type="hidden" id="name" name="name" value="${ui.username}"/> 
    				${ui.username}
    			</td>
    			
    			
    		</tr>
    		<tr>
    		    <td width="200" class="as">
    				申请人姓名<b>*</b>
    			</td>
    			<td width="120">
    				<input type="button" id="button" value="添加一位申请人" onclick="a()"/>
    			</td>
    			<td width="500" id="p">&nbsp;
    			</td>
    			<td width="120"><input type="button" id="button" value="减少一位申请人" onclick="b()"/></td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请事由<b>*</b>
    			</td>
    			<td colspan="5">
    				<input type="radio" name="RadioGroup1" value="1" id="RadioGroup1_0" onClick="change3()">&nbsp;领取新卡&nbsp;&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="RadioGroup1" value="2" id="RadioGroup1_1" onClick="change2()">&nbsp;损坏换卡 &nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="radio" name="RadioGroup1" value="4" id="RadioGroup1_3" onClick="change2()">&nbsp;丢失补卡 &nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="radio" name="RadioGroup1" value="5" id="RadioGroup1_4" onClick="change1()">&nbsp;调整权限（时段） &nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="radio" name="RadioGroup1" value="6" id="RadioGroup1_5" onClick="change2()">&nbsp;注销&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				使用权限
    			</td>
    			<td colspan="5">
    				  五楼大门：<input type="checkbox" id="id1" name="newp1"  />
					  五楼东区：<input type="checkbox" id="id2" name="newp2"  />
					  五楼西区：<input type="checkbox" id="id3" name="newp3" />
						  
					  六楼大门：<input type="checkbox" id="id4" name="newp4"  />
					  六楼西区：<input type="checkbox" id="id5" name="newp5"  />
					  六楼中区：<input type="checkbox" id="id6" name="newp6"  /><br/>
					  六楼综合：<input type="checkbox" id="id7" name="newp7"  />
						  
					  七楼大门：<input type="checkbox" id="id8" name="newp8" />
					  七楼东区：<input type="checkbox" id="id9" name="newp9" />
					  七楼西区：<input type="checkbox" id="id10" name="newp10"  />
						 
					  八楼大门：<input type="checkbox" id="id11" name="newp11"  />
					  八楼东区：<input type="checkbox" id="id12" name="newp12" /><br/>
					  八楼西区：<input type="checkbox" id="id13" name="newp13"  />
						  
					  九楼大门：<input type="checkbox" id="id14" name="newp14"  />
					  九楼东区：<input type="checkbox" id="id15" name="newp15" />
					  九楼西区：<input type="checkbox" id="id16" name="newp16"  />
    			</td>
    		</tr>
    		<tr>
    			<td class="as" rowspan="2">
    				权限时段
    			</td>
    			 <td colspan="3" >
    			 <input type="radio" name="RadioGroup2" value="0" id="RadioGroup2_0"  onClick="hide()">&nbsp;长期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     				<select name="newt" id="newt" > 
						<option id="idt0" selected value="">请选择</option> 
						<option id="idt1" value="1">5×14（7:00-21:00）</option> 
						<option id="idt2" value="2">5×13（7:00-20:00）</option> 
						<option id="idt3" value="3">7×24</option> 
						<option id="idt4" value="4">7×14（7:00-21:00）</option> 
						
					</select> 
        		</td>
    		</tr>
    		<tr>
    			
    			<td colspan="3" id="datetime">
    				
        		<input type="radio" name="RadioGroup2" value="1" id="RadioGroup2_1" onClick="alert('临时调整期限需填写具体调整时间！');show();">&nbsp;临时 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			
    			<input type="text" name="changetime" id="changetime" style="width:400px"/><span id="word1">（填写具体调整时间）</span>
    				   
     				
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				所在处室意见
    			</td>
    			<td colspan="3">
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				综合与生产管理处审批意见
    			</td>
    			<td colspan="3">
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="3">
    				<input type="text" name="remark" style="width:400px"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="3">
    		
    			 <select name="thisunder" id="xuanze">
        				<option value="wu">请选择下一级审批人</option>
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
    			<td colspan="3">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
