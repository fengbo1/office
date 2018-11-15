<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String username = (String)request.getSession().getAttribute("username");
	String IP=request.getRemoteAddr();
	session.setAttribute("IP",IP);
	
%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/cccx_old.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style_old.css" />
<link rel="stylesheet" type="text/css" href="css/style_menu_top.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>自助办公工具</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>

<script language="javascript"> 


function startTime()
{
	
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout('startTime()',500);

}

function checkTime(i)
{
if (i<10) 
  {i="0" + i;}
  return i;
}
 
</script>
<script type="text/javascript">

function frame(o)
{
	var id = document.getElementById("id").value;
	var zhi = document.getElementById("zhi").value;
	var chu = document.getElementById("chu").value;
	var authoA = document.getElementById("authoA").value;
    var authoB = document.getElementById("authoB").value;
	var authoC = document.getElementById("authoC").value;
	var authoD = document.getElementById("authoD").value;
	var authoE = document.getElementById("authoE").value;
	var authoF = document.getElementById("authoF").value;
	var authoG = document.getElementById("authoG").value;
	var authoH = document.getElementById("authoH").value;
	var authoI = document.getElementById("authoI").value;
	var authoJ = document.getElementById("authoJ").value;
	var authoK = document.getElementById("authoK").value;
	var authoL = document.getElementById("authoL").value;
	var authoM = document.getElementById("authoM").value;
	var authoN = document.getElementById("authoN").value;
	var authoO = document.getElementById("authoO").value;
	var authoP = document.getElementById("authoP").value;
	var authoQ = document.getElementById("authoQ").value;
	var authoR = document.getElementById("authoR").value;
	var authoS = document.getElementById("authoS").value;
	var authoT = document.getElementById("authoT").value;										
	var obj = " ";
	obj=o;
	if(obj=="userinfo")
	{
		document.getElementById("frame").src="<%=path%>/user.action?type=find_all";
		//document.getElementById("daohang").innerHTML="用户信息->查询所有";
	}
	else if(obj=="pwdmodify")
	{
		document.getElementById("frame").src="<%=path%>/user.action?type=to_update&id="+id;
		//document.getElementById("daohang").innerHTML="用户信息->修改密码";
	}
	else if(obj=="fqsq_br")//本人发起申请
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewundertake.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/leave.action?newnumber=${newnumber}";
			}
		//document.getElementById("daohang").innerHTML="请假申请->发起申请->本人发起";
	}
	else if(obj=="fqsq_df")//本人发起申请-代申请
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewundertake.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/leave.action?newnumber=${newnumber}&dai=1";
			}
		
		//document.getElementById("daohang").innerHTML="请假申请->发起申请->代发起";
	}
	else if(obj=="brsq_lz")//本人发起申请-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewapply.action?status=1&newnumber=${newnumber}&type=lz";
		//document.getElementById("daohang").innerHTML="请假申请->查看申请->流转中";
	}
	else if(obj=="brsq_bj")//本人发起-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewapply.action?newnumber=${newnumber}&type=ybj";
		//document.getElementById("daohang").innerHTML="请假申请->查看申请->已办结";
	}
	else if(obj=="brcb_dcb")//本人承办-待办事宜
	{
		document.getElementById("frame").src="<%=path%>/viewundertake.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="请假申请->本人承办->待办事宜";
	}
	else if(obj=="brcb_ycb")//本人承办-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="请假申请->本人承办->已承办";
	}
	else if(obj=="tjcx_mx")//统计查询-明细
	{
		document.getElementById("frame").src="<%=path%>/viewall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="请假申请->统计查询->明细查询";
	}
	else if(obj=="tjcx_hz")//统计查询-汇总
	{
		document.getElementById("frame").src="<%=path%>/viewsummary.action?newnumber=${newnumber}&year=${year}";
		//document.getElementById("daohang").innerHTML="请假申请->统计查询->汇总查询";
	}
	else if(obj=="tjcx_tdmx")//统计查询-中心/团队明细
	{
		document.getElementById("frame").src="<%=path%>/viewall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="请假申请->统计查询->明细查询";
	}
	else if(obj=="tjcx_tdhz")//统计查询-中心/团队汇总
	{
		document.getElementById("frame").src="<%=path%>/viewsummary.action?newnumber=${newnumber}&year=${year}&zxtd=td";
		//document.getElementById("daohang").innerHTML="请假申请->统计查询->汇总查询";
	}
	else if(obj=="dr_rlb")//导入日历表
	{
		document.getElementById("frame").src="<%=path%>/importcalendar.action";
		//document.getElementById("daohang").innerHTML="日历表->导入日历表";
	}
	//外出公干
	else if(obj=="wcgg_br")//外出公干-本人发起
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewwcggunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showwcggpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="外出公干->发起申请->本人发起";
	}
	else if(obj=="wcgg_df")//外出公干-代发起
	{
		document.getElementById("frame").src="<%=path%>/showwcggpagedf.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="外出公干->查看申请->流转中";
	}
	else if(obj=="wcgg_lz")//外出公干-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewwcgg.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="外出公干->查看申请->流转中";
	}
	else if(obj=="wcgg_ybj")//外出公干-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewwcggybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="外出公干->查看申请->流转中";
	}
	else if(obj=="wcgg_db")//外出公干-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewwcggunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="外出公干->本人承办->待办事宜";
	}
	else if(obj=="wcgg_all")//外出公干-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewwcggall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="外出公干->统计查询->明细查询";
	}
	else if(obj=="wcgg_tdall")//外出公干-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewwcggall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="外出公干->统计查询->明细查询";
	}
	else if(obj=="wcgg_ycb")//外出公干-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewwcggycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="外出公干->本人承办->已承办";
	}
	//在职证明
	else if(obj=="zzzm_br")//在职证明-本人发起
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewzzzmunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzzzmpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="在职证明->发起申请->本人发起";
	}
	else if(obj=="zzzm_df")//在职证明-代发起
	{
		document.getElementById("frame").src="<%=path%>/showzzzmpagedf.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="在职证明->查看申请->代发起";
	}
	else if(obj=="zzzm_lz")//在职证明-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewzzzm.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="在职证明->查看申请->流转中";
	}
	else if(obj=="zzzm_ybj")//在职证明-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewzzzmybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="在职证明->查看申请->已办结";
	}
	else if(obj=="zzzm_db")//在职证明-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewzzzmunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="在职证明->本人承办->待办事宜";
	}
	else if(obj=="zzzm_all")//在职证明-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzzzmall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="在职证明->统计查询->明细查询";
	}
	else if(obj=="zzzm_tdall")//在职证明-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzzzmall.action?newnumber=${newnumber}&zxtd=td&authoI=${authoI}&authoJ=${authoJ}&authoG=${authoG}";
		//document.getElementById("daohang").innerHTML="在职证明->统计查询->明细查询";
	}
	else if(obj=="zzzm_ycb")//在职证明-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewzzzmycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="在职证明->本人承办->已承办";
	}
	
	
	//门禁管理
	else if(obj=="mjgl_br")//门禁管理-本人发起
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewmjglunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showmjglpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="门禁管理->发起申请->本人发起";
	}
	
	else if(obj=="mjgl_lz")//门禁管理-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewmjgllzz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="门禁管理->查看申请->流转中";
	}
	else if(obj=="mjgl_ybj")//门禁管理-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewmjglybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="门禁管理->查看申请->已办结";
	}
	else if(obj=="mjgl_db")//门禁管理-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewmjglunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="门禁管理->本人承办->待办事宜";
	}
	else if(obj=="mjgl_all")//门禁管理-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewmjglall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="门禁管理->统计查询->明细查询";
	}
	else if(obj=="mjgl_tdall")//门禁管理-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewmjglall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="门禁管理->统计查询->明细查询";
	}
	else if(obj=="mjgl_ycb")//门禁管理-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewmjglycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="门禁管理->本人承办->已承办";
	}
	else if(obj=="mjgl_qxcx")//门禁管理-权限查询
	{
		document.getElementById("frame").src="<%=path%>/viewmjglpage.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="门禁管理->本人承办->已承办";
	}
	else if(obj=="mjgl_qxcxall")//门禁管理-权限查询
	{
		document.getElementById("frame").src="<%=path%>/viewmjglpageall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="门禁管理->本人承办->已承办";
	}
	//else if(obj=="mjgl_qxcx")//门禁管理-权限查询
	//{
		//document.getElementById("frame").src="<%=path%>/viewmjglqxcx.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	//}
	//收入证明
	else if(obj=="srzm_br")//收入证明-本人发起
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewsrzmunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showsrzmpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="收入证明->发起申请->本人发起";
	}
	else if(obj=="srzm_df")//收入证明-代发起
	{
		document.getElementById("frame").src="<%=path%>/showsrzmpagedf.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->代发起";
	}
	else if(obj=="srzm_lz")//收入证明-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewsrzm.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->流转中";
	}
	else if(obj=="srzm_ybj")//收入证明-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewsrzmybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->已办结";
	}
	else if(obj=="srzm_db")//收入证明-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewsrzmunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->待办事宜";
	}
	else if(obj=="srzm_all")//收入证明-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewsrzmall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->统计查询->明细查询";
	}
	else if(obj=="srzm_tdall")//收入证明-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewsrzmall.action?newnumber=${newnumber}&zxtd=td&authoI=${authoI}&authoJ=${authoJ}&authoG=${authoG}";
		//document.getElementById("daohang").innerHTML="收入证明->统计查询->明细查询";
	}
	else if(obj=="srzm_ycb")//收入证明-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewsrzmycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
	else if(obj=="zcsl_br")//资产申领-本人发起
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcapplyunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzcapplypage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="资产申领->发起申请->本人发起";
	}
	
	else if(obj=="zcsl_lz")//资产申领-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewzcapplylzz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->查看申请->流转中";
	}
	else if(obj=="zcsl_ybj")//资产申领-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewzcapplyybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->查看申请->已办结";
	}
	else if(obj=="zcsl_db")//资产申领-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewzcapplyunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->本人承办->待办事宜";
	}
	else if(obj=="zcsl_all")//资产申领-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzcapplyall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->统计查询->明细查询";
	}
	else if(obj=="zcsl_tdall")//资产申领-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzcapplyall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="资产申领->统计查询->明细查询";
	}
	else if(obj=="zcsl_ycb")//资产申领-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewzcapplyycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->本人承办->已承办";
	}
	
	
	
   else if(obj=="zcjy_br")//资产借用-本人发起
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcborrowunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzcborrowpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="资产申领->发起申请->本人发起";
	}
	
	else if(obj=="zcjy_lz")//资产借用-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewzcborrowlzz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产借用->查看申请->流转中";
	}
	else if(obj=="zcjy_ybj")//资产借用-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewzcborrowybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产借用>查看申请->已办结";
	}
	else if(obj=="zcjy_db")//资产借用-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewzcborrowunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产借用->本人承办->待办事宜";
	}
	else if(obj=="zcjy_all")//资产借用-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzcborrowall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产借用->统计查询->明细查询";
	}
	else if(obj=="zcjy_tdall")//资产借用-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzcborrowall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="资产借用->统计查询->明细查询";
	}
	else if(obj=="zcjy_ycb")//资产借用-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewzcborrowycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产借用->本人承办->已承办";
	}
	
	else if(obj=="zcxj_br")//资产续借-本人发起
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcandborrowunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/viewzcneedandborrow.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="资产续借->发起申请->本人发起";
	}
	
	else if(obj=="zcxj_lz")//资产续借-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewzcandborrowlzz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产续借->查看申请->流转中";
	}
	else if(obj=="zcxj_ybj")//资产续借-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewzcandborrowybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产续借>查看申请->已办结";
	}
	else if(obj=="zcxj_db")//资产续借-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewzcandborrowunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产续借->本人承办->待办事宜";
	}
	else if(obj=="zcxj_all")//资产续借-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzcandborrowall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产续借->统计查询->明细查询";
	}
	else if(obj=="zcxj_tdall")//资产续借-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzcandborrowall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="资产续借->统计查询->明细查询";
	}
	else if(obj=="zcxj_ycb")//资产续借-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewzcandborrowycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产续借->本人承办->已承办";
	}
	
	
	
	else if(obj=="zccx_all")//资产查询-处室
	{
		document.getElementById("frame").src="<%=path%>/viewzcsearchallnew.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="资产查询->处室";
	}
	else if(obj=="zccx_allzong")//资产查询-处室
	{
		document.getElementById("frame").src="<%=path%>/viewzcsearchallnewzong.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="资产查询->处室";
	}
	else if(obj=="zccx_allwb")//资产查询-处室
	{
		document.getElementById("frame").src="<%=path%>/viewzcsearchallnewwaibao.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="资产查询->处室";
	}
	
	else if(obj=="zccx_allwb1")//资产查询-处室
	{
		document.getElementById("frame").src="<%=path%>/viewzcsearchallnewwaibao1.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="资产查询->处室";
	}
	else if(obj=="zccx_alltd")//资产查询-中心
	{
		//document.getElementById("frame").src="<%=path%>/viewzcsearchallzx.action?newnumber=${newnumber}";
		document.getElementById("frame").src="<%=path%>/viewzcsearchallnewzx.action?newnumber=${newnumber}";
		topmenu.style.display="none";
		//document.getElementById("daohang").innerHTML="资产查询->中心";
	}
	
	else if(obj=="zcgh_br")//资产归还-借用发起
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcreturnunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzcreturnborrowpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="资产归还->发起申请->本人发起";
	}
	
	else if(obj=="zcgh_fq")//资产归还-领用发起
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcreturnunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzcreturnapplypage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="资产归还->发起申请->本人发起";
	}
	
	else if(obj=="zcgh_lz")//资产归还-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewzcreturnlzz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产归还->查看申请->流转中";
	}
	else if(obj=="zcgh_ybj")//资产归还-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewzcreturnybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产归还>查看申请->已办结";
	}
	else if(obj=="zcgh_db")//资产归还-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewzcreturnunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产归还->本人承办->待办事宜";
	}
	else if(obj=="zcgh_all")//资产归还-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzcreturnall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产归还->统计查询->明细查询";
	}
	else if(obj=="zcgh_tdall")//资产归还-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzcreturnall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="资产归还->统计查询->明细查询";
	}
	else if(obj=="zcgh_ycb")//资产归还-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewzcreturnycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产归还->本人承办->已承办";
	}
	
		
	else if(obj=="kfgl_rk")//库房管理-入库
	{
	
		if(chu=='1'&&authoN=='N')
		{
			document.getElementById("frame").src="<%=path%>/viewzckfinunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzckfinpage.action?newnumber=${newnumber}";
		}
		
		//document.getElementById("daohang").innerHTML="资产申领->发起申请->本人发起";
	}
	
	else if(obj=="kfrk_lz")//库房管理-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewzckfinlzz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->查看申请->流转中";
	}

	else if(obj=="kfrk_db")//库房管理-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewzckfinunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->本人承办->待办事宜";
	}
	//else if(obj=="kfrk_all")//库房管理-查询所有
	//{
		//document.getElementById("frame").src="<%=path%>/viewzckfinall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->统计查询->明细查询";
	//}
	else if(obj=="kfrk_tdall")//库房管理-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzckfinall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="资产申领->统计查询->明细查询";
	}
	
	
	
    else if(obj=="kfgl_ck")//库房管理-出库
	{
	
	     if(chu=='1'&&authoN=='N')
		{
			document.getElementById("frame").src="<%=path%>/viewzckfoutunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzckfoutpage.action?newnumber=${newnumber}";
		}
		
		//document.getElementById("daohang").innerHTML="资产申领->发起申请->本人发起";
	}
	
	else if(obj=="kfck_lz")//库房管理-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewzckfoutlzz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->查看申请->流转中";
	}

	else if(obj=="kfck_db")//库房管理-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewzckfoutunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->本人承办->待办事宜";
	}
	//else if(obj=="kfrk_all")//库房管理-查询所有
	//{
		//document.getElementById("frame").src="<%=path%>/viewzckfinall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="资产申领->统计查询->明细查询";
	//}
	else if(obj=="kfck_tdall")//库房管理-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewzckfoutall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="资产申领->统计查询->明细查询";
	}
	//因私出境	
	else if(obj=="yscj_br")//因私出境-本人发起
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewyscjunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showyscjpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("daohang").innerHTML="因私出境->发起申请->本人发起";
	}
	else if(obj=="yscj_df")//因私出境代发起
	{
		document.getElementById("frame").src="<%=path%>/showyscjpagedf.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->代发起";
	}
	else if(obj=="yscj_lz")//因私出境-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewyscj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->流转中";
	}
	else if(obj=="yscj_ybj")//因私出境-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewyscjybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->查看申请->已办结";
	}
	else if(obj=="yscj_db")//因私出境-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewyscjunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->待办事宜";
	}
	else if(obj=="yscj_all")//因私出境-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewyscjall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->统计查询->明细查询";
	}
	else if(obj=="yscj_tdall")//因私出境-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewyscjall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="收入证明->统计查询->明细查询";
	}
	else if(obj=="yscj_ycb")//因私出境-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewyscjycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
	
	else if(obj=="yscj_tzcx")//因私出境-台账查询
	{
		document.getElementById("frame").src="<%=path%>/viewyscjtz.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="收入证明->本人承办->已承办";
	}
	//加班审批
	else if(obj=="jbsp_br")//加班审批-本人发起
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewjbspunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showjbsppage.action?newnumber=${newnumber}";
		}
		
		//document.getElementById("daohang").innerHTML="加班申请->发起申请->本人发起";
	}
	else if(obj=="jbsp_df")//外出公干-代发起
	{
		document.getElementById("frame").src="<%=path%>/showjbsppagedf.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="外出公干->查看申请->流转中";
	}
	else if(obj=="jbsp_lz")//加班审批-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewjbsp.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="加班申请->查看申请->流转中";
	}
	else if(obj=="jbsp_ybj")//加班审批-已办结
	{
		document.getElementById("frame").src="<%=path%>/viewjbspybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="加班申请->查看申请->流转中";
	}
	else if(obj=="jbsp_db")//加班审批-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewjbspunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="加班申请->本人承办->待办事宜";
	}
	else if(obj=="jbsp_all")//加班审批-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewjbspall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="加班申请->统计查询->明细查询";
	}
	else if(obj=="jbsp_grmx")//加班审批-个人调休明细
	{
		//document.getElementById("frame").src="<%=path%>/viewjbspsummary.action?newnumber=${newnumber}&year=${year}";
		document.getElementById("frame").src="<%=path%>/viewjpdall.action?newnumber=${newnumber}&grzx=gr";
	}
	else if(obj=="jbsp_alltd")//加班审批-查询所有团队明细
	{
		document.getElementById("frame").src="<%=path%>/viewjbspall.action?newnumber=${newnumber}&zxtd=td";
	}
	else if(obj=="jbsp_zxmx")//加班审批-中心调休明细
	{
		//document.getElementById("frame").src="<%=path%>/viewjbspsummary.action?newnumber=${newnumber}&year=${year}&zxtd=td";
		document.getElementById("frame").src="<%=path%>/viewjpdall.action?newnumber=${newnumber}&grzx=zx";
	}
	else if(obj=="jbsp_ycb")//加班审批-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewjbspycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="加班申请->本人承办->已承办";
	}
	//考勤缺失
	else if(obj=="kqqs_br")//考勤缺失-本人发起
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewkqqsunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showkqqspage.action?newnumber=${newnumber}";
		}
		
		//document.getElementById("daohang").innerHTML="考勤缺失->发起申请->本人发起";
	}
	//考勤缺失
	else if(obj=="kqqs_df")//考勤缺失-代发起
	{
		document.getElementById("frame").src="<%=path%>/showkqqspage.action?type=df&newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="考勤缺失->发起申请->本人发起";
	}
	else if(obj=="kqqs_lz")//考勤缺失-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewkqqs.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="考勤缺失->查看申请->流转中";
	}
	else if(obj=="kqqs_ybj")//考勤缺失-流转中
	{
		document.getElementById("frame").src="<%=path%>/viewkqqsybj.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="考勤缺失->查看申请->流转中";
	}
	else if(obj=="kqqs_db")//考勤缺失-待办事项
	{
		document.getElementById("frame").src="<%=path%>/viewkqqsunder.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="考勤缺失->本人承办->待办事宜";
	}
	else if(obj=="kqqs_all")//考勤缺失-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewkqqsall.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="考勤缺失->统计查询->明细查询";
	}
	else if(obj=="kqqs_alltd")//考勤缺失-查询所有
	{
		document.getElementById("frame").src="<%=path%>/viewkqqsall.action?newnumber=${newnumber}&zxtd=td";
		//document.getElementById("daohang").innerHTML="考勤缺失->统计查询->明细查询";
	}
	else if(obj=="kqqs_ycb")//考勤缺失-已承办
	{
		document.getElementById("frame").src="<%=path%>/viewkqqsycb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="考勤缺失->本人承办->已承办";
	}

	else if(obj=="user_list")//用户列表
	{
		document.getElementById("frame").src="<%=path%>/userlist.action?chu=0&newnumber=${newnumber}";
		topmenu.style.display="none";
	}
	else if(obj=="user_set")//用户列表
	{
		document.getElementById("frame").src="<%=path%>/showuserset.action?newnumber=${newnumber}";
		topmenu.style.display="none";
	}
	else if(obj=="home")//返回首页
	{
		topmenu.style.display="none";
		document.getElementById("frame").src="<%=path%>/welcome.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="首页";
	}
	
