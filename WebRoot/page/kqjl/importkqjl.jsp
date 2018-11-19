<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<script language="javascript" type="text/javascript" src="<%=path%>/js/DatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
 $(document).ready(function(){ 
	 var x=document.getElementsByName("para");
	 $('#month').attr('value',x[0].value);
	 });
 </script>
<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>数据导入</title>
</head>
<body>
<div class="layout">
		<div class="title">${ku.month}月已导入情况</div>
			<div id="content" >
				<div class="four_columns">
						 <c:if test="${ku.scpb==1}">	
						 	<div class="four_columns_input">
						 	集中生产排班表
						 	</div>
						 </c:if>
						 <c:if test="${ku.xypb==1}">
						  <div class="four_columns_input">	
						 	员工响应排班表
						 	</div>
						 </c:if>
						 <c:if test="${ku.zwjl==1}">
						 	 <div class="four_columns_input">	
						 	考勤指纹记录
						 	</div>
						 </c:if>
					<div class="clear"></div>
				</div>
			</div>
	</div>
	<br/>
	<div class="layout">
		<form name="filename" method="post" action="importkqjl.action"
			enctype="multipart/form-data">
			<div class="title">排班执行表导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
					</div>
					<div class="four_columns_input" align="right">
						<a href="<%=path%>/templet/paibanbiao.xls">下载【排班表】模板</a>
					</div>
				</div>
			</div>
		</form>
		<table border="1px">
				<tr>
					<td colspan="4" class="title">提示：文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>生产人员排班表：</td>
					<td>月份&nbsp;+&nbsp;scry</td>
					<td>201510scry.xls</td>
					<td rowspan="3">生产人员排班表和员工响应排班表一定要先于考勤记录表导入</td>
				</tr>
				<tr>
					<td>员工响应排班表：</td>
					<td>月份&nbsp;+&nbsp;ygxy</td>
					<td>201510ygxy.xls</td>
				</tr>
			</table>
	</div>
	<br/>
	<div class="layout">
		<form name="filename" method="post" action="importxiaxian.action"
			enctype="multipart/form-data">
			<div class="title">产量下线或组长下线表导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
					</div>
					<div class="four_columns_input" align="right">
						<a href="<%=path%>/templet/xiaxian.xls">下载【产量/组长下线】模板</a>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	<br/>
<c:if test="${authoI=='I'}">
	<div class="layout">
		<form name="filename" method="post" action="importkqjl.action"
			enctype="multipart/form-data">
			<div class="title">考勤指纹记录导入</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="上传">
					</div>
					<div class="four_columns_text"><p style="color:red">（请另存为excel2003格式后上传）</p></div>
				</div>
			</div>
		</form>
		<table border="1px">
				<tr>
					<td colspan="4" class="title">提示：文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>考勤记录表：</td>
					<td>月份&nbsp;+&nbsp;kqjl</td>
					<td>201510kqjl.xls</td>
				</tr>
			</table>
	</div>
	<br/>
	
	<div class="layout">
			<form name="filename" method="post" action="processkqjldaily.action"
			enctype="multipart/form-data">
			<div class="title">考勤记录明细表生成与导出</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_input">
						 <select name="year">
						 	<option value="${year1}">${year1}</option>
						 	<option value="${year2}">${year2}</option>
						 </select>年
						  <select id="month" name="month">
						 	<option value="01">1</option>
						 	<option value="02">2</option>
						 	<option value="03">3</option>
						 	<option value="04">4</option>
						 	<option value="05">5</option>
						 	<option value="06">6</option>
						 	<option value="07">7</option>
						 	<option value="08">8</option>
						 	<option value="09">9</option>
						 	<option value="10">10</option>
						 	<option value="11">11</option>
						 	<option value="12">12</option>
						 </select>月
						 <input type="hidden" name="para" value="${month}"/>
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="生成">
					</div>
					 <input style="width:120px" type="button" onclick="location='<%=path%>/kqqsdis.action'" value="办结上月考勤缺失">
						 （提示：生成明细表后触发）
				</div>
			</div>
		</form>
	</div>
	<div class="layout">
			<form name="filename" method="post" action="exportkqjlmonthhz.action"
			enctype="multipart/form-data">
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_input">
						 <select name="year">
						 	<option value="${year1}">${year1}</option>
						 	<option value="${year2}">${year2}</option>
						 </select>年
						  <select id="month" name="month">
						 	<option value="01">1</option>
						 	<option value="02">2</option>
						 	<option value="03">3</option>
						 	<option value="04">4</option>
						 	<option value="05">5</option>
						 	<option value="06">6</option>
						 	<option value="07">7</option>
						 	<option value="08">8</option>
						 	<option value="09">9</option>
						 	<option value="10">10</option>
						 	<option value="11">11</option>
						 	<option value="12">12</option>
						 </select>月
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="导出">
					</div>
					<div class="four_columns_input">
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	</c:if>
	
	<!--  
	<div class="layout">
			<form name="filename" method="post" action="exportkqjl.action"
			enctype="multipart/form-data">
			<div class="title">导出</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_input">
						 <select name="year">
						 	<option value="${year1}">${year1}</option>
						 	<option value="${year2}">${year2}</option>
						 </select>年
						  <select name="month">
						 	<option value="01">1</option>
						 	<option value="02">2</option>
						 	<option value="03">3</option>
						 	<option value="04">4</option>
						 	<option value="05">5</option>
						 	<option value="06">6</option>
						 	<option value="07">7</option>
						 	<option value="08">8</option>
						 	<option value="09">9</option>
						 	<option value="10">10</option>
						 	<option value="11">11</option>
						 	<option value="12">12</option>
						 </select>月
					</div>
					<div class="four_columns_input">
						 <input type="radio" name="type" value="daily" checked/>明细
					</div>
					<div class="four_columns_input">
						<input type="radio" name="type" value="month" />月报
					</div>
					<div class="four_columns_input">
						 <input type="submit" name="submit"value="导出">
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	-->
	<br/>
</body>
</html>