package office.pb.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import office.kqjl.action.ImportKqjl;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.ScpbUploadDAO;
import office.kqjl.dao.YgpbUploadDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.ScpbUpload;
import office.kqjl.pojo.YgpbUpload;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.pb2.action.ProcessYgxxHz;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

/**
 * 排班管理员批量导入因公下线表
 * @author htzx
 *
 */
public class ImportYgxx {

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
		DateUtil du = new DateUtil();
		ProcessYgxxHz pyh = new ProcessYgxxHz();
		UserInfoDAO uidao = new UserInfoDAO();
		XxsqPageDAO xpdao = new XxsqPageDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		List<XxsqPage> listxp = new ArrayList<XxsqPage>();
		PbMxDAO pmdao = new PbMxDAO();
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
			//第一遍检查提醒
			for (int i = 1; i < nn; i++) {
				String date = sheet.getCell(0, i).getContents().trim();
				String name = sheet.getCell(1, i).getContents().trim();
				String reason = sheet.getCell(2, i).getContents().trim();
				System.out.println(name+i);
				if(!name.trim().equals(""))
				{
					if(uidao.findByName(name)==null)
					{
						message += "找不到员工"+name+",请确认姓名是否正确<br/>";
					}else if(xpdao.ifFindContain(date, date, name,0))
					{
						message += "数据库中已有员工"+name+"，日期"+date+"数据，请核实后提交<br/>";
					}
					else
					{
					}
				}
			}
			//第二遍导入
			if(message.equals("导入成功"))
			{
				for (int i = 1; i < nn; i++) {
					String date = sheet.getCell(0, i).getContents().trim();
					String name = sheet.getCell(1, i).getContents().trim();
					String reason = sheet.getCell(2, i).getContents().trim();
					System.out.println(name+i);
					if(!name.trim().equals(""))
					{
						XxsqPage xp = xpdao.findAllByBegindateAndEnddate(date, date, name);
						UserInfo uifq = uidao.findAllByAuthority("NT").get(0);
						PbMx pm = pmdao.findAllByNameAndDateNull(name, date);
						KqjlDaily kd = kddao.findByDateAndName(date, name);
						String index = "000";
						String number = "";
						index = "000"+fraw.readandwrite("YGXX");
						index = index.substring(index.length() - 3, index.length());
						number = du.getStringDate() + "YGXX" + "00" + index;
						kd.setPbqdtime(Util.zcqd);
						kd.setPbqttime(Util.zcqt);
						if(pm!=null)
						{
							pm.setSw("xx");
							pm.setXw("xx");
							pmdao.merge(pm);
						}
						kddao.merge(kd);
						xp.setNumber(number);
						xp.setDate(du.getStringDate());
						xp.setStatus(4);
						xp.setPreundertake("");
						xp.setUndertake("");
						xp.setInitiator(uifq.getNewnumber());
						xp.setApplicant(uifq.getNewnumber());
						xp.setPeople(name);
						xp.setTel("");
						xp.setBegindate(date);
						xp.setEnddate(date);
						xp.setHalfday(0);
						xp.setDay(1.0);
						xp.setHour(0.0);
						xp.setType(0);
						xp.setReason(20);
						xp.setQita(reason);
						xp.setRemark("排班管理员批量导入");
						xp.setView(1);
						xpdao.merge(xp);
						listxp.add(xp);
					}
				}
			}
			if(!message.equals("导入成功"))
			{
				message = message.replace("成功","失败<br/>");
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
		for(int i=0;i<listxp.size();i++)
		{
			pyh.process(listxp.get(i));
		}
		return "success";
	}
}
