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
		<form action="<%=path%>/scpbadd.action" method="post">
			<div class="layout">
				<div class="title">
					集中生产排班班次增加（<b style="color:red">*</b>为必填项）
				</div>

				<div id="content">

					<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>计划名:
						</div>
						<div class="four_columns_input">
						 	<select id="no" name="no" style="width: 100px">
										<option value="${a}">班次${a}</option>
										<option value="${b}">班次${b}</option>
										<option value="${c}">班次${c}</option>
							</select>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>上班时间:
						</div>
						<div >
						 	<input type="text" id="sb1" name="sb1" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						 	<input type="text" id="sb2" name="sb2" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
							<b style="color:red">（请按09时00分的格式完整填写）</b>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>下班时间:
						</div>
						<div >
						 	<input type="text" id="xb1" name="xb1" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						 	<input type="text" id="xb2" name="xb2" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
							<b style="color:red">（请按24小时制填写）</b>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							<b style="color:red">*</b>作业时间1:
					</div>
					<div class="four_columns_input">
						<input type="text" id="zy11"  name="zy11" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy12"  name="zy12" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分至
						<input type="text" id="zy13"  name="zy13" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy14"  name="zy14" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							作业时间2:
					</div>
					<div class="four_columns_input">
						<input type="text" id="zy21"  name="zy21" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy22"  name="zy22" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分至
						<input type="text" id="zy23"  name="zy23" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy24"  name="zy24" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							作业时间3:
					</div>
					<div class="four_columns_input">
						<input type="text" id="zy31"  name="zy31" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy32"  name="zy32" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分至
						<input type="text" id="zy33"  name="zy33" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy34"  name="zy34" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							作业时间4:
					</div>
					<div class="four_columns_input">
						<input type="text" id="zy41"  name="zy41" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy42"  name="zy42" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分至
						<input type="text" id="zy43"  name="zy43" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="zy44"  name="zy44" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							培训/自我总结时间1:
					</div>
					<div class="four_columns_input">
						<input type="text" id="px11"  name="px11" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="px12"  name="px12" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分至
						<input type="text" id="px13"  name="px13" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="px14"  name="px14" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							培训/自我总结时间2:
					</div>
					<div class="four_columns_input">
						<input type="text" id="px21"  name="px21" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="px22"  name="px22" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>分至
						<input type="text" id="px23"  name="px23" style="width:20px" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="2"/>时
						<input type="text" id="px24"  name="px24" style="width:20px"/>分
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>
						</div>
						 	<select id="type" name="type" style="width: 100px">
								<option value="6">正常班1</option>
								<option value="7">正常班2</option>
								<option value="8">正常班3</option>
								<option value="3">早班</option>
								<option value="1">小晚班</option>
								<option value="2">大晚班</option>
								<option value="4">监控</option>
								<option value="5">试点</option>
								<option value="9">试点1</option>
								<option value="10">试点2</option>
								<option value="11">试点3</option>
								<option value="12">试点4</option>
								<option value="13">试点5</option>
								
						</select>
					<div class="clear"></div>
				</div>
					<div class="button">
						<input type="hidden" name="name" value="${username}"/>
						<input type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="but" value="提交" />
					</div>
				</div>
			</div>
		</form>
	</body>

</html>


