
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script type="text/javascript">
	function tijiao()
	{
        var name = document.getElementById("name").value; 
		var type = document.getElementById("type").value; 
		var namec = encodeURI(name); 
		var typec = encodeURI(type);
		var chu = document.getElementById("chu").value; 
		var status = document.getElementById("status").value; 
		var chuc = chu;
		var statusc = status
		window.location = "<%=path%>/showsearchdetail.action?name="+namec+"&type="+typec+"&chu="+chuc+"&status="+statusc+"&isreturn=1";
	}
</script>
</head>
<body>

<b style="color:red">保存成功</b>

<input type="button" value="返回上一页" onclick="tijiao();">

                       <input type="hidden" id="name" name="name" value="${name}"/>
		                      <input type="hidden" id="type" name="type" value="${type}"/>
		                      <input type="hidden" id="chu" name="chu" value="${chu}"/>
		                      <input type="hidden" id="status" name="status" value="${status}"/>
</body>
</html>