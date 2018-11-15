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
	 function download(f)
	 {
		 window.open("<%=path%>/page/uass/derivept.jsp?Path="+f,"","height=70,width=300,top=400,left=600"); 
	 }
	 function tijiao()
		{
			with(document.forms[0]) {
			action='uassqueren.action';
			method="post";
			submit();
			}
		}
	</script>
  </head>
  
  <body>
    <form action="usptshenpi.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>平台用户维护申请表</strong></p>
        <table width="860" height="550" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as">
    				发起人
    			</td>
    			<td width="250">
    				${fb:newnumbertoname(up.initiator)}
    			</td>
    			<td width="150" class="as">
    				用户编号
    			</td>
    			<td width="250">
    				${ui.newnumber}
    			</td>
    		</tr>
    		<tr>	
    			<td class="as">
    				所在处室
    			</td>
    			<td>
    				${fb:positiontoname(position)}
    			</td>
    			<td class="as">
    				移动电话
    			</td>
    			<td>
    				${up.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				具体事项内容
    			</td>
    			<td colspan="3" >
    				<c:forEach items="${listupp}" var="upp" varStatus="status">
    					${upp.name}:${fb:uassptitemtostring(upp.item)}。备注：${upp.content}<br/>
    				</c:forEach>
    				<p align="right">建议生效日期：${up.sxtime}</p>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请部门意见
    			</td>
    			<td colspan="3" id="p">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'}">
    						审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    					<c:if test="${lp.authority=='C'}">
    						<c:if test="${up.process=='1'||up.process=='3'}">审核人
    						</c:if>
    						<c:if test="${up.process=='2'}">审批人
    						</c:if>
    						：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    				</c:forEach>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				会签部门意见
    			</td>
    			<td colspan="3" id="p">&nbsp;
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='X'}"> 
    					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    				</c:forEach>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				中心部门意见
    			</td>
    			<td colspan="3" id="p">&nbsp;
    			<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='A'}"> 
    					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    				</c:forEach>&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3">
    				<input type="hidden" name="number" value="${number}"/>
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
 					<c:if test="${up.filename!=''}">
    					<input type="button" onclick="download('${up.filename}');" value="下载附件" />
    				</c:if>
    				
    				<c:if test="${queren==1}">
						<input type="button" onclick="tijiao()" value="处    理" />    				
    				</c:if>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
