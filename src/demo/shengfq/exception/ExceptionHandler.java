package demo.shengfq.exception;

public interface ExceptionHandler {
	//void handle(Exception exception,String msg);
	public void handle(String errorContext, String errorCode,
            String errorText, Throwable t);
}
