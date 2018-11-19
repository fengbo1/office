package office.zcgl.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.ExportExcel;
import office.util.Util;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.AssetInfoBean;
import office.zcgl.pojo.AssetInfoDetailBean;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExportAssetInfoDetail {
	private static Logger logger = Logger.getLogger(ExportAssetInfo.class);
	private UserInfo ui;
	private List<AssetInfo>list;
	private String Path;
	private List<AssetInfoDetailBean> listshow;
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public List<AssetInfo> getList() {
		return list;
	}
	public void setList(List<AssetInfo> list) {
		this.list = list;
	}


	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}

	public String execute() throws Exception{
		String filePath = "";
		DateUtil du = new DateUtil();
		String date = du.getStringDate();
		ExportExcel<AssetInfoDetailBean> ex = new ExportExcel<AssetInfoDetailBean>();
		String[]headers = {"资产名称","资产型号","所在处室",
				"使用状态","入库时间","SN号","资产编号","使用人","资产/物品","使用区域","备注"};
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    Query query;
		String hql = "";
 	    UserInfoDAO uidao = new UserInfoDAO();
 	   // ui = uidao.findByNewNumber(newnumber);
 	    //position = ui.getPosition();
 	    hql = "select ai.name,ai.type,ai.chu,ai.status,ai.date,ai.sn,ai.number,ai.people,ai.iswupin,ai.area,ai.remark from AssetInfo as ai "; 
 	    hql+= " order by ai.name,ai.type,ai.chu,ai.status,ai.date";
		query = session.createQuery(hql);
		list=query.list();	
		Iterator itor = list.iterator();
		listshow =new ArrayList<AssetInfoDetailBean>();
		while(itor.hasNext())
		{	
			Object[] object = (Object[])itor.next();
			AssetInfoDetailBean as = new AssetInfoDetailBean();
			as.setName(object[0].toString());
			as.setType(object[1].toString());
			as.setChu(cToName((Integer)object[2]));
			as.setStatus(assetstatusToString((Integer)object[3]));
			as.setDate(object[4].toString());
			if(object[5]!=null)
			{
				as.setSn(object[5].toString());
			}
			//as.setSn(object[5].toString());
			if(object[6]!=null)
			{
				as.setNumber(object[6].toString());
			}
			//as.setNumber(object[6].toString());
			if(object[7]!=null)
			{
				as.setPeople( object[7].toString());
			}
			//as.setPeople( object[7].toString());
			if(object[8]!=null)
			{
				as.setIswupin(iswupinToString((Integer)object[8]) );
			}
			//as.setIswupin(iswupinToString((Integer)object[8]) );
			if(object[9]!=null)
			{
				as.setArea(object[9].toString());
			}
			//as.setArea(object[9].toString());
		    as.setRemark(object[10].toString());
			listshow.add(as);		
		}
		    trans.commit();
			session.flush();
			session.clear();
			session.close();
		//导出
		 try {
			 	filePath=Util.downloadpath+"ZCGLD"+date+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "ZCGLD"+date+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, listshow, out);
				out.close();
				System.out.println("excel导出成功！");
				
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return "success";
	}

	
	public static String cToName(Integer c)
	{
		if(c==null)
		{
			return "-";
		}
		if(c==0)
		{
			return "主任办公室";
		}
		else if(c==1)
		{
			return "综合与生产管理处";
		}
		else if(c==2)
		{
			return "合规与监督二处";
		}
		else if(c==3)
		{
			return "通用业务二处";
		}
		else if(c==4)
		{
			return "员工响应团队";
		}
		else if(c==5)
		{
			return "研发支持二处";
		}
		else if(c==6)
		{
			return "专业处理二处";
		}
		else if(c==7)
		{
			return "库房";
		}
		else if(c==11)
		{
			return "成都维度";
		}
		else if(c==12)
		{
			return "成都银雁";
		}
		else if(c==13)
		{
			return "威科姆";
		}
		else if(c==14)
		{
			return "银河万佳";
		}
		else if(c==15)
		{
			return "民兴物业";
		}
		
		else
		{
			return "其他";
		}
	}
	
	public static String assetstatusToString(Integer status)
	{
		String result = "";
		
		if(status==1)
		{
			result = "在库";
		}
		else if(status==2)
		{
			result = "领用";
		}
		else if(status==3)
		{
			result = "借用";
		}		
		else if(status==4)
		{
			result = "报废";
		}
		else
		{
			result = "未知";
		}
		
		return result;
	}
	
	public static String iswupinToString(Integer iswupin)
	{
		String result = "";
		
		if(iswupin==0)
		{
			result = "物品";
		}
		else if(iswupin==1)
		{
			result = "资产";
		}
		
		else
		{
			result = "未知";
		}
		
		return result;
	}
}
