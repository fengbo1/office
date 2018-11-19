package office.uass.action;

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
import office.uass.dao.UassCostHnDAO;
import office.uass.pojo.UassChpBean;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostHnPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.LeaveUtil;
import office.util.UassUtil;
import office.util.Util;

public class UschExportExcel {

	private String Path;
	private String number;
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String execute() throws Exception{
		String filePath = "";
		String hql = "";
		int index =0;
		String date = number.substring(0, 8);
		UassCostHnDAO uchdao = new UassCostHnDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UassUtil uu = new UassUtil();
		List<UassCostHnPeople> list;
		List<UassChpBean> listucb = new ArrayList<UassChpBean>();
		String[] headers1 = {"序号","是否外包（0否/1是）","外包公司信息",
				"维护类型（新增/修改/注销）","所属机构代码","员工编号",
				"用户名称","证件类型（居民身份证1010/护照/中国护照/其他证件...）",
				"证件号码","用户认证方式（UAAP认证/指纹认证/特殊人群认证）","",
				"操作员状态（生效/注销/锁定）","","角色变更内容（角色代码详见附件1）",
				"","","","生效日期","备注"};
		String[] headers2 = {"","","","","","","","","",
				"变更前","变更后","变更前","变更后","角色代码","","角色名称","","",""};
		String[] headers3 = {"","","","","","","","","","","","","",
				"变更前","变更后","变更前","变更后","",""};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		hql="from UassCostHnPeople as uc where uc.number='"+number+"'";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		for(int i=0;i<list.size();i++)
		{
			UassCostHnPeople uc = list.get(i);
			UassCostHn uch = uchdao.findAllByNumber(uc.getNumber());
			UserInfo ui = uidao.findByName(uc.getName());
			if(ui!=null)
			{
				if(uc.getPool().contains("890"))
				{
					index+=1;
					UassChpBean ucb = new UassChpBean();
					ucb.setId(String.valueOf(index));
					ucb.setIfwb("0否");
					ucb.setWbinfo("");
					ucb.setType(uu.typeToString(uc.getType890()));
					ucb.setJgnum("010000890");
					ucb.setNewnumber(ui.getNewnumber());
					ucb.setName(uc.getName());
					ucb.setIdtype("1010");
					ucb.setIdnum(ui.getIdentity().toUpperCase());
					ucb.setRzfsbf("4");
					ucb.setRzfsaf("");
					ucb.setCzztbf("1");
					ucb.setCzztaf("");
					ucb.setRemark("");
					if(uc.getType890()==2)//修改
					{
						ucb.setCodebf(uu.codeToString(uc.getItem890bf(), "890"));
						ucb.setCodeaf(uu.codeToString(uc.getItem890af(), "890"));
						ucb.setContbf(uu.codeToStringDetail(uc.getItem890bf(), "890"));
						ucb.setContaf(uu.codeToStringDetail(uc.getItem890af(), "890"));
					}
					else if(uc.getType890()==1)//注销
					{
						if(uc.getItem890bf().startsWith("01"))//注销转生效
						{
							ucb.setCodeaf(uu.codeToString(uc.getItem890af(), "890"));
							ucb.setContaf(uu.codeToStringDetail(uc.getItem890af(), "890"));
							ucb.setCodebf("");
							ucb.setContbf("");
							ucb.setType("修改");
							ucb.setRemark("注销转生效");
						}
						else//注销
						{
							ucb.setCodeaf(uu.codeToString(uc.getItem890af(), "890"));
							ucb.setContaf(uu.codeToStringDetail(uc.getItem890af(), "890"));
							ucb.setCodebf("");
							ucb.setContbf("");
							ucb.setType("注销");
						}	
					}
					else if(uc.getType890()==3)//新增
					{
						ucb.setCodeaf(uu.codeToString(uc.getItem890af(), "890"));
						ucb.setContaf(uu.codeToStringDetail(uc.getItem890af(), "890"));
						ucb.setCodebf("");
						ucb.setContbf("");
					}
					ucb.setSxtime(uch.getSxtime());
					//ucb.setRemark("");
					listucb.add(ucb);
				}
				if(uc.getPool().contains("891"))
				{
					index+=1;
					UassChpBean ucb = new UassChpBean();
					ucb.setId(String.valueOf(index));
					ucb.setIfwb("0否");
					ucb.setWbinfo("");
					ucb.setType(uu.typeToString(uc.getType891()));
					ucb.setJgnum("010000891");
					ucb.setNewnumber(ui.getNewnumber());
					ucb.setName(uc.getName());
					ucb.setIdtype("1010");
					ucb.setIdnum(ui.getIdentity().toUpperCase());
					ucb.setRzfsbf("4");
					ucb.setRzfsaf("");
					ucb.setCzztbf("1");
					ucb.setCzztaf("");
					ucb.setRemark("");
					if(uc.getType891()==2)//修改
					{
						ucb.setCodebf(uu.codeToString(uc.getItem891bf(), "891"));
						ucb.setCodeaf(uu.codeToString(uc.getItem891af(), "891"));
						ucb.setContbf(uu.codeToStringDetail(uc.getItem891bf(), "891"));
						ucb.setContaf(uu.codeToStringDetail(uc.getItem891af(), "891"));
					}
					else if(uc.getType891()==1)//注销
					{
						if(uc.getItem891bf().startsWith("01"))//注销转生效
						{
							ucb.setCodeaf(uu.codeToString(uc.getItem891af(), "891"));
							ucb.setContaf(uu.codeToStringDetail(uc.getItem891af(), "891"));
							ucb.setCodebf("");
							ucb.setContbf("");
							ucb.setType("修改");
							ucb.setRemark("注销转生效");
						}
						else//注销
						{
							ucb.setCodeaf(uu.codeToString(uc.getItem891af(), "891"));
							ucb.setContaf(uu.codeToStringDetail(uc.getItem891af(), "891"));
							ucb.setCodebf("");
							ucb.setContbf("");
							ucb.setType("注销");
						}	
					}
					else if(uc.getType891()==3)//新增
					{
						ucb.setCodeaf(uu.codeToString(uc.getItem891af(), "891"));
						ucb.setContaf(uu.codeToStringDetail(uc.getItem891af(), "891"));
						ucb.setCodebf("");
						ucb.setContbf("");
					}
					ucb.setSxtime(uch.getSxtime());
					listucb.add(ucb);
				}
			}
			
		}
		
		//导出
		 try {
			 filePath=Util.downloadpath+number+".xls";
				Path = number+".xls";
				OutputStream out = new FileOutputStream(filePath);
				// 声明一个工作薄
		        HSSFWorkbook workbook = new HSSFWorkbook();
		        // 生成一个表格
		        HSSFSheet sheet = workbook.createSheet("平台操作员信息表");
		        // 设置表格默认列宽度为15个字节
		        sheet.setDefaultColumnWidth((short)10);
		        
		        sheet.setColumnWidth(0,800);
		        sheet.setColumnWidth(1,1200);
		        sheet.setColumnWidth(2,1200);
		        sheet.setColumnWidth(3,1200);
		        sheet.setColumnWidth(6,1200);
		        sheet.setColumnWidth(9,800);
		        sheet.setColumnWidth(10,800);
		        sheet.setColumnWidth(11,800);
		        sheet.setColumnWidth(12,800);
		        sheet.setColumnWidth(15,6000);
		        sheet.setColumnWidth(16,6000);
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
		        
		        //第一行title
		        HSSFRow row = sheet.createRow(0);
		        HSSFCell celltitle = row.createCell(9);
		        //sheet.addMergedRegion(new Region(0,(short)0,0,(short)17));//合并单元格 
		        celltitle.setCellStyle(styletitle);
		        celltitle.setCellValue(new HSSFRichTextString("平台操作员信息表"));
		        
		        //第二行填写申请机构、日期等
		        row = sheet.createRow(1);
		        HSSFCell cellremark = row.createCell(0);
		        cellremark.setCellStyle(styleremark);
		        cellremark.setCellValue("申请机构（部门）：业务处理中心成都分中心");
		        
		        HSSFCell cellremark1 = row.createCell(7);
		        cellremark1.setCellStyle(styleremark);
		        cellremark1.setCellValue("申请日期："+date);
		        
		        HSSFCell cellremark2 = row.createCell(12);
		        cellremark2.setCellStyle(styleremark);
		        cellremark2.setCellValue("申请编号：");
		        
		        // 产生表格标题行
		        row = sheet.createRow(2);
		        for (short i = 0; i < headers1.length; i++) {
		            @SuppressWarnings("deprecation")
		           // HSSFCell cell = row.createCell((short) (celln + 1));   
					HSSFCell cell = row.createCell(i);
		            cell.setCellStyle(stylehead);
		            HSSFRichTextString text = new HSSFRichTextString(headers1[i]);
		            cell.setCellValue(text);
		        }
		        
		        // 产生表格标题行
		        row = sheet.createRow(3);
		        for (short i = 0; i < headers2.length; i++) {
		            @SuppressWarnings("deprecation")
		           // HSSFCell cell = row.createCell((short) (celln + 1));   
					HSSFCell cell = row.createCell(i);
		            cell.setCellStyle(stylehead);
		            HSSFRichTextString text = new HSSFRichTextString(headers2[i]);
		            cell.setCellValue(text);
		        }
		        
		        // 产生表格标题行
		        row = sheet.createRow(4);
		        for (short i = 0; i < headers3.length; i++) {
		            @SuppressWarnings("deprecation")
		           // HSSFCell cell = row.createCell((short) (celln + 1));   
					HSSFCell cell = row.createCell(i);
		            cell.setCellStyle(stylehead);
		            HSSFRichTextString text = new HSSFRichTextString(headers3[i]);
		            cell.setCellValue(text);
		        }
		        
		        //合并单元格
		        for(int i=0;i<9;i++)
		        {
		        	sheet.addMergedRegion(new Region(2,(short)i,4,(short)i));
		        }
		        for(int i=9;i<13;i++)
		        {
		        	sheet.addMergedRegion(new Region(3,(short)i,4,(short)i));
		        }
		        sheet.addMergedRegion(new Region(2,(short)9,2,(short)10));
		        sheet.addMergedRegion(new Region(2,(short)11,2,(short)12));
		        sheet.addMergedRegion(new Region(2,(short)13,2,(short)16));
		        sheet.addMergedRegion(new Region(2,(short)17,4,(short)17));
		        sheet.addMergedRegion(new Region(2,(short)18,4,(short)18));
		        sheet.addMergedRegion(new Region(3,(short)13,3,(short)14));
		        sheet.addMergedRegion(new Region(3,(short)15,3,(short)16));
		        
		        int size = listucb.size();
		        for(int i=0;i<size;i++)
		        {
		        	UassChpBean ucb = listucb.get(i);
		        	//ucb.setId(String.valueOf(i));
		        	row = sheet.createRow(i+5);
		        	Field[] fields = ucb.getClass().getDeclaredFields();
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
		        			Class tCls = ucb.getClass();
		        			Method getMethod = tCls.getMethod(getMethodName,
		                            new Class[] {});
		        			String value = getMethod.invoke(ucb,new Object[]{}).toString();
		        			System.out.println(value);
		        			cell.setCellStyle(stylecontent);
		        			cell.setCellValue(value);
		        			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		        		} catch (SecurityException e) {
		                    // TODO Auto-generated catch block
		                	 System.out.println("first i="+i);
		                    e.printStackTrace();
			        	}catch (NoSuchMethodException e) {
		                    // TODO Auto-generated catch block
		                	 System.out.println("2 i="+i);
		                    e.printStackTrace();
		                   
		                }  finally {
		                    // 清理资源
		                }
			        }
		        }
		        row = sheet.createRow(size+5);
		        HSSFCell cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("经办：");
		        HSSFCell cellremarkend2 = row.createCell(12);
		        cellremarkend2.setCellStyle(styleremark);
		        cellremarkend2.setCellValue("复核：");
		        
		        row = sheet.createRow(size+8);
		        cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("填表说明:");
		        
		        row = sheet.createRow(size+9);
		        cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("1.本参数为总、分行维护参数");
		        
		        row = sheet.createRow(size+10);
		        cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("2.有变更前、变更后栏位的要素允许修改，维护类型为新增、注销时在变更前栏位填写，修改时需要填写变更前、后数值。");
		        
		        row = sheet.createRow(size+11);
		        cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("3.带*号的要素为必填项。");
		        
		        row = sheet.createRow(size+12);
		        cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("4.新增对公开户审批点操作员需要填写审批点机构号。");
		        
		        row = sheet.createRow(size+13);
		        cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("5.新增理财卡主卡申请角色需要填写理财卡审批点机构号");
		        
		        row = sheet.createRow(size+14);
		        cellremarkend1 = row.createCell(0);
		        cellremarkend1.setCellStyle(styleremark);
		        cellremarkend1.setCellValue("6.取消参数主管维护事项应为\"修改\"");
		        
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
