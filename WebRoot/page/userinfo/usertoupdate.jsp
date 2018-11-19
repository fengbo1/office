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
		<script type="text/javascript">
		$(document).ready(function(){
		var x=document.getElementsByName("para");
		$('#chu').attr('value',x[0].value);
		$('#tuan').attr('value',x[1].value);
		$('#zhi').attr('value',x[2].value);
		}); 
</script>	
	</head>
	<body>
		<form action="<%=path%>/userupdate.action" method="post">
			<div class="layout">
				<div class="title">
					员工信息修改
				</div>

				<div id="content">

					<div class="four_columns">
						<div class="four_columns_text">
							用户名:
						</div>
						<div class="four_columns_input">
						 	<input type="text" id="username"  name="username" value="${ui.username}"/>  
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							密码:
						</div>
						<div class="four_columns_input">
						 	<input type="text" id="password"  name="password" value="${ui.password}"/>  
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
							处室团队:
					</div>
					<div class="four_columns_input">
						<select id="zhi" name="zhi" style="width: 120px">
										<option value="3">普通员工</option>
										<option value="2">团队负责人</option>
										<option value="1">处室负责人</option>
										<option value="4">组长</option>
						</select>
						<select id="chu" name="chu" style="width: 120px">
										<option value="1">综合与生产管理处</option>
										<option value="2">合规与监督二处</option>
										<option value="3">通用业务二处</option>
										<option value="5">研发支持二处</option>
										<option value="6">专业处理二处</option>
						</select>
						<select id="tuan" name="tuan" style="width: 120px">
										<option value="0">无分组</option>
										<option value="1">1组/综合/稽核</option>
										<option value="2">2组/人力/反洗钱</option>
										<option value="3">3组/生产/柜面</option>
										<option value="4">4组</option>
										<option value="5">5组</option>
										<option value="6">6组</option>
										<option value="7">7组</option>
						</select>
						
					</div>
					<input type="hidden" name="para" value="${chu}"/>
					<input type="hidden" name="para" value="${tuan}"/>
					<input type="hidden" name="para" value="${zhi}"/>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							身份证号:
					</div>
					<div class="four_columns_input">
						<input type="text" id="identity"  name="identity" value="${ui.identity}"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							参加工作时间:
					</div>
					<div class="four_columns_input">
						<input size=10 type="text" name="workdate" id="workdate" class="Wdate" value="${ui.workdate}" onClick="WdatePicker()" >
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							来行时间:
					</div>
					<div class="four_columns_input">
						<input size=10 type="text" name="ccbdate" id="ccbdate" class="Wdate" value="${ui.ccbdate}" onClick="WdatePicker()" >
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							来中心时间:
					</div>
					<div class="four_columns_input">
						<input size=10 type="text" name="zxdate" id="zxdate" class="Wdate" value="${ui.zxdate}" onClick="WdatePicker()" >
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							工作年限:
					</div>
					<div class="four_columns_input">
						<input type="text" id="workyears"  name="workyears" value="${ui.workyears}"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							护照编号:
					</div>
					<div class="four_columns_input">
						<input type="text" id="passport"  name="passport" value="${ui.passport}"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							港澳通行证编号:
					</div>
					<div class="four_columns_input">
						<input type="text" id="hkpassport"  name="hkpassport" value="${ui.hkpassport}"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							台湾通行证编号:
					</div>
					<div class="four_columns_input">
						<input type="text" id="twpassport"  name="twpassport" value="${ui.twpassport}"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							890角色:
					</div>
					<div class="four_columns_input">
						<input type="text" id="role890" style="width:400px"  name="role890" value="${ui.role890}"/>  
						状态：<input type="text" id="status890" style="width:50px"  name="status890" value="${ui.status890}"/>  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							891角色:
					</div>
					<div class="four_columns_input">
						<input type="text" id="role891" style="width:400px"  name="role891" value="${ui.role891}"/>  
						状态：<input type="text" id="status891" style="width:50px"  name="status891" value="${ui.status891}"/>
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
						<input type="hidden" name="id" value="${ui.id}" />
						<input type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="but" value="提交" />
					</div>
				</div>
			</div>
		</form>
	</body>

</html>


