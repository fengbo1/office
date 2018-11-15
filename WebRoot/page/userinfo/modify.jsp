<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
    /*String username = request.getParameter("username");
    username=new String(username.getBytes("ISO8859-1"),"UTF-8");*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>acceptance_data</title>
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
	</head>
	<body>
		<form action="<%=path%>/userModify.action" method="post">
			<div class="layout">
				<div class="title">
					密码修改
				</div>

				<div id="content">

					<div class="four_columns">
						<div class="four_columns_text">
							用户名:
						</div>
						<div class="four_columns_input">
						 	${username}
						 	<input type="hidden" id="username"  name="username" value="${username}"/>  
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_text">
							旧密码:
					</div>
					<div class="four_columns_input">
						<input type="password" id="passwordId"  name="oldpassword" />  
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">	
					<div class="four_columns_text">
							新密码:
					</div>
					<div class="four_columns_input">
							<input type="password" id="passwordId"  name="newpassword" />  
					</div>	
					<div class="clear"></div>
				</div>	
				<div class="four_columns">
						
					<div class="four_columns_text">
							新密码:
					</div>
					<div class="four_columns_input">
						<input type="password" id="passwordId2"  name="newpassword2" />  
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
						<input type="submit" class="but" value="提交" />
					</div>
				</div>
			</div>
		</form>
	</body>

</html>


