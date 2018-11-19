package office.pb.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import office.jbsp.pojo.JbspPage;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.bean.ScpbTableBean;
import office.pb.dao.PbMxDAO;
import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.ScpbTableDAO;
import office.pb.dao.ScpbTableHzDAO;
import office.pb.dao.ScpbTeamDAO;
import office.pb.dao.TPbPeopleDAO;
import office.pb.pojo.PbMx;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.ScpbTable;
import office.pb.pojo.ScpbTableHz;
import office.pb.pojo.ScpbTeam;
import office.pb.pojo.TPbPeople;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.pb2.pojo.XxsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.LeaveUtil;
import office.util.PbUtil;
import office.util.Util;
import office.wcgg.pojo.WcggPage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 计算排班明细
 * @author htzx
 *
 */
public class ProcessPbMx {

	/**
	 * 生产sc
	 * 员工响应yg
	 */
	private String type;
	private String message;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		message = "完毕";
		String YearandMonth = "";
		String result = "success";
		ScpbPlanDAO spdao = new ScpbPlanDAO();
		ScpbTeamDAO stdao = new ScpbTeamDAO();
		ImportScpb is = new ImportScpb();
		PbMxDAO pmdao = new PbMxDAO();
		ScpbTableHzDAO sthdao = new ScpbTableHzDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		TbsqPageDAO tpdao = new TbsqPageDAO();
		MyCalendarDAO mcdao = new MyCalendarDAO();
		ScpbTableDAO stadao = new ScpbTableDAO();
		TPbPeopleDAO ppdao = new TPbPeopleDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
		try {
			if(type.equals("sc"))
			{
				ScpbTable sta = stadao.findFinal();
				TPbPeople tbpp = ppdao.findFinal();
				if(tbpp!=null)
				{
					YearandMonth = tbpp.getDate().substring(0, 6);
				}
				PbUtil pu = new PbUtil();
				String sql = "";
				String ts = sta.getDwb();//大晚班人员
				String[] tss = ts.split("々");
				List<ScpbTableBean> liststb = pu.scpbTableToBean(sta);
				
				String begindate = sta.getBegindate();
				String enddate = sta.getEnddate();
				String begindatepp = YearandMonth+"01";
				String enddatepp = YearandMonth+"31";
				List<TPbPeople> listpp = ppdao.findByBeginAndEnd(begindatepp, enddatepp);
				int teamnum = sta.getTeamnum();
				int plannum = sta.getPlannum();
				//计算已排班人员明细
					for(int k=0;k<liststb.size();k++)//10
					{
						ScpbTableBean stb = liststb.get(k);
						
						ScpbTeam st = stdao.findAllMaxNumByNo(stb.getTeam());
						ScpbPlan sp = spdao.findAllMaxNumByNo(stb.getPlan());
						ScpbPlan spdwb1 = spdao.findAllByNoAndNum(tss[1], sp.getNum());
						ScpbPlan spdwb2 = spdao.findAllByNoAndNum(tss[3], sp.getNum());
						ScpbPlan spdwb3 = spdao.findAllByNoAndNum(tss[5], sp.getNum());
						List<String> listname = new ArrayList<String>();
						System.out.println("st.member"+st.getMember());
						Collections.addAll(listname, st.getLeader().split("、"));
						Collections.addAll(listname, st.getMember().split("、"));
//						Collections.addAll(listname, st.getMember().split("、"));
//						listname.add(st.getLeader());
						if(sp!=null&&st!=null)
						{
							for(int i=0;i<listname.size();i++)//10
							{
								String name = listname.get(i);
								UserInfo ui = uidao.findByName(name);
								System.out.println("-"+name+"-");
								if(ui!=null)
								{
									String newnumber = ui.getNewnumber();
									List<MyCalendar> listmc = mcdao.findByBeginAndEnd(begindate, enddate, 2);
									for(int j=0;j<listmc.size();j++)//5
									{
										ScpbPlan sptemp = new ScpbPlan();
										MyCalendar mc = listmc.get(j);
										String date = mc.getDate();
										//更新t_scpb_mx_hz
										sql = "delete from t_scpb_table_hz where date='"+date+"' and teamno="+stb.getTeam();
										session.createSQLQuery(sql).executeUpdate();
										ScpbTableHz sth = new ScpbTableHz(date,stb.getTeam(),stb.getPlan());
										sthdao.merge(sth);
										
										TbsqPage tpappli = tpdao.findAllByApplicantNameAndDateAndStatus(ui, date,"4,7");
										TbsqPage tptb = tpdao.findAllByTbNameAndDateAndStatus(ui, date,"4,7");
										sql = "delete from t_pb_mx where name='"+name+"' and date='"+mc.getDate()+"'";
										session.createSQLQuery(sql).executeUpdate();
										//PbMx px = pmdao.findAllByNameAndDate(name, mc.getDate());
										PbMx px = new PbMx();
										px.setName(name);
										px.setDate(mc.getDate());
										px.setMonth(begindate.substring(0,6));
										px.setDate(date);
										px.setWeek(mc.getWeek());
										px.setName(name);
										px.setPosition(ui.getPosition());
										px.setTeamnum(teamnum);
										px.setPlannum(plannum);
										px.setPlantype(1);
										px.setTeam(st.getNo());
										if(tss[0].contains(name))//上大晚班
										{
											sptemp=spdwb1;
										}
										else if(tss[2].contains(name))
										{
											sptemp=spdwb2;
										}
										else if(tss[4].contains(name))
										{
											sptemp=spdwb3;
										}
										else
										{
											sptemp=sp;
										}
										px.setPlan(sptemp.getNo());
										px.setPbqdtime(sptemp.getSbtime());
										px.setPbqttime(sptemp.getXbtime());
										px.setZytime(sptemp.getZytime());
										px.setPxtime(sptemp.getPxtime());
										px.setWb(sptemp.getType());
										sql = "from JbspPage as jp where jp.people like '%"+name+"%' and ((jp.begindate='"+date+"' and jp.halfday in (0,2)) or (jp.begindate<'"+date+"' and jp.enddate>='"+date+"')) and jp.status in (1,2,3,4)";
										List<JbspPage> listjp = session.createQuery(sql).list();
										if(!listjp.isEmpty())
										{
											px.setSw("jb");
										}
										sql = "from JbspPage as jp where jp.people like '%"+name+"%' and ((jp.enddate='"+date+"' and jp.halfday in (0,1)) or (jp.begindate<='"+date+"' and jp.enddate>'"+date+"')) and jp.status in (1,2,3,4)";
										listjp = session.createQuery(sql).list();
										if(!listjp.isEmpty())
										{
											px.setXw("jb");
										}
										sql = "from XxsqPage as xp where xp.people like '%"+name+"%' and ((xp.begindate='"+date+"' and xp.halfday in (0,2)) or (xp.begindate<'"+date+"' and xp.enddate>='"+date+"')) and xp.status in (1,2,3,4)";
										List<XxsqPage> listxp = session.createQuery(sql).list();
										if(!listxp.isEmpty())
										{
											px.setSw("xx"+listxp.get(0).getReason());
										}
										sql = "from XxsqPage as xp where xp.people like '%"+name+"%' and ((xp.enddate='"+date+"' and xp.halfday in (0,1)) or (xp.begindate<='"+date+"' and xp.enddate>'"+date+"')) and xp.status in (1,2,3,4)";
										listxp = session.createQuery(sql).list();
										if(!listxp.isEmpty())
										{
											px.setXw("xx"+listxp.get(0).getReason());
										}
										sql = "from WcggPage as wp where wp.people like '%"+name+"%' and ((wp.begindate='"+date+"' and wp.halfday in (0,2)) or (wp.begindate<'"+date+"' and wp.enddate>='"+date+"')) and wp.status in (1,2,3,4)";
										List<WcggPage> listwp = session.createQuery(sql).list();
										if(!listwp.isEmpty())
										{
											px.setSw("gg");
										}
										sql = "from WcggPage as wp where wp.people like '%"+name+"%' and ((wp.enddate='"+date+"' and wp.halfday in (0,1)) or (wp.begindate<='"+date+"' and wp.enddate>'"+date+"')) and wp.status in (1,2,3,4)";
										listwp = session.createQuery(sql).list();
										if(!listwp.isEmpty())
										{
											px.setXw("gg");
										}
										sql = "from LeavePage as lp where lp.applicant='"+newnumber+"' and ((lp.begindate='"+date+"' and lp.halfday in (0,2)) or (lp.begindate<'"+date+"' and lp.enddate>='"+date+"')) and lp.status in (1,2,7)";
										List<LeavePage> listlp = session.createQuery(sql).list();
										if(!listlp.isEmpty())
										{
											px.setSw("qj"+listlp.get(0).getType());
										}
										sql = "from LeavePage as lp where lp.applicant='"+newnumber+"' and ((lp.enddate='"+date+"' and lp.halfday in (0,1)) or (lp.begindate<='"+date+"' and lp.enddate>'"+date+"')) and lp.status in (1,2,7)";
										listlp = session.createQuery(sql).list();
										if(!listlp.isEmpty())
										{
											px.setXw("qj"+listlp.get(0).getType());
										}
										if(tpappli!=null)//如果有调班存在,作为发起人
										{
											String oldsbtime = tpappli.getPrejihua().split("，")[0].split("：")[1];
											String oldxbtime = tpappli.getPrejihua().split("，")[1].split("：")[1];
											String newsbtime = tpappli.getNowjihua().split("，")[0].split("：")[1];
											String newxbtime = tpappli.getNowjihua().split("，")[1].split("：")[1];
											String newzytime = tpappli.getNowjihua().split("，")[2].split("：")[1];
											if(oldsbtime.equals(sptemp.getSbtime())&&oldxbtime.equals(sptemp.getXbtime()))
											{
												px.setPbqdtime(newsbtime);
												px.setPbqttime(newxbtime);
												px.setZytime(newzytime);
												px.setWb(tpappli.getNowtype());
												px.setTb(tpappli.getTbname());
//												if(newsbtime.compareTo("09:20")>0)
//												{
//													px.setWb(1);
//												}
//												if(newsbtime.compareTo("11:30")>0)
//												{
//													px.setWb(2);
//												}
											}
											else
											{
												message +=ui.getUsername()+"有调班记录，请联系管理员撤销后重新计算排班明细表";
												result = "failed";
											}
											pmdao.merge(px);
										}
										else if(tptb!=null)//如果有调班存在,作为被调班人
										{
											String oldsbtime = tptb.getNowjihua().split("，")[0].split("：")[1];
											String oldxbtime = tptb.getNowjihua().split("，")[1].split("：")[1];
											String newsbtime = tptb.getPrejihua().split("，")[0].split("：")[1];
											String newxbtime = tptb.getPrejihua().split("，")[1].split("：")[1];
											String newzytime = tptb.getPrejihua().split("，")[2].split("：")[1];
											if(oldsbtime.equals(sptemp.getSbtime())&&oldxbtime.equals(sptemp.getXbtime()))
											{
												px.setPbqdtime(newsbtime);
												px.setPbqttime(newxbtime);
												px.setZytime(newzytime);
												px.setWb(tptb.getPretype());
												px.setTb(LeaveUtil.NewNumberToNameNoSession(tptb.getApplicant()));
//												if(newsbtime.compareTo("09:20")>0)
//												{
//													px.setWb(1);
//												}
//												if(newsbtime.compareTo("11:30")>0)
//												{
//													px.setWb(2);
//												}
												
											}
											else
											{
												message +=ui.getUsername()+"有调班记录，请联系管理员撤销后重新计算排班明细表";
												result = "failed";
											}
											pmdao.merge(px);
										}
										else
										{
											pmdao.merge(px);
										}
										
									}
								}
							}
						}
					}
					
					
					
										
					
					//计算未排班人员明细
					List<UserInfo> listui = uidao.findAllByPosition1("sc");
					List<String> listunpb = new ArrayList<String>();
					List<ScpbTeam> listst = stdao.findAllMaxNum();
					List<String> listpb = new ArrayList<String>();
					for(int i=0;i<listui.size();i++)
		    		{
		    			UserInfo ui = listui.get(i);
		    			if(!ui.getPosition().startsWith("2")&&!ui.getPosition().startsWith("1"))
		    				listunpb.add(ui.getUsername());
		    		}
					for(int i=0;i<listst.size();i++)
		    		{
		    			ScpbTeam st = (ScpbTeam) listst.get(i);
		    			Collections.addAll(listpb, st.getLeader().split("、"));
						Collections.addAll(listpb, st.getMember().split("、"));
		    		}
					listunpb.removeAll(listpb);
					for(int i=0;i<listunpb.size();i++)
					{
						String name = listunpb.get(i);
						UserInfo ui = uidao.findByName(name);
						System.out.println("-"+name+"-");
						if(ui!=null)
						{
							String newnumber = ui.getNewnumber();
							List<MyCalendar> listmc = mcdao.findByBeginAndEnd(begindate, enddate, 1);
							for(int j=0;j<listmc.size();j++)//5
							{
								MyCalendar mc = listmc.get(j);
								String date = mc.getDate();
								
								TbsqPage tpappli = tpdao.findAllByApplicantNameAndDateAndStatus(ui, date, "4,7");
								TbsqPage tptb = tpdao.findAllByTbNameAndDateAndStatus(ui, date, "4,7");
								sql = "delete from t_pb_mx where name='"+name+"' and date='"+mc.getDate()+"'";
								session.createSQLQuery(sql).executeUpdate();
								//PbMx px = pmdao.findAllByNameAndDate(name, mc.getDate());
								PbMx px = new PbMx();
								px.setName(name);
								//px.setDate(mc.getDate());
								px.setMonth(begindate.substring(0,6));
								px.setDate(date);
								px.setWeek(mc.getWeek());
								//px.setName(name);
								px.setPosition(ui.getPosition());
								px.setTeamnum(teamnum);
								px.setPlannum(plannum);
								px.setPlantype(1);
								px.setPbqdtime(Util.zcqd.substring(0, 5));
								px.setPbqttime(Util.zcqt.substring(0, 5));
								px.setZytime("");
								px.setPxtime("");
								px.setWb(6);
								
								sql = "from JbspPage as jp where jp.people like '%"+name+"%' and ((jp.begindate='"+date+"' and jp.halfday in (0,2)) or (jp.begindate<'"+date+"' and jp.enddate>='"+date+"')) and jp.status in (1,2,3,4)";
								List<JbspPage> listjp = session.createQuery(sql).list();
								if(!listjp.isEmpty())
								{
									px.setSw("jb");
								}
								sql = "from JbspPage as jp where jp.people like '%"+name+"%' and ((jp.enddate='"+date+"' and jp.halfday in (0,1)) or (jp.begindate<='"+date+"' and jp.enddate>'"+date+"')) and jp.status in (1,2,3,4)";
								listjp = session.createQuery(sql).list();
								if(!listjp.isEmpty())
								{
									px.setXw("jb");
								}
								sql = "from XxsqPage as xp where xp.people like '%"+name+"%' and ((xp.begindate='"+date+"' and xp.halfday in (0,2)) or (xp.begindate<'"+date+"' and xp.enddate>='"+date+"')) and xp.status in (1,2,3,4)";
								List<XxsqPage> listxp = session.createQuery(sql).list();
								if(!listxp.isEmpty())
								{
									px.setSw("xx"+listxp.get(0).getReason());
								}
								sql = "from XxsqPage as xp where xp.people like '%"+name+"%' and ((xp.enddate='"+date+"' and xp.halfday in (0,1)) or (xp.begindate<='"+date+"' and xp.enddate>'"+date+"')) and xp.status in (1,2,3,4)";
								listxp = session.createQuery(sql).list();
								if(!listxp.isEmpty())
								{
									px.setXw("xx"+listxp.get(0).getReason());
								}
								sql = "from WcggPage as wp where wp.people like '%"+name+"%' and ((wp.begindate='"+date+"' and wp.halfday in (0,2)) or (wp.begindate<'"+date+"' and wp.enddate>='"+date+"')) and wp.status in (1,2,3,4)";
								List<WcggPage> listwp = session.createQuery(sql).list();
								if(!listwp.isEmpty())
								{
									px.setSw("gg");
								}
								sql = "from WcggPage as wp where wp.people like '%"+name+"%' and ((wp.enddate='"+date+"' and wp.halfday in (0,1)) or (wp.begindate<='"+date+"' and wp.enddate>'"+date+"')) and wp.status in (1,2,3,4)";
								listwp = session.createQuery(sql).list();
								if(!listwp.isEmpty())
								{
									px.setXw("gg");
								}
								sql = "from LeavePage as lp where lp.applicant='"+newnumber+"' and ((lp.begindate='"+date+"' and lp.halfday in (0,2)) or (lp.begindate<'"+date+"' and lp.enddate>='"+date+"')) and lp.status in (1,2,7)";
								List<LeavePage> listlp = session.createQuery(sql).list();
								if(!listlp.isEmpty())
								{
									px.setSw("qj"+listlp.get(0).getType());
								}
								sql = "from LeavePage as lp where lp.applicant='"+newnumber+"' and ((lp.enddate='"+date+"' and lp.halfday in (0,1)) or (lp.begindate<='"+date+"' and lp.enddate>'"+date+"')) and lp.status in (1,2,7)";
								listlp = session.createQuery(sql).list();
								if(!listlp.isEmpty())
								{
									px.setXw("qj"+listlp.get(0).getType());
								}
								if(tpappli!=null)//如果有调班存在,作为发起人
								{
									String oldsbtime = tpappli.getPrejihua().split("，")[0].split("：")[1];
									String oldxbtime = tpappli.getPrejihua().split("，")[1].split("：")[1];
									String newsbtime = tpappli.getNowjihua().split("，")[0].split("：")[1];
									String newxbtime = tpappli.getNowjihua().split("，")[1].split("：")[1];
									String newzytime = tpappli.getNowjihua().split("，")[2].split("：")[1];
									if(oldsbtime.equals(Util.zcqd.substring(0, 5))&&oldxbtime.equals(Util.zcqt.substring(0, 5)))
									{
										px.setPbqdtime(newsbtime);
										px.setPbqttime(newxbtime);
										px.setZytime(newzytime);
										px.setWb(6);
//										if(newsbtime.compareTo("09:20")>0)
//										{
//											px.setWb(1);
//										}
//										if(newsbtime.compareTo("11:30")>0)
//										{
//											px.setWb(2);
//										}
										pmdao.merge(px);
									}
									else
									{
										message +=ui.getUsername()+"有调班记录，请联系管理员撤销后重新计算排班明细表";
										result = "failed";
									}
								}
								else if(tptb!=null)//如果有调班存在,作为被调班人
								{
									String oldsbtime = tptb.getNowjihua().split("，")[0].split("：")[1];
									String oldxbtime = tptb.getNowjihua().split("，")[1].split("：")[1];
									String newsbtime = tptb.getPrejihua().split("，")[0].split("：")[1];
									String newxbtime = tptb.getPrejihua().split("，")[1].split("：")[1];
									String newzytime = tptb.getPrejihua().split("，")[2].split("：")[1];
									if(oldsbtime.equals(Util.zcqd.substring(0, 5))&&oldxbtime.equals(Util.zcqt.substring(0, 5)))
									{
										px.setPbqdtime(newsbtime);
										px.setPbqttime(newxbtime);
										px.setZytime(newzytime);
										px.setWb(6);
//										if(newsbtime.compareTo("09:20")>0)
//										{
//											px.setWb(1);
//										}
//										if(newsbtime.compareTo("11:30")>0)
//										{
//											px.setWb(2);
//										}
										pmdao.merge(px);
									}
									else
									{
										message +=ui.getUsername()+"有调班记录，请联系管理员撤销后重新计算排班明细表";
										result = "failed";
									}
								}
								else
								{
									pmdao.merge(px);
								}
							}
						}
					}
					
					
					//计算单独排班人员明细
					if(listpp!=null)
					{
						for(int k=0;k<listpp.size();k++)//10
						{
							TPbPeople pp = listpp.get(k);
							//ScpbPlan sp = new ScpbPlan();
							ScpbPlan sp = spdao.findAllMaxNumByNo(pp.getPlan());
							/*if(pp.getPlan()!=0)
							{	
							   sp = spdao.findAllMaxNumByNo(pp.getPlan());
							}*/
							if(sp!=null)
							{
								UserInfo ui = uidao.findByName(pp.getName());
							    TbsqPage tpappli = tpdao.findAllByApplicantNameAndDateAndStatus(ui, pp.getDate(),"4,7");
							    TbsqPage tptb = tpdao.findAllByTbNameAndDateAndStatus(ui,pp.getDate(),"4,7");
								sql = "delete from t_pb_mx where name='"+pp.getName()+"' and date='"+pp.getDate()+"'";
								session.createSQLQuery(sql).executeUpdate();
											//PbMx px = pmdao.findAllByNameAndDate(name, mc.getDate());
								PbMx px = new PbMx();
								px.setName(pp.getName());
								px.setDate(pp.getDate());
								px.setMonth(pp.getDate().substring(0,6));
								px.setWeek(pp.getWeek());
								px.setPosition(ui.getPosition());
								px.setTeamnum(0);
								px.setPlannum(plannum);
								px.setPlantype(1);
								//px.setTeam(0);
								px.setPlan(sp.getNo());
								px.setPbqdtime(sp.getSbtime());
								px.setPbqttime(sp.getXbtime());
								px.setZytime(sp.getZytime());
							    px.setPxtime(sp.getPxtime());
							    px.setWb(sp.getType());
								sql = "from JbspPage as jp where jp.people like '%"+pp.getName()+"%' and ((jp.begindate='"+pp.getDate()+"' and jp.halfday in (0,2)) or (jp.begindate<'"+pp.getDate()+"' and jp.enddate>='"+pp.getDate()+"')) and jp.status in (1,2,3,4)";
								List<JbspPage> listjp = session.createQuery(sql).list();
											if(!listjp.isEmpty())
											{
												px.setSw("jb");
											}
											sql = "from JbspPage as jp where jp.people like '%"+pp.getName()+"%' and ((jp.enddate='"+pp.getDate()+"' and jp.halfday in (0,1)) or (jp.begindate<='"+pp.getDate()+"' and jp.enddate>'"+pp.getDate()+"')) and jp.status in (1,2,3,4)";
											listjp = session.createQuery(sql).list();
											if(!listjp.isEmpty())
											{
												px.setXw("jb");
											}
											sql = "from XxsqPage as xp where xp.people like '%"+pp.getName()+"%' and ((xp.begindate='"+pp.getDate()+"' and xp.halfday in (0,2)) or (xp.begindate<'"+pp.getDate()+"' and xp.enddate>='"+pp.getDate()+"')) and xp.status in (1,2,3,4)";
											List<XxsqPage> listxp = session.createQuery(sql).list();
											if(!listxp.isEmpty())
											{
												px.setSw("xx"+listxp.get(0).getReason());
											}
											sql = "from XxsqPage as xp where xp.people like '%"+pp.getName()+"%' and ((xp.enddate='"+pp.getDate()+"' and xp.halfday in (0,1)) or (xp.begindate<='"+pp.getDate()+"' and xp.enddate>'"+pp.getDate()+"')) and xp.status in (1,2,3,4)";
											listxp = session.createQuery(sql).list();
											if(!listxp.isEmpty())
											{
												px.setXw("xx"+listxp.get(0).getReason());
											}
											sql = "from WcggPage as wp where wp.people like '%"+pp.getName()+"%' and ((wp.begindate='"+pp.getDate()+"' and wp.halfday in (0,2)) or (wp.begindate<'"+pp.getDate()+"' and wp.enddate>='"+pp.getDate()+"')) and wp.status in (1,2,3,4)";
											List<WcggPage> listwp = session.createQuery(sql).list();
											if(!listwp.isEmpty())
											{
												px.setSw("gg");
											}
											sql = "from WcggPage as wp where wp.people like '%"+pp.getName()+"%' and ((wp.enddate='"+pp.getDate()+"' and wp.halfday in (0,1)) or (wp.begindate<='"+pp.getDate()+"' and wp.enddate>'"+pp.getDate()+"')) and wp.status in (1,2,3,4)";
											listwp = session.createQuery(sql).list();
											if(!listwp.isEmpty())
											{
												px.setXw("gg");
											}
											sql = "from LeavePage as lp where lp.applicant='"+ui.getNewnumber()+"' and ((lp.begindate='"+pp.getDate()+"' and lp.halfday in (0,2)) or (lp.begindate<'"+pp.getDate()+"' and lp.enddate>='"+pp.getDate()+"')) and lp.status in (1,2,7)";
											List<LeavePage> listlp = session.createQuery(sql).list();
											if(!listlp.isEmpty())
											{
												px.setSw("qj"+listlp.get(0).getType());
											}
											sql = "from LeavePage as lp where lp.applicant='"+ui.getNewnumber()+"' and ((lp.enddate='"+pp.getDate()+"' and lp.halfday in (0,1)) or (lp.begindate<='"+pp.getDate()+"' and lp.enddate>'"+pp.getDate()+"')) and lp.status in (1,2,7)";
											listlp = session.createQuery(sql).list();
											if(!listlp.isEmpty())
											{
												px.setXw("qj"+listlp.get(0).getType());
											}
											if(tpappli!=null)//如果有调班存在,作为发起人
											{
												String oldsbtime = tpappli.getPrejihua().split("，")[0].split("：")[1];
												String oldxbtime = tpappli.getPrejihua().split("，")[1].split("：")[1];
												String newsbtime = tpappli.getNowjihua().split("，")[0].split("：")[1];
												String newxbtime = tpappli.getNowjihua().split("，")[1].split("：")[1];
												String newzytime = tpappli.getNowjihua().split("，")[2].split("：")[1];
												if(oldsbtime.equals(sp.getSbtime())&&oldxbtime.equals(sp.getXbtime()))
												{
													px.setPbqdtime(newsbtime);
													px.setPbqttime(newxbtime);
													px.setZytime(newzytime);
													px.setWb(tpappli.getNowtype());
													px.setTb(tpappli.getTbname());
//													if(newsbtime.compareTo("09:20")>0)
//													{
//														px.setWb(1);
//													}
//													if(newsbtime.compareTo("11:30")>0)
//													{
//														px.setWb(2);
//													}
												}
												else
												{
													message +=ui.getUsername()+"有调班记录，请联系管理员撤销后重新计算排班明细表";
													result = "failed";
												}
												pmdao.merge(px);
											}
											else if(tptb!=null)//如果有调班存在,作为被调班人
											{
												String oldsbtime = tptb.getNowjihua().split("，")[0].split("：")[1];
												String oldxbtime = tptb.getNowjihua().split("，")[1].split("：")[1];
												String newsbtime = tptb.getPrejihua().split("，")[0].split("：")[1];
												String newxbtime = tptb.getPrejihua().split("，")[1].split("：")[1];
												String newzytime = tptb.getPrejihua().split("，")[2].split("：")[1];
												if(oldsbtime.equals(sp.getSbtime())&&oldxbtime.equals(sp.getXbtime()))
												{
													px.setPbqdtime(newsbtime);
													px.setPbqttime(newxbtime);
													px.setZytime(newzytime);
													px.setWb(tptb.getPretype());
													px.setTb(LeaveUtil.NewNumberToNameNoSession(tptb.getApplicant()));
//													if(newsbtime.compareTo("09:20")>0)
//													{
//														px.setWb(1);
//													}
//													if(newsbtime.compareTo("11:30")>0)
//													{
//														px.setWb(2);
//													}
													
												}
												else
												{
													message +=ui.getUsername()+"有调班记录，请联系管理员撤销后重新计算排班明细表";
													result = "failed";
												}
												pmdao.merge(px);
											}
											else
											{
												pmdao.merge(px);
											}
											
										}
							
							
							else
							{
								UserInfo ui = uidao.findByName(pp.getName());
							
								sql = "delete from t_pb_mx where name='"+pp.getName()+"' and date='"+pp.getDate()+"'";
								session.createSQLQuery(sql).executeUpdate();
											//PbMx px = pmdao.findAllByNameAndDate(name, mc.getDate());
								PbMx px = new PbMx();
								px.setName(pp.getName());
								px.setDate(pp.getDate());
								px.setMonth(pp.getDate().substring(0,6));
								px.setWeek(pp.getWeek());
								px.setPosition(ui.getPosition());
								px.setTeamnum(0);
								px.setPlannum(0);
								px.setPlantype(0);
								//px.setTeam(0);
								px.setPlan(0);
								px.setPbqdtime("");
								px.setPbqttime("");
								px.setZytime("");
							    px.setPxtime("");
							    px.setWb(0);
							    px.setSw("wu");
								px.setXw("wu");
							    pmdao.merge(px);
						    }
						}
					}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return result;
	}
}
