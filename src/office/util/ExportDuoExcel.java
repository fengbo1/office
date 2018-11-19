package office.util;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;


/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 
 * 
 * @author CCB
 * @version v1.0
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 */
public class ExportDuoExcel<T> {

   


   

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     * 
     * @param title
     *            表格标题名
     * @param headers
     *            表格属性列名数组
     * @param dataset
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out
     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern
     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public void exportExcel(String title, String[] headers,
            Collection<T> dataset1,Collection<T> dataset2,Collection<T> dataset3,Collection<T> dataset4,Collection<T> dataset5,Collection<T> dataset6,Collection<T> dataset7,Collection<T> dataset8,Collection<T> dataset9,Collection<T> dataset10,Collection<T> dataset11,Collection<T> dataset12, OutputStream out) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet1 = workbook.createSheet("1月");
        HSSFSheet sheet2 = workbook.createSheet("2月");
        HSSFSheet sheet3 = workbook.createSheet("3月");
        HSSFSheet sheet4 = workbook.createSheet("4月");
        HSSFSheet sheet5 = workbook.createSheet("5月");
        HSSFSheet sheet6 = workbook.createSheet("6月");
        HSSFSheet sheet7 = workbook.createSheet("7月");
        HSSFSheet sheet8 = workbook.createSheet("8月");
        HSSFSheet sheet9 = workbook.createSheet("9月");
        HSSFSheet sheet10 = workbook.createSheet("10月");
        HSSFSheet sheet11 = workbook.createSheet("11月");
        HSSFSheet sheet12 = workbook.createSheet("12月");
        // 设置表格默认列宽度为15个字节
        sheet1.setDefaultColumnWidth((short) 20);
        sheet2.setDefaultColumnWidth((short) 20);
        sheet3.setDefaultColumnWidth((short) 20);
        sheet4.setDefaultColumnWidth((short) 20);
        sheet5.setDefaultColumnWidth((short) 20);
        sheet6.setDefaultColumnWidth((short) 20);
        sheet7.setDefaultColumnWidth((short) 20);
        sheet8.setDefaultColumnWidth((short) 20);
        sheet9.setDefaultColumnWidth((short) 20);
        sheet10.setDefaultColumnWidth((short) 20);
        sheet11.setDefaultColumnWidth((short) 20);
        sheet12.setDefaultColumnWidth((short) 20);
        
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();//表头样式
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.WHITE.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);

        // 声明一个画图的顶级管理器
      

        // 产生表格标题行
        HSSFRow row1 = sheet1.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row1.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row2 = sheet2.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row2.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row3 = sheet3.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row3.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row4 = sheet4.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row4.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row5 = sheet5.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row5.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row6 = sheet6.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row6.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row7 = sheet7.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row7.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row8 = sheet8.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row8.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row9 = sheet9.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row9.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row10 = sheet10.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row10.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row11 = sheet11.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row11.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        HSSFRow row12 = sheet12.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            @SuppressWarnings("deprecation")
           // HSSFCell cell = row.createCell((short) (celln + 1));   
			HSSFCell cell = row12.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //begin row,begin col,end row,end col//合并单元格
        //sheet.addMergedRegion(new Region(0,(short)0,0,(short)5));   
        // 遍历集合数据，产生数据行
        Iterator<T> it1 = dataset1.iterator();
        int index1 = 0;
        
        while (it1.hasNext()) {
            index1++;
            row1 = sheet1.createRow(index1);
            T t = (T) it1.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row1.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index1+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it2 = dataset2.iterator();
        int index2 = 0;
        
        while (it2.hasNext()) {
            index2++;
            row2 = sheet2.createRow(index2);
            T t = (T) it2.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row2.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index2+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it3 = dataset3.iterator();
        int index3 = 0;
        
        while (it3.hasNext()) {
            index3++;
            row3 = sheet3.createRow(index3);
            T t = (T) it3.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row3.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index3+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it4 = dataset4.iterator();
        int index4 = 0;
        
        while (it4.hasNext()) {
            index4++;
            row4 = sheet4.createRow(index4);
            T t = (T) it4.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row4.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index4+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it5 = dataset5.iterator();
        int index5 = 0;
        
        while (it5.hasNext()) {
            index5++;
            row5 = sheet5.createRow(index5);
            T t = (T) it5.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row5.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index5+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it6 = dataset6.iterator();
        int index6 = 0;
        
        while (it6.hasNext()) {
            index6++;
            row6 = sheet6.createRow(index6);
            T t = (T) it6.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row6.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index6+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it7 = dataset7.iterator();
        int index7 = 0;
        
        while (it7.hasNext()) {
            index7++;
            row7 = sheet7.createRow(index7);
            T t = (T) it7.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row7.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index7+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it8 = dataset8.iterator();
        int index8 = 0;
        
        while (it8.hasNext()) {
            index8++;
            row8 = sheet8.createRow(index8);
            T t = (T) it8.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row8.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index8+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it9 = dataset9.iterator();
        int index9 = 0;
        
        while (it9.hasNext()) {
            index9++;
            row9 = sheet9.createRow(index9);
            T t = (T) it9.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row9.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    }  else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index9+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it10 = dataset10.iterator();
        int index10 = 0;
        
        while (it10.hasNext()) {
            index10++;
            row10 = sheet10.createRow(index10);
            T t = (T) it10.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row10.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index10+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it11 = dataset11.iterator();
        int index11 = 0;
        
        while (it11.hasNext()) {
            index11++;
            row11 = sheet11.createRow(index11);
            T t = (T) it11.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row11.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    }else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index11+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        
        
        Iterator<T> it12 = dataset12.iterator();
        int index12 = 0;
        
        while (it12.hasNext()) {
            index12++;
            row12 = sheet12.createRow(index12);
            T t = (T) it12.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            String tmp=t.getClass().getName();
            int j=fields.length;
            for (short i = 0; i < fields.length; i++) {
                @SuppressWarnings("deprecation")
				HSSFCell cell = row12.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                   // System.out.println("fieldName:"+fieldName);
                    //System.out.println("value:"+value);
                    if(fieldName.equals("position")||fieldName.equals("identity")||fieldName.equals("password")||fieldName.equals("newnumber"))
                    {
                    	String strValue = "";
                    	if(value!=null)
                    	{
                    		strValue = value.toString();
                    	}
                    	cell.setCellValue(strValue);
                    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    }
                    else if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }
                    else if (value instanceof Float) {
                     float fValue = (Float) value;
                     
                     cell.setCellValue(fValue);
                     }
                    else if (value instanceof Double) {
                     double dValue = (Double) value;
                     
                     cell.setCellValue(dValue);
                     }
                    else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "男";
                        if (!bValue) {
                            textValue = "女";
                        }
                    } 
                    else {
                        // 其它数据类型都当作字符串简单处理
                       if(value==null||value==""||value=="null")
                    	   textValue="";
                       else
                    	textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) 
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                         //  String strtemp = richString.getString();
                          
                        	   
//                           if(textValue.contains(".")&&!textValue.contains("%"))
//                           {
//                        	   cell.setCellValue(Double.parseDouble(textValue));
//                           }
                          if(textValue.matches("\\d+"))
                           {
                        	   cell.setCellValue(Double.parseDouble(textValue)); 
                           }
                           else
                        	   cell.setCellValue(richString);
                            
                        }
                    }
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("first i="+i);
                    e.printStackTrace();
                   
                } catch (NoSuchMethodException e) {
                    // TODO Auto-generated catch block
                	 System.out.println("2 i="+i);
                    e.printStackTrace();
                   
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                	System.out.println("3 i="+i+"' index="+index12+"' fieldName="+fieldName);
                	e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                	System.out.println("4 i="+i);
                	e.printStackTrace();
                    
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                	System.out.println("5 i="+i);
                	e.printStackTrace();
                    
                } finally {
                    // 清理资源
                }
            }

        }
        try {
            workbook.write(out);
        } catch (IOException e) {
        	System.out.println("100 i=");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
	
}