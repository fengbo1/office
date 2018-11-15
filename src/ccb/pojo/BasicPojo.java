package ccb.pojo;

/**
 * 所有实体类都应该实现该接口
 * @author Administrator
 *
 * @param <PK>
 */
public interface BasicPojo<PK> {
	/**
	 * 获得对象ID
	 * @return
	 */
	PK getId();
}
