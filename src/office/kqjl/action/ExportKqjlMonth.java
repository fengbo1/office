package office.kqjl.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.kqjl.bean.KqjlDailyBean;
import office.kqjl.bean.KqjlMonthBean;
import office.kqjl.bean.KqjlMonthZuzhangBean;
import office.kqjl.dao.KqjlMonthDAO;
import office.kqjl.pojo.KqjlDaily;
import office.kqjl.pojo.KqjlMonth;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.ExportExcel;
import office.util.UserUtil;
import office.util.Util;

/**
 * 考勤管理员下载
 * @author htzx
 *
 */
public class ExportKqjlMonth {

	private String newnumber;
	private String year;
	private String month;
	private String Path;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception{
		String filePath = "";
		String hql = "";
		UserInfoDAO uidao = new UserInfoDAO();
		KqjlMonthDAO kmdao = new KqjlMonthDAO();
		List<KqjlMonth> list;
		List<KqjlMonthBean> kmblist = new ArrayList<KqjlMonthBean>();
		ExportExcel<KqjlMonthBean> ex = new ExportExcel<KqjlMonthBean>();
		String[] headers = {"姓名","处室团队","来源","应出勤天数",
				"指纹记录出勤天数","迟到/早退次数","补考勤次数",
				"事假不扣","事假扣","年假已请天数","公干天数",
				"加班调休天数","产/陪护假天数","病假不扣","病假扣",
				"婚假天数","探亲假天数","丧假天数","工伤假天数",
				"公假天数","产检天数","陪考假天数","哺乳假天数","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		hql = "from KqjlMonth as km where km.month='"+month+"' order by km.position";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		for(int i=0;i<list.size();i++)
		{
			KqjlMonth km = list.get(i);
			KqjlMonthBean kmb = new KqjlMonthBean();
			kmb.setName(km.getName());
			kmb.setChu(UserUtil.positionToName(km.getPosition()));
			kmb.setLaiyuan("工具导出");
			kmb.setWorkdays(String.valueOf(km.getWorkdays()));
			kmb.setZhiwendays(String.valueOf(km.getZhiwendays()));
			kmb.setGgdays(String.valueOf(km.getGgdays()));
			kmb.setChidaozaotui(String.valueOf(km.getChidao()+km.getZaotui()));
			kmb.setBukq(String.valueOf(km.getBukq()));
			kmb.setYearleave(String.valueOf(km.getYearleave()));
			kmb.setWorkleave(String.valueOf(km.getWorkleave()));
			//kmb.setBingleave(String.valueOf(km.getBingleave()));
			kmb.setBingbuleave(String.valueOf(km.getBingleavebu()));
			kmb.setBingkouleave(String.valueOf(km.getBingleavekou()));
			//kmb.setShileave(String.valueOf(km.getShileave()));
			kmb.setShibuleave(String.valueOf(km.getShileavebu()));
			kmb.setShikouleave(String.valueOf(km.getShileavekou()));
			kmb.setHunleave(String.valueOf(km.getHunleave()));
			kmb.setChanleave(String.valueOf(km.getChanleave()));
			kmb.setTanleave(String.valueOf(km.getTanpoleave()+km.getTanfmleave()));
			kmb.setSangleave(String.valueOf(km.getSangleave()));
			kmb.setShangleave(String.valueOf(km.getShangleave()));
			kmb.setGongleave(String.valueOf(km.getGongleave()));
			kmb.setChanjianleave(String.valueOf(km.getChanjianleave()));
			kmb.setPeikaoleave(String.valueOf(km.getPeikaoleave()));
			kmb.setBuruleave(String.valueOf(km.getBuruleave()));
			kmb.setRemark("");
			kmblist.add(kmb);
			
//			KqjlMonthBean kmbqr = new KqjlMonthBean();//确认
//			kmbqr.setName(km.getName());
//			kmbqr.setChu(UserUtil.positionToName(km.getPosition()));
//			kmbqr.setLaiyuan("实际确认");
//			kmbqr.setWorkdays("");
//			kmbqr.setZhiwendays("");
//			kmbqr.setGgdays("");
//			kmbqr.setChidaozaotui("");
//			kmbqr.setBukq("");
//			kmbqr.setYearleave("");
//			kmbqr.setWorkleave("");
//			//kmbqr.setBingleave("");
//			kmbqr.setBingbuleave("");
//			kmbqr.setBingkouleave("");
//			//kmbqr.setShileave("");
//			kmbqr.setShibuleave("");
//			kmbqr.setShikouleave("");
//			kmbqr.setHunleave("");
//			kmbqr.setChanleave("");
//			kmbqr.setTanleave("");
//			kmbqr.setSangleave("");
//			kmbqr.setShangleave("");
//			kmbqr.setGongleave("");
//			kmbqr.setChanjianleave("");
//			kmbqr.setPeikaoleave("");
//			kmbqr.setBuruleave("");
//			kmbqr.setRemark("");
//			kmblist.add(kmbqr);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+month+"kqjldaily.xls";
				Path = month+"kqjldaily.xls";
				OutputStream out = new FileOutputStream(filePath);
				// 声明一个工作薄
		        HSSFWorkbook workbook = new HSSFWorkbook();
		        // 生成一个表格
		        HSSFSheet sheet = workbook.createSheet("考勤月报表");
		        // 设置表格默认列宽度为15个字节
		        sheet.setDefaultColumnWidth((short)3);
		        
		        sheet.setColumnWidth(1,2400);
		        sheet.setColumnWidth(2,2400);
		        sheet.setColumnWidth(23,2400);
		        // 生成一个样式
		        HSSFCellStyle styletitle = workbook.createCellStyle();//标题样式
		        
		        HSSFCellStyle styleremark = workbook.createCellStyle();//注释样式
		        //设置标题样式
		        styletitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        styletitle.setAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        // 生成一个字体
		        HSSFFont fonttitle = workbook.createFont();
		        fonttitle.setFontHeightInPoints((short) 20);
		        fonttitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		        // 把字体应用到当前的样式
		        styletitle.setFont(fonttitle);
		        // 设置表头
		        HSSFCellStyle stylehead = workbook.createCellStyle();//表头样式
		        stylehead.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		        stylehead.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		        stylehead.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		        stylehead.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		        stylehead.setBorderRight(HSSFCellStyle.BORDER_THIN);
		        stylehead.setBorderTop(HSSFCellStyle.BORDER_THIN);
		        stylehead.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        stylehead.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        stylehead.setWrapText(true);
		        // 生成一个字体
		        HSSFFont fonthead = workbook.createFont();
		        //fonthead.setColor(HSSFColor.VIOLET.index);
		        fonthead.setFontHeightInPoints((short)9);
		        fonthead.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		        // 把字体应用到当前的样式
		        stylehead.setFont(fonthead);
		        // 设置注释
		        styleremark.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		        styleremark.setAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        // 生成一个字体
		        HSSFFont fontremark = workbook.createFont();
		        fontremark.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		        // 把字体应用到当前的样式
		        styleremark.setFont(fontremark);
		        // 生成并设置另一个样式
		        HSSFCellStyle stylecontent = workbook.createCellStyle();
		        stylecontent.setFillForegroundColor(HSSFColor.WHITE.index);
		        stylecontent.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		        stylecontent.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		        stylecontent.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		        stylecontent.setBorderRight(HSSFCellStyle.BORDER_THIN);
		        stylecontent.setBorderTop(HSSFCellStyle.BORDER_THIN);
		        stylecontent.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        stylecontent.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        stylecontent.setWrapText(true);
		        //stylecontent.setLocked(true);
		        // 生成另一个字体
		        HSSFFont fontcontent = workbook.createFont();
		        fontcontent.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		        // 把字体应用到当前的样式
		        stylecontent.setFont(fontcontent);

		        // 生成并设置另一个样式，带深色底纹的背景 
		        HSSFCellStyle stylecontent2 = workbook.createCellStyle();
		        stylecontent2.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		        stylecontent2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		        stylecontent2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		        stylecontent2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		        stylecontent2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		        stylecontent2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		        stylecontent2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		        stylecontent2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		        stylecontent2.setWrapText(true);
		        // 把字体应用到当前的样式
		        stylecontent2.setFont(fontcontent);
		        // 声明一个画图的顶级管理器
		        //HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		        // 定义注释的大小和位置,详见文档
		        //HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,0, 0, 0, (short) 4, 2, (short) 6, 5));
		        // 设置注释内容
		        //comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		        //comment.setAuthor("leno");

		        //第一行title
		        HSSFRow row = sheet.createRow(0);
		        HSSFCell celltitle = row.createCell(8);
		        //sheet.addMergedRegion(new Region(0,(short)0,0,(short)17));//合并单元格 
		        celltitle.setCellStyle(styletitle);
		        celltitle.setCellValue(new HSSFRichTextString("考勤月报（"+month.substring(0, 4)+"年"+month.substring(4, 6)+"月）"));
		        //第二行填写处室
		        row = sheet.createRow(1);
		        HSSFCell cellremark = row.createCell(0);
		        cellremark.setCellStyle(styleremark);
		        cellremark.setCellValue("处室：");
		        // 产生表格标题行
		        row = sheet.createRow(2);
		        for (short i = 0; i < headers.length; i++) {
		            @SuppressWarnings("deprecation")
		           // HSSFCell cell = row.createCell((short) (celln + 1));   
					HSSFCell cell = row.createCell(i);
		            cell.setCellStyle(stylehead);
		            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
		            cell.setCellValue(text);
		        }
		        //begin row,begin col,end row,end col//合并单元格
		        //sheet.addMergedRegion(new Region(0,(short)0,0,(short)5));   
		        // 遍历集合数据，产生数据行
		        int size = kmblist.size();
		        for(int i=0;i<size;i++)
		        {
		        	KqjlMonthBean kmb = kmblist.get(i);
		        	row = sheet.createRow(i+3);
		        	Field[] fields = kmb.getClass().getDeclaredFields();
		        	int k=fields.length;
		        	for(int j=0;j<k;j++)
		        	{
		        		HSSFCell cell = row.createCell(j);
		        		
		        		Field field = fields[j];
		        		String fieldName = field.getName();
		        		String getMethodName = "get"
	                        + fieldName.substring(0, 1).toUpperCase()
	                        + fieldName.substring(1);
		        		try {
		        			Class tCls = kmb.getClass();
		        			Method getMethod = tCls.getMethod(getMethodName,
		                            new Class[] {});
		        			String value = getMethod.invoke(kmb,new Object[]{}).toString();
		        			System.out.println(value);
		        			cell.setCellStyle(stylecontent);
		        			if("chidaozaotui".equals(fieldName)&&!value.equals(""))//扣钱涂色
		        			{
		        				int cz = Integer.valueOf(value);
		        				if(cz>2)
		        				{
		        					cell.setCellStyle(stylecontent2);
		        				}
		        			}
		        			if(!value.equals("")&&(fieldName.equals("shikouleave")||fieldName.equals("chanleave")||fieldName.equals("bingkouleave")||fieldName.equals("tanleave")))
		        			{
		        				double czd = Double.parseDouble(value);
		        				if(czd>0)
		        				{
		        					cell.setCellStyle(stylecontent2);
		        				}
		        			}
		        			if(value.equals("0")||value.equals("0.0"))
		        			{
		        				value = "-";
		        			}
		        			cell.setCellValue(value);
		        			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		        		} catch (SecurityException e) {
		                    // TODO Auto-generated catch block
		                	 System.out.println("first i="+i);
		                    e.printStackTrace();
		                   
		                } catch (NoSuchMethodException e) {
		                    // TODO Auto-generated catch block
		                	 System.out.println("2 i="+i);
		                    e.printStackTrace();
		                   
		                }  finally {
		                    // 清理资源
		                }
		        	}
		        }
		        //表未备注
		        row = sheet.createRow(size+5);
		        HSSFCell cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("制表人签字：");
		        HSSFCell cellremarkend2 = row.createCell(12);
		        cellremarkend2.setCellStyle(styleremark);
		        cellremarkend2.setCellValue("处室确认签字：");
		        //两两合并单元格
//		        for(int i=0;i<(size/2);i++)
//		        {
//		        	sheet.addMergedRegion(new Region(i*2+3,(short)0,i*2+4,(short)0));
//		        	sheet.addMergedRegion(new Region(i*2+3,(short)1,i*2+4,(short)1));
//		        	sheet.addMergedRegion(new Region(i*2+3,(short)23,i*2+4,(short)23));
//		        }
		        try {
		            workbook.write(out);
		        } catch (IOException e) {
		        	System.out.println("100 i=");
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
				
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
