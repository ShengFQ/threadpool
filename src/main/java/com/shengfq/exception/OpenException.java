package com.shengfq.exception;

public class OpenException extends PersistenceException {
	private String msg;
	public OpenException(String message) {
		super(message);
		this.msg=message;
	}

}
