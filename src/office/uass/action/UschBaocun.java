package office.uass.action;

import java.util.List;

import office.process.action.GetProcessByPosition;
import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostHnPeopleDAO;
import office.uass.dao.UassPtDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostHnPeople;
import office.uass.pojo.UassPt;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.UserUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UschBaocun {
	private String newnumber;
	private List<UserInfo> list;
	private List<UassCostHnPeople> listuchp;
	private UserInfo ui;// 发起人
	private String addp;// 添加人姓名
	private UserInfo uiapp;// 申请人
	private String position;
	private String brdf;
	private String type;
	private String number;
	private String dai;
	private String name;// 申请人
	private String tel;
	private String sxtime;
	private String content;
	private String pool;
	private String check891zx;
	private String check891xg;
	private String check891xz;
	private String check890;
	private String rd891;
	private String rd890;
	private int uchpid;
	private String message;
	//备注
	private String qt_891_xg;
	private String qt_891_xz;
	private String qt_890_xg;
	private String qt_890_xz;

	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public List<UserInfo> getList() {
		return list;
	}

	public void setList(List<UserInfo> list) {
		this.list = list;
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

	public String getDai() {
		return dai;
	}

	public void setDai(String dai) {
		this.dai = dai;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserInfo getUiapp() {
		return uiapp;
	}

	public void setUiapp(UserInfo uiapp) {
		this.uiapp = uiapp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSxtime() {
		return sxtime;
	}

	public void setSxtime(String sxtime) {
		this.sxtime = sxtime;
	}
	
	public List<UassCostHnPeople> getListuchp() {
		return listuchp;
	}

	public void setListuchp(List<UassCostHnPeople> listuchp) {
		this.listuchp = listuchp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddp() {
		return addp;
	}

	public void setAddp(String addp) {
		this.addp = addp;
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

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public String getCheck891zx() {
		return check891zx;
	}

	public void setCheck891zx(String check891zx) {
		this.check891zx = check891zx;
	}

	public String getCheck891xg() {
		return check891xg;
	}

	public void setCheck891xg(String check891xg) {
		this.check891xg = check891xg;
	}

	public String getCheck891xz() {
		return check891xz;
	}

	public void setCheck891xz(String check891xz) {
		this.check891xz = check891xz;
	}

	public String getCheck890() {
		return check890;
	}

	public void setCheck890(String check890) {
		this.check890 = check890;
	}

	public String getRd891() {
		return rd891;
	}

	public void setRd891(String rd891) {
		this.rd891 = rd891;
	}

	public String getRd890() {
		return rd890;
	}

	public void setRd890(String rd890) {
		this.rd890 = rd890;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getQt_891_xg() {
		return qt_891_xg;
	}

	public void setQt_891_xg(String qt_891Xg) {
		qt_891_xg = qt_891Xg;
	}

	public String getQt_891_xz() {
		return qt_891_xz;
	}

	public void setQt_891_xz(String qt_891Xz) {
		qt_891_xz = qt_891Xz;
	}

	public String getQt_890_xg() {
		return qt_890_xg;
	}

	public void setQt_890_xg(String qt_890Xg) {
		qt_890_xg = qt_890Xg;
	}

	public String getQt_890_xz() {
		return qt_890_xz;
	}

	public void setQt_890_xz(String qt_890Xz) {
		qt_890_xz = qt_890Xz;
	}

	public String execute() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UserUtil uu = new UserUtil();
			UserInfoDAO uidao = new UserInfoDAO();
			UassCostHnDAO uchdao = new UassCostHnDAO();
			DateUtil du = new DateUtil();
			UassCostHn uch = new UassCostHn();
			String addname = "";
			UassCostHnPeople uchp = new UassCostHnPeople();
			UassCostHnPeopleDAO uchpdao = new UassCostHnPeopleDAO();
			FileReadAndWrite fraw = new FileReadAndWrite();
			ui = uidao.findByNewNumber(newnumber);
			position = ui.getPosition();
			String index = "000";
			
			 if(position.charAt(2)=='1')
	 		  {
				 uch.setProcess(1);
	 			list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("2_1_C"));
	 		  }
			  else if((position.charAt(0)=='2'))
 	 		  {
				  uch.setProcess(2);
 	 			list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("1_"+position.substring(2, 3)+"__"));
 	 		  }
	 		  else
	 		  {
	 			 uch.setProcess(1);
	 			list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("2_"+position.substring(2, 3)+"__"));
	 		  }
	 		if(addp!=null&&uidao.findByName(addp)==null)
	 		{
	 			 message = addp+"输入名字有误！";
				 return "success";
	 		}
	 		if(addp!=null&&!uu.ifSameChu(addp,ui.getUsername()))
			{
				 message = addp+"不是同一处室";
				 return "success";
			 }
	 		
			if (type.equals("baocun")) {
				// 保存数据库
				if (number.equals("null")) {//第一次保存
					if(brdf.equals("df"))
					{
						uiapp = uidao.findByName(addp);
						if(uiapp==null)
						{
							uiapp = new UserInfo();
							uiapp.setPosition("88888");
							uiapp.setUsername(addp);
							uiapp.setNewnumber("88888888");
						}
					}
					else
					{
						uiapp = uidao.findByName(name);
					}
					String date = du.getStringDate();
					index = "000" + fraw.readandwrite("USCH");
					index = index.substring(index.length() - 3, index.length());
					if(brdf.equals("df"))
					{
						dai="1";
					}
					number = date + "USCH" + dai + "0" + index;
					uch.setNumber(number);
					uch.setStatus(99);
					uch.setInitiator(newnumber);
					uch.setApplicant(uiapp.getNewnumber());
					uch.setPosition(uiapp.getPosition());
					uch.setTel(tel);
					uch.setSxtime(sxtime);
					
					uchdao.merge(uch);

					uchp = new UassCostHnPeople("", "", "", 0, "", "","", 0, "", "", "","", "");
					addname = uiapp.getUsername();
				} else {//非第一次保存
					uch = uchdao.findAllByNumber(number);
					if(sxtime!=null)
					uch.setSxtime(sxtime);
					
					if(uchpid!=0)
					{
						uchp= uchpdao.findAllById(uchpid);
					}
					else
					{
						uchp= uchpdao.findAllByNameNumber(addp, number);
					}
					
					if (uchp == null) {
						uchp = new UassCostHnPeople("", "", "", 0, "", "","", 0, "", "", "","", "");
					}
					addname =addp;
					
					uchdao.merge(uch);
				}
				//保存维护对象
				UserInfo uiweihu = uidao.findByName(addname);
				if(uiweihu==null)
				{
					message = "输入的名字【"+addname+"】有误，保存失败";
				}
				else
				{
					String temp891 = uiweihu.getRole891();
					String temp890 = uiweihu.getRole890();
					if(pool.contains("891"))
					{
						if(rd891.equals("zx"))//注销
						{
							uchp.setType891(1);
							uchp.setItem891af(temp891);
							uchp.setItem891bf(check891zx);
							if(check891zx.equals("10"))
							{
								uchp.setContent891("891注销");
							}
							else if(check891zx.equals("01"))
							{
								uchp.setContent891("891注销转生效");
							}
						}
						else if(rd891.equals("xg"))//修改
						{
							uchp.setItem891bf(temp891);
							uchp.setItem891af(check891xg);
							uchp.setType891(2);
							uchp.setRemark1(qt_891_xg);
							uchp.setContent891(UserUtil.roleChangeToString(temp891, check891xg, "891"));
						}
						else if(rd891.equals("xz"))//新增
						{
							uchp.setItem891bf(temp891);
							uchp.setItem891af(check891xz);
							uchp.setType891(3);
							uchp.setRemark1(qt_891_xz);
							uchp.setContent891("新增"+UserUtil.roleNewToString(check891xz, "891"));
						}
						else
						{
							uchp.setType891(0);
						}
					}
					if(pool.contains("890"))
					{
						
						if(rd890.equals("zx"))//注销
						{
							uchp.setItem890bf(temp890);
							uchp.setItem890af(check890.substring(0,2));
							uchp.setType890(1);
							if(check890.startsWith("10"))
							{
								uchp.setContent890("890注销");
							}
							else if(check890.startsWith("01"))
							{
								uchp.setContent890("890注销转生效");
							}
						}
						else if(rd890.equals("xg"))//修改
						{
							uchp.setType890(2);
							uchp.setRemark1(qt_890_xg);
							uchp.setItem890bf(temp890);
							uchp.setItem890af(check890.substring(2,8));
							uchp.setContent890(UserUtil.roleChangeToString(temp890, check890.substring(2,8), "890"));
						}
						else if(rd890.equals("xz"))//新增
						{
							uchp.setType890(3);
							uchp.setRemark1(qt_890_xz);
							uchp.setItem890bf(temp890);
							uchp.setItem890af(check890.substring(8,14));
							uchp.setContent890("新增"+UserUtil.roleNewToString(check890.substring(8,14), "890"));
						}
						else
						{
							uchp.setType890(0);
						}
					}
					uchp.setPool(pool);
					uchp.setName(addname);
					uchp.setNumber(number);
					uchpdao.merge(uchp);
				}
				
			}
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
