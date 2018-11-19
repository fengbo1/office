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
		<form action="<%=path%>/useradd.action" method="post">
			<div class="layout">
				<div class="title">
					员工信息增加
				</div>

				<div id="content">

					<div class="four_columns">
						<div class="four_columns_text">
							用户名:
						</div>
						<div class="four_columns_input">
						 	<input type="text" id="username"  name="username"/>  
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							密码:
						</div>
						<div class="four_columns_input">
						 	<input type="text" id="password"  name="password"/>  
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							新一代员工编号:
						</div>
						<div class="four_columns_input">
						 	<input type="text" id="newnumber"  name="newnumber" value="${ui.newnumber}"/>  
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							职务:
					</div>
					<div class="four_columns_input">
						<select id="zhi" name="zhi" style="width: 120px">
										<option value="3">普通员工</option>
										<option value="4">组长</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							处室团队:
					</div>
					<div class="four_columns_input">
						<select id="chutuan" name="chutuan" style="width: 120px">
										<option value="1">综合与生产管理处</option>
										<option value="2">合规与监督二处</option>
										<option value="3">通用业务二处</option>
										<option value="5">研发支持二处</option>
										<option value="6">专业处理二处</option>
										<option value="7">业务处理1组</option>
										<option value="8">业务处理2组</option>
										<option value="9">业务处理3组</option>
										<option value="10">业务处理4组</option>
										<option value="11">业务处理5组</option>
										<option value="12">专业处理1组</option>
										<option value="13">专业处理2组</option>
										<option value="14">专业处理3组</option>
						</select>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							身份证号:
					</div>
					<div class="four_columns_input">
						<input type="text" id="identity"  name="identity"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							参加工作时间:
					</div>
					<div class="four_columns_input">
						<input size=10 type="text" name="workdate" id="workdate" class="Wdate" onClick="WdatePicker()" >
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							来行时间:
					</div>
					<div class="four_columns_input">
						<input size=10 type="text" name="ccbdate" id="ccbdate" class="Wdate" onClick="WdatePicker()" >
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							来中心时间:
					</div>
					<div class="four_columns_input">
						<input size=10 type="text" name="zxdate" id="zxdate" class="Wdate" onClick="WdatePicker()" >
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							工作年限:
					</div>
					<div class="four_columns_input">
						<input type="text" id="workyears"  name="workyears"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							护照编号:
					</div>
					<div class="four_columns_input">
						<input type="text" id="passport"  name="passport"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							港澳通行证编号:
					</div>
					<div class="four_columns_input">
						<input type="text" id="hkpassport"  name="hkpassport"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							台湾通行证编号:
					</div>
					<div class="four_columns_input">
						<input type="text" id="twpassport"  name="twpassport"/>  
					</div>
					<div class="clear"></div>
				</div>
					<div class="four_columns">	
						<div class="four_columns_text"  style="color:red">
							 <s:fielderror></s:fielderror>
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


