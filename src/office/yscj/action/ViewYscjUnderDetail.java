package office.yscj.action;
import java.util.List;
import office.leave.dao.LeaveProcessDAO;
import office.leave.pojo.LeaveProcess;
import office.process.action.FindNextUnder;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.wcgg.dao.WcggBaodaoDAO;
import office.yscj.dao.TYscjDAO;
import office.wcgg.pojo.WcggBaodao;
import office.yscj.pojo.TYscj;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
public class ViewYscjUnderDetail {
	private String number;
	private String undersign;
	private TYscj ty;
	private List<WcggBaodao> listwb;
	private List<LeaveProcess> listlp;
	private List<UserInfo> listui;
	private int youshenpi;
	private String position;
	private String begindate;
	private String enddate;
	private String dai;
	private String bu;
	private UserInfo ui;
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUndersign() {
		return undersign;
	}
	public void setUndersign(String undersign) {
		this.undersign = undersign;
	}

	public TYscj getTy() {
		return ty;
	}
	public void setTy(TYscj ty) {
		this.ty = ty;
	}
	public List<WcggBaodao> getListwb() {
		return listwb;
	}
	public void setListwb(List<WcggBaodao> listwb) {
		this.listwb = listwb;
	}
	public List<LeaveProcess> getListlp() {
		return listlp;
	}
	public void setListlp(List<LeaveProcess> listlp) {
		this.listlp = listlp;
	}
	public List<UserInfo> getListui() {
		return listui;
	}
	public void setListui(List<UserInfo> listui) {
		this.listui = listui;
	}
	public int getYoushenpi() {
		return youshenpi;
	}
	public void setYoushenpi(int youshenpi) {
		this.youshenpi = youshenpi;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getDai() {
		return dai;
	}
	public void setDai(String dai) {
		this.dai = dai;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		TYscjDAO tydao = new TYscjDAO();
		LeaveProcessDAO lpdao = new LeaveProcessDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    ty = tydao.findAllByNumber(number);
	    dai=ty.getNumber().substring(12, 13);
 	    listlp = lpdao.findAllByNumber(number);
 	  	listui = fnu.findNextUnder("YSCJ", number);
 	    ui = uidao.findByNewNumber(ty.getApplicant());
		position = ui.getPosition();
 	  	Process p = pdao.findByItemAndApplicant("YSCJ",ty.getProcess());
 	    
 	  	int jindulength = ty.getJindu().length();
 	  	String proc = p.getProcess();
 	  	
 	  	undersign = proc.substring(jindulength, jindulength+1);
 	  	
 	  	if(listui.isEmpty())
 	  	{
 	  		youshenpi = 0;
 	  	}
 	  	else
 	  	{
 	  		youshenpi = 1;
 	  	}
 	  	begindate=du.simpleToStanderd(ty.getBegindate());
	    enddate=du.simpleToStanderd(ty.getEnddate());
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	
}
