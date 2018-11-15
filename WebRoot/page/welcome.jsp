<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script type="text/javascript">
$(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
   var length1=document.getElementById("listwb1").value;
   var length2=document.getElementById("listwb2").value;
   var length3=document.getElementById("listwb3").value;
   var length4=document.getElementById("listwb4").value;
   var isneedalert = document.getElementById("isneedalert").value;
   if(isneedalert==2000)
   {
     alert("您的资产归还期限已到，需归还或续借！");
   }
   else if(isneedalert!=0&&isneedalert<=5)
   {
   	 alert("您的资产归还期限即将到，请及时归还或续借！");
   }
   if(Number(length1)!=0)
   {
    length1=Number(length1)>3?Number(length1):3;
   	 document.getElementById("scroll1").style.height=Number(length1)*30+'px';
   	 //alert(Number(length1)*30+'px');
   }
   if(Number(length2)!=0)
   {
	   length2=Number(length2)>3?Number(length2):3;
   	 document.getElementById("scroll2").style.height=Number(length2)*30+'px';
   	 //alert(Number(length2)*30+'px');
   }
   if(Number(length3)!=0)
   {
	  length3=Number(length3)>3?Number(length3):3;
   	 document.getElementById("scroll3").style.height=Number(length3)*30+'px';
   	 //alert(Number(length3)*30+'px');
   }
   if(Number(length4)!=0)
   {
	  length4=Number(length4)>3?Number(length4):3;
   	 document.getElementById("scroll4").style.height=Number(length4)*30+'px';
   	 //alert(Number(length3)*30+'px');
   }
 
   if(Number(length1)>15)
     {
     	document.getElementById("scroll1").style.height='250px';
     	//alert("450px");
     }
  if(Number(length2)>15)
     {
     	document.getElementById("scroll2").style.height='250px';
     	 //alert("450px");
     }
  if(Number(length3)>15)
     {
     	document.getElementById("scroll3").style.height='250px';
     	 //alert("450px");
     }
  if(Number(length4)>15)
  {
  	document.getElementById("scroll4").style.height='250px';
  	 //alert("450px");
  } 
 
 });
 
 
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0" cellspacing="2" >
					  <c:if test="${fn:length(listwb1)!=0}">  	
						<tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>考勤管理</b>
							</td>
						</tr>
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
						<tr height="50px" class="表格表头背景1" id="hang">
							
							<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="140px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室</p>
								</div></td>	
							<td  width="170px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>事项</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>员工</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上一级审批人</p>
								</div></td>
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
						</table>
						</td>
					</tr>
					<tr>
			        <td style="padding-left:1px">
			         <div id="scroll1" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					<c:forEach items="${listwb1}" var="wb" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								
								<td  width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.number}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.date}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wb.initiator)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.chu}</div></td>
								<td width="170px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.type1}${wb.type2}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${wb.type1=='门禁管理'}"> ${fb:newnumbertoname(wb.initiator)}</c:if><c:if test="${((wb.name)!='')&&(wb.type1=='门禁管理')}">、</c:if>${wb.name}</div></td>		
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.preunder==wb.name}">
											无
										</c:if>
										<c:if test="${wb.preunder!=wb.name}">
											${wb.preunder}
										</c:if>
										</div>
								</td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.type1=='请假申请'}">
											${fb:statustostring(wb.status)}
										</c:if>
										<c:if test="${wb.type1!='请假申请'}">
											${fb:newstatustostring(wb.status)}
										</c:if>
										</div></td>		
								<td width="132px" height="25" align="center" valign="middle" nowrap><div
										align="center">
									<c:if test="${wb.type1=='请假申请'}">
									<c:choose>
											<c:when test="${wb.type2=='（管理员查阅）'||wb.type2=='（排班管理员查阅）'}">
												<a href="<%=path%>/welcome.action?newnumber=${newnumber}&number=${wb.number}">清除</a>&nbsp;&nbsp;
												<a href="<%=path%>/leavedetail.action?number=${wb.number}">查看详情</a> 
											</c:when>
											<c:otherwise>
												<c:choose>
											<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==4)}">
												<a href="<%=path%>/deleteleavepage.action?number=${wb.number}&newnumber=${wb.initiator}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/leavedetail.action?number=${wb.number}">查看详情</a> 
											</c:when>
											<c:when test="${wb.status==7}">
												<a href="<%=path%>/leavedetail.action?number=${wb.number}&xiaojia=1">销假</a>
											</c:when>
											<c:otherwise>
												<a href="<%=path%>/viewundertakedetail.action?newnumber=${newnumber}&number=${wb.number}">办理</a>
											</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</c:if>
									<c:if test="${wb.type1=='外出公干'}">
										<c:choose>
											<c:when test="${wb.type2=='（管理员查阅）'}">
												<a href="<%=path%>/welcome.action?newnumber=${newnumber}&number=${wb.number}">清除</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewwcggdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
														<a href="<%=path%>/deletewcggpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
														<a href="<%=path%>/viewwcggdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
													</c:when>
													<c:when test="${wb.status==3}">
														<a href="<%=path%>/viewwcggdetail.action?number=${wb.number}&newnumber=${newnumber}">报到</a>
													</c:when>
													<c:otherwise>
														<a href="<%=path%>/wcggunderdetail.action?number=${wb.number}">办理</a>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>	
									</c:if>
									<c:if test="${wb.type1=='加班申请'}">
										<c:choose>
											<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletejbsppage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewjbspdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>  
											</c:when>
											<c:otherwise>
												<a href="<%=path%>/jbspunderdetail.action?number=${wb.number}">办理</a>
											</c:otherwise>
										</c:choose>	
									</c:if>
									<c:if test="${wb.type1=='考勤缺失'}">	
										<c:choose>
											<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletekqqspage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewkqqsdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>  
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${(wb.status==7)}">
														<a href="<%=path%>/viewkqqsdetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">确认</a>
													</c:when>
													<c:otherwise>
														<a href="<%=path%>/kqqsunderdetail.action?number=${wb.number}">办理</a>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>	
									</c:if>
									
									</div>
									</td>	
							        </tr>
									</c:forEach>
								</table>
			                     </div>  
			                     </td>	
			            </tr>
			            </c:if>	
		<!--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 事项审批 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■--> 	            
			              <c:if test="${fn:length(listwb2)!=0}">  	
			            <tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>事项审批</b>
							</td>
						</tr>
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="140px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室</p>
								</div></td>	
							<td  width="170px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>事项</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>员工</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上一级审批人</p>
								</div></td>
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
						</table>
						</td>
					</tr>
					<tr>
			        <td style="padding-left:1px">
			         <div id="scroll2" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					<c:forEach items="${listwb2}" var="wb" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								
								<td  width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.number}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.date}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wb.initiator)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.chu}</div></td>
								<td width="170px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.type1}${wb.type2}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center"><c:if test="${wb.type1=='门禁管理'}"> ${fb:newnumbertoname(wb.initiator)}</c:if><c:if test="${((wb.name)!='')&&(wb.type1=='门禁管理')}">、</c:if>${wb.name}</div></td>		
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.preunder==wb.name}">
											无
										</c:if>
										<c:if test="${wb.preunder!=wb.name}">
											${wb.preunder}
										</c:if>
										</div>
								</td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.type1=='请假申请'}">
											${fb:statustostring(wb.status)}
										</c:if>
										<c:if test="${wb.type1!='请假申请'}">
											${fb:newstatustostring(wb.status)}
										</c:if>
										</div></td>		
								<td width="132px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.type1=='因公下线'}">	
										<c:choose>
											<c:when test="${wb.type2=='（管理员查阅）'||wb.type2=='（排班管理员查阅）'}">
												<a href="<%=path%>/welcome.action?newnumber=${newnumber}&number=${wb.number}">清除</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewxpdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
														<a href="<%=path%>/updatexpstatus.action?number=${wb.number}&newnumber=${newnumber}&type=6">撤销</a>&nbsp;&nbsp;
														<a href="<%=path%>/viewxpdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>  
													</c:when>
													<c:otherwise>
														<a href="<%=path%>/viewxpunderdetail.action?number=${wb.number}&newnumber=${newnumber}">办理</a>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>	
									</c:if>	
									<c:if test="${wb.type1=='调班申请'}">	
										<c:choose>
											<c:when test="${wb.type2=='（调班人查阅）'}">
												<a href="<%=path%>/viewtpdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
														<a onclick="return confirm('撤销后请及时通知调班人！')" href="<%=path%>/updatetpstatus.action?number=${wb.number}&newnumber=${newnumber}&type=6">撤销</a>&nbsp;&nbsp;
														<a href="<%=path%>/viewtpdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>  
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${(wb.status==7)}">
																<a href="<%=path%>/updatetpstatus.action?number=${wb.number}&newnumber=${newnumber}&type=7">确认</a>
																<a href="<%=path%>/viewtpdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>  
															</c:when>
															<c:otherwise>
																<a href="<%=path%>/viewtpunderdetail.action?number=${wb.number}&newnumber=${newnumber}">办理</a>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>	
									</c:if>	
									<c:if test="${wb.type1=='在职证明'}">	
										<c:choose>
											<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletezzzmpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewzzzmdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>  
											</c:when>
											<c:otherwise>
											  <c:choose>
											    <c:when test="${(wb.status==4)}"> 
														<a href="<%=path%>/viewzzzmdetail.action?number=${wb.number}">查看详情</a> &nbsp;&nbsp;
													<!--  -->	<a href="<%=path%>/welcome.action?number=${wb.number}&newnumber=${newnumber}">清除</a>
												</c:when>
												<c:otherwise>
												<c:choose>
													<c:when test="${(wb.status==7)}">
														<a href="<%=path%>/viewzzzmdetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">确认</a>
													</c:when>
													<c:otherwise>
														<a href="<%=path%>/zzzmunderdetail.action?number=${wb.number}">办理</a>
													</c:otherwise>
												</c:choose>
												</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>	
									</c:if>	
									<c:if test="${wb.type1=='收入证明'}">	
										<c:choose>
											<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletesrzmpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewsrzmdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>  
											</c:when>
											<c:otherwise>
											  <c:choose>
											      <c:when test="${(wb.status==4)}"> 
														<a href="<%=path%>/viewsrzmdetail.action?number=${wb.number}">查看详情</a> &nbsp;&nbsp;
													<!--  -->	<a href="<%=path%>/welcome.action?number=${wb.number}&newnumber=${newnumber}">清除</a>
												 </c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${(wb.status==7)}">
														<a href="<%=path%>/viewsrzmdetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">确认</a>
													</c:when>
													<c:otherwise>
														<a href="<%=path%>/srzmunderdetail.action?number=${wb.number}">办理</a>
													</c:otherwise>
												</c:choose>
												</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>	
									</c:if>	
									<c:if test="${wb.type1=='因私出入境'}">	
										<c:choose>
											<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deleteyscjpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewyscjdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a>  
											</c:when>
										 <c:when test="${wb.status==8}">
											<a href="<%=path%>/yscjtzdetail.action?number=${wb.number}&newnumber=${newnumber}">填写护照领取时间</a>
										 </c:when>
										 <c:when test="${wb.status==9}">
											<a href="<%=path%>/yscjtzdetail.action?number=${wb.number}&newnumber=${newnumber}">填写护照归还时间</a>
										 </c:when>
										   <c:when test="${(wb.status!=8)&&(wb.status!=9)}">
											<a href="<%=path%>/yscjunderdetail.action?number=${wb.number}">办理</a>
										   </c:when>
											<c:otherwise>
												
											</c:otherwise>
										</c:choose>	
									</c:if>	
									
									<c:if test="${wb.type1=='门禁管理'}">	
										<c:choose>
										 <c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletemjglpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewmjgldetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										 </c:when>
										 <c:when test="${wb.status==12}">
											<a href="<%=path%>/viewmjgldetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">调整权限</a>
										 </c:when>
										 <c:when test="${wb.status==13}">
											<a href="<%=path%>/viewmjgldetail.action?number=${wb.number}&newnumber=${newnumber}&selfqueren=1">确认</a>
										 </c:when>
										    <c:otherwise>
											    <a href="<%=path%>/viewmjglunderdetail.action?number=${wb.number}">办理</a>
										    </c:otherwise>
										</c:choose>	
									</c:if>	
									
									</div>
									</td>	
							        </tr>
									</c:forEach>
								</table>
			                     </div>  
			                     </td>	
			            </tr>
			              </c:if>	
		 		  <!--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 资产管理 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■-->  
			      <c:if test="${(zhi=='0'||zhi=='1'||zhi=='2'||authoN=='N'||authoM=='M'||authoO=='O'||authoS=='S')&&(fn:length(listwb3)!=0)}">  
			            <tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>资产管理</b>
							</td>
						</tr>
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="140px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室</p>
								</div></td>	
							<td  width="170px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>事项</p>
								</div></td>
						
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上一级审批人</p>
								</div></td>
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
						</table>
						</td>
					</tr>
					<tr>
			        <td style="padding-left:1px">
			         <div id="scroll3" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					<c:forEach items="${listwb3}" var="wb" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								
								<td  width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.number}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.date}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wb.initiator)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.chu}</div></td>
								<td width="170px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.type1}${wb.type2}</div></td>
								
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.preunder==wb.name}">
											无
										</c:if>
										<c:if test="${wb.preunder!=wb.name}">
											${wb.preunder}
										</c:if>
										</div>
								</td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.type1=='请假申请'}">
											${fb:statustostring(wb.status)}
										</c:if>
										<c:if test="${wb.type1!='请假申请'}">
											${fb:newstatustostring(wb.status)}
										</c:if>
										</div></td>		
								<td width="132px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.type1=='资产申领'}">	
										<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletezcapplypage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewzcapplydetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
										   <c:choose>
										    <c:when test="${(wb.status==14)}">
												<a href="<%=path%>/viewzcapplyfennum.action?number=${wb.number}&newnumber=${newnumber}">分配资产编号</a>
											</c:when>
											 <c:when test="${(wb.status==15)}">
												<a href="<%=path%>/viewzcapplyfenname.action?number=${wb.number}&newnumber=${newnumber}">分配资产到人员</a>
											</c:when>
											<c:otherwise>
											<a href="<%=path%>/viewzcapplyunderdetail.action?number=${wb.number}">处理</a>
											</c:otherwise>
						
											</c:choose>
										</c:otherwise>
									</c:choose>	
									</c:if>	
									
									<c:if test="${wb.type1=='资产借用'}">	
										
									<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletezcborrowpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewzcborrowdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
										    <c:choose>
										    <c:when test="${(wb.status==14)}">
												<a href="<%=path%>/viewzcborrowfennum.action?number=${wb.number}&newnumber=${newnumber}">分配资产编号</a>
											</c:when>
											 <c:when test="${(wb.status==15)}">
												<a href="<%=path%>/viewzcborrowfenname.action?number=${wb.number}&newnumber=${newnumber}">分配资产到人员</a>
											</c:when>
											<c:otherwise>
											<a href="<%=path%>/viewzcborrowunderdetail.action?number=${wb.number}">处理</a>
											</c:otherwise>
						
											</c:choose>
										</c:otherwise>
									</c:choose>	
										
										
									</c:if>	
									
									
									
									<c:if test="${wb.type1=='资产归还'}">	
									<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletezcreturnpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewzcreturndetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
										   <c:choose>
										    <c:when test="${(wb.status==18)}">
												<a href="<%=path%>/viewzcreturndetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">确认</a>
											</c:when>
											<c:otherwise>
											<a href="<%=path%>/viewzcreturnunderdetail.action?number=${wb.number}">处理</a>
											</c:otherwise>
						
											</c:choose>
										</c:otherwise>
									</c:choose>	
									</c:if>	
									
									<c:if test="${wb.type1=='入库管理'}">	
									<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletezckfinpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewzckfindetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
										<a href="<%=path%>/checkzckfin.action?number=${wb.number}&newnumber=${newnumber}">复核</a> 
										&nbsp;&nbsp;&nbsp;&nbsp;
										</c:otherwise>
			                            </c:choose>	
									</c:if>	
									
									<c:if test="${wb.type1=='报废管理'}">	
										<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/deletezckfoutpage.action?number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewzckfoutdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
										<a href="<%=path%>/checkzckfout.action?number=${wb.number}&newnumber=${newnumber}">复核</a> 
										&nbsp;&nbsp;&nbsp;&nbsp;
										</c:otherwise>
			                            </c:choose>	
									</c:if>	
									
									</div>
									</td>	
							        </tr>
									</c:forEach>
								</table>
			                     </div>  
			                     </td>	
			            </tr>
			            </c:if>
			            
			<!--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ 员工渠道 ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■-->            
			            <c:if test="${fn:length(listwb4)!=0}">  
			            <tr>
							 <td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="12" align="center" bordercolor="#FFFFFF"><b>员工渠道</b>
							</td>
						</tr>
					<tr>
			        <td style="padding-left:1px">
						<table height="80" align="center" cellpadding="0" cellspacing="2" >
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="140px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>处室</p>
								</div></td>	
							<td  width="170px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>事项</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>员工</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>上一级审批人</p>
								</div></td>
							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
						</table>
						</td>
					</tr>
					<tr>
			        <td style="padding-left:1px">
			         <div id="scroll4" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					<c:forEach items="${listwb4}" var="wb" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								
								<td  width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.number}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.date}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wb.initiator)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.chu}</div></td>
								<td width="170px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.type1}${wb.type2}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.name}</div></td>		
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">
											${wb.preunder}
										</div>
								</td>
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										${fb:newstatustostring(wb.status)}
										</div></td>		
								<td width="132px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${wb.type1=='平台用户'}">	
										<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/updateusptstatus.action?type=cx&number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/viewusptdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
											<c:choose>
													<c:when test="${(wb.status==16)}">
														<a href="<%=path%>/viewusptdetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">确认</a> 
													</c:when>
													<c:otherwise>
														<a href="<%=path%>/usptunderdetail.action?number=${wb.number}">处理</a>
													</c:otherwise>
												</c:choose>
										</c:otherwise>
									</c:choose>	
									</c:if>	
									<c:if test="${wb.type1=='COS_T行方用户'}">	
										<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/uschupdatestatus.action?type=cx&number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/uschviewdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
										<c:choose>	
											<c:when test="${(wb.status==16)}">
												<a href="<%=path%>/uschviewdetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">确认</a> 
											</c:when>
											<c:otherwise>
												<a href="<%=path%>/uschunderdetail.action?number=${wb.number}">处理</a>
											</c:otherwise>
										</c:choose>	
										</c:otherwise>
									</c:choose>	
									</c:if>
									<c:if test="${wb.type1=='COS_T外包用户'}">	
										<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/uscwupdatestatus.action?type=cx&number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/uscwviewdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
										<c:choose>	
											<c:when test="${(wb.status==16)}">
												<a href="<%=path%>/uscwviewdetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">确认</a> 
											</c:when>
											<c:otherwise>
												<a href="<%=path%>/uscwunderdetail.action?number=${wb.number}">处理</a>
											</c:otherwise>
										</c:choose>	
										</c:otherwise>
									</c:choose>	
									</c:if>
									<c:if test="${wb.type1=='稽核用户'}">	
										<c:choose>	
										<c:when test="${(newnumber==wb.initiator)&&(wb.status==0||wb.status==5)}">
												<a href="<%=path%>/usjhupdatestatus.action?type=cx&number=${wb.number}&newnumber=${newnumber}">撤销</a>&nbsp;&nbsp;
												<a href="<%=path%>/usjhviewdetail.action?number=${wb.number}&newnumber=${newnumber}">查看详情</a> 
										</c:when>

										<c:otherwise>
										<c:choose>	
											<c:when test="${(wb.status==16)}">
												<a href="<%=path%>/usjhviewdetail.action?number=${wb.number}&newnumber=${newnumber}&queren=1">确认</a> 
											</c:when>
											<c:otherwise>
												<a href="<%=path%>/usjhunderdetail.action?number=${wb.number}">处理</a>
											</c:otherwise>
										</c:choose>	
										</c:otherwise>
									</c:choose>	
									</c:if>			
									</div>
									</td>	
							        </tr>
									</c:forEach>
								</table>
			                     </div>  
			                     </td>	
			            </tr>
			            </c:if>
				  <input type="hidden" id="isneedalert" value="${isneedalert}"/>
				  <input type="hidden" id="listwb1" value="${fn:length(listwb1)}"/>
				  <input type="hidden" id="listwb2" value="${fn:length(listwb2)}"/>
				  <input type="hidden" id="listwb3" value="${fn:length(listwb3)}"/>	
				  <input type="hidden" id="listwb4" value="${fn:length(listwb4)}"/>				
		</table>
		<br><br><br><br><br>
		</form>
  </body>
</html>