/////////////////////////////用于二级彩单使用/////////////////////////////////////////	
	else if(obj=="test_leave")//请假审批
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewundertake.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/leave.action?newnumber=${newnumber}";
		}
		//topmenu菜单显示控制
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
		if(zhi=='3'&&authoI!='I'&&chu!='5')//普通员工(除考勤管理员)不能代发起
		{
			document.getElementById("22").style.display="none";
		}
		else
		{
			document.getElementById("22").style.display="inline-block";
		}
		document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="inline-block";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoI=='I'||authoT=='T'||authoJ=='J')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="inline-block";
		   document.getElementById("58").style.display="none";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(zhi=='2'||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("58").style.display="inline-block";
		  document.getElementById("54").style.display="none";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('fqsq_br');}; 
		document.getElementById("22").onclick=function(){frame('fqsq_df');}; 
		document.getElementById("31").onclick=function(){frame('brsq_lz');};
		document.getElementById("32").onclick=function(){frame('brsq_bj');};
		document.getElementById("41").onclick=function(){frame('brcb_dcb');};
		document.getElementById("42").onclick=function(){frame('brcb_ycb');};
		document.getElementById("51").onclick=function(){frame('tjcx_mx');};
		document.getElementById("52").onclick=function(){frame('tjcx_hz');};
		document.getElementById("53").onclick=function(){frame('tjcx_tdmx');};
		document.getElementById("54").onclick=function(){frame('tjcx_tdhz');};	
		document.getElementById("57").onclick=function(){frame('tjcx_tdmx');};
		document.getElementById("58").onclick=function(){frame('tjcx_tdhz');};		
	}
	else if(obj=="test_wcgg")//外出公干
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewwcggunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showwcggpage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("21").style.display="inline-block";
		if(zhi=='3'&&authoI!='I')//普通员工(除考勤管理员)不能代发起
		{
			document.getElementById("22").style.display="none";
		}
		else
		{
			document.getElementById("22").style.display="inline-block";
		}
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoI=='I'||authoT=='T'||authoJ=='J')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(zhi=='2'||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";

		document.getElementById("21").onclick=function(){frame('wcgg_br');};
		document.getElementById("22").onclick=function(){frame('wcgg_df');}; 
		document.getElementById("31").onclick=function(){frame('wcgg_lz');};
		document.getElementById("32").onclick=function(){frame('wcgg_ybj');};
		document.getElementById("41").onclick=function(){frame('wcgg_db');};
		document.getElementById("42").onclick=function(){frame('wcgg_ycb');};
		document.getElementById("51").onclick=function(){frame('wcgg_all');};
		document.getElementById("53").onclick=function(){frame('wcgg_tdall');};
		document.getElementById("57").onclick=function(){frame('wcgg_tdall');};
	}
	else if(obj=="test_zzzm")//在职证明
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewzzzmunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzzzmpage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("21").style.display="inline-block";
		if(zhi=='3'&&authoJ!='J'&&authoI!='I'&&chu!='5')//普通员工(除薪酬管理员和考勤管理员)不能代发起
		{
			document.getElementById("22").style.display="none";
		}
		else
		{
			document.getElementById("22").style.display="inline-block";
		}
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoI=='I'||authoJ=='J'||authoG=='G')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoG!='G'))||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('zzzm_br');};
		document.getElementById("22").onclick=function(){frame('zzzm_df');}; 
		document.getElementById("31").onclick=function(){frame('zzzm_lz');};
		document.getElementById("32").onclick=function(){frame('zzzm_ybj');};
		document.getElementById("41").onclick=function(){frame('zzzm_db');};
		document.getElementById("42").onclick=function(){frame('zzzm_ycb');};
		document.getElementById("51").onclick=function(){frame('zzzm_all');};
		document.getElementById("53").onclick=function(){frame('zzzm_tdall');};
		document.getElementById("57").onclick=function(){frame('zzzm_tdall');};
	}
	
	else if(obj=="test_zcsl")//资产申领
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcapplyunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzcapplypage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("21").style.display="inline-block";
	    document.getElementById("22").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
	   if(zhi=='0'||zhi=='1'||authoH=='H'||authoM=='M'||authoP=='P')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoP!='P'))||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('zcsl_br');};
		//document.getElementById("22").onclick=function(){frame('zcsl_df');}; 
		document.getElementById("31").onclick=function(){frame('zcsl_lz');};
		document.getElementById("32").onclick=function(){frame('zcsl_ybj');};
		document.getElementById("41").onclick=function(){frame('zcsl_db');};
		document.getElementById("42").onclick=function(){frame('zcsl_ycb');};
		document.getElementById("51").onclick=function(){frame('zcsl_all');};
		document.getElementById("53").onclick=function(){frame('zcsl_tdall');};
		document.getElementById("57").onclick=function(){frame('zcsl_tdall');};
	}
	
	
  else if(obj=="test_zcjy")//资产借用
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcborrowunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzcborrowpage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
	    document.getElementById("22").style.display="none";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
	   if(zhi=='0'||zhi=='1'||authoH=='H'||authoM=='M'||authoP=='P')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoP!='P'))||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('zcjy_br');};
		//document.getElementById("22").onclick=function(){frame('zcsl_df');}; 
		document.getElementById("31").onclick=function(){frame('zcjy_lz');};
		document.getElementById("32").onclick=function(){frame('zcjy_ybj');};
		document.getElementById("41").onclick=function(){frame('zcjy_db');};
		document.getElementById("42").onclick=function(){frame('zcjy_ycb');};
		document.getElementById("51").onclick=function(){frame('zcjy_all');};
		document.getElementById("53").onclick=function(){frame('zcjy_tdall');};
		document.getElementById("57").onclick=function(){frame('zcjy_tdall');};
	}
	
		else if(obj=="test_zcxj")//资产续借
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcandborrowunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/viewzcneedandborrow.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
	    document.getElementById("22").style.display="none";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
	   if(zhi=='0'||zhi=='1'||authoH=='H'||authoM=='M'||authoP=='P')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoP!='P'))||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('zcxj_br');};
		//document.getElementById("22").onclick=function(){frame('zcsl_df');}; 
		document.getElementById("31").onclick=function(){frame('zcxj_lz');};
		document.getElementById("32").onclick=function(){frame('zcxj_ybj');};
		document.getElementById("41").onclick=function(){frame('zcxj_db');};
		document.getElementById("42").onclick=function(){frame('zcxj_ycb');};
		document.getElementById("51").onclick=function(){frame('zcxj_all');};
		document.getElementById("53").onclick=function(){frame('zcxj_tdall');};
		document.getElementById("57").onclick=function(){frame('zcxj_tdall');};
	}
	
	else if(obj=="test_zcgh")//资产归还
	{
		if(zhi=='0'||zhi=='1'||authoP=='P'||authoM=='M')
		{
			document.getElementById("frame").src="<%=path%>/viewzcreturnunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzcreturnpage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
	    document.getElementById("22").style.display="none";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
	   if(zhi=='0'||zhi=='1'||authoH=='H'||authoM=='M'||authoP=='P')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoP!='P'))||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("23").onclick=function(){frame('zcgh_br');};
		document.getElementById("24").onclick=function(){frame('zcgh_fq');};
		//document.getElementById("22").onclick=function(){frame('zcsl_df');}; 
		document.getElementById("31").onclick=function(){frame('zcgh_lz');};
		document.getElementById("32").onclick=function(){frame('zcgh_ybj');};
		document.getElementById("41").onclick=function(){frame('zcgh_db');};
		document.getElementById("42").onclick=function(){frame('zcgh_ycb');};
		document.getElementById("51").onclick=function(){frame('zcgh_all');};
		document.getElementById("53").onclick=function(){frame('zcgh_tdall');};
		document.getElementById("57").onclick=function(){frame('zcgh_tdall');};
	}
	
	
	else if(obj=="test_kfrk")//库房入库
	{
	   if(chu=='1'&&authoN=='N')
		{
			document.getElementById("frame").src="<%=path%>/viewzckfinunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzckfinpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("frame").src="<%=path%>/showzckfinpage.action?newnumber=${newnumber}";
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
		document.getElementById("22").style.display="none";
        document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="none";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="none";
		document.getElementById("51").style.display="none";
		document.getElementById("52").style.display="none";
	   if(zhi=='0'||zhi=='1'||authoH=='H'||authoM=='M'||authoP=='P')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoP!='P'))||zhi=='4')
		{
		  document.getElementById("57").style.display="none";
		  document.getElementById("53").style.display="inline-block";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('kfgl_rk');};
		
		document.getElementById("31").onclick=function(){frame('kfrk_lz');};
		//document.getElementById("32").onclick=function(){frame('zcsl_ybj');};
		document.getElementById("41").onclick=function(){frame('kfrk_db');};
		//document.getElementById("42").onclick=function(){frame('zcsl_ycb');};
		//document.getElementById("51").onclick=function(){frame('kfrk_all');};
		document.getElementById("53").onclick=function(){frame('kfrk_tdall');};
		//document.getElementById("57").onclick=function(){frame('kfrk_tdall');};
	}
	
	
	
	else if(obj=="test_kfbf")//库房报废
	{
	    if(chu=='1'&&authoN=='N')
		{
			document.getElementById("frame").src="<%=path%>/viewzckfoutunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showzckfoutpage.action?newnumber=${newnumber}";
		}
		//document.getElementById("frame").src="<%=path%>/showzckfoutpage.action?newnumber=${newnumber}";
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
		document.getElementById("22").style.display="none";
        document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="none";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="none";
		document.getElementById("51").style.display="none";
		document.getElementById("52").style.display="none";
	   if(zhi=='0'||zhi=='1'||authoH=='H'||authoM=='M'||authoP=='P')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoP!='P'))||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('kfgl_ck');};
		
		document.getElementById("31").onclick=function(){frame('kfck_lz');};
		//document.getElementById("32").onclick=function(){frame('zcsl_ybj');};
		document.getElementById("41").onclick=function(){frame('kfck_db');};
		//document.getElementById("42").onclick=function(){frame('zcsl_ycb');};
		//document.getElementById("51").onclick=function(){frame('kfck_all');};
		document.getElementById("53").onclick=function(){frame('kfck_tdall');};
		//document.getElementById("57").onclick=function(){frame('kfck_tdall');};
	}
	
	else if(obj=="test_mjgl")//门禁管理
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewmjglunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showmjglpage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
		document.getElementById("22").style.display="none";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		 if(zhi=='0'||zhi=='1'||authoH=='H'||authoQ=='Q'||authoI=='I'||authoJ=='J')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(zhi=='2'||zhi=='4')
		{
		   document.getElementById("57").style.display="inline-block";
		   document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="inline-block";
	
		document.getElementById("21").onclick=function(){frame('mjgl_br');};
		//document.getElementById("22").onclick=function(){frame('zzzm_df');}; 
		document.getElementById("31").onclick=function(){frame('mjgl_lz');};
		document.getElementById("32").onclick=function(){frame('mjgl_ybj');};
		document.getElementById("41").onclick=function(){frame('mjgl_db');};
		document.getElementById("42").onclick=function(){frame('mjgl_ycb');};
		document.getElementById("51").onclick=function(){frame('mjgl_all');};
		document.getElementById("53").onclick=function(){frame('mjgl_tdall');};
		document.getElementById("56").onclick=function(){frame('mjgl_qxcx');};
		document.getElementById("57").onclick=function(){frame('mjgl_tdall');};
	}
	else if(obj=="mjgl_page")//导入门禁权限数据
	{
		document.getElementById("frame").src="<%=path%>/showmjglimport.action";
		topmenu.style.display="none";
	}
	else if(obj=="test_srzm")//收入证明
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewsrzmunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showsrzmpage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		if(zhi=='3'&&authoJ!='J'&&authoI!='I'&&chu!='5')//普通员工(除考勤管理员)不能代发起
		{
			document.getElementById("22").style.display="none";
		}
		else
		{
			document.getElementById("22").style.display="inline-block";
		}
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoI=='I'||authoJ=='J'||authoG=='G')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoG!='G'))||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('srzm_br');};
		document.getElementById("22").onclick=function(){frame('srzm_df');}; 
		document.getElementById("31").onclick=function(){frame('srzm_lz');};
		document.getElementById("32").onclick=function(){frame('srzm_ybj');};
		document.getElementById("41").onclick=function(){frame('srzm_db');};
		document.getElementById("42").onclick=function(){frame('srzm_ycb');};
		document.getElementById("51").onclick=function(){frame('srzm_all');};
		document.getElementById("53").onclick=function(){frame('srzm_tdall');};
		document.getElementById("57").onclick=function(){frame('srzm_tdall');};
	}
	else if(obj=="test_yscj")//因私出入境
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewyscjunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showyscjpage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		if(zhi=='3'&&authoK!='K'&&authoI!='I'&&chu!='5')//普通员工(除考勤管理员)不能代发起
		{
			document.getElementById("22").style.display="none";
		}
		else
		{
			document.getElementById("22").style.display="inline-block";
		}
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoK=='K'||authoI=='I'||authoJ=='J')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(((zhi=='2')&&(authoK!='K'))||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="inline-block";
	    document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('yscj_br');};
		document.getElementById("22").onclick=function(){frame('yscj_df');}; 
		document.getElementById("31").onclick=function(){frame('yscj_lz');};
		document.getElementById("32").onclick=function(){frame('yscj_ybj');};
		document.getElementById("41").onclick=function(){frame('yscj_db');};
		document.getElementById("42").onclick=function(){frame('yscj_ycb');};
		document.getElementById("51").onclick=function(){frame('yscj_all');};
		document.getElementById("53").onclick=function(){frame('yscj_tdall');};
		document.getElementById("55").onclick=function(){frame('yscj_tzcx');};
		document.getElementById("57").onclick=function(){frame('yscj_tdall');};
		
	}
	else if(obj=="test_jbsp")//加班审批
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewjbspunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showjbsppage.action?newnumber=${newnumber}";
		}
		topmenu.style.display="inline-block";
		if(zhi=='3'&&authoI!='I')//普通员工(除考勤管理员)不能代发起
		{
			document.getElementById("22").style.display="none";
		}
		else
		{
			document.getElementById("22").style.display="inline-block";
		}
		document.getElementById("21").style.display="inline-block";
		//document.getElementById("22").style.display="none";
		document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoI=='I'||authoJ=='J')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(zhi=='2'||zhi=='4')
		{
		  document.getElementById("57").style.display="inline-block";
		  document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		//document.getElementById("53").style.display="inline-block";
		//document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('jbsp_br');}; 
		document.getElementById("22").onclick=function(){frame('jbsp_df');}; 
		document.getElementById("31").onclick=function(){frame('jbsp_lz');};
		document.getElementById("32").onclick=function(){frame('jbsp_ybj');};
		document.getElementById("41").onclick=function(){frame('jbsp_db');};
		document.getElementById("42").onclick=function(){frame('jbsp_ycb');};
		document.getElementById("51").onclick=function(){frame('jbsp_all');};
		//document.getElementById("52").innerHTML='个人调休明细';
		//document.getElementById("54").innerHTML='中心调休明细';
		//document.getElementById("52").onclick=function(){frame('jbsp_grmx');};
		document.getElementById("53").onclick=function(){frame('jbsp_alltd');};
		document.getElementById("57").onclick=function(){frame('jbsp_alltd');};
		//document.getElementById("54").onclick=function(){frame('jbsp_zxmx');};
		//document.getElementById("58").onclick=function(){frame('jbsp_zxmx');};
	}
	else if(obj=="test_kqqs")//考勤缺失
	{
		if(zhi=='0')
		{
			document.getElementById("frame").src="<%=path%>/viewkqqsunder.action?newnumber=${newnumber}";
		}
		else
		{
			document.getElementById("frame").src="<%=path%>/showkqqspage.action?newnumber=${newnumber}";
		}
		
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		if(authoI=='I'||zhi=='2')//只有考勤管理员代发起
		{
			document.getElementById("22").style.display="inline-block";
		}
		else
		{
			document.getElementById("22").style.display="none";
		}
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="inline-block";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="inline-block";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoI=='I'||authoJ=='J')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(zhi=='2'||zhi=='4')
		{
		   document.getElementById("57").style.display="inline-block";
		   document.getElementById("53").style.display="none";
		  document.getElementById("54").style.display="none";
		  document.getElementById("58").style.display="none";
		  //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}	
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('kqqs_br');}; 
		document.getElementById("22").onclick=function(){frame('kqqs_df');}; 
		document.getElementById("31").onclick=function(){frame('kqqs_lz');};
		document.getElementById("32").onclick=function(){frame('kqqs_ybj');};
		document.getElementById("41").onclick=function(){frame('kqqs_db');};
		document.getElementById("42").onclick=function(){frame('kqqs_ycb');};
		document.getElementById("51").onclick=function(){frame('kqqs_all');};
		document.getElementById("53").onclick=function(){frame('kqqs_alltd');};
		document.getElementById("57").onclick=function(){frame('kqqs_alltd');};
	}
	else if(obj=="ygxx_page")//因公下线
	{
		if(zhi=='2')
		{
			document.getElementById("frame").src="<%=path%>/showygxxpage.action?newnumber=${newnumber}";
		}
		else
		{
			frame('ygxx_all');
		}
		//document.getElementById("frame").src="<%=path%>/showygxxpage.action?newnumber=${newnumber}";
		topmenu.style.display="inline-block";
        document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		if(zhi=='2')
		{
			document.getElementById("21").style.display="inline-block";
		}
		else
		{
			document.getElementById("21").style.display="none";
		}
		document.getElementById("22").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="none";
		if(zhi=='0'||zhi=='1'||zhi=='2'||authoT=='T')
		{
			document.getElementById("41").style.display="inline-block";
		}
		else
		{
			document.getElementById("41").style.display="none";
		}
		document.getElementById("42").style.display="none";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="inline-block";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoI=='I'||authoT=='T'||authoJ=='J')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("54").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(zhi=='2'||zhi=='4')
		{
		   document.getElementById("57").style.display="inline-block";
		   document.getElementById("58").style.display="inline-block";
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		
		}	
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}
		
		
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
		
		document.getElementById("21").onclick=function(){frame('ygxx_br');}; 
		//document.getElementById("22").onclick=function(){frame('ygxx_df');}; 
		document.getElementById("31").onclick=function(){frame('ygxx_lz');};
		//document.getElementById("32").onclick=function(){frame('ygxx_ybj');};
		document.getElementById("41").onclick=function(){frame('ygxx_db');};
		//document.getElementById("42").onclick=function(){frame('ygxx_ycb');};
		document.getElementById("51").onclick=function(){frame('ygxx_all');};
		/*if(zhi=='0'||zhi=='1'||zhi=='2'||chu=='2'||chu=='1')
		{
			document.getElementById("51").innerHTML='个人发起明细';
		}
		else
		{
			document.getElementById("51").innerHTML='个人下线明细';
		}*/
		document.getElementById("52").onclick=function(){frame('ygxx_hz');};
		document.getElementById("53").onclick=function(){frame('ygxx_alltd');};
		document.getElementById("54").onclick=function(){frame('ygxx_hztd');};
		document.getElementById("57").onclick=function(){frame('ygxx_alltd');};
		document.getElementById("58").onclick=function(){frame('ygxx_hztd');};
	}
	else if(obj=="tbsq_page")//调班申请
	{
		document.getElementById("frame").src="<%=path%>/showtbsqpage.action?newnumber=${newnumber}";
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
	    document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		if((zhi=='3'&&chu=='3')||(zhi=='3'&&chu=='6'))
		{
			document.getElementById("22").style.display="none";
		}
		else
		{
			document.getElementById("22").style.display="inline-block";
		}
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="none";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="none";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		if(zhi=='0'||zhi=='1'||authoH=='H'||authoI=='I'||authoJ=='J'||authoT=='T')
		{
		   document.getElementById("53").style.display="inline-block";
		   document.getElementById("57").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("54").style.display="inline-block";
		}
		else
		{
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		}
		if(zhi=='2'||zhi=='4')
		{
		   document.getElementById("57").style.display="inline-block";
		   document.getElementById("53").style.display="none";
		   document.getElementById("54").style.display="none";
		   document.getElementById("58").style.display="none";
		   //document.getElementById("58").style.display="inline-block";
		}
		else
		{
		   document.getElementById("57").style.display="none";
		   document.getElementById("58").style.display="none";
		}	
		
		//document.getElementById("53").style.display="inline-block";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
	
		document.getElementById("21").onclick=function(){frame('tbsq_br');}; 
		document.getElementById("22").onclick=function(){frame('tbsq_df');}; 
		document.getElementById("31").onclick=function(){frame('tbsq_lz');};
		//document.getElementById("32").onclick=function(){frame('ygxx_ybj');};
		document.getElementById("41").onclick=function(){frame('tbsq_db');};
		//document.getElementById("42").onclick=function(){frame('ygxx_ycb');};
		document.getElementById("51").onclick=function(){frame('tbsq_all');};
		document.getElementById("53").onclick=function(){frame('tbsq_alltd');};
		document.getElementById("57").onclick=function(){frame('tbsq_alltd');};
	}

	else if(obj=="uass_pt_hn"||obj=="uass_pt_wb")//平台用户
	{
		//默认界面
		
		topmenu.style.display="inline-block";
		//document.getElementById("21").style.display="inline-block";
		if(obj=="uass_pt_hn")//行内
		{
			if((chu=='1'&&zhi=='3')||zhi=='2'||chu=='5')//代发起
			{
				document.getElementById("22").style.display="inline-block";
			}
			else
			{
				document.getElementById("22").style.display="none";
			}
			document.getElementById("21").onclick=function(){frame('uass_pt_hn_br');};
			document.getElementById("22").onclick=function(){frame('uass_pt_hn_df');};
			document.getElementById("frame").src="<%=path%>/showuassptpage.action?newnumber=${newnumber}&brdf=br&obj="+obj;
		}
		else//外包
		{
			document.getElementById("22").style.display="none";
			document.getElementById("21").onclick=function(){frame('uass_pt_wb_df');};
			document.getElementById("frame").src="<%=path%>/showuassptpage.action?newnumber=${newnumber}&brdf=df&obj="+obj;
		}
		document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="none";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="none";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		document.getElementById("53").style.display="none";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
		document.getElementById("57").style.display="none";
		document.getElementById("58").style.display="none";
		

		//document.getElementById("21").onclick=function(){frame('uass_pt_br');};
		//document.getElementById("22").onclick=function(){frame('uass_pt_df');}; 
		document.getElementById("31").onclick=function(){frame('uass_pt_lz');};
		document.getElementById("41").onclick=function(){frame('uass_pt_db');};
		document.getElementById("51").onclick=function(){frame('uass_pt_all');};
	}
	else if(obj=="uass_pt_hn_br")//uass平台用户本人发起
	{
		document.getElementById("frame").src="<%=path%>/showuassptpage.action?newnumber=${newnumber}&brdf=br&obj="+obj;
	}
	else if(obj=="uass_pt_hn_df"||obj=="uass_pt_wb_df")//uass平台用户代发起 
	{
		document.getElementById("frame").src="<%=path%>/showuassptpage.action?newnumber=${newnumber}&brdf=df&obj="+obj;
	}
	else if(obj=="uass_pt_db")//uass平台用户待办事宜
	{
		document.getElementById("frame").src="<%=path%>/viewusptunder.action?newnumber=${newnumber}";
	}
	else if(obj=="uass_pt_all")//uass平台用户查询所有
	{
		document.getElementById("frame").src="<%=path%>/usptviewall.action?newnumber=${newnumber}";
	}
	else if(obj=="uass_pt_lz")//uass平台用户查询流转中
	{
		document.getElementById("frame").src="<%=path%>/usptviewlzz.action?newnumber=${newnumber}";
	}
	else if(obj=="uass_cost_hn")//cost行内用户
	{
		//默认界面
		document.getElementById("frame").src="<%=path%>/uschshowpage.action?newnumber=${newnumber}&brdf=br";
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
//		if((chu=='1'&&zhi=='3')||zhi=='2'||chu=='5')//普通员工(除考勤管理员)不能代发起
//		{
			document.getElementById("22").style.display="inline-block";
//		}
//		else
//		{
//			document.getElementById("22").style.display="none";
//		}
		document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="none";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="none";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		document.getElementById("53").style.display="none";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
		document.getElementById("57").style.display="none";
		document.getElementById("58").style.display="none";

		document.getElementById("21").onclick=function(){frame('usch_br');};
		document.getElementById("22").onclick=function(){frame('usch_df');};  
		document.getElementById("31").onclick=function(){frame('usch_lz');};
		document.getElementById("41").onclick=function(){frame('usch_db');};
		document.getElementById("51").onclick=function(){frame('usch_all');};
	}
	else if(obj=="usch_br")//uassCOST行内用户本人发起
	{
		document.getElementById("frame").src="<%=path%>/uschshowpage.action?newnumber=${newnumber}&brdf=br";
	}
	else if(obj=="usch_df")//uassCOST行内用户代发起
	{
		document.getElementById("frame").src="<%=path%>/uschshowpage.action?newnumber=${newnumber}&brdf=df";
	}
	else if(obj=="usch_db")//uassCOST行内用户待办事宜
	{
		document.getElementById("frame").src="<%=path%>/uschviewunder.action?newnumber=${newnumber}";
	}
	else if(obj=="usch_all")//uassCOST行内用户查询所有
	{
		document.getElementById("frame").src="<%=path%>/uschviewall.action?newnumber=${newnumber}";
	}
	else if(obj=="usch_lz")//uassCOST行内用户查询流转中
	{
		document.getElementById("frame").src="<%=path%>/uschviewlzz.action?newnumber=${newnumber}";
	}
	else if(obj=="uass_cost_wb")//cost外包用户
	{
		//默认界面
		document.getElementById("frame").src="<%=path%>/uscwshowpage.action?newnumber=${newnumber}";
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
		document.getElementById("22").style.display="none";
		document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="none";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="none";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		document.getElementById("53").style.display="none";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
		document.getElementById("57").style.display="none";
		document.getElementById("58").style.display="none";

		document.getElementById("21").onclick=function(){frame('uscw_br');};
		document.getElementById("31").onclick=function(){frame('uscw_lz');};
		document.getElementById("41").onclick=function(){frame('uscw_db');};
		document.getElementById("51").onclick=function(){frame('uscw_all');};
	}
	else if(obj=="uscw_br")//uassCOST外包用户本人发起
	{
		document.getElementById("frame").src="<%=path%>/uscwshowpage.action?newnumber=${newnumber}";
	}
	else if(obj=="uscw_db")//uassCOST外包用户待办事宜
	{
		document.getElementById("frame").src="<%=path%>/uscwviewunder.action?newnumber=${newnumber}";
	}
	else if(obj=="uscw_all")//uassCOST外包用户查询所有
	{
		document.getElementById("frame").src="<%=path%>/uscwviewall.action?newnumber=${newnumber}";
	}
	else if(obj=="uscw_lz")//uassCOST外包用户查询流转中
	{
		document.getElementById("frame").src="<%=path%>/uscwviewlzz.action?newnumber=${newnumber}";
	}
	else if(obj=="uass_jh_hn"||obj=="uass_jh_wb")//稽核用户维护申请
	{
		//默认界面
		//document.getElementById("frame").src="<%=path%>/usjhshowpage.action?newnumber=${newnumber}";
		topmenu.style.display="inline-block";
		document.getElementById("21").style.display="inline-block";
		document.getElementById("22").style.display="none";
		if(obj=="uass_jh_hn")//行内
		{
			document.getElementById("21").onclick=function(){frame('usjh_hn');};
			document.getElementById("frame").src="<%=path%>/usjhshowpage.action?newnumber=${newnumber}&obj="+obj;
		}
		else//外包
		{
			document.getElementById("21").onclick=function(){frame('usjh_wb');};
			document.getElementById("frame").src="<%=path%>/usjhshowpage.action?newnumber=${newnumber}&obj="+obj;
		}
		
		
		document.getElementById("23").style.display="none";
		document.getElementById("24").style.display="none";
		document.getElementById("31").style.display="inline-block";
		document.getElementById("32").style.display="none";
		document.getElementById("41").style.display="inline-block";
		document.getElementById("42").style.display="none";
		document.getElementById("51").style.display="inline-block";
		document.getElementById("52").style.display="none";
		document.getElementById("53").style.display="none";
		document.getElementById("54").style.display="none";
		document.getElementById("55").style.display="none";
		document.getElementById("56").style.display="none";
		document.getElementById("57").style.display="none";
		document.getElementById("58").style.display="none";

		//document.getElementById("21").onclick=function(){frame('usjh_br');};
		document.getElementById("31").onclick=function(){frame('usjh_lz');};
		document.getElementById("41").onclick=function(){frame('usjh_db');};
		document.getElementById("51").onclick=function(){frame('usjh_all');};
	}
	else if(obj=="usjh_hn"||obj=="usjh_wb")//uass稽核用户本人发起
	{
		document.getElementById("frame").src="<%=path%>/usjhshowpage.action?newnumber=${newnumber}&obj="+obj;
	}
	else if(obj=="usjh_db")//uass稽核用户待办事宜
	{
		document.getElementById("frame").src="<%=path%>/usjhviewunder.action?newnumber=${newnumber}";
	}
	else if(obj=="usjh_all")//uass稽核用户查询所有
	{
		document.getElementById("frame").src="<%=path%>/usjhviewall.action?newnumber=${newnumber}";
	}
	else if(obj=="usjh_lz")//uass稽核用户查询流转中
	{
		document.getElementById("frame").src="<%=path%>/usjhviewlzz.action?newnumber=${newnumber}";
	}
	else if(obj=="uass_ycsh")//远程审核
	{
		//默认界面
		document.getElementById("frame").src="#";
		topmenu.style.display="none";
	}
	else if(obj=="ygxx_br")//因公下线本人发起
	{
		document.getElementById("frame").src="<%=path%>/showygxxpage.action?newnumber=${newnumber}";
	}
	else if(obj=="ygxx_lz")//因公下线流转中
	{
		document.getElementById("frame").src="<%=path%>/ygxxlzz.action?newnumber=${newnumber}";
	}
	else if(obj=="ygxx_db")//因公下线流转中
	{
		document.getElementById("frame").src="<%=path%>/viewygxxunder.action?newnumber=${newnumber}";
	}
	else if(obj=="ygxx_all")//因公下线明细
	{
		document.getElementById("frame").src="<%=path%>/viewygxxall.action?newnumber=${newnumber}&type=gr";
	}
	else if(obj=="ygxx_alltd")//因公下线明细
	{
		document.getElementById("frame").src="<%=path%>/viewygxxall.action?newnumber=${newnumber}&type=all";
	}
	else if(obj=="ygxx_hz")//因公下线汇总个人
	{
		document.getElementById("frame").src="<%=path%>/viewygxxhz.action?newnumber=${newnumber}&type=gr";
	}
	else if(obj=="ygxx_hztd")//因公下线汇总团队
	{
		document.getElementById("frame").src="<%=path%>/viewygxxhz.action?newnumber=${newnumber}&type=all";
	}
	//调班申请
	else if(obj=="tbsq_br")//调班申请本人发起
	{
		document.getElementById("frame").src="<%=path%>/showtbsqpage.action?newnumber=${newnumber}&df=0";
	}
	else if(obj=="tbsq_df")//调班申请代发起
	{
		document.getElementById("frame").src="<%=path%>/showtbsqpage.action?newnumber=${newnumber}&df=1";
	}
	else if(obj=="tbsq_lz")//调班申请流转中
	{
		document.getElementById("frame").src="<%=path%>/tbsqlzz.action?newnumber=${newnumber}";
	}
	else if(obj=="tbsq_db")//调班申请待办
	{
		document.getElementById("frame").src="<%=path%>/viewtbsqunder.action?newnumber=${newnumber}";
	}
	else if(obj=="tbsq_all")//调班申请明细
	{
		document.getElementById("frame").src="<%=path%>/viewtbsqall.action?newnumber=${newnumber}&type=gr";
	}
	else if(obj=="tbsq_alltd")//调班申请明细团队
	{
		document.getElementById("frame").src="<%=path%>/viewtbsqall.action?newnumber=${newnumber}&type=all";
	}
	else if(obj=="test_drrlb")//导入日历表
	{
		document.getElementById("frame").src="<%=path%>/page/kqjl/importrlb.jsp";
		topmenu.style.display="none";
	}
	//考勤记录
	else if(obj=="test_drkq")//导入考勤数据
	{
		document.getElementById("frame").src="<%=path%>/showkqjlimport.action";
		topmenu.style.display="none";
	}
	else if(obj=="kqjl_zw")//考勤记录-指纹记录
	{
		topmenu.style.display="none";
		document.getElementById("frame").src="<%=path%>/kqjlzw.action?newnumber=${newnumber}&all=0";
		//document.getElementById("daohang").innerHTML="考勤记录->记录查询->日报表";
	}
	else if(obj=="kqjl_rb")//考勤记录-日报表
	{
		topmenu.style.display="none";
		document.getElementById("frame").src="<%=path%>/kqjldaily.action?newnumber=${newnumber}&md=1&tj=1";
		//document.getElementById("daohang").innerHTML="考勤记录->记录查询->日报表";
	}
	else if(obj=="kqjl_grrb")//考勤记录-个人日报表
	{
		topmenu.style.display="none";
		document.getElementById("frame").src="<%=path%>/kqjlgrdaily.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="考勤记录->记录查询->日报表";
	}
	else if(obj=="kqjl_yc")//考勤数据异常表
	{
		document.getElementById("frame").src="<%=path%>/kqjlycdaily.action?newnumber=${newnumber}";
		topmenu.style.display="none";
	}
	else if(obj=="kqjl_hz")//考勤记录-汇总表
	{
		topmenu.style.display="none";
		document.getElementById("frame").src="<%=path%>/kqjlhzb.action?newnumber=${newnumber}";
		//document.getElementById("daohang").innerHTML="考勤记录->记录查询->月报表";
	}
	else if(obj=="kqjl_yb")//考勤记录-月报表
	{
		topmenu.style.display="none";
		document.getElementById("frame").src="<%=path%>/kqjlmonth.action?newnumber=${newnumber}&key=chitui&sequence=1";
		//document.getElementById("daohang").innerHTML="考勤记录->记录查询->月报表";
	}
	else if(obj=="test_drygxx")//导入员工信息表
	{
		document.getElementById("frame").src="<%=path%>/page/userinfo/importuserinfo.jsp";
		topmenu.style.display="none";
	}
	else if(obj=="test_drcshsj")//导入初始化数据
	{
		document.getElementById("frame").src="<%=path%>/page/import/importdata.jsp";
		topmenu.style.display="none";
	}
	else if(obj=="test_drpic")//导入图片
	{
		document.getElementById("frame").src="<%=path%>/page/import/importpic.jsp";
		topmenu.style.display="none";
	}
	else if(obj=="pic_display")//导入图片
	{
		document.getElementById("frame").src="<%=path%>/page/import/displaypic.action";
		topmenu.style.display="none";
	}
	else if(obj=="pb_config")//排班设置
	{
		document.getElementById("frame").src="<%=path%>/getpbconfig.action";
		topmenu.style.display="none";
	}
	else if(obj=="pb_import")//排班数据导入
	{
		document.getElementById("frame").src="<%=path%>/page/pb/pbimport.jsp";
		topmenu.style.display="none";
	}
	else if(obj=="scpb_table")//生产排班表展示
	{
		document.getElementById("frame").src="<%=path%>/scpbtable.action";
		topmenu.style.display="none";
	}
	else if(obj=="pb_mx")//排班明细查询
	{
		document.getElementById("frame").src="<%=path%>/pbmx.action?newnumber=${newnumber}";
		topmenu.style.display="none";
	}
	else if(obj=="pb_test")//排班测试
	{
		document.getElementById("frame").src="<%=path%>/page/pb/test.jsp";
		topmenu.style.display="none";
	}
	if((obj=="test_mjgl"||obj=="mjgl_br"||obj=="mjgl_lz"||obj=="mjgl_ybj"||obj=="mjgl_db"||obj=="mjgl_all"||obj=="mjgl_tdall"||obj=="mjgl_ycb"||obj=="mjgl_qxcx")&&(${authoQ=='Q'}))//显示导入模块
	{
	    document.getElementById("61").style.display="inline-block";
		document.getElementById("62").style.display="inline-block";
	}
	else
	{
		document.getElementById("61").style.display="none";
		document.getElementById("62").style.display="none";
	}
	

	if(obj=="ygxx_page"||obj=="ygxx_br"||obj=="ygxx_lz"||obj=="ygxx_db"||obj=="ygxx_all"||obj=="ygxx_alltd"||obj=="ygxx_hz"||obj=="ygxx_hztd")
	{
		if(zhi=='0'||zhi=='1'||zhi=='2'||chu=='2'||chu=='1')
		{
			document.getElementById("51").innerHTML='个人发起明细';
		}
		else
		{
			document.getElementById("51").innerHTML='个人下线明细';
		}
	}
   else
	{
		document.getElementById("51").innerHTML='明细查询';
	}
	
	//if(obj=="test_leave"||obj=="test_wcgg"||obj=="test_mjgl"||obj=="tbsq_page"||obj=="ygxx_page"||obj=="test_kqqs"||obj=="test_jbsp"||obj=="test_mjgl")
}
</script>

