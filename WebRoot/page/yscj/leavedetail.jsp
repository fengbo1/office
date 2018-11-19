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
  	业务处理中心成都分中心员工请假审批表</strong>
  </p>
  <br/>
  <p align="right" style="padding:0px;margin:0px"><strong> 编号：${lp.number}</strong></p>
  <form>
  <table width="800" height="459" border="1" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td width="100"><div align="center">姓名</div></td>
      <td width="100"><div align="center">${name}</div></td>
      <td width="100"><div align="center">性别</div></td>
      <td width="100"><div align="center">${sex}</div></td>
      <td width="100"><div align="center">出生日期</div></td>
      <td width="100"><div align="center">${birthdate}</div></td>
      <td width="100"><div align="center">工作时间</div></td>
      <td width="100"><div align="center">${workdate}</div></td>
    </tr>
    <tr>
      <td><div align="center">处室</div></td>
      <td colspan="5"><div align="center">${chu}</div></td>
      <td><div align="center">来行时间</div></td>
      <td align="center">${ccbdate }</td>
    </tr>
    <tr>
      <td><div align="center">职务</div></td>
      <td colspan="5"><div align="center">${lp.zhiwu}</div></td>

      <td><div align="center">连续工龄</div></td>
      <td><div align="center">${workyears}年<input type="hidden" name="workyears" value="${workyears}"/></div></td>
    </tr>
    <tr>
      <td><div align="center" >请假类别</div></td>
      <td colspan="7">
      	<div align="center"><p style="color:red;font-size:30px">${type}</p></div>
     </td> </tr>    
    <tr>
      <td><div align="center">请假时间</div></td>
      <td colspan="7" align="center">
      	<p style="color:red;font-size:20px">${begindate}<c:if test="${lp.halfday=='0'||lp.halfday=='2'}">上午</c:if><c:if test="${lp.halfday=='1'||lp.halfday=='3'}">下午</c:if>&nbsp;至
      	${enddate}<c:if test="${lp.halfday=='2'||lp.halfday=='3'}">上午</c:if><c:if test="${lp.halfday=='0'||lp.halfday=='1'}">下午</c:if>&nbsp;，共
      	${lp.days}天</p>
      </td>
      </tr>
    <tr>
      <td><div align="center">上年度请假情况</div></td>
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
      	<c:if test="${lastyear.qitaleave!=0.0}">产检：${lastyear.qitaleave }天</c:if>
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
      	<c:if test="${thisyear.qitaleave!=0.0}">产检：${thisyear.qitaleave }天</c:if>
      </td>
      </tr>
    <tr>
      <td><div align="center">所在处室意见</div></td>
       <td colspan="7">
      <c:forEach items="${lpro}" var="pro" varStatus="status">
      <c:if test="${pro.authority!='H'&&pro.authority!='A'}"> 
      	<c:if test="${pro.authority=='D'||pro.authority=='I'}">审核人：</c:if><c:if test="${pro.authority!='D'&&pro.authority!='I'}">审批人：</c:if>${pro.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(pro.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty pro.remark}">备注：${pro.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if><c:if test="${not empty pro.role}">${pro.role}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${pro.time}<br/>
      </c:if>
      </c:forEach>
    </td>
      </tr>
    <tr>
      <td><div align="center">中心审批意见</div></td>
      <td colspan="7">
      <c:forEach items="${lpro}" var="pro" varStatus="status">
      <c:if test="${pro.authority=='H'||pro.authority=='A'}"> 
     	 审批人：${pro.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(pro.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty pro.remark}">备注：${pro.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if><c:if test="${not empty pro.role}">${pro.role}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${pro.time}<br/>
      </c:if>
      </c:forEach>
      </td>
      </tr>
    <tr>
      <td><div align="center">销假时间</div></td>
      <td colspan="7">
      <c:if test="${lp.xiaojia!=null}"> 
      	销假时间：${lp.xiaojia}&nbsp;&nbsp;&nbsp;
      </c:if>
      </td>
      </tr>
    <tr>
      <td><div align="center">备注</div></td>
      <td colspan="7"><div align="center">${lp.remark }
      </div></td>
      </tr>
     <tr>
     <td></td>
      	<td  colspan="7">
      		<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
      	</td>
     </tr>
  </table>
  </form>
   </div>
  </div>

</body>
</html>
