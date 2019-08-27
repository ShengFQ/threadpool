package demo.shengfq.wujun;
import java.io.File;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
/**
 * 读取所用时间：685
 * 文件数:3510  
 * */
public class Test_15 {
	
	
	static ArrayList<String> urlList = new ArrayList<String>();
	public static final int THREAD_POOL_SIZE = 20;          
	private final File POISON = new File("");
	private final BlockingQueue<File> files = new LinkedBlockingQueue<File>(40000);
	//private final ConcurrentLinkedQueue<String> infos = new ConcurrentLinkedQueue<String>();
	private Thread[] pool = null;
	private volatile boolean running = false;
	
	public Test_15() {
		this(THREAD_POOL_SIZE);
	}
	
	public Test_15(int poolSize) {
		pool = new Thread[poolSize];
		FileWorker worker = new FileWorker();
		for(int i=0;i<pool.length;i++){
			pool[i] = new Thread(worker,"线程"+(i+1));
			pool[i].start();
		}
		running = true;
	}
	
	private class FileWorker implements Runnable {
		public void run() {
			File file = null;
			try {
				while((file=files.take()) != POISON){
					try {
						doWork(file);
//						ReadDisk.listAll(new File("E:\\Jobs\\box\\InDataPool"), 0);
					} catch (Exception e) {
						onException(e,file);
					}
				}
				files.put(POISON);
			} catch (InterruptedException e) {
			}
		}

		private void onException(Exception e, File file) {
			e.printStackTrace();
		}
		
		private void doWork(File file) {

            try {

                System.out.println("当前使用的线程是："
                        + Thread.currentThread().getName() + ",正在读文件:"
                        + file.getPath() + ",列表当前长度:"
                        + files.size());
                urlList.add(file.getName());

            } catch (Exception e) {
                e.printStackTrace();
            }
		}
	}
	
	public void addFile(File file) throws InterruptedException{
		files.put(file);
	}
	
    public void addFilesIgnoreInterrupted(File dir, int level) {
        File files[]=dir.listFiles();
        if(null==files){
            return;
        }
        for(File file:files){
            if(file.isDirectory()){
            	addFilesIgnoreInterrupted(file, ++level);
            }else{
//                logger.info("读取的路径："+file.getAbsolutePath());
                try {
                    this.files.put(file);
                } catch (InterruptedException e) {
                
                }
            }
        }
    }
	
	public void shutdown(){
		try {
			if(running){
				running = false;
				files.put(POISON);
			}
		} catch (InterruptedException e) {
		}
	}
	
	public void waiting(){
		if(running || !files.contains(POISON)){
			throw new IllegalStateException("You must call shutdown() function before.");
		}
		for(Thread t : pool){
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}
	}
	
	/*public Queue<String> getInfos(){
		return infos;
	}*/
	
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		Test_15 instance = new Test_15();
		String strurl = "/Users/sheng/schedule/target&plan&schedule&task/1万科移动需求开发计划[关闭]";
		File folder = new File(strurl);
		instance.addFilesIgnoreInterrupted(folder,0);
		instance.shutdown();
		instance.waiting();
		System.out.println("读取所用时间："+(System.currentTimeMillis() - a));
		System.out.println(urlList.size()+"  ");

	}

}
