
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>无标题页</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
#menuTree A {
	COLOR: #566984; TEXT-DECORATION: none
}


</STYLE>
<script language="javascript"> 
 function office()
 {
    window.parent.location = "/office/login.action?username="+parent.username;
   
 }
 
  function work()
 {
    window.parent.location = "http://172.20.10.12:8080/work/login.action?username="+parent.username;
    
 }
 
  function securtiy()
 {
    window.parent.location = "/office/login.action?username="+parent.username;
    
 }
 
  function per()
 {
     window.parent.location = "/office/login.action?username="+parent.username;
   
 }
</script> 
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg2.gif); BACKGROUND-REPEAT: repeat-x">
  <DIV style="FONT-SIZE: 28px; BACKGROUND-IMAGE: url(images/bg_banner_menu.gif); BACKGROUND-REPEAT:repeat-x;PADDING-BOTTOM: 10px;PADDING-TOP: 10px;  COLOR: white; FONT-FAMILY: system; height:46;" align="center" >主菜单</DIV>
     
  <DIV style=" BACKGROUND-IMAGE: url(images/bg_white.png); BACKGROUND-REPEAT:repeat-x; COLOR: black; FONT-FAMILY: system;height:525px" align="center">
  <br>
  <br>
  <br>
       <input type="image" onclick="office()"  src="images/bg_office.png" width="224" height="43" border=0 align=absMiddle><br>
  
  <br>
  <br>
       <input type="image" onclick="work()"  src="images/bg_work.png" width="224" height="43" border=0 align=absMiddle><br>
  <br>
  <br>
       <input type="image" onclick="security()"  src="images/bg_security.png" width="224" height="43" border=0 align=absMiddle><br>
   <br>
  <br>
       <input type="image"   src="images/bg_per.png" width="224" height="43" border=0 align=absMiddle><br>
  </DIV>
     
 
 
</BODY>
</HTML>
