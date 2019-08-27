package demo.shengfq.exception;

public class ConnectionException extends PersistenceException{
	private String msg;
	public ConnectionException(String message) {
		super(message);
		this.msg=message;
	}

}
