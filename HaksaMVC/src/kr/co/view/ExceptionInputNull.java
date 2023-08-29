package kr.co.view;

@SuppressWarnings("serial")
public class ExceptionInputNull extends Exception{
	String message = "아무것도 적지않으면 안됩니다";
	@Override
	public String getMessage() {
		return this.message;
	}

}
