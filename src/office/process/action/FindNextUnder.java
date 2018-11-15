package office.process.action;

import java.util.ArrayList;
import java.util.List;
import office.mjgl.dao.TMjglPageDAO;
import office.mjgl.dao.TMjglDAO;
import office.mjgl.pojo.TMjgl;
import office.mjgl.pojo.TMjglPage;
import office.jbsp.dao.JbspPageDAO;
import office.jbsp.pojo.JbspPage;
import office.kqqs.dao.KqqsPageDAO;
import office.kqqs.pojo.KqqsPage;
import office.leave.dao.LeavePageDAO;
import office.leave.pojo.LeavePage;
import office.pb2.dao.XxsqPageDAO;
import office.pb2.pojo.XxsqPage;
import office.process.dao.ProcessDAO;
import office.process.pojo.Process;
import office.uass.dao.UassCostHnDAO;
import office.uass.dao.UassCostWbDAO;
import office.uass.dao.UassJiheDAO;
import office.uass.dao.UassPtDAO;
import office.uass.pojo.UassCostHn;
import office.uass.pojo.UassCostWb;
import office.uass.pojo.UassJihe;
import office.uass.pojo.UassPt;
import office.userinfo.dao.UserInfoDAO;
import office.userinfo.pojo.UserInfo;
import office.wcgg.dao.WcggPageDAO;
import office.wcgg.pojo.WcggPage;
import office.zszm.dao.TZzzmDAO;
import office.zszm.pojo.TZzzm;
import office.yscj.dao.TYscjDAO;
import office.yscj.pojo.TYscj;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.hibernate.HibernateSessionFactory;
import office.srzm.dao.TSrzmDAO;
import office.srzm.pojo.TSrzm;
import office.zcgl.dao.AssetApplyDAO;
import office.zcgl.pojo.AssetApply;
import office.zcgl.dao.AssetBorrowDAO;
import office.zcgl.pojo.AssetBorrow;
import office.zcgl.dao.AssetReturnDAO;
import office.zcgl.pojo.AssetReturn;
public class FindNextUnder {

