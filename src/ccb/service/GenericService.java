package ccb.service;

import java.util.List;
import java.util.Map;


public interface GenericService<E> {
	


	/**
	 * 添加实体对象的记录
	 * @param entity
	 */
	public String add(E entity);
	
	/**
	 * 根据ID批量删除记录
	 * @param ids
	 */
	public void delete(List<String> idList);


	/**
	 * 根据时间批量删除记录
	 * @param ids
	 */
	public void delete(String timetb,String beginDate,String endDate);
	
	/**
	 * 根据ID单个删除记录
	 * @param id
	 */
	public void delete(String id);
	
	
	/**
	 * 单个更新实体记录
	 * @param entity
	 */
	public void update(E entity);
	
	/**
	 * 批量更新
	 * @param equalMap
	 * 		进行更新记录的条件
	 * @param updateMap
	 * 		进行更新的信息
	 */
	public void batchUpdate(Map<String, ?> equalMap, Map<String, ?> updateMap);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public E detail(String id);
	
	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<E> findAll(int currentPage,int pageSize);
	/**
	 * 
	 * @param orderType
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<E> findAllDesc(String orderType,int currentPage,int pageSize);
	/**
	 * @param timetb
	 * @param orderType
	 * @param currentPage
	 * @param pageSize
	 * @param benginDate
	 * @param endDate
	 * @return
	 */
	public List<E> findAllDesc(String orderType,int currentPage,int pageSize,String timetb,String beginDate,String endDate);
	/**
	 * @param timetb
	 * @param orderType
	 * @param currentPage
	 * @param pageSize
	 * @param keyWordtb
	 * @param keyWord
	 * @param benginDate
	 * @param endDate
	 * @return
	 */
	public List<E> findAllDesc(String orderType,int currentPage,int pageSize,String timetb,String keyWordtb,String keyWord,String beginDate,String endDate);

	/**
	 * @param keyWordtb
	 * @param orderType
	 * @param currentPage
	 * @param pageSize
	 * @param keyWord
	 * @return
	 */
	public List<E> findAllBy(int currentPage,int pageSize,String keywordtb,int keyword,String timetb,String endDate);
	/**按需排序*/
	public List<E> findAllDesc(String orderType,int currentPage,int pageSize,String keyWordtb,String keyWord);
	/**
	 * @param timetb
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public long sizeAll(String timetb,String beginDate,String endDate);
	/**
	 * @param keyWordtb
	 * @param keyWord
	 * @return
	 */
	public long sizeAll(String keyWordtb,String keyWord);
	/**
	 * @param keyWordtb
	 * @param keyWord
	 * @param timetb
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public long sizeAll(String keyWordtb,String keyWord,String timetb,String beginDate,String endDate);
	/**
	 * @return
	 */
	public long sizeAll();
}
