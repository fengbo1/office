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
if(IP.startsWith("128.160.17")||IP.startsWith("128.168.18")||IP.startsWith("52.242")||IP.startsWith("64.244.184")||IP.startsWith("64.244.176")||IP.startsWith("64.244.178")||IP.equals("127.0.0.1")||IP.startsWith("192.168.1"))
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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="cccc.css" />
<style type="text/css">.b1,.b2,.b3,.b4,.b1b,.b2b,.b3b,.b4b,.b{display:block;overflow:hidden;}

.b1,.b2,.b3,.b1b,.b2b,.b3b{height:1px;}

.b2,.b3,.b4,.b2b,.b3b,.b4b,.b{border-left:1px solid #999;border-right:1px solid #999;}

.b1,.b1b{margin:0 5px;background:#999;}

.b2,.b2b{margin:0 3px;border-width:2px;}

.b3,.b3b{margin:0 2px;}

.b4,.b4b{height:2px;margin:0 1px;}

.d1{background:#BFD3FC;}  /*定义 圆弧型背景的颜色*/

.k {height:390px;} /*定义每个圆弧形块的高度*/


.kuang{ 
border-top-width: 0px; 
border-right-width: 0px; 
border-bottom-width: 1px; 
border-left-width: 0px;
border-color: #878787; 
border-style: solid;
}
.tijiao{



}

</style>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../public/errorpage.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  <meta http-equiv="Refresh" content="0; url=../../fiona/index.jsp">-->
<script language="javascript"> 
window.load = function(){ 
document.getElementById('pwd').value=''; 
};
if(window.top!=window.self){
top.document.location.href="<%=path%>/index.jsp";
}
</script> 
<title>成都业务处理中心自助办公管理工具</title>
<body>

<div style="width:1300px; height:70px; margin-top:20px;margin-left:20px" >  <span> </span><img src="images/logo.gif" width="276" height="50"></div>



<div style="width: 865px; height: 379px; position: absolute; left: 368px; top: 152px;"><img src="images/ccb3.jpg" width="1024" height="401"></div>

<!-- 
<div style="width:700px; height:300px"></div>
 -->

<div class="left1"style="position: absolute; left: 43px; top: 149px; width: 310px; height: 188px;">



<div><b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b class="b4 d1"></b>
		   		<div class="b d1 k">
		   		<div style="width: 308px; font-family: '宋体'; text-align: center; font-size: 24px; margin-top: 10px;">自助办公管理工具</div>
                <div style="width : 308px; height: 250px; background-color: #FFF; MARGIN-TOP: 30PX; padding-top: 20px; font-family: '黑体'; font-size: 10px;">

	<form name="frmLogin" method="post"  action="<%=path%>/login.action"  onsubmit="return validateLogin()">
 		<table width="282" height="172" border="0" align="center" >
     <tr>
     <td width="88" align="right" bordercolor="#FFFFFF"><div align="center">用  户</div></td>
     <td width="170" bordercolor="#FFFFFF"><input class="kuang" size=14 type="text" name="username"></td>
   </tr>
    <tr>
     <td width="88" align="right" bordercolor="#FFFFFF"><div align="center">密  码 </div></td>
     <td width="170" bordercolor="#FFFFFF"><input class="kuang" id="pwd" type="password" size=15 autocomplete="off" name="password"></td>
   </tr>
   <tr><td colspan="2"><div style="color:red"><s:fielderror></s:fielderror></div></td></tr>
   
   <tr>
   	<td align="right" bordercolor="#FFFFFF"><input class="tijiao" type="reset" name="Reset" value="重置 "></td>
     <td colspan="2" align="center" bordercolor="#FFFFFF"><input  class="tijiao" name="submit" type="submit" id="submit" value="提交"></td>
   </tr>
 </table>
</form>
</div>
<!-- javaScript 函数 validateLogin(),用来验证用户名和密码是否为空 --> 
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
    
    
    
    			</div>
<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b class="b1b"></b>
			</div>
</div>
</body>
</html>
<%}else{%>
<html><head><title>Error report</title><style><!--H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;} H2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;} H3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;} BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;} B {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;} P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}A {color : black;}A.name {color : black;}HR {color : #525D76;}--></style> </head><body><h1>HTTP Status 404</h1><HR size="1" noshade="noshade"><p><b>type</b> Status report</p><p><b>message</b> <u>404</u></p><p><b>description</b> <u>The requested resource is not available.</u></p><HR size="1" noshade="noshade"><h3>404</h3></body></html>
<%}%>