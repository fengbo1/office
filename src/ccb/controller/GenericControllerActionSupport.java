package ccb.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ccb.service.GenericService;
import ccb.service.GenericServiceImpl;
import ccb.util.MessageException;


/**
 * 
 * @author miracle
 * 
 * 2012-9-5
 * 
 * 
 * @param <E>
 * 		实体类别
 * 
 * @param <PK>
 * 		实体的ID类别
 * 
 * @param type 类型
 * 
 * @param keyWord 关键字
 * 
 * @param keyWordtb 关键字的字段
 * 
 * @param idList 传入的ID列表
 * 
 * @param timetb 时间字段
 * 
 * @param beginDate 起始时间
 * 
 * @param endDate 终止时间
 */
public class GenericControllerActionSupport<E> extends ControllerActionSupport<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 247921254216870233L;
	
	private static Log log=LogFactory.getLog(GenericControllerActionSupport.class);
	
	public E entity;
	
	protected String id;
	
	protected String ids;
	
	protected List<String> idList = new ArrayList<String>();
	
	protected String[] idArray;
	
	protected GenericService<E> service;

	/**
	 * 根据实体类类对象构造Action<br>
	 * 该方法主要在继承该类的Action类中调用<br>
	 * 使用该构造函数将默认使用GenericServiceImpl的service方法<br>
	 * @param entityClass
	 * 			实体类类对象
	 */
	public GenericControllerActionSupport(Class<E> entityClass){
		this(entityClass.getName());
	}
	
	/**
	 * 根据实体类类对象和service对象构造Action<br>
	 * 该方法主要在继承该类的Action类中调用<br>
	 * 使用该构造方法将使用传入的service提供的方法<br>
	 * @param service
	 */
	public GenericControllerActionSupport(Class<E> entityClass,GenericService<E> service){
		this(entityClass.getName(),service);
		
		this.service=service;
	}
	/**
	 * 根据实体类的类名构造Action<br>
	 * 该方法主要在Spring中根据构造函数注入的时候使用<br>
	 * 使用该构造函数将默认使用GenericServiceImpl的service方法<br>
	 * @param entityClassName
	 */
	@SuppressWarnings("unchecked")
	public GenericControllerActionSupport(String entityClassName){
		try{
			/**
			 * 初始化实体对象
			 */
			entity=(E)Class.forName(entityClassName).newInstance();
			
		} catch (ClassNotFoundException e){
			log.error("不存在名为:"+entityClassName+"的类！", e);
		} catch (InstantiationException e) {
			log.error("实例化"+entityClassName+"对象出错！", e);
		} catch (IllegalAccessException e) {
			log.error(e);
		}
		service=new GenericServiceImpl<E>(entityClassName);
	}

	/**
	 * 根据实体类的类名构造Action<br>
	 * 该方法主要在Spring中根据构造函数注入的时候使用<br>
	 * 使用该构造方法将使用传入的service提供的方法<br>
	 * @param entityClassName
	 */
	@SuppressWarnings("unchecked")
	public GenericControllerActionSupport(String entityClassName,GenericService<E> service){
		try{
			/**
			 * 初始化实体对象
			 */
			entity=(E)Class.forName(entityClassName).newInstance();
			
		} catch (ClassNotFoundException e){
			log.error("不存在名为:"+entityClassName+"的类！", e);
		} catch (InstantiationException e) {
			log.error("实例化"+entityClassName+"对象出错！", e);
		} catch (IllegalAccessException e) {
			log.error(e);
		}
		this.service=service;
	}
	
	@Override
	public String add() throws MessageException {
		service.add(getEntity());
		return ADD_SUCCESS;
	}

	@Override
	public String delete() throws MessageException {
		if(getIds().length()==0)
			throw new MessageException("ID号不能为空！");
		idArray = getIds().split(",");
		for(int i=0;i<idArray.length;i++)
		{
			idList.add(idArray[i]);
		}
		service.delete(idList);
		return DELETE_SUCCESS;
	}

	@Override
	public String delete(List<String> idList) throws MessageException {
		service.delete(idList);
		return DELETE_SUCCESS;
	}
	
	
/*
 * (non-Javadoc)
 * 
 * @see ccb.controller.ControllerActionSupport#delete(java.lang.String, java.lang.String, java.lang.String)
 */
	@Override
	public String delete(String timetb, String beginDate, String endDate) {
		service.delete(timetb, beginDate, endDate);
		return DELETE_SUCCESS;
	}
	@Override
	public String detail() throws MessageException {
		if(isNull(getId()))
			throw new MessageException("ID号不能为空！");
		this.setEntity(service.detail(getId()));
		return DETAIL_SUCCESS;
	}

	@Override
	public String to_update() throws MessageException {
		if(isNull(getId()))
			throw new MessageException("ID号不能为空！");
		this.setEntity(service.detail(getId()));
		return TO_UPDATE_SUCCESS;
	}

	@Override
	public String update() throws MessageException {
		service.update(getEntity());
		return UPDATE_SUCCESS;
	}

	@Override
	public String findAll() {
		totalRows=service.sizeAll();
		initPageProperties();
		list=service.findAll(currentPage, pageSize);
		return FIND_ALL_SUCCESS;
	}
	public String findAllDesc() {
		totalRows=service.sizeAll();
		initPageProperties();
		list=service.findAllDesc("desc",currentPage, pageSize);
		return FIND_ALL_DESC_SUCCESS;
	}
	public String findAllDesc(String timetb,String beginDate,String endDate) {
		
		totalRows=service.sizeAll(timetb,beginDate,endDate);
		initPageProperties();
		list=service.findAllDesc("desc",currentPage, pageSize,timetb,beginDate,endDate);
		return FIND_ALL_DESC_SUCCESS;
	}
	public String findAllDesc(String keyWordtb,String keyWord){
		totalRows=service.sizeAll(keyWordtb,keyWord);
		initPageProperties();
		list=service.findAllDesc("desc",currentPage, pageSize,keyWordtb,keyWord);
		return FIND_ALL_DESC_SUCCESS;
	}
	public String findAllDesc(String keyWordtb,String keyWord,String timetb,String beginDate,String endDate) {
		totalRows=service.sizeAll(keyWordtb,keyWord,timetb,beginDate,endDate);
		initPageProperties();
		list=service.findAllDesc("desc",currentPage, pageSize,keyWordtb,keyWord,timetb,beginDate,endDate);
		return FIND_ALL_DESC_SUCCESS;
	}
	/*按日期字段排序*/
    public String findAllBy(String keyWordtb,int kwint,String timetb,String endDate)
    {
    	totalRows=service.sizeAll();
		initPageProperties();
		list=service.findAllBy( currentPage, pageSize,keyWordtb, kwint, timetb, endDate);
		return FIND_ALL_BY_SUCCESS;
    }
	public E getEntity() {
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public GenericService<E> getService() {
		return service;
	}

	public void setService(GenericService<E> service) {
		this.service = service;
	}
	
	
}
