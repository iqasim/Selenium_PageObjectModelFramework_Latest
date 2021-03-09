package com.iq.exceptions;

@SuppressWarnings("serial")
public class InvalidInputOutputException extends FrameworkException {

	public InvalidInputOutputException(String message) {
		super(message);
	}
	
	public InvalidInputOutputException(String message, Throwable cause) {
		super(message, cause);
	}

}
 