package office.yscj.action;
import java.util.List;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.UserUtil;
import office.process.pojo.Process;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import office.yscj.pojo.TYscjTemp;
import office.yscj.dao.TYscjTempDAO;
import ccb.hibernate.HibernateSessionFactory;
public class ShowYscjPageTj {
	private String newnumberapply;
	private List<UserInfo> list;
	private UserInfo ui;
	private Integer chu;
	private String position;
    private String time;
    private String zhiwu;
	private String zhiwutj;
    private String sextj;
    private String hukoutj;
    private String contactpeopletj;
    private String tocountrytj;
    private String hukou;
    private String contactpeople;
    private String tocountry;
    private int isworkday;
    private int afterworkdaysession;
	private int beforeworkdaysession;
	private int notholidaysession;


	public int getAfterworkdaysession() {
		return afterworkdaysession;
	}


	public void setAfterworkdaysession(int afterworkdaysession) {
		this.afterworkdaysession = afterworkdaysession;
	}


	public int getBeforeworkdaysession() {
		return beforeworkdaysession;
	}


	public void setBeforeworkdaysession(int beforeworkdaysession) {
		this.beforeworkdaysession = beforeworkdaysession;
	}


	public int getNotholidaysession() {
		return notholidaysession;
	}


	public void setNotholidaysession(int notholidaysession) {
		this.notholidaysession = notholidaysession;
	}


	public int getIsworkday() {
		return isworkday;
	}


	public void setIsworkday(int isworkday) {
		this.isworkday = isworkday;
	}


	public String getHukou() {
		return hukou;
	}


	public void setHukou(String hukou) {
		this.hukou = hukou;
	}


	public String getContactpeople() {
		return contactpeople;
	}


	public void setContactpeople(String contactpeople) {
		this.contactpeople = contactpeople;
	}


	public String getTocountry() {
		return tocountry;
	}


	public void setTocountry(String tocountry) {
		this.tocountry = tocountry;
	}


	public String getHukoutj() {
		return hukoutj;
	}


	public void setHukoutj(String hukoutj) {
		this.hukoutj = hukoutj;
	}


	public String getContactpeopletj() {
		return contactpeopletj;
	}


	public void setContactpeopletj(String contactpeopletj) {
		this.contactpeopletj = contactpeopletj;
	}


	public String getTocountrytj() {
		return tocountrytj;
	}


	public void setTocountrytj(String tocountrytj) {
		this.tocountrytj = tocountrytj;
	}


	public String getZhiwu() {
		return zhiwu;
	}


	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}


	public String getZhiwutj() {
		return zhiwutj;
	}


	public void setZhiwutj(String zhiwutj) {
		this.zhiwutj = zhiwutj;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public List<UserInfo> getList() {
		return list;
	}


	public void setList(List<UserInfo> list) {
		this.list = list;
	}


	public String getSextj() {
		return sextj;
	}


	public void setSextj(String sextj) {
		this.sextj = sextj;
	}


	public String getNewnumberapply() {
		return newnumberapply;
	}


	public void setNewnumberapply(String newnumberapply) {
		this.newnumberapply = newnumberapply;
	}


	public Integer getChu() {
		return chu;
	}


	public void setChu(Integer chu) {
		this.chu = chu;
	}

	public UserInfo getUi() {
		return ui;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public void setUi(UserInfo ui) {
		this.ui = ui;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    DateUtil du = new DateUtil();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    GetProcessByPosition gpbp = new GetProcessByPosition();
 	    ProcessDAO pdao = new ProcessDAO();
 	    if(isworkday==1)
 	    {
 	       zhiwutj= new String(zhiwu.getBytes("ISO8859-1"),"UTF-8");
 	       hukoutj= new String(hukou.getBytes("ISO8859-1"),"UTF-8");
 	       contactpeopletj= new String(contactpeople.getBytes("ISO8859-1"),"UTF-8");
 	       tocountrytj= new String(tocountry.getBytes("ISO8859-1"),"UTF-8");
 	       notholidaysession=1;
 	    }
 	    else
 	    {
 	    	zhiwutj=zhiwu;
 	  	    hukoutj=hukou;
 	  	    contactpeopletj=contactpeople;
 	  	    tocountrytj=tocountry;
 	  	    notholidaysession=0;
 	    }
 		ui = uidao.findByNewNumber(newnumberapply);
 	    int process = 0;
 	    position = ui.getPosition();
 	    String thisunder = "";
 	    time = du.getDate();
	    sextj = UserUtil.getSexFromIdentity(ui.getIdentity());
 	    process = gpbp.getYscjProcess(position);
 	    Process p = pdao.findByItemAndApplicant("YSCJ", process);
 	    if(p!=null)
	    {
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	list = uidao.findByAuthorityAndPosition(thisunder, position);
	    }
 	    chu = Integer.parseInt(position.substring(2,3));
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}


	
}
