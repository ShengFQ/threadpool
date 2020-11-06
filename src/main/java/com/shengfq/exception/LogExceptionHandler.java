package com.shengfq.exception;

public class LogExceptionHandler implements ExceptionHandler {
	
	@Override
	public void handle(String errorContext, String errorCode, String errorText,
			Throwable t) {
		System.out.println(errorContext+errorCode+errorText);
	}
	
}
