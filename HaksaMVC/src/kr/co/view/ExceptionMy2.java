package kr.co.view;

@SuppressWarnings("serial")
public class ExceptionMy2 extends Exception{
	String message;
	public ExceptionMy2(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