<script type="text/javascript">
$(document).ready(function(){

	topmenu.style.display="none";			   
	/* 滑动/展开 */
	$("ul.expmenu li > div.header").click(
	function()
	{
		var arrow = $(this).find("span.arrow");
	
		$(this).parent().find("ul.menu1").slideToggle("fast").parents(".a").siblings(".a").children("ul.menu1").hide(300);
	}
);
	$(".cc").click(
			function()
			{
				$(".cc").css("width","155px");
				$(this).css("width","168px");	
			}
			);
});
</script>
<style>
.menu1 ol { padding-left:15px; border:#E7E7E7 1px solid; border-top:none;background: #f7f2e5;}
.menu1 li i{background-color: #ae9c7e;padding: 1px 4px;color: #fff;text-shadow: 0px 0px 0px rgba(255, 255, 255, 0.8);font-family: 宋体;font-style:normal;}
.menu1 a{color: #3f3f3f;text-decoration: none;}
.menu1 .no {display:none;}
.menu1 ol a{width: 228px;display: block;line-height: 2em;margin-left: 20px;}
</style>

<style media="print" type="text/css"> 
.noprint{display:none;} 
</style> 

</head>
<body onload="startTime()"> 
	<div id="zhuti" style="position:absolute">
		<div id="top" class="noprint">
			<img src="images/logo.gif" width="276" height="50"
				style="margin-top:0px" />
		</div>
		<div class="x_beijing">
			<div class="x_anniu noprint">
				<div>
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b
						class="b4 d1"></b>
					<div class="b d1 k">
						<div class=x_gr>
							<!-- 登陆用户信息 -->
							<p style="margin:0px；padding:0px">${username }</p>
							<p style="font-size:14px">欢迎访问自助办公工具</p>
							<p>
								
								<input align="right" name="logout" type="button" value="回到首页" onclick="location='mainccb.jsp'" />
								<input type="hidden" id="id" name="id" value="${id}"/> 
							</p>
							<p><%=new SimpleDateFormat("yyyy年MM月dd日").format(new java.util.Date())%></p>
							<p id="txt"></p>
							<p>累计访问量：${views}</p>
						</div>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b
						class="b1b"></b>
				</div>
					<div class="menu1" style="margin-top: 5px; background-color: #188AE7;">
						<ul class="expmenu">
							<li class="a">
								<div class="header">
									<span class="label">待办事宜</span>
								</div>
								<ul class="menu1">
									<li class="cc"  onclick="frame('home')">待办事宜</li>
								</ul>
							</li>
							<c:if test="${authoR!='R'&&authoS!='S'}">
							<li class="a">
								<div class="header">
									<span class="label">考勤管理</span>
								</div>
								<ul class="menu1">
									<li class="cc"  onclick="frame('test_leave')">请假申请</li>
									<li class="cc"  onclick="frame('test_wcgg')">外出公干</li>
									<li class="cc"  onclick="frame('test_jbsp')">加班申请</li>
									<li class="cc"  onclick="frame('test_kqqs')">考勤缺失</li>
								</ul>
							</li>
						
							<li class="a">
								<div class="header">
									<span class="label">事项审批</span>
								</div>
								<ul class="menu1">
								
									<li class="cc"  onclick="frame('test_zzzm')">在职证明</li>
									<li class="cc"  onclick="frame('test_srzm')">收入证明</li>

									<li class="cc"  onclick="frame('test_yscj')">因私出国（境）</li>
									<li class="cc"  onclick="frame('test_mjgl')">门禁管理</li>
		
									<c:if test="${chu!='5'}">
										
										<li class="cc"  onclick="frame('ygxx_page')">因公下线</li>
										<c:if test="${chu!='4'}">
											<li class="cc"  onclick="frame('tbsq_page')">生产调班</li>
										</c:if>
									</c:if>
									

								</ul>
							</li>
							
							<li class="a">
								<div class="header">
									<span class="label"> 考勤月报</span>
								</div>
								<ul class="menu1">
								<c:if test="${authoI=='I'||authoT=='T'||authoC=='C'}">
								<li class="cc"  onclick="frame('test_drkq')">数据导入</li>
								</c:if>
								<li class="cc"  onclick="frame('kqjl_zw')">指纹记录</li>
								<c:if test="${zhi=='0'||zhi=='1'||zhi=='2'||authoI=='I'}"><!-- 主任看全部 -->
									<li class="cc"  onclick="frame('kqjl_rb')">考勤明细表</li>
								</c:if>
								<c:if test="${zhi!='0'&&zhi!='1'&&zhi!='2'&&authoI!='I'}"><!-- 其他人看当月本人 -->
									<li class="cc"  onclick="frame('kqjl_grrb')">考勤明细表</li>
								</c:if>
								<!-- 
									<li class="cc"  onclick="frame('kqjl_yc')">考勤异常表</li>
								
								<c:if test="${zhi=='2'||zhi=='1'||autho=='I'}">
									<li class="cc"  onclick="frame('kqjl_hz')">考勤汇总表</li>
								</c:if>	
								 -->
									<li class="cc"  onclick="frame('kqjl_yb')">考勤月报表</li>
								</ul>
							</li>
							<li class="a">
								<div class="header">
									<span class="label" >生产排班</span>
								</div>
								<ul class="menu1">
									<c:if test="${zhi=='0'||zhi=='1'||zhi=='2'||authoI=='I'||authoT=='T'}">
										<c:if test="${chu!='4'&&chu!='5'}">
										<li class="cc"  onclick="frame('pb_config')">排班设置</li>
										</c:if>
									</c:if>
									<c:if test="${authoI=='I'||authoT=='T'}">
									<li class="cc"  onclick="frame('pb_import')">数据导入</li>
									</c:if>
									<c:if test="${zhi=='0'||zhi=='1'||zhi=='2'||chu=='1'||chu=='2'}">
										<li class="cc"  onclick="frame('scpb_table')">排班展示</li>
									</c:if>
									<li class="cc"  onclick="frame('pb_mx')">排班明细查询</li>
									
								</ul>
							</li>
							</c:if>
						   <c:if test="${zhi=='0'||zhi=='1'||zhi=='2'||authoN=='N'||authoM=='M'||authoR=='R'||authoS=='S'}">
							<li class="a">
								<div class="header">
								<span class="label">资产管理</span>
								</div>
								<ul class="menu1">
								<c:if test="${authoN=='N'||authoM=='M'||zhi=='0'||zhi=='1'||authoP=='P'||authoR=='R'||authoS=='S'}">
									<li class="cc"  onclick="frame('test_zcsl')">资产申领</li>
									<li class="cc"  onclick="frame('test_zcgh')">资产归还</li>
									<c:if test="${authoR!='R'&&authoS!='S'}">
									<li class="cc"  onclick="frame('test_zcjy')">资产借用</li>
									<!-- <li class="cc"  onclick="frame('test_zcxj')">资产续借</li> -->
									<!--<li class="cc"  onclick="frame('test_zcgh')">资产归还</li>-->
									</c:if>
								</c:if>
								<c:if test="${zhi=='0'||authoH=='H'||authoP=='P'||authoM=='M'||(chu=='1'&&authoN=='N')}">
									<li class="cc"  onclick="frame('zccx_alltd')">中心资产</li>
								</c:if>
								<c:if test="${(zhi=='2'||zhi=='1'||authoN=='N')&&(authoP!='P')&&!(chu=='1'&&authoN=='N')}">
								    <li class="cc"  onclick="frame('zccx_all')">处室资产</li>
								</c:if>
								<c:if test="${authoN=='N'&&chu=='1'}">
								    <li class="cc"  onclick="frame('zccx_allzong')">处室资产</li>
								</c:if>
								<c:if test="${authoR=='R'}">
								    <li class="cc"  onclick="frame('zccx_allwb')">外包资产</li>
								</c:if>
								<c:if test="${authoS=='S'}">
								    <li class="cc"  onclick="frame('zccx_allwb1')">外包资产</li>
								</c:if>
								<c:if test="${authoM=='M'||(chu=='1'&&authoN=='N')}">
		                            <li class="cc"  onclick="frame('test_kfrk')">入库管理</li>
		                            <li class="cc"  onclick="frame('test_kfbf')">报废管理</li>
		                         </c:if> 
								</ul>
							</li>
							</c:if>
							<c:if test="${authoR!='R'&&authoS!='S'}">
							<li class="a">
								<div class="header">
									<span class="label">渠道用户</span>
								</div>
								<ul class="menu1">
								
									<li class="frame">平台用户
										<ul class="menu3">
											<li class="cc" class="frame" onclick="frame('uass_pt_hn')">行方操作员</li>
											<c:if test="${zhi=='0'||zhi=='1'||zhi=='2'||authoL=='L'||authoO=='o'}">
											<li class="cc" class="frame" onclick="frame('uass_pt_wb')">外包操作员</li>
											</c:if>
										</ul>
									</li>
									<li class="frame">COS_T用户
										<ul class="menu3">
											<li class="cc" class="frame" onclick="frame('uass_cost_hn')">行方操作员</li>
											<c:if test="${zhi=='0'||zhi=='1'||zhi=='2'||authoL=='L'||authoO=='o'}">
											<li class="cc" class="frame" onclick="frame('uass_cost_wb')">外包操作员</li>
											</c:if>
										</ul>
									</li>
									<li class="frame">稽核系统用户
										<ul class="menu3">
											<li class="cc" class="frame" onclick="frame('uass_jh_hn')">行方操作员</li>
											<c:if test="${zhi=='0'||zhi=='1'||zhi=='2'||authoL=='L'||authoO=='o'}">
											<li class="cc" class="frame" onclick="frame('uass_jh_wb')">外包操作员</li>
											</c:if>
										</ul>
									</li>
								</ul>
							</li>
							</c:if>
							
							<c:if test="${authoI=='I'||authoJ=='J'||zhi=='0'||zhi=='1'||authoL=='L'}">
							<li class="a">
								<div class="header">
									<span class="label">用户管理</span>
								</div>
								<ul class="menu1">
									<li class="cc"  onclick="frame('user_list')">用户列表</li>
									<c:if test="${zhi=='0'||authoI=='I'||authoL=='L'}">
										
										<li class="cc"  onclick="frame('test_drrlb')">导入日历表</li>
										<li class="cc"  onclick="frame('test_drygxx')">导入员工信息表</li>
										 
										<li class="cc"  onclick="frame('user_set')">用户设置</li>
										<!--
										<li class="cc"   onclick="frame('test_drpic')">导入图片</li>
										<li class="cc"   onclick="frame('pic_display')">已上传的图片</li>
										<li class="cc"   onclick="frame('test_drcshsj')">导入初始化数据</li> -->
									</c:if>
								</ul>
							</li>
							</c:if>
						</ul>
					</div>
			</div>
			<div class="x_xianshi" style="overflow:hidden">
				<div style="overflow:hidden">
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b class="b4 d1"></b>
					<div class="b d1 k3">
 <!--代码开始-->
							<div class="top noprint" id="topmenu">
								<ul class="menu noprint">
									<!-- <li id="daohang" style="background-color:#FFFFFF;width:220px;font-weight:bold">首页</li> -->
									<li>
										<a  class="tablink arwlink noprint">发起申请</a>
										<ul>
											<li><a id="21" href="#" onclick="">本人发起</a><li><a id="23" href="#" onclick="">本人发起</a>
											<li><a id="22" href="#" onclick="">代发起</a><li><a id="24" href="#" onclick="">本人发起</a>
								
										</ul>
							 		</li>
							        
 							      
							       <li>
 							      		<a href="#" class="tablink arwlink noprint">查看本人申请</a>
  							          <ul>
											<li><a id="31" href="#" onclick="">流转中</a></li>
											<li><a id="32" href="#" onclick="">已办结归档</a></li>
							
 							           </ul>
							                <div class="hot"></div>
							      </li>
							      <li>
 							           <a href="#" class="tablink arwlink noprint">查看本人承办</a>
 							           <ul>
											<li><a id="41" href="#" onclick="">待办事宜</a></li>
											<li><a id="42" href="#" onclick="">已承办</a></li>
							            </ul>
							      </li>
							      <li>
							            <a href="#" class="tablink arwlink noprint">统计查询</a>
 							           <ul>
<!-- 
											<li><a id="51" href="#" style="width:80px" onclick="frame('tjcx_mx')">个人明细</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="53" href="#" onclick="frame('tjcx_tdmx')"><c:if test="${autho=='I'||autho=='J'||zhi=='0'||zhi=='1'}">中心明细</c:if><c:if test="${zhi=='2'||zhi=='4'||autho=='NT'||autho=='Q'}">团队明细</c:if></a></li>
											<li><a id="52" href="#" style="width:80px" onclick="frame('tjcx_hz')">个人汇总</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="54" href="#" onclick="frame('tjcx_tdhz')"><c:if test="${autho=='I'||autho=='J'||zhi=='0'||zhi=='1'}">中心汇总</c:if><c:if test="${zhi=='2'||zhi=='4'}">团队汇总</c:if></a></li>
-->
											<li><a id="51" href="#" style="width:80px" onclick="">明细查询</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="53" href="#" style="width:80px" onclick="">中心明细</a><a id="57" href="#" style="width:80px" onclick="">团队明细</a></li>
											<li><a id="52" href="#" style="width:80px" onclick="">个人汇总</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="54" href="#" style="width:80px" onclick="">中心汇总</a><a id="58" href="#" style="width:80px" onclick="">团队汇总</a></li>

							                <li><a id="55" href="#" style="width:90px" onclick="frame('yscj_tzcx')"><c:if test="${authoK=='K'}">因私出国证照领取台账查询</c:if></a><a id="56" href="#" style="width:90px" onclick="frame('mjgl_qxcx')">个人门禁权限</a> </li>
							                <!--<li><a id="56" href="#" style="width:90px" onclick="frame('mjgl_qxcx')">个人门禁权限</a></li>  -->
							            </ul>
							            
							      </li>
							    
							      <li>
 							           <a  id="62" href="#" class="tablink arwlink noprint">门禁权限</a>
 							           <ul>
											<li><a id="61" href="#" style="width:150px" onclick="frame('mjgl_page')">门禁权限导入</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--  <a id="62" href="#" style="width:120px" onclick="frame('mjgl_qxcxall')">中心门禁权限查看</a>--></li>
											
							            </ul>
							      </li>
							     
							   </ul>
							</div>

<!--代码结束-->
						
						
						<iframe id="frame" class="mainpage"	src="<%=path%>/welcome.action?newnumber=${newnumber}" marginwidth='0' marginheight='0' frameborder='0'></iframe>
						<input type="hidden" id="zhi" value="${zhi}"/>
						<input type="hidden" id="chu" value="${chu}"/>
						<!-- <input type="hidden" id="autho" value="${autho}"/> -->
						<input type="hidden" id="authoA" value="${authoA}"/>
						<input type="hidden" id="authoB" value="${authoB}"/>
						<input type="hidden" id="authoC" value="${authoC}"/>
						<input type="hidden" id="authoD" value="${authoD}"/>
						<input type="hidden" id="authoE" value="${authoE}"/>
						<input type="hidden" id="authoF" value="${authoF}"/>
						<input type="hidden" id="authoG" value="${authoG}"/>
						<input type="hidden" id="authoH" value="${authoH}"/>
						<input type="hidden" id="authoI" value="${authoI}"/>
						<input type="hidden" id="authoJ" value="${authoJ}"/>
						<input type="hidden" id="authoK" value="${authoK}"/>
						<input type="hidden" id="authoL" value="${authoL}"/>
						<input type="hidden" id="authoM" value="${authoM}"/>
						<input type="hidden" id="authoN" value="${authoN}"/>
						<input type="hidden" id="authoO" value="${authoO}"/>
						<input type="hidden" id="authoP" value="${authoP}"/>
						<input type="hidden" id="authoQ" value="${authoQ}"/>
						<input type="hidden" id="authoR" value="${authoR}"/>
						<input type="hidden" id="authoS" value="${authoS}"/>
						<input type="hidden" id="authoT" value="${authoT}"/>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b class="b1b"></b>
				</div>
			</div>
		</div>
	</div>
</body>
</html>