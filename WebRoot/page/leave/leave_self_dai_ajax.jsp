<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
${sex}|
${birthdate}|
${workdate}|
${ccbdate}|
${workyears}|
${chu}|
${tuan}|
${newnumber}|

<c:if test="${lastyear.bingleave>0.0}"> 病假：${lastyear.bingleave }天<br></c:if>
<c:if test="${lastyear.yearleave>0.0}">年休假：${lastyear.yearleave}天<br></c:if>
<c:if test="${lastyear.chanleave>0.0}">产（陪护）假：${lastyear.chanleave }天<br></c:if>
<c:if test="${lastyear.shangleave>0.0}">工伤假：${lastyear.shangleave }天<br></c:if>
<c:if test="${lastyear.hunleave>0.0}">婚假：${lastyear.hunleave }天<br></c:if>
<c:if test="${lastyear.workleave>0.0}">加班调休：${lastyear.workleave }天<br></c:if>
<c:if test="${lastyear.sangleave>0.0}">丧假：${lastyear.sangleave }天<br></c:if>
<c:if test="${lastyear.tanfmleave>0.0}">探亲假（父母）：${lastyear.tanfmleave }天<br></c:if>
<c:if test="${lastyear.gongleave>0.0}">公假：${lastyear.gongleave }天<br></c:if>
<c:if test="${lastyear.tanpoleave>0.0}">探亲假（配偶）：${lastyear.tanpoleave }天<br></c:if>
<c:if test="${lastyear.shileave>0.0}">事假：${lastyear.shileave }天<br></c:if>
<c:if test="${lastyear.qitaleave>0.0}">产检：${lastyear.qitaleave }天<br></c:if>
<c:if test="${lastyear.peikaoleave>0.0}">陪考假：${lastyear.peikaoleave }天<br></c:if>
<c:if test="${lastyear.buruleave>0.0}">哺乳假：${lastyear.buruleave }天（每天1小时）</c:if>&nbsp;|


<c:if test="${thisyear.bingleave>0.0}"> 病假：${thisyear.bingleave }天<br></c:if>
<c:if test="${thisyear.yearleave>0.0}">年休假：${thisyear.yearleave}天<br></c:if>
<c:if test="${thisyear.chanleave>0.0}">产（陪护）假：${thisyear.chanleave }天<br></c:if>
<c:if test="${thisyear.shangleave>0.0}">工伤假：${thisyear.shangleave }天<br></c:if>
<c:if test="${thisyear.hunleave>0.0}">婚假：${thisyear.hunleave }天<br></c:if>
<c:if test="${thisyear.workleave>0.0}">加班调休：${thisyear.workleave }天<br></c:if>
<c:if test="${thisyear.sangleave>0.0}">丧假：${thisyear.sangleave }天<br></c:if>
<c:if test="${thisyear.tanfmleave>0.0}">探亲假（父母）：${thisyear.tanfmleave }天<br></c:if>
<c:if test="${thisyear.gongleave>0.0}">公假：${thisyear.gongleave }天<br></c:if>
<c:if test="${thisyear.tanpoleave>0.0}">探亲假（配偶）：${thisyear.tanpoleave }天<br></c:if>
<c:if test="${thisyear.shileave>0.0}">事假：${thisyear.shileave }天<br></c:if>
<c:if test="${thisyear.qitaleave>0.0}">产检：${thisyear.qitaleave }天<br></c:if>
<c:if test="${thisyear.peikaoleave>0.0}">陪考假：${thisyear.peikaoleave }天<br></c:if>
<c:if test="${thisyear.buruleave>0.0}">哺乳假：${thisyear.buruleave }天（每天1小时）</c:if>&nbsp;|
${bossname}|${yearrest}|${jbsprestdays}|${chanrestdays}|${tanporestdays}|${tanfmrestdays}|
${yearcishu}

