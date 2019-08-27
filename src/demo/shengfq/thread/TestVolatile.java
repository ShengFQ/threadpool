package demo.shengfq.thread;
public class TestVolatile{
	public static void main(String[] args) {
		System.out.println("begin test");
		ThreadDemo td=new ThreadDemo("lily");
		new Thread(td).start();
		while(true){
			//synchronized (td) {
				if(td.isFlag()){
					System.out.printf("main thread will gone \n");
					break;
				}
			//}
		}
	}
}