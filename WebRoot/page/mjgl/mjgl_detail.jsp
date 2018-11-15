<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    
    function tijiao1()
		{
			with(document.forms[0]) {
			action='mjglqueren.action';
			method="post";
			submit();
			}
		}
		
	function tijiao2()
		{
			with(document.forms[0]) {
			action='mjglselfqueren.action';
			method="post";
			submit();
			}
		}
		 
	$(document).ready(function(){ 
	            
	         
	            if(${tm.reason}==1)
	            {
	            document.getElementById("RadioGroup1_0").checked=true; 	
	            document.getElementById("RadioGroup1_1").disabled="disabled";	
	            //document.getElementById("RadioGroup1_2").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_3").disabled="disabled";	
	            document.getElementById("RadioGroup1_4").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_5").disabled="disabled";	
	            }
	            if(${tm.reason}==2)
	            {
	            document.getElementById("RadioGroup1_0").disabled="disabled";		
	            document.getElementById("RadioGroup1_1").checked=true; 		
	            //document.getElementById("RadioGroup1_2").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_3").disabled="disabled";	
	            document.getElementById("RadioGroup1_4").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_5").disabled="disabled";	
	            }
	            /*if(${tm.reason}==3)
	            {
	            document.getElementById("RadioGroup1_0").disabled="disabled";		
	            document.getElementById("RadioGroup1_1").disabled="disabled"; 		
	            document.getElementById("RadioGroup1_2").checked=true; 	 	
	            document.getElementById("RadioGroup1_3").disabled="disabled";	
	            document.getElementById("RadioGroup1_4").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_5").disabled="disabled";	
	            }*/
	            if(${tm.reason}==4)
	            {
	            document.getElementById("RadioGroup1_0").disabled="disabled";		
	            document.getElementById("RadioGroup1_1").disabled="disabled";	
	            //document.getElementById("RadioGroup1_2").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_3").checked=true; 		
	            document.getElementById("RadioGroup1_4").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_5").disabled="disabled";	
	            }
	            if(${tm.reason}==5)
	            {
	            document.getElementById("RadioGroup1_0").disabled="disabled";		
	            document.getElementById("RadioGroup1_1").disabled="disabled";	
	           // document.getElementById("RadioGroup1_2").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_3").disabled="disabled";	
	            document.getElementById("RadioGroup1_4").checked=true; 	 	
	            document.getElementById("RadioGroup1_5").disabled="disabled";	
	            }
	            if(${tm.reason}==6)
	            {
	            document.getElementById("RadioGroup1_0").disabled="disabled";		
	            document.getElementById("RadioGroup1_1").disabled="disabled";		
	           // document.getElementById("RadioGroup1_2").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_3").disabled="disabled";	
	            document.getElementById("RadioGroup1_4").disabled="disabled";	 	
	            document.getElementById("RadioGroup1_5").checked=true;
	            }
	            
                if(${tm.istemp}==0)
                {
                document.getElementById("RadioGroup2_0").checked=true;
                document.getElementById("RadioGroup2_1").disabled="disabled";		
      	        if(${tm.reason}==5)
      	      {  
      	      
      	       if(${fn:substring(tm.newp,0,1)}==1){
      	         document.getElementById("id1").checked=true; 
      	         document.getElementById("id1").disabled=false;	
				// document.getElementById("id1").checked=true; 
				 $("#id1").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,0,1)}==0){
				document.getElementById("id1").disabled="disabled";			
			    }
			    if(${fn:substring(tm.newp,1,2)}==1){
			    document.getElementById("id2").checked=true; 
			    document.getElementById("id2").disabled=false;	
				//document.getElementById("id2").checked=true; 
				$("#id2").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,1,2)}==0){
				document.getElementById("id2").disabled="disabled";				
			    }
			    if(${fn:substring(tm.newp,2,3)}==1){
			    document.getElementById("id3").checked=true; 
			    document.getElementById("id3").disabled=false;	
				//document.getElementById("id3").checked=true; 
				$("#id3").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,2,3)}==0){
				document.getElementById("id3").disabled="disabled";				
			    }
			    if(${fn:substring(tm.newp,3,4)}==1){
			    document.getElementById("id4").checked=true; 
			    document.getElementById("id4").disabled=false;	
				//document.getElementById("id4").checked=true; 
				$("#id4").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,3,4)}==0){
				document.getElementById("id4").disabled="disabled";				
			    }
			    if(${fn:substring(tm.newp,4,5)}==1){
			    document.getElementById("id5").checked=true;
			    document.getElementById("id5").disabled=false;	
				//document.getElementById("id5").checked=true; 
				$("#id5").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,4,5)}==0){
				document.getElementById("id5").disabled="disabled";				
			    }
			    if(${fn:substring(tm.newp,5,6)}==1){
			    document.getElementById("id6").checked=true; 
			    document.getElementById("id6").disabled=false;	
				//document.getElementById("id6").checked=true; 
				$("#id6").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,5,6)}==0){
				document.getElementById("id6").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,6,7)}==1){
			    document.getElementById("id7").checked=true; 
			    document.getElementById("id7").disabled=false;	
				//document.getElementById("id7").checked=true; 
				$("#id7").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,6,7)}==0){
				document.getElementById("id7").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,7,8)}==1){
			    document.getElementById("id8").checked=true; 
			    document.getElementById("id8").disabled=false;	
				//document.getElementById("id8").checked=true; 
				$("#id8").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,7,8)}==0){
				document.getElementById("id8").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,8,9)}==1){
			    document.getElementById("id9").checked=true;
			    document.getElementById("id9").disabled=false;	
				//document.getElementById("id9").checked=true;
				$("#id9").click(function(){return false;}); 	 			
			    }
			    if(${fn:substring(tm.newp,8,9)}==0){
				document.getElementById("id9").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,9,10)}==1){
			    document.getElementById("id10").checked=true;
			    document.getElementById("id10").disabled=false;	
				//document.getElementById("id10").checked=true;
				$("#id10").click(function(){return false;}); 	 			
			    }
			    if(${fn:substring(tm.newp,9,10)}==0){
				document.getElementById("id10").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,10,11)}==1){
			    document.getElementById("id11").checked=true; 
			    document.getElementById("id11").disabled=false;	
				//document.getElementById("id11").checked=true; 
				$("#id11").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,10,11)}==0){
				document.getElementById("id11").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,11,12)}==1){
			    document.getElementById("id12").checked=true;
			    document.getElementById("id12").disabled=false;	
				//document.getElementById("id12").checked=true; 
				$("#id12").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,11,12)}==0){
				document.getElementById("id12").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,12,13)}==1){
			    document.getElementById("id13").checked=true; 
			    document.getElementById("id13").disabled=false;	
				//document.getElementById("id13").checked=true; 
				$("#id13").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,12,13)}==0){
				document.getElementById("id13").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,13,14)}==1){
			    document.getElementById("id14").checked=true; 
			    document.getElementById("id14").disabled=false;	
				//document.getElementById("id14").checked=true; 
				$("#id14").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,13,14)}==0){
				document.getElementById("id14").disabled="disabled";				
			    }	
			    if(${fn:substring(tm.newp,14,15)}==1){
			    document.getElementById("id15").checked=true;
			    document.getElementById("id15").disabled=false;	
				//document.getElementById("id15").checked=true;
				$("#id15").click(function(){return false;}); 	 			
			    }
			    if(${fn:substring(tm.newp,14,15)}==0){
				document.getElementById("id15").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.newp,15,16)}==1){
			    document.getElementById("id16").checked=true; 
			    document.getElementById("id16").disabled=false;	
				//document.getElementById("id16").checked=true; 
				$("#id16").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.newp,15,16)}==0){
				document.getElementById("id16").disabled="disabled";				
			    }
			    }
			    else
			    {
			     if(${fn:substring(tm.oldp,0,1)}==1){
      	         document.getElementById("id1").checked=true; 
      	         document.getElementById("id1").disabled=false;	
				// document.getElementById("id1").checked=true; 
				 $("#id1").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,0,1)}==0){
				document.getElementById("id1").disabled="disabled";			
			    }
			    if(${fn:substring(tm.oldp,1,2)}==1){
			    document.getElementById("id2").checked=true; 
			    document.getElementById("id2").disabled=false;	
				//document.getElementById("id2").checked=true; 
				$("#id2").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,1,2)}==0){
				document.getElementById("id2").disabled="disabled";				
			    }
			    if(${fn:substring(tm.oldp,2,3)}==1){
			    document.getElementById("id3").checked=true; 
			    document.getElementById("id3").disabled=false;	
				//document.getElementById("id3").checked=true; 
				$("#id3").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,2,3)}==0){
				document.getElementById("id3").disabled="disabled";				
			    }
			    if(${fn:substring(tm.oldp,3,4)}==1){
			    document.getElementById("id4").checked=true; 
			    document.getElementById("id4").disabled=false;	
				//document.getElementById("id4").checked=true; 
				$("#id4").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,3,4)}==0){
				document.getElementById("id4").disabled="disabled";				
			    }
			    if(${fn:substring(tm.oldp,4,5)}==1){
			    document.getElementById("id5").checked=true;
			    document.getElementById("id5").disabled=false;	
				//document.getElementById("id5").checked=true; 
				$("#id5").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,4,5)}==0){
				document.getElementById("id5").disabled="disabled";				
			    }
			    if(${fn:substring(tm.oldp,5,6)}==1){
			    document.getElementById("id6").checked=true; 
			    document.getElementById("id6").disabled=false;	
				//document.getElementById("id6").checked=true; 
				$("#id6").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,5,6)}==0){
				document.getElementById("id6").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,6,7)}==1){
			    document.getElementById("id7").checked=true; 
			    document.getElementById("id7").disabled=false;	
				//document.getElementById("id7").checked=true; 
				$("#id7").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,6,7)}==0){
				document.getElementById("id7").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,7,8)}==1){
			    document.getElementById("id8").checked=true; 
			    document.getElementById("id8").disabled=false;	
				//document.getElementById("id8").checked=true; 
				$("#id8").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,7,8)}==0){
				document.getElementById("id8").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,8,9)}==1){
			    document.getElementById("id9").checked=true;
			    document.getElementById("id9").disabled=false;	
				//document.getElementById("id9").checked=true;
				$("#id9").click(function(){return false;}); 	 			
			    }
			    if(${fn:substring(tm.oldp,8,9)}==0){
				document.getElementById("id9").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,9,10)}==1){
			    document.getElementById("id10").checked=true;
			    document.getElementById("id10").disabled=false;	
				//document.getElementById("id10").checked=true;
				$("#id10").click(function(){return false;}); 	 			
			    }
			    if(${fn:substring(tm.oldp,9,10)}==0){
				document.getElementById("id10").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,10,11)}==1){
			    document.getElementById("id11").checked=true; 
			    document.getElementById("id11").disabled=false;	
				//document.getElementById("id11").checked=true; 
				$("#id11").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,10,11)}==0){
				document.getElementById("id11").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,11,12)}==1){
			    document.getElementById("id12").checked=true;
			    document.getElementById("id12").disabled=false;	
				//document.getElementById("id12").checked=true; 
				$("#id12").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,11,12)}==0){
				document.getElementById("id12").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,12,13)}==1){
			    document.getElementById("id13").checked=true; 
			    document.getElementById("id13").disabled=false;	
				//document.getElementById("id13").checked=true; 
				$("#id13").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,12,13)}==0){
				document.getElementById("id13").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,13,14)}==1){
			    document.getElementById("id14").checked=true; 
			    document.getElementById("id14").disabled=false;	
				//document.getElementById("id14").checked=true; 
				$("#id14").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,13,14)}==0){
				document.getElementById("id14").disabled="disabled";				
			    }	
			    if(${fn:substring(tm.oldp,14,15)}==1){
			    document.getElementById("id15").checked=true;
			    document.getElementById("id15").disabled=false;	
				//document.getElementById("id15").checked=true;
				$("#id15").click(function(){return false;}); 	 			
			    }
			    if(${fn:substring(tm.oldp,14,15)}==0){
				document.getElementById("id15").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.oldp,15,16)}==1){
			    document.getElementById("id16").checked=true; 
			    document.getElementById("id16").disabled=false;	
				//document.getElementById("id16").checked=true; 
				$("#id16").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.oldp,15,16)}==0){
				document.getElementById("id16").disabled="disabled";				
			    }
			    }
			if(${tm.newtime}==""){
				document.getElementById("idt0").selected="selected"; 			
			}
			if(${tm.newtime}!=""){
				document.getElementById("idt0").disabled="disabled";			
			}    
			if(${tm.newtime}==1){
				document.getElementById("idt1").selected="selected"; 			
			}
			if(${tm.newtime}!=1){
				document.getElementById("idt1").disabled="disabled";			
			}
			if(${tm.newtime}==2){
				document.getElementById("idt2").selected="selected"; 			
			}
			if(${tm.newtime}!=2){
				document.getElementById("idt2").disabled="disabled";			
			}
			if(${tm.newtime}==3){
				document.getElementById("idt3").selected="selected"; 			
			}
			if(${tm.newtime}!=3){
				document.getElementById("idt3").disabled="disabled";			
			}
			if(${tm.newtime}==4){
				document.getElementById("idt4").selected="selected"; 			
			}
			if(${tm.newtime}!=4){
				document.getElementById("idt4").disabled="disabled";			
			}
		
			}
			else if (${tm.istemp}==1)
			{
			    document.getElementById("RadioGroup2_0").disabled="disabled";	
                document.getElementById("RadioGroup2_1").checked=true; 		
			    /*if(${tm.startdateamorpm.equals("sw")})
	            {
	            	document.getElementById("RadioGroup3_0").checked=true; 	
	            	document.getElementById("RadioGroup3_1").disabled="disabled";	
	            }
	            
	            if(${tm.startdateamorpm.equals("xw")})
	            {
	            	document.getElementById("RadioGroup3_0").disabled="disabled";		
	            	document.getElementById("RadioGroup3_1").checked=true; 	
	            }
	            if(${tm.enddateamorpam.equals("sw")})
	            {
	            	document.getElementById("RadioGroup4_0").checked=true; 	
	            	document.getElementById("RadioGroup4_1").disabled="disabled";	
	            }
	            
	            if(${tm.enddateamorpam.equals("xw")})
	            {
	            	document.getElementById("RadioGroup4_0").disabled="disabled";		
	            	document.getElementById("RadioGroup4_1").checked=true; 	
	            }*/
			    if(${fn:substring(tm.tempauth,0,1)}==1){
				 document.getElementById("id1").checked=true;
				 $("#id1").click(function(){return false;}); 	 			
			    }
			    if(${fn:substring(tm.tempauth,0,1)}==0){
				document.getElementById("id1").disabled="disabled";			
			    }
			    if(${fn:substring(tm.tempauth,1,2)}==1){
				document.getElementById("id2").checked=true; 
				$("#id2").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,1,2)}==0){
				document.getElementById("id2").disabled="disabled";				
			    }
			    if(${fn:substring(tm.tempauth,2,3)}==1){
				document.getElementById("id3").checked=true; 	
				$("#id3").click(function(){return false;}); 			
			    }
			    if(${fn:substring(tm.tempauth,2,3)}==0){
				document.getElementById("id3").disabled="disabled";				
			    }
			    if(${fn:substring(tm.tempauth,3,4)}==1){
				document.getElementById("id4").checked=true; 
				$("#id4").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,3,4)}==0){
				document.getElementById("id4").disabled="disabled";				
			    }
			    if(${fn:substring(tm.tempauth,4,5)}==1){
				document.getElementById("id5").checked=true; 
				$("#id5").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,4,5)}==0){
				document.getElementById("id5").disabled="disabled";				
			    }
			    if(${fn:substring(tm.tempauth,5,6)}==1){
				document.getElementById("id6").checked=true; 
				$("#id6").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,5,6)}==0){
				document.getElementById("id6").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,6,7)}==1){
				document.getElementById("id7").checked=true; 
				$("#id7").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,6,7)}==0){
				document.getElementById("id7").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,7,8)}==1){
				document.getElementById("id8").checked=true; 
				$("#id8").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,7,8)}==0){
				document.getElementById("id8").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,8,9)}==1){
				document.getElementById("id9").checked=true; 	
				$("#id9").click(function(){return false;}); 			
			    }
			    if(${fn:substring(tm.tempauth,8,9)}==0){
				document.getElementById("id9").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,9,10)}==1){
				document.getElementById("id10").checked=true; 
				$("#id10").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,9,10)}==0){
				document.getElementById("id10").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,10,11)}==1){
				document.getElementById("id11").checked=true; 
				$("#id11").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,10,11)}==0){
				document.getElementById("id11").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,11,12)}==1){
				document.getElementById("id12").checked=true; 
				$("#id12").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,11,12)}==0){
				document.getElementById("id12").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,12,13)}==1){
				document.getElementById("id13").checked=true; 	
				$("#id13").click(function(){return false;}); 			
			    }
			    if(${fn:substring(tm.tempauth,12,13)}==0){
				document.getElementById("id13").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,13,14)}==1){
				document.getElementById("id14").checked=true; 
				$("#id14").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,13,14)}==0){
				document.getElementById("id14").disabled="disabled";				
			    }	
			    if(${fn:substring(tm.tempauth,14,15)}==1){
				document.getElementById("id15").checked=true; 
				$("#id15").click(function(){return false;}); 				
			    }
			    if(${fn:substring(tm.tempauth,14,15)}==0){
				document.getElementById("id15").disabled="disabled";				
			    }		
			    if(${fn:substring(tm.tempauth,15,16)}==1){
				document.getElementById("id16").checked=true; 	
				$("#id16").click(function(){return false;}); 			
			    }
			    if(${fn:substring(tm.tempauth,15,16)}==0){
				document.getElementById("id16").disabled="disabled";				
			    }
			document.getElementById("idt0").disabled="disabled";
			document.getElementById("idt1").disabled="disabled";			
		    document.getElementById("idt2").disabled="disabled";			
			document.getElementById("idt3").disabled="disabled";			
						
			  		
			}									
						
     });

	
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
   #ii
   {
     vertical-align:bottom;
   }
  </style>
  </head>
  
  <body>
  ${daohang}
    <form>
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心门禁卡申请表</strong><strong> </strong></p>
        <table width="900" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr> 
    		 <td width="200" class="as">
    				发起人姓名<b>*</b>
    		 </td>
    			<td>
    				${fb:newnumbertoname(tm.initiator)}
    			</td>
    		</tr>
    		<tr>
    		    <td width="200" class="as">
    				申请人姓名<b>*</b>
    			</td>
    			
    			<td width="700" id="p">
    			${fb:newnumbertoname(tm.initiator)} <c:if test="${(tm.people)!=''}">、</c:if> ${tm.people}&nbsp;&nbsp; 
    			</td>
    			
    		</tr>
    		<tr>
    			<td class="as">
    				申请事由<b>*</b>
    			</td>
    			<td>
    				<input type="radio" name="RadioGroup1" value="1" id="RadioGroup1_0" >&nbsp;领取新卡&nbsp;&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="RadioGroup1" value="2" id="RadioGroup1_1" >&nbsp;损坏换卡 &nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="radio" name="RadioGroup1" value="4" id="RadioGroup1_3" >&nbsp;丢失补卡 &nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="radio" name="RadioGroup1" value="5" id="RadioGroup1_4" >&nbsp;调整权限（时段） &nbsp;&nbsp;&nbsp;&nbsp;
    			    <input type="radio" name="RadioGroup1" value="6" id="RadioGroup1_5" >&nbsp;注销&nbsp;&nbsp;&nbsp;&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				使用权限
    			</td>
    			<td>
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
    			 <td>
    			    <input type="radio" name="RadioGroup2" value="1" id="RadioGroup2_0" >&nbsp;长期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     				<select name="newt" id="newt"> 
						<option id="idt0" selected value="">请选择</option> 
						<option id="idt1" value="1">5×14（7:00-21:00）</option> 
						<option id="idt2" value="2">5×13（7:00-20:00）</option> 
						<option id="idt3" value="3">7×24</option>
						<option id="idt4" value="4">7×14（7:00-21:00）</option>  
					</select> 
        		</td>
    		</tr>
    		<tr>
    			
    			<td>
    				
        		 <input type="radio" name="RadioGroup2" value="2" id="RadioGroup2_1" >&nbsp;临时 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			
    		     <c:if test="${tm.istemp==1}"> 
    			         ${tm.remark2}
     			 </c:if>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				所在处室意见
    			</td>
    			<td >
    				
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'}">
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				&nbsp;&nbsp;
    			 
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				综合与生产管理处审批意见
    			</td>
    			<td >
    			
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='Q'}"> 
     	 					审核人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审核时间：${lp.time}<br/>
      					</c:if>
    					<c:if test="${lp.authority=='H'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td >
    			 <c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.role=='撤销'}"> 
     	 					${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.role=='收回'}"> 
     	 					${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				${tm.remark1}&nbsp;
    			</td>
    		</tr>
    		
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td >
    				<input type="hidden" name="number" value="${tm.number}"/>
    				<input type="hidden" name="thisunder" value="${undersign}"/>
    				<input type="hidden" name="thisnewnumber" value="${newnumber}"/>
    				<input type="hidden" name="thisundername" value="${username}"/>
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    				<c:if test="${queren==1}">
						<input type="button" onclick="tijiao1()" value="调整权限" />    				
    				</c:if>
    				<c:if test="${selfqueren==1}">
						<input type="button" onclick="tijiao2()" value="确   认" />    				
    				</c:if>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
