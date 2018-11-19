package office.zcgl.action;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.AssetInfoBean;
import office.zcgl.pojo.AssetInfoShowBean;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class ExportAssetInfo {
	private static Logger logger = Logger.getLogger(ExportAssetInfo.class);
	private String newnumber;
	private UserInfo ui;
	private Integer chu;
	private String position;
	private String assetchu;
	private int zhuan;
	private List<AssetInfo>list;
	private List<AssetInfoBean> listshow;
	private String assetname;
	private String assettype;
	private String name;
	private String type;
	private String Path;
	
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public Integer getChu() {
		return chu;
	}
	public void setChu(Integer chu) {
		this.chu = chu;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAssetchu() {
		return assetchu;
	}
	public void setAssetchu(String assetchu) {
		this.assetchu = assetchu;
	}
	public int getZhuan() {
		return zhuan;
	}
	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}
	public List<AssetInfo> getList() {
		return list;
	}
	public void setList(List<AssetInfo> list) {
		this.list = list;
	}

	public List<AssetInfoBean> getListshow() {
		return listshow;
	}
	public void setListshow(List<AssetInfoBean> listshow) {
		this.listshow = listshow;
	}
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public String getAssettype() {
		return assettype;
	}
	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		ExportExcel<AssetInfoBean> ex = new ExportExcel<AssetInfoBean>();
		String[]headers = {"资产名称","资产型号","所在处室",
				"使用状态","入库时间","数量"};
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    Query query;
		String hql = "";
 	    UserInfoDAO uidao = new UserInfoDAO();
 	   // ui = uidao.findByNewNumber(newnumber);
 	    //position = ui.getPosition();
 	    hql = "select ai.name,ai.type,ai.chu,ai.status,ai.date,count(ai.name),ai.remark from AssetInfo as ai group by ai.name, ai.type,ai.chu,ai.status,ai.date "; 
 	    hql+= " order by ai.name,ai.type,ai.chu,ai.status,ai.date";
		query = session.createQuery(hql);
		list=query.list();
		Iterator itor = list.iterator();
		listshow =new ArrayList<AssetInfoBean>();
		while(itor.hasNext())
		{	
			Object[] object = (Object[])itor.next();
			AssetInfoBean as = new AssetInfoBean();
			as.setName(object[0].toString());
			as.setType(object[1].toString());
			as.setChu(cToName((Integer)object[2]));
			as.setStatus(assetstatusToString((Integer)object[3]));
			if(object[4]!=null)
			as.setDate(object[4].toString());
			as.setNum(object[5].toString());
			
			listshow.add(as);		
		}
			
		    trans.commit();
			session.flush();
			session.clear();
			session.close();
		//导出
		 try {
			 	filePath=Util.downloadpath+"ZCGL"+date+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "ZCGL"+date+".xls";
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
}
