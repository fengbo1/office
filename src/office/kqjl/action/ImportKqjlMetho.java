package office.kqjl.action;

import java.util.List;

import office.config.dao.ConfigDAO;
import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.KqjlImportDAO;
import office.kqjl.dao.ScpbUploadDAO;
import office.kqjl.dao.YgpbUploadDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlImport;
import office.kqjl.pojo.ScpbUpload;
import office.kqjl.pojo.YgpbUpload;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.dao.PbMxDAO;
import office.pb.pojo.PbMx;
import office.pb2.dao.TbsqPageDAO;
import office.pb2.pojo.TbsqPage;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.Util;
import office.wcgg.dao.WcggBaodaoDAO;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggBaodao;
import office.wcgg.pojo.WcggPage;

public class ImportKqjlMetho {

	/**
	 * 工作日的计算方法
	 * @param mc
	 * @param ui
	 * @return
	 */
	public KqjlDaily methoForGZR(MyCalendar mc,UserInfo ui,String buru)
	{
		KqjlImportDAO kidao = new KqjlImportDAO();
		WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		WcggPageDAO wpdao = new WcggPageDAO();
		JbspPageDAO jpdao = new JbspPageDAO();
		KqqsPageDAO kpdao = new KqqsPageDAO();
		
		
		KqjlDaily kd = kddao.findByDateAndName(mc.getDate(), ui.getUsername());
		KqjlImport ki = kidao.findAllByDateAndName(mc.getDate(),ui.getUsername());
		List<LeavePage> listlp = lpdao.findByNewNumberAndDate(ui.getNewnumber(),mc.getDate(),"2,7,8");
		List<WcggPage> listwp = wpdao.findAllByNameAndDate(ui.getUsername(), mc.getDate());
		//WcggBaodao wb = wbdao.findAllByNewnumberAndDate(ui.getNewnumber(), mc.getDate());
		List<WcggBaodao> listwb = wbdao.findAllByNewnumberAndDate(ui.getNewnumber(), mc.getDate());
		//List<KqqsPage> listkp = kpdao.findAllByNameAndDate(ui.getNewnumber(),mc.getDate());
		List<JbspPage> listjp = jpdao.findAllByNameAndDate(ui.getUsername(), mc.getDate());
		List<KqqsPage> listkpqd = kpdao.findAllByNameAndDateQD(ui.getNewnumber(),mc.getDate());
		List<KqqsPage> listkpqt = kpdao.findAllByNameAndDateQT(ui.getNewnumber(),mc.getDate());
		kd.setPosition(ui.getPosition());
		kd.setNewnumber(ui.getNewnumber());
		kd.setWeek(mc.getWeek());
		kd.setQdtime(ki.getQdtime());
		kd.setQttime(ki.getQttime());
		String kqqdtime = Util.plusFiveMinutes(kd.getPbqdtime());//加5分钟
		
		//保存考勤情况
		if(ki.getQdtime()==null||ki.getQdtime().length()<2)
		{
			//保存补考勤信息
			if(mc.getRemark().equals("1")||mc.getRemark().equals("3"))
			{
				kd.setQdqs(0);//考勤忽略
			}
			else if(!listkpqd.isEmpty())
			{
				KqqsPage kp = listkpqd.get(0);
				if(kp.getQdqt()==1||kp.getQdqt()==3)
				{
					kd.setQdtime(kp.getQstime()+":00");
					kd.setQdqs(3);//补考勤
				}
				else
				{
					kd.setQdqs(1);//考勤缺失
				}
			}
			else
			{
				kd.setQdqs(1);//考勤缺失
			}
		}
		else
		{
			if(ki.getQdtime().substring(0, 5).compareTo(kqqdtime.substring(0, 5))>0)
			{
				if(buru.contains(ui.getUsername())||mc.getRemark().equals("1")||mc.getRemark().equals("3"))
				{
					kd.setQdqs(0);
				}
				else
				{
					kd.setQdqs(2);//迟到
				}
			}
			else
			{
				kd.setQdqs(0);//正常
			}
		}
		//保存补考勤信息
		if(ki.getQttime()==null||ki.getQttime().length()<2)
		{
			
			if(mc.getRemark().equals("2")||mc.getRemark().equals("3"))
			{
				kd.setQtqs(0);//考勤忽略
			}
			else if(!listkpqt.isEmpty())
			{
				KqqsPage kp = listkpqt.get(0);
				if(kp.getQdqt()==2||kp.getQdqt()==3)
				{
					kd.setQttime(kp.getQstime()+":00");
					kd.setQtqs(3);//补考勤
				}
				else
				{
					kd.setQtqs(1);//考勤缺失
				}
			}
			else
			{
				kd.setQtqs(1);//考勤缺失
			}
		}
		else
		{
			if(ki.getQttime().compareTo(kd.getPbqttime())<0)
			{
				if(buru.contains(ui.getUsername())||mc.getRemark().equals("2")||mc.getRemark().equals("3"))
				{
					kd.setQtqs(0);
				}
				else
				{
					kd.setQtqs(2);//早退
				}
				
			}
			else
			{
				kd.setQtqs(0);//正常
			}
		}
		//保存请假类型
		if(!listlp.isEmpty())
		{
			LeavePage lp = listlp.get(0);
			//哺乳假算正常出勤
			if(lp.getType()!=14)
			{
				kd.setQj(lp.getType());
				if(lp.getBegindate().equals(mc.getDate())&&(lp.getHalfday()==1||lp.getHalfday()==3))
				{
					if(listlp.size()>1)//当天有多于1条的请假记录
					{
						LeavePage lptemp = listlp.get(1);
						if(lptemp.getType()!=14)
						{
							if(lptemp.getEnddate().equals(mc.getDate())&&(lptemp.getHalfday()==2||lptemp.getHalfday()==3))//第二条是上午半天
							{//全天
								kd.setHalfday(0);
								kd.setQtqs(4);//正常
								kd.setQdqs(4);//正常
								kd.setQdtime("");
								kd.setQttime("");
							}
							else
							{
								kd.setHalfday(2);//第一天下午半天
								kd.setQtqs(4);//正常
								kd.setQttime("");
							}
						}
					}else
					{
						kd.setHalfday(2);//第一天下午半天
						kd.setQtqs(4);//正常
						kd.setQttime("");
					}
				}
				else if(lp.getEnddate().equals(mc.getDate())&&(lp.getHalfday()==2||lp.getHalfday()==3))
				{
					if(listlp.size()>1)//当天有多于1条的请假记录
					{
						LeavePage lptemp = listlp.get(1);
						if(lptemp.getType()!=14)
						{
							if(lptemp.getBegindate().equals(mc.getDate())&&(lptemp.getHalfday()==1||lptemp.getHalfday()==3))//第二条是下午半天
							{//全天
								kd.setHalfday(0);
								kd.setQtqs(4);//正常
								kd.setQdqs(4);//正常
								kd.setQdtime("");
								kd.setQttime("");
							}
							else
							{
								kd.setHalfday(1);//最后一天上午半天
								kd.setQdqs(4);//正常
								kd.setQdtime("");
							}
						}
					}else
					{
						kd.setHalfday(1);//最后一天上午半天
						kd.setQdqs(4);//正常
						kd.setQdtime("");
					}
				}
				else
				{
					kd.setHalfday(0);
					kd.setQtqs(4);//正常
					kd.setQdqs(4);//正常
					kd.setQdtime("");
					kd.setQttime("");
				}
			}
			else//哺乳假
			{
				if(listlp.size()>1)//当天有多于1条的请假记录
				{
					LeavePage lptemp = listlp.get(1);
					kd.setQj(lptemp.getType());
					if(lptemp.getBegindate().equals(mc.getDate())&&(lptemp.getHalfday()==1||lptemp.getHalfday()==3))
					{
						kd.setHalfday(2);//第一天下午半天
						kd.setQtqs(4);//正常
						kd.setQttime("");
					}
					else if(lptemp.getEnddate().equals(mc.getDate())&&(lptemp.getHalfday()==2||lptemp.getHalfday()==3))
					{
						kd.setHalfday(1);//最后一天上午半天
						kd.setQdqs(4);//正常
						kd.setQdtime("");
					}
					else
					{
						kd.setHalfday(0);
						kd.setQtqs(4);//正常
						kd.setQdqs(4);//正常
						kd.setQdtime("");
						kd.setQttime("");
					}
				}
			}
		}
		else
		{
			kd.setQj(0);
		}
		//哺乳假正常出勤
		//保存外出公干信息
//		if(!listwb.isEmpty())
//		{
//			for(int i=0;i<listwb.size();i++)
//			{
//				WcggBaodao wb = listwb.get(i);
//				WcggPage wptemp = wpdao.findAllByNumber(wb.getNumber());
//				if(wptemp.getStatus()<5)//如果外出公干不是撤销、退回状态
//				{
//					//外出公干第一天，且下午出发
//					if(wb.getBegindate().equals(mc.getDate())&&(wb.getBghalfday()==2))
//					{
//						kd.setGg(1);
//						kd.setHalfday(2);//第一天下午半天
//						kd.setQtqs(5);//正常
//						kd.setQttime("");
//					}
//					//外出公干最后一天
//					else if(wb.getBaodaodate().equals(mc.getDate()))
//					{
//						//下午回来
//						if(wb.getBdhalfday()==2)
//						{
//							kd.setGg(1);
//							kd.setHalfday(1);//最后一天上午半天
//							kd.setQdqs(5);//正常
//							kd.setQdtime("");
//						}
//						//上午回来
//						else
//						{
//							kd.setGg(0);
//							//kd.setHalfday(0);
//						}
//					}
//					//外出公干中
//					else
//					{
//						kd.setGg(1);
//						kd.setHalfday(0);
//						kd.setQdqs(5);//正常
//						kd.setQtqs(5);//正常
//						kd.setQdtime("");
//						kd.setQttime("");
//					}
//				}
//				else
//				{
//					kd.setGg(0);
//				}
//			}
//		}
//		else
//		{
			if(!listwp.isEmpty())
			{
				WcggPage wp = listwp.get(0);
				kd.setGg(1);
				if(wp.getBegindate().equals(mc.getDate())&&(wp.getHalfday()==1||wp.getHalfday()==3))//第一天下午半天
				{
					if(listwp.size()>1)
					{
						WcggPage wptemp = listwp.get(1);
						if(wptemp.getEnddate().equals(mc.getDate())&&(wptemp.getHalfday()==2||wptemp.getHalfday()==3))
						{
							kd.setHalfday(0);
							kd.setQtqs(5);//正常
							kd.setQdqs(5);//正常
							kd.setQdtime("");
							kd.setQttime("");
						}
						else
						{
							kd.setHalfday(2);//第一天下午半天
							kd.setQtqs(5);//正常
							kd.setQttime("");
						}
					}
					else
					{
						kd.setHalfday(2);//第一天下午半天
						kd.setQtqs(5);//正常
						kd.setQttime("");
					}
				}
				else if(wp.getEnddate().equals(mc.getDate())&&(wp.getHalfday()==2||wp.getHalfday()==3))
				{
					if(listwp.size()>1)
					{
						WcggPage wptemp = listwp.get(1);
						if(wptemp.getBegindate().equals(mc.getDate())&&(wptemp.getHalfday()==1||wptemp.getHalfday()==3))
						{
							kd.setHalfday(0);
							kd.setQtqs(5);//正常
							kd.setQdqs(5);//正常
							kd.setQdtime("");
							kd.setQttime("");
						}
						else
						{
							kd.setHalfday(1);//最后一天上午半天
							kd.setQdqs(5);//正常
							kd.setQdtime("");
						}
					}	
					else
					{
						kd.setHalfday(1);//最后一天上午半天
						kd.setQdqs(5);//正常
						kd.setQdtime("");
					}
				}
				else
				{
					kd.setHalfday(0);
					kd.setQtqs(5);//正常
					kd.setQdqs(5);//正常
					kd.setQdtime("");
					kd.setQttime("");
				}
			}
			else
			{
				kd.setGg(0);
			}
//		}
		
		return kd;
	}
	/**
	 * 非工作日的算法
	 * @param mc
	 * @param ui
	 * @return
	 */
	public KqjlDaily methoForFGZR(MyCalendar mc,UserInfo ui)
	{
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		JbspPageDAO jpdao = new JbspPageDAO();
		KqjlDaily kd = kddao.findByDateAndName(mc.getDate(), ui.getUsername());
		List<JbspPage> listjp = jpdao.findAllByNameAndDate(ui.getUsername(), mc.getDate());
		
		kd.setPosition(ui.getPosition());
		kd.setNewnumber(ui.getNewnumber());
		kd.setWeek(mc.getWeek());
		kd.setPbqdtime("");
		kd.setPbqttime("");
		kd.setQdtime("");//加班不保存签到和签退时间
		kd.setQttime("");
		kd.setQdqs(0);//加班暂不计算迟到早退
		kd.setQtqs(0);
		kd.setQj(0);
		kd.setGg(0);
		if(!listjp.isEmpty())//加班
		{
			JbspPage jp = listjp.get(0);
			kd.setPosition(ui.getPosition());
			kd.setNewnumber(ui.getNewnumber());
			kd.setWeek(mc.getWeek());
			kd.setJb(1);
			if(jp.getBegindate().equals(mc.getDate())&&(jp.getHalfday()==1||jp.getHalfday()==3))
			{
				kd.setHalfday(2);//第一天下午半天
			}
			else if(jp.getEnddate().equals(mc.getDate())&&(jp.getHalfday()==2||jp.getHalfday()==3))
			{
				kd.setHalfday(1);//最后一天上午半天
			}
			else
			{
				kd.setHalfday(0);
			}
		}
		return kd;
	}
	
	
	public KqjlDaily methoForPB(MyCalendar mc,UserInfo ui,String buru)
	{
		KqjlImportDAO kidao = new KqjlImportDAO();
		WcggBaodaoDAO wbdao = new WcggBaodaoDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		WcggPageDAO wpdao = new WcggPageDAO();
		JbspPageDAO jpdao = new JbspPageDAO();
		KqqsPageDAO kpdao = new KqqsPageDAO();
		ScpbUploadDAO sudao = new ScpbUploadDAO();
		YgpbUploadDAO yudao = new YgpbUploadDAO();
		
		KqjlDaily kd = kddao.findByDateAndNameForPb(mc.getDate(), ui.getUsername());
		KqjlImport ki = kidao.findAllByDateAndName(mc.getDate(),ui.getUsername());
		List<LeavePage> listlp = lpdao.findByNewNumberAndDate(ui.getNewnumber(),mc.getDate(),"2,7,8");
		List<WcggPage> listwp = wpdao.findAllByNameAndDate(ui.getUsername(), mc.getDate());
		//WcggBaodao wb = wbdao.findAllByNewnumberAndDate(ui.getNewnumber(), mc.getDate());
		//List<WcggBaodao> listwb = wbdao.findAllByNewnumberAndDate(ui.getNewnumber(), mc.getDate());
		//List<KqqsPage> listkp = kpdao.findAllByNameAndDate(ui.getNewnumber(),mc.getDate());
		List<KqqsPage> listkpqd = kpdao.findAllByNameAndDateQD(ui.getNewnumber(),mc.getDate());
		List<KqqsPage> listkpqt = kpdao.findAllByNameAndDateQT(ui.getNewnumber(),mc.getDate());
		List<JbspPage> listjp = jpdao.findAllByNameAndDate(ui.getUsername(), mc.getDate());
		ScpbUpload su = sudao.findAllByDateNameNull(mc.getDate(), ui.getUsername());
		YgpbUpload yu = yudao.findAllByDateNameNull(mc.getDate(), ui.getUsername());
		
		kd.setPosition(ui.getPosition());
		kd.setNewnumber(ui.getNewnumber());
		kd.setWeek(mc.getWeek());
		kd.setQdtime(ki.getQdtime());
		kd.setQttime(ki.getQttime());
		if(su!=null)
		{
			kd.setPbqdtime(su.getPbqdtime());
			kd.setPbqttime(su.getPbqttime());
			kd.setPb(1);
			kd.setTb(su.getTb());
		}
		if(yu!=null)
		{
			kd.setPbqdtime(yu.getPbqdtime());
			kd.setPbqttime(yu.getPbqttime());
			kd.setPb(1);
			kd.setTb(yu.getTb());
		}
		String kqqdtime = Util.plusFiveMinutes(kd.getPbqdtime());//加5分钟
		//如果当天是排班日
		if(kd.getPb()==1)
		{
			//保存考勤情况
			if(ki.getQdtime()==null||ki.getQdtime().length()<2)
			{
				//保存补考勤信息
				if(mc.getRemark().equals("1")||mc.getRemark().equals("3"))
				{
					kd.setQdqs(0);//考勤忽略
				}
				else if(!listkpqd.isEmpty())
				{
					KqqsPage kp = listkpqd.get(0);
					if(kp.getQdqt()==1||kp.getQdqt()==3)
					{
						kd.setQdtime(kp.getQstime()+":00");
						kd.setQdqs(3);//补考勤
					}
					else
					{
						kd.setQdqs(1);//考勤缺失
					}
				}
				else
				{
					kd.setQdqs(1);//考勤缺失
				}
			}
			else
			{
				if(ki.getQdtime().substring(0, 5).compareTo(kqqdtime.substring(0, 5))>0)
				{
					if(buru.contains(ui.getUsername())||mc.getRemark().equals("1")||mc.getRemark().equals("3"))
					{
						kd.setQdqs(0);
					}
					else
					{
						kd.setQdqs(2);//迟到
					}
				}	
				else
				{
					kd.setQdqs(0);//正常
				}
			}
			//保存补考勤信息
			if(ki.getQttime()==null||ki.getQttime().length()<2)
			{
				if(mc.getRemark().equals("2")||mc.getRemark().equals("3"))
				{
					kd.setQtqs(0);//考勤忽略
				}
				else if(!listkpqt.isEmpty())
				{
					KqqsPage kp = listkpqt.get(0);
					if(kp.getQdqt()==2||kp.getQdqt()==3)
					{
						kd.setQttime(kp.getQstime()+":00");
						kd.setQtqs(3);//补考勤
					}
					else
					{
						kd.setQtqs(1);//考勤缺失
					}
				}
				else
				{
					kd.setQtqs(1);//考勤缺失
				}
			}
			else
			{
				if(ki.getQttime().compareTo(kd.getPbqttime())<0)
				{
					if(buru.contains(ui.getUsername())||mc.getRemark().equals("2")||mc.getRemark().equals("3"))
					{
						kd.setQtqs(0);
					}
					else
					{
						kd.setQtqs(2);//早退
					}
					
				}
				else
				{
					kd.setQtqs(0);//正常
				}
			}
		}
		//非排班日
		else
		{
			kd.setQj(0);
			kd.setGg(0);
			if(!listjp.isEmpty())//加班
			{
				JbspPage jp = listjp.get(0);
				kd.setPosition(ui.getPosition());
				kd.setNewnumber(ui.getNewnumber());
				kd.setWeek(mc.getWeek());
				kd.setPbqdtime("");
				kd.setPbqttime("");
				kd.setQdtime("");//加班不保存签到和签退时间
				kd.setQttime("");
				kd.setQdqs(0);//加班暂不计算迟到早退
				kd.setQtqs(0);
				kd.setJb(1);
				if(jp.getBegindate().equals(mc.getDate())&&(jp.getHalfday()==1||jp.getHalfday()==3))
				{
					kd.setHalfday(2);//第一天下午半天
				}
				else if(jp.getEnddate().equals(mc.getDate())&&(jp.getHalfday()==2||jp.getHalfday()==3))
				{
					kd.setHalfday(1);//最后一天上午半天
				}
				else
				{
					kd.setHalfday(0);
				}
			}
		}
		//请假和公干//只计算工作日
		if(mc.getWorkday()==1)
		{
			//保存请假类型
			if(!listlp.isEmpty())
			{
				LeavePage lp = listlp.get(0);
				//哺乳假算正常出勤
				if(lp.getType()!=14)
				{
					kd.setQj(lp.getType());
					if(lp.getBegindate().equals(mc.getDate())&&(lp.getHalfday()==1||lp.getHalfday()==3))
					{
						if(listlp.size()>1)//当天有多于1条的请假记录
						{
							LeavePage lptemp = listlp.get(1);
							if(lptemp.getEnddate().equals(mc.getDate())&&(lptemp.getHalfday()==2||lptemp.getHalfday()==3))//第二条是上午半天
							{//全天
								kd.setHalfday(0);
								kd.setQtqs(4);//正常
								kd.setQdqs(4);//正常
								kd.setQdtime("");
								kd.setQttime("");
							}
							else
							{
								kd.setHalfday(2);//第一天下午半天
								kd.setQtqs(4);//正常
								kd.setQttime("");
							}
						}else
						{
							kd.setHalfday(2);//第一天下午半天
							kd.setQtqs(4);//正常
							kd.setQttime("");
						}
					}
					else if(lp.getEnddate().equals(mc.getDate())&&(lp.getHalfday()==2||lp.getHalfday()==3))
					{
						if(listlp.size()>1)//当天有多于1条的请假记录
						{
							LeavePage lptemp = listlp.get(1);
							if(lptemp.getBegindate().equals(mc.getDate())&&(lptemp.getHalfday()==1||lptemp.getHalfday()==3))//第二条是下午半天
							{//全天
								kd.setHalfday(0);
								kd.setQtqs(4);//正常
								kd.setQdqs(4);//正常
								kd.setQdtime("");
								kd.setQttime("");
							}
							else
							{
								kd.setHalfday(1);//最后一天上午半天
								kd.setQdqs(4);//正常
								kd.setQdtime("");
							}
						}else
						{
							kd.setHalfday(1);//最后一天上午半天
							kd.setQdqs(4);//正常
							kd.setQdtime("");
						}
					}
					else
					{
						kd.setHalfday(0);
						kd.setQtqs(4);//正常
						kd.setQdqs(4);//正常
						kd.setQdtime("");
						kd.setQttime("");
					}
				}
			}
			else
			{
				kd.setQj(0);
			}
			//保存外出公干信息
//			if(!listwb.isEmpty())
//			{
//				for(int i=0;i<listwb.size();i++)
//				{
//					WcggBaodao wb = listwb.get(i);
//					WcggPage wptemp = wpdao.findAllByNumber(wb.getNumber());
//					if(wptemp.getStatus()<5)//如果外出公干不是撤销、退回状态
//					{
//						//外出公干第一天，且下午出发
//						if(wb.getBegindate().equals(mc.getDate())&&(wb.getBghalfday()==2))
//						{
//							kd.setGg(1);
//							kd.setHalfday(2);//第一天下午半天
//							kd.setQtqs(5);//正常
//							kd.setQttime("");
//						}
//						//外出公干最后一天
//						else if(wb.getBaodaodate().equals(mc.getDate()))
//						{
//							//下午回来
//							if(wb.getBdhalfday()==2)
//							{
//								kd.setGg(1);
//								kd.setHalfday(1);//最后一天上午半天
//								kd.setQdqs(5);//正常
//								kd.setQdtime("");
//							}
//							//上午回来
//							else
//							{
//								kd.setGg(0);
//								//kd.setHalfday(0);
//							}
//						}
//						//外出公干中
//						else
//						{
//							kd.setGg(1);
//							kd.setHalfday(0);
//							kd.setQdqs(5);//正常
//							kd.setQtqs(5);//正常
//							kd.setQdtime("");
//							kd.setQttime("");
//						}
//					}
//					else
//					{
//						kd.setGg(0);
//					}
//				}
//			}
//			else
//			{
				if(!listwp.isEmpty())
				{
					WcggPage wp = listwp.get(0);
					kd.setGg(1);
					if(wp.getBegindate().equals(mc.getDate())&&(wp.getHalfday()==1||wp.getHalfday()==3))//第一天下午半天
					{
						if(listwp.size()>1)
						{
							WcggPage wptemp = listwp.get(1);
							if(wptemp.getEnddate().equals(mc.getDate())&&(wptemp.getHalfday()==2||wptemp.getHalfday()==3))
							{
								kd.setHalfday(0);
								kd.setQtqs(5);//正常
								kd.setQdqs(5);//正常
								kd.setQdtime("");
								kd.setQttime("");
							}
							else
							{
								kd.setHalfday(2);//第一天下午半天
								kd.setQtqs(5);//正常
								kd.setQttime("");
							}
						}
						else
						{
							kd.setHalfday(2);//第一天下午半天
							kd.setQtqs(5);//正常
							kd.setQttime("");
						}
					}
					else if(wp.getEnddate().equals(mc.getDate())&&(wp.getHalfday()==2||wp.getHalfday()==3))
					{
						if(listwp.size()>1)
						{
							WcggPage wptemp = listwp.get(1);
							if(wptemp.getBegindate().equals(mc.getDate())&&(wptemp.getHalfday()==1||wptemp.getHalfday()==3))
							{
								kd.setHalfday(0);
								kd.setQtqs(5);//正常
								kd.setQdqs(5);//正常
								kd.setQdtime("");
								kd.setQttime("");
							}
							else
							{
								kd.setHalfday(1);//最后一天上午半天
								kd.setQdqs(5);//正常
								kd.setQdtime("");
							}
						}	
						else
						{
							kd.setHalfday(1);//最后一天上午半天
							kd.setQdqs(5);//正常
							kd.setQdtime("");
						}
					}
					else
					{
						kd.setHalfday(0);
						kd.setQtqs(5);//正常
						kd.setQdqs(5);//正常
						kd.setQdtime("");
						kd.setQttime("");
					}
				}
				else
				{
					kd.setGg(0);
				}
//			}
		}
		return kd;
	}
	/**
	 * 线上排班使用方法
	 * @param mc
	 * @param ui
	 * @param buru
	 * @return
	 */
	public KqjlDaily methoForYPB(MyCalendar mc,UserInfo ui,String buru)
	{
		KqjlImportDAO kidao = new KqjlImportDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		KqqsPageDAO kpdao = new KqqsPageDAO();
		TbsqPageDAO tpdao = new TbsqPageDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		WcggPageDAO wpdao = new WcggPageDAO();
		PbMxDAO pmdao = new PbMxDAO();
		
		KqjlDaily kd = kddao.findByDateAndNameForPb(mc.getDate(), ui.getUsername());
		KqjlImport ki = kidao.findAllByDateAndName(mc.getDate(),ui.getUsername());
		PbMx pm = pmdao.findAllByNameAndDateNull(ui.getUsername(),mc.getDate());
		TbsqPage tp = tpdao.findAllByNameAndDate(ui,mc.getDate());
		List<LeavePage> listlp = lpdao.findByNewNumberAndDate(ui.getNewnumber(),mc.getDate(),"2,7,8");
		List<WcggPage> listwp = wpdao.findAllByNameAndDate(ui.getUsername(), mc.getDate());
		List<KqqsPage> listkpqd = kpdao.findAllByNameAndDateQD(ui.getNewnumber(),mc.getDate());
		List<KqqsPage> listkpqt = kpdao.findAllByNameAndDateQT(ui.getNewnumber(),mc.getDate());
		kd.setPosition(ui.getPosition());
		kd.setNewnumber(ui.getNewnumber());
		kd.setWeek(mc.getWeek());
		kd.setQdtime(ki.getQdtime());
		kd.setQttime(ki.getQttime());
		kd.setPbqdtime(pm.getPbqdtime()+":00");
		kd.setPbqttime(pm.getPbqttime()+":00");
		
			
		if(pm.getSw()!=null&&pm.getXw()!=null&&pm.getSw().startsWith("xx")&&pm.getXw().startsWith("xx"))
		{
			kd.setPbqdtime(Util.zcqd);
			kd.setPbqttime(Util.zcqt);
		}
		kd.setPb(1);
		if(tp!=null)
		kd.setTb(1);
		String kqqdtime = Util.plusFiveMinutes(kd.getPbqdtime());//加5分钟
		//保存考勤情况
		if(ki.getQdtime()==null||ki.getQdtime().length()<2)
		{
			//保存补考勤信息
			if(mc.getRemark().equals("1")||mc.getRemark().equals("3"))
			{
				kd.setQdqs(0);//考勤忽略
			}
			else if(!listkpqd.isEmpty())
			{
				KqqsPage kp = listkpqd.get(0);
				if(kp.getQdqt()==1||kp.getQdqt()==3)
				{
					kd.setQdtime(kp.getQstime()+":00");
					kd.setQdqs(3);//补考勤
				}
				else
				{
					kd.setQdqs(1);//考勤缺失
				}
			}
			else
			{
				kd.setQdqs(1);//考勤缺失
			}
		}
		else
		{
			if(ki.getQdtime().substring(0, 5).compareTo(kqqdtime.substring(0, 5))>0)
			{
				if(buru.contains(ui.getUsername())||mc.getRemark().equals("1")||mc.getRemark().equals("3"))
				{
					kd.setQdqs(0);
				}
				else
				{
					kd.setQdqs(2);//迟到
				}
			}	
			else
			{
				kd.setQdqs(0);//正常
			}
		}
		//保存补考勤信息
		if(ki.getQttime()==null||ki.getQttime().length()<2)
		{
			if(mc.getRemark().equals("2")||mc.getRemark().equals("3"))
			{
				kd.setQtqs(0);//考勤忽略
			}
			else if(!listkpqt.isEmpty())
			{
				KqqsPage kp = listkpqt.get(0);
				if(kp.getQdqt()==2||kp.getQdqt()==3)
				{
					kd.setQttime(kp.getQstime()+":00");
					kd.setQtqs(3);//补考勤
				}
				else
				{
					kd.setQtqs(1);//考勤缺失
				}
			}
			else
			{
				kd.setQtqs(1);//考勤缺失
			}
		}
		else
		{
			if(ki.getQttime().compareTo(kd.getPbqttime())<0)
			{
				if(buru.contains(ui.getUsername())||mc.getRemark().equals("2")||mc.getRemark().equals("3"))
				{
					kd.setQtqs(0);
				}
				else
				{
					kd.setQtqs(2);//早退
				}
				
			}
			else
			{
				kd.setQtqs(0);//正常
			}
		}	
		//请假和公干//只计算工作日
		if(mc.getWorkday()==1)
		{
			//保存请假类型
			if(!listlp.isEmpty())
			{
				LeavePage lp = listlp.get(0);
				//哺乳假算正常出勤
				if(lp.getType()!=14)
				{
					kd.setQj(lp.getType());
					if(lp.getBegindate().equals(mc.getDate())&&(lp.getHalfday()==1||lp.getHalfday()==3))
					{
						if(listlp.size()>1)//当天有多于1条的请假记录
						{
							LeavePage lptemp = listlp.get(1);
							if(lptemp.getType()!=14)
							{
								if(lptemp.getEnddate().equals(mc.getDate())&&(lptemp.getHalfday()==2||lptemp.getHalfday()==3))//第二条是上午半天
								{//全天
									kd.setHalfday(0);
									kd.setQtqs(4);//正常
									kd.setQdqs(4);//正常
									kd.setQdtime("");
									kd.setQttime("");
								}
								else
								{
									kd.setHalfday(2);//第一天下午半天
									kd.setQtqs(4);//正常
									kd.setQttime("");
								}
							}
						}else
						{
							kd.setHalfday(2);//第一天下午半天
							kd.setQtqs(4);//正常
							kd.setQttime("");
						}
					}
					else if(lp.getEnddate().equals(mc.getDate())&&(lp.getHalfday()==2||lp.getHalfday()==3))
					{
						if(listlp.size()>1)//当天有多于1条的请假记录
						{
							LeavePage lptemp = listlp.get(1);
							if(lptemp.getType()!=14)
							{
								if(lptemp.getBegindate().equals(mc.getDate())&&(lptemp.getHalfday()==1||lptemp.getHalfday()==3))//第二条是下午半天
								{//全天
									kd.setHalfday(0);
									kd.setQtqs(4);//正常
									kd.setQdqs(4);//正常
									kd.setQdtime("");
									kd.setQttime("");
								}
								else
								{
									kd.setHalfday(1);//最后一天上午半天
									kd.setQdqs(4);//正常
									kd.setQdtime("");
								}
							}
						}else
						{
							kd.setHalfday(1);//最后一天上午半天
							kd.setQdqs(4);//正常
							kd.setQdtime("");
						}
					}
					else
					{
						kd.setHalfday(0);
						kd.setQtqs(4);//正常
						kd.setQdqs(4);//正常
						kd.setQdtime("");
						kd.setQttime("");
					}
				}
				else//哺乳假
				{
					if(listlp.size()>1)//当天有多于1条的请假记录
					{
						LeavePage lptemp = listlp.get(1);
						kd.setQj(lptemp.getType());
						if(lptemp.getBegindate().equals(mc.getDate())&&(lptemp.getHalfday()==1||lptemp.getHalfday()==3))
						{
							kd.setHalfday(2);//第一天下午半天
							kd.setQtqs(4);//正常
							kd.setQttime("");
						}
						else if(lptemp.getEnddate().equals(mc.getDate())&&(lptemp.getHalfday()==2||lptemp.getHalfday()==3))
						{
							kd.setHalfday(1);//最后一天上午半天
							kd.setQdqs(4);//正常
							kd.setQdtime("");
						}
						else
						{
							kd.setHalfday(0);
							kd.setQtqs(4);//正常
							kd.setQdqs(4);//正常
							kd.setQdtime("");
							kd.setQttime("");
						}
					}
				}
			}
			else
			{
				kd.setQj(0);
			}
			//外出公干
			if(!listwp.isEmpty())
			{
				WcggPage wp = listwp.get(0);
				kd.setGg(1);
				if(wp.getBegindate().equals(mc.getDate())&&(wp.getHalfday()==1||wp.getHalfday()==3))//第一天下午半天
				{
					if(listwp.size()>1)
					{
						WcggPage wptemp = listwp.get(1);
						if(wptemp.getEnddate().equals(mc.getDate())&&(wptemp.getHalfday()==2||wptemp.getHalfday()==3))
						{
							kd.setHalfday(0);
							kd.setQtqs(5);//正常
							kd.setQdqs(5);//正常
							kd.setQdtime("");
							kd.setQttime("");
						}
						else
						{
							kd.setHalfday(2);//第一天下午半天
							kd.setQtqs(5);//正常
							kd.setQttime("");
						}
					}
					else
					{
						kd.setHalfday(2);//第一天下午半天
						kd.setQtqs(5);//正常
						kd.setQttime("");
					}
				}
				else if(wp.getEnddate().equals(mc.getDate())&&(wp.getHalfday()==2||wp.getHalfday()==3))
				{
					if(listwp.size()>1)
					{
						WcggPage wptemp = listwp.get(1);
						if(wptemp.getBegindate().equals(mc.getDate())&&(wptemp.getHalfday()==1||wptemp.getHalfday()==3))
						{
							kd.setHalfday(0);
							kd.setQtqs(5);//正常
							kd.setQdqs(5);//正常
							kd.setQdtime("");
							kd.setQttime("");
						}
						else
						{
							kd.setHalfday(1);//最后一天上午半天
							kd.setQdqs(5);//正常
							kd.setQdtime("");
						}
					}	
					else
					{
						kd.setHalfday(1);//最后一天上午半天
						kd.setQdqs(5);//正常
						kd.setQdtime("");
					}
				}
				else
				{
					kd.setHalfday(0);
					kd.setQtqs(5);//正常
					kd.setQdqs(5);//正常
					kd.setQdtime("");
					kd.setQttime("");
				}
			}
			else
			{
				kd.setGg(0);
			}
//			String sw = pm.getSw();
//			String xw = pm.getXw();
//			if(sw==null&&xw==null)//上下午都上班
//			{
//				//kd.setHalfday(0);
//				//kd.setQtqs(0);//正常
//				//kd.setQdqs(0);//正常
//				kd.setQj(0);
//			}
//			else if(sw==null)//只有上午上班
//			{
//				if(xw.length()<2)
//				{
//					//kd.setHalfday(0);
//					//kd.setQtqs(0);//正常
//					//kd.setQdqs(0);//正常
//					kd.setQj(0);
//				}
//				else
//				{
//					String type = xw.substring(0, 2);
//					kd.setHalfday(1);
//					kd.setQttime("");
//					if(type.equals("qj"))
//					{
//						kd.setQj(Integer.parseInt(xw.substring(2, xw.length())));
//						kd.setQtqs(4);
//					}
//					if(type.equals("gg"));
//					{
//						kd.setGg(1);
//						kd.setQtqs(5);
//					}
//				}
//			}
//			else if(xw==null)//只有下午上班
//			{
//				if(sw.length()<2)
//				{
//					//kd.setHalfday(0);
//					//kd.setQtqs(0);//正常
//					//kd.setQdqs(0);//正常
//					kd.setQj(0);
//				}
//				else
//				{
//					String type = sw.substring(0, 2);
//					kd.setHalfday(2);
//					kd.setQdtime("");
//					if(type.equals("qj"))
//					{
//						kd.setQj(Integer.parseInt(sw.substring(2, sw.length())));
//						kd.setQdqs(4);
//					}
//					if(type.equals("gg"));
//					{
//						kd.setGg(1);
//						kd.setQdqs(5);
//					}
//				}
//			}
//			else//上下午都有假
//			{
//				if(sw.length()>=2)//上午都有假
//				{
//					kd.setQdtime("");
//					if(sw.startsWith("qj"))
//					{
//						kd.setQj(Integer.parseInt(sw.substring(2, sw.length())));
//						kd.setQdqs(4);
//					}
//					if(sw.startsWith("gg"))
//					{
//						kd.setGg(1);
//						kd.setQdqs(5);
//					}
//				}
//				else
//				{
//					//kd.setQdqs(0);//正常
//				}
//				if(xw.length()>=2)//下午都有假
//				{
//					kd.setQttime("");
//					if(xw.startsWith("qj"))
//					{
//						kd.setQj(Integer.parseInt(xw.substring(2, xw.length())));
//						kd.setQtqs(4);
//					}
//					if(xw.startsWith("gg"))
//					{
//						kd.setGg(1);
//						kd.setQtqs(5);
//					}
//				}
//				else
//				{
//					kd.setQttime("");
//					//kd.setQtqs(0);//正常
//				}
//			}
		}
		return kd;
	}
	
