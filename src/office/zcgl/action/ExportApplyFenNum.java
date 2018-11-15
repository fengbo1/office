package office.zcgl.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import office.util.DateUtil;
import office.util.ExportExcel;
import office.util.Util;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.dao.AssetTempDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.pojo.AssetFenNumBean;
import office.zcgl.pojo.AssetTemp;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class ExportApplyFenNum {
	
	private String number;
	private List<AssetFenNumBean> listshow;
	private String Path;
	
	public List<AssetFenNumBean> getListshow() {
		return listshow;
	}
	public void setListshow(List<AssetFenNumBean> listshow) {
		this.listshow = listshow;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String execute() throws Exception{
		String filePath = "";
		//AssetApply ay = new AssetApply();
		//AssetApplyDAO aydao = new AssetApplyDAO();
		AssetTempDAO apdao = new AssetTempDAO();
		List<AssetTemp> listap = new ArrayList<AssetTemp>();
		ExportExcel<AssetFenNumBean> ex = new ExportExcel<AssetFenNumBean>();
		String[]headers = {"资产名称","资产型号","资产编号"};
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	   // ay= aydao.findAllByNumber(number);
	    listap = apdao.findAllByNumber(number);
 	   
 	   // ui = uidao.findByNewNumber(newnumber);
 	    //position = ui.getPosition();
 	    	
		Iterator itor = listap.iterator();
		listshow =new ArrayList<AssetFenNumBean>();
		while(itor.hasNext())
		{	
			AssetTemp ap = (AssetTemp)itor.next();
			for(int i = 0;i<ap.getNum();i++)
			{
				AssetFenNumBean as = new AssetFenNumBean();
				as.setName(ap.getName());
				as.setType(ap.getType());
				listshow.add(as);	
			}
		}
			
		    trans.commit();
			session.flush();
			session.clear();
			session.close();
		//导出
		 try {
			 	filePath=Util.downloadpath+"ZCSL"+number+".xls";
			 	//logger.info("导出路径"+filePath);
				Path = "ZCSL"+number+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("资产 编号分配表",headers, listshow, out);
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
}
