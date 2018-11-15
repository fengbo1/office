package office.pb.action;

import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.pb.dao.PbMxDAO;
import office.pb.dao.ScpbPlanDAO;
import office.pb.pojo.ScpbPlan;
import office.util.DateUtil;
import office.util.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ChangePbMx {

	private int id;
	private int wb;
	private String opname;
	private String sbtime;
	private String xbtime;
	private String zytime;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWb() {
		return wb;
	}
	public void setWb(int wb) {
		this.wb = wb;
	}
	public String getOpname() {
		return opname;
	}
	public void setOpname(String opname) {
		this.opname = opname;
	}
	public String getSbtime() {
		return sbtime;
	}
	public void setSbtime(String sbtime) {
		this.sbtime = sbtime;
	}
	public String getXbtime() {
		return xbtime;
	}
	public void setXbtime(String xbtime) {
		this.xbtime = xbtime;
	}
	public String getZytime() {
		return zytime;
	}
	public void setZytime(String zytime) {
		this.zytime = zytime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		PbMxDAO pmdao = new PbMxDAO();
		DateUtil du = new DateUtil();
		ScpbPlanDAO spdao = new  ScpbPlanDAO();
		OperateLogDAO oldao = new OperateLogDAO();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		message = "修改成功";
    		OperateLog ol = new OperateLog();
    		office.pb.pojo.PbMx pm = pmdao.findAllById(id);
//    		ScpbPlan spxwb = spdao.findAllByTypeAndNum(1, pm.getPlannum());
//    		ScpbPlan spdwb = spdao.findAllByTypeAndNum(2, pm.getPlannum());
//    		ScpbPlan spdzb = spdao.findAllByTypeAndNum(3, pm.getPlannum());//早班
//    		ScpbPlan spdjk = spdao.findAllByTypeAndNum(4, pm.getPlannum());//监控
//    		ScpbPlan spdsd = spdao.findAllByTypeAndNum(5, pm.getPlannum());//试点
//    		ScpbPlan spd1 = spdao.findAllByTypeAndNum(6, pm.getPlannum());//正常班1
//    		ScpbPlan spd2 = spdao.findAllByTypeAndNum(7, pm.getPlannum());//正常班2
//    		ScpbPlan spd3 = spdao.findAllByTypeAndNum(8, pm.getPlannum());//正常班3
    		
    		
    		if(wb!=-1)
    		{
    			ScpbPlan sp = spdao.findAllByTypeAndNum(wb, pm.getPlannum());//正常班3
    			ol.setOperate(pm.getName()+pm.getDate()+pm.getWb()+"->"+wb);
    			//ScpbPlan sp = spdao.findAllByNoAndNum(pm.getPlan(),pm.getPlannum());
    			if(sp!=null)
    			{
    				pm.setPbqdtime(sp.getSbtime());
    				pm.setPbqttime(sp.getXbtime());
    				pm.setZytime(sp.getZytime());
        			pm.setPxtime(sp.getPxtime());
    			}
    			pm.setWb(wb);
    		}
    		else
    		{
    			ol.setOperate(pm.getName()+pm.getDate()+"排班签到时间"+pm.getPbqdtime()+"->"+sbtime+"排班签退时间"+pm.getPbqttime()+"->"+xbtime);
    			pm.setPbqdtime(sbtime);
				pm.setPbqttime(xbtime);
				pm.setZytime(zytime);
    		}
    		ol.setTime(du.getDateTime());
    		ol.setName(opname);
    		ol.setItem("PBMX");
    		oldao.merge(ol);
    		pmdao.merge(pm);
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
