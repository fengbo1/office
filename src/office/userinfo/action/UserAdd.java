package office.userinfo.action;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UserAdd {

	private String message;
	private String username;
	private String password;
	private int zhi;
	private int chutuan;
	private String identity;
	private String workdate;
	private String ccbdate;
	private String zxdate;
	private int workyears;
	private String passport;
	private String hkpassport;
	private String twpassport;
	private String newnumber;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getZhi() {
		return zhi;
	}
	public void setZhi(int zhi) {
		this.zhi = zhi;
	}
	public int getChutuan() {
		return chutuan;
	}
	public void setChutuan(int chutuan) {
		this.chutuan = chutuan;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getWorkdate() {
		return workdate;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public String getCcbdate() {
		return ccbdate;
	}
	public void setCcbdate(String ccbdate) {
		this.ccbdate = ccbdate;
	}
	public String getZxdate() {
		return zxdate;
	}
	public void setZxdate(String zxdate) {
		this.zxdate = zxdate;
	}
	public int getWorkyears() {
		return workyears;
	}
	public void setWorkyears(int workyears) {
		this.workyears = workyears;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getHkpassport() {
		return hkpassport;
	}
	public void setHkpassport(String hkpassport) {
		this.hkpassport = hkpassport;
	}
	public String getTwpassport() {
		return twpassport;
	}
	public void setTwpassport(String twpassport) {
		this.twpassport = twpassport;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		String result = "success";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		UserInfo ui = new UserInfo();
		ui.setPassword(password.trim());
		ui.setNewnumber(newnumber);
		ui.setPosition(getNewPosition(zhi,chutuan));
		ui.setIdentity(identity.trim());
		ui.setWorkdate(workdate.replace("-",""));
		ui.setCcbdate(ccbdate.replace("-",""));
		ui.setZxdate(zxdate.replace("-",""));
		ui.setWorkyears(workyears);
		ui.setPassport(passport);
		ui.setHkpassport(hkpassport);
		ui.setTwpassport(twpassport);
		if(uidao.findByName(username)!=null)
		{
			message = "失败,已有姓名为"+username+"的员工";
			result = "error";
			
		}
		else if(uidao.findByNewNumber(newnumber)!=null)
		{
			message = "失败,已有新一代员工编号为"+newnumber+"的员工";
			result = "error";
		}
		else
		{
			message = "增加成功";
			ui.setUsername(username.trim());
			uidao.merge(ui);
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
	
	public String getNewPosition(int zhi,int chutuan)
	{
		String position = "";
		if(chutuan>6&&chutuan<12)//7891011
		{
			String zu = String.valueOf(chutuan-6);
			position = zhi+"030"+zu;
		}
		else if(chutuan>11&&chutuan<15)//121314
		{
			String zu = String.valueOf(chutuan-9);
			position = zhi+"060"+zu;
		}
		else if(chutuan==2)
		{
			position = zhi+"0201";
		}
		else
		{
			position = zhi+"0"+String.valueOf(chutuan)+"00";
		}
		return position;
	}
}
