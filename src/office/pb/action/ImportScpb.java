package office.pb.action;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.bean.ScpbTableBean;
import office.pb.dao.PbMxDAO;
import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.ScpbTableDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.pojo.PbMx;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.ScpbTable;
import office.pb.pojo.ScpbTeam;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.PbUtil;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggPage;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportScpb {

	private static Logger logger = Logger.getLogger(ImportScpb.class);
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
		
		ScpbTableDAO stdao = new ScpbTableDAO();
		String realpath = "D:/import/office/";
		int nn=0;
		int mm=0;
		int num = 0;
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
			mm = sheet.getColumns();
			String begindate = sheet.getCell(0, 1).getContents().trim();
			String enddate = sheet.getCell(1, 1).getContents().trim();
			String tsname1 = sheet.getCell(0, 2).getContents().trim();//特殊人员姓名
			String tsbc1 = sheet.getCell(1, 2).getContents().trim();//特殊人员班次
			String tsname2 = sheet.getCell(0, 3).getContents().trim();//特殊人员姓名
			String tsbc2 = sheet.getCell(1, 3).getContents().trim();//特殊人员班次
			String tsname3 = sheet.getCell(0, 4).getContents().trim();//特殊人员姓名
			String tsbc3 = sheet.getCell(1, 4).getContents().trim();//特殊人员班次
			//String month = begindate.substring(0, 6);
			String sql = "delete from t_scpb_table where begindate='"+begindate+"' and enddate='"+enddate+"'";
			session.createSQLQuery(sql).executeUpdate();
			ScpbTable st = stdao.findAllByBeginEnd(begindate, enddate);
			sql = "select max(num) from t_scpb_plan";
			int plannum = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
			st.setPlannum(plannum);
			sql = "select max(num) from t_scpb_team";
			int teamnum = Integer.parseInt(session.createSQLQuery(sql).uniqueResult().toString());
			st.setTeamnum(teamnum);
			st.setMonth(begindate.substring(0, 6));
			st.setBegindate(begindate);
			st.setEnddate(enddate);
			st.setDwb(tsname1+"々"+tsbc1+"々"+tsname2+"々"+tsbc2+"々"+tsname3+"々"+tsbc3);
			if(mm>2)
			{
				String title = sheet.getCell(2, 0).getContents().trim();
				int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
				if(title.startsWith("排班"))
				{
					int plan = Integer.parseInt(sheet.getCell(2, 1).getContents().trim());
					st=setPlan(st,team,plan);
				}
			}
			if(mm>3)
			{
				String title = sheet.getCell(3, 0).getContents().trim();
				int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
				if(title.startsWith("排班"))
				{
					int plan = Integer.parseInt(sheet.getCell(3, 1).getContents().trim());
					st=setPlan(st,team,plan);
				}
			}
			if(mm>4)
			{
				String title = sheet.getCell(4, 0).getContents().trim();
				int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
				if(title.startsWith("排班"))
				{
					int plan = Integer.parseInt(sheet.getCell(4, 1).getContents().trim());
					st=setPlan(st,team,plan);
				}
			}
			if(mm>5)
			{
				String title = sheet.getCell(5, 0).getContents().trim();
				int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
				if(title.startsWith("排班"))
				{
					int plan = Integer.parseInt(sheet.getCell(5, 1).getContents().trim());
					st=setPlan(st,team,plan);
				}
			}
			if(mm>6)
			{
				String title = sheet.getCell(6, 0).getContents().trim();
				int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
				if(title.startsWith("排班"))
				{
					int plan = Integer.parseInt(sheet.getCell(6, 1).getContents().trim());
					st=setPlan(st,team,plan);
				}
			}
			if(mm>7)
			{
				String title = sheet.getCell(7, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(7, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>8)
			{
				String title = sheet.getCell(8, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(8, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>9)
			{
				String title = sheet.getCell(9, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(9, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>10)
			{
				String title = sheet.getCell(10, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(10, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>11)
			{
				String title = sheet.getCell(11, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(11, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>12)
			{
				
				String title = sheet.getCell(12, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(12, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>13)
			{
				String title = sheet.getCell(13, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(13, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>14)
			{
				String title = sheet.getCell(14, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(14, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>15)
			{
				String title = sheet.getCell(15, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(15, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>16)
			{
				String title = sheet.getCell(16, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(16, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>17)
			{
				String title = sheet.getCell(17, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(17, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>18)
			{
				String title = sheet.getCell(18, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(18, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>19)
			{
				String title = sheet.getCell(19, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(19, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			if(mm>20)
			{
				String title = sheet.getCell(20, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(20, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
				
			}
			if(mm>21)
			{
				String title = sheet.getCell(21, 0).getContents().trim();
				if(title.startsWith("排班"))
				{
					int team = Integer.parseInt(title.replace("排班", "").replace("组",""));
					if(title.startsWith("排班"))
					{
						int plan = Integer.parseInt(sheet.getCell(21, 1).getContents().trim());
						st=setPlan(st,team,plan);
					}
				}
			}
			stdao.merge(st);
//			for (int i = 2; i < mm; i++) {
//				Class tCls = st.getClass();
//				Method getMethod = tCls.getMethod(getMethodName,
//                        new Class[] {});
//                Object value = getMethod.invoke(t, new Object[] {});
//				if(stdao.findAllIfContain(begindate, enddate, team))
//				{
//					message += "失败"+begindate+"-"+enddate+"排班【"+team+"】组与已有的排班计划时间重复!，请删除重复排班计划，再导入新排班计划！";
//				}
//				else
//				{
//					stdao.merge(st);
//				}
//			}
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
	
	
	public ScpbTable setPlan(ScpbTable st,int team,int plan)
	{
		if(team==1)
		{
			st.setTeam1(plan);
		}
		if(team==2)
		{
			st.setTeam2(plan);
		}
		if(team==3)
		{
			st.setTeam3(plan);
		}
		if(team==4)
		{
			st.setTeam4(plan);
		}
		if(team==5)
		{
			st.setTeam5(plan);
		}
		if(team==6)
		{
			st.setTeam6(plan);
		}
		if(team==7)
		{
			st.setTeam7(plan);
		}
		if(team==8)
		{
			st.setTeam8(plan);
		}
		if(team==9)
		{
			st.setTeam9(plan);
		}
		if(team==10)
		{
			st.setTeam10(plan);
		}
		if(team==11)
		{
			st.setTeam11(plan);
		}
		if(team==12)
		{
			st.setTeam12(plan);
		}
		if(team==13)
		{
			st.setTeam13(plan);
		}
		if(team==14)
		{
			st.setTeam14(plan);
		}
		if(team==15)
		{
			st.setTeam15(plan);
		}
		if(team==16)
		{
			st.setTeam16(plan);
		}
		if(team==17)
		{
			st.setTeam17(plan);
		}
		if(team==18)
		{
			st.setTeam18(plan);
		}
		if(team==19)
		{
			st.setTeam19(plan);
		}
		if(team==20)
		{
			st.setTeam20(plan);
		}
		if(team==21)
		{
			st.setTeam21(plan);
		}
		if(team==22)
		{
			st.setTeam22(plan);
		}
		if(team==23)
		{
			st.setTeam23(plan);
		}
		if(team==24)
		{
			st.setTeam24(plan);
		}
		if(team==25)
		{
			st.setTeam25(plan);
		}
		if(team==26)
		{
			st.setTeam26(plan);
		}
		if(team==27)
		{
			st.setTeam27(plan);
		}
		if(team==28)
		{
			st.setTeam28(plan);
		}
		if(team==29)
		{
			st.setTeam29(plan);
		}
		if(team==30)
		{
			st.setTeam30(plan);
		}
		return st;
	}
	/**
	 * 生成排班明细表
	 * @param begindate
	 * @param enddate
	 * @param team
	 * @param plan
	 * @return
	 */
//	public String processPbMx(ScpbTable sta,int plantype,Session session) throws Exception
//	{
//		PbMxDAO pmdao = new PbMxDAO();
//		PbUtil pu = new PbUtil();
//		UserInfoDAO uidao = new UserInfoDAO();
//		ScpbTeamDAO stdao = new ScpbTeamDAO();
//		ScpbPlanDAO spdao = new ScpbPlanDAO();
//		TbsqPageDAO tpdao = new TbsqPageDAO();
//		MyCalendarDAO mcdao = new MyCalendarDAO();
//		String sql = "";
//		
//		List<ScpbTableBean> liststb = pu.scpbTableToBean(sta);
//		
//		String begindate = sta.getBegindate();
//		String enddate = sta.getEnddate();
//		int teamnum = sta.getTeamnum();
//		int plannum = sta.getPlannum();
//		try {
//			for(int k=0;k<liststb.size();k++)//10
//			{
//				ScpbTableBean stb = liststb.get(k);
//				ScpbTeam st = stdao.findAllMaxNumByNo(stb.getTeam());
//				ScpbPlan sp = spdao.findAllMaxNumByNo(stb.getPlan());
//				List<String> listname = new ArrayList<String>();
//				System.out.println("st.member"+st.getMember());
//				Collections.addAll(listname, st.getLeader().split("、"));
//				Collections.addAll(listname, st.getMember().split("、"));
//				//for()
//				//listname.add(st.getLeader());
//				if(sp!=null&&st!=null)
//				{
//					for(int i=0;i<listname.size();i++)//10
//					{
//						String name = listname.get(i);
//						UserInfo ui = uidao.findByName(name);
//						System.out.println("-"+name+"-");
//						if(ui!=null)
//						{
//							String newnumber = ui.getNewnumber();
//							List<MyCalendar> listmc = mcdao.findByBeginAndEnd(begindate, enddate, 2);
//							for(int j=0;j<listmc.size();j++)//5
//							{
//								MyCalendar mc = listmc.get(j);
//								String date = mc.getDate();
//								TbsqPage tpappli = tpdao.findAllByApplicantNameAndDateAndStatus(ui, date, 4);
//								TbsqPage tptb = tpdao.findAllByTbNameAndDateAndStatus(ui, date, 4);
//								PbMx px = pmdao.findAllByNameAndDate(name, mc.getDate());
//								px.setMonth(begindate.substring(0,6));
//								px.setDate(date);
//								px.setWeek(mc.getWeek());
//								px.setName(name);
//								px.setPosition(ui.getPosition());
//								px.setPlan(sp.getNo());
//								px.setTeam(st.getNo());
//								px.setTeamnum(teamnum);
//								px.setPlannum(plannum);
//								px.setPlantype(plantype);
//								px.setPbqdtime(sp.getSbtime());
//								px.setPbqttime(sp.getXbtime());
//								px.setZytime(sp.getZytime());
//								px.setPxtime(sp.getPxtime());
//								px.setWb(sp.getType());
//								
//								sql = "from JbspPage as jp where jp.people like '%"+name+"%' and ((jp.begindate='"+date+"' and jp.halfday in (0,2)) or (jp.begindate<'"+date+"' and jp.enddate>='"+date+"')) and jp.status in (1,2,3,4)";
//								List<JbspPage> listjp = session.createQuery(sql).list();
//								if(!listjp.isEmpty())
//								{
//									px.setSw("jb");
//								}
//								sql = "from JbspPage as jp where jp.people like '%"+name+"%' and ((jp.enddate='"+date+"' and jp.halfday in (0,1)) or (jp.begindate<='"+date+"' and jp.enddate>'"+date+"')) and jp.status in (1,2,3,4)";
//								listjp = session.createQuery(sql).list();
//								if(!listjp.isEmpty())
//								{
//									px.setXw("jb");
//								}
//								sql = "from XxsqPage as xp where xp.people like '%"+name+"%' and ((xp.begindate='"+date+"' and xp.halfday in (0,2)) or (xp.begindate<'"+date+"' and xp.enddate>='"+date+"')) and xp.status in (1,2,3,4)";
//								List<XxsqPage> listxp = session.createQuery(sql).list();
//								if(!listxp.isEmpty())
//								{
//									px.setSw("xx"+listxp.get(0).getReason());
//								}
//								sql = "from XxsqPage as xp where xp.people like '%"+name+"%' and ((xp.enddate='"+date+"' and xp.halfday in (0,1)) or (xp.begindate<='"+date+"' and xp.enddate>'"+date+"')) and xp.status in (1,2,3,4)";
//								listxp = session.createQuery(sql).list();
//								if(!listxp.isEmpty())
//								{
//									px.setXw("xx"+listxp.get(0).getReason());
//								}
//								sql = "from WcggPage as wp where wp.people like '%"+name+"%' and ((wp.begindate='"+date+"' and wp.halfday in (0,2)) or (wp.begindate<'"+date+"' and wp.enddate>='"+date+"')) and wp.status in (1,2,3,4)";
//								List<WcggPage> listwp = session.createQuery(sql).list();
//								if(!listwp.isEmpty())
//								{
//									px.setSw("gg");
//								}
//								sql = "from WcggPage as wp where wp.people like '%"+name+"%' and ((wp.enddate='"+date+"' and wp.halfday in (0,1)) or (wp.begindate<='"+date+"' and wp.enddate>'"+date+"')) and wp.status in (1,2,3,4)";
//								listwp = session.createQuery(sql).list();
//								if(!listwp.isEmpty())
//								{
//									px.setXw("gg");
//								}
//								sql = "from LeavePage as lp where lp.applicant='"+newnumber+"' and ((lp.begindate='"+date+"' and lp.halfday in (0,2)) or (lp.begindate<'"+date+"' and lp.enddate>='"+date+"')) and lp.status in (1,2,7)";
//								List<LeavePage> listlp = session.createQuery(sql).list();
//								if(!listlp.isEmpty())
//								{
//									px.setSw("qj"+listlp.get(0).getType());
//								}
//								sql = "from LeavePage as lp where lp.applicant='"+newnumber+"' and ((lp.enddate='"+date+"' and lp.halfday in (0,1)) or (lp.begindate<='"+date+"' and lp.enddate>'"+date+"')) and lp.status in (1,2,7)";
//								listlp = session.createQuery(sql).list();
//								if(!listlp.isEmpty())
//								{
//									px.setXw("qj"+listlp.get(0).getType());
//								}
//								if(tpappli!=null)//如果有调班存在,作为发起人
//								{
//									String oldsbtime = tpappli.getPrejihua().split("，")[0].split("：")[1];
//									String oldxbtime = tpappli.getPrejihua().split("，")[1].split("：")[1];
//									String newsbtime = tpappli.getNowjihua().split("，")[0].split("：")[1];
//									String newxbtime = tpappli.getNowjihua().split("，")[1].split("：")[1];
//									String newzytime = tpappli.getNowjihua().split("，")[2].split("：")[1];
//									if(oldsbtime.equals(sp.getSbtime())&&oldxbtime.equals(sp.getXbtime()))
//									{
//										px.setPbqdtime(newsbtime);
//										px.setPbqttime(newxbtime);
//										px.setZytime(newzytime);
//										pmdao.merge(px);
//									}
//									else
//									{
//										message +=ui.getUsername()+"有调班记录，请联系管理员撤销后重新计算排班明细表";
//									}
//								}
//								else if(tptb!=null)//如果有调班存在,作为被调班人
//								{
//									String oldsbtime = tpappli.getNowjihua().split("，")[0].split("：")[1];
//									String oldxbtime = tpappli.getNowjihua().split("，")[1].split("：")[1];
//									String newsbtime = tpappli.getPrejihua().split("，")[0].split("：")[1];
//									String newxbtime = tpappli.getPrejihua().split("，")[1].split("：")[1];
//									String newzytime = tpappli.getPrejihua().split("，")[2].split("：")[1];
//									if(oldsbtime.equals(sp.getSbtime())&&oldxbtime.equals(sp.getXbtime()))
//									{
//										px.setPbqdtime(newsbtime);
//										px.setPbqttime(newxbtime);
//										px.setZytime(newzytime);
//										pmdao.merge(px);
//									}
//									else
//									{
//										message +=ui.getUsername()+"有调班记录，请联系管理员撤销后重新计算排班明细表";
//									}
//								}
//								else
//								{
//									pmdao.merge(px);
//								}
//								
//							}
//						}
//					}
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		return "success";
//	}
}
