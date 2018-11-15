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
  	<style type="text/css">
	table{
     border-collapse:collapse;
}
table td{
     empty-cells:show;
}
	</style>
 <script type="text/javascript">
 
 $(document).ready(function(){ 
 
  if(${tz.isdeparture}==1)
  {
      document.getElementById("isdepart1").checked=true; 
      document.getElementById("isdepart2").disabled=true;	
	 
  }
  if(${tz.isdeparture}==0)
  {
      document.getElementById("isdepart2").checked=true; 
      document.getElementById("isdepart1").disabled=true;	
	 
  }
  if(${tz.licencech}=="1")
  {
      document.getElementById("licencech").checked=true; 
      document.getElementById("licencech").disabled=false;	
				//document.getElementById("id4").checked=true; 
	  $("#licencech").click(function(){return false;}); 	
  }
  if(${tz.licencech}=="0")
  {
  		document.getElementById("licencech").disabled="disabled";		
  }
  
  if(${tz.licenceen}=="1")
  {
       document.getElementById("licenceen").checked=true; 
       document.getElementById("licenceen").disabled=false;	
	  $("#licenceen").click(function(){return false;}); 	
  }
  if(${tz.licenceen}=="0")
  {
  	    document.getElementById("licenceen").disabled="disabled";	
  }
 
});
  
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
					action='zzzmshenpi.action';
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
			alert("请确认您选择的意见是【不同意】");
			document.getElementById("xuanze").style.display="none"; 
		} 
	} 
	 </script>	
	
	
  </head>
  
  <body>
  ${daohang}
   <form action="zzzmshenpi.action" method="post">
    <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong> <font style="color:red;"><c:if test="${dai=='1'}">（代）</c:if></font>业务处理中心成都分中心在职证明申请表</strong><strong> </strong></p>
    	<table width="945" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="150" class="as" rowspan="2">
    				姓名
    			</td>
    			<td width="176" rowspan="2">
    				${fb:newnumbertoname(tz.applicant)}
    			</td>
    			<td width="101" class="as" rowspan="2">
    				性别
    			</td>
    			<td width="75" rowspan="2">
    				${tz.sex}
    			</td>
    			<td width="121" class="as">
    				身份证号码
    			</td>
    			<td width="201">
    				${ui.identity}
    			</td>
    		</tr>
    		<tr>
    		<td width="121" class="as">
    				护照号
    			</td>
    			<td width="201">
    			  ${ui.passport}
    			</td>
    		</tr>
    		<tr>
    			<td  class="as">
    				所在部门
    			</td>
    			<td colspan="3">
    			
    				${fb:positiontoname(position)}
    			</td>
    			<td  class="as">
    				联系电话
    			</td>
    			<td width="201">
    				${tz.tel}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				来总行工作时间
    				
    			</td>
    			<td colspan="2">
    				
    				${ui.zxdate}
    			</td>
    		
    			<td class="as">
    				现任职务
    			</td>
    			 <td colspan="2"><!--  <input type="text" id="zhiwu" name="zhiwu" style="padding:0px;margin:0px;">-->
      	           ${tz.zhiwu}
	  	
	         </td>
    		</tr>
    			<tr>
    		
    			<td class="as" colspan="2">
    				开具在职证明是否用于出境<b>*</b>
    			</td>
    		
    			
    			 <td class="as" colspan="4"><!--  <input type="text" id="zhiwu" name="zhiwu" style="padding:0px;margin:0px;">-->
      	                          是<input id="isdepart1" type="radio" name="isdeparture" value="1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	                          否  <input id="isdepart2" type="radio" name="isdeparture" value="0"/>
      	        <c:if test='${tz.yscjnumber!="wu"}'>
				   	<a href="<%=path%>/yscjdetail.action?number=${tz.yscjnumber}">查看因私出国（境）审批表</a>			
    			</c:if>
	            </td>
    		</tr>
    		<tr>
    		
    			<td class="as" colspan="3">
    				是否开具单位无营业执照证明（汉语）<input id="licencech" name="licencech" type="checkbox" value="1">
    			</td>
    		
    			
    			 <td class="as" colspan="3"><!--  <input type="text" id="zhiwu" name="zhiwu" style="padding:0px;margin:0px;">-->
      	                                是否开具单位无营业执照证明（英语）<input id="licenceen" name="licenceen" type="checkbox" value="1" >
	         </td>
    		</tr>
    		<tr>
    			<td class="as">
    				在职证明用途  
    			</td>
    			<td colspan="3">
    			${tz.yongtu}
    			</td>
    			<td class="as">
    				所需份数
    			</td>
    			<td>
    			${tz.neednumber}
    			</td>
    		</tr>
    		 <tr>
    			<td class="as">
    				在职证明接收单位
    			</td>
    			<td colspan="5">
    			${tz.todepartment}
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请人   （签字）
    			</td>
    			<td colspan="5">
    				${ui.username} &nbsp;&nbsp;&nbsp;&nbsp; ${tz.date} 
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				综合与生产管理处意见
    			</td>
    			<td colspan="5">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='J'}"> 
     	 					审核人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审核时间：${lp.time}<br/>
      					</c:if>
      					<c:if test="${lp.authority=='G'}"> 
     	 					审核人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审核时间：${lp.time}<br/>
      					</c:if>
    					<c:if test="${lp.authority=='H'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				<c:if test="${undersign=='J'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield" >
    				</c:if> 
    				<c:if test="${undersign=='G'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield" >
    				</c:if> 
    				<c:if test="${undersign=='H'}"> 
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="textfield" >
    				</c:if> 
    				
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">
    			${tz.remark}
    				
    			</td>
    		</tr>
    		<c:if test="${youshenpi==1}"> 
    		<tr>
    			<td class="as">
    				选择审批人
    			</td>
    			<td colspan="5">
    				<select id="xuanze" name="xuanze">
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
    				
    				<input type="hidden" name="number" value="${tz.number}"/>
    				<input type="hidden" name="thisunder" value="${undersign}"/>
    				<input type="hidden" name="thisnewnumber" value="${newnumber}"/>
    				<input type="hidden" name="thisundername" value="${username}"/>
    				<input type="button" onclick="tijiao()"  value="提  交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    				
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>

