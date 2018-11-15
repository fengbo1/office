package office.userinfo.action;

import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UserUpdate {

	private int id;
	private String message;
	private String username;
	private String password;
	private String identity;
	private String workdate;
	private String ccbdate;
	private String zxdate;
	private int workyears;
	private String passport;
	private String hkpassport;
	private String twpassport;
	private String newnumber;
	private int status890;
	private int status891;
	private String role890;
	private String role891;
	private String chu;
	private String tuan;
	private String zhi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public int getStatus890() {
		return status890;
	}
	public void setStatus890(int status890) {
		this.status890 = status890;
	}
	public int getStatus891() {
		return status891;
	}
	public void setStatus891(int status891) {
		this.status891 = status891;
	}
	public String getRole890() {
		return role890;
	}
	public void setRole890(String role890) {
		this.role890 = role890;
	}
	public String getRole891() {
		return role891;
	}
	public void setRole891(String role891) {
		this.role891 = role891;
	}
	public String getChu() {
		return chu;
	}
	public void setChu(String chu) {
		this.chu = chu;
	}
	public String getTuan() {
		return tuan;
	}
	public void setTuan(String tuan) {
		this.tuan = tuan;
	}
	public String getZhi() {
		return zhi;
	}
	public void setZhi(String zhi) {
		this.zhi = zhi;
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao = new UserInfoDAO();
		String position = "";
		String result = "success";
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		UserInfo ui = uidao.findAllById(id);
		position = ui.getPosition();
		ui.setPassword(password.trim());
		ui.setNewnumber(newnumber);
		ui.setPosition(getNewPosition(chu,tuan,zhi));
		if(zhi.equals("3"))
		{
			ui.setAuthority("0000E000000000000000");
		}
		else if(zhi.equals("4"))
		{
			ui.setAuthority("000D0000000000000000");
		}
		else if(zhi.equals("2"))
		{
			ui.setAuthority("00C00000000000000000");
		}
		ui.setIdentity(identity.trim());
		ui.setWorkdate(workdate);
		ui.setCcbdate(ccbdate);
		ui.setZxdate(zxdate);
		ui.setWorkyears(workyears);
		ui.setPassport(passport);
		ui.setHkpassport(hkpassport);
		ui.setTwpassport(twpassport);
		ui.setStatus890(status890);
		ui.setStatus891(status891);
		ui.setRole890(role890);
		ui.setRole891(role891);
		if(uidao.findByName(username)!=null&&uidao.findByName(username).getId()!=id)
		{
			message = "失败,已有姓名为"+username+"的员工";
			result = "error";
		}
		else if(uidao.findByNewNumber(newnumber)!=null&&uidao.findByNewNumber(newnumber).getId()!=id)
		{
			message = "失败,已有新一代员工编号为"+newnumber+"的员工";
			result = "error";
		}
		else
		{
			message = "修改成功";
			ui.setUsername(username.trim());
			uidao.merge(ui);
		}
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return result;
	}
	
	public String getNewPosition(String chu,String tuan,String zhi)
	{
		String position = "";
		if(zhi!=null&&zhi.length()==1)
		{
			position+=zhi;
		}
		else
		{
			position+="9";
		}
		position+="0";
		if(chu!=null&&chu.length()==1)
		{
			position+=chu;
		}
		else
		{
			position+="9";
		}
		position+="0";
		if(tuan!=null&&tuan.length()==1)
		{
			position+=tuan;
		}
		else
		{
			position+="9";
		}
		return position;
	}
	
}
