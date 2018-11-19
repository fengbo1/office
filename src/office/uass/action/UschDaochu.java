package office.uass.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostHnPeopleDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostHnPeople;
import office.userinfo.dao.UserInfoDAO;
import office.util.CustomXWPFDocument;
import office.util.LeaveUtil;
import office.util.Util;
import office.util.WordUtil;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;

public class UschDaochu {

	private String number;
	private String Path;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String execute() throws Exception
	{
		String content = "";
		int num890 = 0; 
		int num891 = 0;
		UassCostHnDAO uchdao = new UassCostHnDAO();
		LeaveUtil lu = new LeaveUtil();
		UassCostHnPeopleDAO uchpdao = new UassCostHnPeopleDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    try {  
 	    	if(!number.isEmpty())
 	    	{
 	    		UassCostHn uch = uchdao.findAllByNumber(number);
 	    		List<UassCostHnPeople> listuchp = uchpdao.findAllByNumber(number);
// 	    		for(int i=0;i<listuchp.size();i++)
// 	    		{
// 	    			UassCostHnPeople uchp = listuchp.get(i);
// 	    			content+=uchp.getName();
// 	    			content+=":";
// 	    			content+=uchp.getContent891();
// 	    			content+=uchp.getContent890();
// 	    			content+=(char)11;
// 	    		}
 	    		for(int i=0;i<listuchp.size();i++)
 	    		{
 	    			UassCostHnPeople uchp = listuchp.get(i);
 	    			if(uchp.getPool().contains("890"))
 	    			{
 	    				num890+=1;
 	    			}
 	    			if(uchp.getPool().contains("891"))
 	    			{
 	    				num891+=1;
 	    			}
 	    		}
 	    		if(num890>0)
 	    		{
 	    			content = "申请890操作员工号维护";
 	    			content += num890;
 	    			content += "笔，详见附件。";
 	    			content+=(char)11;
 	    		}
 	    		if(num891>0)
 	    		{
 	    			content += "申请891操作员工号维护";
 	    			content += num891;
 	    			content += "笔，详见附件。";
 	    		}
// 	    		//写word
// 	    		Map<String, Object> param=new HashMap<String, Object>();
// 	           param.put("${name}",lu.NewNumberToNameNoSession(uch.getInitiator()));
// 	           param.put("${telephone}", uch.getDate());
// 	           param.put("${date}", uch.getTel());
// 	           param.put("${content}", content);
// 	           param.put("${sxtime}", uch.getSxtime());
// 	           CustomXWPFDocument doc=WordUtil.generateWord(param, Util.mubanpath+"muban.docx");
// 	           FileOutputStream fopts = new FileOutputStream(Util.downloadpath+"UASS_COST_HangNei.docx"); 
// 	           doc.write(fopts);  
// 	           fopts.close(); 
// 	           Path = "UASS_COST_HangNei.docx";
 	    		String templatePath = Util.mubanpath+"muban.doc";
 	    		InputStream is = new FileInputStream(templatePath);  
 	    		HWPFDocument doc = new HWPFDocument(is); 
 	    		Range range = doc.getRange();  
 	    		range.replaceText("${name}", lu.NewNumberToNameNoSession(uch.getInitiator()));
 	    		if(uch.getTel()==null)
 	    		{
 	    			range.replaceText("${tel}",uch.getTel());  
 	    		}
 	    		else
 	    		{
 	    			range.replaceText("${tel}","");  
 	    		}
 	    		range.replaceText("${date}",uch.getDate());  
 	    		range.replaceText("${content}",content);  
 	    		range.replaceText("${sxtime}",uch.getSxtime()); 
 	    		OutputStream os = new FileOutputStream(Util.downloadpath+number+"_word.doc");  
 	    		doc.write(os);  
 	    		os.close();  
 	    		is.close();
 	    		Path = number+"_word.doc";
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
		return "success";
	}
}

//////
