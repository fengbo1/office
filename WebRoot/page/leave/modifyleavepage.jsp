<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <script language="javascript" type="text/javascript" src="<%=path%>/js/SpryValidationTextField.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/SpryCollapsiblePanel.css"  />
    <title>My JSP 'leave_self.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
  .leave_self {
	width: 680px;
}
  .leave_self table tr td {
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	
	border-top-color: #000000;
	border-right-color: #000000;
	border-bottom-color: #000000;
	border-left-color: #000000;
}
  .leave_self table {
	border-top-style: double;
	border-right-style: double;
	border-bottom-style: double;
	border-left-style: double;
}
  </style>

  </head>
  
  <body>
  ${daohang}
  <div align="center" >
  <div class="leave_self" >  
  <p align="center" style="padding:0px;margin:0px; font-size: 24px;">
  <strong>
  	<c:if test="${dai=='1'}"> 
  	（代）
  	</c:if>
  	<c:if test="${bu=='1'}"> 
  	（补）
  	</c:if>
  	业务处理中心员工请假审批表</strong>
  </p>
  <p align="right" style="padding:0px;margin:0px"><strong> 编号：${lp.number}</strong></p>
  <form  action="modifyleave.action" method="post" name="fm1" id="form1">
  <table width="672" height="459" border="1" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td width="66"><div align="center">姓名</div></td>
      <td width="79"><div align="center">${ui.username} </div></td>
      <td width="65"><div align="center">性别</div></td>
      <td width="61"><div align="center">-</div></td>
      <td width="81"><div align="center">出生日期</div></td>
      <td width="96"><div align="center">-</div></td>
      <td width="85"><div align="center">工作日期</div></td>
      <td width="115"><div align="center"><input type="text" name="workdate" value="${ui.workdate}"/></div></td>
    </tr>
    <tr>
      <td><div align="center">处室</div></td>
      <td colspan="5"><div align="center"><input size="8" type="text" name="chu" value="${fb:chutostring(lp.chu)}"/>团队<input size="3" type="text" name="tuan" value="${lp.tuan}"/>（无填0）</div></td>
      <td><div align="center">来行时间</div></td>
      <td>${ui.ccbdate }</td>
    </tr>
    <tr>
      <td><div align="center">职务</div></td>
      <td colspan="5"><div align="center"><input type="text" name="zhiwu" value="${lp.zhiwu}"/></div></td>

      <td><div align="center">连续工龄</div></td>
      <td><div align="center"><input type="text" name="workyears" value="${ui.workyears}"/></div></td>
    </tr>
    <tr>
      <td><div align="center" >拟请假类别</div></td>
      <td colspan="7" style="padding-left:20px">
      	<div align="center"><input type="text" name="type" value="${fb:typetostring(lp.type)}"/></div>
     </td> </tr>    
    <tr>
      <td><div align="center">请假时间</div></td>
      <td colspan="7">
      	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<input size="9" type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker()"  value="${lp.begindate}">&nbsp;至
      	<input size="9" type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker()" value="${lp.enddate}">
      	&nbsp;共
      	<input size="8" type="text" name="days" value="${lp.days}"/>天
      	<select name="halfday" id="halfday">
        	<option value="0">首末完整</option>
        	<option value="1">首日只含下午</option>
        	<option value="2">末日只含上午</option>
        	<option value="3">首日只含下午且末日只含上午</option>
        	</select>
      </td>
      </tr>
    <tr>
      <td><div align="center">上年度请假情况</div></td>
      <td colspan="3">
      &nbsp;
	  </td>
      <td><div align="center">本年度请假情况</div></td>
      <td colspan="3">
      &nbsp;
      </td>
      </tr>
    <tr>
      <td><div align="center">备注</div></td>
      <td colspan="7"><div align="center">${lp.remark }</div>&nbsp;</td>
      </tr>
     <tr>
     <td></td>
      	<td  colspan="7">
      	<input type="hidden" name="number" value="${number}"/>
      	<input type="hidden" name="newnumber" value="${newnumber}"/>
      		<input type="button" onclick="javascript:history.go(-1);" value="返回" />
      		<input type="submit" value="确认修改" />
      	</td>
     </tr>
  </table>
  </form>
   </div>
  </div>

</body>
</html>
