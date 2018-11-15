package office.yscj.action;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.leave.dao.LeavePageDAO;
import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.util.DateUtil;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.UserUtil;
public class ShowYscjPageDfAjax {
	private String newnumber;
	private String name;
	private String chutuan;
	private String bossname;
	private UserInfo ui;
	private String identity;
	private String zxdate;
	private String username;
    private String time;
    private String sex;
    private int age;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getZxdate() {
		return zxdate;
	}
	public void setZxdate(String zxdate) {
		this.zxdate = zxdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChutuan() {
		return chutuan;
	}
	public void setChutuan(String chutuan) {
		this.chutuan = chutuan;
	}
	public String getBossname() {
		return bossname;
	}
	public void setBossname(String bossname) {
		this.bossname = bossname;
	}
	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		DateUtil du = new DateUtil();
		time = du.getDate();
		System.out.println("ajax");
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    name=new String(name.getBytes("ISO8859-1"),"UTF-8");
		ui = uidao.findByName(name);
		
		identity=ui.getIdentity();
		zxdate=ui.getZxdate();
		username=ui.getUsername();
		age=countage();
 	    sex = UserUtil.getSexFromIdentity(ui.getIdentity());
		UserInfo uifq = uidao.findByNewNumber(newnumber);
		if(ui==null)
		{
			result = "failededed";
		}
		else if(ifcandai(uifq.getAuthority(),uifq.getPosition(),ui.getPosition()))
		{
			String newnumbersq = ui.getNewnumber();
			chutuan = UserUtil.positionToName(ui.getPosition());
		 	GetProcessByPosition gpbp = new GetProcessByPosition();
		 	ProcessDAO pdao = new ProcessDAO();
		 	int process = 0;
		 	String position = ui.getPosition();
		 	String thisunder = "";
		 	process = gpbp.getYscjProcess(position);
		 	Process p = pdao.findByItemAndApplicant("YSCJ", process);
		 	if(p!=null)
			{
		 	    thisunder = p.getProcess().substring(1, 2);//EDCA
		 	    bossname = uidao.findBoss(thisunder, position);
			 }
		}
		else
		{
			result = "failed";
		}
		trans.commit();
        session.flush();
        session.clear();
        session.close();
		return result;
	}
	
	/**
	 * a是否能代b发起 返回true能。返回false不能
	 * @param positionfq
	 * @param positionsq
	 * @return
	 */
	public boolean ifcandai(String autho,String positionfq,String positionsq)
	{
		String zhifq = positionfq.substring(0, 1);
		String chufq = positionfq.substring(2, 3);
		String zhisq = positionsq.substring(0, 1);
		String chusq = positionsq.substring(2, 3);
		
		if(zhifq.equals("0")||autho.contains("J")||autho.contains("I")||autho.contains("K"))//主任处长代所有人
		{
			return true;
		}
		else if((zhifq.equals("1")&&(chufq.equals(chusq)))||(zhifq.equals("2")&&(chufq.equals(chusq))))//团队负责人代本处室
		{
			return true;
		}
		else if((zhifq.equals("3")||zhifq.equals("4"))&&(chufq.equals(chusq)))//普通员工代本处室&&!zhisq.equals("2")&&!zhisq.equals("1")
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public int countage()
	{
		Calendar a=Calendar.getInstance();
	 	int year = a.get(Calendar.YEAR); 
	 	int birthyear=Integer.parseInt(ui.getIdentity().substring(6,10));
	 	int birthmonth=Integer.parseInt(ui.getIdentity().substring(10,12));
	 	int birthday=Integer.parseInt(ui.getIdentity().substring(12,14));
	 	int month = a.get(Calendar.MONTH)+1; 
	 	int day = a.get(Calendar.DATE); 
		int age=year-birthyear;
		if((birthmonth-month)>0)
		{
			age=age-1;
		}
		if(((birthmonth-month)==0)&&((birthday-day)>0))
		{
			age=age-1;
		}
		return age;
		
	}
}
