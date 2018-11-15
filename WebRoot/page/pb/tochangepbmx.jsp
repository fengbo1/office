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
		<form action="<%=path%>/changepbmx.action" method="post">
			<div class="layout">
				<div class="title">
					修改排班明细信息
				</div>

				<div id="content">

					<div class="four_columns">
						<div class="four_columns_text">
							姓名:
						</div>
						<div class="four_columns_input">
						 	${pm.name}
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							日期:
						</div>
						<div>
						 	${pm.date}
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							上班时间:
						</div>
						<div>
						 	<input type="text" name="sbtime" value="${pm.pbqdtime}"/>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							下班时间:
						</div>
						<div>
						 	<input type="text" name="xbtime" value="${pm.pbqttime}"/>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							作业时间:
						</div>
						<div>
						 	<input type="text" name="zytime" value="${pm.zytime}"/>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							晚班情况:
						</div>
						<div>
							<c:if test="${pm.wb==6}">正常班1</c:if>
										<c:if test="${pm.wb==7}">正常班2</c:if>
										<c:if test="${pm.wb==8}">正常班3</c:if>
										<c:if test="${pm.wb==3}">早班</c:if>
										<c:if test="${pm.wb==1}">小晚班</c:if>
										<c:if test="${pm.wb==2}">大晚班</c:if>
										<c:if test="${pm.wb==4}">监控</c:if>
										<c:if test="${pm.wb==5}">试点</c:if>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							修改晚班:
						</div>
						<div>
						 	<select id="wb" name="wb" style="width: 100px">
						 		<option value="6">正常班1</option>
								<option value="7">正常班2</option>
								<option value="8">正常班3</option>
								<option value="3">早班</option>
								<option value="1">小晚班</option>
								<option value="2">大晚班</option>
								<option value="4">监控</option>
								<option value="5">试点</option>
								<option value="-1">仅修改时间</option>
							</select>
						</div>
					<div class="clear"></div>
				</div>
					<div class="button">
						<input type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="hidden" name="id" value="${pm.id}"/>
						<input type="hidden" name="opname" value="${username}"/>
						<input type="submit" class="but" value="修改" />
					</div>
				</div>
			</div>
		</form>
	</body>

</html>


