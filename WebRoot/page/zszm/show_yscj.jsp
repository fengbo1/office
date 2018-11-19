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

function tijiao()
{
	var yscjlist = document.getElementsByName("yscjchoose");
	//var normprop = document.getElementsByName("kbinormprop");
	var i=0;
	var j=0;
	for(i=0;i<yscjlist.length;i++)
	{
	  
	    if(yscjlist[i].checked)
	    {
            j++;
            break;
	    }
	     
	}
	if(j==0)
	{
	   alert("请选择一个请假审批表");
	   return;
	}
	 with(document.forms[0])
	 {
		action='showzzzmpagetj.action';
	    method="post";
	    submit();
					
	  }	
}
 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/viewyscjall.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="14" align="center" bordercolor="#FFFFFF"><b>已审批通过因私出国（境）</b>
							</td>
						</tr>
						
							<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="125px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="60px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>日期</p>
								</div></td>	
							<td  width="50px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>申请人</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>联系电话</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>拟去国家</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>拟出国时间</p>
								</div></td>			
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>拟回国时间</p>
								</div></td>	
						
							<td  width="80px"  align="center" valign="middle" nowrap
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
							<c:forEach items="${list}" var="yscj" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="125px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yscj.number}</div></td>
								<td width="60px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yscj.date}</div></td>
								<td width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(yscj.initiator)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(yscj.applicant)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yscj.tel}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yscj.tocountry}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yscj.begindate}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${yscj.enddate}</div></td>		
								
								<td width="80px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(yscj.thisunder)}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newstatustostring(yscj.status)}</div></td>
								 
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<input id="${yscj.number}" type="radio"  name="yscjchoose" value="${yscj.number}" />
										<!--<c:if test="${(yscj.status!=4)&&(yscj.status!=6)}">
										<a onClick="return confirm('确定撤销?');"  href="<%=path%>/deleteyscjpage.action?number=${yscj.number}&newnumber=${newnumber}">撤销</a>
										&nbsp;&nbsp;
										</c:if>-->
										<a href="<%=path%>/viewyscjdetail.action?number=${yscj.number}&newnumber=${newnumbers}">查看详情</a>
										</div></td>	
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="14">
								<div align="right">&nbsp; 
						        <input type="hidden" name="name" value="${name}"/>
								<input type="hidden" name="newnumbers" value="${newnumbers}"/>
								<input type="hidden" name="newnumber" value="${newnumber}"/>
								<input type="hidden" name="tel" value="${tel}"/>
								<input type="hidden" name="zhiwu" value="${zhiwu}"/>
								 <input style="width: 60px"  type="button" value="提交" onclick="tijiao()"/>&nbsp; &nbsp; &nbsp; 
								</div>
								<br/>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
