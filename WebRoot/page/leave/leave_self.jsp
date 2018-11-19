<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=request.getSession().getAttribute("username").toString();
String yearrest=request.getAttribute("yearrest").toString();
String workrest=request.getAttribute("workrest").toString();
String nowdate=request.getAttribute("nowdate").toString();
String bossname=request.getAttribute("bossname").toString();
String yearcishu=request.getAttribute("yearcishu").toString();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <script language="javascript" type="text/javascript" src="<%=path%>/js/SpryValidatonTextField.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/SpryCollapsiblePanel.css"  />
    <title>My JSP 'leave_self.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
  .leave_self {
	width: 680px;
}
  .leave_self table tr td {
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	
	border-top-color: #000000;
	border-right-color: #000000;
	border-bottom-color: #000000;
	border-left-color: #000000;
}
  .leave_self table {
	border-top-style: double;
	border-right-style: double;
	border-bottom-style: double;
	border-left-style: double;
}
b{
	color:red;
	
}
.tip{
	color:red;
	font-size:14px;
}
  </style>
  <script type="text/javascript">
//计算请假天数
function countsumdate() {

var begindate= document.getElementById("begindate").value;
var enddate= document.getElementById("enddate").value;
inoutdate(begindate,enddate);

}
</script>
<!-- 用来反显可休假剩余天数 
  <script type="text/javascript">
 function getRadio(x){
 	
 	//年休假剩余天数
 	if(x==2){
 		xianshi.style.display="inline-block";
 	
 	}else{
 		xianshi.style.display="none"; 
 	}
 	//加班调休剩余天数
 	if(x==11){
 		xianshi2.style.display="inline-block";
 	}else{
 		xianshi2.style.display="none";
 	}
 } 
</script>-->
<!-- 补请假判断及起止时间合理性 -->
<script type="text/javascript">

function showpaiban()
{		
	with(document.forms[0]) {
		action='viewpwall.action?isdai=0';
		method="post";
		submit();
	}
}

function checkdate1(){
	var nowdate="<%=nowdate%>";
	var nowdate=nowdate.replace(/-/g,"/");
	var nowdate= new Date(nowdate);
	var begindate= document.getElementById("begindate").value;
	var begindate=begindate.replace(/-/g,"/");
	var begindate=new Date(begindate);


	if(begindate<nowdate){
		alert("根据休假开始时间判断此申请为补申请！");
		bu.style.display="inline-block";	
	}else{
		bu.style.display="none";
		
	} 
	jisuan();
}
function checkdate2(){
	var begindate= document.getElementById("begindate").value;
	var begindate=begindate.replace(/-/g,"/");
	var begindate=new Date(begindate);
	
	var enddate= document.getElementById("enddate").value;
	var enddate=enddate.replace(/-/g,"/");
	var enddate=new Date(enddate);	
	
	if(isNaN(begindate)){		
		document.getElementById("begindate").focus();
		alert("开始休假时间不可为空！");
		return;
	}
	if(begindate>enddate){
		document.getElementById("begindate").value="";
		document.getElementById("enddate").value="";
		alert("休假开始时间不能晚于休假结束时间！");
		return;
	}
jisuan();
	
}
//function change63(a){
//	var xuanze = document.getElementById("xuanze");
//	var xuanze1 = document.getElementById("xuanze1");//考勤管理员
//	if(a==63)
//	{
//		xuanze.style.display="none";
//		xuanze1.style.display="inline-block";
//	}
//	else
//	{
//		xuanze.style.display="inline-block";
//		xuanze1.style.display="none";
//	}
//}

