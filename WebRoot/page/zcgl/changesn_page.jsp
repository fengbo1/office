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
	
	 function tijiao() {
	      var sn=document.getElementById("sn").value;		
	      var message = "您输入的SN号是"+sn+"确认提交？";
		  if (window.confirm(message)) {
		       with(document.forms[0]) {
						
						action='subchangesnpage.action';
						method="post";
						submit();
					}
				}
			
	  }
	      function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
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
    <form action="subchangesnpage.action" method="post">
    	<br>
    		<br>	
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>资产信息明细修改</strong><strong> </strong></p>
        <table id="mytable"  border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr height="50">
    			<td width="200" class="as" >
    				资产名称
    			</td>
    			<td  width="200" class="as" > 			
    				${assetinfo.name}
    			</td>
    			
    		</tr>	
    		<tr height="50">
    			<td width="200" class="as" >
    				资产型号
    			</td>
    			<td  width="200" class="as" >
    				${assetinfo.type}
    			</td>
    			
    		</tr>	
    		<tr height="50">
    			<td width="200" class="as" >
    				资产编号
    			</td>
    			<td  width="200" class="as" >
    				
    				${assetinfo.number}
    			</td>
    			
    		</tr>	
    		<tr height="50">
    			<td width="200" class="as" >
    				使用人
    			</td>
    			<td  width="200" class="as" >
    				
    				${assetinfo.people}
    			</td>
    			
    		</tr>	
    		<tr height="50">
    			<td width="200" class="as" >
    				SN<b>*</b>
    			</td>
    			<td  width="200" class="as" >
    				 <input type="text" id="sn" name="sn" />
    			</td>
    			
    		</tr>	
    		
    		<tr height="40">
    			
    			<td colspan="2" class="as">
    				
    				<input type="hidden" name="number" value="${assetinfo.number}"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			    <input type="hidden" id="name" name="name" value="${name}"/>
		            <input type="hidden" id="type" name="type" value="${type}"/>
		            <input type="hidden" id="chu" name="chu" value="${chu}"/>
		            <input type="hidden" id="status" name="status" value="${status}"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
