<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String Path = request.getParameter("Path");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'derivedetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	<meta http-equiv="Refresh" content="1; url=<%=path%>/derive/${Path}">
	-->
	<SCRIPT language=javascript>
	function go()
	{
		window.open("<%=path%>/derive/<%=request.getParameter("Path")%>","","height=10,width=10,top=400,left=600");
		window.close();
	}
	</SCRIPT>
	
  </head>
  
  <body >
 	 <a	href="javascript:go()"><%=request.getParameter("Path")%></a>点击下载
  </body>
</html>
