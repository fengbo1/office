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

 });


 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form  name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="13" align="center" bordercolor="#FFFFFF"><b>个人请假明细</b>
							</td>
						</tr>
						<!--<tr>
						<td colspan="13" height="10px">
								<div align="center">
									起始日期					
									<input size=10 type="text" name="begindate" id="begindate" class="Wdate" value="${begindate}" onClick="WdatePicker()" >
									截止日期
									<input size=10 type="text" name="enddate" id="enddate" class="Wdate" value="${enddate}" onClick="WdatePicker()" >							
									请假类型
									<select id="type" name="type" style="width: 100px">
										<option value="0">全部</option>
										<option value="1">病假</option>
										<option value="2">年休假</option>
										<option value="3">事假</option>
										<option value="4">婚假</option>
										<option value="5">产假</option>
										<option value="6">探亲假（配偶）</option>
										<option value="7">探亲假（父母）</option>
										<option value="8">丧假</option>
										<option value="9">工伤假</option>
										<option value="10">公假</option>
										<option value="11">加班调休</option>
										<option value="12">产检</option>
									</select>						
									状态								
						    		<select style="width: 70px" id="status" name="status" style="width: 130px">
										<option value="0">全部</option>
										<option value="1">已办结</option>
										<option value="2">流转中</option>
										<option value="3">已撤销</option>
									</select>
									<input type="submit" value="查询"/>
									<input type="hidden" name="para" value="${type}"/>
									<input type="hidden" name="para" value="${status}"/>
									<input type="hidden" name="para" value="${chutuan}"/>
							</div></td>	
						</tr>-->
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="130px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>请假人</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>当前承办人</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>请假类型</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>开始日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>结束日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>请假天数</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>销假时间</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>		
							<td  width="140px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>												
						</tr>
							<c:forEach items="${list}" var="leave" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="130px" height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.number}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.date}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(leave.initiator)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(leave.applicant)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(leave.undertake)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:typetostring(leave.type)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.begindate}</div></td>		
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.enddate}</div></td>		
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.days}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${leave.xiaojia}</div></td>		
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:statustostring(leave.status)}</div></td>
								 
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<!-- <a href="<%=path%>/saveleavenumber.action?leavepagenumber=${leave.number}&newnumberapply=${leave.applicant}">选择</a>  -->
										&nbsp;&nbsp;
										
										<!-- 
										<a href="<%=path%>/modifyleavepage.action?number=${leave.number}&newnumber=${newnumber}">修改</a> 
										&nbsp;&nbsp;
										 -->
										<a href="<%=path%>/viewleavedetailyscj.action?number=${leave.number}">查看详情</a>
										
										</div></td>	
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="13">
								<div align="center">
							      <input type="button" onclick="javascript:history.go(-1);" value="返  回" />
								
								</div>
								<br/>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
