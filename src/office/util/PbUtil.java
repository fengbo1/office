package office.util;

import java.util.ArrayList;
import java.util.List;
import office.pb.bean.ScpbTableBean;
import office.pb.bean.ScpbTableHzBean;
import office.pb.dao.ScpbPlanDAO;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.ScpbTable;
import office.pb.pojo.ScpbTableHz;

/**
 * 排班管理小工具
 * @author htzx
 *
 */
public class PbUtil {

	public List<ScpbTableBean> scpbTableToBean(ScpbTable sta)
	{
		List<ScpbTableBean> liststb = new ArrayList<ScpbTableBean>();
		if(sta!=null)
		{
			if(sta.getTeam1()!=null&&sta.getTeam1()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(1);
				stb.setPlan(sta.getTeam1());
				liststb.add(stb);
			}
			if(sta.getTeam2()!=null&&sta.getTeam2()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(2);
				stb.setPlan(sta.getTeam2());
				liststb.add(stb);
			}
			if(sta.getTeam3()!=null&&sta.getTeam3()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(3);
				stb.setPlan(sta.getTeam3());
				liststb.add(stb);
			}
			if(sta.getTeam4()!=null&&sta.getTeam4()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(4);
				stb.setPlan(sta.getTeam4());
				liststb.add(stb);
			}
			if(sta.getTeam5()!=null&&sta.getTeam5()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(5);
				stb.setPlan(sta.getTeam5());
				liststb.add(stb);
			}
			if(sta.getTeam6()!=null&&sta.getTeam6()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(6);
				stb.setPlan(sta.getTeam6());
				liststb.add(stb);
			}
			if(sta.getTeam7()!=null&&sta.getTeam7()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(7);
				stb.setPlan(sta.getTeam7());
				liststb.add(stb);
			}
			if(sta.getTeam8()!=null&&sta.getTeam8()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(8);
				stb.setPlan(sta.getTeam8());
				liststb.add(stb);
			}
			if(sta.getTeam9()!=null&&sta.getTeam9()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(9);
				stb.setPlan(sta.getTeam9());
				liststb.add(stb);
			}
			if(sta.getTeam10()!=null&&sta.getTeam10()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(10);
				stb.setPlan(sta.getTeam10());
				liststb.add(stb);
			}
			if(sta.getTeam11()!=null&&sta.getTeam11()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(11);
				stb.setPlan(sta.getTeam11());
				liststb.add(stb);
			}
			if(sta.getTeam12()!=null&&sta.getTeam12()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(12);
				stb.setPlan(sta.getTeam12());
				liststb.add(stb);
			}
			if(sta.getTeam13()!=null&&sta.getTeam13()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(13);
				stb.setPlan(sta.getTeam13());
				liststb.add(stb);
			}
			if(sta.getTeam14()!=null&&sta.getTeam14()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(14);
				stb.setPlan(sta.getTeam14());
				liststb.add(stb);
			}
			if(sta.getTeam15()!=null&&sta.getTeam15()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(15);
				stb.setPlan(sta.getTeam15());
				liststb.add(stb);
			}
			if(sta.getTeam16()!=null&&sta.getTeam16()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(16);
				stb.setPlan(sta.getTeam16());
				liststb.add(stb);
			}
			if(sta.getTeam17()!=null&&sta.getTeam17()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(17);
				stb.setPlan(sta.getTeam17());
				liststb.add(stb);
			}
			if(sta.getTeam18()!=null&&sta.getTeam18()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(18);
				stb.setPlan(sta.getTeam18());
				liststb.add(stb);
			}
			if(sta.getTeam19()!=null&&sta.getTeam19()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(19);
				stb.setPlan(sta.getTeam19());
				liststb.add(stb);
			}
			if(sta.getTeam20()!=null&&sta.getTeam20()!=0)
			{
				ScpbTableBean stb = new ScpbTableBean();
				stb.setTeam(20);
				stb.setPlan(sta.getTeam20());
				liststb.add(stb);
			}
		}
		return liststb;
	}
	
