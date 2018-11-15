<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>My JSP 'authorityfailed.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
   <style type="text/css">
  .as {
	text-align: center;
}
  </style>
   <script type="text/javascript">
   function sel(o)
   {
 	  if(o==11)
 	  {
 		  document.getElementById("xuanze").style.display="inline-block";
 			
 		}else{
 			alert("请确认您选择的意见是【不同意】");
 			document.getElementById("xuanze").style.display="none"; 
 		} 
 	}
  function tijiao() {
	  var radio=document.getElementsByName("radio");
	  var xuanze = document.getElementById("xuanze").value;
	  var message = "确认提交？";
	  if(radio[0].checked!=true&&radio[1].checked!=true)
		{
			alert("请选择审批意见");
		}
	  else if(xuanze=="wu"&&radio[0].checked==true)
		{
			alert("请选择下一级审批人");
		}
		else
		{
			if (window.confirm(message)) {
				with(document.forms[0]) {
					action='jbspshenpi.action';
					method="post";
					submit();
				}
			}
		}
  } 
	 </script>
  </head>
  
  <body>
  ${daohang}
    <form action="jbspshenpi.action" method="post">
    	<p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心加班审批备案表</strong><strong> </strong></p>
    	<table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="121" class="as">
    				姓名
    			</td>
    			<td width="176">
    				${fb:newnumbertoname(jp.applicant)}
    			</td>
    			<td width="72" class="as">
    				处室
    			</td>
    			<td width="175">
    				${fb:positiontoname(position)}
    			</td>
    			<td width="89" class="as">
    				联系方式
    			</td>
    			<td width="201">
    				${jp.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				加班人
    			</td>
    			<td colspan="5" id="p">
    				${jp.people }
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				加班事由
    			</td>
    			<td colspan="5">
    				${jp.reason}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				加班时间
    			</td>
    				<td colspan="5">
    				${begindate}<c:if test="${jp.halfday=='0'||jp.halfday=='2'}">上午</c:if><c:if test="${jp.halfday=='1'||jp.halfday=='3'}">下午</c:if>&nbsp;至
      				${enddate}<c:if test="${jp.halfday=='2'||jp.halfday=='3'}">上午</c:if><c:if test="${jp.halfday=='0'||jp.halfday=='1'}">下午</c:if>&nbsp;，共
      				${jp.days}天
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				所在处室意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				<c:if test="${undersign=='B'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield" >
    				</c:if> &nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				中心审批意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='A'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				<c:if test="${undersign=='A'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield" >
    				</c:if> &nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">
    				${jp.remark}&nbsp;
    			</td>
    		</tr>
    		
    		<c:if test="${youshenpi==1}"> 
    		<tr>
    			<td class="as">
    				选择审批人
    			</td>
    			<td colspan="5">
    				<select name="xuanze">
        				<option>请选择下一级审批人</option>
        					<c:forEach items="${listui}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        			</select>
    			</td>
    		</tr>
    		</c:if>
    		<c:if test="${youshenpi!=1}"> 
    			<input type="hidden" name="xuanze" value=""/>
    		</c:if>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="number" value="${jp.number}"/>
    				<input type="hidden" name="thisunder" value="${undersign}"/>
    				<input type="hidden" name="thisnewnumber" value="${newnumber}"/>
    				<input type="hidden" name="thisundername" value="${username}"/>
    				<input  type="button" onclick="tijiao()"  value="提  交" />&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
