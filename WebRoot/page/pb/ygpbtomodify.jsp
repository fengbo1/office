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
		<form action="<%=path%>/ygpbmodify.action" method="post">
			<div class="layout">
				<div class="title">
					员工响应排班计划修改（<b style="color:red">*</b>为必填项）
				</div>

				<div id="content">

					<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>计划名:
						</div>
						<div class="four_columns_input">
						 	<select id="no" name="no" style="width: 100px">
										<option value="${no}">计划${no}</option>
										<option value="${a}">计划${a}</option>
										<option value="${b}">计划${b}</option>
										<option value="${c}">计划${c}</option>
							</select>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>上班时间:
						</div>
						<div >
						 	<input type="text" id="sb1" name="sb1" value="${sb1}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						 	<input type="text" id="sb2" name="sb2" value="${sb2}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
							<b style="color:red">（请按09时00分的格式完整填写）</b>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>下班时间:
						</div>
						<div >
						 	<input type="text" id="xb1" name="xb1" value="${xb1}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						 	<input type="text" id="xb2" name="xb2" value="${xb2}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
							<b style="color:red">（请按24小时制填写）</b>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							<b style="color:red">*</b>作业时间1:
					</div>
					<div class="four_columns_input">
						<input type="text" id="zy11"  name="zy11" value="${zy11}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy12"  name="zy12" value="${zy12}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分至
						<input type="text" id="zy13"  name="zy13" value="${zy13}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy14"  name="zy14" value="${zy14}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							作业时间2:
					</div>
					<div class="four_columns_input">
						<input type="text" id="zy21"  name="zy21" value="${zy21}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy22"  name="zy22" value="${zy22}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分至
						<input type="text" id="zy23"  name="zy23" value="${zy23}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy24"  name="zy24" value="${zy24}" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
					</div>
					<div class="clear"></div>
				</div>
					<div class="button">
						<input type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="hidden" name="id" value="${id}" />
						<input type="submit" class="but" value="提交" />
					</div>
				</div>
			</div>
		</form>
	</body>

</html>


