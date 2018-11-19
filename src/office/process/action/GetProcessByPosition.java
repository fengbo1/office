package office.process.action;

public class GetProcessByPosition {

	/**
	 * 根据position查询外出公干流程编号
	 * @param position
	 * @return
	 */
	public int getWcggProcess(String position,double sumdate)
	{
		int zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		int process = 0;
		if(zhi==1)//处长
		{
			process = 2;
		}
		else if(zhi>1)
		{
			if(sumdate>1)
			{
				process = 1;
			}
			else
			{
				process = 3;
			}
		}
		return process;
	}
	public int getYGXXProcess(String position,String posxx,double sumdate)
	{
		int chu = Integer.parseInt(position.substring(2, 3));// 发起人处室
		int chuxx = Integer.parseInt(posxx.substring(2, 3));// 下线员工处室
		int process = 0;
		if(chu==chuxx)
		{
			process=1;
		}
		else
		{
			process=2;
		}
		if(sumdate>1)
		{
			process+=2;
		}
		return process;
	}
	public int getZzzmProcess(String position)
	{
		//int zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		//int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		int process = 1;
		/*if((zhi==3||zhi==4)&&(chu>=2))//普通员工或组长
		{
			process = 1;
		} 
		else if(zhi==2)//团队负责人
		{
			process = 1;
		}
		 else if(chu==1&&zhi==3)//综合管理处
		{
			process = 3;
		}else if(zhi==1)//处长
		{
			process = 2;
		}*/
		return process;
	}
	public int getSrzmProcess(String position)
	{
		//int zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		//int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		int process = 1;
		/*if((zhi==3||zhi==4)&&(chu>=2))//普通员工或组长
		{
			process = 1;
		} 
		else if(zhi==2)//团队负责人
		{
			process = 1;
		} 
		else if(chu==1&&zhi==3)//综合管理处
		{
			process = 3;
		}
		else if(zhi==1)//处长
		{
			process = 2;
		}*/
		return process;
	}
	public int getYscjProcess(String position)
	{
		int zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		int process = 0;
		if((zhi==3||zhi==4)&&(chu>=2))//普通员工或组长
		{
			process = 1;
		} 
		else if(zhi==2)//非综合团队负责人
		{
			process = 1;
		} 
		else if((zhi==1)&&(chu==1))//综合处负责人
		{
			process = 3;
		} 
		else if(chu==1&&zhi==3)//综合管理处
		{
			process = 2;
		}
		else if(zhi==1)//处室负责人
		{
			process = 2;
		}
		return process;
	}
	/**
	 * 根据position查询加班流程编号
	 * @param position
	 * @return
	 */
	public int getJbspProcess(String position)
	{
		int zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		int process = 0;
		if(zhi==1)//处长
		{
			process = 2;
		}else if(zhi>1)
		{
			process = 1;
		}
		return process;
	}
	/**
	 * 根据position查询考勤缺失编号
	 * @param position
	 * @return
	 */
	public int getKqqsProcess(String position)
	{
		int zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		int process = 0;
		if(zhi==1)//处室负责人
		{
			process = 2;
		} else if(zhi>1)//普通员工
		{
			process = 1;
		}
		return process;
	}
	public int getMjglProcess(String position,String auth)
	{
		int zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		
		int process = 0;
		if((zhi==1)||(chu==1))//处室负责人
		{
			process = 1;
		} 
		else if (auth=="R")
		{
			process = 1;
		}	
		else //普通员工
		{
			process = 2;
		}
		return process;
	}
	
	public int getZcslProcess(String position)
	{
		
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		
		int process = 0;
		if(chu==1||chu==0)//综合与生产管理处资产管理员
		{
			process = 1;
		} 
		
		else //其他处室资产管理员
		{
			process = 2;
		}
		return process;
	}
	
	public int getZcjyProcess(String position)
	{
		
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		
		int process = 0;
		if(chu==1||chu==0)//综合与生产管理处资产管理员
		{
			process = 1;
		} 
		
		else //其他处室资产管理员
		{
			process = 2;
		}
		return process;
	}
	public int getZcxjProcess(String position)
	{
		
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		
		int process = 0;
		if(chu==1)//综合与生产管理处资产管理员
		{
			process = 1;
		} 
		
		else //其他处室资产管理员
		{
			process = 2;
		}
		return process;
	}
	public int getZcghProcess(String position)
	{
		
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		
		int process = 0;
		if(chu==1||chu==0)//综合与生产管理处资产管理员
		{
			process = 1;
		} 
		
		else //其他处室资产管理员
		{
			process = 2;
		}
		return process;
	}
	/**
	 * uass平台用户
	 * @param position
	 * @param autho
	 * @return
	 */
	public int getUsptProcess(String position,String autho)
	{
		
		int chu = Integer.parseInt(position.substring(2, 3));// 第三位表示处室
		
		int process = 0;
		if(chu==1)//综合与生产管理处资产管理员
		{
			process = 1;
		} 
		else //其他处室资产管理员
		{
			process = 2;
		}
		return process;
	}
}
