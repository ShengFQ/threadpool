package demo.shengfq.callback;
public class Local implements CallBack{
	public String message;
	public Local() {
	}
	public Local(String message){
		this.message = message;
	}
	/**
	 * 执行异步调用
	 * */
	public void sendMessage(){
		System.out.println("start..");
		Thread thread = new Thread(new WorkThread(new Remote(),this));
		thread.start();
	}
	
	public static void main(String[] args) {
		Local local = new Local("hello World");
		local.sendMessage();
		System.out.println("main thread exec complete...");
		//主线程虽然执行完成,但是不会结束,在线程栈里,他启动的子线程没有结束,主线程不会结束
		//console output:
		//start..
		//main thread exec complete...
		// current thread:Thread-0
		//remote excute msg:hello World
		//receive from workthread data:hello World change...
		// current thread:Thread-0
		//callback done!
		//由此可见回调函数是运行在工作线程里的. android里的回调函数里不能更新UI,就是因为这个原因,
		//工作线程没有UI线程的对象句柄
	}
	@Override
	public void execute(Object... objects) {
		System.out.println("receive from workthread data:"+objects[0]);
		System.out.println(" current thread:"+Thread.currentThread().getName());
		System.out.println("callback done!");
		}
	
	class WorkThread implements Runnable{
		Remote mremote;
		CallBack callback;
		/**
		 * @param remote 远程对象
		 * @param call 回调接口
		 * */
		public WorkThread(Remote remote,CallBack call){
			this.mremote=remote;
			this.callback=call;
		}
	@Override
	public void run() {
		System.out.println(" current thread:"+Thread.currentThread().getName());
		mremote.executeMessage(message,callback);
	}
	}
}
