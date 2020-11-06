package com.shengfq.exception;

public class PersistenceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(String message){
		super(message);
	}
	public PersistenceException(Class classcode ,String errorCode,String msg){
		this.classCode=classcode;
		this.errorCode=errorCode;
		this.msg=msg;
	}
	private String msg;
	private Class classCode;
	private String errorCode;
	
	
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		return  sb.append("[").append(classCode.getSimpleName()).append("][").append(errorCode).append("]").toString();
	}
}
