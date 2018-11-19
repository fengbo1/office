package office.uass.action;

import java.util.List;

import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostHnPeopleDAO;
import office.uass.dao.UassPtDAO;
import office.uass.dao.UassPtPeopleDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostHnPeople;
import office.uass.pojo.UassPt;
import office.uass.pojo.UassPtPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UschXiugai {

	private String type;
	private String number;
	private String newnumber;
	private String brdf;
	private int uchpid;
	private UassCostHnPeople uchpxg;
	private List<UserInfo> list;
	private List<UassCostHnPeople> listuchp;
	private UserInfo ui;// 发起人
	private String position;
	private String sxtime;
	private String tel;
	private String xgpool;
	private int xgtype891;
	private String xgitem891;
	private String xgremark1;
	private int xgtype890;
	private String xgitem890;
	private String xgremark2;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getBrdf() {
		return brdf;
	}

	public void setBrdf(String brdf) {
		this.brdf = brdf;
	}

	public int getUchpid() {
		return uchpid;
	}

	public void setUchpid(int uchpid) {
		this.uchpid = uchpid;
	}

	public UassCostHnPeople getUchpxg() {
		return uchpxg;
	}

	public void setUchpxg(UassCostHnPeople uchpxg) {
		this.uchpxg = uchpxg;
	}

	public List<UserInfo> getList() {
		return list;
	}

	public void setList(List<UserInfo> list) {
		this.list = list;
	}

	public List<UassCostHnPeople> getListuchp() {
		return listuchp;
	}

	public void setListuchp(List<UassCostHnPeople> listuchp) {
		this.listuchp = listuchp;
	}

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSxtime() {
		return sxtime;
	}

	public void setSxtime(String sxtime) {
		this.sxtime = sxtime;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getXgpool() {
		return xgpool;
	}

	public void setXgpool(String xgpool) {
		this.xgpool = xgpool;
	}

	public int getXgtype891() {
		return xgtype891;
	}

	public void setXgtype891(int xgtype891) {
		this.xgtype891 = xgtype891;
	}

	public void setXgtype890(int xgtype890) {
		this.xgtype890 = xgtype890;
	}

	public String getXgitem891() {
		return xgitem891;
	}

	public void setXgitem891(String xgitem891) {
		this.xgitem891 = xgitem891;
	}

	public String getXgremark1() {
		return xgremark1;
	}

	public void setXgremark1(String xgremark1) {
		this.xgremark1 = xgremark1;
	}

	public int getXgtype890() {
		return xgtype890;
	}

	public String getXgitem890() {
		return xgitem890;
	}

	public void setXgitem890(String xgitem890) {
		this.xgitem890 = xgitem890;
	}

	public String getXgremark2() {
		return xgremark2;
	}

	public void setXgremark2(String xgremark2) {
		this.xgremark2 = xgremark2;
	}

	public String execute() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UserInfoDAO uidao = new UserInfoDAO();
			UassCostHnDAO uchdao = new UassCostHnDAO();
			DateUtil du = new DateUtil();
			UassCostHn uch = new UassCostHn();
			UassCostHnPeopleDAO uchpdao = new UassCostHnPeopleDAO();
			ui = uidao.findByNewNumber(newnumber);
			uch = uchdao.findAllByNumber(number);
			position = ui.getPosition();
			uchpxg = uchpdao.findAllById(uchpid);
	 		list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("1_"+position.substring(2, 3)+"__"));//
			if(type.equals("sc"))
			{
				uchpxg.setNumber("DEL-"+uchpxg.getNumber());
				uchpdao.merge(uchpxg);
				type="baocun";
			}
			else
			{
				xgpool = uchpxg.getPool();
				xgtype891 = uchpxg.getType891();
				xgitem891 = uchpxg.getItem891af();
				xgremark1 = uchpxg.getRemark1();
				xgtype890 = uchpxg.getType890();
				xgitem890 = uchpxg.getItem890af();
				xgremark2 = uchpxg.getRemark2();
			}
			tel = uch.getTel();
			sxtime = uch.getSxtime();
			listuchp = uchpdao.findAllByNumber(number);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return "success";
	}
}
