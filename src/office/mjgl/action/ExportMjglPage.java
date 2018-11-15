package office.mjgl.action;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import office.mjgl.pojo.TMjglPage;
import office.mjgl.pojo.TMjglPageBean;
import office.userinfo.dao.UserInfoDAO;
import office.util.ExportExcel;
import office.util.LeaveUtil;
import office.util.UserUtil;
import office.util.Util;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class ExportMjglPage {
	private static Logger logger = Logger.getLogger(ExportMjglPage.class);
	private String Path;
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception{
		String filePath = "";
		List<TMjglPage> list;
		List<TMjglPageBean> tmblist = new ArrayList<TMjglPageBean>();
		ExportExcel<TMjglPageBean> ex = new ExportExcel<TMjglPageBean>();
		String[] headers = {"姓名","处室","当前权限",
				"当前权限时段","临时权限","临时权限时段","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from TMjglPage as tm";
		hql += " order by tm.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			TMjglPage tm = list.get(i);
			TMjglPageBean tmb = new TMjglPageBean();
			tmb.setName(tm.getName());
		    tmb.setChu(tm.getChu());
		    tmb.setCurrentauth(tm.getCurrentauth());
		    tmb.setCurrenttime(tm.getCurrenttime());
		    tmb.setTempauth(tm.getTempauth());
		    tmb.setTemptime(tm.getTemptime());
		    tmb.setRemark(tm.getRemark());
			tmblist.add(tmb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"MJGL"+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "MJGL"+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("门禁权限表",headers, tmblist, out);
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
