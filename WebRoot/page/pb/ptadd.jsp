<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>acceptance_data</title>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
	</head>
	<body>
		<form action="<%=path%>/ptadd.action" method="post">
			<div class="layout">
				<div class="title">
					特殊人员新增（<b style="color:red">*</b>为必填项）
				</div>

				<div id="content">

					<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>姓名:
						</div>
						<div class="four_columns_input">
						 	<input type="text" id="name" name="name" style="width:50px" maxlength="3"/>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>事项:
						</div>
						<div>
						 	<select id="item" name="item" style="width: 100px">
								<option value="buru">哺乳假</option>
							</select>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>开始时间:
						</div>
						<div>
						 	<input size=10 type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()" >
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>截止时间:
						</div>
						<div>
						 	<input size=10 type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()" >
						</div>
					<div class="clear"></div>
				</div>
				<div class="button">
						<input type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="but" value="提交" />
					</div>
				</div>
			</div>
		</form>
	</body>

</html>


