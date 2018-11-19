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
<title>导入图片</title>
</head>
<body>
	<div class="layout">
		<form name="filename" method="post" action="importpic.action"
			enctype="multipart/form-data">
			<div class="title">导入初始化数据</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						<p style="color:red"></p>
					</div>
					<div class="four_columns_text"></div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_input">
					 <input type="submit" name="submit"value="上传">	
					 </div>
					 <div class="four_columns_input"></div>
					<div class="clear"></div>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>