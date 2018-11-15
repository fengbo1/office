<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <script language="javascript" type="text/javascript" src="<%=path%>/js/SpryValidationTextField.js"></script>
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
	table{
     border-collapse:collapse;
}
table td{
     empty-cells:show;
}
	</style>
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
  </style>
<script type="text/javascript">

function showpaiban()
{		
	with(document.forms[0]) {
		action='viewpwunderall.action?isdai=0';
		method="post";
		submit();
	}
}

function radioc(){
var radio=document.getElementsByName("radio");

	if (radio[0].checked==true){
		 
		document.getElementById("shenpiren").style.display="inline-block";
		//document.getElementById("xuanze").style.display="inline-block";
	}else{
		 
		document.getElementById("shenpiren").style.display="none"; 
		alert("请确认您选择的意见是【不同意】");
	} 
	}
function tijiao() {

	var type = document.getElementById("type").value;
	var status = document.getElementById("status").value;
	var radio=document.getElementsByName("radio");
	var bingzm=document.getElementsByName("bingzm");
	//var jihua=document.getElementsByName("jihua");
	var thisunder = document.getElementById("thisunder").value;
	var autho = document.getElementById("autho").value;
	var xuanze = document.getElementsByName("xuanze")[0].value;
	//var xuanze1 = document.getElementsByName("xuanze")[1].value;
	//var jihua = document.getElementsByName("jihua")[0].value;
	var message="";
	if((type=="病假")&&(radio[0].checked==true)&&(thisunder=="D"||thisunder=="B"))
	{
		message="请确认请假人是否已出示【县级或二级乙等以上医院开具的病休证明、病历原件及复印件】";
	}
	else
	{
		message="确定提交？";
	}
	if(radio[0].checked!=true&&radio[1].checked!=true)
	{
		alert("请选择审批意见");
	}
	else if((type=="病假")&&(status==9)&&bingzm[0].checked!=true&&bingzm[1].checked!=true)
	{
		alert("请选择是否已见病休证明、病历原件及复印件");
	}
	else if(xuanze=='wu'&&radio[0].checked==true)
	{
		alert("请选择下一级审批人");
	}
	//else if(autho=='CG'&&type=='年休假'&&(jihua[0].checked==false)&&(jihua[1].checked==false))
	//{
	//	alert("请选择计划内或者计划外");
	//}
	else
	{
		if (window.confirm(message)) {
			with(document.forms[0]) {
				action='shenpileave.action';
				method="post";
				submit();
			}
		}
	}
}
//function xiugaijihua(a)
//{
//	if(a==1)
//	{
//		document.getElementById("xuanze").style.display="none";
//		document.getElementById("xuanze1").style.display="inline-block";
//		}
//	else
//	{
//		document.getElementById("xuanze").style.display="inline-block";
//		document.getElementById("xuanze1").style.display="none";
//		}
//}
</script>

  </head>
  
  <body>
  ${daohang}
  <div align="center" >
  <div style="width:730">  
   <p align="center" style="padding:0px;margin:0px; font-size: 24px;">
  <strong><font style="color:red;">
  	<c:if test="${dai=='1'}"> 
  	(代)
  	</c:if>
  	<c:if test="${bu=='1'}"> 
  	(补)
  	</c:if></font>
  	业务处理中心员工请假审批表</strong>
  </p>
  <br/>
  <p align="right" style="padding:0px;margin:0px"><strong> 编号：${lp.number}</strong></p>
  <form  action="shenpileave.action" method="post" name="fm1" id="form1">
  <table width="800" height="459" border="1" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td width="100"><div align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;名</div></td>
      <td width="100"><div align="center">${name}</div></td>
      <td width="100"><div align="center">性&nbsp;&nbsp;&nbsp;&nbsp;别</div></td>
      <td width="100"><div align="center">${sex}</div></td>
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
      <td colspan="5"><div align="center">${lp.zhiwu}</div></td>

      <td><div align="center">连续工龄</div></td>
      <td><div align="center">${workyears}年<input type="hidden" name="workyears" value="${workyears}"/></div></td>
    </tr>
    <tr>
      <td><div align="center" >拟请假<br/>类&nbsp;&nbsp;&nbsp;&nbsp;别</div></td>
      <td colspan="7" style="padding-left:20px">
      	<div align="center"><p style="color:red;font-size:30px">${type}</p><input type="hidden" id="type" name="type" value="${type}"/></div>
     </td> </tr>    
    <tr>
      <td><div align="center">拟请假<br/>时&nbsp;&nbsp;&nbsp;&nbsp;间</div></td>
      <td colspan="7" align="center">
      	<p style="color:red;font-size:20px">${begindate}<c:if test="${lp.halfday=='0'||lp.halfday=='2'}">上午</c:if><c:if test="${lp.halfday=='1'||lp.halfday=='3'}">下午</c:if>&nbsp;至
      	${enddate}<c:if test="${lp.halfday=='2'||lp.halfday=='3'}">上午</c:if><c:if test="${lp.halfday=='0'||lp.halfday=='1'}">下午</c:if>&nbsp;，共
      	${lp.days}天</p>
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
      <td><div align="center">所&nbsp;&nbsp;&nbsp;&nbsp;在<br/>处&nbsp;&nbsp;&nbsp;&nbsp;室<br/>意&nbsp;&nbsp;&nbsp;&nbsp;见</div></td>
      <td colspan="7">
      <b style="color:red;font-size:16px;font-weight:bold;">请假申请日期：${lp.date}</b>
      <c:forEach items="${lpro}" var="pro" varStatus="status">
      <c:if test="${pro.authority!='H'&&pro.authority!='A'&&pro.authority!='T'}">
       <b style="color:red;font-size:16px;font-weight:bold;">${yearcs}${youjbtx}</b><br/>
      	 审核人：${pro.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(pro.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty pro.remark}">备注：${pro.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if><c:if test="${not empty pro.role}">${pro.role}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审核时间：${pro.time}<br/>
      </c:if>
      </c:forEach>
      <c:if test="${thisunder=='D'||thisunder=='B'}"> 
       <b style="color:red;font-size:16px;font-weight:bold;">${yearcs}${youjbtx}</b><br/>
      	<input type="radio" name="radio" value="agree" onclick="radioc()">
        	同意<!--<c:if test="${lp.type==1&&lp.status==9}">并已见病休证明</c:if> --> 
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <input type="radio" name="radio" value="disagree" onclick="radioc()">
        	不同意
     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield"><br>
     	 <c:if test="${lp.type==1}"> 
     			<input type="radio" id="bingzmyes" name="bingzm" value="yes">已见病休证明、病历原件及复印件&nbsp;&nbsp;&nbsp;&nbsp;
     			<input type="radio" id="bingzmno" name="bingzm" value="no">未见病休证明、病历原件及复印件
     	</c:if> 
     	</c:if>
    </td>
      </tr>
       <tr>
      <td><div align="center">综合管理<br/>部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门<br/>审核意见</div></td>
      <td colspan="7">
      <c:forEach items="${lpro}" var="pro" varStatus="status">
      <c:if test="${pro.authority=='H'||pro.authority=='T'}">
      <b style="color:red;font-size:16px;font-weight:bold;">${yearcs}${youjbtx}</b><br/>
      	 审核人：${pro.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(pro.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty pro.remark}">备注：${pro.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if><c:if test="${not empty pro.role}">${pro.role}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审核时间：${pro.time}<br/>
      </c:if>
      </c:forEach>
      <c:if test="${thisunder=='H'||thisunder=='T'}"> 
       <b style="color:red;font-size:16px;font-weight:bold;">${yearcs}${youjbtx}</b><br/>
      	<input type="radio" name="radio" value="agree" onclick="radioc()">
        	同意  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <input type="radio" name="radio" value="disagree" onclick="radioc()">
        	不同意
     	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield"><br>
     	<c:if test="${lp.type==1&&lp.status==9}"> 
     			<input type="radio" id="bingzmyes" name="bingzm" value="yes">已见病休证明、病历原件及复印件&nbsp;&nbsp;&nbsp;&nbsp;
     			<input type="radio" id="bingzmno" name="bingzm" value="no">未见病休证明、病历原件及复印件
     	</c:if>
     	</c:if>
    </td>
      </tr>
    <tr>
      <td><div align="center">审&nbsp;&nbsp;&nbsp;&nbsp;批<br/>意&nbsp;&nbsp;&nbsp;&nbsp;见</div></td>
      <td colspan="7">
       <c:forEach items="${lpro}" var="pro" varStatus="status">
      <c:if test="${pro.authority=='A'}"> 
       <b style="color:red;font-size:16px;font-weight:bold;">${yearcs}${youjbtx}</b><br/>
     	 审批人：${pro.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(pro.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty pro.remark}">备注：${pro.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if><c:if test="${not empty pro.role}">${pro.role}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${pro.time}<br/>
      </c:if>
      </c:forEach>
     	<c:if test="${thisunder=='A'}"> 
     	 <b style="color:red;font-size:16px;font-weight:bold;">${yearcs}${youjbtx}</b><br/>
     	 <input type="radio" name="radio" value="agree" onclick="radioc()">
        	同意
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        <input type="radio" name="radio" value="disagree" onclick="radioc()">
        	不同意
     	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield" >
     	 <c:if test="${lp.type==1&&lp.status==9}"> 
     			<input type="radio" id="bingzmyes" name="bingzm" value="yes">已见病休证明、病历原件及复印件&nbsp;&nbsp;&nbsp;&nbsp;
     			<input type="radio" id="bingzmno" name="bingzm" value="no">未见病休证明、病历原件及复印件
     	</c:if>
     	 </c:if>
     	
      </td>
      </tr>
    <tr>
      <td><div align="center">销&nbsp;&nbsp;&nbsp;&nbsp;假<br/>时&nbsp;&nbsp;&nbsp;&nbsp;间</div></td>
      <td colspan="7">&nbsp;</td>
      </tr>
    <tr>
      <td><div align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注</div></td>
      <td colspan="7"><div align="center">${lp.remark }</div>
      <span id = tip style="color:red" ><c:if test="${isshow==0}">计划内下线，不需经排班管理员环节 </c:if><c:if test="${isshow==1}">计划外下线&nbsp;&nbsp;&nbsp;&nbsp; <input style="width:100px" type="button" onclick="showpaiban()" value="查看排班计划表"/> </c:if><c:if test="${isshow>1}">计划外下线，一天以上请报主任同意。&nbsp;&nbsp;&nbsp;&nbsp;<input style="width:100px" type="button" onclick="showpaiban()" value="查看排班计划表"/></c:if></span></td>
      </tr>
     <tr>
     <td align="center">审批人
      	</td>
      	<td colspan="5">
      	<div id="shenpiren">
      	
      	<c:if test="${status!='6'&&status!='4'}"> 
      	
      		<c:if test="${youwushenpi==1}"> 
      		<select style="width:210px" name="xuanze" id="xuanze">
      		<option value="wu">请选择下一级审批人</option>
        	<c:forEach items="${list}" var="user" varStatus="status">
        		<option value="${user.newnumber}">${user.username}</option>
        	</c:forEach>
        	</select>
        	</c:if>
        	<c:if test="${youwushenpi!=1}">
        		<input type="hidden" name="xuanze" value="">
        	</c:if> 
        	
        </c:if>
        </div>&nbsp;
        </td>
        <td colspan="2">	
            <input type="hidden" name="number" value="${lp.number}"/>
      		
      		<input type="hidden" id="thisunder" name="thisunder" value="${thisunder}"/>
      		<input type="hidden" id="status" name="status" value="${lp.status}"/>
      		<input type="hidden" name="thisnewnumber" value="${thisnewnumber}"/>
      		<input type="hidden" name="newnumber" value="${newnumber}"/>
      		<input type="hidden" name="thisundername" value="${username}"/>
      	    <input type="hidden" name="name" value="${name}"/>
      		<input type="hidden" name="autho" id="autho" value="${autho}"/>
      		<c:if test="${status!='4'}"> 
      		<input  type="button" onclick="tijiao()"  value="提  交" />
      		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		</c:if>
      		<c:if test="${status=='4'}"> 
      		<input type="button" onclick="location='<%=path%>/updatestatus.action?type=3&number=${lp.number}'" value="撤  销" />
      		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		</c:if>
      		<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
      	</td>
     </tr>
      <tr>
      <td></td>
      <td colspan="7"></td>
      </tr>
  </table>
  </form>
   </div>
  </div>

</body>
</html>
