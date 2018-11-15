package ccb.controller;


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
public interface ControllerAction {

	/**
	 * 传入参数
	 */
	public final static String ADD = "add";

	public final static String DETAIL = "detail";

	public final static String DEL = "del";
	
	public final static String DELBYTIME = "delByTime";

	public final static String UPDATE = "update";

	public final static String TO_UPDATE = "to_update";
	
	public static final String FIND_ALL="find_all";
	
	public static final String FIND_ALL_DESC="find_all_desc";
	
	public static final String FIND_ALL_BY="find_all_by";
	
	public static final String FIND_ALL_WITHOUT_PAGING="find_all_without_paging";
	/**
	 * 执行结果返回参数
	 */
	public final static String ADD_SUCCESS = "add_success";

	public final static String DETAIL_SUCCESS = "detail_success";

	public final static String DELETE_SUCCESS = "delete_success";
	
	public final static String DELBYTIME_SUCCESS = "delByTime_success";

	public final static String UPDATE_SUCCESS = "update_success";

	public final static String TO_UPDATE_SUCCESS = "to_update_success";
	
	public static final String FIND_ALL_SUCCESS="find_all_success";
	
	public static final String FIND_ALL_DESC_SUCCESS="find_all_desc_success";

	public static final String FIND_ALL_BY_SUCCESS="find_all_by_success";
	
	public static final String FIND_ALL_WITHOUT_PAGING_SUCCESS="find_all_without_paging_success";
	/**
	 * 出错结果返回类型
	 */

	public final static String ADD_INPUT = "add_input";
	
	public final static String UPDATE_INPUT = "update_input";
}
