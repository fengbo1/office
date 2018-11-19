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
	<script type="text/javascript">
	function tijiao()
		{
			var show = "${isshow}";
			if(show==0)
			{
				alert("未分配资产编号！");
				return;
			}
			with(document.forms[0]) {
			action='zcapplyqueren.action';
			method="post";
			submit();
			}
		}
	
	function download()
	{
		var number = "${ay.number}";
		window.location = "<%=path%>/exportapplyfenname.action?number="+number;
	}
	function upload()
	{
		with(document.forms[0]) {
			action='importapplyfenname.action';
			method="post";
			submit();
			}
	}
		
   </script>

 

  <style type="text/css">
  .as {
	text-align: center;
}
b{
	color:red;
}
  </style>
  </head>
  
  <body> 
 ${daohang} 
    <form name="myform" method="post" enctype="multipart/form-data">
    	<br>
    		<br>	
    	 <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心资产申领表</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr height="50">
    		 <td width="150" class="as" >
    				资产管理员<b>*</b>
    			</td>
    			<td width="150" class="as" >
    				<input style="width:50px" id="username" type="hidden" name="username" value="${ui.username}"  />
    				${ui.username}
    			</td>
    			<td width="100" class="as"  >
    				申领处室<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				<input type="hidden" id="chu" name="chu" value="${chu}"/> 
    				${fb:chustostring(chu)}
    			</td>
    			
    			<td width="120" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				${ay.tel}
    			</td>
    		</tr>
    	 <c:forEach items="${listap}" var="ap" varStatus="status">
    		<tr height="40">
    			<td  class="as" >
    				资产名称<b>*</b>
    			</td>
    			<td width="145" class="as" >
    				
    				   ${ap.name} <br/>
    			
    			</td>
    			<td width="100" class="as" >
    				型号<b>*</b>
    			</td>
    			<td class="as" >
    			  
    				   ${ap.type} <br/>
    			
    			</td>
    			<td width="120" class="as">
    				数量<b>*</b>
    			</td>
    			<td width="200" class="as" >
    				
    				  申请 ${ap.num}件 <br/>
    				
    			</td>
    		</tr>
    		</c:forEach>
    		<tr height="40">
    			<td  class="as">
    				申领原因<b>*</b>
    			</td>
    			<td colspan="5" class="as">
    			    ${ay.reason}
    			</td>
    			
    		</tr>
    		
    		<tr height="40">
    			<td class="as">
    				处室意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'}">
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		<tr height="40">
    			<td class="as">
    				综合与生产管理处意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='P'}"> 
     	 					审核人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审核时间：${lp.time}<br/>
      					</c:if>
    					<c:if test="${lp.authority=='H'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		<tr height="40">
    			<td class="as">
    				申请处室指定使用人员
    			</td>
    			<td colspan="5">
    			      <input type="button" onclick="download()" value="下  载" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			     
    			               请选择要上传的文件：<input type="file" name="file" />
			          <input type="button"  value="上传" onclick="upload()"/>  	<br/>	
			          			
    				  <c:if test="${isshow==1}"> 
    				  <c:forEach items="${listaf}" var="af" varStatus="status">
    				       资产名称：${af.name}&nbsp;&nbsp;&nbsp;&nbsp;资产型号：${af.type}&nbsp;&nbsp;&nbsp;&nbsp;资产编号：${af.number}&nbsp;&nbsp;&nbsp;&nbsp;使用人：${af.username}&nbsp;&nbsp;&nbsp;&nbsp;使用区域：${af.area}<br/>
    				  </c:forEach>
    				  </c:if>
    			</td>
    		</tr>
    		<tr height="40">
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">
    				${ay.remark}
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="number" value="${ay.number}"/>
    				
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="tijiao()" value="提   交" />    				
    				
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
