package office.kqjl.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.ScpbUploadDAO;
import office.kqjl.dao.YgpbUploadDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.ScpbUpload;
import office.kqjl.pojo.YgpbUpload;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.userinfo.dao.UserInfoDAO;
import office.util.Util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

/**
 * 导入下线情况
 * 从t_kqjl_daily中剔除下线情况   
 * @author htzx
 *
 */
public class ImportXiaXian {

	private static Logger logger = Logger.getLogger(ImportKqjl.class);
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
    
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
	public String execute() throws Exception{
		String realpath = "D:/import/office/";
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		PbMxDAO pmdao = new PbMxDAO();
		ScpbUploadDAO sudao = new ScpbUploadDAO();
		YgpbUploadDAO yudao = new YgpbUploadDAO();
		int nn=0;
		message = "导入成功";
		if (file != null) {
		       File savefile = new File(new File(realpath), fileFileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file, savefile);
		     }
		    else
		    {
		    	ActionContext.getContext().put("message", "传入文件有误");
		    }
		
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 得到第一列第一行的单元格
			nn = sheet.getRows();
			for (int i = 1; i < nn; i++) {
				String name = sheet.getCell(0, i).getContents().trim();
				String date = sheet.getCell(1, i).getContents().trim();
				System.out.println(name+i);
				if(!name.trim().equals(""))
				{
					if(uidao.findByName(name)==null)
					{
						message = "找不到员工"+name+",请确认姓名是否正确";
						
						return "success";
					}else
					{
						PbMx pm = pmdao.findAllByNameAndDateNull(name, date);
						KqjlDaily kd = kddao.findByDateAndName(date, name);
						ScpbUpload su = sudao.findAllByDateNameNull(date, name);
						YgpbUpload yu = yudao.findAllByDateNameNull(date, name);
						kd.setPbqdtime(Util.zcqd);
						kd.setPbqttime(Util.zcqt);
						if(su!=null)
						{
							su.setPbqdtime(Util.zcqd);
							su.setPbqttime(Util.zcqt);
							sudao.merge(su);
						}
						if(yu!=null)
						{
							yu.setPbqdtime(Util.zcqd);
							yu.setPbqttime(Util.zcqt);
							yudao.merge(yu);
						}
						if(pm!=null)
						{
							pm.setSw("xx");
							pm.setXw("xx");
							pmdao.merge(pm);
						}
						kddao.merge(kd);
					}
				}
			}
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		return "success";
	}
}
