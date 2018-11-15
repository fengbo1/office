package office.kqjl.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

import office.config.dao.ConfigDAO;
import office.kqjl.bean.DateName;
import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.dao.KqjlImportDAO;
import office.kqjl.dao.KqjlMonthDAO;
import office.kqjl.dao.KqjlUploadDAO;
import office.kqjl.dao.ScpbUploadDAO;
import office.kqjl.dao.YgpbUploadDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlImport;
import office.kqjl.pojo.KqjlMonth;
import office.kqjl.pojo.KqjlUpload;
import office.kqjl.pojo.ScpbUpload;
import office.kqjl.pojo.YgpbUpload;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.mycalendar.dao.MyCalendarDAO;
import office.mycalendar.pojo.MyCalendar;
import office.pb.dao.PbMxDAO;
import office.pb.dao.PbTeshuDAO;
import office.pb.pojo.PbMx;
import office.pb.pojo.PbTeshu;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.Util;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import ccb.hibernate.HibernateSessionFactory;


/**
 * 导入考勤记录
 * @author htzx
 *
 */
public class ImportKqjl {
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
	/**
	 * 标准文件名201510kqjl.xls
	 * 			201510ygxy.xls
	 * 			201510scry.xls
	 * 文件上传和读取内容
	 * @return "success"执行成功
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		String realpath = "D:/import/office/";
		KqjlImportDAO kidao = new KqjlImportDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		PbMxDAO pmdao = new PbMxDAO();
		DateUtil du = new DateUtil();
		String last_half_year_day = du.getLastHalfYearDay();
		KqjlUploadDAO kudao = new KqjlUploadDAO();
		YgpbUploadDAO yudao = new YgpbUploadDAO();
		ScpbUploadDAO sudao = new ScpbUploadDAO();
		message = "导入成功";
		UserInfoDAO uidao = new UserInfoDAO();
		String yearmonth = fileFileName.substring(0, 6);
		KqjlUpload ku = kudao.findAllByMonth(yearmonth);
		int nn=0;
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
		if(yearmonth.compareTo("201501")<0||yearmonth.compareTo("209912")>0)
		{
			message = "导入失败,文件名应以年+月开头";
		}
		else if(fileFileName.contains("kqjlold"))//201510kqjl.xls，旧格式考勤记录表
		{
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				
				String sql = "delete from t_kqjl_import where date<'"+last_half_year_day+"'";
				session.createSQLQuery(sql).executeUpdate();
				for (int i = 1; i < nn; i++) {
					String name=sheet.getCell(1, i).getContents().trim();
					if(name.equals("楮永娴")||name.equals("禇永娴"))
					{
						name="褚永娴";
					}
					if(name.equals("虞昕昀"))
					{
						name="虞昕韵";
					}
					String tempdate = sheet.getCell(4, i).getContents().trim();
					String[] temp = tempdate.split("-");
					tempdate = temp[0];
					if(tempdate.length()<=2)
					{
						tempdate = fileFileName.substring(0, 4);//String.valueOf(du.getThisYear());
					}
					if(temp[1].length()==1)
						tempdate+="0";
					tempdate+=temp[1];
					if(temp[2].length()==1)
						tempdate+="0";
					tempdate+=temp[2];
					KqjlImport ki =kidao.findAllByDateAndName(tempdate,name);
					KqjlDaily kd = kddao.findByDateAndNameForPb(tempdate, name); 
					System.out.println("qdtime"+sheet.getCell(7, i).getContents().trim());
					ki.setQdtime(sheet.getCell(7, i).getContents().trim());
					if(ki.getQdtime().length()>1&&ki.getQdtime().length()<8)
					{
						ki.setQdtime("0"+ki.getQdtime());
					}
					
					String qttemp = sheet.getCell(8, i).getContents().trim();
					ki.setQttime(qttemp);
					if(ki.getQttime().length()>1&&ki.getQttime().length()<8)
					{
						ki.setQttime("0"+ki.getQttime());
					}
					if(qttemp!=null&&!qttemp.equals(""))
					{
						int shi = Integer.parseInt(ki.getQttime().split(":")[0]);
						if(shi<12)
						{
							int newshi = shi+12;
							qttemp = String.valueOf(newshi)+ki.getQttime().substring(2, 8);
						}
						ki.setQttime(qttemp);
					}
					if(uidao.findByName(ki.getName())==null)
					{
						message = "姓名:"+ki.getName()+"在工具中查询不到，请确认！";
					}
					else
					{
						ki.setNewnumber(uidao.findByName(ki.getName()).getNewnumber());
					}
					System.out.println(ki.getName());
					kd.setQdtime(ki.getQdtime());
					kd.setQttime(ki.getQttime());
					kidao.merge(ki);
					kddao.merge(kd);
				}
				ku.setZwjl(1);
				kudao.merge(ku);
	    	}catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			}finally{
				 trans.commit();
		         session.flush();
		         session.clear();
		         session.close();
			}
			//countKqjlDaily();//计算考勤记录日表
			//countKqjlDailyForYgxy();//计算考勤记录日表(员工响应)
			//countkqjlMonth();//计算考勤记录月表
		}
		else if(fileFileName.contains("kqjl"))
		{
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				long eighthour = 8*60*60*1000;  
				String sql = "delete from t_kqjl_import where date<'"+last_half_year_day+"'";
				session.createSQLQuery(sql).executeUpdate();
				for (int i = 1; i < nn; i++) {
					String name =sheet.getCell(1, i).getContents().trim();
					String datetime = sheet.getCell(3, i).getContents().trim();
					 Cell cji = sheet.getCell(3, i);
	                   
	                    if (cji.getType() == CellType.DATE) { //手动填写模板文件时为 date 类型，其他情况有可能不是date类型
	                        DateCell dc = (DateCell) cji;
	                        Date date = dc.getDate();
	                        long temptime = date.getTime()-eighthour;
	                        java.util.Date tempdate = new java.util.Date();  
	                        tempdate.setTime(temptime);  
	                        SimpleDateFormat sdf = new SimpleDateFormat(
	                                "yyyy-MM-dd HH:mm:ss");
	                        datetime = sdf.format(tempdate);
	                        System.out.println(datetime);
	                    }
					
					
					String tempdate = datetime.split(" ")[0];
					String time = datetime.split(" ")[1];
					String[] temp = tempdate.split("-");
					tempdate = temp[0];
					if(tempdate.length()<=2)
					{
						tempdate = fileFileName.substring(0, 4);//String.valueOf(du.getThisYear());
					}
					if(temp[1].length()==1)
						tempdate+="0";
					tempdate+=temp[1];
					if(temp[2].length()==1)
						tempdate+="0";
					tempdate+=temp[2];
					if(time.length()<8)
					{
						time="0"+time;
					}
					KqjlImport ki =kidao.findAllByDateAndName(tempdate,name);
//					KqjlDaily kd = kddao.findByDateAndNameForPb(tempdate, name); 
					PbMx pm = pmdao.findAllByNameAndDateNull(name, tempdate);
					if((ki.getQdtime().equals("")||time.compareTo(ki.getQdtime())<0)&&time.compareTo("12:00:00")<0)
					{
						ki.setQdtime(time);
					}
					if((ki.getQttime().equals("")||time.compareTo(ki.getQttime())>0)&&time.compareTo("12:00:00")>0)
					{
						ki.setQttime(time);
					}
					if(uidao.findByName(ki.getName())==null)
					{
						message = "姓名:"+ki.getName()+"在工具中查询不到，请确认！";
					}
					else
					{
						ki.setNewnumber(uidao.findByName(ki.getName()).getNewnumber());
					}
					System.out.println(ki.getName());
//					kd.setQdtime(ki.getQdtime());
//					kd.setQttime(ki.getQttime());
//					if(pm!=null)
//					{
//						kd.setPbqdtime(pm.getPbqdtime());
//						kd.setPbqttime(pm.getPbqttime());
//					}
//					else
//					{
//						kd.setPbqdtime(Util.zcqd);
//						kd.setPbqttime(Util.zcqt);
//					}
					kidao.merge(ki);
//					kddao.merge(kd);
				}
				ku.setZwjl(1);
				kudao.merge(ku);
	    	}catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			}finally{
				 trans.commit();
		         session.flush();
		         session.clear();
		         session.close();
			}
		}
		else if(fileFileName.contains("ygxy"))//201510ygxy.xls，员工响应排班表
		{
			String date = "";
			String month = "";
			String name = "";
			String pbqdtime = "";
			String pbqttime = "";
			String tb = "";
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 遍历所有sheet
	    		Sheet[] sheets = book.getSheets();
	    		String sql = "truncate t_ygpb_upload";
				session.createSQLQuery(sql).executeUpdate();
	    		for(int x=0;x<sheets.length;x++)//遍历所有sheet
	    		{
	    			Sheet sheet = book.getSheet(x);
					// 得到第一列第一行的单元格
					nn = sheet.getRows();
					for (int i = 1; i < nn; i++) {
						date = sheet.getCell(1, i).getContents().trim();
						name = sheet.getCell(0, i).getContents().trim();
						System.out.println(date+name);
						if(!date.equals("")&&!name.equals(""))
						{
							pbqdtime = sheet.getCell(2, i).getContents().trim();
							pbqttime = sheet.getCell(3, i).getContents().trim();
							tb = sheet.getCell(4, i).getContents().trim();
							if(pbqdtime.length()==7)
							{
								pbqdtime = "0"+pbqdtime;
							}
							if(pbqttime.length()==7)
							{
								pbqttime = "0"+pbqttime;
							}
							if(date.length()!=8)
							{
								message+="sheet"+x+"中第"+i+"行日期"+date+"格式有误  ";
							}
							else if(uidao.findByName(name)==null)
							{
								message+="sheet"+x+"中第"+i+"行姓名"+name+"查询不到  ";
							}
							else if(pbqdtime.length()!=8)
							{
								message+="sheet"+x+"中第"+i+"行签到时间"+pbqdtime+"格式有误  ";
							}
							else if(pbqttime.length()!=8)
							{
								message+="sheet"+x+"中第"+i+"行签退时间"+pbqttime+"格式有误  ";
							}
							else if(pbqdtime.compareTo("05:00:00")<0||pbqdtime.compareTo("24:00:00")>0)
							{
								message+="sheet"+x+"中第"+i+"行签到时间"+pbqdtime+"有误  ";
							}
							else if(pbqttime.compareTo("05:00:00")<0||pbqttime.compareTo("24:00:00")>0)
							{
								message+="sheet"+x+"中第"+i+"行签退时间"+pbqttime+"有误  ";
							}
							else 
							{
								YgpbUpload yu = yudao.findAllByDateName(date, name);
								if(yu==null)
								{
									message+="【导入失败！发现人员重复"+date+name+"】";
								}
								else
								{
									yu.setDate(date);
									yu.setName(name);
									yu.setPbqdtime(pbqdtime);
									yu.setPbqttime(pbqttime);
									if(!Util.ifEmpty(tb))//调班标志位
									{
										yu.setTb(1);
									}
									else
									{
										yu.setTb(0);
									}
									yudao.merge(yu);
								}
							}
						}
					}
	    		}
	    		ku.setXypb(1);
				kudao.merge(ku);
	    	}catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			}finally{
				 trans.commit();
		         session.flush();
		         session.clear();
		         session.close();
			}
		}
		else if(fileFileName.contains("scry"))//201510scry.xls，生产人员排班表
		{
			String date = "";
			String name = "";
			String pbqdtime = "";
			String pbqttime = "";
			String tb = "";
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	try {
	    		//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
	    		Sheet[] sheets = book.getSheets();
	    		String sql = "truncate t_scpb_upload";
				session.createSQLQuery(sql).executeUpdate();
	    		for(int x=0;x<sheets.length;x++)//遍历所有sheet
	    		{
	    			Sheet sheet = book.getSheet(x);
	    			// 得到第一列第一行的单元格
					nn = sheet.getRows();
					for (int i = 1; i < nn; i++) {
						date = sheet.getCell(1, i).getContents().trim();
						name = sheet.getCell(0, i).getContents().trim();
						if(!date.equals("")&&!name.equals(""))
						{
						pbqdtime = sheet.getCell(2, i).getContents().trim();
						pbqttime = sheet.getCell(3, i).getContents().trim();
						System.out.println(date+name);
//						Cell pbqt = sheet.getCell(3, i);
//						if(pbqt.getType() == CellType.DATE)
//						{
//							 DateCell dc = (DateCell) pbqt;
//							 Date dateqt = (Date) dc.getDate();
//							 pbqttime = sdf.format(dateqt);
//						}
						tb = sheet.getCell(4, i).getContents().trim();
						if(pbqdtime.length()==7)
						{
							pbqdtime = "0"+pbqdtime;
						}
						else if(pbqdtime.length()==4)
						{
							pbqdtime = "0"+pbqdtime+":00";
						}
						else if(pbqdtime.length()==5)
						{
							pbqdtime = pbqdtime+":00";
						}
						if(pbqttime.length()==7)
						{
							pbqttime = "0"+pbqttime;
						}
						else if(pbqttime.length()==4)
						{
							pbqttime = "0"+pbqttime+":00";
						}
						else if(pbqttime.length()==5)
						{
							pbqttime = pbqttime+":00";
						}
						int shi = Integer.parseInt(pbqttime.split(":")[0]);
						if(shi<12)
						{
							int newshi = shi+12;
							pbqttime = String.valueOf(newshi)+pbqttime.substring(2, 8);
						}
						if(date.length()!=8)
						{
							message+="  第"+i+"行日期格式有误  ";
						}
						else if(uidao.findByName(name)==null)
						{
							message+="  第"+i+"行姓名查询不到  ";
						}
						else if(pbqdtime.length()!=8)
						{
							message+="  第"+i+"行签到时间格式有误  ";
						}
						else if(pbqttime.length()!=8)
						{
							message+="  第"+i+"行签退时间格式有误  ";
						}
						else if(pbqdtime.compareTo("07:00:00")<0||pbqdtime.compareTo("22:00:00")>0)
						{
							message+="  第"+i+"行签到时间有误  ";
						}
						else if(pbqttime.compareTo("07:00:00")<0||pbqttime.compareTo("22:00:00")>0)
						{
							message+="  第"+i+"行签退时间有误  ";
						}
						else 
						{
							ScpbUpload su = sudao.findAllByDateName(date, name);
							if(su==null)
							{
								message+="【导入失败！发现人员重复"+date+name+"】";
							}
							else
							{
								su.setDate(date);
								su.setName(name);
								su.setPbqdtime(pbqdtime);
								su.setPbqttime(pbqttime);
								if(!Util.ifEmpty(tb))//调班标志位
								{
									su.setTb(1);
								}
								else
								{
									su.setTb(0);
								}
								UserInfo ui = uidao.findByName(name);
								char chu = ui.getPosition().charAt(2);
								if(chu=='2'||chu=='3'||chu=='4')
								sudao.merge(su);
							}
						}
						}
					}
	    		}
	    		ku.setScpb(1);
				kudao.merge(ku);
	    	}catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			}finally{
				 trans.commit();
		         session.flush();
		         session.clear();
		         session.close();
			}
		}
		else
		{
			message = "导入失败，请确认文件名是否符合规范。";
		}
		processKqjlDailyPbtime(yearmonth);
		return "success";
	}
	/**
	 * 生产和响应排班表导入后，判断是否重复，导入KqjlDaily中。
	 * @return
	 */
	public String processKqjlDailyPbtime(String month)
	{
		String message = "";
		String sql = "";
		KqjlUploadDAO kudao = new KqjlUploadDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		ScpbUploadDAO sudao = new ScpbUploadDAO();
		YgpbUploadDAO yudao = new YgpbUploadDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		KqjlUpload ku = kudao.findAllByMonth(month);
    		if(ku.getScpb()==1&&ku.getXypb()==1)//生产和响应都导入的情况，计算
    		{
    			//判重
    			sql = "select new office.kqjl.bean.DateName(sc.date,sc.name) from ScpbUpload sc,YgpbUpload yg where sc.date=yg.date and sc.name=yg.name";
    			List list = session.createQuery(sql).list();
    			if(!list.isEmpty())//有重复
    			{
    				message = "失败,生产人员排班表与员工响应排班表发现重复人员：";
    				for(int i=0;i<list.size();i++)
    				{
    					DateName dn = (DateName) list.get(i);
    					message+=dn.getDate();
    					message+="-";
    					message+=dn.getName();
    					message+="、";
    				}
    			}
//    			else//无重复
//    			{
////    				sql = "delete from t_kqjl_daily where date>='"+month+"01' and date<='"+month+"31'";
////            		session.createSQLQuery(sql).executeUpdate();
//            		sql = "update t_kqjl_upload set kqjl1=0,kqjl2=0,kqjl3=0,kqjl4=0 where month='"+month+"'";
//            		session.createSQLQuery(sql).executeUpdate();
//            		List listsc = sudao.findAll();
//            		List listyg = yudao.findAll();
//            		for(int i=0;i<listsc.size();i++)
//            		{
//            			ScpbUpload su = (ScpbUpload) listsc.get(i);
//            			KqjlDaily kd = kddao.findByDateAndName(su.getDate(),su.getName());
//            			kd.setPbqdtime(su.getPbqdtime());
//            			kd.setPbqttime(su.getPbqttime());
//            			kd.setPb(1);
//            			kd.setTb(su.getTb());
//            			kddao.merge(kd);
//            		}
//            		for(int i=0;i<listyg.size();i++)
//            		{
//            			YgpbUpload yu = (YgpbUpload) listyg.get(i);
//            			KqjlDaily kd = kddao.findByDateAndName(yu.getDate(),yu.getName());
//            			kd.setPbqdtime(yu.getPbqdtime());
//            			kd.setPbqttime(yu.getPbqttime());
//            			kd.setPb(1);
//            			kd.setTb(yu.getTb());
//            			kddao.merge(kd);
//            		}
//    			}
    			
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
		return message;
	}
	/**
	 *  原计算方法（适用于无排班功能）
	 *  计算全员（包括员工响应、业务处理、生产管理、综合管理）
	 * 计算考勤记录日表
	 * @return
	 */
	public String countKqjlDaily()
	{
		String date = "";
		String yearmonth = "";
		MyCalendarDAO mcdao = new MyCalendarDAO();
		KqjlImportDAO kidao = new KqjlImportDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		ConfigDAO cfdao = new ConfigDAO();
		ScpbUploadDAO sudao = new ScpbUploadDAO();
		YgpbUploadDAO yudao = new YgpbUploadDAO();
		ImportKqjlMetho ikm = new ImportKqjlMetho();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		
    		List<KqjlImport> listki = kidao.findAll();
    		date = listki.get(0).getDate();
    		yearmonth = date.substring(0, 6);
    		String buru = cfdao.findAllByName("buru").getStrvalue();
    		String sql = "delete from t_kqjl_daily where date>='"+yearmonth+"01' and date<='"+yearmonth+"31'";
    		session.createSQLQuery(sql).executeUpdate();
    		sql = "update t_kqjl_upload set kqjl1=0,kqjl2=0,kqjl3=0,kqjl4=0 where month='"+yearmonth+"'";
    		session.createSQLQuery(sql).executeUpdate();
    		List<MyCalendar> listmcrest = mcdao.findByBeginAndEnd(yearmonth+Util.beginday,yearmonth+Util.endday,0);//当月所有非工作日
    		List<MyCalendar> listmcwork = mcdao.findByBeginAndEnd(yearmonth+Util.beginday,yearmonth+Util.endday,1);//当月所有工作日
    		List<MyCalendar> listmc = mcdao.findByBeginAndEnd(yearmonth+Util.beginday,yearmonth+Util.endday,2);//所有天数
    		List<UserInfo> listui = uidao.findAllDaKaYuanGong();//查询所有打考勤人员
//    		List<UserInfo> listuisc = uidao.findAllForPb();//查询所有打考勤人员(排班人员)
//    		List<UserInfo> listuixy = uidao.findAllForYgxy();//查询所有打考勤人员(员工响应)
//    		List<UserInfo> listuifsc = uidao.findAllDaKaYuanGong();//查询所有打考勤人员（其他人员）
//    		listuifsc.removeAll(listuisc);
//    		listuifsc.removeAll(listuixy);
    		//List<UserInfo> listui = uidao.findAllByNames();
    		//List<UserInfo> listui = uidao.findAllByPosition("301D0");
    		for(int j=0;j<listui.size();j++)//循环所有应该打卡记录的人
			{
    				UserInfo ui = listui.get(j);
    				String position = ui.getPosition();
        			List<KqjlDaily> listpb = kddao.findAllByPb(yearmonth, ui.getUsername());
        			List<ScpbUpload> listsu = sudao.findAllByName(ui.getUsername(),yearmonth);
        			List<YgpbUpload> listyu = yudao.findAllByName(ui.getUsername(),yearmonth);
        			if(listsu.isEmpty()&&listyu.isEmpty())//无排班（包括生产人员非排班月和其他人员）
        			{
        				for(int i=0;i<listmcwork.size();i++)//循环所有工作日
        				{
        					MyCalendar mc = listmcwork.get(i);
        					System.out.println(mc.getDate()+ui.getUsername());
        					KqjlDaily kd = ikm.methoForGZR(mc,ui,buru);
    						kddao.merge(kd);
        				}
        				for(int i=0;i<listmcrest.size();i++)//循环所有非工作日
        				{
        					MyCalendar mc = listmcrest.get(i);
        					System.out.println(mc.getDate()+ui.getUsername());
        					KqjlDaily kd = ikm.methoForFGZR(mc,ui);
        					kddao.merge(kd);
        				}
        			}
        			else//当月有排班（包括生产人员排班月和员工响应）
        			{
        				for(int i=0;i<listmc.size();i++)//循环当月所有日期
        				{
        					MyCalendar mc = listmc.get(i);
        					System.out.println(mc.getDate()+ui.getUsername());
        					KqjlDaily kd = ikm.methoForPB(mc,ui,buru);
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
		return "";
	}
	/**
	 *  新计算方法（适用于有排班功能）
	 *  计算全员（包括员工响应、业务处理、生产管理、综合管理）
	 * 计算考勤记录日表
	 * @return
	 */
	public String countKqjlDailyNew(String yearmonth)
	{
		String date = "";
		//String yearmonth = "";
		String buru = "";
		MyCalendarDAO mcdao = new MyCalendarDAO();
		KqjlImportDAO kidao = new KqjlImportDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		PbMxDAO pmdao = new PbMxDAO();
		//ConfigDAO cfdao = new ConfigDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		PbTeshuDAO ptdao = new PbTeshuDAO();
		ImportKqjlMetho ikm = new ImportKqjlMetho();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		
    		List<KqjlImport> listki = kidao.findAll();
    		date = listki.get(0).getDate();
    		//yearmonth = date.substring(0, 6);
    		//String buru = cfdao.findAllByName("buru").getStrvalue();
    		String sql = "delete from t_kqjl_daily where date>='"+yearmonth+"01' and date<='"+yearmonth+"31'";
    		session.createSQLQuery(sql).executeUpdate();
    		sql = "update t_kqjl_upload set kqjl1=0,kqjl2=0,kqjl3=0,kqjl4=0 where month='"+yearmonth+"'";
    		session.createSQLQuery(sql).executeUpdate();
    		List<MyCalendar> listmcrest = mcdao.findByBeginAndEnd(yearmonth+Util.beginday,yearmonth+Util.endday,0);//当月所有非工作日
    		List<MyCalendar> listmcwork = mcdao.findByBeginAndEnd(yearmonth+Util.beginday,yearmonth+Util.endday,1);//当月所有工作日
    		List<MyCalendar> listmc = mcdao.findByBeginAndEnd(yearmonth+Util.beginday,yearmonth+Util.endday,2);//所有天数
    		List<UserInfo> listui = uidao.findAllDaKaYuanGong();//查询所有算考勤人员
    		
    		List<UserInfo> listuisc = uidao.findAllForPb(yearmonth);//查询所有打考勤人员(排班人员)
    		//List<UserInfo> listuisc = uidao.findAllByNameList("黄梦芊");
    		List<UserInfo> listuixy = uidao.findAllForYgxy();//查询所有打考勤人员(员工响应)
    		List<UserInfo> listuixmz = uidao.findAllForXMZ();//查询所有打考勤人员(项目组)
    		List<UserInfo> listuiqita = uidao.findAllDaKaYuanGong();//查询所有打考勤人员（其他人员）
    		listuiqita.removeAll(listuisc);
    		listuiqita.removeAll(listuixy);
    		listuiqita.removeAll(listuixmz);
    		for(int j=0;j<listmc.size();j++)
			{
    			for(int i=0;i<listuisc.size();i++)//排班人员
        		{
        			UserInfo ui = listuisc.get(i);
        			MyCalendar mc = listmc.get(j);
    				PbTeshu pt = ptdao.findAllBy(ui.getUsername(),mc.getDate(),1);//查询哺乳假
    				List<LeavePage> listburu = lpdao.findAllByDateAndType(ui.getNewnumber(),date, 14);//查询哺乳假
    				PbMx pm = pmdao.findAllByNameAndDateNull(ui.getUsername(),mc.getDate());
    				if(!listburu.isEmpty()||pt!=null)
    				{
    					buru = ui.getUsername();
    				}
    				if((pm==null)&&(mc.getWorkday()==1))//没有排班，但是是工作日
    				{
    					KqjlDaily kd = ikm.methoForGZR(mc,ui,buru);
    					kddao.merge(kd);
    				}
    				if(((pm!=null)&&(pm.getPlan()!=null)&&(pm.getPlan()!=0))||((pm!=null)&&(pm.getPlan()==null)))//有排班
    				{
    					KqjlDaily kd =  ikm.methoForYPB(mc,ui,buru);
    					kddao.merge(kd);
    				}
        		}
			}
    		for(int j=0;j<listuixmz.size();j++)//循环所有项目组的人
			{
    			UserInfo ui = listuixmz.get(j);
    			for(int i=0;i<listmcwork.size();i++)//循环所有工作日
				{
					MyCalendar mc = listmcwork.get(i);
					System.out.println(mc.getDate()+ui.getUsername());
					KqjlDaily kd = ikm.methoForXMZ(mc,ui);
					kddao.merge(kd);
				}
			}
    		for(int j=0;j<listuiqita.size();j++)//循环所有其他
			{
    				UserInfo ui = listuiqita.get(j);
        			for(int i=0;i<listmcwork.size();i++)//循环所有工作日
    				{
    					MyCalendar mc = listmcwork.get(i);
    					PbTeshu pt = ptdao.findAllBy(ui.getUsername(),mc.getDate(),1);//查询哺乳假
        				List<LeavePage> listburu = lpdao.findAllByDateAndType(ui.getNewnumber(),date, 14);//查询哺乳假
        				if(!listburu.isEmpty()||pt!=null)
        				{
        					buru = ui.getUsername();
        				}
    					System.out.println(mc.getDate()+ui.getUsername());
    					KqjlDaily kd = ikm.methoForGZR(mc,ui,buru);
						kddao.merge(kd);
    				}
    				for(int i=0;i<listmcrest.size();i++)//循环所有非工作日
    				{
    					MyCalendar mc = listmcrest.get(i);
    					System.out.println(mc.getDate()+ui.getUsername());
    					KqjlDaily kd = ikm.methoForFGZR(mc,ui);
    					kddao.merge(kd);
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
		return "";
	}
	
	
	/**
	 *  计算全员考勤记录月表
	 * @return
	 */
	public String countkqjlMonth(Session session,String yearmonth)
	{
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		KqjlImportDAO kidao = new KqjlImportDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		MyCalendarDAO mcdao = new MyCalendarDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		//String yearmonth = "";
    		List<UserInfo> listui = uidao.findAllDaKaYuanGong();//查询所有打考勤人员
    		List<KqjlImport> listki = kidao.findAll();
    		//yearmonth = listki.get(0).getDate().substring(0, 6);
    		String sql = "delete from t_kqjl_month where month='"+yearmonth+"'";
    		session.createSQLQuery(sql).executeUpdate();
    		for(int i=0;i<listui.size();i++)//循环所有应该打卡记录的人
			{
    			UserInfo ui = listui.get(i);
    			String position = ui.getPosition();
    			KqjlMonth km = kmdao.findAllByMonthAndName(ui.getUsername(), yearmonth);
    			//List<MyCalendar> listmcwork = mcdao.findByBeginAndEnd(yearmonth+"01",yearmonth+Util.endday,1);
    			//List<KqjlDaily> listkd = kddao.findAllByMonthAndName(yearmonth, ui.getUsername());
    			km.setNewnumber(ui.getNewnumber());
    			km.setPosition(position);
    			countKqjlBesic(km,session,ui,yearmonth);
			}
		return "";
	}
	/**
	 * 计算指定人的考勤记录月表
	 * @param session
	 * @param id
	 * @return
	 */
	public String countkqjlMonthById(Session session,int id)
	{
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		KqjlMonth km = kmdao.findAllById(id);
		UserInfo ui = uidao.findByName(km.getName());
		String position = ui.getPosition();
		String yearmonth = km.getMonth();
		km.setNewnumber(ui.getNewnumber());
		km.setPosition(position);
		countKqjlBesic(km,session,ui,yearmonth);		
		return "";
	}
	/**
	 * 计算指定人的考勤记录月表
	 * @param session
	 * @param name
	 * @param month
	 * @return
	 */
	public String countkqjlMonthByName(Session session,String name,String yearmonth)
	{
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByName(name);
		String position = ui.getPosition();
		KqjlMonth km = kmdao.findAllByMonthAndName(ui.getUsername(), yearmonth);
		km.setNewnumber(ui.getNewnumber());
		km.setPosition(position);
		countKqjlBesic(km,session,ui,yearmonth);		
		return "";
	}
	/**
	 * 计算指定人的考勤记录月表
	 * 如果不存在，则不计算
	 * @param session
	 * @param name
	 * @param month
	 * @return
	 */
	public String countkqjlMonthByNameNull(Session session,String name,String yearmonth)
	{
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = uidao.findByName(name);
		String position = ui.getPosition();
		KqjlMonth km = kmdao.findAllByMonthAndNameNull(ui.getUsername(), yearmonth);
		if(km!=null)
		{
			km.setNewnumber(ui.getNewnumber());
			km.setPosition(position);
			countKqjlBesic(km,session,ui,yearmonth);		
		}
		return "";
	}
	
	/**
	 * 传入session<br/>
	 * 根据传入的position更新指定团队的月表<br/>
	 * 例：30303 更新业务处理3组<br/>
	 *&nbsp;&nbsp;&nbsp;&nbsp;3030_更新业务处理人员<br/>
	 *&nbsp;&nbsp;&nbsp; __4__更新员工响应
	 * @param session
	 * @param position
	 * @return
	 */
	public String countkqjlMonthByTeam(Session session,String team)
	{
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		KqjlImportDAO kidao = new KqjlImportDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		MyCalendarDAO mcdao = new MyCalendarDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		String yearmonth = "";
		List<UserInfo> listui = uidao.findAllDaKaYuanGongByTeam(team);//查询所有打考勤人员
		List<KqjlImport> listki = kidao.findAll();
		yearmonth = listki.get(0).getDate().substring(0, 6);
		for(int i=0;i<listui.size();i++)//循环所有应该打卡记录的人
		{
			UserInfo ui = listui.get(i);
			String position = ui.getPosition();
			
			KqjlMonth km = kmdao.findAllByMonthAndName(ui.getUsername(), yearmonth);
			List<MyCalendar> listmcwork = mcdao.findByBeginAndEnd(yearmonth+"01",yearmonth+Util.endday,1);
			List<KqjlDaily> listkd = kddao.findAllByMonthAndName(yearmonth, ui.getUsername());
			km.setNewnumber(ui.getNewnumber());
			km.setPosition(position);
			countKqjlBesic(km,session,ui,yearmonth);
		}	
		return "";
	}
	
	public String countKqjlBesic(KqjlMonth km,Session session,UserInfo ui,String yearmonth)
	{
		String tempsql = "";
		String beginday = "01";
		String endday = "21";
		double bing=0;
		double bingkou=0;
		double bingbu=0;
		double shi=0;
		double shikou=0;
		double shibu=0;
		LeavePageDAO lpdao = new LeavePageDAO();
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and pbqdtime>'00:00:00'";
		double workdays = Double.parseDouble(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setWorkdays(workdays);//应工作天数(从排班表获取)
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qdqs=2";
		int chidao = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setChidao(chidao);//迟到次数
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qtqs=2";
		int zaotui = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setZaotui(zaotui);//早退次数
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qdqs=1";
		int qdqs = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setQdqs(qdqs);//签到缺失次数
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qtqs=1";
		int qtqs = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setQtqs(qtqs);//签退缺失次数
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qdtime>'00:00:00' and qdqs=0";
		int zcqd = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qttime>'00:00:00' and qtqs=0";
		int zcqt = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setZhiwendays((double)zcqd/2+(double)zcqt/2);//指纹天数
//		tempsql = "select count(*) from t_kqqs_page where applicant='"+ui.getNewnumber()+"' and status in (3,4,7) and qsdate>='"+yearmonth+Util.beginday+"' and qsdate<='"+yearmonth+Util.endday+"'";
//		int bucs = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
//		km.setBukq(bucs);//补考勤次数
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qdqs=3";
		int buqdcs = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qtqs=3";
		int buqtcs = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setBukq(buqdcs+buqtcs);//补考勤次数(不含打了考勤又填缺失的)
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qdqs=4";
		int qjqd = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qtqs=4";
		int qjqt = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setQjdays((double)qjqd/2+(double)qjqt/2);//请假总天数
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qdqs=5";
		int ggqd = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and qtqs=5";
		int ggqt = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setGgdays((double)ggqd/2+(double)ggqt/2);//公干总天数
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and jb>0 and halfday=0";
		int jbwz = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		tempsql = "select count(*) from t_kqjl_daily where name='"+ui.getUsername()+"' and date>='"+yearmonth+Util.beginday+"' and date<='"+yearmonth+Util.endday+"' and jb>0 and halfday>0";
		int jbbwz = Integer.parseInt(session.createSQLQuery(tempsql).uniqueResult().toString());
		km.setJbdays((double)jbwz+(double)jbbwz/2);//加班总天数
		km.setYearleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 2));//年假
		km.setWorkleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 11));//加班调休
		bing = kddao.findDaysByQjType(yearmonth, ui.getUsername(), 1);
		if(bing>3)//如果病假大于三天，有三天不扣减工资
		{
			bingbu = 3;
			bingkou = bing-3;
		}
		else
		{
			bingbu = bing;
			bingkou = 0;
		}
		km.setBingleavebu(bingbu);
		km.setBingleavekou(bingkou);
		shi = kddao.findDaysByQjType(yearmonth, ui.getUsername(), 3);
		shibu = lpdao.findShiBUKOUByDateAndType(ui.getNewnumber(), yearmonth);
		shibu = shibu>1?1:shibu;
		shikou = shi-shibu;
		shikou = shikou>0?shikou:0;
		km.setShileavebu(shibu);
		km.setShileavekou(shikou);
		//km.setBingleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 1));//病假
		//km.setShileave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 3));//事假
		km.setHunleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 4));//婚假
		km.setChanleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 5));//产假
		km.setTanpoleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 6));//探配偶
		km.setTanfmleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 7));//探父母
		km.setSangleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 8));//丧假
		km.setShangleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 9));//工伤假
		km.setGongleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 10));//公假
		km.setChanjianleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 12));//产检
		km.setPeikaoleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 13));//陪考假
		km.setBuruleave(kddao.findDaysByQjType(yearmonth, ui.getUsername(), 14));//哺乳假
		kmdao.merge(km);
		return "";
	}
}
