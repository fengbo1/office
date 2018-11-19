package ccb.util;

public class MessageException extends RuntimeException {

	/**
	 * 消息异常，该异常用于系统传递出错提示
	 */
	private static final long serialVersionUID = -8919952866942840993L;
	public MessageException(){
		super();
	}
	
	public MessageException(String message){
		super(message);
	}
}
