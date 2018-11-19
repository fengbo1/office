package office.uass.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import office.uass.dao.UassPtDAO;
import office.uass.dao.UassPtPeopleDAO;
import office.uass.pojo.UassPt;
import office.uass.pojo.UassPtPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.PinyinTool;
import office.util.Util;
import office.util.PinyinTool.Type;

public class UsptSubPage {

	private String newnumber;
	private String message;
	private String number;
	private String name;
	private String tel;
	private String sxtime;
	private String remark;
	private String obj;
	private String thisunder;
	private File file; //上传的文件
	private String fileFileName;
	private String fileContentType;
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSxtime() {
		return sxtime;
	}
	public void setSxtime(String sxtime) {
		this.sxtime = sxtime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
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
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	public String execute() throws Exception {
		String realpath = Util.ptpath;
		UserInfoDAO uidao = new UserInfoDAO();
		DateUtil du = new DateUtil();
		UassPtDAO updao = new UassPtDAO();
		PinyinTool tool = new PinyinTool();
		UassPtPeopleDAO uppdao = new UassPtPeopleDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UassPt up = updao.findAllByNumber(number);
			if(up==null)
			{
				message = "失败！";
			}
			else
			{
				UserInfo uii = uidao.findByNewNumber(up.getInitiator());
				String uiiauthoL = uii.getAuthority().substring(11, 12);
				up.setDate(du.getStringDate());
				up.setJindu("E");
				up.setStatus(1);
				up.setSxtime(sxtime);
 				up.setUndertake(thisunder);
				up.setPreundertake("");
				up.setFilename("");
				
				if (file != null) {
					System.out.println(fileFileName);
					
					fileFileName = tool.toPinYin(fileFileName,"_",Type.FIRSTUPPER);
					System.out.println(fileFileName);
						fileFileName = number+"_file."+fileFileName.split("\\.")[fileFileName.split("\\.").length-1];
				       File savefile = new File(new File(realpath), fileFileName);
				       if (!savefile.getParentFile().exists())
				            savefile.getParentFile().mkdirs();
				           FileUtils.copyFile(file, savefile);
				           up.setFilename(fileFileName);
				     }
				updao.merge(up);
				message = "提交成功！";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
	}
}
