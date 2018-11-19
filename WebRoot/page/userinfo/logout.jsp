<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.removeAttribute("islogin"); 
	session.removeAttribute("username"); 
	session.removeAttribute("position"); 
	session.removeAttribute("permission"); 
	session.removeAttribute("no"); 
	session.removeAttribute("name"); 
	session.invalidate(); 
	%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="1; url=<%=path%>/index2.jsp">
<title>???????</title>
</head>
<body>
<p>跳转中</p>
</body>
</html>