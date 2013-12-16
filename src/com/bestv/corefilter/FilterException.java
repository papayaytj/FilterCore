package com.bestv.corefilter;

public class FilterException extends Exception {

	private static final long serialVersionUID = -7393689432308521593L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public FilterException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public FilterException() {
		super();
	}

	public FilterException(String message, Throwable cause) {
		super(message, cause);
	}

	public FilterException(Throwable cause) {
		super(cause);
	}

}
