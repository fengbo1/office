package ccb.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.dao.GenericDao;
import ccb.dao.GenericDaoHibernateImpl;
import ccb.util.MessageException;
import ccb.pojo.BasicPojo;

public class GenericServiceImpl<E> implements GenericService<E> {

	private static final Log log = LogFactory.getLog(GenericServiceImpl.class);

	protected GenericDao<E> dao;

	protected Session session;
	
	

	/**
	 * 根据实体类类对象构造Service
	 * 
	 * @param entityClass
	 */
	public GenericServiceImpl(Class<E> entityClass) {
		dao = new GenericDaoHibernateImpl<E>(entityClass);
		session = dao.getSession();
	}

	/**
	 * 根据实体类名称构造Service
	 * 
	 * @param entityClass
	 */
	public GenericServiceImpl(String entityClassName) {
		dao = new GenericDaoHibernateImpl<E>(entityClassName);
		session = dao.getSession();
	}

	/**
	 * 根据Dao对象名称构造Service
	 * 
	 * @param entityClass
	 */
	public GenericServiceImpl(GenericDao<E> dao) {
		this.dao = dao;
		session = dao.getSession();
	}
	
	

	
	/**
	 * 添加实体对象
	 * 如果实体对象继承于BasicPojo则判断其ID是否已存在再添加，
	 * 否则直接添加
	 */
	public String add(E entity) {
		String id;
		session = dao.getSession();
		
		if(entity instanceof BasicPojo){
			BasicPojo basicPojo=(BasicPojo)entity;
			Transaction tran = session.beginTransaction();
			
			if(basicPojo.getId()!=null){
				E old=dao.getForUpdate(basicPojo.getId().toString());
				if(old!=null){
					tran.commit();
					throw new MessageException("已存在代号为："+basicPojo.getId()+"的对象！");
				}
			}
			id = dao.save(entity);
			tran.commit();
			session.flush();
			session.clear();
			return id;
		}
		Transaction tran = session.beginTransaction();
		id = dao.save(entity);
		tran.commit();
		session.flush();
		session.clear();
		return id;
	}

	public void delete(List<String> idList) {
		session = dao.getSession();
		Transaction tran = session.beginTransaction();
		try{
//			for (String id : ids) {
//				dao.deleteById(id);
//			}
//或者直接调用dao的函数
			dao.deleteByIds(idList);
			tran.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.clear();
		}
		
		
		
	}

	public void delete(String id) {
		session = dao.getSession();
		Transaction tran = session.beginTransaction();
		dao.deleteById(id);
		tran.commit();
		session.flush();
		session.clear();
	}
	



	public void delete(String timetb, String beginDate, String endDate) {
		session = dao.getSession();
		Transaction tran = session.beginTransaction();
		dao.deleteByIds(timetb,beginDate,endDate);
		tran.commit();
		session.flush();
		session.clear();
		
	}

	public E detail(String id) {
		E e;
		session = dao.getSession();
		Transaction tran = session.beginTransaction();
		e = dao.getById(id);
		tran.commit();
		session.flush();
		session.clear();
		return  e;
	}

	public List<E> findAll(int currentPage, int pageSize) {
		return dao.findAll(pageSize * (currentPage - 1), pageSize);
	}
	public List<E> findAllDesc(String orderType,int currentPage, int pageSize) {
		session = dao.getSession();
		Transaction tran = session.beginTransaction();
		List<E> e = dao.findAllDesc(orderType,pageSize * (currentPage - 1), pageSize);
		tran.commit();
		session.flush();
		session.clear();
		return e;
	}
	public List<E> findAllDesc(String orderType,int currentPage, int pageSize,String timetb,String beginDate,String endDate) {
		session = dao.getSession();
		Transaction tran = session.beginTransaction();
		List<E> e = dao.findAllDesc(orderType,pageSize * (currentPage - 1), pageSize,timetb,beginDate,endDate);
		tran.commit();
		session.flush();
		session.clear();
		return e;
	}
	public List<E> findAllBy(int currentPage,int pageSize,String keywordtb,int keyword,String timetb,String endDate) {
		return dao.findAllBy(pageSize * (currentPage - 1), pageSize, keywordtb, keyword, timetb, endDate);
	}
	public List<E> findAllDesc(String orderType,int currentPage,int pageSize,String keyWordtb,String keyWord)
	{
		return dao.findAllDesc(orderType,pageSize * (currentPage - 1), pageSize,keyWordtb,keyWord);
	}
	public List<E> findAllDesc(String orderType,int currentPage, int pageSize,String timetb,String keyWordtb,String keyWord,String beginDate,String endDate) {
		return dao.findAllDesc(orderType,pageSize * (currentPage - 1), pageSize,timetb,keyWordtb,keyWord,beginDate,endDate);
	}
	public long sizeAll() {

		return dao.countAll();
	}
	public long sizeAll(String keyWordtb,String keyWord) {

		return dao.countAll(keyWordtb,keyWord);
	}
	public long sizeAll(String timetb,String beginDate,String endDate) {

		return dao.countAll(timetb,beginDate,endDate);
	}
	public long sizeAll(String keyWordtb,String keyWord,String timetb,String beginDate,String endDate) {

		return dao.countAll(keyWordtb,keyWord,timetb,beginDate,endDate);
	}
	public void update(E entity) {
		session = dao.getSession();
		Transaction tran = session.beginTransaction();
		dao.update(entity);
		tran.commit();
		session.flush();
		session.clear();
	}

	public void batchUpdate(Map<String, ?> equalMap, Map<String, ?> updateMap) {
		session = dao.getSession();
		Transaction tran = session.beginTransaction();
		dao.batchUpdate(equalMap, updateMap);
		tran.commit();
		session.flush();
		session.clear();
	}

}
