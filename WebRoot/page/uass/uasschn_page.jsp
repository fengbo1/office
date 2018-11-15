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
	<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	 $(document).ready(function(){ 

		 var xgpool=document.getElementById("xgpool").value;
		 var xgtype891=document.getElementById("xgtype891").value;
		 var xgitem891=document.getElementById("xgitem891").value;
		 var xgremark1=document.getElementById("xgremark1").value; 
		 var xgtype890=document.getElementById("xgtype890").value;
		 var xgitem890=document.getElementById("xgitem890").value;
		 var xgremark2=document.getElementById("xgremark2").value; 
		 //alert(xgpool+"^"+xgtype891+"^"+xgitem891+"^"+xgtype890+"^"+xgitem890);
		 if(xgpool=='891'||xgpool=='891890'||xgpool=='890891')
		 {
			 document.getElementById("it891").checked=true; 
			 if(xgtype891==1)
			 {
				document.getElementById("rd891_1").checked=true;
				for(var i=0;i<2;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						//alert(xgitem891.substr(i,1));
						document.getElementsByName("it_891_zx")[i].checked=true;
					}
				}
			 }
			 else if(xgtype891==2)
			 {
				document.getElementById("rd891_2").checked=true; 
				for(var i=0;i<13;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						document.getElementsByName("it_891_xg_bb")[i].checked=true;
					}
				}
				for(var i=16;i<32;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						document.getElementsByName("it_891_xg_wb")[i-16].checked=true;
					}
				}
				for(var i=32;i<40;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						document.getElementsByName("it_891_xg_gl")[i-32].checked=true;
					}
				}
				for(var i=40;i<48;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						document.getElementsByName("it_891_xg_jy")[i-40].checked=true;
					}
				}
				document.getElementsByName("qt_891_xg")[0].value=xgremark1;
			 }
			 else if(xgtype891==3)
			 {
				document.getElementById("rd891_3").checked=true; 
				for(var i=0;i<13;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						document.getElementsByName("it_891_xz_bb")[i].checked=true;
					}
				}
				for(var i=16;i<32;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						document.getElementsByName("it_891_xz_wb")[i-16].checked=true;
					}
				}
				for(var i=32;i<40;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						document.getElementsByName("it_891_xz_gl")[i-32].checked=true;
					}
				}
				for(var i=40;i<48;i++)
				{
					if(xgitem891.substr(i,1)=="1")
					{
						document.getElementsByName("it_891_xz_jy")[i-40].checked=true;
					}
				}
				document.getElementsByName("qt_891_xz")[0].value=xgremark1;
			 }
				 
	
		 }
		 if(xgpool=='890'||xgpool=='891890'||xgpool=='890891')
		 {
			 alert(xgtype890);
			 document.getElementById("it890").checked=true; 
			 if(xgtype890==1)
			 {
				document.getElementById("rd890_1").checked=true;
				for(var i=0;i<2;i++)
				{
					if(xgitem890.substr(i,1)=="1")
					{
						document.getElementsByName("it_890_zx")[i].checked=true;
					}
				}
			 }
			 else if(xgtype890==2)
			 {
				document.getElementById("rd890_2").checked=true;
				document.getElementsByName("qt_890_xg")[0].value=xgremark2;
				for(var i=0;i<6;i++)
				{
					if(xgitem890.substr(i,1)=="1")
					{
						document.getElementsByName("it_890_xg")[i].checked=true;
					}
				}
			}
			 else if(xgtype890==3)
			 {
				document.getElementById("rd890_3").checked=true;
				document.getElementsByName("qt_890_xz")[0].value=xgremark2;
				for(var i=0;i<6;i++)
				{
					if(xgitem890.substr(i,1)=="1")
					{
						document.getElementsByName("it_890_xz")[i].checked=true;
					}
				}
			}
		 }
		 });
	

	 function tijiao() {
		  var xuanze = document.getElementById("xuanze").value;
		  var tel=document.getElementById("tel").value;
		  var name=document.getElementById("name").value;
		  var sxtime=document.getElementById("sxtime").value;
		  var nowdate=document.getElementById("nowdate").value;
		  var message = "确认提交？";
		  if(sxtime<=nowdate)
			{
				alert("生效日期应晚于今日！");
				  return;
			}
		  if('${type}'=='new')
		  {
			  alert("请至少保存一位维护对象");
			  return;
			}
		  if(tel=="")
		  {
			  alert("请填写联系电话");
			  document.getElementById("tel").focus();return;
			}
		  else if(xuanze=="wu")
			{
				alert("请选择下一级审批人");return;
			}
		  else if(sxtime=="")
			{
				alert("请填写生效时间");return;
			}
			else
			{
				if (window.confirm(message)) {
					with(document.forms[0]) {
						action='uschsubpage.action';
						method="post";
						submit();
					}
				}
			}
	  }
	 function trim(str){ //删除左右两端的空格
		    return str.replace(/(^\s*)|(\s*$)/g, "");
		} 

	function baocun()
	{
		var it891=document.getElementById("it891");
		var it890=document.getElementById("it890");
		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■891注销■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		var it_891_zx_1=document.getElementById("it_891_zx_1");
		var it_891_zx_2=document.getElementById("it_891_zx_2");
		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■891修改■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		var it_891_xg_bb_1=document.getElementById("it_891_xg_bb_1");
		var it_891_xg_bb_2=document.getElementById("it_891_xg_bb_2");
		var it_891_xg_bb_3=document.getElementById("it_891_xg_bb_3");
		var it_891_xg_bb_4=document.getElementById("it_891_xg_bb_4");
		var it_891_xg_bb_5=document.getElementById("it_891_xg_bb_5");
		var it_891_xg_bb_6=document.getElementById("it_891_xg_bb_6");
		var it_891_xg_bb_7=document.getElementById("it_891_xg_bb_7");
		var it_891_xg_bb_8=document.getElementById("it_891_xg_bb_8");
		var it_891_xg_bb_9=document.getElementById("it_891_xg_bb_9");
		var it_891_xg_bb_10=document.getElementById("it_891_xg_bb_10");
		var it_891_xg_bb_11=document.getElementById("it_891_xg_bb_11");
		var it_891_xg_bb_12=document.getElementById("it_891_xg_bb_12");
		var it_891_xg_bb_13=document.getElementById("it_891_xg_bb_13");

		var it_891_xg_wb_1=document.getElementById("it_891_xg_wb_1");
		var it_891_xg_wb_2=document.getElementById("it_891_xg_wb_2");
		var it_891_xg_wb_3=document.getElementById("it_891_xg_wb_3");
		var it_891_xg_wb_4=document.getElementById("it_891_xg_wb_4");
		var it_891_xg_wb_5=document.getElementById("it_891_xg_wb_5");
		var it_891_xg_wb_6=document.getElementById("it_891_xg_wb_6");
		var it_891_xg_wb_7=document.getElementById("it_891_xg_wb_7");
		var it_891_xg_wb_8=document.getElementById("it_891_xg_wb_8");
		var it_891_xg_wb_9=document.getElementById("it_891_xg_wb_9");
		var it_891_xg_wb_10=document.getElementById("it_891_xg_wb_10");
		var it_891_xg_wb_11=document.getElementById("it_891_xg_wb_11");
		var it_891_xg_wb_12=document.getElementById("it_891_xg_wb_12");
		var it_891_xg_wb_13=document.getElementById("it_891_xg_wb_13");
		var it_891_xg_wb_14=document.getElementById("it_891_xg_wb_14");
		var it_891_xg_wb_15=document.getElementById("it_891_xg_wb_15");
		var it_891_xg_wb_16=document.getElementById("it_891_xg_wb_16");

		var it_891_xg_gl_1=document.getElementById("it_891_xg_gl_1");
		var it_891_xg_gl_2=document.getElementById("it_891_xg_gl_2");
		var it_891_xg_gl_3=document.getElementById("it_891_xg_gl_3");
		var it_891_xg_gl_4=document.getElementById("it_891_xg_gl_4");
		var it_891_xg_gl_5=document.getElementById("it_891_xg_gl_5");
		var it_891_xg_gl_6=document.getElementById("it_891_xg_gl_6");
		var it_891_xg_gl_7=document.getElementById("it_891_xg_gl_7");

		var it_891_xg_jy_1=document.getElementById("it_891_xg_jy_1");
		var it_891_xg_jy_2=document.getElementById("it_891_xg_jy_2");
		var it_891_xg_jy_3=document.getElementById("it_891_xg_jy_3");

		var it_891_xg_qt=document.getElementById("it_891_xg_qt");
		
		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■891新增■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		var it_891_xz_bb_1=document.getElementById("it_891_xz_bb_1");
		var it_891_xz_bb_2=document.getElementById("it_891_xz_bb_2");
		var it_891_xz_bb_3=document.getElementById("it_891_xz_bb_3");
		var it_891_xz_bb_4=document.getElementById("it_891_xz_bb_4");
		var it_891_xz_bb_5=document.getElementById("it_891_xz_bb_5");
		var it_891_xz_bb_6=document.getElementById("it_891_xz_bb_6");
		var it_891_xz_bb_7=document.getElementById("it_891_xz_bb_7");
		var it_891_xz_bb_8=document.getElementById("it_891_xz_bb_8");
		var it_891_xz_bb_9=document.getElementById("it_891_xz_bb_9");
		var it_891_xz_bb_10=document.getElementById("it_891_xz_bb_10");
		var it_891_xz_bb_11=document.getElementById("it_891_xz_bb_11");
		var it_891_xz_bb_12=document.getElementById("it_891_xz_bb_12");
		var it_891_xz_bb_13=document.getElementById("it_891_xz_bb_13");

		var it_891_xz_wb_1=document.getElementById("it_891_xz_wb_1");
		var it_891_xz_wb_2=document.getElementById("it_891_xz_wb_2");
		var it_891_xz_wb_3=document.getElementById("it_891_xz_wb_3");
		var it_891_xz_wb_4=document.getElementById("it_891_xz_wb_4");
		var it_891_xz_wb_5=document.getElementById("it_891_xz_wb_5");
		var it_891_xz_wb_6=document.getElementById("it_891_xz_wb_6");
		var it_891_xz_wb_7=document.getElementById("it_891_xz_wb_7");
		var it_891_xz_wb_8=document.getElementById("it_891_xz_wb_8");
		var it_891_xz_wb_9=document.getElementById("it_891_xz_wb_9");
		var it_891_xz_wb_10=document.getElementById("it_891_xz_wb_10");
		var it_891_xz_wb_11=document.getElementById("it_891_xz_wb_11");
		var it_891_xz_wb_12=document.getElementById("it_891_xz_wb_12");
		var it_891_xz_wb_13=document.getElementById("it_891_xz_wb_13");
		var it_891_xz_wb_14=document.getElementById("it_891_xz_wb_14");
		var it_891_xz_wb_15=document.getElementById("it_891_xz_wb_15");
		var it_891_xz_wb_16=document.getElementById("it_891_xz_wb_16");

		var it_891_xz_gl_1=document.getElementById("it_891_xz_gl_1");
		var it_891_xz_gl_2=document.getElementById("it_891_xz_gl_2");
		var it_891_xz_gl_3=document.getElementById("it_891_xz_gl_3");
		var it_891_xz_gl_4=document.getElementById("it_891_xz_gl_4");
		var it_891_xz_gl_5=document.getElementById("it_891_xz_gl_5");
		var it_891_xz_gl_6=document.getElementById("it_891_xz_gl_6");
		var it_891_xz_gl_7=document.getElementById("it_891_xz_gl_7");

		var it_891_xz_jy_1=document.getElementById("it_891_xz_jy_1");
		var it_891_xz_jy_2=document.getElementById("it_891_xz_jy_2");
		var it_891_xz_jy_3=document.getElementById("it_891_xz_jy_3");

		var it_891_xz_qt=document.getElementById("it_891_xz_qt");

		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■890注销■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		var it_890_zx_1=document.getElementById("it_890_zx_1");
		var it_890_zx_2=document.getElementById("it_890_zx_2");

		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■890修改■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		var it_890_xg_1=document.getElementById("it_890_xg_1");
		var it_890_xg_2=document.getElementById("it_890_xg_2");
		var it_890_xg_3=document.getElementById("it_890_xg_3");
		var it_890_xg_4=document.getElementById("it_890_xg_4");
		var it_890_xg_5=document.getElementById("it_890_xg_5");
		var it_890_xg_6=document.getElementById("it_890_xg_6");

		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■890新增■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		var it_890_xz_1=document.getElementById("it_890_xz_1");
		var it_890_xz_2=document.getElementById("it_890_xz_2");
		var it_890_xz_3=document.getElementById("it_890_xz_3");
		var it_890_xz_4=document.getElementById("it_890_xz_4");
		var it_890_xz_5=document.getElementById("it_890_xz_5");
		var it_890_xz_6=document.getElementById("it_890_xz_6");

		//■■■■■■■■■■■■■■■■■■■■■■■■■■■■radio■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		var rd891_1=document.getElementById("rd891_1");
		var rd891_2=document.getElementById("rd891_2");
		var rd891_3=document.getElementById("rd891_3");
		var rd890_1=document.getElementById("rd890_1");
		var rd890_2=document.getElementById("rd890_2");
		var rd890_3=document.getElementById("rd890_3");

		//alert(it_891_xg_bb_1.value);
		if(it891==null)
		{
			return;
		}

		var pool = "";
		var check891zx = "";
		var check891xg = "";
		var check891xz = "";
		var check890 = "";
		//任务池
		if(it890.checked)
		{
			//alert('890');
			pool+="890";
		}
		if(it891.checked)
		{
			//alert('891');
			pool+="891";
		}
		if(!it890.checked&&!it891.checked)
		{
			alert("请选择任务池");
			return;
		}
		if(it891.checked&&!rd891_1.checked&&!rd891_2.checked&&!rd891_3.checked||it890.checked&&!rd890_1.checked&&!rd890_2.checked&&!rd890_3.checked)
		{
			alert("请选择维护事项");
			return;
		}
		//勾选框
		check891zx = ifchk(it_891_zx_1)+ifchk(it_891_zx_2);
		check891xg = ifchk(it_891_xg_bb_1)+ifchk(it_891_xg_bb_2)
					+ifchk(it_891_xg_bb_3)+ifchk(it_891_xg_bb_4)
					+ifchk(it_891_xg_bb_5)+ifchk(it_891_xg_bb_6)
					+ifchk(it_891_xg_bb_7)+ifchk(it_891_xg_bb_8)
					+ifchk(it_891_xg_bb_9)+ifchk(it_891_xg_bb_10)
					+ifchk(it_891_xg_bb_11)+ifchk(it_891_xg_bb_12)
					+ifchk(it_891_xg_bb_13)+"000"//16位
					+ifchk(it_891_xg_wb_1)+ifchk(it_891_xg_wb_2)
					+ifchk(it_891_xg_wb_3)+ifchk(it_891_xg_wb_4)
					+ifchk(it_891_xg_wb_5)+ifchk(it_891_xg_wb_6)
					+ifchk(it_891_xg_wb_7)+ifchk(it_891_xg_wb_8)
					+ifchk(it_891_xg_wb_9)+ifchk(it_891_xg_wb_10)
					+ifchk(it_891_xg_wb_11)+ifchk(it_891_xg_wb_12)
					+ifchk(it_891_xg_wb_13)+ifchk(it_891_xg_wb_14)
					+ifchk(it_891_xg_wb_15)+ifchk(it_891_xg_wb_16)
					
					+ifchk(it_891_xg_gl_1)+ifchk(it_891_xg_gl_2)
					+ifchk(it_891_xg_gl_3)+ifchk(it_891_xg_gl_4)
					+ifchk(it_891_xg_gl_5)+ifchk(it_891_xg_gl_6)
					+ifchk(it_891_xg_gl_7)+ifchk(it_891_xg_qt)
					+ifchk(it_891_xg_jy_1)+ifchk(it_891_xg_jy_2)
					+ifchk(it_891_xg_jy_3)+"00";//一共45位
		check891xz = ifchk(it_891_xz_bb_1)+ifchk(it_891_xz_bb_2)
					+ifchk(it_891_xz_bb_3)+ifchk(it_891_xz_bb_4)
					+ifchk(it_891_xz_bb_5)+ifchk(it_891_xz_bb_6)
					+ifchk(it_891_xz_bb_7)+ifchk(it_891_xz_bb_8)
					+ifchk(it_891_xz_bb_9)+ifchk(it_891_xz_bb_10)
					+ifchk(it_891_xz_bb_11)+ifchk(it_891_xz_bb_12)
					+ifchk(it_891_xz_bb_13)+"000"//16位
					+ifchk(it_891_xz_wb_1)+ifchk(it_891_xz_wb_2)
					+ifchk(it_891_xz_wb_3)+ifchk(it_891_xz_wb_4)
					+ifchk(it_891_xz_wb_5)+ifchk(it_891_xz_wb_6)
					+ifchk(it_891_xz_wb_7)+ifchk(it_891_xz_wb_8)
					+ifchk(it_891_xz_wb_9)+ifchk(it_891_xz_wb_10)
					+ifchk(it_891_xz_wb_11)+ifchk(it_891_xz_wb_12)
					+ifchk(it_891_xz_wb_13)+ifchk(it_891_xz_wb_14)
					+ifchk(it_891_xz_wb_15)+ifchk(it_891_xz_wb_16)

					+ifchk(it_891_xz_gl_1)+ifchk(it_891_xz_gl_2)
					+ifchk(it_891_xz_gl_3)+ifchk(it_891_xz_gl_4)
					+ifchk(it_891_xz_gl_5)+ifchk(it_891_xz_gl_6)
					+ifchk(it_891_xz_gl_7)+ifchk(it_891_xz_qt)
					+ifchk(it_891_xz_jy_1)+ifchk(it_891_xz_jy_2)
					+ifchk(it_891_xz_jy_3)+"00";//一共45位			
		check890 = ifchk(it_890_zx_1)+ifchk(it_890_zx_2)
					+ifchk(it_890_xg_1)+ifchk(it_890_xg_2)
					+ifchk(it_890_xg_3)+ifchk(it_890_xg_4)
					+ifchk(it_890_xg_5)+ifchk(it_890_xg_6)
					+ifchk(it_890_xz_1)+ifchk(it_890_xz_2)
					+ifchk(it_890_xz_3)+ifchk(it_890_xz_4)
					+ifchk(it_890_xz_5)+ifchk(it_890_xz_6);	
		//alert(check891zx+"^"+check891xg+"^"+check891xz+"^"+check890);	
		var message = "确认保存？";
		if (window.confirm(message)) {
			with(document.forms[0]) {
				action='uschbaocun.action?pool='+pool+'&check891zx='+check891zx+'&check891xg='+check891xg+'&check891xz='+check891xz+'&check890='+check890+'&type=baocun';
				method="post";
				submit();
			}
		}
		}

	/*选中1，未选中0*/
	function ifchk(obj)
	{
		if(obj.checked)
		{
			return "1";
		}
		else
		{
			return "0";
		}
	}

	function xinzeng()
	{
		var message = "确认新增？";
		if (window.confirm(message)) {
			with(document.forms[0]) {
				action='uschbaocun.action?type=xinzeng&uchpid=0';
				method="post";
				submit();
			}
		}
		}

	function showitem(pool)
	{
		var addp = "";
		if(document.getElementById("addp")!=null)
		{
			 addp = document.getElementById("addp").value;
			 addp=encodeURI(addp);
		}
		var number = document.getElementsByName("number")[0].value;
		 var newnumber = document.getElementsByName("newnumber")[0].value;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				yesorno=xmlhttp.responseText;
				//alert(yesorno);
				var arr=yesorno.split("|");
				if(pool=='891')
				{
					for(var i=0;i<13;i++)
					{
						if(arr[1].substr(i,1)=="1")
						{
							document.getElementsByName("it_891_xg_bb")[i].checked=true;
						}
					}
					for(var i=0;i<16;i++)
					{
						if(arr[2].substr(i,1)=="1")
						{
							document.getElementsByName("it_891_xg_wb")[i].checked=true;
						}
					}
					for(var i=0;i<7;i++)
					{
						if(arr[3].substr(i,1)=="1")
						{
							document.getElementsByName("it_891_xg_gl")[i].checked=true;
						}
					}
					for(var i=0;i<3;i++)//建亚
					{
						if(arr[7].substr(i,1)=="1")
						{
							document.getElementsByName("it_891_xg_jy")[i].checked=true;
						}
					}
				}
				else if(pool=='890')
				{
					for(var i=0;i<5;i++)
					{
						if(arr[4].substr(i,1)=="1")
						{
							document.getElementsByName("it_890_xg")[i].checked=true;
						}
					}
				}
				else if(pool=='zx891')
				{
					if(arr[5]=="1")
					{
						document.getElementById("it_891_zx_2").checked=true;
					}
					else
					{
						document.getElementById("it_891_zx_1").checked=true;
					}
				}
				else if(pool=='zx890')
				{
					if(arr[6]=="1")
					{
						document.getElementById("it_890_zx_2").checked=true;
					}
					else
					{
						document.getElementById("it_890_zx_1").checked=true;
					}
				}
			}				
		}
		xmlhttp.open("GET","uschshowitem.action?number="+number+"&addp="+addp+"&newnumber="+newnumber,true);
		xmlhttp.send();
	}

	function changeradio(rd)
	{
		if(rd=='zx891')
		{
			for(var i=0;i<2;i++)
			{
				document.getElementsByName("it_891_zx")[i].checked=false;
				document.getElementsByName("it_891_zx")[i].disabled=false;	
			}
///////////////			
			for(var i=0;i<13;i++)
			{
				document.getElementsByName("it_891_xz_bb")[i].checked=false;
				document.getElementsByName("it_891_xz_bb")[i].disabled=true;	
			}
			for(var i=0;i<16;i++)
			{
				document.getElementsByName("it_891_xz_wb")[i].checked=false;
				document.getElementsByName("it_891_xz_wb")[i].disabled=true;	
			}
			for(var i=0;i<8;i++)
			{
				document.getElementsByName("it_891_xz_gl")[i].checked=false;
				document.getElementsByName("it_891_xz_gl")[i].disabled=true;	
			}
			for(var i=0;i<3;i++)
			{
				document.getElementsByName("it_891_xz_jy")[i].checked=false;
				document.getElementsByName("it_891_xz_jy")[i].disabled=true;	
			}
//////////
			for(var i=0;i<13;i++)
			{
				document.getElementsByName("it_891_xg_bb")[i].checked=false;
				document.getElementsByName("it_891_xg_bb")[i].disabled=true;	
			}
			for(var i=0;i<16;i++)
			{
				document.getElementsByName("it_891_xg_wb")[i].checked=false;
				document.getElementsByName("it_891_xg_wb")[i].disabled=true;	
			}
			for(var i=0;i<8;i++)
			{
				document.getElementsByName("it_891_xg_gl")[i].checked=false;
				document.getElementsByName("it_891_xg_gl")[i].disabled=true;	
			}
			for(var i=0;i<3;i++)
			{
				document.getElementsByName("it_891_xg_jy")[i].checked=false;
				document.getElementsByName("it_891_xg_jy")[i].disabled=true;	
			}
		}
		else if(rd=='xg891')
		{
			for(var i=0;i<2;i++)
			{
				document.getElementsByName("it_891_zx")[i].checked=false;
				document.getElementsByName("it_891_zx")[i].disabled=true;	
			}
///////////////			
			for(var i=0;i<13;i++)
			{
				document.getElementsByName("it_891_xz_bb")[i].checked=false;
				document.getElementsByName("it_891_xz_bb")[i].disabled=true;	
			}
			for(var i=0;i<16;i++)
			{
				document.getElementsByName("it_891_xz_wb")[i].checked=false;
				document.getElementsByName("it_891_xz_wb")[i].disabled=true;	
			}
			for(var i=0;i<8;i++)
			{
				document.getElementsByName("it_891_xz_gl")[i].checked=false;
				document.getElementsByName("it_891_xz_gl")[i].disabled=true;	
			}
			for(var i=0;i<3;i++)
			{
				document.getElementsByName("it_891_xz_jy")[i].checked=false;
				document.getElementsByName("it_891_xz_jy")[i].disabled=true;	
			}
//////////
			for(var i=0;i<13;i++)
			{
				document.getElementsByName("it_891_xg_bb")[i].checked=false;
				document.getElementsByName("it_891_xg_bb")[i].disabled=false;	
			}
			for(var i=0;i<16;i++)
			{
				document.getElementsByName("it_891_xg_wb")[i].checked=false;
				document.getElementsByName("it_891_xg_wb")[i].disabled=false;	
			}
			for(var i=0;i<8;i++)
			{
				document.getElementsByName("it_891_xg_gl")[i].checked=false;
				document.getElementsByName("it_891_xg_gl")[i].disabled=false;	
			}
			for(var i=0;i<3;i++)
			{
				document.getElementsByName("it_891_xg_jy")[i].checked=false;
				document.getElementsByName("it_891_xg_jy")[i].disabled=false;	
			}
		}
		else if(rd=='xz891')
		{
			for(var i=0;i<2;i++)
			{
				document.getElementsByName("it_891_zx")[i].checked=false;
				document.getElementsByName("it_891_zx")[i].disabled=true;	
			}
///////////////			
			for(var i=0;i<13;i++)
			{
				document.getElementsByName("it_891_xz_bb")[i].checked=false;
				document.getElementsByName("it_891_xz_bb")[i].disabled=false;	
			}
			for(var i=0;i<16;i++)
			{
				document.getElementsByName("it_891_xz_wb")[i].checked=false;
				document.getElementsByName("it_891_xz_wb")[i].disabled=false;	
			}
			for(var i=0;i<8;i++)
			{
				document.getElementsByName("it_891_xz_gl")[i].checked=false;
				document.getElementsByName("it_891_xz_gl")[i].disabled=false;	
			}
			for(var i=0;i<3;i++)
			{
				document.getElementsByName("it_891_xz_jy")[i].checked=false;
				document.getElementsByName("it_891_xz_jy")[i].disabled=false;	
			}
//////////
			for(var i=0;i<13;i++)
			{
				document.getElementsByName("it_891_xg_bb")[i].checked=false;
				document.getElementsByName("it_891_xg_bb")[i].disabled=true;	
			}
			for(var i=0;i<16;i++)
			{
				document.getElementsByName("it_891_xg_wb")[i].checked=false;
				document.getElementsByName("it_891_xg_wb")[i].disabled=true;	
			}
			for(var i=0;i<8;i++)
			{
				document.getElementsByName("it_891_xg_gl")[i].checked=false;
				document.getElementsByName("it_891_xg_gl")[i].disabled=true;	
			}
			for(var i=0;i<3;i++)
			{
				document.getElementsByName("it_891_xg_jy")[i].checked=false;
				document.getElementsByName("it_891_xg_jy")[i].disabled=true;	
			}
		}

		else if(rd=='zx890')
		{
			for(var i=0;i<2;i++)
			{
				document.getElementsByName("it_890_zx")[i].checked=false;
				document.getElementsByName("it_890_zx")[i].disabled=false;	
			}
///////////////			
			for(var i=0;i<6;i++)
			{
				document.getElementsByName("it_890_xz")[i].checked=false;
				document.getElementsByName("it_890_xz")[i].disabled=true;	
			}
//////////
			for(var i=0;i<6;i++)
			{
				document.getElementsByName("it_890_xg")[i].checked=false;
				document.getElementsByName("it_890_xg")[i].disabled=true;	
			}
		}

		else if(rd=='xg890')
		{
			for(var i=0;i<2;i++)
			{
				document.getElementsByName("it_890_zx")[i].checked=false;
				document.getElementsByName("it_890_zx")[i].disabled=true;	
			}
///////////////			
			for(var i=0;i<6;i++)
			{
				document.getElementsByName("it_890_xz")[i].checked=false;
				document.getElementsByName("it_890_xz")[i].disabled=true;	
			}
//////////
			for(var i=0;i<6;i++)
			{
				document.getElementsByName("it_890_xg")[i].checked=false;
				document.getElementsByName("it_890_xg")[i].disabled=false;	
			}
		}

		else if(rd=='xz890')
		{
			for(var i=0;i<2;i++)
			{
				document.getElementsByName("it_890_zx")[i].checked=false;
				document.getElementsByName("it_890_zx")[i].disabled=true;	
			}
///////////////			
			for(var i=0;i<6;i++)
			{
				document.getElementsByName("it_890_xz")[i].checked=false;
				document.getElementsByName("it_890_xz")[i].disabled=false;	
			}
//////////
			for(var i=0;i<6;i++)
			{
				document.getElementsByName("it_890_xg")[i].checked=false;
				document.getElementsByName("it_890_xg")[i].disabled=true;	
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
  </head>
  
  <body>
  <b>${message}</b>
    <form action="subusptpage.action" method="post">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>行方COS_T系统用户维护申请表</strong></p>
        <table width="860" height="550" border="1" align="center" cellpadding="1" cellspacing="0">
        	<tr>
        		<td width="12.5%">
        		</td>
        		<td width="7.5%">
        		</td>
        		<td width="7.5%">
        		</td>
        		<td width="22.5%">
        		</td>
        		<td width="12.5%">
        		</td>
        		<td width="37.5%">
        		</td>
        		
        	</tr>
    		<tr>
    		
    			<td class="as">
    					发起人<b>*</b>
    			</td>
    			<td  colspan="3">
    				<input type="hidden" id="name" name="name" value="${ui.username}"/> 
    				${ui.username}
    			</td>
    			<td class="as">
    				用户编号<b>*</b>
    			</td>
    			<td>
    				${ui.newnumber}
    			</td>
    		</tr>
    		<tr>	
    			<td class="as">
    				所在处室<b>*</b>
    			</td>
    			<td  colspan="3">
    				<input type="hidden" id="chu" name="chu" value="${fb:positiontoname(position)}"/>
    				${fb:positiontoname(position)}
    			</td>
    			<td class="as">
    				移动电话<b>*</b>
    			</td>
    			<td>
    				<input id="tel" style="IME-MODE: disabled;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" name="tel" type="text" value="${tel}"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				维护对象<b>*</b>
    			</td>
    			<td colspan="5" id="p">
    				<c:if test="${type=='new'&&brdf=='br'}">
    					${ui.username}
    				</c:if>
    				<c:if test="${type=='xinzeng'||type=='baocun'||type=='xg'}">
    				<c:forEach items="${listuchp}" var="uchp" varStatus="status">
    					${uchp.name}&nbsp;&nbsp;&nbsp;&nbsp;${uchp.content891};${uchp.content890}
    					<a href="<%=path%>/uschxiugai.action?type=xg&number=${number}&newnumber=${newnumber}&uchpid=${uchp.id}">修改</a> 
    					&nbsp;
    					<a href="<%=path%>/uschxiugai.action?type=sc&number=${number}&newnumber=${newnumber}&uchpid=${uchp.id}">删除</a> 
    					<br/>
    				</c:forEach>
    				</c:if>
    				<c:if test="${type!='baocun'&&(type!='new'||brdf=='df')}">
    					填写姓名<input type="text" id="addp" name="addp" value="${uchpxg.name}"/>
    				</c:if>
    				
    			</td>
    		</tr>
    		<c:if test="${type!='baocun'}">
    		<tr>
    			<td class="as" rowspan="10">
    				维护内容<b>*</b>
    			</td>
    		</tr>
    		<tr>
    			<td class="as" rowspan="5">
    				<input type="checkbox" id="it891" name="it891"/>
    				891任务池
    			</td>
    		</tr>
    		<tr>
    			<td class="as" >
    				维护<br/>事项
    			</td>
    			<td class="as" colspan="3">
    				维护内容
    			</td>
    		</tr>
    		<tr>
    			<td class="as" >
    				<input type="radio" id="rd891_1" name="rd891" value="zx" onclick="changeradio('zx891');showitem('zx891')"/>状态变更
    			</td>
    			<td colspan="3">
    				<input type="radio" id="it_891_zx_1" name="it_891_zx"/>注销&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" id="it_891_zx_2" name="it_891_zx"/>生效<br/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as" >
    				<input type="radio" id="rd891_2" name="rd891" value="xg" onclick="changeradio('xg891');showitem('891')"/>修改
    			</td>
    			<td colspan="3">
    				<input type="checkbox" id="it_891_xg_bb_1" name="it_891_xg_bb"/>基本信息查询角色
    				<br/>
    				本币<br/>
    				<input type="checkbox" id="it_891_xg_bb_2" name="it_891_xg_bb"/>人工影像拆分角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_bb_3" name="it_891_xg_bb"/>人工版面识别角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_bb_4" name="it_891_xg_bb"/>录入修改角色
    				<br/>
    				<input type="checkbox" id="it_891_xg_bb_5" name="it_891_xg_bb"/>录入修改主管角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_bb_6" name="it_891_xg_bb"/>检核修改角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_bb_7" name="it_891_xg_bb"/>检核修改主管角色
    				<br/>
    				<input type="checkbox" id="it_891_xg_bb_8" name="it_891_xg_bb"/>初审录入&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_bb_9" name="it_891_xg_bb"/>专业复审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_bb_10" name="it_891_xg_bb"/>对公账户资料处理
    				<br/>
    				<input type="checkbox" id="it_891_xg_bb_11" name="it_891_xg_bb"/>人工分析CCBS失败角色
    				<input type="checkbox" id="it_891_xg_bb_12" name="it_891_xg_bb"/>商户资料审核&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_bb_13" name="it_891_xg_bb"/>商户发布失败处理
    				
    				<br/>
    				<br/>
    				外币<br/>
    				<input type="checkbox" id="it_891_xg_wb_1" name="it_891_xg_wb"/>对私汇出初审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_2" name="it_891_xg_wb"/>对私汇出复审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_3" name="it_891_xg_wb"/>外汇票据初审<br/>
    				<input type="checkbox" id="it_891_xg_wb_4" name="it_891_xg_wb"/>外汇票据复审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_5" name="it_891_xg_wb"/>外汇检核修改授权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_6" name="it_891_xg_wb"/>外汇检核修改<br/>
    				<input type="checkbox" id="it_891_xg_wb_7" name="it_891_xg_wb"/>外汇失败原因分析&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_8" name="it_891_xg_wb"/>外汇录入修改授权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_9" name="it_891_xg_wb"/>外汇录入修改<br/>
    				<input type="checkbox" id="it_891_xg_wb_10" name="it_891_xg_wb"/>外汇专项查询角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_11" name="it_891_xg_wb"/>外汇汇入对私初审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_12" name="it_891_xg_wb"/>外汇汇入对私复审<br/>
    				<input type="checkbox" id="it_891_xg_wb_13" name="it_891_xg_wb"/>对公汇出初审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_14" name="it_891_xg_wb"/>对公汇出复审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_wb_15" name="it_891_xg_wb"/>外汇汇入对公初审<br/>
    				<input type="checkbox" id="it_891_xg_wb_16" name="it_891_xg_wb"/>外汇汇入对公复审<br/>
    				<br/>
    				生产管理<br/>
    				<input type="checkbox" id="it_891_xg_gl_1" name="it_891_xg_gl"/>报表查询角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_gl_2" name="it_891_xg_gl"/>生产排班角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_gl_3" name="it_891_xg_gl"/>生产排班管理角色<br/>
    				<input type="checkbox" id="it_891_xg_gl_4" name="it_891_xg_gl"/>日始日终角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_gl_5" name="it_891_xg_gl"/>统计分析角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="hidden" id="it_891_xg_gl_6" name="it_891_xg_gl" /><!-- 总行业务监控角色 <br/>-->
    				<input type="checkbox" id="it_891_xg_gl_7" name="it_891_xg_gl"/>总行集中处理中心监控角色<br/>
    				<br/>
    				建亚<br/>
    				<input type="checkbox" id="it_891_xg_jy_1" name="it_891_xg_jy"/>海外要素录入修改&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_jy_2" name="it_891_xg_jy"/>海外录入修改复核&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xg_jy_3" name="it_891_xg_jy"/>海外票据审核<br/>
    				<br/>
    				其他<br/>
    				<input type="checkbox" id="it_891_xg_qt" name="it_891_xg_gl"/>
    				<input type="text" name="qt_891_xg"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as" >
    				<input type="radio" id="rd891_3" name="rd891" value="xz"  onclick="changeradio('xz891')"/>新增
    			</td>
    			<td colspan="3">
    				<input type="checkbox" id="it_891_xz_bb_1" name="it_891_xz_bb"/>基本信息查询角色
    				<br/>
    				本币<br/>
    				<input type="checkbox" id="it_891_xz_bb_2" name="it_891_xz_bb"/>人工影像拆分角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_bb_3" name="it_891_xz_bb"/>人工版面识别角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_bb_4" name="it_891_xz_bb"/>录入修改角色
    				<br/>
    				<input type="checkbox" id="it_891_xz_bb_5" name="it_891_xz_bb"/>录入修改主管角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_bb_6" name="it_891_xz_bb"/>检核修改角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_bb_7" name="it_891_xz_bb"/>检核修改主管角色
    				<br/>
    				<input type="checkbox" id="it_891_xz_bb_8" name="it_891_xz_bb"/>初审录入&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_bb_9" name="it_891_xz_bb"/>专业复审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_bb_10" name="it_891_xz_bb"/>对公账户资料处理
    				<br/>
    				<input type="checkbox" id="it_891_xz_bb_11" name="it_891_xz_bb"/>人工分析CCBS失败角色
    				<input type="checkbox" id="it_891_xz_bb_12" name="it_891_xz_bb"/>商户资料审核&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_bb_13" name="it_891_xz_bb"/>商户发布失败处理
    				
    				<br/>
    				<br/>
    				外币<br/>
    				<input type="checkbox" id="it_891_xz_wb_1" name="it_891_xz_wb"/>对私汇出初审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_2" name="it_891_xz_wb"/>对私汇出复审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_3" name="it_891_xz_wb"/>外汇票据初审<br/>
    				<input type="checkbox" id="it_891_xz_wb_4" name="it_891_xz_wb"/>外汇票据复审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_5" name="it_891_xz_wb"/>外汇检核修改授权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_6" name="it_891_xz_wb"/>外汇检核修改<br/>
    				<input type="checkbox" id="it_891_xz_wb_7" name="it_891_xz_wb"/>外汇失败原因分析&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_8" name="it_891_xz_wb"/>外汇录入修改授权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_9" name="it_891_xz_wb"/>外汇录入修改<br/>
    				<input type="checkbox" id="it_891_xz_wb_10" name="it_891_xz_wb"/>外汇专项查询角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_11" name="it_891_xz_wb"/>外汇汇入对私初审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_12" name="it_891_xz_wb"/>外汇汇入对私复审<br/>
    				<input type="checkbox" id="it_891_xz_wb_13" name="it_891_xz_wb"/>对公汇出初审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_14" name="it_891_xz_wb"/>对公汇出复审&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_wb_15" name="it_891_xz_wb"/>外汇汇入对公初审<br/>
    				<input type="checkbox" id="it_891_xz_wb_16" name="it_891_xz_wb"/>外汇汇入对公复审<br/>
    				
    				<br/>
    				生产管理<br/>
    				<input type="checkbox" id="it_891_xz_gl_1" name="it_891_xz_gl"/>报表查询角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_gl_2" name="it_891_xz_gl"/>生产排班角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_gl_3" name="it_891_xz_gl"/>生产排班管理角色<br/>
    				<input type="checkbox" id="it_891_xz_gl_4" name="it_891_xz_gl"/>日始日终角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_gl_5" name="it_891_xz_gl"/>统计分析角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="hidden" id="it_891_xz_gl_6" name="it_891_xz_gl"/><!-- 总行业务监控角色 <br/>-->
    				<input type="checkbox" id="it_891_xz_gl_7" name="it_891_xz_gl"/>总行集中处理中心监控角色<br/>
    				<br/>
    				建亚<br/>
    				<input type="checkbox" id="it_891_xz_jy_1" name="it_891_xz_jy"/>海外要素录入修改&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_jy_2" name="it_891_xz_jy"/>海外录入修改复核&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_891_xz_jy_3" name="it_891_xz_jy"/>海外票据审核<br/>
    				<br/>
    				其他<br/>
    				<input type="checkbox" id="it_891_xz_qt" name="it_891_xz_gl"/>
    				<input type="text" name="qt_891_xz"/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as" rowspan="4">
    				<input type="checkbox" id="it890" name="it890"/>
    				890任务池
    			</td>
    		</tr>
    		
    		<tr>
    			<td class="as" >
    				<input type="radio" id="rd890_1" name="rd890" value="zx"  onclick="changeradio('zx890');showitem('zx890')"/>状态变更
    			</td>
    			<td colspan="3">
    				<input type="radio" id="it_890_zx_1" name="it_890_zx"/>注销&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="radio" id="it_890_zx_2" name="it_890_zx"/>生效<br/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as" >
    				<input type="radio" id="rd890_2" name="rd890" value="xg" onclick="changeradio('xg890');showitem('890')"/>修改
    			</td>
    			<td colspan="3">
    				<input type="checkbox" id="it_890_xg_1" name="it_890_xg"/>报表查询角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_890_xg_2" name="it_890_xg"/>统计分析角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_890_xg_3" name="it_890_xg"/>总行业务监控角色<br/>
    				<input type="checkbox" id="it_890_xg_4" name="it_890_xg"/>日始日终角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_890_xg_5" name="it_890_xg"/>基本信息查询角色
    				<input type="checkbox" id="it_890_xg_6" name="it_890_xg"/>其他
    				<input type="text" name="qt_890_xg"/>
    				<br/>
    			</td>
    		</tr>
    		<tr>
    			<td class="as" >
    				<input type="radio" id="rd890_3" name="rd890" value="xz" onclick="changeradio('xz890')"/>新增
    			</td>
    			<td colspan="3">
    				<input type="checkbox" id="it_890_xz_1" name="it_890_xz"/>报表查询角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_890_xz_2" name="it_890_xz"/>统计分析角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_890_xz_3" name="it_890_xz"/>总行业务监控角色<br/>
    				<input type="checkbox" id="it_890_xz_4" name="it_890_xz"/>日始日终角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="checkbox" id="it_890_xz_5" name="it_890_xz"/>基本信息查询角色
    				<input type="checkbox" id="it_890_xz_6" name="it_890_xz"/>其他
    				<input type="text" name="qt_890_xz"/>
    				<br/>
    			</td>
    		</tr>
    		</c:if>
    		<tr>
    			<td colspan="5" class="as">
    				<input style="width:70px" type="button" onclick="baocun()" value="保 存"/>&nbsp;&nbsp;&nbsp;&nbsp;
    				<input style="width:70px" type="button" onclick="xinzeng()" value="新 增"/>
    			</td>
    			<td class="as">
    				<p align="right">建议生效日期：<input type="text" id="sxtime" name="sxtime" value="${sxtime}" class="Wdate"  onClick="WdatePicker()" onchange="alert('建议生效日期原则上应不早于申请日期的次日')"/></p>
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				申请部门意见
    			</td>
    			<td colspan="6" id="p">&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				会签部门意见
    			</td>
    			<td colspan="6" id="p">&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				中心部门意见
    			</td>
    			<td colspan="6" id="p">&nbsp;
    			</td>
    		</tr>
    		<tr>
    			<td class="as">
    				选择审批人<b>*</b>
    			</td>
    			<td colspan="6">
    				<select name="thisunder" id="xuanze">
        				<option value="wu">请选择下一级审批人</option>
        				<c:if test="${zhi!='0'&&zhi!='1'}">
        					<c:forEach items="${list}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        				</c:if>	
        			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="5">
    				<input type="hidden" id="nowdate" name="nowdate" value="${nowdate}"/>
    				<input type="hidden" name="newnumber" value="${newnumber}"/>
    				<input type="hidden" name="number" value="${number}"/>
    				<input type="hidden" name="brdf" value="${brdf}"/>
    				<input type="hidden" id="xgpool" value="${xgpool}"/>
    				<input type="hidden" id="xgtype891" value="${xgtype891}"/>
    				<input type="hidden" id="xgitem891" value="${xgitem891}"/>
    				<input type="hidden" id="xgremark1" value="${xgremark1}"/>
    				<input type="hidden" id="xgtype890" value="${xgtype890}"/>
    				<input type="hidden" id="xgitem890" value="${xgitem890}"/>
    				<input type="hidden" id="xgremark2" value="${xgremark2}"/>
    				<input type="hidden" id="uchpid" name="uchpid" value="${uchpid}"/>
    				
    				<input type="hidden" name="dai" value="0"/>
    				<input style="width:70px" type="button" onclick="tijiao()" value="提  交"/>
    			</td>
    		</tr>
    	</table>
    	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </form>
  </body>
</html>
