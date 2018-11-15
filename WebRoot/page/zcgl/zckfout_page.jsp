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
				alert("导入报废资产为空！");
				return;
			}
			
			var tel = document.getElementById("tel").value; 
			if(tel=="")
			{
				alert("联系方式未填！");
				return;
			}
			with(document.forms[0]) {
			action='subzckfoutpage.action';
			method="post";
			submit();
			}
		}
	
	function show(name,type,number)
	{
		var namec = encodeURI(name); 
		var typec = encodeURI(type);
		var numberc = number;
		window.location = "<%=path%>/showkfout.action?name="+namec+"&type="+typec+"&number="+number;
	}
	function upload()
	{
		with(document.forms[0]) {
			action='importzckfout.action';
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
    	 <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>业务处理中心资产报废表</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr height="50">
    		 <td width="100" class="as" >
    				资产管理员<b>*</b>
    			</td>
    			<td class="as" width="100" >
    				<input style="width:50px" id="username" type="hidden" name="username" value="${ui.username}"  />
    				${ui.username}
    			</td>
    		
    	
   
    			<td class="as">
    				上传报废资产<b>*</b>
    			</td>
    			<td width="500" colspan="3">
    			      <a href="<%=path%>/templet/zcchuku.xls">下载【资产报废表】模板</a><br/>
    			     
    			               请选择要上传的文件：<input type="file" name="file" />
			          <input type="button"  value="上传" onclick="upload()"/>  		
			          		
    				  
    			</td>
    			
    				
    			<td width="100" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td class="as" >
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" />
    			</td>
    	
    		</tr>
    		
    		<tr>
    		<c:if test="${isshow==1}"> 
    				   <c:forEach items="${listtemp}" var="ap" varStatus="status">
    		                 <tr height="40">
    			               <td  class="as" >
    				                                      资产名称<b>*</b>
    			               </td>
    			               <td width="100" class="as" >
    				
    				             ${ap.assetname} 
    			
    			               </td>
    			              <td  class="as" >
    				                                  型号<b>*</b>
    			              </td>
    			              <td width="150" class="as" >
    			  
    				             ${ap.assettype} 
    			
    			              </td>
    			              <td width="100" class="as">
    				                                        数量<b>*</b>
    			              </td>
    		                  <td  class="as" >
    				
    				                                  报废 ${ap.num}件 
    				
    			              </td>
    			              <td  class="as"  colspan="2">
    				
    			                   <input type="button" onclick="show('${ap.assetname}','${ap.assettype}','${ap.rukunum}')" value="查看详情" />    				
    				               
    			              </td>
    		                 </tr>
    		                 </c:forEach>
    				 
    				 
    				          </c:if>
    		</tr>
    		<tr height="40">
    			<td class="as">
    				原因
    			</td>
    			<td colspan="7" >
    				<input type="text" style="width:700px" name="reason" id="reason" />
    				&nbsp;&nbsp;
    			</td>
    		</tr>
    		
    		<tr height="40">
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="7">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="rukunum" value="${rukunum}"/>
    				
    				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="tijiao()" value="提   交" />    				
    				
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
