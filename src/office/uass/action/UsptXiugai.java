package office.uass.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

import office.uass.dao.UassPtDAO;
import office.uass.dao.UassPtPeopleDAO;
import office.uass.pojo.UassPt;
import office.uass.pojo.UassPtPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;

public class UsptXiugai {

	private String type;
	private String number;
	private String newnumber;
	private String brdf;
	private int uppid;
	private UassPtPeople uppxg;
	private List<UserInfo> list;
	private List<UassPtPeople> listupp;
	private UserInfo ui;// 发起人
	private String position;
	private String sxtime;
	private String tel;
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
	public int getUppid() {
		return uppid;
	}
	public void setUppid(int uppid) {
		this.uppid = uppid;
	}
	public UassPtPeople getUppxg() {
		return uppxg;
	}
	public void setUppxg(UassPtPeople uppxg) {
		this.uppxg = uppxg;
	}
	public List<UserInfo> getList() {
		return list;
	}
	public void setList(List<UserInfo> list) {
		this.list = list;
	}
	public List<UassPtPeople> getListupp() {
		return listupp;
	}
	public void setListupp(List<UassPtPeople> listupp) {
		this.listupp = listupp;
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
	public String getBrdf() {
		return brdf;
	}
	public void setBrdf(String brdf) {
		this.brdf = brdf;
	}
	public String execute() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UserInfoDAO uidao = new UserInfoDAO();
			UassPtDAO updao = new UassPtDAO();
			DateUtil du = new DateUtil();
			UassPt up = new UassPt();
			UassPtPeopleDAO uppdao = new UassPtPeopleDAO();
			ui = uidao.findByNewNumber(newnumber);
			up = updao.findAllByNumber(number);
			position = ui.getPosition();
			String authoL = ui.getAuthority().substring(11, 12);
			uppxg = uppdao.findAllById(uppid);
			if (authoL.equals("L")) {
				list = uidao.UserlistToSelectlist(uidao
						.findAllByPosition1("2_1__"));//
			}
			else
	 		{
	 			list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("1_"+position.substring(2, 3)+"__"));//
	 		}
			if(type.equals("sc"))
			{
				uppxg.setNumber("DEL-"+uppxg.getNumber());
				uppdao.merge(uppxg);
				type="baocun";
			}
			tel = up.getTel();
			sxtime = up.getSxtime();
			listupp = uppdao.findAllByNumber(number);
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
