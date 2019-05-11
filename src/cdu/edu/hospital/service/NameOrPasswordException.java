package cdu.edu.hospital.service;

public class NameOrPasswordException extends RuntimeException {
	
	private static final long serialVersionUID = -552021585986711533L;
	
	public static final int NAME = 1;
	public static final int PWD = 2;
	private int field;
	 

	public NameOrPasswordException() {
	}
	public NameOrPasswordException(
			int field, String message) {
		super(message);
		this.field = field;
	}
	public NameOrPasswordException(Throwable cause) {
		super(cause);
	}
	public NameOrPasswordException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/*public NameOrPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}*/
	
	public int getField() {
		return field;
	}
	
	
	
	
	
	
	
	

}
