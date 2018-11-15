
<%
session.removeAttribute("islogin"); 
session.removeAttribute("username"); 
session.removeAttribute("position"); 
session.removeAttribute("permission"); 
session.removeAttribute("no"); 
session.removeAttribute("group"); 
session.removeAttribute("name"); 
session.invalidate();  
String IP=request.getRemoteAddr();
System.out.println(IP);

if(IP.startsWith("128.160.17")||IP.startsWith("128.160.18")||IP.startsWith("172.20.10")||IP.startsWith("128.168.18")||IP.startsWith("52.242")||IP.startsWith("64.244.184")||IP.startsWith("64.244.176")||IP.startsWith("64.244.178")||IP.startsWith("64.244.180")||IP.startsWith("64.244.179")||IP.equals("127.0.0.1")||IP.startsWith("192.168.43"))

{
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.getSession().setMaxInactiveInterval(7200);
//	String IP=request.getRemoteAddr();
//	session.setAttribute("IP",IP);
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../public/errorpage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>业务处理中心成都分中心生产运营管理工具</title>

<link href="css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript"> 
window.load = function(){ 
document.getElementById('pwd').value=''; 
};
if(window.top!=window.self){
top.document.location.href="<%=path%>/index2.jsp";
}
</script> 
 <script language = "javaScript" > 
     function validateLogin() 
     { 
      var sUserName = trim(document.frmLogin.username.value); 
      var sPassword = trim(document.frmLogin.password.value); 
      if(sUserName==""||sUserName==null ) 
      { 
       alert( "请输入用户名！" ); 
       return false;
      } 
      if(sPassword==""||sPassword==null ) 
      { 
       alert( "请输入密码！" ) ; 
       return false;
      } 
      return true;
     } 
     /*去除空格 */
     function trim(str){   
    	    str = str.replace(/^(\s|\u00A0)+/,'');   
    	    for(var i=str.length-1; i>=0; i--){   
    	        if(/\S/.test(str.charAt(i))){   
    	            str = str.substring(0, i+1);   
    	            break;   
    	        }   
    	    }   
    	    return str;   
    	}  
    </script> 
</head>
<body >


<div  class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
			<form name="frmLogin" method="post"  action="<%=path%>/mainlogin.action"  onsubmit="return validateLogin()">
				<div class="name">
					<label><b>用户名</b></label><input type="text" class="text" id="value_1" placeholder="用户名" name="username" tabindex="1">
				</div>
				<div class="pwd">
					<label><b>密　码<b/></label><input type="password" class="text" id="value_2" placeholder="密码" name="password" tabindex="2">
					<input type="submit" class="submit" tabindex="3" value="登录">
					<div class="check"></div>
				</div>
			</form>
				<div class="tip"></div>
			</div>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
   
</div>



<!--[if IE 6]>
<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png')</script>
<![endif]-->
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">

</div>
</body>
</html>

<%}else{%>
<html><head><title>Error report</title><style><!--H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;} H2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;} H3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;} BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;} B {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;} P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}A {color : black;}A.name {color : black;}HR {color : #525D76;}--></style> </head><body><h1>HTTP Status 404</h1><HR size="1" noshade="noshade"><p><b>type</b> Status report</p><p><b>message</b> <u>404</u></p><p><b>description</b> <u>The requested resource is not available.</u></p><HR size="1" noshade="noshade"><h3>404</h3></body></html>
<%}%>