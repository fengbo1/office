package office.pb.action;

import java.util.ArrayList;
import java.util.List;

import office.pb.dao.ScpbPlanDAO;
import office.pb.dao.YgpbPlanDAO;
import office.pb.pojo.ScpbPlan;
import office.pb.pojo.YgpbPlan;

public class YgpbToAdd {

	private int a;
	private int b;
	private int c;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}

	public String execute() throws Exception
	{
		YgpbPlanDAO ygdao = new YgpbPlanDAO();
		List<YgpbPlan> list = ygdao.findAll();
		List<Integer> listintbig = new ArrayList<Integer>();
		List<Integer> listintsmall = new ArrayList<Integer>();
		int size = list.size()+3;
		for(int i=0;i<size;i++)
		{
			listintbig.add(i+1);
		}
		for(int i=0;i<list.size();i++)
		{
			listintsmall.add(list.get(i).getNo());
		}
		listintbig.removeAll(listintsmall);
		a = listintbig.get(0);
		b = listintbig.get(1);
		c = listintbig.get(2);
		return "success";
	}
}