	/**
	 * 根据审批表当前状态、进度、当前审批人信息查找下一个审批人
	 * 
	 * @param item
	 *            事项编号
	 * @param number
	 *            审批表标号
	 * @param thisNewnumber
	 *            当前审批人新一代工号
	 * @return
	 */
	/*  弃用
	public List<UserInfo> findNextUnder(int item, String number,
			String thisNewnumber) {

		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		LeavePageDAO lpdao = new LeavePageDAO();
		Process p = new Process();
		UserInfo ui = new UserInfo();
		LeavePage lp = new LeavePage();
		List<UserInfo> list = new ArrayList<UserInfo>();
		String proc = "";// 完整流程
		String position = "";
		String thisUnder = "";
		String zhi = "";
		String chu = "";
		String tuan = "";
		String jindu = "";
		int status = 0;
		int applicant = 0;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			ui = uidao.findByNewNumber(thisNewnumber);
			lp = lpdao.findByNumber(number);
			applicant = lp.getProcess();
			p = pdao.findByItemAndApplicant(item, applicant);
			proc = p.getProcess();// 完整流程
			position = ui.getPosition();
			zhi = position.substring(0, 1);
			chu = position.substring(2, 3);
			tuan = position.substring(4, 5);
			jindu = lp.getJindu();
			status = lp.getStatus();
			if (item == 1)// 如果是请假审批
			{
				if (status == 0||status == 1||status == 6||status == 9)// 如果是正常流转状态
				{
					thisUnder = proc.substring(jindu.length(), jindu.length() + 1);
					if (thisUnder.equals("B"))
					{
						if(applicant<=5)// 查询主任权限的审批人
						{
							list = uidao.findAllByPosition("0____");
						}
						
					} else if (thisUnder.equals("R")) {
						list = uidao.findAllByPosition("1_1__");//计划内
						if(chu.equals("3"))
						{
							list = uidao.findAllByPositionOut("1_1__","U");//计划外
						}
					} else if (thisUnder.equals("E")) {
						if (chu.equals("3"))// 异常交易处
						{
							list = uidao.findAllByPosition("2_3__");
						}
					} else if (thisUnder.equals("F"))// 普通员工分为异常交易处和员工响应团队
					{
						if (chu.equals("3")) {
							list = uidao.findAllByPosition("4_3_"+tuan);//组长
						} else if (chu.equals("4")) {
							list = uidao.findAllByPosition("2_4__");//员工响应负责人
						}
					}
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		return list;

	}
	*/
	/**
	 *  根据审批表当前状态、进度等信息查找下一个审批人
	 * 
	 * @param item
	 *            事项编号
	 * @param number
	 *            审批表标号
	 */
	public List<UserInfo> findNextUnder(String item,String number)
	{
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		
		
		Process p = new Process();
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		List<UserInfo> listtemp = new ArrayList<UserInfo>();
		String newnumber = "";//实际请假/公干人新员工工号
		String proc = "";// 完整流程
		String jindu = "";// 当前进度
		String under = "无";
		String zu = "";
		String chu = "";
		String chudf = "";//对方处室
		int length = 0;//当前进度长度
		int applicant = 0;
		if(item.equals("QJSQ"))
		{
			LeavePageDAO lpdao = new LeavePageDAO();
			LeavePage lp = lpdao.findByNumber(number);
			newnumber = lp.getApplicant();
			applicant = lp.getProcess();
			jindu = lp.getJindu();
		}
		else if(item.equals("WCGG"))
		{
			WcggPageDAO wpdao = new WcggPageDAO();
			WcggPage wp = wpdao.findAllByNumber(number);
			newnumber = wp.getApplicant();
			applicant = wp.getProcess();
			jindu = wp.getJindu();
		}
		else if(item.equals("JBSP"))
		{
			JbspPageDAO jpdao = new JbspPageDAO();
			JbspPage jp = jpdao.findAllByNumber(number);
			newnumber = jp.getApplicant();
			applicant = jp.getProcess();
			jindu = jp.getJindu();
		}
		else if(item.equals("KQQS"))
		{
			KqqsPageDAO kpdao = new KqqsPageDAO();
			KqqsPage kp = kpdao.findAllByNumber(number);
			newnumber = kp.getApplicant();
			applicant = kp.getProcess();
			jindu = kp.getJindu();
		}
		else if(item.equals("YGXX"))
		{
			XxsqPageDAO xpdao = new XxsqPageDAO();
			XxsqPage xp = xpdao.findAllByNumber(number);
			newnumber = xp.getApplicant();
			applicant = xp.getProcess();
			jindu = xp.getJindu();
			chudf = uidao.findByName(xp.getPeople().split("、")[0]).getPosition().substring(2, 3);
		}
		else if(item.equals("ZZZM"))
		{
			TZzzmDAO tzdao = new TZzzmDAO();
			TZzzm tz = tzdao.findAllByNumber(number);
			newnumber = tz.getApplicant();
			applicant = tz.getProcess();
			jindu = tz.getJindu();
		}
		else if(item.equals("SRZM"))
		{
			TSrzmDAO tzdao = new TSrzmDAO();
			TSrzm tz = tzdao.findAllByNumber(number);
			newnumber = tz.getApplicant();
			applicant = tz.getProcess();
			jindu = tz.getJindu();
		}
		else if(item.equals("YSCJ"))
		{
			TYscjDAO tydao = new TYscjDAO();
			TYscj ty = tydao.findAllByNumber(number);
			newnumber = ty.getApplicant();
			applicant = ty.getProcess();
			jindu = ty.getJindu();
		}
		else if(item.equals("MJGL"))
		{
			TMjglDAO tmdao = new TMjglDAO();
			TMjgl tm = tmdao.findAllByNumber(number);
			newnumber = tm.getInitiator();
			applicant = tm.getProcess();
			jindu = tm.getJindu();
		}
		else if(item.equals("ZCSL"))
		{
			AssetApplyDAO aydao = new AssetApplyDAO();
			AssetApply ay = aydao.findAllByNumber(number);
			newnumber = ay.getInitiator();
			applicant = ay.getProcess();
			jindu = ay.getJindu();
		}
		else if(item.equals("ZCJY"))
		{
			AssetBorrowDAO aydao = new AssetBorrowDAO();
			AssetBorrow ay = aydao.findAllByNumber(number);
			newnumber = ay.getInitiator();
			applicant = ay.getProcess();
			jindu = ay.getJindu();
		}
		
		else if(item.equals("ZCGH"))
		{
			AssetReturnDAO aydao = new AssetReturnDAO();
			AssetReturn ay = aydao.findAllByNumber(number);
			newnumber = ay.getInitiator();
			applicant = ay.getProcess();
			jindu = ay.getJindu();
		}
		else if(item.equals("USPT"))
		{
			UassPtDAO updao = new UassPtDAO();
			UassPt up = updao.findAllByNumber(number);
			newnumber = up.getInitiator();
			applicant = up.getProcess();
			jindu = up.getJindu();
		}
		else if(item.equals("USCH"))
		{
			UassCostHnDAO uchdao = new UassCostHnDAO();
			UassCostHn uch = uchdao.findAllByNumber(number);
			newnumber = uch.getInitiator();
			applicant = uch.getProcess();
			jindu = uch.getJindu();
		}
		else if(item.equals("USCW"))
		{
			UassCostWbDAO ucdao = new UassCostWbDAO();
			UassCostWb uc = ucdao.findAllByNumber(number);
			newnumber = uc.getInitiator();
			applicant = uc.getProcess();
			jindu = uc.getJindu();
		}
		else if(item.equals("USJH"))
		{
			UassJiheDAO ucdao = new UassJiheDAO();
			UassJihe uc = ucdao.findAllByNumber(number);
			newnumber = uc.getInitiator();
			applicant = uc.getProcess();
			jindu = uc.getJindu();
		}
		ui = uidao.findByNewNumber(newnumber);
		chu = ui.getPosition().substring(2,3);
		zu = ui.getPosition().substring(4,5);
		length = jindu.length();
		p = pdao.findByItemAndApplicant(item, applicant);
		proc = p.getProcess();
		if((length+1)<proc.length())//如果有下一个审批人 // EDCB
		{
			under = proc.substring(length+1,length+2);//EDCBA
		}
		if(under.equals("D"))// 如果下一审批人是组长
		{
			listtemp = uidao.findZuZhangByAuthorityAndZu(under,chu,zu);
		}
		else if(under.equals("C"))// 如果下一审批人是团队负责人
		{
			listtemp = uidao.findTuanByAuthorityAndChu(under,chu);
		}
		else if(under.equals("B"))// 如果下一审批人是处室负责人
		{
			listtemp = uidao.findTuanByAuthorityAndChu(under,chu);
		}
		else if(under.equals("b"))// 如果下一审批人是对方处室负责人
		{
			listtemp = uidao.findTuanByAuthorityAndChu(under,chudf);
		}
		else if(under.equals("X"))// 如果下一审批人是任意处室负责人
		{
			if(item.equals("USJH")&&applicant==2)
			{
				listtemp = uidao.findAllByPosition1("1_2__");
			}
			else if(item.equals("USCW"))
			{
				listtemp = uidao.findAllByPosition1("1_3__");
			}
			else if(item.equals("USPT")&&applicant==2)
			{
				listtemp = uidao.findAllByPosition1("1_1__");
			}
			else{
				listtemp = uidao.findAllByAuthority("B");
			}
		}
		else
		{
			listtemp = uidao.findAllByAuthority(under);
		}
		if(!listtemp.isEmpty())
		{
			for(int i=0;i<listtemp.size();i++)
			{
				UserInfo uitemp = listtemp.get(i);
				UserInfo uithis = new UserInfo();
				String position = uitemp.getPosition();
				String tempstr = "";
				//String autho = uitemp.getAuthority();
				String tempchu = position.substring(2,3);
				String tempzhi = position.substring(0,1);
				//String tempzu = position.substring(4,5);
				
				if(under.equals("T"))
				{
					tempstr = "排班管理员（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("Q"))
				{
					tempstr = "门禁管理员（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("G"))
				{
					tempstr = "人力资源团队（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("J"))
				{
					tempstr = "薪酬管理员（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("P"))
				{
					tempstr = "综合与财务管理团队（"+uitemp.getUsername()+"）";
				}
				else if(under.equals("o"))
				{
					tempstr = "UASS管理员（"+uitemp.getUsername()+"）";
				}
				else if(tempzhi.equals("0"))
				{
					tempstr = "分中心主任（"+uitemp.getUsername()+"）";
				}
				else if(tempchu.equals("1"))
				{
					tempstr = "综合与生产管理处（"+uitemp.getUsername()+"）";
				}
				else if(tempchu.equals("2"))
				{
					tempstr = "合规与监督二处（"+uitemp.getUsername()+"）";
				}
				else if(tempchu.equals("3"))
				{
					tempstr = "通用业务二处（"+uitemp.getUsername()+"）";
				}
				else if(tempchu.equals("4"))
				{
					tempstr = "员工响应团队（"+uitemp.getUsername()+"）";
				}
				else if(tempchu.equals("5"))
				{
					tempstr = "研发支持二处（"+uitemp.getUsername()+"）";
				}
				else if(tempchu.equals("6"))
				{
					tempstr = "专业处理二处（"+uitemp.getUsername()+"）";
				}
				uithis.setUsername(tempstr);
				uithis.setNewnumber(uitemp.getNewnumber());
				list.add(uithis);
			}
		}
		return list;
	}
	
}