	/**
	 * 项目组的计算方法
	 * @param mc
	 * @param ui
	 * @return
	 */
	public KqjlDaily methoForXMZ(MyCalendar mc,UserInfo ui)
	{
		KqjlImportDAO kidao = new KqjlImportDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		WcggPageDAO wpdao = new WcggPageDAO();
		
		
		KqjlDaily kd = kddao.findByDateAndName(mc.getDate(), ui.getUsername());
		KqjlImport ki = kidao.findAllByDateAndName(mc.getDate(),ui.getUsername());
		List<LeavePage> listlp = lpdao.findByNewNumberAndDate(ui.getNewnumber(),mc.getDate(),"2,7,8");
		List<WcggPage> listwp = wpdao.findAllByNameAndDate(ui.getUsername(), mc.getDate());
		//WcggBaodao wb = wbdao.findAllByNewnumberAndDate(ui.getNewnumber(), mc.getDate());
		//List<KqqsPage> listkp = kpdao.findAllByNameAndDate(ui.getNewnumber(),mc.getDate());
		kd.setPosition(ui.getPosition());
		kd.setNewnumber(ui.getNewnumber());
		kd.setWeek(mc.getWeek());
		kd.setQdtime(ki.getQdtime());
		kd.setQttime(ki.getQttime());
		
		kd.setQdqs(0);
		kd.setQtqs(0);
		//保存请假类型
		if(!listlp.isEmpty())
		{
			LeavePage lp = listlp.get(0);
			//哺乳假算正常出勤
			if(lp.getType()!=14)
			{
				kd.setQj(lp.getType());
				if(lp.getBegindate().equals(mc.getDate())&&(lp.getHalfday()==1||lp.getHalfday()==3))
				{
					if(listlp.size()>1)//当天有多于1条的请假记录
					{
						LeavePage lptemp = listlp.get(1);
						if(lptemp.getEnddate().equals(mc.getDate())&&(lptemp.getHalfday()==2||lptemp.getHalfday()==3))//第二条是上午半天
						{//全天
							kd.setHalfday(0);
							kd.setQtqs(4);//正常
							kd.setQdqs(4);//正常
							kd.setQdtime("");
							kd.setQttime("");
						}
						else
						{
							kd.setHalfday(2);//第一天下午半天
							kd.setQtqs(4);//正常
							kd.setQttime("");
						}
					}else
					{
						kd.setHalfday(2);//第一天下午半天
						kd.setQtqs(4);//正常
						kd.setQttime("");
					}
				}
				else if(lp.getEnddate().equals(mc.getDate())&&(lp.getHalfday()==2||lp.getHalfday()==3))
				{
					if(listlp.size()>1)//当天有多于1条的请假记录
					{
						LeavePage lptemp = listlp.get(1);
						if(lptemp.getBegindate().equals(mc.getDate())&&(lptemp.getHalfday()==1||lptemp.getHalfday()==3))//第二条是下午半天
						{//全天
							kd.setHalfday(0);
							kd.setQtqs(4);//正常
							kd.setQdqs(4);//正常
							kd.setQdtime("");
							kd.setQttime("");
						}
						else
						{
							kd.setHalfday(1);//最后一天上午半天
							kd.setQdqs(4);//正常
							kd.setQdtime("");
						}
					}else
					{
						kd.setHalfday(1);//最后一天上午半天
						kd.setQdqs(4);//正常
						kd.setQdtime("");
					}
				}
				else
				{
					kd.setHalfday(0);
					kd.setQtqs(4);//正常
					kd.setQdqs(4);//正常
					kd.setQdtime("");
					kd.setQttime("");
				}
			}
		}
		else
		{
			kd.setQj(0);
		}
		//保存外出公干信息
		if(!listwp.isEmpty())
		{
			WcggPage wp = listwp.get(0);
			kd.setGg(1);
			if(wp.getBegindate().equals(mc.getDate())&&(wp.getHalfday()==1||wp.getHalfday()==3))//第一天下午半天
			{
				if(listwp.size()>1)
				{
					WcggPage wptemp = listwp.get(1);
					if(wptemp.getEnddate().equals(mc.getDate())&&(wptemp.getHalfday()==2||wptemp.getHalfday()==3))
					{
						kd.setHalfday(0);
						kd.setQtqs(5);//正常
						kd.setQdqs(5);//正常
						kd.setQdtime("");
						kd.setQttime("");
					}
					else
					{
						kd.setHalfday(2);//第一天下午半天
						kd.setQtqs(5);//正常
						kd.setQttime("");
					}
				}
				else
				{
					kd.setHalfday(2);//第一天下午半天
					kd.setQtqs(5);//正常
					kd.setQttime("");
				}
			}
			else if(wp.getEnddate().equals(mc.getDate())&&(wp.getHalfday()==2||wp.getHalfday()==3))
			{
				if(listwp.size()>1)
				{
					WcggPage wptemp = listwp.get(1);
					if(wptemp.getBegindate().equals(mc.getDate())&&(wptemp.getHalfday()==1||wptemp.getHalfday()==3))
					{
						kd.setHalfday(0);
						kd.setQtqs(5);//正常
						kd.setQdqs(5);//正常
						kd.setQdtime("");
						kd.setQttime("");
					}
					else
					{
						kd.setHalfday(1);//最后一天上午半天
						kd.setQdqs(5);//正常
						kd.setQdtime("");
					}
				}	
				else
				{
					kd.setHalfday(1);//最后一天上午半天
					kd.setQdqs(5);//正常
					kd.setQdtime("");
				}
			}
			else
			{
				kd.setHalfday(0);
				kd.setQtqs(5);//正常
				kd.setQdqs(5);//正常
				kd.setQdtime("");
				kd.setQttime("");
			}
		}
		else
		{
			kd.setGg(0);
		}
		
		return kd;
	}
}
