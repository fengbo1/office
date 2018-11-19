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
	$(document).ready(function(){ 
	

       if(${ty.passporttype}==1)
       {
       document.getElementById("passporttype1").checked=true;
       document.getElementById("passporttype2").disabled="disabled";
       document.getElementById("passporttype3").disabled="disabled";
       }
       if(${ty.passporttype}==2)
       {
       document.getElementById("passporttype2").checked=true;
       document.getElementById("passporttype1").disabled="disabled";
       document.getElementById("passporttype3").disabled="disabled";
       }
       if(${ty.passporttype}==3)
       {
       document.getElementById("passporttype3").checked=true;
       document.getElementById("passporttype2").disabled="disabled";
       document.getElementById("passporttype1").disabled="disabled";
       }
       if(${ty.reason}==1)
       {
       document.getElementById("reason1").checked=true;
       document.getElementById("reason2").disabled="disabled";
       document.getElementById("reason3").disabled="disabled";
       document.getElementById("reason4").disabled="disabled";
       }
       if(${ty.reason}==2)
       {
       document.getElementById("reason2").checked=true;
       document.getElementById("reason1").disabled="disabled";
       document.getElementById("reason3").disabled="disabled";
       document.getElementById("reason4").disabled="disabled";
       }
       if(${ty.reason}==3)
       {
       
       document.getElementById("reason3").checked=true;
       document.getElementById("reason2").disabled="disabled";
       document.getElementById("reason1").disabled="disabled";
       document.getElementById("reason4").disabled="disabled";
       }
       if(${ty.reason}==4)
       {
       document.getElementById("reason4").checked=true;
       document.getElementById("reason2").disabled="disabled";
       document.getElementById("reason3").disabled="disabled";
       document.getElementById("reason1").disabled="disabled";
       }
       if(${ty.category}==1)
       {
       document.getElementById("category1").checked=true;
       document.getElementById("category2").disabled="disabled";
       }
       if(${ty.category}==2)
       {
       document.getElementById("category2").checked=true;
       document.getElementById("category1").disabled="disabled";
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
					action='yscjshenpi.action';
					method="post";
					submit();
				}
			}
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
	</script>
  </head>
  
  <body>  
${daohang}  
    <form action="yscjshenpi.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font style="color:red;"><c:if test="${dai=='1'}">（代）</c:if></font>业务处理中心员工因私出国（境）申请表</strong><strong> </strong></p>
       <div>&nbsp;&nbsp;&nbsp;&nbsp;申请人：<input type="hidden" id="name" name="name" value="${ui.username}"/> 
    				${ui.username} 所在处室：<input type="hidden" id="chu" name="chu" value="${fb:positiontoname(position)}"/>
    				${fb:positiontoname(position)}
                                  职务：${ty.zhiwu}
      	         
        <table width="1160" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="151" class="as" rowspan="3">
    				申请人基本情况
    			</td>
    			<td width="72" class="as" >
    				性别
    			</td>
    			<td width="72" class="as">
                    ${ty.sex}				
     
    			</td>
    			<td width="121" class="as" >
    				年龄
    			</td>
    			<td width="72" class="as" >
    				 ${ty.age}		
    			</td>
    			<td width="121" class="as" >
    				身份证号
    			</td>
    			<td width="121" class="as" >
    				<input type="hidden" id="identity" name="identity" value="${ui.identity}"/> 
    				${ui.identity}
    			</td>
    			<td width="121" class="as" >
    				户口所在地
    			</td>
    			<td width="121" class="as" >
    				 ${ty.hukou}		
    			</td>
    			</tr>
    			<tr>
    			<td class="as" rowspan="2">
    				来中心时间
    				
    			</td>
    			<td colspan="2" rowspan="2">
    				<input type="hidden" id="zxdate" name="zxdate" value="${ui.zxdate}"/> 
    				${ui.zxdate}
    			</td>
    			<td width="121" class="as" rowspan="2">
    				联系电话及邮箱
    			</td>
    			<td width="201" colspan="2">
    				 ${ty.tel}		
    			</td>
    			<td width="121" class="as" rowspan="2">
    				国（境）内联系人及电话
    			</td>
    			<td width="201">
    			    ${ty.contactpeople}		
    			 </td>
    			</tr>
    		<tr>
    			<td width="201" colspan="2">
    			    ${ty.email}		
    			 </td>
    			 <td width="201">
    				 ${ty.contactpeopletel}		
    			</td>
    		</tr>
    	   <tr>
    			<td class="as" rowspan="9">
    				申请事项
    			</td>
    			<td class="as">
    				出国（境）类别
    			</td>
    			<td class="as" colspan="4">
    				初次出国（境）<input id=category1 name=category type="radio" value="1" >
    			</td>
    			<td class="as" colspan="3">
    				再次出国（境）<input id=category2 name=category type="radio" value="2" >
    			</td>	
    			
    		</tr>
    		<tr>
    			<td class="as">
    				拟去国家或地区
    			</td>
    			<td class="as">
    				 ${ty.tocountry}	
    			</td>
    			<td class="as">
    				往返天数
    			</td>
    			<td colspan="5">
    				${ty.begindate}<!--<c:if test="${(ty.halfday=='0'||ty.halfday=='2')&&(ty.notholiday!='1'&&ty.notholiday!='3')}">下班前</c:if><c:if test="${(ty.halfday=='1'||ty.halfday=='3')&&(ty.notholiday!='1'&&ty.notholiday!='3')}">下班后</c:if>&nbsp;-->，预计至
      				${ty.enddate}<!--<c:if test="${(ty.halfday=='2'||ty.halfday=='3')&&(ty.notholiday!='2'&&ty.notholiday!='3')}">上班后</c:if><c:if test="${(ty.halfday=='0'||ty.halfday=='1')&&(ty.notholiday!='2'&&ty.notholiday!='3')}">上班前</c:if>&nbsp;-->，共
      				${ty.sumday}天
    			</td>
    			</td>
    			
    		</tr>
    		<tr>
    		     <td class="as">
    		               申请领取的证件类型
    		     </td>
    		      <td colspan="7" class="as">
    		              护照<input id="passporttype1" type="radio" name="passporttype" value="1"/>
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			   港澳通行证<input id="passporttype2" type="radio" name="passporttype" value="2"/>
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			   台湾通行证<input id="passporttype3" type="radio" name="passporttype" value="3"/>
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		      </td>
    		      
    		</tr>
    		
    		<tr>
    			<td class="as" rowspan="4">
    				出国（境）事由
    			</td>
    			<td colspan="7">
    				(1)旅游<input id="reason1" type="radio" name="reason" value="1"/>
    				&nbsp;&nbsp;
    				旅行社名称： ${ty.travelagency}	
    				
    			</td>
    		 </tr>
    		 <tr>
    			<td colspan="7">
    				(2)探亲<input id="reason2" type="radio" name="reason" value="2"/>
    				&nbsp;&nbsp;
    		    <c:if test="${ty.reason==2}">
				    邀请人姓名： ${ty.invitepeople}
				    与本人关系：  ${ty.relationship}
				    电话： ${ty.invitepeopletel}
    			</c:if>
    				
    			</td>
    		 </tr>
    		 <tr>
    			<td colspan="7">
    				(3)访友<input id="reason3" type="radio" name="reason" value="3"/>
    				&nbsp;&nbsp;
    		    <c:if test="${ty.reason==3}">
				  邀请人姓名：  ${ty.invitepeople}
				 与本人关系：   ${ty.relationship}
				 电话：   ${ty.invitepeopletel}
    			</c:if>
    			</td>
    		 </tr>
    		<tr>
    		 <td colspan="7">
    				(4)其他<input id="reason4" type="radio" name="reason" value="4"/>
    				&nbsp;&nbsp;
    			   请说明：  ${ty.qitashuoming}
    				
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as">
    				申请人承诺
    			</td>
    			<td colspan="8">
    			(1)回国（境）后三工作日内，将出入境证件交主中心组织人事归口管理部门保管；<br>
    			(2)本人所填写表内信息属实；<br>
    			(3)出国（境）后遵守外事纪律，不做有损国家和建行荣誉、利益、安全的事；<br>
    			(4)按时回国（境），及时销假，严格履行请假、销假手续。<br>
    			
    			</td>
    			 
    		</tr>
    		
    		<tr>
    			<td class="as">
    				申请人承诺
    			</td>
    			<td colspan="8">
    			(1)回国（境）后三工作日内，将出入境证件交主中心组织人事归口管理部门保管；<br>
    			(2)本人所填写表内信息属实；<br>
    			(3)出国（境）后遵守外事纪律，不做有损国家和建行荣誉、利益、安全的事；<br>
    			(4)按时回国（境），及时销假，严格履行请假、销假手续。<br>
    			申请人：${ui.username} &nbsp;&nbsp;&nbsp;&nbsp; ${ty.date} 
    			</td>
    			 
    		</tr>
    		<tr>
    			<td class="as">
    				所在处室意见
    			</td>
    			<td colspan="8">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'}">
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
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
    				组织人事归口管理部门意见
    			</td>
    				<td colspan="8">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='H'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					</c:if>
    				</c:forEach>
    				<c:if test="${undersign=='H'}"> 
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
    				所在部门分管领导意见
    			</td>
    			<td colspan="8">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				审批意见
    			</td>
    			<td colspan="8">
    			   <c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='A'}"> 
     	 					审批人：${lp.viewer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
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
    			<td colspan="8">
    				${ty.leaveremark}&nbsp;&nbsp;&nbsp;&nbsp;
    			<c:if test='${ty.leavepagenumber!=""}'>
				   	<a href="<%=path%>/leavedetailyscj.action?number=${ty.number}">查看请假详情</a>	
				   	请审批人注意比对请假日期与出境日期是否一致	
    			</c:if>
    			</td>
    		</tr>
    			<c:if test="${youshenpi==1}"> 
    		<tr>
    			<td class="as">
    				选择审批人
    			</td>
    			<td colspan="8">
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
    			<td colspan="8">
    				
    				<input type="hidden" name="number" value="${ty.number}"/>
    				<input type="hidden" name="thisunder" value="${undersign}"/>
    				<input type="hidden" name="thisnewnumber" value="${newnumber}"/>
    				<input type="hidden" name="thisundername" value="${username}"/>
    				<input type="hidden" name="username" value="${ui.username}"/>
    				<input type="button" onclick="tijiao()"  value="提  交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    				
    			</td>
    		</tr>
    	</table>
    	<br/><br/><br/>
    </form>
  </body>
</html>
