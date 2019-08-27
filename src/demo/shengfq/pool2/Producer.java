package demo.shengfq.pool2;
import java.util.Random;  
import java.util.concurrent.BlockingQueue;  
import java.util.concurrent.TimeUnit;  
import java.util.concurrent.atomic.AtomicInteger;  
  
/** 
 * 生产者线程。 
 *  
 * @author SYZ 
 * @date 2016-12-8 下午02:07:34 
 * @version 1.0.0 
 * @see com.gbcom.java.blockqueue.Producer 
 */  
public class Producer implements Runnable {  
  
    private volatile boolean isRunning = true;  
    private BlockingQueue queue;  
    private static AtomicInteger count = new AtomicInteger();  
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;  
  
    public Producer(BlockingQueue queue) {  
        this.queue = queue;  
    }  
  
    public void run() {  
        String data = null;  
        Random r = new Random();  
  
        System.out.println("启动生产者线程！");  
        try {  
            while (isRunning) {  
                System.out.println("正在生产数据...");  
                Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));  
  
                data = "data:" + count.incrementAndGet();  
                System.out.println("将数据：" + data + "放入队列...");  
                if (queue.size() >= 5) {  
                    System.out  
                            .println("/***************** clear**********************/");  
                    queue.clear();  
                }  
                queue.put(data);  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
            Thread.currentThread().interrupt();  
        } finally {  
            System.out.println("退出生产者线程！");  
        }  
    }  
  
    public void stop() {  
        isRunning = false;  
    }  
  
} 