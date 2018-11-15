<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>导入日历表</title>
</head>
<body>
${daohang}
	<div class="layout">
		<form name="filename" method="post" action="importrlb.action"
			enctype="multipart/form-data">
			<div class="title">导入日历表</div>
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
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	<div class="layout">
		<form name="filename" method="post" action="importrole.action"
			enctype="multipart/form-data">
			<div class="title">导入渠道用户权限表</div>
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
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	<br/>
	<div class="layout">
			<table border="1px">
				<tr>
					<td colspan="4" class="title">文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>日历表：</td>
					<td>年份&nbsp;+&nbsp;rlb</td>
					<td>2015rlb.xls</td>
				</tr>
			</table>
	</div>
	
	<div class="layout">
		<input align="right" name="logout" type="button" value="算下线汇总" onclick="location='<%=path%>/processYgxxHzAll.action'" />
	</div>
</body>
</html>