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

 function expressout()
	{
		var begindate = document.getElementById("begindate").value;
		var enddate = document.getElementById("enddate").value;
		var name = document.getElementById("name").value;	
		var newnumber = document.getElementById("newnumber").value;	
		window.location = "<%=path%>/exporttbsq.action?begindate="+begindate+"&enddate="+enddate+"&name="+name+"&newnumber="+newnumber;
	}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/viewtbsqall.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>调班记录明细</b>
							</td>
						</tr>
						<tr>
							<td colspan="13" height="10px">
								<div align="center">
									起始日期						
								<input size=10 type="text" name="begindate" id="begindate" class="Wdate" value="${begindate}" onClick="WdatePicker()" >
									截止日期						
								<input size=10 type="text" name="enddate" id="enddate" class="Wdate" value="${enddate}" onClick="WdatePicker()" >
									<c:if test="${type=='all'}">
									姓名	
								<input style="width:100px" type="text" id="name" name="name" value="${name}"/>
								</c:if>								
								查询
									<input type="submit" value="查询"/>
									<c:if test="${type=='all'}">
									<input type="button" value="导出" onclick="expressout()"/>
									</c:if>
						</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>调班对象</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>调班日期</p>
								</div></td>
							<td  width="250px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>原排班计划</p>
								</div></td>
							<td  width="250px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>调班后计划</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>当前承办人</p>
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
							<c:forEach items="${list}" var="tp" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								<td height="25" align="center" valign="middle" ><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${fb:faqidai(tp.initiator,tp.applicant)}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${tp.tbname}</div></td>
								<td height="25" align="center" valign="middle" ><div
										align="center">${tp.tbdate}</div></td>
								<td width="250px"  height="25" align="center" valign="middle" ><div
										align="center">${tp.prejihua}</div></td>
								<td width="250px"  height="25" align="center" valign="middle" ><div
										align="center">${tp.nowjihua}</div></td>
								<td width="100px"  height="25" align="center" valign="middle" ><div
										align="center">${fb:newnumbertoname(tp.undertake)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newstatustostring(tp.status)}</div></td>								
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<c:if test="${(newnumber==tp.preundertake)&&(tp.status==2)}">
										<a href="<%=path%>/updatetpstatus.action?number=${tp.number}&newnumber=${newnumber}&type=0">收回</a> 
										&nbsp;&nbsp;
										</c:if>
										<c:if test="${(newnumber==tp.initiator)&&(tp.status==0||tp.status==5)}">
										<a href="<%=path%>/updatetpstatus.action?number=${tp.number}&newnumber=${newnumber}&type=6">撤销</a> 
										&nbsp;&nbsp;
										</c:if>
										<c:if test="${(authoI=='I')&&(xp.status!=6)}">
										<a onclick="return confirm('确定撤销？');" href="<%=path%>/updatetpstatus.action?number=${tp.number}&newnumber=${newnumber}&type=6">撤销</a> 
										&nbsp;&nbsp;
										</c:if>
										<a href="<%=path%>/viewtpdetail.action?number=${tp.number}&newnumber=${newnumber}">查看详情</a>
										</div></td>	
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="14">
								<div align="center">
								<a	href="<%=path%>/viewtbsqall.action?zhuan=1&name=${name}&begindate=${begindate}&enddate=${enddate}&newnumber=${newnumber}&type=${type}&currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/viewtbsqall.action?zhuan=1&name=${name}&begindate=${begindate}&enddate=${enddate}&newnumber=${newnumber}&type=${type}&currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="hidden" name="type" value="${type}"/>
								<input type="hidden" name="newnumber" value="${newnumber}"/>
								<input type="submit" value="跳转"/>	
								</div>
								<br/>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
