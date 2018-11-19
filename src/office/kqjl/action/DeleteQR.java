package office.kqjl.action;

import office.kqjl.dao.KqjlDailyDAO;
import office.kqjl.pojo.KqjlDaily;
import office.log.dao.OperateLogDAO;
import office.log.pojo.OperateLog;
import office.util.DateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import ccb.hibernate.HibernateSessionFactory;

/**
 * 考勤记录删除确认
 * @author htzx
 *
 */
public class DeleteQR {

	private int id;
	/**
	 * 1异常2异议
	 */
	private int type;
	private String qddel;
	private String qtdel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getQddel() {
		return qddel;
	}
	public void setQddel(String qddel) {
		this.qddel = qddel;
	}
	public String getQtdel() {
		return qtdel;
	}

	public void setQtdel(String qtdel) {
		this.qtdel = qtdel;
	}
	public String execute() throws Exception
	{
		String op_newnumber = (String) ActionContext.getContext().getSession().get("newnumber");
		String op_username = (String) ActionContext.getContext().getSession().get("username");
		String message = "删除成功，";
		KqjlDailyDAO kddao = new KqjlDailyDAO();
		DateUtil du = new DateUtil();
		OperateLogDAO oldao = new OperateLogDAO();
		ProcessKqjlDaily pkd = new ProcessKqjlDaily();
		Session session = HibernateSessionFactory.getSession();
    	Transaction trans=session.beginTransaction();
    	try {
    		KqjlDaily kd = kddao.findAllByID(id);
    		OperateLog ol = new OperateLog();
    		message+="日期"+kd.getDate()+"，姓名"+kd.getName();
    		if(qddel.equals("1"))//签到
    		{
    			message+="，签到时间"+kd.getQdtime();
    			kd.setQdtime("");
    		}
    		if(qtdel.equals("1"))//签退
    		{
    			message+="，签退时间"+kd.getQdtime();
    			kd.setQttime("");
    		}
    		if(kd.getQj()==1||kd.getGg()==1)
			{
				if(kd.getHalfday()==1)
    			{
					if(kd.getQdtime().equals(""))
					{
						kd.setYc(0);
					}
    				if(kd.getQttime().equals(""))
    				{
    					kd.setQtqs(1);
    				}
    			}
    			else if(kd.getHalfday()==2)
    			{
					if(kd.getQttime().equals(""))
					{
						kd.setYc(0);
					}
    				if(kd.getQdtime().equals(""))
    				{
    					kd.setQdqs(1);
    				}
    			}
    			else if(kd.getHalfday()==0)
    			{
					if(kd.getQdtime().equals("")&&kd.getQttime().equals(""))
					{
						kd.setYc(0);
					}
    			}
    			else
    			{
    				
    			}
			}
    		if(type==1)
    		{
    			kd.setYc(0);
    		}
    		if(type==2)
    		{
    			kd.setYy(0);
    		}
    		kddao.merge(kd);
    		ol.setTime(du.getDateTime());
    		ol.setNewnumber(op_newnumber);
    		ol.setName(op_username);
    		ol.setItem("DELQR");
    		ol.setOperate(message);
    		oldao.merge(ol);
    	}catch (Exception e) {
			trans.rollback();//出错回滚
			e.printStackTrace();
		}finally{
			 trans.commit();
	         session.flush();
	         session.clear();
	         session.close();
		}
		pkd.processKqjlById(id);
		return "success";
	}
}