	public ScpbTableHzBean scpbTableHzToBean(List<ScpbTableHz> liststh)
	{
		if(liststh.isEmpty())
		{
			return null;
		}
		else
		{
			ScpbTableHzBean sthb = new ScpbTableHzBean();
			for(int i=0;i<liststh.size();i++)
			{
				ScpbTableHz sth = liststh.get(i);
				if(sth.getTeamno()==1)
				{
					sthb.setTeam1(sth.getPlanno());
				}
				else if(sth.getTeamno()==2)
				{
					sthb.setTeam2(sth.getPlanno());
				}
				else if(sth.getTeamno()==3)
				{
					sthb.setTeam3(sth.getPlanno());
				}
				else if(sth.getTeamno()==4)
				{
					sthb.setTeam4(sth.getPlanno());
				}
				else if(sth.getTeamno()==5)
				{
					sthb.setTeam5(sth.getPlanno());
				}
				else if(sth.getTeamno()==6)
				{
					sthb.setTeam6(sth.getPlanno());
				}
				else if(sth.getTeamno()==7)
				{
					sthb.setTeam7(sth.getPlanno());
				}
				else if(sth.getTeamno()==8)
				{
					sthb.setTeam8(sth.getPlanno());
				}
				else if(sth.getTeamno()==9)
				{
					sthb.setTeam9(sth.getPlanno());
				}
				else if(sth.getTeamno()==10)
				{
					sthb.setTeam10(sth.getPlanno());
				}
				else if(sth.getTeamno()==11)
				{
					sthb.setTeam11(sth.getPlanno());
				}
				else if(sth.getTeamno()==12)
				{
					sthb.setTeam12(sth.getPlanno());
				}
				else if(sth.getTeamno()==13)
				{
					sthb.setTeam13(sth.getPlanno());
				}
				else if(sth.getTeamno()==14)
				{
					sthb.setTeam14(sth.getPlanno());
				}
				else if(sth.getTeamno()==15)
				{
					sthb.setTeam15(sth.getPlanno());
				}
				else if(sth.getTeamno()==16)
				{
					sthb.setTeam16(sth.getPlanno());
				}
				else if(sth.getTeamno()==17)
				{
					sthb.setTeam17(sth.getPlanno());
				}
				else if(sth.getTeamno()==18)
				{
					sthb.setTeam18(sth.getPlanno());
				}
				else if(sth.getTeamno()==19)
				{
					sthb.setTeam19(sth.getPlanno());
				}
				else if(sth.getTeamno()==20)
				{
					sthb.setTeam20(sth.getPlanno());
				}
				else if(sth.getTeamno()==21)
				{
					sthb.setTeam21(sth.getPlanno());
				}
				else if(sth.getTeamno()==22)
				{
					sthb.setTeam22(sth.getPlanno());
				}
				else if(sth.getTeamno()==23)
				{
					sthb.setTeam23(sth.getPlanno());
				}
				else if(sth.getTeamno()==24)
				{
					sthb.setTeam24(sth.getPlanno());
				}
				else if(sth.getTeamno()==25)
				{
					sthb.setTeam25(sth.getPlanno());
				}
				else if(sth.getTeamno()==26)
				{
					sthb.setTeam26(sth.getPlanno());
				}
				else if(sth.getTeamno()==27)
				{
					sthb.setTeam27(sth.getPlanno());
				}
				else if(sth.getTeamno()==28)
				{
					sthb.setTeam28(sth.getPlanno());
				}
				else if(sth.getTeamno()==29)
				{
					sthb.setTeam29(sth.getPlanno());
				}
				else if(sth.getTeamno()==30)
				{
					sthb.setTeam30(sth.getPlanno());
				}
				else if(sth.getTeamno()==31)
				{
					sthb.setTeam31(sth.getPlanno());
				}
				else if(sth.getTeamno()==32)
				{
					sthb.setTeam32(sth.getPlanno());
				}
				else if(sth.getTeamno()==33)
				{
					sthb.setTeam33(sth.getPlanno());
				}
				else if(sth.getTeamno()==34)
				{
					sthb.setTeam34(sth.getPlanno());
				}
				else if(sth.getTeamno()==35)
				{
					sthb.setTeam35(sth.getPlanno());
				}
			}
			return sthb;
		}
	}
	
	public static String banciToString(Integer bc)
	{
		ScpbPlanDAO spdao = new ScpbPlanDAO();
		String result="";
		if(bc!=null&&bc!=0)
		{
			ScpbPlan sp = spdao.findAllMaxNumByNo(bc);
			//result = "班次"+bc;
			result = typeToString(sp.getType());
		}
		else
		{
			result = "-";
		}
		return result;
	}
	
	public static String faqiDai(String initiator,String applicant)
	{
		String result = "";
		if(initiator.equals(applicant))
		{
			result = LeaveUtil.NewNumberToName(applicant);
		}
		else
		{
			result = LeaveUtil.NewNumberToName(initiator)+"代"+LeaveUtil.NewNumberToName(applicant);
		}
		return result;
	}
	
	public static String typeToString(Integer type)
	{
		if(type==1)
		{
			return "小晚班";
		}
		else if(type==2)
		{
			return "大晚班";
		}
		else if(type==3)
		{
			return "早班";
		}
		else if(type==4)
		{
			return "监控";
		}
		else if(type==5)
		{
			return "试点";
		}
		else if(type==6)
		{
			return "正常班1";
		}
		else if(type==7)
		{
			return "正常班2";
		}
		else if(type==8)
		{
			return "正常班3";
		}
		else if(type==9)
		{
			return "试点1";
		}
		else if(type==10)
		{
			return "试点2";
		}
		else if(type==11)
		{
			return "试点3";
		}
		else if(type==12)
		{
			return "试点4";
		}
		else if(type==13)
		{
			return "试点5";
		}
		else
		{
			return "";
		}
	}
}
