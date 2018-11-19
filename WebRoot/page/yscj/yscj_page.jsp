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

	//计算休假日期使用 -->
	
	//传入日期返回天数
/*	function inoutdate(begindate,enddate,type,halfday1,halfday2){
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
			alert("出境开始时间不能晚于出境结束时间！");
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
				document.getElementById("sumday").value=sumdate;
							
			}				
		} 
		var url="sumdate.action?begindate="+begindate+"&enddate="+enddate+"&type="+type+"&halfday1="+halfday1+"&halfday2="+halfday2;
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
	}*/
     //document.getElementById('sumday').attachEvent("onpropertychange",isworkday);
     function isworkday()
     {
   		//alert("0");
     	var isworkday="";
     	var begindate= document.getElementById("begindate").value;
		var enddate= document.getElementById("enddate").value;
        var name=document.getElementById('name').value;
        var category1=document.getElementById("category1").checked;
		var category2=document.getElementById("category2").checked;
		//var rg1=document.getElementsByName("RadioGroup1")[0].value;
		//var rg11=document.getElementById("RadioGroup1_1").value;
		//var rg2=document.getElementsByName("RadioGroup2")[0].value;
		//var rg21=document.getElementById("RadioGroup2_1").value; 
        var zhiwu=document.getElementById("zhiwu").value; 
        var tel=document.getElementById("tel").value;
        var identity=document.getElementById("identity").value; 
        var zxdate=document.getElementById("zxdate").value; 
		var sex=document.getElementById("sex").value; 
		var age=document.getElementById("age").value;
		var hukou=document.getElementsByName("hukou")[0].value; 
	    var tocountry=document.getElementsByName("tocountry")[0].value; 
	    var contactpeopletel=document.getElementById("contactpeopletel").value;
		var contactpeople=document.getElementById("contactpeople").value;
		var email=document.getElementById("email").value;
		var afterwork1=document.getElementById("afterwork1");
		var afterwork2=document.getElementById("afterwork2");
		var afterwork3=document.getElementById("afterwork3");
		var beforework1=document.getElementById("beforework1");
		var beforework2=document.getElementById("beforework2");
		var beforework3=document.getElementById("beforework3");
		var afterworkday=0;
		var beforeworkday=0;
		//var notholiday=0;
		/*if(afterwork3.checked)
		  {
			  alert("notholiday1");
			  notholiday=1;
		  }*/
		if(afterwork2.checked)
		  {
			  
			  afterworkday=1;
		  }
		if(beforework2.checked)
		  {
			  
			  beforeworkday=1;
		  }
		 /*if(beforework3.checked)
		  {
			  alert("notholiday2");
			  notholiday=2;
		  }*/
		  /* if(beforework3.checked&&afterwork3.checked)
		  {
			  alert("notholiday3");
			  notholiday=3;
		  }*/
		if(!afterwork1.checked&&!afterwork2.checked)
		{
            
			return;
		}
		if(!beforework1.checked&&!beforework2.checked)
		{
			
			return;
		}
		//var sumday=document.getElementById("sumday").value
		var message="因私占用工作日出国（境）还需同时提交请假审批表";
		var result = begindate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
        if(result==null)
        { 
            return;
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
			alert("出境开始时间不能晚于出境结束时间！");
			return ;
		}
        name = encodeURI(name); 
        zhiwu = encodeURI(zhiwu); 
        hukou = encodeURI(hukou); 
        tocountry = encodeURI(tocountry); 
        contactpeople = encodeURI(contactpeople); 
        sex = encodeURI(sex); 
        //alert("1");
        var xmlhttp;
	    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		   xmlhttp = new XMLHttpRequest();
	    }    else {// code for IE6, IE5
		  xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }	
	   // alert("2");
	    xmlhttp.onreadystatechange = function() {
	   //alert("3");
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		    alert(message);
			isworkday=xmlhttp.responseText;
			if(isworkday==1)
			{
			
			     // if (window.confirm(message)) {
					with(document.forms[0]) {
						action='viewleave.action';
						method="post";
						submit();
					}
				//}
										
			}
			else
			{
				with(document.forms[0]) {
						action='showyscjpagetj.action?newnumberapply=${newnumber}&isworkday='+isworkday;
						method="post";
						submit();
					}
			}
									
		}				
	} 
	     var url="yscjisworkday.action?begindate="+begindate+"&enddate="+enddate+"&name="+name+"&category1="+category1+"&category2="+category2+"&zhiwu="+zhiwu+"&tel="+tel+"&identity="+identity+"&zxdate="+zxdate+"&sex="+sex+"&age="+age+"&hukou="+hukou+"&tocountry="+tocountry+"&contactpeopletel="+contactpeopletel+"&contactpeople="+contactpeople+"&email="+email+"&afterworkday="+afterworkday+"&beforeworkday="+beforeworkday;
	     xmlhttp.open("GET",url,true);
	     xmlhttp.send();
	   
     }
     
     
     
	 function tijiao() {
		var begindate= document.getElementById("begindate").value;
		var enddate= document.getElementById("enddate").value;
		var begindates=begindate.replace(/-/g,"/");
		var begindates=new Date(begindates);
		var enddates=enddate.replace(/-/g,"/");
		var enddates=new Date(enddates);	 
		  
		  var zhiwu=document.getElementById("zhiwu"); 
		  var sex=document.getElementById("sex"); 
		  var sumday=document.getElementById("sumday"); 
		  var age=document.getElementById("age");
		  var hukou=document.getElementsByName("hukou")[0].value; 
		  var tocountry=document.getElementsByName("tocountry")[0].value; 
		  var rg10=document.getElementById("RadioGroup1_0");
		  var rg11=document.getElementById("RadioGroup1_1");
		  var rg20=document.getElementById("RadioGroup2_0");
		  var rg21=document.getElementById("RadioGroup2_1");
		  var reason1=document.getElementById("reason1").value;
		  var reason2=document.getElementById("reason2").value;
		  var reason3=document.getElementById("reason3").value;
		  var reason4=document.getElementById("reason4").value;
		  var tel=document.getElementById("tel").value;
		  var email=document.getElementById("email").value;
		  var contactpeopletel=document.getElementById("contactpeopletel").value;
		  var contactpeople=document.getElementById("contactpeople").value;
		  var category1=document.getElementById("category1").value;
		  var category2=document.getElementById("category2").value;
		  var passporttype1=document.getElementById("passporttype1").value;
		  var passporttype2=document.getElementById("passporttype2").value;
		  var passporttype3=document.getElementById("passporttype3").value;
		  var invitepeople1=document.getElementById("invitepeople1").value;
		  var invitepeople2=document.getElementById("invitepeople2").value;
		  var invitepeopletel1=document.getElementById("invitepeopletel1").value;
		  var invitepeopletel2=document.getElementById("invitepeopletel2").value;
		  var qitashuoming=document.getElementById("qitashuoming").value;
		  var travelagency=document.getElementById("travelagency").value;
		  var relationship1=document.getElementById("relationship1").value;
		  var relationship2=document.getElementById("relationship2").value;
		  var name=document.getElementById("name").value;
		  var chu=document.getElementById("chu").value;
		  var notholiday=document.getElementById("notholiday").value;
		  var message = "确认提交？";
          var xuanze = document.getElementById("xuanze").value;
		  if(name=="")
		  {
			  alert("请填写姓名");
			  document.getElementById("name").focus();return;
			}
		  else if(chu=="")
		  {
			  alert("请填写处室");
			  document.getElementById("chu").focus();return;
			}
		  else if(tel=="")
		  {
			  alert("请填写联系电话");
			  document.getElementById("tel").focus();return;
			}
		  else if(email=="")
		  {
			  alert("请填写联系邮箱");
			  document.getElementById("email").focus();return;
			}
		  else if(reason1.checked&&travelagency=="")
		  {
			  alert("请填写旅行社名称");
			  document.getElementById("travelagency").focus();return;
			}
		 else if(reason2.checked&&relationship1=="")
		  {
			  alert("请填写与本人关系");
			  document.getElementById("relationship1").focus();return;
			}
		 else if(reason3.checked&&relationship2=="")
		  {
			  alert("请填写与本人关系");
			  document.getElementById("relationship2").focus();return;
			}
		  else if(contactpeopletel=="")
		  {
			  alert("请填写国境内联系人联系电话");
			  document.getElementById("contactpeopletel").focus();return;
			}
		 else if(contactpeople=="")
		  {
			  alert("请填写国境内联系人");
			  document.getElementById("contactpeople").focus();return;
			}
		 else if(reason2.checked&&invitepeople1=="")
		  {
			  alert("请填写邀请人姓名");
			  document.getElementById("invitepeople1").focus();return;
			}
		 else if(reason3.checked&&invitepeople2=="")
		  {
			  alert("请填写邀请人姓名");
			  document.getElementById("invitepeople2").focus();return;
			}
		 else if((reason4.checked&&qitashuoming==""))
		  {
			  alert("请填写说明");
			  document.getElementById("qitashuoming").focus();return;
			}
		 else if(reason2.checked&&invitepeopletel1=="")
		  {
			  alert("请填写邀请人联系方式");
			  document.getElementById("invitepeopletel1").focus();return;
			}
		 else if(reason3.checked&&invitepeopletel2=="")
		  {
			  alert("请填写邀请人联系方式");
			  document.getElementById("invitepeopletel2").focus();return;
			}
		  else if(age=="")
		  {
			  alert("请填写年龄");
			  document.getElementById("age").focus();return;
			}
		else if(zhiwu=="")
		  {
			  alert("请填写职务");
			  document.getElementById("zhiwu").focus();return;
			}
		  else if(trim(hukou)=="")
		  {
			  alert("请输入户口所在地");
			}
		  else if(trim(tocountry)=="")
		  {
			  alert("请输入拟去国家或地区");
			}
		 else if(passporttype1.checked||passporttype2.checked||passporttype3.checked)
			{
				alert("请选择申请领取的护照类型");
				return;
			}
		 else if(reason1.checked||reason2.checked||reason3.checked||reason4.checked)
			{
				alert("请选择出国境事由");
				return;
			}
		 else if(category1.checked||category2.checked)
			{
				alert("请选择出国境类别");
				return;
			}
		  else if(!rg10.checked&&!rg11.checked)
			{
				alert("请选择上午或下午");
				ii=ii+1;return;
			}
		  else if(!rg20.checked&&!rg21.checked)
			{
				alert("请选择上午或下午");
				ii=ii+1;return;
			}
		  else if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
			else if(begindates>enddates)
			{
				alert("因私出境开始时间不能晚于因私出境结束时间！");
				return ;
			}
			else if(sumday.value==0.0||sumday.value=="")
			{
				alert("因私出境天数不得为0天！");
				return;
			}
			else if(isNaN(enddates))
			{
				alert("因私出境结束时间不可为空！");
				return ;
			}
			else if(isNaN(begindates))
			{
				alert("因私出境开始时间不可为空！");
				return ;
			}
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						alert("需所有审批流程完成后方可领取护照，请自行与审批人联系催办审批事项！");
						action='subyscjpage.action';
						method="post";
						submit();
					}
				}
			}
	  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
		}  
	 function paste()
     {
     	var text="(1)回国（境）后三工作日内，将出入境证件交主中心组织人事归口管理部门保管；\n(2)本人所填写表内信息属实；\n(3)出国（境）后遵守外事纪律，不做有损国家和建行荣誉、利益、安全的事；\n(4)按时回国（境），及时销假，严格履行请假、销假手续。"
        document.getElementById("chengnuo").value=text;
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
    <form action="subyscjpage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心员工因私出国（境）申请表</strong><strong> </strong></p>
      <div>&nbsp;&nbsp;&nbsp;&nbsp;申请人：<input type="hidden" id="name" name="name" value="${ui.username}"/> 
    				${ui.username} 所在处室：<input type="hidden" id="chu" name="chu" value="${fb:positiontoname(position)}"/>
    				${fb:positiontoname(position)}
                                  职务<b>*</b>：<select id="zhiwu" name="zhiwu" style="padding:0px;margin:0px;">
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
      	         </select></div> 
      	         
        <table width="1170" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="151" class="as" rowspan="3">
    				申请人基本情况<b>*</b>
    			</td>
    			<td width="72" class="as" >
    				性别<b>*</b>
    			</td>
    			<td width="72" class="as">
    				<input style="width:50px" id="sex" type="hidden" name="sex" value="${sex}"  />
    				${sex}
      	        </td>
    			<td width="121" class="as" >
    				年龄<b>*</b>
    			</td>
    			<td width="72" class="as" >
    				<input style="width:50px" id="age" type="hidden" name="age" value="${age}"  />
    				${age}
    			</td>
    			<td width="121" class="as" >
    				身份证号<b>*</b>
    			</td>
    			<td width="201" class="as" >
    				<input type="hidden" id="identity" name="identity" value="${ui.identity}"/> 
    				${ui.identity}
    			</td>
    			<td width="121" class="as" >
    				户口所在地<b>*</b>
    			</td>
    			<td width="121" class="as" >
    				<input type="text" name="hukou" id="hukou" />
    			</td>
    			</tr>
    			<tr>
    			<td class="as" rowspan="2">
    				来中心时间<b>*</b>
    				
    			</td>
    			<td colspan="2" rowspan="2">
    				<input type="hidden" id="zxdate" name="zxdate" value="${ui.zxdate}"/> 
    				${ui.zxdate}
    			</td>
    			<td width="121" class="as" rowspan="2">
    				联系电话及邮箱<b>*</b>
    			</td>
    			<td width="201" colspan="2">
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text"  />电话
    			</td>
    			<td width="121" class="as" rowspan="2">
    				国（境）内联系人及电话<b>*</b>
    			</td>
    			<td width="201">
    			    <input id="contactpeople" name="contactpeople" type="text" />姓名
    			 </td>
    			</tr>
    		<tr>
    			<td width="201" colspan="2">
    			    <input id="email" name="email" type="text"  />邮箱
    			 </td>
    			 <td width="201">
    				<input id="contactpeopletel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="contactpeopletel" type="text" />电话
    			</td>
    		</tr>
    		
    	   <tr>
    			<td class="as" rowspan="9">
    				申请事项<b>*</b>
    			</td>
    			<td class="as">
    				出国（境）类别<b>*</b>
    			</td>
    			<td class="as" colspan="4">
    				初次出国（境）<input id=category1 name=category type="radio" value="1" >
    			</td>
    			<td class="as" colspan="3">
    				再次出国（境）<input id=category2 name=category type="radio" value="2" >
    			</td>	
    			
    		</tr>
    		<tr>
    			<td class="as">
    				拟去国家或地区<b>*</b>
    			</td>
    			<td class="as">
    				<input type="text" name="tocountry"  id="tocountry"/>
    			</td>
    			<td class="as">
    				拟出国（境）总天数
    			</td>
    			<td class="as">
    			<div name="sumday"  id="sumday"  >&nbsp;&nbsp;</div>
    			<!-- <input size="12" readonly="readonly" type="text" name="sumday"  id="sumday" >-->
    			</td>
    			<td class="as">
    				拟出国（境）时间<b>*</b>
    			</td>
    			<td>
    			<input size="9" type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()" onchange="isworkday()" ><br>
     		        下班前<input id="afterwork1" name="afterwork" type="radio" value="0" onClick="isworkday()"> 下班后<input id="afterwork2" name="afterwork" type="radio" value="1" onClick="isworkday()" ><!--非工作日<input id="afterwork3" name="afterwork" type="radio" value="2" onClick="isworkday()" >-->
    			</td>
    			<td class="as">
    				拟回国（境）时间<b>*</b>
    			</td>
    			<td>
    			<input size="9" type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()" onchange="isworkday()" ><br>  				
    			上班前<input id="beforework1" name="beforework" type="radio" value="0" onClick="isworkday()"> 上班后<input id="beforework2" name="beforework" type="radio" value="1" onClick="isworkday()" ><!--  非工作日<input id="beforework3" name="beforework" type="radio" value="2" onClick="isworkday()" >-->
    			</td>
    		</tr>
    		<tr>
    		     <td class="as">
    		               申请领取的证件类型<b>*</b>
    		     </td>
    		      <td colspan="7" class="as">
    		              护照<input id="passporttype1" type="radio" name="passporttype" value="1"/>
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			   港澳通行证<input id="passporttype2" type="radio" name="passporttype" value="2"/>
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			   台湾通行证<input id="passporttype3" type="radio" name="passporttype" value="3"/>
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		      </td>
    		      
    		</tr>
    		
    		<tr>
    			<td class="as" rowspan="4">
    				出国（境）事由<b>*</b>
    			</td>
    			<td colspan="7">
    				(1)旅游<input id="reason1" type="radio" name="reason" value="1"/>
    				&nbsp;&nbsp;
    				旅行社名称：<input id="travelagency" type="text" name="travelagency"  />
    				
    			</td>
    		 </tr>
    		 <tr>
    			<td colspan="7">
    				(2)探亲<input id="reason2" type="radio" name="reason" value="2"/>
    				&nbsp;&nbsp;
    				邀请人姓名：<input id="invitepeople1" type="text" name="invitepeople1"  />
    				与本人关系：<input id="relationship1" type="text" name="relationship1"  />
    				电话：<input id="invitepeopletel1" type="text" name="invitepeopletel1" />
    			</td>
    		 </tr>
    		 <tr>
    			<td colspan="7">
    				(3)访友<input id="reason3" type="radio" name="reason" value="3"/>
    				&nbsp;&nbsp;
    				邀请人姓名：<input id="invitepeople2"  type="text" name="invitepeople2"  />
    				与本人关系：<input id="relationship2" type="text" name="relationship2"  />
    				电话：<input id="invitepeopletel2"  type="text" name="invitepeopletel2" />
    			</td>
    		 </tr>
    		<tr>
    		 <td colspan="7">
    				(4)其他<input id="reason4" type="radio" name="reason" value="4"/>
    				&nbsp;&nbsp;
    				请说明：<input id="qitashuoming" type="text" name="qitashuoming" style="width:500px"  />
    				
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				申请人承诺
    			</td>
    			<td colspan="8">
    			(1)回国（境）后三工作日内，将出入境证件交主中心组织人事归口管理部门保管；<br>
    			(2)本人所填写表内信息属实；<br>
    			(3)出国（境）后遵守外事纪律，不做有损国家和建行荣誉、利益、安全的事；<br>
    			(4)按时回国（境），及时销假，严格履行请假、销假手续。<br>
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<input style="width:70px" type="button" onclick="paste()" value="复制与粘贴"/>
    			</td>
    			 
    		</tr>
    		<tr>
    			<td class="as">
    				申请人承诺
    			</td>
    			<td colspan="8">
    			<textarea id="chengnuo" cols="72" rows="4"></textarea><br>
    			申请人：<input id="signature" type="text" name="signature"  /> &nbsp;&nbsp;&nbsp;&nbsp; ${time} 
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			
    			</td>
    			 
    		</tr>
    		<tr>
    			<td class="as">
    				所在处室意见
    			</td>
    			<td colspan="8">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				组织人事归口管理部门意见
    			</td>
    			<td colspan="8">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				所在部门分管领导意见
    			</td>
    			<td colspan="8">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				审批意见
    			</td>
    			<td colspan="8">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="8">
    				因私占用工作日出国（境）还需同时提交请假审批表
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="8">
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
    			<td colspan="8">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    	<br/><br/><br/>
    </form>
  </body>
</html>
