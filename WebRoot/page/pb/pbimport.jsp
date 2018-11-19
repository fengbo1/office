<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" errorPage="../public/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
 
 function daochu()
	{
		
		window.location = "<%=path%>/exporttempxx.action";
	}
	
 function updatetxx()
	{
		
		window.location = "<%=path%>/updatetempxx.action";
	}
 </script>
<title>排班数据导入</title>
</head>
<body>
${daohang}
<div class="layout">
		<form name="filename" method="post" action="importscpbry.action"
			enctype="multipart/form-data">
			<div class="title">导入集中生产排班小组人员表</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						<p style="color:red">（请另存为excel2003格式后上传）</p>
					</div>
					<div class="four_columns_text">
					<a href="<%=path%>/templet/scpbry.xls">下载【集中生产排班小组人员】模板</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_input">
					</div>
					<div class="four_columns_input">
						<input type="submit" name="提交" value="提交"/>
					</div>
					<div class="four_columns_input">
					</div>
				</div>
			</div>
		</form>
		<table border="1px">
				<tr>
					<td colspan="4" class="title">提示：文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>集中生产排班小组人员表：</td>
					<td>月份&nbsp;+&nbsp;pbry</td>
					<td>201510pbry.xls</td>
					<td rowspan="3"></td>
				</tr>
			</table>
	</div>
	<br/>
	
	<div class="layout">
		<form name="filename" method="post" action="importpeoplepb.action"
			enctype="multipart/form-data">
			<div class="title">导入单独人员排班表</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						<p style="color:red">（请另存为excel2003格式后上传）</p>
					</div>
					<div class="four_columns_text">
					<a href="<%=path%>/templet/personpb.xls">下载【单独人员排班表】模板</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_input">
					</div>
					<div class="four_columns_input">
						<input type="submit" name="提交" value="提交"/>
					</div>
					<div class="four_columns_input">
					</div>
				</div>
			</div>
		</form>
		<table border="1px">
				<tr>
					<td colspan="4" class="title">提示：文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>单独人员排班表：</td>
					<td>月份&nbsp;+&nbsp;personpb</td>
					<td>201510personpb.xls</td>
					<td rowspan="3"></td>
				</tr>
	   </table>
	</div>
	<br/>
	
	<div class="layout">
		<form name="filename" method="post" action="importscpb.action"
			enctype="multipart/form-data">
			<div class="title">导入集中生产排班表</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						<p style="color:red">（请另存为excel2003格式后上传）</p>
					</div>
					<div class="four_columns_text">
					<a href="<%=path%>/templet/scpb.xls">下载【集中生产排班表】模板</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_input">
					</div>
					<div class="four_columns_input">
						<input type="submit" name="提交" value="提交"/>
					</div>
					<div class="four_columns_input">
						<input type="button" value="生成排班明细" onclick="location='<%=path%>/processpbmx.action?type=sc'"/>
					</div>
				</div>
			</div>
		</form>
		<table border="1px">
				<tr>
					<td colspan="4" class="title">提示：文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>集中生产排班表：</td>
					<td>日期&nbsp;+&nbsp;scpb</td>
					<td>20151001-20151002scpb.xls</td>
					<td rowspan="3">按周导入</td>
				</tr>
				<tr colspan="4" style="color:red">注意，生产排班表一次只支持一条数据导入，多条数据仅读取第一条；如果周末没有排班，排班时间段请不要跨周末；每次导入生产排班表后点击生成排班明细才能生效。</tr>
			</table>
	</div>
	
	<br/>
	<div class="layout">
		<form name="filename" method="post" action="importygxx.action"
			enctype="multipart/form-data">
			<div class="title">批量导入因公下线</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						<p style="color:red">（请另存为excel2003格式后上传）</p>
					</div>
					<div class="four_columns_text">
					<a href="<%=path%>/templet/ygxx.xls">下载【因公下线】模板</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_input">
					</div>
					<div class="four_columns_input">
						<input type="submit" name="提交" value="提交"/>
					</div>
				</div>
			</div>
		</form>
		<table border="1px">
				<tr>
					<td colspan="4" class="title">提示：文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>因公下线表：</td>
					<td>年&nbsp;+&nbsp;季度&nbsp;+&nbsp;ygxx</td>
					<td>2016Q3ygxx.xls</td>
					<td rowspan="3"></td>
				</tr>
			</table>
	</div>
		<br/>
		
		<div class="layout">
		<form name="filename" method="post" action="importpw.action"
			enctype="multipart/form-data">
			<div class="title">导入作业人员统计表</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						<p style="color:red">（请另存为excel2003格式后上传）</p>
					</div>
					<div class="four_columns_text">
					<a href="<%=path%>/templet/workpb.xls">下载【作业人员排班表】模板</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_input">
					</div>
					<div class="four_columns_input">
						<input type="submit" name="提交" value="提交"/>
					</div>
					<div class="four_columns_input">
					</div>
				</div>
			</div>
		</form>
		<table border="1px">
				<tr>
					<td colspan="4" class="title">提示：文件名规则</td>
				</tr>
				<tr>
					<td style="width:250px"></td>
					<td style="width:200px">文件名规则如下：</td>
					<td style="width:200px">示例如下：</td>
				</tr>
				<tr>
					<td>作业人员排班表：</td>
					<td>月份&nbsp;+&nbsp;workpb</td>
					<td>201708workpb.xls</td>
					<td rowspan="3"></td>
				</tr>
	   </table>
	</div>

	<br/>
	
	<div class="layout">
		<form name="filename" method="post" action="importpw.action"
			enctype="multipart/form-data">
			<div class="title">生成成都分中心临时下线人员情况表</div>
			<div id="content" >
			
				     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
				    
				     <input type="button" style="width:60" onclick="updatetxx()" value="更新"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				     <input type="button" style="width:60" onclick="daochu()" value="下载"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				     <span id="updatetip"><c:if test="${tip==1}"><b style="color:red">有更新</b></c:if><c:if test="${tip==0}"><b style="color:red">无更新</b></c:if></span>
				</div>
				
			
		</form>
		<table border="1px">
				<tr>
					<td colspan="4" class="title">提示：</td>
				</tr>
			
				<tr>
					<td>一、更新按钮用以更新表数据，并给出更新结果提示</td>
				
				</tr>
				<tr>
					<td>二、下载按钮用以下载导出EXCEL表</td>
				
				</tr>
	   </table>
	</div>
	<br/>
	<c:if test="${authoI=='I'}">
	<div class="layout">
		<form name="filename" method="post" action="importjbsp.action"
			enctype="multipart/form-data">
			<div class="title">批量导入加班审批</div>
			<div id="content" >
				<div class="four_columns">
					<div class="four_columns_text">选择上传文件</div>
					<div class="four_columns_input">
						<input type="file" name="file" />
					</div>
					<div class="four_columns_input">
						<p style="color:red">（请另存为excel2003格式后上传）</p>
					</div>
					<div class="four_columns_text">
					<a href="<%=path%>/templet/jbsp.xls">下载【加班审批】模板</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
					<div class="four_columns_input">
					</div>
					<div class="four_columns_input">
						<input type="submit" name="提交" value="提交"/>
					</div>
				</div>
			</div>
		</form>
	</div>
	</c:if>
		<br/>
</body>
</html>