function istip()
{
    var begindate = document.getElementById("begindate").value;
	var enddate = document.getElementById("enddate").value;
	var newnumber = document.getElementById("newnumber").value;
	var yesorno="";
	var type=0;
	var time=new Date().getTime();
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
			    if(Number(yesorno)==0)
			    {
			       document.getElementById("tip").innerHTML="计划内下线，不需经排班管理员环节";
			       document.getElementById("showbt").style.display="none";
			    }
				if(Number(yesorno)==1)
				{
				   document.getElementById("tip").innerHTML="计划外下线";
				   document.getElementById("showbt").style.display="inline";
				}
				//alert(arr[0].length);
				//alert(arr[11]);
				if(Number(yesorno)>1)
				{
				   document.getElementById("tip").innerHTML="计划外下线，一天以上请报主任同意。";
				   document.getElementById("showbt").style.display="inline";
				}
							
		}				
	} 
	
	xmlhttp.open("GET","showtip.action?newnumber="+newnumber+"&begindate="+begindate+"&enddate="+enddate+"&nowtime="+time+"&type="+type,true);

	xmlhttp.send();

}
</script>
<!-- 计算休假日期使用 -->
<script type="text/javascript">
function jisuan() {
	////////////////////////////////计算日期//////////////////
	var halfday1s=document.getElementsByName("RadioGroup1");
	var halfday2s=document.getElementsByName("RadioGroup2");
	var halfday1="false";
	var halfday2="false";
	var begindate= document.getElementById("begindate").value;
	var enddate= document.getElementById("enddate").value;
	var jbsprestdays = document.getElementById("jbsprestdays").value;
	var types=document.getElementsByName("type");
	var type="999";	
		
	for (var i=0;i<14;i++){			
		if (types[i].checked==true){
			
			type=types[i].value;
			}
	} 
	/*
	if(type=="999"){
		alert("请选择休假类型！");
		return;
	}	
	*/
	if(halfday1s[1].checked==true){
		halfday1="true";
		}
	if(halfday2s[0].checked==true){
		halfday2="true";
		}	
	
	
    inoutdate(begindate,enddate,type,halfday1,halfday2);
    if((type==1||type==3)&&jbsprestdays>0)//病假或事假
    {
		alert("有未休完的加班调休，按中心规定，应休完加班调休后再请病事假！");
    }
}
</script>
<!-- 提交时检查项目是否为空 -->
<script type="text/javascript">
function tijiao() {
	var nowdate="<%=nowdate%>";
	var nowdate=nowdate.replace(/-/g,"/");
	var nowdate= new Date(nowdate);
	var begindate= document.getElementById("begindate").value;
	var authoI= document.getElementById("authoI").value;
	var begindate=begindate.replace(/-/g,"/");
	var begindate=new Date(begindate);
	var jbsprestdays = document.getElementById("jbsprestdays").value;
	var yearrest=document.getElementById("yearrest").value;
	var yearcishu=document.getElementById("yearcishu").value;
	var enddate= document.getElementById("enddate").value;
	var enddate=enddate.replace(/-/g,"/");
	var enddate=new Date(enddate);
	var rg10=document.getElementById("RadioGroup1_0");
	var rg11=document.getElementById("RadioGroup1_1");
	var rg20=document.getElementById("RadioGroup2_0");
	var rg21=document.getElementById("RadioGroup2_1");
	var sex=document.getElementById("sex").value;
	var chanrestdays = document.getElementById("chanrestdays").value;
	var tanporestdays = document.getElementById("tanporestdays").value;
	var tanfmrestdays = document.getElementById("tanfmrestdays").value;
	var remark = document.getElementsByName("remark")[0].value;
	var types=document.getElementsByName("type");
	var sumdate=document.getElementById("sumdate");
	var zhi = document.getElementById("zhi").value;
	var message="";
	var type="999";	
	var ii=0;
	
    
	
	if(document.getElementById("zhiwu").value==""){
		alert("职务不得为空！");return;
		document.getElementById("zhiwu").focus();
		ii=ii+1;
	}
	
	for (var i=0;i<14;i++){
		if (types[i].checked==true)
			{
			type=types[i].value;
			}
	}
	if((authoI!="I")&&((begindate-nowdate)>5270400000))
	{
		alert("最多只能提前两个月提交请假审批表！");
		ii=ii+1;return;
	}
	if(!rg10.checked&&!rg11.checked)
	{
		alert("请选择上午或下午");return;
		ii=ii+1;
	}
	if(!rg20.checked&&!rg21.checked)
	{
		alert("请选择上午或下午");return;
		ii=ii+1;
	}
	if(type=="999"){
		alert("请选择休假类型！");return;
		ii=ii+1;
	}
	if(isNaN(begindate)){		
		//document.getElementById("begindate").focus();
		alert("开始休假时间不可为空！");return;
		ii=ii+1;
	}
	if(isNaN(enddate)){		
		//document.getElementById("enddate").focus();
		alert("休假结束时间不可为空！");return;
		ii=ii+1;
	}
	if(begindate>enddate){
		document.getElementById("begindate").value="";
		document.getElementById("enddate").value="";
		alert("休假开始时间不能晚于休假结束时间！");return;
	}
	
	if(document.getElementById("sumdate").value==""){
		alert("休假天数不得为空！");
		document.getElementById("sumdate").focus();
		ii=ii+1;return;

	}
		if(sumdate.value==0.0||sumdate.value==""){
		alert("请假天数不得为0天！");return;
	}
	var xuanze = document.getElementById("xuanze");
	
	var panduan= xuanze.selectedIndex;
	if((xuanze.options[panduan].value=="aaa")&&(type!=6)&&(type!=7)&&(type!=9)){
		alert("请选择下一级审批人员！！");
		//document.getElementById("xuanze").focus();
		ii=ii+1;return;
	}
	
	//休假类型与天数匹配检核是否合规
	  //病假
	if (type==1){
		if(trim(remark)=='')
		{
			alert("请在备注中填写病假情况说明！");
			ii=ii+1;return;
			}
			
	}
	  //年休假
	if (type==2){
		if(Number(sumdate.value)>yearrest){
			alert("年休假可休天数:"+yearrest+"小于拟请假天数："+sumdate.value+"\n\n假期不足。");
			document.getElementById("sumdate").value="";
			ii=ii+1;return;return;
		}
		else if(yearcishu<1){
			if(window.confirm("年休假已休满3次，可休次数:"+trim(yearcishu)+"次。请确认是否休假？")){
             }else{
                return false;
            }
		}
	}
	  //事假
	if (type==3){
		if(trim(remark)=='')
		{
			alert("请在备注栏填写请假事由！");
			ii=ii+1;return;
			}
	}
  //婚假
    if (type==4){
	if(Number(sumdate.value)>3){
		alert("婚假不得超过3日！");
		document.getElementById("sumdate").value="";
		ii=ii+1;return;
	}
	if(trim(remark)=='')
	{
		alert("请在备注栏填写结婚证领取日期！");
		ii=ii+1;return;
		}
		
}
//产假
if (type==5){
	if(trim(remark)=='')
	{
		alert("请填写备注信息！");
		ii=ii+1;return;
		}
}
//产假
if (type==5){
	if(sex=="男")
	{
		if(Number(sumdate.value)>chanrestdays){
			alert("陪护假不得超过20日，剩余可休天数"+chanrestdays+"！");
			document.getElementById("sumdate").value="";
			ii=ii+1;return;
		}
	}
	else
	{
		if(Number(sumdate.value)>chanrestdays){
			alert("产假不得超过158日，剩余可休天数"+chanrestdays+"！");
			document.getElementById("sumdate").value="";
			ii=ii+1;return;
		}
	}
}
  //探亲假（配偶）
if (type==6){
	if(Number(sumdate.value)>tanporestdays){
		alert("探亲假（探望配偶）只能请一次，且不能超过30天！");
		document.getElementById("sumdate").value="";
		ii=ii+1;return;
	}
}
  //探亲假（父母）
if (type==7){
	//alert(tanfmrestdays);
	if(Number(sumdate.value)>tanfmrestdays){
		alert("探亲假（探望父母）只能请一次，且不能超过45天！");
		document.getElementById("sumdate").value="";
		ii=ii+1;return;
	}
}
  //丧假
if (type==8){
	if(sumdate.value>5){
		alert("丧假不得超过5日！");
		document.getElementById("sumdate").value="";
		ii=ii+1;return;
	}
}
//工伤假
if (type==9){
	if(trim(remark)=='')
	{
		alert("请在备注栏填写请假事由！");
		ii=ii+1;return;
		}
}
//公假
if (type==10){
	if(trim(remark)=='')
	{
		alert("请在备注栏填写请假事由！");
		ii=ii+1;return;
		}
}
  //加班调休
if (type==11){
	if(Number(sumdate.value)>Number(jbsprestdays)){
		alert("加班调休可休天数:"+jbsprestdays+"小于拟请假天数："+sumdate.value);
		document.getElementById("sumdate").value="";
		ii=ii+1;return;
	}
}
//其他
if (type==12){
	var qita = document.getElementById("qita").value;
	if(trim(qita)=="")
	{
		alert("选择其他时请填写请假内容");
		ii=ii+1;
		return;
		}
	if(Number(sumdate.value)>1)
	{
		alert("产检天数不能大于1天");
		ii=ii+1;return;
		}
}
//陪考假
if (type==13){
	if(trim(remark)=='')
	{
		alert("请在备注栏填写请假事由！");
		ii=ii+1;return;
		}
	if(Number(sumdate.value)>3)
	{
		alert("陪考假天数不能大于3天");
		ii=ii+1;return;
		}
}
//哺乳假
if (type==14){
	if(trim(remark)=='')
	{
		alert("请在备注栏填写小孩出生日期！");
		ii=ii+1;return;
		}
}

if((Number(sumdate.value)>=5)&&(zhi!=1))
{
   message="离开中心超过5天，请按规定冻结工号！";
}
   message=message+"需所有审批流程完成后方可休假，请自行与审批人联系催办审批事项！";


	if(ii==0){
		if(type==1)
		{
			alert("注意,病假需向下一级审批人出示县级或二级乙等以上医院开具的病休证明、病历原件及复印件！");
		}
			
		if (window.confirm(message))
		{
			with(document.forms[0]) {
			//alert("需所有审批流程完成后方可休假，请自行与审批人联系催办审批事项！");
			action='subleave.action';
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

<script type="text/javascript">
function change1(){

var yesorno="";
var time=new Date().getTime();
var name=document.getElementById('name').value;
var begindate=document.getElementById('begindate').value;
var newnumber=document.getElementById('newnumber').value;
name = encodeURI(name); 
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
				//alert(arr[0].length);
				//alert(arr[11]);
				document.getElementById("xianshi").innerHTML="本年剩余可休天数："+arr[11]+"天，剩余可休次数："+arr[16]+"次）";
				document.getElementById("xianshi2").innerHTML="（剩余可休天数："+arr[12]+"）";
				document.getElementById("yearrest").value=arr[11];
				document.getElementById("jbsprestdays").value=arr[12];
				document.getElementById("yearcishu").value=arr[16];
		}				
	} 
	xmlhttp.open("GET","leave_self_dai.action?name="+name+"&newnumber="+newnumber+"&begindate="+begindate+"&nowtime="+time,true);
	xmlhttp.send();
}
</script>

<script type="text/javascript">
//传入日期返回天数
function inoutdate(begindate,enddate,type,halfday1,halfday2){
//判断传入数据的合理性起

		//alert("要开始计算了");
		//检查上下午是否勾选，没有选不计算
        var rg10=document.getElementById("RadioGroup1_0");
		var rg11=document.getElementById("RadioGroup1_1");
		var rg20=document.getElementById("RadioGroup2_0");
		var rg21=document.getElementById("RadioGroup2_1");
        if(!rg10.checked&&!rg11.checked)
		{
			return;
		}
		if(!rg20.checked&&!rg21.checked)
		{
			return;
		}
           
        //检查日期格式有没有问题，有问题不计算

//alert("要开始计算了");

        var result = begindate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
        if(result==null)
        {

           // alert("开始日期有问题，没有计算");
            return ;

            //alert("请输入正确的日期格式1111111");
            //return false;

        }
        var result2 = enddate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
        if(result2==null)
        {

           // alert("结束日期有问题，没有计算");
            return;

           // alert("请输入正确的日期格式222222222");
           // return false;

        }
        //检查类型是否勾选，没选不计算
        if(type=="999"){
		//alert("请假类型有问题，没有计算");
		return;
	}
	//检查时间前后合理性，不合理不计算
	var begindates=begindate.replace(/-/g,"/");
	var begindates=new Date(begindates);
	

	var enddates=enddate.replace(/-/g,"/");
	var enddates=new Date(enddates);	
	
	
	if(begindates>enddates){
		alert("休假开始时间不能晚于休假结束时间！");
		return;
	}






//判断传入数据的合理性止
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
			document.getElementById("sumdate").value=sumdate;
						
		}				
	} 
	var url="sumdate.action?begindate="+begindate+"&enddate="+enddate+"&type="+type+"&halfday1="+halfday1+"&halfday2="+halfday2;
	//alert("看到这个，就是已经计算天数了~~~~~~~！！！！");
	//alert("看到这个，就是计算了~~~~~~~！！！！");
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
}
</script>
<script type="text/javascript"> 
//确定审批下一人
window.onload=function(){

var bossnames="<%=bossname%>";
var arry= new Array();
arry=bossnames.split(";"); //字符分割 
var obj=document.getElementById('xuanze'); 

for (var i=0;i<arry.length;i++){	
	var brry= new Array();
	brry=arry[i].split(":");
	obj.options.add(new Option(brry[0],brry[1])); //这个兼容IE与firefox 
}
} 
</script>
  </head>
  
  <body> 
 ${daohang} 
  <div align="center" >
  <div style="width:750">  
  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心员工请假审批表</strong><strong> </strong></p>
 <!--   <p align="right" style="padding:0px;margin:0px"><strong> 编号：123456789123456</strong></p>-->
  <form action="subleave.action" method="post" name="fm1" id="form1">
  <table width="810" height="459" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td width="100"><div align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名</div></td>
      <td width="100"><div align="center">${name}</div></td>
      <td width="100"><div align="center">性&nbsp;&nbsp;&nbsp;&nbsp;别</div></td>
      <td width="100"><div align="center">${sex}<input type="hidden" id="sex" name="sex" value="${sex}"/></div></td>
      <td width="100"><div align="center">出生日期</div></td>
      <td width="100"><div align="center">${birthdate}</div></td>
      <td width="100"><div align="center">工作时间</div></td>
      <td width="100"><div align="center">${workdate}</div></td>
    </tr>
    <tr>
      <td><div align="center">处&nbsp;&nbsp;&nbsp;&nbsp;室</div></td>
      <td colspan="5"><div align="center">${chu}</div></td>
      <td><div align="center">来行时间</div></td>
      <td align="center">${ccbdate }</td>
    </tr>
    <tr>
      <td><div align="center">职&nbsp;&nbsp;&nbsp;&nbsp;务</div></td>
      <td colspan="5"><!--  <input type="text" id="zhiwu" name="zhiwu" style="padding:0px;margin:0px;">-->
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
      <td><div align="center">连续工龄</div></td>
      <td><div align="center">${workyears}年<input type="hidden" name="workyears" value="${workyears}"/></div></td>
    </tr>
    <tr>
      <td><div align="center" >拟请假<br/>类&nbsp;&nbsp;&nbsp;&nbsp;别</div></td>
      <td colspan="7" style="padding-left:10px">
      	<label><input name="type" type="radio" value="1" onclick="jisuan();alert('1.向下一级审批人出示县级或二级乙等以上医院开具的病休证明、病历原件及复印件  2.请在备注中填写病假情况说明')"/>病假&nbsp;&nbsp;<span class="tip">（请向下一级审批人出示县级或二级乙等以上医院开具的病休证明、病历原件及复印件）</span></label>
      	<br/>
      	<label><input name="type" type="radio" value="13" onclick="jisuan();"/>陪考假<span class="tip">（请向下一级审批人出示子女中、高考准考证复印件，陪考假3天，其中考前1天，考试2天）</span></label>
      	<br/>
      	<label><input name="type" type="radio" value="2" onclick="jisuan();change1();"/>年休假<span class="tip">（休假次数不应超过3次，</span> </label>
      	<span class="tip" id="xianshi">本年剩余可休天数：${yearrest }天；剩余可休次数：${yearcishu}次）</span>    
      	<br/>
      	<label><input name="type" type="radio" value="3" onclick="jisuan();alert('请在备注栏填写请假事由！')"/>事假</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       	<label><input name="type" type="radio" value="14" onclick="jisuan();"/>哺乳假</label><span class="tip">（女员工产后上班第一天到小孩满一周岁可申请哺乳假）</span>
      	<br/>
      	<label><input name="type" type="radio" value="4" onclick="jisuan();alert('1.向下一级审批人和考勤管理员出示结婚证  2.备注请填写结婚日期  3.领证一年内可休婚假')"/>婚假</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<label><input name="type" type="radio" value="10" onclick="jisuan();alert('1.在工作时间内依法参加选举等社会活动可以请公假 2.请在备注栏填写请假事由')"/>公假</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<label><input name="type" type="radio" value="11" onclick="jisuan();change1();"/>加班调休</label>&nbsp;&nbsp;
      	<span class="tip" id="xianshi2">（剩余可休天数：${jbsprestdays}）</span>
      	<br/>
      	<label><input name="type" type="radio" value="9" onclick="jisuan();"/>工伤假</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<label><input name="type" type="radio" value="12" onclick="jisuan();"/>产检</label><input size="8" type="hidden" id="qita" name="qita" value="产检"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<label><input name="type" type="radio" value="5" onclick="jisuan();"/><input type="hidden" value="${chanrestdays}" id="chanrestdays" name="chanrestdays"/>产假（或陪护假）</label>
      	<br/>
      	<label><input name="type" type="radio" value="8" onclick="jisuan();alert('仅员工父母、配偶、子女或配偶父母去世可以请丧假')"/>丧假</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<label><input name="type" type="radio" value="7" onclick="jisuan();alert('同父母分居两地，乘坐火车、汽车不能在周末休息日团聚可以请探亲假')"/><input type="hidden" value="${tanfmrestdays}" id="tanfmrestdays" name="tanfmrestdays"/>探亲假（父母）</label>&nbsp;&nbsp;&nbsp;&nbsp;
      	<label><input name="type" type="radio" value="6" onclick="gjisuan();alert('同配偶分居两地，乘坐火车、汽车不能在周末休息日团聚可以请探亲假')"/><input type="hidden" value="${tanporestdays}" id="tanporestdays" name="tanporestdays"/>探亲假（配偶）</label>
      	<br/>
     </td> </tr>    
    <tr>
      <td><div align="center">拟请假<br/>时&nbsp;&nbsp;&nbsp;&nbsp;间</div></td>
      <td colspan="7" >
     <div style="float:left;padding-top:8px;width:110px">从<input size="9" type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker();jisuan();change1()" ></div>
     
     <div style="float:left">  
     	<input type="radio" name="RadioGroup1" value="sw" id="RadioGroup1_0" onClick="jisuan()">上午<br>
        <input type="radio" name="RadioGroup1" value="xw" id="RadioGroup1_1" onClick="jisuan()">下午    
     </div>    
               
     <div style="float:left;padding-top:8px;width:120px"> 起至<input size="9" type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker();jisuan()" ></div>      
     <div style="float:left">      
     	<input type="radio" name="RadioGroup2" value="sw" id="RadioGroup2_0" onClick="jisuan()">上午<br>     
        <input type="radio" name="RadioGroup2" value="xw" id="RadioGroup2_1" onClick="jisuan()">下午 
     </div>
     <div style="float:left;padding-top:8px;width:140px"> 	
       	 止，共<input size="4" readonly="readonly" type="text" name="sumdate"  id="sumdate" onpropertychange="istip()">天
     </div>
        </td>
      </tr>
    <tr>
      <td><div align="center">上年度<br/>请&nbsp;&nbsp;&nbsp;&nbsp;假<br/>情&nbsp;&nbsp;&nbsp;&nbsp;况</div></td>
      <td colspan="3">
	  	<c:if test="${lastyear.bingleave!=0.0}"> 病假：${lastyear.bingleave }天<br></c:if>
		<c:if test="${lastyear.yearleave!=0.0}">年休假：${lastyear.yearleave}天<br></c:if>
	  	<c:if test="${lastyear.chanleave!=0.0}">产假：${lastyear.chanleave }天<br></c:if>
		<c:if test="${lastyear.shangleave!=0.0}">工伤假：${lastyear.shangleave }天<br></c:if>
	  	<c:if test="${lastyear.hunleave!=0.0}">婚假：${lastyear.hunleave }天<br></c:if>
		<c:if test="${lastyear.workleave!=0.0}">加班调休：${lastyear.workleave }天<br></c:if>
      	<c:if test="${lastyear.sangleave!=0.0}">丧假：${lastyear.sangleave }天<br></c:if>
		<c:if test="${lastyear.tanfmleave!=0.0}">探亲假（父母）：${lastyear.tanfmleave }天<br></c:if>
      	<c:if test="${lastyear.gongleave!=0.0}">公假：${lastyear.gongleave }天<br></c:if>
		<c:if test="${lastyear.tanpoleave!=0.0}">探亲假（配偶）：${lastyear.tanpoleave }天<br></c:if>
      	<c:if test="${lastyear.shileave!=0.0}">事假：${lastyear.shileave }天<br></c:if>
      	<c:if test="${lastyear.qitaleave!=0.0}">产检：${lastyear.qitaleave }天<br></c:if>
      	<c:if test="${lastyear.peikaoleave!=0.0}">陪考假：${lastyear.peikaoleave }天<br></c:if>
      	<c:if test="${lastyear.buruleave!=0.0}">哺乳假：${lastyear.buruleave }天（每天1小时）</c:if>
      	&nbsp;
	  </td>
      <td><div align="center">本年度请假情况</div></td>
      <td colspan="3">
      	<c:if test="${thisyear.bingleave!=0.0}"> 病假：${thisyear.bingleave }天<br></c:if>
		<c:if test="${thisyear.yearleave!=0.0}">年休假：${thisyear.yearleave}天<br></c:if>
	  	<c:if test="${thisyear.chanleave!=0.0}">产假：${thisyear.chanleave }天<br></c:if>
		<c:if test="${thisyear.shangleave!=0.0}">工伤假：${thisyear.shangleave }天<br></c:if>
	  	<c:if test="${thisyear.hunleave!=0.0}">婚假：${thisyear.hunleave }天<br></c:if>
		<c:if test="${thisyear.workleave!=0.0}">加班调休：${thisyear.workleave }天<br></c:if>
      	<c:if test="${thisyear.sangleave!=0.0}">丧假：${thisyear.sangleave }天<br></c:if>
		<c:if test="${thisyear.tanfmleave!=0.0}">探亲假（父母）：${thisyear.tanfmleave }天<br></c:if>
      	<c:if test="${thisyear.gongleave!=0.0}">公假：${thisyear.gongleave }天<br></c:if>
		<c:if test="${thisyear.tanpoleave!=0.0}">探亲假（配偶）：${thisyear.tanpoleave }天<br></c:if>
      	<c:if test="${thisyear.shileave!=0.0}">事假：${thisyear.shileave }天<br></c:if>
      	<c:if test="${thisyear.qitaleave!=0.0}">产检：${thisyear.qitaleave }天<br></c:if>
      	<c:if test="${thisyear.peikaoleave!=0.0}">陪考假：${thisyear.peikaoleave }天<br></c:if>
      	<c:if test="${thisyear.buruleave!=0.0}">哺乳假：${thisyear.buruleave }天（每天1小时）</c:if>
      	&nbsp;
      </td>
      
      </tr>
    <tr>
      <td><div align="center">所在处室意见</div></td>
      <td colspan="7">&nbsp;
    	</td>
      </tr>
      <tr>
      <td><div align="center">综合管理部门审核意见</div></td>
      <td colspan="7">&nbsp;
    	</td>
      </tr>
    <tr>
      <td><div align="center">审批意见</div></td>
      <td colspan="7">&nbsp;
      </td>
      </tr>
    <tr>
      <td><div align="center">销假时间</div></td>
      <td colspan="7">&nbsp;</td>
      </tr>
    <tr>
      <td><div align="center">备注</div></td>
      <td colspan="7"><input type="text" name="remark" style="width:400px"/><input id="showbt" style="width:100px;display:none" type="button" onclick="showpaiban()" value="查看排班计划表"/><br><span id = tip style="color:red"></span> </td>
      </tr>
     <tr>
     	<td><div align="center">审批人</div></td>
     	<td colspan="2">
      		<select name="xuanze" id="xuanze" style="width:210px">
        	<option value="aaa">请选择下一级审批人<b>*</b></option>
        	</select>
      	</td>
    
        <td colspan="3">&nbsp;&nbsp;</td>
        <td colspan="2">
        <input type="hidden" name="name" value="${name}"/>
        <input type="hidden" id="newnumber" name="newnumber" value="${newnumber}"/>
        <input type="hidden" id="autho" name="autho" value="${autho}"/>
        <input type="hidden" id="authoI" name="authoI" value="${authoI}"/>
        <input type="hidden" id="jbsprestdays" value="${jbsprestdays}"/>
        <input type="hidden" id="yearrest" value="${yearrest}"/>
        <input type="hidden" id="yearcishu" value="${yearcishu}"/>
        <input type="hidden" id="zhi" name="zhi" value="${zhi}"/>
        <input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
        </td>
     </tr>
    <tr> <td colspan="8">&nbsp;</td></tr>
  </table>
 
  </form>
   </div>
  </div>
 <br/>
  <br/>
   <br/>
    <br/>
</body>
</html>
