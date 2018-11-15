package office.uass.action;

import java.io.File;
import java.util.List;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.process.action.GetProcessByPosition;
import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostWbDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostWb;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.Util;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UscwSubPage {
	private String newnumber;
	private String message;
	private String name;
	private String tel;
	private String content;
	private String remark;
	private String thisunder;
	private String sxtime;
	private File file1; //上传的文件
	private File file2; //上传的文件
	private File file3; //上传的文件
	private String file1FileName;
	private String file1ContentType;
	private String file2FileName;
	private String file2ContentType;
	private String file3FileName;
	private String file3ContentType;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getSxtime() {
		return sxtime;
	}
	public void setSxtime(String sxtime) {
		this.sxtime = sxtime;
	}
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public File getFile2() {
		return file2;
	}
	public void setFile2(File file2) {
		this.file2 = file2;
	}
	public File getFile3() {
		return file3;
	}
	public void setFile3(File file3) {
		this.file3 = file3;
	}
	public String getFile1FileName() {
		return file1FileName;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public String getFile1ContentType() {
		return file1ContentType;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	public String getFile2FileName() {
		return file2FileName;
	}
	public void setFile2FileName(String file2FileName) {
		this.file2FileName = file2FileName;
	}
	public String getFile2ContentType() {
		return file2ContentType;
	}
	public void setFile2ContentType(String file2ContentType) {
		this.file2ContentType = file2ContentType;
	}
	public String getFile3FileName() {
		return file3FileName;
	}
	public void setFile3FileName(String file3FileName) {
		this.file3FileName = file3FileName;
	}
	public String getFile3ContentType() {
		return file3ContentType;
	}
	public void setFile3ContentType(String file3ContentType) {
		this.file3ContentType = file3ContentType;
	}
	public String execute() throws Exception {
		String realpath = Util.ctpath;
		UassCostWb uc = new UassCostWb();
		UserInfoDAO uidao = new UserInfoDAO();
		UassCostWbDAO ucdao = new UassCostWbDAO();
		FileReadAndWrite fraw = new FileReadAndWrite();
		DateUtil du = new DateUtil();
		message = "提交成功";
		int bu = 0;// 是否补申请0:否，1：是
		String date = du.getStringDate();
		String index = "000";
		String dai = "0";
		String number = "";
		String result = "success";
		if(thisunder.contains("选择"))
		{
			message = "提交失败,请选择下一级审批人";
			return "failed";
		}
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		UserInfo ui = uidao.findByName(name);
		// zhi = Integer.parseInt(position.substring(0, 1));//
		// 职务0主任1处长2团队负责人3小组长4普通员工
			index = "000"+fraw.readandwrite("USCW");
			index = index.substring(index.length() - 3, index.length());
			number = date + "USCW" + dai + bu + index;
		if(ucdao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
		uc.setNumber(number);
		uc.setProcess(1);
		uc.setJindu("E");
		uc.setDate(date);
		uc.setStatus(1);
		uc.setPreundertake("");
		uc.setContent(content);
		uc.setUndertake(thisunder);
		uc.setInitiator(newnumber);
		uc.setPosition(ui.getPosition());
		uc.setApplicant(ui.getNewnumber());
		uc.setTel(tel);
		uc.setSxtime(sxtime);
		uc.setRemark(remark);
		uc.setFilename1("");
		uc.setFilename2("");
		uc.setFilename3("");
		
		if (file1 != null) {
			file1FileName = number+"_file1."+file1FileName.split("\\.")[1];
		       File savefile = new File(new File(realpath), file1FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file1, savefile);
		           uc.setFilename1(file1FileName);
		     }
		
		if (file2 != null) {
			file2FileName = number+"_file2."+file2FileName.split("\\.")[1];
		       File savefile = new File(new File(realpath), file2FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file2, savefile);
		           uc.setFilename2(file2FileName);
		     }
		if (file3 != null) {
			file3FileName = number+"_file3."+file3FileName.split("\\.")[1];
		       File savefile = new File(new File(realpath), file3FileName);
		       if (!savefile.getParentFile().exists())
		            savefile.getParentFile().mkdirs();
		           FileUtils.copyFile(file3, savefile);
		           uc.setFilename3(file3FileName);
		     }
		
		ucdao.merge(uc);
		trans.commit();
		session.flush();
		session.clear();
		session.close();

		return result;
	}
}
