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
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>
<style type="text/css">
a:link,a:visited{
 text-decoration:none; 
 color:white;  /*超链接无下划线*/
}
a:hover{
 color:red;
}

}
</style>
<script language="javascript"> 
 function office()
 {
    window.parent.location = "/office/login.action?username="+parent.username;
   
 }
 
  function work()
 {//http://64.244.178.53/work/login.action
    window.parent.location = "/work/login.action?username="+parent.username;
    
 }
 
  function security1()
 {
    window.parent.location = "/security/login.action?username="+parent.username;
    
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


<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR 
  style="BACKGROUND-IMAGE: url(images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" 
  height=48px>
      
	   <TD  width=28% align="center" ><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN><SPAN 
      style="PADDING-RIGHT: 20px; PADDING-LEFT: 20px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 12px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 48px; TEXT-ALIGN: center; font-size:20px " >欢迎访问生产运营管理工具：</SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN></TD>
        <TD class="clickchange4" width=18% align="center"><SPAN class="clickchange1"
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN><SPAN class="clickchange2"
      style="PADDING-RIGHT: 40px; PADDING-LEFT: 40px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 12px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 48px; TEXT-ALIGN: center; font-size:20px;" onclick="office()" ><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;自助办公&nbsp;&nbsp;&nbsp;&nbsp;</a></SPAN><SPAN class="clickchange3"
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2-back.gif); WIDTH: 22px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN></TD>
        <TD class="clickchange4" width=18% align="center"><SPAN class="clickchange1"
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN><SPAN class="clickchange2"
      style="PADDING-RIGHT: 40px; PADDING-LEFT: 40px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 12px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 48px;TEXT-ALIGN: center; font-size:20px;" onclick="work()"><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;生产信息&nbsp;&nbsp;&nbsp;&nbsp;</a></SPAN><SPAN class="clickchange3"
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2-back.gif); WIDTH:22px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN></TD>
	   <TD class="clickchange4" width=18% align="center"><SPAN class="clickchange1"
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN><SPAN class="clickchange2"
      style="PADDING-RIGHT: 40px; PADDING-LEFT: 40px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 12px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 48px; TEXT-ALIGN: center; font-size:20px; " onclick="security1()"><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;安全管理&nbsp;&nbsp;&nbsp;&nbsp;</a></SPAN><SPAN class="clickchange3"
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2-back.gif); WIDTH: 22px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN></TD>
	   <TD class="clickchange4" width=18% align="center"><SPAN class="clickchange1"
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT:48px"></SPAN><SPAN class="clickchange2"
      style="PADDING-RIGHT: 40px; PADDING-LEFT: 40px; FLOAT: left; BACKGROUND-IMAGE: url(images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 12px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 48px; TEXT-ALIGN: center; font-size:20px ; "><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;绩效评价&nbsp;&nbsp;&nbsp;&nbsp;</a></SPAN><SPAN class="clickchange3"
      style="FLOAT: left; BACKGROUND-IMAGE: url(images/main_hl2-back.gif); WIDTH: 22px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 48px"></SPAN></TD>   
       
      </TR>
      <TR>
       
        <TD  colspan="5" 
    style=" COLOR: #566984; " 
    vAlign=top align=middle><img src="images/main.gif" width=100% height="503px" align="middle"></TD>
        
      </TR>
    
    </TBODY>
  </TABLE>
</DIV>

</BODY>
</HTML>
