package demo.shengfq.pool2;
import java.util.Random;  
import java.util.concurrent.BlockingQueue;  
import java.util.concurrent.TimeUnit;  
import java.util.concurrent.atomic.AtomicInteger;  
  
/** 
 * 消费线程 
 *  
 * @author SYZ 
 * @date 2016-12-8 下午02:07:24 
 * @version 1.0.0 
 * @see com.gbcom.java.blockqueue.Consumer 
 */  
public class Consumer implements Runnable {  
    private BlockingQueue<String> queue;  
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;  
    private static AtomicInteger count = new AtomicInteger();  
  
    public Consumer(BlockingQueue<String> queue) {  
        this.queue = queue;  
    }  
  
    public void run() {  
        System.out.println("启动消费者线程！");  
        Random r = new Random();  
        boolean isRunning = true;  
        try {  
            while (isRunning) {  
                System.out.println("正从队列获取数据...");  
                String data = queue.take();  
                if (null != data) {  
                    System.out.println("拿到数据：" + data + "  : queue size = "  
                            + queue.size());  
                    System.out.println(Thread.currentThread().getName()  
                            + " - 正在消费数据：" + data + "::::consumer times="  
                            + count.incrementAndGet());  
                    Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));  
                } else {  
                    isRunning = false;  
                }  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
            Thread.currentThread().interrupt();  
        } finally {  
            System.out.println("退出消费者线程！");  
        }  
    }  
  
}  