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
	
	function a(){
		 alert("仅添加本处室人员！");
		 $('#p').append("<input type='text' name='people' style='width:50px' onblur='check(this.value)'/>");
		}
	function b(){
		$("input[name='people']").eq($("input[name='people']").size()-1).remove();
		}
	function check(val)
	{
		var allname= document.getElementById("allname").value;
		var chuname= document.getElementById("chuname").value;
		var fndchu = chuname.indexOf(val+'、');
		var fndall = allname.indexOf(val+'、');
		if(fndall==-1)
		{
			alert("姓名【"+val+"】在员工信息中查询不到，请确认是否书写正确！");
		}
		else if(fndchu==-1)
		{
			alert("姓名【"+val+"】在本处室信息中查询不到，请填写本处室员工！");
		}
	}
	//计算休假日期使用 -->
	function jisuan() {
		////////////////////////////////计算日期//////////////////
		var halfday1s=document.getElementsByName("RadioGroup1");
		var halfday2s=document.getElementsByName("RadioGroup2");
		var halfday1="false";
		var halfday2="false";
		if(halfday1s[1].checked==true){
			halfday1="true";
			}
		if(halfday2s[0].checked==true){
			halfday2="true";
			}

		
		var begindate= document.getElementById("begindate").value;
		var enddate= document.getElementById("enddate").value;
	    inoutdate(begindate,enddate,2,halfday1,halfday2);
	}
	//传入日期返回天数
	function inoutdate(begindate,enddate,type,halfday1,halfday2){
	////////提交计算前检查一下///////////////////////////
		var rg10=document.getElementById("RadioGroup1_0");
		var rg11=document.getElementById("RadioGroup1_1");
		var rg20=document.getElementById("RadioGroup2_0");
		var rg21=document.getElementById("RadioGroup2_1");
	    var result = begindate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
        if(result==null)
        { return ;
		 }
        var result2 = enddate.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
        if(result2==null)
        {        
            return;
        }
        var begindates=begindate.replace(/-/g,"/");
		var begindates=new Date(begindates);
		var enddates=enddate.replace(/-/g,"/");
		var enddates=new Date(enddates);	
		if(begindates>enddates){
			alert("公干开始时间不能晚于公干结束时间！");
			return ;
		}
		if(!rg10.checked&&!rg11.checked)
			{
				return;
			}
		if(!rg20.checked&&!rg21.checked)
			{
				return;
			}	
	
	////////提交计算前检查一下///////////////////////////
	var sumdate; 
	var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}	
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				sumdate=xmlhttp.responseText;			
				document.getElementById("sumdate").value=sumdate;
			}				
		} 
		var url="sumdate.action?begindate="+begindate+"&enddate="+enddate+"&type="+type+"&halfday1="+halfday1+"&halfday2="+halfday2;
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
	}

	 function tijiao() {
		var begindate= document.getElementById("begindate").value;
		var enddate= document.getElementById("enddate").value;
		var begindates=begindate.replace(/-/g,"/");
		var begindates=new Date(begindates);
		var enddates=enddate.replace(/-/g,"/");
		var enddates=new Date(enddates);	 
		  
		  var sumdate=document.getElementById("sumdate"); 
		  var xuanze = document.getElementById("xuanze").value;
		  var rg10=document.getElementById("RadioGroup1_0");
		  var rg11=document.getElementById("RadioGroup1_1");
		  var rg20=document.getElementById("RadioGroup2_0");
		  var rg21=document.getElementById("RadioGroup2_1");
		  var reason=document.getElementsByName("reason")[0].value;
		  var addr=document.getElementsByName("addr")[0].value;
		  var tel=document.getElementById("tel").value;
		  var name=document.getElementById("name").value;
		  var chu=document.getElementById("chu").value;
		  var intchu=document.getElementById("intchu").value;
		  var message = "确认提交？";
           var zhi = document.getElementById("zhi").value;

         if((Number(sumdate.value)>=5)&&(zhi!=1))
          {
            message=message+"离开中心超过5天，请按规定冻结工号！";
          }
           
          
		  if(name=="")
		  {
			  alert("请填写姓名");
			  document.getElementById("name").focus();return;
			}
		  else if(chu=="")
		  {
			  alert("请填写处室");
			  document.getElementById("chu").focus();return;
			}
		  else if(tel=="")
		  {
			  alert("请填写联系电话");
			  document.getElementById("tel").focus();return;
			}
		  else if(trim(reason)=="")
		  {
			  alert("请输入公干事由");
			}
		  else if(trim(addr)=="")
		  {
			  alert("请输入公干地点");
			}
		  else if(!rg10.checked&&!rg11.checked)
			{
				alert("请选择上午或下午");
				ii=ii+1;return;
			}
		  else if(!rg20.checked&&!rg21.checked)
			{
				alert("请选择上午或下午");
				ii=ii+1;return;
			}
		  else if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
			else if(begindates>enddates)
			{
				alert("公干开始时间不能晚于公干结束时间！");
				return ;
			}
			else if(sumdate.value==0.0||sumdate.value=="")
			{
				alert("公干天数不得为0天！");
				return;
			}
			else if(isNaN(enddates))
			{
				alert("公干结束时间不可为空！");
				return ;
			}
			else if(isNaN(begindates))
			{
				alert("公干开始时间不可为空！");
				return ;
			}
			else
			{
				if(intchu=='3'||intchu=='6'||intchu=='2')
				{
					alert("注意！请提醒有权人提交因公下线！");
				}
				if (window.confirm(message)) {
					with(document.forms[0]) {
						alert("需所有审批流程完成后方可外出，请自行与审批人联系催办审批事项！");
						action='subwcggpage.action';
						method="post";
						submit();
					}
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
    <form action="subwcggpage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong><font id="bu" style="display:none;">（补）</font>业务处理中心外出公干备案表</strong><strong> </strong></p>
        <table width="860" height="398" border="1" align="center" cellpadding="1" cellspacing="0">
    		<tr>
    			<td width="121" class="as">
    				姓名<b>*</b>
    			</td>
    			<td width="176">
    				<input type="hidden" id="name" name="name" value="${ui.username}"/> 
    				${ui.username}
    			</td>
    			<td width="72" class="as">
    				处室<b>*</b>
    			</td>
    			<td width="175">
    				<input type="hidden" id="chu" name="chu" value="${fb:positiontoname(position)}"/>
    				${fb:positiontoname(position)}
    			</td>
    			<td width="89" class="as">
    				联系方式<b>*</b>
    			</td>
    			<td width="201">
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" />
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="button" id="button" value="添加一位同行人" onclick="a()"/>
    			</td>
    			<td colspan="4" id="p">&nbsp;
    			</td>
    			<td><input type="button" id="button" value="减少一位同行人" onclick="b()"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				公干事由<b>*</b>
    			</td>
    			<td colspan="5">
    				<input type="text" name="reason" style="width:400px"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				公干地点<b>*</b>
    			</td>
    			<td colspan="5">
    				<input type="text" name="addr" style="width:400px"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				往返时间<b>*</b>
    			</td>
    			 <td colspan="5" >
     				<div style="float:left;padding-top:8px;width:110px">从<input size="9" type="text" name="begindate" id="begindate" class="Wdate" onClick="WdatePicker();jisuan()" ></div>
    				 <div style="float:left">  
     					<input type="radio" name="RadioGroup1" value="sw" id="RadioGroup1_0" onClick="jisuan()">上午<br>
        				<input type="radio" name="RadioGroup1" value="xw" id="RadioGroup1_1" onClick="jisuan()">下午    
    				 </div>    
    				 <div style="float:left;padding-top:8px;width:170px"> 起，预计至<input size="9" type="text" name="enddate" id="enddate" class="Wdate" onClick="WdatePicker();jisuan()" ></div>      
    				 <div style="float:left">      
     					<input type="radio" name="RadioGroup2" value="sw" id="RadioGroup2_0" onClick="jisuan()">上午<br>     
       				 <input type="radio" name="RadioGroup2" value="xw" id="RadioGroup2_1" onClick="jisuan()">下午 
     				</div>
    			 <div style="float:left;padding-top:8px;width:140px"> 	
      			 	 止，共<input size="4" readonly="readonly" type="text" name="sumdate"  id="sumdate" onchange="check()">天
    			 </div>
        		</td>
    		</tr>
    		<tr>
    			<td class="as">
    				所在处室意见
    			</td>
    			<td colspan="5">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				中心审批意见
    			</td>
    			<td colspan="5">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				回中心报到时间
    			</td>
    			<td colspan="5">
    				&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				备注
    			</td>
    			<td colspan="5">
    				<input type="text" name="remark" style="width:400px"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="5">
    				<select name="thisunder" id="xuanze">
        				<option value="wu">请选择下一级审批人</option>
        					<c:forEach items="${list}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="chuname" value="${chuname}"/>
    				<input type="hidden" name="allname" value="${allname}"/>
    				<input type="hidden" id="intchu" name="intchu" value="${chu}"/>
    				<input type="hidden" id="zhi" name="zhi" value="${zhi}"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
