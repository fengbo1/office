package office.zcgl.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.zcgl.dao.AssetInfoDAO;
import office.zcgl.dao.StorehouseDataDAO;
import office.zcgl.pojo.AssetInfo;
import office.zcgl.pojo.StorehouseData;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportZcKfOut {
	private static Logger logger = Logger.getLogger(ImportAssetApplyFenName.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    private String rukunum;
    private String result;
    private UserInfo ui;
    private String tel;
    private String remark;
    private String newnumber;
   
    
    
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String getRukunum() {
		return rukunum;
	}
	public void setRukunum(String rukunum) {
		this.rukunum = rukunum;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
  public String execute() throws Exception {
		
		String realpath = "D:/import/office/";
		message = "导入成功";
		result="success";
		 Query query;
		//UserInfoDAO uidao = new UserInfoDAO();
		DateUtil Date = new DateUtil();
		rukunum = Date.getSimpleDateTime();
		int nn=0;
		if (file != null) {
	       File savefile = new File(new File(realpath), fileFileName);
	       if (!savefile.getParentFile().exists())
	            savefile.getParentFile().mkdirs();
	           FileUtils.copyFile(file, savefile);
	     }
	    else
	    {
	    	 message = "传入文件有误！";
	    	//ActionContext.getContext().put("message", "传入文件有误");
	    }
	
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	int flag = 0;
	    	StorehouseDataDAO sthdao = new StorehouseDataDAO();
	    	StorehouseData sth = new StorehouseData();
	    	AssetInfoDAO aidao = new AssetInfoDAO();
	    	UserInfoDAO uidao = new UserInfoDAO();
	 	    ui = uidao.findByNewNumber(newnumber);
	    	String assetname = "";
	    	String assettype = "";
	    	String assetnumber = "";
	    	//String rukutime = "";
	    	String sn = "";
	    
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				
				for (int i = 1; i < nn; i++) {
					assetname = sheet.getCell(0, i).getContents().trim();
					assettype = sheet.getCell(1, i).getContents().trim();
					assetnumber = sheet.getCell(2, i).getContents().trim();
					sn = sheet.getCell(3, i).getContents().trim();
					//rukutime = sheet.getCell(4, i).getContents().trim();
					AssetInfo ai = new AssetInfo();
					if(!sheet.getCell(2, i).getContents().trim().equals(""))
				    {
					   ai = aidao.findAllByNumberAndChu(assetnumber);
				    }
					if(sheet.getCell(0, i).getContents().trim().equals(""))
					{
						flag = 1;
						break;
					}
					else if(sheet.getCell(1, i).getContents().trim().equals(""))
					{
						flag = 2;
						break;
					}
					else if(sheet.getCell(2, i).getContents().trim().equals(""))
					{
						flag = 3;
						break;
					}
					/*else if(sheet.getCell(4, i).getContents().trim().equals(""))
					{
						flag = 4;
						break;
					}*/
					else if(ai==null)
					{
						flag = 5;
						break;
					}
					
					else
					{
						sth.setAssetname(assetname);
						sth.setAssetnumber(assetnumber);
						sth.setAssettype(assettype);
						sth.setRukunum(rukunum);
						//sth.setRukutime(rukutime);
						if(sheet.getCell(2, i).getContents().trim().substring(5, 6).equals("1"))
						{
							sth.setIswupin(0);
						}
						else
						{
							sth.setIswupin(1);
						}
						sth.setArea("报废");
						sth.setSn(sn);
						sthdao.merge(sth);
					}
					
	    	        }
				
				 
				  if(flag==1)
				  {
					  message="存在资产名称为空！";
					 // ActionContext.getContext().put("message", "存在资产名称为空！");
					 result="failed";
				  }
				  else if(flag==2)
				  {
					  message="存在资产类型为空！";
					 // ActionContext.getContext().put("message", "存在资产类型为空！");
						 result="failed";
				  }
				  else if(flag==3)
				  {
					  message="存在资产编号为空！";
					  //ActionContext.getContext().put("message", "存在资产编号为空！");
						 result="failed";
				  }
				/*  else if(flag==4)
				  {
					  message="存在入库时间为空！";
					  //ActionContext.getContext().put("message", "存在入库时间为空！");
						 result="failed";
				  }*/
				  else if(flag==5)
				  {
					  message="资产编号重复！";
					  //ActionContext.getContext().put("message", "报废资产不在库房中！");
						 result="failed";
				  }
				 
				}
				catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			    }
				finally{
				 trans.commit();
		         session.flush();
		         session.clear();
		         session.close();
			  }
			
		
		return result;
   }
}
