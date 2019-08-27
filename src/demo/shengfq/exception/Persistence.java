package demo.shengfq.exception;

public class Persistence {
	static ExceptionHandler handler=new LogExceptionHandler();
	public static void main(String[] args) {
		Persistence persistence=new Persistence();
		persistence.process();
		
	}
	public void process() {
		try{
		connection("");
		}catch(PersistenceException ex){
			handler.handle(Persistence.class.getSimpleName(),"", "",ex);
		}
		System.out.println("process finish");
		//opendb(true);
	}
	
	public void connection(String url) throws ConnectionException{
		if("".equals(url)){
			throw new ConnectionException("url is empty");
		}
		System.out.println("connection is finish");
	}
	
	public void opendb(boolean isConnected) throws OpenException{
		if(!isConnected){
			throw new OpenException("opendb faure  ");
		}
		System.out.println("opendb finish");
	}
	
	public void preperStatement(){
		
	}
	public void execute(){
		
	}
	public void close(){
		
	}
}
