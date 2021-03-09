package com.iq.exceptions;

@SuppressWarnings("serial")
public class InvalidPropertyUsageException extends FrameworkException {

	public InvalidPropertyUsageException(String message) {
		super(message);
	}
	
	public InvalidPropertyUsageException(String message, Throwable cause) {
		super(message, cause);
	}

}
