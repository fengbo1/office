package ccb.util;

public class IsNull {

	/**
	 * 判断是否为空
	 * @param property
	 * @return
	 */
	public static boolean isNull(Object property){
		if(property==null){
			return true;
		}else if(property.toString().trim().equals("")){
			return true;
		}
		return false;
	}
}
