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
	      var area=document.getElementById("area").value;		
	      var message = "您选择的使用区域是"+area+"确认提交？";
		  if (window.confirm(message)) {
		       with(document.forms[0]) {
						
						action='subchangeareapage.action';
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
    <form action="subchangeareapage.action" method="post">
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
    				使用区域<b>*</b>
    			</td>
    			<td  width="200" class="as" >
    			 <c:if test="${assetinfo.name!='台式办公机'}"> 
    					<select id="area" name="area" style="padding:0px;margin:0px;" >
      		             <option value="${assetinfo.area}">${assetinfo.area}</option>
      		               <option value="四楼值班室">四楼值班室</option>
      		               <option value="四楼设备间1">四楼设备间1</option>
      		               <option value="四楼设备间2">四楼设备间2</option>
      		               <option value="五楼东休息区">五楼东休息区</option>
      		               <option value="五楼设备间">五楼设备间</option>
      		               <option value="501">501</option>
      		               <option value="502">502</option>；
      		               <option value="503">503</option>
      		               <option value="504">504</option>
      		               <option value="505">505</option>
      		               <option value="507">507</option>
      		               <option value="508">508</option>
      		               <option value="509">509</option>
      		               <option value="511">511</option>
      		               <option value="512">512</option>
      		               <option value="母婴室">母婴室</option>
      		               <option value="六楼综合办公区1">六楼综合办公区1</option>
      		               <option value="六楼综合办公区2">六楼综合办公区2</option>
      		               <option value="六楼综合办公区3">六楼综合办公区3</option>
      		               <option value="601">601</option>
      		               <option value="602">602</option>
      		               <option value="605">605</option>
      		               <option value="606">606</option>
      		               <option value="607">607</option>
      		               <option value="608">608</option>
      		               <option value="609">609</option>
      		               <option value="610">610</option>
      		               <option value="611">611</option>
      		               <option value="612">612</option>
      		               <option value="613">613</option>
      		               <option value="614">614</option>
      		               <option value="六楼设备间">六楼设备间</option>
      		               <option value="七楼东工区">七楼东工区</option>
      		               <option value="七楼西工区">七楼西工区</option>
      		               <option value="七楼中间办公室">七楼中间办公室</option>
      		               <option value="七楼西休息室">七楼西休息室</option>
      		               <option value="七楼东休息区">七楼东休息区</option>
      		               <option value="七楼设备间">七楼设备间</option>
      		               <option value="八楼东工区">八楼东工区</option>
      		               <option value="八楼西工区">八楼西工区</option>
      		               <option value="八楼中间办公室">八楼中间办公室</option>
      		               <option value="八楼西休息室">八楼西休息室</option>
      		               <option value="八楼东休息区">八楼东休息区</option>
      		               <option value="八楼设备间">八楼设备间</option>
      		               <option value="九楼培训室">九楼培训室</option>
      		               <option value="九楼中间办公室">九楼中间办公室</option>
      		               <option value="九楼东工区">九楼东工区</option>        
      		               <option value="九楼东休息区">九楼东休息区</option>
                    	</select>
    				  </c:if>
    				   <c:if test="${assetinfo.name=='台式办公机'}">    
    				    <input type="text" name="area"  value="${assetinfo.area}"/>
    				    </c:if>
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
