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
<title>导入员工信息表</title>
</head>
<body>
${daohang}
	<div class="layout">
		<form name="filename" method="post" action="importuserinfo.action"
			enctype="multipart/form-data">
			<div class="title">导入员工信息表</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						<p style="color:red">（请另存为excel2003格式后上传）</p>
					</div>
					<div class="four_columns_text"></div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
				<div class="four_columns_input"></div>
				<div class="four_columns_input">
						 <input type="radio" name="type" value="fugai" />删除原表，全量覆盖
					</div>
					<div class="four_columns_input">
					 	<input type="radio" name="type" value="xinzeng" checked/>保留原表，更新新增
					</div>
					<div class="four_columns_input">
					 <input type="submit" name="submit"value="上传">	
					 </div>
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
					<td>员工信息表：</td>
					<td>ygxx.xls</td>
					<td>ygxx.xls</td>
				</tr>
			</table>
	</div>
</body>
</html>