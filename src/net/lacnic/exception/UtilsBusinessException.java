package net.lacnic.exception;

public class UtilsBusinessException extends Exception {
	private static final long serialVersionUID = -917344981082570556L;

	public UtilsBusinessException() {
	}

	public UtilsBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilsBusinessException(String message) {
		super(message);
	}

	public UtilsBusinessException(Throwable cause) {
		super(cause);
	}
}
