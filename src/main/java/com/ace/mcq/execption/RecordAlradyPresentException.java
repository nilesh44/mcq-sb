package com.ace.mcq.execption;

public class RecordAlradyPresentException  extends RuntimeException {

   
	public RecordAlradyPresentException() {
		super();
	}

	public RecordAlradyPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RecordAlradyPresentException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordAlradyPresentException(String message) {
		super(message);
	}

	public RecordAlradyPresentException(Throwable cause) {
		super(cause);
	}
    
}
