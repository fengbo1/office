<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="office.zcgl.pojo.*" %>
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
 <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
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
$("tr.btbj").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
//$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
//$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
  mergecell();
});


function mergecell()
{
	var tab = document.getElementById('tab');
	
	var sumname = Number(3);
	var sumtype = Number(3);
	var sumchu = Number(3);
	
	<% List listshow=(List) request.getAttribute("listshow");
	   for(int a=0;a<listshow.size();a++)
	   {
	    AssetInfoShowNewBean showinfo = (AssetInfoShowNewBean)listshow.get(a);
	    int size = listshow.size();
	    int namenum = showinfo.getNamenum();
	    int typesize = showinfo.getType().size();
	    int chusize = showinfo.getChu().size();
	 %>
	 var size = <%=a%>;
	//var showcontent = "${ss}";
	//var shows = JSON.parse(showcontent);
	//var shows = eval("(" + showcontent + ")");
	//alert(shows);
	
	
	
	
	  
	   
		var namenum = <%=namenum%>;
	 
		tab.rows[sumname].cells[1].rowSpan = namenum;
		
		for(var j = (Number(sumname)+Number(1));Number(j)<(Number(sumname)+Number(namenum));j++)
		{
			tab.rows[j].cells[1].style.display="none";
		
		}
		<%for (int k = 0; k<typesize; k++){
		   TypeAndNum type = showinfo.getType().get(k);
		   int typenum = type.getTypenum();
		%>
			
			var typenum = <%=typenum%>;
			tab.rows[sumtype].cells[2].rowSpan = typenum;
			for(var m=(Number(sumtype)+Number(1));Number(m)<(Number(sumtype)+Number(typenum));m++)
			{
				tab.rows[m].cells[2].style.display="none";
			}
			sumtype = Number(sumtype)+Number(typenum);
		<%} %>
		
			
			
		<%for (int n = 0; n<chusize; n++)
		{
		    ChuAndNum chu = showinfo.getChu().get(n); 
		    int chunum = chu.getChunum();
		%>
	
			var chunum =<%=chunum%>;
			tab.rows[sumchu].cells[3].rowSpan = chunum;
			for(var l=(Number(sumchu)+Number(1));Number(l)<(Number(sumchu)+Number(chunum));l++)
			{
				tab.rows[l].cells[3].style.display="none";
			}
			sumchu = Number(sumchu)+Number(chunum);
		<%}%>
		sumname= Number(sumname)+Number(namenum);
		
	<%}%>
}

function gettype(){
    
    var types="";
    var	assetname=document.getElementById('assetname').value;
    assetname = encodeURI(assetname); 
    var xmlhttp;
     var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			types=xmlhttp.responseText;
			//alert(yesorno);
				
				//document.getElementById("chutuan").innerHTML=arr[0];
			 typename(types);
		}				
	} 
	xmlhttp.open("GET","getzichansearchleixing.action?assetname="+assetname+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}


function typename(types){

var arry= new Array();
arry=types.split("|"); //字符分割 
var obj=document.getElementById('assettype'); 
obj.options.length=0;
obj.options.add(new Option("-请选择资产型号-","wu"));

for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(arry[i],arry[i])); //这个兼容IE与firefox 
}
} 

function tijiao() {
	 
		  
		  var assetname = document.getElementById("assetname").value; 
		  var assettype = document.getElementById("assettype").value;
	
         	if((assettype!="wu")&&(assetname=="wu"))
          	   {
          	   	 alert("请选择资产名称！");
          	   	 return;
          	   }
         		
	
		     with(document.forms[0]) {
						
						action='viewzcsearchallnewwaibao1.action';
						method="post";
						submit();
					}
				
	  }
	  
	function show(name,type,chu,status)
	{
		var namec = encodeURI(name); 
		var typec = encodeURI(type);
		var chuc = chu;
		var statusc = status
		window.location = "<%=path%>/showsearchdetail.action?name="+namec+"&type="+typec+"&chu="+chuc+"&status="+statusc;
	}
	
	function changeall()
	{
			window.location = "<%=path%>/page/zcgl/changealldrwai.jsp";
	}
	
	function expressoutdetail()
	{
			window.location = "<%=path%>/exportassetchuinfodetail.action";
	}

</script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form action="<%=path%>/viewzcsearchall.action" method="post" name="fm1">
				<br>
					<br>	
					<table id="tab" height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="15" align="center" bordercolor="#FFFFFF"><b>外包资产 </b>
							</td>
						</tr>
						<tr>
							<td colspan="26" height="10px">
								<div align="center">
								
									资产名称
									<select id="assetname" name="assetname"  style="width: 135px" onchange="gettype()">
			                            <option value="wu">-请选择资产名称-</option>
			                           
			                              <c:forEach items="${listinfo}" var="info" varStatus="status">
        						            <option value="${info}">${info}</option>
        				                  </c:forEach>
		                            </select>
		                         
		                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                                                                           型号
		                            <select id="assettype" name="assettype"  style="width: 135px" >
			                        <option value="wu">-请选择资产型号-</option>
			                          
		                            </select>
		                             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                                                                          资产/物品
									<select id="iswupin" name="iswupin" style="width: 135px" >
										<option value="wu">-请选择资产/物品-</option>
										<option value="1">资产</option>
										<option value="2">物品</option>
										
									</select>			
		                             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input style="width:70px" type="button" onclick="tijiao()" value="查询"/>
							        <input style="width:70px" type="button" value="批量修改" onclick="changeall()"/>
							         <input style="width:70px" type="button" value="导出明细" onclick="expressoutdetail()"/>
							</div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
								<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							
							<td  width="200px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>资产名称</p>
								</div></td>
							<td  width="250px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>资产型号</p>
								</div></td>	
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>外包公司</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>使用状态</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>数量</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>详情</p>
								</div></td>						
						   </tr>
							<c:forEach items="${listsingleshow}" var="zcsearch" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="200px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.name}</div></td>
								<td width="250px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.type}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:chutostring(zcsearch.chu)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:assetstatustostring(zcsearch.status)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${zcsearch.num}</div></td>
							    <td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center"><input style="width:70px" type="button" onclick="show('${zcsearch.name}','${zcsearch.type}','${zcsearch.chu}','${zcsearch.status}')"  value="查看详情"/></div></td>	
							</tr>
							</c:forEach>
			
		</table>
		                       <input type="hidden" name="type" value="${type}"/>
								<input type="hidden" name="newnumber" value="${newnumber}"/>
		</form>
  </body>
</html>
