package office.zcgl.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import office.util.ExportExcel;
import office.util.ExportExcelTip;
import office.util.ExportXiaLaExcel;
import office.util.Util;
import office.zcgl.dao.AssertFenDAO;
import office.zcgl.pojo.AssertFen;
import office.zcgl.pojo.AssetFenNameBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExportBorrowFenName {
	private String number;
	private List<AssetFenNameBean> listshow;
	private String Path;
	
	public List<AssetFenNameBean> getListshow() {
		return listshow;
	}
	public void setListshow(List<AssetFenNameBean> listshow) {
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
		
		AssertFenDAO afdao = new AssertFenDAO();
		List<AssertFen> listaf = new ArrayList<AssertFen>();
		ExportExcelTip<AssetFenNameBean> ex = new ExportExcelTip<AssetFenNameBean>();
		String[]headers = {"资产名称","资产型号","资产编号","使用人姓名","摆放区域(请填写座位编号，若对应设备不在座位使用、保存，或座位无编号，请填写工区或房间号)"};
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    //ay= aydao.findAllByNumber(number);
	    listaf = afdao.findAllByApplyNumber(number);
 	   
 	   // ui = uidao.findByNewNumber(newnumber);
 	    //position = ui.getPosition();
 	    	
		Iterator itor = listaf.iterator();
		listshow =new ArrayList<AssetFenNameBean>();
		while(itor.hasNext())
		{	
			AssertFen af = (AssertFen)itor.next();
		    AssetFenNameBean as = new AssetFenNameBean();
		    as.setName(af.getName());
		    as.setType(af.getType());
		    as.setNumber(af.getNumber());
		   
		    listshow.add(as);	
			
		}
			
		    trans.commit();
			session.flush();
			session.clear();
			session.close();
		//导出
		 try {
			 	filePath=Util.downloadpath+"ZCJY"+number+".xls";
			 	//logger.info("导出路径"+filePath);
				Path = "ZCJY"+number+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("资产人员分配表",headers, listshow, out);
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
