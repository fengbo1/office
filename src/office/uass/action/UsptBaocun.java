package office.uass.action;

import java.util.List;

import office.process.action.GetProcessByPosition;
import office.process.dao.ProcessDAO;
import office.uass.dao.UassPtDAO;
import office.uass.dao.UassPtPeopleDAO;
import office.uass.pojo.UassPt;
import office.uass.pojo.UassPtPeople;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.util.DateUtil;
import office.util.FileReadAndWrite;
import office.util.UserUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UsptBaocun {
	private String newnumber;
	private List<UserInfo> list;
	private List<UassPtPeople> listupp;
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
	private String check;
	private String obj;
	private String message;
	private int uppid;
	

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

	public List<UassPtPeople> getListupp() {
		return listupp;
	}

	public void setListupp(List<UassPtPeople> listupp) {
		this.listupp = listupp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
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

	public int getUppid() {
		return uppid;
	}

	public void setUppid(int uppid) {
		this.uppid = uppid;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			UserUtil uu = new UserUtil();
			UserInfoDAO uidao = new UserInfoDAO();
			UassPtDAO updao = new UassPtDAO();
			DateUtil du = new DateUtil();
			UassPt up = new UassPt();
			int process= 0;
			UassPtPeopleDAO uppdao = new UassPtPeopleDAO();
			FileReadAndWrite fraw = new FileReadAndWrite();
			ui = uidao.findByNewNumber(newnumber);
			
			position = ui.getPosition();
			String index = "000";
			String authoL = ui.getAuthority().substring(11, 12);
			if (obj.startsWith("uass_pt_wb")||position.charAt(2)=='1') {
				list = uidao.UserlistToSelectlist(uidao
						.findAllByPosition1("2_1_C"));//
			}
			 else
	 		  {
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
				 if((position.charAt(0)=='2'))
	 	 		  {
	 	 			list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("1_"+position.substring(2, 3)+"__"));
	 	 		  }
				 else 
				 {
					 list = uidao.UserlistToSelectlist(uidao.findAllByPosition1("2_"+position.substring(2, 3)+"__"));//
				 }
	 		  }
			if (type.equals("baocun")) {
				// 保存数据库
				if (number.equals("null")) {
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
					index = "000" + fraw.readandwrite("USPT");
					index = index.substring(index.length() - 3, index.length());
					if(brdf.equals("df"))
					{
						dai="1";
					}
					number = date + "USPT" + dai + "0" + index;
					up.setNumber(number);
					up.setStatus(99);
					up.setInitiator(newnumber);
					up.setApplicant(uiapp.getNewnumber());
					up.setPosition(uiapp.getPosition());
					up.setTel(tel);
					up.setSxtime(sxtime);
					if (obj.startsWith("uass_pt_wb")) {
						process = 2;
					}
					else if(!check.equals("00000")&&!check.equals("01000"))
					{
						if(position.charAt(0)=='2')
						{
							process = 4;
						}
						else
						{
							process = 1;
						}
						
					}
					else
					{
						if(position.charAt(0)=='2')
						{
							process = 5;
						}
						else
						{
							process = 3;
						}
					}
					up.setProcess(process);
					updao.merge(up);

					UassPtPeople upp = uppdao.findAllByNameNumber(uiapp.getUsername(), number);
					if (upp == null) {
						upp = new UassPtPeople("", "", "", "");
					}
					upp.setName(uiapp.getUsername());
					upp.setNumber(number);
					upp.setContent(content);
					upp.setItem(check);
					uppdao.merge(upp);
				} else {
					up = updao.findAllByNumber(number);
					if(sxtime!=null)
					up.setSxtime(sxtime);
					process = up.getProcess();
					if (authoL.equals("L")) {
						process = 2;
					}
					else if(!check.equals("00000")&&!check.equals("01000"))
					{
						if(position.charAt(0)=='2')
						{
							process = 4;
						}
						else
						{
							process = 1;
						}
					}
					up.setProcess(process);

					UassPtPeople upp ;
					if(uppid!=0)
					{
						upp= uppdao.findAllById(uppid);
					}
					else
					{
						upp= uppdao.findAllByNameNumber(addp, number);
					}
					
					if (upp == null) {
						upp = new UassPtPeople("", "", "", "");
					}
					
					upp.setName(addp);
					upp.setNumber(number);
					upp.setContent(content);
					upp.setItem(check);
					uppdao.merge(upp);
					updao.merge(up);
				}
			}
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
