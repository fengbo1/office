package ccb.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

/**
 * 
 * @author mir
 *
 * 2012-05-23
 *	
 * @param <E>
 * @param <PK>
 * 
 */
public interface GenericDao<E> {

	/**
	 * 获得hibernate session
	 * 
	 * @return
	 */
	Session getSession();
	
	/**
	 * 根据实体Id获得
	 * 
	 * @param id
	 * @return 
	 */
	E getById(String id);

	/**
	 * 保存对象
	 * 
	 * @param entity
	 */

	String save(E entity);
	/**
	 *	 
	 */
	public void delete(E entity);
	/**
	 * 根据ID删除相关信息
	 * 
	 * @param id
	 */
	void deleteById(String id);

	/**
	 * 根据多个ID删除相关信息
	 * 
	 * @param ids
	 */
	void deleteByIds(List<String> idList);
	/**
	 * 根据时间删除相关信息
	 * @param beginDate
	 * @param endDate
	 */
	void deleteByIds(String timetb,String beginDate,String endDate);

	/**
	 * 查询全部
	 * 
	 * @return List
	 */
	
	List<E> findAll();

	/**
	 * 获取全部记录
	 * 
	 * @return
	 */
	long countAll();
	/**
	 * 获取全部记录
	 * @param keyWordtb
	 * @param keyWord
	 * @return
	 */
	long countAll(String keyWordtb,String keyWord);
	/**
	 * 获取全部记录
	 * @param timetb
	 * @param beginDate
	 * @param endDate
	 * @author mir
	 * 
	 * @return
	 */
	long countAll(String timetb,String beginDate,String endDate);
	/**
	 * 获取全部记录
	 * @param keyWordtb
	 * @param keyWord
	 * @param timetb
	 * @param beginDate
	 * @param endDate
	 * @author mir
	 * 
	 * @return
	 */
	long countAll(String keyWordtb,String keyWord,String timetb,String beginDate,String endDate);
	/**
	 * 带分页的查询全部
	 * 
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	List<E> findAll(int firstResult, int maxResult);
	/**
	 * 带分页的逆序查询全部
	 * 
	 * @param orderType
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	List<E> findAllDesc(String orderType,int firstResult, int maxResult);
	/**
	 * 带分页和时间的逆序查询全部
	 * 
	 * @param orderType
	 * @param firstResult
	 * @param maxResult
	 * @param timetb
	 * @param beginDate
	 * @param beginDate
	 * @return
	 */
	List<E> findAllDesc(String orderType,int firstResult, int maxResult,String timetb,String beginDate,String endDate);
	/**
	 * 带分页和时间的逆序查询全部
	 * 
	 * @param orderType
	 * @param firstResult
	 * @param maxResult
	 * @param keyWordtb
	 * @param keyWord
	 * @param timetb
	 * @param beginDate
	 * @param beginDate
	 * @return
	 */
	List<E> findAllDesc(String orderType,int firstResult, int maxResult,String keyWordtb,String keyWord,String timetb,String beginDate,String endDate);

	/**
	 * 带关键字的逆序查询全部
	 * 
	 * @param orderType
	 * @param firstResult
	 * @param maxResult
	 * @param keyWordtb
	 * @param keyWord
	 * @return
	 */
	List<E> findAllBy(int firstResult, int maxResult,String keyWordtb,int kwint,String timetb,String endDate);
	/**按需排序*/
	
	List<E> findAllDesc(String orderType,int currentPage,int pageSize,String keyWordtb,String keyWord);
	/**
	 * 根据传入的equalMap属性获得满足条件的记录
	 * 
	 * @param equalMap
	 * @return
	 */
	public List<E> findEntity(Map<String, ?> equalMap);

	/**
	 * 根据传入的equalMap属性获得满足条件的记录长度
	 * 
	 * @param equalMap
	 * @return
	 */
	public int countEntity(Map<String, ?> equalMap);

	/**
	 * 带分页的根据传入的con属性获得满足条件的记录
	 * 
	 * @param equalMap
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<E> findEntity(Map<String, ?> equalMap, int firstResult,
			int maxResult);

	/**
	 * 
	 * @param equalMap
	 * @param inMap
	 *            动态生成in .... 的条件查询语句
	 * @return
	 */
	public int countEntity(Map<String, ?> equalMap, Map<String, Object[]> inMap);

	/**
	 * 
	 * @param equalMap
	 * @param inMap
	 *            动态生成in .... 的条件查询语句
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<E> findEntity(Map<String, ?> equalMap,
			Map<String, Object[]> inMap, int firstResult, int maxResult);

	/**
	 * 
	 * @param equalMap
	 * @param inMap
	 *            动态生成in .... 的条件查询语句
	 * @param orders
	 *            动态生成order by .....的排序条件
	 * @param orderType
	 *            排序的方式 该参数默认为asc 可能的取值为 asc 和 desc
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<E> findEntity(Map<String, ?> equalMap,
			Map<String, Object[]> inMap, String[] orders, String orderType,
			int firstResult, int maxResult);
	/**
	 * 更新实体对象对应的信息
	 * 
	 * @param id
	 */
	public E getForUpdate(String id);
	/**
	 * 更新实体对象对应的信息
	 * 
	 * @param entity
	 */
	void update(E entity);
	
	/**
	 * 批量更新
	 * @param equalMap
	 * 		进行更新记录的条件
	 * @param updateMap
	 * 		进行更新的信息
	 */
	public void batchUpdate(Map<String, ?> equalMap, Map<String, ?> updateMap);

}
