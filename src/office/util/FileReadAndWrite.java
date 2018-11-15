package office.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件读写操作
 * 审批事项专用
 * @author htzx
 *
 */
public class FileReadAndWrite {

	private String input;
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String execute() throws Exception
	{
		
		//filewrite(input);
		//fileread("D:\\QJSQ");
		return "success";
	}
	public String fileread(String newdate,String type)
	{
		String path = "D:\\"+type;
		File f=new File(path);
		String temp = "";
		if(!f.exists()){
			System.out.println("file not exist");
			return "null";
		}else{
			try {
				BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"));
				try {
					temp = reader.readLine();
					System.out.println(temp+":"+temp.length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		return temp;
	}
	public String filewrite(String input,String type)
	{
		String path = "D:\\"+type;
		try {
			FileWriter fileWriter;
			fileWriter = new FileWriter(path,false);
			fileWriter.write(input);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 审批事项序号自动生成
	 * @param type QJSQ/WCGG/JBSP/KQQS
	 * @return
	 */
	public String readandwrite(String type)
	{
		DateUtil du = new DateUtil();
		int index = 1;
		String date = du.getStringDate();
		String content = fileread(date,type);
		if(content.equals("null")||content.length()<9)//空
		{
			filewrite(date+"A",type);
		}
		else
		{
			String olddate = content.substring(0, 8);
			
			if(olddate.equals(date))//当日
			{
				content = content+"A";
				index = content.length()-8;
			}
			else
			{
				content = date+"A";
			}
			filewrite(content,type);
		}
		return String.valueOf(index);
	}
	
	
}
