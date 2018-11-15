
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
<HEAD id=Head1>
<TITLE>无标题页</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script type="text/javascript">
 $(document).ready(function(){ 
  document.getElementById("peoplename").innerHTML="&nbsp;&nbsp;"+parent.username;
});

function tips()
{
  alert("如需帮助，请联系综合与生产管理处，冯波  86026764，宋阳 86026254");
}

function modify()
{
  window.parent.location = "/office/page/userinfo/modify.jsp?username="+parent.username;
  //alert(parent.username);
}
 </script>
<STYLE type=text/css> 
*{
	FONT-SIZE: 12px; COLOR: white
}
#logo {
	COLOR: white
}
#logo A {
	COLOR: white
}
FORM {
	MARGIN: 0px
}
</STYLE>
<SCRIPT src="js/Clock.js" type=text/javascript></SCRIPT>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY 
style="BACKGROUND-IMAGE: url(images/bg2.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x">
<form id="form1">
  <DIV id=logo 
style="BACKGROUND-IMAGE: url(images/logo1.gif); BACKGROUND-REPEAT: no-repeat">
   <!-- <DIV 
style="PADDING-RIGHT: 50px; BACKGROUND-POSITION: right 50%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(images/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 30px; TEXT-ALIGN: right"><A 
href="#"><IMG src="images/mail.gif" 
align=absMiddle border=0></A>  <IMG 
src="images/menu_seprator.gif" align=absMiddle> <A id=HyperLink3 
href="index2.jsp" >退出系统</A> </DIV> --> 
<br/><br/>
    <DIV style="DISPLAY: block; HEIGHT: 54px"></DIV>
    <DIV 
style="BACKGROUND-IMAGE: url(images/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px">
      <TABLE cellSpacing=0 cellPadding=0 width="100%">
        <TBODY>
          <TR>
            <TD>
              <DIV><IMG src="images/nav_pre.gif" align=absMiddle> 欢迎 <SPAN 
      id=lblBra>业务处理中心成都分中心</SPAN><span id="peoplename"></span> </DIV>
            </TD>
            <TD align=right width="70%"> <A href="#" onclick="modify()"><IMG src="images/nav_resetPassword.gif" 
      align=absMiddle border=0>修改密码</A> <A href="index2.jsp" ><IMG src="images/nav_back.gif" 
      align=absMiddle border=0>退出系统</A> <A href="#" onclick="tips()"><img src="images/nav_help.gif" align=absMiddle border=0>帮助</A> <IMG 
      src="images/menu_seprator.gif" align=absMiddle><SPAN 
      id=clock></SPAN></SPAN>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</TD>
          </TR>
        </TBODY>
      </TABLE>
    </DIV>
  </DIV>
  <SCRIPT type=text/javascript>
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
</SCRIPT>
</form>
</BODY>
</HTML>
