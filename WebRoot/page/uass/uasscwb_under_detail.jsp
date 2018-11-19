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
		 window.open("<%=path%>/page/uass/derivecost.jsp?Path="+f,"","height=70,width=300,top=400,left=600"); 
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
					action='uscwshenpi.action';
					method="post";
					submit();
				}
			}
		}
  } 
  function sel(o)
  {
	  if(o==11)
	  {
		  document.getElementById("xuanze").style.display="inline-block";
			
		}else{
			 
			document.getElementById("xuanze").style.display="none"; 
			alert("请确认您选择的意见是【不同意】");
		} 
	} 
	 </script>
  </head>
  
  <body>
    <form action="uscwshenpi.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>外包COS_T系统用户维护申请表</strong></p>
        <table width="860" height="550" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as">
    				发起人
    			</td>
    			<td width="250">
    				${fb:newnumbertoname(uc.initiator)}
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
    				${uc.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请事项
    			</td>
    			<td colspan="3" >
    				${uc.content}
    				<br/>
    				<c:if test="${uc.filename1!=''}">
    					<input type="button" onclick="download('${uc.filename1}');" value="附件1" />
    				</c:if>
    				<c:if test="${uc.filename2!=''}">
    					<input type="button" onclick="download('${uc.filename2}');" value="附件2" />
    				</c:if>
    				<c:if test="${uc.filename3!=''}">
    					<input type="button" onclick="download('${uc.filename3}');" value="附件3" />
    				</c:if>
    				<p align="right">建议生效日期：${uc.sxtime}</p>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请部门意见
    			</td>
    			<td colspan="3" id="p">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'||lp.authority=='C'}"> 
    						审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批时间：${lp.time}<br/>
    					</c:if>
    				</c:forEach>
    				<c:if test="${undersign=='B'||undersign=='C'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 备注：<input type="text" name="textfield" >
    				</c:if>
    				<c:if test="${undersign=='o'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						处理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						退回
     					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 备注：<input type="text" name="textfield" >
    				</c:if>
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
    				</c:forEach>
    				<c:if test="${undersign=='X'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 备注：<input type="text" name="textfield" >
    				</c:if>
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
    				</c:forEach>
    			<c:if test="${undersign=='A'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 备注：<input type="text" name="textfield" >
    				</c:if>
    			</td>
    		</tr>
    		<c:if test="${youshenpi==1}"> 
    			<c:if test="${undersign!='A'}"> 
	    		<tr>
	    			<td class="as">
	    				选择审批人
	    			</td>
	    			<td colspan="3">
	    				<select name="xuanze" id="xuanze">
	        				<option value="wu">请选择下一级审批人</option>
	        					<c:forEach items="${listui}" var="user" varStatus="status">
	        						<option value="${user.newnumber}">${user.username}</option>
	        					</c:forEach>
	        			</select>
	    			</td>
	    		</tr>
	    		</c:if>
	    		<c:if test="${undersign=='A'}"> 
	    			<tr>
	    			<td class="as">
	    				选择处理人
	    			</td>
	    			<td colspan="3">
	    				<select name="xuanze" id="xuanze">
	        				<option value="wu">请选择UASS管理员</option>
	        					<c:forEach items="${listui}" var="user" varStatus="status">
	        						<option value="${user.newnumber}">${user.username}</option>
	        					</c:forEach>
	        			</select>
	    			</td>
	    		</tr>
	    		</c:if>
    		</c:if>
    		<c:if test="${youshenpi!=1}"> 
    			<input type="hidden" name="xuanze" value=""/>
    		</c:if>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3">
    				<input type="hidden" name="number" value="${uc.number}"/>
    				<input type="hidden" name="thisunder" value="${undersign}"/>
    				<input type="hidden" name="thisnewnumber" value="${newnumber}"/>
    				<input type="hidden" name="thisundername" value="${username}"/>
    				<input  type="button" onclick="tijiao()"  value="提  交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
 
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
