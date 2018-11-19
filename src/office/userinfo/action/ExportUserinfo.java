package office.userinfo.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import office.userinfo.pojo.UserInfo;
import office.userinfo.pojo.UserInfoBean;
import office.userinfo.dao.UserInfoDAO;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UassUtil;
import office.util.UserUtil;
import office.util.Util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExportUserinfo {

	private String Path;

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}
	
	public String execute() throws Exception{
		String filePath = "";
		UserInfoDAO uidao = new UserInfoDAO();
		UassUtil uu = new UassUtil();
		List<UserInfo> list;
		List<UserInfoBean> uiblist = new ArrayList<UserInfoBean>();
		ExportExcel<UserInfoBean> ex = new ExportExcel<UserInfoBean>();
		String[] headers = {"姓名","员工编号","密码","职位（position）",
				"权限","身份证号","工作时间","来行时间","来中心时间","工作年限",
				"护照号","港澳通行证号","台湾通行证号","890状态","891状态","890权限","891权限"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from UserInfo as ui";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			
			UserInfo ui = list.get(i);
			UserInfoBean uib = new UserInfoBean();
			uib.setNewnumber(ui.getNewnumber());
			uib.setUsername(ui.getUsername());
			uib.setPassword(ui.getPassword());
			uib.setPosition(ui.getPosition());
			uib.setAuthority(ui.getAuthority());
			uib.setIdentity(ui.getIdentity());
			uib.setWorkdate(ui.getWorkdate());
			uib.setCcbdate(ui.getCcbdate());
			uib.setZxdate(ui.getZxdate());
			uib.setWorkyears(String.valueOf(ui.getWorkyears()));
			uib.setPassport(ui.getPassport());
			uib.setHkpassport(ui.getHkpassport());
			uib.setTwpassport(ui.getTwpassport());
			uib.setStatus890(String.valueOf(ui.getStatus890()));
			uib.setStatus891(String.valueOf(ui.getStatus891()));
			uib.setRole890(uu.codeToStringDetail(ui.getRole890(),"890"));
			uib.setRole891(uu.codeToStringDetail(ui.getRole891(),"891"));
			uiblist.add(uib);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"userinfo.xls";
				Path = "userinfo.xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, uiblist, out);
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
