package office.uass.action;

import office.uass.dao.UassCostHnPeopleDAO;
import office.uass.pojo.UassCostHnPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UschShowItem {

	private String pool;
	private String addp;
	private String number;
	private String newnumber;
	private String itembb;
	private String itemwb;
	private String itemgl;
	private String itemjy;
	private String item890;
	private int status891;
	private int status890;
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
	public String getAddp() {
		return addp;
	}
	public void setAddp(String addp) {
		this.addp = addp;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getItembb() {
		return itembb;
	}
	public void setItembb(String itembb) {
		this.itembb = itembb;
	}
	public String getItemwb() {
		return itemwb;
	}
	public void setItemwb(String itemwb) {
		this.itemwb = itemwb;
	}
	public String getItemgl() {
		return itemgl;
	}
	public void setItemgl(String itemgl) {
		this.itemgl = itemgl;
	}
	public String getItem890() {
		return item890;
	}
	public void setItem890(String item890) {
		this.item890 = item890;
	}
	public int getStatus891() {
		return status891;
	}
	public void setStatus891(int status891) {
		this.status891 = status891;
	}
	public int getStatus890() {
		return status890;
	}
	public void setStatus890(int status890) {
		this.status890 = status890;
	}
	public String getItemjy() {
		return itemjy;
	}
	public void setItemjy(String itemjy) {
		this.itemjy = itemjy;
	}
	public String execute() throws Exception{
		UserInfoDAO uidao = new UserInfoDAO();
		UassCostHnPeopleDAO uchpdao = new UassCostHnPeopleDAO();
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UserInfo ui =null;
			if(!addp.isEmpty())
			{
				addp = new String(addp.getBytes("ISO8859-1"),"UTF-8");
				ui = uidao.findByName(addp);
			}
			else
			{
				ui = uidao.findByNewNumber(newnumber);
			}
			
			if(ui!=null)
			{
				UassCostHnPeople uchp = uchpdao.findAllByNameNumber(ui.getUsername(),number);
				status890=ui.getStatus890();
				status891=ui.getStatus891();
				if(uchp==null)
				{
					itembb = ui.getRole891().substring(0, 16);
					itemwb = ui.getRole891().substring(16,32);
					itemgl = ui.getRole891().substring(32,40);
					if(ui.getRole891().length()>42)
					{
						itemjy = ui.getRole891().substring(40,43);
					}
					else
					{
						itemjy = "000";
					}
					item890 = ui.getRole890();//890修改项目
				}
				else
				{
					if(uchp.getType891()==2)
					{
						itembb = uchp.getItem891af().substring(0, 16);
						itemwb = uchp.getItem891af().substring(16,32);
						itemgl = uchp.getItem891af().substring(32,40);
						if(uchp.getItem891af().length()>42)
						{
							itemjy = uchp.getItem891af().substring(40,43);
						}
						else
						{
							itemjy = "000";
						}
					}
					else
					{
						itembb = ui.getRole891().substring(0, 16);
						itemwb = ui.getRole891().substring(16,32);
						itemgl = ui.getRole891().substring(32,40);
						if(ui.getRole891().length()>42)
						{
							itemjy = ui.getRole891().substring(40,43);
						}
						else
						{
							itemjy = "000";
						}
					}
					if(uchp.getType890()==2)
					{
						item890 = uchp.getItem890af();//890修改项目
					}
					else
					{
						item890 = ui.getRole890();//890修改项目
					}
				}
			}
		}catch (Exception e) {
			trans.rollback();//出错回滚
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
