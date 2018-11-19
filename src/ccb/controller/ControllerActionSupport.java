package ccb.controller;
import java.util.List;

import ccb.util.IsNull;
import ccb.util.MessageException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author miracle
 * 
 * 2012-9-5
 * 
 * @param <E>
 * 		实体类别
 * 
 * @param <PK>
 * 		实体的ID类别
 */
public class ControllerActionSupport<E> extends ActionSupport implements ControllerAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1046751037184976151L;
	
	/**
	 * 操作的类型
	 */
	String type;
	
	/**
	 * 跳转控制参数
	 */
	private String forward;
	private static final Log log = LogFactory.getLog(ControllerActionSupport.class);
	/**
	 * 关键字的数据库表字段
	 */
	protected String keyWordtb;
	/**
	 * 关键字
	 */
	protected String keyWord;
	
	/**
	 *int型的关键字
	 **/
	protected int kwint;
	/**
	 * 传入的ID列表
	 */
	List<String> idList;
	/**
	 * 表名
	 */
	protected String timetb;
	/**
	* 起始时间
	*/
	protected String beginDate;
	/**
	* 结束时间
	*/
	protected String endDate;
/**
* 获得默认的分页大小
*/
protected int pageSize = 15;

/**
* 总页数
*/
protected int totalPages = -1;

/**
* 当前页
*/
protected int currentPage = -1;

/**
* 上一页
*/
private int previousPage = 1;

/**
* 下一页
*/
private int nextPage = 1;
/**
* 第一页
*/
private int firstPage = 1;
/**
* 最后一页
*/
private int lastPage = 1;
/**
* 总记录条数
*/
protected long totalRows = -1;

/**
* 列表数据
*/
protected List<E> list;

	
	public ControllerActionSupport(){
		super();
	}
	@Override
	public String execute()
			throws Exception {
		// TODO Auto-generated method stub
		/**
		 *强制转换，以获得操作的类型
		 */
		type = getType();
		timetb = getTimetb();
		beginDate = getBeginDate();
		endDate = getEndDate();
		keyWord = getKeyWord();
		keyWordtb = getKeyWordtb();
		kwint=getKwint();
		idList = getIdList();
		
		//System.out.println("started!");
		if (type == null) {
			throw new MessageException("对不起，操作类型不能为空！");
		}else if (ADD.equals(type)) {
			forward = add();
		}else if (DETAIL.equals(type)) {
			forward = detail();
		}else if (DEL.equals(type)) {
				forward = delete();
		}else if(DELBYTIME.equals(type)){
				forward = delete(timetb,beginDate,endDate);
		}else if (UPDATE.equals(type)) {
			forward = update();
		}else if(TO_UPDATE.equals(type)){
			forward =to_update();
		}else if(FIND_ALL.equals(type)){
			forward =findAll();
		}else if(FIND_ALL_DESC.equals(type)){
			if(beginDate==null&&endDate==null
					&&keyWord==null)
			{
				forward = findAllDesc();
			}
			else if(keyWord.isEmpty())
			{
				forward = findAllDesc(timetb,beginDate,endDate);
			}
			//else if(beginDate.isEmpty()&&endDate.isEmpty())
			else if(beginDate==null&&endDate==null)
			{
				forward = findAllDesc(keyWordtb,keyWord);
			}
			else
			{
				forward = findAllDesc(keyWordtb,keyWord,timetb,beginDate,endDate);
			}	
		}else if(FIND_ALL_BY.equals(type))
		{
			forward=findAllBy(keyWordtb,kwint,timetb,endDate);
		}
		else {
			throw new MessageException("对不起，不存在该操作类型！ type=" + type);
		}

		return forward;
	}
	
	/**
	 * 初始化页面属性<br>
	 * 必须在已获得totalRows值之后再调用该函数<br>
	 * 调用方式为：<br>
	 * 
	 * 给totalRows赋值<br>
	 * 调用initPageProperties(form)方法<br>
	 * 给list赋值<br>
	 * 调用initAttribute(request)方法<br>
	 * 
	 * 该方法在调用查询语句之前调用<br>
	 * pageSize为系统默认的分页的大小，如要更改pageSize，应在掉用setPageSize方法后再调用该方法<br>
	 * 
	 * 
	 */
	protected void initPageProperties() {

		if (totalRows == -1) {
			log.error("没有初始化totalRows参数！");
		}

		firstPage = 1;
		
		currentPage = currentPage <= 1 ? 1 : currentPage;

		totalPages = (totalRows % pageSize == 0) ? ((int) (totalRows / pageSize))
				: ((int) (totalRows / pageSize + 1));

		currentPage = currentPage >= totalPages ? totalPages : currentPage;

		previousPage = currentPage > 1 ? currentPage - 1 : 1;

		nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

		lastPage = totalPages;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getKeyWordtb() {
		return keyWordtb;
	}
	public void setKeyWordtb(String keyWordtb) {
		this.keyWordtb = keyWordtb;
	}
	
	public List<String> getIdList() {
		return idList;
	}
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getKwint() {
		return kwint;
	}
	public void setKwint(int kwint) {
		this.kwint = kwint;
	}
	public String getTimetb() {
		return timetb;
	}
	public void setTimetb(String timetb) {
		this.timetb = timetb;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public String add() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete(List<String> idList) throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete(String timetb,String beginDate,String endDate){
		// TODO Auto-generated method stub
		return null;
	}

	public String detail() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 *准备更新记录	 
	 */
	public String to_update() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 查找所有
	 */
	public String findAll() {
		return null;
	}
	/*
	 * 逆序查找所有
	 */
	public String findAllDesc() {
		return null;
	}
	/*
	 * 根据时间逆序查找所有
	 */
	public String findAllDesc(String timetb,String beginDate,String endDate) {
		return null;
	}
	/*
	 * 根据关键字段的关键字逆序查找所有
	 */
	public String findAllDesc(String keyWordtb,String keyWord){
		return null;
	}
	/*
	 * 根据时间和关键字段的关键字逆序查找所有
	 */
	public String findAllDesc(String keyWordtb,String keyWord,String timetb,String beginDate,String endDate) {
		return null;
	}
	/*
	 *根据关键字查询后按日期逆序排序 
	 */
	public String findAllBy(String keyWordtb,int kwint,String timetb,String endDate) {
		return null;
	}
	/*
	 * 更新记录
	 */
	public String update() throws MessageException {
		// TODO Auto-generated method stub
		return null;
	}
	protected boolean isNull(Object property){
		return IsNull.isNull(property);
	}
}
